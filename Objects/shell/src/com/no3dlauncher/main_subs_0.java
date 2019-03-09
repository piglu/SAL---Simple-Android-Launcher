package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,126);
if (RapidSub.canDelegate("activity_create")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
RemoteObject _reflect = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _res = null;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 126;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 127;BA.debugLine="Activity.LoadLayout(\"tabs\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("tabs")),main.mostCurrent.activityBA);
 BA.debugLineNum = 129;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(1);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 130;BA.debugLine="cu.Initialize";
Debug.ShouldStop(2);
main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_initialize",main.processBA);
 };
 BA.debugLineNum = 136;BA.debugLine="TabStrip1.LoadLayout(\"mejn\", \"Main\")";
Debug.ShouldStop(128);
main.mostCurrent._tabstrip1.runVoidMethodAndSync ("LoadLayout",(Object)(BA.ObjectToString("mejn")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Main"))));
 BA.debugLineNum = 137;BA.debugLine="TabStrip1.LoadLayout(\"kontakti\", \"Contacts\")";
Debug.ShouldStop(256);
main.mostCurrent._tabstrip1.runVoidMethodAndSync ("LoadLayout",(Object)(BA.ObjectToString("kontakti")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Contacts"))));
 BA.debugLineNum = 138;BA.debugLine="TabStrip1.LoadLayout(\"widget_panel\", \"Widgets\")";
Debug.ShouldStop(512);
main.mostCurrent._tabstrip1.runVoidMethodAndSync ("LoadLayout",(Object)(BA.ObjectToString("widget_panel")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Widgets"))));
 BA.debugLineNum = 140;BA.debugLine="Dim reflect As Reflector";
Debug.ShouldStop(2048);
_reflect = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("reflect", _reflect);
 BA.debugLineNum = 141;BA.debugLine="reflect.Target = scvDock.Panel";
Debug.ShouldStop(4096);
_reflect.setField ("Target",(main.mostCurrent._scvdock.runMethod(false,"getPanel").getObject()));
 BA.debugLineNum = 142;BA.debugLine="reflect.SetOnTouchListener(\"scvPanel_Touch\")";
Debug.ShouldStop(8192);
_reflect.runVoidMethod ("SetOnTouchListener",main.processBA,(Object)(RemoteObject.createImmutable("scvPanel_Touch")));
 BA.debugLineNum = 155;BA.debugLine="nativeMe.InitializeContext";
Debug.ShouldStop(67108864);
main._nativeme.runVoidMethod ("InitializeContext",main.processBA);
 BA.debugLineNum = 157;BA.debugLine="f.UcitajVrijednostiOpt";
Debug.ShouldStop(268435456);
main.mostCurrent._f.runVoidMethod ("_ucitajvrijednostiopt",main.mostCurrent.activityBA);
 BA.debugLineNum = 159;BA.debugLine="Log(\"f.animStr: \" & f.animStr)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("f.animStr: "),main.mostCurrent._f._animstr)));
 BA.debugLineNum = 162;BA.debugLine="Log(\"f.brStranica: \" & f.brStranica)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("f.brStranica: "),main.mostCurrent._f._brstranica)));
 BA.debugLineNum = 173;BA.debugLine="TabStrip1_PageSelected(0)";
Debug.ShouldStop(4096);
_tabstrip1_pageselected(BA.numberCast(int.class, 0));
 BA.debugLineNum = 196;BA.debugLine="pnlMeni.Visible = False";
Debug.ShouldStop(8);
main.mostCurrent._pnlmeni.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 198;BA.debugLine="If Starter.mapa.IsInitialized Then";
Debug.ShouldStop(32);
if (main.mostCurrent._starter._mapa.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 199;BA.debugLine="If Starter.mapa.Size = 0 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",main.mostCurrent._starter._mapa.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 200;BA.debugLine="CallSub(Starter, \"GetInstalledApps\")";
Debug.ShouldStop(128);
main.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",main.processBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("GetInstalledApps")));
 };
 }else {
 BA.debugLineNum = 203;BA.debugLine="CallSub(Starter, \"GetInstalledApps\")";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",main.processBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("GetInstalledApps")));
 };
 BA.debugLineNum = 218;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(33554432);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 219;BA.debugLine="Dim res(4) As Int";
Debug.ShouldStop(67108864);
_res = RemoteObject.createNewArray ("int", new int[] {4}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 220;BA.debugLine="res = getARGB(f.bojaPozadine)";
Debug.ShouldStop(134217728);
_res = _getargb(main.mostCurrent._f._bojapozadine);Debug.locals.put("res", _res);
 BA.debugLineNum = 221;BA.debugLine="res(0) = f.trans";
Debug.ShouldStop(268435456);
_res.setArrayElement (main.mostCurrent._f._trans,BA.numberCast(int.class, 0));
 BA.debugLineNum = 222;BA.debugLine="cd.Initialize(Colors.ARGB(res(0), res(1), res(2),";
Debug.ShouldStop(536870912);
_cd.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 0))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 1))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 2))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 3))))),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 223;BA.debugLine="pnlMeni.Background = cd";
Debug.ShouldStop(1073741824);
main.mostCurrent._pnlmeni.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 225;BA.debugLine="iv_size.Initialize";
Debug.ShouldStop(1);
main.mostCurrent._iv_size.runVoidMethod ("Initialize");
 BA.debugLineNum = 226;BA.debugLine="listaFavorita.Initialize";
Debug.ShouldStop(2);
main.mostCurrent._listafavorita.runVoidMethod ("Initialize");
 BA.debugLineNum = 228;BA.debugLine="ViewsBringToFront";
Debug.ShouldStop(8);
_viewsbringtofront();
 BA.debugLineNum = 230;BA.debugLine="ShowFavoriteApps";
Debug.ShouldStop(32);
_showfavoriteapps();
 BA.debugLineNum = 231;BA.debugLine="btnDock_Click";
Debug.ShouldStop(64);
_btndock_click();
 BA.debugLineNum = 233;BA.debugLine="tajmer1.Initialize(\"tajmer\", 5000)";
Debug.ShouldStop(256);
main._tajmer1.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tajmer")),(Object)(BA.numberCast(long.class, 5000)));
 BA.debugLineNum = 234;BA.debugLine="tajmer1.Enabled = True";
Debug.ShouldStop(512);
main._tajmer1.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 238;BA.debugLine="cr.Initialize(\"cr\")";
Debug.ShouldStop(8192);
main.mostCurrent._cr.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("cr")));
 BA.debugLineNum = 239;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,350);
if (RapidSub.canDelegate("activity_pause")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 350;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 356;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,346);
if (RapidSub.canDelegate("activity_resume")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 346;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 348;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnclearall_click() throws Exception{
try {
		Debug.PushSubsStack("btnClearAll_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2474);
if (RapidSub.canDelegate("btnclearall_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnclearall_click");
 BA.debugLineNum = 2474;BA.debugLine="Sub btnClearAll_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 2475;BA.debugLine="CallSubDelayed(NotificationService, \"ClearAll\")";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.processBA,(Object)((main.mostCurrent._notificationservice.getObject())),(Object)(RemoteObject.createImmutable("ClearAll")));
 BA.debugLineNum = 2476;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btndock_click() throws Exception{
try {
		Debug.PushSubsStack("btnDock_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,441);
if (RapidSub.canDelegate("btndock_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btndock_click");
 BA.debugLineNum = 441;BA.debugLine="Sub btnDock_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 442;BA.debugLine="If pnl_dock_vidljiv Then";
Debug.ShouldStop(33554432);
if (main._pnl_dock_vidljiv.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 443;BA.debugLine="btnDock.SendToBack";
Debug.ShouldStop(67108864);
main.mostCurrent._btndock.runVoidMethod ("SendToBack");
 BA.debugLineNum = 444;BA.debugLine="pnlDock.SendToBack";
Debug.ShouldStop(134217728);
main.mostCurrent._pnldock.runVoidMethod ("SendToBack");
 BA.debugLineNum = 445;BA.debugLine="pnl_dock_vidljiv = False";
Debug.ShouldStop(268435456);
main._pnl_dock_vidljiv = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 446;BA.debugLine="btnDock.SetBackgroundImage(LoadBitmap(File.DirAs";
Debug.ShouldStop(536870912);
main.mostCurrent._btndock.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("scvdock_otvori.png"))).getObject())));
 BA.debugLineNum = 447;BA.debugLine="pnlDock.SetLayoutAnimated(500, 15%x, 100%y - pnl";
Debug.ShouldStop(1073741824);
main.mostCurrent._pnldock.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),main.mostCurrent._pnldock.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 65)))}, "-+",2, 1)),(Object)(main.mostCurrent._pnldock.runMethod(true,"getWidth")),(Object)(main.mostCurrent._pnldock.runMethod(true,"getHeight")));
 }else {
 BA.debugLineNum = 449;BA.debugLine="btnDock.BringToFront";
Debug.ShouldStop(1);
main.mostCurrent._btndock.runVoidMethod ("BringToFront");
 BA.debugLineNum = 450;BA.debugLine="pnlDock.BringToFront";
Debug.ShouldStop(2);
main.mostCurrent._pnldock.runVoidMethod ("BringToFront");
 BA.debugLineNum = 451;BA.debugLine="pnlMeni.Visible = False";
Debug.ShouldStop(4);
main.mostCurrent._pnlmeni.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 452;BA.debugLine="pnl_dock_vidljiv = True";
Debug.ShouldStop(8);
main._pnl_dock_vidljiv = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 453;BA.debugLine="btnDock.SetBackgroundImage(LoadBitmap(File.DirAs";
Debug.ShouldStop(16);
main.mostCurrent._btndock.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("scvdock_zatvori.png"))).getObject())));
 BA.debugLineNum = 454;BA.debugLine="pnlDock.SetLayoutAnimated(500, 15%x, 100%y - pnl";
Debug.ShouldStop(32);
main.mostCurrent._pnldock.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),main.mostCurrent._pnldock.runMethod(true,"getHeight")}, "-",1, 1)),(Object)(main.mostCurrent._pnldock.runMethod(true,"getWidth")),(Object)(main.mostCurrent._pnldock.runMethod(true,"getHeight")));
 };
 BA.debugLineNum = 456;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btndodajstr_click() throws Exception{
try {
		Debug.PushSubsStack("btnDodajStr_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2506);
if (RapidSub.canDelegate("btndodajstr_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btndodajstr_click");
 BA.debugLineNum = 2506;BA.debugLine="Sub btnDodajStr_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 2507;BA.debugLine="Log(\"btnDodajStr_Click\")";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("btnDodajStr_Click")));
 BA.debugLineNum = 2508;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btndodajwidget_click() throws Exception{
try {
		Debug.PushSubsStack("btnDodajWidget_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2498);
if (RapidSub.canDelegate("btndodajwidget_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btndodajwidget_click");
 BA.debugLineNum = 2498;BA.debugLine="Sub btnDodajWidget_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 2499;BA.debugLine="If Panel1.Visible Then";
Debug.ShouldStop(4);
if (main.mostCurrent._panel1.runMethod(true,"getVisible").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 2502;BA.debugLine="CreateSmartWidget(1)";
Debug.ShouldStop(32);
_createsmartwidget(BA.numberCast(int.class, 1));
 };
 BA.debugLineNum = 2504;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btninfo_click() throws Exception{
try {
		Debug.PushSubsStack("btnInfo_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,501);
if (RapidSub.canDelegate("btninfo_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btninfo_click");
 BA.debugLineNum = 501;BA.debugLine="Sub btnInfo_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 502;BA.debugLine="Log(\"btnInfo klik!\")";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("btnInfo klik!")));
 BA.debugLineNum = 503;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnkontaktemail_click(RemoteObject _ajtemid) throws Exception{
try {
		Debug.PushSubsStack("btnKontaktEmail_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2869);
if (RapidSub.canDelegate("btnkontaktemail_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnkontaktemail_click", _ajtemid);
RemoteObject _msg = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.Email");
RemoteObject _lemail = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _allcontactemails = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _c = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cuemail");
RemoteObject _adresa = RemoteObject.createImmutable("");
Debug.locals.put("ajtemID", _ajtemid);
 BA.debugLineNum = 2869;BA.debugLine="Sub btnKontaktEmail_Click(ajtemID As String)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 2871;BA.debugLine="Dim msg As Email";
Debug.ShouldStop(4194304);
_msg = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.Email");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 2873;BA.debugLine="Dim lEmail As List";
Debug.ShouldStop(16777216);
_lemail = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lEmail", _lemail);
 BA.debugLineNum = 2874;BA.debugLine="lEmail.Initialize";
Debug.ShouldStop(33554432);
_lemail.runVoidMethod ("Initialize");
 BA.debugLineNum = 2875;BA.debugLine="Dim allContactEmails As List = cu.GetEmails(ajtem";
Debug.ShouldStop(67108864);
_allcontactemails = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_allcontactemails = main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getemails",(Object)(BA.numberCast(long.class, _ajtemid)));Debug.locals.put("allContactEmails", _allcontactemails);Debug.locals.put("allContactEmails", _allcontactemails);
 BA.debugLineNum = 2876;BA.debugLine="If allContactEmails.Size > 0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean(">",_allcontactemails.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 2877;BA.debugLine="For Each c As cuEmail In allContactEmails";
Debug.ShouldStop(268435456);
{
final RemoteObject group6 = _allcontactemails;
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_c = (group6.runMethod(false,"Get",index6));Debug.locals.put("c", _c);
Debug.locals.put("c", _c);
 BA.debugLineNum = 2878;BA.debugLine="lEmail.Add(c.Email)";
Debug.ShouldStop(536870912);
_lemail.runVoidMethod ("Add",(Object)((_c.getField(true,"Email"))));
 }
}Debug.locals.put("c", _c);
;
 BA.debugLineNum = 2881;BA.debugLine="If lEmail.Size = 1 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_lemail.runMethod(true,"getSize"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 2882;BA.debugLine="msg.To.Add(c.Email)";
Debug.ShouldStop(2);
_msg.getField(false,"To").runVoidMethod ("Add",(Object)((_c.getField(true,"Email"))));
 BA.debugLineNum = 2883;BA.debugLine="StartActivity(msg.GetIntent)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_msg.runMethod(false,"GetIntent"))));
 }else {
 BA.debugLineNum = 2886;BA.debugLine="Dim adresa As String = PrikaziListuEmailAdresaU";
Debug.ShouldStop(32);
_adresa = _prikazilistuemailadresaudijalogu(_lemail);Debug.locals.put("adresa", _adresa);Debug.locals.put("adresa", _adresa);
 BA.debugLineNum = 2887;BA.debugLine="If adresa.EqualsIgnoreCase(\"false\") = False The";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_adresa.runMethod(true,"equalsIgnoreCase",(Object)(RemoteObject.createImmutable("false"))),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 2888;BA.debugLine="msg.To.Add(adresa)";
Debug.ShouldStop(128);
_msg.getField(false,"To").runVoidMethod ("Add",(Object)((_adresa)));
 BA.debugLineNum = 2889;BA.debugLine="StartActivity(msg.GetIntent)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_msg.runMethod(false,"GetIntent"))));
 }else {
 BA.debugLineNum = 2891;BA.debugLine="ToastMessageShow(\"You didn't choose email addr";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("You didn't choose email address!")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 };
 }else {
 BA.debugLineNum = 2895;BA.debugLine="ToastMessageShow(\"No email address!\", False)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No email address!")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 2897;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnkontaktinfo_click(RemoteObject _ajtemid) throws Exception{
try {
		Debug.PushSubsStack("btnKontaktInfo_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2817);
if (RapidSub.canDelegate("btnkontaktinfo_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnkontaktinfo_click", _ajtemid);
Debug.locals.put("ajtemID", _ajtemid);
 BA.debugLineNum = 2817;BA.debugLine="Sub btnKontaktInfo_Click(ajtemID As String)";
Debug.ShouldStop(1);
 BA.debugLineNum = 2820;BA.debugLine="Log(\"GetAccounts: \" & cu.GetAccounts(ajtemID))";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("GetAccounts: "),main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getaccounts",(Object)(BA.numberCast(long.class, _ajtemid))))));
 BA.debugLineNum = 2821;BA.debugLine="Log(\"GetEmails: \" & cu.GetEmails(ajtemID))";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("GetEmails: "),main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getemails",(Object)(BA.numberCast(long.class, _ajtemid))))));
 BA.debugLineNum = 2822;BA.debugLine="Log(\"GetEvents: \" & cu.GetEvents(ajtemID))";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("GetEvents: "),main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getevents",(Object)(BA.numberCast(long.class, _ajtemid))))));
 BA.debugLineNum = 2823;BA.debugLine="Log(\"GetGroups: \" & cu.GetGroups(ajtemID))";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("GetGroups: "),main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getgroups",(Object)(BA.numberCast(long.class, _ajtemid))))));
 BA.debugLineNum = 2824;BA.debugLine="Log(\"GetNameFromId: \" & cu.GetNameFromId(ajtemID)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("GetNameFromId: "),main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getnamefromid",(Object)(_ajtemid)))));
 BA.debugLineNum = 2825;BA.debugLine="Log(\"GetNote: \" & cu.GetNote(ajtemID))";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("GetNote: "),main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getnote",(Object)(BA.numberCast(long.class, _ajtemid))))));
 BA.debugLineNum = 2826;BA.debugLine="Log(\"GetOrganization :\" & cu.GetOrganization(ajte";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("GetOrganization :"),main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getorganization",(Object)(BA.numberCast(long.class, _ajtemid))))));
 BA.debugLineNum = 2827;BA.debugLine="Log(\"GetPhones: \" & cu.GetPhones(ajtemID))";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("GetPhones: "),main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getphones",(Object)(BA.numberCast(long.class, _ajtemid))))));
 BA.debugLineNum = 2828;BA.debugLine="Log(\"GetStarred: \" & cu.GetStarred(ajtemID))";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("GetStarred: "),main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getstarred",(Object)(BA.numberCast(long.class, _ajtemid))))));
 BA.debugLineNum = 2829;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnkontaktpoziv_click(RemoteObject _ajtemid) throws Exception{
try {
		Debug.PushSubsStack("btnKontaktPoziv_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2831);
if (RapidSub.canDelegate("btnkontaktpoziv_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnkontaktpoziv_click", _ajtemid);
RemoteObject _pc = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.PhoneCalls");
RemoteObject _lfoun = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _allphones = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _phone = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cuphone");
RemoteObject _broj_tel = RemoteObject.createImmutable("");
Debug.locals.put("ajtemID", _ajtemid);
 BA.debugLineNum = 2831;BA.debugLine="Sub btnKontaktPoziv_Click(ajtemID As String)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 2833;BA.debugLine="Dim pc As PhoneCalls";
Debug.ShouldStop(65536);
_pc = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.PhoneCalls");Debug.locals.put("pc", _pc);
 BA.debugLineNum = 2835;BA.debugLine="Dim lFoun As List";
Debug.ShouldStop(262144);
_lfoun = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("lFoun", _lfoun);
 BA.debugLineNum = 2836;BA.debugLine="lFoun.Initialize";
Debug.ShouldStop(524288);
_lfoun.runVoidMethod ("Initialize");
 BA.debugLineNum = 2837;BA.debugLine="Dim allPhones As List = cu.GetPhones(ajtemID)";
Debug.ShouldStop(1048576);
_allphones = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_allphones = main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getphones",(Object)(BA.numberCast(long.class, _ajtemid)));Debug.locals.put("allPhones", _allphones);Debug.locals.put("allPhones", _allphones);
 BA.debugLineNum = 2838;BA.debugLine="If allPhones.Size > 0 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean(">",_allphones.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 2839;BA.debugLine="For Each phone As cuPhone In cu.GetPhones(ajtemI";
Debug.ShouldStop(4194304);
{
final RemoteObject group6 = main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getphones",(Object)(BA.numberCast(long.class, _ajtemid)));
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_phone = (group6.runMethod(false,"Get",index6));Debug.locals.put("phone", _phone);
Debug.locals.put("phone", _phone);
 BA.debugLineNum = 2841;BA.debugLine="lFoun.Add(phone.Number)";
Debug.ShouldStop(16777216);
_lfoun.runVoidMethod ("Add",(Object)((_phone.getField(true,"Number"))));
 }
}Debug.locals.put("phone", _phone);
;
 BA.debugLineNum = 2843;BA.debugLine="If lFoun.Size = 1 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_lfoun.runMethod(true,"getSize"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 2844;BA.debugLine="StartActivity(pc.Call(lFoun.Get(0)))";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_pc.runMethod(false,"Call",(Object)(BA.ObjectToString(_lfoun.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0)))))))));
 }else {
 BA.debugLineNum = 2846;BA.debugLine="Dim broj_tel As String = PrikaziListuBrojevaTel";
Debug.ShouldStop(536870912);
_broj_tel = _prikazilistubrojevatelefona(_lfoun);Debug.locals.put("broj_tel", _broj_tel);Debug.locals.put("broj_tel", _broj_tel);
 BA.debugLineNum = 2847;BA.debugLine="StartActivity(pc.Call(broj_tel))";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_pc.runMethod(false,"Call",(Object)(_broj_tel)))));
 };
 }else {
 BA.debugLineNum = 2850;BA.debugLine="ToastMessageShow(\"No phone!\", False)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No phone!")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 2852;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnkontaktsms_click(RemoteObject _ajtemid) throws Exception{
try {
		Debug.PushSubsStack("btnKontaktSMS_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2854);
if (RapidSub.canDelegate("btnkontaktsms_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnkontaktsms_click", _ajtemid);
RemoteObject _intent1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _phone = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cuphone");
Debug.locals.put("ajtemID", _ajtemid);
 BA.debugLineNum = 2854;BA.debugLine="Sub btnKontaktSMS_Click(ajtemID As String)";
Debug.ShouldStop(32);
 BA.debugLineNum = 2856;BA.debugLine="Dim intent1 As Intent";
Debug.ShouldStop(128);
_intent1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("intent1", _intent1);
 BA.debugLineNum = 2858;BA.debugLine="Dim l As List = cu.GetPhones(ajtemID)";
Debug.ShouldStop(512);
main.mostCurrent._l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
main.mostCurrent._l = main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getphones",(Object)(BA.numberCast(long.class, _ajtemid)));
 BA.debugLineNum = 2859;BA.debugLine="If l.Size > 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",main.mostCurrent._l.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 2860;BA.debugLine="For Each phone As cuPhone In cu.GetPhones(ajtemI";
Debug.ShouldStop(2048);
{
final RemoteObject group4 = main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getphones",(Object)(BA.numberCast(long.class, _ajtemid)));
final int groupLen4 = group4.runMethod(true,"getSize").<Integer>get()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_phone = (group4.runMethod(false,"Get",index4));Debug.locals.put("phone", _phone);
Debug.locals.put("phone", _phone);
 }
}Debug.locals.put("phone", _phone);
;
 BA.debugLineNum = 2862;BA.debugLine="intent1.Initialize(intent1.ACTION_VIEW, \"sms:\" &";
Debug.ShouldStop(8192);
_intent1.runVoidMethod ("Initialize",(Object)(_intent1.getField(true,"ACTION_VIEW")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("sms:"),_phone.getField(true,"Number"))));
 BA.debugLineNum = 2863;BA.debugLine="StartActivity(intent1)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_intent1.getObject())));
 }else {
 BA.debugLineNum = 2865;BA.debugLine="ToastMessageShow(\"No phone number so no SMS!\", F";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("No phone number so no SMS!")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 BA.debugLineNum = 2867;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnmeni_click() throws Exception{
try {
		Debug.PushSubsStack("btnMeni_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,462);
if (RapidSub.canDelegate("btnmeni_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnmeni_click");
 BA.debugLineNum = 462;BA.debugLine="Sub btnMeni_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 463;BA.debugLine="If pnl_dock_vidljiv Then";
Debug.ShouldStop(16384);
if (main._pnl_dock_vidljiv.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 464;BA.debugLine="pnlDock.SendToBack";
Debug.ShouldStop(32768);
main.mostCurrent._pnldock.runVoidMethod ("SendToBack");
 BA.debugLineNum = 465;BA.debugLine="pnl_dock_vidljiv = False";
Debug.ShouldStop(65536);
main._pnl_dock_vidljiv = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 466;BA.debugLine="btnDock.SetBackgroundImage(LoadBitmap(File.DirAs";
Debug.ShouldStop(131072);
main.mostCurrent._btndock.runVoidMethod ("SetBackgroundImageNew",(Object)((main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("scvdock_otvori.png"))).getObject())));
 BA.debugLineNum = 467;BA.debugLine="pnlDock.SetLayoutAnimated(500, 15%x, 100%y - pnl";
Debug.ShouldStop(262144);
main.mostCurrent._pnldock.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 500)),(Object)(main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 15)),main.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA),main.mostCurrent._pnldock.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 65)))}, "-+",2, 1)),(Object)(main.mostCurrent._pnldock.runMethod(true,"getWidth")),(Object)(main.mostCurrent._pnldock.runMethod(true,"getHeight")));
 };
 BA.debugLineNum = 470;BA.debugLine="If f.showApps = 0 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main.mostCurrent._f._showapps,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 482;BA.debugLine="DodajListuAppUKotac";
Debug.ShouldStop(2);
_dodajlistuappukotac();
 }else 
{ BA.debugLineNum = 483;BA.debugLine="else if f.showApps = 1 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",main.mostCurrent._f._showapps,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 495;BA.debugLine="DodajListuSaIkonamaAppULAdicu";
Debug.ShouldStop(16384);
_dodajlistusaikonamaappuladicu();
 }else 
{ BA.debugLineNum = 496;BA.debugLine="else if f.showApps = 2 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",main.mostCurrent._f._showapps,BA.numberCast(double.class, 2))) { 
 BA.debugLineNum = 497;BA.debugLine="DodajAppULadicu";
Debug.ShouldStop(65536);
_dodajappuladicu();
 }}}
;
 BA.debugLineNum = 499;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnnaprijed_click() throws Exception{
try {
		Debug.PushSubsStack("btnNaprijed_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2523);
if (RapidSub.canDelegate("btnnaprijed_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnnaprijed_click");
 BA.debugLineNum = 2523;BA.debugLine="Sub btnNaprijed_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 2524;BA.debugLine="If TabStrip1.CurrentPage < 3 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("<",main.mostCurrent._tabstrip1.runMethod(true,"getCurrentPage"),BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 2525;BA.debugLine="TabStrip1.ScrollTo(TabStrip1.CurrentPage + 1, Tr";
Debug.ShouldStop(268435456);
main.mostCurrent._tabstrip1.runVoidMethod ("ScrollTo",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._tabstrip1.runMethod(true,"getCurrentPage"),RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 2527;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnnatrag_click() throws Exception{
try {
		Debug.PushSubsStack("btnNatrag_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2510);
if (RapidSub.canDelegate("btnnatrag_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnnatrag_click");
 BA.debugLineNum = 2510;BA.debugLine="Sub btnNatrag_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 2511;BA.debugLine="If TabStrip1.CurrentPage > 0 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean(">",main.mostCurrent._tabstrip1.runMethod(true,"getCurrentPage"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 2512;BA.debugLine="TabStrip1.ScrollTo(TabStrip1.CurrentPage - 1, Tr";
Debug.ShouldStop(32768);
main.mostCurrent._tabstrip1.runVoidMethod ("ScrollTo",(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._tabstrip1.runMethod(true,"getCurrentPage"),RemoteObject.createImmutable(1)}, "-",1, 1)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 2514;BA.debugLine="TabStrip1.ScrollTo(2, True)";
Debug.ShouldStop(131072);
main.mostCurrent._tabstrip1.runVoidMethod ("ScrollTo",(Object)(BA.numberCast(int.class, 2)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 2518;BA.debugLine="If TabStrip1.CurrentPage = 1 And pnlKontakti.Numb";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main.mostCurrent._tabstrip1.runMethod(true,"getCurrentPage"),BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("=",main.mostCurrent._pnlkontakti.runMethod(true,"getNumberOfViews"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 2519;BA.debugLine="UbaciKontakte2'(c)";
Debug.ShouldStop(4194304);
_ubacikontakte2();
 };
 BA.debugLineNum = 2521;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnnotify_click() throws Exception{
try {
		Debug.PushSubsStack("btnNotify_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2488);
if (RapidSub.canDelegate("btnnotify_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnnotify_click");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 2488;BA.debugLine="Sub btnNotify_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 2489;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(16777216);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 2490;BA.debugLine="Log(p.GetSettings(\"enabled_notification_listeners";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_p.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("enabled_notification_listeners")))));
 BA.debugLineNum = 2491;BA.debugLine="If p.GetSettings(\"enabled_notification_listeners\"";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_p.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("enabled_notification_listeners"))).runMethod(true,"contains",(Object)(RemoteObject.createImmutable("com.no3dlauncher"))),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 2492;BA.debugLine="Dim In As Intent";
Debug.ShouldStop(134217728);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("In", _in);
 BA.debugLineNum = 2493;BA.debugLine="In.Initialize(\"android.settings.ACTION_NOTIFICAT";
Debug.ShouldStop(268435456);
_in.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 2494;BA.debugLine="StartActivity(In)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_in.getObject())));
 };
 BA.debugLineNum = 2496;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnpostavke_click() throws Exception{
try {
		Debug.PushSubsStack("btnPostavke_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,505);
if (RapidSub.canDelegate("btnpostavke_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnpostavke_click");
 BA.debugLineNum = 505;BA.debugLine="Sub btnPostavke_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 506;BA.debugLine="StartActivity(pnlmeni_postavke)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._pnlmeni_postavke.getObject())));
 BA.debugLineNum = 507;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnpostavkekontakti_click() throws Exception{
try {
		Debug.PushSubsStack("btnPostavkeKontakti_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2923);
if (RapidSub.canDelegate("btnpostavkekontakti_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnpostavkekontakti_click");
 BA.debugLineNum = 2923;BA.debugLine="Sub btnPostavkeKontakti_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 2924;BA.debugLine="StartActivity(postavke_kontakti)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._postavke_kontakti.getObject())));
 BA.debugLineNum = 2925;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnsearch_click() throws Exception{
try {
		Debug.PushSubsStack("btnSearch_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,458);
if (RapidSub.canDelegate("btnsearch_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnsearch_click");
 BA.debugLineNum = 458;BA.debugLine="Sub btnSearch_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 459;BA.debugLine="StartActivity(search)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._search.getObject())));
 BA.debugLineNum = 460;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnwidgeti_click() throws Exception{
try {
		Debug.PushSubsStack("btnWidgeti_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,509);
if (RapidSub.canDelegate("btnwidgeti_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","btnwidgeti_click");
 BA.debugLineNum = 509;BA.debugLine="Sub btnWidgeti_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 510;BA.debugLine="TabStrip1.ScrollTo(2, True)";
Debug.ShouldStop(536870912);
main.mostCurrent._tabstrip1.runVoidMethod ("ScrollTo",(Object)(BA.numberCast(int.class, 2)),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 515;BA.debugLine="Log(\"widgeti klik!\")";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("widgeti klik!")));
 BA.debugLineNum = 516;BA.debugLine="File.Delete(File.DirInternal, \"theappid.txt\")";
Debug.ShouldStop(8);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("theappid.txt")));
 BA.debugLineNum = 517;BA.debugLine="File.Delete(File.DirInternal, \"theid.txt\")";
Debug.ShouldStop(16);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("theid.txt")));
 BA.debugLineNum = 518;BA.debugLine="File.Delete(File.DirInternal, \"thehost.txt\")";
Debug.ShouldStop(32);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("thehost.txt")));
 BA.debugLineNum = 577;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clv_itemclick(RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("clv_ItemClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1340);
if (RapidSub.canDelegate("clv_itemclick")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","clv_itemclick", _index, _value);
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 1340;BA.debugLine="Sub clv_ItemClick (Index As Int, Value As Object)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 1341;BA.debugLine="Dim in As Intent";
Debug.ShouldStop(268435456);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("in", _in);
 BA.debugLineNum = 1342;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(536870912);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 1344;BA.debugLine="zadnja_oznacena_app = Index";
Debug.ShouldStop(-2147483648);
main._zadnja_oznacena_app = _index;
 BA.debugLineNum = 1345;BA.debugLine="in = pm.GetApplicationIntent(l1.Get(Index))";
Debug.ShouldStop(1);
_in = _pm.runMethod(false,"GetApplicationIntent",(Object)(BA.ObjectToString(main.mostCurrent._l1.runMethod(false,"Get",(Object)(_index)))));Debug.locals.put("in", _in);
 BA.debugLineNum = 1346;BA.debugLine="If in.IsInitialized Then";
Debug.ShouldStop(2);
if (_in.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1349;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_in.getObject())));
 };
 BA.debugLineNum = 1351;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createsmartwidget(RemoteObject _id) throws Exception{
try {
		Debug.PushSubsStack("CreateSmartWidget (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2034);
if (RapidSub.canDelegate("createsmartwidget")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","createsmartwidget", _id);
Debug.locals.put("id", _id);
 BA.debugLineNum = 2034;BA.debugLine="Sub CreateSmartWidget(id As Int)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 2035;BA.debugLine="SmartWidgets.Initialize(\"SmartWidgets\", id)";
Debug.ShouldStop(262144);
main._smartwidgets.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("SmartWidgets")),(Object)(_id));
 BA.debugLineNum = 2036;BA.debugLine="SmartWidgets.SelectWidget";
Debug.ShouldStop(524288);
main._smartwidgets.runVoidMethod ("SelectWidget");
 BA.debugLineNum = 2037;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dodajappufavorite() throws Exception{
try {
		Debug.PushSubsStack("DodajAppUFavorite (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1070);
if (RapidSub.canDelegate("dodajappufavorite")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","dodajappufavorite");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _pckg1 = RemoteObject.createImmutable("");
RemoteObject _pckg = RemoteObject.createImmutable("");
RemoteObject _bdw = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 BA.debugLineNum = 1070;BA.debugLine="Sub DodajAppUFavorite";
Debug.ShouldStop(8192);
 BA.debugLineNum = 1071;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(16384);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 1072;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(32768);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 1074;BA.debugLine="Dim pckg1 As String";
Debug.ShouldStop(131072);
_pckg1 = RemoteObject.createImmutable("");Debug.locals.put("pckg1", _pckg1);
 BA.debugLineNum = 1075;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(zadnja";
Debug.ShouldStop(262144);
_pckg = BA.ObjectToString(main.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(main._zadnja_oznacena_app)));Debug.locals.put("pckg", _pckg);Debug.locals.put("pckg", _pckg);
 BA.debugLineNum = 1077;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(zadn";
Debug.ShouldStop(1048576);
_provjeraappufavoritima(BA.ObjectToString(main.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(main._zadnja_oznacena_app))));
 BA.debugLineNum = 1079;BA.debugLine="iv.Initialize(\"\")";
Debug.ShouldStop(4194304);
_iv.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1080;BA.debugLine="iv.Tag = scvDock.Panel.NumberOfViews";
Debug.ShouldStop(8388608);
_iv.runMethod(false,"setTag",(main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"getNumberOfViews")));
 BA.debugLineNum = 1081;BA.debugLine="iv.Width = 48dip";
Debug.ShouldStop(16777216);
_iv.runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))));
 BA.debugLineNum = 1082;BA.debugLine="iv.Height = 48dip";
Debug.ShouldStop(33554432);
_iv.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))));
 BA.debugLineNum = 1083;BA.debugLine="iv.Gravity = Gravity.FILL";
Debug.ShouldStop(67108864);
_iv.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 1085;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pckg";
Debug.ShouldStop(268435456);
_pckg1 = _pckg.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";"))),RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(_pckg.runMethod(true,"length")));Debug.locals.put("pckg1", _pckg1);
 BA.debugLineNum = 1086;BA.debugLine="Dim bdw As BitmapDrawable = pm.GetApplicationIcon";
Debug.ShouldStop(536870912);
_bdw = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
_bdw.setObject(_pm.runMethod(false,"GetApplicationIcon",(Object)(_pckg1)));Debug.locals.put("bdw", _bdw);
 BA.debugLineNum = 1087;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
Debug.ShouldStop(1073741824);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp.setObject(_bdw.runMethod(false,"getBitmap"));Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 1088;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True))";
Debug.ShouldStop(-2147483648);
_bdw.runVoidMethod ("Initialize",(Object)((_bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))))),(Object)(main.mostCurrent.__c.getField(true,"True"))).getObject())));
 BA.debugLineNum = 1089;BA.debugLine="listaFavorita.Add(pckg1)	' dodaj ime paketa aplik";
Debug.ShouldStop(1);
main.mostCurrent._listafavorita.runVoidMethod ("Add",(Object)((_pckg1)));
 BA.debugLineNum = 1092;BA.debugLine="iv.Bitmap = bdw.Bitmap'bm1";
Debug.ShouldStop(8);
_iv.runMethod(false,"setBitmap",_bdw.runMethod(false,"getBitmap"));
 BA.debugLineNum = 1093;BA.debugLine="scvDock.Panel.AddView(iv, iv.Width*scvDock.Panel.";
Debug.ShouldStop(16);
main.mostCurrent._scvdock.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_iv.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_iv.runMethod(true,"getWidth"),main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"getNumberOfViews"),main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"getNumberOfViews"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "*+*",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(_iv.runMethod(true,"getWidth")),(Object)(_iv.runMethod(true,"getHeight")));
 BA.debugLineNum = 1095;BA.debugLine="ToastMessageShow(\"App added to favorites!\", True)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("App added to favorites!")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 1096;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _dodajappuladicu() throws Exception{
ResumableSub_DodajAppULadicu rsub = new ResumableSub_DodajAppULadicu(null);
rsub.resume(null, null);
}
public static class ResumableSub_DodajAppULadicu extends BA.ResumableSub {
public ResumableSub_DodajAppULadicu(com.no3dlauncher.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.no3dlauncher.main parent;
RemoteObject _dlgdrawer = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog");
RemoteObject _sf = RemoteObject.declareNull("Object");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _x = RemoteObject.createImmutable(0);
int _i = 0;
int _j = 0;
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _s1 = RemoteObject.createImmutable("");
RemoteObject _drawable = RemoteObject.declareNull("Object");
RemoteObject _bdw = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _s2 = RemoteObject.createImmutable("");
int step14;
int limit14;
int step15;
int limit15;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("DodajAppULadicu (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,682);
if (RapidSub.canDelegate("dodajappuladicu")) return ;
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 683;BA.debugLine="Private dlgDrawer As CustomLayoutDialog";
Debug.ShouldStop(1024);
_dlgdrawer = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog");Debug.locals.put("dlgDrawer", _dlgdrawer);
 BA.debugLineNum = 684;BA.debugLine="Dim sf As Object = dlgDrawer.ShowAsync(\"All appli";
Debug.ShouldStop(2048);
_sf = _dlgdrawer.runMethod(false,"ShowAsync",(Object)(BA.ObjectToString("All applications")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),main.mostCurrent.activityBA,(Object)((parent.mostCurrent.__c.getField(false,"Null"))),(Object)(parent.mostCurrent.__c.getField(true,"True")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 685;BA.debugLine="dlgDrawer.SetSize(100%x, 90%y)";
Debug.ShouldStop(4096);
_dlgdrawer.runVoidMethod ("SetSize",(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 90)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 686;BA.debugLine="Wait For (sf) Dialog_Ready(pnl As Panel)";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","dialog_ready", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), _sf);
this.state = 19;
return;
case 19:
//C
this.state = 1;
_pnl = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("pnl", _pnl);
;
 BA.debugLineNum = 688;BA.debugLine="FiltrirajImenaAppIImenaPaketa";
Debug.ShouldStop(32768);
_filtrirajimenaappiimenapaketa();
 BA.debugLineNum = 690;BA.debugLine="sv.Initialize(1000dip)";
Debug.ShouldStop(131072);
parent.mostCurrent._sv.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1000)))));
 BA.debugLineNum = 691;BA.debugLine="pnl.AddView(sv, 0, 0, pnl.Width, pnl.Height)";
Debug.ShouldStop(262144);
_pnl.runVoidMethod ("AddView",(Object)((parent.mostCurrent._sv.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_pnl.runMethod(true,"getWidth")),(Object)(_pnl.runMethod(true,"getHeight")));
 BA.debugLineNum = 692;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(524288);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 693;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(1048576);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 694;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
Debug.ShouldStop(2097152);
_cd.runVoidMethod ("Initialize",(Object)(parent.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)))),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 695;BA.debugLine="Dim x As Int";
Debug.ShouldStop(4194304);
_x = RemoteObject.createImmutable(0);Debug.locals.put("x", _x);
 BA.debugLineNum = 696;BA.debugLine="x = Activity.Width / 5'pkg1.Size";
Debug.ShouldStop(8388608);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._activity.runMethod(true,"getWidth"),RemoteObject.createImmutable(5)}, "/",0, 0));Debug.locals.put("x", _x);
 BA.debugLineNum = 697;BA.debugLine="x = x - 10dip";
Debug.ShouldStop(16777216);
_x = RemoteObject.solve(new RemoteObject[] {_x,parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1);Debug.locals.put("x", _x);
 BA.debugLineNum = 699;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
Debug.ShouldStop(67108864);
if (true) break;

case 1:
//for
this.state = 18;
step14 = 1;
limit14 = RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._starter._mapa.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
this.state = 20;
if (true) break;

case 20:
//C
this.state = 18;
if ((step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14)) this.state = 3;
if (true) break;

case 21:
//C
this.state = 20;
_i = ((int)(0 + _i + step14)) ;
Debug.locals.put("i", _i);
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 700;BA.debugLine="For j = 0 To 4";
Debug.ShouldStop(134217728);
if (true) break;

case 4:
//for
this.state = 17;
step15 = 1;
limit15 = 4;
_j = 0 ;
Debug.locals.put("j", _j);
this.state = 22;
if (true) break;

case 22:
//C
this.state = 17;
if ((step15 > 0 && _j <= limit15) || (step15 < 0 && _j >= limit15)) this.state = 6;
if (true) break;

case 23:
//C
this.state = 22;
_j = ((int)(0 + _j + step15)) ;
Debug.locals.put("j", _j);
if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 701;BA.debugLine="If (i*5+j) < Starter.mapa.Size Then";
Debug.ShouldStop(268435456);
if (true) break;

case 7:
//if
this.state = 16;
if (RemoteObject.solveBoolean("<",(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1)),BA.numberCast(double.class, parent.mostCurrent._starter._mapa.runMethod(true,"getSize")))) { 
this.state = 9;
}else {
this.state = 15;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 702;BA.debugLine="Dim s As String = Starter.mapa.GetKeyAt(i*5+j)";
Debug.ShouldStop(536870912);
_s = BA.ObjectToString(parent.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))));Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 704;BA.debugLine="Dim s1 As String = s.SubString2(s.IndexOf(\";\")";
Debug.ShouldStop(-2147483648);
_s1 = _s.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_s.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";"))),RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(_s.runMethod(true,"length")));Debug.locals.put("s1", _s1);Debug.locals.put("s1", _s1);
 BA.debugLineNum = 705;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon";
Debug.ShouldStop(1);
_drawable = (_pm.runMethod(false,"GetApplicationIcon",(Object)(_s1)));Debug.locals.put("drawable", _drawable);Debug.locals.put("drawable", _drawable);
 BA.debugLineNum = 706;BA.debugLine="If drawable Is BitmapDrawable Then";
Debug.ShouldStop(2);
if (true) break;

case 10:
//if
this.state = 13;
if (RemoteObject.solveBoolean("i",_drawable, RemoteObject.createImmutable("android.graphics.drawable.BitmapDrawable"))) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 707;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
Debug.ShouldStop(4);
_bdw = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
_bdw.setObject(_drawable);Debug.locals.put("bdw", _bdw);
 BA.debugLineNum = 708;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
Debug.ShouldStop(8);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp.setObject(_bdw.runMethod(false,"getBitmap"));Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 709;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True)";
Debug.ShouldStop(16);
_bdw.runVoidMethod ("Initialize",(Object)((_bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))))),(Object)(BA.numberCast(float.class, parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))))),(Object)(parent.mostCurrent.__c.getField(true,"True"))).getObject())));
 BA.debugLineNum = 710;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(32);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 711;BA.debugLine="iv.Initialize(\"ivAppMain\")";
Debug.ShouldStop(64);
_iv.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ivAppMain")));
 BA.debugLineNum = 712;BA.debugLine="iv.Bitmap = bdw.Bitmap";
Debug.ShouldStop(128);
_iv.runMethod(false,"setBitmap",_bdw.runMethod(false,"getBitmap"));
 BA.debugLineNum = 713;BA.debugLine="iv.Tag = s1'Starter.mapa.GetKeyAt(i*5+j)";
Debug.ShouldStop(256);
_iv.runMethod(false,"setTag",(_s1));
 BA.debugLineNum = 714;BA.debugLine="sv.Panel.AddView(iv, x*j + j*2dip, x*i + 10di";
Debug.ShouldStop(512);
parent.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_iv.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j),RemoteObject.createImmutable(_j),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "*+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(_i),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "*++*",2, 1)),(Object)(_x),(Object)(_x));
 BA.debugLineNum = 715;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(1024);
parent.mostCurrent._lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 716;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(2048);
parent.mostCurrent._lbl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 718;BA.debugLine="Dim s2 As String = s.SubString2(0, s.IndexOf(";
Debug.ShouldStop(8192);
_s2 = _s.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(_s.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";")))));Debug.locals.put("s2", _s2);Debug.locals.put("s2", _s2);
 BA.debugLineNum = 719;BA.debugLine="lbl.Text = s2";
Debug.ShouldStop(16384);
parent.mostCurrent._lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_s2));
 BA.debugLineNum = 720;BA.debugLine="lbl.TextColor = Colors.White";
Debug.ShouldStop(32768);
parent.mostCurrent._lbl.runMethod(true,"setTextColor",parent.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 721;BA.debugLine="lbl.Background = cd";
Debug.ShouldStop(65536);
parent.mostCurrent._lbl.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 722;BA.debugLine="lbl.TextSize = 10.0";
Debug.ShouldStop(131072);
parent.mostCurrent._lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 10.0));
 BA.debugLineNum = 723;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
Debug.ShouldStop(262144);
parent.mostCurrent._lbl.runMethod(false,"setTypeface",parent.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(parent.mostCurrent._f._wheellistfont,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 724;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
Debug.ShouldStop(524288);
parent.mostCurrent._lbl.runMethod(true,"setGravity",parent.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(parent.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL")),(Object)(parent.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"))));
 BA.debugLineNum = 725;BA.debugLine="sv.Panel.AddView(lbl, x*j + j*2dip, x*i + x +";
Debug.ShouldStop(1048576);
parent.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((parent.mostCurrent._lbl.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j),RemoteObject.createImmutable(_j),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "*+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),_x,RemoteObject.createImmutable(_i),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))}, "*++*+",3, 1)),(Object)(_x),(Object)(parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 if (true) break;

case 13:
//C
this.state = 16;
;
 if (true) break;

case 15:
//C
this.state = 16;
 BA.debugLineNum = 728;BA.debugLine="Exit";
Debug.ShouldStop(8388608);
this.state = 17;
if (true) break;
 if (true) break;

case 16:
//C
this.state = 23;
;
 if (true) break;
if (true) break;

case 17:
//C
this.state = 21;
Debug.locals.put("j", _j);
;
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 732;BA.debugLine="sv.Panel.Height = sv.Panel.Height + 12dip";
Debug.ShouldStop(134217728);
parent.mostCurrent._sv.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._sv.runMethod(false,"getPanel").runMethod(true,"getHeight"),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 12)))}, "+",1, 1));
 BA.debugLineNum = 733;BA.debugLine="dlgDrawer.GetButton(DialogResponse.POSITIVE).Enab";
Debug.ShouldStop(268435456);
_dlgdrawer.runMethod(false,"GetButton",(Object)(parent.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE"))).runMethod(true,"setEnabled",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 734;BA.debugLine="Wait for (sf) ivAppMain_Click";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","ivappmain_click", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), _sf);
this.state = 24;
return;
case 24:
//C
this.state = -1;
;
 BA.debugLineNum = 735;BA.debugLine="Wait For (sf) ivApp_LongClick";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","ivapp_longclick", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), _sf);
this.state = 25;
return;
case 25:
//C
this.state = -1;
;
 BA.debugLineNum = 736;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _dialog_ready(RemoteObject _pnl) throws Exception{
}
public static void  _ivapp_longclick() throws Exception{
}
public static void  _dodajlistuappukotac() throws Exception{
ResumableSub_DodajListuAppUKotac rsub = new ResumableSub_DodajListuAppUKotac(null);
rsub.resume(null, null);
}
public static class ResumableSub_DodajListuAppUKotac extends BA.ResumableSub {
public ResumableSub_DodajListuAppUKotac(com.no3dlauncher.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.no3dlauncher.main parent;
RemoteObject _dlgdrawer = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog");
RemoteObject _sf = RemoteObject.declareNull("Object");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _mylist = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _res = null;
RemoteObject _position = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("DodajListuAppUKotac (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,869);
if (RapidSub.canDelegate("dodajlistuappukotac")) return ;
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 BA.debugLineNum = 870;BA.debugLine="Private dlgDrawer As CustomLayoutDialog";
Debug.ShouldStop(32);
_dlgdrawer = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog");Debug.locals.put("dlgDrawer", _dlgdrawer);
 BA.debugLineNum = 871;BA.debugLine="Dim sf As Object = dlgDrawer.ShowAsync(\"All appli";
Debug.ShouldStop(64);
_sf = _dlgdrawer.runMethod(false,"ShowAsync",(Object)(BA.ObjectToString("All applications")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),main.mostCurrent.activityBA,(Object)((parent.mostCurrent.__c.getField(false,"Null"))),(Object)(parent.mostCurrent.__c.getField(true,"True")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 872;BA.debugLine="dlgDrawer.SetSize(80%x, 62%y)";
Debug.ShouldStop(128);
_dlgdrawer.runVoidMethod ("SetSize",(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 80)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 62)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 873;BA.debugLine="Wait For (sf) Dialog_Ready(pnl As Panel)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","dialog_ready", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), _sf);
this.state = 1;
return;
case 1:
//C
this.state = -1;
_pnl = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("pnl", _pnl);
;
 BA.debugLineNum = 875;BA.debugLine="FiltrirajImenaAppIImenaPaketa";
Debug.ShouldStop(1024);
_filtrirajimenaappiimenapaketa();
 BA.debugLineNum = 877;BA.debugLine="wp1.Initialize(\"wp1\")";
Debug.ShouldStop(4096);
parent.mostCurrent._wp1.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("wp1")));
 BA.debugLineNum = 878;BA.debugLine="pnl.AddView(wp1, 0, btnPostavke.Height, pnlMeni.W";
Debug.ShouldStop(8192);
_pnl.runVoidMethod ("AddView",(Object)((parent.mostCurrent._wp1.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(parent.mostCurrent._btnpostavke.runMethod(true,"getHeight")),(Object)(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._pnlmeni.runMethod(true,"getWidth"),parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)}, "-",1, 1)),(Object)(parent.mostCurrent._pnlmeni.runMethod(true,"getHeight")));
 BA.debugLineNum = 880;BA.debugLine="Dim mylist As List";
Debug.ShouldStop(32768);
_mylist = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("mylist", _mylist);
 BA.debugLineNum = 881;BA.debugLine="mylist.Initialize";
Debug.ShouldStop(65536);
_mylist.runVoidMethod ("Initialize");
 BA.debugLineNum = 882;BA.debugLine="mylist.Add(LoadBitmap(File.DirAssets, \"act_add.pn";
Debug.ShouldStop(131072);
_mylist.runVoidMethod ("Add",(Object)((parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("act_add.png"))).getObject())));
 BA.debugLineNum = 884;BA.debugLine="wp1.Tag = \"kotac\"";
Debug.ShouldStop(524288);
parent.mostCurrent._wp1.runMethod(false,"setTag",RemoteObject.createImmutable(("kotac")));
 BA.debugLineNum = 885;BA.debugLine="wp1.Curved = True";
Debug.ShouldStop(1048576);
parent.mostCurrent._wp1.runVoidMethod ("setCurved",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 886;BA.debugLine="wp1.Cyclic = True";
Debug.ShouldStop(2097152);
parent.mostCurrent._wp1.runVoidMethod ("setCyclic",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 887;BA.debugLine="wp1.ItemTextColor = f.bojaFonta";
Debug.ShouldStop(4194304);
parent.mostCurrent._wp1.runVoidMethod ("setItemTextColor",parent.mostCurrent._f._bojafonta);
 BA.debugLineNum = 888;BA.debugLine="wp1.Atmospheric = True";
Debug.ShouldStop(8388608);
parent.mostCurrent._wp1.runVoidMethod ("setAtmospheric",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 889;BA.debugLine="wp1.ItemAlign = 0                        '0 = cen";
Debug.ShouldStop(16777216);
parent.mostCurrent._wp1.runVoidMethod ("setItemAlign",BA.numberCast(int.class, 0));
 BA.debugLineNum = 890;BA.debugLine="wp1.ItemTextSize = f.fontzSize'55";
Debug.ShouldStop(33554432);
parent.mostCurrent._wp1.runVoidMethod ("setItemTextSize",parent.mostCurrent._f._fontzsize);
 BA.debugLineNum = 892;BA.debugLine="wp1.VisibleItemCount = 10";
Debug.ShouldStop(134217728);
parent.mostCurrent._wp1.runVoidMethod ("setVisibleItemCount",BA.numberCast(int.class, 10));
 BA.debugLineNum = 893;BA.debugLine="wp1.Indicator = True";
Debug.ShouldStop(268435456);
parent.mostCurrent._wp1.runVoidMethod ("setIndicator",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 894;BA.debugLine="wp1.ItemSpace = 20";
Debug.ShouldStop(536870912);
parent.mostCurrent._wp1.runVoidMethod ("setItemSpace",BA.numberCast(int.class, 20));
 BA.debugLineNum = 895;BA.debugLine="wp1.Typeface = Typeface.LoadFromAssets(f.wheelLis";
Debug.ShouldStop(1073741824);
parent.mostCurrent._wp1.runVoidMethod ("setTypeface",parent.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(parent.mostCurrent._f._wheellistfont,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 896;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(-2147483648);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 897;BA.debugLine="Dim res(4) As Int";
Debug.ShouldStop(1);
_res = RemoteObject.createNewArray ("int", new int[] {4}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 898;BA.debugLine="res = getARGB(f.bojaPozadine)";
Debug.ShouldStop(2);
_res = _getargb(parent.mostCurrent._f._bojapozadine);Debug.locals.put("res", _res);
 BA.debugLineNum = 899;BA.debugLine="res(0) = f.trans";
Debug.ShouldStop(4);
_res.setArrayElement (parent.mostCurrent._f._trans,BA.numberCast(int.class, 0));
 BA.debugLineNum = 900;BA.debugLine="cd.Initialize(Colors.ARGB(res(0), res(1), res(2),";
Debug.ShouldStop(8);
_cd.runVoidMethod ("Initialize",(Object)(parent.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 0))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 1))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 2))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 3))))),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 901;BA.debugLine="wp1.Background = cd";
Debug.ShouldStop(16);
parent.mostCurrent._wp1.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 902;BA.debugLine="wp1.Data = l";
Debug.ShouldStop(32);
parent.mostCurrent._wp1.runVoidMethod ("setData",(parent.mostCurrent._l.getObject()));
 BA.debugLineNum = 905;BA.debugLine="ivWheelDodaj.Initialize(\"ivWheelDodaj\")";
Debug.ShouldStop(256);
parent.mostCurrent._ivwheeldodaj.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ivWheelDodaj")));
 BA.debugLineNum = 906;BA.debugLine="ivWheelDodaj.Tag = \"kotac_dodaj\"";
Debug.ShouldStop(512);
parent.mostCurrent._ivwheeldodaj.runMethod(false,"setTag",RemoteObject.createImmutable(("kotac_dodaj")));
 BA.debugLineNum = 907;BA.debugLine="ivWheelDodaj.Bitmap = LoadBitmap(File.DirAssets,";
Debug.ShouldStop(1024);
parent.mostCurrent._ivwheeldodaj.runMethod(false,"setBitmap",(parent.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(parent.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("act_add.png"))).getObject()));
 BA.debugLineNum = 908;BA.debugLine="ivWheelDodaj.Gravity = Gravity.FILL";
Debug.ShouldStop(2048);
parent.mostCurrent._ivwheeldodaj.runMethod(true,"setGravity",parent.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 909;BA.debugLine="pnl.AddView(ivWheelDodaj, wp1.Width, (pnlMeni.Hei";
Debug.ShouldStop(4096);
_pnl.runVoidMethod ("AddView",(Object)((parent.mostCurrent._ivwheeldodaj.getObject())),(Object)(parent.mostCurrent._wp1.runMethod(true,"getWidth")),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._pnlmeni.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0)),(RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._btnpostavke.runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0))}, "+",1, 0))),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 10)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 912;BA.debugLine="Wait For ivWheelDodaj_Click";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","ivwheeldodaj_click", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), null);
this.state = 2;
return;
case 2:
//C
this.state = -1;
;
 BA.debugLineNum = 914;BA.debugLine="Wait For wp1_index_clicked(position As Int)";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","wp1_index_clicked", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), null);
this.state = 3;
return;
case 3:
//C
this.state = -1;
_position = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("position", _position);
;
 BA.debugLineNum = 916;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _dodajlistusaikonamaappuladicu() throws Exception{
ResumableSub_DodajListuSaIkonamaAppULAdicu rsub = new ResumableSub_DodajListuSaIkonamaAppULAdicu(null);
rsub.resume(null, null);
}
public static class ResumableSub_DodajListuSaIkonamaAppULAdicu extends BA.ResumableSub {
public ResumableSub_DodajListuSaIkonamaAppULAdicu(com.no3dlauncher.main parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.no3dlauncher.main parent;
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _dlgdrawer = RemoteObject.declareNull("anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog");
RemoteObject _sf = RemoteObject.declareNull("Object");
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _res = null;
int _i = 0;
RemoteObject _pckg1 = RemoteObject.createImmutable("");
RemoteObject _pckg2 = RemoteObject.createImmutable("");
RemoteObject _pckg = RemoteObject.createImmutable("");
RemoteObject _drawable = RemoteObject.declareNull("Object");
RemoteObject _bdw = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _value = RemoteObject.declareNull("Object");
int step14;
int limit14;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("DodajListuSaIkonamaAppULAdicu (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,639);
if (RapidSub.canDelegate("dodajlistusaikonamaappuladicu")) return ;
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 640;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(-2147483648);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 642;BA.debugLine="FiltrirajImenaAppIImenaPaketa";
Debug.ShouldStop(2);
_filtrirajimenaappiimenapaketa();
 BA.debugLineNum = 644;BA.debugLine="Private dlgDrawer As CustomLayoutDialog";
Debug.ShouldStop(8);
_dlgdrawer = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog");Debug.locals.put("dlgDrawer", _dlgdrawer);
 BA.debugLineNum = 645;BA.debugLine="Dim sf As Object = dlgDrawer.ShowAsync(\"All appli";
Debug.ShouldStop(16);
_sf = _dlgdrawer.runMethod(false,"ShowAsync",(Object)(BA.ObjectToString("All applications")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),main.mostCurrent.activityBA,(Object)((parent.mostCurrent.__c.getField(false,"Null"))),(Object)(parent.mostCurrent.__c.getField(true,"True")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 646;BA.debugLine="dlgDrawer.SetSize(100%x, 90%y)";
Debug.ShouldStop(32);
_dlgdrawer.runVoidMethod ("SetSize",(Object)(parent.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA)),(Object)(parent.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 90)),main.mostCurrent.activityBA)));
 BA.debugLineNum = 647;BA.debugLine="Wait For (sf) Dialog_Ready(pnl As Panel)";
Debug.ShouldStop(64);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","dialog_ready", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), _sf);
this.state = 9;
return;
case 9:
//C
this.state = 1;
_pnl = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("pnl", _pnl);
;
 BA.debugLineNum = 649;BA.debugLine="pnl.LoadLayout(\"clv1\")";
Debug.ShouldStop(256);
_pnl.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("clv1")),main.mostCurrent.activityBA);
 BA.debugLineNum = 651;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(1024);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 652;BA.debugLine="Dim res(4) As Int";
Debug.ShouldStop(2048);
_res = RemoteObject.createNewArray ("int", new int[] {4}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 653;BA.debugLine="res = getARGB(f.bojaPozadine)";
Debug.ShouldStop(4096);
_res = _getargb(parent.mostCurrent._f._bojapozadine);Debug.locals.put("res", _res);
 BA.debugLineNum = 654;BA.debugLine="res(0) = f.trans";
Debug.ShouldStop(8192);
_res.setArrayElement (parent.mostCurrent._f._trans,BA.numberCast(int.class, 0));
 BA.debugLineNum = 655;BA.debugLine="cd.Initialize(Colors.ARGB(res(0), res(1), res(2),";
Debug.ShouldStop(16384);
_cd.runVoidMethod ("Initialize",(Object)(parent.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 0))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 1))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 2))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 3))))),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 657;BA.debugLine="clv.AsView.Color = cd";
Debug.ShouldStop(65536);
parent.mostCurrent._clv.runClassMethod (com.no3dlauncher.customlistview.class, "_asview").runMethod(true,"setColor",BA.numberCast(int.class, _cd));
 BA.debugLineNum = 660;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
Debug.ShouldStop(524288);
if (true) break;

case 1:
//for
this.state = 8;
step14 = 1;
limit14 = RemoteObject.solve(new RemoteObject[] {parent.mostCurrent._starter._mapa.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
this.state = 10;
if (true) break;

case 10:
//C
this.state = 8;
if ((step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14)) this.state = 3;
if (true) break;

case 11:
//C
this.state = 10;
_i = ((int)(0 + _i + step14)) ;
Debug.locals.put("i", _i);
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 661;BA.debugLine="Dim pckg1, pckg2 As String";
Debug.ShouldStop(1048576);
_pckg1 = RemoteObject.createImmutable("");Debug.locals.put("pckg1", _pckg1);
_pckg2 = RemoteObject.createImmutable("");Debug.locals.put("pckg2", _pckg2);
 BA.debugLineNum = 662;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
Debug.ShouldStop(2097152);
_pckg = BA.ObjectToString(parent.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("pckg", _pckg);Debug.locals.put("pckg", _pckg);
 BA.debugLineNum = 663;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pck";
Debug.ShouldStop(4194304);
_pckg1 = _pckg.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";"))),RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(_pckg.runMethod(true,"length")));Debug.locals.put("pckg1", _pckg1);
 BA.debugLineNum = 664;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon(p";
Debug.ShouldStop(8388608);
_drawable = (_pm.runMethod(false,"GetApplicationIcon",(Object)(_pckg1)));Debug.locals.put("drawable", _drawable);Debug.locals.put("drawable", _drawable);
 BA.debugLineNum = 665;BA.debugLine="If drawable Is BitmapDrawable Then";
Debug.ShouldStop(16777216);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("i",_drawable, RemoteObject.createImmutable("android.graphics.drawable.BitmapDrawable"))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 666;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
Debug.ShouldStop(33554432);
_bdw = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
_bdw.setObject(_drawable);Debug.locals.put("bdw", _bdw);
 BA.debugLineNum = 667;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
Debug.ShouldStop(67108864);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp.setObject(_bdw.runMethod(false,"getBitmap"));Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 668;BA.debugLine="bdw.Initialize(bmp.Resize(32dip, 32dip, True))";
Debug.ShouldStop(134217728);
_bdw.runVoidMethod ("Initialize",(Object)((_bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))))),(Object)(BA.numberCast(float.class, parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32))))),(Object)(parent.mostCurrent.__c.getField(true,"True"))).getObject())));
 BA.debugLineNum = 669;BA.debugLine="pckg2 = pckg.SubString2(0, pckg.IndexOf(\";\"))";
Debug.ShouldStop(268435456);
_pckg2 = _pckg.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";")))));Debug.locals.put("pckg2", _pckg2);
 BA.debugLineNum = 670;BA.debugLine="clv.Add(KreirajStavku(bdw.Bitmap, pckg2, pnlMen";
Debug.ShouldStop(536870912);
parent.mostCurrent._clv.runClassMethod (com.no3dlauncher.customlistview.class, "_add",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _kreirajstavku(RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), _bdw.runMethod(false,"getBitmap")),_pckg2,parent.mostCurrent._pnlmeni.runMethod(true,"getWidth"),parent.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))).getObject()),(Object)((RemoteObject.createImmutable(""))));
 if (true) break;

case 7:
//C
this.state = 11;
;
 if (true) break;
if (true) break;

case 8:
//C
this.state = -1;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 674;BA.debugLine="Wait For clv_ItemClick (Index As Int, Value As Ob";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","clv_itemclick", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), null);
this.state = 12;
return;
case 12:
//C
this.state = -1;
_index = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Index", _index);
_value = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(1));Debug.locals.put("Value", _value);
;
 BA.debugLineNum = 675;BA.debugLine="Log(\"Selected item: \" & Value)";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Selected item: "),_value)));
 BA.debugLineNum = 677;BA.debugLine="Wait For ivClvDodaj_Click";
Debug.ShouldStop(16);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","ivclvdodaj_click", main.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this), null);
this.state = 13;
return;
case 13:
//C
this.state = -1;
;
 BA.debugLineNum = 680;BA.debugLine="End Sub";
Debug.ShouldStop(128);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _filtrirajimenaappiimenapaketa() throws Exception{
try {
		Debug.PushSubsStack("FiltrirajImenaAppIImenaPaketa (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,853);
if (RapidSub.canDelegate("filtrirajimenaappiimenapaketa")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","filtrirajimenaappiimenapaketa");
int _i = 0;
RemoteObject _pckg1 = RemoteObject.createImmutable("");
RemoteObject _pckg = RemoteObject.createImmutable("");
 BA.debugLineNum = 853;BA.debugLine="Sub FiltrirajImenaAppIImenaPaketa";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 854;BA.debugLine="l1.Initialize";
Debug.ShouldStop(2097152);
main.mostCurrent._l1.runVoidMethod ("Initialize");
 BA.debugLineNum = 855;BA.debugLine="Dim l As List";
Debug.ShouldStop(4194304);
main.mostCurrent._l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 856;BA.debugLine="l.Initialize";
Debug.ShouldStop(8388608);
main.mostCurrent._l.runVoidMethod ("Initialize");
 BA.debugLineNum = 857;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
Debug.ShouldStop(16777216);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._starter._mapa.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 858;BA.debugLine="Dim pckg1 As String";
Debug.ShouldStop(33554432);
_pckg1 = RemoteObject.createImmutable("");Debug.locals.put("pckg1", _pckg1);
 BA.debugLineNum = 859;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
Debug.ShouldStop(67108864);
_pckg = BA.ObjectToString(main.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("pckg", _pckg);Debug.locals.put("pckg", _pckg);
 BA.debugLineNum = 860;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pck";
Debug.ShouldStop(134217728);
_pckg1 = _pckg.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";"))),RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(_pckg.runMethod(true,"length")));Debug.locals.put("pckg1", _pckg1);
 BA.debugLineNum = 862;BA.debugLine="l1.Add(pckg1)";
Debug.ShouldStop(536870912);
main.mostCurrent._l1.runVoidMethod ("Add",(Object)((_pckg1)));
 BA.debugLineNum = 863;BA.debugLine="pckg1 = pckg.SubString2(0, pckg.IndexOf(\";\"))";
Debug.ShouldStop(1073741824);
_pckg1 = _pckg.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";")))));Debug.locals.put("pckg1", _pckg1);
 BA.debugLineNum = 865;BA.debugLine="l.Add(pckg1)";
Debug.ShouldStop(1);
main.mostCurrent._l.runVoidMethod ("Add",(Object)((_pckg1)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 867;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getalltablabels(RemoteObject _tabstrip) throws Exception{
try {
		Debug.PushSubsStack("GetAllTabLabels (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,253);
if (RapidSub.canDelegate("getalltablabels")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","getalltablabels", _tabstrip);
RemoteObject _jo = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _tc = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _v = RemoteObject.declareNull("anywheresoftware.b4a.objects.ConcreteViewWrapper");
Debug.locals.put("tabstrip", _tabstrip);
 BA.debugLineNum = 253;BA.debugLine="Public Sub GetAllTabLabels (tabstrip As TabStrip)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 254;BA.debugLine="Dim jo As JavaObject = tabstrip";
Debug.ShouldStop(536870912);
_jo = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jo.setObject(_tabstrip);Debug.locals.put("jo", _jo);
 BA.debugLineNum = 255;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(1073741824);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 256;BA.debugLine="r.Target = jo.GetField(\"tabStrip\")";
Debug.ShouldStop(-2147483648);
_r.setField ("Target",_jo.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("tabStrip"))));
 BA.debugLineNum = 257;BA.debugLine="Dim tc As Panel = r.GetField(\"tabsContainer\")";
Debug.ShouldStop(1);
_tc = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
_tc.setObject(_r.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("tabsContainer"))));Debug.locals.put("tc", _tc);
 BA.debugLineNum = 258;BA.debugLine="Dim res As List";
Debug.ShouldStop(2);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 259;BA.debugLine="res.Initialize";
Debug.ShouldStop(4);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 260;BA.debugLine="For Each v As View In tc";
Debug.ShouldStop(8);
_v = RemoteObject.createNew ("anywheresoftware.b4a.objects.ConcreteViewWrapper");
{
final RemoteObject group7 = _tc;
final int groupLen7 = group7.runMethod(true,"getSize").<Integer>get()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_v.setObject(group7.runMethod(false,"Get",index7));
Debug.locals.put("v", _v);
 BA.debugLineNum = 261;BA.debugLine="If v Is Label Then res.Add(v)";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TextView"))) { 
_res.runVoidMethod ("Add",(Object)((_v.getObject())));};
 }
}Debug.locals.put("v", _v);
;
 BA.debugLineNum = 264;BA.debugLine="Return res";
Debug.ShouldStop(128);
if (true) return _res;
 BA.debugLineNum = 265;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getargb(RemoteObject _color) throws Exception{
try {
		Debug.PushSubsStack("getARGB (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1424);
if (RapidSub.canDelegate("getargb")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","getargb", _color);
RemoteObject _res = null;
Debug.locals.put("Color", _color);
 BA.debugLineNum = 1424;BA.debugLine="Sub getARGB(Color As Int) As Int()";
Debug.ShouldStop(32768);
 BA.debugLineNum = 1425;BA.debugLine="Dim res(4) As Int";
Debug.ShouldStop(65536);
_res = RemoteObject.createNewArray ("int", new int[] {4}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 1427;BA.debugLine="res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
Debug.ShouldStop(262144);
_res.setArrayElement (main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"UnsignedShiftRight",(Object)(main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_color),(Object)(BA.numberCast(int.class, 0xff000000)))),(Object)(BA.numberCast(int.class, 24))),BA.numberCast(int.class, 0));
 BA.debugLineNum = 1428;BA.debugLine="res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
Debug.ShouldStop(524288);
_res.setArrayElement (main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"UnsignedShiftRight",(Object)(main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_color),(Object)(BA.numberCast(int.class, 0xff0000)))),(Object)(BA.numberCast(int.class, 16))),BA.numberCast(int.class, 1));
 BA.debugLineNum = 1429;BA.debugLine="res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
Debug.ShouldStop(1048576);
_res.setArrayElement (main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"UnsignedShiftRight",(Object)(main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_color),(Object)(BA.numberCast(int.class, 0xff00)))),(Object)(BA.numberCast(int.class, 8))),BA.numberCast(int.class, 2));
 BA.debugLineNum = 1430;BA.debugLine="res(3) = Bit.And(Color, 0xff)";
Debug.ShouldStop(2097152);
_res.setArrayElement (main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_color),(Object)(BA.numberCast(int.class, 0xff))),BA.numberCast(int.class, 3));
 BA.debugLineNum = 1432;BA.debugLine="Return res";
Debug.ShouldStop(8388608);
if (true) return _res;
 BA.debugLineNum = 1433;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 42;BA.debugLine="Private pnlDock As Panel";
main.mostCurrent._pnldock = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private btnDock As Button";
main.mostCurrent._btndock = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private scvDock As HorizontalScrollView";
main.mostCurrent._scvdock = RemoteObject.createNew ("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Dim pnl_dock_vidljiv As Boolean = True";
main._pnl_dock_vidljiv = main.mostCurrent.__c.getField(true,"True");
 //BA.debugLineNum = 47;BA.debugLine="Private btnMeni As Button";
main.mostCurrent._btnmeni = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private btnWidgeti As Button";
main.mostCurrent._btnwidgeti = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private pnlMeni As Panel";
main.mostCurrent._pnlmeni = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Dim zadnja_oznacena_app As Int = 0";
main._zadnja_oznacena_app = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 52;BA.debugLine="Private wp1 As WheelPicker";
main.mostCurrent._wp1 = RemoteObject.createNew ("wheelpickerwrapper.wheelpickerWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Dim l, l1 As List";
main.mostCurrent._l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
main.mostCurrent._l1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 56;BA.debugLine="Dim clv As CustomListView";
main.mostCurrent._clv = RemoteObject.createNew ("com.no3dlauncher.customlistview");
 //BA.debugLineNum = 57;BA.debugLine="Private lblImeApp As Label";
main.mostCurrent._lblimeapp = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private ivApp As ImageView";
main.mostCurrent._ivapp = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private ivDodaj, ivWheelDodaj As ImageView";
main.mostCurrent._ivdodaj = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
main.mostCurrent._ivwheeldodaj = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Dim iv_size As List";
main.mostCurrent._iv_size = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 61;BA.debugLine="Dim listaFavorita As List	' imena paketa";
main.mostCurrent._listafavorita = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
 //BA.debugLineNum = 62;BA.debugLine="Dim lbl As Label";
main.mostCurrent._lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Private btnSearch As Button";
main.mostCurrent._btnsearch = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private btnPostavke As Button";
main.mostCurrent._btnpostavke = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 75;BA.debugLine="Private btnNotify As Button";
main.mostCurrent._btnnotify = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 78;BA.debugLine="Dim sv As ScrollView";
main.mostCurrent._sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 80;BA.debugLine="Private TabStrip1 As TabStrip";
main.mostCurrent._tabstrip1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabStripViewPager");
 //BA.debugLineNum = 83;BA.debugLine="Dim topW As Int = 40dip";
main._topw = main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)));
 //BA.debugLineNum = 87;BA.debugLine="Private CustomListView1 As CustomListView";
main.mostCurrent._customlistview1 = RemoteObject.createNew ("com.no3dlauncher.customlistview");
 //BA.debugLineNum = 88;BA.debugLine="Private Panel1 As Panel";
main.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 89;BA.debugLine="Dim ipsilon As Int";
main._ipsilon = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 92;BA.debugLine="Private btnDodajWidget As Button";
main.mostCurrent._btndodajwidget = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 93;BA.debugLine="Private btnDodajStr As Button";
main.mostCurrent._btndodajstr = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 94;BA.debugLine="Private btnNatrag As Button";
main.mostCurrent._btnnatrag = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 95;BA.debugLine="Private btnNaprijed As Button";
main.mostCurrent._btnnaprijed = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 99;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 109;BA.debugLine="Dim cr As ContentResolver";
main.mostCurrent._cr = RemoteObject.createNew ("anywheresoftware.b4a.objects.ContentResolverWrapper");
 //BA.debugLineNum = 110;BA.debugLine="Private btnPostavkeKontakti As Button";
main.mostCurrent._btnpostavkekontakti = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 120;BA.debugLine="Private pnlKontakti As Panel";
main.mostCurrent._pnlkontakti = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 121;BA.debugLine="Private grid As CustomGridView";
main.mostCurrent._grid = RemoteObject.createNew ("njdude.customgridview.library.customgridview");
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _ivappmain_click() throws Exception{
try {
		Debug.PushSubsStack("ivAppMain_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,774);
if (RapidSub.canDelegate("ivappmain_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","ivappmain_click");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
 BA.debugLineNum = 774;BA.debugLine="Sub ivAppMain_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 775;BA.debugLine="Dim in As Intent";
Debug.ShouldStop(64);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("in", _in);
 BA.debugLineNum = 776;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(128);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 777;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(256);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 779;BA.debugLine="iv = Sender";
Debug.ShouldStop(1024);
_iv.setObject(main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 780;BA.debugLine="Log(iv.Tag)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_iv.runMethod(false,"getTag"))));
 BA.debugLineNum = 781;BA.debugLine="in = pm.GetApplicationIntent(iv.Tag)";
Debug.ShouldStop(4096);
_in = _pm.runMethod(false,"GetApplicationIntent",(Object)(BA.ObjectToString(_iv.runMethod(false,"getTag"))));Debug.locals.put("in", _in);
 BA.debugLineNum = 782;BA.debugLine="If in.IsInitialized Then";
Debug.ShouldStop(8192);
if (_in.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 785;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(65536);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_in.getObject())));
 };
 BA.debugLineNum = 787;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ivappmain_longclick() throws Exception{
try {
		Debug.PushSubsStack("ivAppMain_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,738);
if (RapidSub.canDelegate("ivappmain_longclick")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","ivappmain_longclick");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _ll = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _x = RemoteObject.declareNull("com.maximus.id.id");
RemoteObject _m = RemoteObject.createImmutable(0);
 BA.debugLineNum = 738;BA.debugLine="Sub ivAppMain_LongClick";
Debug.ShouldStop(2);
 BA.debugLineNum = 739;BA.debugLine="Log(\"ivapp long klik!\")";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("ivapp long klik!")));
 BA.debugLineNum = 740;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(8);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 741;BA.debugLine="iv = Sender";
Debug.ShouldStop(16);
_iv.setObject(main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 742;BA.debugLine="Log(iv.Tag)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_iv.runMethod(false,"getTag"))));
 BA.debugLineNum = 743;BA.debugLine="Dim ll As List";
Debug.ShouldStop(64);
_ll = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ll", _ll);
 BA.debugLineNum = 744;BA.debugLine="ll.Initialize";
Debug.ShouldStop(128);
_ll.runVoidMethod ("Initialize");
 BA.debugLineNum = 745;BA.debugLine="ll.AddAll(Array As String(\"Add to favorites\", \"Un";
Debug.ShouldStop(256);
_ll.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("Add to favorites"),RemoteObject.createImmutable("Uninstall")})))));
 BA.debugLineNum = 746;BA.debugLine="Dim x As id";
Debug.ShouldStop(512);
_x = RemoteObject.createNew ("com.maximus.id.id");Debug.locals.put("x", _x);
 BA.debugLineNum = 747;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
Debug.ShouldStop(1024);
_m = _x.runMethodAndSync(true,"InputList1",(Object)(_ll),(Object)(RemoteObject.createImmutable("")),main.mostCurrent.activityBA);Debug.locals.put("m", _m);Debug.locals.put("m", _m);
 BA.debugLineNum = 748;BA.debugLine="Select m";
Debug.ShouldStop(2048);
switch (BA.switchObjectToInt(_m,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1))) {
case 0: {
 BA.debugLineNum = 750;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(za";
Debug.ShouldStop(8192);
_provjeraappufavoritima(BA.ObjectToString(main.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(main._zadnja_oznacena_app))));
 BA.debugLineNum = 751;BA.debugLine="DodajAppUFavorite";
Debug.ShouldStop(16384);
_dodajappufavorite();
 break; }
case 1: {
 BA.debugLineNum = 753;BA.debugLine="UninstallApp(iv.Tag)";
Debug.ShouldStop(65536);
_uninstallapp(BA.ObjectToString(_iv.runMethod(false,"getTag")));
 break; }
}
;
 BA.debugLineNum = 755;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ivclvdodaj_click() throws Exception{
try {
		Debug.PushSubsStack("ivClvDodaj_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1435);
if (RapidSub.canDelegate("ivclvdodaj_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","ivclvdodaj_click");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _imgv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _index = RemoteObject.createImmutable(0);
RemoteObject _pckg1 = RemoteObject.createImmutable("");
RemoteObject _pckg = RemoteObject.createImmutable("");
RemoteObject _bdw = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 BA.debugLineNum = 1435;BA.debugLine="Sub ivClvDodaj_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 1436;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(134217728);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 1437;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(268435456);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 1439;BA.debugLine="If lbl.IsInitialized Then lbl.RemoveView";
Debug.ShouldStop(1073741824);
if (main.mostCurrent._lbl.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
main.mostCurrent._lbl.runVoidMethod ("RemoveView");};
 BA.debugLineNum = 1441;BA.debugLine="Private imgV As ImageView = Sender";
Debug.ShouldStop(1);
_imgv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
_imgv.setObject(main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));Debug.locals.put("imgV", _imgv);
 BA.debugLineNum = 1442;BA.debugLine="Private Index As Int = clv.GetItemFromView(Sender";
Debug.ShouldStop(2);
_index = main.mostCurrent._clv.runClassMethod (com.no3dlauncher.customlistview.class, "_getitemfromview",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA)));Debug.locals.put("Index", _index);Debug.locals.put("Index", _index);
 BA.debugLineNum = 1444;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(Inde";
Debug.ShouldStop(8);
_provjeraappufavoritima(BA.ObjectToString(main.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(_index))));
 BA.debugLineNum = 1446;BA.debugLine="iv.Initialize(\"ivMainApp\")";
Debug.ShouldStop(32);
_iv.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ivMainApp")));
 BA.debugLineNum = 1447;BA.debugLine="iv.Tag = scvDock.Panel.NumberOfViews";
Debug.ShouldStop(64);
_iv.runMethod(false,"setTag",(main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"getNumberOfViews")));
 BA.debugLineNum = 1448;BA.debugLine="iv.Width = 48dip";
Debug.ShouldStop(128);
_iv.runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))));
 BA.debugLineNum = 1449;BA.debugLine="iv.Height = 48dip";
Debug.ShouldStop(256);
_iv.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))));
 BA.debugLineNum = 1450;BA.debugLine="iv.Gravity = Gravity.FILL";
Debug.ShouldStop(512);
_iv.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 1452;BA.debugLine="Dim pckg1 As String";
Debug.ShouldStop(2048);
_pckg1 = RemoteObject.createImmutable("");Debug.locals.put("pckg1", _pckg1);
 BA.debugLineNum = 1453;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(Index)";
Debug.ShouldStop(4096);
_pckg = BA.ObjectToString(main.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(_index)));Debug.locals.put("pckg", _pckg);Debug.locals.put("pckg", _pckg);
 BA.debugLineNum = 1454;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pckg";
Debug.ShouldStop(8192);
_pckg1 = _pckg.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";"))),RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(_pckg.runMethod(true,"length")));Debug.locals.put("pckg1", _pckg1);
 BA.debugLineNum = 1455;BA.debugLine="Dim bdw As BitmapDrawable = pm.GetApplicationIcon";
Debug.ShouldStop(16384);
_bdw = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
_bdw.setObject(_pm.runMethod(false,"GetApplicationIcon",(Object)(_pckg1)));Debug.locals.put("bdw", _bdw);
 BA.debugLineNum = 1456;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
Debug.ShouldStop(32768);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp.setObject(_bdw.runMethod(false,"getBitmap"));Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 1457;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True))";
Debug.ShouldStop(65536);
_bdw.runVoidMethod ("Initialize",(Object)((_bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))))),(Object)(main.mostCurrent.__c.getField(true,"True"))).getObject())));
 BA.debugLineNum = 1458;BA.debugLine="listaFavorita.Add(pckg1)	' dodaj ime paketa aplik";
Debug.ShouldStop(131072);
main.mostCurrent._listafavorita.runVoidMethod ("Add",(Object)((_pckg1)));
 BA.debugLineNum = 1461;BA.debugLine="iv.Bitmap = bdw.Bitmap'bm1";
Debug.ShouldStop(1048576);
_iv.runMethod(false,"setBitmap",_bdw.runMethod(false,"getBitmap"));
 BA.debugLineNum = 1462;BA.debugLine="scvDock.Panel.AddView(iv, iv.Width*scvDock.Panel.";
Debug.ShouldStop(2097152);
main.mostCurrent._scvdock.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_iv.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_iv.runMethod(true,"getWidth"),main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"getNumberOfViews")}, "*",0, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))),(Object)(_iv.runMethod(true,"getWidth")),(Object)(_iv.runMethod(true,"getHeight")));
 BA.debugLineNum = 1551;BA.debugLine="imgV.Bitmap = LoadBitmap(File.DirAssets, \"act_add";
Debug.ShouldStop(16384);
_imgv.runMethod(false,"setBitmap",(main.mostCurrent.__c.runMethod(false,"LoadBitmap",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("act_add_pressed.png"))).getObject()));
 BA.debugLineNum = 1553;BA.debugLine="File.WriteList(File.DirInternal, \"favorit_app\", l";
Debug.ShouldStop(65536);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("favorit_app")),(Object)(main.mostCurrent._listafavorita));
 BA.debugLineNum = 1555;BA.debugLine="ToastMessageShow(\"Application added to favorites.";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Application added to favorites.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 1556;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ivdokpokreniapp_click() throws Exception{
try {
		Debug.PushSubsStack("ivDokPokreniApp_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1569);
if (RapidSub.canDelegate("ivdokpokreniapp_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","ivdokpokreniapp_click");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
 BA.debugLineNum = 1569;BA.debugLine="Sub ivDokPokreniApp_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 1570;BA.debugLine="Log(\"klik!\")";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("klik!")));
 BA.debugLineNum = 1571;BA.debugLine="Dim in As Intent";
Debug.ShouldStop(4);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("in", _in);
 BA.debugLineNum = 1572;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(8);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 1573;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(16);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 1575;BA.debugLine="iv = Sender";
Debug.ShouldStop(64);
_iv.setObject(main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 1576;BA.debugLine="Log(iv.Tag)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_iv.runMethod(false,"getTag"))));
 BA.debugLineNum = 1578;BA.debugLine="Log(listaFavorita.Get(iv.Tag))";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(main.mostCurrent._listafavorita.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _iv.runMethod(false,"getTag")))))));
 BA.debugLineNum = 1579;BA.debugLine="in = pm.GetApplicationIntent(listaFavorita.Get(iv";
Debug.ShouldStop(1024);
_in = _pm.runMethod(false,"GetApplicationIntent",(Object)(BA.ObjectToString(main.mostCurrent._listafavorita.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _iv.runMethod(false,"getTag")))))));Debug.locals.put("in", _in);
 BA.debugLineNum = 1580;BA.debugLine="If in.IsInitialized Then";
Debug.ShouldStop(2048);
if (_in.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 1583;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_in.getObject())));
 };
 BA.debugLineNum = 1585;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ivwheeldodaj_click() throws Exception{
try {
		Debug.PushSubsStack("ivWheelDodaj_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1098);
if (RapidSub.canDelegate("ivwheeldodaj_click")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","ivwheeldodaj_click");
 BA.debugLineNum = 1098;BA.debugLine="Sub ivWheelDodaj_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 1099;BA.debugLine="Log(\"vil dodaj klik!\")";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("vil dodaj klik!")));
 BA.debugLineNum = 1101;BA.debugLine="ivWheelDodaj.BringToFront";
Debug.ShouldStop(4096);
main.mostCurrent._ivwheeldodaj.runVoidMethod ("BringToFront");
 BA.debugLineNum = 1106;BA.debugLine="If lbl.IsInitialized Then lbl.RemoveView";
Debug.ShouldStop(131072);
if (main.mostCurrent._lbl.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
main.mostCurrent._lbl.runVoidMethod ("RemoveView");};
 BA.debugLineNum = 1117;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(zadn";
Debug.ShouldStop(268435456);
_provjeraappufavoritima(BA.ObjectToString(main.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(main._zadnja_oznacena_app))));
 BA.debugLineNum = 1118;BA.debugLine="DodajAppUFavorite";
Debug.ShouldStop(536870912);
_dodajappufavorite();
 BA.debugLineNum = 1216;BA.debugLine="File.WriteList(File.DirInternal, \"favorit_app\", l";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("favorit_app")),(Object)(main.mostCurrent._listafavorita));
 BA.debugLineNum = 1217;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _kontaktigrid_finishedloading() throws Exception{
try {
		Debug.PushSubsStack("kontaktiGrid_FinishedLoading (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2651);
if (RapidSub.canDelegate("kontaktigrid_finishedloading")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","kontaktigrid_finishedloading");
 BA.debugLineNum = 2651;BA.debugLine="Sub kontaktiGrid_FinishedLoading";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 2652;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 2653;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _kontaktigrid_itemclicked(RemoteObject _item) throws Exception{
try {
		Debug.PushSubsStack("kontaktiGrid_ItemClicked (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2631);
if (RapidSub.canDelegate("kontaktigrid_itemclicked")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","kontaktigrid_itemclicked", _item);
RemoteObject _ll = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _x = RemoteObject.declareNull("com.maximus.id.id");
RemoteObject _m = RemoteObject.createImmutable(0);
Debug.locals.put("Item", _item);
 BA.debugLineNum = 2631;BA.debugLine="Sub kontaktiGrid_ItemClicked(Item As String)";
Debug.ShouldStop(64);
 BA.debugLineNum = 2632;BA.debugLine="Log(Item)";
Debug.ShouldStop(128);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_item));
 BA.debugLineNum = 2633;BA.debugLine="Dim ll As List";
Debug.ShouldStop(256);
_ll = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ll", _ll);
 BA.debugLineNum = 2634;BA.debugLine="ll.Initialize";
Debug.ShouldStop(512);
_ll.runVoidMethod ("Initialize");
 BA.debugLineNum = 2635;BA.debugLine="ll.AddAll(Array As String(\"Call\", \"SMS\", \"EMail\",";
Debug.ShouldStop(1024);
_ll.runVoidMethod ("AddAll",(Object)(main.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("Call"),BA.ObjectToString("SMS"),BA.ObjectToString("EMail"),RemoteObject.createImmutable("Info")})))));
 BA.debugLineNum = 2636;BA.debugLine="Dim x As id";
Debug.ShouldStop(2048);
_x = RemoteObject.createNew ("com.maximus.id.id");Debug.locals.put("x", _x);
 BA.debugLineNum = 2637;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
Debug.ShouldStop(4096);
_m = _x.runMethodAndSync(true,"InputList1",(Object)(_ll),(Object)(RemoteObject.createImmutable("")),main.mostCurrent.activityBA);Debug.locals.put("m", _m);Debug.locals.put("m", _m);
 BA.debugLineNum = 2638;BA.debugLine="Log(m)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_m)));
 BA.debugLineNum = 2639;BA.debugLine="Select m";
Debug.ShouldStop(16384);
switch (BA.switchObjectToInt(_m,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2),BA.numberCast(int.class, 3))) {
case 0: {
 BA.debugLineNum = 2641;BA.debugLine="btnKontaktPoziv_Click(Item.Replace(\"file:///\",";
Debug.ShouldStop(65536);
_btnkontaktpoziv_click(_item.runMethod(true,"replace",(Object)(BA.ObjectToString("file:///")),(Object)(RemoteObject.createImmutable(""))));
 break; }
case 1: {
 BA.debugLineNum = 2643;BA.debugLine="btnKontaktSMS_Click(Item.Replace(\"file:///\", \"\"";
Debug.ShouldStop(262144);
_btnkontaktsms_click(_item.runMethod(true,"replace",(Object)(BA.ObjectToString("file:///")),(Object)(RemoteObject.createImmutable(""))));
 break; }
case 2: {
 BA.debugLineNum = 2645;BA.debugLine="btnKontaktEmail_Click(Item.Replace(\"file:///\",";
Debug.ShouldStop(1048576);
_btnkontaktemail_click(_item.runMethod(true,"replace",(Object)(BA.ObjectToString("file:///")),(Object)(RemoteObject.createImmutable(""))));
 break; }
case 3: {
 BA.debugLineNum = 2647;BA.debugLine="btnKontaktInfo_Click(Item.Replace(\"file:///\", \"";
Debug.ShouldStop(4194304);
_btnkontaktinfo_click(_item.runMethod(true,"replace",(Object)(BA.ObjectToString("file:///")),(Object)(RemoteObject.createImmutable(""))));
 break; }
}
;
 BA.debugLineNum = 2649;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _kreirajstavku(RemoteObject _b,RemoteObject _imeapp,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("KreirajStavku (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1323);
if (RapidSub.canDelegate("kreirajstavku")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","kreirajstavku", _b, _imeapp, _width, _height);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
Debug.locals.put("b", _b);
Debug.locals.put("imeApp", _imeapp);
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 1323;BA.debugLine="Sub KreirajStavku(b As Bitmap, imeApp As String, W";
Debug.ShouldStop(1024);
 BA.debugLineNum = 1324;BA.debugLine="Dim p As Panel";
Debug.ShouldStop(2048);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 1326;BA.debugLine="p.Initialize(\"\")";
Debug.ShouldStop(8192);
_p.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 1327;BA.debugLine="p.Color = Colors.Transparent";
Debug.ShouldStop(16384);
_p.runVoidMethod ("setColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Transparent"));
 BA.debugLineNum = 1328;BA.debugLine="p.SetLayout(0, btnPostavke.Height, Width, Height)";
Debug.ShouldStop(32768);
_p.runVoidMethod ("SetLayout",(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent._btnpostavke.runMethod(true,"getHeight")),(Object)(_width),(Object)(_height));
 BA.debugLineNum = 1329;BA.debugLine="p.LoadLayout(\"clv_stavka\")";
Debug.ShouldStop(65536);
_p.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("clv_stavka")),main.mostCurrent.activityBA);
 BA.debugLineNum = 1331;BA.debugLine="ivApp.Bitmap = b";
Debug.ShouldStop(262144);
main.mostCurrent._ivapp.runMethod(false,"setBitmap",(_b.getObject()));
 BA.debugLineNum = 1332;BA.debugLine="lblImeApp.TextSize = f.fontzSize";
Debug.ShouldStop(524288);
main.mostCurrent._lblimeapp.runMethod(true,"setTextSize",BA.numberCast(float.class, main.mostCurrent._f._fontzsize));
 BA.debugLineNum = 1333;BA.debugLine="lblImeApp.Typeface = Typeface.LoadFromAssets(f.wh";
Debug.ShouldStop(1048576);
main.mostCurrent._lblimeapp.runMethod(false,"setTypeface",main.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(main.mostCurrent._f._wheellistfont,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 1334;BA.debugLine="lblImeApp.Text = imeApp";
Debug.ShouldStop(2097152);
main.mostCurrent._lblimeapp.runMethod(true,"setText",BA.ObjectToCharSequence(_imeapp));
 BA.debugLineNum = 1335;BA.debugLine="lblImeApp.TextColor = f.bojaFonta";
Debug.ShouldStop(4194304);
main.mostCurrent._lblimeapp.runMethod(true,"setTextColor",main.mostCurrent._f._bojafonta);
 BA.debugLineNum = 1337;BA.debugLine="Return p";
Debug.ShouldStop(16777216);
if (true) return _p;
 BA.debugLineNum = 1338;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _lblimeapp_longclick() throws Exception{
try {
		Debug.PushSubsStack("lblImeApp_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1420);
if (RapidSub.canDelegate("lblimeapp_longclick")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","lblimeapp_longclick");
 BA.debugLineNum = 1420;BA.debugLine="Sub lblImeApp_LongClick";
Debug.ShouldStop(2048);
 BA.debugLineNum = 1421;BA.debugLine="Log(\"lblimeapp long klik!\")";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("lblimeapp long klik!")));
 BA.debugLineNum = 1422;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _osvjezi() throws Exception{
try {
		Debug.PushSubsStack("Osvjezi (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1359);
if (RapidSub.canDelegate("osvjezi")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","osvjezi");
 BA.debugLineNum = 1359;BA.debugLine="Sub Osvjezi";
Debug.ShouldStop(16384);
 BA.debugLineNum = 1360;BA.debugLine="f.UcitajVrijednostiOpt";
Debug.ShouldStop(32768);
main.mostCurrent._f.runVoidMethod ("_ucitajvrijednostiopt",main.mostCurrent.activityBA);
 BA.debugLineNum = 1362;BA.debugLine="ViewsBringToFront";
Debug.ShouldStop(131072);
_viewsbringtofront();
 BA.debugLineNum = 1364;BA.debugLine="If scvDock.IsInitialized Then scvDock.Panel.Remov";
Debug.ShouldStop(524288);
if (main.mostCurrent._scvdock.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
main.mostCurrent._scvdock.runMethod(false,"getPanel").runVoidMethod ("RemoveAllViews");};
 BA.debugLineNum = 1370;BA.debugLine="ShowFavoriteApps";
Debug.ShouldStop(33554432);
_showfavoriteapps();
 BA.debugLineNum = 1406;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _prikazilistubrojevatelefona(RemoteObject _listabrojeva) throws Exception{
try {
		Debug.PushSubsStack("PrikaziListuBrojevaTelefona (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2911);
if (RapidSub.canDelegate("prikazilistubrojevatelefona")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","prikazilistubrojevatelefona", _listabrojeva);
RemoteObject _x = RemoteObject.declareNull("com.maximus.id.id");
RemoteObject _m = RemoteObject.createImmutable(0);
Debug.locals.put("listaBrojeva", _listabrojeva);
 BA.debugLineNum = 2911;BA.debugLine="Sub PrikaziListuBrojevaTelefona(listaBrojeva As Li";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 2912;BA.debugLine="Dim x As id";
Debug.ShouldStop(-2147483648);
_x = RemoteObject.createNew ("com.maximus.id.id");Debug.locals.put("x", _x);
 BA.debugLineNum = 2913;BA.debugLine="Dim m As Int = x.InputList1(listaBrojeva, \"\")";
Debug.ShouldStop(1);
_m = _x.runMethodAndSync(true,"InputList1",(Object)(_listabrojeva),(Object)(RemoteObject.createImmutable("")),main.mostCurrent.activityBA);Debug.locals.put("m", _m);Debug.locals.put("m", _m);
 BA.debugLineNum = 2916;BA.debugLine="If m >= 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("g",_m,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 2917;BA.debugLine="Return listaBrojeva.Get(m)";
Debug.ShouldStop(16);
if (true) return BA.ObjectToString(_listabrojeva.runMethod(false,"Get",(Object)(_m)));
 }else {
 BA.debugLineNum = 2919;BA.debugLine="Return False";
Debug.ShouldStop(64);
if (true) return BA.ObjectToString(main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 2921;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _prikazilistuemailadresaudijalogu(RemoteObject _listaadresa) throws Exception{
try {
		Debug.PushSubsStack("PrikaziListuEmailAdresaUDijalogu (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2899);
if (RapidSub.canDelegate("prikazilistuemailadresaudijalogu")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","prikazilistuemailadresaudijalogu", _listaadresa);
RemoteObject _x = RemoteObject.declareNull("com.maximus.id.id");
RemoteObject _m = RemoteObject.createImmutable(0);
Debug.locals.put("listaAdresa", _listaadresa);
 BA.debugLineNum = 2899;BA.debugLine="Sub PrikaziListuEmailAdresaUDijalogu(listaAdresa A";
Debug.ShouldStop(262144);
 BA.debugLineNum = 2900;BA.debugLine="Dim x As id";
Debug.ShouldStop(524288);
_x = RemoteObject.createNew ("com.maximus.id.id");Debug.locals.put("x", _x);
 BA.debugLineNum = 2901;BA.debugLine="Dim m As Int = x.InputList1(listaAdresa, \"\")";
Debug.ShouldStop(1048576);
_m = _x.runMethodAndSync(true,"InputList1",(Object)(_listaadresa),(Object)(RemoteObject.createImmutable("")),main.mostCurrent.activityBA);Debug.locals.put("m", _m);Debug.locals.put("m", _m);
 BA.debugLineNum = 2904;BA.debugLine="If m >= 0 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("g",_m,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 2905;BA.debugLine="Return listaAdresa.Get(m)";
Debug.ShouldStop(16777216);
if (true) return BA.ObjectToString(_listaadresa.runMethod(false,"Get",(Object)(_m)));
 }else {
 BA.debugLineNum = 2907;BA.debugLine="Return False";
Debug.ShouldStop(67108864);
if (true) return BA.ObjectToString(main.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 2909;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
pnlmeni_postavke_subs_0._process_globals();
search_subs_0._process_globals();
notificationservice_subs_0._process_globals();
postavke_kontakti_subs_0._process_globals();
f_subs_0._process_globals();
provjera_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("com.no3dlauncher.main");
starter.myClass = BA.getDeviceClass ("com.no3dlauncher.starter");
pnlmeni_postavke.myClass = BA.getDeviceClass ("com.no3dlauncher.pnlmeni_postavke");
search.myClass = BA.getDeviceClass ("com.no3dlauncher.search");
notificationservice.myClass = BA.getDeviceClass ("com.no3dlauncher.notificationservice");
postavke_kontakti.myClass = BA.getDeviceClass ("com.no3dlauncher.postavke_kontakti");
contactsutils.myClass = BA.getDeviceClass ("com.no3dlauncher.contactsutils");
f.myClass = BA.getDeviceClass ("com.no3dlauncher.f");
keyvaluestore.myClass = BA.getDeviceClass ("com.no3dlauncher.keyvaluestore");
provjera.myClass = BA.getDeviceClass ("com.no3dlauncher.provjera");
colorwheeldialog.myClass = BA.getDeviceClass ("com.no3dlauncher.colorwheeldialog");
customlistview.myClass = BA.getDeviceClass ("com.no3dlauncher.customlistview");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 26;BA.debugLine="Dim nativeMe As JavaObject";
main._nativeme = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
 //BA.debugLineNum = 29;BA.debugLine="Dim SmartWidgets As RSSmartWidgets";
main._smartwidgets = RemoteObject.createNew ("com.rootsoft.rssmartwidgets.RSSmartWidgets");
 //BA.debugLineNum = 33;BA.debugLine="Dim tajmer1 As Timer";
main._tajmer1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 34;BA.debugLine="Dim cu As ContactsUtils";
main._cu = RemoteObject.createNew ("com.no3dlauncher.contactsutils");
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _provjeraappufavoritima(RemoteObject _mapavrijednost) throws Exception{
try {
		Debug.PushSubsStack("ProvjeraAppUFavoritima (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1558);
if (RapidSub.canDelegate("provjeraappufavoritima")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","provjeraappufavoritima", _mapavrijednost);
RemoteObject _brappudoku = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _s = RemoteObject.createImmutable("");
Debug.locals.put("mapavrijednost", _mapavrijednost);
 BA.debugLineNum = 1558;BA.debugLine="Sub ProvjeraAppUFavoritima(mapavrijednost As Strin";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 1559;BA.debugLine="Dim brAppUDoku As Int = scvDock.Panel.NumberOfVie";
Debug.ShouldStop(4194304);
_brappudoku = main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"getNumberOfViews");Debug.locals.put("brAppUDoku", _brappudoku);Debug.locals.put("brAppUDoku", _brappudoku);
 BA.debugLineNum = 1561;BA.debugLine="For i = 0 To brAppUDoku - 1";
Debug.ShouldStop(16777216);
{
final int step2 = 1;
final int limit2 = RemoteObject.solve(new RemoteObject[] {_brappudoku,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2) ;_i = ((int)(0 + _i + step2))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 1562;BA.debugLine="Dim s As String = listaFavorita.Get(i)";
Debug.ShouldStop(33554432);
_s = BA.ObjectToString(main.mostCurrent._listafavorita.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 1563;BA.debugLine="If mapavrijednost.Contains(s) = True Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",_mapavrijednost.runMethod(true,"contains",(Object)(_s)),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 1564;BA.debugLine="ToastMessageShow(\"App already in favorites!\", F";
Debug.ShouldStop(134217728);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("App already in favorites!")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 1567;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scvpanel_longclick() throws Exception{
try {
		Debug.PushSubsStack("scvPanel_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,579);
if (RapidSub.canDelegate("scvpanel_longclick")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","scvpanel_longclick");
 BA.debugLineNum = 579;BA.debugLine="Sub scvPanel_LongClick";
Debug.ShouldStop(4);
 BA.debugLineNum = 580;BA.debugLine="Log(\"scvDock long klik\")";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("scvDock long klik")));
 BA.debugLineNum = 581;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scvpanel_touch(RemoteObject _vt_iv,RemoteObject _action,RemoteObject _x,RemoteObject _y,RemoteObject _motionevent) throws Exception{
try {
		Debug.PushSubsStack("scvPanel_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,583);
if (RapidSub.canDelegate("scvpanel_touch")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","scvpanel_touch", _vt_iv, _action, _x, _y, _motionevent);
RemoteObject _numlab = RemoteObject.createImmutable(0);
RemoteObject _iv1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _tag = RemoteObject.createImmutable("");
Debug.locals.put("vt_iv", _vt_iv);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
Debug.locals.put("MotionEvent", _motionevent);
 BA.debugLineNum = 583;BA.debugLine="Sub scvPanel_Touch(vt_iv As Object, Action As Int,";
Debug.ShouldStop(64);
 BA.debugLineNum = 584;BA.debugLine="Select Action";
Debug.ShouldStop(128);
switch (BA.switchObjectToInt(_action,main.mostCurrent._activity.getField(true,"ACTION_DOWN"))) {
case 0: {
 BA.debugLineNum = 586;BA.debugLine="If lbl.IsInitialized = False Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",main.mostCurrent._lbl.runMethod(true,"IsInitialized"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 587;BA.debugLine="Dim NumLab As Int = (X / 48dip)	' if labels ar";
Debug.ShouldStop(1024);
_numlab = BA.numberCast(int.class, (RemoteObject.solve(new RemoteObject[] {_x,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48)))}, "/",0, 0)));Debug.locals.put("NumLab", _numlab);Debug.locals.put("NumLab", _numlab);
 BA.debugLineNum = 588;BA.debugLine="Dim iv1 As ImageView = scvDock.Panel.getview(N";
Debug.ShouldStop(2048);
_iv1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
_iv1.setObject(main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(false,"GetView",(Object)(_numlab)).getObject());Debug.locals.put("iv1", _iv1);
 BA.debugLineNum = 589;BA.debugLine="Dim Tag As String = iv1.Tag";
Debug.ShouldStop(4096);
_tag = BA.ObjectToString(_iv1.runMethod(false,"getTag"));Debug.locals.put("Tag", _tag);Debug.locals.put("Tag", _tag);
 BA.debugLineNum = 590;BA.debugLine="Log(Tag)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(_tag));
 BA.debugLineNum = 591;BA.debugLine="Log(listaFavorita.Get(Tag))";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(main.mostCurrent._listafavorita.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _tag))))));
 };
 BA.debugLineNum = 593;BA.debugLine="Return True";
Debug.ShouldStop(65536);
if (true) return main.mostCurrent.__c.getField(true,"True");
 break; }
}
;
 BA.debugLineNum = 596;BA.debugLine="Return False";
Debug.ShouldStop(524288);
if (true) return main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 597;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _showfavoriteapps() throws Exception{
try {
		Debug.PushSubsStack("ShowFavoriteApps (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,358);
if (RapidSub.canDelegate("showfavoriteapps")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","showfavoriteapps");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
int _i = 0;
RemoteObject _bdw = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
 BA.debugLineNum = 358;BA.debugLine="Private Sub ShowFavoriteApps";
Debug.ShouldStop(32);
 BA.debugLineNum = 359;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(64);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 360;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(128);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 364;BA.debugLine="File.Delete(File.DirInternal, \"favorit_app\")";
Debug.ShouldStop(2048);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("favorit_app")));
 BA.debugLineNum = 365;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(4096);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 366;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
Debug.ShouldStop(8192);
_cd.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)))),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 367;BA.debugLine="If File.Exists(File.DirInternal, \"favorit_app\") T";
Debug.ShouldStop(16384);
if (main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("favorit_app"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 368;BA.debugLine="listaFavorita = File.ReadList(File.DirInternal,";
Debug.ShouldStop(32768);
main.mostCurrent._listafavorita = main.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("favorit_app")));
 BA.debugLineNum = 369;BA.debugLine="For i = 0 To listaFavorita.Size - 1";
Debug.ShouldStop(65536);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._listafavorita.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 387;BA.debugLine="iv.Initialize(\"ivDokPokreniApp\")";
Debug.ShouldStop(4);
_iv.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ivDokPokreniApp")));
 BA.debugLineNum = 389;BA.debugLine="iv.Tag = i";
Debug.ShouldStop(16);
_iv.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 390;BA.debugLine="iv.Width = 48dip";
Debug.ShouldStop(32);
_iv.runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))));
 BA.debugLineNum = 391;BA.debugLine="iv.Height = 48dip";
Debug.ShouldStop(64);
_iv.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))));
 BA.debugLineNum = 392;BA.debugLine="iv.Gravity = Gravity.FILL";
Debug.ShouldStop(128);
_iv.runMethod(true,"setGravity",main.mostCurrent.__c.getField(false,"Gravity").getField(true,"FILL"));
 BA.debugLineNum = 401;BA.debugLine="Dim bdw As BitmapDrawable = pm.GetApplicationIc";
Debug.ShouldStop(65536);
_bdw = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
_bdw.setObject(_pm.runMethod(false,"GetApplicationIcon",(Object)(BA.ObjectToString(main.mostCurrent._listafavorita.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i)))))));Debug.locals.put("bdw", _bdw);
 BA.debugLineNum = 402;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
Debug.ShouldStop(131072);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp.setObject(_bdw.runMethod(false,"getBitmap"));Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 403;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True))";
Debug.ShouldStop(262144);
_bdw.runVoidMethod ("Initialize",(Object)((_bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))))),(Object)(BA.numberCast(float.class, main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))))),(Object)(main.mostCurrent.__c.getField(true,"True"))).getObject())));
 BA.debugLineNum = 404;BA.debugLine="iv.Bitmap = bdw.Bitmap";
Debug.ShouldStop(524288);
_iv.runMethod(false,"setBitmap",_bdw.runMethod(false,"getBitmap"));
 BA.debugLineNum = 424;BA.debugLine="scvDock.Panel.AddView(iv, iv.Width*i + i*10dip,";
Debug.ShouldStop(128);
main.mostCurrent._scvdock.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_iv.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_iv.runMethod(true,"getWidth"),RemoteObject.createImmutable(_i),RemoteObject.createImmutable(_i),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "*+*",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))),(Object)(_iv.runMethod(true,"getWidth")),(Object)(_iv.runMethod(true,"getHeight")));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 427;BA.debugLine="scvDock.Panel.Width = scvDock.Panel.NumberOfView";
Debug.ShouldStop(1024);
main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"getNumberOfViews"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 48))),main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"getNumberOfViews"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "*+*",1, 1));
 }else {
 BA.debugLineNum = 430;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(8192);
main.mostCurrent._lbl.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 431;BA.debugLine="lbl.Text = \"Add some apps here (long click on ap";
Debug.ShouldStop(16384);
main.mostCurrent._lbl.runMethod(true,"setText",BA.ObjectToCharSequence("Add some apps here (long click on app icon in search window -> 'Add to favorites' or tap '+' in list of all applications)"));
 BA.debugLineNum = 432;BA.debugLine="lbl.TextColor = Colors.yellow'Red";
Debug.ShouldStop(32768);
main.mostCurrent._lbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow"));
 BA.debugLineNum = 433;BA.debugLine="lbl.TextSize = 12.0";
Debug.ShouldStop(65536);
main.mostCurrent._lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 12.0));
 BA.debugLineNum = 434;BA.debugLine="scvDock.Panel.AddView(lbl, 0, 0, scvDock.Width,";
Debug.ShouldStop(131072);
main.mostCurrent._scvdock.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((main.mostCurrent._lbl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent._scvdock.runMethod(true,"getWidth")),(Object)(main.mostCurrent._scvdock.runMethod(true,"getHeight")));
 BA.debugLineNum = 435;BA.debugLine="scvDock.Panel.Width = 100%x";
Debug.ShouldStop(262144);
main.mostCurrent._scvdock.runMethod(false,"getPanel").runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),main.mostCurrent.activityBA));
 };
 BA.debugLineNum = 439;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _smartwidgets_backpressed(RemoteObject _widgetid) throws Exception{
try {
		Debug.PushSubsStack("SmartWidgets_BackPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2182);
if (RapidSub.canDelegate("smartwidgets_backpressed")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","smartwidgets_backpressed", _widgetid);
Debug.locals.put("WidgetId", _widgetid);
 BA.debugLineNum = 2182;BA.debugLine="Sub SmartWidgets_BackPressed (WidgetId As Int)";
Debug.ShouldStop(32);
 BA.debugLineNum = 2183;BA.debugLine="Log(\"Back pressed\")";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Back pressed")));
 BA.debugLineNum = 2184;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _smartwidgets_widgetcreated(RemoteObject _hostid,RemoteObject _hostview,RemoteObject _widgetid,RemoteObject _widgetinfo) throws Exception{
try {
		Debug.PushSubsStack("SmartWidgets_WidgetCreated (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2067);
if (RapidSub.canDelegate("smartwidgets_widgetcreated")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","smartwidgets_widgetcreated", _hostid, _hostview, _widgetid, _widgetinfo);
RemoteObject _widget_panel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _info = RemoteObject.declareNull("com.rootsoft.rssmartwidgets.RSAppWidgetProviderInfo");
RemoteObject _hw = RemoteObject.declareNull("com.rootsoft.rssmartwidgets.RSAppWidgetHostView");
Debug.locals.put("HostId", _hostid);
Debug.locals.put("HostView", _hostview);
Debug.locals.put("WidgetId", _widgetid);
Debug.locals.put("widgetinfo", _widgetinfo);
 BA.debugLineNum = 2067;BA.debugLine="Sub SmartWidgets_WidgetCreated (HostId As Int, Hos";
Debug.ShouldStop(262144);
 BA.debugLineNum = 2068;BA.debugLine="Dim widget_panel As Panel";
Debug.ShouldStop(524288);
_widget_panel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("widget_panel", _widget_panel);
 BA.debugLineNum = 2070;BA.debugLine="Dim Info As RSWidgetProviderInfo = widgetinfo";
Debug.ShouldStop(2097152);
_info = RemoteObject.createNew ("com.rootsoft.rssmartwidgets.RSAppWidgetProviderInfo");
_info.setObject(_widgetinfo);Debug.locals.put("Info", _info);
 BA.debugLineNum = 2071;BA.debugLine="Dim hw As RSWidgetHostView = HostView";
Debug.ShouldStop(4194304);
_hw = RemoteObject.createNew ("com.rootsoft.rssmartwidgets.RSAppWidgetHostView");
_hw.setObject(_hostview);Debug.locals.put("hw", _hw);
 BA.debugLineNum = 2079;BA.debugLine="Log(hw)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_hw)));
 BA.debugLineNum = 2080;BA.debugLine="Log(HostId)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_hostid)));
 BA.debugLineNum = 2081;BA.debugLine="Log(WidgetId)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_widgetid)));
 BA.debugLineNum = 2082;BA.debugLine="widget_panel.Initialize(\"\")";
Debug.ShouldStop(2);
_widget_panel.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 2083;BA.debugLine="widget_panel = hw'HostView' SmartWidgets.HostView";
Debug.ShouldStop(4);
_widget_panel.setObject(_hw.getObject());
 BA.debugLineNum = 2084;BA.debugLine="Log(hw)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_hw)));
 BA.debugLineNum = 2085;BA.debugLine="Log(HostId)";
Debug.ShouldStop(16);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_hostid)));
 BA.debugLineNum = 2086;BA.debugLine="Log(WidgetId)";
Debug.ShouldStop(32);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(_widgetid)));
 BA.debugLineNum = 2087;BA.debugLine="If DipToCurrent(Info.MinWidth) > GetDeviceLayoutV";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(">",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(_info.runMethod(true,"getMinWidth"))),BA.numberCast(double.class, main.mostCurrent.__c.runMethod(false,"GetDeviceLayoutValues",main.mostCurrent.activityBA).getField(true,"Width")))) { 
 BA.debugLineNum = 2088;BA.debugLine="widget_panel.Width = Info.MinWidth";
Debug.ShouldStop(128);
_widget_panel.runMethod(true,"setWidth",_info.runMethod(true,"getMinWidth"));
 }else {
 BA.debugLineNum = 2090;BA.debugLine="widget_panel.Width = DipToCurrent(Info.MinWidth)";
Debug.ShouldStop(512);
_widget_panel.runMethod(true,"setWidth",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(_info.runMethod(true,"getMinWidth"))));
 };
 BA.debugLineNum = 2093;BA.debugLine="If DipToCurrent(Info.MinHeight) > GetDeviceLayout";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(_info.runMethod(true,"getMinHeight"))),BA.numberCast(double.class, main.mostCurrent.__c.runMethod(false,"GetDeviceLayoutValues",main.mostCurrent.activityBA).getField(true,"Height")))) { 
 BA.debugLineNum = 2094;BA.debugLine="widget_panel.Height = Info.MinHeight";
Debug.ShouldStop(8192);
_widget_panel.runMethod(true,"setHeight",_info.runMethod(true,"getMinHeight"));
 }else {
 BA.debugLineNum = 2096;BA.debugLine="widget_panel.Height = DipToCurrent(Info.MinHeigh";
Debug.ShouldStop(32768);
_widget_panel.runMethod(true,"setHeight",main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(_info.runMethod(true,"getMinHeight"))));
 };
 BA.debugLineNum = 2099;BA.debugLine="ipsilon = widget_panel.Height";
Debug.ShouldStop(262144);
main._ipsilon = _widget_panel.runMethod(true,"getHeight");
 BA.debugLineNum = 2100;BA.debugLine="SmartWidgets.AddView(Panel1, widget_panel, 0, top";
Debug.ShouldStop(524288);
main._smartwidgets.runVoidMethod ("AddView",(Object)(main.mostCurrent._panel1),(Object)((_widget_panel.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(main._topw));
 BA.debugLineNum = 2101;BA.debugLine="topW = topW + ipsilon";
Debug.ShouldStop(1048576);
main._topw = RemoteObject.solve(new RemoteObject[] {main._topw,main._ipsilon}, "+",1, 1);
 BA.debugLineNum = 2111;BA.debugLine="Log(hw)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_hw)));
 BA.debugLineNum = 2112;BA.debugLine="SmartWidgets.StartListening";
Debug.ShouldStop(-2147483648);
main._smartwidgets.runVoidMethod ("StartListening");
 BA.debugLineNum = 2176;BA.debugLine="File.WriteString(File.DirInternal, \"thehost.txt\",";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("thehost.txt")),(Object)(BA.ObjectToString(_hostview)));
 BA.debugLineNum = 2177;BA.debugLine="File.writestring(File.DirInternal, \"theid.txt\", H";
Debug.ShouldStop(1);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("theid.txt")),(Object)(BA.NumberToString(_hostid)));
 BA.debugLineNum = 2178;BA.debugLine="File.WriteString(File.DirInternal, \"theappid.txt\"";
Debug.ShouldStop(2);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString("theappid.txt")),(Object)(BA.NumberToString(main._smartwidgets.runMethod(true,"getAppWidgetId"))));
 BA.debugLineNum = 2179;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tabstrip1_pageselected(RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("TabStrip1_PageSelected (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2022);
if (RapidSub.canDelegate("tabstrip1_pageselected")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","tabstrip1_pageselected", _position);
RemoteObject _i = RemoteObject.createImmutable(0);
Debug.locals.put("Position", _position);
 BA.debugLineNum = 2022;BA.debugLine="Sub TabStrip1_PageSelected (Position As Int)";
Debug.ShouldStop(32);
 BA.debugLineNum = 2023;BA.debugLine="Log($\"Current page: ${Position}\"$)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)((RemoteObject.concat(RemoteObject.createImmutable("Current page: "),main.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_position))),RemoteObject.createImmutable("")))));
 BA.debugLineNum = 2024;BA.debugLine="Dim i As Int";
Debug.ShouldStop(128);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 2025;BA.debugLine="For Each lbl As Label In GetAllTabLabels(TabStrip";
Debug.ShouldStop(256);
main.mostCurrent._lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
{
final RemoteObject group3 = _getalltablabels(main.mostCurrent._tabstrip1);
final int groupLen3 = group3.runMethod(true,"getSize").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
main.mostCurrent._lbl.setObject(group3.runMethod(false,"Get",index3));
 BA.debugLineNum = 2026;BA.debugLine="If i = Position Then lbl.TextColor = Colors.Blue";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_i,BA.numberCast(double.class, _position))) { 
main.mostCurrent._lbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Blue"));}
else {
main.mostCurrent._lbl.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));};
 BA.debugLineNum = 2027;BA.debugLine="i = i + 1";
Debug.ShouldStop(1024);
_i = RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("i", _i);
 }
};
 BA.debugLineNum = 2029;BA.debugLine="If TabStrip1.CurrentPage = 1 And pnlKontakti.Numb";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",main.mostCurrent._tabstrip1.runMethod(true,"getCurrentPage"),BA.numberCast(double.class, 1)) && RemoteObject.solveBoolean("=",main.mostCurrent._pnlkontakti.runMethod(true,"getNumberOfViews"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 2030;BA.debugLine="UbaciKontakte2";
Debug.ShouldStop(8192);
_ubacikontakte2();
 };
 BA.debugLineNum = 2032;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tajmer_tick() throws Exception{
try {
		Debug.PushSubsStack("tajmer_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2482);
if (RapidSub.canDelegate("tajmer_tick")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","tajmer_tick");
 BA.debugLineNum = 2482;BA.debugLine="Sub tajmer_Tick";
Debug.ShouldStop(131072);
 BA.debugLineNum = 2483;BA.debugLine="NotificationService.brojNotifikacija = 0";
Debug.ShouldStop(262144);
main.mostCurrent._notificationservice._brojnotifikacija = BA.numberCast(int.class, 0);
 BA.debugLineNum = 2484;BA.debugLine="CallSubDelayed(NotificationService, \"GetActive\")";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.processBA,(Object)((main.mostCurrent._notificationservice.getObject())),(Object)(RemoteObject.createImmutable("GetActive")));
 BA.debugLineNum = 2485;BA.debugLine="Log(NotificationService.brojNotifikacija)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.NumberToString(main.mostCurrent._notificationservice._brojnotifikacija)));
 BA.debugLineNum = 2486;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ubacikontakte2() throws Exception{
try {
		Debug.PushSubsStack("UbaciKontakte2 (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,2529);
if (RapidSub.canDelegate("ubacikontakte2")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","ubacikontakte2");
RemoteObject _allcontacts = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ukupno = RemoteObject.createImmutable(0);
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _l1k = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _l2k = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _c = RemoteObject.declareNull("com.no3dlauncher.contactsutils._cucontact");
int _j = 0;
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
 BA.debugLineNum = 2529;BA.debugLine="Sub UbaciKontakte2";
Debug.ShouldStop(1);
 BA.debugLineNum = 2530;BA.debugLine="Dim allContacts As List = cu.FindAllContacts(True";
Debug.ShouldStop(2);
_allcontacts = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_allcontacts = main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_findallcontacts",(Object)(main.mostCurrent.__c.getField(true,"True")));Debug.locals.put("allContacts", _allcontacts);Debug.locals.put("allContacts", _allcontacts);
 BA.debugLineNum = 2535;BA.debugLine="If File.Exists (File.DirInternal, \"nema_slike.png";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("nema_slike.png"))),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 2536;BA.debugLine="File.Copy(File.DirAssets, \"nema_slike.png\", File";
Debug.ShouldStop(128);
main.mostCurrent.__c.getField(false,"File").runVoidMethod ("Copy",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(BA.ObjectToString("nema_slike.png")),(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("nema_slike.png")));
 };
 BA.debugLineNum = 2539;BA.debugLine="grid.Initialize(pnlKontakti, Me, \"kontaktiGrid\",";
Debug.ShouldStop(1024);
main.mostCurrent._grid.runVoidMethod ("_initialize",main.mostCurrent.activityBA,(Object)(main.mostCurrent._pnlkontakti),(Object)(main.getObject()),(Object)(BA.ObjectToString("kontaktiGrid")),(Object)(BA.numberCast(int.class, 4)),(Object)(RemoteObject.createImmutable("S")));
 BA.debugLineNum = 2541;BA.debugLine="grid.PrepareGridView";
Debug.ShouldStop(4096);
main.mostCurrent._grid.runVoidMethod ("_preparegridview");
 BA.debugLineNum = 2561;BA.debugLine="Dim ukupno, i As Int = 0";
Debug.ShouldStop(1);
_ukupno = RemoteObject.createImmutable(0);Debug.locals.put("ukupno", _ukupno);
_i = BA.numberCast(int.class, 0);Debug.locals.put("i", _i);Debug.locals.put("i", _i);
 BA.debugLineNum = 2563;BA.debugLine="ProgressDialogShow(\"Building contacts...\")";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ProgressDialogShow",main.mostCurrent.activityBA,(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Building contacts..."))));
 BA.debugLineNum = 2564;BA.debugLine="Dim l1k, l2k As List";
Debug.ShouldStop(8);
_l1k = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l1k", _l1k);
_l2k = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l2k", _l2k);
 BA.debugLineNum = 2565;BA.debugLine="l1k.Initialize	' diaply name";
Debug.ShouldStop(16);
_l1k.runVoidMethod ("Initialize");
 BA.debugLineNum = 2566;BA.debugLine="l2k.Initialize	' id";
Debug.ShouldStop(32);
_l2k.runVoidMethod ("Initialize");
 BA.debugLineNum = 2567;BA.debugLine="For Each c As cuContact In allContacts'cu.FindAll";
Debug.ShouldStop(64);
{
final RemoteObject group12 = _allcontacts;
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_c = (group12.runMethod(false,"Get",index12));Debug.locals.put("c", _c);
Debug.locals.put("c", _c);
 BA.debugLineNum = 2568;BA.debugLine="l1k.Add(c.DisplayName)";
Debug.ShouldStop(128);
_l1k.runVoidMethod ("Add",(Object)((_c.getField(true,"DisplayName"))));
 BA.debugLineNum = 2569;BA.debugLine="l2k.Add(c.Id)";
Debug.ShouldStop(256);
_l2k.runVoidMethod ("Add",(Object)((_c.getField(true,"Id"))));
 }
}Debug.locals.put("c", _c);
;
 BA.debugLineNum = 2572;BA.debugLine="Log(l1k)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_l1k)));
 BA.debugLineNum = 2573;BA.debugLine="Log(l2k)";
Debug.ShouldStop(4096);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_l2k)));
 BA.debugLineNum = 2574;BA.debugLine="For i = 0 To allContacts.Size - 1";
Debug.ShouldStop(8192);
{
final int step18 = 1;
final int limit18 = RemoteObject.solve(new RemoteObject[] {_allcontacts.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step18 > 0 && _i.<Integer>get().intValue() <= limit18) || (step18 < 0 && _i.<Integer>get().intValue() >= limit18) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step18))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 2575;BA.debugLine="For j = 0 To 4";
Debug.ShouldStop(16384);
{
final int step19 = 1;
final int limit19 = 4;
_j = 0 ;
for (;(step19 > 0 && _j <= limit19) || (step19 < 0 && _j >= limit19) ;_j = ((int)(0 + _j + step19))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 2576;BA.debugLine="If ukupno < allContacts.Size Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("<",_ukupno,BA.numberCast(double.class, _allcontacts.runMethod(true,"getSize")))) { 
 BA.debugLineNum = 2578;BA.debugLine="Dim bmp As Bitmap = cu.GetPhoto(l2k.Get(i*5+j)";
Debug.ShouldStop(131072);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp = main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getphoto",(Object)(BA.numberCast(long.class, _l2k.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))))));Debug.locals.put("bmp", _bmp);Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 2579;BA.debugLine="If bmp.IsInitialized = False Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_bmp.runMethod(true,"IsInitialized"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 2580;BA.debugLine="grid.AddToGridView(File.Combine(File.DirInter";
Debug.ShouldStop(524288);
main.mostCurrent._grid.runVoidMethod ("_addtogridview",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(RemoteObject.createImmutable("nema_slike.png")))),(Object)(BA.ObjectToString(_l1k.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))))),(Object)(BA.ObjectToString(_l2k.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))))));
 }else {
 BA.debugLineNum = 2582;BA.debugLine="Dim bmp As Bitmap = cu.GetPhoto(l2k.Get(i*5+j";
Debug.ShouldStop(2097152);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp = main._cu.runClassMethod (com.no3dlauncher.contactsutils.class, "_getphoto",(Object)(BA.numberCast(long.class, _l2k.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))))));Debug.locals.put("bmp", _bmp);Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 2583;BA.debugLine="Dim Out As OutputStream";
Debug.ShouldStop(4194304);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("Out", _out);
 BA.debugLineNum = 2584;BA.debugLine="Out = File.OpenOutput(File.DirInternal, l1k.G";
Debug.ShouldStop(8388608);
_out = main.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString(_l1k.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))))),(Object)(main.mostCurrent.__c.getField(true,"False")));Debug.locals.put("Out", _out);
 BA.debugLineNum = 2585;BA.debugLine="bmp.WriteToStream(Out, 100, \"PNG\")";
Debug.ShouldStop(16777216);
_bmp.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("PNG"))));
 BA.debugLineNum = 2586;BA.debugLine="Out.Close";
Debug.ShouldStop(33554432);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 2587;BA.debugLine="grid.AddToGridView(File.Combine(File.DirInter";
Debug.ShouldStop(67108864);
main.mostCurrent._grid.runVoidMethod ("_addtogridview",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"Combine",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(BA.ObjectToString(_l1k.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))))))),(Object)(BA.ObjectToString(_l1k.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))))),(Object)(BA.ObjectToString(_l2k.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_i,RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))))));
 };
 BA.debugLineNum = 2615;BA.debugLine="ukupno = ukupno + 1";
Debug.ShouldStop(4194304);
_ukupno = RemoteObject.solve(new RemoteObject[] {_ukupno,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ukupno", _ukupno);
 }else {
 BA.debugLineNum = 2618;BA.debugLine="Exit";
Debug.ShouldStop(33554432);
if (true) break;
 };
 }
}Debug.locals.put("j", _j);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 2623;BA.debugLine="grid.TitleBoxVisible = True";
Debug.ShouldStop(1073741824);
main.mostCurrent._grid.runVoidMethod ("_settitleboxvisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 2626;BA.debugLine="grid.ShowGridView";
Debug.ShouldStop(2);
main.mostCurrent._grid.runVoidMethod ("_showgridview");
 BA.debugLineNum = 2629;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _uninstallapp(RemoteObject _pkg) throws Exception{
try {
		Debug.PushSubsStack("UninstallApp (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,757);
if (RapidSub.canDelegate("uninstallapp")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","uninstallapp", _pkg);
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
Debug.locals.put("pkg", _pkg);
 BA.debugLineNum = 757;BA.debugLine="Sub UninstallApp(pkg As String)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 758;BA.debugLine="If IsPaused(provjera) = True Then StartService(pr";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main.mostCurrent.__c.runMethod(true,"IsPaused",main.processBA,(Object)((main.mostCurrent._provjera.getObject()))),main.mostCurrent.__c.getField(true,"True"))) { 
main.mostCurrent.__c.runVoidMethod ("StartService",main.processBA,(Object)((main.mostCurrent._provjera.getObject())));};
 BA.debugLineNum = 760;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(8388608);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 762;BA.debugLine="Log(\"package:\" & pkg)";
Debug.ShouldStop(33554432);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("package:"),_pkg)));
 BA.debugLineNum = 763;BA.debugLine="i.Initialize(\"android.intent.action.DELETE\", \"pac";
Debug.ShouldStop(67108864);
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.intent.action.DELETE")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("package:"),_pkg)));
 BA.debugLineNum = 765;BA.debugLine="StartActivity(i)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_i.getObject())));
 BA.debugLineNum = 772;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _viewsbringtofront() throws Exception{
try {
		Debug.PushSubsStack("ViewsBringToFront (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,1353);
if (RapidSub.canDelegate("viewsbringtofront")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","viewsbringtofront");
 BA.debugLineNum = 1353;BA.debugLine="Sub ViewsBringToFront";
Debug.ShouldStop(256);
 BA.debugLineNum = 1354;BA.debugLine="btnSearch.BringToFront";
Debug.ShouldStop(512);
main.mostCurrent._btnsearch.runVoidMethod ("BringToFront");
 BA.debugLineNum = 1355;BA.debugLine="btnNotify.BringToFront";
Debug.ShouldStop(1024);
main.mostCurrent._btnnotify.runVoidMethod ("BringToFront");
 BA.debugLineNum = 1356;BA.debugLine="btnPostavke.BringToFront";
Debug.ShouldStop(2048);
main.mostCurrent._btnpostavke.runVoidMethod ("BringToFront");
 BA.debugLineNum = 1357;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wp1_index_changed(RemoteObject _currentindex) throws Exception{
try {
		Debug.PushSubsStack("wp1_index_changed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,599);
if (RapidSub.canDelegate("wp1_index_changed")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","wp1_index_changed", _currentindex);
Debug.locals.put("currentindex", _currentindex);
 BA.debugLineNum = 599;BA.debugLine="Sub wp1_index_changed (currentindex As Int)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 605;BA.debugLine="If zadnja_oznacena_app <> currentindex Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("!",main._zadnja_oznacena_app,BA.numberCast(double.class, _currentindex))) { 
 BA.debugLineNum = 607;BA.debugLine="zadnja_oznacena_app = currentindex";
Debug.ShouldStop(1073741824);
main._zadnja_oznacena_app = _currentindex;
 };
 BA.debugLineNum = 609;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wp1_index_clicked(RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("wp1_index_clicked (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,611);
if (RapidSub.canDelegate("wp1_index_clicked")) return com.no3dlauncher.main.remoteMe.runUserSub(false, "main","wp1_index_clicked", _position);
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
Debug.locals.put("position", _position);
 BA.debugLineNum = 611;BA.debugLine="Sub wp1_index_clicked(position As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 612;BA.debugLine="Dim in As Intent";
Debug.ShouldStop(8);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("in", _in);
 BA.debugLineNum = 613;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(16);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 615;BA.debugLine="in = pm.GetApplicationIntent(l1.Get(zadnja_oznace";
Debug.ShouldStop(64);
_in = _pm.runMethod(false,"GetApplicationIntent",(Object)(BA.ObjectToString(main.mostCurrent._l1.runMethod(false,"Get",(Object)(main._zadnja_oznacena_app)))));Debug.locals.put("in", _in);
 BA.debugLineNum = 616;BA.debugLine="If in.IsInitialized Then";
Debug.ShouldStop(128);
if (_in.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 617;BA.debugLine="Log(f.animStr)";
Debug.ShouldStop(256);
main.mostCurrent.__c.runVoidMethod ("Log",(Object)(main.mostCurrent._f._animstr));
 BA.debugLineNum = 620;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((_in.getObject())));
 };
 BA.debugLineNum = 622;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}