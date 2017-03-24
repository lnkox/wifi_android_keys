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
public lnk.wifi_keys.sta_set _sta_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public static String  _getsetting2(anywheresoftware.b4a.BA _ba,String _key,String _defaultvalue) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("getsetting2"))
	return (String) Debug.delegate(null, "getsetting2", new Object[] {_ba,_key,_defaultvalue});
String _v = "";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub GetSetting2(Key As String, DefaultValue As Str";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
 };
RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="Dim v As String";
_v = "";
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="v = settings.GetDefault(Key.ToLowerCase, DefaultV";
_v = BA.ObjectToString(_settings.GetDefault((Object)(_key.toLowerCase()),(Object)(_defaultvalue)));
RDebugUtils.currentLine=1114123;
 //BA.debugLineNum = 1114123;BA.debugLine="Return v";
if (true) return _v;
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="End Sub";
return "";
}
public static String  _savesettings(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("savesettings"))
	return (String) Debug.delegate(null, "savesettings", new Object[] {_ba});
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub SaveSettings";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="If settings.IsInitialized Then";
if (_settings.IsInitialized()) { 
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="File.WriteMap(File.DirInternal, settingsFileName";
anywheresoftware.b4a.keywords.Common.File.WriteMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename,_settings);
 };
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="End Sub";
return "";
}
public static String  _setsetting(anywheresoftware.b4a.BA _ba,String _key,String _value) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("setsetting"))
	return (String) Debug.delegate(null, "setsetting", new Object[] {_ba,_key,_value});
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub SetSetting(Key As String, Value As String)";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="settings.Initialize";
_settings.Initialize();
 };
 };
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="settings.Put(Key.ToLowerCase, Value)";
_settings.Put((Object)(_key.toLowerCase()),(Object)(_value));
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="End Sub";
return "";
}
public static Object[]  _getnextitem(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("getnextitem"))
	return (Object[]) Debug.delegate(null, "getnextitem", new Object[] {_ba,_list1});
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub getNextItem(list1 As List) As Object()";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="listPosition = listPosition + 1";
_listposition = (int) (_listposition+1);
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="Return list1.Get(listPosition)";
if (true) return (Object[])(_list1.Get(_listposition));
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub innerRestoreState(v As View, list1 As List)";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="edit.Text = data(0)";
_edit.setText(_data[(int) (0)]);
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="edit.SelectionStart = data(1)";
_edit.setSelectionStart((int)(BA.ObjectToNumber(_data[(int) (1)])));
 }else 
{RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="check.Checked = data(0)";
_check.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=1572877;
 //BA.debugLineNum = 1572877;BA.debugLine="Else If v Is Button Then";
if (_v.getObjectOrNull() instanceof android.widget.Button) { 
RDebugUtils.currentLine=1572878;
 //BA.debugLineNum = 1572878;BA.debugLine="Dim Button1 As Button";
_button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="Button1 = v";
_button1.setObject((android.widget.Button)(_v.getObject()));
RDebugUtils.currentLine=1572880;
 //BA.debugLineNum = 1572880;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=1572881;
 //BA.debugLineNum = 1572881;BA.debugLine="Button1.Text = data(0)";
_button1.setText(_data[(int) (0)]);
RDebugUtils.currentLine=1572882;
 //BA.debugLineNum = 1572882;BA.debugLine="Button1.Tag = data(1)";
_button1.setTag(_data[(int) (1)]);
RDebugUtils.currentLine=1572883;
 //BA.debugLineNum = 1572883;BA.debugLine="Button1.Left= data(2)";
_button1.setLeft((int)(BA.ObjectToNumber(_data[(int) (2)])));
RDebugUtils.currentLine=1572884;
 //BA.debugLineNum = 1572884;BA.debugLine="Button1.Top= data(3)";
_button1.setTop((int)(BA.ObjectToNumber(_data[(int) (3)])));
RDebugUtils.currentLine=1572885;
 //BA.debugLineNum = 1572885;BA.debugLine="Button1.Width= data(4)";
_button1.setWidth((int)(BA.ObjectToNumber(_data[(int) (4)])));
RDebugUtils.currentLine=1572886;
 //BA.debugLineNum = 1572886;BA.debugLine="Button1.Height= data(5)";
_button1.setHeight((int)(BA.ObjectToNumber(_data[(int) (5)])));
RDebugUtils.currentLine=1572887;
 //BA.debugLineNum = 1572887;BA.debugLine="Button1.Background =data(6)";
_button1.setBackground((android.graphics.drawable.Drawable)(_data[(int) (6)]));
 }else 
{RDebugUtils.currentLine=1572888;
 //BA.debugLineNum = 1572888;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=1572889;
 //BA.debugLineNum = 1572889;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=1572890;
 //BA.debugLineNum = 1572890;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=1572891;
 //BA.debugLineNum = 1572891;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=1572892;
 //BA.debugLineNum = 1572892;BA.debugLine="spinner1.SelectedIndex = data(0)";
_spinner1.setSelectedIndex((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=1572893;
 //BA.debugLineNum = 1572893;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=1572894;
 //BA.debugLineNum = 1572894;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=1572895;
 //BA.debugLineNum = 1572895;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=1572896;
 //BA.debugLineNum = 1572896;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=1572897;
 //BA.debugLineNum = 1572897;BA.debugLine="radio.Checked = data(0)";
_radio.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=1572898;
 //BA.debugLineNum = 1572898;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=1572899;
 //BA.debugLineNum = 1572899;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=1572900;
 //BA.debugLineNum = 1572900;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=1572901;
 //BA.debugLineNum = 1572901;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=1572902;
 //BA.debugLineNum = 1572902;BA.debugLine="toggle.Checked = data(0)";
_toggle.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=1572903;
 //BA.debugLineNum = 1572903;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=1572904;
 //BA.debugLineNum = 1572904;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=1572905;
 //BA.debugLineNum = 1572905;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=1572906;
 //BA.debugLineNum = 1572906;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=1572907;
 //BA.debugLineNum = 1572907;BA.debugLine="seek.Value = data(0)";
_seek.setValue((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=1572908;
 //BA.debugLineNum = 1572908;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=1572909;
 //BA.debugLineNum = 1572909;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=1572910;
 //BA.debugLineNum = 1572910;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=1572911;
 //BA.debugLineNum = 1572911;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=1572912;
 //BA.debugLineNum = 1572912;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step48 = 1;
final int limit48 = (int) (_th.getTabCount()-1);
for (_i = (int) (0) ; (step48 > 0 && _i <= limit48) || (step48 < 0 && _i >= limit48); _i = ((int)(0 + _i + step48)) ) {
RDebugUtils.currentLine=1572913;
 //BA.debugLineNum = 1572913;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=1572915;
 //BA.debugLineNum = 1572915;BA.debugLine="th.CurrentTab = data(0)";
_th.setCurrentTab((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=1572916;
 //BA.debugLineNum = 1572916;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=1572917;
 //BA.debugLineNum = 1572917;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=1572918;
 //BA.debugLineNum = 1572918;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1572919;
 //BA.debugLineNum = 1572919;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=1572920;
 //BA.debugLineNum = 1572920;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step56 = 1;
final int limit56 = (int) (_tabparentpanel.getNumberOfViews()-1);
for (_i = (int) (0) ; (step56 > 0 && _i <= limit56) || (step56 < 0 && _i >= limit56); _i = ((int)(0 + _i + step56)) ) {
RDebugUtils.currentLine=1572921;
 //BA.debugLineNum = 1572921;BA.debugLine="innerRestoreState(tabParentPanel.GetView(i), li";
_innerrestorestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=1572923;
 //BA.debugLineNum = 1572923;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=1572924;
 //BA.debugLineNum = 1572924;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=1572925;
 //BA.debugLineNum = 1572925;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=1572926;
 //BA.debugLineNum = 1572926;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=1572927;
 //BA.debugLineNum = 1572927;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=1572928;
 //BA.debugLineNum = 1572928;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
RDebugUtils.currentLine=1572929;
 //BA.debugLineNum = 1572929;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=1572930;
 //BA.debugLineNum = 1572930;BA.debugLine="innerRestoreState(sv.Panel, list1)";
_innerrestorestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=1572931;
 //BA.debugLineNum = 1572931;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=1572932;
 //BA.debugLineNum = 1572932;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1572933;
 //BA.debugLineNum = 1572933;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=1572934;
 //BA.debugLineNum = 1572934;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step70 = 1;
final int limit70 = (int) (_panel1.getNumberOfViews()-1);
for (_i = (int) (0) ; (step70 > 0 && _i <= limit70) || (step70 < 0 && _i >= limit70); _i = ((int)(0 + _i + step70)) ) {
RDebugUtils.currentLine=1572935;
 //BA.debugLineNum = 1572935;BA.debugLine="innerRestoreState(panel1.GetView(i), list1)";
_innerrestorestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}}};
RDebugUtils.currentLine=1572938;
 //BA.debugLineNum = 1572938;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub innerSaveState(v As View, list1 As List)";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="data = Array As Object(edit.Text, edit.Selection";
_data = new Object[]{(Object)(_edit.getText()),(Object)(_edit.getSelectionStart())};
 }else 
{RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="data = Array As Object(check.Checked)";
_data = new Object[]{(Object)(_check.getChecked())};
 }else 
{RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="Else If v Is Button Then";
if (_v.getObjectOrNull() instanceof android.widget.Button) { 
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="Dim Button1 As Button";
_button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1507340;
 //BA.debugLineNum = 1507340;BA.debugLine="Button1 = v";
_button1.setObject((android.widget.Button)(_v.getObject()));
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="data = Array As Object(Button1.Text,Button1.tag,";
_data = new Object[]{(Object)(_button1.getText()),_button1.getTag(),(Object)(_button1.getLeft()),(Object)(_button1.getTop()),(Object)(_button1.getWidth()),(Object)(_button1.getHeight()),(Object)(_button1.getBackground())};
 }else 
{RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=1507343;
 //BA.debugLineNum = 1507343;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=1507344;
 //BA.debugLineNum = 1507344;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="data = Array As Object(spinner1.SelectedIndex)";
_data = new Object[]{(Object)(_spinner1.getSelectedIndex())};
 }else 
{RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=1507347;
 //BA.debugLineNum = 1507347;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=1507348;
 //BA.debugLineNum = 1507348;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=1507349;
 //BA.debugLineNum = 1507349;BA.debugLine="data = Array As Object(radio.Checked)";
_data = new Object[]{(Object)(_radio.getChecked())};
 }else 
{RDebugUtils.currentLine=1507350;
 //BA.debugLineNum = 1507350;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=1507351;
 //BA.debugLineNum = 1507351;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=1507352;
 //BA.debugLineNum = 1507352;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=1507353;
 //BA.debugLineNum = 1507353;BA.debugLine="data = Array As Object(toggle.Checked)";
_data = new Object[]{(Object)(_toggle.getChecked())};
 }else 
{RDebugUtils.currentLine=1507354;
 //BA.debugLineNum = 1507354;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=1507355;
 //BA.debugLineNum = 1507355;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=1507356;
 //BA.debugLineNum = 1507356;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=1507357;
 //BA.debugLineNum = 1507357;BA.debugLine="data = Array As Object(seek.Value)";
_data = new Object[]{(Object)(_seek.getValue())};
 }else 
{RDebugUtils.currentLine=1507358;
 //BA.debugLineNum = 1507358;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=1507359;
 //BA.debugLineNum = 1507359;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=1507360;
 //BA.debugLineNum = 1507360;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=1507361;
 //BA.debugLineNum = 1507361;BA.debugLine="data = Array As Object(th.CurrentTab)";
_data = new Object[]{(Object)(_th.getCurrentTab())};
RDebugUtils.currentLine=1507362;
 //BA.debugLineNum = 1507362;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step34 = 1;
final int limit34 = (int) (_th.getTabCount()-1);
for (_i = (int) (0) ; (step34 > 0 && _i <= limit34) || (step34 < 0 && _i >= limit34); _i = ((int)(0 + _i + step34)) ) {
RDebugUtils.currentLine=1507363;
 //BA.debugLineNum = 1507363;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=1507365;
 //BA.debugLineNum = 1507365;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=1507366;
 //BA.debugLineNum = 1507366;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=1507367;
 //BA.debugLineNum = 1507367;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=1507368;
 //BA.debugLineNum = 1507368;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=1507369;
 //BA.debugLineNum = 1507369;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1507370;
 //BA.debugLineNum = 1507370;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=1507371;
 //BA.debugLineNum = 1507371;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step43 = 1;
final int limit43 = (int) (_tabparentpanel.getNumberOfViews()-1);
for (_i = (int) (0) ; (step43 > 0 && _i <= limit43) || (step43 < 0 && _i >= limit43); _i = ((int)(0 + _i + step43)) ) {
RDebugUtils.currentLine=1507372;
 //BA.debugLineNum = 1507372;BA.debugLine="innerSaveState(tabParentPanel.GetView(i), list1";
_innersavestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=1507374;
 //BA.debugLineNum = 1507374;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=1507375;
 //BA.debugLineNum = 1507375;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=1507376;
 //BA.debugLineNum = 1507376;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=1507377;
 //BA.debugLineNum = 1507377;BA.debugLine="data = Array As Object(sv.ScrollPosition)";
_data = new Object[]{(Object)(_sv.getScrollPosition())};
RDebugUtils.currentLine=1507378;
 //BA.debugLineNum = 1507378;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=1507379;
 //BA.debugLineNum = 1507379;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=1507380;
 //BA.debugLineNum = 1507380;BA.debugLine="innerSaveState(sv.Panel, list1)";
_innersavestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=1507381;
 //BA.debugLineNum = 1507381;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=1507382;
 //BA.debugLineNum = 1507382;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=1507383;
 //BA.debugLineNum = 1507383;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=1507384;
 //BA.debugLineNum = 1507384;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step56 = 1;
final int limit56 = (int) (_panel1.getNumberOfViews()-1);
for (_i = (int) (0) ; (step56 > 0 && _i <= limit56) || (step56 < 0 && _i >= limit56); _i = ((int)(0 + _i + step56)) ) {
RDebugUtils.currentLine=1507385;
 //BA.debugLineNum = 1507385;BA.debugLine="innerSaveState(panel1.GetView(i), list1)";
_innersavestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}}};
RDebugUtils.currentLine=1507388;
 //BA.debugLineNum = 1507388;BA.debugLine="If data.Length > 0 Then list1.Add(data)";
if (_data.length>0) { 
_list1.Add((Object)(_data));};
RDebugUtils.currentLine=1507389;
 //BA.debugLineNum = 1507389;BA.debugLine="End Sub";
return "";
}
public static String  _loadstatefile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("loadstatefile"))
	return (String) Debug.delegate(null, "loadstatefile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub loadStateFile";
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="If states.IsInitialized Then Return";
if (_states.IsInitialized()) { 
if (true) return "";};
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="If File.Exists(File.DirInternal, statesFileName)";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename)) { 
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="states = raf.ReadObject(0)";
_states.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_raf.ReadObject((long) (0))));
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="raf.Close";
_raf.Close();
 };
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="End Sub";
return "";
}
public static String  _resetstate(anywheresoftware.b4a.BA _ba,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("resetstate"))
	return (String) Debug.delegate(null, "resetstate", new Object[] {_ba,_activityname});
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub ResetState(ActivityName As String)";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="If states.IsInitialized Then";
if (_states.IsInitialized()) { 
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="states.Remove(ActivityName.ToLowerCase)";
_states.Remove((Object)(_activityname.toLowerCase()));
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
 };
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="End Sub";
return "";
}
public static String  _writestatetofile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("writestatetofile"))
	return (String) Debug.delegate(null, "writestatetofile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub writeStateToFile";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="raf.WriteObject(states, True, raf.CurrentPosition";
_raf.WriteObject((Object)(_states.getObject()),anywheresoftware.b4a.keywords.Common.True,_raf.CurrentPosition);
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="raf.Close";
_raf.Close();
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="End Sub";
return "";
}
public static boolean  _restorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname,int _validperiodinminutes) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("restorestate"))
	return (Boolean) Debug.delegate(null, "restorestate", new Object[] {_ba,_activity,_activityname,_validperiodinminutes});
anywheresoftware.b4a.objects.collections.List _list1 = null;
long _time = 0L;
int _i = 0;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub RestoreState(Activity As Activity, ActivityNam";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="Try";
try {RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="If states.IsInitialized = False Then";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="list1 = states.Get(ActivityName.ToLowerCase)";
_list1.setObject((java.util.List)(_states.Get((Object)(_activityname.toLowerCase()))));
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="If list1.IsInitialized = False Then Return False";
if (_list1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=1703945;
 //BA.debugLineNum = 1703945;BA.debugLine="Dim time As Long";
_time = 0L;
RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="time = list1.Get(0)";
_time = BA.ObjectToLongNumber(_list1.Get((int) (0)));
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="If ValidPeriodInMinutes > 0 And time + ValidPeri";
if (_validperiodinminutes>0 && _time+_validperiodinminutes*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute<anywheresoftware.b4a.keywords.Common.DateTime.getNow()) { 
RDebugUtils.currentLine=1703948;
 //BA.debugLineNum = 1703948;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1703950;
 //BA.debugLineNum = 1703950;BA.debugLine="listPosition = 0";
_listposition = (int) (0);
RDebugUtils.currentLine=1703951;
 //BA.debugLineNum = 1703951;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step15 = 1;
final int limit15 = (int) (_activity.getNumberOfViews()-1);
for (_i = (int) (0) ; (step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15); _i = ((int)(0 + _i + step15)) ) {
RDebugUtils.currentLine=1703952;
 //BA.debugLineNum = 1703952;BA.debugLine="innerRestoreState(Activity.GetView(i), list1)";
_innerrestorestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=1703954;
 //BA.debugLineNum = 1703954;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e220) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e220);RDebugUtils.currentLine=1703956;
 //BA.debugLineNum = 1703956;BA.debugLine="Log(\"Error loading state.\")";
anywheresoftware.b4a.keywords.Common.Log("Error loading state.");
RDebugUtils.currentLine=1703957;
 //BA.debugLineNum = 1703957;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage());
RDebugUtils.currentLine=1703958;
 //BA.debugLineNum = 1703958;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1703960;
 //BA.debugLineNum = 1703960;BA.debugLine="End Sub";
return false;
}
public static String  _savestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("savestate"))
	return (String) Debug.delegate(null, "savestate", new Object[] {_ba,_activity,_activityname});
anywheresoftware.b4a.objects.collections.List _list1 = null;
int _i = 0;
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub SaveState(Activity As Activity, ActivityName A";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="If states.IsInitialized = False Then states.Initi";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_states.Initialize();};
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="list1.Initialize";
_list1.Initialize();
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="list1.Add(DateTime.Now)";
_list1.Add((Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step5 = 1;
final int limit5 = (int) (_activity.getNumberOfViews()-1);
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="innerSaveState(Activity.GetView(i), list1)";
_innersavestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="states.Put(ActivityName.ToLowerCase, list1)";
_states.Put((Object)(_activityname.toLowerCase()),(Object)(_list1.getObject()));
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="End Sub";
return "";
}
}