package com.no3dlauncher;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class contactsutils extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "com.no3dlauncher.contactsutils");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.no3dlauncher.contactsutils.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public static class _cucontact{
public boolean IsInitialized;
public long Id;
public String DisplayName;
public void Initialize() {
IsInitialized = true;
Id = 0L;
DisplayName = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _cuemail{
public boolean IsInitialized;
public String Email;
public String EmailType;
public void Initialize() {
IsInitialized = true;
Email = "";
EmailType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _cuphone{
public boolean IsInitialized;
public String Number;
public String PhoneType;
public void Initialize() {
IsInitialized = true;
Number = "";
PhoneType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _cuevent{
public boolean IsInitialized;
public String DateString;
public String EventType;
public void Initialize() {
IsInitialized = true;
DateString = "";
EventType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static class _cuorganization{
public boolean IsInitialized;
public String Company;
public String Title;
public void Initialize() {
IsInitialized = true;
Company = "";
Title = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.collections.Map _mailtypes = null;
public anywheresoftware.b4a.objects.collections.Map _phonetypes = null;
public anywheresoftware.b4a.objects.collections.Map _eventtypes = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper _cr = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _datauri = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _contacturi = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _rawcontacturi = null;
public anywheresoftware.b4a.objects.collections.Map _groupsources = null;
public anywheresoftware.b4a.objects.RuntimePermissions _rp = null;
public com.no3dlauncher.main _main = null;
public com.no3dlauncher.starter _starter = null;
public com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public com.no3dlauncher.search _search = null;
public com.no3dlauncher.notificationservice _notificationservice = null;
public com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public com.no3dlauncher.f _f = null;
public com.no3dlauncher.provjera _provjera = null;
public String  _initialize(com.no3dlauncher.contactsutils __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
RDebugUtils.currentLine=7274496;
 //BA.debugLineNum = 7274496;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=7274497;
 //BA.debugLineNum = 7274497;BA.debugLine="dataUri.Parse(\"content://com.android.contacts/dat";
__ref._datauri.Parse("content://com.android.contacts/data");
RDebugUtils.currentLine=7274498;
 //BA.debugLineNum = 7274498;BA.debugLine="contactUri.Parse(\"content://com.android.contacts/";
__ref._contacturi.Parse("content://com.android.contacts/contacts");
RDebugUtils.currentLine=7274499;
 //BA.debugLineNum = 7274499;BA.debugLine="rawContactUri.Parse(\"content://com.android.contac";
__ref._rawcontacturi.Parse("content://com.android.contacts/raw_contacts");
RDebugUtils.currentLine=7274500;
 //BA.debugLineNum = 7274500;BA.debugLine="cr.Initialize(\"cr\")";
__ref._cr.Initialize("cr");
RDebugUtils.currentLine=7274501;
 //BA.debugLineNum = 7274501;BA.debugLine="mailTypes.Initialize";
__ref._mailtypes.Initialize();
RDebugUtils.currentLine=7274502;
 //BA.debugLineNum = 7274502;BA.debugLine="mailTypes.Put(\"1\", \"home\")";
__ref._mailtypes.Put((Object)("1"),(Object)("home"));
RDebugUtils.currentLine=7274503;
 //BA.debugLineNum = 7274503;BA.debugLine="mailTypes.Put(\"2\", \"work\")";
__ref._mailtypes.Put((Object)("2"),(Object)("work"));
RDebugUtils.currentLine=7274504;
 //BA.debugLineNum = 7274504;BA.debugLine="mailTypes.Put(\"3\", \"other\")";
__ref._mailtypes.Put((Object)("3"),(Object)("other"));
RDebugUtils.currentLine=7274505;
 //BA.debugLineNum = 7274505;BA.debugLine="mailTypes.Put(\"4\", \"mobile\")";
__ref._mailtypes.Put((Object)("4"),(Object)("mobile"));
RDebugUtils.currentLine=7274507;
 //BA.debugLineNum = 7274507;BA.debugLine="phoneTypes.Initialize";
__ref._phonetypes.Initialize();
RDebugUtils.currentLine=7274508;
 //BA.debugLineNum = 7274508;BA.debugLine="phoneTypes.Put(\"1\", \"home\")";
__ref._phonetypes.Put((Object)("1"),(Object)("home"));
RDebugUtils.currentLine=7274509;
 //BA.debugLineNum = 7274509;BA.debugLine="phoneTypes.Put(\"2\", \"mobile\")";
__ref._phonetypes.Put((Object)("2"),(Object)("mobile"));
RDebugUtils.currentLine=7274510;
 //BA.debugLineNum = 7274510;BA.debugLine="phoneTypes.Put(\"3\", \"work\")";
__ref._phonetypes.Put((Object)("3"),(Object)("work"));
RDebugUtils.currentLine=7274511;
 //BA.debugLineNum = 7274511;BA.debugLine="phoneTypes.Put(\"4\", \"fax_work\")";
__ref._phonetypes.Put((Object)("4"),(Object)("fax_work"));
RDebugUtils.currentLine=7274512;
 //BA.debugLineNum = 7274512;BA.debugLine="phoneTypes.Put(\"5\", \"fax_home\")";
__ref._phonetypes.Put((Object)("5"),(Object)("fax_home"));
RDebugUtils.currentLine=7274513;
 //BA.debugLineNum = 7274513;BA.debugLine="phoneTypes.Put(\"6\", \"pager\")";
__ref._phonetypes.Put((Object)("6"),(Object)("pager"));
RDebugUtils.currentLine=7274514;
 //BA.debugLineNum = 7274514;BA.debugLine="phoneTypes.Put(\"7\", \"other\")";
__ref._phonetypes.Put((Object)("7"),(Object)("other"));
RDebugUtils.currentLine=7274515;
 //BA.debugLineNum = 7274515;BA.debugLine="phoneTypes.Put(\"8\", \"callback\")";
__ref._phonetypes.Put((Object)("8"),(Object)("callback"));
RDebugUtils.currentLine=7274516;
 //BA.debugLineNum = 7274516;BA.debugLine="phoneTypes.Put(\"9\", \"car\")";
__ref._phonetypes.Put((Object)("9"),(Object)("car"));
RDebugUtils.currentLine=7274517;
 //BA.debugLineNum = 7274517;BA.debugLine="phoneTypes.Put(\"10\", \"company_main\")";
__ref._phonetypes.Put((Object)("10"),(Object)("company_main"));
RDebugUtils.currentLine=7274518;
 //BA.debugLineNum = 7274518;BA.debugLine="phoneTypes.Put(\"11\", \"isdn\")";
__ref._phonetypes.Put((Object)("11"),(Object)("isdn"));
RDebugUtils.currentLine=7274519;
 //BA.debugLineNum = 7274519;BA.debugLine="phoneTypes.Put(\"12\", \"main\")";
__ref._phonetypes.Put((Object)("12"),(Object)("main"));
RDebugUtils.currentLine=7274520;
 //BA.debugLineNum = 7274520;BA.debugLine="phoneTypes.Put(\"13\", \"other_fax\")";
__ref._phonetypes.Put((Object)("13"),(Object)("other_fax"));
RDebugUtils.currentLine=7274521;
 //BA.debugLineNum = 7274521;BA.debugLine="phoneTypes.Put(\"14\", \"radio\")";
__ref._phonetypes.Put((Object)("14"),(Object)("radio"));
RDebugUtils.currentLine=7274522;
 //BA.debugLineNum = 7274522;BA.debugLine="phoneTypes.Put(\"15\", \"telex\")";
__ref._phonetypes.Put((Object)("15"),(Object)("telex"));
RDebugUtils.currentLine=7274523;
 //BA.debugLineNum = 7274523;BA.debugLine="phoneTypes.Put(\"16\", \"tty_tdd\")";
__ref._phonetypes.Put((Object)("16"),(Object)("tty_tdd"));
RDebugUtils.currentLine=7274524;
 //BA.debugLineNum = 7274524;BA.debugLine="phoneTypes.Put(\"17\", \"work_mobile\")";
__ref._phonetypes.Put((Object)("17"),(Object)("work_mobile"));
RDebugUtils.currentLine=7274525;
 //BA.debugLineNum = 7274525;BA.debugLine="phoneTypes.Put(\"18\", \"work_pager\")";
__ref._phonetypes.Put((Object)("18"),(Object)("work_pager"));
RDebugUtils.currentLine=7274526;
 //BA.debugLineNum = 7274526;BA.debugLine="phoneTypes.Put(\"19\", \"assistant\")";
__ref._phonetypes.Put((Object)("19"),(Object)("assistant"));
RDebugUtils.currentLine=7274527;
 //BA.debugLineNum = 7274527;BA.debugLine="phoneTypes.Put(\"20\", \"mms\")";
__ref._phonetypes.Put((Object)("20"),(Object)("mms"));
RDebugUtils.currentLine=7274529;
 //BA.debugLineNum = 7274529;BA.debugLine="eventTypes.Initialize";
__ref._eventtypes.Initialize();
RDebugUtils.currentLine=7274530;
 //BA.debugLineNum = 7274530;BA.debugLine="eventTypes.Put(\"1\", \"anniversary\")";
__ref._eventtypes.Put((Object)("1"),(Object)("anniversary"));
RDebugUtils.currentLine=7274531;
 //BA.debugLineNum = 7274531;BA.debugLine="eventTypes.Put(\"2\", \"other\")";
__ref._eventtypes.Put((Object)("2"),(Object)("other"));
RDebugUtils.currentLine=7274532;
 //BA.debugLineNum = 7274532;BA.debugLine="eventTypes.Put(\"3\", \"birthday\")";
__ref._eventtypes.Put((Object)("3"),(Object)("birthday"));
RDebugUtils.currentLine=7274533;
 //BA.debugLineNum = 7274533;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_READ_CONTACTS)";
__ref._rp.CheckAndRequest(ba,__ref._rp.PERMISSION_READ_CONTACTS);
RDebugUtils.currentLine=7274534;
 //BA.debugLineNum = 7274534;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_CONTACTS)";
__ref._rp.CheckAndRequest(ba,__ref._rp.PERMISSION_WRITE_CONTACTS);
RDebugUtils.currentLine=7274535;
 //BA.debugLineNum = 7274535;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CALL_PHONE)";
__ref._rp.CheckAndRequest(ba,__ref._rp.PERMISSION_CALL_PHONE);
RDebugUtils.currentLine=7274536;
 //BA.debugLineNum = 7274536;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _getemails(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getemails", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getemails", new Object[] {_id}));}
anywheresoftware.b4a.objects.collections.List _res = null;
Object[] _obj = null;
com.no3dlauncher.contactsutils._cuemail _e = null;
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Public Sub GetEmails(Id As Long) As List";
RDebugUtils.currentLine=7995393;
 //BA.debugLineNum = 7995393;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=7995395;
 //BA.debugLineNum = 7995395;BA.debugLine="For Each obj() As Object In GetData(\"vnd.android.";
{
final anywheresoftware.b4a.BA.IterableList group3 = __ref._getdata(null,"vnd.android.cursor.item/email_v2",new String[]{"data1","data2"},_id,(boolean[])(__c.Null));
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_obj = (Object[])(group3.Get(index3));
RDebugUtils.currentLine=7995396;
 //BA.debugLineNum = 7995396;BA.debugLine="Dim e As cuEmail";
_e = new com.no3dlauncher.contactsutils._cuemail();
RDebugUtils.currentLine=7995397;
 //BA.debugLineNum = 7995397;BA.debugLine="e.Initialize";
_e.Initialize();
RDebugUtils.currentLine=7995398;
 //BA.debugLineNum = 7995398;BA.debugLine="e.Email = obj(0)";
_e.Email = BA.ObjectToString(_obj[(int) (0)]);
RDebugUtils.currentLine=7995399;
 //BA.debugLineNum = 7995399;BA.debugLine="e.EmailType = mailTypes.Get(obj(1))";
_e.EmailType = BA.ObjectToString(__ref._mailtypes.Get(_obj[(int) (1)]));
RDebugUtils.currentLine=7995400;
 //BA.debugLineNum = 7995400;BA.debugLine="res.Add(e)";
_res.Add((Object)(_e));
 }
};
RDebugUtils.currentLine=7995402;
 //BA.debugLineNum = 7995402;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=7995403;
 //BA.debugLineNum = 7995403;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.Map  _getaccounts(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getaccounts", false))
	 {return ((anywheresoftware.b4a.objects.collections.Map) Debug.delegate(ba, "getaccounts", new Object[] {_id}));}
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _uri = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _c = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _i = 0;
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Public Sub GetAccounts(Id As Long) As Map";
RDebugUtils.currentLine=9175041;
 //BA.debugLineNum = 9175041;BA.debugLine="Dim uri As Uri";
_uri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="uri.Parse(\"content://com.android.contacts/contact";
_uri.Parse("content://com.android.contacts/contacts/"+BA.NumberToString(_id)+"/entities");
RDebugUtils.currentLine=9175043;
 //BA.debugLineNum = 9175043;BA.debugLine="Dim c As Cursor = cr.Query(uri, Array As String(\"";
_c = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_c = __ref._cr.Query(_uri,new String[]{"account_name","account_type"},"",(String[])(__c.Null),"");
RDebugUtils.currentLine=9175044;
 //BA.debugLineNum = 9175044;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=9175045;
 //BA.debugLineNum = 9175045;BA.debugLine="m.Initialize";
_m.Initialize();
RDebugUtils.currentLine=9175046;
 //BA.debugLineNum = 9175046;BA.debugLine="For i = 0 To c.RowCount - 1";
{
final int step6 = 1;
final int limit6 = (int) (_c.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=9175047;
 //BA.debugLineNum = 9175047;BA.debugLine="c.Position = i";
_c.setPosition(_i);
RDebugUtils.currentLine=9175048;
 //BA.debugLineNum = 9175048;BA.debugLine="m.Put(c.GetString(\"account_name\"), c.GetString(\"";
_m.Put((Object)(_c.GetString("account_name")),(Object)(_c.GetString("account_type")));
 }
};
RDebugUtils.currentLine=9175050;
 //BA.debugLineNum = 9175050;BA.debugLine="c.Close";
_c.Close();
RDebugUtils.currentLine=9175052;
 //BA.debugLineNum = 9175052;BA.debugLine="Return m";
if (true) return _m;
RDebugUtils.currentLine=9175053;
 //BA.debugLineNum = 9175053;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getevents(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getevents", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getevents", new Object[] {_id}));}
anywheresoftware.b4a.objects.collections.List _res = null;
Object[] _obj = null;
com.no3dlauncher.contactsutils._cuevent _e = null;
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Public Sub GetEvents(Id As Long) As List";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="For Each obj() As Object In GetData(\"vnd.android.";
{
final anywheresoftware.b4a.BA.IterableList group3 = __ref._getdata(null,"vnd.android.cursor.item/contact_event",new String[]{"data1","data2"},_id,(boolean[])(__c.Null));
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_obj = (Object[])(group3.Get(index3));
RDebugUtils.currentLine=8060932;
 //BA.debugLineNum = 8060932;BA.debugLine="Dim e As cuEvent";
_e = new com.no3dlauncher.contactsutils._cuevent();
RDebugUtils.currentLine=8060933;
 //BA.debugLineNum = 8060933;BA.debugLine="e.Initialize";
_e.Initialize();
RDebugUtils.currentLine=8060934;
 //BA.debugLineNum = 8060934;BA.debugLine="e.DateString = obj(0)";
_e.DateString = BA.ObjectToString(_obj[(int) (0)]);
RDebugUtils.currentLine=8060935;
 //BA.debugLineNum = 8060935;BA.debugLine="e.EventType = eventTypes.Get(obj(1))";
_e.EventType = BA.ObjectToString(__ref._eventtypes.Get(_obj[(int) (1)]));
RDebugUtils.currentLine=8060936;
 //BA.debugLineNum = 8060936;BA.debugLine="res.Add(e)";
_res.Add((Object)(_e));
 }
};
RDebugUtils.currentLine=8060938;
 //BA.debugLineNum = 8060938;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=8060939;
 //BA.debugLineNum = 8060939;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getgroups(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getgroups", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getgroups", new Object[] {_id}));}
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _uri = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _c = null;
anywheresoftware.b4a.objects.collections.List _groups = null;
int _i = 0;
String _source = "";
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Public Sub GetGroups(Id As Long) As List";
RDebugUtils.currentLine=9306113;
 //BA.debugLineNum = 9306113;BA.debugLine="FillGroupSources";
__ref._fillgroupsources(null);
RDebugUtils.currentLine=9306114;
 //BA.debugLineNum = 9306114;BA.debugLine="Dim uri As Uri";
_uri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=9306115;
 //BA.debugLineNum = 9306115;BA.debugLine="uri.Parse(\"content://com.android.contacts/contact";
_uri.Parse("content://com.android.contacts/contacts/"+BA.NumberToString(_id)+"/entities");
RDebugUtils.currentLine=9306116;
 //BA.debugLineNum = 9306116;BA.debugLine="Dim c As Cursor = cr.Query(uri, Array As String(\"";
_c = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_c = __ref._cr.Query(_uri,new String[]{"group_sourceid"},"",(String[])(__c.Null),"");
RDebugUtils.currentLine=9306117;
 //BA.debugLineNum = 9306117;BA.debugLine="Dim groups As List";
_groups = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=9306118;
 //BA.debugLineNum = 9306118;BA.debugLine="groups.Initialize";
_groups.Initialize();
RDebugUtils.currentLine=9306119;
 //BA.debugLineNum = 9306119;BA.debugLine="For i = 0 To c.RowCount - 1";
{
final int step7 = 1;
final int limit7 = (int) (_c.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=9306120;
 //BA.debugLineNum = 9306120;BA.debugLine="c.Position = i";
_c.setPosition(_i);
RDebugUtils.currentLine=9306121;
 //BA.debugLineNum = 9306121;BA.debugLine="If c.GetString(\"group_sourceid\") <> Null Then";
if (_c.GetString("group_sourceid")!= null) { 
RDebugUtils.currentLine=9306122;
 //BA.debugLineNum = 9306122;BA.debugLine="Dim source As String = c.GetString(\"group_sourc";
_source = _c.GetString("group_sourceid");
RDebugUtils.currentLine=9306123;
 //BA.debugLineNum = 9306123;BA.debugLine="If GroupSources.ContainsKey(source) Then";
if (__ref._groupsources.ContainsKey((Object)(_source))) { 
RDebugUtils.currentLine=9306124;
 //BA.debugLineNum = 9306124;BA.debugLine="groups.Add(GroupSources.Get(source))";
_groups.Add(__ref._groupsources.Get((Object)(_source)));
 };
 };
 }
};
RDebugUtils.currentLine=9306128;
 //BA.debugLineNum = 9306128;BA.debugLine="c.Close";
_c.Close();
RDebugUtils.currentLine=9306129;
 //BA.debugLineNum = 9306129;BA.debugLine="Return groups";
if (true) return _groups;
RDebugUtils.currentLine=9306130;
 //BA.debugLineNum = 9306130;BA.debugLine="End Sub";
return null;
}
public String  _getnamefromid(com.no3dlauncher.contactsutils __ref,String _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getnamefromid", false))
	 {return ((String) Debug.delegate(ba, "getnamefromid", new Object[] {_id}));}
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
String _name = "";
RDebugUtils.currentLine=7798784;
 //BA.debugLineNum = 7798784;BA.debugLine="Public Sub GetNameFromId (id As String) As String";
RDebugUtils.currentLine=7798785;
 //BA.debugLineNum = 7798785;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, Array As S";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = __ref._cr.Query(__ref._datauri,new String[]{"contact_id","display_name"},"contact_id = ?",new String[]{_id},"");
RDebugUtils.currentLine=7798787;
 //BA.debugLineNum = 7798787;BA.debugLine="Dim name As String";
_name = "";
RDebugUtils.currentLine=7798788;
 //BA.debugLineNum = 7798788;BA.debugLine="If crsr.RowCount = 0 Then";
if (_crsr.getRowCount()==0) { 
RDebugUtils.currentLine=7798789;
 //BA.debugLineNum = 7798789;BA.debugLine="Log(\"Contact not found: \" & id)";
__c.LogImpl("37798789","Contact not found: "+_id,0);
 }else {
RDebugUtils.currentLine=7798791;
 //BA.debugLineNum = 7798791;BA.debugLine="crsr.Position = 0";
_crsr.setPosition((int) (0));
RDebugUtils.currentLine=7798792;
 //BA.debugLineNum = 7798792;BA.debugLine="name = crsr.GetString2(1)";
_name = _crsr.GetString2((int) (1));
 };
RDebugUtils.currentLine=7798794;
 //BA.debugLineNum = 7798794;BA.debugLine="crsr.Close";
_crsr.Close();
RDebugUtils.currentLine=7798795;
 //BA.debugLineNum = 7798795;BA.debugLine="Return name";
if (true) return _name;
RDebugUtils.currentLine=7798796;
 //BA.debugLineNum = 7798796;BA.debugLine="End Sub";
return "";
}
public String  _getnote(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getnote", false))
	 {return ((String) Debug.delegate(ba, "getnote", new Object[] {_id}));}
anywheresoftware.b4a.objects.collections.List _raw = null;
Object[] _obj = null;
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Public Sub GetNote(id As Long) As String";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="Dim raw As List = GetData(\"vnd.android.cursor.ite";
_raw = new anywheresoftware.b4a.objects.collections.List();
_raw = __ref._getdata(null,"vnd.android.cursor.item/note",new String[]{"data1"},_id,(boolean[])(__c.Null));
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="If raw.Size = 0 Then Return \"\"";
if (_raw.getSize()==0) { 
if (true) return "";};
RDebugUtils.currentLine=8192003;
 //BA.debugLineNum = 8192003;BA.debugLine="Dim obj() As Object = raw.Get(0)";
_obj = (Object[])(_raw.Get((int) (0)));
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="Return obj(0)";
if (true) return BA.ObjectToString(_obj[(int) (0)]);
RDebugUtils.currentLine=8192005;
 //BA.debugLineNum = 8192005;BA.debugLine="End Sub";
return "";
}
public com.no3dlauncher.contactsutils._cuorganization  _getorganization(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getorganization", false))
	 {return ((com.no3dlauncher.contactsutils._cuorganization) Debug.delegate(ba, "getorganization", new Object[] {_id}));}
anywheresoftware.b4a.objects.collections.List _organizations = null;
com.no3dlauncher.contactsutils._cuorganization _o = null;
Object[] _obj = null;
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Public Sub GetOrganization(Id As Long) As cuOrgani";
RDebugUtils.currentLine=7929857;
 //BA.debugLineNum = 7929857;BA.debugLine="Dim organizations As List = GetData(\"vnd.android.";
_organizations = new anywheresoftware.b4a.objects.collections.List();
_organizations = __ref._getdata(null,"vnd.android.cursor.item/organization",new String[]{"data1","data4"},_id,(boolean[])(__c.Null));
RDebugUtils.currentLine=7929859;
 //BA.debugLineNum = 7929859;BA.debugLine="Dim o As cuOrganization";
_o = new com.no3dlauncher.contactsutils._cuorganization();
RDebugUtils.currentLine=7929860;
 //BA.debugLineNum = 7929860;BA.debugLine="If organizations.Size > 0 Then";
if (_organizations.getSize()>0) { 
RDebugUtils.currentLine=7929861;
 //BA.debugLineNum = 7929861;BA.debugLine="o.Initialize";
_o.Initialize();
RDebugUtils.currentLine=7929862;
 //BA.debugLineNum = 7929862;BA.debugLine="Dim obj() As Object = organizations.Get(0)";
_obj = (Object[])(_organizations.Get((int) (0)));
RDebugUtils.currentLine=7929863;
 //BA.debugLineNum = 7929863;BA.debugLine="o.Company = obj(0)";
_o.Company = BA.ObjectToString(_obj[(int) (0)]);
RDebugUtils.currentLine=7929864;
 //BA.debugLineNum = 7929864;BA.debugLine="o.Title = obj(1)";
_o.Title = BA.ObjectToString(_obj[(int) (1)]);
 };
RDebugUtils.currentLine=7929866;
 //BA.debugLineNum = 7929866;BA.debugLine="Return o";
if (true) return _o;
RDebugUtils.currentLine=7929867;
 //BA.debugLineNum = 7929867;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getphones(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getphones", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getphones", new Object[] {_id}));}
anywheresoftware.b4a.objects.collections.List _res = null;
Object[] _obj = null;
com.no3dlauncher.contactsutils._cuphone _p = null;
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Public Sub GetPhones(id As Long) As List";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="For Each obj() As Object In GetData(\"vnd.android.";
{
final anywheresoftware.b4a.BA.IterableList group3 = __ref._getdata(null,"vnd.android.cursor.item/phone_v2",new String[]{"data1","data2"},_id,(boolean[])(__c.Null));
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_obj = (Object[])(group3.Get(index3));
RDebugUtils.currentLine=8126468;
 //BA.debugLineNum = 8126468;BA.debugLine="Dim p As cuPhone";
_p = new com.no3dlauncher.contactsutils._cuphone();
RDebugUtils.currentLine=8126469;
 //BA.debugLineNum = 8126469;BA.debugLine="p.Initialize";
_p.Initialize();
RDebugUtils.currentLine=8126470;
 //BA.debugLineNum = 8126470;BA.debugLine="p.Number = obj(0)";
_p.Number = BA.ObjectToString(_obj[(int) (0)]);
RDebugUtils.currentLine=8126471;
 //BA.debugLineNum = 8126471;BA.debugLine="p.PhoneType = phoneTypes.Get(obj(1))";
_p.PhoneType = BA.ObjectToString(__ref._phonetypes.Get(_obj[(int) (1)]));
RDebugUtils.currentLine=8126472;
 //BA.debugLineNum = 8126472;BA.debugLine="res.Add(p)";
_res.Add((Object)(_p));
 }
};
RDebugUtils.currentLine=8126474;
 //BA.debugLineNum = 8126474;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=8126475;
 //BA.debugLineNum = 8126475;BA.debugLine="End Sub";
return null;
}
public boolean  _getstarred(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getstarred", false))
	 {return ((Boolean) Debug.delegate(ba, "getstarred", new Object[] {_id}));}
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
boolean _starred = false;
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Public Sub GetStarred(Id As Long) As Boolean";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="Dim crsr As Cursor = cr.Query(contactUri, Array A";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = __ref._cr.Query(__ref._contacturi,new String[]{"starred"},"_id = ?",new String[]{BA.NumberToString(_id)},"");
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="crsr.Position = 0";
_crsr.setPosition((int) (0));
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="Dim starred As Boolean = crsr.GetInt(\"starred\") =";
_starred = _crsr.GetInt("starred")==1;
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="crsr.Close";
_crsr.Close();
RDebugUtils.currentLine=8323077;
 //BA.debugLineNum = 8323077;BA.debugLine="Return starred";
if (true) return _starred;
RDebugUtils.currentLine=8323078;
 //BA.debugLineNum = 8323078;BA.debugLine="End Sub";
return false;
}
public anywheresoftware.b4a.objects.collections.List  _findallcontacts(com.no3dlauncher.contactsutils __ref,boolean _visibleonly) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "findallcontacts", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "findallcontacts", new Object[] {_visibleonly}));}
RDebugUtils.currentLine=7667712;
 //BA.debugLineNum = 7667712;BA.debugLine="Public Sub FindAllContacts(VisibleOnly As Boolean)";
RDebugUtils.currentLine=7667713;
 //BA.debugLineNum = 7667713;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return __ref._findcontactsidfromdata(null,"vnd.android.cursor.item/name","data1","null","<>",__c.True,_visibleonly);
RDebugUtils.currentLine=7667714;
 //BA.debugLineNum = 7667714;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _getphoto(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getphoto", false))
	 {return ((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) Debug.delegate(ba, "getphoto", new Object[] {_id}));}
anywheresoftware.b4a.objects.collections.List _raw = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
Object[] _obj = null;
byte[] _bytes = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Public Sub GetPhoto(Id As Long) As Bitmap";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="Dim raw As List = GetData(\"vnd.android.cursor.ite";
_raw = new anywheresoftware.b4a.objects.collections.List();
_raw = __ref._getdata(null,"vnd.android.cursor.item/photo",new String[]{"data15"},_id,new boolean[]{__c.True});
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="Dim bmp As Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=8257539;
 //BA.debugLineNum = 8257539;BA.debugLine="If raw.Size > 0 Then";
if (_raw.getSize()>0) { 
RDebugUtils.currentLine=8257540;
 //BA.debugLineNum = 8257540;BA.debugLine="Dim obj() As Object = raw.Get(0)";
_obj = (Object[])(_raw.Get((int) (0)));
RDebugUtils.currentLine=8257541;
 //BA.debugLineNum = 8257541;BA.debugLine="Dim bytes() As Byte = obj(0)";
_bytes = (byte[])(_obj[(int) (0)]);
RDebugUtils.currentLine=8257542;
 //BA.debugLineNum = 8257542;BA.debugLine="If bytes <> Null Then";
if (_bytes!= null) { 
RDebugUtils.currentLine=8257543;
 //BA.debugLineNum = 8257543;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
RDebugUtils.currentLine=8257544;
 //BA.debugLineNum = 8257544;BA.debugLine="In.InitializeFromBytesArray(bytes, 0, bytes.Len";
_in.InitializeFromBytesArray(_bytes,(int) (0),_bytes.length);
RDebugUtils.currentLine=8257545;
 //BA.debugLineNum = 8257545;BA.debugLine="bmp.Initialize2(In)";
_bmp.Initialize2((java.io.InputStream)(_in.getObject()));
RDebugUtils.currentLine=8257546;
 //BA.debugLineNum = 8257546;BA.debugLine="In.Close";
_in.Close();
 };
 };
RDebugUtils.currentLine=8257549;
 //BA.debugLineNum = 8257549;BA.debugLine="Return bmp";
if (true) return _bmp;
RDebugUtils.currentLine=8257550;
 //BA.debugLineNum = 8257550;BA.debugLine="End Sub";
return null;
}
public String  _addemail(com.no3dlauncher.contactsutils __ref,long _id,String _email,String _emailtype) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "addemail", false))
	 {return ((String) Debug.delegate(ba, "addemail", new Object[] {_id,_email,_emailtype}));}
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _v = null;
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Public Sub AddEmail(Id As Long, Email As String, E";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="Dim v As ContentValues";
_v = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="v.Initialize";
_v.Initialize();
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="v.PutString(\"data1\", Email)";
_v.PutString("data1",_email);
RDebugUtils.currentLine=8585220;
 //BA.debugLineNum = 8585220;BA.debugLine="v.PutInteger(\"data2\", GetKeyFromValue(mailTypes,";
_v.PutInteger("data2",__ref._getkeyfromvalue(null,__ref._mailtypes,_emailtype,(int) (3)));
RDebugUtils.currentLine=8585221;
 //BA.debugLineNum = 8585221;BA.debugLine="SetData(\"vnd.android.cursor.item/email_v2\", v, Id";
__ref._setdata(null,"vnd.android.cursor.item/email_v2",_v,_id,__c.False);
RDebugUtils.currentLine=8585222;
 //BA.debugLineNum = 8585222;BA.debugLine="End Sub";
return "";
}
public int  _getkeyfromvalue(com.no3dlauncher.contactsutils __ref,anywheresoftware.b4a.objects.collections.Map _m,String _v,int _defaultvalue) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getkeyfromvalue", false))
	 {return ((Integer) Debug.delegate(ba, "getkeyfromvalue", new Object[] {_m,_v,_defaultvalue}));}
int _t = 0;
int _i = 0;
RDebugUtils.currentLine=8847360;
 //BA.debugLineNum = 8847360;BA.debugLine="Private Sub GetKeyFromValue(m As Map, v As String,";
RDebugUtils.currentLine=8847361;
 //BA.debugLineNum = 8847361;BA.debugLine="Dim t As Int = defaultValue";
_t = _defaultvalue;
RDebugUtils.currentLine=8847362;
 //BA.debugLineNum = 8847362;BA.debugLine="For i = 0 To m.Size - 1";
{
final int step2 = 1;
final int limit2 = (int) (_m.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=8847363;
 //BA.debugLineNum = 8847363;BA.debugLine="If m.GetValueAt(i) = v Then";
if ((_m.GetValueAt(_i)).equals((Object)(_v))) { 
RDebugUtils.currentLine=8847364;
 //BA.debugLineNum = 8847364;BA.debugLine="t = m.GetKeyAt(i)";
_t = (int)(BA.ObjectToNumber(_m.GetKeyAt(_i)));
RDebugUtils.currentLine=8847365;
 //BA.debugLineNum = 8847365;BA.debugLine="Exit";
if (true) break;
 };
 }
};
RDebugUtils.currentLine=8847368;
 //BA.debugLineNum = 8847368;BA.debugLine="Return t";
if (true) return _t;
RDebugUtils.currentLine=8847369;
 //BA.debugLineNum = 8847369;BA.debugLine="End Sub";
return 0;
}
public String  _setdata(com.no3dlauncher.contactsutils __ref,String _mime,anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _values,long _id,boolean _update) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "setdata", false))
	 {return ((String) Debug.delegate(ba, "setdata", new Object[] {_mime,_values,_id,_update}));}
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Private Sub SetData(Mime As String, Values As Cont";
RDebugUtils.currentLine=8978433;
 //BA.debugLineNum = 8978433;BA.debugLine="If Update Then";
if (_update) { 
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="cr.Update(dataUri, Values, \"mimetype = ? AND con";
__ref._cr.Update((android.net.Uri)(__ref._datauri.getObject()),(android.content.ContentValues)(_values.getObject()),"mimetype = ? AND contact_id = ?",new String[]{_mime,BA.NumberToString(_id)});
 }else {
RDebugUtils.currentLine=8978436;
 //BA.debugLineNum = 8978436;BA.debugLine="Dim crsr As Cursor = cr.Query(contactUri, Array";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = __ref._cr.Query(__ref._contacturi,new String[]{"name_raw_contact_id"},"_id = ?",new String[]{BA.NumberToString(_id)},"");
RDebugUtils.currentLine=8978438;
 //BA.debugLineNum = 8978438;BA.debugLine="If crsr.RowCount = 0 Then";
if (_crsr.getRowCount()==0) { 
RDebugUtils.currentLine=8978439;
 //BA.debugLineNum = 8978439;BA.debugLine="Log(\"Error getting raw_contact_id\")";
__c.LogImpl("38978439","Error getting raw_contact_id",0);
RDebugUtils.currentLine=8978440;
 //BA.debugLineNum = 8978440;BA.debugLine="crsr.Close";
_crsr.Close();
RDebugUtils.currentLine=8978441;
 //BA.debugLineNum = 8978441;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=8978443;
 //BA.debugLineNum = 8978443;BA.debugLine="crsr.Position = 0";
_crsr.setPosition((int) (0));
RDebugUtils.currentLine=8978444;
 //BA.debugLineNum = 8978444;BA.debugLine="Values.PutString(\"raw_contact_id\", crsr.GetStrin";
_values.PutString("raw_contact_id",_crsr.GetString("name_raw_contact_id"));
RDebugUtils.currentLine=8978445;
 //BA.debugLineNum = 8978445;BA.debugLine="crsr.Close";
_crsr.Close();
RDebugUtils.currentLine=8978446;
 //BA.debugLineNum = 8978446;BA.debugLine="Values.PutString(\"mimetype\", Mime)";
_values.PutString("mimetype",_mime);
RDebugUtils.currentLine=8978447;
 //BA.debugLineNum = 8978447;BA.debugLine="cr.Insert(dataUri, Values)";
__ref._cr.Insert(__ref._datauri,(android.content.ContentValues)(_values.getObject()));
 };
RDebugUtils.currentLine=8978449;
 //BA.debugLineNum = 8978449;BA.debugLine="End Sub";
return "";
}
public String  _addnote(com.no3dlauncher.contactsutils __ref,long _id,String _note) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "addnote", false))
	 {return ((String) Debug.delegate(ba, "addnote", new Object[] {_id,_note}));}
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _v = null;
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Public Sub AddNote(Id As Long, Note As String)";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="Dim v As ContentValues";
_v = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="v.Initialize";
_v.Initialize();
RDebugUtils.currentLine=8519683;
 //BA.debugLineNum = 8519683;BA.debugLine="v.PutString(\"data1\", Note)";
_v.PutString("data1",_note);
RDebugUtils.currentLine=8519684;
 //BA.debugLineNum = 8519684;BA.debugLine="SetData(\"vnd.android.cursor.item/note\", v, Id, Fa";
__ref._setdata(null,"vnd.android.cursor.item/note",_v,_id,__c.False);
RDebugUtils.currentLine=8519685;
 //BA.debugLineNum = 8519685;BA.debugLine="End Sub";
return "";
}
public String  _addphone(com.no3dlauncher.contactsutils __ref,long _id,String _phonenumber,String _phonetype) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "addphone", false))
	 {return ((String) Debug.delegate(ba, "addphone", new Object[] {_id,_phonenumber,_phonetype}));}
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _v = null;
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Public Sub AddPhone(Id As Long, PhoneNumber As Str";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="Dim v As ContentValues";
_v = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="v.Initialize";
_v.Initialize();
RDebugUtils.currentLine=8650755;
 //BA.debugLineNum = 8650755;BA.debugLine="v.PutString(\"data1\", PhoneNumber)";
_v.PutString("data1",_phonenumber);
RDebugUtils.currentLine=8650756;
 //BA.debugLineNum = 8650756;BA.debugLine="v.PutInteger(\"data2\", GetKeyFromValue(phoneTypes,";
_v.PutInteger("data2",__ref._getkeyfromvalue(null,__ref._phonetypes,_phonetype,(int) (7)));
RDebugUtils.currentLine=8650757;
 //BA.debugLineNum = 8650757;BA.debugLine="SetData(\"vnd.android.cursor.item/phone_v2\", v, Id";
__ref._setdata(null,"vnd.android.cursor.item/phone_v2",_v,_id,__c.False);
RDebugUtils.currentLine=8650758;
 //BA.debugLineNum = 8650758;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(com.no3dlauncher.contactsutils __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
RDebugUtils.currentLine=7208960;
 //BA.debugLineNum = 7208960;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=7208961;
 //BA.debugLineNum = 7208961;BA.debugLine="Type cuContact (Id As Long, DisplayName As String";
;
RDebugUtils.currentLine=7208962;
 //BA.debugLineNum = 7208962;BA.debugLine="Type cuEmail (Email As String, EmailType As Strin";
;
RDebugUtils.currentLine=7208963;
 //BA.debugLineNum = 7208963;BA.debugLine="Type cuPhone (Number As String, PhoneType As Stri";
;
RDebugUtils.currentLine=7208964;
 //BA.debugLineNum = 7208964;BA.debugLine="Type cuEvent (DateString As String, EventType As";
;
RDebugUtils.currentLine=7208965;
 //BA.debugLineNum = 7208965;BA.debugLine="Type cuOrganization(Company As String, Title As S";
;
RDebugUtils.currentLine=7208966;
 //BA.debugLineNum = 7208966;BA.debugLine="Private mailTypes, phoneTypes, eventTypes As Map";
_mailtypes = new anywheresoftware.b4a.objects.collections.Map();
_phonetypes = new anywheresoftware.b4a.objects.collections.Map();
_eventtypes = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=7208967;
 //BA.debugLineNum = 7208967;BA.debugLine="Private cr As ContentResolver";
_cr = new anywheresoftware.b4a.objects.ContentResolverWrapper();
RDebugUtils.currentLine=7208968;
 //BA.debugLineNum = 7208968;BA.debugLine="Private dataUri, contactUri, rawContactUri As Uri";
_datauri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
_contacturi = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
_rawcontacturi = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=7208969;
 //BA.debugLineNum = 7208969;BA.debugLine="Private GroupSources As Map";
_groupsources = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=7208970;
 //BA.debugLineNum = 7208970;BA.debugLine="Private rp As RuntimePermissions";
_rp = new anywheresoftware.b4a.objects.RuntimePermissions();
RDebugUtils.currentLine=7208971;
 //BA.debugLineNum = 7208971;BA.debugLine="End Sub";
return "";
}
public String  _deletecontact(com.no3dlauncher.contactsutils __ref,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "deletecontact", false))
	 {return ((String) Debug.delegate(ba, "deletecontact", new Object[] {_id}));}
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Public Sub DeleteContact(Id As Long)";
RDebugUtils.currentLine=9109505;
 //BA.debugLineNum = 9109505;BA.debugLine="cr.Delete(rawContactUri, \"contact_id = ?\", Array";
__ref._cr.Delete((android.net.Uri)(__ref._rawcontacturi.getObject()),"contact_id = ?",new String[]{BA.NumberToString(_id)});
RDebugUtils.currentLine=9109506;
 //BA.debugLineNum = 9109506;BA.debugLine="End Sub";
return "";
}
public String  _deletedata(com.no3dlauncher.contactsutils __ref,String _mime,String _data1value,long _id) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "deletedata", false))
	 {return ((String) Debug.delegate(ba, "deletedata", new Object[] {_mime,_data1value,_id}));}
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Private Sub DeleteData(Mime As String, Data1Value";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="cr.Delete(dataUri, \"mimetype = ? AND data1 = ? AN";
__ref._cr.Delete((android.net.Uri)(__ref._datauri.getObject()),"mimetype = ? AND data1 = ? AND contact_id = ?",new String[]{_mime,_data1value,BA.NumberToString(_id)});
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="End Sub";
return "";
}
public String  _deleteemail(com.no3dlauncher.contactsutils __ref,long _id,String _email) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "deleteemail", false))
	 {return ((String) Debug.delegate(ba, "deleteemail", new Object[] {_id,_email}));}
RDebugUtils.currentLine=8781824;
 //BA.debugLineNum = 8781824;BA.debugLine="Public Sub DeleteEmail(Id As Long,Email As String)";
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="DeleteData(\"vnd.android.cursor.item/email_v2\", Em";
__ref._deletedata(null,"vnd.android.cursor.item/email_v2",_email,_id);
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="End Sub";
return "";
}
public String  _deletephone(com.no3dlauncher.contactsutils __ref,long _id,String _phonenumber) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "deletephone", false))
	 {return ((String) Debug.delegate(ba, "deletephone", new Object[] {_id,_phonenumber}));}
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Public Sub DeletePhone(Id As Long, PhoneNumber As";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="DeleteData(\"vnd.android.cursor.item/phone_v2\", Ph";
__ref._deletedata(null,"vnd.android.cursor.item/phone_v2",_phonenumber,_id);
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="End Sub";
return "";
}
public String  _fillgroupsources(com.no3dlauncher.contactsutils __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "fillgroupsources", false))
	 {return ((String) Debug.delegate(ba, "fillgroupsources", null));}
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _gu = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _c = null;
int _i = 0;
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Private Sub FillGroupSources";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="If GroupSources.IsInitialized = False Then";
if (__ref._groupsources.IsInitialized()==__c.False) { 
RDebugUtils.currentLine=9240578;
 //BA.debugLineNum = 9240578;BA.debugLine="GroupSources.Initialize";
__ref._groupsources.Initialize();
RDebugUtils.currentLine=9240579;
 //BA.debugLineNum = 9240579;BA.debugLine="Dim gu As Uri";
_gu = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
RDebugUtils.currentLine=9240580;
 //BA.debugLineNum = 9240580;BA.debugLine="gu.Parse(\"content://com.android.contacts/groups\"";
_gu.Parse("content://com.android.contacts/groups");
RDebugUtils.currentLine=9240581;
 //BA.debugLineNum = 9240581;BA.debugLine="Dim c As Cursor = cr.Query(gu, Array As String(\"";
_c = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_c = __ref._cr.Query(_gu,new String[]{"sourceid","title"},"",(String[])(__c.Null),"");
RDebugUtils.currentLine=9240582;
 //BA.debugLineNum = 9240582;BA.debugLine="For i = 0 To c.RowCount - 1";
{
final int step6 = 1;
final int limit6 = (int) (_c.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
RDebugUtils.currentLine=9240583;
 //BA.debugLineNum = 9240583;BA.debugLine="c.Position = i";
_c.setPosition(_i);
RDebugUtils.currentLine=9240584;
 //BA.debugLineNum = 9240584;BA.debugLine="GroupSources.Put(c.GetString(\"sourceid\"), c.Get";
__ref._groupsources.Put((Object)(_c.GetString("sourceid")),(Object)(_c.GetString("title")));
 }
};
 };
RDebugUtils.currentLine=9240587;
 //BA.debugLineNum = 9240587;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsidfromdata(com.no3dlauncher.contactsutils __ref,String _mime,String _datacolumn,String _value,String _operator,boolean _exact,boolean _visibleonly) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "findcontactsidfromdata", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "findcontactsidfromdata", new Object[] {_mime,_datacolumn,_value,_operator,_exact,_visibleonly}));}
String _selection = "";
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
anywheresoftware.b4a.objects.collections.List _res = null;
anywheresoftware.b4a.objects.collections.Map _m = null;
int _i = 0;
com.no3dlauncher.contactsutils._cucontact _cu = null;
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Private Sub FindContactsIdFromData (Mime As String";
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="If Not(Exact) Then";
if (__c.Not(_exact)) { 
RDebugUtils.currentLine=7864323;
 //BA.debugLineNum = 7864323;BA.debugLine="Operator = \"LIKE\"";
_operator = "LIKE";
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="Value = \"%\" & Value & \"%\"";
_value = "%"+_value+"%";
 };
RDebugUtils.currentLine=7864326;
 //BA.debugLineNum = 7864326;BA.debugLine="Dim selection As String = \"mimetype = ? AND \" & D";
_selection = "mimetype = ? AND "+_datacolumn+" "+_operator+" ? ";
RDebugUtils.currentLine=7864327;
 //BA.debugLineNum = 7864327;BA.debugLine="If VisibleOnly Then selection = selection & \" AND";
if (_visibleonly) { 
_selection = _selection+" AND in_visible_group = 1";};
RDebugUtils.currentLine=7864328;
 //BA.debugLineNum = 7864328;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, Array As S";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = __ref._cr.Query(__ref._datauri,new String[]{"contact_id","display_name"},_selection,new String[]{_mime,_value},"");
RDebugUtils.currentLine=7864330;
 //BA.debugLineNum = 7864330;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=7864331;
 //BA.debugLineNum = 7864331;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=7864332;
 //BA.debugLineNum = 7864332;BA.debugLine="Dim m As Map";
_m = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=7864333;
 //BA.debugLineNum = 7864333;BA.debugLine="m.Initialize";
_m.Initialize();
RDebugUtils.currentLine=7864334;
 //BA.debugLineNum = 7864334;BA.debugLine="For i = 0 To crsr.RowCount - 1";
{
final int step12 = 1;
final int limit12 = (int) (_crsr.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
RDebugUtils.currentLine=7864335;
 //BA.debugLineNum = 7864335;BA.debugLine="crsr.Position = i";
_crsr.setPosition(_i);
RDebugUtils.currentLine=7864336;
 //BA.debugLineNum = 7864336;BA.debugLine="Dim cu As cuContact";
_cu = new com.no3dlauncher.contactsutils._cucontact();
RDebugUtils.currentLine=7864337;
 //BA.debugLineNum = 7864337;BA.debugLine="cu.Initialize";
_cu.Initialize();
RDebugUtils.currentLine=7864338;
 //BA.debugLineNum = 7864338;BA.debugLine="cu.Id = crsr.GetLong(\"contact_id\")";
_cu.Id = _crsr.GetLong("contact_id");
RDebugUtils.currentLine=7864339;
 //BA.debugLineNum = 7864339;BA.debugLine="cu.DisplayName = crsr.GetString(\"display_name\")";
_cu.DisplayName = _crsr.GetString("display_name");
RDebugUtils.currentLine=7864340;
 //BA.debugLineNum = 7864340;BA.debugLine="If m.ContainsKey(cu.Id) Then Continue";
if (_m.ContainsKey((Object)(_cu.Id))) { 
if (true) continue;};
RDebugUtils.currentLine=7864341;
 //BA.debugLineNum = 7864341;BA.debugLine="m.Put(cu.Id, Null)";
_m.Put((Object)(_cu.Id),__c.Null);
RDebugUtils.currentLine=7864342;
 //BA.debugLineNum = 7864342;BA.debugLine="res.Add(cu)";
_res.Add((Object)(_cu));
 }
};
RDebugUtils.currentLine=7864344;
 //BA.debugLineNum = 7864344;BA.debugLine="crsr.Close";
_crsr.Close();
RDebugUtils.currentLine=7864345;
 //BA.debugLineNum = 7864345;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=7864346;
 //BA.debugLineNum = 7864346;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbymail(com.no3dlauncher.contactsutils __ref,String _mail,boolean _exact,boolean _visibleonly) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "findcontactsbymail", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "findcontactsbymail", new Object[] {_mail,_exact,_visibleonly}));}
RDebugUtils.currentLine=7405568;
 //BA.debugLineNum = 7405568;BA.debugLine="Public Sub FindContactsByMail(Mail As String, Exac";
RDebugUtils.currentLine=7405569;
 //BA.debugLineNum = 7405569;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return __ref._findcontactsidfromdata(null,"vnd.android.cursor.item/email_v2","data1",_mail,"=",_exact,_visibleonly);
RDebugUtils.currentLine=7405570;
 //BA.debugLineNum = 7405570;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbyname(com.no3dlauncher.contactsutils __ref,String _name,boolean _exact,boolean _visibleonly) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "findcontactsbyname", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "findcontactsbyname", new Object[] {_name,_exact,_visibleonly}));}
RDebugUtils.currentLine=7340032;
 //BA.debugLineNum = 7340032;BA.debugLine="Public Sub FindContactsByName(Name As String, Exac";
RDebugUtils.currentLine=7340033;
 //BA.debugLineNum = 7340033;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return __ref._findcontactsidfromdata(null,"vnd.android.cursor.item/name","data1",_name,"=",_exact,_visibleonly);
RDebugUtils.currentLine=7340034;
 //BA.debugLineNum = 7340034;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbynotes(com.no3dlauncher.contactsutils __ref,String _note,boolean _exact,boolean _visibleonly) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "findcontactsbynotes", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "findcontactsbynotes", new Object[] {_note,_exact,_visibleonly}));}
RDebugUtils.currentLine=7471104;
 //BA.debugLineNum = 7471104;BA.debugLine="Public Sub FindContactsByNotes(Note As String, Exa";
RDebugUtils.currentLine=7471105;
 //BA.debugLineNum = 7471105;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return __ref._findcontactsidfromdata(null,"vnd.android.cursor.item/note","data1",_note,"=",_exact,_visibleonly);
RDebugUtils.currentLine=7471106;
 //BA.debugLineNum = 7471106;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbyphone(com.no3dlauncher.contactsutils __ref,String _phonenumber,boolean _exact,boolean _visibleonly) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "findcontactsbyphone", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "findcontactsbyphone", new Object[] {_phonenumber,_exact,_visibleonly}));}
RDebugUtils.currentLine=7536640;
 //BA.debugLineNum = 7536640;BA.debugLine="Public Sub FindContactsByPhone(PhoneNumber As Stri";
RDebugUtils.currentLine=7536641;
 //BA.debugLineNum = 7536641;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return __ref._findcontactsidfromdata(null,"vnd.android.cursor.item/phone_v2","data1",_phonenumber,"=",_exact,_visibleonly);
RDebugUtils.currentLine=7536642;
 //BA.debugLineNum = 7536642;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactsbystarred(com.no3dlauncher.contactsutils __ref,boolean _starred) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "findcontactsbystarred", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "findcontactsbystarred", new Object[] {_starred}));}
String _value = "";
RDebugUtils.currentLine=7602176;
 //BA.debugLineNum = 7602176;BA.debugLine="Public Sub FindContactsByStarred(Starred As Boolea";
RDebugUtils.currentLine=7602177;
 //BA.debugLineNum = 7602177;BA.debugLine="Dim value As String";
_value = "";
RDebugUtils.currentLine=7602178;
 //BA.debugLineNum = 7602178;BA.debugLine="If Starred Then value = \"1\" Else value = \"0\"";
if (_starred) { 
_value = "1";}
else {
_value = "0";};
RDebugUtils.currentLine=7602179;
 //BA.debugLineNum = 7602179;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return __ref._findcontactsidfromdata(null,"vnd.android.cursor.item/name","starred",_value,"=",__c.True,__c.True);
RDebugUtils.currentLine=7602180;
 //BA.debugLineNum = 7602180;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _findcontactswithphotos(com.no3dlauncher.contactsutils __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "findcontactswithphotos", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "findcontactswithphotos", null));}
RDebugUtils.currentLine=7733248;
 //BA.debugLineNum = 7733248;BA.debugLine="Public Sub FindContactsWithPhotos As List";
RDebugUtils.currentLine=7733249;
 //BA.debugLineNum = 7733249;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
if (true) return __ref._findcontactsidfromdata(null,"vnd.android.cursor.item/photo","data15","null","<>",__c.True,__c.False);
RDebugUtils.currentLine=7733250;
 //BA.debugLineNum = 7733250;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.collections.List  _getdata(com.no3dlauncher.contactsutils __ref,String _mime,String[] _datacolumns,long _id,boolean[] _blobs) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "getdata", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(ba, "getdata", new Object[] {_mime,_datacolumns,_id,_blobs}));}
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
anywheresoftware.b4a.objects.collections.List _res = null;
int _i = 0;
Object[] _row = null;
int _c = 0;
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Private Sub GetData(Mime As String, DataColumns()";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, DataColumn";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = __ref._cr.Query(__ref._datauri,_datacolumns,"mimetype = ? AND contact_id = ?",new String[]{_mime,BA.NumberToString(_id)},"");
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8388612;
 //BA.debugLineNum = 8388612;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=8388613;
 //BA.debugLineNum = 8388613;BA.debugLine="For i = 0 To crsr.RowCount - 1";
{
final int step4 = 1;
final int limit4 = (int) (_crsr.getRowCount()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=8388614;
 //BA.debugLineNum = 8388614;BA.debugLine="crsr.Position = i";
_crsr.setPosition(_i);
RDebugUtils.currentLine=8388615;
 //BA.debugLineNum = 8388615;BA.debugLine="Dim row(DataColumns.Length) As Object";
_row = new Object[_datacolumns.length];
{
int d0 = _row.length;
for (int i0 = 0;i0 < d0;i0++) {
_row[i0] = new Object();
}
}
;
RDebugUtils.currentLine=8388616;
 //BA.debugLineNum = 8388616;BA.debugLine="For c = 0 To DataColumns.Length - 1";
{
final int step7 = 1;
final int limit7 = (int) (_datacolumns.length-1);
_c = (int) (0) ;
for (;_c <= limit7 ;_c = _c + step7 ) {
RDebugUtils.currentLine=8388617;
 //BA.debugLineNum = 8388617;BA.debugLine="If  Blobs <> Null And Blobs(c) = True Then";
if (_blobs!= null && _blobs[_c]==__c.True) { 
RDebugUtils.currentLine=8388618;
 //BA.debugLineNum = 8388618;BA.debugLine="row(c) = crsr.GetBlob2(c)";
_row[_c] = (Object)(_crsr.GetBlob2(_c));
 }else {
RDebugUtils.currentLine=8388620;
 //BA.debugLineNum = 8388620;BA.debugLine="row(c) = crsr.GetString2(c)";
_row[_c] = (Object)(_crsr.GetString2(_c));
 };
 }
};
RDebugUtils.currentLine=8388623;
 //BA.debugLineNum = 8388623;BA.debugLine="res.Add(row)";
_res.Add((Object)(_row));
 }
};
RDebugUtils.currentLine=8388625;
 //BA.debugLineNum = 8388625;BA.debugLine="crsr.Close";
_crsr.Close();
RDebugUtils.currentLine=8388626;
 //BA.debugLineNum = 8388626;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=8388627;
 //BA.debugLineNum = 8388627;BA.debugLine="End Sub";
return null;
}
public com.no3dlauncher.contactsutils._cucontact  _insertcontact(com.no3dlauncher.contactsutils __ref,String _name,String _phone) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "insertcontact", false))
	 {return ((com.no3dlauncher.contactsutils._cucontact) Debug.delegate(ba, "insertcontact", new Object[] {_name,_phone}));}
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _values = null;
anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper _rawuri = null;
long _rawcontactid = 0L;
com.no3dlauncher.contactsutils._cucontact _cu = null;
anywheresoftware.b4a.sql.SQL.CursorWrapper _crsr = null;
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Public Sub InsertContact(Name As String, Phone As";
RDebugUtils.currentLine=9371649;
 //BA.debugLineNum = 9371649;BA.debugLine="Dim values As ContentValues";
_values = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
RDebugUtils.currentLine=9371650;
 //BA.debugLineNum = 9371650;BA.debugLine="values.Initialize";
_values.Initialize();
RDebugUtils.currentLine=9371651;
 //BA.debugLineNum = 9371651;BA.debugLine="values.PutNull(\"account_name\")";
_values.PutNull("account_name");
RDebugUtils.currentLine=9371652;
 //BA.debugLineNum = 9371652;BA.debugLine="values.PutNull(\"account_type\")";
_values.PutNull("account_type");
RDebugUtils.currentLine=9371653;
 //BA.debugLineNum = 9371653;BA.debugLine="Dim rawUri As Uri = cr.Insert(rawContactUri, valu";
_rawuri = new anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper();
_rawuri = __ref._cr.Insert(__ref._rawcontacturi,(android.content.ContentValues)(_values.getObject()));
RDebugUtils.currentLine=9371654;
 //BA.debugLineNum = 9371654;BA.debugLine="Dim rawContactId As Long = rawUri.ParseId";
_rawcontactid = _rawuri.ParseId();
RDebugUtils.currentLine=9371656;
 //BA.debugLineNum = 9371656;BA.debugLine="values.Initialize";
_values.Initialize();
RDebugUtils.currentLine=9371657;
 //BA.debugLineNum = 9371657;BA.debugLine="values.PutLong(\"raw_contact_id\", rawContactId)";
_values.PutLong("raw_contact_id",_rawcontactid);
RDebugUtils.currentLine=9371658;
 //BA.debugLineNum = 9371658;BA.debugLine="values.PutString(\"mimetype\", \"vnd.android.cursor.";
_values.PutString("mimetype","vnd.android.cursor.item/phone_v2");
RDebugUtils.currentLine=9371659;
 //BA.debugLineNum = 9371659;BA.debugLine="values.PutString(\"data1\", Phone)";
_values.PutString("data1",_phone);
RDebugUtils.currentLine=9371660;
 //BA.debugLineNum = 9371660;BA.debugLine="cr.Insert(dataUri, values)";
__ref._cr.Insert(__ref._datauri,(android.content.ContentValues)(_values.getObject()));
RDebugUtils.currentLine=9371662;
 //BA.debugLineNum = 9371662;BA.debugLine="values.Initialize";
_values.Initialize();
RDebugUtils.currentLine=9371663;
 //BA.debugLineNum = 9371663;BA.debugLine="values.PutLong(\"raw_contact_id\", rawContactId)";
_values.PutLong("raw_contact_id",_rawcontactid);
RDebugUtils.currentLine=9371664;
 //BA.debugLineNum = 9371664;BA.debugLine="values.PutString(\"mimetype\", \"vnd.android.cursor.";
_values.PutString("mimetype","vnd.android.cursor.item/name");
RDebugUtils.currentLine=9371665;
 //BA.debugLineNum = 9371665;BA.debugLine="values.PutString(\"data1\", Name)";
_values.PutString("data1",_name);
RDebugUtils.currentLine=9371666;
 //BA.debugLineNum = 9371666;BA.debugLine="cr.Insert(dataUri, values)";
__ref._cr.Insert(__ref._datauri,(android.content.ContentValues)(_values.getObject()));
RDebugUtils.currentLine=9371667;
 //BA.debugLineNum = 9371667;BA.debugLine="Dim cu As cuContact";
_cu = new com.no3dlauncher.contactsutils._cucontact();
RDebugUtils.currentLine=9371668;
 //BA.debugLineNum = 9371668;BA.debugLine="cu.Initialize";
_cu.Initialize();
RDebugUtils.currentLine=9371669;
 //BA.debugLineNum = 9371669;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, Array As S";
_crsr = new anywheresoftware.b4a.sql.SQL.CursorWrapper();
_crsr = __ref._cr.Query(__ref._datauri,new String[]{"contact_id","display_name"},"raw_contact_id = ?",new String[]{BA.NumberToString(_rawcontactid)},"");
RDebugUtils.currentLine=9371671;
 //BA.debugLineNum = 9371671;BA.debugLine="crsr.Position = 0";
_crsr.setPosition((int) (0));
RDebugUtils.currentLine=9371672;
 //BA.debugLineNum = 9371672;BA.debugLine="cu.DisplayName = crsr.GetString(\"display_name\")";
_cu.DisplayName = _crsr.GetString("display_name");
RDebugUtils.currentLine=9371673;
 //BA.debugLineNum = 9371673;BA.debugLine="cu.Id = crsr.GetLong(\"contact_id\")";
_cu.Id = _crsr.GetLong("contact_id");
RDebugUtils.currentLine=9371674;
 //BA.debugLineNum = 9371674;BA.debugLine="Return cu";
if (true) return _cu;
RDebugUtils.currentLine=9371675;
 //BA.debugLineNum = 9371675;BA.debugLine="End Sub";
return null;
}
public String  _printcursor(com.no3dlauncher.contactsutils __ref,anywheresoftware.b4a.sql.SQL.CursorWrapper _c) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "printcursor", false))
	 {return ((String) Debug.delegate(ba, "printcursor", new Object[] {_c}));}
int _r = 0;
int _col = 0;
RDebugUtils.currentLine=9437184;
 //BA.debugLineNum = 9437184;BA.debugLine="Private Sub printCursor(c As Cursor) 'ignore";
RDebugUtils.currentLine=9437185;
 //BA.debugLineNum = 9437185;BA.debugLine="For r = 0 To c.RowCount - 1";
{
final int step1 = 1;
final int limit1 = (int) (_c.getRowCount()-1);
_r = (int) (0) ;
for (;_r <= limit1 ;_r = _r + step1 ) {
RDebugUtils.currentLine=9437186;
 //BA.debugLineNum = 9437186;BA.debugLine="c.Position = r";
_c.setPosition(_r);
RDebugUtils.currentLine=9437187;
 //BA.debugLineNum = 9437187;BA.debugLine="For col = 0 To c.ColumnCount - 1";
{
final int step3 = 1;
final int limit3 = (int) (_c.getColumnCount()-1);
_col = (int) (0) ;
for (;_col <= limit3 ;_col = _col + step3 ) {
RDebugUtils.currentLine=9437188;
 //BA.debugLineNum = 9437188;BA.debugLine="Try";
try {RDebugUtils.currentLine=9437189;
 //BA.debugLineNum = 9437189;BA.debugLine="Log(c.GetColumnName(col) & \": \" & c.GetString2";
__c.LogImpl("39437189",_c.GetColumnName(_col)+": "+_c.GetString2(_col),0);
 } 
       catch (Exception e7) {
			ba.setLastException(e7);RDebugUtils.currentLine=9437191;
 //BA.debugLineNum = 9437191;BA.debugLine="Log(c.GetColumnName(col) & \": \" & LastExceptio";
__c.LogImpl("39437191",_c.GetColumnName(_col)+": "+BA.ObjectToString(__c.LastException(getActivityBA())),0);
 };
 }
};
RDebugUtils.currentLine=9437194;
 //BA.debugLineNum = 9437194;BA.debugLine="Log(\"***************\")";
__c.LogImpl("39437194","***************",0);
 }
};
RDebugUtils.currentLine=9437196;
 //BA.debugLineNum = 9437196;BA.debugLine="End Sub";
return "";
}
public String  _setnote(com.no3dlauncher.contactsutils __ref,long _id,String _note) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "setnote", false))
	 {return ((String) Debug.delegate(ba, "setnote", new Object[] {_id,_note}));}
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _v = null;
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Public Sub SetNote(Id As Long, Note As String)";
RDebugUtils.currentLine=8454145;
 //BA.debugLineNum = 8454145;BA.debugLine="Dim v As ContentValues";
_v = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="v.Initialize";
_v.Initialize();
RDebugUtils.currentLine=8454147;
 //BA.debugLineNum = 8454147;BA.debugLine="v.PutString(\"data1\", Note)";
_v.PutString("data1",_note);
RDebugUtils.currentLine=8454148;
 //BA.debugLineNum = 8454148;BA.debugLine="SetData(\"vnd.android.cursor.item/note\", v, Id, Tr";
__ref._setdata(null,"vnd.android.cursor.item/note",_v,_id,__c.True);
RDebugUtils.currentLine=8454149;
 //BA.debugLineNum = 8454149;BA.debugLine="End Sub";
return "";
}
public String  _setstarred(com.no3dlauncher.contactsutils __ref,long _id,boolean _starred) throws Exception{
__ref = this;
RDebugUtils.currentModule="contactsutils";
if (Debug.shouldDelegate(ba, "setstarred", false))
	 {return ((String) Debug.delegate(ba, "setstarred", new Object[] {_id,_starred}));}
anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper _values = null;
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Public Sub SetStarred (Id As Long, Starred As Bool";
RDebugUtils.currentLine=9043969;
 //BA.debugLineNum = 9043969;BA.debugLine="Dim values As ContentValues";
_values = new anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper();
RDebugUtils.currentLine=9043970;
 //BA.debugLineNum = 9043970;BA.debugLine="values.Initialize";
_values.Initialize();
RDebugUtils.currentLine=9043971;
 //BA.debugLineNum = 9043971;BA.debugLine="values.PutBoolean(\"starred\", Starred)";
_values.PutBoolean("starred",_starred);
RDebugUtils.currentLine=9043972;
 //BA.debugLineNum = 9043972;BA.debugLine="cr.Update(contactUri, values, \"_id = ?\", Array As";
__ref._cr.Update((android.net.Uri)(__ref._contacturi.getObject()),(android.content.ContentValues)(_values.getObject()),"_id = ?",new String[]{BA.NumberToString(_id)});
RDebugUtils.currentLine=9043973;
 //BA.debugLineNum = 9043973;BA.debugLine="End Sub";
return "";
}
}