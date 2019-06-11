package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class notificationservice_subs_0 {


public static RemoteObject  _clearall() throws Exception{
try {
		Debug.PushSubsStack("ClearAll (notificationservice) ","notificationservice",4,notificationservice.processBA,notificationservice.mostCurrent,39);
if (RapidSub.canDelegate("clearall")) { return com.no3dlauncher.notificationservice.remoteMe.runUserSub(false, "notificationservice","clearall");}
 BA.debugLineNum = 39;BA.debugLine="Sub ClearAll";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="listener.ClearAll";
Debug.ShouldStop(128);
notificationservice._listener.runVoidMethod ("ClearAll");
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getactive() throws Exception{
try {
		Debug.PushSubsStack("GetActive (notificationservice) ","notificationservice",4,notificationservice.processBA,notificationservice.mostCurrent,43);
if (RapidSub.canDelegate("getactive")) { return com.no3dlauncher.notificationservice.remoteMe.runUserSub(false, "notificationservice","getactive");}
 BA.debugLineNum = 43;BA.debugLine="Sub GetActive";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="listener.GetActiveNotifications";
Debug.ShouldStop(2048);
notificationservice._listener.runVoidMethod ("GetActiveNotifications");
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _listener_notificationposted(RemoteObject _sbn) throws Exception{
try {
		Debug.PushSubsStack("Listener_NotificationPosted (notificationservice) ","notificationservice",4,notificationservice.processBA,notificationservice.mostCurrent,17);
if (RapidSub.canDelegate("listener_notificationposted")) { return com.no3dlauncher.notificationservice.remoteMe.runUserSub(false, "notificationservice","listener_notificationposted", _sbn);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _jno = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _extras = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _title = RemoteObject.createImmutable("");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("SBN", _sbn);
 BA.debugLineNum = 17;BA.debugLine="Sub Listener_NotificationPosted (SBN As StatusBarN";
Debug.ShouldStop(65536);
 BA.debugLineNum = 18;BA.debugLine="brojNotifikacija = brojNotifikacija + 1";
Debug.ShouldStop(131072);
notificationservice._brojnotifikacija = RemoteObject.solve(new RemoteObject[] {notificationservice._brojnotifikacija,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 19;BA.debugLine="Log(\"NotificationPosted, package = \" & SBN.Packag";
Debug.ShouldStop(262144);
notificationservice.mostCurrent.__c.runVoidMethod ("LogImpl","36488066",RemoteObject.concat(RemoteObject.createImmutable("NotificationPosted, package = "),_sbn.runMethod(true,"getPackageName"),RemoteObject.createImmutable(", id = "),_sbn.runMethod(true,"getId"),RemoteObject.createImmutable(", text = "),_sbn.runMethod(true,"getTickerText")),0);
 BA.debugLineNum = 20;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(524288);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 21;BA.debugLine="If p.SdkVersion >= 19 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 19))) { 
 BA.debugLineNum = 22;BA.debugLine="Dim jno As JavaObject = SBN.Notification";
Debug.ShouldStop(2097152);
_jno = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jno.setObject(_sbn.runMethod(false,"getNotification").getObject());Debug.locals.put("jno", _jno);
 BA.debugLineNum = 23;BA.debugLine="Dim extras As JavaObject = jno.GetField(\"extras\"";
Debug.ShouldStop(4194304);
_extras = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_extras.setObject(_jno.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("extras"))));Debug.locals.put("extras", _extras);
 BA.debugLineNum = 24;BA.debugLine="extras.RunMethod(\"size\", Null)";
Debug.ShouldStop(8388608);
_extras.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("size")),(Object)((notificationservice.mostCurrent.__c.getField(false,"Null"))));
 BA.debugLineNum = 25;BA.debugLine="Log(extras)";
Debug.ShouldStop(16777216);
notificationservice.mostCurrent.__c.runVoidMethod ("LogImpl","36488072",BA.ObjectToString(_extras),0);
 BA.debugLineNum = 26;BA.debugLine="Dim title As String = extras.RunMethod(\"getStrin";
Debug.ShouldStop(33554432);
_title = BA.ObjectToString(_extras.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getString")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("android.title"))}))));Debug.locals.put("title", _title);Debug.locals.put("title", _title);
 BA.debugLineNum = 27;BA.debugLine="LogColor(\"Title = \" & title, Colors.Blue)";
Debug.ShouldStop(67108864);
notificationservice.mostCurrent.__c.runVoidMethod ("LogImpl","36488074",RemoteObject.concat(RemoteObject.createImmutable("Title = "),_title),notificationservice.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));
 BA.debugLineNum = 28;BA.debugLine="Dim bmp As Bitmap = jno.GetField(\"largeIcon\")";
Debug.ShouldStop(134217728);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp.setObject(_jno.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("largeIcon"))));Debug.locals.put("bmp", _bmp);
 };
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _listener_notificationremoved(RemoteObject _sbn) throws Exception{
try {
		Debug.PushSubsStack("Listener_NotificationRemoved (notificationservice) ","notificationservice",4,notificationservice.processBA,notificationservice.mostCurrent,33);
if (RapidSub.canDelegate("listener_notificationremoved")) { return com.no3dlauncher.notificationservice.remoteMe.runUserSub(false, "notificationservice","listener_notificationremoved", _sbn);}
Debug.locals.put("SBN", _sbn);
 BA.debugLineNum = 33;BA.debugLine="Sub Listener_NotificationRemoved (SBN As StatusBar";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="Log(\"NotificationRemoved, package = \" & SBN.Packa";
Debug.ShouldStop(2);
notificationservice.mostCurrent.__c.runVoidMethod ("LogImpl","36553601",RemoteObject.concat(RemoteObject.createImmutable("NotificationRemoved, package = "),_sbn.runMethod(true,"getPackageName"),RemoteObject.createImmutable(", id = "),_sbn.runMethod(true,"getId"),RemoteObject.createImmutable(", text = "),_sbn.runMethod(true,"getTickerText")),0);
 BA.debugLineNum = 36;BA.debugLine="brojNotifikacija = brojNotifikacija - 1";
Debug.ShouldStop(8);
notificationservice._brojnotifikacija = RemoteObject.solve(new RemoteObject[] {notificationservice._brojnotifikacija,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private listener As NotificationListener";
notificationservice._listener = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationListenerWrapper.NotificationListener");
 //BA.debugLineNum = 7;BA.debugLine="Dim brojNotifikacija As Int = 0";
notificationservice._brojnotifikacija = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (notificationservice) ","notificationservice",4,notificationservice.processBA,notificationservice.mostCurrent,9);
if (RapidSub.canDelegate("service_create")) { return com.no3dlauncher.notificationservice.remoteMe.runUserSub(false, "notificationservice","service_create");}
 BA.debugLineNum = 9;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(256);
 BA.debugLineNum = 10;BA.debugLine="listener.Initialize(\"listener\")";
Debug.ShouldStop(512);
notificationservice._listener.runVoidMethod ("Initialize",notificationservice.processBA,(Object)(RemoteObject.createImmutable("listener")));
 BA.debugLineNum = 11;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (notificationservice) ","notificationservice",4,notificationservice.processBA,notificationservice.mostCurrent,47);
if (RapidSub.canDelegate("service_destroy")) { return com.no3dlauncher.notificationservice.remoteMe.runUserSub(false, "notificationservice","service_destroy");}
 BA.debugLineNum = 47;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (notificationservice) ","notificationservice",4,notificationservice.processBA,notificationservice.mostCurrent,13);
if (RapidSub.canDelegate("service_start")) { return com.no3dlauncher.notificationservice.remoteMe.runUserSub(false, "notificationservice","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 13;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="If listener.HandleIntent(StartingIntent) Then Ret";
Debug.ShouldStop(8192);
if (notificationservice._listener.runMethod(true,"HandleIntent",(Object)(_startingintent)).<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 15;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}