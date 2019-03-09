package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class search_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"trazi\")";
Debug.ShouldStop(8388608);
search.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("trazi")),search.mostCurrent.activityBA);
 BA.debugLineNum = 26;BA.debugLine="DodajSlova";
Debug.ShouldStop(33554432);
_dodajslova();
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_KeyPress (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,200);
if (RapidSub.canDelegate("activity_keypress")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","activity_keypress", _keycode);
Debug.locals.put("KeyCode", _keycode);
 BA.debugLineNum = 200;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
Debug.ShouldStop(128);
 BA.debugLineNum = 201;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And pnlAppPodS";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_keycode,BA.numberCast(double.class, search.mostCurrent.__c.getField(false,"KeyCodes").getField(true,"KEYCODE_BACK"))) && RemoteObject.solveBoolean(".",search.mostCurrent._pnlapppodslovom.runMethod(true,"IsInitialized"))) { 
 BA.debugLineNum = 202;BA.debugLine="If pnlAppPodSlovom.Visible = True Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",search.mostCurrent._pnlapppodslovom.runMethod(true,"getVisible"),search.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 203;BA.debugLine="pnlAppPodSlovom.Visible = False";
Debug.ShouldStop(1024);
search.mostCurrent._pnlapppodslovom.runMethod(true,"setVisible",search.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 204;BA.debugLine="pnlSlova.Visible = True";
Debug.ShouldStop(2048);
search.mostCurrent._pnlslova.runMethod(true,"setVisible",search.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 205;BA.debugLine="Return True";
Debug.ShouldStop(4096);
if (true) return search.mostCurrent.__c.getField(true,"True");
 };
 };
 BA.debugLineNum = 209;BA.debugLine="Return False";
Debug.ShouldStop(65536);
if (true) return search.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Pause (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,33);
if (RapidSub.canDelegate("activity_pause")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Resume (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,29);
if (RapidSub.canDelegate("activity_resume")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","activity_resume");
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
		Debug.PushSubsStack("AddToFavorites (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,179);
if (RapidSub.canDelegate("addtofavorites")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","addtofavorites");
 BA.debugLineNum = 179;BA.debugLine="Sub AddToFavorites";
Debug.ShouldStop(262144);
 BA.debugLineNum = 180;BA.debugLine="CallSub(Main, \"DodajAppUFavorite\")";
Debug.ShouldStop(524288);
search.mostCurrent.__c.runMethodAndSync(false,"CallSubNew",search.processBA,(Object)((search.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("DodajAppUFavorite")));
 BA.debugLineNum = 181;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnslovo_click() throws Exception{
try {
		Debug.PushSubsStack("btnSlovo_Click (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,83);
if (RapidSub.canDelegate("btnslovo_click")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","btnslovo_click");
RemoteObject _b = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
RemoteObject _pkg1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _pkg2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _ukupno1 = RemoteObject.createImmutable(0);
RemoteObject _ukupno2 = RemoteObject.createImmutable(0);
int _i = 0;
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _pckg = RemoteObject.createImmutable("");
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _x = RemoteObject.createImmutable(0);
int _j = 0;
RemoteObject _drawable = RemoteObject.declareNull("Object");
RemoteObject _bdw = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
 BA.debugLineNum = 83;BA.debugLine="Sub btnSlovo_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="Dim b As Button";
Debug.ShouldStop(524288);
_b = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("b", _b);
 BA.debugLineNum = 85;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(1048576);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 86;BA.debugLine="Dim pkg1, pkg2 As List";
Debug.ShouldStop(2097152);
_pkg1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("pkg1", _pkg1);
_pkg2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("pkg2", _pkg2);
 BA.debugLineNum = 88;BA.debugLine="b = Sender";
Debug.ShouldStop(8388608);
_b.setObject(search.mostCurrent.__c.runMethod(false,"Sender",search.mostCurrent.activityBA));
 BA.debugLineNum = 89;BA.debugLine="Log(b.Tag)";
Debug.ShouldStop(16777216);
search.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_b.runMethod(false,"getTag"))));
 BA.debugLineNum = 90;BA.debugLine="pnlSlova.Visible = False";
Debug.ShouldStop(33554432);
search.mostCurrent._pnlslova.runMethod(true,"setVisible",search.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 91;BA.debugLine="pnlAppPodSlovom.Initialize(\"\")";
Debug.ShouldStop(67108864);
search.mostCurrent._pnlapppodslovom.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 92;BA.debugLine="Activity.AddView(pnlAppPodSlovom, 0, 46dip, 100%x";
Debug.ShouldStop(134217728);
search.mostCurrent._activity.runVoidMethod ("AddView",(Object)((search.mostCurrent._pnlapppodslovom.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 46)))),(Object)(search.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA)),(Object)(search.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA)));
 BA.debugLineNum = 93;BA.debugLine="Dim ukupno1, ukupno2 As Int = 0";
Debug.ShouldStop(268435456);
_ukupno1 = RemoteObject.createImmutable(0);Debug.locals.put("ukupno1", _ukupno1);
_ukupno2 = BA.numberCast(int.class, 0);Debug.locals.put("ukupno2", _ukupno2);Debug.locals.put("ukupno2", _ukupno2);
 BA.debugLineNum = 94;BA.debugLine="pkg1.Initialize";
Debug.ShouldStop(536870912);
_pkg1.runVoidMethod ("Initialize");
 BA.debugLineNum = 95;BA.debugLine="pkg2.Initialize";
Debug.ShouldStop(1073741824);
_pkg2.runVoidMethod ("Initialize");
 BA.debugLineNum = 97;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
Debug.ShouldStop(1);
{
final int step12 = 1;
final int limit12 = RemoteObject.solve(new RemoteObject[] {search.mostCurrent._starter._mapa.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12) ;_i = ((int)(0 + _i + step12))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 98;BA.debugLine="Dim s As String = Starter.mapa.GetKeyAt(i)";
Debug.ShouldStop(2);
_s = BA.ObjectToString(search.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 99;BA.debugLine="If s.StartsWith(b.Tag) Then";
Debug.ShouldStop(4);
if (_s.runMethod(true,"startsWith",(Object)(BA.ObjectToString(_b.runMethod(false,"getTag")))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 100;BA.debugLine="ukupno1 = ukupno1 + 1";
Debug.ShouldStop(8);
_ukupno1 = RemoteObject.solve(new RemoteObject[] {_ukupno1,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ukupno1", _ukupno1);
 BA.debugLineNum = 101;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
Debug.ShouldStop(16);
_pckg = BA.ObjectToString(search.mostCurrent._starter._mapa.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("pckg", _pckg);Debug.locals.put("pckg", _pckg);
 BA.debugLineNum = 103;BA.debugLine="pkg1.Add(pckg.SubString2(pckg.IndexOf(\";\")+1, p";
Debug.ShouldStop(64);
_pkg1.runVoidMethod ("Add",(Object)((_pckg.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";"))),RemoteObject.createImmutable(1)}, "+",1, 1)),(Object)(_pckg.runMethod(true,"length"))))));
 BA.debugLineNum = 105;BA.debugLine="pkg2.Add(pckg.SubString2(0, pckg.IndexOf(\";\")))";
Debug.ShouldStop(256);
_pkg2.runVoidMethod ("Add",(Object)((_pckg.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(_pckg.runMethod(true,"indexOf",(Object)(RemoteObject.createImmutable(";"))))))));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 109;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(4096);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 110;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
Debug.ShouldStop(8192);
_cd.runVoidMethod ("Initialize",(Object)(search.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)))),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 111;BA.debugLine="Dim x As Int";
Debug.ShouldStop(16384);
_x = RemoteObject.createImmutable(0);Debug.locals.put("x", _x);
 BA.debugLineNum = 112;BA.debugLine="x = Activity.Width / 5'pkg1.Size";
Debug.ShouldStop(32768);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {search.mostCurrent._activity.runMethod(true,"getWidth"),RemoteObject.createImmutable(5)}, "/",0, 0));Debug.locals.put("x", _x);
 BA.debugLineNum = 116;BA.debugLine="For i = 0 To pkg1.Size - 1";
Debug.ShouldStop(524288);
{
final int step25 = 1;
final int limit25 = RemoteObject.solve(new RemoteObject[] {_pkg1.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step25 > 0 && _i <= limit25) || (step25 < 0 && _i >= limit25) ;_i = ((int)(0 + _i + step25))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 117;BA.debugLine="For j = 0 To 4";
Debug.ShouldStop(1048576);
{
final int step26 = 1;
final int limit26 = 4;
_j = 0 ;
for (;(step26 > 0 && _j <= limit26) || (step26 < 0 && _j >= limit26) ;_j = ((int)(0 + _j + step26))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 118;BA.debugLine="If ukupno2 < ukupno1 Then'pkg1.Size - 1 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("<",_ukupno2,BA.numberCast(double.class, _ukupno1))) { 
 BA.debugLineNum = 119;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon";
Debug.ShouldStop(4194304);
_drawable = (_pm.runMethod(false,"GetApplicationIcon",(Object)(BA.ObjectToString(_pkg1.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1)))))));Debug.locals.put("drawable", _drawable);Debug.locals.put("drawable", _drawable);
 BA.debugLineNum = 120;BA.debugLine="If drawable Is BitmapDrawable Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("i",_drawable, RemoteObject.createImmutable("android.graphics.drawable.BitmapDrawable"))) { 
 BA.debugLineNum = 121;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
Debug.ShouldStop(16777216);
_bdw = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.BitmapDrawable");
_bdw.setObject(_drawable);Debug.locals.put("bdw", _bdw);
 BA.debugLineNum = 122;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
Debug.ShouldStop(33554432);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
_bmp.setObject(_bdw.runMethod(false,"getBitmap"));Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 123;BA.debugLine="bdw.Initialize(bmp.Resize(64dip, 64dip, True)";
Debug.ShouldStop(67108864);
_bdw.runVoidMethod ("Initialize",(Object)((_bmp.runMethod(false,"Resize",(Object)(BA.numberCast(float.class, search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 64))))),(Object)(BA.numberCast(float.class, search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 64))))),(Object)(search.mostCurrent.__c.getField(true,"True"))).getObject())));
 BA.debugLineNum = 124;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(134217728);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 125;BA.debugLine="iv.Initialize(\"ivApp\")";
Debug.ShouldStop(268435456);
_iv.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("ivApp")));
 BA.debugLineNum = 126;BA.debugLine="iv.Bitmap = bdw.Bitmap";
Debug.ShouldStop(536870912);
_iv.runMethod(false,"setBitmap",_bdw.runMethod(false,"getBitmap"));
 BA.debugLineNum = 127;BA.debugLine="iv.Tag = pkg1.Get(i*5+j)";
Debug.ShouldStop(1073741824);
_iv.runMethod(false,"setTag",_pkg1.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))));
 BA.debugLineNum = 128;BA.debugLine="pnlAppPodSlovom.AddView(iv, x*j + j*2dip, x*i";
Debug.ShouldStop(-2147483648);
search.mostCurrent._pnlapppodslovom.runVoidMethod ("AddView",(Object)((_iv.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j),RemoteObject.createImmutable(_j),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "*+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10))),RemoteObject.createImmutable(_i),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "*++*",2, 1)),(Object)(_x),(Object)(_x));
 BA.debugLineNum = 129;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(1);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 130;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(2);
_lbl.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 131;BA.debugLine="lbl.Text = pkg2.Get(i*5+j)";
Debug.ShouldStop(4);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_pkg2.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1)))));
 BA.debugLineNum = 132;BA.debugLine="lbl.TextColor = Colors.White";
Debug.ShouldStop(8);
_lbl.runMethod(true,"setTextColor",search.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 133;BA.debugLine="lbl.Background = cd";
Debug.ShouldStop(16);
_lbl.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 134;BA.debugLine="lbl.TextSize = 12.0";
Debug.ShouldStop(32);
_lbl.runMethod(true,"setTextSize",BA.numberCast(float.class, 12.0));
 BA.debugLineNum = 135;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
Debug.ShouldStop(64);
_lbl.runMethod(false,"setTypeface",search.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(search.mostCurrent._f._wheellistfont,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 136;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
Debug.ShouldStop(128);
_lbl.runMethod(true,"setGravity",search.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL")),(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"))));
 BA.debugLineNum = 137;BA.debugLine="pnlAppPodSlovom.AddView(lbl, x*j, x*i + x + i";
Debug.ShouldStop(256);
search.mostCurrent._pnlapppodslovom.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j)}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),_x,RemoteObject.createImmutable(_i),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30))),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 4)))}, "*++*+",3, 1)),(Object)(_x),(Object)(search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 };
 BA.debugLineNum = 140;BA.debugLine="ukupno2 = ukupno2 + 1";
Debug.ShouldStop(2048);
_ukupno2 = RemoteObject.solve(new RemoteObject[] {_ukupno2,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ukupno2", _ukupno2);
 }else {
 BA.debugLineNum = 142;BA.debugLine="Exit";
Debug.ShouldStop(8192);
if (true) break;
 };
 }
}Debug.locals.put("j", _j);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("btnTrazi_Click (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,74);
if (RapidSub.canDelegate("btntrazi_click")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","btntrazi_click");
 BA.debugLineNum = 74;BA.debugLine="Sub btnTrazi_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Log(\"trazi\")";
Debug.ShouldStop(1024);
search.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("trazi")));
 BA.debugLineNum = 76;BA.debugLine="Trazi(traziString)";
Debug.ShouldStop(2048);
_trazi(search.mostCurrent._trazistring);
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("DodajSlova (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,37);
if (RapidSub.canDelegate("dodajslova")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","dodajslova");
RemoteObject _x = RemoteObject.createImmutable(0);
RemoteObject _y = RemoteObject.createImmutable(0);
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _ukupno = RemoteObject.createImmutable(0);
int _i = 0;
int _j = 0;
RemoteObject _s = RemoteObject.createImmutable("");
RemoteObject _btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
 BA.debugLineNum = 37;BA.debugLine="Sub DodajSlova";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Dim x As Int = Activity.Width / 5	' 5 slova abece";
Debug.ShouldStop(32);
_x = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {search.mostCurrent._activity.runMethod(true,"getWidth"),RemoteObject.createImmutable(5)}, "/",0, 0));Debug.locals.put("x", _x);Debug.locals.put("x", _x);
 BA.debugLineNum = 39;BA.debugLine="Dim y As Int = Activity.Width - x*5 + 8dip";
Debug.ShouldStop(64);
_y = RemoteObject.solve(new RemoteObject[] {search.mostCurrent._activity.runMethod(true,"getWidth"),_x,RemoteObject.createImmutable(5),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 8)))}, "-*+",2, 1);Debug.locals.put("y", _y);Debug.locals.put("y", _y);
 BA.debugLineNum = 40;BA.debugLine="pnlSlova.Initialize(\"\")";
Debug.ShouldStop(128);
search.mostCurrent._pnlslova.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 41;BA.debugLine="Activity.AddView(pnlSlova, 0, 46dip, 100%x, 100%y";
Debug.ShouldStop(256);
search.mostCurrent._activity.runVoidMethod ("AddView",(Object)((search.mostCurrent._pnlslova.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 46)))),(Object)(search.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA)),(Object)(search.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),search.mostCurrent.activityBA)));
 BA.debugLineNum = 42;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(512);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 43;BA.debugLine="cd.Initialize2(Colors.ARGB(127, 211, 211, 211), x";
Debug.ShouldStop(1024);
_cd.runVoidMethod ("Initialize2",(Object)(search.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(BA.numberCast(int.class, 127)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)),(Object)(BA.numberCast(int.class, 211)))),(Object)(_x),(Object)(BA.numberCast(int.class, 4)),(Object)(search.mostCurrent.__c.getField(false,"Colors").getField(true,"White")));
 BA.debugLineNum = 44;BA.debugLine="Dim ukupno As Int = 0";
Debug.ShouldStop(2048);
_ukupno = BA.numberCast(int.class, 0);Debug.locals.put("ukupno", _ukupno);Debug.locals.put("ukupno", _ukupno);
 BA.debugLineNum = 45;BA.debugLine="For i = 0 To Starter.listaSlova.Size - 1' Step 4";
Debug.ShouldStop(4096);
{
final int step8 = 1;
final int limit8 = RemoteObject.solve(new RemoteObject[] {search.mostCurrent._starter._listaslova.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step8 > 0 && _i <= limit8) || (step8 < 0 && _i >= limit8) ;_i = ((int)(0 + _i + step8))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 46;BA.debugLine="For j = 0 To 4";
Debug.ShouldStop(8192);
{
final int step9 = 1;
final int limit9 = 4;
_j = 0 ;
for (;(step9 > 0 && _j <= limit9) || (step9 < 0 && _j >= limit9) ;_j = ((int)(0 + _j + step9))  ) {
Debug.locals.put("j", _j);
 BA.debugLineNum = 47;BA.debugLine="If ukupno < Starter.listaSlova.Size Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("<",_ukupno,BA.numberCast(double.class, search.mostCurrent._starter._listaslova.runMethod(true,"getSize")))) { 
 BA.debugLineNum = 48;BA.debugLine="Dim s As String = Starter.listaSlova.Get(i*5+j";
Debug.ShouldStop(32768);
_s = BA.ObjectToString(search.mostCurrent._starter._listaslova.runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(5),RemoteObject.createImmutable(_j)}, "*+",1, 1))));Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 49;BA.debugLine="Dim btn As Button";
Debug.ShouldStop(65536);
_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("btn", _btn);
 BA.debugLineNum = 50;BA.debugLine="btn.Initialize(\"btnSlovo\")";
Debug.ShouldStop(131072);
_btn.runVoidMethod ("Initialize",search.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("btnSlovo")));
 BA.debugLineNum = 51;BA.debugLine="btn.Text = s";
Debug.ShouldStop(262144);
_btn.runMethod(true,"setText",BA.ObjectToCharSequence(_s));
 BA.debugLineNum = 52;BA.debugLine="btn.Tag = s";
Debug.ShouldStop(524288);
_btn.runMethod(false,"setTag",(_s));
 BA.debugLineNum = 53;BA.debugLine="btn.TextSize = 28.0";
Debug.ShouldStop(1048576);
_btn.runMethod(true,"setTextSize",BA.numberCast(float.class, 28.0));
 BA.debugLineNum = 54;BA.debugLine="btn.TextColor = Colors.White";
Debug.ShouldStop(2097152);
_btn.runMethod(true,"setTextColor",search.mostCurrent.__c.getField(false,"Colors").getField(true,"White"));
 BA.debugLineNum = 55;BA.debugLine="btn.Typeface = Typeface.LoadFromAssets(f.wheel";
Debug.ShouldStop(4194304);
_btn.runMethod(false,"setTypeface",search.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(search.mostCurrent._f._wheellistfont,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 56;BA.debugLine="btn.Background = cd";
Debug.ShouldStop(8388608);
_btn.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 57;BA.debugLine="btn.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL";
Debug.ShouldStop(16777216);
_btn.runMethod(true,"setGravity",search.mostCurrent.__c.getField(false,"Bit").runMethod(true,"Or",(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_HORIZONTAL")),(Object)(search.mostCurrent.__c.getField(false,"Gravity").getField(true,"CENTER_VERTICAL"))));
 BA.debugLineNum = 58;BA.debugLine="pnlSlova.AddView(btn, x*j + j*2dip, x*i + y +";
Debug.ShouldStop(33554432);
search.mostCurrent._pnlslova.runVoidMethod ("AddView",(Object)((_btn.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_j),RemoteObject.createImmutable(_j),search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "*+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,RemoteObject.createImmutable(_i),_y,RemoteObject.createImmutable(_i),_y}, "*++*",2, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {_x,search.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)));
 BA.debugLineNum = 59;BA.debugLine="ukupno = ukupno + 1";
Debug.ShouldStop(67108864);
_ukupno = RemoteObject.solve(new RemoteObject[] {_ukupno,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("ukupno", _ukupno);
 }else {
 BA.debugLineNum = 61;BA.debugLine="Exit";
Debug.ShouldStop(268435456);
if (true) break;
 };
 }
}Debug.locals.put("j", _j);
;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("edtTrazi_TextChanged (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,67);
if (RapidSub.canDelegate("edttrazi_textchanged")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","edttrazi_textchanged", _old, _new);
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 67;BA.debugLine="Sub edtTrazi_TextChanged (Old As String, New As St";
Debug.ShouldStop(4);
 BA.debugLineNum = 68;BA.debugLine="If New.Length > 0 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 69;BA.debugLine="Log(New)";
Debug.ShouldStop(16);
search.mostCurrent.__c.runVoidMethod ("Log",(Object)(_new));
 BA.debugLineNum = 70;BA.debugLine="traziString = New";
Debug.ShouldStop(32);
search.mostCurrent._trazistring = _new;
 };
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
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _ivapp_click() throws Exception{
try {
		Debug.PushSubsStack("ivApp_Click (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,148);
if (RapidSub.canDelegate("ivapp_click")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","ivapp_click");
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _pm = RemoteObject.declareNull("anywheresoftware.b4a.phone.PackageManagerWrapper");
 BA.debugLineNum = 148;BA.debugLine="Sub ivApp_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 149;BA.debugLine="Dim in As Intent";
Debug.ShouldStop(1048576);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("in", _in);
 BA.debugLineNum = 150;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(2097152);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 151;BA.debugLine="Dim pm As PackageManager";
Debug.ShouldStop(4194304);
_pm = RemoteObject.createNew ("anywheresoftware.b4a.phone.PackageManagerWrapper");Debug.locals.put("pm", _pm);
 BA.debugLineNum = 153;BA.debugLine="iv = Sender";
Debug.ShouldStop(16777216);
_iv.setObject(search.mostCurrent.__c.runMethod(false,"Sender",search.mostCurrent.activityBA));
 BA.debugLineNum = 154;BA.debugLine="Log(iv.Tag)";
Debug.ShouldStop(33554432);
search.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_iv.runMethod(false,"getTag"))));
 BA.debugLineNum = 155;BA.debugLine="in = pm.GetApplicationIntent(iv.Tag)";
Debug.ShouldStop(67108864);
_in = _pm.runMethod(false,"GetApplicationIntent",(Object)(BA.ObjectToString(_iv.runMethod(false,"getTag"))));Debug.locals.put("in", _in);
 BA.debugLineNum = 156;BA.debugLine="If in.IsInitialized Then";
Debug.ShouldStop(134217728);
if (_in.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 157;BA.debugLine="StartActivity(in)";
Debug.ShouldStop(268435456);
search.mostCurrent.__c.runVoidMethod ("StartActivity",search.processBA,(Object)((_in.getObject())));
 };
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ivapp_longclick() throws Exception{
try {
		Debug.PushSubsStack("ivApp_LongClick (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,161);
if (RapidSub.canDelegate("ivapp_longclick")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","ivapp_longclick");
RemoteObject _iv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
RemoteObject _ll = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _x = RemoteObject.declareNull("com.maximus.id.id");
RemoteObject _m = RemoteObject.createImmutable(0);
 BA.debugLineNum = 161;BA.debugLine="Sub ivApp_LongClick";
Debug.ShouldStop(1);
 BA.debugLineNum = 162;BA.debugLine="Log(\"long klik!\")";
Debug.ShouldStop(2);
search.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("long klik!")));
 BA.debugLineNum = 163;BA.debugLine="Dim iv As ImageView";
Debug.ShouldStop(4);
_iv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");Debug.locals.put("iv", _iv);
 BA.debugLineNum = 164;BA.debugLine="iv = Sender";
Debug.ShouldStop(8);
_iv.setObject(search.mostCurrent.__c.runMethod(false,"Sender",search.mostCurrent.activityBA));
 BA.debugLineNum = 165;BA.debugLine="Log(iv.Tag)";
Debug.ShouldStop(16);
search.mostCurrent.__c.runVoidMethod ("Log",(Object)(BA.ObjectToString(_iv.runMethod(false,"getTag"))));
 BA.debugLineNum = 166;BA.debugLine="Dim ll As List";
Debug.ShouldStop(32);
_ll = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("ll", _ll);
 BA.debugLineNum = 167;BA.debugLine="ll.Initialize";
Debug.ShouldStop(64);
_ll.runVoidMethod ("Initialize");
 BA.debugLineNum = 168;BA.debugLine="ll.AddAll(Array As String(\"Add to favorites\", \"Un";
Debug.ShouldStop(128);
_ll.runVoidMethod ("AddAll",(Object)(search.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {2},new Object[] {BA.ObjectToString("Add to favorites"),RemoteObject.createImmutable("Uninstall")})))));
 BA.debugLineNum = 169;BA.debugLine="Dim x As id";
Debug.ShouldStop(256);
_x = RemoteObject.createNew ("com.maximus.id.id");Debug.locals.put("x", _x);
 BA.debugLineNum = 170;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
Debug.ShouldStop(512);
_m = _x.runMethodAndSync(true,"InputList1",(Object)(_ll),(Object)(RemoteObject.createImmutable("")),search.mostCurrent.activityBA);Debug.locals.put("m", _m);Debug.locals.put("m", _m);
 BA.debugLineNum = 171;BA.debugLine="Select m";
Debug.ShouldStop(1024);
switch (BA.switchObjectToInt(_m,BA.numberCast(int.class, 0),BA.numberCast(int.class, 1))) {
case 0: {
 BA.debugLineNum = 173;BA.debugLine="AddToFavorites";
Debug.ShouldStop(4096);
_addtofavorites();
 break; }
case 1: {
 BA.debugLineNum = 175;BA.debugLine="UninstallApp(iv.Tag)";
Debug.ShouldStop(16384);
_uninstallapp(BA.ObjectToString(_iv.runMethod(false,"getTag")));
 break; }
}
;
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Trazi (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,79);
if (RapidSub.canDelegate("trazi")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","trazi", _str);
Debug.locals.put("str", _str);
 BA.debugLineNum = 79;BA.debugLine="Sub Trazi(str As String)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("UninstallApp (search) ","search",3,search.mostCurrent.activityBA,search.mostCurrent,183);
if (RapidSub.canDelegate("uninstallapp")) return com.no3dlauncher.search.remoteMe.runUserSub(false, "search","uninstallapp", _pkg);
RemoteObject _i = RemoteObject.declareNull("anywheresoftware.b4a.objects.IntentWrapper");
Debug.locals.put("pkg", _pkg);
 BA.debugLineNum = 183;BA.debugLine="Sub UninstallApp(pkg As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 184;BA.debugLine="If IsPaused(provjera) = True Then StartService(pr";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",search.mostCurrent.__c.runMethod(true,"IsPaused",search.processBA,(Object)((search.mostCurrent._provjera.getObject()))),search.mostCurrent.__c.getField(true,"True"))) { 
search.mostCurrent.__c.runVoidMethod ("StartService",search.processBA,(Object)((search.mostCurrent._provjera.getObject())));};
 BA.debugLineNum = 186;BA.debugLine="Dim i As Intent";
Debug.ShouldStop(33554432);
_i = RemoteObject.createNew ("anywheresoftware.b4a.objects.IntentWrapper");Debug.locals.put("i", _i);
 BA.debugLineNum = 188;BA.debugLine="Log(\"package:\" & pkg)";
Debug.ShouldStop(134217728);
search.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("package:"),_pkg)));
 BA.debugLineNum = 189;BA.debugLine="i.Initialize(\"android.intent.action.DELETE\", \"pac";
Debug.ShouldStop(268435456);
_i.runVoidMethod ("Initialize",(Object)(BA.ObjectToString("android.intent.action.DELETE")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("package:"),_pkg)));
 BA.debugLineNum = 191;BA.debugLine="StartActivity(i)";
Debug.ShouldStop(1073741824);
search.mostCurrent.__c.runVoidMethod ("StartActivity",search.processBA,(Object)((_i.getObject())));
 BA.debugLineNum = 193;BA.debugLine="pnlAppPodSlovom.Visible = False";
Debug.ShouldStop(1);
search.mostCurrent._pnlapppodslovom.runMethod(true,"setVisible",search.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 194;BA.debugLine="pnlAppPodSlovom.RemoveAllViews";
Debug.ShouldStop(2);
search.mostCurrent._pnlapppodslovom.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 195;BA.debugLine="pnlSlova.Visible = True";
Debug.ShouldStop(4);
search.mostCurrent._pnlslova.runMethod(true,"setVisible",search.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 196;BA.debugLine="pnlSlova.RemoveAllViews";
Debug.ShouldStop(8);
search.mostCurrent._pnlslova.runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 197;BA.debugLine="DodajSlova";
Debug.ShouldStop(16);
_dodajslova();
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
}