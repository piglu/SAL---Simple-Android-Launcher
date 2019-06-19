package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class contactsutils_subs_0 {


public static RemoteObject  _addemail(RemoteObject __ref,RemoteObject _id,RemoteObject _email,RemoteObject _emailtype) throws Exception{
try {
		Debug.PushSubsStack("AddEmail (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,265);
if (RapidSub.canDelegate("addemail")) { return __ref.runUserSub(false, "contactsutils","addemail", __ref, _id, _email, _emailtype);}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");
Debug.locals.put("Id", _id);
Debug.locals.put("Email", _email);
Debug.locals.put("EmailType", _emailtype);
 BA.debugLineNum = 265;BA.debugLine="Public Sub AddEmail(Id As Long, Email As String, E";
Debug.ShouldStop(256);
 BA.debugLineNum = 266;BA.debugLine="Dim v As ContentValues";
Debug.ShouldStop(512);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 267;BA.debugLine="v.Initialize";
Debug.ShouldStop(1024);
_v.runVoidMethod ("Initialize");
 BA.debugLineNum = 268;BA.debugLine="v.PutString(\"data1\", Email)";
Debug.ShouldStop(2048);
_v.runVoidMethod ("PutString",(Object)(BA.ObjectToString("data1")),(Object)(_email));
 BA.debugLineNum = 269;BA.debugLine="v.PutInteger(\"data2\", GetKeyFromValue(mailTypes,";
Debug.ShouldStop(4096);
_v.runVoidMethod ("PutInteger",(Object)(BA.ObjectToString("data2")),(Object)(__ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_getkeyfromvalue",(Object)(__ref.getField(false,"_mailtypes")),(Object)(_emailtype),(Object)(BA.numberCast(int.class, 3)))));
 BA.debugLineNum = 270;BA.debugLine="SetData(\"vnd.android.cursor.item/email_v2\", v, Id";
Debug.ShouldStop(8192);
__ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_setdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/email_v2")),(Object)(_v),(Object)(_id),(Object)(contactsutils.__c.getField(true,"False")));
 BA.debugLineNum = 271;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addnote(RemoteObject __ref,RemoteObject _id,RemoteObject _note) throws Exception{
try {
		Debug.PushSubsStack("AddNote (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,255);
if (RapidSub.canDelegate("addnote")) { return __ref.runUserSub(false, "contactsutils","addnote", __ref, _id, _note);}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");
Debug.locals.put("Id", _id);
Debug.locals.put("Note", _note);
 BA.debugLineNum = 255;BA.debugLine="Public Sub AddNote(Id As Long, Note As String)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 256;BA.debugLine="Dim v As ContentValues";
Debug.ShouldStop(-2147483648);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 257;BA.debugLine="v.Initialize";
Debug.ShouldStop(1);
_v.runVoidMethod ("Initialize");
 BA.debugLineNum = 258;BA.debugLine="v.PutString(\"data1\", Note)";
Debug.ShouldStop(2);
_v.runVoidMethod ("PutString",(Object)(BA.ObjectToString("data1")),(Object)(_note));
 BA.debugLineNum = 259;BA.debugLine="SetData(\"vnd.android.cursor.item/note\", v, Id, Fa";
Debug.ShouldStop(4);
__ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_setdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/note")),(Object)(_v),(Object)(_id),(Object)(contactsutils.__c.getField(true,"False")));
 BA.debugLineNum = 260;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addphone(RemoteObject __ref,RemoteObject _id,RemoteObject _phonenumber,RemoteObject _phonetype) throws Exception{
try {
		Debug.PushSubsStack("AddPhone (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,275);
if (RapidSub.canDelegate("addphone")) { return __ref.runUserSub(false, "contactsutils","addphone", __ref, _id, _phonenumber, _phonetype);}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");
Debug.locals.put("Id", _id);
Debug.locals.put("PhoneNumber", _phonenumber);
Debug.locals.put("PhoneType", _phonetype);
 BA.debugLineNum = 275;BA.debugLine="Public Sub AddPhone(Id As Long, PhoneNumber As Str";
Debug.ShouldStop(262144);
 BA.debugLineNum = 276;BA.debugLine="Dim v As ContentValues";
Debug.ShouldStop(524288);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 277;BA.debugLine="v.Initialize";
Debug.ShouldStop(1048576);
_v.runVoidMethod ("Initialize");
 BA.debugLineNum = 278;BA.debugLine="v.PutString(\"data1\", PhoneNumber)";
Debug.ShouldStop(2097152);
_v.runVoidMethod ("PutString",(Object)(BA.ObjectToString("data1")),(Object)(_phonenumber));
 BA.debugLineNum = 279;BA.debugLine="v.PutInteger(\"data2\", GetKeyFromValue(phoneTypes,";
Debug.ShouldStop(4194304);
_v.runVoidMethod ("PutInteger",(Object)(BA.ObjectToString("data2")),(Object)(__ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_getkeyfromvalue",(Object)(__ref.getField(false,"_phonetypes")),(Object)(_phonetype),(Object)(BA.numberCast(int.class, 7)))));
 BA.debugLineNum = 280;BA.debugLine="SetData(\"vnd.android.cursor.item/phone_v2\", v, Id";
Debug.ShouldStop(8388608);
__ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_setdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/phone_v2")),(Object)(_v),(Object)(_id),(Object)(contactsutils.__c.getField(true,"False")));
 BA.debugLineNum = 281;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Type cuContact (Id As Long, DisplayName As String";
;
 //BA.debugLineNum = 5;BA.debugLine="Type cuEmail (Email As String, EmailType As Strin";
;
 //BA.debugLineNum = 6;BA.debugLine="Type cuPhone (Number As String, PhoneType As Stri";
;
 //BA.debugLineNum = 7;BA.debugLine="Type cuEvent (DateString As String, EventType As";
;
 //BA.debugLineNum = 8;BA.debugLine="Type cuOrganization(Company As String, Title As S";
;
 //BA.debugLineNum = 9;BA.debugLine="Private mailTypes, phoneTypes, eventTypes As Map";
contactsutils._mailtypes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_mailtypes",contactsutils._mailtypes);
contactsutils._phonetypes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_phonetypes",contactsutils._phonetypes);
contactsutils._eventtypes = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_eventtypes",contactsutils._eventtypes);
 //BA.debugLineNum = 10;BA.debugLine="Private cr As ContentResolver";
contactsutils._cr = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper");__ref.setField("_cr",contactsutils._cr);
 //BA.debugLineNum = 11;BA.debugLine="Private dataUri, contactUri, rawContactUri As Uri";
contactsutils._datauri = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");__ref.setField("_datauri",contactsutils._datauri);
contactsutils._contacturi = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");__ref.setField("_contacturi",contactsutils._contacturi);
contactsutils._rawcontacturi = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");__ref.setField("_rawcontacturi",contactsutils._rawcontacturi);
 //BA.debugLineNum = 12;BA.debugLine="Private GroupSources As Map";
contactsutils._groupsources = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");__ref.setField("_groupsources",contactsutils._groupsources);
 //BA.debugLineNum = 13;BA.debugLine="Private rp As RuntimePermissions";
contactsutils._rp = RemoteObject.createNew ("anywheresoftware.b4a.objects.RuntimePermissions");__ref.setField("_rp",contactsutils._rp);
 //BA.debugLineNum = 14;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _deletecontact(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("DeleteContact (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,335);
if (RapidSub.canDelegate("deletecontact")) { return __ref.runUserSub(false, "contactsutils","deletecontact", __ref, _id);}
Debug.locals.put("Id", _id);
 BA.debugLineNum = 335;BA.debugLine="Public Sub DeleteContact(Id As Long)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 336;BA.debugLine="cr.Delete(rawContactUri, \"contact_id = ?\", Array";
Debug.ShouldStop(32768);
__ref.getField(false,"_cr").runVoidMethod ("Delete",(Object)((__ref.getField(false,"_rawcontacturi").getObject())),(Object)(BA.ObjectToString("contact_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_id)})));
 BA.debugLineNum = 337;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deletedata(RemoteObject __ref,RemoteObject _mime,RemoteObject _data1value,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("DeleteData (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,304);
if (RapidSub.canDelegate("deletedata")) { return __ref.runUserSub(false, "contactsutils","deletedata", __ref, _mime, _data1value, _id);}
Debug.locals.put("Mime", _mime);
Debug.locals.put("Data1Value", _data1value);
Debug.locals.put("Id", _id);
 BA.debugLineNum = 304;BA.debugLine="Private Sub DeleteData(Mime As String, Data1Value";
Debug.ShouldStop(32768);
 BA.debugLineNum = 305;BA.debugLine="cr.Delete(dataUri, \"mimetype = ? AND data1 = ? AN";
Debug.ShouldStop(65536);
__ref.getField(false,"_cr").runVoidMethod ("Delete",(Object)((__ref.getField(false,"_datauri").getObject())),(Object)(BA.ObjectToString("mimetype = ? AND data1 = ? AND contact_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {3},new Object[] {_mime,_data1value,BA.NumberToString(_id)})));
 BA.debugLineNum = 306;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deleteemail(RemoteObject __ref,RemoteObject _id,RemoteObject _email) throws Exception{
try {
		Debug.PushSubsStack("DeleteEmail (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,288);
if (RapidSub.canDelegate("deleteemail")) { return __ref.runUserSub(false, "contactsutils","deleteemail", __ref, _id, _email);}
Debug.locals.put("Id", _id);
Debug.locals.put("Email", _email);
 BA.debugLineNum = 288;BA.debugLine="Public Sub DeleteEmail(Id As Long,Email As String)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 289;BA.debugLine="DeleteData(\"vnd.android.cursor.item/email_v2\", Em";
Debug.ShouldStop(1);
__ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_deletedata",(Object)(BA.ObjectToString("vnd.android.cursor.item/email_v2")),(Object)(_email),(Object)(_id));
 BA.debugLineNum = 290;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deletephone(RemoteObject __ref,RemoteObject _id,RemoteObject _phonenumber) throws Exception{
try {
		Debug.PushSubsStack("DeletePhone (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,284);
if (RapidSub.canDelegate("deletephone")) { return __ref.runUserSub(false, "contactsutils","deletephone", __ref, _id, _phonenumber);}
Debug.locals.put("Id", _id);
Debug.locals.put("PhoneNumber", _phonenumber);
 BA.debugLineNum = 284;BA.debugLine="Public Sub DeletePhone(Id As Long, PhoneNumber As";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 285;BA.debugLine="DeleteData(\"vnd.android.cursor.item/phone_v2\", Ph";
Debug.ShouldStop(268435456);
__ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_deletedata",(Object)(BA.ObjectToString("vnd.android.cursor.item/phone_v2")),(Object)(_phonenumber),(Object)(_id));
 BA.debugLineNum = 286;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _fillgroupsources(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("FillGroupSources (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,355);
if (RapidSub.canDelegate("fillgroupsources")) { return __ref.runUserSub(false, "contactsutils","fillgroupsources", __ref);}
RemoteObject _gu = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
int _i = 0;
 BA.debugLineNum = 355;BA.debugLine="Private Sub FillGroupSources";
Debug.ShouldStop(4);
 BA.debugLineNum = 356;BA.debugLine="If GroupSources.IsInitialized = False Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_groupsources").runMethod(true,"IsInitialized"),contactsutils.__c.getField(true,"False"))) { 
 BA.debugLineNum = 357;BA.debugLine="GroupSources.Initialize";
Debug.ShouldStop(16);
__ref.getField(false,"_groupsources").runVoidMethod ("Initialize");
 BA.debugLineNum = 358;BA.debugLine="Dim gu As Uri";
Debug.ShouldStop(32);
_gu = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("gu", _gu);
 BA.debugLineNum = 359;BA.debugLine="gu.Parse(\"content://com.android.contacts/groups\"";
Debug.ShouldStop(64);
_gu.runVoidMethod ("Parse",(Object)(RemoteObject.createImmutable("content://com.android.contacts/groups")));
 BA.debugLineNum = 360;BA.debugLine="Dim c As Cursor = cr.Query(gu, Array As String(\"";
Debug.ShouldStop(128);
_c = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_c = __ref.getField(false,"_cr").runMethod(false,"Query",(Object)(_gu),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("sourceid"),RemoteObject.createImmutable("title")})),(Object)(BA.ObjectToString("")),(Object)((contactsutils.__c.getField(false,"Null"))),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("c", _c);Debug.locals.put("c", _c);
 BA.debugLineNum = 361;BA.debugLine="For i = 0 To c.RowCount - 1";
Debug.ShouldStop(256);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_c.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 362;BA.debugLine="c.Position = i";
Debug.ShouldStop(512);
_c.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 363;BA.debugLine="GroupSources.Put(c.GetString(\"sourceid\"), c.Get";
Debug.ShouldStop(1024);
__ref.getField(false,"_groupsources").runVoidMethod ("Put",(Object)((_c.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("sourceid"))))),(Object)((_c.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("title"))))));
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 366;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findallcontacts(RemoteObject __ref,RemoteObject _visibleonly) throws Exception{
try {
		Debug.PushSubsStack("FindAllContacts (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,88);
if (RapidSub.canDelegate("findallcontacts")) { return __ref.runUserSub(false, "contactsutils","findallcontacts", __ref, _visibleonly);}
Debug.locals.put("VisibleOnly", _visibleonly);
 BA.debugLineNum = 88;BA.debugLine="Public Sub FindAllContacts(VisibleOnly As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
Debug.ShouldStop(16777216);
if (true) return __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_findcontactsidfromdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/name")),(Object)(BA.ObjectToString("data1")),(Object)(BA.ObjectToString("null")),(Object)(BA.ObjectToString("<>")),(Object)(contactsutils.__c.getField(true,"True")),(Object)(_visibleonly));
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findcontactsbymail(RemoteObject __ref,RemoteObject _mail,RemoteObject _exact,RemoteObject _visibleonly) throws Exception{
try {
		Debug.PushSubsStack("FindContactsByMail (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,67);
if (RapidSub.canDelegate("findcontactsbymail")) { return __ref.runUserSub(false, "contactsutils","findcontactsbymail", __ref, _mail, _exact, _visibleonly);}
Debug.locals.put("Mail", _mail);
Debug.locals.put("Exact", _exact);
Debug.locals.put("VisibleOnly", _visibleonly);
 BA.debugLineNum = 67;BA.debugLine="Public Sub FindContactsByMail(Mail As String, Exac";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
Debug.ShouldStop(8);
if (true) return __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_findcontactsidfromdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/email_v2")),(Object)(BA.ObjectToString("data1")),(Object)(_mail),(Object)(BA.ObjectToString("=")),(Object)(_exact),(Object)(_visibleonly));
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findcontactsbyname(RemoteObject __ref,RemoteObject _name,RemoteObject _exact,RemoteObject _visibleonly) throws Exception{
try {
		Debug.PushSubsStack("FindContactsByName (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,62);
if (RapidSub.canDelegate("findcontactsbyname")) { return __ref.runUserSub(false, "contactsutils","findcontactsbyname", __ref, _name, _exact, _visibleonly);}
Debug.locals.put("Name", _name);
Debug.locals.put("Exact", _exact);
Debug.locals.put("VisibleOnly", _visibleonly);
 BA.debugLineNum = 62;BA.debugLine="Public Sub FindContactsByName(Name As String, Exac";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
Debug.ShouldStop(1073741824);
if (true) return __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_findcontactsidfromdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/name")),(Object)(BA.ObjectToString("data1")),(Object)(_name),(Object)(BA.ObjectToString("=")),(Object)(_exact),(Object)(_visibleonly));
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findcontactsbynotes(RemoteObject __ref,RemoteObject _note,RemoteObject _exact,RemoteObject _visibleonly) throws Exception{
try {
		Debug.PushSubsStack("FindContactsByNotes (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,72);
if (RapidSub.canDelegate("findcontactsbynotes")) { return __ref.runUserSub(false, "contactsutils","findcontactsbynotes", __ref, _note, _exact, _visibleonly);}
Debug.locals.put("Note", _note);
Debug.locals.put("Exact", _exact);
Debug.locals.put("VisibleOnly", _visibleonly);
 BA.debugLineNum = 72;BA.debugLine="Public Sub FindContactsByNotes(Note As String, Exa";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
Debug.ShouldStop(256);
if (true) return __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_findcontactsidfromdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/note")),(Object)(BA.ObjectToString("data1")),(Object)(_note),(Object)(BA.ObjectToString("=")),(Object)(_exact),(Object)(_visibleonly));
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findcontactsbyphone(RemoteObject __ref,RemoteObject _phonenumber,RemoteObject _exact,RemoteObject _visibleonly) throws Exception{
try {
		Debug.PushSubsStack("FindContactsByPhone (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,77);
if (RapidSub.canDelegate("findcontactsbyphone")) { return __ref.runUserSub(false, "contactsutils","findcontactsbyphone", __ref, _phonenumber, _exact, _visibleonly);}
Debug.locals.put("PhoneNumber", _phonenumber);
Debug.locals.put("Exact", _exact);
Debug.locals.put("VisibleOnly", _visibleonly);
 BA.debugLineNum = 77;BA.debugLine="Public Sub FindContactsByPhone(PhoneNumber As Stri";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
Debug.ShouldStop(8192);
if (true) return __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_findcontactsidfromdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/phone_v2")),(Object)(BA.ObjectToString("data1")),(Object)(_phonenumber),(Object)(BA.ObjectToString("=")),(Object)(_exact),(Object)(_visibleonly));
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findcontactsbystarred(RemoteObject __ref,RemoteObject _starred) throws Exception{
try {
		Debug.PushSubsStack("FindContactsByStarred (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,82);
if (RapidSub.canDelegate("findcontactsbystarred")) { return __ref.runUserSub(false, "contactsutils","findcontactsbystarred", __ref, _starred);}
RemoteObject _value = RemoteObject.createImmutable("");
Debug.locals.put("Starred", _starred);
 BA.debugLineNum = 82;BA.debugLine="Public Sub FindContactsByStarred(Starred As Boolea";
Debug.ShouldStop(131072);
 BA.debugLineNum = 83;BA.debugLine="Dim value As String";
Debug.ShouldStop(262144);
_value = RemoteObject.createImmutable("");Debug.locals.put("value", _value);
 BA.debugLineNum = 84;BA.debugLine="If Starred Then value = \"1\" Else value = \"0\"";
Debug.ShouldStop(524288);
if (_starred.<Boolean>get().booleanValue()) { 
_value = BA.ObjectToString("1");Debug.locals.put("value", _value);}
else {
_value = BA.ObjectToString("0");Debug.locals.put("value", _value);};
 BA.debugLineNum = 85;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
Debug.ShouldStop(1048576);
if (true) return __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_findcontactsidfromdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/name")),(Object)(BA.ObjectToString("starred")),(Object)(_value),(Object)(BA.ObjectToString("=")),(Object)(contactsutils.__c.getField(true,"True")),(Object)(contactsutils.__c.getField(true,"True")));
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findcontactsidfromdata(RemoteObject __ref,RemoteObject _mime,RemoteObject _datacolumn,RemoteObject _value,RemoteObject _operator,RemoteObject _exact,RemoteObject _visibleonly) throws Exception{
try {
		Debug.PushSubsStack("FindContactsIdFromData (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,110);
if (RapidSub.canDelegate("findcontactsidfromdata")) { return __ref.runUserSub(false, "contactsutils","findcontactsidfromdata", __ref, _mime, _datacolumn, _value, _operator, _exact, _visibleonly);}
RemoteObject _selection = RemoteObject.createImmutable("");
RemoteObject _crsr = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
RemoteObject _cu = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cucontact");
Debug.locals.put("Mime", _mime);
Debug.locals.put("DataColumn", _datacolumn);
Debug.locals.put("Value", _value);
Debug.locals.put("Operator", _operator);
Debug.locals.put("Exact", _exact);
Debug.locals.put("VisibleOnly", _visibleonly);
 BA.debugLineNum = 110;BA.debugLine="Private Sub FindContactsIdFromData (Mime As String";
Debug.ShouldStop(8192);
 BA.debugLineNum = 112;BA.debugLine="If Not(Exact) Then";
Debug.ShouldStop(32768);
if (contactsutils.__c.runMethod(true,"Not",(Object)(_exact)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 113;BA.debugLine="Operator = \"LIKE\"";
Debug.ShouldStop(65536);
_operator = BA.ObjectToString("LIKE");Debug.locals.put("Operator", _operator);
 BA.debugLineNum = 114;BA.debugLine="Value = \"%\" & Value & \"%\"";
Debug.ShouldStop(131072);
_value = RemoteObject.concat(RemoteObject.createImmutable("%"),_value,RemoteObject.createImmutable("%"));Debug.locals.put("Value", _value);
 };
 BA.debugLineNum = 116;BA.debugLine="Dim selection As String = \"mimetype = ? AND \" & D";
Debug.ShouldStop(524288);
_selection = RemoteObject.concat(RemoteObject.createImmutable("mimetype = ? AND "),_datacolumn,RemoteObject.createImmutable(" "),_operator,RemoteObject.createImmutable(" ? "));Debug.locals.put("selection", _selection);Debug.locals.put("selection", _selection);
 BA.debugLineNum = 117;BA.debugLine="If VisibleOnly Then selection = selection & \" AND";
Debug.ShouldStop(1048576);
if (_visibleonly.<Boolean>get().booleanValue()) { 
_selection = RemoteObject.concat(_selection,RemoteObject.createImmutable(" AND in_visible_group = 1"));Debug.locals.put("selection", _selection);};
 BA.debugLineNum = 118;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, Array As S";
Debug.ShouldStop(2097152);
_crsr = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_crsr = __ref.getField(false,"_cr").runMethod(false,"Query",(Object)(__ref.getField(false,"_datauri")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("contact_id"),RemoteObject.createImmutable("display_name")})),(Object)(_selection),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {_mime,_value})),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("crsr", _crsr);Debug.locals.put("crsr", _crsr);
 BA.debugLineNum = 120;BA.debugLine="Dim res As List";
Debug.ShouldStop(8388608);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 121;BA.debugLine="res.Initialize";
Debug.ShouldStop(16777216);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 122;BA.debugLine="Dim m As Map";
Debug.ShouldStop(33554432);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 123;BA.debugLine="m.Initialize";
Debug.ShouldStop(67108864);
_m.runVoidMethod ("Initialize");
 BA.debugLineNum = 124;BA.debugLine="For i = 0 To crsr.RowCount - 1";
Debug.ShouldStop(134217728);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {_crsr.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12) ;_i = ((int)(0 + _i + step12))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 125;BA.debugLine="crsr.Position = i";
Debug.ShouldStop(268435456);
_crsr.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 126;BA.debugLine="Dim cu As cuContact";
Debug.ShouldStop(536870912);
_cu = RemoteObject.createNew ("com.no3dlauncher.contactsutils._cucontact");Debug.locals.put("cu", _cu);
 BA.debugLineNum = 127;BA.debugLine="cu.Initialize";
Debug.ShouldStop(1073741824);
_cu.runVoidMethod ("Initialize");
 BA.debugLineNum = 128;BA.debugLine="cu.Id = crsr.GetLong(\"contact_id\")";
Debug.ShouldStop(-2147483648);
_cu.setField ("Id",_crsr.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("contact_id"))));
 BA.debugLineNum = 129;BA.debugLine="cu.DisplayName = crsr.GetString(\"display_name\")";
Debug.ShouldStop(1);
_cu.setField ("DisplayName",_crsr.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("display_name"))));
 BA.debugLineNum = 130;BA.debugLine="If m.ContainsKey(cu.Id) Then Continue";
Debug.ShouldStop(2);
if (_m.runMethod(true,"ContainsKey",(Object)((_cu.getField(true,"Id")))).<Boolean>get().booleanValue()) { 
if (true) continue;};
 BA.debugLineNum = 131;BA.debugLine="m.Put(cu.Id, Null)";
Debug.ShouldStop(4);
_m.runVoidMethod ("Put",(Object)((_cu.getField(true,"Id"))),(Object)(contactsutils.__c.getField(false,"Null")));
 BA.debugLineNum = 132;BA.debugLine="res.Add(cu)";
Debug.ShouldStop(8);
_res.runVoidMethod ("Add",(Object)((_cu)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 134;BA.debugLine="crsr.Close";
Debug.ShouldStop(32);
_crsr.runVoidMethod ("Close");
 BA.debugLineNum = 135;BA.debugLine="Return res";
Debug.ShouldStop(64);
if (true) return _res;
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findcontactswithphotos(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("FindContactsWithPhotos (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,92);
if (RapidSub.canDelegate("findcontactswithphotos")) { return __ref.runUserSub(false, "contactsutils","findcontactswithphotos", __ref);}
 BA.debugLineNum = 92;BA.debugLine="Public Sub FindContactsWithPhotos As List";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="Return FindContactsIdFromData(\"vnd.android.cursor";
Debug.ShouldStop(268435456);
if (true) return __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_findcontactsidfromdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/photo")),(Object)(BA.ObjectToString("data15")),(Object)(BA.ObjectToString("null")),(Object)(BA.ObjectToString("<>")),(Object)(contactsutils.__c.getField(true,"True")),(Object)(contactsutils.__c.getField(true,"False")));
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getaccounts(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetAccounts (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,340);
if (RapidSub.canDelegate("getaccounts")) { return __ref.runUserSub(false, "contactsutils","getaccounts", __ref, _id);}
RemoteObject _uri = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _m = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
Debug.locals.put("Id", _id);
 BA.debugLineNum = 340;BA.debugLine="Public Sub GetAccounts(Id As Long) As Map";
Debug.ShouldStop(524288);
 BA.debugLineNum = 341;BA.debugLine="Dim uri As Uri";
Debug.ShouldStop(1048576);
_uri = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("uri", _uri);
 BA.debugLineNum = 342;BA.debugLine="uri.Parse(\"content://com.android.contacts/contact";
Debug.ShouldStop(2097152);
_uri.runVoidMethod ("Parse",(Object)(RemoteObject.concat(RemoteObject.createImmutable("content://com.android.contacts/contacts/"),_id,RemoteObject.createImmutable("/entities"))));
 BA.debugLineNum = 343;BA.debugLine="Dim c As Cursor = cr.Query(uri, Array As String(\"";
Debug.ShouldStop(4194304);
_c = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_c = __ref.getField(false,"_cr").runMethod(false,"Query",(Object)(_uri),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("account_name"),RemoteObject.createImmutable("account_type")})),(Object)(BA.ObjectToString("")),(Object)((contactsutils.__c.getField(false,"Null"))),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("c", _c);Debug.locals.put("c", _c);
 BA.debugLineNum = 344;BA.debugLine="Dim m As Map";
Debug.ShouldStop(8388608);
_m = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("m", _m);
 BA.debugLineNum = 345;BA.debugLine="m.Initialize";
Debug.ShouldStop(16777216);
_m.runVoidMethod ("Initialize");
 BA.debugLineNum = 346;BA.debugLine="For i = 0 To c.RowCount - 1";
Debug.ShouldStop(33554432);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_c.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 347;BA.debugLine="c.Position = i";
Debug.ShouldStop(67108864);
_c.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 348;BA.debugLine="m.Put(c.GetString(\"account_name\"), c.GetString(\"";
Debug.ShouldStop(134217728);
_m.runVoidMethod ("Put",(Object)((_c.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("account_name"))))),(Object)((_c.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("account_type"))))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 350;BA.debugLine="c.Close";
Debug.ShouldStop(536870912);
_c.runVoidMethod ("Close");
 BA.debugLineNum = 352;BA.debugLine="Return m";
Debug.ShouldStop(-2147483648);
if (true) return _m;
 BA.debugLineNum = 353;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdata(RemoteObject __ref,RemoteObject _mime,RemoteObject _datacolumns,RemoteObject _id,RemoteObject _blobs) throws Exception{
try {
		Debug.PushSubsStack("GetData (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,227);
if (RapidSub.canDelegate("getdata")) { return __ref.runUserSub(false, "contactsutils","getdata", __ref, _mime, _datacolumns, _id, _blobs);}
RemoteObject _crsr = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _row = null;
int _c = 0;
Debug.locals.put("Mime", _mime);
Debug.locals.put("DataColumns", _datacolumns);
Debug.locals.put("Id", _id);
Debug.locals.put("Blobs", _blobs);
 BA.debugLineNum = 227;BA.debugLine="Private Sub GetData(Mime As String, DataColumns()";
Debug.ShouldStop(4);
 BA.debugLineNum = 228;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, DataColumn";
Debug.ShouldStop(8);
_crsr = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_crsr = __ref.getField(false,"_cr").runMethod(false,"Query",(Object)(__ref.getField(false,"_datauri")),(Object)(_datacolumns),(Object)(BA.ObjectToString("mimetype = ? AND contact_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {_mime,BA.NumberToString(_id)})),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("crsr", _crsr);Debug.locals.put("crsr", _crsr);
 BA.debugLineNum = 230;BA.debugLine="Dim res As List";
Debug.ShouldStop(32);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 231;BA.debugLine="res.Initialize";
Debug.ShouldStop(64);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 232;BA.debugLine="For i = 0 To crsr.RowCount - 1";
Debug.ShouldStop(128);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_crsr.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 233;BA.debugLine="crsr.Position = i";
Debug.ShouldStop(256);
_crsr.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 234;BA.debugLine="Dim row(DataColumns.Length) As Object";
Debug.ShouldStop(512);
_row = RemoteObject.createNewArray ("Object", new int[] {_datacolumns.getField(true,"length").<Integer>get().intValue()}, new Object[]{});Debug.locals.put("row", _row);
 BA.debugLineNum = 235;BA.debugLine="For c = 0 To DataColumns.Length - 1";
Debug.ShouldStop(1024);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_datacolumns.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_c = 0 ;
for (;(step7 > 0 && _c <= limit7) || (step7 < 0 && _c >= limit7) ;_c = ((int)(0 + _c + step7))  ) {
Debug.locals.put("c", _c);
 BA.debugLineNum = 236;BA.debugLine="If  Blobs <> Null And Blobs(c) = True Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("N",_blobs) && RemoteObject.solveBoolean("=",_blobs.getArrayElement(true,BA.numberCast(int.class, _c)),contactsutils.__c.getField(true,"True"))) { 
 BA.debugLineNum = 237;BA.debugLine="row(c) = crsr.GetBlob2(c)";
Debug.ShouldStop(4096);
_row.setArrayElement ((_crsr.runMethod(false,"GetBlob2",(Object)(BA.numberCast(int.class, _c)))),BA.numberCast(int.class, _c));
 }else {
 BA.debugLineNum = 239;BA.debugLine="row(c) = crsr.GetString2(c)";
Debug.ShouldStop(16384);
_row.setArrayElement ((_crsr.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _c)))),BA.numberCast(int.class, _c));
 };
 }
}Debug.locals.put("c", _c);
;
 BA.debugLineNum = 242;BA.debugLine="res.Add(row)";
Debug.ShouldStop(131072);
_res.runVoidMethod ("Add",(Object)((_row)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 244;BA.debugLine="crsr.Close";
Debug.ShouldStop(524288);
_crsr.runVoidMethod ("Close");
 BA.debugLineNum = 245;BA.debugLine="Return res";
Debug.ShouldStop(1048576);
if (true) return _res;
 BA.debugLineNum = 246;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getemails(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetEmails (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,152);
if (RapidSub.canDelegate("getemails")) { return __ref.runUserSub(false, "contactsutils","getemails", __ref, _id);}
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _obj = null;
RemoteObject _e = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cuemail");
Debug.locals.put("Id", _id);
 BA.debugLineNum = 152;BA.debugLine="Public Sub GetEmails(Id As Long) As List";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 153;BA.debugLine="Dim res As List";
Debug.ShouldStop(16777216);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 154;BA.debugLine="res.Initialize";
Debug.ShouldStop(33554432);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 155;BA.debugLine="For Each obj() As Object In GetData(\"vnd.android.";
Debug.ShouldStop(67108864);
{
final RemoteObject group3 = __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_getdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/email_v2")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("data1"),RemoteObject.createImmutable("data2")})),(Object)(_id),(Object)((contactsutils.__c.getField(false,"Null"))));
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_obj = (group3.runMethod(false,"Get",index3));Debug.locals.put("obj", _obj);
Debug.locals.put("obj", _obj);
 BA.debugLineNum = 156;BA.debugLine="Dim e As cuEmail";
Debug.ShouldStop(134217728);
_e = RemoteObject.createNew ("com.no3dlauncher.contactsutils._cuemail");Debug.locals.put("e", _e);
 BA.debugLineNum = 157;BA.debugLine="e.Initialize";
Debug.ShouldStop(268435456);
_e.runVoidMethod ("Initialize");
 BA.debugLineNum = 158;BA.debugLine="e.Email = obj(0)";
Debug.ShouldStop(536870912);
_e.setField ("Email",BA.ObjectToString(_obj.getArrayElement(false,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 159;BA.debugLine="e.EmailType = mailTypes.Get(obj(1))";
Debug.ShouldStop(1073741824);
_e.setField ("EmailType",BA.ObjectToString(__ref.getField(false,"_mailtypes").runMethod(false,"Get",(Object)(_obj.getArrayElement(false,BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 160;BA.debugLine="res.Add(e)";
Debug.ShouldStop(-2147483648);
_res.runVoidMethod ("Add",(Object)((_e)));
 }
}Debug.locals.put("obj", _obj);
;
 BA.debugLineNum = 162;BA.debugLine="Return res";
Debug.ShouldStop(2);
if (true) return _res;
 BA.debugLineNum = 163;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getevents(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetEvents (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,165);
if (RapidSub.canDelegate("getevents")) { return __ref.runUserSub(false, "contactsutils","getevents", __ref, _id);}
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _obj = null;
RemoteObject _e = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cuevent");
Debug.locals.put("Id", _id);
 BA.debugLineNum = 165;BA.debugLine="Public Sub GetEvents(Id As Long) As List";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="Dim res As List";
Debug.ShouldStop(32);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 167;BA.debugLine="res.Initialize";
Debug.ShouldStop(64);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 168;BA.debugLine="For Each obj() As Object In GetData(\"vnd.android.";
Debug.ShouldStop(128);
{
final RemoteObject group3 = __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_getdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/contact_event")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("data1"),RemoteObject.createImmutable("data2")})),(Object)(_id),(Object)((contactsutils.__c.getField(false,"Null"))));
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_obj = (group3.runMethod(false,"Get",index3));Debug.locals.put("obj", _obj);
Debug.locals.put("obj", _obj);
 BA.debugLineNum = 169;BA.debugLine="Dim e As cuEvent";
Debug.ShouldStop(256);
_e = RemoteObject.createNew ("com.no3dlauncher.contactsutils._cuevent");Debug.locals.put("e", _e);
 BA.debugLineNum = 170;BA.debugLine="e.Initialize";
Debug.ShouldStop(512);
_e.runVoidMethod ("Initialize");
 BA.debugLineNum = 171;BA.debugLine="e.DateString = obj(0)";
Debug.ShouldStop(1024);
_e.setField ("DateString",BA.ObjectToString(_obj.getArrayElement(false,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 172;BA.debugLine="e.EventType = eventTypes.Get(obj(1))";
Debug.ShouldStop(2048);
_e.setField ("EventType",BA.ObjectToString(__ref.getField(false,"_eventtypes").runMethod(false,"Get",(Object)(_obj.getArrayElement(false,BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 173;BA.debugLine="res.Add(e)";
Debug.ShouldStop(4096);
_res.runVoidMethod ("Add",(Object)((_e)));
 }
}Debug.locals.put("obj", _obj);
;
 BA.debugLineNum = 175;BA.debugLine="Return res";
Debug.ShouldStop(16384);
if (true) return _res;
 BA.debugLineNum = 176;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getgroups(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetGroups (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,368);
if (RapidSub.canDelegate("getgroups")) { return __ref.runUserSub(false, "contactsutils","getgroups", __ref, _id);}
RemoteObject _uri = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _groups = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _source = RemoteObject.createImmutable("");
Debug.locals.put("Id", _id);
 BA.debugLineNum = 368;BA.debugLine="Public Sub GetGroups(Id As Long) As List";
Debug.ShouldStop(32768);
 BA.debugLineNum = 369;BA.debugLine="FillGroupSources";
Debug.ShouldStop(65536);
__ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_fillgroupsources");
 BA.debugLineNum = 370;BA.debugLine="Dim uri As Uri";
Debug.ShouldStop(131072);
_uri = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");Debug.locals.put("uri", _uri);
 BA.debugLineNum = 371;BA.debugLine="uri.Parse(\"content://com.android.contacts/contact";
Debug.ShouldStop(262144);
_uri.runVoidMethod ("Parse",(Object)(RemoteObject.concat(RemoteObject.createImmutable("content://com.android.contacts/contacts/"),_id,RemoteObject.createImmutable("/entities"))));
 BA.debugLineNum = 372;BA.debugLine="Dim c As Cursor = cr.Query(uri, Array As String(\"";
Debug.ShouldStop(524288);
_c = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_c = __ref.getField(false,"_cr").runMethod(false,"Query",(Object)(_uri),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("group_sourceid")})),(Object)(BA.ObjectToString("")),(Object)((contactsutils.__c.getField(false,"Null"))),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("c", _c);Debug.locals.put("c", _c);
 BA.debugLineNum = 373;BA.debugLine="Dim groups As List";
Debug.ShouldStop(1048576);
_groups = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("groups", _groups);
 BA.debugLineNum = 374;BA.debugLine="groups.Initialize";
Debug.ShouldStop(2097152);
_groups.runVoidMethod ("Initialize");
 BA.debugLineNum = 375;BA.debugLine="For i = 0 To c.RowCount - 1";
Debug.ShouldStop(4194304);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_c.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 376;BA.debugLine="c.Position = i";
Debug.ShouldStop(8388608);
_c.runMethod(true,"setPosition",BA.numberCast(int.class, _i));
 BA.debugLineNum = 377;BA.debugLine="If c.GetString(\"group_sourceid\") <> Null Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("N",_c.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("group_sourceid"))))) { 
 BA.debugLineNum = 378;BA.debugLine="Dim source As String = c.GetString(\"group_sourc";
Debug.ShouldStop(33554432);
_source = _c.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("group_sourceid")));Debug.locals.put("source", _source);Debug.locals.put("source", _source);
 BA.debugLineNum = 379;BA.debugLine="If GroupSources.ContainsKey(source) Then";
Debug.ShouldStop(67108864);
if (__ref.getField(false,"_groupsources").runMethod(true,"ContainsKey",(Object)((_source))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 380;BA.debugLine="groups.Add(GroupSources.Get(source))";
Debug.ShouldStop(134217728);
_groups.runVoidMethod ("Add",(Object)(__ref.getField(false,"_groupsources").runMethod(false,"Get",(Object)((_source)))));
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 384;BA.debugLine="c.Close";
Debug.ShouldStop(-2147483648);
_c.runVoidMethod ("Close");
 BA.debugLineNum = 385;BA.debugLine="Return groups";
Debug.ShouldStop(1);
if (true) return _groups;
 BA.debugLineNum = 386;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getkeyfromvalue(RemoteObject __ref,RemoteObject _m,RemoteObject _v,RemoteObject _defaultvalue) throws Exception{
try {
		Debug.PushSubsStack("GetKeyFromValue (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,293);
if (RapidSub.canDelegate("getkeyfromvalue")) { return __ref.runUserSub(false, "contactsutils","getkeyfromvalue", __ref, _m, _v, _defaultvalue);}
RemoteObject _t = RemoteObject.createImmutable(0);
int _i = 0;
Debug.locals.put("m", _m);
Debug.locals.put("v", _v);
Debug.locals.put("defaultValue", _defaultvalue);
 BA.debugLineNum = 293;BA.debugLine="Private Sub GetKeyFromValue(m As Map, v As String,";
Debug.ShouldStop(16);
 BA.debugLineNum = 294;BA.debugLine="Dim t As Int = defaultValue";
Debug.ShouldStop(32);
_t = _defaultvalue;Debug.locals.put("t", _t);Debug.locals.put("t", _t);
 BA.debugLineNum = 295;BA.debugLine="For i = 0 To m.Size - 1";
Debug.ShouldStop(64);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {_m.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 296;BA.debugLine="If m.GetValueAt(i) = v Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_m.runMethod(false,"GetValueAt",(Object)(BA.numberCast(int.class, _i))),(_v))) { 
 BA.debugLineNum = 297;BA.debugLine="t = m.GetKeyAt(i)";
Debug.ShouldStop(256);
_t = BA.numberCast(int.class, _m.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("t", _t);
 BA.debugLineNum = 298;BA.debugLine="Exit";
Debug.ShouldStop(512);
if (true) break;
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 301;BA.debugLine="Return t";
Debug.ShouldStop(4096);
if (true) return _t;
 BA.debugLineNum = 302;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getnamefromid(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetNameFromId (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,96);
if (RapidSub.canDelegate("getnamefromid")) { return __ref.runUserSub(false, "contactsutils","getnamefromid", __ref, _id);}
RemoteObject _crsr = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _name = RemoteObject.createImmutable("");
Debug.locals.put("id", _id);
 BA.debugLineNum = 96;BA.debugLine="Public Sub GetNameFromId (id As String) As String";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, Array As S";
Debug.ShouldStop(1);
_crsr = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_crsr = __ref.getField(false,"_cr").runMethod(false,"Query",(Object)(__ref.getField(false,"_datauri")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("contact_id"),RemoteObject.createImmutable("display_name")})),(Object)(BA.ObjectToString("contact_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {_id})),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("crsr", _crsr);Debug.locals.put("crsr", _crsr);
 BA.debugLineNum = 99;BA.debugLine="Dim name As String";
Debug.ShouldStop(4);
_name = RemoteObject.createImmutable("");Debug.locals.put("name", _name);
 BA.debugLineNum = 100;BA.debugLine="If crsr.RowCount = 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_crsr.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 101;BA.debugLine="Log(\"Contact not found: \" & id)";
Debug.ShouldStop(16);
contactsutils.__c.runVoidMethod ("LogImpl","77864325",RemoteObject.concat(RemoteObject.createImmutable("Contact not found: "),_id),0);
 }else {
 BA.debugLineNum = 103;BA.debugLine="crsr.Position = 0";
Debug.ShouldStop(64);
_crsr.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 104;BA.debugLine="name = crsr.GetString2(1)";
Debug.ShouldStop(128);
_name = _crsr.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 1)));Debug.locals.put("name", _name);
 };
 BA.debugLineNum = 106;BA.debugLine="crsr.Close";
Debug.ShouldStop(512);
_crsr.runVoidMethod ("Close");
 BA.debugLineNum = 107;BA.debugLine="Return name";
Debug.ShouldStop(1024);
if (true) return _name;
 BA.debugLineNum = 108;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getnote(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetNote (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,193);
if (RapidSub.canDelegate("getnote")) { return __ref.runUserSub(false, "contactsutils","getnote", __ref, _id);}
RemoteObject _raw = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _obj = null;
Debug.locals.put("id", _id);
 BA.debugLineNum = 193;BA.debugLine="Public Sub GetNote(id As Long) As String";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="Dim raw As List = GetData(\"vnd.android.cursor.ite";
Debug.ShouldStop(2);
_raw = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_raw = __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_getdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/note")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("data1")})),(Object)(_id),(Object)((contactsutils.__c.getField(false,"Null"))));Debug.locals.put("raw", _raw);Debug.locals.put("raw", _raw);
 BA.debugLineNum = 195;BA.debugLine="If raw.Size = 0 Then Return \"\"";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",_raw.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
if (true) return BA.ObjectToString("");};
 BA.debugLineNum = 196;BA.debugLine="Dim obj() As Object = raw.Get(0)";
Debug.ShouldStop(8);
_obj = (_raw.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("obj", _obj);Debug.locals.put("obj", _obj);
 BA.debugLineNum = 197;BA.debugLine="Return obj(0)";
Debug.ShouldStop(16);
if (true) return BA.ObjectToString(_obj.getArrayElement(false,BA.numberCast(int.class, 0)));
 BA.debugLineNum = 198;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getorganization(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetOrganization (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,138);
if (RapidSub.canDelegate("getorganization")) { return __ref.runUserSub(false, "contactsutils","getorganization", __ref, _id);}
RemoteObject _organizations = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _o = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cuorganization");
RemoteObject _obj = null;
Debug.locals.put("Id", _id);
 BA.debugLineNum = 138;BA.debugLine="Public Sub GetOrganization(Id As Long) As cuOrgani";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="Dim organizations As List = GetData(\"vnd.android.";
Debug.ShouldStop(1024);
_organizations = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_organizations = __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_getdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/organization")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("data1"),RemoteObject.createImmutable("data4")})),(Object)(_id),(Object)((contactsutils.__c.getField(false,"Null"))));Debug.locals.put("organizations", _organizations);Debug.locals.put("organizations", _organizations);
 BA.debugLineNum = 141;BA.debugLine="Dim o As cuOrganization";
Debug.ShouldStop(4096);
_o = RemoteObject.createNew ("com.no3dlauncher.contactsutils._cuorganization");Debug.locals.put("o", _o);
 BA.debugLineNum = 142;BA.debugLine="If organizations.Size > 0 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean(">",_organizations.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 143;BA.debugLine="o.Initialize";
Debug.ShouldStop(16384);
_o.runVoidMethod ("Initialize");
 BA.debugLineNum = 144;BA.debugLine="Dim obj() As Object = organizations.Get(0)";
Debug.ShouldStop(32768);
_obj = (_organizations.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("obj", _obj);Debug.locals.put("obj", _obj);
 BA.debugLineNum = 145;BA.debugLine="o.Company = obj(0)";
Debug.ShouldStop(65536);
_o.setField ("Company",BA.ObjectToString(_obj.getArrayElement(false,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 146;BA.debugLine="o.Title = obj(1)";
Debug.ShouldStop(131072);
_o.setField ("Title",BA.ObjectToString(_obj.getArrayElement(false,BA.numberCast(int.class, 1))));
 };
 BA.debugLineNum = 148;BA.debugLine="Return o";
Debug.ShouldStop(524288);
if (true) return _o;
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getphones(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetPhones (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,179);
if (RapidSub.canDelegate("getphones")) { return __ref.runUserSub(false, "contactsutils","getphones", __ref, _id);}
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _obj = null;
RemoteObject _p = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cuphone");
Debug.locals.put("id", _id);
 BA.debugLineNum = 179;BA.debugLine="Public Sub GetPhones(id As Long) As List";
Debug.ShouldStop(262144);
 BA.debugLineNum = 180;BA.debugLine="Dim res As List";
Debug.ShouldStop(524288);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 181;BA.debugLine="res.Initialize";
Debug.ShouldStop(1048576);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 182;BA.debugLine="For Each obj() As Object In GetData(\"vnd.android.";
Debug.ShouldStop(2097152);
{
final RemoteObject group3 = __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_getdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/phone_v2")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("data1"),RemoteObject.createImmutable("data2")})),(Object)(_id),(Object)((contactsutils.__c.getField(false,"Null"))));
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_obj = (group3.runMethod(false,"Get",index3));Debug.locals.put("obj", _obj);
Debug.locals.put("obj", _obj);
 BA.debugLineNum = 183;BA.debugLine="Dim p As cuPhone";
Debug.ShouldStop(4194304);
_p = RemoteObject.createNew ("com.no3dlauncher.contactsutils._cuphone");Debug.locals.put("p", _p);
 BA.debugLineNum = 184;BA.debugLine="p.Initialize";
Debug.ShouldStop(8388608);
_p.runVoidMethod ("Initialize");
 BA.debugLineNum = 185;BA.debugLine="p.Number = obj(0)";
Debug.ShouldStop(16777216);
_p.setField ("Number",BA.ObjectToString(_obj.getArrayElement(false,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 186;BA.debugLine="p.PhoneType = phoneTypes.Get(obj(1))";
Debug.ShouldStop(33554432);
_p.setField ("PhoneType",BA.ObjectToString(__ref.getField(false,"_phonetypes").runMethod(false,"Get",(Object)(_obj.getArrayElement(false,BA.numberCast(int.class, 1))))));
 BA.debugLineNum = 187;BA.debugLine="res.Add(p)";
Debug.ShouldStop(67108864);
_res.runVoidMethod ("Add",(Object)((_p)));
 }
}Debug.locals.put("obj", _obj);
;
 BA.debugLineNum = 189;BA.debugLine="Return res";
Debug.ShouldStop(268435456);
if (true) return _res;
 BA.debugLineNum = 190;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getphoto(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetPhoto (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,201);
if (RapidSub.canDelegate("getphoto")) { return __ref.runUserSub(false, "contactsutils","getphoto", __ref, _id);}
RemoteObject _raw = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _obj = null;
RemoteObject _bytes = null;
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
Debug.locals.put("Id", _id);
 BA.debugLineNum = 201;BA.debugLine="Public Sub GetPhoto(Id As Long) As Bitmap";
Debug.ShouldStop(256);
 BA.debugLineNum = 202;BA.debugLine="Dim raw As List = GetData(\"vnd.android.cursor.ite";
Debug.ShouldStop(512);
_raw = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_raw = __ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_getdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/photo")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("data15")})),(Object)(_id),(Object)(RemoteObject.createNewArray("boolean",new int[] {1},new Object[] {contactsutils.__c.getField(true,"True")})));Debug.locals.put("raw", _raw);Debug.locals.put("raw", _raw);
 BA.debugLineNum = 203;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(1024);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 204;BA.debugLine="If raw.Size > 0 Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean(">",_raw.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 205;BA.debugLine="Dim obj() As Object = raw.Get(0)";
Debug.ShouldStop(4096);
_obj = (_raw.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("obj", _obj);Debug.locals.put("obj", _obj);
 BA.debugLineNum = 206;BA.debugLine="Dim bytes() As Byte = obj(0)";
Debug.ShouldStop(8192);
_bytes = (_obj.getArrayElement(false,BA.numberCast(int.class, 0)));Debug.locals.put("bytes", _bytes);Debug.locals.put("bytes", _bytes);
 BA.debugLineNum = 207;BA.debugLine="If bytes <> Null Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("N",_bytes)) { 
 BA.debugLineNum = 208;BA.debugLine="Dim In As InputStream";
Debug.ShouldStop(32768);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");Debug.locals.put("In", _in);
 BA.debugLineNum = 209;BA.debugLine="In.InitializeFromBytesArray(bytes, 0, bytes.Len";
Debug.ShouldStop(65536);
_in.runVoidMethod ("InitializeFromBytesArray",(Object)(_bytes),(Object)(BA.numberCast(int.class, 0)),(Object)(_bytes.getField(true,"length")));
 BA.debugLineNum = 210;BA.debugLine="bmp.Initialize2(In)";
Debug.ShouldStop(131072);
_bmp.runVoidMethod ("Initialize2",(Object)((_in.getObject())));
 BA.debugLineNum = 211;BA.debugLine="In.Close";
Debug.ShouldStop(262144);
_in.runVoidMethod ("Close");
 };
 };
 BA.debugLineNum = 214;BA.debugLine="Return bmp";
Debug.ShouldStop(2097152);
if (true) return _bmp;
 BA.debugLineNum = 215;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getstarred(RemoteObject __ref,RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("GetStarred (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,218);
if (RapidSub.canDelegate("getstarred")) { return __ref.runUserSub(false, "contactsutils","getstarred", __ref, _id);}
RemoteObject _crsr = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
RemoteObject _starred = RemoteObject.createImmutable(false);
Debug.locals.put("Id", _id);
 BA.debugLineNum = 218;BA.debugLine="Public Sub GetStarred(Id As Long) As Boolean";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="Dim crsr As Cursor = cr.Query(contactUri, Array A";
Debug.ShouldStop(67108864);
_crsr = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_crsr = __ref.getField(false,"_cr").runMethod(false,"Query",(Object)(__ref.getField(false,"_contacturi")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("starred")})),(Object)(BA.ObjectToString("_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_id)})),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("crsr", _crsr);Debug.locals.put("crsr", _crsr);
 BA.debugLineNum = 220;BA.debugLine="crsr.Position = 0";
Debug.ShouldStop(134217728);
_crsr.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 221;BA.debugLine="Dim starred As Boolean = crsr.GetInt(\"starred\") =";
Debug.ShouldStop(268435456);
_starred = BA.ObjectToBoolean(RemoteObject.solveBoolean("=",_crsr.runMethod(true,"GetInt",(Object)(RemoteObject.createImmutable("starred"))),BA.numberCast(double.class, 1)));Debug.locals.put("starred", _starred);Debug.locals.put("starred", _starred);
 BA.debugLineNum = 222;BA.debugLine="crsr.Close";
Debug.ShouldStop(536870912);
_crsr.runVoidMethod ("Close");
 BA.debugLineNum = 223;BA.debugLine="Return starred";
Debug.ShouldStop(1073741824);
if (true) return _starred;
 BA.debugLineNum = 224;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,16);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "contactsutils","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 16;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="dataUri.Parse(\"content://com.android.contacts/dat";
Debug.ShouldStop(65536);
__ref.getField(false,"_datauri").runVoidMethod ("Parse",(Object)(RemoteObject.createImmutable("content://com.android.contacts/data")));
 BA.debugLineNum = 18;BA.debugLine="contactUri.Parse(\"content://com.android.contacts/";
Debug.ShouldStop(131072);
__ref.getField(false,"_contacturi").runVoidMethod ("Parse",(Object)(RemoteObject.createImmutable("content://com.android.contacts/contacts")));
 BA.debugLineNum = 19;BA.debugLine="rawContactUri.Parse(\"content://com.android.contac";
Debug.ShouldStop(262144);
__ref.getField(false,"_rawcontacturi").runVoidMethod ("Parse",(Object)(RemoteObject.createImmutable("content://com.android.contacts/raw_contacts")));
 BA.debugLineNum = 20;BA.debugLine="cr.Initialize(\"cr\")";
Debug.ShouldStop(524288);
__ref.getField(false,"_cr").runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("cr")));
 BA.debugLineNum = 21;BA.debugLine="mailTypes.Initialize";
Debug.ShouldStop(1048576);
__ref.getField(false,"_mailtypes").runVoidMethod ("Initialize");
 BA.debugLineNum = 22;BA.debugLine="mailTypes.Put(\"1\", \"home\")";
Debug.ShouldStop(2097152);
__ref.getField(false,"_mailtypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("1"))),(Object)((RemoteObject.createImmutable("home"))));
 BA.debugLineNum = 23;BA.debugLine="mailTypes.Put(\"2\", \"work\")";
Debug.ShouldStop(4194304);
__ref.getField(false,"_mailtypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("2"))),(Object)((RemoteObject.createImmutable("work"))));
 BA.debugLineNum = 24;BA.debugLine="mailTypes.Put(\"3\", \"other\")";
Debug.ShouldStop(8388608);
__ref.getField(false,"_mailtypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("3"))),(Object)((RemoteObject.createImmutable("other"))));
 BA.debugLineNum = 25;BA.debugLine="mailTypes.Put(\"4\", \"mobile\")";
Debug.ShouldStop(16777216);
__ref.getField(false,"_mailtypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("4"))),(Object)((RemoteObject.createImmutable("mobile"))));
 BA.debugLineNum = 27;BA.debugLine="phoneTypes.Initialize";
Debug.ShouldStop(67108864);
__ref.getField(false,"_phonetypes").runVoidMethod ("Initialize");
 BA.debugLineNum = 28;BA.debugLine="phoneTypes.Put(\"1\", \"home\")";
Debug.ShouldStop(134217728);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("1"))),(Object)((RemoteObject.createImmutable("home"))));
 BA.debugLineNum = 29;BA.debugLine="phoneTypes.Put(\"2\", \"mobile\")";
Debug.ShouldStop(268435456);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("2"))),(Object)((RemoteObject.createImmutable("mobile"))));
 BA.debugLineNum = 30;BA.debugLine="phoneTypes.Put(\"3\", \"work\")";
Debug.ShouldStop(536870912);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("3"))),(Object)((RemoteObject.createImmutable("work"))));
 BA.debugLineNum = 31;BA.debugLine="phoneTypes.Put(\"4\", \"fax_work\")";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("4"))),(Object)((RemoteObject.createImmutable("fax_work"))));
 BA.debugLineNum = 32;BA.debugLine="phoneTypes.Put(\"5\", \"fax_home\")";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("5"))),(Object)((RemoteObject.createImmutable("fax_home"))));
 BA.debugLineNum = 33;BA.debugLine="phoneTypes.Put(\"6\", \"pager\")";
Debug.ShouldStop(1);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("6"))),(Object)((RemoteObject.createImmutable("pager"))));
 BA.debugLineNum = 34;BA.debugLine="phoneTypes.Put(\"7\", \"other\")";
Debug.ShouldStop(2);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("7"))),(Object)((RemoteObject.createImmutable("other"))));
 BA.debugLineNum = 35;BA.debugLine="phoneTypes.Put(\"8\", \"callback\")";
Debug.ShouldStop(4);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("8"))),(Object)((RemoteObject.createImmutable("callback"))));
 BA.debugLineNum = 36;BA.debugLine="phoneTypes.Put(\"9\", \"car\")";
Debug.ShouldStop(8);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("9"))),(Object)((RemoteObject.createImmutable("car"))));
 BA.debugLineNum = 37;BA.debugLine="phoneTypes.Put(\"10\", \"company_main\")";
Debug.ShouldStop(16);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("10"))),(Object)((RemoteObject.createImmutable("company_main"))));
 BA.debugLineNum = 38;BA.debugLine="phoneTypes.Put(\"11\", \"isdn\")";
Debug.ShouldStop(32);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("11"))),(Object)((RemoteObject.createImmutable("isdn"))));
 BA.debugLineNum = 39;BA.debugLine="phoneTypes.Put(\"12\", \"main\")";
Debug.ShouldStop(64);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("12"))),(Object)((RemoteObject.createImmutable("main"))));
 BA.debugLineNum = 40;BA.debugLine="phoneTypes.Put(\"13\", \"other_fax\")";
Debug.ShouldStop(128);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("13"))),(Object)((RemoteObject.createImmutable("other_fax"))));
 BA.debugLineNum = 41;BA.debugLine="phoneTypes.Put(\"14\", \"radio\")";
Debug.ShouldStop(256);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("14"))),(Object)((RemoteObject.createImmutable("radio"))));
 BA.debugLineNum = 42;BA.debugLine="phoneTypes.Put(\"15\", \"telex\")";
Debug.ShouldStop(512);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("15"))),(Object)((RemoteObject.createImmutable("telex"))));
 BA.debugLineNum = 43;BA.debugLine="phoneTypes.Put(\"16\", \"tty_tdd\")";
Debug.ShouldStop(1024);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("16"))),(Object)((RemoteObject.createImmutable("tty_tdd"))));
 BA.debugLineNum = 44;BA.debugLine="phoneTypes.Put(\"17\", \"work_mobile\")";
Debug.ShouldStop(2048);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("17"))),(Object)((RemoteObject.createImmutable("work_mobile"))));
 BA.debugLineNum = 45;BA.debugLine="phoneTypes.Put(\"18\", \"work_pager\")";
Debug.ShouldStop(4096);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("18"))),(Object)((RemoteObject.createImmutable("work_pager"))));
 BA.debugLineNum = 46;BA.debugLine="phoneTypes.Put(\"19\", \"assistant\")";
Debug.ShouldStop(8192);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("19"))),(Object)((RemoteObject.createImmutable("assistant"))));
 BA.debugLineNum = 47;BA.debugLine="phoneTypes.Put(\"20\", \"mms\")";
Debug.ShouldStop(16384);
__ref.getField(false,"_phonetypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("20"))),(Object)((RemoteObject.createImmutable("mms"))));
 BA.debugLineNum = 49;BA.debugLine="eventTypes.Initialize";
Debug.ShouldStop(65536);
__ref.getField(false,"_eventtypes").runVoidMethod ("Initialize");
 BA.debugLineNum = 50;BA.debugLine="eventTypes.Put(\"1\", \"anniversary\")";
Debug.ShouldStop(131072);
__ref.getField(false,"_eventtypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("1"))),(Object)((RemoteObject.createImmutable("anniversary"))));
 BA.debugLineNum = 51;BA.debugLine="eventTypes.Put(\"2\", \"other\")";
Debug.ShouldStop(262144);
__ref.getField(false,"_eventtypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("2"))),(Object)((RemoteObject.createImmutable("other"))));
 BA.debugLineNum = 52;BA.debugLine="eventTypes.Put(\"3\", \"birthday\")";
Debug.ShouldStop(524288);
__ref.getField(false,"_eventtypes").runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("3"))),(Object)((RemoteObject.createImmutable("birthday"))));
 BA.debugLineNum = 53;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_READ_CONTACTS)";
Debug.ShouldStop(1048576);
__ref.getField(false,"_rp").runVoidMethod ("CheckAndRequest",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_rp").getField(true,"PERMISSION_READ_CONTACTS")));
 BA.debugLineNum = 54;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_WRITE_CONTACTS)";
Debug.ShouldStop(2097152);
__ref.getField(false,"_rp").runVoidMethod ("CheckAndRequest",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_rp").getField(true,"PERMISSION_WRITE_CONTACTS")));
 BA.debugLineNum = 55;BA.debugLine="rp.CheckAndRequest(rp.PERMISSION_CALL_PHONE)";
Debug.ShouldStop(4194304);
__ref.getField(false,"_rp").runVoidMethod ("CheckAndRequest",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_rp").getField(true,"PERMISSION_CALL_PHONE")));
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertcontact(RemoteObject __ref,RemoteObject _name,RemoteObject _phone) throws Exception{
try {
		Debug.PushSubsStack("InsertContact (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,389);
if (RapidSub.canDelegate("insertcontact")) { return __ref.runUserSub(false, "contactsutils","insertcontact", __ref, _name, _phone);}
RemoteObject _values = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");
RemoteObject _rawuri = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
RemoteObject _rawcontactid = RemoteObject.createImmutable(0L);
RemoteObject _cu = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cucontact");
RemoteObject _crsr = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
Debug.locals.put("Name", _name);
Debug.locals.put("Phone", _phone);
 BA.debugLineNum = 389;BA.debugLine="Public Sub InsertContact(Name As String, Phone As";
Debug.ShouldStop(16);
 BA.debugLineNum = 390;BA.debugLine="Dim values As ContentValues";
Debug.ShouldStop(32);
_values = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");Debug.locals.put("values", _values);
 BA.debugLineNum = 391;BA.debugLine="values.Initialize";
Debug.ShouldStop(64);
_values.runVoidMethod ("Initialize");
 BA.debugLineNum = 392;BA.debugLine="values.PutNull(\"account_name\")";
Debug.ShouldStop(128);
_values.runVoidMethod ("PutNull",(Object)(RemoteObject.createImmutable("account_name")));
 BA.debugLineNum = 393;BA.debugLine="values.PutNull(\"account_type\")";
Debug.ShouldStop(256);
_values.runVoidMethod ("PutNull",(Object)(RemoteObject.createImmutable("account_type")));
 BA.debugLineNum = 394;BA.debugLine="Dim rawUri As Uri = cr.Insert(rawContactUri, valu";
Debug.ShouldStop(512);
_rawuri = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.UriWrapper");
_rawuri = __ref.getField(false,"_cr").runMethod(false,"Insert",(Object)(__ref.getField(false,"_rawcontacturi")),(Object)((_values.getObject())));Debug.locals.put("rawUri", _rawuri);Debug.locals.put("rawUri", _rawuri);
 BA.debugLineNum = 395;BA.debugLine="Dim rawContactId As Long = rawUri.ParseId";
Debug.ShouldStop(1024);
_rawcontactid = _rawuri.runMethod(true,"ParseId");Debug.locals.put("rawContactId", _rawcontactid);Debug.locals.put("rawContactId", _rawcontactid);
 BA.debugLineNum = 397;BA.debugLine="values.Initialize";
Debug.ShouldStop(4096);
_values.runVoidMethod ("Initialize");
 BA.debugLineNum = 398;BA.debugLine="values.PutLong(\"raw_contact_id\", rawContactId)";
Debug.ShouldStop(8192);
_values.runVoidMethod ("PutLong",(Object)(BA.ObjectToString("raw_contact_id")),(Object)(_rawcontactid));
 BA.debugLineNum = 399;BA.debugLine="values.PutString(\"mimetype\", \"vnd.android.cursor.";
Debug.ShouldStop(16384);
_values.runVoidMethod ("PutString",(Object)(BA.ObjectToString("mimetype")),(Object)(RemoteObject.createImmutable("vnd.android.cursor.item/phone_v2")));
 BA.debugLineNum = 400;BA.debugLine="values.PutString(\"data1\", Phone)";
Debug.ShouldStop(32768);
_values.runVoidMethod ("PutString",(Object)(BA.ObjectToString("data1")),(Object)(_phone));
 BA.debugLineNum = 401;BA.debugLine="cr.Insert(dataUri, values)";
Debug.ShouldStop(65536);
__ref.getField(false,"_cr").runVoidMethod ("Insert",(Object)(__ref.getField(false,"_datauri")),(Object)((_values.getObject())));
 BA.debugLineNum = 403;BA.debugLine="values.Initialize";
Debug.ShouldStop(262144);
_values.runVoidMethod ("Initialize");
 BA.debugLineNum = 404;BA.debugLine="values.PutLong(\"raw_contact_id\", rawContactId)";
Debug.ShouldStop(524288);
_values.runVoidMethod ("PutLong",(Object)(BA.ObjectToString("raw_contact_id")),(Object)(_rawcontactid));
 BA.debugLineNum = 405;BA.debugLine="values.PutString(\"mimetype\", \"vnd.android.cursor.";
Debug.ShouldStop(1048576);
_values.runVoidMethod ("PutString",(Object)(BA.ObjectToString("mimetype")),(Object)(RemoteObject.createImmutable("vnd.android.cursor.item/name")));
 BA.debugLineNum = 406;BA.debugLine="values.PutString(\"data1\", Name)";
Debug.ShouldStop(2097152);
_values.runVoidMethod ("PutString",(Object)(BA.ObjectToString("data1")),(Object)(_name));
 BA.debugLineNum = 407;BA.debugLine="cr.Insert(dataUri, values)";
Debug.ShouldStop(4194304);
__ref.getField(false,"_cr").runVoidMethod ("Insert",(Object)(__ref.getField(false,"_datauri")),(Object)((_values.getObject())));
 BA.debugLineNum = 408;BA.debugLine="Dim cu As cuContact";
Debug.ShouldStop(8388608);
_cu = RemoteObject.createNew ("com.no3dlauncher.contactsutils._cucontact");Debug.locals.put("cu", _cu);
 BA.debugLineNum = 409;BA.debugLine="cu.Initialize";
Debug.ShouldStop(16777216);
_cu.runVoidMethod ("Initialize");
 BA.debugLineNum = 410;BA.debugLine="Dim crsr As Cursor = cr.Query(dataUri, Array As S";
Debug.ShouldStop(33554432);
_crsr = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_crsr = __ref.getField(false,"_cr").runMethod(false,"Query",(Object)(__ref.getField(false,"_datauri")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("contact_id"),RemoteObject.createImmutable("display_name")})),(Object)(BA.ObjectToString("raw_contact_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_rawcontactid)})),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("crsr", _crsr);Debug.locals.put("crsr", _crsr);
 BA.debugLineNum = 412;BA.debugLine="crsr.Position = 0";
Debug.ShouldStop(134217728);
_crsr.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 413;BA.debugLine="cu.DisplayName = crsr.GetString(\"display_name\")";
Debug.ShouldStop(268435456);
_cu.setField ("DisplayName",_crsr.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("display_name"))));
 BA.debugLineNum = 414;BA.debugLine="cu.Id = crsr.GetLong(\"contact_id\")";
Debug.ShouldStop(536870912);
_cu.setField ("Id",_crsr.runMethod(true,"GetLong",(Object)(RemoteObject.createImmutable("contact_id"))));
 BA.debugLineNum = 415;BA.debugLine="Return cu";
Debug.ShouldStop(1073741824);
if (true) return _cu;
 BA.debugLineNum = 416;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _printcursor(RemoteObject __ref,RemoteObject _c) throws Exception{
try {
		Debug.PushSubsStack("printCursor (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,419);
if (RapidSub.canDelegate("printcursor")) { return __ref.runUserSub(false, "contactsutils","printcursor", __ref, _c);}
int _r = 0;
int _col = 0;
Debug.locals.put("c", _c);
 BA.debugLineNum = 419;BA.debugLine="Private Sub printCursor(c As Cursor) 'ignore";
Debug.ShouldStop(4);
 BA.debugLineNum = 420;BA.debugLine="For r = 0 To c.RowCount - 1";
Debug.ShouldStop(8);
{
final int step1 = 1;
final int limit1 = RemoteObject.solve(new RemoteObject[] {_c.runMethod(true,"getRowCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_r = 0 ;
for (;(step1 > 0 && _r <= limit1) || (step1 < 0 && _r >= limit1) ;_r = ((int)(0 + _r + step1))  ) {
Debug.locals.put("r", _r);
 BA.debugLineNum = 421;BA.debugLine="c.Position = r";
Debug.ShouldStop(16);
_c.runMethod(true,"setPosition",BA.numberCast(int.class, _r));
 BA.debugLineNum = 422;BA.debugLine="For col = 0 To c.ColumnCount - 1";
Debug.ShouldStop(32);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_c.runMethod(true,"getColumnCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_col = 0 ;
for (;(step3 > 0 && _col <= limit3) || (step3 < 0 && _col >= limit3) ;_col = ((int)(0 + _col + step3))  ) {
Debug.locals.put("col", _col);
 BA.debugLineNum = 423;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 424;BA.debugLine="Log(c.GetColumnName(col) & \": \" & c.GetString2";
Debug.ShouldStop(128);
contactsutils.__c.runVoidMethod ("LogImpl","79502725",RemoteObject.concat(_c.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _col))),RemoteObject.createImmutable(": "),_c.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, _col)))),0);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e7.toString()); BA.debugLineNum = 426;BA.debugLine="Log(c.GetColumnName(col) & \": \" & LastExceptio";
Debug.ShouldStop(512);
contactsutils.__c.runVoidMethod ("LogImpl","79502727",RemoteObject.concat(_c.runMethod(true,"GetColumnName",(Object)(BA.numberCast(int.class, _col))),RemoteObject.createImmutable(": "),contactsutils.__c.runMethod(false,"LastException",__ref.runMethod(false,"getActivityBA"))),0);
 };
 }
}Debug.locals.put("col", _col);
;
 BA.debugLineNum = 429;BA.debugLine="Log(\"***************\")";
Debug.ShouldStop(4096);
contactsutils.__c.runVoidMethod ("LogImpl","79502730",RemoteObject.createImmutable("***************"),0);
 }
}Debug.locals.put("r", _r);
;
 BA.debugLineNum = 431;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setdata(RemoteObject __ref,RemoteObject _mime,RemoteObject _values,RemoteObject _id,RemoteObject _update) throws Exception{
try {
		Debug.PushSubsStack("SetData (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,307);
if (RapidSub.canDelegate("setdata")) { return __ref.runUserSub(false, "contactsutils","setdata", __ref, _mime, _values, _id, _update);}
RemoteObject _crsr = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.CursorWrapper");
Debug.locals.put("Mime", _mime);
Debug.locals.put("Values", _values);
Debug.locals.put("Id", _id);
Debug.locals.put("Update", _update);
 BA.debugLineNum = 307;BA.debugLine="Private Sub SetData(Mime As String, Values As Cont";
Debug.ShouldStop(262144);
 BA.debugLineNum = 308;BA.debugLine="If Update Then";
Debug.ShouldStop(524288);
if (_update.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 309;BA.debugLine="cr.Update(dataUri, Values, \"mimetype = ? AND con";
Debug.ShouldStop(1048576);
__ref.getField(false,"_cr").runVoidMethod ("Update",(Object)((__ref.getField(false,"_datauri").getObject())),(Object)((_values.getObject())),(Object)(BA.ObjectToString("mimetype = ? AND contact_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {_mime,BA.NumberToString(_id)})));
 }else {
 BA.debugLineNum = 311;BA.debugLine="Dim crsr As Cursor = cr.Query(contactUri, Array";
Debug.ShouldStop(4194304);
_crsr = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.CursorWrapper");
_crsr = __ref.getField(false,"_cr").runMethod(false,"Query",(Object)(__ref.getField(false,"_contacturi")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("name_raw_contact_id")})),(Object)(BA.ObjectToString("_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_id)})),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("crsr", _crsr);Debug.locals.put("crsr", _crsr);
 BA.debugLineNum = 313;BA.debugLine="If crsr.RowCount = 0 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_crsr.runMethod(true,"getRowCount"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 314;BA.debugLine="Log(\"Error getting raw_contact_id\")";
Debug.ShouldStop(33554432);
contactsutils.__c.runVoidMethod ("LogImpl","79043975",RemoteObject.createImmutable("Error getting raw_contact_id"),0);
 BA.debugLineNum = 315;BA.debugLine="crsr.Close";
Debug.ShouldStop(67108864);
_crsr.runVoidMethod ("Close");
 BA.debugLineNum = 316;BA.debugLine="Return";
Debug.ShouldStop(134217728);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 318;BA.debugLine="crsr.Position = 0";
Debug.ShouldStop(536870912);
_crsr.runMethod(true,"setPosition",BA.numberCast(int.class, 0));
 BA.debugLineNum = 319;BA.debugLine="Values.PutString(\"raw_contact_id\", crsr.GetStrin";
Debug.ShouldStop(1073741824);
_values.runVoidMethod ("PutString",(Object)(BA.ObjectToString("raw_contact_id")),(Object)(_crsr.runMethod(true,"GetString",(Object)(RemoteObject.createImmutable("name_raw_contact_id")))));
 BA.debugLineNum = 320;BA.debugLine="crsr.Close";
Debug.ShouldStop(-2147483648);
_crsr.runVoidMethod ("Close");
 BA.debugLineNum = 321;BA.debugLine="Values.PutString(\"mimetype\", Mime)";
Debug.ShouldStop(1);
_values.runVoidMethod ("PutString",(Object)(BA.ObjectToString("mimetype")),(Object)(_mime));
 BA.debugLineNum = 322;BA.debugLine="cr.Insert(dataUri, Values)";
Debug.ShouldStop(2);
__ref.getField(false,"_cr").runVoidMethod ("Insert",(Object)(__ref.getField(false,"_datauri")),(Object)((_values.getObject())));
 };
 BA.debugLineNum = 324;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setnote(RemoteObject __ref,RemoteObject _id,RemoteObject _note) throws Exception{
try {
		Debug.PushSubsStack("SetNote (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,248);
if (RapidSub.canDelegate("setnote")) { return __ref.runUserSub(false, "contactsutils","setnote", __ref, _id, _note);}
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");
Debug.locals.put("Id", _id);
Debug.locals.put("Note", _note);
 BA.debugLineNum = 248;BA.debugLine="Public Sub SetNote(Id As Long, Note As String)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 249;BA.debugLine="Dim v As ContentValues";
Debug.ShouldStop(16777216);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");Debug.locals.put("v", _v);
 BA.debugLineNum = 250;BA.debugLine="v.Initialize";
Debug.ShouldStop(33554432);
_v.runVoidMethod ("Initialize");
 BA.debugLineNum = 251;BA.debugLine="v.PutString(\"data1\", Note)";
Debug.ShouldStop(67108864);
_v.runVoidMethod ("PutString",(Object)(BA.ObjectToString("data1")),(Object)(_note));
 BA.debugLineNum = 252;BA.debugLine="SetData(\"vnd.android.cursor.item/note\", v, Id, Tr";
Debug.ShouldStop(134217728);
__ref.runClassMethod (com.no3dlauncher.contactsutils.class, "_setdata",(Object)(BA.ObjectToString("vnd.android.cursor.item/note")),(Object)(_v),(Object)(_id),(Object)(contactsutils.__c.getField(true,"True")));
 BA.debugLineNum = 253;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setstarred(RemoteObject __ref,RemoteObject _id,RemoteObject _starred) throws Exception{
try {
		Debug.PushSubsStack("SetStarred (contactsutils) ","contactsutils",6,__ref.getField(false, "ba"),__ref,327);
if (RapidSub.canDelegate("setstarred")) { return __ref.runUserSub(false, "contactsutils","setstarred", __ref, _id, _starred);}
RemoteObject _values = RemoteObject.declareNull("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");
Debug.locals.put("Id", _id);
Debug.locals.put("Starred", _starred);
 BA.debugLineNum = 327;BA.debugLine="Public Sub SetStarred (Id As Long, Starred As Bool";
Debug.ShouldStop(64);
 BA.debugLineNum = 328;BA.debugLine="Dim values As ContentValues";
Debug.ShouldStop(128);
_values = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper.ContentValuesWrapper");Debug.locals.put("values", _values);
 BA.debugLineNum = 329;BA.debugLine="values.Initialize";
Debug.ShouldStop(256);
_values.runVoidMethod ("Initialize");
 BA.debugLineNum = 330;BA.debugLine="values.PutBoolean(\"starred\", Starred)";
Debug.ShouldStop(512);
_values.runVoidMethod ("PutBoolean",(Object)(BA.ObjectToString("starred")),(Object)(_starred));
 BA.debugLineNum = 331;BA.debugLine="cr.Update(contactUri, values, \"_id = ?\", Array As";
Debug.ShouldStop(1024);
__ref.getField(false,"_cr").runVoidMethod ("Update",(Object)((__ref.getField(false,"_contacturi").getObject())),(Object)((_values.getObject())),(Object)(BA.ObjectToString("_id = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {BA.NumberToString(_id)})));
 BA.debugLineNum = 332;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}