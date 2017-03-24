package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class key_set_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) return key_set.remoteMe.runUserSub(false, "key_set","activity_create", _firsttime);
int _i = 0;
RemoteObject _tchk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
RemoteObject _tlab = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
RemoteObject _ttxt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"key_set_lay\")";
Debug.ShouldStop(268435456);
key_set.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("key_set_lay")),key_set.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="lfont_size.Initialize(\"lfont_size\")";
Debug.ShouldStop(536870912);
key_set.mostCurrent._lfont_size.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lfont_size")));
 BA.debugLineNum = 31;BA.debugLine="scview.Panel.AddView(lfont_size, 5dip, 10dip, 60d";
Debug.ShouldStop(1073741824);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((key_set.mostCurrent._lfont_size.getObject())),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 5)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 60)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 32;BA.debugLine="lfont_size.Text =\"Font:\"";
Debug.ShouldStop(-2147483648);
key_set.mostCurrent._lfont_size.runMethod(true,"setText",RemoteObject.createImmutable(("Font:")));
 BA.debugLineNum = 33;BA.debugLine="lfont_size.TextSize =\"14\"";
Debug.ShouldStop(1);
key_set.mostCurrent._lfont_size.runMethod(true,"setTextSize",BA.numberCast(float.class, "14"));
 BA.debugLineNum = 34;BA.debugLine="font_size.Initialize(\"font_size\")";
Debug.ShouldStop(2);
key_set.mostCurrent._font_size.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("font_size")));
 BA.debugLineNum = 35;BA.debugLine="font_size.InputType = font_size.INPUT_TYPE_NUMBER";
Debug.ShouldStop(4);
key_set.mostCurrent._font_size.runMethod(true,"setInputType",key_set.mostCurrent._font_size.getField(true,"INPUT_TYPE_NUMBERS"));
 BA.debugLineNum = 36;BA.debugLine="scview.Panel.AddView(font_size, 40dip ,0dip, 50di";
Debug.ShouldStop(8);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((key_set.mostCurrent._font_size.getObject())),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 37;BA.debugLine="font_size.SingleLine=True";
Debug.ShouldStop(16);
key_set.mostCurrent._font_size.runVoidMethod ("setSingleLine",key_set.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 38;BA.debugLine="font_size.Text =\"14\"";
Debug.ShouldStop(32);
key_set.mostCurrent._font_size.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("14")));
 BA.debugLineNum = 39;BA.debugLine="lh_size.Initialize(\"lh_size\")";
Debug.ShouldStop(64);
key_set.mostCurrent._lh_size.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lh_size")));
 BA.debugLineNum = 40;BA.debugLine="scview.Panel.AddView(lh_size, 120dip, 10dip, 40di";
Debug.ShouldStop(128);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((key_set.mostCurrent._lh_size.getObject())),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 120)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 41;BA.debugLine="lh_size.Text =\"Horiz:\"";
Debug.ShouldStop(256);
key_set.mostCurrent._lh_size.runMethod(true,"setText",RemoteObject.createImmutable(("Horiz:")));
 BA.debugLineNum = 42;BA.debugLine="h_size.Initialize(\"h_size\")";
Debug.ShouldStop(512);
key_set.mostCurrent._h_size.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("h_size")));
 BA.debugLineNum = 43;BA.debugLine="h_size.InputType = h_size.INPUT_TYPE_NUMBERS";
Debug.ShouldStop(1024);
key_set.mostCurrent._h_size.runMethod(true,"setInputType",key_set.mostCurrent._h_size.getField(true,"INPUT_TYPE_NUMBERS"));
 BA.debugLineNum = 44;BA.debugLine="scview.Panel.AddView(h_size, 160dip ,0dip, 40dip,";
Debug.ShouldStop(2048);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((key_set.mostCurrent._h_size.getObject())),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 160)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 45;BA.debugLine="h_size.SingleLine=True";
Debug.ShouldStop(4096);
key_set.mostCurrent._h_size.runVoidMethod ("setSingleLine",key_set.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 46;BA.debugLine="lv_size.Initialize(\"lv_size\")";
Debug.ShouldStop(8192);
key_set.mostCurrent._lv_size.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("lv_size")));
 BA.debugLineNum = 47;BA.debugLine="scview.Panel.AddView(lv_size, 210dip, 10dip, 40di";
Debug.ShouldStop(16384);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((key_set.mostCurrent._lv_size.getObject())),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 210)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 48;BA.debugLine="lv_size.Text =\"Vert:\"";
Debug.ShouldStop(32768);
key_set.mostCurrent._lv_size.runMethod(true,"setText",RemoteObject.createImmutable(("Vert:")));
 BA.debugLineNum = 49;BA.debugLine="v_size.Initialize(\"h_size\")";
Debug.ShouldStop(65536);
key_set.mostCurrent._v_size.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("h_size")));
 BA.debugLineNum = 50;BA.debugLine="v_size.InputType = v_size.INPUT_TYPE_NUMBERS";
Debug.ShouldStop(131072);
key_set.mostCurrent._v_size.runMethod(true,"setInputType",key_set.mostCurrent._v_size.getField(true,"INPUT_TYPE_NUMBERS"));
 BA.debugLineNum = 51;BA.debugLine="scview.Panel.AddView(v_size, 240dip ,0dip, 40dip,";
Debug.ShouldStop(262144);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((key_set.mostCurrent._v_size.getObject())),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 240)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 52;BA.debugLine="v_size.SingleLine=True";
Debug.ShouldStop(524288);
key_set.mostCurrent._v_size.runVoidMethod ("setSingleLine",key_set.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 54;BA.debugLine="For i = 1 To 30";
Debug.ShouldStop(2097152);
{
final int step26 = 1;
final int limit26 = 30;
for (_i = 1 ; (step26 > 0 && _i <= limit26) || (step26 < 0 && _i >= limit26); _i = ((int)(0 + _i + step26)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 55;BA.debugLine="Dim tchk As CheckBox";
Debug.ShouldStop(4194304);
_tchk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");Debug.locals.put("tchk", _tchk);
 BA.debugLineNum = 56;BA.debugLine="Dim tlab As Label";
Debug.ShouldStop(8388608);
_tlab = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");Debug.locals.put("tlab", _tlab);
 BA.debugLineNum = 57;BA.debugLine="Dim ttxt As EditText";
Debug.ShouldStop(16777216);
_ttxt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");Debug.locals.put("ttxt", _ttxt);
 BA.debugLineNum = 58;BA.debugLine="tchk.Initialize(\"CheckBox\")";
Debug.ShouldStop(33554432);
_tchk.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("CheckBox")));
 BA.debugLineNum = 59;BA.debugLine="tlab.Initialize(\"label\")";
Debug.ShouldStop(67108864);
_tlab.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("label")));
 BA.debugLineNum = 60;BA.debugLine="ttxt.Initialize(\"edittext\")";
Debug.ShouldStop(134217728);
_ttxt.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("edittext")));
 BA.debugLineNum = 61;BA.debugLine="scview.Panel.AddView(tlab, 0, i*40dip+10di";
Debug.ShouldStop(268435456);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_tlab.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40))),key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))}, "*+",1, 1)),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 62;BA.debugLine="scview.Panel.AddView(tchk, 15dip, i*40dip, 30d";
Debug.ShouldStop(536870912);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_tchk.getObject())),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 15)))),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "*",0, 1)),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 63;BA.debugLine="scview.Panel.AddView(ttxt, 45dip, i*40dip, Activ";
Debug.ShouldStop(1073741824);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((_ttxt.getObject())),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 45)))),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))}, "*",0, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {key_set.mostCurrent._activity.runMethod(true,"getWidth"),key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 64;BA.debugLine="tlab.Tag=i:tchk.Tag=i:ttxt.Tag=i:";
Debug.ShouldStop(-2147483648);
_tlab.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 64;BA.debugLine="tlab.Tag=i:tchk.Tag=i:ttxt.Tag=i:";
Debug.ShouldStop(-2147483648);
_tchk.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 64;BA.debugLine="tlab.Tag=i:tchk.Tag=i:ttxt.Tag=i:";
Debug.ShouldStop(-2147483648);
_ttxt.runMethod(false,"setTag",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 65;BA.debugLine="tlab.Text=i";
Debug.ShouldStop(1);
_tlab.runMethod(true,"setText",RemoteObject.createImmutable((_i)));
 BA.debugLineNum = 66;BA.debugLine="ttxt.SingleLine=True";
Debug.ShouldStop(2);
_ttxt.runVoidMethod ("setSingleLine",key_set.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 67;BA.debugLine="lab(i)=tlab";
Debug.ShouldStop(4);
key_set.mostCurrent._lab.setArrayElement (_tlab,BA.numberCast(int.class, _i));
 BA.debugLineNum = 68;BA.debugLine="chk(i)=tchk";
Debug.ShouldStop(8);
key_set.mostCurrent._chk.setArrayElement (_tchk,BA.numberCast(int.class, _i));
 BA.debugLineNum = 69;BA.debugLine="txt(i)=ttxt";
Debug.ShouldStop(16);
key_set.mostCurrent._txt.setArrayElement (_ttxt,BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 71;BA.debugLine="save_ks_but.Initialize(\"save_ks_but\")";
Debug.ShouldStop(64);
key_set.mostCurrent._save_ks_but.runVoidMethod ("Initialize",key_set.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("save_ks_but")));
 BA.debugLineNum = 72;BA.debugLine="save_ks_but.Text =\"Save\"";
Debug.ShouldStop(128);
key_set.mostCurrent._save_ks_but.runMethod(true,"setText",RemoteObject.createImmutable(("Save")));
 BA.debugLineNum = 73;BA.debugLine="scview.Panel.AddView(save_ks_but, 10dip ,1260dip,";
Debug.ShouldStop(256);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runVoidMethod ("AddView",(Object)((key_set.mostCurrent._save_ks_but.getObject())),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 10)))),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1260)))),(Object)(RemoteObject.solve(new RemoteObject[] {key_set.mostCurrent._activity.runMethod(true,"getWidth"),key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 40)))));
 BA.debugLineNum = 74;BA.debugLine="scview.Panel.Height =1340dip";
Debug.ShouldStop(512);
key_set.mostCurrent._scview.runMethod(false,"getPanel").runMethod(true,"setHeight",key_set.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1340))));
 BA.debugLineNum = 75;BA.debugLine="Activity.Title =\"Keys setup - \" & StateManager.Ge";
Debug.ShouldStop(1024);
key_set.mostCurrent._activity.runMethod(false,"setTitle",(RemoteObject.concat(RemoteObject.createImmutable("Keys setup - "),key_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",key_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 76;BA.debugLine="get_key_data";
Debug.ShouldStop(2048);
_get_key_data();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e70) {
			BA.rdebugUtils.runVoidMethod("setLastException",key_set.processBA, e70.toString()); BA.debugLineNum = 78;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(8192);
_proces_error(key_set.mostCurrent.__c.runMethod(false,"LastException",key_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 80;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,87);
if (RapidSub.canDelegate("activity_pause")) return key_set.remoteMe.runUserSub(false, "key_set","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 87;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,82);
if (RapidSub.canDelegate("activity_resume")) return key_set.remoteMe.runUserSub(false, "key_set","activity_resume");
 BA.debugLineNum = 82;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(131072);
 BA.debugLineNum = 84;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _finish_him() throws Exception{
try {
		Debug.PushSubsStack("finish_him (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,180);
if (RapidSub.canDelegate("finish_him")) return key_set.remoteMe.runUserSub(false, "key_set","finish_him");
 BA.debugLineNum = 180;BA.debugLine="Sub finish_him()";
Debug.ShouldStop(524288);
 BA.debugLineNum = 181;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 182;BA.debugLine="CallSubDelayed(Main,\"load_keys\")";
Debug.ShouldStop(2097152);
key_set.mostCurrent.__c.runVoidMethod ("CallSubDelayed",key_set.mostCurrent.activityBA,(Object)((key_set.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("load_keys")));
 BA.debugLineNum = 183;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4194304);
key_set.mostCurrent._activity.runVoidMethod ("Finish");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e160) {
			BA.rdebugUtils.runVoidMethod("setLastException",key_set.processBA, e160.toString()); BA.debugLineNum = 185;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(16777216);
_proces_error(key_set.mostCurrent.__c.runMethod(false,"LastException",key_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 187;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_key_data() throws Exception{
try {
		Debug.PushSubsStack("get_key_data (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,91);
if (RapidSub.canDelegate("get_key_data")) return key_set.remoteMe.runUserSub(false, "key_set","get_key_data");
int _a = 0;
 BA.debugLineNum = 91;BA.debugLine="Sub get_key_data() 'заповнення полів налаштування";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 94;BA.debugLine="v_size.Text=StateManager.GetSetting2(\"v_size\",\"\")";
Debug.ShouldStop(536870912);
key_set.mostCurrent._v_size.runMethodAndSync(true,"setText",(key_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",key_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("v_size")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 95;BA.debugLine="h_size.Text=StateManager.GetSetting2(\"h_size\",\"\")";
Debug.ShouldStop(1073741824);
key_set.mostCurrent._h_size.runMethodAndSync(true,"setText",(key_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",key_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("h_size")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 96;BA.debugLine="font_size.Text=StateManager.GetSetting2(\"font_siz";
Debug.ShouldStop(-2147483648);
key_set.mostCurrent._font_size.runMethodAndSync(true,"setText",(key_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",key_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("font_size")),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 97;BA.debugLine="For a=1 To 30";
Debug.ShouldStop(1);
{
final int step5 = 1;
final int limit5 = 30;
for (_a = 1 ; (step5 > 0 && _a <= limit5) || (step5 < 0 && _a >= limit5); _a = ((int)(0 + _a + step5)) ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 98;BA.debugLine="chk(a).Checked=CM.obj2Bool(StateManager.GetSetti";
Debug.ShouldStop(2);
key_set.mostCurrent._chk.getArrayElement(false,BA.numberCast(int.class, _a)).runMethodAndSync(true,"setChecked",key_set.mostCurrent._cm.runMethod(true,"_obj2bool",key_set.mostCurrent.activityBA,(Object)((key_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",key_set.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keylock"),RemoteObject.createImmutable(_a))),(Object)(BA.NumberToString(0)))))));
 BA.debugLineNum = 99;BA.debugLine="txt(a).Text =StateManager.GetSetting2(\"keytext\"";
Debug.ShouldStop(4);
key_set.mostCurrent._txt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethodAndSync(true,"setText",(key_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",key_set.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytext"),RemoteObject.createImmutable(_a))),(Object)(RemoteObject.createImmutable("")))));
 }
}Debug.locals.put("a", _a);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e87) {
			BA.rdebugUtils.runVoidMethod("setLastException",key_set.processBA, e87.toString()); BA.debugLineNum = 102;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(32);
_proces_error(key_set.mostCurrent.__c.runMethod(false,"LastException",key_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 104;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 11;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 12;BA.debugLine="Public  setbut_tmr As Timer";
key_set.mostCurrent._setbut_tmr = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 13;BA.debugLine="Private scview As ScrollView";
key_set.mostCurrent._scview = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Dim chk(33) As CheckBox";
key_set.mostCurrent._chk = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper", new int[] {33}, new Object[]{});
 //BA.debugLineNum = 15;BA.debugLine="Dim lab(33) As Label";
key_set.mostCurrent._lab = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.LabelWrapper", new int[] {33}, new Object[]{});
 //BA.debugLineNum = 16;BA.debugLine="Dim txt(33) As EditText";
key_set.mostCurrent._txt = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.EditTextWrapper", new int[] {33}, new Object[]{});
 //BA.debugLineNum = 17;BA.debugLine="Dim font_size As EditText";
key_set.mostCurrent._font_size = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim lfont_size As Label";
key_set.mostCurrent._lfont_size = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Dim v_size As EditText";
key_set.mostCurrent._v_size = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Dim lv_size As Label";
key_set.mostCurrent._lv_size = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim h_size As EditText";
key_set.mostCurrent._h_size = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim lh_size As Label";
key_set.mostCurrent._lh_size = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim save_ks_but As Button";
key_set.mostCurrent._save_ks_but = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim key_n As Int =0";
key_set._key_n = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _proces_error(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("proces_error (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,189);
if (RapidSub.canDelegate("proces_error")) return key_set.remoteMe.runUserSub(false, "key_set","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 189;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 190;BA.debugLine="Msgbox(msg,\"error\")";
Debug.ShouldStop(536870912);
key_set.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(_msg),(Object)(RemoteObject.createImmutable("error")),key_set.mostCurrent.activityBA);
 BA.debugLineNum = 191;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Public key_set_load As Boolean";
key_set._key_set_load = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 9;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _save_ks_but_click() throws Exception{
try {
		Debug.PushSubsStack("save_ks_but_Click (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,106);
if (RapidSub.canDelegate("save_ks_but_click")) return key_set.remoteMe.runUserSub(false, "key_set","save_ks_but_click");
 BA.debugLineNum = 106;BA.debugLine="Sub save_ks_but_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 107;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 108;BA.debugLine="ToastMessageShow(\"Saving....\",True)";
Debug.ShouldStop(2048);
key_set.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Saving....")),(Object)(key_set.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 109;BA.debugLine="key_n=0";
Debug.ShouldStop(4096);
key_set._key_n = BA.numberCast(int.class, 0);
 BA.debugLineNum = 110;BA.debugLine="setbut_tmr.Initialize(\"setbut_tmr\", 100)";
Debug.ShouldStop(8192);
key_set.mostCurrent._setbut_tmr.runVoidMethod ("Initialize",key_set.processBA,(Object)(BA.ObjectToString("setbut_tmr")),(Object)(BA.numberCast(long.class, 100)));
 BA.debugLineNum = 111;BA.debugLine="setbut_tmr.Enabled =True";
Debug.ShouldStop(16384);
key_set.mostCurrent._setbut_tmr.runMethod(true,"setEnabled",key_set.mostCurrent.__c.getField(true,"True"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e97) {
			BA.rdebugUtils.runVoidMethod("setLastException",key_set.processBA, e97.toString()); BA.debugLineNum = 113;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(65536);
_proces_error(key_set.mostCurrent.__c.runMethod(false,"LastException",key_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 115;BA.debugLine="End Sub";
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
public static RemoteObject  _set_key(RemoteObject _ind) throws Exception{
try {
		Debug.PushSubsStack("set_key (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,131);
if (RapidSub.canDelegate("set_key")) return key_set.remoteMe.runUserSub(false, "key_set","set_key", _ind);
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("ind", _ind);
 BA.debugLineNum = 131;BA.debugLine="Sub set_key(ind As Int)";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 133;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(16);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 134;BA.debugLine="Data.Initialize";
Debug.ShouldStop(32);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 135;BA.debugLine="Data.Put (\"setkey\",ind)";
Debug.ShouldStop(64);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("setkey"))),(Object)((_ind)));
 BA.debugLineNum = 136;BA.debugLine="Data.Put (\"name\",txt(ind).Text)";
Debug.ShouldStop(128);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("name"))),(Object)((key_set.mostCurrent._txt.getArrayElement(false,_ind).runMethod(true,"getText"))));
 BA.debugLineNum = 137;BA.debugLine="Data.Put (\"lock\",chk(ind).Checked)";
Debug.ShouldStop(256);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("lock"))),(Object)((key_set.mostCurrent._chk.getArrayElement(false,_ind).runMethod(true,"getChecked"))));
 BA.debugLineNum = 138;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(512);
key_set.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",key_set.mostCurrent.activityBA,(Object)((key_set.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e122) {
			BA.rdebugUtils.runVoidMethod("setLastException",key_set.processBA, e122.toString()); BA.debugLineNum = 140;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(2048);
_proces_error(key_set.mostCurrent.__c.runMethod(false,"LastException",key_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_key_info() throws Exception{
try {
		Debug.PushSubsStack("set_key_info (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,143);
if (RapidSub.canDelegate("set_key_info")) return key_set.remoteMe.runUserSub(false, "key_set","set_key_info");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 143;BA.debugLine="Sub set_key_info()";
Debug.ShouldStop(16384);
 BA.debugLineNum = 144;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 145;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(65536);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 146;BA.debugLine="Data.Initialize";
Debug.ShouldStop(131072);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 147;BA.debugLine="Data.Put (\"font_size\",font_size.Text)";
Debug.ShouldStop(262144);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("font_size"))),(Object)((key_set.mostCurrent._font_size.runMethod(true,"getText"))));
 BA.debugLineNum = 148;BA.debugLine="Data.Put (\"h_size\",h_size.Text)";
Debug.ShouldStop(524288);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("h_size"))),(Object)((key_set.mostCurrent._h_size.runMethod(true,"getText"))));
 BA.debugLineNum = 149;BA.debugLine="Data.Put (\"v_size\",v_size.Text)";
Debug.ShouldStop(1048576);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("v_size"))),(Object)((key_set.mostCurrent._v_size.runMethod(true,"getText"))));
 BA.debugLineNum = 150;BA.debugLine="Data.Put (\"save_info\",3)";
Debug.ShouldStop(2097152);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("save_info"))),(Object)(RemoteObject.createImmutable((3))));
 BA.debugLineNum = 151;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(4194304);
key_set.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",key_set.mostCurrent.activityBA,(Object)((key_set.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e135) {
			BA.rdebugUtils.runVoidMethod("setLastException",key_set.processBA, e135.toString()); BA.debugLineNum = 153;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(16777216);
_proces_error(key_set.mostCurrent.__c.runMethod(false,"LastException",key_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_key_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_key_set (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,160);
if (RapidSub.canDelegate("set_key_set")) return key_set.remoteMe.runUserSub(false, "key_set","set_key_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 160;BA.debugLine="Sub set_key_set (mapar As Map)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 161;BA.debugLine="Try";
Debug.ShouldStop(1);
try { BA.debugLineNum = 162;BA.debugLine="txt(mapar.Get (\"key_id\")).Text = mapar.Get (\"nam";
Debug.ShouldStop(2);
key_set.mostCurrent._txt.getArrayElement(false,BA.numberCast(int.class, _mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))).runMethodAndSync(true,"setText",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))));
 BA.debugLineNum = 163;BA.debugLine="chk(mapar.Get (\"key_id\")).Checked = CM.obj2Bool(";
Debug.ShouldStop(4);
key_set.mostCurrent._chk.getArrayElement(false,BA.numberCast(int.class, _mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))).runMethodAndSync(true,"setChecked",key_set.mostCurrent._cm.runMethod(true,"_obj2bool",key_set.mostCurrent.activityBA,(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("lock")))))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e143) {
			BA.rdebugUtils.runVoidMethod("setLastException",key_set.processBA, e143.toString()); BA.debugLineNum = 165;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(16);
_proces_error(key_set.mostCurrent.__c.runMethod(false,"LastException",key_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 167;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_keyinfo_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_keyinfo_set (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,169);
if (RapidSub.canDelegate("set_keyinfo_set")) return key_set.remoteMe.runUserSub(false, "key_set","set_keyinfo_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 169;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
Debug.ShouldStop(256);
 BA.debugLineNum = 170;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 171;BA.debugLine="If mapar.ContainsKey(\"font_size\")=True Then  font";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("font_size")))),key_set.mostCurrent.__c.getField(true,"True"))) { 
key_set.mostCurrent._font_size.runMethodAndSync(true,"setText",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("font_size")))));};
 BA.debugLineNum = 172;BA.debugLine="If mapar.ContainsKey(\"h_size\")=True Then  h_size.";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("h_size")))),key_set.mostCurrent.__c.getField(true,"True"))) { 
key_set.mostCurrent._h_size.runMethodAndSync(true,"setText",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("h_size")))));};
 BA.debugLineNum = 173;BA.debugLine="If mapar.ContainsKey(\"v_size\")=True Then  v_size.";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("v_size")))),key_set.mostCurrent.__c.getField(true,"True"))) { 
key_set.mostCurrent._v_size.runMethodAndSync(true,"setText",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("v_size")))));};
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e152) {
			BA.rdebugUtils.runVoidMethod("setLastException",key_set.processBA, e152.toString()); BA.debugLineNum = 175;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(16384);
_proces_error(key_set.mostCurrent.__c.runMethod(false,"LastException",key_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 177;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _setbut_tmr_tick() throws Exception{
try {
		Debug.PushSubsStack("setbut_tmr_Tick (key_set) ","key_set",6,key_set.mostCurrent.activityBA,key_set.mostCurrent,117);
if (RapidSub.canDelegate("setbut_tmr_tick")) return key_set.remoteMe.runUserSub(false, "key_set","setbut_tmr_tick");
 BA.debugLineNum = 117;BA.debugLine="Sub setbut_tmr_Tick()";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 119;BA.debugLine="key_n=key_n+1";
Debug.ShouldStop(4194304);
key_set._key_n = RemoteObject.solve(new RemoteObject[] {key_set._key_n,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 120;BA.debugLine="If key_n>=32 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("g",key_set._key_n,BA.numberCast(double.class, 32))) { 
 BA.debugLineNum = 121;BA.debugLine="set_key_info";
Debug.ShouldStop(16777216);
_set_key_info();
 BA.debugLineNum = 122;BA.debugLine="setbut_tmr.Enabled =False";
Debug.ShouldStop(33554432);
key_set.mostCurrent._setbut_tmr.runMethod(true,"setEnabled",key_set.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 123;BA.debugLine="Return";
Debug.ShouldStop(67108864);
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 125;BA.debugLine="set_key(key_n)";
Debug.ShouldStop(268435456);
_set_key(key_set._key_n);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e110) {
			BA.rdebugUtils.runVoidMethod("setLastException",key_set.processBA, e110.toString()); BA.debugLineNum = 127;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(1073741824);
_proces_error(key_set.mostCurrent.__c.runMethod(false,"LastException",key_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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