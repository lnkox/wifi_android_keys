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
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public static Object  _byte_to_object(anywheresoftware.b4a.BA _ba,byte[] _data) throws Exception{
anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
 //BA.debugLineNum = 38;BA.debugLine="Sub byte_to_object(data() As Byte)As Object";
 //BA.debugLineNum = 39;BA.debugLine="Dim ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
 //BA.debugLineNum = 40;BA.debugLine="Return ser.ConvertBytesToObject(data)";
if (true) return _ser.ConvertBytesToObject(_data);
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return null;
}
public static boolean  _obj2bool(anywheresoftware.b4a.BA _ba,Object _value) throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub obj2Bool(value As Object) As Boolean";
 //BA.debugLineNum = 7;BA.debugLine="If value = Null Then Return False";
if (_value== null) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 8;BA.debugLine="If value=0 Then Return False";
if ((_value).equals((Object)(0))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 9;BA.debugLine="If value=False Then Return False";
if ((_value).equals((Object)(anywheresoftware.b4a.keywords.Common.False))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 10;BA.debugLine="If value=\"False\" Then Return False";
if ((_value).equals((Object)("False"))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 11;BA.debugLine="If value=\"false\" Then Return False";
if ((_value).equals((Object)("false"))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 12;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return false;
}
public static byte[]  _object_to_byte(anywheresoftware.b4a.BA _ba,Object _obj) throws Exception{
anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
 //BA.debugLineNum = 33;BA.debugLine="Sub object_to_byte(obj As Object)As Byte()";
 //BA.debugLineNum = 34;BA.debugLine="Dim ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
 //BA.debugLineNum = 35;BA.debugLine="Return ser.ConvertObjectToBytes(obj)";
if (true) return _ser.ConvertObjectToBytes(_obj);
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return null;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Public bc As ByteConverter";
_bc = new anywheresoftware.b4a.agraham.byteconverter.ByteConverter();
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return "";
}
public static int  _toint(anywheresoftware.b4a.BA _ba,String _dig) throws Exception{
int _i = 0;
 //BA.debugLineNum = 15;BA.debugLine="Sub toint(dig As String) As Int";
 //BA.debugLineNum = 16;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 17;BA.debugLine="If IsNumber(dig) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_dig)) { 
 //BA.debugLineNum = 18;BA.debugLine="i = dig";
_i = (int)(Double.parseDouble(_dig));
 }else {
 //BA.debugLineNum = 20;BA.debugLine="i = 0";
_i = (int) (0);
 };
 //BA.debugLineNum = 22;BA.debugLine="Return i";
if (true) return _i;
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return 0;
}
public static int  _tolong(anywheresoftware.b4a.BA _ba,String _dig) throws Exception{
long _i = 0L;
 //BA.debugLineNum = 24;BA.debugLine="Sub tolong(dig As String) As Int";
 //BA.debugLineNum = 25;BA.debugLine="Dim i As Long";
_i = 0L;
 //BA.debugLineNum = 26;BA.debugLine="If IsNumber(dig) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_dig)) { 
 //BA.debugLineNum = 27;BA.debugLine="i = dig";
_i = (long)(Double.parseDouble(_dig));
 }else {
 //BA.debugLineNum = 29;BA.debugLine="i = 0";
_i = (long) (0);
 };
 //BA.debugLineNum = 31;BA.debugLine="Return i";
if (true) return (int) (_i);
 //BA.debugLineNum = 32;BA.debugLine="End Sub";
return 0;
}
}
