package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ap_set_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ap_set) ","ap_set",4,ap_set.mostCurrent.activityBA,ap_set.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) return ap_set.remoteMe.runUserSub(false, "ap_set","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 23;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"ap_set\")";
Debug.ShouldStop(8388608);
ap_set.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ap_set")),ap_set.mostCurrent.activityBA);
 BA.debugLineNum = 25;BA.debugLine="clear_field";
Debug.ShouldStop(16777216);
_clear_field();
 BA.debugLineNum = 26;BA.debugLine="Activity.Title =\"AP setup - \" & StateManager.Get";
Debug.ShouldStop(33554432);
ap_set.mostCurrent._activity.runMethod(false,"setTitle",(RemoteObject.concat(RemoteObject.createImmutable("AP setup - "),ap_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",ap_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 27;BA.debugLine="get_apset";
Debug.ShouldStop(67108864);
_get_apset();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e18) {
			BA.rdebugUtils.runVoidMethod("setLastException",ap_set.processBA, e18.toString()); BA.debugLineNum = 29;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(268435456);
_proces_error(ap_set.mostCurrent.__c.runMethod(false,"LastException",ap_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 31;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (ap_set) ","ap_set",4,ap_set.mostCurrent.activityBA,ap_set.mostCurrent,37);
if (RapidSub.canDelegate("activity_pause")) return ap_set.remoteMe.runUserSub(false, "ap_set","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 37;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16);
 BA.debugLineNum = 39;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (ap_set) ","ap_set",4,ap_set.mostCurrent.activityBA,ap_set.mostCurrent,33);
if (RapidSub.canDelegate("activity_resume")) return ap_set.remoteMe.runUserSub(false, "ap_set","activity_resume");
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clear_field() throws Exception{
try {
		Debug.PushSubsStack("clear_field (ap_set) ","ap_set",4,ap_set.mostCurrent.activityBA,ap_set.mostCurrent,57);
if (RapidSub.canDelegate("clear_field")) return ap_set.remoteMe.runUserSub(false, "ap_set","clear_field");
 BA.debugLineNum = 57;BA.debugLine="Sub clear_field()";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="Try";
Debug.ShouldStop(33554432);
try { BA.debugLineNum = 59;BA.debugLine="ap_ssid_txt.Text=\"no connect\"";
Debug.ShouldStop(67108864);
ap_set.mostCurrent._ap_ssid_txt.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("no connect")));
 BA.debugLineNum = 60;BA.debugLine="ap_pass_txt.Text=\"no connect\"";
Debug.ShouldStop(134217728);
ap_set.mostCurrent._ap_pass_txt.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("no connect")));
 BA.debugLineNum = 61;BA.debugLine="hide_ssid_chk.Checked =False";
Debug.ShouldStop(268435456);
ap_set.mostCurrent._hide_ssid_chk.runMethodAndSync(true,"setChecked",ap_set.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 62;BA.debugLine="ap_mode_chk.Checked=False";
Debug.ShouldStop(536870912);
ap_set.mostCurrent._ap_mode_chk.runMethodAndSync(true,"setChecked",ap_set.mostCurrent.__c.getField(true,"False"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e46) {
			BA.rdebugUtils.runVoidMethod("setLastException",ap_set.processBA, e46.toString()); BA.debugLineNum = 64;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(-2147483648);
_proces_error(ap_set.mostCurrent.__c.runMethod(false,"LastException",ap_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("finish_him (ap_set) ","ap_set",4,ap_set.mostCurrent.activityBA,ap_set.mostCurrent,90);
if (RapidSub.canDelegate("finish_him")) return ap_set.remoteMe.runUserSub(false, "ap_set","finish_him");
 BA.debugLineNum = 90;BA.debugLine="Sub finish_him()";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="Activity.Finish";
Debug.ShouldStop(67108864);
ap_set.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 92;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_apset() throws Exception{
try {
		Debug.PushSubsStack("get_apset (ap_set) ","ap_set",4,ap_set.mostCurrent.activityBA,ap_set.mostCurrent,68);
if (RapidSub.canDelegate("get_apset")) return ap_set.remoteMe.runUserSub(false, "ap_set","get_apset");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 68;BA.debugLine="Sub get_apset()";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 70;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(32);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 71;BA.debugLine="Data.Initialize";
Debug.ShouldStop(64);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 72;BA.debugLine="Data.Put (\"getapset\",1)";
Debug.ShouldStop(128);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("getapset"))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 73;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(256);
ap_set.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",ap_set.mostCurrent.activityBA,(Object)((ap_set.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e56) {
			BA.rdebugUtils.runVoidMethod("setLastException",ap_set.processBA, e56.toString()); BA.debugLineNum = 75;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(1024);
_proces_error(ap_set.mostCurrent.__c.runMethod(false,"LastException",ap_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private ap_pass_txt As EditText";
ap_set.mostCurrent._ap_pass_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Private ap_ssid_txt As EditText";
ap_set.mostCurrent._ap_ssid_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private hide_ssid_chk As CheckBox";
ap_set.mostCurrent._hide_ssid_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private Label1 As Label";
ap_set.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private Label2 As Label";
ap_set.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private save_ap_set_btn As Button";
ap_set.mostCurrent._save_ap_set_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private ap_mode_chk As CheckBox";
ap_set.mostCurrent._ap_mode_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _proces_error(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("proces_error (ap_set) ","ap_set",4,ap_set.mostCurrent.activityBA,ap_set.mostCurrent,94);
if (RapidSub.canDelegate("proces_error")) return ap_set.remoteMe.runUserSub(false, "ap_set","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 94;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="Msgbox(msg,\"error\")";
Debug.ShouldStop(1073741824);
ap_set.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(_msg),(Object)(RemoteObject.createImmutable("error")),ap_set.mostCurrent.activityBA);
 BA.debugLineNum = 96;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _save_ap_set_btn_click() throws Exception{
try {
		Debug.PushSubsStack("save_ap_set_btn_Click (ap_set) ","ap_set",4,ap_set.mostCurrent.activityBA,ap_set.mostCurrent,42);
if (RapidSub.canDelegate("save_ap_set_btn_click")) return ap_set.remoteMe.runUserSub(false, "ap_set","save_ap_set_btn_click");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 42;BA.debugLine="Sub save_ap_set_btn_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 44;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(2048);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 45;BA.debugLine="Data.Initialize";
Debug.ShouldStop(4096);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 46;BA.debugLine="Data.Put (\"ssid_ap\",ap_ssid_txt.Text)";
Debug.ShouldStop(8192);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("ssid_ap"))),(Object)((ap_set.mostCurrent._ap_ssid_txt.runMethod(true,"getText"))));
 BA.debugLineNum = 47;BA.debugLine="Data.Put (\"pass_ap\",ap_pass_txt.Text)";
Debug.ShouldStop(16384);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("pass_ap"))),(Object)((ap_set.mostCurrent._ap_pass_txt.runMethod(true,"getText"))));
 BA.debugLineNum = 48;BA.debugLine="Data.Put (\"hide_ssid\",hide_ssid_chk.Checked)";
Debug.ShouldStop(32768);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("hide_ssid"))),(Object)((ap_set.mostCurrent._hide_ssid_chk.runMethod(true,"getChecked"))));
 BA.debugLineNum = 49;BA.debugLine="Data.Put (\"mode_ap\",ap_mode_chk.Checked)";
Debug.ShouldStop(65536);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("mode_ap"))),(Object)((ap_set.mostCurrent._ap_mode_chk.runMethod(true,"getChecked"))));
 BA.debugLineNum = 50;BA.debugLine="Data.Put (\"save_info\",1)";
Debug.ShouldStop(131072);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("save_info"))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 51;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(262144);
ap_set.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",ap_set.mostCurrent.activityBA,(Object)((ap_set.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e36) {
			BA.rdebugUtils.runVoidMethod("setLastException",ap_set.processBA, e36.toString()); BA.debugLineNum = 53;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(1048576);
_proces_error(ap_set.mostCurrent.__c.runMethod(false,"LastException",ap_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_ap_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_ap_set (ap_set) ","ap_set",4,ap_set.mostCurrent.activityBA,ap_set.mostCurrent,80);
if (RapidSub.canDelegate("set_ap_set")) return ap_set.remoteMe.runUserSub(false, "ap_set","set_ap_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 80;BA.debugLine="Sub set_ap_set (mapar As Map)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 81;BA.debugLine="Try";
Debug.ShouldStop(65536);
try { BA.debugLineNum = 82;BA.debugLine="If mapar.ContainsKey(\"ssid_ap\")=True Then  ap_ssi";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("ssid_ap")))),ap_set.mostCurrent.__c.getField(true,"True"))) { 
ap_set.mostCurrent._ap_ssid_txt.runMethodAndSync(true,"setText",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("ssid_ap")))));};
 BA.debugLineNum = 83;BA.debugLine="If mapar.ContainsKey(\"pass_ap\")=True Then  ap_pas";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("pass_ap")))),ap_set.mostCurrent.__c.getField(true,"True"))) { 
ap_set.mostCurrent._ap_pass_txt.runMethodAndSync(true,"setText",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("pass_ap")))));};
 BA.debugLineNum = 84;BA.debugLine="If mapar.ContainsKey(\"hide_ssid\")=True Then  hide";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("hide_ssid")))),ap_set.mostCurrent.__c.getField(true,"True"))) { 
ap_set.mostCurrent._hide_ssid_chk.runMethodAndSync(true,"setChecked",ap_set.mostCurrent._cm.runMethod(true,"_obj2bool",ap_set.mostCurrent.activityBA,(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("hide_ssid")))))));};
 BA.debugLineNum = 85;BA.debugLine="If mapar.ContainsKey(\"mode_ap\")=True Then  ap_mod";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("mode_ap")))),ap_set.mostCurrent.__c.getField(true,"True"))) { 
ap_set.mostCurrent._ap_mode_chk.runMethodAndSync(true,"setChecked",ap_set.mostCurrent._cm.runMethod(true,"_obj2bool",ap_set.mostCurrent.activityBA,(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("mode_ap")))))));};
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e66) {
			BA.rdebugUtils.runVoidMethod("setLastException",ap_set.processBA, e66.toString()); BA.debugLineNum = 87;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(4194304);
_proces_error(ap_set.mostCurrent.__c.runMethod(false,"LastException",ap_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
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
}