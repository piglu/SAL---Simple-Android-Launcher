package com.no3dlauncher;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class keyvaluestore_subs_0 {


public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private sql1 As SQL";
keyvaluestore._sql1 = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL");__ref.setField("_sql1",keyvaluestore._sql1);
 //BA.debugLineNum = 4;BA.debugLine="Private ser As B4XSerializator";
keyvaluestore._ser = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.B4XSerializator");__ref.setField("_ser",keyvaluestore._ser);
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _close(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("Close (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,111);
if (RapidSub.canDelegate("close")) return __ref.runUserSub(false, "keyvaluestore","close", __ref);
 BA.debugLineNum = 111;BA.debugLine="Public Sub Close";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="sql1.Close";
Debug.ShouldStop(32768);
__ref.getField(false,"_sql1").runVoidMethod ("Close");
 BA.debugLineNum = 113;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _containskey(RemoteObject __ref,RemoteObject _key) throws Exception{
try {
		Debug.PushSubsStack("ContainsKey (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,98);
if (RapidSub.canDelegate("containskey")) return __ref.runUserSub(false, "keyvaluestore","containskey", __ref, _key);
Debug.locals.put("Key", _key);
 BA.debugLineNum = 98;BA.debugLine="Public Sub ContainsKey(Key As String) As Boolean";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="Return sql1.ExecQuerySingleResult2(\"SELECT count(";
Debug.ShouldStop(4);
if (true) return BA.ObjectToBoolean(RemoteObject.solveBoolean(">",BA.numberCast(double.class, __ref.getField(false,"_sql1").runMethod(true,"ExecQuerySingleResult2",(Object)(BA.ObjectToString("SELECT count(key) FROM main WHERE key = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {_key})))),BA.numberCast(double.class, 0)));
 BA.debugLineNum = 101;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createtable(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("CreateTable (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,117);
if (RapidSub.canDelegate("createtable")) return __ref.runUserSub(false, "keyvaluestore","createtable", __ref);
 BA.debugLineNum = 117;BA.debugLine="Private Sub CreateTable";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="sql1.ExecNonQuery(\"CREATE TABLE IF NOT EXISTS mai";
Debug.ShouldStop(2097152);
__ref.getField(false,"_sql1").runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("CREATE TABLE IF NOT EXISTS main(key TEXT PRIMARY KEY, value NONE)")));
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _deleteall(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("DeleteAll (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,104);
if (RapidSub.canDelegate("deleteall")) return __ref.runUserSub(false, "keyvaluestore","deleteall", __ref);
 BA.debugLineNum = 104;BA.debugLine="Public Sub DeleteAll";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="sql1.ExecNonQuery(\"DROP TABLE main\")";
Debug.ShouldStop(256);
__ref.getField(false,"_sql1").runVoidMethod ("ExecNonQuery",(Object)(RemoteObject.createImmutable("DROP TABLE main")));
 BA.debugLineNum = 106;BA.debugLine="CreateTable";
Debug.ShouldStop(512);
__ref.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_createtable");
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
public static RemoteObject  _get(RemoteObject __ref,RemoteObject _key) throws Exception{
try {
		Debug.PushSubsStack("Get (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,22);
if (RapidSub.canDelegate("get")) return __ref.runUserSub(false, "keyvaluestore","get", __ref, _key);
RemoteObject _rs = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _result = RemoteObject.declareNull("Object");
Debug.locals.put("Key", _key);
 BA.debugLineNum = 22;BA.debugLine="Public Sub Get(Key As String) As Object";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="Dim rs As ResultSet = sql1.ExecQuery2(\"SELECT val";
Debug.ShouldStop(4194304);
_rs = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_rs.setObject(__ref.getField(false,"_sql1").runMethod(false,"ExecQuery2",(Object)(BA.ObjectToString("SELECT value FROM main WHERE key = ?")),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {_key}))));Debug.locals.put("rs", _rs);
 BA.debugLineNum = 24;BA.debugLine="Dim result As Object = Null";
Debug.ShouldStop(8388608);
_result = keyvaluestore.__c.getField(false,"Null");Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 25;BA.debugLine="If rs.NextRow Then";
Debug.ShouldStop(16777216);
if (_rs.runMethod(true,"NextRow").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 26;BA.debugLine="result = ser.ConvertBytesToObject(rs.GetBlob2(0)";
Debug.ShouldStop(33554432);
_result = __ref.getField(false,"_ser").runMethod(false,"ConvertBytesToObject",(Object)(_rs.runMethod(false,"GetBlob2",(Object)(BA.numberCast(int.class, 0)))));Debug.locals.put("result", _result);
 };
 BA.debugLineNum = 28;BA.debugLine="rs.Close";
Debug.ShouldStop(134217728);
_rs.runVoidMethod ("Close");
 BA.debugLineNum = 29;BA.debugLine="Return result";
Debug.ShouldStop(268435456);
if (true) return _result;
 BA.debugLineNum = 30;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getbitmap(RemoteObject __ref,RemoteObject _key) throws Exception{
try {
		Debug.PushSubsStack("GetBitmap (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,68);
if (RapidSub.canDelegate("getbitmap")) return __ref.runUserSub(false, "keyvaluestore","getbitmap", __ref, _key);
RemoteObject _b = null;
RemoteObject _in = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");
RemoteObject _bmp = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("Key", _key);
 BA.debugLineNum = 68;BA.debugLine="Public Sub GetBitmap(Key As String) As Bitmap";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="Dim b() As Byte = Get(Key)";
Debug.ShouldStop(16);
_b = (__ref.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(_key)));Debug.locals.put("b", _b);Debug.locals.put("b", _b);
 BA.debugLineNum = 70;BA.debugLine="If b = Null Then Return Null";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("n",_b)) { 
if (true) return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper"), keyvaluestore.__c.getField(false,"Null"));};
 BA.debugLineNum = 71;BA.debugLine="Dim in As InputStream";
Debug.ShouldStop(64);
_in = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.InputStreamWrapper");Debug.locals.put("in", _in);
 BA.debugLineNum = 72;BA.debugLine="in.InitializeFromBytesArray(b, 0, b.Length)";
Debug.ShouldStop(128);
_in.runVoidMethod ("InitializeFromBytesArray",(Object)(_b),(Object)(BA.numberCast(int.class, 0)),(Object)(_b.getField(true,"length")));
 BA.debugLineNum = 73;BA.debugLine="Dim bmp As Bitmap";
Debug.ShouldStop(256);
_bmp = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("bmp", _bmp);
 BA.debugLineNum = 74;BA.debugLine="bmp.Initialize2(in)";
Debug.ShouldStop(512);
_bmp.runVoidMethod ("Initialize2",(Object)((_in.getObject())));
 BA.debugLineNum = 75;BA.debugLine="in.Close";
Debug.ShouldStop(1024);
_in.runVoidMethod ("Close");
 BA.debugLineNum = 76;BA.debugLine="Return bmp";
Debug.ShouldStop(2048);
if (true) return _bmp;
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdefault(RemoteObject __ref,RemoteObject _key,RemoteObject _defaultvalue) throws Exception{
try {
		Debug.PushSubsStack("GetDefault (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,32);
if (RapidSub.canDelegate("getdefault")) return __ref.runUserSub(false, "keyvaluestore","getdefault", __ref, _key, _defaultvalue);
RemoteObject _res = RemoteObject.declareNull("Object");
Debug.locals.put("Key", _key);
Debug.locals.put("DefaultValue", _defaultvalue);
 BA.debugLineNum = 32;BA.debugLine="Public Sub GetDefault(Key As String, DefaultValue";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 33;BA.debugLine="Dim res As Object = Get(Key)";
Debug.ShouldStop(1);
_res = __ref.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(_key));Debug.locals.put("res", _res);Debug.locals.put("res", _res);
 BA.debugLineNum = 34;BA.debugLine="If res = Null Then Return DefaultValue";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("n",_res)) { 
if (true) return _defaultvalue;};
 BA.debugLineNum = 35;BA.debugLine="Return res";
Debug.ShouldStop(4);
if (true) return _res;
 BA.debugLineNum = 36;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getencrypted(RemoteObject __ref,RemoteObject _key,RemoteObject _password) throws Exception{
try {
		Debug.PushSubsStack("GetEncrypted (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,48);
if (RapidSub.canDelegate("getencrypted")) return __ref.runUserSub(false, "keyvaluestore","getencrypted", __ref, _key, _password);
RemoteObject _cipher = RemoteObject.declareNull("anywheresoftware.b4a.object.B4XEncryption");
RemoteObject _b = null;
Debug.locals.put("Key", _key);
Debug.locals.put("Password", _password);
 BA.debugLineNum = 48;BA.debugLine="Public Sub GetEncrypted (Key As String, Password A";
Debug.ShouldStop(32768);
 BA.debugLineNum = 52;BA.debugLine="Dim cipher As B4XCipher";
Debug.ShouldStop(524288);
_cipher = RemoteObject.createNew ("anywheresoftware.b4a.object.B4XEncryption");Debug.locals.put("cipher", _cipher);
 BA.debugLineNum = 54;BA.debugLine="Dim b() As Byte = Get(Key)";
Debug.ShouldStop(2097152);
_b = (__ref.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_get",(Object)(_key)));Debug.locals.put("b", _b);Debug.locals.put("b", _b);
 BA.debugLineNum = 55;BA.debugLine="If b = Null Then Return Null";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("n",_b)) { 
if (true) return keyvaluestore.__c.getField(false,"Null");};
 BA.debugLineNum = 56;BA.debugLine="Return ser.ConvertBytesToObject(cipher.Decrypt(b,";
Debug.ShouldStop(8388608);
if (true) return __ref.getField(false,"_ser").runMethod(false,"ConvertBytesToObject",(Object)(_cipher.runMethod(false,"Decrypt",(Object)(_b),(Object)(_password))));
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba,RemoteObject _dir,RemoteObject _filename) throws Exception{
try {
		Debug.PushSubsStack("Initialize (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,8);
if (RapidSub.canDelegate("initialize")) return __ref.runUserSub(false, "keyvaluestore","initialize", __ref, _ba, _dir, _filename);
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
Debug.locals.put("Dir", _dir);
Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize (Dir As String, FileName As";
Debug.ShouldStop(128);
 BA.debugLineNum = 9;BA.debugLine="If sql1.IsInitialized Then sql1.Close";
Debug.ShouldStop(256);
if (__ref.getField(false,"_sql1").runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
__ref.getField(false,"_sql1").runVoidMethod ("Close");};
 BA.debugLineNum = 13;BA.debugLine="sql1.Initialize(Dir, FileName, True)";
Debug.ShouldStop(4096);
__ref.getField(false,"_sql1").runVoidMethod ("Initialize",(Object)(_dir),(Object)(_filename),(Object)(keyvaluestore.__c.getField(true,"True")));
 BA.debugLineNum = 15;BA.debugLine="CreateTable";
Debug.ShouldStop(16384);
__ref.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_createtable");
 BA.debugLineNum = 16;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _listkeys(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("ListKeys (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,86);
if (RapidSub.canDelegate("listkeys")) return __ref.runUserSub(false, "keyvaluestore","listkeys", __ref);
RemoteObject _c = RemoteObject.declareNull("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
 BA.debugLineNum = 86;BA.debugLine="Public Sub ListKeys As List";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="Dim c As ResultSet = sql1.ExecQuery(\"SELECT key F";
Debug.ShouldStop(4194304);
_c = RemoteObject.createNew ("anywheresoftware.b4a.sql.SQL.ResultSetWrapper");
_c.setObject(__ref.getField(false,"_sql1").runMethod(false,"ExecQuery",(Object)(RemoteObject.createImmutable("SELECT key FROM main"))));Debug.locals.put("c", _c);
 BA.debugLineNum = 88;BA.debugLine="Dim res As List";
Debug.ShouldStop(8388608);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("res", _res);
 BA.debugLineNum = 89;BA.debugLine="res.Initialize";
Debug.ShouldStop(16777216);
_res.runVoidMethod ("Initialize");
 BA.debugLineNum = 90;BA.debugLine="Do While c.NextRow";
Debug.ShouldStop(33554432);
while (_c.runMethod(true,"NextRow").<Boolean>get().booleanValue()) {
 BA.debugLineNum = 91;BA.debugLine="res.Add(c.GetString2(0))";
Debug.ShouldStop(67108864);
_res.runVoidMethod ("Add",(Object)((_c.runMethod(true,"GetString2",(Object)(BA.numberCast(int.class, 0))))));
 }
;
 BA.debugLineNum = 93;BA.debugLine="c.Close";
Debug.ShouldStop(268435456);
_c.runVoidMethod ("Close");
 BA.debugLineNum = 94;BA.debugLine="Return res";
Debug.ShouldStop(536870912);
if (true) return _res;
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _put(RemoteObject __ref,RemoteObject _key,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("Put (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,18);
if (RapidSub.canDelegate("put")) return __ref.runUserSub(false, "keyvaluestore","put", __ref, _key, _value);
Debug.locals.put("Key", _key);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 18;BA.debugLine="Public Sub Put(Key As String, Value As Object)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 19;BA.debugLine="sql1.ExecNonQuery2(\"INSERT OR REPLACE INTO main V";
Debug.ShouldStop(262144);
__ref.getField(false,"_sql1").runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("INSERT OR REPLACE INTO main VALUES(?, ?)")),(Object)(keyvaluestore.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_key),(__ref.getField(false,"_ser").runMethod(false,"ConvertObjectToBytes",(Object)(_value)))})))));
 BA.debugLineNum = 20;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _putbitmap(RemoteObject __ref,RemoteObject _key,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("PutBitmap (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,60);
if (RapidSub.canDelegate("putbitmap")) return __ref.runUserSub(false, "keyvaluestore","putbitmap", __ref, _key, _value);
RemoteObject _out = RemoteObject.declareNull("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");
Debug.locals.put("Key", _key);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 60;BA.debugLine="Public Sub PutBitmap(Key As String, Value As Bitma";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="Dim out As OutputStream";
Debug.ShouldStop(268435456);
_out = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper");Debug.locals.put("out", _out);
 BA.debugLineNum = 62;BA.debugLine="out.InitializeToBytesArray(0)";
Debug.ShouldStop(536870912);
_out.runVoidMethod ("InitializeToBytesArray",(Object)(BA.numberCast(int.class, 0)));
 BA.debugLineNum = 63;BA.debugLine="Value.WriteToStream(out, 100, \"PNG\")";
Debug.ShouldStop(1073741824);
_value.runVoidMethod ("WriteToStream",(Object)((_out.getObject())),(Object)(BA.numberCast(int.class, 100)),(Object)(BA.getEnumFromString(BA.getDeviceClass("android.graphics.Bitmap.CompressFormat"),RemoteObject.createImmutable("PNG"))));
 BA.debugLineNum = 64;BA.debugLine="Put(Key, out.ToBytesArray)";
Debug.ShouldStop(-2147483648);
__ref.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(_key),(Object)((_out.runMethod(false,"ToBytesArray"))));
 BA.debugLineNum = 65;BA.debugLine="out.Close";
Debug.ShouldStop(1);
_out.runVoidMethod ("Close");
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _putencrypted(RemoteObject __ref,RemoteObject _key,RemoteObject _value,RemoteObject _password) throws Exception{
try {
		Debug.PushSubsStack("PutEncrypted (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,38);
if (RapidSub.canDelegate("putencrypted")) return __ref.runUserSub(false, "keyvaluestore","putencrypted", __ref, _key, _value, _password);
RemoteObject _cipher = RemoteObject.declareNull("anywheresoftware.b4a.object.B4XEncryption");
Debug.locals.put("Key", _key);
Debug.locals.put("Value", _value);
Debug.locals.put("Password", _password);
 BA.debugLineNum = 38;BA.debugLine="Public Sub PutEncrypted (Key As String, Value As O";
Debug.ShouldStop(32);
 BA.debugLineNum = 42;BA.debugLine="Dim cipher As B4XCipher";
Debug.ShouldStop(512);
_cipher = RemoteObject.createNew ("anywheresoftware.b4a.object.B4XEncryption");Debug.locals.put("cipher", _cipher);
 BA.debugLineNum = 44;BA.debugLine="Put(Key, cipher.Encrypt(ser.ConvertObjectToBytes(";
Debug.ShouldStop(2048);
__ref.runClassMethod (com.no3dlauncher.keyvaluestore.class, "_put",(Object)(_key),(Object)((_cipher.runMethod(false,"Encrypt",(Object)(__ref.getField(false,"_ser").runMethod(false,"ConvertObjectToBytes",(Object)(_value))),(Object)(_password)))));
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _remove(RemoteObject __ref,RemoteObject _key) throws Exception{
try {
		Debug.PushSubsStack("Remove (keyvaluestore) ","keyvaluestore",8,__ref.getField(false, "ba"),__ref,81);
if (RapidSub.canDelegate("remove")) return __ref.runUserSub(false, "keyvaluestore","remove", __ref, _key);
Debug.locals.put("Key", _key);
 BA.debugLineNum = 81;BA.debugLine="Public Sub Remove(Key As String)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="sql1.ExecNonQuery2(\"DELETE FROM main WHERE key =";
Debug.ShouldStop(131072);
__ref.getField(false,"_sql1").runVoidMethod ("ExecNonQuery2",(Object)(BA.ObjectToString("DELETE FROM main WHERE key = ?")),(Object)(keyvaluestore.__c.runMethod(false, "ArrayToList", (Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_key)})))));
 BA.debugLineNum = 83;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}