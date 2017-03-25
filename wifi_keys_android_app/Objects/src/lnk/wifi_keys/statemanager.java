package lnk.wifi_keys;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class statemanager {
private static statemanager mostCurrent = new statemanager();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.collections.Map _states = null;
public static int _listposition = 0;
public static String _statesfilename = "";
public static String _settingsfilename = "";
public static anywheresoftware.b4a.objects.collections.Map _settings = null;
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public static String  _getsetting2(anywheresoftware.b4a.BA _ba,String _key,String _defaultvalue) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("getsetting2"))
	return (String) Debug.delegate(null, "getsetting2", new Object[] {_ba,_key,_defaultvalue});
String _v = "";
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub GetSetting2(Key As String, DefaultValue As Str";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
 };
RDebugUtils.currentLine=2818057;
 //BA.debugLineNum = 2818057;BA.debugLine="Dim v As String";
_v = "";
RDebugUtils.currentLine=2818058;
 //BA.debugLineNum = 2818058;BA.debugLine="v = settings.GetDefault(Key.ToLowerCase, DefaultV";
_v = BA.ObjectToString(_settings.GetDefault((Object)(_key.toLowerCase()),(Object)(_defaultvalue)));
RDebugUtils.currentLine=2818059;
 //BA.debugLineNum = 2818059;BA.debugLine="Return v";
if (true) return _v;
RDebugUtils.currentLine=2818060;
 //BA.debugLineNum = 2818060;BA.debugLine="End Sub";
return "";
}
public static String  _savesettings(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("savesettings"))
	return (String) Debug.delegate(null, "savesettings", new Object[] {_ba});
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub SaveSettings";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="If settings.IsInitialized Then";
if (_settings.IsInitialized()) { 
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="File.WriteMap(File.DirInternal, settingsFileName";
anywheresoftware.b4a.keywords.Common.File.WriteMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename,_settings);
 };
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="End Sub";
return "";
}
public static String  _setsetting(anywheresoftware.b4a.BA _ba,String _key,String _value) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("setsetting"))
	return (String) Debug.delegate(null, "setsetting", new Object[] {_ba,_key,_value});
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub SetSetting(Key As String, Value As String)";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="settings.Initialize";
_settings.Initialize();
 };
 };
RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="settings.Put(Key.ToLowerCase, Value)";
_settings.Put((Object)(_key.toLowerCase()),(Object)(_value));
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="End Sub";
return "";
}
public static Object[]  _getnextitem(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("getnextitem"))
	return (Object[]) Debug.delegate(null, "getnextitem", new Object[] {_ba,_list1});
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub getNextItem(list1 As List) As Object()";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="listPosition = listPosition + 1";
_listposition = (int) (_listposition+1);
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Return list1.Get(listPosition)";
if (true) return (Object[])(_list1.Get(_listposition));
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="End Sub";
return null;
}
public static String  _innerrestorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("innerrestorestate"))
	return (String) Debug.delegate(null, "innerrestorestate", new Object[] {_ba,_v,_list1});
Object[] _data = null;
anywheresoftware.b4a.objects.EditTextWrapper _edit = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _check = null;
anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _toggle = null;
anywheresoftware.b4a.objects.SeekBarWrapper _seek = null;
anywheresoftware.b4a.objects.TabHostWrapper _th = null;
int _i = 0;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.PanelWrapper _tabparentpanel = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub innerRestoreState(v As View, list1 As List)";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3276806;
 //BA.debugLineNum = 3276806;BA.debugLine="edit.Text = data(0)";
_edit.setText(_data[(int) (0)]);
RDebugUtils.currentLine=3276807;
 //BA.debugLineNum = 3276807;BA.debugLine="edit.SelectionStart = data(1)";
_edit.setSelectionStart((int)(BA.ObjectToNumber(_data[(int) (1)])));
 }else 
{RDebugUtils.currentLine=3276808;
 //BA.debugLineNum = 3276808;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=3276809;
 //BA.debugLineNum = 3276809;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=3276810;
 //BA.debugLineNum = 3276810;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=3276811;
 //BA.debugLineNum = 3276811;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3276812;
 //BA.debugLineNum = 3276812;BA.debugLine="check.Checked = data(0)";
_check.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=3276813;
 //BA.debugLineNum = 3276813;BA.debugLine="Else If v Is Button Then";
if (_v.getObjectOrNull() instanceof android.widget.Button) { 
RDebugUtils.currentLine=3276814;
 //BA.debugLineNum = 3276814;BA.debugLine="Dim Button1 As Button";
_button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3276815;
 //BA.debugLineNum = 3276815;BA.debugLine="Button1 = v";
_button1.setObject((android.widget.Button)(_v.getObject()));
RDebugUtils.currentLine=3276816;
 //BA.debugLineNum = 3276816;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3276817;
 //BA.debugLineNum = 3276817;BA.debugLine="Button1.Text = data(0)";
_button1.setText(_data[(int) (0)]);
RDebugUtils.currentLine=3276818;
 //BA.debugLineNum = 3276818;BA.debugLine="Button1.Tag = data(1)";
_button1.setTag(_data[(int) (1)]);
RDebugUtils.currentLine=3276819;
 //BA.debugLineNum = 3276819;BA.debugLine="Button1.Left= data(2)";
_button1.setLeft((int)(BA.ObjectToNumber(_data[(int) (2)])));
RDebugUtils.currentLine=3276820;
 //BA.debugLineNum = 3276820;BA.debugLine="Button1.Top= data(3)";
_button1.setTop((int)(BA.ObjectToNumber(_data[(int) (3)])));
RDebugUtils.currentLine=3276821;
 //BA.debugLineNum = 3276821;BA.debugLine="Button1.Width= data(4)";
_button1.setWidth((int)(BA.ObjectToNumber(_data[(int) (4)])));
RDebugUtils.currentLine=3276822;
 //BA.debugLineNum = 3276822;BA.debugLine="Button1.Height= data(5)";
_button1.setHeight((int)(BA.ObjectToNumber(_data[(int) (5)])));
RDebugUtils.currentLine=3276823;
 //BA.debugLineNum = 3276823;BA.debugLine="Button1.Background =data(6)";
_button1.setBackground((android.graphics.drawable.Drawable)(_data[(int) (6)]));
 }else 
{RDebugUtils.currentLine=3276824;
 //BA.debugLineNum = 3276824;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=3276825;
 //BA.debugLineNum = 3276825;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=3276826;
 //BA.debugLineNum = 3276826;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=3276827;
 //BA.debugLineNum = 3276827;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3276828;
 //BA.debugLineNum = 3276828;BA.debugLine="spinner1.SelectedIndex = data(0)";
_spinner1.setSelectedIndex((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=3276829;
 //BA.debugLineNum = 3276829;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=3276830;
 //BA.debugLineNum = 3276830;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=3276831;
 //BA.debugLineNum = 3276831;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=3276832;
 //BA.debugLineNum = 3276832;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3276833;
 //BA.debugLineNum = 3276833;BA.debugLine="radio.Checked = data(0)";
_radio.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=3276834;
 //BA.debugLineNum = 3276834;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=3276835;
 //BA.debugLineNum = 3276835;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=3276836;
 //BA.debugLineNum = 3276836;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=3276837;
 //BA.debugLineNum = 3276837;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3276838;
 //BA.debugLineNum = 3276838;BA.debugLine="toggle.Checked = data(0)";
_toggle.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=3276839;
 //BA.debugLineNum = 3276839;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=3276840;
 //BA.debugLineNum = 3276840;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=3276841;
 //BA.debugLineNum = 3276841;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=3276842;
 //BA.debugLineNum = 3276842;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3276843;
 //BA.debugLineNum = 3276843;BA.debugLine="seek.Value = data(0)";
_seek.setValue((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=3276844;
 //BA.debugLineNum = 3276844;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=3276845;
 //BA.debugLineNum = 3276845;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=3276846;
 //BA.debugLineNum = 3276846;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=3276847;
 //BA.debugLineNum = 3276847;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3276848;
 //BA.debugLineNum = 3276848;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step48 = 1;
final int limit48 = (int) (_th.getTabCount()-1);
for (_i = (int) (0) ; (step48 > 0 && _i <= limit48) || (step48 < 0 && _i >= limit48); _i = ((int)(0 + _i + step48)) ) {
RDebugUtils.currentLine=3276849;
 //BA.debugLineNum = 3276849;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=3276851;
 //BA.debugLineNum = 3276851;BA.debugLine="th.CurrentTab = data(0)";
_th.setCurrentTab((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=3276852;
 //BA.debugLineNum = 3276852;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=3276853;
 //BA.debugLineNum = 3276853;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=3276854;
 //BA.debugLineNum = 3276854;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3276855;
 //BA.debugLineNum = 3276855;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=3276856;
 //BA.debugLineNum = 3276856;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step56 = 1;
final int limit56 = (int) (_tabparentpanel.getNumberOfViews()-1);
for (_i = (int) (0) ; (step56 > 0 && _i <= limit56) || (step56 < 0 && _i >= limit56); _i = ((int)(0 + _i + step56)) ) {
RDebugUtils.currentLine=3276857;
 //BA.debugLineNum = 3276857;BA.debugLine="innerRestoreState(tabParentPanel.GetView(i), li";
_innerrestorestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=3276859;
 //BA.debugLineNum = 3276859;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=3276860;
 //BA.debugLineNum = 3276860;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=3276861;
 //BA.debugLineNum = 3276861;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=3276862;
 //BA.debugLineNum = 3276862;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3276863;
 //BA.debugLineNum = 3276863;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=3276864;
 //BA.debugLineNum = 3276864;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
RDebugUtils.currentLine=3276865;
 //BA.debugLineNum = 3276865;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=3276866;
 //BA.debugLineNum = 3276866;BA.debugLine="innerRestoreState(sv.Panel, list1)";
_innerrestorestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=3276867;
 //BA.debugLineNum = 3276867;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=3276868;
 //BA.debugLineNum = 3276868;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3276869;
 //BA.debugLineNum = 3276869;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=3276870;
 //BA.debugLineNum = 3276870;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step70 = 1;
final int limit70 = (int) (_panel1.getNumberOfViews()-1);
for (_i = (int) (0) ; (step70 > 0 && _i <= limit70) || (step70 < 0 && _i >= limit70); _i = ((int)(0 + _i + step70)) ) {
RDebugUtils.currentLine=3276871;
 //BA.debugLineNum = 3276871;BA.debugLine="innerRestoreState(panel1.GetView(i), list1)";
_innerrestorestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}}};
RDebugUtils.currentLine=3276874;
 //BA.debugLineNum = 3276874;BA.debugLine="End Sub";
return "";
}
public static String  _innersavestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("innersavestate"))
	return (String) Debug.delegate(null, "innersavestate", new Object[] {_ba,_v,_list1});
Object[] _data = null;
anywheresoftware.b4a.objects.EditTextWrapper _edit = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _check = null;
anywheresoftware.b4a.objects.ButtonWrapper _button1 = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _toggle = null;
anywheresoftware.b4a.objects.SeekBarWrapper _seek = null;
anywheresoftware.b4a.objects.TabHostWrapper _th = null;
int _i = 0;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.PanelWrapper _tabparentpanel = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub innerSaveState(v As View, list1 As List)";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="data = Array As Object(edit.Text, edit.Selection";
_data = new Object[]{(Object)(_edit.getText()),(Object)(_edit.getSelectionStart())};
 }else 
{RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=3211272;
 //BA.debugLineNum = 3211272;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="data = Array As Object(check.Checked)";
_data = new Object[]{(Object)(_check.getChecked())};
 }else 
{RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="Else If v Is Button Then";
if (_v.getObjectOrNull() instanceof android.widget.Button) { 
RDebugUtils.currentLine=3211275;
 //BA.debugLineNum = 3211275;BA.debugLine="Dim Button1 As Button";
_button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3211276;
 //BA.debugLineNum = 3211276;BA.debugLine="Button1 = v";
_button1.setObject((android.widget.Button)(_v.getObject()));
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="data = Array As Object(Button1.Text,Button1.tag,";
_data = new Object[]{(Object)(_button1.getText()),_button1.getTag(),(Object)(_button1.getLeft()),(Object)(_button1.getTop()),(Object)(_button1.getWidth()),(Object)(_button1.getHeight()),(Object)(_button1.getBackground())};
 }else 
{RDebugUtils.currentLine=3211278;
 //BA.debugLineNum = 3211278;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=3211279;
 //BA.debugLineNum = 3211279;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=3211280;
 //BA.debugLineNum = 3211280;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=3211281;
 //BA.debugLineNum = 3211281;BA.debugLine="data = Array As Object(spinner1.SelectedIndex)";
_data = new Object[]{(Object)(_spinner1.getSelectedIndex())};
 }else 
{RDebugUtils.currentLine=3211282;
 //BA.debugLineNum = 3211282;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=3211283;
 //BA.debugLineNum = 3211283;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=3211284;
 //BA.debugLineNum = 3211284;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=3211285;
 //BA.debugLineNum = 3211285;BA.debugLine="data = Array As Object(radio.Checked)";
_data = new Object[]{(Object)(_radio.getChecked())};
 }else 
{RDebugUtils.currentLine=3211286;
 //BA.debugLineNum = 3211286;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=3211287;
 //BA.debugLineNum = 3211287;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=3211288;
 //BA.debugLineNum = 3211288;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=3211289;
 //BA.debugLineNum = 3211289;BA.debugLine="data = Array As Object(toggle.Checked)";
_data = new Object[]{(Object)(_toggle.getChecked())};
 }else 
{RDebugUtils.currentLine=3211290;
 //BA.debugLineNum = 3211290;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=3211291;
 //BA.debugLineNum = 3211291;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=3211292;
 //BA.debugLineNum = 3211292;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=3211293;
 //BA.debugLineNum = 3211293;BA.debugLine="data = Array As Object(seek.Value)";
_data = new Object[]{(Object)(_seek.getValue())};
 }else 
{RDebugUtils.currentLine=3211294;
 //BA.debugLineNum = 3211294;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=3211295;
 //BA.debugLineNum = 3211295;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=3211296;
 //BA.debugLineNum = 3211296;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=3211297;
 //BA.debugLineNum = 3211297;BA.debugLine="data = Array As Object(th.CurrentTab)";
_data = new Object[]{(Object)(_th.getCurrentTab())};
RDebugUtils.currentLine=3211298;
 //BA.debugLineNum = 3211298;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step34 = 1;
final int limit34 = (int) (_th.getTabCount()-1);
for (_i = (int) (0) ; (step34 > 0 && _i <= limit34) || (step34 < 0 && _i >= limit34); _i = ((int)(0 + _i + step34)) ) {
RDebugUtils.currentLine=3211299;
 //BA.debugLineNum = 3211299;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=3211301;
 //BA.debugLineNum = 3211301;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=3211302;
 //BA.debugLineNum = 3211302;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3211303;
 //BA.debugLineNum = 3211303;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=3211304;
 //BA.debugLineNum = 3211304;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=3211305;
 //BA.debugLineNum = 3211305;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3211306;
 //BA.debugLineNum = 3211306;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=3211307;
 //BA.debugLineNum = 3211307;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step43 = 1;
final int limit43 = (int) (_tabparentpanel.getNumberOfViews()-1);
for (_i = (int) (0) ; (step43 > 0 && _i <= limit43) || (step43 < 0 && _i >= limit43); _i = ((int)(0 + _i + step43)) ) {
RDebugUtils.currentLine=3211308;
 //BA.debugLineNum = 3211308;BA.debugLine="innerSaveState(tabParentPanel.GetView(i), list1";
_innersavestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=3211310;
 //BA.debugLineNum = 3211310;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=3211311;
 //BA.debugLineNum = 3211311;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=3211312;
 //BA.debugLineNum = 3211312;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=3211313;
 //BA.debugLineNum = 3211313;BA.debugLine="data = Array As Object(sv.ScrollPosition)";
_data = new Object[]{(Object)(_sv.getScrollPosition())};
RDebugUtils.currentLine=3211314;
 //BA.debugLineNum = 3211314;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=3211315;
 //BA.debugLineNum = 3211315;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3211316;
 //BA.debugLineNum = 3211316;BA.debugLine="innerSaveState(sv.Panel, list1)";
_innersavestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=3211317;
 //BA.debugLineNum = 3211317;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=3211318;
 //BA.debugLineNum = 3211318;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3211319;
 //BA.debugLineNum = 3211319;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=3211320;
 //BA.debugLineNum = 3211320;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step56 = 1;
final int limit56 = (int) (_panel1.getNumberOfViews()-1);
for (_i = (int) (0) ; (step56 > 0 && _i <= limit56) || (step56 < 0 && _i >= limit56); _i = ((int)(0 + _i + step56)) ) {
RDebugUtils.currentLine=3211321;
 //BA.debugLineNum = 3211321;BA.debugLine="innerSaveState(panel1.GetView(i), list1)";
_innersavestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}}};
RDebugUtils.currentLine=3211324;
 //BA.debugLineNum = 3211324;BA.debugLine="If data.Length > 0 Then list1.Add(data)";
if (_data.length>0) { 
_list1.Add((Object)(_data));};
RDebugUtils.currentLine=3211325;
 //BA.debugLineNum = 3211325;BA.debugLine="End Sub";
return "";
}
public static String  _loadstatefile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("loadstatefile"))
	return (String) Debug.delegate(null, "loadstatefile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub loadStateFile";
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="If states.IsInitialized Then Return";
if (_states.IsInitialized()) { 
if (true) return "";};
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="If File.Exists(File.DirInternal, statesFileName)";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename)) { 
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="states = raf.ReadObject(0)";
_states.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_raf.ReadObject((long) (0))));
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="raf.Close";
_raf.Close();
 };
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="End Sub";
return "";
}
public static String  _resetstate(anywheresoftware.b4a.BA _ba,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("resetstate"))
	return (String) Debug.delegate(null, "resetstate", new Object[] {_ba,_activityname});
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub ResetState(ActivityName As String)";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="If states.IsInitialized Then";
if (_states.IsInitialized()) { 
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="states.Remove(ActivityName.ToLowerCase)";
_states.Remove((Object)(_activityname.toLowerCase()));
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
 };
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="End Sub";
return "";
}
public static String  _writestatetofile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("writestatetofile"))
	return (String) Debug.delegate(null, "writestatetofile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub writeStateToFile";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="raf.WriteObject(states, True, raf.CurrentPosition";
_raf.WriteObject((Object)(_states.getObject()),anywheresoftware.b4a.keywords.Common.True,_raf.CurrentPosition);
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="raf.Close";
_raf.Close();
RDebugUtils.currentLine=3145733;
 //BA.debugLineNum = 3145733;BA.debugLine="End Sub";
return "";
}
public static boolean  _restorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname,int _validperiodinminutes) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("restorestate"))
	return (Boolean) Debug.delegate(null, "restorestate", new Object[] {_ba,_activity,_activityname,_validperiodinminutes});
anywheresoftware.b4a.objects.collections.List _list1 = null;
long _time = 0L;
int _i = 0;
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub RestoreState(Activity As Activity, ActivityNam";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="Try";
try {RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="If states.IsInitialized = False Then";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="list1 = states.Get(ActivityName.ToLowerCase)";
_list1.setObject((java.util.List)(_states.Get((Object)(_activityname.toLowerCase()))));
RDebugUtils.currentLine=3407880;
 //BA.debugLineNum = 3407880;BA.debugLine="If list1.IsInitialized = False Then Return False";
if (_list1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="Dim time As Long";
_time = 0L;
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="time = list1.Get(0)";
_time = BA.ObjectToLongNumber(_list1.Get((int) (0)));
RDebugUtils.currentLine=3407883;
 //BA.debugLineNum = 3407883;BA.debugLine="If ValidPeriodInMinutes > 0 And time + ValidPeri";
if (_validperiodinminutes>0 && _time+_validperiodinminutes*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute<anywheresoftware.b4a.keywords.Common.DateTime.getNow()) { 
RDebugUtils.currentLine=3407884;
 //BA.debugLineNum = 3407884;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3407886;
 //BA.debugLineNum = 3407886;BA.debugLine="listPosition = 0";
_listposition = (int) (0);
RDebugUtils.currentLine=3407887;
 //BA.debugLineNum = 3407887;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step15 = 1;
final int limit15 = (int) (_activity.getNumberOfViews()-1);
for (_i = (int) (0) ; (step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15); _i = ((int)(0 + _i + step15)) ) {
RDebugUtils.currentLine=3407888;
 //BA.debugLineNum = 3407888;BA.debugLine="innerRestoreState(Activity.GetView(i), list1)";
_innerrestorestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=3407890;
 //BA.debugLineNum = 3407890;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e220) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e220);RDebugUtils.currentLine=3407892;
 //BA.debugLineNum = 3407892;BA.debugLine="Log(\"Error loading state.\")";
anywheresoftware.b4a.keywords.Common.Log("Error loading state.");
RDebugUtils.currentLine=3407893;
 //BA.debugLineNum = 3407893;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage());
RDebugUtils.currentLine=3407894;
 //BA.debugLineNum = 3407894;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3407896;
 //BA.debugLineNum = 3407896;BA.debugLine="End Sub";
return false;
}
public static String  _savestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("savestate"))
	return (String) Debug.delegate(null, "savestate", new Object[] {_ba,_activity,_activityname});
anywheresoftware.b4a.objects.collections.List _list1 = null;
int _i = 0;
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub SaveState(Activity As Activity, ActivityName A";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="If states.IsInitialized = False Then states.Initi";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_states.Initialize();};
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="list1.Initialize";
_list1.Initialize();
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="list1.Add(DateTime.Now)";
_list1.Add((Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step5 = 1;
final int limit5 = (int) (_activity.getNumberOfViews()-1);
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="innerSaveState(Activity.GetView(i), list1)";
_innersavestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="states.Put(ActivityName.ToLowerCase, list1)";
_states.Put((Object)(_activityname.toLowerCase()),(Object)(_list1.getObject()));
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="End Sub";
return "";
}
}