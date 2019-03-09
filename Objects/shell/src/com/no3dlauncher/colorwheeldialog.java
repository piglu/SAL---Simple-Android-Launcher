
package com.no3dlauncher;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class colorwheeldialog {
    public static RemoteObject myClass;
	public colorwheeldialog() {
	}
    public static PCBA staticBA = new PCBA(null, colorwheeldialog.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _dialog = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog");
public static RemoteObject _cvscolors = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
public static RemoteObject _cvsoverlay = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
public static RemoteObject _pnlcolors = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnloverlay = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _colorresult = RemoteObject.createImmutable(0);
public static com.no3dlauncher.main _main = null;
public static com.no3dlauncher.starter _starter = null;
public static com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public static com.no3dlauncher.search _search = null;
public static com.no3dlauncher.notificationservice _notificationservice = null;
public static com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public static com.no3dlauncher.f _f = null;
public static com.no3dlauncher.provjera _provjera = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"ColorResult",_ref.getField(false, "_colorresult"),"cvsColors",_ref.getField(false, "_cvscolors"),"cvsOverlay",_ref.getField(false, "_cvsoverlay"),"dialog",_ref.getField(false, "_dialog"),"pnlColors",_ref.getField(false, "_pnlcolors"),"pnlOverlay",_ref.getField(false, "_pnloverlay")};
}
}