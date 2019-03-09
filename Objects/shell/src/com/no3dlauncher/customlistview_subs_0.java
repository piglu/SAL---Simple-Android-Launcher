package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class customlistview_subs_0 {


public static RemoteObject  _add(RemoteObject __ref,RemoteObject _pnl,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Add (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,371);
if (RapidSub.canDelegate("add")) return __ref.runUserSub(false, "customlistview","add", __ref, _pnl, _value);
Debug.locals.put("Pnl", _pnl);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 371;BA.debugLine="Public Sub Add(Pnl As B4XView, Value As Object)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 372;BA.debugLine="InsertAt(items.Size, Pnl, Value)";
Debug.ShouldStop(524288);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_insertat",(Object)(__ref.getField(false,"_items").runMethod(true,"getSize")),(Object)(_pnl),(Object)(_value));
 BA.debugLineNum = 373;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _addtextitem(RemoteObject __ref,RemoteObject _text,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("AddTextItem (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,182);
if (RapidSub.canDelegate("addtextitem")) return __ref.runUserSub(false, "customlistview","addtextitem", __ref, _text, _value);
Debug.locals.put("Text", _text);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 182;BA.debugLine="Public Sub AddTextItem(Text As Object, Value As Ob";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 183;BA.debugLine="InsertAtTextItem(items.Size, Text, Value)";
Debug.ShouldStop(4194304);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_insertattextitem",(Object)(__ref.getField(false,"_items").runMethod(true,"getSize")),(Object)(_text),(Object)(_value));
 BA.debugLineNum = 184;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _asview(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("AsView (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,124);
if (RapidSub.canDelegate("asview")) return __ref.runUserSub(false, "customlistview","asview", __ref);
 BA.debugLineNum = 124;BA.debugLine="Public Sub AsView As B4XView";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="Return mBase";
Debug.ShouldStop(268435456);
if (true) return __ref.getField(false,"_mbase");
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _base_resize(RemoteObject __ref,RemoteObject _width,RemoteObject _height) throws Exception{
try {
		Debug.PushSubsStack("Base_Resize (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,100);
if (RapidSub.canDelegate("base_resize")) return __ref.runUserSub(false, "customlistview","base_resize", __ref, _width, _height);
RemoteObject _scrollbar = RemoteObject.createImmutable(0);
RemoteObject _it = RemoteObject.declareNull("com.no3dlauncher.customlistview._clvitem");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
Debug.locals.put("Width", _width);
Debug.locals.put("Height", _height);
 BA.debugLineNum = 100;BA.debugLine="Public Sub Base_Resize (Width As Double, Height As";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="sv.SetLayoutAnimated(0, 0, 0, Width, Height)";
Debug.ShouldStop(16);
__ref.getField(false,"_sv").runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, _width)),(Object)(BA.numberCast(int.class, _height)));
 BA.debugLineNum = 102;BA.debugLine="Dim scrollbar As Int";
Debug.ShouldStop(32);
_scrollbar = RemoteObject.createImmutable(0);Debug.locals.put("scrollbar", _scrollbar);
 BA.debugLineNum = 103;BA.debugLine="If xui.IsB4J And ScrollBarsVisible Then scrollbar";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(".",__ref.getField(false,"_xui").runMethod(true,"getIsB4J")) && RemoteObject.solveBoolean(".",__ref.getField(true,"_scrollbarsvisible"))) { 
_scrollbar = BA.numberCast(int.class, 20);Debug.locals.put("scrollbar", _scrollbar);};
 BA.debugLineNum = 104;BA.debugLine="If horizontal Then";
Debug.ShouldStop(128);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 105;BA.debugLine="sv.ScrollViewContentHeight = Height - scrollbar";
Debug.ShouldStop(256);
__ref.getField(false,"_sv").runMethod(true,"setScrollViewContentHeight",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_height,_scrollbar}, "-",1, 0)));
 BA.debugLineNum = 106;BA.debugLine="For Each it As CLVItem In items";
Debug.ShouldStop(512);
{
final RemoteObject group6 = __ref.getField(false,"_items");
final int groupLen6 = group6.runMethod(true,"getSize").<Integer>get()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_it = (group6.runMethod(false,"Get",index6));Debug.locals.put("it", _it);
Debug.locals.put("it", _it);
 BA.debugLineNum = 107;BA.debugLine="it.Panel.Height = sv.ScrollViewContentHeight";
Debug.ShouldStop(1024);
_it.getField(false,"Panel").runMethod(true,"setHeight",__ref.getField(false,"_sv").runMethod(true,"getScrollViewContentHeight"));
 BA.debugLineNum = 108;BA.debugLine="it.Panel.GetView(0).Height = it.Panel.Height";
Debug.ShouldStop(2048);
_it.getField(false,"Panel").runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).runMethod(true,"setHeight",_it.getField(false,"Panel").runMethod(true,"getHeight"));
 }
}Debug.locals.put("it", _it);
;
 }else {
 BA.debugLineNum = 111;BA.debugLine="sv.ScrollViewContentWidth = Width - scrollbar";
Debug.ShouldStop(16384);
__ref.getField(false,"_sv").runMethod(true,"setScrollViewContentWidth",BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_width,_scrollbar}, "-",1, 0)));
 BA.debugLineNum = 112;BA.debugLine="For Each it As CLVItem In items";
Debug.ShouldStop(32768);
{
final RemoteObject group12 = __ref.getField(false,"_items");
final int groupLen12 = group12.runMethod(true,"getSize").<Integer>get()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_it = (group12.runMethod(false,"Get",index12));Debug.locals.put("it", _it);
Debug.locals.put("it", _it);
 BA.debugLineNum = 113;BA.debugLine="it.Panel.Width = sv.ScrollViewContentWidth";
Debug.ShouldStop(65536);
_it.getField(false,"Panel").runMethod(true,"setWidth",__ref.getField(false,"_sv").runMethod(true,"getScrollViewContentWidth"));
 BA.debugLineNum = 114;BA.debugLine="it.Panel.GetView(0).Width = it.Panel.Width";
Debug.ShouldStop(131072);
_it.getField(false,"Panel").runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).runMethod(true,"setWidth",_it.getField(false,"Panel").runMethod(true,"getWidth"));
 BA.debugLineNum = 115;BA.debugLine="If it.TextItem Then";
Debug.ShouldStop(262144);
if (_it.getField(true,"TextItem").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 116;BA.debugLine="Dim lbl As B4XView = it.Panel.GetView(0).GetVi";
Debug.ShouldStop(524288);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_lbl = _it.getField(false,"Panel").runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0))).runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0)));Debug.locals.put("lbl", _lbl);Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 117;BA.debugLine="lbl.SetLayoutAnimated(0, lbl.Left, lbl.Top, it";
Debug.ShouldStop(1048576);
_lbl.runVoidMethod ("SetLayoutAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(_lbl.runMethod(true,"getLeft")),(Object)(_lbl.runMethod(true,"getTop")),(Object)(RemoteObject.solve(new RemoteObject[] {_it.getField(false,"Panel").runMethod(true,"getWidth"),_lbl.runMethod(true,"getLeft")}, "-",1, 1)),(Object)(_lbl.runMethod(true,"getHeight")));
 };
 }
}Debug.locals.put("it", _it);
;
 };
 BA.debugLineNum = 121;BA.debugLine="If items.Size > 0 Then UpdateVisibleRange";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean(">",__ref.getField(false,"_items").runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_updatevisiblerange");};
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 14;BA.debugLine="Private mBase As B4XView";
customlistview._mbase = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_mbase",customlistview._mbase);
 //BA.debugLineNum = 15;BA.debugLine="Public sv As B4XView";
customlistview._sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_sv",customlistview._sv);
 //BA.debugLineNum = 16;BA.debugLine="Type CLVItem(Panel As B4XView, Size As Int, Value";
;
 //BA.debugLineNum = 18;BA.debugLine="Private items As List";
customlistview._items = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");__ref.setField("_items",customlistview._items);
 //BA.debugLineNum = 19;BA.debugLine="Private mDividerSize As Float";
customlistview._mdividersize = RemoteObject.createImmutable(0f);__ref.setField("_mdividersize",customlistview._mdividersize);
 //BA.debugLineNum = 20;BA.debugLine="Private EventName As String";
customlistview._eventname = RemoteObject.createImmutable("");__ref.setField("_eventname",customlistview._eventname);
 //BA.debugLineNum = 21;BA.debugLine="Private CallBack As Object";
customlistview._callback = RemoteObject.createNew ("Object");__ref.setField("_callback",customlistview._callback);
 //BA.debugLineNum = 22;BA.debugLine="Public DefaultTextColor As Int";
customlistview._defaulttextcolor = RemoteObject.createImmutable(0);__ref.setField("_defaulttextcolor",customlistview._defaulttextcolor);
 //BA.debugLineNum = 23;BA.debugLine="Public DefaultTextBackgroundColor As Int";
customlistview._defaulttextbackgroundcolor = RemoteObject.createImmutable(0);__ref.setField("_defaulttextbackgroundcolor",customlistview._defaulttextbackgroundcolor);
 //BA.debugLineNum = 24;BA.debugLine="Public AnimationDuration As Int = 300";
customlistview._animationduration = BA.numberCast(int.class, 300);__ref.setField("_animationduration",customlistview._animationduration);
 //BA.debugLineNum = 25;BA.debugLine="Private LastReachEndEvent As Long";
customlistview._lastreachendevent = RemoteObject.createImmutable(0L);__ref.setField("_lastreachendevent",customlistview._lastreachendevent);
 //BA.debugLineNum = 26;BA.debugLine="Private PressedColor As Int";
customlistview._pressedcolor = RemoteObject.createImmutable(0);__ref.setField("_pressedcolor",customlistview._pressedcolor);
 //BA.debugLineNum = 27;BA.debugLine="Private xui As XUI";
customlistview._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");__ref.setField("_xui",customlistview._xui);
 //BA.debugLineNum = 28;BA.debugLine="Private DesignerLabel As Label";
customlistview._designerlabel = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");__ref.setField("_designerlabel",customlistview._designerlabel);
 //BA.debugLineNum = 29;BA.debugLine="Private horizontal As Boolean";
customlistview._horizontal = RemoteObject.createImmutable(false);__ref.setField("_horizontal",customlistview._horizontal);
 //BA.debugLineNum = 33;BA.debugLine="Private su As StringUtils";
customlistview._su = RemoteObject.createNew ("anywheresoftware.b4a.objects.StringUtils");__ref.setField("_su",customlistview._su);
 //BA.debugLineNum = 37;BA.debugLine="Private mFirstVisibleIndex, mLastVisibleIndex As";
customlistview._mfirstvisibleindex = RemoteObject.createImmutable(0);__ref.setField("_mfirstvisibleindex",customlistview._mfirstvisibleindex);
customlistview._mlastvisibleindex = RemoteObject.createImmutable(0);__ref.setField("_mlastvisibleindex",customlistview._mlastvisibleindex);
 //BA.debugLineNum = 38;BA.debugLine="Private MonitorVisibleRange As Boolean";
customlistview._monitorvisiblerange = RemoteObject.createImmutable(false);__ref.setField("_monitorvisiblerange",customlistview._monitorvisiblerange);
 //BA.debugLineNum = 39;BA.debugLine="Private FireScrollChanged As Boolean";
customlistview._firescrollchanged = RemoteObject.createImmutable(false);__ref.setField("_firescrollchanged",customlistview._firescrollchanged);
 //BA.debugLineNum = 40;BA.debugLine="Private ScrollBarsVisible As Boolean";
customlistview._scrollbarsvisible = RemoteObject.createImmutable(false);__ref.setField("_scrollbarsvisible",customlistview._scrollbarsvisible);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _clear(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Clear (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,129);
if (RapidSub.canDelegate("clear")) return __ref.runUserSub(false, "customlistview","clear", __ref);
 BA.debugLineNum = 129;BA.debugLine="Public Sub Clear";
Debug.ShouldStop(1);
 BA.debugLineNum = 130;BA.debugLine="items.Clear";
Debug.ShouldStop(2);
__ref.getField(false,"_items").runVoidMethod ("Clear");
 BA.debugLineNum = 131;BA.debugLine="sv.ScrollViewInnerPanel.RemoveAllViews";
Debug.ShouldStop(4);
__ref.getField(false,"_sv").runMethod(false,"getScrollViewInnerPanel").runVoidMethod ("RemoveAllViews");
 BA.debugLineNum = 132;BA.debugLine="SetScrollViewContentSize(0)";
Debug.ShouldStop(8);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_setscrollviewcontentsize",(Object)(BA.numberCast(float.class, 0)));
 BA.debugLineNum = 133;BA.debugLine="ResetVisibles";
Debug.ShouldStop(16);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_resetvisibles");
 BA.debugLineNum = 134;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createlabel(RemoteObject __ref,RemoteObject _txt) throws Exception{
try {
		Debug.PushSubsStack("CreateLabel (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,524);
if (RapidSub.canDelegate("createlabel")) return __ref.runUserSub(false, "customlistview","createlabel", __ref, _txt);
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
Debug.locals.put("txt", _txt);
 BA.debugLineNum = 524;BA.debugLine="Private Sub CreateLabel(txt As Object) As B4XView";
Debug.ShouldStop(2048);
 BA.debugLineNum = 525;BA.debugLine="Dim lbl As Label";
Debug.ShouldStop(4096);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 526;BA.debugLine="lbl.Initialize(\"\")";
Debug.ShouldStop(8192);
_lbl.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 527;BA.debugLine="lbl.Gravity = DesignerLabel.Gravity";
Debug.ShouldStop(16384);
_lbl.runMethod(true,"setGravity",__ref.getField(false,"_designerlabel").runMethod(true,"getGravity"));
 BA.debugLineNum = 528;BA.debugLine="lbl.TextSize = DesignerLabel.TextSize";
Debug.ShouldStop(32768);
_lbl.runMethod(true,"setTextSize",__ref.getField(false,"_designerlabel").runMethod(true,"getTextSize"));
 BA.debugLineNum = 529;BA.debugLine="lbl.SingleLine = False";
Debug.ShouldStop(65536);
_lbl.runVoidMethod ("setSingleLine",customlistview.__c.getField(true,"False"));
 BA.debugLineNum = 530;BA.debugLine="lbl.Text = txt";
Debug.ShouldStop(131072);
_lbl.runMethod(true,"setText",BA.ObjectToCharSequence(_txt));
 BA.debugLineNum = 531;BA.debugLine="lbl.Width = sv.ScrollViewContentWidth - 10dip";
Debug.ShouldStop(262144);
_lbl.runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv").runMethod(true,"getScrollViewContentWidth"),customlistview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1));
 BA.debugLineNum = 532;BA.debugLine="lbl.Height = su.MeasureMultilineTextHeight(lbl, t";
Debug.ShouldStop(524288);
_lbl.runMethod(true,"setHeight",__ref.getField(false,"_su").runMethod(true,"MeasureMultilineTextHeight",(Object)((_lbl.getObject())),(Object)(BA.ObjectToCharSequence(_txt))));
 BA.debugLineNum = 533;BA.debugLine="Return lbl";
Debug.ShouldStop(1048576);
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _lbl.getObject());
 BA.debugLineNum = 534;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createpanel(RemoteObject __ref,RemoteObject _paneleventname) throws Exception{
try {
		Debug.PushSubsStack("CreatePanel (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,491);
if (RapidSub.canDelegate("createpanel")) return __ref.runUserSub(false, "customlistview","createpanel", __ref, _paneleventname);
Debug.locals.put("PanelEventName", _paneleventname);
 BA.debugLineNum = 491;BA.debugLine="Private Sub CreatePanel (PanelEventName As String)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 492;BA.debugLine="Return xui.CreatePanel(PanelEventName)";
Debug.ShouldStop(2048);
if (true) return __ref.getField(false,"_xui").runMethod(false,"CreatePanel",__ref.getField(false, "ba"),(Object)(_paneleventname));
 BA.debugLineNum = 493;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createscrollview(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CreateScrollView (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,504);
if (RapidSub.canDelegate("createscrollview")) return __ref.runUserSub(false, "customlistview","createscrollview", __ref);
RemoteObject _hv = RemoteObject.declareNull("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
RemoteObject _nsv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
 BA.debugLineNum = 504;BA.debugLine="Private Sub CreateScrollView As B4XView";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 505;BA.debugLine="If horizontal Then";
Debug.ShouldStop(16777216);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 506;BA.debugLine="Dim hv As HorizontalScrollView";
Debug.ShouldStop(33554432);
_hv = RemoteObject.createNew ("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");Debug.locals.put("hv", _hv);
 BA.debugLineNum = 507;BA.debugLine="hv.Initialize(0, \"sv\")";
Debug.ShouldStop(67108864);
_hv.runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.createImmutable("sv")));
 BA.debugLineNum = 508;BA.debugLine="Return hv";
Debug.ShouldStop(134217728);
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _hv.getObject());
 }else {
 BA.debugLineNum = 510;BA.debugLine="Dim nsv As ScrollView";
Debug.ShouldStop(536870912);
_nsv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");Debug.locals.put("nsv", _nsv);
 BA.debugLineNum = 511;BA.debugLine="nsv.Initialize2(0, \"sv\")";
Debug.ShouldStop(1073741824);
_nsv.runVoidMethod ("Initialize2",__ref.getField(false, "ba"),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.createImmutable("sv")));
 BA.debugLineNum = 512;BA.debugLine="Return nsv";
Debug.ShouldStop(-2147483648);
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), _nsv.getObject());
 };
 BA.debugLineNum = 514;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _designercreateview(RemoteObject __ref,RemoteObject _base,RemoteObject _lbl,RemoteObject _props) throws Exception{
try {
		Debug.PushSubsStack("DesignerCreateView (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,65);
if (RapidSub.canDelegate("designercreateview")) return __ref.runUserSub(false, "customlistview","designercreateview", __ref, _base, _lbl, _props);
RemoteObject _o = RemoteObject.createImmutable("");
RemoteObject _jsv = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("Base", _base);
Debug.locals.put("Lbl", _lbl);
Debug.locals.put("Props", _props);
 BA.debugLineNum = 65;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="mBase = Base";
Debug.ShouldStop(2);
__ref.getField(false,"_mbase").setObject (_base);
 BA.debugLineNum = 67;BA.debugLine="Dim o As String = Props.GetDefault(\"ListOrientati";
Debug.ShouldStop(4);
_o = BA.ObjectToString(_props.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("ListOrientation"))),(Object)((RemoteObject.createImmutable("Vertical")))));Debug.locals.put("o", _o);Debug.locals.put("o", _o);
 BA.debugLineNum = 68;BA.debugLine="horizontal = o = \"Horizontal\"";
Debug.ShouldStop(8);
__ref.setField ("_horizontal",BA.ObjectToBoolean(RemoteObject.solveBoolean("=",_o,BA.ObjectToString("Horizontal"))));
 BA.debugLineNum = 69;BA.debugLine="sv = CreateScrollView";
Debug.ShouldStop(16);
__ref.setField ("_sv",__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_createscrollview"));
 BA.debugLineNum = 70;BA.debugLine="mBase.AddView(sv, 0, 0, mBase.Width, mBase.Height";
Debug.ShouldStop(32);
__ref.getField(false,"_mbase").runVoidMethod ("AddView",(Object)((__ref.getField(false,"_sv").getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(__ref.getField(false,"_mbase").runMethod(true,"getWidth")),(Object)(__ref.getField(false,"_mbase").runMethod(true,"getHeight")));
 BA.debugLineNum = 71;BA.debugLine="sv.ScrollViewInnerPanel.Color = xui.PaintOrColorT";
Debug.ShouldStop(64);
__ref.getField(false,"_sv").runMethod(false,"getScrollViewInnerPanel").runMethod(true,"setColor",__ref.getField(false,"_xui").runMethod(true,"PaintOrColorToColor",(Object)(_props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("DividerColor")))))));
 BA.debugLineNum = 72;BA.debugLine="mDividerSize = DipToCurrent(Props.Get(\"DividerHei";
Debug.ShouldStop(128);
__ref.setField ("_mdividersize",BA.numberCast(float.class, customlistview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, _props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("DividerHeight")))))))));
 BA.debugLineNum = 73;BA.debugLine="PressedColor = xui.PaintOrColorToColor(Props.Get(";
Debug.ShouldStop(256);
__ref.setField ("_pressedcolor",__ref.getField(false,"_xui").runMethod(true,"PaintOrColorToColor",(Object)(_props.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("PressedColor")))))));
 BA.debugLineNum = 74;BA.debugLine="AnimationDuration = Props.GetDefault(\"InsertAnima";
Debug.ShouldStop(512);
__ref.setField ("_animationduration",BA.numberCast(int.class, _props.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("InsertAnimationDuration"))),(Object)((__ref.getField(true,"_animationduration"))))));
 BA.debugLineNum = 75;BA.debugLine="ScrollBarsVisible = Props.GetDefault(\"ShowScrollB";
Debug.ShouldStop(1024);
__ref.setField ("_scrollbarsvisible",BA.ObjectToBoolean(_props.runMethod(false,"GetDefault",(Object)(RemoteObject.createImmutable(("ShowScrollBar"))),(Object)((customlistview.__c.getField(true,"True"))))));
 BA.debugLineNum = 76;BA.debugLine="If ScrollBarsVisible = False Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_scrollbarsvisible"),customlistview.__c.getField(true,"False"))) { 
 BA.debugLineNum = 82;BA.debugLine="Dim jsv As JavaObject = sv";
Debug.ShouldStop(131072);
_jsv = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_jsv.setObject(__ref.getField(false,"_sv").getObject());Debug.locals.put("jsv", _jsv);
 BA.debugLineNum = 83;BA.debugLine="If horizontal Then";
Debug.ShouldStop(262144);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 84;BA.debugLine="jsv.RunMethod(\"setHorizontalScrollBarEnabled\",";
Debug.ShouldStop(524288);
_jsv.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setHorizontalScrollBarEnabled")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(customlistview.__c.getField(true,"False"))})));
 }else {
 BA.debugLineNum = 86;BA.debugLine="jsv.RunMethod(\"setVerticalScrollBarEnabled\", Ar";
Debug.ShouldStop(2097152);
_jsv.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setVerticalScrollBarEnabled")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(customlistview.__c.getField(true,"False"))})));
 };
 };
 BA.debugLineNum = 94;BA.debugLine="DefaultTextColor = xui.PaintOrColorToColor(Lbl.Te";
Debug.ShouldStop(536870912);
__ref.setField ("_defaulttextcolor",__ref.getField(false,"_xui").runMethod(true,"PaintOrColorToColor",(Object)((_lbl.runMethod(true,"getTextColor")))));
 BA.debugLineNum = 95;BA.debugLine="DefaultTextBackgroundColor = mBase.Color";
Debug.ShouldStop(1073741824);
__ref.setField ("_defaulttextbackgroundcolor",__ref.getField(false,"_mbase").runMethod(true,"getColor"));
 BA.debugLineNum = 96;BA.debugLine="DesignerLabel = Lbl";
Debug.ShouldStop(-2147483648);
__ref.setField ("_designerlabel",_lbl);
 BA.debugLineNum = 97;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
Debug.ShouldStop(1);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_base_resize",(Object)(BA.numberCast(double.class, __ref.getField(false,"_mbase").runMethod(true,"getWidth"))),(Object)(BA.numberCast(double.class, __ref.getField(false,"_mbase").runMethod(true,"getHeight"))));
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _findindexfromoffset(RemoteObject __ref,RemoteObject _offset) throws Exception{
try {
		Debug.PushSubsStack("FindIndexFromOffset (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,413);
if (RapidSub.canDelegate("findindexfromoffset")) return __ref.runUserSub(false, "customlistview","findindexfromoffset", __ref, _offset);
RemoteObject _position = RemoteObject.createImmutable(0);
RemoteObject _stepsize = RemoteObject.createImmutable(0);
RemoteObject _currentitem = RemoteObject.declareNull("com.no3dlauncher.customlistview._clvitem");
RemoteObject _nextoffset = RemoteObject.createImmutable(0);
RemoteObject _prevoffset = RemoteObject.createImmutable(0);
Debug.locals.put("Offset", _offset);
 BA.debugLineNum = 413;BA.debugLine="Public Sub FindIndexFromOffset(Offset As Int) As I";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 415;BA.debugLine="Dim Position As Int = items.Size / 2";
Debug.ShouldStop(1073741824);
_position = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_items").runMethod(true,"getSize"),RemoteObject.createImmutable(2)}, "/",0, 0));Debug.locals.put("Position", _position);Debug.locals.put("Position", _position);
 BA.debugLineNum = 416;BA.debugLine="Dim StepSize As Int = Ceil(Position / 2)";
Debug.ShouldStop(-2147483648);
_stepsize = BA.numberCast(int.class, customlistview.__c.runMethod(true,"Ceil",(Object)(RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(2)}, "/",0, 0))));Debug.locals.put("StepSize", _stepsize);Debug.locals.put("StepSize", _stepsize);
 BA.debugLineNum = 417;BA.debugLine="Do While True";
Debug.ShouldStop(1);
while (customlistview.__c.getField(true,"True").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 418;BA.debugLine="Dim CurrentItem As CLVItem = items.Get(Position)";
Debug.ShouldStop(2);
_currentitem = (__ref.getField(false,"_items").runMethod(false,"Get",(Object)(_position)));Debug.locals.put("CurrentItem", _currentitem);Debug.locals.put("CurrentItem", _currentitem);
 BA.debugLineNum = 419;BA.debugLine="Dim NextOffset As Int";
Debug.ShouldStop(4);
_nextoffset = RemoteObject.createImmutable(0);Debug.locals.put("NextOffset", _nextoffset);
 BA.debugLineNum = 420;BA.debugLine="If Position < items.Size - 1 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("<",_position,BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_items").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))) { 
 BA.debugLineNum = 421;BA.debugLine="NextOffset = GetRawListItem(Position + 1).Offse";
Debug.ShouldStop(16);
_nextoffset = RemoteObject.solve(new RemoteObject[] {__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getrawlistitem",(Object)(RemoteObject.solve(new RemoteObject[] {_position,RemoteObject.createImmutable(1)}, "+",1, 1))).getField(true,"Offset"),RemoteObject.createImmutable(1)}, "-",1, 1);Debug.locals.put("NextOffset", _nextoffset);
 }else {
 BA.debugLineNum = 423;BA.debugLine="NextOffset = 0x7FFFFFFF";
Debug.ShouldStop(64);
_nextoffset = BA.numberCast(int.class, 0x7fffffff);Debug.locals.put("NextOffset", _nextoffset);
 };
 BA.debugLineNum = 425;BA.debugLine="Dim PrevOffset As Int";
Debug.ShouldStop(256);
_prevoffset = RemoteObject.createImmutable(0);Debug.locals.put("PrevOffset", _prevoffset);
 BA.debugLineNum = 426;BA.debugLine="If Position = 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_position,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 427;BA.debugLine="PrevOffset = 0x80000000";
Debug.ShouldStop(1024);
_prevoffset = BA.numberCast(int.class, 0x80000000);Debug.locals.put("PrevOffset", _prevoffset);
 }else {
 BA.debugLineNum = 429;BA.debugLine="PrevOffset = CurrentItem.Offset";
Debug.ShouldStop(4096);
_prevoffset = _currentitem.getField(true,"Offset");Debug.locals.put("PrevOffset", _prevoffset);
 };
 BA.debugLineNum = 431;BA.debugLine="If Offset > NextOffset Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean(">",_offset,BA.numberCast(double.class, _nextoffset))) { 
 BA.debugLineNum = 432;BA.debugLine="Position = Min(Position + StepSize, items.Size";
Debug.ShouldStop(32768);
_position = BA.numberCast(int.class, customlistview.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_position,_stepsize}, "+",1, 1))),(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_items").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1)))));Debug.locals.put("Position", _position);
 }else 
{ BA.debugLineNum = 433;BA.debugLine="Else if Offset < PrevOffset Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("<",_offset,BA.numberCast(double.class, _prevoffset))) { 
 BA.debugLineNum = 434;BA.debugLine="Position = Max(Position - StepSize, 0)";
Debug.ShouldStop(131072);
_position = BA.numberCast(int.class, customlistview.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {_position,_stepsize}, "-",1, 1))),(Object)(BA.numberCast(double.class, 0))));Debug.locals.put("Position", _position);
 }else {
 BA.debugLineNum = 436;BA.debugLine="Return Position";
Debug.ShouldStop(524288);
if (true) return _position;
 }}
;
 BA.debugLineNum = 438;BA.debugLine="StepSize = Ceil(StepSize / 2)";
Debug.ShouldStop(2097152);
_stepsize = BA.numberCast(int.class, customlistview.__c.runMethod(true,"Ceil",(Object)(RemoteObject.solve(new RemoteObject[] {_stepsize,RemoteObject.createImmutable(2)}, "/",0, 0))));Debug.locals.put("StepSize", _stepsize);
 }
;
 BA.debugLineNum = 440;BA.debugLine="Return -1";
Debug.ShouldStop(8388608);
if (true) return BA.numberCast(int.class, -(double) (0 + 1));
 BA.debugLineNum = 441;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _finditemoffset(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("FindItemOffset (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,408);
if (RapidSub.canDelegate("finditemoffset")) return __ref.runUserSub(false, "customlistview","finditemoffset", __ref, _index);
Debug.locals.put("Index", _index);
 BA.debugLineNum = 408;BA.debugLine="Private Sub FindItemOffset(Index As Int) As Int";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 409;BA.debugLine="Return GetRawListItem(Index).Offset";
Debug.ShouldStop(16777216);
if (true) return __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getrawlistitem",(Object)(_index)).getField(true,"Offset");
 BA.debugLineNum = 410;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getbase(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetBase (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,136);
if (RapidSub.canDelegate("getbase")) return __ref.runUserSub(false, "customlistview","getbase", __ref);
 BA.debugLineNum = 136;BA.debugLine="Public Sub GetBase As B4XView";
Debug.ShouldStop(128);
 BA.debugLineNum = 137;BA.debugLine="Return mBase";
Debug.ShouldStop(256);
if (true) return __ref.getField(false,"_mbase");
 BA.debugLineNum = 138;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdividersize(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getDividerSize (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,495);
if (RapidSub.canDelegate("getdividersize")) return __ref.runUserSub(false, "customlistview","getdividersize", __ref);
 BA.debugLineNum = 495;BA.debugLine="Public Sub getDividerSize As Float";
Debug.ShouldStop(16384);
 BA.debugLineNum = 496;BA.debugLine="Return mDividerSize";
Debug.ShouldStop(32768);
if (true) return __ref.getField(true,"_mdividersize");
 BA.debugLineNum = 497;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getfirstvisibleindex(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getFirstVisibleIndex (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,444);
if (RapidSub.canDelegate("getfirstvisibleindex")) return __ref.runUserSub(false, "customlistview","getfirstvisibleindex", __ref);
 BA.debugLineNum = 444;BA.debugLine="Public Sub getFirstVisibleIndex As Int";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 445;BA.debugLine="Return FindIndexFromOffset(GetScrollViewOffset +";
Debug.ShouldStop(268435456);
if (true) return __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_findindexfromoffset",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewoffset"),__ref.getField(true,"_mdividersize")}, "+",1, 0))));
 BA.debugLineNum = 446;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getitemfromview(RemoteObject __ref,RemoteObject _v) throws Exception{
try {
		Debug.PushSubsStack("GetItemFromView (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,464);
if (RapidSub.canDelegate("getitemfromview")) return __ref.runUserSub(false, "customlistview","getitemfromview", __ref, _v);
RemoteObject _parent = RemoteObject.declareNull("Object");
RemoteObject _current = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
Debug.locals.put("v", _v);
 BA.debugLineNum = 464;BA.debugLine="Public Sub GetItemFromView(v As B4XView) As Int";
Debug.ShouldStop(32768);
 BA.debugLineNum = 465;BA.debugLine="Dim parent = v As Object, current As B4XView";
Debug.ShouldStop(65536);
_parent = (_v.getObject());Debug.locals.put("parent", _parent);Debug.locals.put("parent", _parent);
_current = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");Debug.locals.put("current", _current);
 BA.debugLineNum = 466;BA.debugLine="Do While sv.ScrollViewInnerPanel <> parent";
Debug.ShouldStop(131072);
while (RemoteObject.solveBoolean("!",__ref.getField(false,"_sv").runMethod(false,"getScrollViewInnerPanel"),_parent)) {
 BA.debugLineNum = 467;BA.debugLine="current = parent";
Debug.ShouldStop(262144);
_current.setObject(_parent);
 BA.debugLineNum = 468;BA.debugLine="parent = current.Parent";
Debug.ShouldStop(524288);
_parent = (_current.runMethod(false,"getParent").getObject());Debug.locals.put("parent", _parent);
 }
;
 BA.debugLineNum = 470;BA.debugLine="v = current";
Debug.ShouldStop(2097152);
_v = _current;Debug.locals.put("v", _v);
 BA.debugLineNum = 471;BA.debugLine="Return v.Tag";
Debug.ShouldStop(4194304);
if (true) return BA.numberCast(int.class, _v.runMethod(false,"getTag"));
 BA.debugLineNum = 472;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getlastvisibleindex(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getLastVisibleIndex (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,449);
if (RapidSub.canDelegate("getlastvisibleindex")) return __ref.runUserSub(false, "customlistview","getlastvisibleindex", __ref);
 BA.debugLineNum = 449;BA.debugLine="Public Sub getLastVisibleIndex As Int";
Debug.ShouldStop(1);
 BA.debugLineNum = 450;BA.debugLine="Return FindIndexFromOffset(GetScrollViewOffset +";
Debug.ShouldStop(2);
if (true) return __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_findindexfromoffset",(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewoffset"),__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewvisiblesize")}, "+",1, 0))));
 BA.debugLineNum = 451;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getmaxscrolloffset(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetMaxScrollOffset (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,380);
if (RapidSub.canDelegate("getmaxscrolloffset")) return __ref.runUserSub(false, "customlistview","getmaxscrolloffset", __ref);
 BA.debugLineNum = 380;BA.debugLine="Private Sub GetMaxScrollOffset As Float";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 381;BA.debugLine="Return GetScrollViewContentSize - GetScrollViewVi";
Debug.ShouldStop(268435456);
if (true) return BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewcontentsize"),__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewvisiblesize")}, "-",1, 0));
 BA.debugLineNum = 382;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getpanel(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("GetPanel (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,151);
if (RapidSub.canDelegate("getpanel")) return __ref.runUserSub(false, "customlistview","getpanel", __ref, _index);
Debug.locals.put("Index", _index);
 BA.debugLineNum = 151;BA.debugLine="Public Sub GetPanel(Index As Int) As B4XView";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="Return GetRawListItem(Index).Panel.GetView(0)";
Debug.ShouldStop(8388608);
if (true) return __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getrawlistitem",(Object)(_index)).getField(false,"Panel").runMethod(false,"GetView",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 153;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getrawlistitem(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("GetRawListItem (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,146);
if (RapidSub.canDelegate("getrawlistitem")) return __ref.runUserSub(false, "customlistview","getrawlistitem", __ref, _index);
Debug.locals.put("Index", _index);
 BA.debugLineNum = 146;BA.debugLine="Public Sub GetRawListItem(Index As Int) As CLVItem";
Debug.ShouldStop(131072);
 BA.debugLineNum = 147;BA.debugLine="Return items.Get(Index)";
Debug.ShouldStop(262144);
if (true) return (__ref.getField(false,"_items").runMethod(false,"Get",(Object)(_index)));
 BA.debugLineNum = 148;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscrollviewcontentsize(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetScrollViewContentSize (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,324);
if (RapidSub.canDelegate("getscrollviewcontentsize")) return __ref.runUserSub(false, "customlistview","getscrollviewcontentsize", __ref);
 BA.debugLineNum = 324;BA.debugLine="Private Sub GetScrollViewContentSize As Float";
Debug.ShouldStop(8);
 BA.debugLineNum = 325;BA.debugLine="If horizontal Then";
Debug.ShouldStop(16);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 326;BA.debugLine="Return sv.ScrollViewContentWidth";
Debug.ShouldStop(32);
if (true) return BA.numberCast(float.class, __ref.getField(false,"_sv").runMethod(true,"getScrollViewContentWidth"));
 }else {
 BA.debugLineNum = 328;BA.debugLine="Return sv.ScrollViewContentHeight";
Debug.ShouldStop(128);
if (true) return BA.numberCast(float.class, __ref.getField(false,"_sv").runMethod(true,"getScrollViewContentHeight"));
 };
 BA.debugLineNum = 330;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscrollviewoffset(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetScrollViewOffset (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,308);
if (RapidSub.canDelegate("getscrollviewoffset")) return __ref.runUserSub(false, "customlistview","getscrollviewoffset", __ref);
 BA.debugLineNum = 308;BA.debugLine="Private Sub GetScrollViewOffset As Float";
Debug.ShouldStop(524288);
 BA.debugLineNum = 309;BA.debugLine="If horizontal Then";
Debug.ShouldStop(1048576);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 310;BA.debugLine="Return sv.ScrollViewOffsetX";
Debug.ShouldStop(2097152);
if (true) return BA.numberCast(float.class, __ref.getField(false,"_sv").runMethod(true,"getScrollViewOffsetX"));
 }else {
 BA.debugLineNum = 312;BA.debugLine="Return sv.ScrollViewOffsetY";
Debug.ShouldStop(8388608);
if (true) return BA.numberCast(float.class, __ref.getField(false,"_sv").runMethod(true,"getScrollViewOffsetY"));
 };
 BA.debugLineNum = 314;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getscrollviewvisiblesize(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("GetScrollViewVisibleSize (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,300);
if (RapidSub.canDelegate("getscrollviewvisiblesize")) return __ref.runUserSub(false, "customlistview","getscrollviewvisiblesize", __ref);
 BA.debugLineNum = 300;BA.debugLine="Private Sub GetScrollViewVisibleSize As Float";
Debug.ShouldStop(2048);
 BA.debugLineNum = 301;BA.debugLine="If horizontal Then";
Debug.ShouldStop(4096);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 302;BA.debugLine="Return sv.Width";
Debug.ShouldStop(8192);
if (true) return BA.numberCast(float.class, __ref.getField(false,"_sv").runMethod(true,"getWidth"));
 }else {
 BA.debugLineNum = 304;BA.debugLine="Return sv.Height";
Debug.ShouldStop(32768);
if (true) return BA.numberCast(float.class, __ref.getField(false,"_sv").runMethod(true,"getHeight"));
 };
 BA.debugLineNum = 306;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable(0f);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getsize(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("getSize (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,141);
if (RapidSub.canDelegate("getsize")) return __ref.runUserSub(false, "customlistview","getsize", __ref);
 BA.debugLineNum = 141;BA.debugLine="Public Sub getSize As Int";
Debug.ShouldStop(4096);
 BA.debugLineNum = 142;BA.debugLine="Return items.Size";
Debug.ShouldStop(8192);
if (true) return __ref.getField(false,"_items").runMethod(true,"getSize");
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getvalue(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("GetValue (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,156);
if (RapidSub.canDelegate("getvalue")) return __ref.runUserSub(false, "customlistview","getvalue", __ref, _index);
Debug.locals.put("Index", _index);
 BA.debugLineNum = 156;BA.debugLine="Public Sub GetValue(Index As Int) As Object";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="Return GetRawListItem(Index).Value";
Debug.ShouldStop(268435456);
if (true) return __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getrawlistitem",(Object)(_index)).getField(false,"Value");
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _vcallback,RemoteObject _veventname) throws Exception{
try {
		Debug.PushSubsStack("Initialize (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,43);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "customlistview","initialize", __ref, _ba, _vcallback, _veventname);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("vCallBack", _vcallback);
Debug.locals.put("vEventName", _veventname);
 BA.debugLineNum = 43;BA.debugLine="Public Sub Initialize (vCallBack As Object, vEvent";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="EventName = vEventName";
Debug.ShouldStop(2048);
__ref.setField ("_eventname",_veventname);
 BA.debugLineNum = 45;BA.debugLine="CallBack = vCallBack";
Debug.ShouldStop(4096);
__ref.setField ("_callback",_vcallback);
 BA.debugLineNum = 46;BA.debugLine="items.Initialize";
Debug.ShouldStop(8192);
__ref.getField(false,"_items").runVoidMethod ("Initialize");
 BA.debugLineNum = 47;BA.debugLine="DefaultTextBackgroundColor = xui.Color_White";
Debug.ShouldStop(16384);
__ref.setField ("_defaulttextbackgroundcolor",__ref.getField(false,"_xui").getField(true,"Color_White"));
 BA.debugLineNum = 48;BA.debugLine="DefaultTextColor = xui.Color_Black";
Debug.ShouldStop(32768);
__ref.setField ("_defaulttextcolor",__ref.getField(false,"_xui").getField(true,"Color_Black"));
 BA.debugLineNum = 49;BA.debugLine="MonitorVisibleRange = xui.SubExists(CallBack, Eve";
Debug.ShouldStop(65536);
__ref.setField ("_monitorvisiblerange",__ref.getField(false,"_xui").runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_eventname"),RemoteObject.createImmutable("_VisibleRangeChanged"))),(Object)(BA.numberCast(int.class, 2))));
 BA.debugLineNum = 50;BA.debugLine="FireScrollChanged = xui.SubExists(CallBack, Event";
Debug.ShouldStop(131072);
__ref.setField ("_firescrollchanged",__ref.getField(false,"_xui").runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_eventname"),RemoteObject.createImmutable("_ScrollChanged"))),(Object)(BA.numberCast(int.class, 1))));
 BA.debugLineNum = 51;BA.debugLine="ResetVisibles";
Debug.ShouldStop(262144);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_resetvisibles");
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertat(RemoteObject __ref,RemoteObject _index,RemoteObject _pnl,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("InsertAt (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,205);
if (RapidSub.canDelegate("insertat")) return __ref.runUserSub(false, "customlistview","insertat", __ref, _index, _pnl, _value);
RemoteObject _size = RemoteObject.createImmutable(0f);
Debug.locals.put("Index", _index);
Debug.locals.put("pnl", _pnl);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 205;BA.debugLine="Public Sub InsertAt(Index As Int, pnl As B4XView,";
Debug.ShouldStop(4096);
 BA.debugLineNum = 206;BA.debugLine="Dim size As Float";
Debug.ShouldStop(8192);
_size = RemoteObject.createImmutable(0f);Debug.locals.put("size", _size);
 BA.debugLineNum = 207;BA.debugLine="If horizontal Then";
Debug.ShouldStop(16384);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 208;BA.debugLine="size = pnl.Width";
Debug.ShouldStop(32768);
_size = BA.numberCast(float.class, _pnl.runMethod(true,"getWidth"));Debug.locals.put("size", _size);
 }else {
 BA.debugLineNum = 210;BA.debugLine="size = pnl.Height";
Debug.ShouldStop(131072);
_size = BA.numberCast(float.class, _pnl.runMethod(true,"getHeight"));Debug.locals.put("size", _size);
 };
 BA.debugLineNum = 212;BA.debugLine="InsertAtImpl(Index, pnl, size, Value, 0)";
Debug.ShouldStop(524288);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_insertatimpl",(Object)(_index),(Object)(_pnl),(Object)(BA.numberCast(int.class, _size)),(Object)(_value),(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 213;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertatimpl(RemoteObject __ref,RemoteObject _index,RemoteObject _pnl,RemoteObject _itemsize,RemoteObject _value,RemoteObject _initialsize) throws Exception{
try {
		Debug.PushSubsStack("InsertAtImpl (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,216);
if (RapidSub.canDelegate("insertatimpl")) return __ref.runUserSub(false, "customlistview","insertatimpl", __ref, _index, _pnl, _itemsize, _value, _initialsize);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _includedividierheight = RemoteObject.createImmutable(0);
RemoteObject _newitem = RemoteObject.declareNull("com.no3dlauncher.customlistview._clvitem");
RemoteObject _offset = RemoteObject.createImmutable(0);
RemoteObject _previtem = RemoteObject.declareNull("com.no3dlauncher.customlistview._clvitem");
int _i = 0;
RemoteObject _it = RemoteObject.declareNull("com.no3dlauncher.customlistview._clvitem");
RemoteObject _newoffset = RemoteObject.createImmutable(0);
Debug.locals.put("Index", _index);
Debug.locals.put("Pnl", _pnl);
Debug.locals.put("ItemSize", _itemsize);
Debug.locals.put("Value", _value);
Debug.locals.put("InitialSize", _initialsize);
 BA.debugLineNum = 216;BA.debugLine="Private Sub InsertAtImpl(Index As Int, Pnl As B4XV";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 218;BA.debugLine="Dim p As B4XView = CreatePanel(\"Panel\")";
Debug.ShouldStop(33554432);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_createpanel",(Object)(RemoteObject.createImmutable("Panel")));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 219;BA.debugLine="p.Color = Pnl.Color";
Debug.ShouldStop(67108864);
_p.runMethod(true,"setColor",_pnl.runMethod(true,"getColor"));
 BA.debugLineNum = 220;BA.debugLine="Pnl.Color = xui.Color_Transparent";
Debug.ShouldStop(134217728);
_pnl.runMethod(true,"setColor",__ref.getField(false,"_xui").getField(true,"Color_Transparent"));
 BA.debugLineNum = 221;BA.debugLine="If horizontal Then";
Debug.ShouldStop(268435456);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 222;BA.debugLine="p.AddView(Pnl, 0, 0, ItemSize, sv.ScrollViewCont";
Debug.ShouldStop(536870912);
_p.runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(_itemsize),(Object)(__ref.getField(false,"_sv").runMethod(true,"getScrollViewContentHeight")));
 }else {
 BA.debugLineNum = 224;BA.debugLine="p.AddView(Pnl, 0, 0, sv.ScrollViewContentWidth,";
Debug.ShouldStop(-2147483648);
_p.runVoidMethod ("AddView",(Object)((_pnl.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(__ref.getField(false,"_sv").runMethod(true,"getScrollViewContentWidth")),(Object)(_itemsize));
 };
 BA.debugLineNum = 226;BA.debugLine="p.Tag = Index";
Debug.ShouldStop(2);
_p.runMethod(false,"setTag",(_index));
 BA.debugLineNum = 227;BA.debugLine="Dim IncludeDividierHeight As Int";
Debug.ShouldStop(4);
_includedividierheight = RemoteObject.createImmutable(0);Debug.locals.put("IncludeDividierHeight", _includedividierheight);
 BA.debugLineNum = 228;BA.debugLine="If InitialSize = 0 Then IncludeDividierHeight = m";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_initialsize,BA.numberCast(double.class, 0))) { 
_includedividierheight = BA.numberCast(int.class, __ref.getField(true,"_mdividersize"));Debug.locals.put("IncludeDividierHeight", _includedividierheight);}
else {
_includedividierheight = BA.numberCast(int.class, 0);Debug.locals.put("IncludeDividierHeight", _includedividierheight);};
 BA.debugLineNum = 229;BA.debugLine="Dim NewItem As CLVItem";
Debug.ShouldStop(16);
_newitem = RemoteObject.createNew ("com.no3dlauncher.customlistview._clvitem");Debug.locals.put("NewItem", _newitem);
 BA.debugLineNum = 230;BA.debugLine="NewItem.Panel = p";
Debug.ShouldStop(32);
_newitem.setField ("Panel",_p);
 BA.debugLineNum = 231;BA.debugLine="NewItem.Size = ItemSize";
Debug.ShouldStop(64);
_newitem.setField ("Size",_itemsize);
 BA.debugLineNum = 232;BA.debugLine="NewItem.Value = Value";
Debug.ShouldStop(128);
_newitem.setField ("Value",_value);
 BA.debugLineNum = 233;BA.debugLine="NewItem.Color = p.Color";
Debug.ShouldStop(256);
_newitem.setField ("Color",_p.runMethod(true,"getColor"));
 BA.debugLineNum = 234;BA.debugLine="If Index = items.Size And InitialSize = 0 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_index,BA.numberCast(double.class, __ref.getField(false,"_items").runMethod(true,"getSize"))) && RemoteObject.solveBoolean("=",_initialsize,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 235;BA.debugLine="items.Add(NewItem)";
Debug.ShouldStop(1024);
__ref.getField(false,"_items").runVoidMethod ("Add",(Object)((_newitem)));
 BA.debugLineNum = 236;BA.debugLine="Dim offset As Int";
Debug.ShouldStop(2048);
_offset = RemoteObject.createImmutable(0);Debug.locals.put("offset", _offset);
 BA.debugLineNum = 237;BA.debugLine="If Index = 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_index,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 238;BA.debugLine="offset = mDividerSize";
Debug.ShouldStop(8192);
_offset = BA.numberCast(int.class, __ref.getField(true,"_mdividersize"));Debug.locals.put("offset", _offset);
 }else {
 BA.debugLineNum = 240;BA.debugLine="offset = GetScrollViewContentSize";
Debug.ShouldStop(32768);
_offset = BA.numberCast(int.class, __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewcontentsize"));Debug.locals.put("offset", _offset);
 };
 BA.debugLineNum = 242;BA.debugLine="NewItem.Offset = offset";
Debug.ShouldStop(131072);
_newitem.setField ("Offset",_offset);
 BA.debugLineNum = 243;BA.debugLine="If horizontal Then";
Debug.ShouldStop(262144);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 244;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, offset, 0, I";
Debug.ShouldStop(524288);
__ref.getField(false,"_sv").runMethod(false,"getScrollViewInnerPanel").runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(_offset),(Object)(BA.numberCast(int.class, 0)),(Object)(_itemsize),(Object)(__ref.getField(false,"_sv").runMethod(true,"getHeight")));
 }else {
 BA.debugLineNum = 246;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, 0, offset, s";
Debug.ShouldStop(2097152);
__ref.getField(false,"_sv").runMethod(false,"getScrollViewInnerPanel").runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_offset),(Object)(__ref.getField(false,"_sv").runMethod(true,"getWidth")),(Object)(_itemsize));
 };
 }else {
 BA.debugLineNum = 249;BA.debugLine="Dim offset As Int";
Debug.ShouldStop(16777216);
_offset = RemoteObject.createImmutable(0);Debug.locals.put("offset", _offset);
 BA.debugLineNum = 250;BA.debugLine="If Index = 0 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_index,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 251;BA.debugLine="offset = mDividerSize";
Debug.ShouldStop(67108864);
_offset = BA.numberCast(int.class, __ref.getField(true,"_mdividersize"));Debug.locals.put("offset", _offset);
 }else {
 BA.debugLineNum = 253;BA.debugLine="Dim PrevItem As CLVItem = items.Get(Index - 1)";
Debug.ShouldStop(268435456);
_previtem = (__ref.getField(false,"_items").runMethod(false,"Get",(Object)(RemoteObject.solve(new RemoteObject[] {_index,RemoteObject.createImmutable(1)}, "-",1, 1))));Debug.locals.put("PrevItem", _previtem);Debug.locals.put("PrevItem", _previtem);
 BA.debugLineNum = 254;BA.debugLine="offset = PrevItem.Offset + PrevItem.Size + mDiv";
Debug.ShouldStop(536870912);
_offset = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_previtem.getField(true,"Offset"),_previtem.getField(true,"Size"),__ref.getField(true,"_mdividersize")}, "++",2, 0));Debug.locals.put("offset", _offset);
 };
 BA.debugLineNum = 256;BA.debugLine="For i = Index To items.Size - 1";
Debug.ShouldStop(-2147483648);
{
final int step39 = 1;
final int limit39 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_items").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = _index.<Integer>get().intValue() ;
for (;(step39 > 0 && _i <= limit39) || (step39 < 0 && _i >= limit39) ;_i = ((int)(0 + _i + step39))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 257;BA.debugLine="Dim It As CLVItem = items.Get(i)";
Debug.ShouldStop(1);
_it = (__ref.getField(false,"_items").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("It", _it);Debug.locals.put("It", _it);
 BA.debugLineNum = 258;BA.debugLine="Dim NewOffset As Int = It.Offset + ItemSize - I";
Debug.ShouldStop(2);
_newoffset = RemoteObject.solve(new RemoteObject[] {_it.getField(true,"Offset"),_itemsize,_initialsize,_includedividierheight}, "+-+",3, 1);Debug.locals.put("NewOffset", _newoffset);Debug.locals.put("NewOffset", _newoffset);
 BA.debugLineNum = 259;BA.debugLine="If Min(NewOffset, It.Offset) - GetScrollViewOff";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {customlistview.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, _newoffset)),(Object)(BA.numberCast(double.class, _it.getField(true,"Offset")))),__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewoffset")}, "-",1, 0),BA.numberCast(double.class, __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewvisiblesize")))) { 
 BA.debugLineNum = 260;BA.debugLine="It.Offset = NewOffset";
Debug.ShouldStop(8);
_it.setField ("Offset",_newoffset);
 BA.debugLineNum = 261;BA.debugLine="If horizontal Then";
Debug.ShouldStop(16);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 262;BA.debugLine="It.Panel.SetLayoutAnimated(AnimationDuration,";
Debug.ShouldStop(32);
_it.getField(false,"Panel").runVoidMethod ("SetLayoutAnimated",(Object)(__ref.getField(true,"_animationduration")),(Object)(_newoffset),(Object)(BA.numberCast(int.class, 0)),(Object)(_it.getField(true,"Size")),(Object)(_it.getField(false,"Panel").runMethod(true,"getHeight")));
 }else {
 BA.debugLineNum = 264;BA.debugLine="It.Panel.SetLayoutAnimated(AnimationDuration,";
Debug.ShouldStop(128);
_it.getField(false,"Panel").runVoidMethod ("SetLayoutAnimated",(Object)(__ref.getField(true,"_animationduration")),(Object)(BA.numberCast(int.class, 0)),(Object)(_newoffset),(Object)(_it.getField(false,"Panel").runMethod(true,"getWidth")),(Object)(_it.getField(true,"Size")));
 };
 }else {
 BA.debugLineNum = 267;BA.debugLine="SetItemOffset(It, NewOffset)";
Debug.ShouldStop(1024);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_setitemoffset",(Object)(_it),(Object)(BA.numberCast(float.class, _newoffset)));
 };
 BA.debugLineNum = 269;BA.debugLine="It.Panel.Tag = i + 1";
Debug.ShouldStop(4096);
_it.getField(false,"Panel").runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 271;BA.debugLine="items.InsertAt(Index, NewItem)";
Debug.ShouldStop(16384);
__ref.getField(false,"_items").runVoidMethod ("InsertAt",(Object)(_index),(Object)((_newitem)));
 BA.debugLineNum = 272;BA.debugLine="NewItem.Offset = offset";
Debug.ShouldStop(32768);
_newitem.setField ("Offset",_offset);
 BA.debugLineNum = 273;BA.debugLine="If horizontal Then";
Debug.ShouldStop(65536);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 274;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, offset, 0, I";
Debug.ShouldStop(131072);
__ref.getField(false,"_sv").runMethod(false,"getScrollViewInnerPanel").runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(_offset),(Object)(BA.numberCast(int.class, 0)),(Object)(_initialsize),(Object)(__ref.getField(false,"_sv").runMethod(true,"getHeight")));
 BA.debugLineNum = 275;BA.debugLine="p.SetLayoutAnimated(AnimationDuration, offset,";
Debug.ShouldStop(262144);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(__ref.getField(true,"_animationduration")),(Object)(_offset),(Object)(BA.numberCast(int.class, 0)),(Object)(_itemsize),(Object)(_p.runMethod(true,"getHeight")));
 }else {
 BA.debugLineNum = 277;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, 0, offset, s";
Debug.ShouldStop(1048576);
__ref.getField(false,"_sv").runMethod(false,"getScrollViewInnerPanel").runVoidMethod ("AddView",(Object)((_p.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(_offset),(Object)(__ref.getField(false,"_sv").runMethod(true,"getWidth")),(Object)(_initialsize));
 BA.debugLineNum = 278;BA.debugLine="p.SetLayoutAnimated(AnimationDuration, 0, offse";
Debug.ShouldStop(2097152);
_p.runVoidMethod ("SetLayoutAnimated",(Object)(__ref.getField(true,"_animationduration")),(Object)(BA.numberCast(int.class, 0)),(Object)(_offset),(Object)(_p.runMethod(true,"getWidth")),(Object)(_itemsize));
 };
 };
 BA.debugLineNum = 281;BA.debugLine="SetScrollViewContentSize(GetScrollViewContentSize";
Debug.ShouldStop(16777216);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_setscrollviewcontentsize",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewcontentsize"),_itemsize,_initialsize,_includedividierheight}, "+-+",3, 0))));
 BA.debugLineNum = 282;BA.debugLine="If items.Size = 1 Then SetScrollViewContentSize(G";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_items").runMethod(true,"getSize"),BA.numberCast(double.class, 1))) { 
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_setscrollviewcontentsize",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewcontentsize"),_includedividierheight}, "+",1, 0))));};
 BA.debugLineNum = 283;BA.debugLine="If Index < mLastVisibleIndex Or GetRawListItem(mL";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("<",_index,BA.numberCast(double.class, __ref.getField(true,"_mlastvisibleindex"))) || RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getrawlistitem",(Object)(__ref.getField(true,"_mlastvisibleindex"))).getField(true,"Offset"),__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getrawlistitem",(Object)(__ref.getField(true,"_mlastvisibleindex"))).getField(true,"Size"),__ref.getField(true,"_mdividersize")}, "++",2, 0),BA.numberCast(double.class, __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewvisiblesize")))) { 
 BA.debugLineNum = 285;BA.debugLine="UpdateVisibleRange";
Debug.ShouldStop(268435456);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_updatevisiblerange");
 };
 BA.debugLineNum = 287;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _insertattextitem(RemoteObject __ref,RemoteObject _index,RemoteObject _text,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("InsertAtTextItem (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,187);
if (RapidSub.canDelegate("insertattextitem")) return __ref.runUserSub(false, "customlistview","insertattextitem", __ref, _index, _text, _value);
RemoteObject _pnl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _lbl = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _item = RemoteObject.declareNull("com.no3dlauncher.customlistview._clvitem");
Debug.locals.put("Index", _index);
Debug.locals.put("Text", _text);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 187;BA.debugLine="Public Sub InsertAtTextItem(Index As Int, Text As";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 188;BA.debugLine="If horizontal Then";
Debug.ShouldStop(134217728);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 189;BA.debugLine="Log(\"AddTextItem is only supported in vertical o";
Debug.ShouldStop(268435456);
customlistview.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("AddTextItem is only supported in vertical orientation.")));
 BA.debugLineNum = 190;BA.debugLine="Return";
Debug.ShouldStop(536870912);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 192;BA.debugLine="Dim pnl As B4XView = CreatePanel(\"\")";
Debug.ShouldStop(-2147483648);
_pnl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_pnl = __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_createpanel",(Object)(RemoteObject.createImmutable("")));Debug.locals.put("pnl", _pnl);Debug.locals.put("pnl", _pnl);
 BA.debugLineNum = 193;BA.debugLine="Dim lbl As B4XView = CreateLabel(Text)";
Debug.ShouldStop(1);
_lbl = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_lbl = __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_createlabel",(Object)(_text));Debug.locals.put("lbl", _lbl);Debug.locals.put("lbl", _lbl);
 BA.debugLineNum = 194;BA.debugLine="lbl.Height = Max(50dip, lbl.Height)";
Debug.ShouldStop(2);
_lbl.runMethod(true,"setHeight",BA.numberCast(int.class, customlistview.__c.runMethod(true,"Max",(Object)(BA.numberCast(double.class, customlistview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50))))),(Object)(BA.numberCast(double.class, _lbl.runMethod(true,"getHeight"))))));
 BA.debugLineNum = 195;BA.debugLine="pnl.AddView(lbl, 5dip, 2dip, sv.ScrollViewContent";
Debug.ShouldStop(4);
_pnl.runVoidMethod ("AddView",(Object)((_lbl.getObject())),(Object)(customlistview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(customlistview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_sv").runMethod(true,"getScrollViewContentWidth"),customlistview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "-",1, 1)),(Object)(_lbl.runMethod(true,"getHeight")));
 BA.debugLineNum = 196;BA.debugLine="lbl.TextColor = DefaultTextColor";
Debug.ShouldStop(8);
_lbl.runMethod(true,"setTextColor",__ref.getField(true,"_defaulttextcolor"));
 BA.debugLineNum = 197;BA.debugLine="pnl.Color = DefaultTextBackgroundColor";
Debug.ShouldStop(16);
_pnl.runMethod(true,"setColor",__ref.getField(true,"_defaulttextbackgroundcolor"));
 BA.debugLineNum = 198;BA.debugLine="pnl.Height = lbl.Height + 2dip";
Debug.ShouldStop(32);
_pnl.runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_lbl.runMethod(true,"getHeight"),customlistview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "+",1, 1));
 BA.debugLineNum = 199;BA.debugLine="InsertAt(Index, pnl, Value)";
Debug.ShouldStop(64);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_insertat",(Object)(_index),(Object)(_pnl),(Object)(_value));
 BA.debugLineNum = 200;BA.debugLine="Dim item As CLVItem = GetRawListItem(Index)";
Debug.ShouldStop(128);
_item = __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getrawlistitem",(Object)(_index));Debug.locals.put("item", _item);Debug.locals.put("item", _item);
 BA.debugLineNum = 201;BA.debugLine="item.TextItem = True";
Debug.ShouldStop(256);
_item.setField ("TextItem",customlistview.__c.getField(true,"True"));
 BA.debugLineNum = 202;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jumptoitem(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("JumpToItem (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,376);
if (RapidSub.canDelegate("jumptoitem")) return __ref.runUserSub(false, "customlistview","jumptoitem", __ref, _index);
Debug.locals.put("Index", _index);
 BA.debugLineNum = 376;BA.debugLine="Public Sub JumpToItem(Index As Int)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 377;BA.debugLine="SetScrollViewOffset(Min(GetMaxScrollOffset, FindI";
Debug.ShouldStop(16777216);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_setscrollviewoffset",(Object)(BA.numberCast(float.class, customlistview.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getmaxscrolloffset"))),(Object)(BA.numberCast(double.class, __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_finditemoffset",(Object)(_index))))))));
 BA.debugLineNum = 378;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _panel_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Panel_Click (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,516);
if (RapidSub.canDelegate("panel_click")) return __ref.runUserSub(false, "customlistview","panel_click", __ref);
 BA.debugLineNum = 516;BA.debugLine="Private Sub Panel_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 517;BA.debugLine="PanelClickHandler(Sender)";
Debug.ShouldStop(16);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_panelclickhandler",RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.B4XViewWrapper"), customlistview.__c.runMethod(false,"Sender",__ref.getField(false, "ba"))));
 BA.debugLineNum = 518;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _panelclickhandler(RemoteObject __ref,RemoteObject _senderpanel) throws Exception{
ResumableSub_PanelClickHandler rsub = new ResumableSub_PanelClickHandler(null,__ref,_senderpanel);
rsub.resume(null, null);
}
public static class ResumableSub_PanelClickHandler extends BA.ResumableSub {
public ResumableSub_PanelClickHandler(com.no3dlauncher.customlistview parent,RemoteObject __ref,RemoteObject _senderpanel) {
this.parent = parent;
this.__ref = __ref;
this._senderpanel = _senderpanel;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
com.no3dlauncher.customlistview parent;
RemoteObject _senderpanel;
RemoteObject _clr = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("PanelClickHandler (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,453);
if (RapidSub.canDelegate("panelclickhandler")) return ;
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
Debug.locals.put("SenderPanel", _senderpanel);
 BA.debugLineNum = 454;BA.debugLine="Dim clr As Int = GetRawListItem(SenderPanel.Tag).";
Debug.ShouldStop(32);
_clr = __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getrawlistitem",(Object)(BA.numberCast(int.class, _senderpanel.runMethod(false,"getTag")))).getField(true,"Color");Debug.locals.put("clr", _clr);Debug.locals.put("clr", _clr);
 BA.debugLineNum = 455;BA.debugLine="SenderPanel.SetColorAnimated(50, clr, PressedColo";
Debug.ShouldStop(64);
_senderpanel.runVoidMethod ("SetColorAnimated",(Object)(BA.numberCast(int.class, 50)),(Object)(_clr),(Object)(__ref.getField(true,"_pressedcolor")));
 BA.debugLineNum = 456;BA.debugLine="If xui.SubExists(CallBack, EventName & \"_ItemClic";
Debug.ShouldStop(128);
if (true) break;

case 1:
//if
this.state = 4;
if (__ref.getField(false,"_xui").runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_eventname"),RemoteObject.createImmutable("_ItemClick"))),(Object)(BA.numberCast(int.class, 2))).<Boolean>get().booleanValue()) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 457;BA.debugLine="CallSub3(CallBack, EventName & \"_ItemClick\", Sen";
Debug.ShouldStop(256);
parent.__c.runMethodAndSync(false,"CallSubNew3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_eventname"),RemoteObject.createImmutable("_ItemClick"))),(Object)(_senderpanel.runMethod(false,"getTag")),(Object)(__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getrawlistitem",(Object)(BA.numberCast(int.class, _senderpanel.runMethod(false,"getTag")))).getField(false,"Value")));
 if (true) break;

case 4:
//C
this.state = -1;
;
 BA.debugLineNum = 459;BA.debugLine="Sleep(200)";
Debug.ShouldStop(1024);
parent.__c.runVoidMethod ("Sleep",__ref.getField(false, "ba"),anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this),BA.numberCast(int.class, 200));
this.state = 5;
return;
case 5:
//C
this.state = -1;
;
 BA.debugLineNum = 460;BA.debugLine="SenderPanel.SetColorAnimated(200, PressedColor, c";
Debug.ShouldStop(2048);
_senderpanel.runVoidMethod ("SetColorAnimated",(Object)(BA.numberCast(int.class, 200)),(Object)(__ref.getField(true,"_pressedcolor")),(Object)(_clr));
 BA.debugLineNum = 461;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
public static RemoteObject  _refresh(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Refresh (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,60);
if (RapidSub.canDelegate("refresh")) return __ref.runUserSub(false, "customlistview","refresh", __ref);
 BA.debugLineNum = 60;BA.debugLine="Public Sub Refresh";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="ResetVisibles";
Debug.ShouldStop(268435456);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_resetvisibles");
 BA.debugLineNum = 62;BA.debugLine="UpdateVisibleRange";
Debug.ShouldStop(536870912);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_updatevisiblerange");
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _removeat(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("RemoveAt (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,161);
if (RapidSub.canDelegate("removeat")) return __ref.runUserSub(false, "customlistview","removeat", __ref, _index);
RemoteObject _removeitem = RemoteObject.declareNull("com.no3dlauncher.customlistview._clvitem");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
int _i = 0;
RemoteObject _item = RemoteObject.declareNull("com.no3dlauncher.customlistview._clvitem");
RemoteObject _newoffset = RemoteObject.createImmutable(0);
Debug.locals.put("Index", _index);
 BA.debugLineNum = 161;BA.debugLine="Public Sub RemoveAt(Index As Int)";
Debug.ShouldStop(1);
 BA.debugLineNum = 162;BA.debugLine="If getSize <= 1 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("k",__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getsize"),BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 163;BA.debugLine="Clear";
Debug.ShouldStop(4);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_clear");
 BA.debugLineNum = 164;BA.debugLine="Return";
Debug.ShouldStop(8);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 166;BA.debugLine="Dim RemoveItem As CLVItem = items.Get(Index)";
Debug.ShouldStop(32);
_removeitem = (__ref.getField(false,"_items").runMethod(false,"Get",(Object)(_index)));Debug.locals.put("RemoveItem", _removeitem);Debug.locals.put("RemoveItem", _removeitem);
 BA.debugLineNum = 167;BA.debugLine="Dim p As B4XView";
Debug.ShouldStop(64);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 168;BA.debugLine="For i = Index + 1 To items.Size - 1";
Debug.ShouldStop(128);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_items").runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = RemoteObject.solve(new RemoteObject[] {_index,RemoteObject.createImmutable(1)}, "+",1, 1).<Integer>get().intValue() ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 169;BA.debugLine="Dim item As CLVItem = items.Get(i)";
Debug.ShouldStop(256);
_item = (__ref.getField(false,"_items").runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));Debug.locals.put("item", _item);Debug.locals.put("item", _item);
 BA.debugLineNum = 170;BA.debugLine="p = item.Panel";
Debug.ShouldStop(512);
_p = _item.getField(false,"Panel");Debug.locals.put("p", _p);
 BA.debugLineNum = 171;BA.debugLine="p.Tag = i - 1";
Debug.ShouldStop(1024);
_p.runMethod(false,"setTag",(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "-",1, 1)));
 BA.debugLineNum = 172;BA.debugLine="Dim NewOffset As Int = item.Offset - RemoveItem.";
Debug.ShouldStop(2048);
_newoffset = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {_item.getField(true,"Offset"),_removeitem.getField(true,"Size"),__ref.getField(true,"_mdividersize")}, "--",2, 0));Debug.locals.put("NewOffset", _newoffset);Debug.locals.put("NewOffset", _newoffset);
 BA.debugLineNum = 173;BA.debugLine="SetItemOffset(item, NewOffset)";
Debug.ShouldStop(4096);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_setitemoffset",(Object)(_item),(Object)(BA.numberCast(float.class, _newoffset)));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 175;BA.debugLine="SetScrollViewContentSize(GetScrollViewContentSize";
Debug.ShouldStop(16384);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_setscrollviewcontentsize",(Object)(BA.numberCast(float.class, RemoteObject.solve(new RemoteObject[] {__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewcontentsize"),_removeitem.getField(true,"Size"),__ref.getField(true,"_mdividersize")}, "--",2, 0))));
 BA.debugLineNum = 176;BA.debugLine="items.RemoveAt(Index)";
Debug.ShouldStop(32768);
__ref.getField(false,"_items").runVoidMethod ("RemoveAt",(Object)(_index));
 BA.debugLineNum = 177;BA.debugLine="RemoveItem.Panel.RemoveViewFromParent";
Debug.ShouldStop(65536);
_removeitem.getField(false,"Panel").runVoidMethod ("RemoveViewFromParent");
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _replaceat(RemoteObject __ref,RemoteObject _index,RemoteObject _pnl,RemoteObject _itemheight,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("ReplaceAt (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,361);
if (RapidSub.canDelegate("replaceat")) return __ref.runUserSub(false, "customlistview","replaceat", __ref, _index, _pnl, _itemheight, _value);
RemoteObject _removeitem = RemoteObject.declareNull("com.no3dlauncher.customlistview._clvitem");
Debug.locals.put("Index", _index);
Debug.locals.put("pnl", _pnl);
Debug.locals.put("ItemHeight", _itemheight);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 361;BA.debugLine="Public Sub ReplaceAt(Index As Int, pnl As B4XView,";
Debug.ShouldStop(256);
 BA.debugLineNum = 362;BA.debugLine="Dim RemoveItem As CLVItem = items.Get(Index)";
Debug.ShouldStop(512);
_removeitem = (__ref.getField(false,"_items").runMethod(false,"Get",(Object)(_index)));Debug.locals.put("RemoveItem", _removeitem);Debug.locals.put("RemoveItem", _removeitem);
 BA.debugLineNum = 363;BA.debugLine="items.RemoveAt(Index)";
Debug.ShouldStop(1024);
__ref.getField(false,"_items").runVoidMethod ("RemoveAt",(Object)(_index));
 BA.debugLineNum = 364;BA.debugLine="RemoveItem.Panel.RemoveViewFromParent";
Debug.ShouldStop(2048);
_removeitem.getField(false,"Panel").runVoidMethod ("RemoveViewFromParent");
 BA.debugLineNum = 365;BA.debugLine="InsertAtImpl(Index, pnl, ItemHeight, Value, Remov";
Debug.ShouldStop(4096);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_insertatimpl",(Object)(_index),(Object)(_pnl),(Object)(_itemheight),(Object)(_value),(Object)(_removeitem.getField(true,"Size")));
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
public static RemoteObject  _resetvisibles(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ResetVisibles (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,54);
if (RapidSub.canDelegate("resetvisibles")) return __ref.runUserSub(false, "customlistview","resetvisibles", __ref);
 BA.debugLineNum = 54;BA.debugLine="Private Sub ResetVisibles";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="mFirstVisibleIndex = -1";
Debug.ShouldStop(4194304);
__ref.setField ("_mfirstvisibleindex",BA.numberCast(int.class, -(double) (0 + 1)));
 BA.debugLineNum = 56;BA.debugLine="mLastVisibleIndex = 0x7FFFFFFF";
Debug.ShouldStop(8388608);
__ref.setField ("_mlastvisibleindex",BA.numberCast(int.class, 0x7fffffff));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _resizeitem(RemoteObject __ref,RemoteObject _index,RemoteObject _itemheight) throws Exception{
try {
		Debug.PushSubsStack("ResizeItem (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,350);
if (RapidSub.canDelegate("resizeitem")) return __ref.runUserSub(false, "customlistview","resizeitem", __ref, _index, _itemheight);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
RemoteObject _value = RemoteObject.declareNull("Object");
RemoteObject _parent = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
Debug.locals.put("Index", _index);
Debug.locals.put("ItemHeight", _itemheight);
 BA.debugLineNum = 350;BA.debugLine="Public Sub ResizeItem(Index As Int, ItemHeight As";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 351;BA.debugLine="Dim p As B4XView = GetPanel(Index)";
Debug.ShouldStop(1073741824);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_p = __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getpanel",(Object)(_index));Debug.locals.put("p", _p);Debug.locals.put("p", _p);
 BA.debugLineNum = 352;BA.debugLine="Dim value As Object = GetValue(Index)";
Debug.ShouldStop(-2147483648);
_value = __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getvalue",(Object)(_index));Debug.locals.put("value", _value);Debug.locals.put("value", _value);
 BA.debugLineNum = 353;BA.debugLine="Dim parent As B4XView = p.Parent";
Debug.ShouldStop(1);
_parent = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");
_parent = _p.runMethod(false,"getParent");Debug.locals.put("parent", _parent);Debug.locals.put("parent", _parent);
 BA.debugLineNum = 354;BA.debugLine="p.Color = parent.Color";
Debug.ShouldStop(2);
_p.runMethod(true,"setColor",_parent.runMethod(true,"getColor"));
 BA.debugLineNum = 355;BA.debugLine="p.RemoveViewFromParent";
Debug.ShouldStop(4);
_p.runVoidMethod ("RemoveViewFromParent");
 BA.debugLineNum = 356;BA.debugLine="ReplaceAt(Index, p, ItemHeight, value)";
Debug.ShouldStop(8);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_replaceat",(Object)(_index),(Object)(_p),(Object)(_itemheight),(Object)(_value));
 BA.debugLineNum = 357;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scrollhandler(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ScrollHandler (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,474);
if (RapidSub.canDelegate("scrollhandler")) return __ref.runUserSub(false, "customlistview","scrollhandler", __ref);
RemoteObject _position = RemoteObject.createImmutable(0);
 BA.debugLineNum = 474;BA.debugLine="Private Sub ScrollHandler";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 475;BA.debugLine="If items.Size = 0 Then Return";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_items").runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 476;BA.debugLine="Dim position As Int = GetScrollViewOffset";
Debug.ShouldStop(134217728);
_position = BA.numberCast(int.class, __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewoffset"));Debug.locals.put("position", _position);Debug.locals.put("position", _position);
 BA.debugLineNum = 477;BA.debugLine="If position + GetScrollViewVisibleSize >= GetScro";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("g",RemoteObject.solve(new RemoteObject[] {_position,__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewvisiblesize")}, "+",1, 0),RemoteObject.solve(new RemoteObject[] {__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getscrollviewcontentsize"),customlistview.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))}, "-",1, 0)) && RemoteObject.solveBoolean(">",customlistview.__c.getField(false,"DateTime").runMethod(true,"getNow"),BA.numberCast(double.class, RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_lastreachendevent"),RemoteObject.createImmutable(100)}, "+",1, 2)))) { 
 BA.debugLineNum = 478;BA.debugLine="If xui.SubExists(CallBack, EventName & \"_ReachEn";
Debug.ShouldStop(536870912);
if (__ref.getField(false,"_xui").runMethod(true,"SubExists",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_eventname"),RemoteObject.createImmutable("_ReachEnd"))),(Object)(BA.numberCast(int.class, 0))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 479;BA.debugLine="LastReachEndEvent = DateTime.Now";
Debug.ShouldStop(1073741824);
__ref.setField ("_lastreachendevent",customlistview.__c.getField(false,"DateTime").runMethod(true,"getNow"));
 BA.debugLineNum = 480;BA.debugLine="CallSubDelayed(CallBack, EventName & \"_ReachEnd";
Debug.ShouldStop(-2147483648);
customlistview.__c.runVoidMethod ("CallSubDelayed",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_eventname"),RemoteObject.createImmutable("_ReachEnd"))));
 }else {
 BA.debugLineNum = 482;BA.debugLine="LastReachEndEvent = DateTime.Now + 1000 * DateT";
Debug.ShouldStop(2);
__ref.setField ("_lastreachendevent",RemoteObject.solve(new RemoteObject[] {customlistview.__c.getField(false,"DateTime").runMethod(true,"getNow"),RemoteObject.createImmutable(1000),customlistview.__c.getField(false,"DateTime").getField(true,"TicksPerDay")}, "+*",1, 2));
 };
 };
 BA.debugLineNum = 485;BA.debugLine="UpdateVisibleRange";
Debug.ShouldStop(16);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_updatevisiblerange");
 BA.debugLineNum = 486;BA.debugLine="If FireScrollChanged Then";
Debug.ShouldStop(32);
if (__ref.getField(true,"_firescrollchanged").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 487;BA.debugLine="CallSub2(CallBack, EventName & \"_ScrollChanged\",";
Debug.ShouldStop(64);
customlistview.__c.runMethodAndSync(false,"CallSubNew2",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_eventname"),RemoteObject.createImmutable("_ScrollChanged"))),(Object)((_position)));
 };
 BA.debugLineNum = 489;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _scrolltoitem(RemoteObject __ref,RemoteObject _index) throws Exception{
try {
		Debug.PushSubsStack("ScrollToItem (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,385);
if (RapidSub.canDelegate("scrolltoitem")) return __ref.runUserSub(false, "customlistview","scrolltoitem", __ref, _index);
RemoteObject _offset = RemoteObject.createImmutable(0f);
RemoteObject _hv = RemoteObject.declareNull("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
RemoteObject _nsv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
Debug.locals.put("Index", _index);
 BA.debugLineNum = 385;BA.debugLine="Public Sub ScrollToItem(Index As Int)";
Debug.ShouldStop(1);
 BA.debugLineNum = 386;BA.debugLine="Dim offset As Float = Min(GetMaxScrollOffset, Fin";
Debug.ShouldStop(2);
_offset = BA.numberCast(float.class, customlistview.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getmaxscrolloffset"))),(Object)(BA.numberCast(double.class, __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_finditemoffset",(Object)(_index))))));Debug.locals.put("offset", _offset);Debug.locals.put("offset", _offset);
 BA.debugLineNum = 398;BA.debugLine="If horizontal Then";
Debug.ShouldStop(8192);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 399;BA.debugLine="Dim hv As HorizontalScrollView = sv";
Debug.ShouldStop(16384);
_hv = RemoteObject.createNew ("anywheresoftware.b4a.objects.HorizontalScrollViewWrapper");
_hv.setObject(__ref.getField(false,"_sv").getObject());Debug.locals.put("hv", _hv);
 BA.debugLineNum = 400;BA.debugLine="hv.ScrollPosition = offset 'smooth scroll";
Debug.ShouldStop(32768);
_hv.runMethod(true,"setScrollPosition",BA.numberCast(int.class, _offset));
 }else {
 BA.debugLineNum = 402;BA.debugLine="Dim nsv As ScrollView = sv";
Debug.ShouldStop(131072);
_nsv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
_nsv.setObject(__ref.getField(false,"_sv").getObject());Debug.locals.put("nsv", _nsv);
 BA.debugLineNum = 403;BA.debugLine="nsv.ScrollPosition = offset";
Debug.ShouldStop(262144);
_nsv.runMethod(true,"setScrollPosition",BA.numberCast(int.class, _offset));
 };
 BA.debugLineNum = 406;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setitemoffset(RemoteObject __ref,RemoteObject _item,RemoteObject _offset) throws Exception{
try {
		Debug.PushSubsStack("SetItemOffset (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,340);
if (RapidSub.canDelegate("setitemoffset")) return __ref.runUserSub(false, "customlistview","setitemoffset", __ref, _item, _offset);
Debug.locals.put("item", _item);
Debug.locals.put("offset", _offset);
 BA.debugLineNum = 340;BA.debugLine="Private Sub SetItemOffset (item As CLVItem, offset";
Debug.ShouldStop(524288);
 BA.debugLineNum = 341;BA.debugLine="item.Offset = offset";
Debug.ShouldStop(1048576);
_item.setField ("Offset",BA.numberCast(int.class, _offset));
 BA.debugLineNum = 342;BA.debugLine="If horizontal Then";
Debug.ShouldStop(2097152);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 343;BA.debugLine="item.Panel.Left = offset";
Debug.ShouldStop(4194304);
_item.getField(false,"Panel").runMethod(true,"setLeft",BA.numberCast(int.class, _offset));
 }else {
 BA.debugLineNum = 345;BA.debugLine="item.Panel.Top = offset";
Debug.ShouldStop(16777216);
_item.getField(false,"Panel").runMethod(true,"setTop",BA.numberCast(int.class, _offset));
 };
 BA.debugLineNum = 347;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setscrollviewcontentsize(RemoteObject __ref,RemoteObject _f) throws Exception{
try {
		Debug.PushSubsStack("SetScrollViewContentSize (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,332);
if (RapidSub.canDelegate("setscrollviewcontentsize")) return __ref.runUserSub(false, "customlistview","setscrollviewcontentsize", __ref, customlistview._f);
Debug.locals.put("f", _f);
 BA.debugLineNum = 332;BA.debugLine="Private Sub SetScrollViewContentSize(f As Float)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 333;BA.debugLine="If horizontal Then";
Debug.ShouldStop(4096);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 334;BA.debugLine="sv.ScrollViewContentWidth = f";
Debug.ShouldStop(8192);
__ref.getField(false,"_sv").runMethod(true,"setScrollViewContentWidth",BA.numberCast(int.class, customlistview._f));
 }else {
 BA.debugLineNum = 336;BA.debugLine="sv.ScrollViewContentHeight = f";
Debug.ShouldStop(32768);
__ref.getField(false,"_sv").runMethod(true,"setScrollViewContentHeight",BA.numberCast(int.class, customlistview._f));
 };
 BA.debugLineNum = 338;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setscrollviewoffset(RemoteObject __ref,RemoteObject _offset) throws Exception{
try {
		Debug.PushSubsStack("SetScrollViewOffset (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,316);
if (RapidSub.canDelegate("setscrollviewoffset")) return __ref.runUserSub(false, "customlistview","setscrollviewoffset", __ref, _offset);
Debug.locals.put("offset", _offset);
 BA.debugLineNum = 316;BA.debugLine="Private Sub SetScrollViewOffset(offset As Float)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 317;BA.debugLine="If horizontal Then";
Debug.ShouldStop(268435456);
if (__ref.getField(true,"_horizontal").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 318;BA.debugLine="sv.ScrollViewOffsetX = offset";
Debug.ShouldStop(536870912);
__ref.getField(false,"_sv").runMethod(true,"setScrollViewOffsetX",BA.numberCast(int.class, _offset));
 }else {
 BA.debugLineNum = 320;BA.debugLine="sv.ScrollViewOffsetY = offset";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_sv").runMethod(true,"setScrollViewOffsetY",BA.numberCast(int.class, _offset));
 };
 BA.debugLineNum = 322;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sv_scrollchanged(RemoteObject __ref,RemoteObject _position) throws Exception{
try {
		Debug.PushSubsStack("sv_ScrollChanged (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,520);
if (RapidSub.canDelegate("sv_scrollchanged")) return __ref.runUserSub(false, "customlistview","sv_scrollchanged", __ref, _position);
Debug.locals.put("Position", _position);
 BA.debugLineNum = 520;BA.debugLine="Private Sub sv_ScrollChanged(Position As Int)";
Debug.ShouldStop(128);
 BA.debugLineNum = 521;BA.debugLine="ScrollHandler";
Debug.ShouldStop(256);
__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_scrollhandler");
 BA.debugLineNum = 522;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _updatevisiblerange(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("UpdateVisibleRange (customlistview) ","customlistview",11,__ref.getField(false, "ba"),__ref,289);
if (RapidSub.canDelegate("updatevisiblerange")) return __ref.runUserSub(false, "customlistview","updatevisiblerange", __ref);
RemoteObject _first = RemoteObject.createImmutable(0);
RemoteObject _last = RemoteObject.createImmutable(0);
 BA.debugLineNum = 289;BA.debugLine="Private Sub UpdateVisibleRange";
Debug.ShouldStop(1);
 BA.debugLineNum = 290;BA.debugLine="If MonitorVisibleRange = False Or getSize = 0 The";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_monitorvisiblerange"),customlistview.__c.getField(true,"False")) || RemoteObject.solveBoolean("=",__ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getsize"),BA.numberCast(double.class, 0))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 291;BA.debugLine="Dim first As Int = getFirstVisibleIndex";
Debug.ShouldStop(4);
_first = __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getfirstvisibleindex");Debug.locals.put("first", _first);Debug.locals.put("first", _first);
 BA.debugLineNum = 292;BA.debugLine="Dim last As Int = getLastVisibleIndex";
Debug.ShouldStop(8);
_last = __ref.runClassMethod (com.no3dlauncher.customlistview.class, "_getlastvisibleindex");Debug.locals.put("last", _last);Debug.locals.put("last", _last);
 BA.debugLineNum = 293;BA.debugLine="If first <> mFirstVisibleIndex Or last <> mLastVi";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("!",_first,BA.numberCast(double.class, __ref.getField(true,"_mfirstvisibleindex"))) || RemoteObject.solveBoolean("!",_last,BA.numberCast(double.class, __ref.getField(true,"_mlastvisibleindex")))) { 
 BA.debugLineNum = 294;BA.debugLine="mFirstVisibleIndex = first";
Debug.ShouldStop(32);
__ref.setField ("_mfirstvisibleindex",_first);
 BA.debugLineNum = 295;BA.debugLine="mLastVisibleIndex = last";
Debug.ShouldStop(64);
__ref.setField ("_mlastvisibleindex",_last);
 BA.debugLineNum = 296;BA.debugLine="CallSubDelayed3(CallBack, EventName & \"_VisibleR";
Debug.ShouldStop(128);
customlistview.__c.runVoidMethod ("CallSubDelayed3",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_callback")),(Object)(RemoteObject.concat(__ref.getField(true,"_eventname"),RemoteObject.createImmutable("_VisibleRangeChanged"))),(Object)((__ref.getField(true,"_mfirstvisibleindex"))),(Object)((__ref.getField(true,"_mlastvisibleindex"))));
 };
 BA.debugLineNum = 298;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}