package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class cm_subs_0 {


public static RemoteObject  _byte_to_object(RemoteObject _ba,RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("byte_to_object (cm) ","cm",6,_ba,cm.mostCurrent,39);
if (RapidSub.canDelegate("byte_to_object")) return cm.remoteMe.runUserSub(false, "cm","byte_to_object", _ba, _data);
RemoteObject _ser = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.B4XSerializator");
;
Debug.locals.put("data", _data);
 BA.debugLineNum = 39;BA.debugLine="Sub byte_to_object(data() As Byte)As Object";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="Dim ser As B4XSerializator";
Debug.ShouldStop(128);
_ser = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.B4XSerializator");Debug.locals.put("ser", _ser);
 BA.debugLineNum = 41;BA.debugLine="Return ser.ConvertBytesToObject(data)";
Debug.ShouldStop(256);
Debug.CheckDeviceExceptions();if (true) return _ser.runMethod(false,"ConvertBytesToObject",(Object)(_data));
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _obj2bool(RemoteObject _ba,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("obj2Bool (cm) ","cm",6,_ba,cm.mostCurrent,7);
if (RapidSub.canDelegate("obj2bool")) return cm.remoteMe.runUserSub(false, "cm","obj2bool", _ba, _value);
;
Debug.locals.put("value", _value);
 BA.debugLineNum = 7;BA.debugLine="Sub obj2Bool(value As Object) As Boolean";
Debug.ShouldStop(64);
 BA.debugLineNum = 8;BA.debugLine="If value = Null Then Return False";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("n",_value)) { 
Debug.CheckDeviceExceptions();if (true) return cm.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 9;BA.debugLine="If value=0 Then Return False";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_value,RemoteObject.createImmutable((0)))) { 
Debug.CheckDeviceExceptions();if (true) return cm.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 10;BA.debugLine="If value=False Then Return False";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_value,(cm.mostCurrent.__c.getField(true,"False")))) { 
Debug.CheckDeviceExceptions();if (true) return cm.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 11;BA.debugLine="If value=\"False\" Then Return False";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_value,RemoteObject.createImmutable(("False")))) { 
Debug.CheckDeviceExceptions();if (true) return cm.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 12;BA.debugLine="If value=\"false\" Then Return False";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_value,RemoteObject.createImmutable(("false")))) { 
Debug.CheckDeviceExceptions();if (true) return cm.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 13;BA.debugLine="Return True";
Debug.ShouldStop(4096);
Debug.CheckDeviceExceptions();if (true) return cm.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 14;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _object_to_byte(RemoteObject _ba,RemoteObject _obj) throws Exception{
try {
		Debug.PushSubsStack("object_to_byte (cm) ","cm",6,_ba,cm.mostCurrent,34);
if (RapidSub.canDelegate("object_to_byte")) return cm.remoteMe.runUserSub(false, "cm","object_to_byte", _ba, _obj);
RemoteObject _ser = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.B4XSerializator");
;
Debug.locals.put("obj", _obj);
 BA.debugLineNum = 34;BA.debugLine="Sub object_to_byte(obj As Object)As Byte()";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="Dim ser As B4XSerializator";
Debug.ShouldStop(4);
_ser = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.B4XSerializator");Debug.locals.put("ser", _ser);
 BA.debugLineNum = 36;BA.debugLine="Return ser.ConvertObjectToBytes(obj)";
Debug.ShouldStop(8);
Debug.CheckDeviceExceptions();if (true) return _ser.runMethod(false,"ConvertObjectToBytes",(Object)(_obj));
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public bc As ByteConverter";
cm._bc = RemoteObject.createNew ("anywheresoftware.b4a.agraham.byteconverter.ByteConverter");
 //BA.debugLineNum = 3;BA.debugLine="Public connect_type As Boolean";
cm._connect_type = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 4;BA.debugLine="Public myid as String";
cm._myid = RemoteObject.createImmutable("");
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _toint(RemoteObject _ba,RemoteObject _dig) throws Exception{
try {
		Debug.PushSubsStack("toint (cm) ","cm",6,_ba,cm.mostCurrent,16);
if (RapidSub.canDelegate("toint")) return cm.remoteMe.runUserSub(false, "cm","toint", _ba, _dig);
RemoteObject _i = RemoteObject.createImmutable(0);
;
Debug.locals.put("dig", _dig);
 BA.debugLineNum = 16;BA.debugLine="Sub toint(dig As String) As Int";
Debug.ShouldStop(32768);
 BA.debugLineNum = 17;BA.debugLine="Dim i As Int";
Debug.ShouldStop(65536);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 18;BA.debugLine="If IsNumber(dig) Then";
Debug.ShouldStop(131072);
if (cm.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_dig)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 19;BA.debugLine="i = dig";
Debug.ShouldStop(262144);
_i = BA.numberCast(int.class, _dig);Debug.locals.put("i", _i);
 }else {
 BA.debugLineNum = 21;BA.debugLine="i = 0";
Debug.ShouldStop(1048576);
_i = BA.numberCast(int.class, 0);Debug.locals.put("i", _i);
 };
 BA.debugLineNum = 23;BA.debugLine="Return i";
Debug.ShouldStop(4194304);
Debug.CheckDeviceExceptions();if (true) return _i;
 BA.debugLineNum = 24;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tolong(RemoteObject _ba,RemoteObject _dig) throws Exception{
try {
		Debug.PushSubsStack("tolong (cm) ","cm",6,_ba,cm.mostCurrent,25);
if (RapidSub.canDelegate("tolong")) return cm.remoteMe.runUserSub(false, "cm","tolong", _ba, _dig);
RemoteObject _i = RemoteObject.createImmutable(0L);
;
Debug.locals.put("dig", _dig);
 BA.debugLineNum = 25;BA.debugLine="Sub tolong(dig As String) As Int";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 26;BA.debugLine="Dim i As Long";
Debug.ShouldStop(33554432);
_i = RemoteObject.createImmutable(0L);Debug.locals.put("i", _i);
 BA.debugLineNum = 27;BA.debugLine="If IsNumber(dig) Then";
Debug.ShouldStop(67108864);
if (cm.mostCurrent.__c.runMethod(true,"IsNumber",(Object)(_dig)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 28;BA.debugLine="i = dig";
Debug.ShouldStop(134217728);
_i = BA.numberCast(long.class, _dig);Debug.locals.put("i", _i);
 }else {
 BA.debugLineNum = 30;BA.debugLine="i = 0";
Debug.ShouldStop(536870912);
_i = BA.numberCast(long.class, 0);Debug.locals.put("i", _i);
 };
 BA.debugLineNum = 32;BA.debugLine="Return i";
Debug.ShouldStop(-2147483648);
Debug.CheckDeviceExceptions();if (true) return BA.numberCast(int.class, _i);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable(0);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}