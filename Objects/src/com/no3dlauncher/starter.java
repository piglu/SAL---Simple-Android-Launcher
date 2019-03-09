package com.no3dlauncher;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "com.no3dlauncher", "com.no3dlauncher.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "com.no3dlauncher.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (starter) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.collections.Map _mapa = null;
public static anywheresoftware.b4a.objects.collections.List _listaslova = null;
public com.no3dlauncher.main _main = null;
public com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public com.no3dlauncher.search _search = null;
public com.no3dlauncher.notificationservice _notificationservice = null;
public com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public com.no3dlauncher.f _f = null;
public com.no3dlauncher.provjera _provjera = null;
public static String  _getinstalledapps() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "getinstalledapps"))
	return (String) Debug.delegate(processBA, "getinstalledapps", null);
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.objects.collections.List _packages = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
int _i = 0;
String _p = "";
String _appname = "";
anywheresoftware.b4a.objects.collections.Map _mtemp = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Private Sub GetInstalledApps";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Dim pm As PackageManager  'phone library";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Dim packages As List";
_packages = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="mapa.Initialize";
_mapa.Initialize();
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="mapa.Clear";
_mapa.Clear();
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="Log(\"starter: \" & mapa.Size)";
anywheresoftware.b4a.keywords.Common.Log("starter: "+BA.NumberToString(_mapa.getSize()));
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="listaSlova.Initialize";
_listaslova.Initialize();
RDebugUtils.currentLine=4063241;
 //BA.debugLineNum = 4063241;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="packages = pm.GetInstalledPackages";
_packages = _pm.GetInstalledPackages();
RDebugUtils.currentLine=4063245;
 //BA.debugLineNum = 4063245;BA.debugLine="For i = 0 To packages.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_packages.getSize()-1);
_i = (int) (0) ;
for (;(step10 > 0 && _i <= limit10) || (step10 < 0 && _i >= limit10) ;_i = ((int)(0 + _i + step10))  ) {
RDebugUtils.currentLine=4063246;
 //BA.debugLineNum = 4063246;BA.debugLine="Dim p As String = packages.Get(i)";
_p = BA.ObjectToString(_packages.Get(_i));
RDebugUtils.currentLine=4063247;
 //BA.debugLineNum = 4063247;BA.debugLine="Dim AppName As String = pm.GetApplicationLabel(p";
_appname = _pm.GetApplicationLabel(_p);
RDebugUtils.currentLine=4063248;
 //BA.debugLineNum = 4063248;BA.debugLine="If pm.GetApplicationIntent(p).IsInitialized Then";
if (_pm.GetApplicationIntent(_p).IsInitialized()) { 
RDebugUtils.currentLine=4063249;
 //BA.debugLineNum = 4063249;BA.debugLine="listaSlova.Add(AppName.SubString2(0, 1).ToUpper";
_listaslova.Add((Object)(_appname.substring((int) (0),(int) (1)).toUpperCase()));
RDebugUtils.currentLine=4063250;
 //BA.debugLineNum = 4063250;BA.debugLine="mapa.Put(AppName & \";\" & packages.Get(i), i)";
_mapa.Put((Object)(_appname+";"+BA.ObjectToString(_packages.Get(_i))),(Object)(_i));
 };
 }
};
RDebugUtils.currentLine=4063266;
 //BA.debugLineNum = 4063266;BA.debugLine="Dim mTemp As Map";
_mtemp = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4063267;
 //BA.debugLineNum = 4063267;BA.debugLine="mTemp.Initialize";
_mtemp.Initialize();
RDebugUtils.currentLine=4063268;
 //BA.debugLineNum = 4063268;BA.debugLine="For i = 0 To listaSlova.Size - 1";
{
final int step20 = 1;
final int limit20 = (int) (_listaslova.getSize()-1);
_i = (int) (0) ;
for (;(step20 > 0 && _i <= limit20) || (step20 < 0 && _i >= limit20) ;_i = ((int)(0 + _i + step20))  ) {
RDebugUtils.currentLine=4063269;
 //BA.debugLineNum = 4063269;BA.debugLine="mTemp.Put(listaSlova.Get(i), i)";
_mtemp.Put(_listaslova.Get(_i),(Object)(_i));
 }
};
RDebugUtils.currentLine=4063271;
 //BA.debugLineNum = 4063271;BA.debugLine="listaSlova.Clear";
_listaslova.Clear();
RDebugUtils.currentLine=4063272;
 //BA.debugLineNum = 4063272;BA.debugLine="For i = 0 To mTemp.Size - 1";
{
final int step24 = 1;
final int limit24 = (int) (_mtemp.getSize()-1);
_i = (int) (0) ;
for (;(step24 > 0 && _i <= limit24) || (step24 < 0 && _i >= limit24) ;_i = ((int)(0 + _i + step24))  ) {
RDebugUtils.currentLine=4063273;
 //BA.debugLineNum = 4063273;BA.debugLine="listaSlova.Add(mTemp.GetKeyAt(i))";
_listaslova.Add(_mtemp.GetKeyAt(_i));
 }
};
RDebugUtils.currentLine=4063275;
 //BA.debugLineNum = 4063275;BA.debugLine="listaSlova.Sort(True)";
_listaslova.Sort(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063277;
 //BA.debugLineNum = 4063277;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4063278;
 //BA.debugLineNum = 4063278;BA.debugLine="m = SortMapKeys(mapa, True)";
_m = _sortmapkeys(_mapa,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063279;
 //BA.debugLineNum = 4063279;BA.debugLine="mapa = m";
_mapa = _m;
RDebugUtils.currentLine=4063280;
 //BA.debugLineNum = 4063280;BA.debugLine="End Sub";
return "";
}
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "application_error"))
	return (Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace});
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="End Sub";
return false;
}
public static anywheresoftware.b4a.objects.collections.Map  _sortmapkeys(anywheresoftware.b4a.objects.collections.Map _m,boolean _sortasc) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "sortmapkeys"))
	return (anywheresoftware.b4a.objects.collections.Map) Debug.delegate(processBA, "sortmapkeys", new Object[] {_m,_sortasc});
anywheresoftware.b4a.objects.collections.List _keyslist = null;
anywheresoftware.b4a.objects.collections.Map _m2 = null;
int _i = 0;
String _key = "";
int _x = 0;
Object _val = null;
String _m2key = "";
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub SortMapKeys (m As Map, SortAsc As Boolean) As";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Private KeysList As List:KeysList.Initialize";
_keyslist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="Private KeysList As List:KeysList.Initialize";
_keyslist.Initialize();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="Private m2 As Map:m2.Initialize";
_m2 = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="Private m2 As Map:m2.Initialize";
_m2.Initialize();
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="For i = 0 To m.Size - 1";
{
final int step5 = 1;
final int limit5 = (int) (_m.getSize()-1);
_i = (int) (0) ;
for (;(step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5) ;_i = ((int)(0 + _i + step5))  ) {
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="Private key As String = m.GetKeyAt(i)";
_key = BA.ObjectToString(_m.GetKeyAt(_i));
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="KeysList.Add(key)";
_keyslist.Add((Object)(_key));
 }
};
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="KeysList.Sort(SortAsc)";
_keyslist.Sort(_sortasc);
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="For x = 0 To KeysList.Size - 1";
{
final int step10 = 1;
final int limit10 = (int) (_keyslist.getSize()-1);
_x = (int) (0) ;
for (;(step10 > 0 && _x <= limit10) || (step10 < 0 && _x >= limit10) ;_x = ((int)(0 + _x + step10))  ) {
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="Private key As String = KeysList.Get(x)";
_key = BA.ObjectToString(_keyslist.Get(_x));
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="Private val As Object = m.Get(key)";
_val = _m.Get((Object)(_key));
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="m2.Put(key, val)";
_m2.Put((Object)(_key),_val);
 }
};
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="m.Clear";
_m.Clear();
RDebugUtils.currentLine=4128785;
 //BA.debugLineNum = 4128785;BA.debugLine="For Each m2Key As String In m2.Keys";
{
final anywheresoftware.b4a.BA.IterableList group16 = _m2.Keys();
final int groupLen16 = group16.getSize()
;int index16 = 0;
;
for (; index16 < groupLen16;index16++){
_m2key = BA.ObjectToString(group16.Get(index16));
RDebugUtils.currentLine=4128786;
 //BA.debugLineNum = 4128786;BA.debugLine="m.Put(m2Key, m2.Get(m2Key))";
_m.Put((Object)(_m2key),_m2.Get((Object)(_m2key)));
 }
};
RDebugUtils.currentLine=4128789;
 //BA.debugLineNum = 4128789;BA.debugLine="Return m";
if (true) return _m;
RDebugUtils.currentLine=4128790;
 //BA.debugLineNum = 4128790;BA.debugLine="End Sub";
return null;
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="f.InitKVS2";
mostCurrent._f._initkvs2(processBA);
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="f.UcitajVrijednostiOpt";
mostCurrent._f._ucitajvrijednostiopt(processBA);
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="GetInstalledApps";
_getinstalledapps();
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate(processBA, "service_taskremoved"))
	return (String) Debug.delegate(processBA, "service_taskremoved", null);
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub Service_TaskRemoved";
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="End Sub";
return "";
}
}