B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=7.3
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim mapa As Map
	Dim listaSlova As List
'	Dim cu As ContactsUtils
'	Dim cll As List
'	Dim mapa As Map
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.
	f.InitKVS2
	f.UcitajVrijednostiOpt
	GetInstalledApps
End Sub

Sub Service_Start (StartingIntent As Intent)
	
End Sub

Sub Service_TaskRemoved
	'This event will be raised when the user removes the app from the recent apps list.
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub

Private Sub GetInstalledApps
	Dim pm As PackageManager  'phone library
	Dim packages As List
	Dim jo As JavaObject

	mapa.Initialize
	mapa.Clear
	Log("starter: " & mapa.Size)
	listaSlova.Initialize
	jo.InitializeContext

	packages = pm.GetInstalledPackages

	For i = 0 To packages.Size - 1
		Dim p As String = packages.Get(i)
		Dim AppName As String = pm.GetApplicationLabel(p)
		If pm.GetApplicationIntent(p).IsInitialized Then
			listaSlova.Add(AppName.SubString2(0, 1).ToUpperCase)
			mapa.Put(AppName & ";" & packages.Get(i), i)
		End If
'		If jo.RunMethodJO("getPackageManager", Null).RunMethodJO("getApplicationInfo", Array (p, 0)).GetField("flags") = False Then
'		If jo.RunMethodJO("getPackageManager", Null).RunMethodJO("getLaunchIntentForPackage", Array(p)) <> Null Then
'			Log(AppName)
'		If f.sist Then
'		If IsSystemApp(p) = False Then
'			listaSlova.Add(AppName.SubString2(0, 1).ToUpperCase)
'			mapa.Put(AppName & ";" & packages.Get(i), i)
'		End If
'		Else
'			listaSlova.Add(AppName.SubString2(0, 1).ToUpperCase)
'			mapa.Put(AppName & ";" & packages.Get(i), i)
'		End If
	Next

	Dim mTemp As Map
	mTemp.Initialize
	For i = 0 To listaSlova.Size - 1
		mTemp.Put(listaSlova.Get(i), i)
	Next
	listaSlova.Clear
	For i = 0 To mTemp.Size - 1
		listaSlova.Add(mTemp.GetKeyAt(i))
	Next
	listaSlova.Sort(True)

	Dim m As Map
	m = SortMapKeys(mapa, True)
	mapa = m
End Sub

'Sub IsSystemApp (PackageName As String) As Boolean
'	Dim jo As JavaObject
'
'	jo.InitializeContext
'	Dim flags As Int = jo.RunMethodJO("getPackageManager", Null).RunMethodJO("getApplicationInfo", Array (PackageName, 0)).GetField("flags")
'
'	Return Bit.And(flags, 1) = 1 'FLAG_SYSTEM
'End Sub

Sub SortMapKeys (m As Map, SortAsc As Boolean) As Map
	Private KeysList As List:KeysList.Initialize
	Private m2 As Map:m2.Initialize
	
	For i = 0 To m.Size - 1
		Private key As String = m.GetKeyAt(i)
		KeysList.Add(key)
	Next
	
	KeysList.Sort(SortAsc)
  
	For x = 0 To KeysList.Size - 1
		Private key As String = KeysList.Get(x)
		Private val As Object = m.Get(key)
		m2.Put(key, val)
	Next
	m.Clear
	For Each m2Key As String In m2.Keys
		m.Put(m2Key, m2.Get(m2Key))
	Next

	Return m
End Sub

'Sub FindContacts
'	cu.Initialize
'	cll.Initialize
'	mapa.Initialize
'
'	cll = cu.FindAllContacts(True)
'End Sub