package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class pnlmeni_postavke_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,36);
if (RapidSub.canDelegate("activity_create")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","activity_create", _firsttime);}
RemoteObject _cd = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
RemoteObject _res = null;
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="Activity.LoadLayout(\"opt\")";
Debug.ShouldStop(16);
pnlmeni_postavke.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("opt")),pnlmeni_postavke.mostCurrent.activityBA);
 BA.debugLineNum = 39;BA.debugLine="mapaAnimacija = animacije.Techniques";
Debug.ShouldStop(64);
pnlmeni_postavke.mostCurrent._mapaanimacija = pnlmeni_postavke.mostCurrent._animacije.runMethod(false,"getTechniques");
 BA.debugLineNum = 41;BA.debugLine="f.UcitajVrijednostiOpt";
Debug.ShouldStop(256);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_ucitajvrijednostiopt",pnlmeni_postavke.mostCurrent.activityBA);
 BA.debugLineNum = 42;BA.debugLine="sbTransparent.Value = f.trans";
Debug.ShouldStop(512);
pnlmeni_postavke.mostCurrent._sbtransparent.runMethod(true,"setValue",pnlmeni_postavke.mostCurrent._f._trans);
 BA.debugLineNum = 43;BA.debugLine="Dim cd As ColorDrawable";
Debug.ShouldStop(1024);
_cd = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");Debug.locals.put("cd", _cd);
 BA.debugLineNum = 44;BA.debugLine="Dim res(4) As Int";
Debug.ShouldStop(2048);
_res = RemoteObject.createNewArray ("int", new int[] {4}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 45;BA.debugLine="res = getARGB(f.bojaPozadine)";
Debug.ShouldStop(4096);
_res = _getargb(pnlmeni_postavke.mostCurrent._f._bojapozadine);Debug.locals.put("res", _res);
 BA.debugLineNum = 46;BA.debugLine="res(0) = f.trans";
Debug.ShouldStop(8192);
_res.setArrayElement (pnlmeni_postavke.mostCurrent._f._trans,BA.numberCast(int.class, 0));
 BA.debugLineNum = 47;BA.debugLine="cd.Initialize(Colors.ARGB(res(0), res(1), res(2),";
Debug.ShouldStop(16384);
_cd.runVoidMethod ("Initialize",(Object)(pnlmeni_postavke.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 0))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 1))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 2))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 3))))),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 48;BA.debugLine="Label1.Background = cd";
Debug.ShouldStop(32768);
pnlmeni_postavke.mostCurrent._label1.runMethod(false,"setBackground",(_cd.getObject()));
 BA.debugLineNum = 49;BA.debugLine="Label1.TextColor = f.bojaFonta";
Debug.ShouldStop(65536);
pnlmeni_postavke.mostCurrent._label1.runMethod(true,"setTextColor",pnlmeni_postavke.mostCurrent._f._bojafonta);
 BA.debugLineNum = 50;BA.debugLine="spnApps.AddAll(Array As String(\"in a wheel\", \"in";
Debug.ShouldStop(131072);
pnlmeni_postavke.mostCurrent._spnapps.runVoidMethod ("AddAll",(Object)(pnlmeni_postavke.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {3},new Object[] {BA.ObjectToString("in a wheel"),BA.ObjectToString("in a list with app icons"),RemoteObject.createImmutable("in drawer")})))));
 BA.debugLineNum = 51;BA.debugLine="spnApps.SelectedIndex = f.showApps";
Debug.ShouldStop(262144);
pnlmeni_postavke.mostCurrent._spnapps.runMethod(true,"setSelectedIndex",pnlmeni_postavke.mostCurrent._f._showapps);
 BA.debugLineNum = 52;BA.debugLine="spnIconType.AddAll(Array As String(\"Round\", \"Hexa";
Debug.ShouldStop(524288);
pnlmeni_postavke.mostCurrent._spnicontype.runVoidMethod ("AddAll",(Object)(pnlmeni_postavke.mostCurrent.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("String",new int[] {7},new Object[] {BA.ObjectToString("Round"),BA.ObjectToString("Hexagon"),BA.ObjectToString("Triangle"),BA.ObjectToString("Star"),BA.ObjectToString("Heart"),BA.ObjectToString("Bubble"),RemoteObject.createImmutable("Cone")})))));
 BA.debugLineNum = 53;BA.debugLine="spnIconType.SelectedIndex = f.tipIkone";
Debug.ShouldStop(1048576);
pnlmeni_postavke.mostCurrent._spnicontype.runMethod(true,"setSelectedIndex",pnlmeni_postavke.mostCurrent._f._tipikone);
 BA.debugLineNum = 54;BA.debugLine="If spnIconType.SelectedIndex = 3 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",pnlmeni_postavke.mostCurrent._spnicontype.runMethod(true,"getSelectedIndex"),BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 55;BA.debugLine="Label7.Visible = True";
Debug.ShouldStop(4194304);
pnlmeni_postavke.mostCurrent._label7.runMethod(true,"setVisible",pnlmeni_postavke.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 56;BA.debugLine="edtNoOfStarPoints.Visible = True";
Debug.ShouldStop(8388608);
pnlmeni_postavke.mostCurrent._edtnoofstarpoints.runMethod(true,"setVisible",pnlmeni_postavke.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 57;BA.debugLine="edtNoOfStarPoints.Text = f.brTocaka";
Debug.ShouldStop(16777216);
pnlmeni_postavke.mostCurrent._edtnoofstarpoints.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(pnlmeni_postavke.mostCurrent._f._brtocaka));
 }else {
 BA.debugLineNum = 59;BA.debugLine="Label7.Visible = False";
Debug.ShouldStop(67108864);
pnlmeni_postavke.mostCurrent._label7.runMethod(true,"setVisible",pnlmeni_postavke.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 60;BA.debugLine="edtNoOfStarPoints.Visible = False";
Debug.ShouldStop(134217728);
pnlmeni_postavke.mostCurrent._edtnoofstarpoints.runMethod(true,"setVisible",pnlmeni_postavke.mostCurrent.__c.getField(true,"False"));
 };
 BA.debugLineNum = 63;BA.debugLine="Dim l As List";
Debug.ShouldStop(1073741824);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l", _l);
 BA.debugLineNum = 64;BA.debugLine="l.Initialize";
Debug.ShouldStop(-2147483648);
_l.runVoidMethod ("Initialize");
 BA.debugLineNum = 65;BA.debugLine="For i = 0 To mapaAnimacija.Size - 1";
Debug.ShouldStop(1);
{
final int step26 = 1;
final int limit26 = RemoteObject.solve(new RemoteObject[] {pnlmeni_postavke.mostCurrent._mapaanimacija.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step26 > 0 && _i <= limit26) || (step26 < 0 && _i >= limit26) ;_i = ((int)(0 + _i + step26))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 66;BA.debugLine="l.Add(mapaAnimacija.GetKeyAt(i))";
Debug.ShouldStop(2);
_l.runVoidMethod ("Add",(Object)(pnlmeni_postavke.mostCurrent._mapaanimacija.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 70;BA.debugLine="spnAnim.AddAll(l)";
Debug.ShouldStop(32);
pnlmeni_postavke.mostCurrent._spnanim.runVoidMethod ("AddAll",(Object)(_l));
 BA.debugLineNum = 71;BA.debugLine="spnAnim.SelectedIndex = spnAnim.IndexOf(f.animStr";
Debug.ShouldStop(64);
pnlmeni_postavke.mostCurrent._spnanim.runMethod(true,"setSelectedIndex",pnlmeni_postavke.mostCurrent._spnanim.runMethod(true,"IndexOf",(Object)(pnlmeni_postavke.mostCurrent._f._animstr)));
 BA.debugLineNum = 73;BA.debugLine="edtPages.Text = f.brStranica";
Debug.ShouldStop(256);
pnlmeni_postavke.mostCurrent._edtpages.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(pnlmeni_postavke.mostCurrent._f._brstranica));
 BA.debugLineNum = 75;BA.debugLine="edtFontSize.Text = f.fontzSize";
Debug.ShouldStop(1024);
pnlmeni_postavke.mostCurrent._edtfontsize.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(pnlmeni_postavke.mostCurrent._f._fontzsize));
 BA.debugLineNum = 76;BA.debugLine="DodajFontove";
Debug.ShouldStop(2048);
_dodajfontove();
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,83);
if (RapidSub.canDelegate("activity_pause")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 83;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="If UserClosed Then";
Debug.ShouldStop(524288);
if (_userclosed.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 85;BA.debugLine="Log(\"juzer klouzed\")";
Debug.ShouldStop(1048576);
pnlmeni_postavke.mostCurrent.__c.runVoidMethod ("LogImpl","34456450",RemoteObject.createImmutable("juzer klouzed"),0);
 BA.debugLineNum = 86;BA.debugLine="CallSubDelayed(Main, \"Osvjezi\")";
Debug.ShouldStop(2097152);
pnlmeni_postavke.mostCurrent.__c.runVoidMethod ("CallSubDelayed",pnlmeni_postavke.processBA,(Object)((pnlmeni_postavke.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("Osvjezi")));
 };
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,79);
if (RapidSub.canDelegate("activity_resume")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","activity_resume");}
 BA.debugLineNum = 79;BA.debugLine="Sub Activity_Resume";
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
public static void  _btnbackground_click() throws Exception{
try {
		Debug.PushSubsStack("btnBackground_Click (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,130);
if (RapidSub.canDelegate("btnbackground_click")) { com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","btnbackground_click"); return;}
ResumableSub_btnBackground_Click rsub = new ResumableSub_btnBackground_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btnBackground_Click extends BA.ResumableSub {
public ResumableSub_btnBackground_Click(com.no3dlauncher.pnlmeni_postavke parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.no3dlauncher.pnlmeni_postavke parent;
RemoteObject _cw = RemoteObject.declareNull("com.no3dlauncher.colorwheeldialog");
RemoteObject _res = null;
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnBackground_Click (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,130);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 131;BA.debugLine="Dim cw As ColorWheelDialog";
Debug.ShouldStop(4);
_cw = RemoteObject.createNew ("com.no3dlauncher.colorwheeldialog");Debug.locals.put("cw", _cw);
 BA.debugLineNum = 132;BA.debugLine="Dim res(4) As Int";
Debug.ShouldStop(8);
_res = RemoteObject.createNewArray ("int", new int[] {4}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 134;BA.debugLine="cw.Initialize";
Debug.ShouldStop(32);
_cw.runClassMethod (com.no3dlauncher.colorwheeldialog.class, "_initialize",pnlmeni_postavke.mostCurrent.activityBA);
 BA.debugLineNum = 135;BA.debugLine="cw.ShowAsync(Me, \"Select Background Color\")";
Debug.ShouldStop(64);
_cw.runClassMethod (com.no3dlauncher.colorwheeldialog.class, "_showasync",(Object)(pnlmeni_postavke.getObject()),(Object)(RemoteObject.createImmutable("Select Background Color")));
 BA.debugLineNum = 136;BA.debugLine="Wait For (cw) Color_Result(Success As Boolean)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","color_result", pnlmeni_postavke.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "pnlmeni_postavke", "btnbackground_click"), (_cw));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 137;BA.debugLine="If Success Then";
Debug.ShouldStop(256);
if (true) break;

case 1:
//if
this.state = 4;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 138;BA.debugLine="res = getARGB(cw.ColorResult)";
Debug.ShouldStop(512);
_res = _getargb(_cw.getField(true,"_colorresult"));Debug.locals.put("res", _res);
 BA.debugLineNum = 139;BA.debugLine="Log(res(0))";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","34784137",BA.NumberToString(_res.getArrayElement(true,BA.numberCast(int.class, 0))),0);
 BA.debugLineNum = 140;BA.debugLine="Log(res(1))";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","34784138",BA.NumberToString(_res.getArrayElement(true,BA.numberCast(int.class, 1))),0);
 BA.debugLineNum = 141;BA.debugLine="Log(res(2))";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","34784139",BA.NumberToString(_res.getArrayElement(true,BA.numberCast(int.class, 2))),0);
 BA.debugLineNum = 142;BA.debugLine="Log(res(3))";
Debug.ShouldStop(8192);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","34784140",BA.NumberToString(_res.getArrayElement(true,BA.numberCast(int.class, 3))),0);
 BA.debugLineNum = 143;BA.debugLine="Label1.Color = cw.ColorResult";
Debug.ShouldStop(16384);
parent.mostCurrent._label1.runVoidMethod ("setColor",_cw.getField(true,"_colorresult"));
 BA.debugLineNum = 144;BA.debugLine="f.SnimiOpcije2(\"bojaPozadine\", cw.ColorResult)";
Debug.ShouldStop(32768);
parent.mostCurrent._f.runVoidMethod ("_snimiopcije2",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("bojaPozadine")),(Object)(_cw.getField(true,"_colorresult")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
public static void  _color_result(RemoteObject _success) throws Exception{
}
public static void  _btnfont_click() throws Exception{
try {
		Debug.PushSubsStack("btnFont_Click (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,148);
if (RapidSub.canDelegate("btnfont_click")) { com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","btnfont_click"); return;}
ResumableSub_btnFont_Click rsub = new ResumableSub_btnFont_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btnFont_Click extends BA.ResumableSub {
public ResumableSub_btnFont_Click(com.no3dlauncher.pnlmeni_postavke parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
com.no3dlauncher.pnlmeni_postavke parent;
RemoteObject _cw = RemoteObject.declareNull("com.no3dlauncher.colorwheeldialog");
RemoteObject _res = null;
RemoteObject _success = RemoteObject.createImmutable(false);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnFont_Click (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,148);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 149;BA.debugLine="Dim cw As ColorWheelDialog";
Debug.ShouldStop(1048576);
_cw = RemoteObject.createNew ("com.no3dlauncher.colorwheeldialog");Debug.locals.put("cw", _cw);
 BA.debugLineNum = 150;BA.debugLine="Dim res(4) As Int";
Debug.ShouldStop(2097152);
_res = RemoteObject.createNewArray ("int", new int[] {4}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 152;BA.debugLine="cw.Initialize";
Debug.ShouldStop(8388608);
_cw.runClassMethod (com.no3dlauncher.colorwheeldialog.class, "_initialize",pnlmeni_postavke.mostCurrent.activityBA);
 BA.debugLineNum = 153;BA.debugLine="cw.ShowAsync(Me, \"Select Font Color\")";
Debug.ShouldStop(16777216);
_cw.runClassMethod (com.no3dlauncher.colorwheeldialog.class, "_showasync",(Object)(pnlmeni_postavke.getObject()),(Object)(RemoteObject.createImmutable("Select Font Color")));
 BA.debugLineNum = 154;BA.debugLine="Wait For (cw) Color_Result(Success As Boolean)";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","color_result", pnlmeni_postavke.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "pnlmeni_postavke", "btnfont_click"), (_cw));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_success = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(0));Debug.locals.put("Success", _success);
;
 BA.debugLineNum = 155;BA.debugLine="If Success Then";
Debug.ShouldStop(67108864);
if (true) break;

case 1:
//if
this.state = 4;
if (_success.<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 156;BA.debugLine="res = getARGB(cw.ColorResult)";
Debug.ShouldStop(134217728);
_res = _getargb(_cw.getField(true,"_colorresult"));Debug.locals.put("res", _res);
 BA.debugLineNum = 157;BA.debugLine="Log(res(0))";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","34849673",BA.NumberToString(_res.getArrayElement(true,BA.numberCast(int.class, 0))),0);
 BA.debugLineNum = 158;BA.debugLine="Log(res(1))";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","34849674",BA.NumberToString(_res.getArrayElement(true,BA.numberCast(int.class, 1))),0);
 BA.debugLineNum = 159;BA.debugLine="Log(res(2))";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","34849675",BA.NumberToString(_res.getArrayElement(true,BA.numberCast(int.class, 2))),0);
 BA.debugLineNum = 160;BA.debugLine="Log(res(3))";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","34849676",BA.NumberToString(_res.getArrayElement(true,BA.numberCast(int.class, 3))),0);
 BA.debugLineNum = 161;BA.debugLine="Label1.TextColor = cw.ColorResult";
Debug.ShouldStop(1);
parent.mostCurrent._label1.runMethod(true,"setTextColor",_cw.getField(true,"_colorresult"));
 BA.debugLineNum = 162;BA.debugLine="f.SnimiOpcije2(\"bojaFonta\", cw.ColorResult)";
Debug.ShouldStop(2);
parent.mostCurrent._f.runVoidMethod ("_snimiopcije2",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("bojaFonta")),(Object)(_cw.getField(true,"_colorresult")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 164;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
public static RemoteObject  _dodajfontove() throws Exception{
try {
		Debug.PushSubsStack("DodajFontove (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,90);
if (RapidSub.canDelegate("dodajfontove")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","dodajfontove");}
RemoteObject _list = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
RemoteObject _s = RemoteObject.createImmutable("");
 BA.debugLineNum = 90;BA.debugLine="Sub DodajFontove";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="Dim list As List";
Debug.ShouldStop(67108864);
_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list", _list);
 BA.debugLineNum = 92;BA.debugLine="list = File.ListFiles(File.DirAssets)";
Debug.ShouldStop(134217728);
_list = pnlmeni_postavke.mostCurrent.__c.getField(false,"File").runMethod(false,"ListFiles",(Object)(pnlmeni_postavke.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")));Debug.locals.put("list", _list);
 BA.debugLineNum = 93;BA.debugLine="For i = 0 To list.Size - 1";
Debug.ShouldStop(268435456);
{
final int step3 = 1;
final int limit3 = RemoteObject.solve(new RemoteObject[] {_list.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((int)(0 + _i + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 94;BA.debugLine="Dim s As String = list.Get(i)";
Debug.ShouldStop(536870912);
_s = BA.ObjectToString(_list.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("s", _s);Debug.locals.put("s", _s);
 BA.debugLineNum = 95;BA.debugLine="If s.EndsWith(\".ttf\") Then";
Debug.ShouldStop(1073741824);
if (_s.runMethod(true,"endsWith",(Object)(RemoteObject.createImmutable(".ttf"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 96;BA.debugLine="s = s.SubString2(0, s.LastIndexOf(\".\"))";
Debug.ShouldStop(-2147483648);
_s = _s.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 0)),(Object)(_s.runMethod(true,"lastIndexOf",(Object)(RemoteObject.createImmutable(".")))));Debug.locals.put("s", _s);
 BA.debugLineNum = 97;BA.debugLine="spnFont.Add(s)";
Debug.ShouldStop(1);
pnlmeni_postavke.mostCurrent._spnfont.runVoidMethod ("Add",(Object)(_s));
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 100;BA.debugLine="spnFont.SelectedIndex = spnFont.IndexOf(f.wheelLi";
Debug.ShouldStop(8);
pnlmeni_postavke.mostCurrent._spnfont.runMethod(true,"setSelectedIndex",pnlmeni_postavke.mostCurrent._spnfont.runMethod(true,"IndexOf",(Object)(pnlmeni_postavke.mostCurrent._f._wheellistfont)));
 BA.debugLineNum = 101;BA.debugLine="Label3.Typeface = Typeface.LoadFromAssets(f.wheel";
Debug.ShouldStop(16);
pnlmeni_postavke.mostCurrent._label3.runMethod(false,"setTypeface",pnlmeni_postavke.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(pnlmeni_postavke.mostCurrent._f._wheellistfont,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edtfontsize_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("edtFontSize_TextChanged (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,123);
if (RapidSub.canDelegate("edtfontsize_textchanged")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","edtfontsize_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 123;BA.debugLine="Sub edtFontSize_TextChanged (Old As String, New As";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 124;BA.debugLine="If New.Length > 0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 126;BA.debugLine="f.SnimiOpcije2(\"fontzSize\", New)";
Debug.ShouldStop(536870912);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_snimiopcije2",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("fontzSize")),(Object)(BA.numberCast(int.class, _new)));
 };
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edtnoofstarpoints_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("edtNoOfStarPoints_TextChanged (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,200);
if (RapidSub.canDelegate("edtnoofstarpoints_textchanged")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","edtnoofstarpoints_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 200;BA.debugLine="Sub edtNoOfStarPoints_TextChanged (Old As String,";
Debug.ShouldStop(128);
 BA.debugLineNum = 201;BA.debugLine="If New.Length > 0 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 202;BA.debugLine="f.SnimiOpcije2(\"brTocaka\", New)";
Debug.ShouldStop(512);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_snimiopcije2",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("brTocaka")),(Object)(BA.numberCast(int.class, _new)));
 };
 BA.debugLineNum = 204;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _edtpages_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("edtPages_TextChanged (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,206);
if (RapidSub.canDelegate("edtpages_textchanged")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","edtpages_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 206;BA.debugLine="Sub edtPages_TextChanged (Old As String, New As St";
Debug.ShouldStop(8192);
 BA.debugLineNum = 207;BA.debugLine="If New.Length > 0 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 208;BA.debugLine="f.SnimiOpcije2(\"brStranica\", New)";
Debug.ShouldStop(32768);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_snimiopcije2",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("brStranica")),(Object)(BA.numberCast(int.class, _new)));
 };
 BA.debugLineNum = 210;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getargb(RemoteObject _color) throws Exception{
try {
		Debug.PushSubsStack("getARGB (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,166);
if (RapidSub.canDelegate("getargb")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","getargb", _color);}
RemoteObject _res = null;
Debug.locals.put("Color", _color);
 BA.debugLineNum = 166;BA.debugLine="Sub getARGB(Color As Int) As Int()";
Debug.ShouldStop(32);
 BA.debugLineNum = 167;BA.debugLine="Dim res(4) As Int";
Debug.ShouldStop(64);
_res = RemoteObject.createNewArray ("int", new int[] {4}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 169;BA.debugLine="res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
Debug.ShouldStop(256);
_res.setArrayElement (pnlmeni_postavke.mostCurrent.__c.getField(false,"Bit").runMethod(true,"UnsignedShiftRight",(Object)(pnlmeni_postavke.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_color),(Object)(BA.numberCast(int.class, 0xff000000)))),(Object)(BA.numberCast(int.class, 24))),BA.numberCast(int.class, 0));
 BA.debugLineNum = 170;BA.debugLine="res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
Debug.ShouldStop(512);
_res.setArrayElement (pnlmeni_postavke.mostCurrent.__c.getField(false,"Bit").runMethod(true,"UnsignedShiftRight",(Object)(pnlmeni_postavke.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_color),(Object)(BA.numberCast(int.class, 0xff0000)))),(Object)(BA.numberCast(int.class, 16))),BA.numberCast(int.class, 1));
 BA.debugLineNum = 171;BA.debugLine="res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
Debug.ShouldStop(1024);
_res.setArrayElement (pnlmeni_postavke.mostCurrent.__c.getField(false,"Bit").runMethod(true,"UnsignedShiftRight",(Object)(pnlmeni_postavke.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_color),(Object)(BA.numberCast(int.class, 0xff00)))),(Object)(BA.numberCast(int.class, 8))),BA.numberCast(int.class, 2));
 BA.debugLineNum = 172;BA.debugLine="res(3) = Bit.And(Color, 0xff)";
Debug.ShouldStop(2048);
_res.setArrayElement (pnlmeni_postavke.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(_color),(Object)(BA.numberCast(int.class, 0xff))),BA.numberCast(int.class, 3));
 BA.debugLineNum = 174;BA.debugLine="Return res";
Debug.ShouldStop(8192);
if (true) return _res;
 BA.debugLineNum = 175;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 15;BA.debugLine="Private spnApps As Spinner";
pnlmeni_postavke.mostCurrent._spnapps = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private spnFont As Spinner";
pnlmeni_postavke.mostCurrent._spnfont = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Label3 As Label";
pnlmeni_postavke.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private edtFontSize As EditText";
pnlmeni_postavke.mostCurrent._edtfontsize = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private Label1 As Label";
pnlmeni_postavke.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private btnBackground As Button";
pnlmeni_postavke.mostCurrent._btnbackground = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private btnFont As Button";
pnlmeni_postavke.mostCurrent._btnfont = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private sbTransparent As SeekBar";
pnlmeni_postavke.mostCurrent._sbtransparent = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private spnIconType As Spinner";
pnlmeni_postavke.mostCurrent._spnicontype = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private edtNoOfStarPoints As EditText";
pnlmeni_postavke.mostCurrent._edtnoofstarpoints = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Label7 As Label";
pnlmeni_postavke.mostCurrent._label7 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private edtPages As EditText";
pnlmeni_postavke.mostCurrent._edtpages = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim animacije As AnimationComposer";
pnlmeni_postavke.mostCurrent._animacije = RemoteObject.createNew ("de.donmanfred.AnimationComposerWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Dim mapaAnimacija As Map";
pnlmeni_postavke.mostCurrent._mapaanimacija = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 32;BA.debugLine="Private spnAnim As Spinner";
pnlmeni_postavke.mostCurrent._spnanim = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private btnEnableNotifications As Button";
pnlmeni_postavke.mostCurrent._btnenablenotifications = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _sbtransparent_valuechanged(RemoteObject _value,RemoteObject _userchanged) throws Exception{
try {
		Debug.PushSubsStack("sbTransparent_ValueChanged (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,177);
if (RapidSub.canDelegate("sbtransparent_valuechanged")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","sbtransparent_valuechanged", _value, _userchanged);}
RemoteObject _res = null;
Debug.locals.put("Value", _value);
Debug.locals.put("UserChanged", _userchanged);
 BA.debugLineNum = 177;BA.debugLine="Sub sbTransparent_ValueChanged (Value As Int, User";
Debug.ShouldStop(65536);
 BA.debugLineNum = 178;BA.debugLine="If UserChanged Then";
Debug.ShouldStop(131072);
if (_userchanged.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 179;BA.debugLine="Dim res(4) As Int";
Debug.ShouldStop(262144);
_res = RemoteObject.createNewArray ("int", new int[] {4}, new Object[]{});Debug.locals.put("res", _res);
 BA.debugLineNum = 180;BA.debugLine="f.SnimiOpcije2(\"trans\", Value)";
Debug.ShouldStop(524288);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_snimiopcije2",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("trans")),(Object)(_value));
 BA.debugLineNum = 181;BA.debugLine="f.UcitajVrijednostiOpt";
Debug.ShouldStop(1048576);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_ucitajvrijednostiopt",pnlmeni_postavke.mostCurrent.activityBA);
 BA.debugLineNum = 182;BA.debugLine="res = getARGB(f.bojaPozadine)";
Debug.ShouldStop(2097152);
_res = _getargb(pnlmeni_postavke.mostCurrent._f._bojapozadine);Debug.locals.put("res", _res);
 BA.debugLineNum = 183;BA.debugLine="res(0) = f.trans";
Debug.ShouldStop(4194304);
_res.setArrayElement (pnlmeni_postavke.mostCurrent._f._trans,BA.numberCast(int.class, 0));
 BA.debugLineNum = 184;BA.debugLine="Label1.Color = Colors.ARGB(res(0), res(1), res(2";
Debug.ShouldStop(8388608);
pnlmeni_postavke.mostCurrent._label1.runVoidMethod ("setColor",pnlmeni_postavke.mostCurrent.__c.getField(false,"Colors").runMethod(true,"ARGB",(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 0))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 1))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 2))),(Object)(_res.getArrayElement(true,BA.numberCast(int.class, 3)))));
 };
 BA.debugLineNum = 186;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _spnanim_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("spnAnim_ItemClick (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,212);
if (RapidSub.canDelegate("spnanim_itemclick")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","spnanim_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 212;BA.debugLine="Sub spnAnim_ItemClick (Position As Int, Value As O";
Debug.ShouldStop(524288);
 BA.debugLineNum = 213;BA.debugLine="f.SnimiOpcije(\"animStr\", Value)";
Debug.ShouldStop(1048576);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_snimiopcije",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("animStr")),(Object)(BA.ObjectToString(_value)));
 BA.debugLineNum = 214;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _spnapps_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("spnApps_ItemClick (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,109);
if (RapidSub.canDelegate("spnapps_itemclick")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","spnapps_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 109;BA.debugLine="Sub spnApps_ItemClick (Position As Int, Value As O";
Debug.ShouldStop(4096);
 BA.debugLineNum = 110;BA.debugLine="f.UcitajVrijednostiOpt";
Debug.ShouldStop(8192);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_ucitajvrijednostiopt",pnlmeni_postavke.mostCurrent.activityBA);
 BA.debugLineNum = 112;BA.debugLine="If Position > 0 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean(">",_position,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 113;BA.debugLine="If f.fontzSize >= 50 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("g",pnlmeni_postavke.mostCurrent._f._fontzsize,BA.numberCast(double.class, 50))) { 
 BA.debugLineNum = 114;BA.debugLine="edtFontSize.Text = 18";
Debug.ShouldStop(131072);
pnlmeni_postavke.mostCurrent._edtfontsize.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(18));
 };
 }else {
 BA.debugLineNum = 117;BA.debugLine="ToastMessageShow(\"Font size should be at least 5";
Debug.ShouldStop(1048576);
pnlmeni_postavke.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Font size should be at least 55 for 'in wheel'!")),(Object)(pnlmeni_postavke.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 118;BA.debugLine="edtFontSize.Text = 55";
Debug.ShouldStop(2097152);
pnlmeni_postavke.mostCurrent._edtfontsize.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(55));
 };
 BA.debugLineNum = 120;BA.debugLine="f.SnimiOpcije2(\"showApps\", Position)";
Debug.ShouldStop(8388608);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_snimiopcije2",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("showApps")),(Object)(_position));
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _spnfont_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("spnFont_ItemClick (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,104);
if (RapidSub.canDelegate("spnfont_itemclick")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","spnfont_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 104;BA.debugLine="Sub spnFont_ItemClick (Position As Int, Value As O";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="f.SnimiOpcije(\"wheelListFont\",	Value)";
Debug.ShouldStop(256);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_snimiopcije",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("wheelListFont")),(Object)(BA.ObjectToString(_value)));
 BA.debugLineNum = 106;BA.debugLine="Label3.Typeface = Typeface.LoadFromAssets(Value &";
Debug.ShouldStop(512);
pnlmeni_postavke.mostCurrent._label3.runMethod(false,"setTypeface",pnlmeni_postavke.mostCurrent.__c.getField(false,"Typeface").runMethod(false,"LoadFromAssets",(Object)(RemoteObject.concat(_value,RemoteObject.createImmutable(".ttf")))));
 BA.debugLineNum = 107;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _spnicontype_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("spnIconType_ItemClick (pnlmeni_postavke) ","pnlmeni_postavke",2,pnlmeni_postavke.mostCurrent.activityBA,pnlmeni_postavke.mostCurrent,188);
if (RapidSub.canDelegate("spnicontype_itemclick")) { return com.no3dlauncher.pnlmeni_postavke.remoteMe.runUserSub(false, "pnlmeni_postavke","spnicontype_itemclick", _position, _value);}
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 188;BA.debugLine="Sub spnIconType_ItemClick (Position As Int, Value";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 189;BA.debugLine="f.SnimiOpcije2(\"tipIkone\", Position)";
Debug.ShouldStop(268435456);
pnlmeni_postavke.mostCurrent._f.runVoidMethod ("_snimiopcije2",pnlmeni_postavke.mostCurrent.activityBA,(Object)(BA.ObjectToString("tipIkone")),(Object)(_position));
 BA.debugLineNum = 190;BA.debugLine="If Position = 3 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, 3))) { 
 BA.debugLineNum = 191;BA.debugLine="Label7.Visible = True";
Debug.ShouldStop(1073741824);
pnlmeni_postavke.mostCurrent._label7.runMethod(true,"setVisible",pnlmeni_postavke.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 192;BA.debugLine="edtNoOfStarPoints.Visible = True";
Debug.ShouldStop(-2147483648);
pnlmeni_postavke.mostCurrent._edtnoofstarpoints.runMethod(true,"setVisible",pnlmeni_postavke.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 193;BA.debugLine="edtNoOfStarPoints.Text = f.brTocaka";
Debug.ShouldStop(1);
pnlmeni_postavke.mostCurrent._edtnoofstarpoints.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(pnlmeni_postavke.mostCurrent._f._brtocaka));
 }else {
 BA.debugLineNum = 195;BA.debugLine="Label7.Visible = False";
Debug.ShouldStop(4);
pnlmeni_postavke.mostCurrent._label7.runMethod(true,"setVisible",pnlmeni_postavke.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 196;BA.debugLine="edtNoOfStarPoints.Visible = False";
Debug.ShouldStop(8);
pnlmeni_postavke.mostCurrent._edtnoofstarpoints.runMethod(true,"setVisible",pnlmeni_postavke.mostCurrent.__c.getField(true,"False"));
 };
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