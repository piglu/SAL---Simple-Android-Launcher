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
	Private listener As NotificationListener
	Dim brojNotifikacija As Int = 0
End Sub
Sub Service_Create
	listener.Initialize("listener")
End Sub

Sub Service_Start (StartingIntent As Intent)
	If listener.HandleIntent(StartingIntent) Then Return
End Sub

Sub Listener_NotificationPosted (SBN As StatusBarNotification)
	brojNotifikacija = brojNotifikacija + 1
	Log("NotificationPosted, package = " & SBN.PackageName & ", id = " & SBN.Id & ", text = " & SBN.TickerText)
	Dim p As Phone
	If p.SdkVersion >= 19 Then
		Dim jno As JavaObject = SBN.Notification
		Dim extras As JavaObject = jno.GetField("extras")
		extras.RunMethod("size", Null)
		Log(extras)
		Dim title As String = extras.RunMethod("getString", Array As Object("android.title"))
		LogColor("Title = " & title, Colors.Blue)
		Dim bmp As Bitmap = jno.GetField("largeIcon")
	End If

End Sub

Sub Listener_NotificationRemoved (SBN As StatusBarNotification)
	Log("NotificationRemoved, package = " & SBN.PackageName & ", id = " & SBN.Id & _
		", text = " & SBN.TickerText)
	brojNotifikacija = brojNotifikacija - 1
End Sub

Sub ClearAll
	listener.ClearAll
End Sub

Sub GetActive
	listener.GetActiveNotifications
End Sub

Sub Service_Destroy

End Sub
