package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class inet_set_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (inet_set) ","inet_set",7,inet_set.mostCurrent.activityBA,inet_set.mostCurrent,29);
if (RapidSub.canDelegate("activity_create")) return inet_set.remoteMe.runUserSub(false, "inet_set","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 30;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 31;BA.debugLine="Activity.LoadLayout(\"INET_SET\")";
Debug.ShouldStop(1073741824);
inet_set.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("INET_SET")),inet_set.mostCurrent.activityBA);
 BA.debugLineNum = 32;BA.debugLine="Activity.Title =\"Inet MQTT set - \" & StateManager";
Debug.ShouldStop(-2147483648);
inet_set.mostCurrent._activity.runMethod(false,"setTitle",(RemoteObject.concat(RemoteObject.createImmutable("Inet MQTT set - "),inet_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 33;BA.debugLine="inet_devname_txt.Text=StateManager.GetSetting2(\"c";
Debug.ShouldStop(1);
inet_set.mostCurrent._inet_devname_txt.runMethodAndSync(true,"setText",(inet_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none")))));
 BA.debugLineNum = 34;BA.debugLine="inet_login_txt.Text=StateManager.GetSetting2(\"ine";
Debug.ShouldStop(2);
inet_set.mostCurrent._inet_login_txt.runMethodAndSync(true,"setText",(inet_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("inet_login")),(Object)(RemoteObject.createImmutable("MQTT login")))));
 BA.debugLineNum = 35;BA.debugLine="inet_pass_txt.Text=StateManager.GetSetting2(\"inet";
Debug.ShouldStop(4);
inet_set.mostCurrent._inet_pass_txt.runMethodAndSync(true,"setText",(inet_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("inet_pass")),(Object)(RemoteObject.createImmutable("MQTT pass")))));
 BA.debugLineNum = 36;BA.debugLine="inet_port_txt.Text=StateManager.GetSetting2(\"inet";
Debug.ShouldStop(8);
inet_set.mostCurrent._inet_port_txt.runMethodAndSync(true,"setText",(inet_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("inet_port")),(Object)(RemoteObject.createImmutable("1234")))));
 BA.debugLineNum = 37;BA.debugLine="inet_server_txt.Text=StateManager.GetSetting2(\"in";
Debug.ShouldStop(16);
inet_set.mostCurrent._inet_server_txt.runMethodAndSync(true,"setText",(inet_set.mostCurrent._statemanager.runMethod(true,"_getsetting2",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("inet_server")),(Object)(RemoteObject.createImmutable("MQTT server")))));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e25) {
			BA.rdebugUtils.runVoidMethod("setLastException",inet_set.processBA, e25.toString()); BA.debugLineNum = 39;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(64);
_proces_error(inet_set.mostCurrent.__c.runMethod(false,"LastException",inet_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (inet_set) ","inet_set",7,inet_set.mostCurrent.activityBA,inet_set.mostCurrent,47);
if (RapidSub.canDelegate("activity_pause")) return inet_set.remoteMe.runUserSub(false, "inet_set","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 47;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 49;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (inet_set) ","inet_set",7,inet_set.mostCurrent.activityBA,inet_set.mostCurrent,43);
if (RapidSub.canDelegate("activity_resume")) return inet_set.remoteMe.runUserSub(false, "inet_set","activity_resume");
 BA.debugLineNum = 43;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1024);
 BA.debugLineNum = 45;BA.debugLine="End Sub";
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
public static RemoteObject  _finish_him() throws Exception{
try {
		Debug.PushSubsStack("finish_him (inet_set) ","inet_set",7,inet_set.mostCurrent.activityBA,inet_set.mostCurrent,77);
if (RapidSub.canDelegate("finish_him")) return inet_set.remoteMe.runUserSub(false, "inet_set","finish_him");
 BA.debugLineNum = 77;BA.debugLine="Sub finish_him()";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8192);
inet_set.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 79;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private inet_devname_txt As EditText";
inet_set.mostCurrent._inet_devname_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private inet_login_txt As EditText";
inet_set.mostCurrent._inet_login_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private inet_pass_txt As EditText";
inet_set.mostCurrent._inet_pass_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private inet_port_txt As EditText";
inet_set.mostCurrent._inet_port_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private inet_server_txt As EditText";
inet_set.mostCurrent._inet_server_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private Label1 As Label";
inet_set.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private Label2 As Label";
inet_set.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Label3 As Label";
inet_set.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private Label4 As Label";
inet_set.mostCurrent._label4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Label5 As Label";
inet_set.mostCurrent._label5 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private save_ap_set_btn As Button";
inet_set.mostCurrent._save_ap_set_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _label5_longclick() throws Exception{
try {
		Debug.PushSubsStack("Label5_LongClick (inet_set) ","inet_set",7,inet_set.mostCurrent.activityBA,inet_set.mostCurrent,81);
if (RapidSub.canDelegate("label5_longclick")) return inet_set.remoteMe.runUserSub(false, "inet_set","label5_longclick");
 BA.debugLineNum = 81;BA.debugLine="Sub Label5_LongClick";
Debug.ShouldStop(65536);
 BA.debugLineNum = 83;BA.debugLine="End Sub";
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
public static RemoteObject  _proces_error(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("proces_error (inet_set) ","inet_set",7,inet_set.mostCurrent.activityBA,inet_set.mostCurrent,73);
if (RapidSub.canDelegate("proces_error")) return inet_set.remoteMe.runUserSub(false, "inet_set","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 73;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(256);
 BA.debugLineNum = 74;BA.debugLine="Msgbox(msg,\"error\")";
Debug.ShouldStop(512);
inet_set.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(_msg),(Object)(RemoteObject.createImmutable("error")),inet_set.mostCurrent.activityBA);
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
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
		Debug.PushSubsStack("save_ap_set_btn_Click (inet_set) ","inet_set",7,inet_set.mostCurrent.activityBA,inet_set.mostCurrent,52);
if (RapidSub.canDelegate("save_ap_set_btn_click")) return inet_set.remoteMe.runUserSub(false, "inet_set","save_ap_set_btn_click");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 52;BA.debugLine="Sub save_ap_set_btn_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 54;BA.debugLine="StateManager.SetSetting(\"new_dev_name\",inet_devna";
Debug.ShouldStop(2097152);
inet_set.mostCurrent._statemanager.runVoidMethod ("_setsetting",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("new_dev_name")),(Object)(inet_set.mostCurrent._inet_devname_txt.runMethod(true,"getText")));
 BA.debugLineNum = 55;BA.debugLine="StateManager.SetSetting(\"inet_login\",inet_login_t";
Debug.ShouldStop(4194304);
inet_set.mostCurrent._statemanager.runVoidMethod ("_setsetting",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("inet_login")),(Object)(inet_set.mostCurrent._inet_login_txt.runMethod(true,"getText")));
 BA.debugLineNum = 56;BA.debugLine="StateManager.SetSetting(\"inet_pass\",inet_pass_txt";
Debug.ShouldStop(8388608);
inet_set.mostCurrent._statemanager.runVoidMethod ("_setsetting",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("inet_pass")),(Object)(inet_set.mostCurrent._inet_pass_txt.runMethod(true,"getText")));
 BA.debugLineNum = 57;BA.debugLine="StateManager.SetSetting(\"inet_port\",inet_port_txt";
Debug.ShouldStop(16777216);
inet_set.mostCurrent._statemanager.runVoidMethod ("_setsetting",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("inet_port")),(Object)(inet_set.mostCurrent._inet_port_txt.runMethod(true,"getText")));
 BA.debugLineNum = 58;BA.debugLine="StateManager.SetSetting(\"inet_server\",inet_server";
Debug.ShouldStop(33554432);
inet_set.mostCurrent._statemanager.runVoidMethod ("_setsetting",inet_set.mostCurrent.activityBA,(Object)(BA.ObjectToString("inet_server")),(Object)(inet_set.mostCurrent._inet_server_txt.runMethod(true,"getText")));
 BA.debugLineNum = 59;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(67108864);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 60;BA.debugLine="Data.Initialize";
Debug.ShouldStop(134217728);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 61;BA.debugLine="Data.Put (\"newdevname\",inet_devname_txt.Text)";
Debug.ShouldStop(268435456);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("newdevname"))),(Object)((inet_set.mostCurrent._inet_devname_txt.runMethod(true,"getText"))));
 BA.debugLineNum = 62;BA.debugLine="Data.Put (\"inet_login\",inet_login_txt.Text)";
Debug.ShouldStop(536870912);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("inet_login"))),(Object)((inet_set.mostCurrent._inet_login_txt.runMethod(true,"getText"))));
 BA.debugLineNum = 63;BA.debugLine="Data.Put (\"inet_pass\",inet_pass_txt.Text)";
Debug.ShouldStop(1073741824);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("inet_pass"))),(Object)((inet_set.mostCurrent._inet_pass_txt.runMethod(true,"getText"))));
 BA.debugLineNum = 64;BA.debugLine="Data.Put (\"inet_port\",inet_port_txt.Text)";
Debug.ShouldStop(-2147483648);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("inet_port"))),(Object)((inet_set.mostCurrent._inet_port_txt.runMethod(true,"getText"))));
 BA.debugLineNum = 65;BA.debugLine="Data.Put (\"inet_server\",inet_server_txt.Text)";
Debug.ShouldStop(1);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("inet_server"))),(Object)((inet_set.mostCurrent._inet_server_txt.runMethod(true,"getText"))));
 BA.debugLineNum = 66;BA.debugLine="Data.Put (\"save_info\",4)";
Debug.ShouldStop(2);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("save_info"))),(Object)(RemoteObject.createImmutable((4))));
 BA.debugLineNum = 67;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(4);
inet_set.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",inet_set.mostCurrent.activityBA,(Object)((inet_set.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e49) {
			BA.rdebugUtils.runVoidMethod("setLastException",inet_set.processBA, e49.toString()); BA.debugLineNum = 69;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(16);
_proces_error(inet_set.mostCurrent.__c.runMethod(false,"LastException",inet_set.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 71;BA.debugLine="End Sub";
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
}