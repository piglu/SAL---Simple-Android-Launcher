package com.no3dlauncher;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class colorwheeldialog extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "com.no3dlauncher.colorwheeldialog");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.no3dlauncher.colorwheeldialog.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog _dialog = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvscolors = null;
public anywheresoftware.b4a.objects.drawable.CanvasWrapper _cvsoverlay = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlcolors = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnloverlay = null;
public int _colorresult = 0;
public com.no3dlauncher.main _main = null;
public com.no3dlauncher.starter _starter = null;
public com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public com.no3dlauncher.search _search = null;
public com.no3dlauncher.notificationservice _notificationservice = null;
public com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public com.no3dlauncher.f _f = null;
public com.no3dlauncher.provjera _provjera = null;
public String  _initialize(com.no3dlauncher.colorwheeldialog __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="colorwheeldialog";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
RDebugUtils.currentLine=11272192;
 //BA.debugLineNum = 11272192;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=11272194;
 //BA.debugLineNum = 11272194;BA.debugLine="End Sub";
return "";
}
public void  _showasync(com.no3dlauncher.colorwheeldialog __ref,Object _callback,String _title) throws Exception{
RDebugUtils.currentModule="colorwheeldialog";
if (Debug.shouldDelegate(ba, "showasync", false))
	 {Debug.delegate(ba, "showasync", new Object[] {_callback,_title}); return;}
ResumableSub_ShowAsync rsub = new ResumableSub_ShowAsync(this,__ref,_callback,_title);
rsub.resume(ba, null);
}
public static class ResumableSub_ShowAsync extends BA.ResumableSub {
public ResumableSub_ShowAsync(com.no3dlauncher.colorwheeldialog parent,com.no3dlauncher.colorwheeldialog __ref,Object _callback,String _title) {
this.parent = parent;
this.__ref = __ref;
this._callback = _callback;
this._title = _title;
this.__ref = parent;
}
com.no3dlauncher.colorwheeldialog __ref;
com.no3dlauncher.colorwheeldialog parent;
Object _callback;
String _title;
Object _sf = null;
anywheresoftware.b4a.objects.PanelWrapper _dialogpanel = null;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="colorwheeldialog";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=11337729;
 //BA.debugLineNum = 11337729;BA.debugLine="Dim sf As Object = dialog.ShowAsync(Title, \"Ok\",";
_sf = __ref._dialog.ShowAsync(_title,"Ok","Cancel","",ba,(android.graphics.Bitmap)(parent.__c.Null),parent.__c.True);
RDebugUtils.currentLine=11337730;
 //BA.debugLineNum = 11337730;BA.debugLine="dialog.SetSize(300dip, 450dip)";
__ref._dialog.SetSize(parent.__c.DipToCurrent((int) (300)),parent.__c.DipToCurrent((int) (450)));
RDebugUtils.currentLine=11337731;
 //BA.debugLineNum = 11337731;BA.debugLine="Wait For (sf) Dialog_Ready (DialogPanel As Panel)";
parent.__c.WaitFor("dialog_ready", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "colorwheeldialog", "showasync"), _sf);
this.state = 1;
return;
case 1:
//C
this.state = -1;
_dialogpanel = (anywheresoftware.b4a.objects.PanelWrapper) result[1];
;
RDebugUtils.currentLine=11337732;
 //BA.debugLineNum = 11337732;BA.debugLine="DialogPanel.LoadLayout(\"WheelPicker\")";
_dialogpanel.LoadLayout("WheelPicker",ba);
RDebugUtils.currentLine=11337733;
 //BA.debugLineNum = 11337733;BA.debugLine="cvsColors.Initialize(pnlColors)";
__ref._cvscolors.Initialize((android.view.View)(__ref._pnlcolors.getObject()));
RDebugUtils.currentLine=11337734;
 //BA.debugLineNum = 11337734;BA.debugLine="cvsOverlay.Initialize(pnlOverlay)";
__ref._cvsoverlay.Initialize((android.view.View)(__ref._pnloverlay.getObject()));
RDebugUtils.currentLine=11337735;
 //BA.debugLineNum = 11337735;BA.debugLine="Wait For (sf) Dialog_Result (Result As Int)";
parent.__c.WaitFor("dialog_result", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "colorwheeldialog", "showasync"), _sf);
this.state = 2;
return;
case 2:
//C
this.state = -1;
_result = (Integer) result[1];
;
RDebugUtils.currentLine=11337736;
 //BA.debugLineNum = 11337736;BA.debugLine="CallSubDelayed2(CallBack, \"Color_Result\", Result";
parent.__c.CallSubDelayed2(ba,_callback,"Color_Result",(Object)(_result==parent.__c.DialogResponse.POSITIVE));
RDebugUtils.currentLine=11337737;
 //BA.debugLineNum = 11337737;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _class_globals(com.no3dlauncher.colorwheeldialog __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="colorwheeldialog";
RDebugUtils.currentLine=11206656;
 //BA.debugLineNum = 11206656;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=11206657;
 //BA.debugLineNum = 11206657;BA.debugLine="Private dialog As CustomLayoutDialog";
_dialog = new anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog();
RDebugUtils.currentLine=11206658;
 //BA.debugLineNum = 11206658;BA.debugLine="Private cvsColors As Canvas";
_cvscolors = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=11206659;
 //BA.debugLineNum = 11206659;BA.debugLine="Private cvsOverlay As Canvas";
_cvsoverlay = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=11206660;
 //BA.debugLineNum = 11206660;BA.debugLine="Private pnlColors As Panel";
_pnlcolors = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11206661;
 //BA.debugLineNum = 11206661;BA.debugLine="Private pnlOverlay As Panel";
_pnloverlay = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=11206662;
 //BA.debugLineNum = 11206662;BA.debugLine="Public ColorResult As Int";
_colorresult = 0;
RDebugUtils.currentLine=11206663;
 //BA.debugLineNum = 11206663;BA.debugLine="End Sub";
return "";
}
public String  _pnlcolors_touch(com.no3dlauncher.colorwheeldialog __ref,int _action,float _x,float _y) throws Exception{
__ref = this;
RDebugUtils.currentModule="colorwheeldialog";
if (Debug.shouldDelegate(ba, "pnlcolors_touch", false))
	 {return ((String) Debug.delegate(ba, "pnlcolors_touch", new Object[] {_action,_x,_y}));}
float _cx = 0f;
float _cy = 0f;
RDebugUtils.currentLine=11403264;
 //BA.debugLineNum = 11403264;BA.debugLine="Sub pnlColors_Touch (Action As Int, X As Float, Y";
RDebugUtils.currentLine=11403265;
 //BA.debugLineNum = 11403265;BA.debugLine="Dim cx = pnlColors.Width / 2, cy = pnlColors.Heig";
_cx = (float) (__ref._pnlcolors.getWidth()/(double)2);
_cy = (float) (__ref._pnlcolors.getHeight()/(double)2);
RDebugUtils.currentLine=11403266;
 //BA.debugLineNum = 11403266;BA.debugLine="If Sqrt(Power(x - cx, 2) + Power(y - cy, 2)) > pn";
if (__c.Sqrt(__c.Power(_x-_cx,2)+__c.Power(_y-_cy,2))>__ref._pnlcolors.getWidth()/(double)2) { 
if (true) return "";};
RDebugUtils.currentLine=11403267;
 //BA.debugLineNum = 11403267;BA.debugLine="ColorResult = cvsColors.Bitmap.GetPixel(X, Y)";
__ref._colorresult = __ref._cvscolors.getBitmap().GetPixel((int) (_x),(int) (_y));
RDebugUtils.currentLine=11403268;
 //BA.debugLineNum = 11403268;BA.debugLine="cvsOverlay.DrawColor(Colors.Transparent)";
__ref._cvsoverlay.DrawColor(__c.Colors.Transparent);
RDebugUtils.currentLine=11403269;
 //BA.debugLineNum = 11403269;BA.debugLine="cvsOverlay.DrawCircle(X, Y, 20dip, Colors.Black,";
__ref._cvsoverlay.DrawCircle(_x,_y,(float) (__c.DipToCurrent((int) (20))),__c.Colors.Black,__c.False,(float) (__c.DipToCurrent((int) (3))));
RDebugUtils.currentLine=11403270;
 //BA.debugLineNum = 11403270;BA.debugLine="pnlOverlay.Invalidate";
__ref._pnloverlay.Invalidate();
RDebugUtils.currentLine=11403271;
 //BA.debugLineNum = 11403271;BA.debugLine="End Sub";
return "";
}
}