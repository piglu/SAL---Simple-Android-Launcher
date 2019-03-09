package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,33);
if (RapidSub.canDelegate("application_error")) return com.no3dlauncher.starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 33;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="Return True";
Debug.ShouldStop(2);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getinstalledapps() throws Exception{
try {
		Debug.PushSubsStack("GetInstalledApps (starter) ","starter",1,starter.processBA,starter.mostCurrent,41);
if (RapidSub.canDelegate("getinstalledapps")) return com.no3dlauncher.starter.remoteMe.runUserSub(false, "starter","getinstalledapps");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _packages = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
int _i = 0;
RemoteObject _p = RemoteObject.createImmutable("");
RemoteObject _appname = RemoteObject.createImmutable("");
RemoteObject _mtemp = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 41;BA.debugLine="Private Sub GetInstalledApps";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="Dim pm As PackageManager  'phone library";
Debug.ShouldStop(512);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 43;BA.debugLine="Dim packages As List";
Debug.ShouldStop(1024);
_packages = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("packages", _packages);
 BA.debugLineNum = 44;BA.debugLine="Dim jo As JavaObject";
Debug.ShouldStop(2048);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("jo", _jo);
 BA.debugLineNum = 46;BA.debugLine="mapa.Initialize";
Debug.ShouldStop(8192);
starter._mapa.runVoidMethod ("Initialize");
 BA.debugLineNum = 47;BA.debugLine="mapa.Clear";
Debug.ShouldStop(16384);
starter._mapa.runVoidMethod ("Clear");
 BA.debugLineNum = 48;BA.debugLine="Log(\"starter: \" & mapa.Size)";
Debug.ShouldStop(32768);
starter.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("starter: "),starter._mapa.runMethod(true,"getSize"))));
 BA.debugLineNum = 49;BA.debugLine="listaSlova.Initialize";
Debug.ShouldStop(65536);
starter._listaslova.runVoidMethod ("Initialize");
 BA.debugLineNum = 50;BA.debugLine="jo.InitializeContext";
Debug.ShouldStop(131072);
_jo.runVoidMethod ("InitializeContext",starter.processBA);
 BA.debugLineNum = 52;BA.debugLine="packages = pm.GetInstalledPackages";
Debug.ShouldStop(524288);
_packages = _pm.runMethod(false,"GetInstalledPackages");Debug.locals.put("packages", _packages);
 BA.debugLineNum = 54;BA.debugLine="For i = 0 To packages.Size - 1";
Debug.ShouldStop(2097152);
{
final int step10 = 1;
final int limit10 = RemoteObject.solve(new RemoteObject[] {_packages.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 55;BA.debugLine="Dim p As String = packages.Get(i)";
Debug.ShouldStop(4194304);
_p = BA.ObjectToString(_packages.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 56;BA.debugLine="Dim AppName As String = pm.GetApplicationLabel(p";
Debug.ShouldStop(8388608);
_appname = _pm.runMethod(true,"GetApplicationLabel",(Object)(_p));Debug.locals.put("AppName", _appname);Debug.locals.put("AppName", _appname);
 BA.debugLineNum = 57;BA.debugLine="If pm.GetApplicationIntent(p).IsInitialized Then";
Debug.ShouldStop(16777216);
if (_pm.runMethod(false,"GetApplicationIntent",(Object)(_p)).runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 58;BA.debugLine="listaSlova.Add(AppName.SubString2(0, 1).ToUpper";
Debug.ShouldStop(33554432);
starter._listaslova.runVoidMethod ("Add",(Object)((_appname.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 1))).runMethod(true,"toUpperCase"))));
 BA.debugLineNum = 59;BA.debugLine="mapa.Put(AppName & \";\" & packages.Get(i), i)";
Debug.ShouldStop(67108864);
starter._mapa.runVoidMethod ("Put",(Object)((RemoteObject.concat(_appname,RemoteObject.createImmutable(";"),_packages.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))))),(Object)(RemoteObject.createImmutable((_i))));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 75;BA.debugLine="Dim mTemp As Map";
Debug.ShouldStop(1024);
_mtemp = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("mTemp", _mtemp);
 BA.debugLineNum = 76;BA.debugLine="mTemp.Initialize";
Debug.ShouldStop(2048);
_mtemp.runVoidMethod ("Initialize");
 BA.debugLineNum = 77;BA.debugLine="For i = 0 To listaSlova.Size - 1";
Debug.ShouldStop(4096);
{
final int step20 = 1;
final int limit20 = RemoteObject.solve(new RemoteObject[] {starter._listaslova.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step20 > 0 && _i <= limit20) || (step20 < 0 && _i >= limit20) ;_i = ((int)(0 + _i + step20))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 78;BA.debugLine="mTemp.Put(listaSlova.Get(i), i)";
Debug.ShouldStop(8192);
_mtemp.runVoidMethod ("Put",(Object)(starter._listaslova.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))),(Object)(RemoteObject.createImmutable((_i))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 80;BA.debugLine="listaSlova.Clear";
Debug.ShouldStop(32768);
starter._listaslova.runVoidMethod ("Clear");
 BA.debugLineNum = 81;BA.debugLine="For i = 0 To mTemp.Size - 1";
Debug.ShouldStop(65536);
{
final int step24 = 1;
final int limit24 = RemoteObject.solve(new RemoteObject[] {_mtemp.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step24 > 0 && _i <= limit24) || (step24 < 0 && _i >= limit24) ;_i = ((int)(0 + _i + step24))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 82;BA.debugLine="listaSlova.Add(mTemp.GetKeyAt(i))";
Debug.ShouldStop(131072);
starter._listaslova.runVoidMethod ("Add",(Object)(_mtemp.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 84;BA.debugLine="listaSlova.Sort(True)";
Debug.ShouldStop(524288);
starter._listaslova.runVoidMethod ("Sort",(Object)(starter.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 86;BA.debugLine="Dim m As Map";
Debug.ShouldStop(2097152);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 87;BA.debugLine="m = SortMapKeys(mapa, True)";
Debug.ShouldStop(4194304);
_m = _sortmapkeys(starter._mapa,starter.mostCurrent.__c.getField(true,"True"));Debug.locals.put("m", _m);
 BA.debugLineNum = 88;BA.debugLine="mapa = m";
Debug.ShouldStop(8388608);
starter._mapa = _m;
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim mapa As Map";
starter._mapa = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 10;BA.debugLine="Dim listaSlova As List";
starter._listaslova = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,16);
if (RapidSub.canDelegate("service_create")) return com.no3dlauncher.starter.remoteMe.runUserSub(false, "starter","service_create");
 BA.debugLineNum = 16;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(32768);
 BA.debugLineNum = 19;BA.debugLine="f.InitKVS2";
Debug.ShouldStop(262144);
starter.mostCurrent._f.runVoidMethod ("_initkvs2",starter.processBA);
 BA.debugLineNum = 20;BA.debugLine="f.UcitajVrijednostiOpt";
Debug.ShouldStop(524288);
starter.mostCurrent._f.runVoidMethod ("_ucitajvrijednostiopt",starter.processBA);
 BA.debugLineNum = 21;BA.debugLine="GetInstalledApps";
Debug.ShouldStop(1048576);
_getinstalledapps();
 BA.debugLineNum = 22;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
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
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,37);
if (RapidSub.canDelegate("service_destroy")) return com.no3dlauncher.starter.remoteMe.runUserSub(false, "starter","service_destroy");
 BA.debugLineNum = 37;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(16);
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
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,24);
if (RapidSub.canDelegate("service_start")) return com.no3dlauncher.starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 24;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_taskremoved() throws Exception{
try {
		Debug.PushSubsStack("Service_TaskRemoved (starter) ","starter",1,starter.processBA,starter.mostCurrent,28);
if (RapidSub.canDelegate("service_taskremoved")) return com.no3dlauncher.starter.remoteMe.runUserSub(false, "starter","service_taskremoved");
 BA.debugLineNum = 28;BA.debugLine="Sub Service_TaskRemoved";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sortmapkeys(RemoteObject _m,RemoteObject _sortasc) throws Exception{
try {
		Debug.PushSubsStack("SortMapKeys (starter) ","starter",1,starter.processBA,starter.mostCurrent,100);
if (RapidSub.canDelegate("sortmapkeys")) return com.no3dlauncher.starter.remoteMe.runUserSub(false, "starter","sortmapkeys", _m, _sortasc);
RemoteObject _keyslist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _m2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
RemoteObject _key = RemoteObject.createImmutable("");
int _x = 0;
RemoteObject _val = RemoteObject.declareNull("Object");
RemoteObject _m2key = RemoteObject.createImmutable("");
Debug.locals.put("m", _m);
Debug.locals.put("SortAsc", _sortasc);
 BA.debugLineNum = 100;BA.debugLine="Sub SortMapKeys (m As Map, SortAsc As Boolean) As";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="Private KeysList As List:KeysList.Initialize";
Debug.ShouldStop(16);
_keyslist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("KeysList", _keyslist);
 BA.debugLineNum = 101;BA.debugLine="Private KeysList As List:KeysList.Initialize";
Debug.ShouldStop(16);
_keyslist.runVoidMethod ("Initialize");
 BA.debugLineNum = 102;BA.debugLine="Private m2 As Map:m2.Initialize";
Debug.ShouldStop(32);
_m2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m2", _m2);
 BA.debugLineNum = 102;BA.debugLine="Private m2 As Map:m2.Initialize";
Debug.ShouldStop(32);
_m2.runVoidMethod ("Initialize");
 BA.debugLineNum = 104;BA.debugLine="For i = 0 To m.Size - 1";
Debug.ShouldStop(128);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_m.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 105;BA.debugLine="Private key As String = m.GetKeyAt(i)";
Debug.ShouldStop(256);
_key = BA.ObjectToString(_m.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 106;BA.debugLine="KeysList.Add(key)";
Debug.ShouldStop(512);
_keyslist.runVoidMethod ("Add",(Object)((_key)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 109;BA.debugLine="KeysList.Sort(SortAsc)";
Debug.ShouldStop(4096);
_keyslist.runVoidMethod ("Sort",(Object)(_sortasc));
 BA.debugLineNum = 111;BA.debugLine="For x = 0 To KeysList.Size - 1";
Debug.ShouldStop(16384);
{
final int step10 = 1;
final int limit10 = RemoteObject.solve(new RemoteObject[] {_keyslist.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_x = 0 ;
for (;(step10 > 0 && _x <= limit10) || (step10 < 0 && _x >= limit10) ;_x = ((int)(0 + _x + step10))  ) {
Debug.locals.put("x", _x);
 BA.debugLineNum = 112;BA.debugLine="Private key As String = KeysList.Get(x)";
Debug.ShouldStop(32768);
_key = BA.ObjectToString(_keyslist.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _x))));Debug.locals.put("key", _key);Debug.locals.put("key", _key);
 BA.debugLineNum = 113;BA.debugLine="Private val As Object = m.Get(key)";
Debug.ShouldStop(65536);
_val = _m.runMethod(false,"Get",(Object)((_key)));Debug.locals.put("val", _val);Debug.locals.put("val", _val);
 BA.debugLineNum = 114;BA.debugLine="m2.Put(key, val)";
Debug.ShouldStop(131072);
_m2.runVoidMethod ("Put",(Object)((_key)),(Object)(_val));
 }
}Debug.locals.put("x", _x);
;
 BA.debugLineNum = 116;BA.debugLine="m.Clear";
Debug.ShouldStop(524288);
_m.runVoidMethod ("Clear");
 BA.debugLineNum = 117;BA.debugLine="For Each m2Key As String In m2.Keys";
Debug.ShouldStop(1048576);
{
final RemoteObject group16 = _m2.runMethod(false,"Keys");
final int groupLen16 = group16.runMethod(true,"getSize").<Integer>get()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_m2key = BA.ObjectToString(group16.runMethod(false,"Get",index16));Debug.locals.put("m2Key", _m2key);
Debug.locals.put("m2Key", _m2key);
 BA.debugLineNum = 118;BA.debugLine="m.Put(m2Key, m2.Get(m2Key))";
Debug.ShouldStop(2097152);
_m.runVoidMethod ("Put",(Object)((_m2key)),(Object)(_m2.runMethod(false,"Get",(Object)((_m2key)))));
 }
}Debug.locals.put("m2Key", _m2key);
;
 BA.debugLineNum = 121;BA.debugLine="Return m";
Debug.ShouldStop(16777216);
if (true) return _m;
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}