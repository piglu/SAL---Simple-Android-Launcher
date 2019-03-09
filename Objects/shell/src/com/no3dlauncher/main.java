
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "com.no3dlauncher.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _nativeme = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _smartwidgets = RemoteObject.declareNull("com.rootsoft.rssmartwidgets.RSSmartWidgets");
public static RemoteObject _tajmer1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _cu = RemoteObject.declareNull("com.no3dlauncher.contactsutils");
public static RemoteObject _pnldock = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btndock = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _scvdock = RemoteObject.declareNull("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
public static RemoteObject _pnl_dock_vidljiv = RemoteObject.createImmutable(false);
public static RemoteObject _btnmeni = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnwidgeti = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _pnlmeni = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _zadnja_oznacena_app = RemoteObject.createImmutable(0);
public static RemoteObject _wp1 = RemoteObject.declareNull("wheelpickerwrapper.wheelpickerWrapper");
public static RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _l1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _clv = RemoteObject.declareNull("com.no3dlauncher.customlistview");
public static RemoteObject _lblimeapp = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _ivapp = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _ivdodaj = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _ivwheeldodaj = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _iv_size = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _listafavorita = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
public static RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _btnsearch = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnpostavke = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnnotify = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _sv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _tabstrip1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabStripViewPager");
public static RemoteObject _topw = RemoteObject.createImmutable(0);
public static RemoteObject _customlistview1 = RemoteObject.declareNull("com.no3dlauncher.customlistview");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _ipsilon = RemoteObject.createImmutable(0);
public static RemoteObject _btndodajwidget = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btndodajstr = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnnatrag = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btnnaprijed = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cr = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper");
public static RemoteObject _btnpostavkekontakti = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _pnlkontakti = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _grid = RemoteObject.declareNull("njdude.customgridview.library.customgridview");
public static com.no3dlauncher.starter _starter = null;
public static com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public static com.no3dlauncher.search _search = null;
public static com.no3dlauncher.notificationservice _notificationservice = null;
public static com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public static com.no3dlauncher.f _f = null;
public static com.no3dlauncher.provjera _provjera = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"btnDock",main.mostCurrent._btndock,"btnDodajStr",main.mostCurrent._btndodajstr,"btnDodajWidget",main.mostCurrent._btndodajwidget,"btnMeni",main.mostCurrent._btnmeni,"btnNaprijed",main.mostCurrent._btnnaprijed,"btnNatrag",main.mostCurrent._btnnatrag,"btnNotify",main.mostCurrent._btnnotify,"btnPostavke",main.mostCurrent._btnpostavke,"btnPostavkeKontakti",main.mostCurrent._btnpostavkekontakti,"btnSearch",main.mostCurrent._btnsearch,"btnWidgeti",main.mostCurrent._btnwidgeti,"clv",main.mostCurrent._clv,"cr",main.mostCurrent._cr,"cu",main._cu,"CustomListView1",main.mostCurrent._customlistview1,"f",Debug.moduleToString(com.no3dlauncher.f.class),"grid",main.mostCurrent._grid,"ipsilon",main._ipsilon,"iv_size",main.mostCurrent._iv_size,"ivApp",main.mostCurrent._ivapp,"ivDodaj",main.mostCurrent._ivdodaj,"ivWheelDodaj",main.mostCurrent._ivwheeldodaj,"l",main.mostCurrent._l,"l1",main.mostCurrent._l1,"Label1",main.mostCurrent._label1,"lbl",main.mostCurrent._lbl,"lblImeApp",main.mostCurrent._lblimeapp,"listaFavorita",main.mostCurrent._listafavorita,"nativeMe",main._nativeme,"NotificationService",Debug.moduleToString(com.no3dlauncher.notificationservice.class),"Panel1",main.mostCurrent._panel1,"pnl_dock_vidljiv",main._pnl_dock_vidljiv,"pnlDock",main.mostCurrent._pnldock,"pnlKontakti",main.mostCurrent._pnlkontakti,"pnlMeni",main.mostCurrent._pnlmeni,"pnlmeni_postavke",Debug.moduleToString(com.no3dlauncher.pnlmeni_postavke.class),"postavke_kontakti",Debug.moduleToString(com.no3dlauncher.postavke_kontakti.class),"provjera",Debug.moduleToString(com.no3dlauncher.provjera.class),"scvDock",main.mostCurrent._scvdock,"search",Debug.moduleToString(com.no3dlauncher.search.class),"SmartWidgets",main._smartwidgets,"Starter",Debug.moduleToString(com.no3dlauncher.starter.class),"sv",main.mostCurrent._sv,"TabStrip1",main.mostCurrent._tabstrip1,"tajmer1",main._tajmer1,"topW",main._topw,"wp1",main.mostCurrent._wp1,"zadnja_oznacena_app",main._zadnja_oznacena_app};
}
}