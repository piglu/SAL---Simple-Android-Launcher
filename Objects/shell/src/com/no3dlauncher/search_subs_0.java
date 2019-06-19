package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class search_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="Activity.LoadLayout(\"trazi\")";
Debug.ShouldStop(33554432);
search.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("trazi")),search.mostCurrent.activityBA);
 BA.debugLineNum = 28;BA.debugLine="sv.Initialize(500dip)";
Debug.ShouldStop(134217728);
search.mostCurrent._sv.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 500)))));
 BA.debugLineNum = 29;BA.debugLine="Activity.AddView(sv, 0, 46dip, 100%x, 100%y - 46d";
Debug.ShouldStop(268435456);
search.mostCurrent._activity.runVoidMethod ("AddView",(Object)((search.mostCurrent._sv.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 46)))),(Object)(search.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA)),(Object)(RemoteObject.solve(new RemoteObject[] {search.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 46)))}, "-",1, 1)));
 BA.debugLineNum = 31;BA.debugLine="DodajSlova";
Debug.ShouldStop(1073741824);
_dodajslova();
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_keypress(RemoteObject _keycode) throws Exception{
try {
		Debug.PushSubsStack("Activity_KeyPress (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,287);
if (RapidSub.canDelegate("activity_keypress")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","activity_keypress", _keycode);}
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 287;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 288;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And pnlAppPodS";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, search.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK"))) && RemoteObject.solveBoolean(".",search.mostCurrent._pnlapppodslovom.runMethod(true,"IsInitialized"))) { 
 BA.debugLineNum = 289;BA.debugLine="If pnlAppPodSlovom.Visible = True Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",search.mostCurrent._pnlapppodslovom.runMethod(true,"getVisible"),search.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 291;BA.debugLine="lbl1.RemoveView";
Debug.ShouldStop(4);
search.mostCurrent._lbl1.runVoidMethod ("RemoveView");
 BA.debugLineNum = 292;BA.debugLine="pnlAppPodSlovom.Visible = False";
Debug.ShouldStop(8);
search.mostCurrent._pnlapppodslovom.runMethod(true,"setVisible",search.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 294;BA.debugLine="DodajSlova";
Debug.ShouldStop(32);
_dodajslova();
 BA.debugLineNum = 295;BA.debugLine="Return True";
Debug.ShouldStop(64);
if (true) return search.mostCurrent.__c.getField(true,"True");
 };
 };
 BA.debugLineNum = 299;BA.debugLine="Return False";
Debug.ShouldStop(1024);
if (true) return search.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 300;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,38);
if (RapidSub.canDelegate("activity_pause")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 38;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(32);
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("Activity_Resume (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,34);
if (RapidSub.canDelegate("activity_resume")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","activity_resume");}
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtofavorites() throws Exception{
try {
		Debug.PushSubsStack("AddToFavorites (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,267);
if (RapidSub.canDelegate("addtofavorites")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","addtofavorites");}
 BA.debugLineNum = 267;BA.debugLine="Sub AddToFavorites";
Debug.ShouldStop(1024);
 BA.debugLineNum = 268;BA.debugLine="CallSub(Main, \"DodajAppUFavorite\")";
Debug.ShouldStop(2048);
search.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",search.processBA,(Object)((search.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("DodajAppUFavorite")));
 BA.debugLineNum = 269;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bitmaptobitmapdrawable(RemoteObject _bmd) throws Exception{
try {
		Debug.PushSubsStack("BitmapToBitmapDrawable (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,202);
if (RapidSub.canDelegate("bitmaptobitmapdrawable")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","bitmaptobitmapdrawable", _bmd);}
RemoteObject _bd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
Debug.locals.put("BMD", _bmd);
 BA.debugLineNum = 202;BA.debugLine="Sub BitmapToBitmapDrawable(BMD As Bitmap) As Bitma";
Debug.ShouldStop(512);
 BA.debugLineNum = 203;BA.debugLine="Dim BD As BitmapDrawable";
Debug.ShouldStop(1024);
_bd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");Debug.locals.put("BD", _bd);
 BA.debugLineNum = 204;BA.debugLine="BD.Initialize(BMD)";
Debug.ShouldStop(2048);
_bd.runVoidMethod ("Initialize",(Object)((_bmd.getObject())));
 BA.debugLineNum = 206;BA.debugLine="Return BD";
Debug.ShouldStop(8192);
if (true) return _bd;
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnslovo_click() throws Exception{
try {
		Debug.PushSubsStack("btnSlovo_Click (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,90);
if (RapidSub.canDelegate("btnslovo_click")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","btnslovo_click");}
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _pkg1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _pkg2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _ukupno1 = RemoteObject.createImmutable(0);
RemoteObject _ukupno2 = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _pckg = RemoteObject.createImmutable("");
RemoteObject _x = RemoteObject.createImmutable(0);
int _j = 0;
RemoteObject _drawable = RemoteObject.declareNull("Object");
RemoteObject _bdw = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _btm = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _destrect = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");
RemoteObject _can = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper");
 BA.debugLineNum = 90;BA.debugLine="Sub btnSlovo_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="Dim b As Button";
Debug.ShouldStop(67108864);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 92;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(134217728);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 93;BA.debugLine="Dim pkg1, pkg2 As List";
Debug.ShouldStop(268435456);
_pkg1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("pkg1", _pkg1);
_pkg2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("pkg2", _pkg2);
 BA.debugLineNum = 95;BA.debugLine="b = Sender";
Debug.ShouldStop(1073741824);
_b.setObject(search.mostCurrent.__c.runMethod(false,"Sender",search.mostCurrent.activityBA));
 BA.debugLineNum = 96;BA.debugLine="pnlSlova.RemoveView";
Debug.ShouldStop(-2147483648);
search.mostCurrent._pnlslova.runVoidMethod ("RemoveView");
 BA.debugLineNum = 101;BA.debugLine="pnlAppPodSlovom.Initialize(\"\")";
Debug.ShouldStop(16);
search.mostCurrent._pnlapppodslovom.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 102;BA.debugLine="sv.Panel.AddView(pnlAppPodSlovom, 0, 0, 100%x, 10";
Debug.ShouldStop(32);
search.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((search.mostCurrent._pnlapppodslovom.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(search.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA)),(Object)(search.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA)));
 BA.debugLineNum = 103;BA.debugLine="lbl1.Initialize(\"\")";
Debug.ShouldStop(64);
search.mostCurrent._lbl1.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 104;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(128);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 105;BA.debugLine="cd.Initialize(Colors.Yellow, 50)";
Debug.ShouldStop(256);
_cd.runVoidMethod ("Initialize",(Object)(search.mostCurrent.__c.getField(false,"Colors").getField(true,"Yellow")),(Object)(BA.numberCast(int.class, 50)));
 BA.debugLineNum = 106;BA.debugLine="lbl1.Background = cd";
Debug.ShouldStop(512);
search.mostCurrent._lbl1.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 107;BA.debugLine="lbl1.Typeface = Typeface.DEFAULT_BOLD";
Debug.ShouldStop(1024);
search.mostCurrent._lbl1.runMethod(false,"setTypeface",search.mostCurrent.__c.getField(false,"Typeface").getField(false,"DEFAULT_BOLD"));
 BA.debugLineNum = 108;BA.debugLine="lbl1.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL,";
Debug.ShouldStop(2048);
search.mostCurrent._lbl1.runMethod(true,"setGravity",search.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL")),(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"))));
 BA.debugLineNum = 110;BA.debugLine="sv.Panel.AddView(lbl1, 100%x - 32dip, 100%y - 80d";
Debug.ShouldStop(8192);
search.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((search.mostCurrent._lbl1.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {search.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32)))}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {search.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 80)))}, "-",1, 1)),(Object)(search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32)))),(Object)(search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 32)))));
 BA.debugLineNum = 112;BA.debugLine="Dim ukupno1, ukupno2 As Int = 0";
Debug.ShouldStop(32768);
_ukupno1 = RemoteObject.createImmutable(0);Debug.locals.put("ukupno1", _ukupno1);
_ukupno2 = BA.numberCast(int.class, 0);Debug.locals.put("ukupno2", _ukupno2);Debug.locals.put("ukupno2", _ukupno2);
 BA.debugLineNum = 113;BA.debugLine="pkg1.Initialize";
Debug.ShouldStop(65536);
_pkg1.runVoidMethod ("Initialize");
 BA.debugLineNum = 114;BA.debugLine="pkg2.Initialize";
Debug.ShouldStop(131072);
_pkg2.runVoidMethod ("Initialize");
 BA.debugLineNum = 116;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
Debug.ShouldStop(524288);
{
final int step18 = 1;
final int limit18 = RemoteObject.solve(new RemoteObject[] {search.mostCurrent._starter._mapa.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step18 > 0 && _i <= limit18) || (step18 < 0 && _i >= limit18) ;_i = ((int)(0 + _i + step18))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 117;BA.debugLine="Dim s As String = Starter.mapa.GetKeyAt(i)";
Debug.ShouldStop(1048576);
_s = BA.ObjectToString(search.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 118;BA.debugLine="If s.StartsWith(b.Tag) Then";
Debug.ShouldStop(2097152);
if (_s.runMethod(true,"startsWith",(Object)(BA.ObjectToString(_b.runMethod(false,"getTag")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 119;BA.debugLine="ukupno1 = ukupno1 + 1";
Debug.ShouldStop(4194304);
_ukupno1 = RemoteObject.solve(new RemoteObject[] {_ukupno1,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ukupno1", _ukupno1);
 BA.debugLineNum = 120;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
Debug.ShouldStop(8388608);
_pckg = BA.ObjectToString(search.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("pckg", _pckg);Debug.locals.put("pckg", _pckg);
 BA.debugLineNum = 122;BA.debugLine="pkg1.Add(pckg.SubString2(pckg.IndexOf(\";\")+1, p";
Debug.ShouldStop(33554432);
_pkg1.runVoidMethod ("Add",(Object)((_pckg.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";"))),RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(_pckg.runMethod(true,"length"))))));
 BA.debugLineNum = 124;BA.debugLine="pkg2.Add(pckg.SubString2(0, pckg.IndexOf(\";\")))";
Debug.ShouldStop(134217728);
_pkg2.runVoidMethod ("Add",(Object)((_pckg.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";"))))))));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 128;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(-2147483648);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 129;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
Debug.ShouldStop(1);
_cd.runVoidMethod ("Initialize",(Object)(search.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)))),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 130;BA.debugLine="Dim x As Int";
Debug.ShouldStop(2);
_x = RemoteObject.createImmutable(0);Debug.locals.put("x", _x);
 BA.debugLineNum = 131;BA.debugLine="x = Activity.Width / 5'pkg1.Size";
Debug.ShouldStop(4);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {search.mostCurrent._activity.runMethod(true,"getWidth"),RemoteObject.createImmutable(5)}, "/",0, 0));Debug.locals.put("x", _x);
 BA.debugLineNum = 132;BA.debugLine="x = x - 2dip";
Debug.ShouldStop(8);
_x = RemoteObject.solve(new RemoteObject[] {_x,search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1);Debug.locals.put("x", _x);
 BA.debugLineNum = 136;BA.debugLine="Log(pnlAppPodSlovom.Height)";
Debug.ShouldStop(128);
search.mostCurrent.__c.runVoidMethod ("LogImpl","72555950",BA.NumberToString(search.mostCurrent._pnlapppodslovom.runMethod(true,"getHeight")),0);
 BA.debugLineNum = 137;BA.debugLine="For i = 0 To pkg1.Size - 1";
Debug.ShouldStop(256);
{
final int step33 = 1;
final int limit33 = RemoteObject.solve(new RemoteObject[] {_pkg1.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step33 > 0 && _i <= limit33) || (step33 < 0 && _i >= limit33) ;_i = ((int)(0 + _i + step33))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 138;BA.debugLine="For j = 0 To 4";
Debug.ShouldStop(512);
{
final int step34 = 1;
final int limit34 = 4;
_j = 0 ;
for (;(step34 > 0 && _j <= limit34) || (step34 < 0 && _j >= limit34) ;_j = ((int)(0 + _j + step34))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 139;BA.debugLine="If ukupno2 < ukupno1 Then'pkg1.Size - 1 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("<",_ukupno2,BA.numberCast(double.class, _ukupno1))) { 
 BA.debugLineNum = 140;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon";
Debug.ShouldStop(2048);
_drawable = (_pm.runMethod(false,"GetApplicationIcon",(Object)(BA.ObjectToString(_pkg1.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1)))))));Debug.locals.put("drawable", _drawable);Debug.locals.put("drawable", _drawable);
 BA.debugLineNum = 141;BA.debugLine="If drawable Is BitmapDrawable Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("i",_drawable, RemoteObject.createImmutable("android.graphics.drawable.BitmapDrawable"))) { 
 BA.debugLineNum = 142;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
Debug.ShouldStop(8192);
_bdw = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
_bdw.setObject(_drawable);Debug.locals.put("bdw", _bdw);
 BA.debugLineNum = 143;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
Debug.ShouldStop(16384);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp.setObject(_bdw.runMethod(false,"getBitmap"));Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 144;BA.debugLine="bdw.Initialize(bmp.Resize(64dip, 64dip, True)";
Debug.ShouldStop(32768);
_bdw.runVoidMethod ("Initialize",(Object)((_bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 64))))),(Object)(BA.numberCast(float.class, search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 64))))),(Object)(search.mostCurrent.__c.getField(true,"True"))).getObject())));
 BA.debugLineNum = 145;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(65536);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 146;BA.debugLine="iv.Initialize(\"ivApp\")";
Debug.ShouldStop(131072);
_iv.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ivApp")));
 BA.debugLineNum = 147;BA.debugLine="iv.Bitmap = bdw.Bitmap";
Debug.ShouldStop(262144);
_iv.runMethod(false,"setBitmap",_bdw.runMethod(false,"getBitmap"));
 BA.debugLineNum = 148;BA.debugLine="iv.Tag = pkg1.Get(i*5+j)";
Debug.ShouldStop(524288);
_iv.runMethod(false,"setTag",_pkg1.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))));
 BA.debugLineNum = 150;BA.debugLine="pnlAppPodSlovom.AddView(iv, x*j + j*1dip, x*i";
Debug.ShouldStop(2097152);
search.mostCurrent._pnlapppodslovom.runVoidMethod ("AddView",(Object)((_iv.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j),RemoteObject.createImmutable(_j),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "*+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(_i),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "*++*",2, 1)),(Object)(_x),(Object)(_x));
 BA.debugLineNum = 151;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(4194304);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 152;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(8388608);
_lbl.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 153;BA.debugLine="lbl.Text = pkg2.Get(i*5+j)";
Debug.ShouldStop(16777216);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_pkg2.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1)))));
 BA.debugLineNum = 154;BA.debugLine="lbl.TextColor = Colors.White";
Debug.ShouldStop(33554432);
_lbl.runMethod(true,"setTextColor",search.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 155;BA.debugLine="lbl.Background = cd";
Debug.ShouldStop(67108864);
_lbl.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 156;BA.debugLine="lbl.TextSize = 10";
Debug.ShouldStop(134217728);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 157;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
Debug.ShouldStop(268435456);
_lbl.runMethod(false,"setTypeface",search.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(search.mostCurrent._f._wheellistfont,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 158;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
Debug.ShouldStop(536870912);
_lbl.runMethod(true,"setGravity",search.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL")),(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"))));
 BA.debugLineNum = 159;BA.debugLine="pnlAppPodSlovom.AddView(lbl, x*j, x*i + x + i";
Debug.ShouldStop(1073741824);
search.mostCurrent._pnlapppodslovom.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),_x,RemoteObject.createImmutable(_i),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))}, "*++*+",3, 1)),(Object)(_x),(Object)(search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 }else {
 BA.debugLineNum = 164;BA.debugLine="Dim btm As Bitmap";
Debug.ShouldStop(8);
_btm = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("btm", _btm);
 BA.debugLineNum = 165;BA.debugLine="btm.InitializeMutable(x, x)";
Debug.ShouldStop(16);
_btm.runVoidMethod ("InitializeMutable",(Object)(_x),(Object)(_x));
 BA.debugLineNum = 166;BA.debugLine="Dim DestRect As Rect";
Debug.ShouldStop(32);
_destrect = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper");Debug.locals.put("DestRect", _destrect);
 BA.debugLineNum = 167;BA.debugLine="DestRect.Initialize(0, 0, x, x)";
Debug.ShouldStop(64);
_destrect.runVoidMethod ("Initialize",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_x),(Object)(_x));
 BA.debugLineNum = 168;BA.debugLine="Dim can As Canvas";
Debug.ShouldStop(128);
_can = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");Debug.locals.put("can", _can);
 BA.debugLineNum = 169;BA.debugLine="can.Initialize2(btm)";
Debug.ShouldStop(256);
_can.runVoidMethod ("Initialize2",(Object)((_btm.getObject())));
 BA.debugLineNum = 170;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(512);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 171;BA.debugLine="can.DrawDrawable(pm.GetApplicationIcon(pkg1.G";
Debug.ShouldStop(1024);
_can.runVoidMethod ("DrawDrawable",(Object)(_pm.runMethod(false,"GetApplicationIcon",(Object)(BA.ObjectToString(_pkg1.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))))))),(Object)((_destrect.getObject())));
 BA.debugLineNum = 172;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(2048);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 173;BA.debugLine="iv.Initialize(\"ivApp\")";
Debug.ShouldStop(4096);
_iv.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ivApp")));
 BA.debugLineNum = 174;BA.debugLine="iv.Background = BitmapToBitmapDrawable(btm)";
Debug.ShouldStop(8192);
_iv.runMethod(false,"setBackground",(_bitmaptobitmapdrawable(_btm).getObject()));
 BA.debugLineNum = 177;BA.debugLine="iv.Tag = pkg1.Get(i*5+j)";
Debug.ShouldStop(65536);
_iv.runMethod(false,"setTag",_pkg1.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))));
 BA.debugLineNum = 179;BA.debugLine="pnlAppPodSlovom.AddView(iv, x*j + j*1dip, x*i";
Debug.ShouldStop(262144);
search.mostCurrent._pnlapppodslovom.runVoidMethod ("AddView",(Object)((_iv.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j),RemoteObject.createImmutable(_j),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "*+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(_i),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "*++*",2, 1)),(Object)(_x),(Object)(_x));
 BA.debugLineNum = 180;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(524288);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 181;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(1048576);
_lbl.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 182;BA.debugLine="lbl.Text = pkg2.Get(i*5+j)";
Debug.ShouldStop(2097152);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_pkg2.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1)))));
 BA.debugLineNum = 183;BA.debugLine="lbl.TextColor = Colors.White";
Debug.ShouldStop(4194304);
_lbl.runMethod(true,"setTextColor",search.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 184;BA.debugLine="lbl.Background = cd";
Debug.ShouldStop(8388608);
_lbl.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 185;BA.debugLine="lbl.TextSize = 10";
Debug.ShouldStop(16777216);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 10));
 BA.debugLineNum = 186;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
Debug.ShouldStop(33554432);
_lbl.runMethod(false,"setTypeface",search.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(search.mostCurrent._f._wheellistfont,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 187;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
Debug.ShouldStop(67108864);
_lbl.runMethod(true,"setGravity",search.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL")),(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"))));
 BA.debugLineNum = 188;BA.debugLine="pnlAppPodSlovom.AddView(lbl, x*j, x*i + x + i";
Debug.ShouldStop(134217728);
search.mostCurrent._pnlapppodslovom.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),_x,RemoteObject.createImmutable(_i),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))}, "*++*+",3, 1)),(Object)(_x),(Object)(search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 };
 BA.debugLineNum = 190;BA.debugLine="ukupno2 = ukupno2 + 1";
Debug.ShouldStop(536870912);
_ukupno2 = RemoteObject.solve(new RemoteObject[] {_ukupno2,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ukupno2", _ukupno2);
 }else {
 BA.debugLineNum = 192;BA.debugLine="Exit";
Debug.ShouldStop(-2147483648);
if (true) break;
 };
 }
}Debug.locals.put("j", _j);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 196;BA.debugLine="lbl1.Text = ukupno1";
Debug.ShouldStop(8);
search.mostCurrent._lbl1.runMethod(true,"setText",BA.ObjectToCharSequence(_ukupno1));
 BA.debugLineNum = 197;BA.debugLine="lbl1.TextColor = Colors.Black";
Debug.ShouldStop(16);
search.mostCurrent._lbl1.runMethod(true,"setTextColor",search.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 199;BA.debugLine="sv.Panel.Height = pnlAppPodSlovom.Height - 46dip";
Debug.ShouldStop(64);
search.mostCurrent._sv.runMethod(false,"getPanel").runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {search.mostCurrent._pnlapppodslovom.runMethod(true,"getHeight"),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 46)))}, "-",1, 1));
 BA.debugLineNum = 200;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btntrazi_click() throws Exception{
try {
		Debug.PushSubsStack("btnTrazi_Click (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,81);
if (RapidSub.canDelegate("btntrazi_click")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","btntrazi_click");}
 BA.debugLineNum = 81;BA.debugLine="Sub btnTrazi_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="Log(\"trazi\")";
Debug.ShouldStop(131072);
search.mostCurrent.__c.runVoidMethod ("LogImpl","72424833",RemoteObject.createImmutable("trazi"),0);
 BA.debugLineNum = 83;BA.debugLine="Trazi(traziString)";
Debug.ShouldStop(262144);
_trazi(search.mostCurrent._trazistring);
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _dodajslova() throws Exception{
try {
		Debug.PushSubsStack("DodajSlova (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,42);
if (RapidSub.canDelegate("dodajslova")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","dodajslova");}
RemoteObject _x = RemoteObject.createImmutable(0);
RemoteObject _y = RemoteObject.createImmutable(0);
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _ukupno = RemoteObject.createImmutable(0);
int _i = 0;
int _j = 0;
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 42;BA.debugLine="Sub DodajSlova";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="Dim x As Int = Activity.Width / 5	' 5 slova abece";
Debug.ShouldStop(1024);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {search.mostCurrent._activity.runMethod(true,"getWidth"),RemoteObject.createImmutable(5)}, "/",0, 0));Debug.locals.put("x", _x);Debug.locals.put("x", _x);
 BA.debugLineNum = 44;BA.debugLine="Dim y As Int = Activity.Width - x*5 + 8dip";
Debug.ShouldStop(2048);
_y = RemoteObject.solve(new RemoteObject[] {search.mostCurrent._activity.runMethod(true,"getWidth"),_x,RemoteObject.createImmutable(5),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))}, "-*+",2, 1);Debug.locals.put("y", _y);Debug.locals.put("y", _y);
 BA.debugLineNum = 46;BA.debugLine="pnlSlova.Initialize(\"\")";
Debug.ShouldStop(8192);
search.mostCurrent._pnlslova.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 47;BA.debugLine="sv.Panel.AddView(pnlSlova, 0, 0, 100%x, 100%y)";
Debug.ShouldStop(16384);
search.mostCurrent._sv.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((search.mostCurrent._pnlslova.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(search.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA)),(Object)(search.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA)));
 BA.debugLineNum = 49;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(65536);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 50;BA.debugLine="cd.Initialize2(Colors.ARGB(127, 211, 211, 211), x";
Debug.ShouldStop(131072);
_cd.runVoidMethod ("Initialize2",(Object)(search.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 127)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)))),(Object)(_x),(Object)(BA.numberCast(int.class, 4)),(Object)(search.mostCurrent.__c.getField(false,"Colors").getField(true,"White")));
 BA.debugLineNum = 51;BA.debugLine="Dim ukupno As Int = 0";
Debug.ShouldStop(262144);
_ukupno = BA.numberCast(int.class, 0);Debug.locals.put("ukupno", _ukupno);Debug.locals.put("ukupno", _ukupno);
 BA.debugLineNum = 52;BA.debugLine="For i = 0 To Starter.listaSlova.Size - 1' Step 4";
Debug.ShouldStop(524288);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {search.mostCurrent._starter._listaslova.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 53;BA.debugLine="For j = 0 To 4";
Debug.ShouldStop(1048576);
{
final int step9 = 1;
final int limit9 = 4;
_j = 0 ;
for (;(step9 > 0 && _j <= limit9) || (step9 < 0 && _j >= limit9) ;_j = ((int)(0 + _j + step9))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 54;BA.debugLine="If ukupno < Starter.listaSlova.Size Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("<",_ukupno,BA.numberCast(double.class, search.mostCurrent._starter._listaslova.runMethod(true,"getSize")))) { 
 BA.debugLineNum = 55;BA.debugLine="Dim s As String = Starter.listaSlova.Get(i*5+j";
Debug.ShouldStop(4194304);
_s = BA.ObjectToString(search.mostCurrent._starter._listaslova.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))));Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 56;BA.debugLine="Dim btn As Button";
Debug.ShouldStop(8388608);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btn", _btn);
 BA.debugLineNum = 57;BA.debugLine="btn.Initialize(\"btnSlovo\")";
Debug.ShouldStop(16777216);
_btn.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("btnSlovo")));
 BA.debugLineNum = 58;BA.debugLine="btn.Text = s";
Debug.ShouldStop(33554432);
_btn.runMethod(true,"setText",BA.ObjectToCharSequence(_s));
 BA.debugLineNum = 59;BA.debugLine="btn.Tag = s";
Debug.ShouldStop(67108864);
_btn.runMethod(false,"setTag",(_s));
 BA.debugLineNum = 60;BA.debugLine="btn.TextSize = 28.0";
Debug.ShouldStop(134217728);
_btn.runMethod(true,"setTextSize",BA.numberCast(float.class, 28.0));
 BA.debugLineNum = 61;BA.debugLine="btn.TextColor = Colors.White";
Debug.ShouldStop(268435456);
_btn.runMethod(true,"setTextColor",search.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 62;BA.debugLine="btn.Typeface = Typeface.LoadFromAssets(f.wheel";
Debug.ShouldStop(536870912);
_btn.runMethod(false,"setTypeface",search.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(search.mostCurrent._f._wheellistfont,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 63;BA.debugLine="btn.Background = cd";
Debug.ShouldStop(1073741824);
_btn.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 64;BA.debugLine="btn.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(-2147483648);
_btn.runMethod(true,"setGravity",search.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL")),(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"))));
 BA.debugLineNum = 65;BA.debugLine="pnlSlova.AddView(btn, x*j + j*2dip, x*i + y +";
Debug.ShouldStop(1);
search.mostCurrent._pnlslova.runVoidMethod ("AddView",(Object)((_btn.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j),RemoteObject.createImmutable(_j),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "*+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),_y,RemoteObject.createImmutable(_i),_y}, "*++*",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)));
 BA.debugLineNum = 66;BA.debugLine="ukupno = ukupno + 1";
Debug.ShouldStop(2);
_ukupno = RemoteObject.solve(new RemoteObject[] {_ukupno,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ukupno", _ukupno);
 }else {
 BA.debugLineNum = 68;BA.debugLine="Exit";
Debug.ShouldStop(8);
if (true) break;
 };
 }
}Debug.locals.put("j", _j);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edttrazi_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("edtTrazi_TextChanged (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,74);
if (RapidSub.canDelegate("edttrazi_textchanged")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","edttrazi_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 74;BA.debugLine="Sub edtTrazi_TextChanged (Old As String, New As St";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="If New.Length > 0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 76;BA.debugLine="Log(New)";
Debug.ShouldStop(2048);
search.mostCurrent.__c.runVoidMethod ("LogImpl","72359298",_new,0);
 BA.debugLineNum = 77;BA.debugLine="traziString = New";
Debug.ShouldStop(4096);
search.mostCurrent._trazistring = _new;
 };
 BA.debugLineNum = 79;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private edtTrazi As EditText";
search.mostCurrent._edttrazi = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private btnTrazi As Button";
search.mostCurrent._btntrazi = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Dim traziString As String";
search.mostCurrent._trazistring = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Dim pnlSlova As Panel";
search.mostCurrent._pnlslova = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim pnlAppPodSlovom As Panel";
search.mostCurrent._pnlapppodslovom = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private sv As ScrollView";
search.mostCurrent._sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim lbl1 As Label	' za ukupan broj aplikacija koj";
search.mostCurrent._lbl1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _issystemapp(RemoteObject _app) throws Exception{
try {
		Debug.PushSubsStack("isSystemapp (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,302);
if (RapidSub.canDelegate("issystemapp")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","issystemapp", _app);}
RemoteObject _obj1 = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _obj2 = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _obj3 = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _size = RemoteObject.createImmutable(0);
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _flags = RemoteObject.createImmutable(0);
RemoteObject _result = RemoteObject.createImmutable(false);
RemoteObject _name = RemoteObject.createImmutable("");
Debug.locals.put("app", _app);
 BA.debugLineNum = 302;BA.debugLine="Sub isSystemapp(app As String) As Boolean";
Debug.ShouldStop(8192);
 BA.debugLineNum = 303;BA.debugLine="Dim Obj1, Obj2, Obj3 As Reflector";
Debug.ShouldStop(16384);
_obj1 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("Obj1", _obj1);
_obj2 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("Obj2", _obj2);
_obj3 = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("Obj3", _obj3);
 BA.debugLineNum = 304;BA.debugLine="Dim size, i, flags As Int";
Debug.ShouldStop(32768);
_size = RemoteObject.createImmutable(0);Debug.locals.put("size", _size);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
_flags = RemoteObject.createImmutable(0);Debug.locals.put("flags", _flags);
 BA.debugLineNum = 305;BA.debugLine="Dim result As Boolean = False";
Debug.ShouldStop(65536);
_result = search.mostCurrent.__c.getField(true,"False");Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 307;BA.debugLine="Obj1.Target = Obj1.GetContext";
Debug.ShouldStop(262144);
_obj1.setField ("Target",(_obj1.runMethod(false,"GetContext",search.processBA)));
 BA.debugLineNum = 308;BA.debugLine="Obj1.Target = Obj1.RunMethod(\"getPackageManager\")";
Debug.ShouldStop(524288);
_obj1.setField ("Target",_obj1.runMethod(false,"RunMethod",(Object)(RemoteObject.createImmutable("getPackageManager"))));
 BA.debugLineNum = 309;BA.debugLine="Obj1.Target = Obj1.RunMethod2(\"getInstalledPackag";
Debug.ShouldStop(1048576);
_obj1.setField ("Target",_obj1.runMethod(false,"RunMethod2",(Object)(BA.ObjectToString("getInstalledPackages")),(Object)(BA.NumberToString(0)),(Object)(RemoteObject.createImmutable("java.lang.int"))));
 BA.debugLineNum = 310;BA.debugLine="For i = 0 To Obj1.RunMethod(\"size\") -1";
Debug.ShouldStop(2097152);
{
final int step7 = 1;
final int limit7 = (int) (0 + RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _obj1.runMethod(false,"RunMethod",(Object)(RemoteObject.createImmutable("size")))),RemoteObject.createImmutable(1)}, "-",1, 0).<Double>get().doubleValue());
_i = BA.numberCast(int.class, 0) ;
for (;(step7 > 0 && _i.<Integer>get().intValue() <= limit7) || (step7 < 0 && _i.<Integer>get().intValue() >= limit7) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 311;BA.debugLine="Obj2.Target = Obj1.RunMethod2(\"get\", i, \"java.la";
Debug.ShouldStop(4194304);
_obj2.setField ("Target",_obj1.runMethod(false,"RunMethod2",(Object)(BA.ObjectToString("get")),(Object)(BA.NumberToString(_i)),(Object)(RemoteObject.createImmutable("java.lang.int"))));
 BA.debugLineNum = 312;BA.debugLine="Dim name As String = Obj2.GetField(\"packageName\"";
Debug.ShouldStop(8388608);
_name = BA.ObjectToString(_obj2.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("packageName"))));Debug.locals.put("name", _name);Debug.locals.put("name", _name);
 BA.debugLineNum = 313;BA.debugLine="If app.ToLowerCase = name.ToLowerCase Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_app.runMethod(true,"toLowerCase"),_name.runMethod(true,"toLowerCase"))) { 
 BA.debugLineNum = 314;BA.debugLine="Obj3.Target = Obj2.GetField(\"applicationInfo\")";
Debug.ShouldStop(33554432);
_obj3.setField ("Target",_obj2.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("applicationInfo"))));
 BA.debugLineNum = 315;BA.debugLine="flags = Obj3.GetField(\"flags\")";
Debug.ShouldStop(67108864);
_flags = BA.numberCast(int.class, _obj3.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("flags"))));Debug.locals.put("flags", _flags);
 BA.debugLineNum = 316;BA.debugLine="If Bit.And(flags, 1)  = 0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",search.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_flags),(Object)(BA.numberCast(int.class, 1))),BA.numberCast(double.class, 0))) { 
 }else {
 BA.debugLineNum = 320;BA.debugLine="result = True";
Debug.ShouldStop(-2147483648);
_result = search.mostCurrent.__c.getField(true,"True");Debug.locals.put("result", _result);
 };
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 324;BA.debugLine="Return result";
Debug.ShouldStop(8);
if (true) return _result;
 BA.debugLineNum = 325;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ivapp_click() throws Exception{
try {
		Debug.PushSubsStack("ivApp_Click (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,209);
if (RapidSub.canDelegate("ivapp_click")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","ivapp_click");}
RemoteObject _in1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _myintent = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _ll = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _x = RemoteObject.declareNull("com.maximus.id.id");
RemoteObject _m = RemoteObject.createImmutable(0);
 BA.debugLineNum = 209;BA.debugLine="Sub ivApp_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 210;BA.debugLine="Dim in1, MyIntent As Intent";
Debug.ShouldStop(131072);
_in1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("in1", _in1);
_myintent = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("MyIntent", _myintent);
 BA.debugLineNum = 211;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(262144);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 212;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(524288);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 214;BA.debugLine="iv = Sender";
Debug.ShouldStop(2097152);
_iv.setObject(search.mostCurrent.__c.runMethod(false,"Sender",search.mostCurrent.activityBA));
 BA.debugLineNum = 215;BA.debugLine="Log(iv.Tag)";
Debug.ShouldStop(4194304);
search.mostCurrent.__c.runVoidMethod ("LogImpl","72621446",BA.ObjectToString(_iv.runMethod(false,"getTag")),0);
 BA.debugLineNum = 217;BA.debugLine="in1 = pm.GetApplicationIntent(iv.Tag)";
Debug.ShouldStop(16777216);
_in1 = _pm.runMethod(false,"GetApplicationIntent",(Object)(BA.ObjectToString(_iv.runMethod(false,"getTag"))));Debug.locals.put("in1", _in1);
 BA.debugLineNum = 221;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(268435456);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 222;BA.debugLine="iv = Sender";
Debug.ShouldStop(536870912);
_iv.setObject(search.mostCurrent.__c.runMethod(false,"Sender",search.mostCurrent.activityBA));
 BA.debugLineNum = 223;BA.debugLine="Log(iv.Tag)";
Debug.ShouldStop(1073741824);
search.mostCurrent.__c.runVoidMethod ("LogImpl","72621454",BA.ObjectToString(_iv.runMethod(false,"getTag")),0);
 BA.debugLineNum = 224;BA.debugLine="Dim ll As List";
Debug.ShouldStop(-2147483648);
_ll = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ll", _ll);
 BA.debugLineNum = 225;BA.debugLine="ll.Initialize";
Debug.ShouldStop(1);
_ll.runVoidMethod ("Initialize");
 BA.debugLineNum = 226;BA.debugLine="ll.AddAll(Array As String(\"Run\", \"Add to favorit";
Debug.ShouldStop(2);
_ll.runVoidMethod ("AddAll",(Object)(search.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("Run"),BA.ObjectToString("Add to favorites"),RemoteObject.createImmutable("Uninstall")})))));
 BA.debugLineNum = 227;BA.debugLine="Dim x As id";
Debug.ShouldStop(4);
_x = RemoteObject.createNew ("com.maximus.id.id");Debug.locals.put("x", _x);
 BA.debugLineNum = 228;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
Debug.ShouldStop(8);
_m = _x.runMethodAndSync(true,"InputList1",(Object)(_ll),(Object)(RemoteObject.createImmutable("")),search.mostCurrent.activityBA);Debug.locals.put("m", _m);Debug.locals.put("m", _m);
 BA.debugLineNum = 229;BA.debugLine="Select m";
Debug.ShouldStop(16);
switch (BA.switchObjectToInt(_m,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1),BA.numberCast(int.class, 2))) {
case 0: {
 BA.debugLineNum = 231;BA.debugLine="StartActivity(in1)";
Debug.ShouldStop(64);
search.mostCurrent.__c.runVoidMethod ("StartActivity",search.processBA,(Object)((_in1.getObject())));
 break; }
case 1: {
 BA.debugLineNum = 233;BA.debugLine="AddToFavorites";
Debug.ShouldStop(256);
_addtofavorites();
 break; }
case 2: {
 BA.debugLineNum = 235;BA.debugLine="UninstallApp(iv.Tag)";
Debug.ShouldStop(1024);
_uninstallapp(BA.ObjectToString(_iv.runMethod(false,"getTag")));
 break; }
}
;
 BA.debugLineNum = 247;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _playstorelink() throws Exception{
try {
		Debug.PushSubsStack("PlayStoreLink (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,330);
if (RapidSub.canDelegate("playstorelink")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","playstorelink");}
RemoteObject _furi = RemoteObject.createImmutable("");
RemoteObject _market = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
 BA.debugLineNum = 330;BA.debugLine="Sub PlayStoreLink";
Debug.ShouldStop(512);
 BA.debugLineNum = 331;BA.debugLine="Dim fURI As String";
Debug.ShouldStop(1024);
_furi = RemoteObject.createImmutable("");Debug.locals.put("fURI", _furi);
 BA.debugLineNum = 332;BA.debugLine="fURI = \"market://details?id=com.b4a.example\"";
Debug.ShouldStop(2048);
_furi = BA.ObjectToString("market://details?id=com.b4a.example");Debug.locals.put("fURI", _furi);
 BA.debugLineNum = 333;BA.debugLine="Dim Market As Intent";
Debug.ShouldStop(4096);
_market = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("Market", _market);
 BA.debugLineNum = 334;BA.debugLine="Market.Initialize(Market.ACTION_VIEW,fURI)";
Debug.ShouldStop(8192);
_market.runVoidMethod ("Initialize",(Object)(_market.getField(true,"ACTION_VIEW")),(Object)(_furi));
 BA.debugLineNum = 335;BA.debugLine="StartActivity (Market)";
Debug.ShouldStop(16384);
search.mostCurrent.__c.runVoidMethod ("StartActivity",search.processBA,(Object)((_market.getObject())));
 BA.debugLineNum = 336;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _trazi(RemoteObject _str) throws Exception{
try {
		Debug.PushSubsStack("Trazi (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,86);
if (RapidSub.canDelegate("trazi")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","trazi", _str);}
Debug.locals.put("str", _str);
 BA.debugLineNum = 86;BA.debugLine="Sub Trazi(str As String)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
		Debug.PushSubsStack("UninstallApp (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,271);
if (RapidSub.canDelegate("uninstallapp")) { return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","uninstallapp", _pkg);}
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
Debug.locals.put("pkg", _pkg);
 BA.debugLineNum = 271;BA.debugLine="Sub UninstallApp(pkg As String)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 272;BA.debugLine="If IsPaused(provjera) = True Then StartService(pr";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",search.mostCurrent.__c.runMethod(true,"IsPaused",search.processBA,(Object)((search.mostCurrent._provjera.getObject()))),search.mostCurrent.__c.getField(true,"True"))) { 
search.mostCurrent.__c.runVoidMethod ("StartService",search.processBA,(Object)((search.mostCurrent._provjera.getObject())));};
 BA.debugLineNum = 274;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(131072);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 276;BA.debugLine="Log(\"package:\" & pkg)";
Debug.ShouldStop(524288);
search.mostCurrent.__c.runVoidMethod ("LogImpl","72818053",RemoteObject.concat(RemoteObject.createImmutable("package:"),_pkg),0);
 BA.debugLineNum = 277;BA.debugLine="i.Initialize(\"android.intent.action.DELETE\", \"pac";
Debug.ShouldStop(1048576);
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.intent.action.DELETE")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("package:"),_pkg)));
 BA.debugLineNum = 279;BA.debugLine="StartActivity(i)";
Debug.ShouldStop(4194304);
search.mostCurrent.__c.runVoidMethod ("StartActivity",search.processBA,(Object)((_i.getObject())));
 BA.debugLineNum = 281;BA.debugLine="pnlSlova.Visible = True";
Debug.ShouldStop(16777216);
search.mostCurrent._pnlslova.runMethod(true,"setVisible",search.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 282;BA.debugLine="pnlSlova.RemoveAllViews";
Debug.ShouldStop(33554432);
search.mostCurrent._pnlslova.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 284;BA.debugLine="DodajSlova";
Debug.ShouldStop(134217728);
_dodajslova();
 BA.debugLineNum = 285;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}