B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8.8
@EndOfDesignText@

'  Returns the ID of the item selected, or "" if menu was canceled (when .Cancelable = True)
#Event:  Click(ButtonID As String)

Sub Class_Globals
	Public Const MENU_LEFT As Int = 0
	Public Const MENU_RIGHT As Int = 1
	Public Const MENU_TOP As Int = 2
	Public Const MENU_BOTTOM As Int = 3
	
	
	Private moXUI As XUI
	Private moCaller As Object
	Private msBaseEvent As String 
	Private moContainer As Panel
	
	Type FanMenuItem(ID As String, Icon As Bitmap, IconFillPercent As Float, Text As String, BackColor As Int, TextSize As Float, TextColor As Int, SelectedColor As Int)
	
	' Internal use for the FanMenu class, not for public use
	Type FanMenuBlade(ClipPath As B4XPath, AngleStart As Double, AngleEnd As Double, BoundingRect As B4XRect, MidPoint As FanPointf, ItemInfo As FanMenuItem)	
	
	' Internal use for the FanMenu class, not for public use
	Type FanCenterITem(CenterX As Int, CenterY As Int, Radius As Int, BoundingRect As B4XRect, ClipPath As B4XPath, ItemInfo As FanMenuItem)
	
	' Internal use only
	Type FanPointf(X As Double, Y As Double)
	
	
	Private moBackPanel As Panel
	Private moBackCan As B4XCanvas
	Private moMenuBmp As B4XBitmap
	
	Private miFanAnimTime As Int = 1000
	Private miSlideAnimTime As Int = 1000
	Private miMenuPos As Int = MENU_RIGHT
	Private miElevation As Int = 50dip		' should be high enough to be on top of any other views inside container
	Private mbAutoClose As Boolean = True 
	Private mbCancelable As Boolean = True 
	Private miDefItemBackColor As Int = Colors.White
	Private miDefItemTextColor As Int = Colors.Black
	Private mfDefItemIconFillPercent As Float = 0.75
	Private mfDefItemTextSize As Float = 18.00
	Private miDefItemSelColor As Int = Colors.Blue
	Private miMenuLineColor As Int = Colors.Black
	Private miMenuLineWidth As Int = 2dip 

	Private moFanFont As Typeface = Typeface.DEFAULT
	Private moCenterItem As FanCenterITem
	Private mbRotating As Boolean = False 	' recursive animation call prevent
	Private moItems As List 		' list of fanmenublade
	
	Private moFinalRect As Rect  'final posistion of the completed menu as drawn on the container
End Sub

' Container should be full size of activity and elevated above all other views.
Public Sub Initialize(Caller As Object, BaseEvent As String, Container As Panel)
	moCaller = Caller
	If BaseEvent = "" Then 
		msBaseEvent = ""
	Else
		msBaseEvent = BaseEvent & "_"
	End If
	moContainer = Container
	
	'  Create a panel to fill supplied container which will capture our events and hold the menu image.
	moBackPanel.Initialize("panBack")
	Container.AddView(moBackPanel, 0, 0, Container.Width, Container.Height)
	moBackPanel.BringToFront
	moBackPanel.Elevation = miElevation
	moBackPanel.Visible = False 
	
	moItems.Initialize
End Sub

'  Returns a new FanMenuItem with the defined default values specified.
Public Sub NewMenuItem As FanMenuItem
	Dim poItem As FanMenuItem
	poItem.Initialize
	poItem.BackColor = miDefItemBackColor
	poItem.SelectedColor = miDefItemSelColor
	poItem.ID = ""
	poItem.IconFillPercent = mfDefItemIconFillPercent	'% of wedge area to be occupied by the icon
	poItem.Text = ""
	poItem.TextSize = mfDefItemTextSize
	poItem.TextColor = miDefItemTextColor
	Return poItem 
End Sub


'  MenuPos should be a MENU_ constant value and MenuList is a list of FanMenuItem
Public Sub CreateMenu(MenuPos As Int, CenterItem As FanMenuItem, MenuList As List)
	Dim poMenu As B4XView
	Dim poMenuCan As B4XCanvas
	Dim piCenterX As Int
	Dim piCenterY As Int
	Dim piStartAngle As Float = -85		'east is 0 degrees on android
	Dim piSweepAngle As Float = 170
	Dim piIndex As Int
	Dim pfSweep As Float
	Dim pfCurrAngle As Float
	Dim piSquare As Int
	Dim pdOuterRadius As Double 
	Dim piMaxSize As Int 
	Dim poTargetRect As B4XRect
	
	miMenuPos = MenuPos

	moItems.Clear

	moCenterItem.Initialize
	moCenterItem.ItemInfo = CenterItem
	
	For Each poItem As FanMenuItem In MenuList
		Dim poBlade As FanMenuBlade
		poBlade.Initialize
		poBlade.ItemInfo.Initialize
		poBlade.ItemInfo = poItem 
		moItems.Add(poBlade)
	Next
	If moItems.Size < 1 Then 
		Return
	End If


	pfSweep = piSweepAngle / moItems.Size
	Select Case MenuPos
		Case MENU_RIGHT
			piStartAngle = -265 ' and draw to -90
			
		Case MENU_TOP
			piStartAngle = 5	' and draw to +180

		Case MENU_BOTTOM
			piStartAngle = -175	' and draw to zero

		Case Else
			piStartAngle = -85  ' MENU_LEFT  (and draw to +90)
	End Select
	piSweepAngle = 170  '180 degress less 5 start and 5 end

	poMenu = moXUI.CreatePanel("")
	piSquare = Min(moBackPanel.Width, moBackPanel.Height)
	poMenu.SetLayoutAnimated(0, 0, 0, piSquare, piSquare)
	poTargetRect.Initialize(0, 0, piSquare, piSquare)
	poMenuCan.Initialize(poMenu)
	
	piCenterY = poTargetRect.Height / 2
	piCenterX = poTargetRect.Width / 2
	poMenuCan.ClearRect(poTargetRect)
	poMenuCan.DrawRect(poTargetRect, Colors.Transparent , True, 1dip)

	' center menu button values
	moCenterItem.CenterX = piCenterX
	moCenterItem.CenterY = piCenterY
	moCenterItem.Radius = poTargetRect.Height / 4
	pdOuterRadius = poTargetRect.Height / 2
	' figure center area bounding rect (largest square that fits entirely within the circle) 
	Dim piSideLen As Int = 1.414213562 * moCenterItem.Radius  'sqrt(2) * radius
	Dim piRectLeft As Int = piCenterX - (piSideLen / 2)
	Dim piRectTop As Int = piCenterY - (piSideLen / 2)
	moCenterItem.BoundingRect.Initialize(piRectLeft, piRectTop, piRectLeft + piSideLen, piRectTop + piSideLen)
	' full circle rectangle, initialize oval at this location for clipping path
	Dim poRect As B4XRect
	poRect.Initialize(moCenterItem.CenterX - moCenterItem.Radius, moCenterItem.CenterY - moCenterItem.Radius, moCenterItem.CenterX + moCenterItem.Radius, moCenterItem.CenterY + moCenterItem.Radius)
	moCenterItem.ClipPath.InitializeOval(poRect)
	
	' Draw radial menu fan blades
	pfCurrAngle = piStartAngle
	piMaxSize = pdOuterRadius
	For piIndex = 0 To moItems.Size - 1
		Dim poBlade As FanMenuBlade = moItems.Get(piIndex)
		Dim poPath As B4XPath
		poPath.InitializeArc(piCenterX, piCenterY, pdOuterRadius, pfCurrAngle, pfSweep)
		poBlade.AngleStart = pfCurrAngle
		poBlade.AngleEnd = pfCurrAngle + pfSweep 
		' add in ending path line back to center point and save the path
		poPath.LineTo(piCenterX, piCenterY)
		poBlade.ClipPath = poPath
		' find bounding rect and mid point of segment
		poBlade.BoundingRect = FindBoundingRect(poBlade.AngleStart, poBlade.AngleEnd, moCenterItem.Radius, pdOuterRadius)
		poBlade.MidPoint = FindBladeMidpoint(poBlade.AngleStart, poBlade.AngleEnd, moCenterItem.Radius, pdOuterRadius)
		moItems.Set(piIndex, poBlade)
		' draw the acutal "blade" of the menu
		poMenuCan.DrawPath(poPath, poBlade.ItemInfo.BackColor, True, 1dip)
		poMenuCan.DrawPath(poPath, miMenuLineColor, False, miMenuLineWidth)
		' find smallest wedge square size 
		piMaxSize = Min(piMaxSize, Min(poBlade.BoundingRect.Height, poBlade.BoundingRect.Width))
		' next blade segment
		pfCurrAngle = pfCurrAngle + pfSweep
	Next
	
	' draw each fan blade icon/text
	For piIndex = 0 To moItems.Size - 1
		Dim poBlade As FanMenuBlade = moItems.Get(piIndex)
		' set clipping region to be sure any image/text drawn is full contained within the fan blade.
		poMenuCan.ClipPath(poBlade.ClipPath)
		' draw the icon if we have one
		If poBlade.ItemInfo.Icon <> Null Then
			If poBlade.ItemInfo.Icon.IsInitialized Then
				Dim poIconRect As B4XRect
				Dim piIconSize As Int = piMaxSize * poBlade.ItemInfo.IconFillPercent
				Dim piRectLeft As Int = poBlade.MidPoint.X - (piIconSize / 2)
				Dim piRectTop As Int = poBlade.MidPoint.Y - (piIconSize / 2)
				poIconRect.Initialize(piRectLeft, piRectTop, piRectLeft + piIconSize, piRectTop + piIconSize)
				poMenuCan.DrawBitmap(poBlade.ItemInfo.Icon, poIconRect)
			End If
		End If
		' draw item text if we have any
		If poBlade.ItemInfo.Text.trim <> "" Then 
			DrawBladeText(poMenuCan, pdOuterRadius, poBlade)
		End If
		' clear clipping region
		poMenuCan.RemoveClip
	Next
		
	' ============= DRAW CENTER BUTTON
	'
	' draw the center circle
	poMenuCan.DrawCircle(piCenterX, piCenterY,  moCenterItem.Radius, moCenterItem.ItemInfo.BackColor, True, 1dip)
	' Add clipping path to center rectangle of the circle
	poMenuCan.ClipPath(moCenterItem.ClipPath)

	' draw center icon offset by icon size based on menu location
	Dim piTextTop As Int = 0 
	If moCenterItem.ItemInfo.Icon <> Null Then
		If moCenterItem.ItemInfo.Icon.IsInitialized Then
			Dim poIconRect As B4XRect
			Dim piIconSize As Int = moCenterItem.Radius * moCenterItem.ItemInfo.IconFillPercent
			Select Case miMenuPos
				Case MENU_RIGHT
					piRectLeft = piCenterX - piIconSize
					piRectTop = piCenterY - (piIconSize / 2)
					piTextTop = piRectTop + piIconSize + 2dip
			
				Case MENU_TOP
					piRectLeft = piCenterX - (piIconSize / 2)
					piRectTop = piCenterY
					piTextTop = piRectTop + piIconSize + 2dip

				Case MENU_BOTTOM
					piRectLeft = piCenterX - (piIconSize / 2)
					piRectTop = piCenterY - piIconSize
					piTextTop = piRectTop 

				Case Else
					piRectLeft = piCenterX
					piRectTop = piCenterY - (piIconSize / 2)
					piTextTop = piRectTop + piIconSize + 2dip
			End Select
			poIconRect.Initialize(piRectLeft, piRectTop, piRectLeft + piIconSize, piRectTop + piIconSize)
			poMenuCan.DrawBitmap(moCenterItem.ItemInfo.Icon, poIconRect)
		End If
	End If

	' draw button center text next to center icon 
	If moCenterItem.ItemInfo.Text.Trim.Length > 0 Then 
		Dim poTextRect As B4XRect
		Dim piTextX As Int 
		Dim piTextY As Int 
		Dim poTextFnt As B4XFont
		Select Case miMenuPos
			Case MENU_RIGHT, MENU_LEFT
				poTextRect.Initialize(moCenterItem.CenterX, moCenterItem.CenterY, moCenterItem.CenterX + moCenterItem.BoundingRect.Width / 2, moCenterItem.CenterY + moCenterItem.BoundingRect.Height)
			
			Case Else
				poTextRect.Initialize(moCenterItem.CenterX, moCenterItem.CenterY, moCenterItem.CenterX + moCenterItem.BoundingRect.Width, moCenterItem.CenterY + moCenterItem.BoundingRect.Height / 2)
		End Select
		poTextFnt = moXUI.CreateFont(moFanFont, moCenterItem.ItemInfo.TextSize)
		poTextRect = poMenuCan.MeasureText(moCenterItem.ItemInfo.Text.Trim, poTextFnt)
		Select Case miMenuPos
			Case MENU_RIGHT
				piTextX = moCenterItem.CenterX - poTextRect.Width - 2dip
				piTextY = piTextTop + poTextRect.Height 
			
			Case MENU_TOP
				piTextX = moCenterItem.CenterX - (poTextRect.Width / 2)
				piTextY = piTextTop + poTextRect.Height 

			Case MENU_BOTTOM
				piTextX = moCenterItem.CenterX - (poTextRect.Width / 2)
				piTextY = piTextTop 

			Case Else
				piTextX = moCenterItem.CenterX + 2dip
				piTextY = piTextTop + poTextRect.Height 
		End Select
		poMenuCan.DrawText(moCenterItem.ItemInfo.Text.Trim, piTextX, piTextY, poTextFnt, moCenterItem.ItemInfo.TextColor, "LEFT")
	End If
	
	' clear center button clip path
	poMenuCan.RemoveClip
	' draw center circle outer border line last to be sure it's on top of everything else we drew
	poMenuCan.DrawCircle(piCenterY, piCenterY, moCenterItem.Radius, miMenuLineColor, False, miMenuLineWidth)

	' save off the completed bitmap so we can use it later.
	moMenuBmp = poMenuCan.CreateBitmap
	' clean up
	poMenuCan.Release

	' create canvas for background panel and clear it
	moBackCan.Initialize(moBackPanel)
	moBackCan.ClearRect(moBackCan.TargetRect)
	moBackCan.DrawRect(moBackCan.TargetRect, Colors.Transparent, True, 1dip)
	' make sure menu panel is hidden	
	moBackPanel.Visible = False 
End Sub

'  Opens the fan menu
Public Sub ShowFan
	RotateMenu(True)
End Sub

' Closes the fan menu
Public Sub HideFan
	RotateMenu(False)
End Sub

' True if menu is currently visible
Public Sub MenuIsVisible As Boolean 
	Return moBackPanel.Visible 
End Sub


#Region "  PRIVATE METHODS  "
Private Sub panBack_Touch (Action As Int, X As Float, Y As Float) As Boolean 
	' ignore clicks if we're in the middle of animating the menu
	If Not(mbRotating) Then 
		If moFinalRect.Width > 0 And moFinalRect.Height > 0 Then
			Select Case Action
				Case moBackPanel.ACTION_MOVE
					' do nothing 
				Case moBackPanel.ACTION_DOWN
					' do nothing 
				Case moBackPanel.ACTION_UP
					If X >= moFinalRect.Left And X <= moFinalRect.Right And Y >= moFinalRect.Top And Y <= moFinalRect.Bottom Then
						' offset touch distance based on drawn position (translate to 0,0 upper left)
						Dim piX As Int = X - moFinalRect.Left 
						Dim piY As Int = Y - moFinalRect.Top 
						Dim pdDistance As Double 
						pdDistance = Sqrt(Power((moCenterItem.CenterX - piX), 2) + Power((moCenterItem.CenterY - piY), 2))
						If pdDistance <= moCenterItem.Radius Then 
							CallSubDelayed3(Me, "RaiseClick", moCenterItem.ItemInfo.ID, mbAutoClose)
						Else
							Dim pfAngle As Double
							pfAngle = RadianToDegree(ATan2(piY - moCenterItem.CenterY, piX - moCenterItem.CenterX)) 
							'LogColor("CLICK ANGLE = " & NumberFormat2(pfAngle, 1, 4, 4, False), Colors.Magenta)
							Select Case miMenuPos
								Case MENU_RIGHT
									If pfAngle >= 90 Then
										pfAngle = pfAngle - 360
										LogColor("CLICK ANGLE ADJUSTED TO " & NumberFormat2(pfAngle, 1, 4, 4, False), Colors.Magenta)
									End If
							End Select
							For Each poFan As FanMenuBlade In moItems
								'LogColor("Slice #" & poFan.ItemInfo.ID & " (" & NumberFormat2(poFan.AngleStart, 1, 4, 4, False) & _
								' 			" to " & NumberFormat2(poFan.AngleEnd, 1, 4, 4, False) & ")", Colors.ARGB(255, 88, 180, 88))
								If pfAngle >= poFan.AngleStart  And pfAngle < poFan.AngleEnd Then
									CallSubDelayed3(Me, "RaiseClick", poFan.ItemInfo.ID, mbAutoClose)
									Exit
								End If
							Next
						End If
					Else
						If mbCancelable Then
							CallSubDelayed3(Me, "RaiseClick", "", True)
						End If
					End If
			End Select
		Else
			If mbCancelable Then
				CallSubDelayed3(Me, "RaiseClick", "", True)
			End If
		End If
	End If 	
	Return True
End Sub

Private Sub RaiseClick(ID As String, CloseMenu As Boolean)
	' notify caller
	If moCaller <> Null And msBaseEvent <> "" Then 
		If SubExists(moCaller, msBaseEvent & "Click") Then 
			CallSubDelayed2(moCaller, msBaseEvent & "Click", ID)
		End If
	End If
	' make clicky noise
	Try
		' not that this cannot be in the panel's _Click event handler or the sound gets distorted up when you .RunMethod
		' it needs to be outside of the _Click event and should be called delayed from the click event for "normal" sound
		Dim poRf As Reflector
		poRf.Target = moContainer
		poRf.RunMethod2("playSoundEffect", 0, "java.lang.int")
	Catch
		Log(LastException)
	End Try
	' hide menu if requested
	If CloseMenu Then
		HideFan
	End If
End Sub


Private Sub DrawBladeText(oCan As B4XCanvas, OuterRadius As Double, oBlade As FanMenuBlade)
	Dim pdMidAngle As Double
	Dim piMidX As Double
	Dim piMidY As Double
	Dim pdAngle As Double 
	Dim poFont As B4XFont
	Dim poSize As B4XRect
	Dim pdTextMargin As Double = 3dip
	Dim pdTextAngle As Double
	
	If oBlade.ItemInfo.Text.Trim.Length = 0 Then 
		Return
	End If
	' setup our font and measure the text we need to print
	poFont = moXUI.CreateFont(moFanFont, oBlade.ItemInfo.TextSize)
	poSize = oCan.MeasureText(oBlade.ItemInfo.Text, poFont)
	' caluclate mid point of outer arc 
	pdAngle = (oBlade.AngleEnd + oBlade.AngleStart) / 2
	' convert our angle degrees to radians
	pdMidAngle = DegreeToRadian(pdAngle)
	' adjust text position based on which menu position we're using then draw it
	Select Case miMenuPos
		Case MENU_TOP
			pdTextAngle = pdAngle - 90
			piMidX = moCenterItem.CenterX + (OuterRadius - (poSize.Height / 2)) * Cos(pdMidAngle)
			piMidY = moCenterItem.CenterY + (OuterRadius - miMenuLineWidth - pdTextMargin) * Sin(pdMidAngle)

		Case MENU_BOTTOM
			pdTextAngle = pdAngle + 90
			piMidX = moCenterItem.CenterX + (OuterRadius - (poSize.Width / 2)) * Cos(pdMidAngle)
			piMidY = moCenterItem.CenterY + (OuterRadius - pdTextMargin - poSize.Height - miMenuLineWidth) * Sin(pdMidAngle)

		Case Else
			pdTextAngle = pdAngle + 90
			piMidX = moCenterItem.CenterX + (OuterRadius - (poSize.Width / 2)) * Cos(pdMidAngle)
			piMidY = moCenterItem.CenterY + (OuterRadius - pdTextMargin - poSize.Height) * Sin(pdMidAngle)
	End Select
	oCan.DrawTextRotated(oBlade.ItemInfo.Text, piMidX, piMidY, poFont, oBlade.ItemInfo.TextColor, "CENTER", pdTextAngle)
End Sub

Private Sub FindBladeMidpoint(AngleStart As Double, AngleEnd As Double, InnerRadius As Double, OuterRadius As Double) As FanPointf
	Dim pdCurr As Double
	Dim poLower As FanPointf
	Dim poUpper As FanPointf
	Dim poMid As FanPointf
	
	pdCurr = DegreeToRadian(AngleStart + (AngleEnd - AngleStart) / 2)
		' lower X/Y (outer edge of the inner circle)
	poLower.Initialize
	poLower.X = moCenterItem.CenterX + InnerRadius * Cos(pdCurr)
	poLower.Y = moCenterItem.CenterY + InnerRadius * Sin(pdCurr)
		' upper x/y (outer edge of full circle
	poUpper.Initialize
	poUpper.X = moCenterItem.CenterX + OuterRadius  * Cos(pdCurr)
	poUpper.Y = moCenterItem.CenterY + OuterRadius * Sin(pdCurr)
	
	poMid.Initialize
	poMid.X = (poUpper.X + poLower.X) / 2
	poMid.Y = (poUpper.Y + poLower.Y) / 2
	
	Return poMid
End Sub

Private Sub FindBoundingRect(AngleStart As Double, AngleEnd As Double, InnerRadius As Double, OuterRadius As Double) As B4XRect
	Dim poList As List
	Dim pdStart As Double
	Dim pdEnd As Double
	Dim pdCurr As Double
	Dim poRect As B4XRect
	
	poList.Initialize
	' R is outer edge of inner circle, R2 is edge of outer circle
	' a is begin angle in radians, b is end angle in radians
	' area = (b-a)*((r+r2)^2-r^2)/2
	' a and b must be expressed in radians
	' build a list of points along the curve for this blade
	pdStart = DegreeToRadian(AngleStart)
	pdEnd = DegreeToRadian(AngleEnd)
	For pdCurr = pdStart To pdEnd Step 0.025
		' lower X/Y (outer edge of the inner circle)
		Dim poPt As FanPointf
		poPt.Initialize
		poPt.X = moCenterItem.CenterX + InnerRadius * Cos(pdCurr)
		poPt.Y = moCenterItem.CenterY + InnerRadius * Sin(pdCurr)
		poList.Add(poPt)
		' upper x/y (outer edge of full circle
		Dim poPt As FanPointf
		poPt.Initialize
		poPt.X = moCenterItem.CenterX + OuterRadius  * Cos(pdCurr)
		poPt.Y = moCenterItem.CenterY + OuterRadius * Sin(pdCurr)
		poList.Add(poPt)
	Next
	' make sure the last angle is in the list of points
	Dim poPt As FanPointf
	poPt.Initialize
	poPt.X = moCenterItem.CenterX + InnerRadius * Cos(pdEnd)
	poPt.Y = moCenterItem.CenterY + InnerRadius * Sin(pdEnd)
	poList.Add(poPt)
	Dim poPt As FanPointf
	poPt.Initialize
	poPt.X = moCenterItem.CenterX + OuterRadius  * Cos(pdEnd)
	poPt.Y = moCenterItem.CenterY + OuterRadius * Sin(pdEnd)
	poList.Add(poPt)
	
	' now we have a list of points in the blade, construct a boundin rect based on min/maxes contained in that list
	Dim poPt As FanPointf = poList.Get(0)
	poRect.Initialize(poPt.X, poPt.Y, poPt.X, poPt.Y) 
	For Each poPt As FanPointf In poList
		If poPt.X < poRect.Left Then 
			poRect.Left = poPt.X
		End If
		If poPt.Y < poRect.Top Then 
			poRect.top = poPt.Y 
		End If
		If poPt.X > poRect.Right Then 
			poRect.Right = poPt.X		
		End If
		If poPt.Y > poRect.Bottom Then 
			poRect.Bottom = poPt.Y
		End If
	Next
	' return the bounding rectangle
	Return poRect
End Sub

Private Sub RadianToDegree(RadianValue As Double) As Double
	Return RadianValue * 57.29577951
End Sub
Private Sub DegreeToRadian(DegreeValue As Double) As Double
	Return DegreeValue * 0.017453292
End Sub

' Animation routine, slides the inner circle on screen then rotates the image to make the fan visible.
Private Sub RotateMenu(RotateIn As Boolean)
	Dim poMenuRect As B4XRect
	Dim pfTimeStep As Float = miFanAnimTime / 180
	Dim pfAngleStep As Float = 180 / pfTimeStep
	Dim pfAngle As Float = -180
	Dim piLeft As Int
	Dim piTop As Int
	Dim poOutRect As B4XRect
	Dim poFullRect As B4XRect
	Dim pbDone As Boolean = False
	Dim piBackColor As Int = Colors.Transparent
	Dim pfBackColorMax As Float
	Dim pfBackColorStep As Float
	Dim pfBackColorCurr As Float  

	' prevent recursion during the animation cycle	
	If mbRotating Then 
		Return 
	End If
	mbRotating = True 

	' our drawn "menu" rectangle
	poMenuRect.Initialize(0, 0, moMenuBmp.Width, moMenuBmp.Height)

	Select Case miMenuPos
		Case MENU_BOTTOM
			pfAngle = -180
			piLeft = (moBackPanel.Width - poMenuRect.Width) / 2
			piTop = moBackPanel.Height - (poMenuRect.Height / 2)


		Case MENU_LEFT
			pfAngle = -180
			piLeft = -(poMenuRect.Width / 2)
			piTop = (moBackPanel.Height - poMenuRect.Height) / 2


		Case MENU_RIGHT
			pfAngle = 180
			pfAngleStep = pfAngleStep * -1
			piLeft = moBackPanel.Width - (poMenuRect.Width / 2)
			piTop = (moBackPanel.Height - poMenuRect.Height) / 2
			

		Case MENU_TOP
			pfAngle = 180
			pfAngleStep = pfAngleStep * -1
			piLeft = (moBackPanel.Width - poMenuRect.Width) / 2
			piTop = -(poMenuRect.Height / 2)
	End Select

	If Not(RotateIn) Then
		' menu is drawn in the "open" position
		pfAngle = 0
	End If
	' where we will draw the menu
	poOutRect.Initialize(piLeft, piTop, piLeft + poMenuRect.Width, piTop + poMenuRect.Height)
	' our complete output area
	poFullRect.Initialize(0, 0, moContainer.Width, moContainer.Height)

	' slide the center "circle" in if rotating in
	If RotateIn Then
		moBackPanel.Visible = True
		moBackPanel.Elevation = miElevation
		moBackPanel.BringToFront
		moBackCan.DrawRect(poFullRect, Colors.Transparent, True, 1dip)
		moContainer.Invalidate
		Sleep(0)

		Dim piSlideWidthX As Int = moMenuBmp.Width / 4
		Dim piSlideWidthY As Int = moMenuBmp.Height / 4
		Dim pfSlideStepX As Float = miSlideAnimTime / piSlideWidthX
		Dim pfSlideStepY As Float = miSlideAnimTime / piSlideWidthY
		Dim pfSlideShiftX As Float = piSlideWidthX / pfSlideStepX
		Dim pfSlideShiftY As Float = piSlideWidthY / pfSlideStepY
		Dim poSlideRect As B4XRect
		Dim piSlideLeft As Int
		Dim piSlideTop As Int
		
		Select Case miMenuPos
			Case MENU_BOTTOM   'bottom up
				pfBackColorMax = piSlideWidthY
				pfBackColorStep = pfSlideShiftY
				pfSlideShiftX = 0
				piSlideLeft = piLeft 
				piSlideTop = piTop + piSlideWidthY
				pfSlideShiftY = -pfSlideShiftY

			Case MENU_LEFT
				pfBackColorStep = pfSlideShiftX
				pfBackColorMax = piSlideWidthX
				piSlideLeft = piLeft - piSlideWidthX
				piSlideTop = piTop 
				pfSlideShiftY = 0


			Case MENU_RIGHT
				pfBackColorStep = pfSlideShiftX
				pfBackColorMax = piSlideWidthX
				piSlideLeft = piLeft + piSlideWidthX
				piSlideTop = piTop
				pfSlideShiftX = -pfSlideShiftX
				pfSlideShiftY = 0

			Case MENU_TOP	'top down 
				pfBackColorMax = piSlideWidthY
				pfBackColorStep = pfSlideShiftY
				pfSlideShiftX = 0
				piSlideLeft = piLeft
				piSlideTop = piTop - piSlideWidthY
		End Select
		
		pbDone = False
		pfBackColorCurr = pfBackColorStep 
		piBackColor = OffsetToColor(pfBackColorCurr, pfBackColorMax)
		Do While Not(pbDone)
			moBackCan.ClearRect(poFullRect)
			moBackCan.DrawRect(poFullRect, piBackColor, True, 1dip)
			poSlideRect.Initialize(piSlideLeft, piSlideTop, piSlideLeft + poMenuRect.Width, piSlideTop + poMenuRect.Height)
			moBackCan.DrawBitmapRotated(moMenuBmp, poSlideRect, pfAngle)
			piSlideLeft = piSlideLeft + pfSlideShiftX
			piSlideTop = piSlideTop + pfSlideShiftY
			pfBackColorCurr = pfBackColorCurr + pfBackColorStep
			piBackColor = OffsetToColor(pfBackColorCurr, pfBackColorMax)
			' we done?
			Select Case miMenuPos
				Case MENU_BOTTOM
					If piSlideTop <= piTop Then
						pbDone = True
					End If

				Case MENU_LEFT
					If piSlideLeft >= piLeft Then
						pbDone = True 
					End If

				Case MENU_RIGHT
					If piSlideLeft <= piLeft Then
						pbDone = True
					End If

				Case MENU_TOP
					If piSlideTop >= piTop Then
						pbDone = True
					End If
			End Select
			If Not(pbDone) Then
				moContainer.Invalidate
				Sleep(pfSlideStepX)
			End If
		Loop
	End If
	' back visible now, or is already visible
	piBackColor = OffsetToColor(100, 100)
	
	
	'==============================================================================================================
	' now rotate the "fan blades" into view
	pbDone = False
	poOutRect.Initialize(piLeft, piTop, piLeft + poMenuRect.Width, piTop + poMenuRect.Height)
	Do While Not(pbDone)
		moBackCan.ClearRect(poFullRect)
		moBackCan.DrawRect(poFullRect, piBackColor, True, 1dip)
     	moBackCan.DrawBitmapRotated(moMenuBmp, poOutRect, pfAngle)
		moContainer.Invalidate
		Sleep(pfTimeStep)
		If RotateIn Then
			pfAngle = pfAngle + pfAngleStep
			Select Case miMenuPos
				Case MENU_LEFT, MENU_BOTTOM
					If pfAngle >= 0 Then
						pfAngle = 0 
						pbDone = True
					End If

				Case MENU_RIGHT, MENU_TOP
					If pfAngle <= 0 Then
						pfAngle = 0 
						pbDone = True
					End If
				
			End Select
		Else
			pfAngle = pfAngle - pfAngleStep
			Select Case miMenuPos
				Case MENU_LEFT, MENU_BOTTOM
					If pfAngle <= -180 Then
						pfAngle = -180
						pbDone = True
					End If

				Case MENU_RIGHT, MENU_TOP
					If pfAngle >= 180 Then
						pfAngle = 180
						pbDone = True
					End If
			End Select
		End If
	Loop
	
	'==============================================================================================================
	' clear and redraw at final position if rotating in, else just leave it cleared
	If RotateIn Then
		piBackColor = OffsetToColor(100, 100)
		moBackCan.ClearRect(poFullRect)
		moBackCan.DrawRect(poFullRect, piBackColor, True, 1dip)
		moBackCan.DrawBitmap(moMenuBmp, poOutRect)
		' save off the final position so it can be used by the touch event
		moFinalRect.Initialize(poOutRect.Left, poOutRect.Top, poOutRect.Right, poOutRect.Bottom)
	Else
		' slide the "circle" out
		Dim piSlideWidthX As Int = moMenuBmp.Width / 4
		Dim piSlideWidthY As Int = moMenuBmp.Height / 4
		Dim pfSlideStepX As Float = miSlideAnimTime / piSlideWidthX
		Dim pfSlideStepY As Float = miSlideAnimTime / piSlideWidthY
		Dim pfSlideShiftX As Float = piSlideWidthX / pfSlideStepX
		Dim pfSlideShiftY As Float = piSlideWidthY / pfSlideStepY
		Dim poSlideRect As B4XRect
		Dim piSlideLeft As Int
		Dim piSlideTop As Int
		
		Select Case miMenuPos
			Case MENU_BOTTOM   'bottom up
				pfBackColorStep = pfSlideShiftY
				pfBackColorMax = piSlideWidthY
				pfSlideShiftX = 0
				piSlideLeft = piLeft
				piSlideTop = piTop 
				pfSlideShiftY = pfSlideShiftY

			Case MENU_LEFT
				pfBackColorStep = pfSlideShiftX
				pfBackColorMax = piSlideWidthX
				piSlideLeft = piLeft
				piSlideTop = piTop
				pfSlideShiftX = -pfSlideShiftX
				pfSlideShiftY = 0
				pfAngle = -180

			Case MENU_RIGHT
				pfBackColorStep = pfSlideShiftX
				pfBackColorMax = piSlideWidthX
				piSlideLeft = piLeft
				piSlideTop = piTop
				pfSlideShiftY = 0
				pfAngle = 180

			Case MENU_TOP		'top down 
				pfBackColorStep = pfSlideShiftY
				pfBackColorMax = piSlideWidthY
				pfSlideShiftX = 0
				piSlideLeft = piLeft
				piSlideTop = piTop
				pfSlideShiftY = -pfSlideShiftY
		End Select
		
		pbDone = False
		pfBackColorCurr = pfBackColorMax
		piBackColor = OffsetToColor(pfBackColorCurr, pfBackColorMax)
		Do While Not(pbDone)
			moBackCan.ClearRect(poFullRect)
			moBackCan.DrawRect(poFullRect, piBackColor, True, 1dip)
			poSlideRect.Initialize(piSlideLeft, piSlideTop, piSlideLeft + poMenuRect.Width, piSlideTop + poMenuRect.Height)
			moBackCan.DrawBitmapRotated(moMenuBmp, poSlideRect, pfAngle)
			piSlideLeft = piSlideLeft + pfSlideShiftX
			piSlideTop = piSlideTop + pfSlideShiftY
			pfBackColorCurr = pfBackColorCurr - pfBackColorStep
			piBackColor = OffsetToColor(pfBackColorCurr, pfBackColorMax)
			' we done?
			Select Case miMenuPos
				Case MENU_BOTTOM
					If piSlideTop >= (piTop + piSlideWidthY)  Then
						pbDone = True
					End If

				Case MENU_LEFT
					If piSlideLeft <= (piLeft - piSlideWidthX)  Then
						pbDone = True
					End If

				Case MENU_RIGHT
					If piSlideLeft >= (piLeft + piSlideWidthX)  Then
						pbDone = True
					End If

				Case MENU_TOP
					If piSlideTop <= (piTop - piSlideWidthY)  Then
						pbDone = True
					End If
			End Select
			If Not(pbDone) Then
				moContainer.Invalidate
				Sleep(pfSlideStepX)
			End If
		Loop

		moBackCan.ClearRect(poFullRect)
		moBackCan.DrawRect(poFullRect, Colors.Transparent, True, 1dip)
		' clear final rect to prevent any wayward touch events in case the user is tap-happy.
		moFinalRect.Initialize(0, 0, 0, 0)
	End If
	moContainer.Invalidate
	Sleep(0)
	moBackPanel.Visible = RotateIn
	mbRotating = False 
End Sub

Private Sub OffsetToColor(CurrentWidth As Float, TotalWidth As Float) As Int
	Dim Visible As Float =  (CurrentWidth + 1) / TotalWidth
	Return Colors.ARGB(175 * Visible, 0, 0, 0)
End Sub
#End Region		' PRIVATE METHODS


#Region  "  PROPERITES  "
' Gets or sets if the menu automatically closes once a selection has been made.
Public Sub getAutoClose As Boolean
	Return mbAutoClose
End Sub
Public Sub setAutoClose(Value As Boolean)
	mbAutoClose = Value 
End Sub

'  Gets or sets if the menu may be closed by clicking anywhere on the screen that is not part of the menu.  False = must select a menu button.
Public Sub getCancelable As Boolean
	Return mbCancelable
End Sub
Public Sub setCancelable(Value As Boolean)
	mbCancelable = Value 
End Sub

' Gets or sets the default item backcolor (used by NewMenuItem method, this does not change exiting items backcolor)
Public Sub getDefaultItemBackcolor As Int
	Return miDefItemBackColor
End Sub
Public Sub setDefaultItemBackcolor(Value As Int)
	miDefItemBackColor = Value 
End Sub

' Gets or sets the default item text color (used by NewMenuItem method, this does not change exiting items text color)
Public Sub getDefaultItemTextColor As Int 
	Return miDefItemTextColor
End Sub
Public Sub setDefaultItemTextColor(Value As Int)
	miDefItemTextColor = Value
End Sub

' Gets or sets the default text point size (used by NewMenuItem method, this does not change exiting items text size)
Public Sub getDefaultMenuItemTextSize As Float
	Return mfDefItemTextSize
End Sub
public Sub setDefaultMenuItemTextSize(Value As Float)
	mfDefItemTextSize = Value
End Sub

' Gets or sets the default item icon size percentage 1.0 = 100%.  (used by NewMenuItem method, this does not change exiting items values)
Public Sub getDefaultItemIconFillPercent As Float
	Return mfDefItemIconFillPercent
End Sub
Public Sub setDefaultItemIconFillPercent(Value As Float)
	mfDefItemIconFillPercent = Value
End Sub

' Gets or sets the menu dividing line color.  This does not change exiting item line colors, CreateMenu must be called after setting this.
Public Sub getMenuItemLineColor As Int
	Return miMenuLineColor
End Sub
Public Sub setMenuItemLineColor(Value As Int)
	miMenuLineColor = Value 
End Sub

' Gets or sets the menu dividing line width (in DIP).  This does not change exiting item line widths, CreateMenu must be called after setting this.
Public Sub getMenuItemLineWidth As Int
	Return miMenuLineWidth
End Sub
Public Sub setMenuItemLineWidth(Value As Int)
	miMenuLineWidth = Value 
End Sub

' Gets or sets the font used for displaying the blade text.  This does not change exiting item text, CreateMenu must be called after setting this.
Public Sub getItemFont As Typeface
	Return moFanFont
End Sub
Public Sub setItemFont(Font As Typeface)
	moFanFont = Font 
End Sub


#End Region			' PROPERTIES 


