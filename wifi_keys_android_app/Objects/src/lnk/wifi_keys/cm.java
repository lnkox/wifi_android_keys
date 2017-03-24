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
public static int _vert_size = 0;
public static int _horiz_size = 0;
public static int _font_size = 0;
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public static boolean  _obj2bool(anywheresoftware.b4a.BA _ba,Object _value) throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub obj2Bool(value As Object) As Boolean";
 //BA.debugLineNum = 12;BA.debugLine="If value = Null Then Return False";
if (_value== null) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 13;BA.debugLine="If value=0 Then Return False";
if ((_value).equals((Object)(0))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 14;BA.debugLine="If value=False Then Return False";
if ((_value).equals((Object)(anywheresoftware.b4a.keywords.Common.False))) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 15;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return false;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Public vert_size As Int";
_vert_size = 0;
 //BA.debugLineNum = 7;BA.debugLine="Public horiz_size As Int";
_horiz_size = 0;
 //BA.debugLineNum = 8;BA.debugLine="Public font_size As Int";
_font_size = 0;
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return "";
}
public static int  _toint(anywheresoftware.b4a.BA _ba,String _dig) throws Exception{
int _i = 0;
 //BA.debugLineNum = 18;BA.debugLine="Sub toint(dig As String) As Int";
 //BA.debugLineNum = 19;BA.debugLine="Dim i As Int";
_i = 0;
 //BA.debugLineNum = 20;BA.debugLine="If IsNumber(dig) Then";
if (anywheresoftware.b4a.keywords.Common.IsNumber(_dig)) { 
 //BA.debugLineNum = 21;BA.debugLine="i = dig";
_i = (int)(Double.parseDouble(_dig));
 }else {
 //BA.debugLineNum = 23;BA.debugLine="i = 0";
_i = (int) (0);
 };
 //BA.debugLineNum = 25;BA.debugLine="Return i";
if (true) return _i;
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return 0;
}
}
