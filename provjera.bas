B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=7.3
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim pe As PhoneEvents
End Sub

Sub Service_Create
	pe.Initialize("pe")
End Sub

Sub Service_Start (StartingIntent As Intent)

End Sub

Sub Service_Destroy

End Sub

Sub pe_PackageRemoved (Package As String, Intent As Intent)
	'Your code to do stuff here
	Log("uninstall ok")
	CallSub(Starter, "GetInstalledApps")
End Sub