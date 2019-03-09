
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

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "com.no3dlauncher.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("com.no3dlauncher.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _mapa = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _listaslova = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static com.no3dlauncher.main _main = null;
public static com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public static com.no3dlauncher.search _search = null;
public static com.no3dlauncher.notificationservice _notificationservice = null;
public static com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public static com.no3dlauncher.f _f = null;
public static com.no3dlauncher.provjera _provjera = null;
  public Object[] GetGlobals() {
		return new Object[] {"f",Debug.moduleToString(com.no3dlauncher.f.class),"listaSlova",starter._listaslova,"Main",Debug.moduleToString(com.no3dlauncher.main.class),"mapa",starter._mapa,"NotificationService",Debug.moduleToString(com.no3dlauncher.notificationservice.class),"pnlmeni_postavke",Debug.moduleToString(com.no3dlauncher.pnlmeni_postavke.class),"postavke_kontakti",Debug.moduleToString(com.no3dlauncher.postavke_kontakti.class),"provjera",Debug.moduleToString(com.no3dlauncher.provjera.class),"search",Debug.moduleToString(com.no3dlauncher.search.class),"Service",starter.mostCurrent._service};
}
}