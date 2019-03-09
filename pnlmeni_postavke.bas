B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=7.3
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private spnApps As Spinner
	Private spnFont As Spinner
	Private Label3 As Label
	'
	' fontovi sa stranice http://webpagepublicity.com/free-fonts-x.html
	'
	Private edtFontSize As EditText
	Private Label1 As Label
	Private btnBackground As Button
	Private btnFont As Button
	Private sbTransparent As SeekBar
	Private spnIconType As Spinner
	Private edtNoOfStarPoints As EditText
	Private Label7 As Label
	Private edtPages As EditText
	Dim animacije As AnimationComposer
	Dim mapaAnimacija As Map
	Private spnAnim As Spinner
	Private btnEnableNotifications As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("opt")

	mapaAnimacija = animacije.Techniques

	f.UcitajVrijednostiOpt
	sbTransparent.Value = f.trans
	Dim cd As ColorDrawable
	Dim res(4) As Int
	res = getARGB(f.bojaPozadine)
	res(0) = f.trans
	cd.Initialize(Colors.ARGB(res(0), res(1), res(2), res(3)), 0)
	Label1.Background = cd
	Label1.TextColor = f.bojaFonta
	spnApps.AddAll(Array As String("in a wheel", "in a list with app icons", "in drawer"))
	spnApps.SelectedIndex = f.showApps
	spnIconType.AddAll(Array As String("Round", "Hexagon", "Triangle", "Star", "Heart", "Bubble", "Cone"))
	spnIconType.SelectedIndex = f.tipIkone
	If spnIconType.SelectedIndex = 3 Then
		Label7.Visible = True
		edtNoOfStarPoints.Visible = True
		edtNoOfStarPoints.Text = f.brTocaka
	Else
		Label7.Visible = False
		edtNoOfStarPoints.Visible = False
	End If

	Dim l As List
	l.Initialize
	For i = 0 To mapaAnimacija.Size - 1
		l.Add(mapaAnimacija.GetKeyAt(i))
'		Log(mapaAnimacija.GetKeyAt(i))
'		Log(mapaAnimacija.GetValueAt(i))
	Next
	spnAnim.AddAll(l)
	spnAnim.SelectedIndex = spnAnim.IndexOf(f.animStr)

	edtPages.Text = f.brStranica

	edtFontSize.Text = f.fontzSize
	DodajFontove
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	If UserClosed Then
		Log("juzer klouzed")
		CallSubDelayed(Main, "Osvjezi")
	End If
End Sub

Sub DodajFontove
	Dim list As List
	list = File.ListFiles(File.DirAssets)
	For i = 0 To list.Size - 1
		Dim s As String = list.Get(i)
		If s.EndsWith(".ttf") Then
			s = s.SubString2(0, s.LastIndexOf("."))
			spnFont.Add(s)
		End If
	Next
	spnFont.SelectedIndex = spnFont.IndexOf(f.wheelListFont)
	Label3.Typeface = Typeface.LoadFromAssets(f.wheelListFont & ".ttf")
End Sub

Sub spnFont_ItemClick (Position As Int, Value As Object)
	f.SnimiOpcije("wheelListFont",	Value)
	Label3.Typeface = Typeface.LoadFromAssets(Value & ".ttf")
End Sub

Sub spnApps_ItemClick (Position As Int, Value As Object)
	f.UcitajVrijednostiOpt

	If Position > 0 Then
		If f.fontzSize >= 50 Then
			edtFontSize.Text = 18
		End If
	Else
		ToastMessageShow("Font size should be at least 55 for 'in wheel'!", True)
		edtFontSize.Text = 55
	End If
	f.SnimiOpcije2("showApps", Position)
End Sub

Sub edtFontSize_TextChanged (Old As String, New As String)
	If New.Length > 0 Then
'		Log(New)
		f.SnimiOpcije2("fontzSize", New)
	End If
End Sub

Sub btnBackground_Click
	Dim cw As ColorWheelDialog
	Dim res(4) As Int

	cw.Initialize
	cw.ShowAsync(Me, "Select Background Color")
	Wait For (cw) Color_Result(Success As Boolean)
	If Success Then
		res = getARGB(cw.ColorResult)
		Log(res(0))
		Log(res(1))
		Log(res(2))
		Log(res(3))
		Label1.Color = cw.ColorResult
		f.SnimiOpcije2("bojaPozadine", cw.ColorResult)
	End If
End Sub

Sub btnFont_Click
	Dim cw As ColorWheelDialog
	Dim res(4) As Int

	cw.Initialize
	cw.ShowAsync(Me, "Select Font Color")
	Wait For (cw) Color_Result(Success As Boolean)
	If Success Then
		res = getARGB(cw.ColorResult)
		Log(res(0))
		Log(res(1))
		Log(res(2))
		Log(res(3))
		Label1.TextColor = cw.ColorResult
		f.SnimiOpcije2("bojaFonta", cw.ColorResult)
	End If
End Sub

Sub getARGB(Color As Int) As Int()
	Dim res(4) As Int

	res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff000000), 24)
	res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff0000), 16)
	res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0xff00), 8)
	res(3) = Bit.And(Color, 0xff)

	Return res
End Sub

Sub sbTransparent_ValueChanged (Value As Int, UserChanged As Boolean)
	If UserChanged Then
		Dim res(4) As Int
		f.SnimiOpcije2("trans", Value)
		f.UcitajVrijednostiOpt
		res = getARGB(f.bojaPozadine)
		res(0) = f.trans
		Label1.Color = Colors.ARGB(res(0), res(1), res(2), res(3))
	End If
End Sub

Sub spnIconType_ItemClick (Position As Int, Value As Object)
	f.SnimiOpcije2("tipIkone", Position)
	If Position = 3 Then
		Label7.Visible = True
		edtNoOfStarPoints.Visible = True
		edtNoOfStarPoints.Text = f.brTocaka
	Else
		Label7.Visible = False
		edtNoOfStarPoints.Visible = False
	End If
End Sub

Sub edtNoOfStarPoints_TextChanged (Old As String, New As String)
	If New.Length > 0 Then
		f.SnimiOpcije2("brTocaka", New)
	End If
End Sub

Sub edtPages_TextChanged (Old As String, New As String)
	If New.Length > 0 Then
		f.SnimiOpcije2("brStranica", New)
	End If
End Sub

Sub spnAnim_ItemClick (Position As Int, Value As Object)
	f.SnimiOpcije("animStr", Value)
End Sub

'Sub btnEnableNotifications_Click
'	Dim p As Phone
'	Log(p.GetSettings("enabled_notification_listeners"))
'	If p.GetSettings("enabled_notification_listeners") Then
'		
'	End If
'		
'	Dim In As Intent
'	In.Initialize("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS", "")
'	StartActivity(In)
'End Sub