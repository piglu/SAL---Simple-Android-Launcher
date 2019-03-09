Type=Class
Version=7.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Private Sub Class_Globals
	Private pnl As Panel 	
	Private Eventname As String 
	Private module As Object 
	Private tmr As Timer 
	
	Private mDuration As Int 
		
	Private finalHeight As Int 
	Private direction As Int 
	
	'AutoExpand
	Public maxHeight As Int 
	Public minHeight As Int
	
	Public IndicatorView As View 
	'Private Anim As AnimationPlus 
	Private RotAngle As Float 
	
	Private lastTime As Long = 0
	Dim Anim As noaValueAnimator
End Sub

'Initializes the Expandable Panels
'EventName only supports panel click for now
'Module is the activity name
'If you want to re-adjust otherviews, create a sub called "Resize_Views" in module that re-adjusts surrounding views
Public Sub Initialize(pEventname As String, pModule As Object)
	module    = pModule
	Eventname = pEventname
	pnl.Initialize("pnl")
	RotAngle = 0
End Sub

'Sets the speed of the animation
'Set the duration in ms for the animation
Public Sub setSpeed(pDuration As Int)
	mDuration = pDuration	
End Sub

'Returns the panel
Public Sub AsPanel As Panel
	Return pnl
End Sub

'Dynamically resize panel to required height
'Make sure to set setSpeed before calling Resize
Public Sub ResizeTo(pfinalHeight As Int)
	finalHeight = pfinalHeight
	Anim.InitializeInt(pnl.Height ,finalHeight, "Anim")
	Anim.Interpolator = Anim.INTERPOLATOR_LINEAR
	Anim.setDuration(mDuration)
	If pnl.Height > pfinalHeight Then
		direction = -1
		'Anim.InitializeRotateCenter("Rotate",0, -90,IndicatorView)
	Else
		direction = 1
		'Anim.InitializeRotateCenter("Rotate",-90, 0,IndicatorView)
	End If
	lastTime = DateTime.Now 
	'tmr.Enabled = True
	Anim.Start 
	
	'
	RotAngle = RotAngle + (direction * 90)
	'Anim.Duration = 500
	'Anim.PersistAfter = True
	'Anim.Start(IndicatorView)
End Sub

Private Sub Anim_Update
	pnl.Height = Anim.AnimatedValue
	CallSub(module, Eventname & "_Resize_Views")
End Sub

Private Sub pnl_Click
	If SubExists(module,Eventname & "_Click") Then
		CallSub2(module,Eventname & "_Click",Me)
	End If
End Sub

'Resizes the panel to maxHeight. Make sure to set it before you call Expand
Public Sub Expand
	ResizeTo(maxHeight)
End Sub

'Resizes the panel to minHeigh. Make sure to set it before you call Collapse
Public Sub Collapse
	ResizeTo(minHeight)
End Sub

'Returns whether the panel is fully expanded or not
'Depends on maxHeight and minHeight being set
Public Sub IsExpanded As Boolean
	Return (pnl.Height = maxHeight)
End Sub

'Toggles the height to expand or collapse.
'Make sure maxHeight AND minHeight As set
Public Sub ToggleHeight
	If IsExpanded Then
		Collapse
	Else
		Expand
	End If
End Sub

