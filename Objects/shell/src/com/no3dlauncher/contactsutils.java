
package com.no3dlauncher;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class contactsutils {
    public static RemoteObject myClass;
	public contactsutils() {
	}
    public static PCBA staticBA = new PCBA(null, contactsutils.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _mailtypes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _phonetypes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _eventtypes = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _cr = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper");
public static RemoteObject _datauri = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
public static RemoteObject _contacturi = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
public static RemoteObject _rawcontacturi = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
public static RemoteObject _groupsources = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static com.no3dlauncher.main _main = null;
public static com.no3dlauncher.starter _starter = null;
public static com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public static com.no3dlauncher.search _search = null;
public static com.no3dlauncher.notificationservice _notificationservice = null;
public static com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public static com.no3dlauncher.f _f = null;
public static com.no3dlauncher.provjera _provjera = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"contactUri",_ref.getField(false, "_contacturi"),"cr",_ref.getField(false, "_cr"),"dataUri",_ref.getField(false, "_datauri"),"eventTypes",_ref.getField(false, "_eventtypes"),"GroupSources",_ref.getField(false, "_groupsources"),"mailTypes",_ref.getField(false, "_mailtypes"),"phoneTypes",_ref.getField(false, "_phonetypes"),"rawContactUri",_ref.getField(false, "_rawcontacturi")};
}
}