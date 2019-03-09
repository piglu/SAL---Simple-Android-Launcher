B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=7.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private edtTrazi As EditText
	Private btnTrazi As Button
	Dim traziString As String
	Dim pnlSlova As Panel
	Dim pnlAppPodSlovom As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("trazi")

	DodajSlova
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub DodajSlova
	Dim x As Int = Activity.Width / 5	' 5 slova abecede u retku
	Dim y As Int = Activity.Width - x*5 + 8dip
	pnlSlova.Initialize("")
	Activity.AddView(pnlSlova, 0, 46dip, 100%x, 100%y)
	Dim cd As ColorDrawable
	cd.Initialize2(Colors.ARGB(127, 211, 211, 211), x, 4, Colors.White)
	Dim ukupno As Int = 0
	For i = 0 To Starter.listaSlova.Size - 1' Step 4
		For j = 0 To 4
			If ukupno < Starter.listaSlova.Size Then
				Dim s As String = Starter.listaSlova.Get(i*5+j)
				Dim btn As Button
				btn.Initialize("btnSlovo")
				btn.Text = s
				btn.Tag = s
				btn.TextSize = 28.0
				btn.TextColor = Colors.White
				btn.Typeface = Typeface.LoadFromAssets(f.wheelListFont & ".ttf")
				btn.Background = cd
				btn.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL)
				pnlSlova.AddView(btn, x*j + j*2dip, x*i + y + i*y, x - 10dip, x - 10dip)
				ukupno = ukupno + 1
			Else
				Exit
			End If
		Next
	Next
End Sub

Sub edtTrazi_TextChanged (Old As String, New As String)
	If New.Length > 0 Then
		Log(New)
		traziString = New
	End If
End Sub

Sub btnTrazi_Click
	Log("trazi")
	Trazi(traziString)
End Sub

Sub Trazi(str As String)
	
End Sub

Sub btnSlovo_Click
	Dim b As Button
	Dim pm As PackageManager
	Dim pkg1, pkg2 As List

	b = Sender
	Log(b.Tag)
	pnlSlova.Visible = False
	pnlAppPodSlovom.Initialize("")
	Activity.AddView(pnlAppPodSlovom, 0, 46dip, 100%x, 100%y)
	Dim ukupno1, ukupno2 As Int = 0
	pkg1.Initialize
	pkg2.Initialize
	' prikaži sve aplikacije pod izabranim slovom
	For i = 0 To Starter.mapa.Size - 1
		Dim s As String = Starter.mapa.GetKeyAt(i)
		If s.StartsWith(b.Tag) Then
			ukupno1 = ukupno1 + 1
			Dim pckg As String = Starter.mapa.GetKeyAt(i)
			' ime paketa
			pkg1.Add(pckg.SubString2(pckg.IndexOf(";")+1, pckg.Length))
			' ime aplikacije
			pkg2.Add(pckg.SubString2(0, pckg.IndexOf(";")))
		End If
	Next

	Dim cd As ColorDrawable
	cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)
	Dim x As Int
	x = Activity.Width / 5'pkg1.Size
'	Log(x)
'	x = x - 20dip	' 4dip razmak između krugova * 5 krugova po retku
'	Log(x)
	For i = 0 To pkg1.Size - 1
		For j = 0 To 4
			If ukupno2 < ukupno1 Then'pkg1.Size - 1 Then
				Dim drawable As Object = pm.GetApplicationIcon(pkg1.Get(i*5+j))
				If drawable Is BitmapDrawable Then
					Dim bdw As BitmapDrawable = drawable
					Dim bmp As Bitmap = bdw.Bitmap
					bdw.Initialize(bmp.Resize(64dip, 64dip, True))
					Dim iv As ImageView
					iv.Initialize("ivApp")
					iv.Bitmap = bdw.Bitmap
					iv.Tag = pkg1.Get(i*5+j)
					pnlAppPodSlovom.AddView(iv, x*j + j*2dip, x*i + 10dip + i*30dip, x, x)
					Dim lbl As Label
					lbl.Initialize("")
					lbl.Text = pkg2.Get(i*5+j)
					lbl.TextColor = Colors.White
					lbl.Background = cd
					lbl.TextSize = 12.0
					lbl.Typeface = Typeface.LoadFromAssets(f.wheelListFont & ".ttf")
					lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL)
					pnlAppPodSlovom.AddView(lbl, x*j, x*i + x + i*30dip + 4dip, x, 30dip)
'					pnlAppPodSlovom.AddView(lbl, 64dip*j + 10dip, 64dip*i + 64dip + i*30dip + 4dip, 64dip, 30dip)
				End If
				ukupno2 = ukupno2 + 1
			Else
				Exit
			End If
		Next
	Next
End Sub

Sub ivApp_Click
	Dim in As Intent
	Dim iv As ImageView
	Dim pm As PackageManager

	iv = Sender
	Log(iv.Tag)
	in = pm.GetApplicationIntent(iv.Tag)
	If in.IsInitialized Then
		StartActivity(in)
	End If
End Sub

Sub ivApp_LongClick
	Log("long klik!")
	Dim iv As ImageView
	iv = Sender
	Log(iv.Tag)
	Dim ll As List
	ll.Initialize
	ll.AddAll(Array As String("Add to favorites", "Uninstall"))
	Dim x As id
	Dim m As Int = x.InputList1(ll, "")
	Select m
		Case 0
			AddToFavorites
		Case 1
			UninstallApp(iv.Tag)
	End Select
End Sub

Sub AddToFavorites
	CallSub(Main, "DodajAppUFavorite")
End Sub

Sub UninstallApp(pkg As String)
	If IsPaused(provjera) = True Then StartService(provjera)

	Dim i As Intent

	Log("package:" & pkg)
	i.Initialize("android.intent.action.DELETE", "package:" & pkg)

	StartActivity(i)

	pnlAppPodSlovom.Visible = False
	pnlAppPodSlovom.RemoveAllViews
	pnlSlova.Visible = True
	pnlSlova.RemoveAllViews
	DodajSlova
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode = KeyCodes.KEYCODE_BACK And pnlAppPodSlovom.IsInitialized Then
		If pnlAppPodSlovom.Visible = True Then
			pnlAppPodSlovom.Visible = False
			pnlSlova.Visible = True
			Return True
		End If
	End If

	Return False
End Sub
