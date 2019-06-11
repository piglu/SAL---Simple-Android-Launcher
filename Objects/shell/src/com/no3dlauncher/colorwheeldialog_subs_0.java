package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class colorwheeldialog_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Private dialog As CustomLayoutDialog";
colorwheeldialog._dialog = RemoteObject.createNew ("anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog");__ref.setField("_dialog",colorwheeldialog._dialog);
 //BA.debugLineNum = 3;BA.debugLine="Private cvsColors As Canvas";
colorwheeldialog._cvscolors = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");__ref.setField("_cvscolors",colorwheeldialog._cvscolors);
 //BA.debugLineNum = 4;BA.debugLine="Private cvsOverlay As Canvas";
colorwheeldialog._cvsoverlay = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper");__ref.setField("_cvsoverlay",colorwheeldialog._cvsoverlay);
 //BA.debugLineNum = 5;BA.debugLine="Private pnlColors As Panel";
colorwheeldialog._pnlcolors = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_pnlcolors",colorwheeldialog._pnlcolors);
 //BA.debugLineNum = 6;BA.debugLine="Private pnlOverlay As Panel";
colorwheeldialog._pnloverlay = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");__ref.setField("_pnloverlay",colorwheeldialog._pnloverlay);
 //BA.debugLineNum = 7;BA.debugLine="Public ColorResult As Int";
colorwheeldialog._colorresult = RemoteObject.createImmutable(0);__ref.setField("_colorresult",colorwheeldialog._colorresult);
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (colorwheeldialog) ","colorwheeldialog",10,__ref.getField(false, "ba"),__ref,11);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "colorwheeldialog","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 11;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(1024);
 BA.debugLineNum = 13;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pnlcolors_touch(RemoteObject __ref,RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("pnlColors_Touch (colorwheeldialog) ","colorwheeldialog",10,__ref.getField(false, "ba"),__ref,26);
if (RapidSub.canDelegate("pnlcolors_touch")) { return __ref.runUserSub(false, "colorwheeldialog","pnlcolors_touch", __ref, _action, _x, _y);}
RemoteObject _cx = RemoteObject.createImmutable(0f);
RemoteObject _cy = RemoteObject.createImmutable(0f);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 26;BA.debugLine="Sub pnlColors_Touch (Action As Int, X As Float, Y";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="Dim cx = pnlColors.Width / 2, cy = pnlColors.Heig";
Debug.ShouldStop(67108864);
_cx = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_pnlcolors").runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("cx", _cx);Debug.locals.put("cx", _cx);
_cy = BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_pnlcolors").runMethod(true,"getHeight"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("cy", _cy);Debug.locals.put("cy", _cy);
 BA.debugLineNum = 28;BA.debugLine="If Sqrt(Power(x - cx, 2) + Power(y - cy, 2)) > pn";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean(">",colorwheeldialog.__c.runMethod(true,"Sqrt",(Object)(RemoteObject.solve(new RemoteObject[] {colorwheeldialog.__c.runMethod(true,"Power",(Object)(RemoteObject.solve(new RemoteObject[] {_x,_cx}, "-",1, 0)),(Object)(BA.numberCast(double.class, 2))),colorwheeldialog.__c.runMethod(true,"Power",(Object)(RemoteObject.solve(new RemoteObject[] {_y,_cy}, "-",1, 0)),(Object)(BA.numberCast(double.class, 2)))}, "+",1, 0))),RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_pnlcolors").runMethod(true,"getWidth"),RemoteObject.createImmutable(2)}, "/",0, 0))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 29;BA.debugLine="ColorResult = cvsColors.Bitmap.GetPixel(X, Y)";
Debug.ShouldStop(268435456);
__ref.setField ("_colorresult",__ref.getField(false,"_cvscolors").runMethod(false,"getBitmap").runMethod(true,"GetPixel",(Object)(BA.numberCast(int.class, _x)),(Object)(BA.numberCast(int.class, _y))));
 BA.debugLineNum = 30;BA.debugLine="cvsOverlay.DrawColor(Colors.Transparent)";
Debug.ShouldStop(536870912);
__ref.getField(false,"_cvsoverlay").runVoidMethod ("DrawColor",(Object)(colorwheeldialog.__c.getField(false,"Colors").getField(true,"Transparent")));
 BA.debugLineNum = 31;BA.debugLine="cvsOverlay.DrawCircle(X, Y, 20dip, Colors.Black,";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_cvsoverlay").runVoidMethod ("DrawCircle",(Object)(_x),(Object)(_y),(Object)(BA.numberCast(float.class, colorwheeldialog.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20))))),(Object)(colorwheeldialog.__c.getField(false,"Colors").getField(true,"Black")),(Object)(colorwheeldialog.__c.getField(true,"False")),(Object)(BA.numberCast(float.class, colorwheeldialog.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 3))))));
 BA.debugLineNum = 32;BA.debugLine="pnlOverlay.Invalidate";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_pnloverlay").runVoidMethod ("Invalidate");
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _showasync(RemoteObject __ref,RemoteObject _callback,RemoteObject _title) throws Exception{
try {
		Debug.PushSubsStack("ShowAsync (colorwheeldialog) ","colorwheeldialog",10,__ref.getField(false, "ba"),__ref,15);
if (RapidSub.canDelegate("showasync")) { __ref.runUserSub(false, "colorwheeldialog","showasync", __ref, _callback, _title); return;}
ResumableSub_ShowAsync rsub = new ResumableSub_ShowAsync(null,__ref,_callback,_title);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_ShowAsync extends BA.ResumableSub {
public ResumableSub_ShowAsync(com.no3dlauncher.colorwheeldialog parent,RemoteObject __ref,RemoteObject _callback,RemoteObject _title) {
this.parent = parent;
this.__ref = __ref;
this._callback = _callback;
this._title = _title;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
com.no3dlauncher.colorwheeldialog parent;
RemoteObject _callback;
RemoteObject _title;
RemoteObject _sf = RemoteObject.declareNull("Object");
RemoteObject _dialogpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _result = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("ShowAsync (colorwheeldialog) ","colorwheeldialog",10,__ref.getField(false, "ba"),__ref,15);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
Debug.locals.put("_ref", __ref);
Debug.locals.put("CallBack", _callback);
Debug.locals.put("Title", _title);
 BA.debugLineNum = 16;BA.debugLine="Dim sf As Object = dialog.ShowAsync(Title, \"Ok\",";
Debug.ShouldStop(32768);
_sf = __ref.getField(false,"_dialog").runMethod(false,"ShowAsync",(Object)(_title),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("Cancel")),(Object)(BA.ObjectToString("")),__ref.getField(false, "ba"),(Object)((parent.__c.getField(false,"Null"))),(Object)(parent.__c.getField(true,"True")));Debug.locals.put("sf", _sf);Debug.locals.put("sf", _sf);
 BA.debugLineNum = 17;BA.debugLine="dialog.SetSize(300dip, 450dip)";
Debug.ShouldStop(65536);
__ref.getField(false,"_dialog").runVoidMethod ("SetSize",(Object)(parent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 300)))),(Object)(parent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 450)))));
 BA.debugLineNum = 18;BA.debugLine="Wait For (sf) Dialog_Ready (DialogPanel As Panel)";
Debug.ShouldStop(131072);
parent.__c.runVoidMethod ("WaitFor","dialog_ready", __ref.getField(false, "ba"), anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "colorwheeldialog", "showasync"), _sf);
this.state = 1;
return;
case 1:
//C
this.state = -1;
_dialogpanel = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(1));Debug.locals.put("DialogPanel", _dialogpanel);
;
 BA.debugLineNum = 19;BA.debugLine="DialogPanel.LoadLayout(\"WheelPicker\")";
Debug.ShouldStop(262144);
_dialogpanel.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("WheelPicker")),__ref.getField(false, "ba"));
 BA.debugLineNum = 20;BA.debugLine="cvsColors.Initialize(pnlColors)";
Debug.ShouldStop(524288);
__ref.getField(false,"_cvscolors").runVoidMethod ("Initialize",(Object)((__ref.getField(false,"_pnlcolors").getObject())));
 BA.debugLineNum = 21;BA.debugLine="cvsOverlay.Initialize(pnlOverlay)";
Debug.ShouldStop(1048576);
__ref.getField(false,"_cvsoverlay").runVoidMethod ("Initialize",(Object)((__ref.getField(false,"_pnloverlay").getObject())));
 BA.debugLineNum = 22;BA.debugLine="Wait For (sf) Dialog_Result (Result As Int)";
Debug.ShouldStop(2097152);
parent.__c.runVoidMethod ("WaitFor","dialog_result", __ref.getField(false, "ba"), anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "colorwheeldialog", "showasync"), _sf);
this.state = 2;
return;
case 2:
//C
this.state = -1;
_result = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("Result", _result);
;
 BA.debugLineNum = 23;BA.debugLine="CallSubDelayed2(CallBack, \"Color_Result\", Result";
Debug.ShouldStop(4194304);
parent.__c.runVoidMethod ("CallSubDelayed2",__ref.getField(false, "ba"),(Object)(_callback),(Object)(BA.ObjectToString("Color_Result")),(Object)(RemoteObject.createImmutable((RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, parent.__c.getField(false,"DialogResponse").getField(true,"POSITIVE")))))));
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
public static void  _dialog_ready(RemoteObject __ref,RemoteObject _dialogpanel) throws Exception{
}
public static void  _dialog_result(RemoteObject __ref,RemoteObject _result) throws Exception{
}
}