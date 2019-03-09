package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class f_subs_0 {


public static RemoteObject  _initkvs2(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("InitKVS2 (f) ","f",7,_ba,f.mostCurrent,21);
if (RapidSub.canDelegate("initkvs2")) return com.no3dlauncher.f.remoteMe.runUserSub(false, "f","initkvs2", _ba);
;
 BA.debugLineNum = 21;BA.debugLine="Sub InitKVS2";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 22;BA.debugLine="kvs2.Initialize(File.DirInternal, \"opt\")";
Debug.ShouldStop(2097152);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_initialize",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba),(Object)(f.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("opt")));
 BA.debugLineNum = 23;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private kvs2 As KeyValueStore";
f._kvs2 = RemoteObject.createNew ("com.no3dlauncher.keyvaluestore");
 //BA.debugLineNum = 7;BA.debugLine="Dim bojaPozadine As Int = 16776960";
f._bojapozadine = BA.numberCast(int.class, 16776960);
 //BA.debugLineNum = 8;BA.debugLine="Dim wheelListFont As String = \"xerox sans serif n";
f._wheellistfont = BA.ObjectToString("xerox sans serif narrow");
 //BA.debugLineNum = 9;BA.debugLine="Dim showApps As Int = 0";
f._showapps = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 10;BA.debugLine="Dim fontzSize As Int = 55";
f._fontzsize = BA.numberCast(int.class, 55);
 //BA.debugLineNum = 11;BA.debugLine="Dim bojaFonta As Int = 255";
f._bojafonta = BA.numberCast(int.class, 255);
 //BA.debugLineNum = 12;BA.debugLine="Dim trans As Int = 0";
f._trans = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 13;BA.debugLine="Dim tipIkone As Int";
f._tipikone = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 14;BA.debugLine="Dim brTocaka As Int = 4";
f._brtocaka = BA.numberCast(int.class, 4);
 //BA.debugLineNum = 15;BA.debugLine="Dim brStranica As Int = 2";
f._brstranica = BA.numberCast(int.class, 2);
 //BA.debugLineNum = 16;BA.debugLine="Dim animStr As String = \"Bounce\"";
f._animstr = BA.ObjectToString("Bounce");
 //BA.debugLineNum = 17;BA.debugLine="Dim sms_dani As Int = -5";
f._sms_dani = BA.numberCast(int.class, -(double) (0 + 5));
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _snimiopcije(RemoteObject _ba,RemoteObject _kljuc,RemoteObject _s) throws Exception{
try {
		Debug.PushSubsStack("SnimiOpcije (f) ","f",7,_ba,f.mostCurrent,99);
if (RapidSub.canDelegate("snimiopcije")) return com.no3dlauncher.f.remoteMe.runUserSub(false, "f","snimiopcije", _ba, _kljuc, _s);
;
Debug.locals.put("kljuc", _kljuc);
Debug.locals.put("s", _s);
 BA.debugLineNum = 99;BA.debugLine="Sub SnimiOpcije(kljuc As String, s As String)";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="kvs2.Put(kljuc, s)";
Debug.ShouldStop(8);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(_kljuc),(Object)((_s)));
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _snimiopcije2(RemoteObject _ba,RemoteObject _kljuc,RemoteObject _i) throws Exception{
try {
		Debug.PushSubsStack("SnimiOpcije2 (f) ","f",7,_ba,f.mostCurrent,103);
if (RapidSub.canDelegate("snimiopcije2")) return com.no3dlauncher.f.remoteMe.runUserSub(false, "f","snimiopcije2", _ba, _kljuc, _i);
;
Debug.locals.put("kljuc", _kljuc);
Debug.locals.put("i", _i);
 BA.debugLineNum = 103;BA.debugLine="Sub SnimiOpcije2(kljuc As String, i As Int)";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="kvs2.Put(kljuc, i)";
Debug.ShouldStop(128);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(_kljuc),(Object)((_i)));
 BA.debugLineNum = 105;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ucitajvrijednostiopt(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("UcitajVrijednostiOpt (f) ","f",7,_ba,f.mostCurrent,25);
if (RapidSub.canDelegate("ucitajvrijednostiopt")) return com.no3dlauncher.f.remoteMe.runUserSub(false, "f","ucitajvrijednostiopt", _ba);
;
 BA.debugLineNum = 25;BA.debugLine="Sub UcitajVrijednostiOpt";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 26;BA.debugLine="If kvs2.ContainsKey(\"bojaPozadine\") Then";
Debug.ShouldStop(33554432);
if (f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("bojaPozadine"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 27;BA.debugLine="bojaPozadine = kvs2.Get(\"bojaPozadine\")";
Debug.ShouldStop(67108864);
f._bojapozadine = BA.numberCast(int.class, f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("bojaPozadine"))));
 }else {
 BA.debugLineNum = 29;BA.debugLine="kvs2.Put(\"bojaPozadine\", bojaPozadine)";
Debug.ShouldStop(268435456);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("bojaPozadine")),(Object)((f._bojapozadine)));
 };
 BA.debugLineNum = 32;BA.debugLine="If kvs2.ContainsKey(\"wheelListFont\") Then";
Debug.ShouldStop(-2147483648);
if (f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("wheelListFont"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 33;BA.debugLine="wheelListFont = kvs2.Get(\"wheelListFont\")";
Debug.ShouldStop(1);
f._wheellistfont = BA.ObjectToString(f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("wheelListFont"))));
 }else {
 BA.debugLineNum = 35;BA.debugLine="kvs2.Put(\"wheelListFont\", wheelListFont)";
Debug.ShouldStop(4);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("wheelListFont")),(Object)((f._wheellistfont)));
 };
 BA.debugLineNum = 38;BA.debugLine="If kvs2.ContainsKey(\"showApps\") Then";
Debug.ShouldStop(32);
if (f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("showApps"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 39;BA.debugLine="showApps = kvs2.Get(\"showApps\")";
Debug.ShouldStop(64);
f._showapps = BA.numberCast(int.class, f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("showApps"))));
 }else {
 BA.debugLineNum = 41;BA.debugLine="kvs2.Put(\"showApps\", showApps)";
Debug.ShouldStop(256);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("showApps")),(Object)((f._showapps)));
 };
 BA.debugLineNum = 44;BA.debugLine="If kvs2.ContainsKey(\"fontzSize\") Then";
Debug.ShouldStop(2048);
if (f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("fontzSize"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 45;BA.debugLine="fontzSize = kvs2.Get(\"fontzSize\")";
Debug.ShouldStop(4096);
f._fontzsize = BA.numberCast(int.class, f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("fontzSize"))));
 }else {
 BA.debugLineNum = 47;BA.debugLine="kvs2.Put(\"fontzSize\", fontzSize)";
Debug.ShouldStop(16384);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("fontzSize")),(Object)((f._fontzsize)));
 };
 BA.debugLineNum = 50;BA.debugLine="If kvs2.ContainsKey(\"bojaFonta\") Then";
Debug.ShouldStop(131072);
if (f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("bojaFonta"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 51;BA.debugLine="bojaFonta = kvs2.Get(\"bojaFonta\")";
Debug.ShouldStop(262144);
f._bojafonta = BA.numberCast(int.class, f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("bojaFonta"))));
 }else {
 BA.debugLineNum = 53;BA.debugLine="kvs2.Put(\"bojaFonta\", bojaFonta)";
Debug.ShouldStop(1048576);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("bojaFonta")),(Object)((f._bojafonta)));
 };
 BA.debugLineNum = 56;BA.debugLine="If kvs2.ContainsKey(\"trans\") = True Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("trans"))),f.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 57;BA.debugLine="trans = kvs2.Get(\"trans\")";
Debug.ShouldStop(16777216);
f._trans = BA.numberCast(int.class, f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("trans"))));
 }else {
 BA.debugLineNum = 59;BA.debugLine="kvs2.Put(\"trans\", trans)";
Debug.ShouldStop(67108864);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("trans")),(Object)((f._trans)));
 };
 BA.debugLineNum = 62;BA.debugLine="If kvs2.ContainsKey(\"tipIkone\") = True Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("tipIkone"))),f.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 63;BA.debugLine="tipIkone = kvs2.Get(\"tipIkone\")";
Debug.ShouldStop(1073741824);
f._tipikone = BA.numberCast(int.class, f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("tipIkone"))));
 }else {
 BA.debugLineNum = 65;BA.debugLine="kvs2.Put(\"tipIkone\", tipIkone)";
Debug.ShouldStop(1);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("tipIkone")),(Object)((f._tipikone)));
 };
 BA.debugLineNum = 68;BA.debugLine="If kvs2.ContainsKey(\"brTocaka\") = True Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("brTocaka"))),f.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 69;BA.debugLine="brTocaka = kvs2.Get(\"brTocaka\")";
Debug.ShouldStop(16);
f._brtocaka = BA.numberCast(int.class, f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("brTocaka"))));
 }else {
 BA.debugLineNum = 71;BA.debugLine="kvs2.Put(\"brTocaka\", brTocaka)";
Debug.ShouldStop(64);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("brTocaka")),(Object)((f._brtocaka)));
 };
 BA.debugLineNum = 74;BA.debugLine="If kvs2.ContainsKey(\"brStranica\") = True Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("brStranica"))),f.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 75;BA.debugLine="brStranica = kvs2.Get(\"brStranica\")";
Debug.ShouldStop(1024);
f._brstranica = BA.numberCast(int.class, f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("brStranica"))));
 }else {
 BA.debugLineNum = 77;BA.debugLine="kvs2.Put(\"brStranica\", brStranica)";
Debug.ShouldStop(4096);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("brStranica")),(Object)((f._brstranica)));
 };
 BA.debugLineNum = 80;BA.debugLine="If kvs2.ContainsKey(\"animStr\") = True Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("animStr"))),f.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 81;BA.debugLine="animStr = kvs2.Get(\"animStr\")";
Debug.ShouldStop(65536);
f._animstr = BA.ObjectToString(f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("animStr"))));
 }else {
 BA.debugLineNum = 83;BA.debugLine="kvs2.Put(\"animStr\", animStr)";
Debug.ShouldStop(262144);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("animStr")),(Object)((f._animstr)));
 };
 BA.debugLineNum = 86;BA.debugLine="If kvs2.ContainsKey(\"sms_dani\") = True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_containskey",(Object)(RemoteObject.createImmutable("sms_dani"))),f.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 87;BA.debugLine="sms_dani = kvs2.Get(\"sms_dani\")";
Debug.ShouldStop(4194304);
f._sms_dani = BA.numberCast(int.class, f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(RemoteObject.createImmutable("sms_dani"))));
 }else {
 BA.debugLineNum = 89;BA.debugLine="kvs2.Put(\"sms_dani\", sms_dani)";
Debug.ShouldStop(16777216);
f._kvs2.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(BA.ObjectToString("sms_dani")),(Object)((f._sms_dani)));
 };
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}