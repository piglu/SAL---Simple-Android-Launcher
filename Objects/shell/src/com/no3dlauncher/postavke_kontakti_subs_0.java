package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class postavke_kontakti_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (postavke_kontakti) ","postavke_kontakti",5,postavke_kontakti.mostCurrent.activityBA,postavke_kontakti.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) { return com.no3dlauncher.postavke_kontakti.remoteMe.runUserSub(false, "postavke_kontakti","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 21;BA.debugLine="Activity.LoadLayout(\"opt_kontakti\")";
Debug.ShouldStop(1048576);
postavke_kontakti.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("opt_kontakti")),postavke_kontakti.mostCurrent.activityBA);
 BA.debugLineNum = 23;BA.debugLine="f.UcitajVrijednostiOpt";
Debug.ShouldStop(4194304);
postavke_kontakti.mostCurrent._f.runVoidMethod ("_ucitajvrijednostiopt",postavke_kontakti.mostCurrent.activityBA);
 BA.debugLineNum = 24;BA.debugLine="EditText1.Text = f.sms_dani";
Debug.ShouldStop(8388608);
postavke_kontakti.mostCurrent._edittext1.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(postavke_kontakti.mostCurrent._f._sms_dani));
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (postavke_kontakti) ","postavke_kontakti",5,postavke_kontakti.mostCurrent.activityBA,postavke_kontakti.mostCurrent,31);
if (RapidSub.canDelegate("activity_pause")) { return com.no3dlauncher.postavke_kontakti.remoteMe.runUserSub(false, "postavke_kontakti","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (postavke_kontakti) ","postavke_kontakti",5,postavke_kontakti.mostCurrent.activityBA,postavke_kontakti.mostCurrent,27);
if (RapidSub.canDelegate("activity_resume")) { return com.no3dlauncher.postavke_kontakti.remoteMe.runUserSub(false, "postavke_kontakti","activity_resume");}
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edittext1_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("EditText1_TextChanged (postavke_kontakti) ","postavke_kontakti",5,postavke_kontakti.mostCurrent.activityBA,postavke_kontakti.mostCurrent,35);
if (RapidSub.canDelegate("edittext1_textchanged")) { return com.no3dlauncher.postavke_kontakti.remoteMe.runUserSub(false, "postavke_kontakti","edittext1_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 35;BA.debugLine="Sub EditText1_TextChanged (Old As String, New As S";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="If New.Length > 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 37;BA.debugLine="f.SnimiOpcije2(\"sms_dani\", New)";
Debug.ShouldStop(16);
postavke_kontakti.mostCurrent._f.runVoidMethod ("_snimiopcije2",postavke_kontakti.mostCurrent.activityBA,(Object)(BA.ObjectToString("sms_dani")),(Object)(BA.numberCast(int.class, _new)));
 };
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private EditText1 As EditText";
postavke_kontakti.mostCurrent._edittext1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}