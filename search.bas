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
	Private sv As ScrollView
	Dim lbl1 As Label	' za ukupan broj aplikacija koje počinju nekim slovom
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("trazi")

	sv.Initialize(500dip)
	Activity.AddView(sv, 0, 46dip, 100%x, 100%y - 46dip)

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
	sv.Panel.AddView(pnlSlova, 0, 0, 100%x, 100%y)
'	Activity.AddView(pnlSlova, 0, 46dip, 100%x, 100%y)
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
	pnlSlova.RemoveView
'	Log(b.Tag)
'	pnlSlova.Visible = False
''	sv.Initialize(1000dip)
''	Activity.AddView(sv, 0, 46dip, 100%x, 100%y)
	pnlAppPodSlovom.Initialize("")
	sv.Panel.AddView(pnlAppPodSlovom, 0, 0, 100%x, 100%y)
	lbl1.Initialize("")
	Dim cd As ColorDrawable
	cd.Initialize(Colors.Yellow, 50)
	lbl1.Background = cd
	lbl1.Typeface = Typeface.DEFAULT_BOLD
	lbl1.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL)
'	lbl1.Color = Colors.Transparent
	sv.Panel.AddView(lbl1, 100%x - 32dip, 100%y - 80dip, 32dip, 32dip)
'	Activity.AddView(pnlAppPodSlovom, 0, 46dip, 100%x, 100%y)
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
	x = x - 2dip
'	Log(x)
'	x = x - 20dip	' 4dip razmak između krugova * 5 krugova po retku
'	Log(x)
	Log(pnlAppPodSlovom.Height)
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
'					Log(pkg1.Get(i*5+j))
					pnlAppPodSlovom.AddView(iv, x*j + j*1dip, x*i + 10dip + i*30dip, x, x)
					Dim lbl As Label
					lbl.Initialize("")
					lbl.Text = pkg2.Get(i*5+j)
					lbl.TextColor = Colors.White
					lbl.Background = cd
					lbl.TextSize = 10
					lbl.Typeface = Typeface.LoadFromAssets(f.wheelListFont & ".ttf")
					lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL)
					pnlAppPodSlovom.AddView(lbl, x*j, x*i + x + i*30dip + 4dip, x, 30dip)
'					pnlAppPodSlovom.AddView(lbl, 64dip*j + 10dip, 64dip*i + 64dip + i*30dip + 4dip, 64dip, 30dip)
				Else
'					Log(drawable)
'					Log("nešto drugo")
					Dim btm As Bitmap
					btm.InitializeMutable(x, x)
					Dim DestRect As Rect
					DestRect.Initialize(0, 0, x, x)
					Dim can As Canvas
					can.Initialize2(btm)
					Dim pm As PackageManager
					can.DrawDrawable(pm.GetApplicationIcon(pkg1.Get(i*5+j)), DestRect)
					Dim iv As ImageView
					iv.Initialize("ivApp")
					iv.Background = BitmapToBitmapDrawable(btm)
'					iv.Bitmap = BitmapToBitmapDrawable(btm)
'					iv.Bitmap = bdw.Bitmap
					iv.Tag = pkg1.Get(i*5+j)
'					Log(pkg1.Get(i*5+j))
					pnlAppPodSlovom.AddView(iv, x*j + j*1dip, x*i + 10dip + i*30dip, x, x)
					Dim lbl As Label
					lbl.Initialize("")
					lbl.Text = pkg2.Get(i*5+j)
					lbl.TextColor = Colors.White
					lbl.Background = cd
					lbl.TextSize = 10
					lbl.Typeface = Typeface.LoadFromAssets(f.wheelListFont & ".ttf")
					lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL)
					pnlAppPodSlovom.AddView(lbl, x*j, x*i + x + i*30dip + 4dip, x, 30dip)
				End If
				ukupno2 = ukupno2 + 1
			Else
				Exit
			End If
		Next
	Next
	lbl1.Text = ukupno1
	lbl1.TextColor = Colors.Black
'	Log(pnlAppPodSlovom.Height)
	sv.Panel.Height = pnlAppPodSlovom.Height - 46dip
End Sub

Sub BitmapToBitmapDrawable(BMD As Bitmap) As BitmapDrawable
	Dim BD As BitmapDrawable
	BD.Initialize(BMD)

	Return BD
End Sub

Sub ivApp_Click
	Dim in1, MyIntent As Intent
	Dim iv As ImageView
	Dim pm As PackageManager

	iv = Sender
	Log(iv.Tag)

	in1 = pm.GetApplicationIntent(iv.Tag)

'	If isSystemapp(iv.Tag) = False Then
'	If in1.IsInitialized Then
		Dim iv As ImageView
		iv = Sender
		Log(iv.Tag)
		Dim ll As List
		ll.Initialize
		ll.AddAll(Array As String("Run", "Add to favorites", "Uninstall"))
		Dim x As id
		Dim m As Int = x.InputList1(ll, "")
		Select m
			Case 0
				StartActivity(in1)
			Case 1
				AddToFavorites
			Case 2
				UninstallApp(iv.Tag)
		End Select
'	Else
'		Msgbox("This is system app!", "Info")
'		MyIntent.Initialize(in1.ACTION_VIEW, 0)
'		MyIntent.Initialize(iv.tag, 0)
'		MyIntent.SetComponent(iv.Tag)
'		Dim jo As JavaObject = MyIntent
'		Dim t As String = jo.RunMethod("getPackage", MyIntent)
'		Log(t)
'		StartActivity(MyIntent)
'	End If
End Sub

'Sub ivApp_LongClick
'	Log("long klik!")
'	Dim iv As ImageView
'	iv = Sender
'	Log(iv.Tag)
'	Dim ll As List
'	ll.Initialize
'	ll.AddAll(Array As String("Add to favorites", "Uninstall"))
'	Dim x As id
'	Dim m As Int = x.InputList1(ll, "")
'	Select m
'		Case 0
'			AddToFavorites
'		Case 1
'			UninstallApp(iv.Tag)
'	End Select
'End Sub

Sub AddToFavorites
	CallSub(Main, "DodajAppUFavorite")
End Sub

Sub UninstallApp(pkg As String)
	If IsPaused(provjera) = True Then StartService(provjera)

	Dim i As Intent

	Log("package:" & pkg)
	i.Initialize("android.intent.action.DELETE", "package:" & pkg)

	StartActivity(i)

	pnlSlova.Visible = True
	pnlSlova.RemoveAllViews

	DodajSlova
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode = KeyCodes.KEYCODE_BACK And pnlAppPodSlovom.IsInitialized Then
		If pnlAppPodSlovom.Visible = True Then
'			pnlAppPodSlovom.RemoveView
			lbl1.RemoveView
			pnlAppPodSlovom.Visible = False
'			lbl1.Visible = False
			DodajSlova
			Return True
		End If
	End If

	Return False
End Sub

Sub isSystemapp(app As String) As Boolean
	Dim Obj1, Obj2, Obj3 As Reflector
	Dim size, i, flags As Int
	Dim result As Boolean = False

	Obj1.Target = Obj1.GetContext
	Obj1.Target = Obj1.RunMethod("getPackageManager") ' PackageManager
	Obj1.Target = Obj1.RunMethod2("getInstalledPackages", 0, "java.lang.int") ' List<PackageInfo>
	For i = 0 To Obj1.RunMethod("size") -1
		Obj2.Target = Obj1.RunMethod2("get", i, "java.lang.int") ' PackageInfo
		Dim name As String = Obj2.GetField("packageName")
		If app.ToLowerCase = name.ToLowerCase Then
			Obj3.Target = Obj2.GetField("applicationInfo") ' ApplicationInfo
			flags = Obj3.GetField("flags")
			If Bit.And(flags, 1)  = 0 Then
				'app is not in the system image
			Else
				' Systemapp
				result = True
			End If
		End If
	Next
	Return result
End Sub

'
' traži aplikaciju u play storeu sa linkom
'
Sub PlayStoreLink
	Dim fURI As String
	fURI = "market://details?id=com.b4a.example"
	Dim Market As Intent
	Market.Initialize(Market.ACTION_VIEW,fURI)
	StartActivity (Market)
End Sub