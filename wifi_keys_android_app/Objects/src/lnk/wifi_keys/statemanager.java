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
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub GetSetting2(Key As String, DefaultValue As Str";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
 };
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="Dim v As String";
_v = "";
RDebugUtils.currentLine=3145738;
 //BA.debugLineNum = 3145738;BA.debugLine="v = settings.GetDefault(Key.ToLowerCase, DefaultV";
_v = BA.ObjectToString(_settings.GetDefault((Object)(_key.toLowerCase()),(Object)(_defaultvalue)));
RDebugUtils.currentLine=3145739;
 //BA.debugLineNum = 3145739;BA.debugLine="Return v";
if (true) return _v;
RDebugUtils.currentLine=3145740;
 //BA.debugLineNum = 3145740;BA.debugLine="End Sub";
return "";
}
public static String  _savesettings(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("savesettings"))
	return (String) Debug.delegate(null, "savesettings", new Object[] {_ba});
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub SaveSettings";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="If settings.IsInitialized Then";
if (_settings.IsInitialized()) { 
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="File.WriteMap(File.DirInternal, settingsFileName";
anywheresoftware.b4a.keywords.Common.File.WriteMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename,_settings);
 };
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="End Sub";
return "";
}
public static String  _setsetting(anywheresoftware.b4a.BA _ba,String _key,String _value) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("setsetting"))
	return (String) Debug.delegate(null, "setsetting", new Object[] {_ba,_key,_value});
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub SetSetting(Key As String, Value As String)";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="settings.Initialize";
_settings.Initialize();
 };
 };
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="settings.Put(Key.ToLowerCase, Value)";
_settings.Put((Object)(_key.toLowerCase()),(Object)(_value));
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="End Sub";
return "";
}
public static Object[]  _getnextitem(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("getnextitem"))
	return (Object[]) Debug.delegate(null, "getnextitem", new Object[] {_ba,_list1});
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub getNextItem(list1 As List) As Object()";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="listPosition = listPosition + 1";
_listposition = (int) (_listposition+1);
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Return list1.Get(listPosition)";
if (true) return (Object[])(_list1.Get(_listposition));
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub innerRestoreState(v As View, list1 As List)";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="edit.Text = data(0)";
_edit.setText(_data[(int) (0)]);
RDebugUtils.currentLine=3604487;
 //BA.debugLineNum = 3604487;BA.debugLine="edit.SelectionStart = data(1)";
_edit.setSelectionStart((int)(BA.ObjectToNumber(_data[(int) (1)])));
 }else 
{RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3604492;
 //BA.debugLineNum = 3604492;BA.debugLine="check.Checked = data(0)";
_check.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=3604493;
 //BA.debugLineNum = 3604493;BA.debugLine="Else If v Is Button Then";
if (_v.getObjectOrNull() instanceof android.widget.Button) { 
RDebugUtils.currentLine=3604494;
 //BA.debugLineNum = 3604494;BA.debugLine="Dim Button1 As Button";
_button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3604495;
 //BA.debugLineNum = 3604495;BA.debugLine="Button1 = v";
_button1.setObject((android.widget.Button)(_v.getObject()));
RDebugUtils.currentLine=3604496;
 //BA.debugLineNum = 3604496;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3604497;
 //BA.debugLineNum = 3604497;BA.debugLine="Button1.Text = data(0)";
_button1.setText(_data[(int) (0)]);
RDebugUtils.currentLine=3604498;
 //BA.debugLineNum = 3604498;BA.debugLine="Button1.Tag = data(1)";
_button1.setTag(_data[(int) (1)]);
RDebugUtils.currentLine=3604499;
 //BA.debugLineNum = 3604499;BA.debugLine="Button1.Left= data(2)";
_button1.setLeft((int)(BA.ObjectToNumber(_data[(int) (2)])));
RDebugUtils.currentLine=3604500;
 //BA.debugLineNum = 3604500;BA.debugLine="Button1.Top= data(3)";
_button1.setTop((int)(BA.ObjectToNumber(_data[(int) (3)])));
RDebugUtils.currentLine=3604501;
 //BA.debugLineNum = 3604501;BA.debugLine="Button1.Width= data(4)";
_button1.setWidth((int)(BA.ObjectToNumber(_data[(int) (4)])));
RDebugUtils.currentLine=3604502;
 //BA.debugLineNum = 3604502;BA.debugLine="Button1.Height= data(5)";
_button1.setHeight((int)(BA.ObjectToNumber(_data[(int) (5)])));
RDebugUtils.currentLine=3604503;
 //BA.debugLineNum = 3604503;BA.debugLine="Button1.Background =data(6)";
_button1.setBackground((android.graphics.drawable.Drawable)(_data[(int) (6)]));
 }else 
{RDebugUtils.currentLine=3604504;
 //BA.debugLineNum = 3604504;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=3604505;
 //BA.debugLineNum = 3604505;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=3604506;
 //BA.debugLineNum = 3604506;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=3604507;
 //BA.debugLineNum = 3604507;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3604508;
 //BA.debugLineNum = 3604508;BA.debugLine="spinner1.SelectedIndex = data(0)";
_spinner1.setSelectedIndex((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=3604509;
 //BA.debugLineNum = 3604509;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=3604510;
 //BA.debugLineNum = 3604510;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=3604511;
 //BA.debugLineNum = 3604511;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=3604512;
 //BA.debugLineNum = 3604512;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3604513;
 //BA.debugLineNum = 3604513;BA.debugLine="radio.Checked = data(0)";
_radio.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=3604514;
 //BA.debugLineNum = 3604514;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=3604515;
 //BA.debugLineNum = 3604515;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=3604516;
 //BA.debugLineNum = 3604516;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=3604517;
 //BA.debugLineNum = 3604517;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3604518;
 //BA.debugLineNum = 3604518;BA.debugLine="toggle.Checked = data(0)";
_toggle.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=3604519;
 //BA.debugLineNum = 3604519;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=3604520;
 //BA.debugLineNum = 3604520;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=3604521;
 //BA.debugLineNum = 3604521;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=3604522;
 //BA.debugLineNum = 3604522;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3604523;
 //BA.debugLineNum = 3604523;BA.debugLine="seek.Value = data(0)";
_seek.setValue((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=3604524;
 //BA.debugLineNum = 3604524;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=3604525;
 //BA.debugLineNum = 3604525;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=3604526;
 //BA.debugLineNum = 3604526;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=3604527;
 //BA.debugLineNum = 3604527;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3604528;
 //BA.debugLineNum = 3604528;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step48 = 1;
final int limit48 = (int) (_th.getTabCount()-1);
for (_i = (int) (0) ; (step48 > 0 && _i <= limit48) || (step48 < 0 && _i >= limit48); _i = ((int)(0 + _i + step48)) ) {
RDebugUtils.currentLine=3604529;
 //BA.debugLineNum = 3604529;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=3604531;
 //BA.debugLineNum = 3604531;BA.debugLine="th.CurrentTab = data(0)";
_th.setCurrentTab((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=3604532;
 //BA.debugLineNum = 3604532;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=3604533;
 //BA.debugLineNum = 3604533;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=3604534;
 //BA.debugLineNum = 3604534;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3604535;
 //BA.debugLineNum = 3604535;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=3604536;
 //BA.debugLineNum = 3604536;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step56 = 1;
final int limit56 = (int) (_tabparentpanel.getNumberOfViews()-1);
for (_i = (int) (0) ; (step56 > 0 && _i <= limit56) || (step56 < 0 && _i >= limit56); _i = ((int)(0 + _i + step56)) ) {
RDebugUtils.currentLine=3604537;
 //BA.debugLineNum = 3604537;BA.debugLine="innerRestoreState(tabParentPanel.GetView(i), li";
_innerrestorestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=3604539;
 //BA.debugLineNum = 3604539;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=3604540;
 //BA.debugLineNum = 3604540;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=3604541;
 //BA.debugLineNum = 3604541;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=3604542;
 //BA.debugLineNum = 3604542;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=3604543;
 //BA.debugLineNum = 3604543;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=3604544;
 //BA.debugLineNum = 3604544;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
RDebugUtils.currentLine=3604545;
 //BA.debugLineNum = 3604545;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=3604546;
 //BA.debugLineNum = 3604546;BA.debugLine="innerRestoreState(sv.Panel, list1)";
_innerrestorestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=3604547;
 //BA.debugLineNum = 3604547;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=3604548;
 //BA.debugLineNum = 3604548;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3604549;
 //BA.debugLineNum = 3604549;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=3604550;
 //BA.debugLineNum = 3604550;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step70 = 1;
final int limit70 = (int) (_panel1.getNumberOfViews()-1);
for (_i = (int) (0) ; (step70 > 0 && _i <= limit70) || (step70 < 0 && _i >= limit70); _i = ((int)(0 + _i + step70)) ) {
RDebugUtils.currentLine=3604551;
 //BA.debugLineNum = 3604551;BA.debugLine="innerRestoreState(panel1.GetView(i), list1)";
_innerrestorestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}}};
RDebugUtils.currentLine=3604554;
 //BA.debugLineNum = 3604554;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub innerSaveState(v As View, list1 As List)";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="data = Array As Object(edit.Text, edit.Selection";
_data = new Object[]{(Object)(_edit.getText()),(Object)(_edit.getSelectionStart())};
 }else 
{RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="data = Array As Object(check.Checked)";
_data = new Object[]{(Object)(_check.getChecked())};
 }else 
{RDebugUtils.currentLine=3538954;
 //BA.debugLineNum = 3538954;BA.debugLine="Else If v Is Button Then";
if (_v.getObjectOrNull() instanceof android.widget.Button) { 
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="Dim Button1 As Button";
_button1 = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=3538956;
 //BA.debugLineNum = 3538956;BA.debugLine="Button1 = v";
_button1.setObject((android.widget.Button)(_v.getObject()));
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="data = Array As Object(Button1.Text,Button1.tag,";
_data = new Object[]{(Object)(_button1.getText()),_button1.getTag(),(Object)(_button1.getLeft()),(Object)(_button1.getTop()),(Object)(_button1.getWidth()),(Object)(_button1.getHeight()),(Object)(_button1.getBackground())};
 }else 
{RDebugUtils.currentLine=3538958;
 //BA.debugLineNum = 3538958;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=3538959;
 //BA.debugLineNum = 3538959;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=3538960;
 //BA.debugLineNum = 3538960;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=3538961;
 //BA.debugLineNum = 3538961;BA.debugLine="data = Array As Object(spinner1.SelectedIndex)";
_data = new Object[]{(Object)(_spinner1.getSelectedIndex())};
 }else 
{RDebugUtils.currentLine=3538962;
 //BA.debugLineNum = 3538962;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=3538963;
 //BA.debugLineNum = 3538963;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=3538964;
 //BA.debugLineNum = 3538964;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=3538965;
 //BA.debugLineNum = 3538965;BA.debugLine="data = Array As Object(radio.Checked)";
_data = new Object[]{(Object)(_radio.getChecked())};
 }else 
{RDebugUtils.currentLine=3538966;
 //BA.debugLineNum = 3538966;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=3538967;
 //BA.debugLineNum = 3538967;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=3538968;
 //BA.debugLineNum = 3538968;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=3538969;
 //BA.debugLineNum = 3538969;BA.debugLine="data = Array As Object(toggle.Checked)";
_data = new Object[]{(Object)(_toggle.getChecked())};
 }else 
{RDebugUtils.currentLine=3538970;
 //BA.debugLineNum = 3538970;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=3538971;
 //BA.debugLineNum = 3538971;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=3538972;
 //BA.debugLineNum = 3538972;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=3538973;
 //BA.debugLineNum = 3538973;BA.debugLine="data = Array As Object(seek.Value)";
_data = new Object[]{(Object)(_seek.getValue())};
 }else 
{RDebugUtils.currentLine=3538974;
 //BA.debugLineNum = 3538974;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=3538975;
 //BA.debugLineNum = 3538975;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=3538976;
 //BA.debugLineNum = 3538976;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=3538977;
 //BA.debugLineNum = 3538977;BA.debugLine="data = Array As Object(th.CurrentTab)";
_data = new Object[]{(Object)(_th.getCurrentTab())};
RDebugUtils.currentLine=3538978;
 //BA.debugLineNum = 3538978;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step34 = 1;
final int limit34 = (int) (_th.getTabCount()-1);
for (_i = (int) (0) ; (step34 > 0 && _i <= limit34) || (step34 < 0 && _i >= limit34); _i = ((int)(0 + _i + step34)) ) {
RDebugUtils.currentLine=3538979;
 //BA.debugLineNum = 3538979;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=3538981;
 //BA.debugLineNum = 3538981;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=3538982;
 //BA.debugLineNum = 3538982;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3538983;
 //BA.debugLineNum = 3538983;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=3538984;
 //BA.debugLineNum = 3538984;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=3538985;
 //BA.debugLineNum = 3538985;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3538986;
 //BA.debugLineNum = 3538986;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=3538987;
 //BA.debugLineNum = 3538987;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step43 = 1;
final int limit43 = (int) (_tabparentpanel.getNumberOfViews()-1);
for (_i = (int) (0) ; (step43 > 0 && _i <= limit43) || (step43 < 0 && _i >= limit43); _i = ((int)(0 + _i + step43)) ) {
RDebugUtils.currentLine=3538988;
 //BA.debugLineNum = 3538988;BA.debugLine="innerSaveState(tabParentPanel.GetView(i), list1";
_innersavestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=3538990;
 //BA.debugLineNum = 3538990;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=3538991;
 //BA.debugLineNum = 3538991;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=3538992;
 //BA.debugLineNum = 3538992;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=3538993;
 //BA.debugLineNum = 3538993;BA.debugLine="data = Array As Object(sv.ScrollPosition)";
_data = new Object[]{(Object)(_sv.getScrollPosition())};
RDebugUtils.currentLine=3538994;
 //BA.debugLineNum = 3538994;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=3538995;
 //BA.debugLineNum = 3538995;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=3538996;
 //BA.debugLineNum = 3538996;BA.debugLine="innerSaveState(sv.Panel, list1)";
_innersavestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=3538997;
 //BA.debugLineNum = 3538997;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=3538998;
 //BA.debugLineNum = 3538998;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=3538999;
 //BA.debugLineNum = 3538999;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=3539000;
 //BA.debugLineNum = 3539000;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step56 = 1;
final int limit56 = (int) (_panel1.getNumberOfViews()-1);
for (_i = (int) (0) ; (step56 > 0 && _i <= limit56) || (step56 < 0 && _i >= limit56); _i = ((int)(0 + _i + step56)) ) {
RDebugUtils.currentLine=3539001;
 //BA.debugLineNum = 3539001;BA.debugLine="innerSaveState(panel1.GetView(i), list1)";
_innersavestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}}};
RDebugUtils.currentLine=3539004;
 //BA.debugLineNum = 3539004;BA.debugLine="If data.Length > 0 Then list1.Add(data)";
if (_data.length>0) { 
_list1.Add((Object)(_data));};
RDebugUtils.currentLine=3539005;
 //BA.debugLineNum = 3539005;BA.debugLine="End Sub";
return "";
}
public static String  _loadstatefile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("loadstatefile"))
	return (String) Debug.delegate(null, "loadstatefile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub loadStateFile";
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="If states.IsInitialized Then Return";
if (_states.IsInitialized()) { 
if (true) return "";};
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="If File.Exists(File.DirInternal, statesFileName)";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename)) { 
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="states = raf.ReadObject(0)";
_states.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_raf.ReadObject((long) (0))));
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="raf.Close";
_raf.Close();
 };
RDebugUtils.currentLine=3801097;
 //BA.debugLineNum = 3801097;BA.debugLine="End Sub";
return "";
}
public static String  _resetstate(anywheresoftware.b4a.BA _ba,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("resetstate"))
	return (String) Debug.delegate(null, "resetstate", new Object[] {_ba,_activityname});
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub ResetState(ActivityName As String)";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="If states.IsInitialized Then";
if (_states.IsInitialized()) { 
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="states.Remove(ActivityName.ToLowerCase)";
_states.Remove((Object)(_activityname.toLowerCase()));
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
 };
RDebugUtils.currentLine=3342342;
 //BA.debugLineNum = 3342342;BA.debugLine="End Sub";
return "";
}
public static String  _writestatetofile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("writestatetofile"))
	return (String) Debug.delegate(null, "writestatetofile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub writeStateToFile";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="raf.WriteObject(states, True, raf.CurrentPosition";
_raf.WriteObject((Object)(_states.getObject()),anywheresoftware.b4a.keywords.Common.True,_raf.CurrentPosition);
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="raf.Close";
_raf.Close();
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="End Sub";
return "";
}
public static boolean  _restorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname,int _validperiodinminutes) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("restorestate"))
	return (Boolean) Debug.delegate(null, "restorestate", new Object[] {_ba,_activity,_activityname,_validperiodinminutes});
anywheresoftware.b4a.objects.collections.List _list1 = null;
long _time = 0L;
int _i = 0;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub RestoreState(Activity As Activity, ActivityNam";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Try";
try {RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="If states.IsInitialized = False Then";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="list1 = states.Get(ActivityName.ToLowerCase)";
_list1.setObject((java.util.List)(_states.Get((Object)(_activityname.toLowerCase()))));
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="If list1.IsInitialized = False Then Return False";
if (_list1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="Dim time As Long";
_time = 0L;
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="time = list1.Get(0)";
_time = BA.ObjectToLongNumber(_list1.Get((int) (0)));
RDebugUtils.currentLine=3735563;
 //BA.debugLineNum = 3735563;BA.debugLine="If ValidPeriodInMinutes > 0 And time + ValidPeri";
if (_validperiodinminutes>0 && _time+_validperiodinminutes*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute<anywheresoftware.b4a.keywords.Common.DateTime.getNow()) { 
RDebugUtils.currentLine=3735564;
 //BA.debugLineNum = 3735564;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3735566;
 //BA.debugLineNum = 3735566;BA.debugLine="listPosition = 0";
_listposition = (int) (0);
RDebugUtils.currentLine=3735567;
 //BA.debugLineNum = 3735567;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step15 = 1;
final int limit15 = (int) (_activity.getNumberOfViews()-1);
for (_i = (int) (0) ; (step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15); _i = ((int)(0 + _i + step15)) ) {
RDebugUtils.currentLine=3735568;
 //BA.debugLineNum = 3735568;BA.debugLine="innerRestoreState(Activity.GetView(i), list1)";
_innerrestorestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=3735570;
 //BA.debugLineNum = 3735570;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e220) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e220);RDebugUtils.currentLine=3735572;
 //BA.debugLineNum = 3735572;BA.debugLine="Log(\"Error loading state.\")";
anywheresoftware.b4a.keywords.Common.Log("Error loading state.");
RDebugUtils.currentLine=3735573;
 //BA.debugLineNum = 3735573;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage());
RDebugUtils.currentLine=3735574;
 //BA.debugLineNum = 3735574;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3735576;
 //BA.debugLineNum = 3735576;BA.debugLine="End Sub";
return false;
}
public static String  _savestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("savestate"))
	return (String) Debug.delegate(null, "savestate", new Object[] {_ba,_activity,_activityname});
anywheresoftware.b4a.objects.collections.List _list1 = null;
int _i = 0;
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub SaveState(Activity As Activity, ActivityName A";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="If states.IsInitialized = False Then states.Initi";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_states.Initialize();};
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="list1.Initialize";
_list1.Initialize();
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="list1.Add(DateTime.Now)";
_list1.Add((Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step5 = 1;
final int limit5 = (int) (_activity.getNumberOfViews()-1);
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="innerSaveState(Activity.GetView(i), list1)";
_innersavestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=3407880;
 //BA.debugLineNum = 3407880;BA.debugLine="states.Put(ActivityName.ToLowerCase, list1)";
_states.Put((Object)(_activityname.toLowerCase()),(Object)(_list1.getObject()));
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="End Sub";
return "";
}
}