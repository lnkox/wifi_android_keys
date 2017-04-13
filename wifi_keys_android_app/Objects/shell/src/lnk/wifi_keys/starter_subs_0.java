package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,27);
if (RapidSub.canDelegate("application_error")) return starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 27;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 28;BA.debugLine="Return True";
Debug.ShouldStop(134217728);
if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mqtt_connect() throws Exception{
try {
		Debug.PushSubsStack("mqtt_connect (starter) ","starter",1,starter.processBA,starter.mostCurrent,55);
if (RapidSub.canDelegate("mqtt_connect")) return starter.remoteMe.runUserSub(false, "starter","mqtt_connect");
RemoteObject _strbroker = RemoteObject.createImmutable("");
RemoteObject _strusername = RemoteObject.createImmutable("");
RemoteObject _strpassword = RemoteObject.createImmutable("");
RemoteObject _bret = RemoteObject.createImmutable(false);
 BA.debugLineNum = 55;BA.debugLine="Sub mqtt_connect()";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 57;BA.debugLine="Dim strBroker As String = \"tcp://\" & StateManager";
Debug.ShouldStop(16777216);
_strbroker = RemoteObject.concat(RemoteObject.createImmutable("tcp://"),starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("inet_server")),(Object)(RemoteObject.createImmutable("MQTT server"))),RemoteObject.createImmutable(":"),starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("inet_port")),(Object)(RemoteObject.createImmutable("1234"))));Debug.locals.put("strBroker", _strbroker);Debug.locals.put("strBroker", _strbroker);
 BA.debugLineNum = 58;BA.debugLine="Dim strUsername As String  = StateManager.GetSett";
Debug.ShouldStop(33554432);
_strusername = starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("inet_login")),(Object)(RemoteObject.createImmutable("MQTT login")));Debug.locals.put("strUsername", _strusername);Debug.locals.put("strUsername", _strusername);
 BA.debugLineNum = 59;BA.debugLine="Dim strPassword As String  = StateManager.GetSett";
Debug.ShouldStop(67108864);
_strpassword = starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("inet_pass")),(Object)(RemoteObject.createImmutable("MQTT pass")));Debug.locals.put("strPassword", _strpassword);Debug.locals.put("strPassword", _strpassword);
 BA.debugLineNum = 60;BA.debugLine="ToastMessageShow(\"Connecting to \" & strBroker,Fal";
Debug.ShouldStop(134217728);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Connecting to "),_strbroker)),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 62;BA.debugLine="Dim bRet As Boolean = objMqtt.Connect(strBroker,\"";
Debug.ShouldStop(536870912);
_bret = starter._objmqtt.runMethod(true,"Connect",starter.processBA,(Object)(_strbroker),(Object)(BA.ObjectToString("")),(Object)(_strusername),(Object)(_strpassword));Debug.locals.put("bRet", _bret);Debug.locals.put("bRet", _bret);
 BA.debugLineNum = 63;BA.debugLine="If bRet=False Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",_bret,starter.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 64;BA.debugLine="ToastMessageShow(\"MQTT error\",False)";
Debug.ShouldStop(-2147483648);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("MQTT error")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 65;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
Debug.ShouldStop(1);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"False"))));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e46) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e46.toString()); BA.debugLineNum = 68;BA.debugLine="proces_error(LastException.Message & \"mqtt_connec";
Debug.ShouldStop(8);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("mqtt_connect")));
 };
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mqtt_disconnect() throws Exception{
try {
		Debug.PushSubsStack("mqtt_disconnect (starter) ","starter",1,starter.processBA,starter.mostCurrent,47);
if (RapidSub.canDelegate("mqtt_disconnect")) return starter.remoteMe.runUserSub(false, "starter","mqtt_disconnect");
 BA.debugLineNum = 47;BA.debugLine="Sub mqtt_disconnect()";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 49;BA.debugLine="objMqtt.Disconnect";
Debug.ShouldStop(65536);
starter._objmqtt.runVoidMethod ("Disconnect",starter.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e31) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e31.toString()); BA.debugLineNum = 51;BA.debugLine="proces_error(LastException.Message & \"mqtt_discon";
Debug.ShouldStop(262144);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("mqtt_disconnect")));
 };
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mqtt_init() throws Exception{
try {
		Debug.PushSubsStack("mqtt_init (starter) ","starter",1,starter.processBA,starter.mostCurrent,37);
if (RapidSub.canDelegate("mqtt_init")) return starter.remoteMe.runUserSub(false, "starter","mqtt_init");
 BA.debugLineNum = 37;BA.debugLine="Sub mqtt_init()";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 39;BA.debugLine="objMqtt.JavaDebug = True";
Debug.ShouldStop(64);
starter._objmqtt.setField ("JavaDebug",starter.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 40;BA.debugLine="objMqtt.CleanSession = True";
Debug.ShouldStop(128);
starter._objmqtt.setField ("CleanSession",starter.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 41;BA.debugLine="objMqtt.Initialize(\"oMqtt\")";
Debug.ShouldStop(256);
starter._objmqtt.runVoidMethod ("Initialize",starter.processBA,(Object)(RemoteObject.createImmutable("oMqtt")));
 BA.debugLineNum = 42;BA.debugLine="objMqtt.KeepAliveInterval =3";
Debug.ShouldStop(512);
starter._objmqtt.setField ("KeepAliveInterval",BA.numberCast(int.class, 3));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e24) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e24.toString()); BA.debugLineNum = 44;BA.debugLine="proces_error(LastException.Message & \"mqtt_init\")";
Debug.ShouldStop(2048);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("mqtt_init")));
 };
 BA.debugLineNum = 46;BA.debugLine="End Sub";
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
public static RemoteObject  _omqtt_connectionlost() throws Exception{
try {
		Debug.PushSubsStack("oMqtt_connectionLost (starter) ","starter",1,starter.processBA,starter.mostCurrent,75);
if (RapidSub.canDelegate("omqtt_connectionlost")) return starter.remoteMe.runUserSub(false, "starter","omqtt_connectionlost");
 BA.debugLineNum = 75;BA.debugLine="Sub oMqtt_connectionLost()";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
Debug.ShouldStop(2048);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"False"))));
 BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(\"MQTT connect error\",False)";
Debug.ShouldStop(4096);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("MQTT connect error")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 78;BA.debugLine="End Sub";
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
public static RemoteObject  _omqtt_deliverycomplete(RemoteObject _token) throws Exception{
try {
		Debug.PushSubsStack("oMqtt_deliverycomplete (starter) ","starter",1,starter.processBA,starter.mostCurrent,96);
if (RapidSub.canDelegate("omqtt_deliverycomplete")) return starter.remoteMe.runUserSub(false, "starter","omqtt_deliverycomplete", _token);
Debug.locals.put("Token", _token);
 BA.debugLineNum = 96;BA.debugLine="Sub oMqtt_deliverycomplete(Token As String)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 98;BA.debugLine="End Sub";
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
public static RemoteObject  _omqtt_messagearrived(RemoteObject _topic,RemoteObject _message) throws Exception{
try {
		Debug.PushSubsStack("oMqtt_messageArrived (starter) ","starter",1,starter.processBA,starter.mostCurrent,93);
if (RapidSub.canDelegate("omqtt_messagearrived")) return starter.remoteMe.runUserSub(false, "starter","omqtt_messagearrived", _topic, _message);
Debug.locals.put("Topic", _topic);
Debug.locals.put("Message", _message);
 BA.debugLineNum = 93;BA.debugLine="Sub oMqtt_messageArrived(Topic As String, Message";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="proces_json(Message,\"MQTT\")";
Debug.ShouldStop(536870912);
_proces_json(_message,RemoteObject.createImmutable("MQTT"));
 BA.debugLineNum = 95;BA.debugLine="End Sub";
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
public static RemoteObject  _omqtt_onconnect(RemoteObject _status) throws Exception{
try {
		Debug.PushSubsStack("oMqtt_onConnect (starter) ","starter",1,starter.processBA,starter.mostCurrent,79);
if (RapidSub.canDelegate("omqtt_onconnect")) return starter.remoteMe.runUserSub(false, "starter","omqtt_onconnect", _status);
Debug.locals.put("Status", _status);
 BA.debugLineNum = 79;BA.debugLine="Sub oMqtt_onConnect(Status As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="If Status=False Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_status,starter.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 81;BA.debugLine="ToastMessageShow(\"MQTT connect error\",False)";
Debug.ShouldStop(65536);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("MQTT connect error")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 82;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
Debug.ShouldStop(131072);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"False"))));
 }else {
 BA.debugLineNum = 84;BA.debugLine="ToastMessageShow(\"MQTT is connected\",False)";
Debug.ShouldStop(524288);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("MQTT is connected")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 85;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",True)";
Debug.ShouldStop(1048576);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"True"))));
 BA.debugLineNum = 86;BA.debugLine="objMqtt.Subscribe(\"wfkey\")";
Debug.ShouldStop(2097152);
starter._objmqtt.runVoidMethod ("Subscribe",starter.processBA,(Object)(RemoteObject.createImmutable("wfkey")));
 };
 BA.debugLineNum = 88;BA.debugLine="End Sub";
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
public static RemoteObject  _omqtt_ondisconnect(RemoteObject _status) throws Exception{
try {
		Debug.PushSubsStack("oMqtt_onDisconnect (starter) ","starter",1,starter.processBA,starter.mostCurrent,89);
if (RapidSub.canDelegate("omqtt_ondisconnect")) return starter.remoteMe.runUserSub(false, "starter","omqtt_ondisconnect", _status);
Debug.locals.put("Status", _status);
 BA.debugLineNum = 89;BA.debugLine="Sub oMqtt_onDisconnect(Status As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="ToastMessageShow(\"MQTT disconnect\",False)";
Debug.ShouldStop(33554432);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("MQTT disconnect")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 91;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
Debug.ShouldStop(67108864);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"False"))));
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
public static RemoteObject  _omqtt_oninitialized() throws Exception{
try {
		Debug.PushSubsStack("oMqtt_onInitialized (starter) ","starter",1,starter.processBA,starter.mostCurrent,72);
if (RapidSub.canDelegate("omqtt_oninitialized")) return starter.remoteMe.runUserSub(false, "starter","omqtt_oninitialized");
 BA.debugLineNum = 72;BA.debugLine="Sub oMqtt_onInitialized()";
Debug.ShouldStop(128);
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
public static RemoteObject  _proces_error(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("proces_error (starter) ","starter",1,starter.processBA,starter.mostCurrent,233);
if (RapidSub.canDelegate("proces_error")) return starter.remoteMe.runUserSub(false, "starter","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 233;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(256);
 BA.debugLineNum = 234;BA.debugLine="ToastMessageShow(msg,True)";
Debug.ShouldStop(512);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(_msg),(Object)(starter.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 235;BA.debugLine="End Sub";
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
public static RemoteObject  _proces_json(RemoteObject _result,RemoteObject _host) throws Exception{
try {
		Debug.PushSubsStack("proces_json (starter) ","starter",1,starter.processBA,starter.mostCurrent,119);
if (RapidSub.canDelegate("proces_json")) return starter.remoteMe.runUserSub(false, "starter","proces_json", _result, _host);
RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _mapar = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _tmpid = RemoteObject.createImmutable("");
Debug.locals.put("result", _result);
Debug.locals.put("host", _host);
 BA.debugLineNum = 119;BA.debugLine="Sub proces_json(result As String,host As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 120;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 121;BA.debugLine="result=result.Replace(Chr(0),\"\")";
Debug.ShouldStop(16777216);
_result = _result.runMethod(true,"replace",(Object)(BA.ObjectToString(starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0))))),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("result", _result);
 BA.debugLineNum = 122;BA.debugLine="result=result.Replace(\"}{\",\",\")";
Debug.ShouldStop(33554432);
_result = _result.runMethod(true,"replace",(Object)(BA.ObjectToString("}{")),(Object)(RemoteObject.createImmutable(",")));Debug.locals.put("result", _result);
 BA.debugLineNum = 123;BA.debugLine="Dim JSON As JSONParser";
Debug.ShouldStop(67108864);
_json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("JSON", _json);
 BA.debugLineNum = 124;BA.debugLine="Dim Mapar As Map";
Debug.ShouldStop(134217728);
_mapar = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Mapar", _mapar);
 BA.debugLineNum = 125;BA.debugLine="JSON.Initialize(result)";
Debug.ShouldStop(268435456);
_json.runVoidMethod ("Initialize",(Object)(_result));
 BA.debugLineNum = 126;BA.debugLine="Mapar = JSON.NextObject";
Debug.ShouldStop(536870912);
_mapar = _json.runMethod(false,"NextObject");Debug.locals.put("Mapar", _mapar);
 BA.debugLineNum = 128;BA.debugLine="If Mapar.ContainsKey(\"yourid\")=False Then Return";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("yourid")))),starter.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 129;BA.debugLine="Dim tmpid As String=Mapar.Get(\"yourid\")";
Debug.ShouldStop(1);
_tmpid = BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("yourid")))));Debug.locals.put("tmpid", _tmpid);Debug.locals.put("tmpid", _tmpid);
 BA.debugLineNum = 130;BA.debugLine="If tmpid.EqualsIgnoreCase(CM.myid)=False Then Ret";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_tmpid.runMethod(true,"equalsIgnoreCase",(Object)(starter.mostCurrent._cm._myid)),starter.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 132;BA.debugLine="If Mapar.ContainsKey(\"rssi\")=True Then   CallSubD";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("rssi")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_ris")),(Object)((_mapar)));};
 BA.debugLineNum = 133;BA.debugLine="If Mapar.ContainsKey(\"namedev\")=True Then CallSub";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("namedev")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed3",starter.processBA,(Object)((starter.mostCurrent._sel_dev.getObject())),(Object)(BA.ObjectToString("add_dev_tolist")),(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("namedev"))))),(Object)((_host)));};
 BA.debugLineNum = 134;BA.debugLine="If Mapar.ContainsKey(\"ssid_ap\")=True Then CallSub";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("ssid_ap")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._ap_set.getObject())),(Object)(BA.ObjectToString("set_ap_set")),(Object)((_mapar)));};
 BA.debugLineNum = 135;BA.debugLine="If Mapar.ContainsKey(\"ssid_sta\")=True Then CallSu";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("ssid_sta")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._sta_set.getObject())),(Object)(BA.ObjectToString("set_sta_set")),(Object)((_mapar)));};
 BA.debugLineNum = 136;BA.debugLine="If Mapar.ContainsKey(\"key_id\")=True Then set_key_";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("key_id")))),starter.mostCurrent.__c.getField(true,"True"))) { 
_set_key_set(_mapar);};
 BA.debugLineNum = 137;BA.debugLine="If Mapar.ContainsKey(\"font_size\")=True Then set_k";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("font_size")))),starter.mostCurrent.__c.getField(true,"True"))) { 
_set_keyinfo_set(_mapar);};
 BA.debugLineNum = 139;BA.debugLine="If Mapar.ContainsKey(\"save_ok\")=True Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("save_ok")))),starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 140;BA.debugLine="ToastMessageShow (\"Saved\",False)";
Debug.ShouldStop(2048);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Saved")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 141;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=1) Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 142;BA.debugLine="CallSubDelayed(AP_SET,\"finish_him\")";
Debug.ShouldStop(8192);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._ap_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 BA.debugLineNum = 144;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=2) Then";
Debug.ShouldStop(32768);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 145;BA.debugLine="CallSubDelayed(STA_SET,\"finish_him\")";
Debug.ShouldStop(65536);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._sta_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 BA.debugLineNum = 147;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=3) Then";
Debug.ShouldStop(262144);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 148;BA.debugLine="CallSubDelayed(KEY_SET,\"finish_him\")";
Debug.ShouldStop(524288);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._key_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 BA.debugLineNum = 149;BA.debugLine="CallSubDelayed(sel_dev,\"load_keys\")";
Debug.ShouldStop(1048576);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._sel_dev.getObject())),(Object)(RemoteObject.createImmutable("load_keys")));
 };
 BA.debugLineNum = 151;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=4) Then";
Debug.ShouldStop(4194304);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 152;BA.debugLine="CallSubDelayed(INET_SET,\"finish_him\")";
Debug.ShouldStop(8388608);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._inet_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e123) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e123.toString()); BA.debugLineNum = 156;BA.debugLine="proces_error(LastException.Message & \"process_jso";
Debug.ShouldStop(134217728);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("process_json")));
 };
 BA.debugLineNum = 158;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim UDPSocket As UDPSocket";
starter._udpsocket = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 10;BA.debugLine="Dim objMqtt As MQTT";
starter._objmqtt = RemoteObject.createNew ("com.visualnet.mqtt");
 //BA.debugLineNum = 11;BA.debugLine="Dim objPhone As Phone";
starter._objphone = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _send_to_dev(RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("send_to_dev (starter) ","starter",1,starter.processBA,starter.mostCurrent,189);
if (RapidSub.canDelegate("send_to_dev")) return starter.remoteMe.runUserSub(false, "starter","send_to_dev", _data);
RemoteObject _msg = RemoteObject.createImmutable("");
RemoteObject _jsongenerator = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
Debug.locals.put("data", _data);
 BA.debugLineNum = 189;BA.debugLine="Sub send_to_dev(data As Map) As Boolean ' Відправк";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 190;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 191;BA.debugLine="Dim msg As String";
Debug.ShouldStop(1073741824);
_msg = RemoteObject.createImmutable("");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 192;BA.debugLine="Dim JSONGenerator As JSONGenerator";
Debug.ShouldStop(-2147483648);
_jsongenerator = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("JSONGenerator", _jsongenerator);
 BA.debugLineNum = 193;BA.debugLine="data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
Debug.ShouldStop(1);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("dev_name"))),(Object)((starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 194;BA.debugLine="data.Put (\"myid\",CM.myid)";
Debug.ShouldStop(2);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("myid"))),(Object)((starter.mostCurrent._cm._myid)));
 BA.debugLineNum = 195;BA.debugLine="JSONGenerator.Initialize(data)";
Debug.ShouldStop(4);
_jsongenerator.runVoidMethod ("Initialize",(Object)(_data));
 BA.debugLineNum = 196;BA.debugLine="msg = JSONGenerator.ToString";
Debug.ShouldStop(8);
_msg = _jsongenerator.runMethod(true,"ToString");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 197;BA.debugLine="If CM.connect_type=True Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",starter.mostCurrent._cm._connect_type,starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 198;BA.debugLine="Return send_to_dev_mqtt(msg)";
Debug.ShouldStop(32);
Debug.CheckDeviceExceptions();if (true) return _send_to_dev_mqtt(_msg);
 }else {
 BA.debugLineNum = 200;BA.debugLine="Return send_to_dev_udp(msg)";
Debug.ShouldStop(128);
Debug.CheckDeviceExceptions();if (true) return _send_to_dev_udp(_msg);
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e170) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e170.toString()); BA.debugLineNum = 203;BA.debugLine="proces_error(LastException.Message & \"send_to_de";
Debug.ShouldStop(1024);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("send_to_dev")));
 };
 BA.debugLineNum = 205;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _send_to_dev_mqtt(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("send_to_dev_mqtt (starter) ","starter",1,starter.processBA,starter.mostCurrent,207);
if (RapidSub.canDelegate("send_to_dev_mqtt")) return starter.remoteMe.runUserSub(false, "starter","send_to_dev_mqtt", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 207;BA.debugLine="Sub send_to_dev_mqtt(msg As String) As Boolean ' В";
Debug.ShouldStop(16384);
 BA.debugLineNum = 208;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 209;BA.debugLine="If objMqtt.isConnected =False Then Return False";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",starter._objmqtt.runMethod(true,"isConnected"),starter.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 210;BA.debugLine="objMqtt.Publish(\"wfkeyin\",msg,  objMqtt.QoS_Exact";
Debug.ShouldStop(131072);
starter._objmqtt.runVoidMethod ("Publish",starter.processBA,(Object)(BA.ObjectToString("wfkeyin")),(Object)(_msg),(Object)(starter._objmqtt.getField(true,"QoS_ExactlyOnce")),(Object)(starter.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 211;BA.debugLine="Return True";
Debug.ShouldStop(262144);
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"True");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e179) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e179.toString()); BA.debugLineNum = 213;BA.debugLine="proces_error(LastException.Message & \"send_to_dev";
Debug.ShouldStop(1048576);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("send_to_dev_mqtt")));
 BA.debugLineNum = 214;BA.debugLine="Return False";
Debug.ShouldStop(2097152);
if (true) return starter.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _send_to_dev_udp(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("send_to_dev_udp (starter) ","starter",1,starter.processBA,starter.mostCurrent,218);
if (RapidSub.canDelegate("send_to_dev_udp")) return starter.remoteMe.runUserSub(false, "starter","send_to_dev_udp", _msg);
RemoteObject _packet = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");
RemoteObject _buffer = null;
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 218;BA.debugLine="Sub send_to_dev_udp(msg As String) As Boolean ' Ві";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 220;BA.debugLine="If UDPSocket.IsInitialized =False Then Return Fal";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",starter._udpsocket.runMethod(true,"IsInitialized"),starter.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 221;BA.debugLine="Dim Packet As UDPPacket";
Debug.ShouldStop(268435456);
_packet = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 222;BA.debugLine="Dim Buffer() As Byte";
Debug.ShouldStop(536870912);
_buffer = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 223;BA.debugLine="Buffer = msg.GetBytes(\"UTF8\")";
Debug.ShouldStop(1073741824);
_buffer = _msg.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 224;BA.debugLine="Packet.Initialize(Buffer, \"255.255.255.255\", \"";
Debug.ShouldStop(-2147483648);
_packet.runVoidMethod ("Initialize",(Object)(_buffer),(Object)(BA.ObjectToString("255.255.255.255")),(Object)(BA.numberCast(int.class, RemoteObject.createImmutable("2201"))));
 BA.debugLineNum = 225;BA.debugLine="UDPSocket.Send(Packet)";
Debug.ShouldStop(1);
starter._udpsocket.runVoidMethod ("Send",(Object)(_packet));
 BA.debugLineNum = 226;BA.debugLine="Return True";
Debug.ShouldStop(2);
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"True");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e193) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e193.toString()); BA.debugLineNum = 228;BA.debugLine="proces_error(LastException.Message & \"send_to_dev";
Debug.ShouldStop(8);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("send_to_dev_udp")));
 BA.debugLineNum = 229;BA.debugLine="Return False";
Debug.ShouldStop(16);
if (true) return starter.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 231;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,14);
if (RapidSub.canDelegate("service_create")) return starter.remoteMe.runUserSub(false, "starter","service_create");
 BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(8192);
 BA.debugLineNum = 18;BA.debugLine="End Sub";
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
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,31);
if (RapidSub.canDelegate("service_destroy")) return starter.remoteMe.runUserSub(false, "starter","service_destroy");
 BA.debugLineNum = 31;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
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
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,20);
if (RapidSub.canDelegate("service_start")) return starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 20;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 21;BA.debugLine="udp_init ' ініціалізація UDP";
Debug.ShouldStop(1048576);
_udp_init();
 BA.debugLineNum = 22;BA.debugLine="mqtt_init' ініціалізація MQTT";
Debug.ShouldStop(2097152);
_mqtt_init();
 BA.debugLineNum = 23;BA.debugLine="CM.myid=objPhone.GetSettings(\"android_id\")";
Debug.ShouldStop(4194304);
starter.mostCurrent._cm._myid = starter._objphone.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id")));
 BA.debugLineNum = 24;BA.debugLine="End Sub";
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
public static RemoteObject  _set_key_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_key_set (starter) ","starter",1,starter.processBA,starter.mostCurrent,159);
if (RapidSub.canDelegate("set_key_set")) return starter.remoteMe.runUserSub(false, "starter","set_key_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 159;BA.debugLine="Sub set_key_set (mapar As Map)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="Try";
Debug.ShouldStop(-2147483648);
try { BA.debugLineNum = 161;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))<1 Or CM.toint(m";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("<",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id"))))))),BA.numberCast(double.class, 1)) || RemoteObject.solveBoolean(">",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id"))))))),BA.numberCast(double.class, 30))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 162;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))=30 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id"))))))),BA.numberCast(double.class, 30))) { 
 BA.debugLineNum = 163;BA.debugLine="ToastMessageShow(\"Load data complete\",False)";
Debug.ShouldStop(4);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Load data complete")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 164;BA.debugLine="CallSubDelayed(sel_dev,\"finish_him\")";
Debug.ShouldStop(8);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._sel_dev.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 BA.debugLineNum = 166;BA.debugLine="StateManager.SetSetting(\"keytext\" & mapar.Get (\"";
Debug.ShouldStop(32);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytext"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))))));
 BA.debugLineNum = 167;BA.debugLine="If mapar.Get (\"name\") =\"@\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))),RemoteObject.createImmutable(("@")))) { 
 BA.debugLineNum = 168;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
Debug.ShouldStop(128);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(RemoteObject.createImmutable("")));
 }else {
 BA.debugLineNum = 170;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
Debug.ShouldStop(512);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))));
 };
 BA.debugLineNum = 172;BA.debugLine="StateManager.SetSetting(\"keylock\" & mapar.Get (\"";
Debug.ShouldStop(2048);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keylock"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(BA.ObjectToString(starter.mostCurrent._cm.runMethod(true,"_obj2bool",starter.processBA,(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("lock")))))))));
 BA.debugLineNum = 173;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(4096);
starter.mostCurrent._statemanager.runVoidMethod ("_savesettings",starter.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e142) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e142.toString()); BA.debugLineNum = 175;BA.debugLine="proces_error(LastException.Message & \"set_key_se";
Debug.ShouldStop(16384);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("set_key_set")));
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
public static RemoteObject  _set_keyinfo_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_keyinfo_set (starter) ","starter",1,starter.processBA,starter.mostCurrent,178);
if (RapidSub.canDelegate("set_keyinfo_set")) return starter.remoteMe.runUserSub(false, "starter","set_keyinfo_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 178;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 179;BA.debugLine="Try";
Debug.ShouldStop(262144);
try { BA.debugLineNum = 180;BA.debugLine="StateManager.SetSetting(\"font_size\", CM.toint(ma";
Debug.ShouldStop(524288);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("font_size")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("font_size"))))))))));
 BA.debugLineNum = 181;BA.debugLine="StateManager.SetSetting(\"h_size\", CM.toint(mapar";
Debug.ShouldStop(1048576);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("h_size")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("h_size"))))))))));
 BA.debugLineNum = 182;BA.debugLine="StateManager.SetSetting(\"v_size\", CM.toint(mapar";
Debug.ShouldStop(2097152);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("v_size")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("v_size"))))))))));
 BA.debugLineNum = 183;BA.debugLine="StateManager.SetSetting(\"batt_dev\", CM.toint(map";
Debug.ShouldStop(4194304);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("batt_dev")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("batt_dev"))))))))));
 BA.debugLineNum = 184;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(8388608);
starter.mostCurrent._statemanager.runVoidMethod ("_savesettings",starter.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e153) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e153.toString()); BA.debugLineNum = 186;BA.debugLine="proces_error(LastException.Message & \"set_key_in";
Debug.ShouldStop(33554432);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("set_key_info_set")));
 };
 BA.debugLineNum = 188;BA.debugLine="End Sub";
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
public static RemoteObject  _udp_init() throws Exception{
try {
		Debug.PushSubsStack("udp_init (starter) ","starter",1,starter.processBA,starter.mostCurrent,103);
if (RapidSub.canDelegate("udp_init")) return starter.remoteMe.runUserSub(false, "starter","udp_init");
 BA.debugLineNum = 103;BA.debugLine="Sub udp_init()";
Debug.ShouldStop(64);
 BA.debugLineNum = 104;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 105;BA.debugLine="UDPSocket.Initialize(\"UDP\", 1407,255)";
Debug.ShouldStop(256);
starter._udpsocket.runVoidMethod ("Initialize",starter.processBA,(Object)(BA.ObjectToString("UDP")),(Object)(BA.numberCast(int.class, 1407)),(Object)(BA.numberCast(int.class, 255)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e78) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e78.toString()); BA.debugLineNum = 107;BA.debugLine="proces_error(LastException.Message & \"udp_init\")";
Debug.ShouldStop(1024);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("udp_init")));
 };
 BA.debugLineNum = 109;BA.debugLine="End Sub";
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
public static RemoteObject  _udp_packetarrived(RemoteObject _packet) throws Exception{
try {
		Debug.PushSubsStack("UDP_PacketArrived (starter) ","starter",1,starter.processBA,starter.mostCurrent,111);
if (RapidSub.canDelegate("udp_packetarrived")) return starter.remoteMe.runUserSub(false, "starter","udp_packetarrived", _packet);
RemoteObject _result = RemoteObject.createImmutable("");
Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 111;BA.debugLine="Sub UDP_PacketArrived (Packet As UDPPacket)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 112;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 113;BA.debugLine="Dim result As String = BytesToString(Packet.Da";
Debug.ShouldStop(65536);
_result = starter.mostCurrent.__c.runMethod(true,"BytesToString",(Object)(_packet.runMethod(false,"getData")),(Object)(_packet.runMethod(true,"getOffset")),(Object)(_packet.runMethod(true,"getLength")),(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 114;BA.debugLine="proces_json(result,Packet.HostAddress)";
Debug.ShouldStop(131072);
_proces_json(_result,_packet.runMethod(true,"getHostAddress"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e86) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e86.toString()); BA.debugLineNum = 116;BA.debugLine="proces_error(LastException.Message & \"udp_pack.ar";
Debug.ShouldStop(524288);
_proces_error(RemoteObject.concat(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("udp_pack.arrived")));
 };
 BA.debugLineNum = 118;BA.debugLine="End Sub";
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
}