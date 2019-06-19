package com.no3dlauncher;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class f {
private static f mostCurrent = new f();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static com.no3dlauncher.keyvaluestore _kvs2 = null;
public static int _bojapozadine = 0;
public static String _wheellistfont = "";
public static int _showapps = 0;
public static int _fontzsize = 0;
public static int _bojafonta = 0;
public static int _trans = 0;
public static int _tipikone = 0;
public static int _brtocaka = 0;
public static int _brstranica = 0;
public static String _animstr = "";
public static int _sms_dani = 0;
public com.no3dlauncher.main _main = null;
public com.no3dlauncher.starter _starter = null;
public com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public com.no3dlauncher.search _search = null;
public com.no3dlauncher.notificationservice _notificationservice = null;
public com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public com.no3dlauncher.provjera _provjera = null;
public static String  _ucitajvrijednostiopt(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="f";
if (Debug.shouldDelegate(null, "ucitajvrijednostiopt", false))
	 {return ((String) Debug.delegate(null, "ucitajvrijednostiopt", new Object[] {_ba}));}
RDebugUtils.currentLine=9699328;
 //BA.debugLineNum = 9699328;BA.debugLine="Sub UcitajVrijednostiOpt";
RDebugUtils.currentLine=9699329;
 //BA.debugLineNum = 9699329;BA.debugLine="If kvs2.ContainsKey(\"bojaPozadine\") Then";
if (_kvs2._containskey(null,"bojaPozadine")) { 
RDebugUtils.currentLine=9699330;
 //BA.debugLineNum = 9699330;BA.debugLine="bojaPozadine = kvs2.Get(\"bojaPozadine\")";
_bojapozadine = (int)(BA.ObjectToNumber(_kvs2._get(null,"bojaPozadine")));
 }else {
RDebugUtils.currentLine=9699332;
 //BA.debugLineNum = 9699332;BA.debugLine="kvs2.Put(\"bojaPozadine\", bojaPozadine)";
_kvs2._put(null,"bojaPozadine",(Object)(_bojapozadine));
 };
RDebugUtils.currentLine=9699335;
 //BA.debugLineNum = 9699335;BA.debugLine="If kvs2.ContainsKey(\"wheelListFont\") Then";
if (_kvs2._containskey(null,"wheelListFont")) { 
RDebugUtils.currentLine=9699336;
 //BA.debugLineNum = 9699336;BA.debugLine="wheelListFont = kvs2.Get(\"wheelListFont\")";
_wheellistfont = BA.ObjectToString(_kvs2._get(null,"wheelListFont"));
 }else {
RDebugUtils.currentLine=9699338;
 //BA.debugLineNum = 9699338;BA.debugLine="kvs2.Put(\"wheelListFont\", wheelListFont)";
_kvs2._put(null,"wheelListFont",(Object)(_wheellistfont));
 };
RDebugUtils.currentLine=9699341;
 //BA.debugLineNum = 9699341;BA.debugLine="If kvs2.ContainsKey(\"showApps\") Then";
if (_kvs2._containskey(null,"showApps")) { 
RDebugUtils.currentLine=9699342;
 //BA.debugLineNum = 9699342;BA.debugLine="showApps = kvs2.Get(\"showApps\")";
_showapps = (int)(BA.ObjectToNumber(_kvs2._get(null,"showApps")));
 }else {
RDebugUtils.currentLine=9699344;
 //BA.debugLineNum = 9699344;BA.debugLine="kvs2.Put(\"showApps\", showApps)";
_kvs2._put(null,"showApps",(Object)(_showapps));
 };
RDebugUtils.currentLine=9699347;
 //BA.debugLineNum = 9699347;BA.debugLine="If kvs2.ContainsKey(\"fontzSize\") Then";
if (_kvs2._containskey(null,"fontzSize")) { 
RDebugUtils.currentLine=9699348;
 //BA.debugLineNum = 9699348;BA.debugLine="fontzSize = kvs2.Get(\"fontzSize\")";
_fontzsize = (int)(BA.ObjectToNumber(_kvs2._get(null,"fontzSize")));
 }else {
RDebugUtils.currentLine=9699350;
 //BA.debugLineNum = 9699350;BA.debugLine="kvs2.Put(\"fontzSize\", fontzSize)";
_kvs2._put(null,"fontzSize",(Object)(_fontzsize));
 };
RDebugUtils.currentLine=9699353;
 //BA.debugLineNum = 9699353;BA.debugLine="If kvs2.ContainsKey(\"bojaFonta\") Then";
if (_kvs2._containskey(null,"bojaFonta")) { 
RDebugUtils.currentLine=9699354;
 //BA.debugLineNum = 9699354;BA.debugLine="bojaFonta = kvs2.Get(\"bojaFonta\")";
_bojafonta = (int)(BA.ObjectToNumber(_kvs2._get(null,"bojaFonta")));
 }else {
RDebugUtils.currentLine=9699356;
 //BA.debugLineNum = 9699356;BA.debugLine="kvs2.Put(\"bojaFonta\", bojaFonta)";
_kvs2._put(null,"bojaFonta",(Object)(_bojafonta));
 };
RDebugUtils.currentLine=9699359;
 //BA.debugLineNum = 9699359;BA.debugLine="If kvs2.ContainsKey(\"trans\") = True Then";
if (_kvs2._containskey(null,"trans")==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=9699360;
 //BA.debugLineNum = 9699360;BA.debugLine="trans = kvs2.Get(\"trans\")";
_trans = (int)(BA.ObjectToNumber(_kvs2._get(null,"trans")));
 }else {
RDebugUtils.currentLine=9699362;
 //BA.debugLineNum = 9699362;BA.debugLine="kvs2.Put(\"trans\", trans)";
_kvs2._put(null,"trans",(Object)(_trans));
 };
RDebugUtils.currentLine=9699365;
 //BA.debugLineNum = 9699365;BA.debugLine="If kvs2.ContainsKey(\"tipIkone\") = True Then";
if (_kvs2._containskey(null,"tipIkone")==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=9699366;
 //BA.debugLineNum = 9699366;BA.debugLine="tipIkone = kvs2.Get(\"tipIkone\")";
_tipikone = (int)(BA.ObjectToNumber(_kvs2._get(null,"tipIkone")));
 }else {
RDebugUtils.currentLine=9699368;
 //BA.debugLineNum = 9699368;BA.debugLine="kvs2.Put(\"tipIkone\", tipIkone)";
_kvs2._put(null,"tipIkone",(Object)(_tipikone));
 };
RDebugUtils.currentLine=9699371;
 //BA.debugLineNum = 9699371;BA.debugLine="If kvs2.ContainsKey(\"brTocaka\") = True Then";
if (_kvs2._containskey(null,"brTocaka")==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=9699372;
 //BA.debugLineNum = 9699372;BA.debugLine="brTocaka = kvs2.Get(\"brTocaka\")";
_brtocaka = (int)(BA.ObjectToNumber(_kvs2._get(null,"brTocaka")));
 }else {
RDebugUtils.currentLine=9699374;
 //BA.debugLineNum = 9699374;BA.debugLine="kvs2.Put(\"brTocaka\", brTocaka)";
_kvs2._put(null,"brTocaka",(Object)(_brtocaka));
 };
RDebugUtils.currentLine=9699377;
 //BA.debugLineNum = 9699377;BA.debugLine="If kvs2.ContainsKey(\"brStranica\") = True Then";
if (_kvs2._containskey(null,"brStranica")==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=9699378;
 //BA.debugLineNum = 9699378;BA.debugLine="brStranica = kvs2.Get(\"brStranica\")";
_brstranica = (int)(BA.ObjectToNumber(_kvs2._get(null,"brStranica")));
 }else {
RDebugUtils.currentLine=9699380;
 //BA.debugLineNum = 9699380;BA.debugLine="kvs2.Put(\"brStranica\", brStranica)";
_kvs2._put(null,"brStranica",(Object)(_brstranica));
 };
RDebugUtils.currentLine=9699383;
 //BA.debugLineNum = 9699383;BA.debugLine="If kvs2.ContainsKey(\"animStr\") = True Then";
if (_kvs2._containskey(null,"animStr")==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=9699384;
 //BA.debugLineNum = 9699384;BA.debugLine="animStr = kvs2.Get(\"animStr\")";
_animstr = BA.ObjectToString(_kvs2._get(null,"animStr"));
 }else {
RDebugUtils.currentLine=9699386;
 //BA.debugLineNum = 9699386;BA.debugLine="kvs2.Put(\"animStr\", animStr)";
_kvs2._put(null,"animStr",(Object)(_animstr));
 };
RDebugUtils.currentLine=9699389;
 //BA.debugLineNum = 9699389;BA.debugLine="If kvs2.ContainsKey(\"sms_dani\") = True Then";
if (_kvs2._containskey(null,"sms_dani")==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=9699390;
 //BA.debugLineNum = 9699390;BA.debugLine="sms_dani = kvs2.Get(\"sms_dani\")";
_sms_dani = (int)(BA.ObjectToNumber(_kvs2._get(null,"sms_dani")));
 }else {
RDebugUtils.currentLine=9699392;
 //BA.debugLineNum = 9699392;BA.debugLine="kvs2.Put(\"sms_dani\", sms_dani)";
_kvs2._put(null,"sms_dani",(Object)(_sms_dani));
 };
RDebugUtils.currentLine=9699400;
 //BA.debugLineNum = 9699400;BA.debugLine="End Sub";
return "";
}
public static String  _initkvs2(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="f";
if (Debug.shouldDelegate(null, "initkvs2", false))
	 {return ((String) Debug.delegate(null, "initkvs2", new Object[] {_ba}));}
RDebugUtils.currentLine=9633792;
 //BA.debugLineNum = 9633792;BA.debugLine="Sub InitKVS2";
RDebugUtils.currentLine=9633793;
 //BA.debugLineNum = 9633793;BA.debugLine="kvs2.Initialize(File.DirInternal, \"opt\")";
_kvs2._initialize(null,(_ba.processBA == null ? _ba : _ba.processBA),anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"opt");
RDebugUtils.currentLine=9633794;
 //BA.debugLineNum = 9633794;BA.debugLine="End Sub";
return "";
}
public static String  _snimiopcije2(anywheresoftware.b4a.BA _ba,String _kljuc,int _i) throws Exception{
RDebugUtils.currentModule="f";
if (Debug.shouldDelegate(null, "snimiopcije2", false))
	 {return ((String) Debug.delegate(null, "snimiopcije2", new Object[] {_ba,_kljuc,_i}));}
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Sub SnimiOpcije2(kljuc As String, i As Int)";
RDebugUtils.currentLine=9830401;
 //BA.debugLineNum = 9830401;BA.debugLine="kvs2.Put(kljuc, i)";
_kvs2._put(null,_kljuc,(Object)(_i));
RDebugUtils.currentLine=9830402;
 //BA.debugLineNum = 9830402;BA.debugLine="End Sub";
return "";
}
public static String  _snimiopcije(anywheresoftware.b4a.BA _ba,String _kljuc,String _s) throws Exception{
RDebugUtils.currentModule="f";
if (Debug.shouldDelegate(null, "snimiopcije", false))
	 {return ((String) Debug.delegate(null, "snimiopcije", new Object[] {_ba,_kljuc,_s}));}
RDebugUtils.currentLine=9764864;
 //BA.debugLineNum = 9764864;BA.debugLine="Sub SnimiOpcije(kljuc As String, s As String)";
RDebugUtils.currentLine=9764865;
 //BA.debugLineNum = 9764865;BA.debugLine="kvs2.Put(kljuc, s)";
_kvs2._put(null,_kljuc,(Object)(_s));
RDebugUtils.currentLine=9764866;
 //BA.debugLineNum = 9764866;BA.debugLine="End Sub";
return "";
}
}