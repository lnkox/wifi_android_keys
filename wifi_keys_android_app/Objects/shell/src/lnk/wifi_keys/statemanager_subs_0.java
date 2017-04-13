package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class statemanager_subs_0 {


public static RemoteObject  _getnextitem(RemoteObject _ba,RemoteObject _list1) throws Exception{
try {
		Debug.PushSubsStack("getNextItem (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,213);
if (RapidSub.canDelegate("getnextitem")) return statemanager.remoteMe.runUserSub(false, "statemanager","getnextitem", _ba, _list1);
;
Debug.locals.put("list1", _list1);
 BA.debugLineNum = 213;BA.debugLine="Sub getNextItem(list1 As List) As Object()";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 214;BA.debugLine="listPosition = listPosition + 1";
Debug.ShouldStop(2097152);
statemanager._listposition = RemoteObject.solve(new RemoteObject[] {statemanager._listposition,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 215;BA.debugLine="Return list1.Get(listPosition)";
Debug.ShouldStop(4194304);
if (true) return (_list1.runMethod(false,"Get",(Object)(statemanager._listposition)));
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getsetting2(RemoteObject _ba,RemoteObject _key,RemoteObject _defaultvalue) throws Exception{
try {
		Debug.PushSubsStack("GetSetting2 (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,13);
if (RapidSub.canDelegate("getsetting2")) return statemanager.remoteMe.runUserSub(false, "statemanager","getsetting2", _ba, _key, _defaultvalue);
RemoteObject _v = RemoteObject.createImmutable("");
;
Debug.locals.put("Key", _key);
Debug.locals.put("DefaultValue", _defaultvalue);
 BA.debugLineNum = 13;BA.debugLine="Sub GetSetting2(Key As String, DefaultValue As Str";
Debug.ShouldStop(4096);
 BA.debugLineNum = 14;BA.debugLine="If settings.IsInitialized = False Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",statemanager._settings.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 16;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
Debug.ShouldStop(32768);
if (statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 17;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
Debug.ShouldStop(65536);
statemanager._settings = statemanager.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadMap",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename));
 }else {
 BA.debugLineNum = 19;BA.debugLine="Return DefaultValue";
Debug.ShouldStop(262144);
if (true) return _defaultvalue;
 };
 };
 BA.debugLineNum = 22;BA.debugLine="Dim v As String";
Debug.ShouldStop(2097152);
_v = RemoteObject.createImmutable("");Debug.locals.put("v", _v);
 BA.debugLineNum = 23;BA.debugLine="v = settings.GetDefault(Key.ToLowerCase, DefaultV";
Debug.ShouldStop(4194304);
_v = BA.ObjectToString(statemanager._settings.runMethod(false,"GetDefault",(Object)((_key.runMethod(true,"toLowerCase"))),(Object)((_defaultvalue))));Debug.locals.put("v", _v);
 BA.debugLineNum = 24;BA.debugLine="Return v";
Debug.ShouldStop(8388608);
if (true) return _v;
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _innerrestorestate(RemoteObject _ba,RemoteObject _v,RemoteObject _list1) throws Exception{
try {
		Debug.PushSubsStack("innerRestoreState (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,137);
if (RapidSub.canDelegate("innerrestorestate")) return statemanager.remoteMe.runUserSub(false, "statemanager","innerrestorestate", _ba, _v, _list1);
RemoteObject _data = null;
RemoteObject _edit = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
RemoteObject _check = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _button1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _spinner1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
RemoteObject _radio = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _toggle = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
RemoteObject _seek = RemoteObject.declareNull("anywheresoftware.b4a.objects.SeekBarWrapper");
RemoteObject _th = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabHostWrapper");
int _i = 0;
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _tabparentpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _sv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
;
Debug.locals.put("v", _v);
Debug.locals.put("list1", _list1);
 BA.debugLineNum = 137;BA.debugLine="Sub innerRestoreState(v As View, list1 As List)";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="Dim data() As Object";
Debug.ShouldStop(512);
_data = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("data", _data);
 BA.debugLineNum = 139;BA.debugLine="If v Is EditText Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.EditText"))) { 
 BA.debugLineNum = 140;BA.debugLine="Dim edit As EditText";
Debug.ShouldStop(2048);
_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");Debug.locals.put("edit", _edit);
 BA.debugLineNum = 141;BA.debugLine="edit = v";
Debug.ShouldStop(4096);
_edit.setObject(_v.getObject());
 BA.debugLineNum = 142;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(8192);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 143;BA.debugLine="edit.Text = data(0)";
Debug.ShouldStop(16384);
_edit.runMethodAndSync(true,"setText",_data.getArrayElement(false,BA.numberCast(int.class, 0)));
 BA.debugLineNum = 144;BA.debugLine="edit.SelectionStart = data(1)";
Debug.ShouldStop(32768);
_edit.runMethod(true,"setSelectionStart",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 1))));
 }else 
{ BA.debugLineNum = 145;BA.debugLine="Else If v Is CheckBox Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.CheckBox"))) { 
 BA.debugLineNum = 146;BA.debugLine="Dim check As CheckBox";
Debug.ShouldStop(131072);
_check = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("check", _check);
 BA.debugLineNum = 147;BA.debugLine="check = v";
Debug.ShouldStop(262144);
_check.setObject(_v.getObject());
 BA.debugLineNum = 148;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(524288);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 149;BA.debugLine="check.Checked = data(0)";
Debug.ShouldStop(1048576);
_check.runMethodAndSync(true,"setChecked",BA.ObjectToBoolean(_data.getArrayElement(false,BA.numberCast(int.class, 0))));
 }else 
{ BA.debugLineNum = 150;BA.debugLine="Else If v Is Button Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.Button"))) { 
 BA.debugLineNum = 151;BA.debugLine="Dim Button1 As Button";
Debug.ShouldStop(4194304);
_button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("Button1", _button1);
 BA.debugLineNum = 152;BA.debugLine="Button1 = v";
Debug.ShouldStop(8388608);
_button1.setObject(_v.getObject());
 BA.debugLineNum = 153;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(16777216);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 154;BA.debugLine="Button1.Text = data(0)";
Debug.ShouldStop(33554432);
_button1.runMethod(true,"setText",_data.getArrayElement(false,BA.numberCast(int.class, 0)));
 BA.debugLineNum = 155;BA.debugLine="Button1.Tag = data(1)";
Debug.ShouldStop(67108864);
_button1.runMethod(false,"setTag",_data.getArrayElement(false,BA.numberCast(int.class, 1)));
 BA.debugLineNum = 156;BA.debugLine="Button1.Left= data(2)";
Debug.ShouldStop(134217728);
_button1.runMethod(true,"setLeft",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 2))));
 BA.debugLineNum = 157;BA.debugLine="Button1.Top= data(3)";
Debug.ShouldStop(268435456);
_button1.runMethod(true,"setTop",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 3))));
 BA.debugLineNum = 158;BA.debugLine="Button1.Width= data(4)";
Debug.ShouldStop(536870912);
_button1.runMethod(true,"setWidth",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 4))));
 BA.debugLineNum = 159;BA.debugLine="Button1.Height= data(5)";
Debug.ShouldStop(1073741824);
_button1.runMethod(true,"setHeight",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 5))));
 BA.debugLineNum = 160;BA.debugLine="Button1.Background =data(6)";
Debug.ShouldStop(-2147483648);
_button1.runMethod(false,"setBackground",(_data.getArrayElement(false,BA.numberCast(int.class, 6))));
 }else 
{ BA.debugLineNum = 161;BA.debugLine="Else If v Is Spinner Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner"))) { 
 BA.debugLineNum = 162;BA.debugLine="Dim spinner1 As Spinner";
Debug.ShouldStop(2);
_spinner1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("spinner1", _spinner1);
 BA.debugLineNum = 163;BA.debugLine="spinner1 = v";
Debug.ShouldStop(4);
_spinner1.setObject(_v.getObject());
 BA.debugLineNum = 164;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(8);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 165;BA.debugLine="spinner1.SelectedIndex = data(0)";
Debug.ShouldStop(16);
_spinner1.runMethod(true,"setSelectedIndex",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 0))));
 }else 
{ BA.debugLineNum = 166;BA.debugLine="Else If v Is RadioButton Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.RadioButton"))) { 
 BA.debugLineNum = 167;BA.debugLine="Dim radio As RadioButton";
Debug.ShouldStop(64);
_radio = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");Debug.locals.put("radio", _radio);
 BA.debugLineNum = 168;BA.debugLine="radio = v";
Debug.ShouldStop(128);
_radio.setObject(_v.getObject());
 BA.debugLineNum = 169;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(256);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 170;BA.debugLine="radio.Checked = data(0)";
Debug.ShouldStop(512);
_radio.runMethodAndSync(true,"setChecked",BA.ObjectToBoolean(_data.getArrayElement(false,BA.numberCast(int.class, 0))));
 }else 
{ BA.debugLineNum = 171;BA.debugLine="Else If v Is ToggleButton Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.ToggleButton"))) { 
 BA.debugLineNum = 172;BA.debugLine="Dim toggle As ToggleButton";
Debug.ShouldStop(2048);
_toggle = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");Debug.locals.put("toggle", _toggle);
 BA.debugLineNum = 173;BA.debugLine="toggle = v";
Debug.ShouldStop(4096);
_toggle.setObject(_v.getObject());
 BA.debugLineNum = 174;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(8192);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 175;BA.debugLine="toggle.Checked = data(0)";
Debug.ShouldStop(16384);
_toggle.runMethodAndSync(true,"setChecked",BA.ObjectToBoolean(_data.getArrayElement(false,BA.numberCast(int.class, 0))));
 }else 
{ BA.debugLineNum = 176;BA.debugLine="Else If v Is SeekBar Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.SeekBar"))) { 
 BA.debugLineNum = 177;BA.debugLine="Dim seek As SeekBar";
Debug.ShouldStop(65536);
_seek = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");Debug.locals.put("seek", _seek);
 BA.debugLineNum = 178;BA.debugLine="seek = v";
Debug.ShouldStop(131072);
_seek.setObject(_v.getObject());
 BA.debugLineNum = 179;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(262144);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 180;BA.debugLine="seek.Value = data(0)";
Debug.ShouldStop(524288);
_seek.runMethod(true,"setValue",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 0))));
 }else 
{ BA.debugLineNum = 181;BA.debugLine="Else If v Is TabHost Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TabHost"))) { 
 BA.debugLineNum = 182;BA.debugLine="Dim th As TabHost";
Debug.ShouldStop(2097152);
_th = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");Debug.locals.put("th", _th);
 BA.debugLineNum = 183;BA.debugLine="th = v";
Debug.ShouldStop(4194304);
_th.setObject(_v.getObject());
 BA.debugLineNum = 184;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(8388608);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 185;BA.debugLine="For i = 0 To th.TabCount - 1";
Debug.ShouldStop(16777216);
{
final int step48 = 1;
final int limit48 = RemoteObject.solve(new RemoteObject[] {_th.runMethod(true,"getTabCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step48 > 0 && _i <= limit48) || (step48 < 0 && _i >= limit48); _i = ((int)(0 + _i + step48)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 186;BA.debugLine="th.CurrentTab = i";
Debug.ShouldStop(33554432);
_th.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 188;BA.debugLine="th.CurrentTab = data(0)";
Debug.ShouldStop(134217728);
_th.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 189;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(268435456);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 190;BA.debugLine="r.Target = th";
Debug.ShouldStop(536870912);
_r.setField ("Target",(_th.getObject()));
 BA.debugLineNum = 191;BA.debugLine="Dim tabParentPanel As Panel";
Debug.ShouldStop(1073741824);
_tabparentpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("tabParentPanel", _tabparentpanel);
 BA.debugLineNum = 192;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
Debug.ShouldStop(-2147483648);
_tabparentpanel.setObject(_r.runMethod(false,"RunMethod",(Object)(RemoteObject.createImmutable("getTabContentView"))));
 BA.debugLineNum = 193;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
Debug.ShouldStop(1);
{
final int step56 = 1;
final int limit56 = RemoteObject.solve(new RemoteObject[] {_tabparentpanel.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step56 > 0 && _i <= limit56) || (step56 < 0 && _i >= limit56); _i = ((int)(0 + _i + step56)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 194;BA.debugLine="innerRestoreState(tabParentPanel.GetView(i), li";
Debug.ShouldStop(2);
_innerrestorestate(_ba,_tabparentpanel.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))),_list1);
 }
}Debug.locals.put("i", _i);
;
 }else 
{ BA.debugLineNum = 196;BA.debugLine="Else If v Is ScrollView Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.ScrollView"))) { 
 BA.debugLineNum = 197;BA.debugLine="Dim sv As ScrollView";
Debug.ShouldStop(16);
_sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");Debug.locals.put("sv", _sv);
 BA.debugLineNum = 198;BA.debugLine="sv = v";
Debug.ShouldStop(32);
_sv.setObject(_v.getObject());
 BA.debugLineNum = 199;BA.debugLine="data = getNextItem(list1)";
Debug.ShouldStop(64);
_data = _getnextitem(_ba,_list1);Debug.locals.put("data", _data);
 BA.debugLineNum = 200;BA.debugLine="sv.ScrollPosition = data(0)";
Debug.ShouldStop(128);
_sv.runMethod(true,"setScrollPosition",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 201;BA.debugLine="DoEvents";
Debug.ShouldStop(256);
statemanager.mostCurrent.__c.runVoidMethodAndSync ("DoEvents");
 BA.debugLineNum = 202;BA.debugLine="sv.ScrollPosition = data(0)";
Debug.ShouldStop(512);
_sv.runMethod(true,"setScrollPosition",BA.numberCast(int.class, _data.getArrayElement(false,BA.numberCast(int.class, 0))));
 BA.debugLineNum = 203;BA.debugLine="innerRestoreState(sv.Panel, list1)";
Debug.ShouldStop(1024);
_innerrestorestate(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _sv.runMethod(false,"getPanel").getObject()),_list1);
 }else 
{ BA.debugLineNum = 204;BA.debugLine="Else If v Is Panel Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.view.ViewGroup"))) { 
 BA.debugLineNum = 205;BA.debugLine="Dim panel1 As Panel";
Debug.ShouldStop(4096);
_panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("panel1", _panel1);
 BA.debugLineNum = 206;BA.debugLine="panel1 = v";
Debug.ShouldStop(8192);
_panel1.setObject(_v.getObject());
 BA.debugLineNum = 207;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
Debug.ShouldStop(16384);
{
final int step70 = 1;
final int limit70 = RemoteObject.solve(new RemoteObject[] {_panel1.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step70 > 0 && _i <= limit70) || (step70 < 0 && _i >= limit70); _i = ((int)(0 + _i + step70)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 208;BA.debugLine="innerRestoreState(panel1.GetView(i), list1)";
Debug.ShouldStop(32768);
_innerrestorestate(_ba,_panel1.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))),_list1);
 }
}Debug.locals.put("i", _i);
;
 }}}}}}}}}};
 BA.debugLineNum = 211;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _innersavestate(RemoteObject _ba,RemoteObject _v,RemoteObject _list1) throws Exception{
try {
		Debug.PushSubsStack("innerSaveState (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,75);
if (RapidSub.canDelegate("innersavestate")) return statemanager.remoteMe.runUserSub(false, "statemanager","innersavestate", _ba, _v, _list1);
RemoteObject _data = null;
RemoteObject _edit = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
RemoteObject _check = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _button1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _spinner1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
RemoteObject _radio = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");
RemoteObject _toggle = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");
RemoteObject _seek = RemoteObject.declareNull("anywheresoftware.b4a.objects.SeekBarWrapper");
RemoteObject _th = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabHostWrapper");
int _i = 0;
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _tabparentpanel = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
RemoteObject _sv = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
;
Debug.locals.put("v", _v);
Debug.locals.put("list1", _list1);
 BA.debugLineNum = 75;BA.debugLine="Sub innerSaveState(v As View, list1 As List)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="Dim data() As Object";
Debug.ShouldStop(2048);
_data = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("data", _data);
 BA.debugLineNum = 77;BA.debugLine="If v Is EditText Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.EditText"))) { 
 BA.debugLineNum = 78;BA.debugLine="Dim edit As EditText";
Debug.ShouldStop(8192);
_edit = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");Debug.locals.put("edit", _edit);
 BA.debugLineNum = 79;BA.debugLine="edit = v";
Debug.ShouldStop(16384);
_edit.setObject(_v.getObject());
 BA.debugLineNum = 80;BA.debugLine="data = Array As Object(edit.Text, edit.Selection";
Debug.ShouldStop(32768);
_data = RemoteObject.createNewArray("Object",new int[] {2},new Object[] {(_edit.runMethod(true,"getText")),(_edit.runMethod(true,"getSelectionStart"))});Debug.locals.put("data", _data);
 }else 
{ BA.debugLineNum = 81;BA.debugLine="Else If v Is CheckBox Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.CheckBox"))) { 
 BA.debugLineNum = 82;BA.debugLine="Dim check As CheckBox";
Debug.ShouldStop(131072);
_check = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("check", _check);
 BA.debugLineNum = 83;BA.debugLine="check = v";
Debug.ShouldStop(262144);
_check.setObject(_v.getObject());
 BA.debugLineNum = 84;BA.debugLine="data = Array As Object(check.Checked)";
Debug.ShouldStop(524288);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_check.runMethod(true,"getChecked"))});Debug.locals.put("data", _data);
 }else 
{ BA.debugLineNum = 85;BA.debugLine="Else If v Is Button Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.Button"))) { 
 BA.debugLineNum = 86;BA.debugLine="Dim Button1 As Button";
Debug.ShouldStop(2097152);
_button1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("Button1", _button1);
 BA.debugLineNum = 87;BA.debugLine="Button1 = v";
Debug.ShouldStop(4194304);
_button1.setObject(_v.getObject());
 BA.debugLineNum = 88;BA.debugLine="data = Array As Object(Button1.Text,Button1.tag,";
Debug.ShouldStop(8388608);
_data = RemoteObject.createNewArray("Object",new int[] {7},new Object[] {(_button1.runMethod(true,"getText")),_button1.runMethod(false,"getTag"),(_button1.runMethod(true,"getLeft")),(_button1.runMethod(true,"getTop")),(_button1.runMethod(true,"getWidth")),(_button1.runMethod(true,"getHeight")),(_button1.runMethod(false,"getBackground"))});Debug.locals.put("data", _data);
 }else 
{ BA.debugLineNum = 89;BA.debugLine="Else If v Is Spinner Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner"))) { 
 BA.debugLineNum = 90;BA.debugLine="Dim spinner1 As Spinner";
Debug.ShouldStop(33554432);
_spinner1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.SpinnerWrapper");Debug.locals.put("spinner1", _spinner1);
 BA.debugLineNum = 91;BA.debugLine="spinner1 = v";
Debug.ShouldStop(67108864);
_spinner1.setObject(_v.getObject());
 BA.debugLineNum = 92;BA.debugLine="data = Array As Object(spinner1.SelectedIndex)";
Debug.ShouldStop(134217728);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_spinner1.runMethod(true,"getSelectedIndex"))});Debug.locals.put("data", _data);
 }else 
{ BA.debugLineNum = 93;BA.debugLine="Else If v Is RadioButton Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.RadioButton"))) { 
 BA.debugLineNum = 94;BA.debugLine="Dim radio As RadioButton";
Debug.ShouldStop(536870912);
_radio = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper");Debug.locals.put("radio", _radio);
 BA.debugLineNum = 95;BA.debugLine="radio = v";
Debug.ShouldStop(1073741824);
_radio.setObject(_v.getObject());
 BA.debugLineNum = 96;BA.debugLine="data = Array As Object(radio.Checked)";
Debug.ShouldStop(-2147483648);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_radio.runMethod(true,"getChecked"))});Debug.locals.put("data", _data);
 }else 
{ BA.debugLineNum = 97;BA.debugLine="Else If v Is ToggleButton Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.ToggleButton"))) { 
 BA.debugLineNum = 98;BA.debugLine="Dim toggle As ToggleButton";
Debug.ShouldStop(2);
_toggle = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper");Debug.locals.put("toggle", _toggle);
 BA.debugLineNum = 99;BA.debugLine="toggle = v";
Debug.ShouldStop(4);
_toggle.setObject(_v.getObject());
 BA.debugLineNum = 100;BA.debugLine="data = Array As Object(toggle.Checked)";
Debug.ShouldStop(8);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_toggle.runMethod(true,"getChecked"))});Debug.locals.put("data", _data);
 }else 
{ BA.debugLineNum = 101;BA.debugLine="Else If v Is SeekBar Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.SeekBar"))) { 
 BA.debugLineNum = 102;BA.debugLine="Dim seek As SeekBar";
Debug.ShouldStop(32);
_seek = RemoteObject.createNew ("anywheresoftware.b4a.objects.SeekBarWrapper");Debug.locals.put("seek", _seek);
 BA.debugLineNum = 103;BA.debugLine="seek = v";
Debug.ShouldStop(64);
_seek.setObject(_v.getObject());
 BA.debugLineNum = 104;BA.debugLine="data = Array As Object(seek.Value)";
Debug.ShouldStop(128);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_seek.runMethod(true,"getValue"))});Debug.locals.put("data", _data);
 }else 
{ BA.debugLineNum = 105;BA.debugLine="Else If v Is TabHost Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.TabHost"))) { 
 BA.debugLineNum = 106;BA.debugLine="Dim th As TabHost";
Debug.ShouldStop(512);
_th = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");Debug.locals.put("th", _th);
 BA.debugLineNum = 107;BA.debugLine="th = v";
Debug.ShouldStop(1024);
_th.setObject(_v.getObject());
 BA.debugLineNum = 108;BA.debugLine="data = Array As Object(th.CurrentTab)";
Debug.ShouldStop(2048);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_th.runMethod(true,"getCurrentTab"))});Debug.locals.put("data", _data);
 BA.debugLineNum = 109;BA.debugLine="For i = 0 To th.TabCount - 1";
Debug.ShouldStop(4096);
{
final int step34 = 1;
final int limit34 = RemoteObject.solve(new RemoteObject[] {_th.runMethod(true,"getTabCount"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step34 > 0 && _i <= limit34) || (step34 < 0 && _i >= limit34); _i = ((int)(0 + _i + step34)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 110;BA.debugLine="th.CurrentTab = i";
Debug.ShouldStop(8192);
_th.runMethodAndSync(true,"setCurrentTab",BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 112;BA.debugLine="list1.Add(data)";
Debug.ShouldStop(32768);
_list1.runVoidMethod ("Add",(Object)((_data)));
 BA.debugLineNum = 113;BA.debugLine="Dim data() As Object";
Debug.ShouldStop(65536);
_data = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("data", _data);
 BA.debugLineNum = 114;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(131072);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 115;BA.debugLine="r.Target = th";
Debug.ShouldStop(262144);
_r.setField ("Target",(_th.getObject()));
 BA.debugLineNum = 116;BA.debugLine="Dim tabParentPanel As Panel";
Debug.ShouldStop(524288);
_tabparentpanel = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("tabParentPanel", _tabparentpanel);
 BA.debugLineNum = 117;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
Debug.ShouldStop(1048576);
_tabparentpanel.setObject(_r.runMethod(false,"RunMethod",(Object)(RemoteObject.createImmutable("getTabContentView"))));
 BA.debugLineNum = 118;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
Debug.ShouldStop(2097152);
{
final int step43 = 1;
final int limit43 = RemoteObject.solve(new RemoteObject[] {_tabparentpanel.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step43 > 0 && _i <= limit43) || (step43 < 0 && _i >= limit43); _i = ((int)(0 + _i + step43)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 119;BA.debugLine="innerSaveState(tabParentPanel.GetView(i), list1";
Debug.ShouldStop(4194304);
_innersavestate(_ba,_tabparentpanel.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))),_list1);
 }
}Debug.locals.put("i", _i);
;
 }else 
{ BA.debugLineNum = 121;BA.debugLine="Else If v Is ScrollView Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.widget.ScrollView"))) { 
 BA.debugLineNum = 122;BA.debugLine="Dim sv As ScrollView";
Debug.ShouldStop(33554432);
_sv = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");Debug.locals.put("sv", _sv);
 BA.debugLineNum = 123;BA.debugLine="sv = v";
Debug.ShouldStop(67108864);
_sv.setObject(_v.getObject());
 BA.debugLineNum = 124;BA.debugLine="data = Array As Object(sv.ScrollPosition)";
Debug.ShouldStop(134217728);
_data = RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_sv.runMethod(true,"getScrollPosition"))});Debug.locals.put("data", _data);
 BA.debugLineNum = 125;BA.debugLine="list1.Add(data)";
Debug.ShouldStop(268435456);
_list1.runVoidMethod ("Add",(Object)((_data)));
 BA.debugLineNum = 126;BA.debugLine="Dim data() As Object";
Debug.ShouldStop(536870912);
_data = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("data", _data);
 BA.debugLineNum = 127;BA.debugLine="innerSaveState(sv.Panel, list1)";
Debug.ShouldStop(1073741824);
_innersavestate(_ba,RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.ConcreteViewWrapper"), _sv.runMethod(false,"getPanel").getObject()),_list1);
 }else 
{ BA.debugLineNum = 128;BA.debugLine="Else If v Is Panel Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("i",_v.getObjectOrNull(), RemoteObject.createImmutable("android.view.ViewGroup"))) { 
 BA.debugLineNum = 129;BA.debugLine="Dim panel1 As Panel";
Debug.ShouldStop(1);
_panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");Debug.locals.put("panel1", _panel1);
 BA.debugLineNum = 130;BA.debugLine="panel1 = v";
Debug.ShouldStop(2);
_panel1.setObject(_v.getObject());
 BA.debugLineNum = 131;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
Debug.ShouldStop(4);
{
final int step56 = 1;
final int limit56 = RemoteObject.solve(new RemoteObject[] {_panel1.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step56 > 0 && _i <= limit56) || (step56 < 0 && _i >= limit56); _i = ((int)(0 + _i + step56)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 132;BA.debugLine="innerSaveState(panel1.GetView(i), list1)";
Debug.ShouldStop(8);
_innersavestate(_ba,_panel1.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))),_list1);
 }
}Debug.locals.put("i", _i);
;
 }}}}}}}}}};
 BA.debugLineNum = 135;BA.debugLine="If data.Length > 0 Then list1.Add(data)";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean(">",_data.getField(true,"length"),BA.numberCast(double.class, 0))) { 
_list1.runVoidMethod ("Add",(Object)((_data)));};
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _loadstatefile(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("loadStateFile (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,247);
if (RapidSub.canDelegate("loadstatefile")) return statemanager.remoteMe.runUserSub(false, "statemanager","loadstatefile", _ba);
RemoteObject _raf = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.RandomAccessFile");
;
 BA.debugLineNum = 247;BA.debugLine="Sub loadStateFile";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 249;BA.debugLine="If states.IsInitialized Then Return";
Debug.ShouldStop(16777216);
if (statemanager._states.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 250;BA.debugLine="If File.Exists(File.DirInternal, statesFileName)";
Debug.ShouldStop(33554432);
if (statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._statesfilename)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 251;BA.debugLine="Dim raf As RandomAccessFile";
Debug.ShouldStop(67108864);
_raf = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.RandomAccessFile");Debug.locals.put("raf", _raf);
 BA.debugLineNum = 252;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
Debug.ShouldStop(134217728);
_raf.runVoidMethod ("Initialize",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._statesfilename),(Object)(statemanager.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 253;BA.debugLine="states = raf.ReadObject(0)";
Debug.ShouldStop(268435456);
statemanager._states.setObject(_raf.runMethod(false,"ReadObject",(Object)(BA.numberCast(long.class, 0))));
 BA.debugLineNum = 254;BA.debugLine="raf.Close";
Debug.ShouldStop(536870912);
_raf.runVoidMethod ("Close");
 };
 BA.debugLineNum = 256;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Dim states As Map";
statemanager._states = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 5;BA.debugLine="Dim listPosition As Int";
statemanager._listposition = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 6;BA.debugLine="Dim statesFileName, settingsFileName As String";
statemanager._statesfilename = RemoteObject.createImmutable("");
statemanager._settingsfilename = RemoteObject.createImmutable("");
 //BA.debugLineNum = 7;BA.debugLine="statesFileName = \"state.dat\"";
statemanager._statesfilename = BA.ObjectToString("state.dat");
 //BA.debugLineNum = 8;BA.debugLine="settingsFileName = \"settings.properties\"";
statemanager._settingsfilename = BA.ObjectToString("settings.properties");
 //BA.debugLineNum = 9;BA.debugLine="Dim settings As Map";
statemanager._settings = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _resetstate(RemoteObject _ba,RemoteObject _activityname) throws Exception{
try {
		Debug.PushSubsStack("ResetState (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,50);
if (RapidSub.canDelegate("resetstate")) return statemanager.remoteMe.runUserSub(false, "statemanager","resetstate", _ba, _activityname);
;
Debug.locals.put("ActivityName", _activityname);
 BA.debugLineNum = 50;BA.debugLine="Sub ResetState(ActivityName As String)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="loadStateFile";
Debug.ShouldStop(262144);
_loadstatefile(_ba);
 BA.debugLineNum = 52;BA.debugLine="If states.IsInitialized Then";
Debug.ShouldStop(524288);
if (statemanager._states.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 53;BA.debugLine="states.Remove(ActivityName.ToLowerCase)";
Debug.ShouldStop(1048576);
statemanager._states.runVoidMethod ("Remove",(Object)((_activityname.runMethod(true,"toLowerCase"))));
 BA.debugLineNum = 54;BA.debugLine="writeStateToFile";
Debug.ShouldStop(2097152);
_writestatetofile(_ba);
 };
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _restorestate(RemoteObject _ba,RemoteObject _activity,RemoteObject _activityname,RemoteObject _validperiodinminutes) throws Exception{
try {
		Debug.PushSubsStack("RestoreState (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,221);
if (RapidSub.canDelegate("restorestate")) return statemanager.remoteMe.runUserSub(false, "statemanager","restorestate", _ba, _activity, _activityname, _validperiodinminutes);
RemoteObject _list1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _time = RemoteObject.createImmutable(0L);
int _i = 0;
;
Debug.locals.put("Activity", _activity);
Debug.locals.put("ActivityName", _activityname);
Debug.locals.put("ValidPeriodInMinutes", _validperiodinminutes);
 BA.debugLineNum = 221;BA.debugLine="Sub RestoreState(Activity As Activity, ActivityNam";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 222;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 223;BA.debugLine="loadStateFile";
Debug.ShouldStop(1073741824);
_loadstatefile(_ba);
 BA.debugLineNum = 224;BA.debugLine="If states.IsInitialized = False Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",statemanager._states.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 225;BA.debugLine="Return False";
Debug.ShouldStop(1);
Debug.CheckDeviceExceptions();if (true) return statemanager.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 227;BA.debugLine="Dim list1 As List";
Debug.ShouldStop(4);
_list1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list1", _list1);
 BA.debugLineNum = 228;BA.debugLine="list1 = states.Get(ActivityName.ToLowerCase)";
Debug.ShouldStop(8);
_list1.setObject(statemanager._states.runMethod(false,"Get",(Object)((_activityname.runMethod(true,"toLowerCase")))));
 BA.debugLineNum = 229;BA.debugLine="If list1.IsInitialized = False Then Return False";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_list1.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return statemanager.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 230;BA.debugLine="Dim time As Long";
Debug.ShouldStop(32);
_time = RemoteObject.createImmutable(0L);Debug.locals.put("time", _time);
 BA.debugLineNum = 231;BA.debugLine="time = list1.Get(0)";
Debug.ShouldStop(64);
_time = BA.numberCast(long.class, _list1.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("time", _time);
 BA.debugLineNum = 232;BA.debugLine="If ValidPeriodInMinutes > 0 And time + ValidPeri";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean(">",_validperiodinminutes,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("<",RemoteObject.solve(new RemoteObject[] {_time,_validperiodinminutes,statemanager.mostCurrent.__c.getField(false,"DateTime").getField(true,"TicksPerMinute")}, "+*",1, 2),BA.numberCast(double.class, statemanager.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow")))) { 
 BA.debugLineNum = 233;BA.debugLine="Return False";
Debug.ShouldStop(256);
Debug.CheckDeviceExceptions();if (true) return statemanager.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 235;BA.debugLine="listPosition = 0";
Debug.ShouldStop(1024);
statemanager._listposition = BA.numberCast(int.class, 0);
 BA.debugLineNum = 236;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
Debug.ShouldStop(2048);
{
final int step15 = 1;
final int limit15 = RemoteObject.solve(new RemoteObject[] {_activity.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15); _i = ((int)(0 + _i + step15)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 237;BA.debugLine="innerRestoreState(Activity.GetView(i), list1)";
Debug.ShouldStop(4096);
_innerrestorestate(_ba,_activity.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))),_list1);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 239;BA.debugLine="Return True";
Debug.ShouldStop(16384);
Debug.CheckDeviceExceptions();if (true) return statemanager.mostCurrent.__c.getField(true,"True");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e220) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e220.toString()); BA.debugLineNum = 241;BA.debugLine="Log(\"Error loading state.\")";
Debug.ShouldStop(65536);
statemanager.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.createImmutable("Error loading state.")));
 BA.debugLineNum = 242;BA.debugLine="Log(LastException.Message)";
Debug.ShouldStop(131072);
statemanager.mostCurrent.__c.runVoidMethod ("Log",(Object)(statemanager.mostCurrent.__c.runMethod(false,"LastException",_ba).runMethod(true,"getMessage")));
 BA.debugLineNum = 243;BA.debugLine="Return False";
Debug.ShouldStop(262144);
if (true) return statemanager.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 245;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savesettings(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("SaveSettings (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,43);
if (RapidSub.canDelegate("savesettings")) return statemanager.remoteMe.runUserSub(false, "statemanager","savesettings", _ba);
;
 BA.debugLineNum = 43;BA.debugLine="Sub SaveSettings";
Debug.ShouldStop(1024);
 BA.debugLineNum = 44;BA.debugLine="If settings.IsInitialized Then";
Debug.ShouldStop(2048);
if (statemanager._settings.runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 45;BA.debugLine="File.WriteMap(File.DirInternal, settingsFileName";
Debug.ShouldStop(4096);
statemanager.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteMap",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename),(Object)(statemanager._settings));
 };
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _savestate(RemoteObject _ba,RemoteObject _activity,RemoteObject _activityname) throws Exception{
try {
		Debug.PushSubsStack("SaveState (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,58);
if (RapidSub.canDelegate("savestate")) return statemanager.remoteMe.runUserSub(false, "statemanager","savestate", _ba, _activity, _activityname);
RemoteObject _list1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
int _i = 0;
;
Debug.locals.put("Activity", _activity);
Debug.locals.put("ActivityName", _activityname);
 BA.debugLineNum = 58;BA.debugLine="Sub SaveState(Activity As Activity, ActivityName A";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 59;BA.debugLine="If states.IsInitialized = False Then states.Initi";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",statemanager._states.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
statemanager._states.runVoidMethod ("Initialize");};
 BA.debugLineNum = 60;BA.debugLine="Dim list1 As List";
Debug.ShouldStop(134217728);
_list1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("list1", _list1);
 BA.debugLineNum = 61;BA.debugLine="list1.Initialize";
Debug.ShouldStop(268435456);
_list1.runVoidMethod ("Initialize");
 BA.debugLineNum = 62;BA.debugLine="list1.Add(DateTime.Now)";
Debug.ShouldStop(536870912);
_list1.runVoidMethod ("Add",(Object)((statemanager.mostCurrent.__c.getField(false,"DateTime").runMethod(true,"getNow"))));
 BA.debugLineNum = 63;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
Debug.ShouldStop(1073741824);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_activity.runMethod(true,"getNumberOfViews"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 64;BA.debugLine="innerSaveState(Activity.GetView(i), list1)";
Debug.ShouldStop(-2147483648);
_innersavestate(_ba,_activity.runMethod(false,"GetView",(Object)(BA.numberCast(int.class, _i))),_list1);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 66;BA.debugLine="states.Put(ActivityName.ToLowerCase, list1)";
Debug.ShouldStop(2);
statemanager._states.runVoidMethod ("Put",(Object)((_activityname.runMethod(true,"toLowerCase"))),(Object)((_list1.getObject())));
 BA.debugLineNum = 67;BA.debugLine="writeStateToFile";
Debug.ShouldStop(4);
_writestatetofile(_ba);
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setsetting(RemoteObject _ba,RemoteObject _key,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("SetSetting (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,31);
if (RapidSub.canDelegate("setsetting")) return statemanager.remoteMe.runUserSub(false, "statemanager","setsetting", _ba, _key, _value);
;
Debug.locals.put("Key", _key);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 31;BA.debugLine="Sub SetSetting(Key As String, Value As String)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 32;BA.debugLine="If settings.IsInitialized = False Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",statemanager._settings.runMethod(true,"IsInitialized"),statemanager.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 34;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
Debug.ShouldStop(2);
if (statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"Exists",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename)).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 35;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
Debug.ShouldStop(4);
statemanager._settings = statemanager.mostCurrent.__c.getField(false,"File").runMethod(false,"ReadMap",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._settingsfilename));
 }else {
 BA.debugLineNum = 37;BA.debugLine="settings.Initialize";
Debug.ShouldStop(16);
statemanager._settings.runVoidMethod ("Initialize");
 };
 };
 BA.debugLineNum = 40;BA.debugLine="settings.Put(Key.ToLowerCase, Value)";
Debug.ShouldStop(128);
statemanager._settings.runVoidMethod ("Put",(Object)((_key.runMethod(true,"toLowerCase"))),(Object)((_value)));
 BA.debugLineNum = 41;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _writestatetofile(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("writeStateToFile (statemanager) ","statemanager",2,_ba,statemanager.mostCurrent,69);
if (RapidSub.canDelegate("writestatetofile")) return statemanager.remoteMe.runUserSub(false, "statemanager","writestatetofile", _ba);
RemoteObject _raf = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.RandomAccessFile");
;
 BA.debugLineNum = 69;BA.debugLine="Sub writeStateToFile";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="Dim raf As RandomAccessFile";
Debug.ShouldStop(32);
_raf = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.RandomAccessFile");Debug.locals.put("raf", _raf);
 BA.debugLineNum = 71;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
Debug.ShouldStop(64);
_raf.runVoidMethod ("Initialize",(Object)(statemanager.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal")),(Object)(statemanager._statesfilename),(Object)(statemanager.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 72;BA.debugLine="raf.WriteObject(states, True, raf.CurrentPosition";
Debug.ShouldStop(128);
_raf.runVoidMethod ("WriteObject",(Object)((statemanager._states.getObject())),(Object)(statemanager.mostCurrent.__c.getField(true,"True")),(Object)(_raf.getField(true,"CurrentPosition")));
 BA.debugLineNum = 73;BA.debugLine="raf.Close";
Debug.ShouldStop(256);
_raf.runVoidMethod ("Close");
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}