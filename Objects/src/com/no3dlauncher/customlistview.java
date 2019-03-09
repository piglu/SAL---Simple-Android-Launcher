package com.no3dlauncher;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class customlistview extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new anywheresoftware.b4a.ShellBA(_ba, this, htSubs, "com.no3dlauncher.customlistview");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.no3dlauncher.customlistview.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public static class _clvitem{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.B4XViewWrapper Panel;
public int Size;
public Object Value;
public int Color;
public boolean TextItem;
public int Offset;
public void Initialize() {
IsInitialized = true;
Panel = new anywheresoftware.b4a.objects.B4XViewWrapper();
Size = 0;
Value = new Object();
Color = 0;
TextItem = false;
Offset = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _mbase = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _sv = null;
public anywheresoftware.b4a.objects.collections.List _items = null;
public float _mdividersize = 0f;
public String _eventname = "";
public Object _callback = null;
public int _defaulttextcolor = 0;
public int _defaulttextbackgroundcolor = 0;
public int _animationduration = 0;
public long _lastreachendevent = 0L;
public int _pressedcolor = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4a.objects.LabelWrapper _designerlabel = null;
public boolean _horizontal = false;
public anywheresoftware.b4a.objects.StringUtils _su = null;
public int _mfirstvisibleindex = 0;
public int _mlastvisibleindex = 0;
public boolean _monitorvisiblerange = false;
public boolean _firescrollchanged = false;
public boolean _scrollbarsvisible = false;
public com.no3dlauncher.main _main = null;
public com.no3dlauncher.starter _starter = null;
public com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public com.no3dlauncher.search _search = null;
public com.no3dlauncher.notificationservice _notificationservice = null;
public com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public com.no3dlauncher.f _f = null;
public com.no3dlauncher.provjera _provjera = null;
public anywheresoftware.b4a.objects.B4XViewWrapper  _asview(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "asview"))
	return (anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "asview", null);
RDebugUtils.currentLine=11796480;
 //BA.debugLineNum = 11796480;BA.debugLine="Public Sub AsView As B4XView";
RDebugUtils.currentLine=11796481;
 //BA.debugLineNum = 11796481;BA.debugLine="Return mBase";
if (true) return __ref._mbase;
RDebugUtils.currentLine=11796482;
 //BA.debugLineNum = 11796482;BA.debugLine="End Sub";
return null;
}
public String  _add(com.no3dlauncher.customlistview __ref,anywheresoftware.b4a.objects.B4XViewWrapper _pnl,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "add"))
	return (String) Debug.delegate(ba, "add", new Object[] {_pnl,_value});
RDebugUtils.currentLine=13172736;
 //BA.debugLineNum = 13172736;BA.debugLine="Public Sub Add(Pnl As B4XView, Value As Object)";
RDebugUtils.currentLine=13172737;
 //BA.debugLineNum = 13172737;BA.debugLine="InsertAt(items.Size, Pnl, Value)";
__ref._insertat(null,__ref._items.getSize(),_pnl,_value);
RDebugUtils.currentLine=13172738;
 //BA.debugLineNum = 13172738;BA.debugLine="End Sub";
return "";
}
public int  _getitemfromview(com.no3dlauncher.customlistview __ref,anywheresoftware.b4a.objects.B4XViewWrapper _v) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getitemfromview"))
	return (Integer) Debug.delegate(ba, "getitemfromview", new Object[] {_v});
Object _parent = null;
anywheresoftware.b4a.objects.B4XViewWrapper _current = null;
RDebugUtils.currentLine=13762560;
 //BA.debugLineNum = 13762560;BA.debugLine="Public Sub GetItemFromView(v As B4XView) As Int";
RDebugUtils.currentLine=13762561;
 //BA.debugLineNum = 13762561;BA.debugLine="Dim parent = v As Object, current As B4XView";
_parent = (Object)(_v.getObject());
_current = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=13762562;
 //BA.debugLineNum = 13762562;BA.debugLine="Do While sv.ScrollViewInnerPanel <> parent";
while ((__ref._sv.getScrollViewInnerPanel()).equals((java.lang.Object)(_parent)) == false) {
RDebugUtils.currentLine=13762563;
 //BA.debugLineNum = 13762563;BA.debugLine="current = parent";
_current.setObject((java.lang.Object)(_parent));
RDebugUtils.currentLine=13762564;
 //BA.debugLineNum = 13762564;BA.debugLine="parent = current.Parent";
_parent = (Object)(_current.getParent().getObject());
 }
;
RDebugUtils.currentLine=13762566;
 //BA.debugLineNum = 13762566;BA.debugLine="v = current";
_v = _current;
RDebugUtils.currentLine=13762567;
 //BA.debugLineNum = 13762567;BA.debugLine="Return v.Tag";
if (true) return (int)(BA.ObjectToNumber(_v.getTag()));
RDebugUtils.currentLine=13762568;
 //BA.debugLineNum = 13762568;BA.debugLine="End Sub";
return 0;
}
public String  _insertat(com.no3dlauncher.customlistview __ref,int _index,anywheresoftware.b4a.objects.B4XViewWrapper _pnl,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "insertat"))
	return (String) Debug.delegate(ba, "insertat", new Object[] {_index,_pnl,_value});
float _size = 0f;
RDebugUtils.currentLine=12451840;
 //BA.debugLineNum = 12451840;BA.debugLine="Public Sub InsertAt(Index As Int, pnl As B4XView,";
RDebugUtils.currentLine=12451841;
 //BA.debugLineNum = 12451841;BA.debugLine="Dim size As Float";
_size = 0f;
RDebugUtils.currentLine=12451842;
 //BA.debugLineNum = 12451842;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12451843;
 //BA.debugLineNum = 12451843;BA.debugLine="size = pnl.Width";
_size = (float) (_pnl.getWidth());
 }else {
RDebugUtils.currentLine=12451845;
 //BA.debugLineNum = 12451845;BA.debugLine="size = pnl.Height";
_size = (float) (_pnl.getHeight());
 };
RDebugUtils.currentLine=12451847;
 //BA.debugLineNum = 12451847;BA.debugLine="InsertAtImpl(Index, pnl, size, Value, 0)";
__ref._insertatimpl(null,_index,_pnl,(int) (_size),_value,(int) (0));
RDebugUtils.currentLine=12451848;
 //BA.debugLineNum = 12451848;BA.debugLine="End Sub";
return "";
}
public String  _addtextitem(com.no3dlauncher.customlistview __ref,Object _text,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "addtextitem"))
	return (String) Debug.delegate(ba, "addtextitem", new Object[] {_text,_value});
RDebugUtils.currentLine=12320768;
 //BA.debugLineNum = 12320768;BA.debugLine="Public Sub AddTextItem(Text As Object, Value As Ob";
RDebugUtils.currentLine=12320769;
 //BA.debugLineNum = 12320769;BA.debugLine="InsertAtTextItem(items.Size, Text, Value)";
__ref._insertattextitem(null,__ref._items.getSize(),_text,_value);
RDebugUtils.currentLine=12320770;
 //BA.debugLineNum = 12320770;BA.debugLine="End Sub";
return "";
}
public String  _insertattextitem(com.no3dlauncher.customlistview __ref,int _index,Object _text,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "insertattextitem"))
	return (String) Debug.delegate(ba, "insertattextitem", new Object[] {_index,_text,_value});
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
com.no3dlauncher.customlistview._clvitem _item = null;
RDebugUtils.currentLine=12386304;
 //BA.debugLineNum = 12386304;BA.debugLine="Public Sub InsertAtTextItem(Index As Int, Text As";
RDebugUtils.currentLine=12386305;
 //BA.debugLineNum = 12386305;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12386306;
 //BA.debugLineNum = 12386306;BA.debugLine="Log(\"AddTextItem is only supported in vertical o";
__c.Log("AddTextItem is only supported in vertical orientation.");
RDebugUtils.currentLine=12386307;
 //BA.debugLineNum = 12386307;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=12386309;
 //BA.debugLineNum = 12386309;BA.debugLine="Dim pnl As B4XView = CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = __ref._createpanel(null,"");
RDebugUtils.currentLine=12386310;
 //BA.debugLineNum = 12386310;BA.debugLine="Dim lbl As B4XView = CreateLabel(Text)";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = __ref._createlabel(null,_text);
RDebugUtils.currentLine=12386311;
 //BA.debugLineNum = 12386311;BA.debugLine="lbl.Height = Max(50dip, lbl.Height)";
_lbl.setHeight((int) (__c.Max(__c.DipToCurrent((int) (50)),_lbl.getHeight())));
RDebugUtils.currentLine=12386312;
 //BA.debugLineNum = 12386312;BA.debugLine="pnl.AddView(lbl, 5dip, 2dip, sv.ScrollViewContent";
_pnl.AddView((android.view.View)(_lbl.getObject()),__c.DipToCurrent((int) (5)),__c.DipToCurrent((int) (2)),(int) (__ref._sv.getScrollViewContentWidth()-__c.DipToCurrent((int) (10))),_lbl.getHeight());
RDebugUtils.currentLine=12386313;
 //BA.debugLineNum = 12386313;BA.debugLine="lbl.TextColor = DefaultTextColor";
_lbl.setTextColor(__ref._defaulttextcolor);
RDebugUtils.currentLine=12386314;
 //BA.debugLineNum = 12386314;BA.debugLine="pnl.Color = DefaultTextBackgroundColor";
_pnl.setColor(__ref._defaulttextbackgroundcolor);
RDebugUtils.currentLine=12386315;
 //BA.debugLineNum = 12386315;BA.debugLine="pnl.Height = lbl.Height + 2dip";
_pnl.setHeight((int) (_lbl.getHeight()+__c.DipToCurrent((int) (2))));
RDebugUtils.currentLine=12386316;
 //BA.debugLineNum = 12386316;BA.debugLine="InsertAt(Index, pnl, Value)";
__ref._insertat(null,_index,_pnl,_value);
RDebugUtils.currentLine=12386317;
 //BA.debugLineNum = 12386317;BA.debugLine="Dim item As CLVItem = GetRawListItem(Index)";
_item = __ref._getrawlistitem(null,_index);
RDebugUtils.currentLine=12386318;
 //BA.debugLineNum = 12386318;BA.debugLine="item.TextItem = True";
_item.TextItem = __c.True;
RDebugUtils.currentLine=12386319;
 //BA.debugLineNum = 12386319;BA.debugLine="End Sub";
return "";
}
public String  _base_resize(com.no3dlauncher.customlistview __ref,double _width,double _height) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "base_resize"))
	return (String) Debug.delegate(ba, "base_resize", new Object[] {_width,_height});
int _scrollbar = 0;
com.no3dlauncher.customlistview._clvitem _it = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
RDebugUtils.currentLine=11730944;
 //BA.debugLineNum = 11730944;BA.debugLine="Public Sub Base_Resize (Width As Double, Height As";
RDebugUtils.currentLine=11730945;
 //BA.debugLineNum = 11730945;BA.debugLine="sv.SetLayoutAnimated(0, 0, 0, Width, Height)";
__ref._sv.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
RDebugUtils.currentLine=11730946;
 //BA.debugLineNum = 11730946;BA.debugLine="Dim scrollbar As Int";
_scrollbar = 0;
RDebugUtils.currentLine=11730947;
 //BA.debugLineNum = 11730947;BA.debugLine="If xui.IsB4J And ScrollBarsVisible Then scrollbar";
if (__ref._xui.getIsB4J() && __ref._scrollbarsvisible) { 
_scrollbar = (int) (20);};
RDebugUtils.currentLine=11730948;
 //BA.debugLineNum = 11730948;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=11730949;
 //BA.debugLineNum = 11730949;BA.debugLine="sv.ScrollViewContentHeight = Height - scrollbar";
__ref._sv.setScrollViewContentHeight((int) (_height-_scrollbar));
RDebugUtils.currentLine=11730950;
 //BA.debugLineNum = 11730950;BA.debugLine="For Each it As CLVItem In items";
{
final anywheresoftware.b4a.BA.IterableList group6 = __ref._items;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_it = (com.no3dlauncher.customlistview._clvitem)(group6.Get(index6));
RDebugUtils.currentLine=11730951;
 //BA.debugLineNum = 11730951;BA.debugLine="it.Panel.Height = sv.ScrollViewContentHeight";
_it.Panel.setHeight(__ref._sv.getScrollViewContentHeight());
RDebugUtils.currentLine=11730952;
 //BA.debugLineNum = 11730952;BA.debugLine="it.Panel.GetView(0).Height = it.Panel.Height";
_it.Panel.GetView((int) (0)).setHeight(_it.Panel.getHeight());
 }
};
 }else {
RDebugUtils.currentLine=11730955;
 //BA.debugLineNum = 11730955;BA.debugLine="sv.ScrollViewContentWidth = Width - scrollbar";
__ref._sv.setScrollViewContentWidth((int) (_width-_scrollbar));
RDebugUtils.currentLine=11730956;
 //BA.debugLineNum = 11730956;BA.debugLine="For Each it As CLVItem In items";
{
final anywheresoftware.b4a.BA.IterableList group12 = __ref._items;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_it = (com.no3dlauncher.customlistview._clvitem)(group12.Get(index12));
RDebugUtils.currentLine=11730957;
 //BA.debugLineNum = 11730957;BA.debugLine="it.Panel.Width = sv.ScrollViewContentWidth";
_it.Panel.setWidth(__ref._sv.getScrollViewContentWidth());
RDebugUtils.currentLine=11730958;
 //BA.debugLineNum = 11730958;BA.debugLine="it.Panel.GetView(0).Width = it.Panel.Width";
_it.Panel.GetView((int) (0)).setWidth(_it.Panel.getWidth());
RDebugUtils.currentLine=11730959;
 //BA.debugLineNum = 11730959;BA.debugLine="If it.TextItem Then";
if (_it.TextItem) { 
RDebugUtils.currentLine=11730960;
 //BA.debugLineNum = 11730960;BA.debugLine="Dim lbl As B4XView = it.Panel.GetView(0).GetVi";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _it.Panel.GetView((int) (0)).GetView((int) (0));
RDebugUtils.currentLine=11730961;
 //BA.debugLineNum = 11730961;BA.debugLine="lbl.SetLayoutAnimated(0, lbl.Left, lbl.Top, it";
_lbl.SetLayoutAnimated((int) (0),_lbl.getLeft(),_lbl.getTop(),(int) (_it.Panel.getWidth()-_lbl.getLeft()),_lbl.getHeight());
 };
 }
};
 };
RDebugUtils.currentLine=11730965;
 //BA.debugLineNum = 11730965;BA.debugLine="If items.Size > 0 Then UpdateVisibleRange";
if (__ref._items.getSize()>0) { 
__ref._updatevisiblerange(null);};
RDebugUtils.currentLine=11730966;
 //BA.debugLineNum = 11730966;BA.debugLine="End Sub";
return "";
}
public String  _updatevisiblerange(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "updatevisiblerange"))
	return (String) Debug.delegate(ba, "updatevisiblerange", null);
int _first = 0;
int _last = 0;
RDebugUtils.currentLine=12582912;
 //BA.debugLineNum = 12582912;BA.debugLine="Private Sub UpdateVisibleRange";
RDebugUtils.currentLine=12582913;
 //BA.debugLineNum = 12582913;BA.debugLine="If MonitorVisibleRange = False Or getSize = 0 The";
if (__ref._monitorvisiblerange==__c.False || __ref._getsize(null)==0) { 
if (true) return "";};
RDebugUtils.currentLine=12582914;
 //BA.debugLineNum = 12582914;BA.debugLine="Dim first As Int = getFirstVisibleIndex";
_first = __ref._getfirstvisibleindex(null);
RDebugUtils.currentLine=12582915;
 //BA.debugLineNum = 12582915;BA.debugLine="Dim last As Int = getLastVisibleIndex";
_last = __ref._getlastvisibleindex(null);
RDebugUtils.currentLine=12582916;
 //BA.debugLineNum = 12582916;BA.debugLine="If first <> mFirstVisibleIndex Or last <> mLastVi";
if (_first!=__ref._mfirstvisibleindex || _last!=__ref._mlastvisibleindex) { 
RDebugUtils.currentLine=12582917;
 //BA.debugLineNum = 12582917;BA.debugLine="mFirstVisibleIndex = first";
__ref._mfirstvisibleindex = _first;
RDebugUtils.currentLine=12582918;
 //BA.debugLineNum = 12582918;BA.debugLine="mLastVisibleIndex = last";
__ref._mlastvisibleindex = _last;
RDebugUtils.currentLine=12582919;
 //BA.debugLineNum = 12582919;BA.debugLine="CallSubDelayed3(CallBack, EventName & \"_VisibleR";
__c.CallSubDelayed3(ba,__ref._callback,__ref._eventname+"_VisibleRangeChanged",(Object)(__ref._mfirstvisibleindex),(Object)(__ref._mlastvisibleindex));
 };
RDebugUtils.currentLine=12582921;
 //BA.debugLineNum = 12582921;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
RDebugUtils.currentLine=11403264;
 //BA.debugLineNum = 11403264;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=11403265;
 //BA.debugLineNum = 11403265;BA.debugLine="Private mBase As B4XView";
_mbase = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=11403266;
 //BA.debugLineNum = 11403266;BA.debugLine="Public sv As B4XView";
_sv = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=11403267;
 //BA.debugLineNum = 11403267;BA.debugLine="Type CLVItem(Panel As B4XView, Size As Int, Value";
;
RDebugUtils.currentLine=11403269;
 //BA.debugLineNum = 11403269;BA.debugLine="Private items As List";
_items = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=11403270;
 //BA.debugLineNum = 11403270;BA.debugLine="Private mDividerSize As Float";
_mdividersize = 0f;
RDebugUtils.currentLine=11403271;
 //BA.debugLineNum = 11403271;BA.debugLine="Private EventName As String";
_eventname = "";
RDebugUtils.currentLine=11403272;
 //BA.debugLineNum = 11403272;BA.debugLine="Private CallBack As Object";
_callback = new Object();
RDebugUtils.currentLine=11403273;
 //BA.debugLineNum = 11403273;BA.debugLine="Public DefaultTextColor As Int";
_defaulttextcolor = 0;
RDebugUtils.currentLine=11403274;
 //BA.debugLineNum = 11403274;BA.debugLine="Public DefaultTextBackgroundColor As Int";
_defaulttextbackgroundcolor = 0;
RDebugUtils.currentLine=11403275;
 //BA.debugLineNum = 11403275;BA.debugLine="Public AnimationDuration As Int = 300";
_animationduration = (int) (300);
RDebugUtils.currentLine=11403276;
 //BA.debugLineNum = 11403276;BA.debugLine="Private LastReachEndEvent As Long";
_lastreachendevent = 0L;
RDebugUtils.currentLine=11403277;
 //BA.debugLineNum = 11403277;BA.debugLine="Private PressedColor As Int";
_pressedcolor = 0;
RDebugUtils.currentLine=11403278;
 //BA.debugLineNum = 11403278;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=11403279;
 //BA.debugLineNum = 11403279;BA.debugLine="Private DesignerLabel As Label";
_designerlabel = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=11403280;
 //BA.debugLineNum = 11403280;BA.debugLine="Private horizontal As Boolean";
_horizontal = false;
RDebugUtils.currentLine=11403284;
 //BA.debugLineNum = 11403284;BA.debugLine="Private su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
RDebugUtils.currentLine=11403288;
 //BA.debugLineNum = 11403288;BA.debugLine="Private mFirstVisibleIndex, mLastVisibleIndex As";
_mfirstvisibleindex = 0;
_mlastvisibleindex = 0;
RDebugUtils.currentLine=11403289;
 //BA.debugLineNum = 11403289;BA.debugLine="Private MonitorVisibleRange As Boolean";
_monitorvisiblerange = false;
RDebugUtils.currentLine=11403290;
 //BA.debugLineNum = 11403290;BA.debugLine="Private FireScrollChanged As Boolean";
_firescrollchanged = false;
RDebugUtils.currentLine=11403291;
 //BA.debugLineNum = 11403291;BA.debugLine="Private ScrollBarsVisible As Boolean";
_scrollbarsvisible = false;
RDebugUtils.currentLine=11403292;
 //BA.debugLineNum = 11403292;BA.debugLine="End Sub";
return "";
}
public String  _clear(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "clear"))
	return (String) Debug.delegate(ba, "clear", null);
RDebugUtils.currentLine=11862016;
 //BA.debugLineNum = 11862016;BA.debugLine="Public Sub Clear";
RDebugUtils.currentLine=11862017;
 //BA.debugLineNum = 11862017;BA.debugLine="items.Clear";
__ref._items.Clear();
RDebugUtils.currentLine=11862018;
 //BA.debugLineNum = 11862018;BA.debugLine="sv.ScrollViewInnerPanel.RemoveAllViews";
__ref._sv.getScrollViewInnerPanel().RemoveAllViews();
RDebugUtils.currentLine=11862019;
 //BA.debugLineNum = 11862019;BA.debugLine="SetScrollViewContentSize(0)";
__ref._setscrollviewcontentsize(null,(float) (0));
RDebugUtils.currentLine=11862020;
 //BA.debugLineNum = 11862020;BA.debugLine="ResetVisibles";
__ref._resetvisibles(null);
RDebugUtils.currentLine=11862021;
 //BA.debugLineNum = 11862021;BA.debugLine="End Sub";
return "";
}
public String  _setscrollviewcontentsize(com.no3dlauncher.customlistview __ref,float _f) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "setscrollviewcontentsize"))
	return (String) Debug.delegate(ba, "setscrollviewcontentsize", new Object[] {_f});
RDebugUtils.currentLine=12910592;
 //BA.debugLineNum = 12910592;BA.debugLine="Private Sub SetScrollViewContentSize(f As Float)";
RDebugUtils.currentLine=12910593;
 //BA.debugLineNum = 12910593;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12910594;
 //BA.debugLineNum = 12910594;BA.debugLine="sv.ScrollViewContentWidth = f";
__ref._sv.setScrollViewContentWidth((int) (_f));
 }else {
RDebugUtils.currentLine=12910596;
 //BA.debugLineNum = 12910596;BA.debugLine="sv.ScrollViewContentHeight = f";
__ref._sv.setScrollViewContentHeight((int) (_f));
 };
RDebugUtils.currentLine=12910598;
 //BA.debugLineNum = 12910598;BA.debugLine="End Sub";
return "";
}
public String  _resetvisibles(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "resetvisibles"))
	return (String) Debug.delegate(ba, "resetvisibles", null);
RDebugUtils.currentLine=11534336;
 //BA.debugLineNum = 11534336;BA.debugLine="Private Sub ResetVisibles";
RDebugUtils.currentLine=11534337;
 //BA.debugLineNum = 11534337;BA.debugLine="mFirstVisibleIndex = -1";
__ref._mfirstvisibleindex = (int) (-1);
RDebugUtils.currentLine=11534338;
 //BA.debugLineNum = 11534338;BA.debugLine="mLastVisibleIndex = 0x7FFFFFFF";
__ref._mlastvisibleindex = (int) (0x7fffffff);
RDebugUtils.currentLine=11534339;
 //BA.debugLineNum = 11534339;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createlabel(com.no3dlauncher.customlistview __ref,Object _txt) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "createlabel"))
	return (anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "createlabel", new Object[] {_txt});
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
RDebugUtils.currentLine=14221312;
 //BA.debugLineNum = 14221312;BA.debugLine="Private Sub CreateLabel(txt As Object) As B4XView";
RDebugUtils.currentLine=14221313;
 //BA.debugLineNum = 14221313;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=14221314;
 //BA.debugLineNum = 14221314;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
RDebugUtils.currentLine=14221315;
 //BA.debugLineNum = 14221315;BA.debugLine="lbl.Gravity = DesignerLabel.Gravity";
_lbl.setGravity(__ref._designerlabel.getGravity());
RDebugUtils.currentLine=14221316;
 //BA.debugLineNum = 14221316;BA.debugLine="lbl.TextSize = DesignerLabel.TextSize";
_lbl.setTextSize(__ref._designerlabel.getTextSize());
RDebugUtils.currentLine=14221317;
 //BA.debugLineNum = 14221317;BA.debugLine="lbl.SingleLine = False";
_lbl.setSingleLine(__c.False);
RDebugUtils.currentLine=14221318;
 //BA.debugLineNum = 14221318;BA.debugLine="lbl.Text = txt";
_lbl.setText(BA.ObjectToCharSequence(_txt));
RDebugUtils.currentLine=14221319;
 //BA.debugLineNum = 14221319;BA.debugLine="lbl.Width = sv.ScrollViewContentWidth - 10dip";
_lbl.setWidth((int) (__ref._sv.getScrollViewContentWidth()-__c.DipToCurrent((int) (10))));
RDebugUtils.currentLine=14221320;
 //BA.debugLineNum = 14221320;BA.debugLine="lbl.Height = su.MeasureMultilineTextHeight(lbl, t";
_lbl.setHeight(__ref._su.MeasureMultilineTextHeight((android.widget.TextView)(_lbl.getObject()),BA.ObjectToCharSequence(_txt)));
RDebugUtils.currentLine=14221321;
 //BA.debugLineNum = 14221321;BA.debugLine="Return lbl";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
RDebugUtils.currentLine=14221322;
 //BA.debugLineNum = 14221322;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createpanel(com.no3dlauncher.customlistview __ref,String _paneleventname) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "createpanel"))
	return (anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "createpanel", new Object[] {_paneleventname});
RDebugUtils.currentLine=13893632;
 //BA.debugLineNum = 13893632;BA.debugLine="Private Sub CreatePanel (PanelEventName As String)";
RDebugUtils.currentLine=13893633;
 //BA.debugLineNum = 13893633;BA.debugLine="Return xui.CreatePanel(PanelEventName)";
if (true) return __ref._xui.CreatePanel(ba,_paneleventname);
RDebugUtils.currentLine=13893634;
 //BA.debugLineNum = 13893634;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _createscrollview(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "createscrollview"))
	return (anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "createscrollview", null);
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hv = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _nsv = null;
RDebugUtils.currentLine=14024704;
 //BA.debugLineNum = 14024704;BA.debugLine="Private Sub CreateScrollView As B4XView";
RDebugUtils.currentLine=14024705;
 //BA.debugLineNum = 14024705;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=14024706;
 //BA.debugLineNum = 14024706;BA.debugLine="Dim hv As HorizontalScrollView";
_hv = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
RDebugUtils.currentLine=14024707;
 //BA.debugLineNum = 14024707;BA.debugLine="hv.Initialize(0, \"sv\")";
_hv.Initialize(ba,(int) (0),"sv");
RDebugUtils.currentLine=14024708;
 //BA.debugLineNum = 14024708;BA.debugLine="Return hv";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_hv.getObject()));
 }else {
RDebugUtils.currentLine=14024710;
 //BA.debugLineNum = 14024710;BA.debugLine="Dim nsv As ScrollView";
_nsv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=14024711;
 //BA.debugLineNum = 14024711;BA.debugLine="nsv.Initialize2(0, \"sv\")";
_nsv.Initialize2(ba,(int) (0),"sv");
RDebugUtils.currentLine=14024712;
 //BA.debugLineNum = 14024712;BA.debugLine="Return nsv";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_nsv.getObject()));
 };
RDebugUtils.currentLine=14024714;
 //BA.debugLineNum = 14024714;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(com.no3dlauncher.customlistview __ref,Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "designercreateview"))
	return (String) Debug.delegate(ba, "designercreateview", new Object[] {_base,_lbl,_props});
String _o = "";
anywheresoftware.b4j.object.JavaObject _jsv = null;
RDebugUtils.currentLine=11665408;
 //BA.debugLineNum = 11665408;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
RDebugUtils.currentLine=11665409;
 //BA.debugLineNum = 11665409;BA.debugLine="mBase = Base";
__ref._mbase.setObject((java.lang.Object)(_base));
RDebugUtils.currentLine=11665410;
 //BA.debugLineNum = 11665410;BA.debugLine="Dim o As String = Props.GetDefault(\"ListOrientati";
_o = BA.ObjectToString(_props.GetDefault((Object)("ListOrientation"),(Object)("Vertical")));
RDebugUtils.currentLine=11665411;
 //BA.debugLineNum = 11665411;BA.debugLine="horizontal = o = \"Horizontal\"";
__ref._horizontal = (_o).equals("Horizontal");
RDebugUtils.currentLine=11665412;
 //BA.debugLineNum = 11665412;BA.debugLine="sv = CreateScrollView";
__ref._sv = __ref._createscrollview(null);
RDebugUtils.currentLine=11665413;
 //BA.debugLineNum = 11665413;BA.debugLine="mBase.AddView(sv, 0, 0, mBase.Width, mBase.Height";
__ref._mbase.AddView((android.view.View)(__ref._sv.getObject()),(int) (0),(int) (0),__ref._mbase.getWidth(),__ref._mbase.getHeight());
RDebugUtils.currentLine=11665414;
 //BA.debugLineNum = 11665414;BA.debugLine="sv.ScrollViewInnerPanel.Color = xui.PaintOrColorT";
__ref._sv.getScrollViewInnerPanel().setColor(__ref._xui.PaintOrColorToColor(_props.Get((Object)("DividerColor"))));
RDebugUtils.currentLine=11665415;
 //BA.debugLineNum = 11665415;BA.debugLine="mDividerSize = DipToCurrent(Props.Get(\"DividerHei";
__ref._mdividersize = (float) (__c.DipToCurrent((int)(BA.ObjectToNumber(_props.Get((Object)("DividerHeight"))))));
RDebugUtils.currentLine=11665416;
 //BA.debugLineNum = 11665416;BA.debugLine="PressedColor = xui.PaintOrColorToColor(Props.Get(";
__ref._pressedcolor = __ref._xui.PaintOrColorToColor(_props.Get((Object)("PressedColor")));
RDebugUtils.currentLine=11665417;
 //BA.debugLineNum = 11665417;BA.debugLine="AnimationDuration = Props.GetDefault(\"InsertAnima";
__ref._animationduration = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("InsertAnimationDuration"),(Object)(__ref._animationduration))));
RDebugUtils.currentLine=11665418;
 //BA.debugLineNum = 11665418;BA.debugLine="ScrollBarsVisible = Props.GetDefault(\"ShowScrollB";
__ref._scrollbarsvisible = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowScrollBar"),(Object)(__c.True)));
RDebugUtils.currentLine=11665419;
 //BA.debugLineNum = 11665419;BA.debugLine="If ScrollBarsVisible = False Then";
if (__ref._scrollbarsvisible==__c.False) { 
RDebugUtils.currentLine=11665425;
 //BA.debugLineNum = 11665425;BA.debugLine="Dim jsv As JavaObject = sv";
_jsv = new anywheresoftware.b4j.object.JavaObject();
_jsv.setObject((java.lang.Object)(__ref._sv.getObject()));
RDebugUtils.currentLine=11665426;
 //BA.debugLineNum = 11665426;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=11665427;
 //BA.debugLineNum = 11665427;BA.debugLine="jsv.RunMethod(\"setHorizontalScrollBarEnabled\",";
_jsv.RunMethod("setHorizontalScrollBarEnabled",new Object[]{(Object)(__c.False)});
 }else {
RDebugUtils.currentLine=11665429;
 //BA.debugLineNum = 11665429;BA.debugLine="jsv.RunMethod(\"setVerticalScrollBarEnabled\", Ar";
_jsv.RunMethod("setVerticalScrollBarEnabled",new Object[]{(Object)(__c.False)});
 };
 };
RDebugUtils.currentLine=11665437;
 //BA.debugLineNum = 11665437;BA.debugLine="DefaultTextColor = xui.PaintOrColorToColor(Lbl.Te";
__ref._defaulttextcolor = __ref._xui.PaintOrColorToColor((Object)(_lbl.getTextColor()));
RDebugUtils.currentLine=11665438;
 //BA.debugLineNum = 11665438;BA.debugLine="DefaultTextBackgroundColor = mBase.Color";
__ref._defaulttextbackgroundcolor = __ref._mbase.getColor();
RDebugUtils.currentLine=11665439;
 //BA.debugLineNum = 11665439;BA.debugLine="DesignerLabel = Lbl";
__ref._designerlabel = _lbl;
RDebugUtils.currentLine=11665440;
 //BA.debugLineNum = 11665440;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
__ref._base_resize(null,__ref._mbase.getWidth(),__ref._mbase.getHeight());
RDebugUtils.currentLine=11665441;
 //BA.debugLineNum = 11665441;BA.debugLine="End Sub";
return "";
}
public int  _findindexfromoffset(com.no3dlauncher.customlistview __ref,int _offset) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "findindexfromoffset"))
	return (Integer) Debug.delegate(ba, "findindexfromoffset", new Object[] {_offset});
int _position = 0;
int _stepsize = 0;
com.no3dlauncher.customlistview._clvitem _currentitem = null;
int _nextoffset = 0;
int _prevoffset = 0;
RDebugUtils.currentLine=13500416;
 //BA.debugLineNum = 13500416;BA.debugLine="Public Sub FindIndexFromOffset(Offset As Int) As I";
RDebugUtils.currentLine=13500418;
 //BA.debugLineNum = 13500418;BA.debugLine="Dim Position As Int = items.Size / 2";
_position = (int) (__ref._items.getSize()/(double)2);
RDebugUtils.currentLine=13500419;
 //BA.debugLineNum = 13500419;BA.debugLine="Dim StepSize As Int = Ceil(Position / 2)";
_stepsize = (int) (__c.Ceil(_position/(double)2));
RDebugUtils.currentLine=13500420;
 //BA.debugLineNum = 13500420;BA.debugLine="Do While True";
while (__c.True) {
RDebugUtils.currentLine=13500421;
 //BA.debugLineNum = 13500421;BA.debugLine="Dim CurrentItem As CLVItem = items.Get(Position)";
_currentitem = (com.no3dlauncher.customlistview._clvitem)(__ref._items.Get(_position));
RDebugUtils.currentLine=13500422;
 //BA.debugLineNum = 13500422;BA.debugLine="Dim NextOffset As Int";
_nextoffset = 0;
RDebugUtils.currentLine=13500423;
 //BA.debugLineNum = 13500423;BA.debugLine="If Position < items.Size - 1 Then";
if (_position<__ref._items.getSize()-1) { 
RDebugUtils.currentLine=13500424;
 //BA.debugLineNum = 13500424;BA.debugLine="NextOffset = GetRawListItem(Position + 1).Offse";
_nextoffset = (int) (__ref._getrawlistitem(null,(int) (_position+1)).Offset-1);
 }else {
RDebugUtils.currentLine=13500426;
 //BA.debugLineNum = 13500426;BA.debugLine="NextOffset = 0x7FFFFFFF";
_nextoffset = (int) (0x7fffffff);
 };
RDebugUtils.currentLine=13500428;
 //BA.debugLineNum = 13500428;BA.debugLine="Dim PrevOffset As Int";
_prevoffset = 0;
RDebugUtils.currentLine=13500429;
 //BA.debugLineNum = 13500429;BA.debugLine="If Position = 0 Then";
if (_position==0) { 
RDebugUtils.currentLine=13500430;
 //BA.debugLineNum = 13500430;BA.debugLine="PrevOffset = 0x80000000";
_prevoffset = (int) (0x80000000);
 }else {
RDebugUtils.currentLine=13500432;
 //BA.debugLineNum = 13500432;BA.debugLine="PrevOffset = CurrentItem.Offset";
_prevoffset = _currentitem.Offset;
 };
RDebugUtils.currentLine=13500434;
 //BA.debugLineNum = 13500434;BA.debugLine="If Offset > NextOffset Then";
if (_offset>_nextoffset) { 
RDebugUtils.currentLine=13500435;
 //BA.debugLineNum = 13500435;BA.debugLine="Position = Min(Position + StepSize, items.Size";
_position = (int) (__c.Min(_position+_stepsize,__ref._items.getSize()-1));
 }else 
{RDebugUtils.currentLine=13500436;
 //BA.debugLineNum = 13500436;BA.debugLine="Else if Offset < PrevOffset Then";
if (_offset<_prevoffset) { 
RDebugUtils.currentLine=13500437;
 //BA.debugLineNum = 13500437;BA.debugLine="Position = Max(Position - StepSize, 0)";
_position = (int) (__c.Max(_position-_stepsize,0));
 }else {
RDebugUtils.currentLine=13500439;
 //BA.debugLineNum = 13500439;BA.debugLine="Return Position";
if (true) return _position;
 }}
;
RDebugUtils.currentLine=13500441;
 //BA.debugLineNum = 13500441;BA.debugLine="StepSize = Ceil(StepSize / 2)";
_stepsize = (int) (__c.Ceil(_stepsize/(double)2));
 }
;
RDebugUtils.currentLine=13500443;
 //BA.debugLineNum = 13500443;BA.debugLine="Return -1";
if (true) return (int) (-1);
RDebugUtils.currentLine=13500444;
 //BA.debugLineNum = 13500444;BA.debugLine="End Sub";
return 0;
}
public com.no3dlauncher.customlistview._clvitem  _getrawlistitem(com.no3dlauncher.customlistview __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getrawlistitem"))
	return (com.no3dlauncher.customlistview._clvitem) Debug.delegate(ba, "getrawlistitem", new Object[] {_index});
RDebugUtils.currentLine=12058624;
 //BA.debugLineNum = 12058624;BA.debugLine="Public Sub GetRawListItem(Index As Int) As CLVItem";
RDebugUtils.currentLine=12058625;
 //BA.debugLineNum = 12058625;BA.debugLine="Return items.Get(Index)";
if (true) return (com.no3dlauncher.customlistview._clvitem)(__ref._items.Get(_index));
RDebugUtils.currentLine=12058626;
 //BA.debugLineNum = 12058626;BA.debugLine="End Sub";
return null;
}
public int  _finditemoffset(com.no3dlauncher.customlistview __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "finditemoffset"))
	return (Integer) Debug.delegate(ba, "finditemoffset", new Object[] {_index});
RDebugUtils.currentLine=13434880;
 //BA.debugLineNum = 13434880;BA.debugLine="Private Sub FindItemOffset(Index As Int) As Int";
RDebugUtils.currentLine=13434881;
 //BA.debugLineNum = 13434881;BA.debugLine="Return GetRawListItem(Index).Offset";
if (true) return __ref._getrawlistitem(null,_index).Offset;
RDebugUtils.currentLine=13434882;
 //BA.debugLineNum = 13434882;BA.debugLine="End Sub";
return 0;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getbase(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getbase"))
	return (anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "getbase", null);
RDebugUtils.currentLine=11927552;
 //BA.debugLineNum = 11927552;BA.debugLine="Public Sub GetBase As B4XView";
RDebugUtils.currentLine=11927553;
 //BA.debugLineNum = 11927553;BA.debugLine="Return mBase";
if (true) return __ref._mbase;
RDebugUtils.currentLine=11927554;
 //BA.debugLineNum = 11927554;BA.debugLine="End Sub";
return null;
}
public float  _getdividersize(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getdividersize"))
	return (Float) Debug.delegate(ba, "getdividersize", null);
RDebugUtils.currentLine=13959168;
 //BA.debugLineNum = 13959168;BA.debugLine="Public Sub getDividerSize As Float";
RDebugUtils.currentLine=13959169;
 //BA.debugLineNum = 13959169;BA.debugLine="Return mDividerSize";
if (true) return __ref._mdividersize;
RDebugUtils.currentLine=13959170;
 //BA.debugLineNum = 13959170;BA.debugLine="End Sub";
return 0f;
}
public int  _getfirstvisibleindex(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getfirstvisibleindex"))
	return (Integer) Debug.delegate(ba, "getfirstvisibleindex", null);
RDebugUtils.currentLine=13565952;
 //BA.debugLineNum = 13565952;BA.debugLine="Public Sub getFirstVisibleIndex As Int";
RDebugUtils.currentLine=13565953;
 //BA.debugLineNum = 13565953;BA.debugLine="Return FindIndexFromOffset(GetScrollViewOffset +";
if (true) return __ref._findindexfromoffset(null,(int) (__ref._getscrollviewoffset(null)+__ref._mdividersize));
RDebugUtils.currentLine=13565954;
 //BA.debugLineNum = 13565954;BA.debugLine="End Sub";
return 0;
}
public float  _getscrollviewoffset(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getscrollviewoffset"))
	return (Float) Debug.delegate(ba, "getscrollviewoffset", null);
RDebugUtils.currentLine=12713984;
 //BA.debugLineNum = 12713984;BA.debugLine="Private Sub GetScrollViewOffset As Float";
RDebugUtils.currentLine=12713985;
 //BA.debugLineNum = 12713985;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12713986;
 //BA.debugLineNum = 12713986;BA.debugLine="Return sv.ScrollViewOffsetX";
if (true) return (float) (__ref._sv.getScrollViewOffsetX());
 }else {
RDebugUtils.currentLine=12713988;
 //BA.debugLineNum = 12713988;BA.debugLine="Return sv.ScrollViewOffsetY";
if (true) return (float) (__ref._sv.getScrollViewOffsetY());
 };
RDebugUtils.currentLine=12713990;
 //BA.debugLineNum = 12713990;BA.debugLine="End Sub";
return 0f;
}
public int  _getlastvisibleindex(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getlastvisibleindex"))
	return (Integer) Debug.delegate(ba, "getlastvisibleindex", null);
RDebugUtils.currentLine=13631488;
 //BA.debugLineNum = 13631488;BA.debugLine="Public Sub getLastVisibleIndex As Int";
RDebugUtils.currentLine=13631489;
 //BA.debugLineNum = 13631489;BA.debugLine="Return FindIndexFromOffset(GetScrollViewOffset +";
if (true) return __ref._findindexfromoffset(null,(int) (__ref._getscrollviewoffset(null)+__ref._getscrollviewvisiblesize(null)));
RDebugUtils.currentLine=13631490;
 //BA.debugLineNum = 13631490;BA.debugLine="End Sub";
return 0;
}
public float  _getscrollviewvisiblesize(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getscrollviewvisiblesize"))
	return (Float) Debug.delegate(ba, "getscrollviewvisiblesize", null);
RDebugUtils.currentLine=12648448;
 //BA.debugLineNum = 12648448;BA.debugLine="Private Sub GetScrollViewVisibleSize As Float";
RDebugUtils.currentLine=12648449;
 //BA.debugLineNum = 12648449;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12648450;
 //BA.debugLineNum = 12648450;BA.debugLine="Return sv.Width";
if (true) return (float) (__ref._sv.getWidth());
 }else {
RDebugUtils.currentLine=12648452;
 //BA.debugLineNum = 12648452;BA.debugLine="Return sv.Height";
if (true) return (float) (__ref._sv.getHeight());
 };
RDebugUtils.currentLine=12648454;
 //BA.debugLineNum = 12648454;BA.debugLine="End Sub";
return 0f;
}
public float  _getmaxscrolloffset(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getmaxscrolloffset"))
	return (Float) Debug.delegate(ba, "getmaxscrolloffset", null);
RDebugUtils.currentLine=13303808;
 //BA.debugLineNum = 13303808;BA.debugLine="Private Sub GetMaxScrollOffset As Float";
RDebugUtils.currentLine=13303809;
 //BA.debugLineNum = 13303809;BA.debugLine="Return GetScrollViewContentSize - GetScrollViewVi";
if (true) return (float) (__ref._getscrollviewcontentsize(null)-__ref._getscrollviewvisiblesize(null));
RDebugUtils.currentLine=13303810;
 //BA.debugLineNum = 13303810;BA.debugLine="End Sub";
return 0f;
}
public float  _getscrollviewcontentsize(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getscrollviewcontentsize"))
	return (Float) Debug.delegate(ba, "getscrollviewcontentsize", null);
RDebugUtils.currentLine=12845056;
 //BA.debugLineNum = 12845056;BA.debugLine="Private Sub GetScrollViewContentSize As Float";
RDebugUtils.currentLine=12845057;
 //BA.debugLineNum = 12845057;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12845058;
 //BA.debugLineNum = 12845058;BA.debugLine="Return sv.ScrollViewContentWidth";
if (true) return (float) (__ref._sv.getScrollViewContentWidth());
 }else {
RDebugUtils.currentLine=12845060;
 //BA.debugLineNum = 12845060;BA.debugLine="Return sv.ScrollViewContentHeight";
if (true) return (float) (__ref._sv.getScrollViewContentHeight());
 };
RDebugUtils.currentLine=12845062;
 //BA.debugLineNum = 12845062;BA.debugLine="End Sub";
return 0f;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _getpanel(com.no3dlauncher.customlistview __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getpanel"))
	return (anywheresoftware.b4a.objects.B4XViewWrapper) Debug.delegate(ba, "getpanel", new Object[] {_index});
RDebugUtils.currentLine=12124160;
 //BA.debugLineNum = 12124160;BA.debugLine="Public Sub GetPanel(Index As Int) As B4XView";
RDebugUtils.currentLine=12124161;
 //BA.debugLineNum = 12124161;BA.debugLine="Return GetRawListItem(Index).Panel.GetView(0)";
if (true) return __ref._getrawlistitem(null,_index).Panel.GetView((int) (0));
RDebugUtils.currentLine=12124162;
 //BA.debugLineNum = 12124162;BA.debugLine="End Sub";
return null;
}
public int  _getsize(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getsize"))
	return (Integer) Debug.delegate(ba, "getsize", null);
RDebugUtils.currentLine=11993088;
 //BA.debugLineNum = 11993088;BA.debugLine="Public Sub getSize As Int";
RDebugUtils.currentLine=11993089;
 //BA.debugLineNum = 11993089;BA.debugLine="Return items.Size";
if (true) return __ref._items.getSize();
RDebugUtils.currentLine=11993090;
 //BA.debugLineNum = 11993090;BA.debugLine="End Sub";
return 0;
}
public Object  _getvalue(com.no3dlauncher.customlistview __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "getvalue"))
	return (Object) Debug.delegate(ba, "getvalue", new Object[] {_index});
RDebugUtils.currentLine=12189696;
 //BA.debugLineNum = 12189696;BA.debugLine="Public Sub GetValue(Index As Int) As Object";
RDebugUtils.currentLine=12189697;
 //BA.debugLineNum = 12189697;BA.debugLine="Return GetRawListItem(Index).Value";
if (true) return __ref._getrawlistitem(null,_index).Value;
RDebugUtils.currentLine=12189698;
 //BA.debugLineNum = 12189698;BA.debugLine="End Sub";
return null;
}
public String  _initialize(com.no3dlauncher.customlistview __ref,anywheresoftware.b4a.BA _ba,Object _vcallback,String _veventname) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "initialize"))
	return (String) Debug.delegate(ba, "initialize", new Object[] {_ba,_vcallback,_veventname});
RDebugUtils.currentLine=11468800;
 //BA.debugLineNum = 11468800;BA.debugLine="Public Sub Initialize (vCallBack As Object, vEvent";
RDebugUtils.currentLine=11468801;
 //BA.debugLineNum = 11468801;BA.debugLine="EventName = vEventName";
__ref._eventname = _veventname;
RDebugUtils.currentLine=11468802;
 //BA.debugLineNum = 11468802;BA.debugLine="CallBack = vCallBack";
__ref._callback = _vcallback;
RDebugUtils.currentLine=11468803;
 //BA.debugLineNum = 11468803;BA.debugLine="items.Initialize";
__ref._items.Initialize();
RDebugUtils.currentLine=11468804;
 //BA.debugLineNum = 11468804;BA.debugLine="DefaultTextBackgroundColor = xui.Color_White";
__ref._defaulttextbackgroundcolor = __ref._xui.Color_White;
RDebugUtils.currentLine=11468805;
 //BA.debugLineNum = 11468805;BA.debugLine="DefaultTextColor = xui.Color_Black";
__ref._defaulttextcolor = __ref._xui.Color_Black;
RDebugUtils.currentLine=11468806;
 //BA.debugLineNum = 11468806;BA.debugLine="MonitorVisibleRange = xui.SubExists(CallBack, Eve";
__ref._monitorvisiblerange = __ref._xui.SubExists(ba,__ref._callback,__ref._eventname+"_VisibleRangeChanged",(int) (2));
RDebugUtils.currentLine=11468807;
 //BA.debugLineNum = 11468807;BA.debugLine="FireScrollChanged = xui.SubExists(CallBack, Event";
__ref._firescrollchanged = __ref._xui.SubExists(ba,__ref._callback,__ref._eventname+"_ScrollChanged",(int) (1));
RDebugUtils.currentLine=11468808;
 //BA.debugLineNum = 11468808;BA.debugLine="ResetVisibles";
__ref._resetvisibles(null);
RDebugUtils.currentLine=11468809;
 //BA.debugLineNum = 11468809;BA.debugLine="End Sub";
return "";
}
public String  _insertatimpl(com.no3dlauncher.customlistview __ref,int _index,anywheresoftware.b4a.objects.B4XViewWrapper _pnl,int _itemsize,Object _value,int _initialsize) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "insertatimpl"))
	return (String) Debug.delegate(ba, "insertatimpl", new Object[] {_index,_pnl,_itemsize,_value,_initialsize});
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
int _includedividierheight = 0;
com.no3dlauncher.customlistview._clvitem _newitem = null;
int _offset = 0;
com.no3dlauncher.customlistview._clvitem _previtem = null;
int _i = 0;
com.no3dlauncher.customlistview._clvitem _it = null;
int _newoffset = 0;
RDebugUtils.currentLine=12517376;
 //BA.debugLineNum = 12517376;BA.debugLine="Private Sub InsertAtImpl(Index As Int, Pnl As B4XV";
RDebugUtils.currentLine=12517378;
 //BA.debugLineNum = 12517378;BA.debugLine="Dim p As B4XView = CreatePanel(\"Panel\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = __ref._createpanel(null,"Panel");
RDebugUtils.currentLine=12517379;
 //BA.debugLineNum = 12517379;BA.debugLine="p.Color = Pnl.Color";
_p.setColor(_pnl.getColor());
RDebugUtils.currentLine=12517380;
 //BA.debugLineNum = 12517380;BA.debugLine="Pnl.Color = xui.Color_Transparent";
_pnl.setColor(__ref._xui.Color_Transparent);
RDebugUtils.currentLine=12517381;
 //BA.debugLineNum = 12517381;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12517382;
 //BA.debugLineNum = 12517382;BA.debugLine="p.AddView(Pnl, 0, 0, ItemSize, sv.ScrollViewCont";
_p.AddView((android.view.View)(_pnl.getObject()),(int) (0),(int) (0),_itemsize,__ref._sv.getScrollViewContentHeight());
 }else {
RDebugUtils.currentLine=12517384;
 //BA.debugLineNum = 12517384;BA.debugLine="p.AddView(Pnl, 0, 0, sv.ScrollViewContentWidth,";
_p.AddView((android.view.View)(_pnl.getObject()),(int) (0),(int) (0),__ref._sv.getScrollViewContentWidth(),_itemsize);
 };
RDebugUtils.currentLine=12517386;
 //BA.debugLineNum = 12517386;BA.debugLine="p.Tag = Index";
_p.setTag((Object)(_index));
RDebugUtils.currentLine=12517387;
 //BA.debugLineNum = 12517387;BA.debugLine="Dim IncludeDividierHeight As Int";
_includedividierheight = 0;
RDebugUtils.currentLine=12517388;
 //BA.debugLineNum = 12517388;BA.debugLine="If InitialSize = 0 Then IncludeDividierHeight = m";
if (_initialsize==0) { 
_includedividierheight = (int) (__ref._mdividersize);}
else {
_includedividierheight = (int) (0);};
RDebugUtils.currentLine=12517389;
 //BA.debugLineNum = 12517389;BA.debugLine="Dim NewItem As CLVItem";
_newitem = new com.no3dlauncher.customlistview._clvitem();
RDebugUtils.currentLine=12517390;
 //BA.debugLineNum = 12517390;BA.debugLine="NewItem.Panel = p";
_newitem.Panel = _p;
RDebugUtils.currentLine=12517391;
 //BA.debugLineNum = 12517391;BA.debugLine="NewItem.Size = ItemSize";
_newitem.Size = _itemsize;
RDebugUtils.currentLine=12517392;
 //BA.debugLineNum = 12517392;BA.debugLine="NewItem.Value = Value";
_newitem.Value = _value;
RDebugUtils.currentLine=12517393;
 //BA.debugLineNum = 12517393;BA.debugLine="NewItem.Color = p.Color";
_newitem.Color = _p.getColor();
RDebugUtils.currentLine=12517394;
 //BA.debugLineNum = 12517394;BA.debugLine="If Index = items.Size And InitialSize = 0 Then";
if (_index==__ref._items.getSize() && _initialsize==0) { 
RDebugUtils.currentLine=12517395;
 //BA.debugLineNum = 12517395;BA.debugLine="items.Add(NewItem)";
__ref._items.Add((Object)(_newitem));
RDebugUtils.currentLine=12517396;
 //BA.debugLineNum = 12517396;BA.debugLine="Dim offset As Int";
_offset = 0;
RDebugUtils.currentLine=12517397;
 //BA.debugLineNum = 12517397;BA.debugLine="If Index = 0 Then";
if (_index==0) { 
RDebugUtils.currentLine=12517398;
 //BA.debugLineNum = 12517398;BA.debugLine="offset = mDividerSize";
_offset = (int) (__ref._mdividersize);
 }else {
RDebugUtils.currentLine=12517400;
 //BA.debugLineNum = 12517400;BA.debugLine="offset = GetScrollViewContentSize";
_offset = (int) (__ref._getscrollviewcontentsize(null));
 };
RDebugUtils.currentLine=12517402;
 //BA.debugLineNum = 12517402;BA.debugLine="NewItem.Offset = offset";
_newitem.Offset = _offset;
RDebugUtils.currentLine=12517403;
 //BA.debugLineNum = 12517403;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12517404;
 //BA.debugLineNum = 12517404;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, offset, 0, I";
__ref._sv.getScrollViewInnerPanel().AddView((android.view.View)(_p.getObject()),_offset,(int) (0),_itemsize,__ref._sv.getHeight());
 }else {
RDebugUtils.currentLine=12517406;
 //BA.debugLineNum = 12517406;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, 0, offset, s";
__ref._sv.getScrollViewInnerPanel().AddView((android.view.View)(_p.getObject()),(int) (0),_offset,__ref._sv.getWidth(),_itemsize);
 };
 }else {
RDebugUtils.currentLine=12517409;
 //BA.debugLineNum = 12517409;BA.debugLine="Dim offset As Int";
_offset = 0;
RDebugUtils.currentLine=12517410;
 //BA.debugLineNum = 12517410;BA.debugLine="If Index = 0 Then";
if (_index==0) { 
RDebugUtils.currentLine=12517411;
 //BA.debugLineNum = 12517411;BA.debugLine="offset = mDividerSize";
_offset = (int) (__ref._mdividersize);
 }else {
RDebugUtils.currentLine=12517413;
 //BA.debugLineNum = 12517413;BA.debugLine="Dim PrevItem As CLVItem = items.Get(Index - 1)";
_previtem = (com.no3dlauncher.customlistview._clvitem)(__ref._items.Get((int) (_index-1)));
RDebugUtils.currentLine=12517414;
 //BA.debugLineNum = 12517414;BA.debugLine="offset = PrevItem.Offset + PrevItem.Size + mDiv";
_offset = (int) (_previtem.Offset+_previtem.Size+__ref._mdividersize);
 };
RDebugUtils.currentLine=12517416;
 //BA.debugLineNum = 12517416;BA.debugLine="For i = Index To items.Size - 1";
{
final int step39 = 1;
final int limit39 = (int) (__ref._items.getSize()-1);
_i = _index ;
for (;(step39 > 0 && _i <= limit39) || (step39 < 0 && _i >= limit39) ;_i = ((int)(0 + _i + step39))  ) {
RDebugUtils.currentLine=12517417;
 //BA.debugLineNum = 12517417;BA.debugLine="Dim It As CLVItem = items.Get(i)";
_it = (com.no3dlauncher.customlistview._clvitem)(__ref._items.Get(_i));
RDebugUtils.currentLine=12517418;
 //BA.debugLineNum = 12517418;BA.debugLine="Dim NewOffset As Int = It.Offset + ItemSize - I";
_newoffset = (int) (_it.Offset+_itemsize-_initialsize+_includedividierheight);
RDebugUtils.currentLine=12517419;
 //BA.debugLineNum = 12517419;BA.debugLine="If Min(NewOffset, It.Offset) - GetScrollViewOff";
if (__c.Min(_newoffset,_it.Offset)-__ref._getscrollviewoffset(null)<__ref._getscrollviewvisiblesize(null)) { 
RDebugUtils.currentLine=12517420;
 //BA.debugLineNum = 12517420;BA.debugLine="It.Offset = NewOffset";
_it.Offset = _newoffset;
RDebugUtils.currentLine=12517421;
 //BA.debugLineNum = 12517421;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12517422;
 //BA.debugLineNum = 12517422;BA.debugLine="It.Panel.SetLayoutAnimated(AnimationDuration,";
_it.Panel.SetLayoutAnimated(__ref._animationduration,_newoffset,(int) (0),_it.Size,_it.Panel.getHeight());
 }else {
RDebugUtils.currentLine=12517424;
 //BA.debugLineNum = 12517424;BA.debugLine="It.Panel.SetLayoutAnimated(AnimationDuration,";
_it.Panel.SetLayoutAnimated(__ref._animationduration,(int) (0),_newoffset,_it.Panel.getWidth(),_it.Size);
 };
 }else {
RDebugUtils.currentLine=12517427;
 //BA.debugLineNum = 12517427;BA.debugLine="SetItemOffset(It, NewOffset)";
__ref._setitemoffset(null,_it,(float) (_newoffset));
 };
RDebugUtils.currentLine=12517429;
 //BA.debugLineNum = 12517429;BA.debugLine="It.Panel.Tag = i + 1";
_it.Panel.setTag((Object)(_i+1));
 }
};
RDebugUtils.currentLine=12517431;
 //BA.debugLineNum = 12517431;BA.debugLine="items.InsertAt(Index, NewItem)";
__ref._items.InsertAt(_index,(Object)(_newitem));
RDebugUtils.currentLine=12517432;
 //BA.debugLineNum = 12517432;BA.debugLine="NewItem.Offset = offset";
_newitem.Offset = _offset;
RDebugUtils.currentLine=12517433;
 //BA.debugLineNum = 12517433;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12517434;
 //BA.debugLineNum = 12517434;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, offset, 0, I";
__ref._sv.getScrollViewInnerPanel().AddView((android.view.View)(_p.getObject()),_offset,(int) (0),_initialsize,__ref._sv.getHeight());
RDebugUtils.currentLine=12517435;
 //BA.debugLineNum = 12517435;BA.debugLine="p.SetLayoutAnimated(AnimationDuration, offset,";
_p.SetLayoutAnimated(__ref._animationduration,_offset,(int) (0),_itemsize,_p.getHeight());
 }else {
RDebugUtils.currentLine=12517437;
 //BA.debugLineNum = 12517437;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, 0, offset, s";
__ref._sv.getScrollViewInnerPanel().AddView((android.view.View)(_p.getObject()),(int) (0),_offset,__ref._sv.getWidth(),_initialsize);
RDebugUtils.currentLine=12517438;
 //BA.debugLineNum = 12517438;BA.debugLine="p.SetLayoutAnimated(AnimationDuration, 0, offse";
_p.SetLayoutAnimated(__ref._animationduration,(int) (0),_offset,_p.getWidth(),_itemsize);
 };
 };
RDebugUtils.currentLine=12517441;
 //BA.debugLineNum = 12517441;BA.debugLine="SetScrollViewContentSize(GetScrollViewContentSize";
__ref._setscrollviewcontentsize(null,(float) (__ref._getscrollviewcontentsize(null)+_itemsize-_initialsize+_includedividierheight));
RDebugUtils.currentLine=12517442;
 //BA.debugLineNum = 12517442;BA.debugLine="If items.Size = 1 Then SetScrollViewContentSize(G";
if (__ref._items.getSize()==1) { 
__ref._setscrollviewcontentsize(null,(float) (__ref._getscrollviewcontentsize(null)+_includedividierheight));};
RDebugUtils.currentLine=12517443;
 //BA.debugLineNum = 12517443;BA.debugLine="If Index < mLastVisibleIndex Or GetRawListItem(mL";
if (_index<__ref._mlastvisibleindex || __ref._getrawlistitem(null,__ref._mlastvisibleindex).Offset+__ref._getrawlistitem(null,__ref._mlastvisibleindex).Size+__ref._mdividersize<__ref._getscrollviewvisiblesize(null)) { 
RDebugUtils.currentLine=12517445;
 //BA.debugLineNum = 12517445;BA.debugLine="UpdateVisibleRange";
__ref._updatevisiblerange(null);
 };
RDebugUtils.currentLine=12517447;
 //BA.debugLineNum = 12517447;BA.debugLine="End Sub";
return "";
}
public String  _setitemoffset(com.no3dlauncher.customlistview __ref,com.no3dlauncher.customlistview._clvitem _item,float _offset) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "setitemoffset"))
	return (String) Debug.delegate(ba, "setitemoffset", new Object[] {_item,_offset});
RDebugUtils.currentLine=12976128;
 //BA.debugLineNum = 12976128;BA.debugLine="Private Sub SetItemOffset (item As CLVItem, offset";
RDebugUtils.currentLine=12976129;
 //BA.debugLineNum = 12976129;BA.debugLine="item.Offset = offset";
_item.Offset = (int) (_offset);
RDebugUtils.currentLine=12976130;
 //BA.debugLineNum = 12976130;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12976131;
 //BA.debugLineNum = 12976131;BA.debugLine="item.Panel.Left = offset";
_item.Panel.setLeft((int) (_offset));
 }else {
RDebugUtils.currentLine=12976133;
 //BA.debugLineNum = 12976133;BA.debugLine="item.Panel.Top = offset";
_item.Panel.setTop((int) (_offset));
 };
RDebugUtils.currentLine=12976135;
 //BA.debugLineNum = 12976135;BA.debugLine="End Sub";
return "";
}
public String  _jumptoitem(com.no3dlauncher.customlistview __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "jumptoitem"))
	return (String) Debug.delegate(ba, "jumptoitem", new Object[] {_index});
RDebugUtils.currentLine=13238272;
 //BA.debugLineNum = 13238272;BA.debugLine="Public Sub JumpToItem(Index As Int)";
RDebugUtils.currentLine=13238273;
 //BA.debugLineNum = 13238273;BA.debugLine="SetScrollViewOffset(Min(GetMaxScrollOffset, FindI";
__ref._setscrollviewoffset(null,(float) (__c.Min(__ref._getmaxscrolloffset(null),__ref._finditemoffset(null,_index))));
RDebugUtils.currentLine=13238274;
 //BA.debugLineNum = 13238274;BA.debugLine="End Sub";
return "";
}
public String  _setscrollviewoffset(com.no3dlauncher.customlistview __ref,float _offset) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "setscrollviewoffset"))
	return (String) Debug.delegate(ba, "setscrollviewoffset", new Object[] {_offset});
RDebugUtils.currentLine=12779520;
 //BA.debugLineNum = 12779520;BA.debugLine="Private Sub SetScrollViewOffset(offset As Float)";
RDebugUtils.currentLine=12779521;
 //BA.debugLineNum = 12779521;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=12779522;
 //BA.debugLineNum = 12779522;BA.debugLine="sv.ScrollViewOffsetX = offset";
__ref._sv.setScrollViewOffsetX((int) (_offset));
 }else {
RDebugUtils.currentLine=12779524;
 //BA.debugLineNum = 12779524;BA.debugLine="sv.ScrollViewOffsetY = offset";
__ref._sv.setScrollViewOffsetY((int) (_offset));
 };
RDebugUtils.currentLine=12779526;
 //BA.debugLineNum = 12779526;BA.debugLine="End Sub";
return "";
}
public String  _panel_click(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "panel_click"))
	return (String) Debug.delegate(ba, "panel_click", null);
RDebugUtils.currentLine=14090240;
 //BA.debugLineNum = 14090240;BA.debugLine="Private Sub Panel_Click";
RDebugUtils.currentLine=14090241;
 //BA.debugLineNum = 14090241;BA.debugLine="PanelClickHandler(Sender)";
__ref._panelclickhandler(null,(anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))));
RDebugUtils.currentLine=14090242;
 //BA.debugLineNum = 14090242;BA.debugLine="End Sub";
return "";
}
public void  _panelclickhandler(com.no3dlauncher.customlistview __ref,anywheresoftware.b4a.objects.B4XViewWrapper _senderpanel) throws Exception{
ResumableSub_PanelClickHandler rsub = new ResumableSub_PanelClickHandler(this,__ref,_senderpanel);
rsub.resume(ba, null);
}
public static class ResumableSub_PanelClickHandler extends BA.ResumableSub {
public ResumableSub_PanelClickHandler(com.no3dlauncher.customlistview parent,com.no3dlauncher.customlistview __ref,anywheresoftware.b4a.objects.B4XViewWrapper _senderpanel) {
this.parent = parent;
this.__ref = __ref;
this._senderpanel = _senderpanel;
}
com.no3dlauncher.customlistview __ref;
com.no3dlauncher.customlistview parent;
anywheresoftware.b4a.objects.B4XViewWrapper _senderpanel;
int _clr = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="customlistview";
Debug.delegate(ba, "panelclickhandler", new Object[] {_senderpanel});
if (true) return;
    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=13697025;
 //BA.debugLineNum = 13697025;BA.debugLine="Dim clr As Int = GetRawListItem(SenderPanel.Tag).";
_clr = __ref._getrawlistitem(null,(int)(BA.ObjectToNumber(_senderpanel.getTag()))).Color;
RDebugUtils.currentLine=13697026;
 //BA.debugLineNum = 13697026;BA.debugLine="SenderPanel.SetColorAnimated(50, clr, PressedColo";
_senderpanel.SetColorAnimated((int) (50),_clr,__ref._pressedcolor);
RDebugUtils.currentLine=13697027;
 //BA.debugLineNum = 13697027;BA.debugLine="If xui.SubExists(CallBack, EventName & \"_ItemClic";
if (true) break;

case 1:
//if
this.state = 4;
if (__ref._xui.SubExists(ba,__ref._callback,__ref._eventname+"_ItemClick",(int) (2))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=13697028;
 //BA.debugLineNum = 13697028;BA.debugLine="CallSub3(CallBack, EventName & \"_ItemClick\", Sen";
parent.__c.CallSubNew3(ba,__ref._callback,__ref._eventname+"_ItemClick",_senderpanel.getTag(),__ref._getrawlistitem(null,(int)(BA.ObjectToNumber(_senderpanel.getTag()))).Value);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=13697030;
 //BA.debugLineNum = 13697030;BA.debugLine="Sleep(200)";
parent.__c.Sleep(ba,this,(int) (200));
this.state = 5;
return;
case 5:
//C
this.state = -1;
;
RDebugUtils.currentLine=13697031;
 //BA.debugLineNum = 13697031;BA.debugLine="SenderPanel.SetColorAnimated(200, PressedColor, c";
_senderpanel.SetColorAnimated((int) (200),__ref._pressedcolor,_clr);
RDebugUtils.currentLine=13697032;
 //BA.debugLineNum = 13697032;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _refresh(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "refresh"))
	return (String) Debug.delegate(ba, "refresh", null);
RDebugUtils.currentLine=11599872;
 //BA.debugLineNum = 11599872;BA.debugLine="Public Sub Refresh";
RDebugUtils.currentLine=11599873;
 //BA.debugLineNum = 11599873;BA.debugLine="ResetVisibles";
__ref._resetvisibles(null);
RDebugUtils.currentLine=11599874;
 //BA.debugLineNum = 11599874;BA.debugLine="UpdateVisibleRange";
__ref._updatevisiblerange(null);
RDebugUtils.currentLine=11599875;
 //BA.debugLineNum = 11599875;BA.debugLine="End Sub";
return "";
}
public String  _removeat(com.no3dlauncher.customlistview __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "removeat"))
	return (String) Debug.delegate(ba, "removeat", new Object[] {_index});
com.no3dlauncher.customlistview._clvitem _removeitem = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
int _i = 0;
com.no3dlauncher.customlistview._clvitem _item = null;
int _newoffset = 0;
RDebugUtils.currentLine=12255232;
 //BA.debugLineNum = 12255232;BA.debugLine="Public Sub RemoveAt(Index As Int)";
RDebugUtils.currentLine=12255233;
 //BA.debugLineNum = 12255233;BA.debugLine="If getSize <= 1 Then";
if (__ref._getsize(null)<=1) { 
RDebugUtils.currentLine=12255234;
 //BA.debugLineNum = 12255234;BA.debugLine="Clear";
__ref._clear(null);
RDebugUtils.currentLine=12255235;
 //BA.debugLineNum = 12255235;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=12255237;
 //BA.debugLineNum = 12255237;BA.debugLine="Dim RemoveItem As CLVItem = items.Get(Index)";
_removeitem = (com.no3dlauncher.customlistview._clvitem)(__ref._items.Get(_index));
RDebugUtils.currentLine=12255238;
 //BA.debugLineNum = 12255238;BA.debugLine="Dim p As B4XView";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=12255239;
 //BA.debugLineNum = 12255239;BA.debugLine="For i = Index + 1 To items.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (__ref._items.getSize()-1);
_i = (int) (_index+1) ;
for (;(step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7) ;_i = ((int)(0 + _i + step7))  ) {
RDebugUtils.currentLine=12255240;
 //BA.debugLineNum = 12255240;BA.debugLine="Dim item As CLVItem = items.Get(i)";
_item = (com.no3dlauncher.customlistview._clvitem)(__ref._items.Get(_i));
RDebugUtils.currentLine=12255241;
 //BA.debugLineNum = 12255241;BA.debugLine="p = item.Panel";
_p = _item.Panel;
RDebugUtils.currentLine=12255242;
 //BA.debugLineNum = 12255242;BA.debugLine="p.Tag = i - 1";
_p.setTag((Object)(_i-1));
RDebugUtils.currentLine=12255243;
 //BA.debugLineNum = 12255243;BA.debugLine="Dim NewOffset As Int = item.Offset - RemoveItem.";
_newoffset = (int) (_item.Offset-_removeitem.Size-__ref._mdividersize);
RDebugUtils.currentLine=12255244;
 //BA.debugLineNum = 12255244;BA.debugLine="SetItemOffset(item, NewOffset)";
__ref._setitemoffset(null,_item,(float) (_newoffset));
 }
};
RDebugUtils.currentLine=12255246;
 //BA.debugLineNum = 12255246;BA.debugLine="SetScrollViewContentSize(GetScrollViewContentSize";
__ref._setscrollviewcontentsize(null,(float) (__ref._getscrollviewcontentsize(null)-_removeitem.Size-__ref._mdividersize));
RDebugUtils.currentLine=12255247;
 //BA.debugLineNum = 12255247;BA.debugLine="items.RemoveAt(Index)";
__ref._items.RemoveAt(_index);
RDebugUtils.currentLine=12255248;
 //BA.debugLineNum = 12255248;BA.debugLine="RemoveItem.Panel.RemoveViewFromParent";
_removeitem.Panel.RemoveViewFromParent();
RDebugUtils.currentLine=12255249;
 //BA.debugLineNum = 12255249;BA.debugLine="End Sub";
return "";
}
public String  _replaceat(com.no3dlauncher.customlistview __ref,int _index,anywheresoftware.b4a.objects.B4XViewWrapper _pnl,int _itemheight,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "replaceat"))
	return (String) Debug.delegate(ba, "replaceat", new Object[] {_index,_pnl,_itemheight,_value});
com.no3dlauncher.customlistview._clvitem _removeitem = null;
RDebugUtils.currentLine=13107200;
 //BA.debugLineNum = 13107200;BA.debugLine="Public Sub ReplaceAt(Index As Int, pnl As B4XView,";
RDebugUtils.currentLine=13107201;
 //BA.debugLineNum = 13107201;BA.debugLine="Dim RemoveItem As CLVItem = items.Get(Index)";
_removeitem = (com.no3dlauncher.customlistview._clvitem)(__ref._items.Get(_index));
RDebugUtils.currentLine=13107202;
 //BA.debugLineNum = 13107202;BA.debugLine="items.RemoveAt(Index)";
__ref._items.RemoveAt(_index);
RDebugUtils.currentLine=13107203;
 //BA.debugLineNum = 13107203;BA.debugLine="RemoveItem.Panel.RemoveViewFromParent";
_removeitem.Panel.RemoveViewFromParent();
RDebugUtils.currentLine=13107204;
 //BA.debugLineNum = 13107204;BA.debugLine="InsertAtImpl(Index, pnl, ItemHeight, Value, Remov";
__ref._insertatimpl(null,_index,_pnl,_itemheight,_value,_removeitem.Size);
RDebugUtils.currentLine=13107205;
 //BA.debugLineNum = 13107205;BA.debugLine="End Sub";
return "";
}
public String  _resizeitem(com.no3dlauncher.customlistview __ref,int _index,int _itemheight) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "resizeitem"))
	return (String) Debug.delegate(ba, "resizeitem", new Object[] {_index,_itemheight});
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
Object _value = null;
anywheresoftware.b4a.objects.B4XViewWrapper _parent = null;
RDebugUtils.currentLine=13041664;
 //BA.debugLineNum = 13041664;BA.debugLine="Public Sub ResizeItem(Index As Int, ItemHeight As";
RDebugUtils.currentLine=13041665;
 //BA.debugLineNum = 13041665;BA.debugLine="Dim p As B4XView = GetPanel(Index)";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = __ref._getpanel(null,_index);
RDebugUtils.currentLine=13041666;
 //BA.debugLineNum = 13041666;BA.debugLine="Dim value As Object = GetValue(Index)";
_value = __ref._getvalue(null,_index);
RDebugUtils.currentLine=13041667;
 //BA.debugLineNum = 13041667;BA.debugLine="Dim parent As B4XView = p.Parent";
_parent = new anywheresoftware.b4a.objects.B4XViewWrapper();
_parent = _p.getParent();
RDebugUtils.currentLine=13041668;
 //BA.debugLineNum = 13041668;BA.debugLine="p.Color = parent.Color";
_p.setColor(_parent.getColor());
RDebugUtils.currentLine=13041669;
 //BA.debugLineNum = 13041669;BA.debugLine="p.RemoveViewFromParent";
_p.RemoveViewFromParent();
RDebugUtils.currentLine=13041670;
 //BA.debugLineNum = 13041670;BA.debugLine="ReplaceAt(Index, p, ItemHeight, value)";
__ref._replaceat(null,_index,_p,_itemheight,_value);
RDebugUtils.currentLine=13041671;
 //BA.debugLineNum = 13041671;BA.debugLine="End Sub";
return "";
}
public String  _scrollhandler(com.no3dlauncher.customlistview __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "scrollhandler"))
	return (String) Debug.delegate(ba, "scrollhandler", null);
int _position = 0;
RDebugUtils.currentLine=13828096;
 //BA.debugLineNum = 13828096;BA.debugLine="Private Sub ScrollHandler";
RDebugUtils.currentLine=13828097;
 //BA.debugLineNum = 13828097;BA.debugLine="If items.Size = 0 Then Return";
if (__ref._items.getSize()==0) { 
if (true) return "";};
RDebugUtils.currentLine=13828098;
 //BA.debugLineNum = 13828098;BA.debugLine="Dim position As Int = GetScrollViewOffset";
_position = (int) (__ref._getscrollviewoffset(null));
RDebugUtils.currentLine=13828099;
 //BA.debugLineNum = 13828099;BA.debugLine="If position + GetScrollViewVisibleSize >= GetScro";
if (_position+__ref._getscrollviewvisiblesize(null)>=__ref._getscrollviewcontentsize(null)-__c.DipToCurrent((int) (5)) && __c.DateTime.getNow()>__ref._lastreachendevent+100) { 
RDebugUtils.currentLine=13828100;
 //BA.debugLineNum = 13828100;BA.debugLine="If xui.SubExists(CallBack, EventName & \"_ReachEn";
if (__ref._xui.SubExists(ba,__ref._callback,__ref._eventname+"_ReachEnd",(int) (0))) { 
RDebugUtils.currentLine=13828101;
 //BA.debugLineNum = 13828101;BA.debugLine="LastReachEndEvent = DateTime.Now";
__ref._lastreachendevent = __c.DateTime.getNow();
RDebugUtils.currentLine=13828102;
 //BA.debugLineNum = 13828102;BA.debugLine="CallSubDelayed(CallBack, EventName & \"_ReachEnd";
__c.CallSubDelayed(ba,__ref._callback,__ref._eventname+"_ReachEnd");
 }else {
RDebugUtils.currentLine=13828104;
 //BA.debugLineNum = 13828104;BA.debugLine="LastReachEndEvent = DateTime.Now + 1000 * DateT";
__ref._lastreachendevent = (long) (__c.DateTime.getNow()+1000*__c.DateTime.TicksPerDay);
 };
 };
RDebugUtils.currentLine=13828107;
 //BA.debugLineNum = 13828107;BA.debugLine="UpdateVisibleRange";
__ref._updatevisiblerange(null);
RDebugUtils.currentLine=13828108;
 //BA.debugLineNum = 13828108;BA.debugLine="If FireScrollChanged Then";
if (__ref._firescrollchanged) { 
RDebugUtils.currentLine=13828109;
 //BA.debugLineNum = 13828109;BA.debugLine="CallSub2(CallBack, EventName & \"_ScrollChanged\",";
__c.CallSubNew2(ba,__ref._callback,__ref._eventname+"_ScrollChanged",(Object)(_position));
 };
RDebugUtils.currentLine=13828111;
 //BA.debugLineNum = 13828111;BA.debugLine="End Sub";
return "";
}
public String  _scrolltoitem(com.no3dlauncher.customlistview __ref,int _index) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "scrolltoitem"))
	return (String) Debug.delegate(ba, "scrolltoitem", new Object[] {_index});
float _offset = 0f;
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hv = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _nsv = null;
RDebugUtils.currentLine=13369344;
 //BA.debugLineNum = 13369344;BA.debugLine="Public Sub ScrollToItem(Index As Int)";
RDebugUtils.currentLine=13369345;
 //BA.debugLineNum = 13369345;BA.debugLine="Dim offset As Float = Min(GetMaxScrollOffset, Fin";
_offset = (float) (__c.Min(__ref._getmaxscrolloffset(null),__ref._finditemoffset(null,_index)));
RDebugUtils.currentLine=13369357;
 //BA.debugLineNum = 13369357;BA.debugLine="If horizontal Then";
if (__ref._horizontal) { 
RDebugUtils.currentLine=13369358;
 //BA.debugLineNum = 13369358;BA.debugLine="Dim hv As HorizontalScrollView = sv";
_hv = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
_hv.setObject((android.widget.HorizontalScrollView)(__ref._sv.getObject()));
RDebugUtils.currentLine=13369359;
 //BA.debugLineNum = 13369359;BA.debugLine="hv.ScrollPosition = offset 'smooth scroll";
_hv.setScrollPosition((int) (_offset));
 }else {
RDebugUtils.currentLine=13369361;
 //BA.debugLineNum = 13369361;BA.debugLine="Dim nsv As ScrollView = sv";
_nsv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
_nsv.setObject((android.widget.ScrollView)(__ref._sv.getObject()));
RDebugUtils.currentLine=13369362;
 //BA.debugLineNum = 13369362;BA.debugLine="nsv.ScrollPosition = offset";
_nsv.setScrollPosition((int) (_offset));
 };
RDebugUtils.currentLine=13369365;
 //BA.debugLineNum = 13369365;BA.debugLine="End Sub";
return "";
}
public String  _sv_scrollchanged(com.no3dlauncher.customlistview __ref,int _position) throws Exception{
__ref = this;
RDebugUtils.currentModule="customlistview";
if (Debug.shouldDelegate(ba, "sv_scrollchanged"))
	return (String) Debug.delegate(ba, "sv_scrollchanged", new Object[] {_position});
RDebugUtils.currentLine=14155776;
 //BA.debugLineNum = 14155776;BA.debugLine="Private Sub sv_ScrollChanged(Position As Int)";
RDebugUtils.currentLine=14155777;
 //BA.debugLineNum = 14155777;BA.debugLine="ScrollHandler";
__ref._scrollhandler(null);
RDebugUtils.currentLine=14155778;
 //BA.debugLineNum = 14155778;BA.debugLine="End Sub";
return "";
}
}