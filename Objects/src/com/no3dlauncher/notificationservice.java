package com.no3dlauncher;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class notificationservice extends  android.app.Service{
	public static class notificationservice_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (notificationservice) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, notificationservice.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, anywheresoftware.b4a.ShellBA.class);
		}

	}
    static notificationservice mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return notificationservice.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "com.no3dlauncher", "com.no3dlauncher.notificationservice");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "com.no3dlauncher.notificationservice", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (notificationservice) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
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
                    BA.LogInfo("** Service (notificationservice) Create **");
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
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (notificationservice) Start **");
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
        BA.LogInfo("** Service (notificationservice) Destroy **");
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
public static anywheresoftware.b4a.objects.NotificationListenerWrapper.NotificationListener _listener = null;
public static int _brojnotifikacija = 0;
public com.no3dlauncher.main _main = null;
public com.no3dlauncher.starter _starter = null;
public com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public com.no3dlauncher.search _search = null;
public com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public com.no3dlauncher.f _f = null;
public com.no3dlauncher.provjera _provjera = null;
public static String  _clearall() throws Exception{
RDebugUtils.currentModule="notificationservice";
if (Debug.shouldDelegate(processBA, "clearall"))
	return (String) Debug.delegate(processBA, "clearall", null);
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub ClearAll";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="listener.ClearAll";
_listener.ClearAll();
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="End Sub";
return "";
}
public static String  _getactive() throws Exception{
RDebugUtils.currentModule="notificationservice";
if (Debug.shouldDelegate(processBA, "getactive"))
	return (String) Debug.delegate(processBA, "getactive", null);
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub GetActive";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="listener.GetActiveNotifications";
_listener.GetActiveNotifications();
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="End Sub";
return "";
}
public static String  _listener_notificationposted(anywheresoftware.b4a.objects.NotificationListenerWrapper.StatusBarNotificationWrapper _sbn) throws Exception{
RDebugUtils.currentModule="notificationservice";
if (Debug.shouldDelegate(processBA, "listener_notificationposted"))
	return (String) Debug.delegate(processBA, "listener_notificationposted", new Object[] {_sbn});
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jno = null;
anywheresoftware.b4j.object.JavaObject _extras = null;
String _title = "";
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Sub Listener_NotificationPosted (SBN As StatusBarN";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="brojNotifikacija = brojNotifikacija + 1";
_brojnotifikacija = (int) (_brojnotifikacija+1);
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="Log(\"NotificationPosted, package = \" & SBN.Packag";
anywheresoftware.b4a.keywords.Common.Log("NotificationPosted, package = "+_sbn.getPackageName()+", id = "+BA.NumberToString(_sbn.getId())+", text = "+_sbn.getTickerText());
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="If p.SdkVersion >= 19 Then";
if (_p.getSdkVersion()>=19) { 
RDebugUtils.currentLine=6488069;
 //BA.debugLineNum = 6488069;BA.debugLine="Dim jno As JavaObject = SBN.Notification";
_jno = new anywheresoftware.b4j.object.JavaObject();
_jno.setObject((java.lang.Object)(_sbn.getNotification().getObject()));
RDebugUtils.currentLine=6488070;
 //BA.debugLineNum = 6488070;BA.debugLine="Dim extras As JavaObject = jno.GetField(\"extras\"";
_extras = new anywheresoftware.b4j.object.JavaObject();
_extras.setObject((java.lang.Object)(_jno.GetField("extras")));
RDebugUtils.currentLine=6488071;
 //BA.debugLineNum = 6488071;BA.debugLine="extras.RunMethod(\"size\", Null)";
_extras.RunMethod("size",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
RDebugUtils.currentLine=6488072;
 //BA.debugLineNum = 6488072;BA.debugLine="Log(extras)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(_extras));
RDebugUtils.currentLine=6488073;
 //BA.debugLineNum = 6488073;BA.debugLine="Dim title As String = extras.RunMethod(\"getStrin";
_title = BA.ObjectToString(_extras.RunMethod("getString",new Object[]{(Object)("android.title")}));
RDebugUtils.currentLine=6488074;
 //BA.debugLineNum = 6488074;BA.debugLine="LogColor(\"Title = \" & title, Colors.Blue)";
anywheresoftware.b4a.keywords.Common.LogColor("Title = "+_title,anywheresoftware.b4a.keywords.Common.Colors.Blue);
RDebugUtils.currentLine=6488075;
 //BA.debugLineNum = 6488075;BA.debugLine="Dim bmp As Bitmap = jno.GetField(\"largeIcon\")";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_jno.GetField("largeIcon")));
 };
RDebugUtils.currentLine=6488078;
 //BA.debugLineNum = 6488078;BA.debugLine="End Sub";
return "";
}
public static String  _listener_notificationremoved(anywheresoftware.b4a.objects.NotificationListenerWrapper.StatusBarNotificationWrapper _sbn) throws Exception{
RDebugUtils.currentModule="notificationservice";
if (Debug.shouldDelegate(processBA, "listener_notificationremoved"))
	return (String) Debug.delegate(processBA, "listener_notificationremoved", new Object[] {_sbn});
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Sub Listener_NotificationRemoved (SBN As StatusBar";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="Log(\"NotificationRemoved, package = \" & SBN.Packa";
anywheresoftware.b4a.keywords.Common.Log("NotificationRemoved, package = "+_sbn.getPackageName()+", id = "+BA.NumberToString(_sbn.getId())+", text = "+_sbn.getTickerText());
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="brojNotifikacija = brojNotifikacija - 1";
_brojnotifikacija = (int) (_brojnotifikacija-1);
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="notificationservice";
if (Debug.shouldDelegate(processBA, "service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="listener.Initialize(\"listener\")";
_listener.Initialize(processBA,"listener");
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="notificationservice";
if (Debug.shouldDelegate(processBA, "service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="notificationservice";
if (Debug.shouldDelegate(processBA, "service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="If listener.HandleIntent(StartingIntent) Then Ret";
if (_listener.HandleIntent(_startingintent)) { 
if (true) return "";};
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="End Sub";
return "";
}
}