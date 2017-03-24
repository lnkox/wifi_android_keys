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
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public static int  _toint(anywheresoftware.b4a.BA _ba,String _dig) throws Exception{
RDebugUtils.currentModule="cm";
if (Debug.shouldDelegate("toint"))
	return (Integer) Debug.delegate(null, "toint", new Object[] {_ba,_dig});
int _i = 0;
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub toint(dig As String) As Int";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="If IsNumber(dig) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_dig)) { 
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="i = dig";
_i = (int)(Double.parseDouble(_dig));
 }else {
RDebugUtils.currentLine=6291461;
 //BA.debugLineNum = 6291461;BA.debugLine="i = 0";
_i = (int) (0);
 };
RDebugUtils.currentLine=6291463;
 //BA.debugLineNum = 6291463;BA.debugLine="Return i";
if (true) return _i;
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="End Sub";
return 0;
}
public static boolean  _obj2bool(anywheresoftware.b4a.BA _ba,Object _value) throws Exception{
RDebugUtils.currentModule="cm";
if (Debug.shouldDelegate("obj2bool"))
	return (Boolean) Debug.delegate(null, "obj2bool", new Object[] {_ba,_value});
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub obj2Bool(value As Object) As Boolean";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="If value = Null Then Return False";
if (_value== null) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="If value=0 Then Return False";
if ((_value).equals((Object)(0))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="If value=False Then Return False";
if ((_value).equals((Object)(anywheresoftware.b4a.keywords.Common.False))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="If value=\"False\" Then Return False";
if ((_value).equals((Object)("False"))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="If value=\"false\" Then Return False";
if ((_value).equals((Object)("false"))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=6225926;
 //BA.debugLineNum = 6225926;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="End Sub";
return false;
}
public static Object  _byte_to_object(anywheresoftware.b4a.BA _ba,byte[] _data) throws Exception{
RDebugUtils.currentModule="cm";
if (Debug.shouldDelegate("byte_to_object"))
	return (Object) Debug.delegate(null, "byte_to_object", new Object[] {_ba,_data});
anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub byte_to_object(data() As Byte)As Object";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="Dim ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="Return ser.ConvertBytesToObject(data)";
if (true) return _ser.ConvertBytesToObject(_data);
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="End Sub";
return null;
}
public static byte[]  _object_to_byte(anywheresoftware.b4a.BA _ba,Object _obj) throws Exception{
RDebugUtils.currentModule="cm";
if (Debug.shouldDelegate("object_to_byte"))
	return (byte[]) Debug.delegate(null, "object_to_byte", new Object[] {_ba,_obj});
anywheresoftware.b4a.randomaccessfile.B4XSerializator _ser = null;
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub object_to_byte(obj As Object)As Byte()";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="Dim ser As B4XSerializator";
_ser = new anywheresoftware.b4a.randomaccessfile.B4XSerializator();
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="Return ser.ConvertObjectToBytes(obj)";
if (true) return _ser.ConvertObjectToBytes(_obj);
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="End Sub";
return null;
}
}