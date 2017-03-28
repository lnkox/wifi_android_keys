package lnk.wifi_keys;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class cm {
private static cm mostCurrent = new cm();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.agraham.byteconverter.ByteConverter _bc = null;
public static boolean _connect_type = false;
public static String _myid = "";
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public static int  _toint(anywheresoftware.b4a.BA _ba,String _dig) throws Exception{
RDebugUtils.currentModule="cm";
if (Debug.shouldDelegate("toint"))
	return (Integer) Debug.delegate(null, "toint", new Object[] {_ba,_dig});
int _i = 0;
RDebugUtils.currentLine=6684672;
 //BA.debugLineNum = 6684672;BA.debugLine="Sub toint(dig As String) As Int";
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="If IsNumber(dig) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_dig)) { 
RDebugUtils.currentLine=6684675;
 //BA.debugLineNum = 6684675;BA.debugLine="i = dig";
_i = (int)(Double.parseDouble(_dig));
 }else {
RDebugUtils.currentLine=6684677;
 //BA.debugLineNum = 6684677;BA.debugLine="i = 0";
_i = (int) (0);
 };
RDebugUtils.currentLine=6684679;
 //BA.debugLineNum = 6684679;BA.debugLine="Return i";
if (true) return _i;
RDebugUtils.currentLine=6684680;
 //BA.debugLineNum = 6684680;BA.debugLine="End Sub";
return 0;
}
public static boolean  _obj2bool(anywheresoftware.b4a.BA _ba,Object _value) throws Exception{
RDebugUtils.currentModule="cm";
if (Debug.shouldDelegate("obj2bool"))
	return (Boolean) Debug.delegate(null, "obj2bool", new Object[] {_ba,_value});
RDebugUtils.currentLine=6619136;
 //BA.debugLineNum = 6619136;BA.debugLine="Sub obj2Bool(value As Object) As Boolean";
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="If value = Null Then Return False";
if (_value== null) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="If value=0 Then Return False";
if ((_value).equals((Object)(0))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="If value=False Then Return False";
if ((_value).equals((Object)(anywheresoftware.b4a.keywords.Common.False))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6619140;
 //BA.debugLineNum = 6619140;BA.debugLine="If value=\"False\" Then Return False";
if ((_value).equals((Object)("False"))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="If value=\"false\" Then Return False";
if ((_value).equals((Object)("false"))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=6619143;
 //BA.debugLineNum = 6619143;BA.debugLine="End Sub";
return false;
}
public static int  _tolong(anywheresoftware.b4a.BA _ba,String _dig) throws Exception{
RDebugUtils.currentModule="cm";
if (Debug.shouldDelegate("tolong"))
	return (Integer) Debug.delegate(null, "tolong", new Object[] {_ba,_dig});
long _i = 0L;
RDebugUtils.currentLine=6750208;
 //BA.debugLineNum = 6750208;BA.debugLine="Sub tolong(dig As String) As Int";
RDebugUtils.currentLine=6750209;
 //BA.debugLineNum = 6750209;BA.debugLine="Dim i As Long";
_i = 0L;
RDebugUtils.currentLine=6750210;
 //BA.debugLineNum = 6750210;BA.debugLine="If IsNumber(dig) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_dig)) { 
RDebugUtils.currentLine=6750211;
 //BA.debugLineNum = 6750211;BA.debugLine="i = dig";
_i = (long)(Double.parseDouble(_dig));
 }else {
RDebugUtils.currentLine=6750213;
 //BA.debugLineNum = 6750213;BA.debugLine="i = 0";
_i = (long) (0);
 };
RDebugUtils.currentLine=6750215;
 //BA.debugLineNum = 6750215;BA.debugLine="Return i";
if (true) return (int) (_i);
RDebugUtils.currentLine=6750216;
 //BA.debugLineNum = 6750216;BA.debugLine="End Sub";
return 0;
}
public static Object  _byte_to_object(anywheresoftware.b4a.BA _ba,byte[] _data) throws Exception{
RDebugUtils.currentModule="cm";
if (Debug.shouldDelegate("byte_to_object"))
	return (Object) Debug.delegate(null, "byte_to_object", new Object[] {_ba,_data});
anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
RDebugUtils.currentLine=6881280;
 //BA.debugLineNum = 6881280;BA.debugLine="Sub byte_to_object(data() As Byte)As Object";
RDebugUtils.currentLine=6881281;
 //BA.debugLineNum = 6881281;BA.debugLine="Dim ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
RDebugUtils.currentLine=6881282;
 //BA.debugLineNum = 6881282;BA.debugLine="Return ser.ConvertBytesToObject(data)";
if (true) return _ser.ConvertBytesToObject(_data);
RDebugUtils.currentLine=6881283;
 //BA.debugLineNum = 6881283;BA.debugLine="End Sub";
return null;
}
public static byte[]  _object_to_byte(anywheresoftware.b4a.BA _ba,Object _obj) throws Exception{
RDebugUtils.currentModule="cm";
if (Debug.shouldDelegate("object_to_byte"))
	return (byte[]) Debug.delegate(null, "object_to_byte", new Object[] {_ba,_obj});
anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
RDebugUtils.currentLine=6815744;
 //BA.debugLineNum = 6815744;BA.debugLine="Sub object_to_byte(obj As Object)As Byte()";
RDebugUtils.currentLine=6815745;
 //BA.debugLineNum = 6815745;BA.debugLine="Dim ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
RDebugUtils.currentLine=6815746;
 //BA.debugLineNum = 6815746;BA.debugLine="Return ser.ConvertObjectToBytes(obj)";
if (true) return _ser.ConvertObjectToBytes(_obj);
RDebugUtils.currentLine=6815747;
 //BA.debugLineNum = 6815747;BA.debugLine="End Sub";
return null;
}
}