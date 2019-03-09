
package com.no3dlauncher;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class f implements IRemote{
	public static f mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public f() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, f.class);
    static {
		mostCurrent = new f();
        remoteMe = RemoteObject.declareNull("com.no3dlauncher.f");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("f"), "com.no3dlauncher.f");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("com.no3dlauncher.f"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _kvs2 = RemoteObject.declareNull("com.no3dlauncher.keyvaluestore");
public static RemoteObject _bojapozadine = RemoteObject.createImmutable(0);
public static RemoteObject _wheellistfont = RemoteObject.createImmutable("");
public static RemoteObject _showapps = RemoteObject.createImmutable(0);
public static RemoteObject _fontzsize = RemoteObject.createImmutable(0);
public static RemoteObject _bojafonta = RemoteObject.createImmutable(0);
public static RemoteObject _trans = RemoteObject.createImmutable(0);
public static RemoteObject _tipikone = RemoteObject.createImmutable(0);
public static RemoteObject _brtocaka = RemoteObject.createImmutable(0);
public static RemoteObject _brstranica = RemoteObject.createImmutable(0);
public static RemoteObject _animstr = RemoteObject.createImmutable("");
public static RemoteObject _sms_dani = RemoteObject.createImmutable(0);
public static com.no3dlauncher.main _main = null;
public static com.no3dlauncher.starter _starter = null;
public static com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public static com.no3dlauncher.search _search = null;
public static com.no3dlauncher.notificationservice _notificationservice = null;
public static com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public static com.no3dlauncher.provjera _provjera = null;
  public Object[] GetGlobals() {
		return new Object[] {"animStr",f._animstr,"bojaFonta",f._bojafonta,"bojaPozadine",f._bojapozadine,"brStranica",f._brstranica,"brTocaka",f._brtocaka,"fontzSize",f._fontzsize,"kvs2",f._kvs2,"Main",Debug.moduleToString(com.no3dlauncher.main.class),"NotificationService",Debug.moduleToString(com.no3dlauncher.notificationservice.class),"pnlmeni_postavke",Debug.moduleToString(com.no3dlauncher.pnlmeni_postavke.class),"postavke_kontakti",Debug.moduleToString(com.no3dlauncher.postavke_kontakti.class),"provjera",Debug.moduleToString(com.no3dlauncher.provjera.class),"search",Debug.moduleToString(com.no3dlauncher.search.class),"showApps",f._showapps,"sms_dani",f._sms_dani,"Starter",Debug.moduleToString(com.no3dlauncher.starter.class),"tipIkone",f._tipikone,"trans",f._trans,"wheelListFont",f._wheellistfont};
}
}