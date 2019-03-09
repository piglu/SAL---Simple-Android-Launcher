
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

public class pnlmeni_postavke implements IRemote{
	public static pnlmeni_postavke mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public pnlmeni_postavke() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("pnlmeni_postavke"), "com.no3dlauncher.pnlmeni_postavke");
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
		pcBA = new PCBA(this, pnlmeni_postavke.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _spnapps = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _spnfont = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _label3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _edtfontsize = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _btnbackground = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnfont = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _sbtransparent = RemoteObject.declareNull("anywheresoftware.b4a.objects.SeekBarWrapper");
public static RemoteObject _spnicontype = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _edtnoofstarpoints = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _label7 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _edtpages = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _animacije = RemoteObject.declareNull("de.donmanfred.AnimationComposerWrapper");
public static RemoteObject _mapaanimacija = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _spnanim = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _btnenablenotifications = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static com.no3dlauncher.main _main = null;
public static com.no3dlauncher.starter _starter = null;
public static com.no3dlauncher.search _search = null;
public static com.no3dlauncher.notificationservice _notificationservice = null;
public static com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public static com.no3dlauncher.f _f = null;
public static com.no3dlauncher.provjera _provjera = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",pnlmeni_postavke.mostCurrent._activity,"animacije",pnlmeni_postavke.mostCurrent._animacije,"btnBackground",pnlmeni_postavke.mostCurrent._btnbackground,"btnEnableNotifications",pnlmeni_postavke.mostCurrent._btnenablenotifications,"btnFont",pnlmeni_postavke.mostCurrent._btnfont,"edtFontSize",pnlmeni_postavke.mostCurrent._edtfontsize,"edtNoOfStarPoints",pnlmeni_postavke.mostCurrent._edtnoofstarpoints,"edtPages",pnlmeni_postavke.mostCurrent._edtpages,"f",Debug.moduleToString(com.no3dlauncher.f.class),"Label1",pnlmeni_postavke.mostCurrent._label1,"Label3",pnlmeni_postavke.mostCurrent._label3,"Label7",pnlmeni_postavke.mostCurrent._label7,"Main",Debug.moduleToString(com.no3dlauncher.main.class),"mapaAnimacija",pnlmeni_postavke.mostCurrent._mapaanimacija,"NotificationService",Debug.moduleToString(com.no3dlauncher.notificationservice.class),"postavke_kontakti",Debug.moduleToString(com.no3dlauncher.postavke_kontakti.class),"provjera",Debug.moduleToString(com.no3dlauncher.provjera.class),"sbTransparent",pnlmeni_postavke.mostCurrent._sbtransparent,"search",Debug.moduleToString(com.no3dlauncher.search.class),"spnAnim",pnlmeni_postavke.mostCurrent._spnanim,"spnApps",pnlmeni_postavke.mostCurrent._spnapps,"spnFont",pnlmeni_postavke.mostCurrent._spnfont,"spnIconType",pnlmeni_postavke.mostCurrent._spnicontype,"Starter",Debug.moduleToString(com.no3dlauncher.starter.class)};
}
}