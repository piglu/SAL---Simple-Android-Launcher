package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class provjera_subs_0 {


public static RemoteObject  _pe_packageremoved(RemoteObject _package,RemoteObject _intent) throws Exception{
try {
		Debug.PushSubsStack("pe_PackageRemoved (provjera) ","provjera",9,provjera.processBA,provjera.mostCurrent,23);
if (RapidSub.canDelegate("pe_packageremoved")) return com.no3dlauncher.provjera.remoteMe.runUserSub(false, "provjera","pe_packageremoved", _package, _intent);
Debug.locals.put("Package", _package);
Debug.locals.put("Intent", _intent);
 BA.debugLineNum = 23;BA.debugLine="Sub pe_PackageRemoved (Package As String, Intent A";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="Log(\"uninstall ok\")";
Debug.ShouldStop(16777216);
provjera.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("uninstall ok")));
 BA.debugLineNum = 26;BA.debugLine="CallSub(Starter, \"GetInstalledApps\")";
Debug.ShouldStop(33554432);
provjera.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",provjera.processBA,(Object)((provjera.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("GetInstalledApps")));
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
 //BA.debugLineNum = 8;BA.debugLine="Dim pe As PhoneEvents";
provjera._pe = RemoteObject.createNew ("anywheresoftware.b4a.phone.PhoneEvents");
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (provjera) ","provjera",9,provjera.processBA,provjera.mostCurrent,11);
if (RapidSub.canDelegate("service_create")) return com.no3dlauncher.provjera.remoteMe.runUserSub(false, "provjera","service_create");
 BA.debugLineNum = 11;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(1024);
 BA.debugLineNum = 12;BA.debugLine="pe.Initialize(\"pe\")";
Debug.ShouldStop(2048);
provjera._pe.runVoidMethod ("Initialize",provjera.processBA,(Object)(RemoteObject.createImmutable("pe")));
 BA.debugLineNum = 13;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Service_Destroy (provjera) ","provjera",9,provjera.processBA,provjera.mostCurrent,19);
if (RapidSub.canDelegate("service_destroy")) return com.no3dlauncher.provjera.remoteMe.runUserSub(false, "provjera","service_destroy");
 BA.debugLineNum = 19;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(262144);
 BA.debugLineNum = 21;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("Service_Start (provjera) ","provjera",9,provjera.processBA,provjera.mostCurrent,15);
if (RapidSub.canDelegate("service_start")) return com.no3dlauncher.provjera.remoteMe.runUserSub(false, "provjera","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 15;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 17;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}