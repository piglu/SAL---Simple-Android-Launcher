
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

public class postavke_kontakti implements IRemote{
	public static postavke_kontakti mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public postavke_kontakti() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("postavke_kontakti"), "com.no3dlauncher.postavke_kontakti");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, postavke_kontakti.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _edittext1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static com.no3dlauncher.main _main = null;
public static com.no3dlauncher.starter _starter = null;
public static com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public static com.no3dlauncher.search _search = null;
public static com.no3dlauncher.notificationservice _notificationservice = null;
public static com.no3dlauncher.f _f = null;
public static com.no3dlauncher.provjera _provjera = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",postavke_kontakti.mostCurrent._activity,"EditText1",postavke_kontakti.mostCurrent._edittext1,"f",Debug.moduleToString(com.no3dlauncher.f.class),"Main",Debug.moduleToString(com.no3dlauncher.main.class),"NotificationService",Debug.moduleToString(com.no3dlauncher.notificationservice.class),"pnlmeni_postavke",Debug.moduleToString(com.no3dlauncher.pnlmeni_postavke.class),"provjera",Debug.moduleToString(com.no3dlauncher.provjera.class),"search",Debug.moduleToString(com.no3dlauncher.search.class),"Starter",Debug.moduleToString(com.no3dlauncher.starter.class)};
}
}