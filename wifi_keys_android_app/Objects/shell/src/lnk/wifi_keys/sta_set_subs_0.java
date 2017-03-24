package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class sta_set_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (sta_set) ","sta_set",5,sta_set.mostCurrent.activityBA,sta_set.mostCurrent,19);
if (RapidSub.canDelegate("activity_create")) return sta_set.remoteMe.runUserSub(false, "sta_set","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 19;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 20;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 21;BA.debugLine="Activity.LoadLayout(\"sta_set\")";
Debug.ShouldStop(1048576);
sta_set.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("sta_set")),sta_set.mostCurrent.activityBA);
 BA.debugLineNum = 22;BA.debugLine="clear_field";
Debug.ShouldStop(2097152);
_clear_field();
 BA.debugLineNum = 23;BA.debugLine="Activity.Title =\"WFclient setup - \" & StateManage";
Debug.ShouldStop(4194304);
sta_set.mostCurrent._activity.runMethod(false,"setTitle",(RemoteObject.concat(RemoteObject.createImmutable("WFclient setup - "),sta_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",sta_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 24;BA.debugLine="get_staset";
Debug.ShouldStop(8388608);
_get_staset();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e17) {
			BA.rdebugUtils.runVoidMethod("setLastException",sta_set.processBA, e17.toString()); BA.debugLineNum = 26;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(33554432);
_proces_error(sta_set.mostCurrent.__c.runMethod(false,"LastException",sta_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 28;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (sta_set) ","sta_set",5,sta_set.mostCurrent.activityBA,sta_set.mostCurrent,34);
if (RapidSub.canDelegate("activity_pause")) return sta_set.remoteMe.runUserSub(false, "sta_set","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 34;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2);
 BA.debugLineNum = 36;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (sta_set) ","sta_set",5,sta_set.mostCurrent.activityBA,sta_set.mostCurrent,30);
if (RapidSub.canDelegate("activity_resume")) return sta_set.remoteMe.runUserSub(false, "sta_set","activity_resume");
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 32;BA.debugLine="End Sub";
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
public static RemoteObject  _clear_field() throws Exception{
try {
		Debug.PushSubsStack("clear_field (sta_set) ","sta_set",5,sta_set.mostCurrent.activityBA,sta_set.mostCurrent,53);
if (RapidSub.canDelegate("clear_field")) return sta_set.remoteMe.runUserSub(false, "sta_set","clear_field");
 BA.debugLineNum = 53;BA.debugLine="Sub clear_field()";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 55;BA.debugLine="sta_ssid_txt.Text=\"no connect\"";
Debug.ShouldStop(4194304);
sta_set.mostCurrent._sta_ssid_txt.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("no connect")));
 BA.debugLineNum = 56;BA.debugLine="sta_pass_txt.Text=\"no connect\"";
Debug.ShouldStop(8388608);
sta_set.mostCurrent._sta_pass_txt.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("no connect")));
 BA.debugLineNum = 57;BA.debugLine="sta_mode_chk.Checked=False";
Debug.ShouldStop(16777216);
sta_set.mostCurrent._sta_mode_chk.runMethodAndSync(true,"setChecked",sta_set.mostCurrent.__c.getField(true,"False"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e43) {
			BA.rdebugUtils.runVoidMethod("setLastException",sta_set.processBA, e43.toString()); BA.debugLineNum = 59;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(67108864);
_proces_error(sta_set.mostCurrent.__c.runMethod(false,"LastException",sta_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
		Debug.PushSubsStack("finish_him (sta_set) ","sta_set",5,sta_set.mostCurrent.activityBA,sta_set.mostCurrent,84);
if (RapidSub.canDelegate("finish_him")) return sta_set.remoteMe.runUserSub(false, "sta_set","finish_him");
 BA.debugLineNum = 84;BA.debugLine="Sub finish_him()";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
sta_set.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 86;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_staset() throws Exception{
try {
		Debug.PushSubsStack("get_staset (sta_set) ","sta_set",5,sta_set.mostCurrent.activityBA,sta_set.mostCurrent,63);
if (RapidSub.canDelegate("get_staset")) return sta_set.remoteMe.runUserSub(false, "sta_set","get_staset");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 63;BA.debugLine="Sub get_staset()";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 64;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
try { BA.debugLineNum = 65;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(1);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 66;BA.debugLine="Data.Initialize";
Debug.ShouldStop(2);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 67;BA.debugLine="Data.Put (\"getstaset\",1)";
Debug.ShouldStop(4);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("getstaset"))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 68;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(8);
sta_set.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",sta_set.mostCurrent.activityBA,(Object)((sta_set.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e53) {
			BA.rdebugUtils.runVoidMethod("setLastException",sta_set.processBA, e53.toString()); BA.debugLineNum = 70;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(32);
_proces_error(sta_set.mostCurrent.__c.runMethod(false,"LastException",sta_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 72;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 9;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 11;BA.debugLine="Private sta_pass_txt As EditText";
sta_set.mostCurrent._sta_pass_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 12;BA.debugLine="Private sta_ssid_txt As EditText";
sta_set.mostCurrent._sta_ssid_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 13;BA.debugLine="Private Label1 As Label";
sta_set.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 14;BA.debugLine="Private Label2 As Label";
sta_set.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 15;BA.debugLine="Private save_sta_set_btn As Button";
sta_set.mostCurrent._save_sta_set_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private sta_mode_chk As CheckBox";
sta_set.mostCurrent._sta_mode_chk = RemoteObject.createNew ("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _proces_error(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("proces_error (sta_set) ","sta_set",5,sta_set.mostCurrent.activityBA,sta_set.mostCurrent,88);
if (RapidSub.canDelegate("proces_error")) return sta_set.remoteMe.runUserSub(false, "sta_set","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 88;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 89;BA.debugLine="Msgbox(msg,\"error\")";
Debug.ShouldStop(16777216);
sta_set.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(_msg),(Object)(RemoteObject.createImmutable("error")),sta_set.mostCurrent.activityBA);
 BA.debugLineNum = 90;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _save_sta_set_btn_click() throws Exception{
try {
		Debug.PushSubsStack("save_sta_set_btn_Click (sta_set) ","sta_set",5,sta_set.mostCurrent.activityBA,sta_set.mostCurrent,39);
if (RapidSub.canDelegate("save_sta_set_btn_click")) return sta_set.remoteMe.runUserSub(false, "sta_set","save_sta_set_btn_click");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 39;BA.debugLine="Sub save_sta_set_btn_Click";
Debug.ShouldStop(64);
 BA.debugLineNum = 40;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 41;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(256);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 42;BA.debugLine="Data.Initialize";
Debug.ShouldStop(512);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 43;BA.debugLine="Data.Put (\"ssid_sta\",sta_ssid_txt.Text)";
Debug.ShouldStop(1024);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("ssid_sta"))),(Object)((sta_set.mostCurrent._sta_ssid_txt.runMethod(true,"getText"))));
 BA.debugLineNum = 44;BA.debugLine="Data.Put (\"pass_sta\",sta_pass_txt.Text)";
Debug.ShouldStop(2048);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("pass_sta"))),(Object)((sta_set.mostCurrent._sta_pass_txt.runMethod(true,"getText"))));
 BA.debugLineNum = 45;BA.debugLine="Data.Put (\"mode_sta\",sta_mode_chk.Checked)";
Debug.ShouldStop(4096);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("mode_sta"))),(Object)((sta_set.mostCurrent._sta_mode_chk.runMethod(true,"getChecked"))));
 BA.debugLineNum = 46;BA.debugLine="Data.Put (\"save_info\",2)";
Debug.ShouldStop(8192);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("save_info"))),(Object)(RemoteObject.createImmutable((2))));
 BA.debugLineNum = 47;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(16384);
sta_set.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",sta_set.mostCurrent.activityBA,(Object)((sta_set.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e34) {
			BA.rdebugUtils.runVoidMethod("setLastException",sta_set.processBA, e34.toString()); BA.debugLineNum = 49;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(65536);
_proces_error(sta_set.mostCurrent.__c.runMethod(false,"LastException",sta_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 51;BA.debugLine="End Sub";
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
public static RemoteObject  _set_sta_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_sta_set (sta_set) ","sta_set",5,sta_set.mostCurrent.activityBA,sta_set.mostCurrent,74);
if (RapidSub.canDelegate("set_sta_set")) return sta_set.remoteMe.runUserSub(false, "sta_set","set_sta_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 74;BA.debugLine="Sub set_sta_set (mapar As Map)";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 76;BA.debugLine="If mapar.ContainsKey(\"ssid_sta\")=True Then  sta_s";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("ssid_sta")))),sta_set.mostCurrent.__c.getField(true,"True"))) { 
sta_set.mostCurrent._sta_ssid_txt.runMethodAndSync(true,"setText",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("ssid_sta")))));};
 BA.debugLineNum = 77;BA.debugLine="If mapar.ContainsKey(\"pass_sta\")=True Then  sta_p";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("pass_sta")))),sta_set.mostCurrent.__c.getField(true,"True"))) { 
sta_set.mostCurrent._sta_pass_txt.runMethodAndSync(true,"setText",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("pass_sta")))));};
 BA.debugLineNum = 78;BA.debugLine="If mapar.ContainsKey(\"mode_sta\")=True Then  sta_m";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("mode_sta")))),sta_set.mostCurrent.__c.getField(true,"True"))) { 
sta_set.mostCurrent._sta_mode_chk.runMethodAndSync(true,"setChecked",sta_set.mostCurrent._cm.runMethod(true,"_obj2bool",sta_set.mostCurrent.activityBA,(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("mode_sta")))))));};
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e62) {
			BA.rdebugUtils.runVoidMethod("setLastException",sta_set.processBA, e62.toString()); BA.debugLineNum = 80;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(32768);
_proces_error(sta_set.mostCurrent.__c.runMethod(false,"LastException",sta_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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