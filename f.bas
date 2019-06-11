B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=7.3
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private kvs2 As KeyValueStore
	Dim bojaPozadine As Int = 16776960
	Dim wheelListFont As String = "xerox sans serif narrow"
	Dim showApps As Int = 3
	Dim fontzSize As Int = 55
	Dim bojaFonta As Int = 255
	Dim trans As Int = 0
	Dim tipIkone As Int
	Dim brTocaka As Int = 4
	Dim brStranica As Int = 2
	Dim animStr As String = "Bounce"
	Dim sms_dani As Int = -5
'	Dim sist As Boolean
End Sub

Sub InitKVS2
	kvs2.Initialize(File.DirInternal, "opt")
End Sub

Sub UcitajVrijednostiOpt
	If kvs2.ContainsKey("bojaPozadine") Then
		bojaPozadine = kvs2.Get("bojaPozadine")
	Else
		kvs2.Put("bojaPozadine", bojaPozadine)
	End If

	If kvs2.ContainsKey("wheelListFont") Then
		wheelListFont = kvs2.Get("wheelListFont")
	Else
		kvs2.Put("wheelListFont", wheelListFont)
	End If

	If kvs2.ContainsKey("showApps") Then
		showApps = kvs2.Get("showApps")
	Else
		kvs2.Put("showApps", showApps)
	End If

	If kvs2.ContainsKey("fontzSize") Then
		fontzSize = kvs2.Get("fontzSize")
	Else
		kvs2.Put("fontzSize", fontzSize)
	End If

	If kvs2.ContainsKey("bojaFonta") Then
		bojaFonta = kvs2.Get("bojaFonta")
	Else
		kvs2.Put("bojaFonta", bojaFonta)
	End If

	If kvs2.ContainsKey("trans") = True Then
		trans = kvs2.Get("trans")
	Else
		kvs2.Put("trans", trans)
	End If

	If kvs2.ContainsKey("tipIkone") = True Then
		tipIkone = kvs2.Get("tipIkone")
	Else
		kvs2.Put("tipIkone", tipIkone)
	End If

	If kvs2.ContainsKey("brTocaka") = True Then
		brTocaka = kvs2.Get("brTocaka")
	Else
		kvs2.Put("brTocaka", brTocaka)
	End If

	If kvs2.ContainsKey("brStranica") = True Then
		brStranica = kvs2.Get("brStranica")
	Else
		kvs2.Put("brStranica", brStranica)
	End If

	If kvs2.ContainsKey("animStr") = True Then
		animStr = kvs2.Get("animStr")
	Else
		kvs2.Put("animStr", animStr)
	End If

	If kvs2.ContainsKey("sms_dani") = True Then
		sms_dani = kvs2.Get("sms_dani")
	Else
		kvs2.Put("sms_dani", sms_dani)
	End If

'	If kvs2.ContainsKey("sist") = True Then
'		sist = kvs2.Get("sist")
'	Else
'		kvs2.Put("sist", sist)
'	End If
End Sub

Sub SnimiOpcije(kljuc As String, s As String)
	kvs2.Put(kljuc, s)
End Sub

Sub SnimiOpcije2(kljuc As String, i As Int)
	kvs2.Put(kljuc, i)
End Sub

'Sub SnimiOpcije3(kljuc As String, b As Boolean)
'	kvs2.Put(kljuc, b)
'End Sub
