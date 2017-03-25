package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_2 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,26);
if (RapidSub.canDelegate("application_error")) return starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 26;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 27;BA.debugLine="Return True";
Debug.ShouldStop(67108864);
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 28;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("mqtt_connect (starter) ","starter",1,starter.processBA,starter.mostCurrent,41);
if (RapidSub.canDelegate("mqtt_connect")) return starter.remoteMe.runUserSub(false, "starter","mqtt_connect");
 BA.debugLineNum = 41;BA.debugLine="Sub mqtt_connect()";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 43;BA.debugLine="objMqtt.Disconnect";
Debug.ShouldStop(1024);
starter._objmqtt.runVoidMethod ("Disconnect",starter.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e24) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e24.toString()); BA.debugLineNum = 45;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(4096);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
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
public static RemoteObject  _mqtt_disconnect() throws Exception{
try {
		Debug.PushSubsStack("mqtt_disconnect (starter) ","starter",1,starter.processBA,starter.mostCurrent,49);
if (RapidSub.canDelegate("mqtt_disconnect")) return starter.remoteMe.runUserSub(false, "starter","mqtt_disconnect");
RemoteObject _strbroker = RemoteObject.createImmutable("");
RemoteObject _strusername = RemoteObject.createImmutable("");
RemoteObject _strpassword = RemoteObject.createImmutable("");
RemoteObject _bret = RemoteObject.createImmutable(false);
 BA.debugLineNum = 49;BA.debugLine="Sub mqtt_disconnect()";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Try";
Debug.ShouldStop(131072);
try { BA.debugLineNum = 51;BA.debugLine="Dim strBroker As String = \"tcp://\" & StateManager";
Debug.ShouldStop(262144);
_strbroker = RemoteObject.concat(RemoteObject.createImmutable("tcp://"),starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("inet_server")),(Object)(RemoteObject.createImmutable("MQTT server"))),RemoteObject.createImmutable(":"),starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("inet_port")),(Object)(RemoteObject.createImmutable("1234"))));Debug.locals.put("strBroker", _strbroker);Debug.locals.put("strBroker", _strbroker);
 BA.debugLineNum = 52;BA.debugLine="Dim strUsername As String  = StateManager.GetSett";
Debug.ShouldStop(524288);
_strusername = starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("inet_login")),(Object)(RemoteObject.createImmutable("MQTT login")));Debug.locals.put("strUsername", _strusername);Debug.locals.put("strUsername", _strusername);
 BA.debugLineNum = 53;BA.debugLine="Dim strPassword As String  = StateManager.GetSett";
Debug.ShouldStop(1048576);
_strpassword = starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("inet_pass")),(Object)(RemoteObject.createImmutable("MQTT pass")));Debug.locals.put("strPassword", _strpassword);Debug.locals.put("strPassword", _strpassword);
 BA.debugLineNum = 54;BA.debugLine="ToastMessageShow(\"Connecting to \" & strBroker,Fal";
Debug.ShouldStop(2097152);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Connecting to "),_strbroker)),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 56;BA.debugLine="Dim bRet As Boolean = objMqtt.Connect(strBroker,\"";
Debug.ShouldStop(8388608);
_bret = starter._objmqtt.runMethod(true,"Connect",starter.processBA,(Object)(_strbroker),(Object)(BA.ObjectToString("")),(Object)(_strusername),(Object)(_strpassword));Debug.locals.put("bRet", _bret);Debug.locals.put("bRet", _bret);
 BA.debugLineNum = 57;BA.debugLine="If bRet=False Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_bret,starter.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 58;BA.debugLine="ToastMessageShow(\"MQTT error\",False)";
Debug.ShouldStop(33554432);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("MQTT error")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 59;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
Debug.ShouldStop(67108864);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"False"))));
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e39) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e39.toString()); BA.debugLineNum = 62;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(536870912);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 64;BA.debugLine="End Sub";
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
public static RemoteObject  _mqtt_init() throws Exception{
try {
		Debug.PushSubsStack("mqtt_init (starter) ","starter",1,starter.processBA,starter.mostCurrent,36);
if (RapidSub.canDelegate("mqtt_init")) return starter.remoteMe.runUserSub(false, "starter","mqtt_init");
 BA.debugLineNum = 36;BA.debugLine="Sub mqtt_init()";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="objMqtt.JavaDebug = True";
Debug.ShouldStop(16);
starter._objmqtt.setField ("JavaDebug",starter.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 38;BA.debugLine="objMqtt.CleanSession = True";
Debug.ShouldStop(32);
starter._objmqtt.setField ("CleanSession",starter.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 39;BA.debugLine="objMqtt.Initialize(\"oMqtt\")";
Debug.ShouldStop(64);
starter._objmqtt.runVoidMethod ("Initialize",starter.processBA,(Object)(RemoteObject.createImmutable("oMqtt")));
 BA.debugLineNum = 40;BA.debugLine="End Sub";
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
public static RemoteObject  _omqtt_connectionlost() throws Exception{
try {
		Debug.PushSubsStack("oMqtt_connectionLost (starter) ","starter",1,starter.processBA,starter.mostCurrent,69);
if (RapidSub.canDelegate("omqtt_connectionlost")) return starter.remoteMe.runUserSub(false, "starter","omqtt_connectionlost");
 BA.debugLineNum = 69;BA.debugLine="Sub oMqtt_connectionLost()";
Debug.ShouldStop(16);
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
public static RemoteObject  _omqtt_deliverycomplete(RemoteObject _token) throws Exception{
try {
		Debug.PushSubsStack("oMqtt_deliverycomplete (starter) ","starter",1,starter.processBA,starter.mostCurrent,87);
if (RapidSub.canDelegate("omqtt_deliverycomplete")) return starter.remoteMe.runUserSub(false, "starter","omqtt_deliverycomplete", _token);
Debug.locals.put("Token", _token);
 BA.debugLineNum = 87;BA.debugLine="Sub oMqtt_deliverycomplete(Token As String)";
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
public static RemoteObject  _omqtt_messagearrived(RemoteObject _topic,RemoteObject _message) throws Exception{
try {
		Debug.PushSubsStack("oMqtt_messageArrived (starter) ","starter",1,starter.processBA,starter.mostCurrent,84);
if (RapidSub.canDelegate("omqtt_messagearrived")) return starter.remoteMe.runUserSub(false, "starter","omqtt_messagearrived", _topic, _message);
Debug.locals.put("Topic", _topic);
Debug.locals.put("Message", _message);
 BA.debugLineNum = 84;BA.debugLine="Sub oMqtt_messageArrived(Topic As String, Message";
Debug.ShouldStop(524288);
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
public static RemoteObject  _omqtt_onconnect(RemoteObject _status) throws Exception{
try {
		Debug.PushSubsStack("oMqtt_onConnect (starter) ","starter",1,starter.processBA,starter.mostCurrent,72);
if (RapidSub.canDelegate("omqtt_onconnect")) return starter.remoteMe.runUserSub(false, "starter","omqtt_onconnect", _status);
Debug.locals.put("Status", _status);
 BA.debugLineNum = 72;BA.debugLine="Sub oMqtt_onConnect(Status As Boolean)";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="If Status=False Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_status,starter.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 74;BA.debugLine="ToastMessageShow(\"MQTT connect error\",False)";
Debug.ShouldStop(512);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("MQTT connect error")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 75;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
Debug.ShouldStop(1024);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"False"))));
 }else {
 BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(\"MQTT is connected\",False)";
Debug.ShouldStop(4096);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("MQTT is connected")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 78;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",True)";
Debug.ShouldStop(8192);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"True"))));
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
public static RemoteObject  _omqtt_ondisconnect(RemoteObject _status) throws Exception{
try {
		Debug.PushSubsStack("oMqtt_onDisconnect (starter) ","starter",1,starter.processBA,starter.mostCurrent,81);
if (RapidSub.canDelegate("omqtt_ondisconnect")) return starter.remoteMe.runUserSub(false, "starter","omqtt_ondisconnect", _status);
Debug.locals.put("Status", _status);
 BA.debugLineNum = 81;BA.debugLine="Sub oMqtt_onDisconnect(Status As Boolean)";
Debug.ShouldStop(65536);
 BA.debugLineNum = 82;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
Debug.ShouldStop(131072);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"False"))));
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
public static RemoteObject  _omqtt_oninitialized() throws Exception{
try {
		Debug.PushSubsStack("oMqtt_onInitialized (starter) ","starter",1,starter.processBA,starter.mostCurrent,66);
if (RapidSub.canDelegate("omqtt_oninitialized")) return starter.remoteMe.runUserSub(false, "starter","omqtt_oninitialized");
 BA.debugLineNum = 66;BA.debugLine="Sub oMqtt_onInitialized()";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
Debug.ShouldStop(4);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_mqtt_state")),(Object)((starter.mostCurrent.__c.getField(true,"False"))));
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
public static RemoteObject  _proces_error(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("proces_error (starter) ","starter",1,starter.processBA,starter.mostCurrent,186);
if (RapidSub.canDelegate("proces_error")) return starter.remoteMe.runUserSub(false, "starter","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 186;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 187;BA.debugLine="ToastMessageShow(msg,True)";
Debug.ShouldStop(67108864);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(_msg),(Object)(starter.mostCurrent.__c.getField(true,"True")));
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim UDPSocket As UDPSocket";
starter._udpsocket = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 10;BA.debugLine="Dim objMqtt As MQTT";
starter._objmqtt = RemoteObject.createNew ("com.visualnet.mqtt");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _send_to_dev(RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("send_to_dev (starter) ","starter",1,starter.processBA,starter.mostCurrent,167);
if (RapidSub.canDelegate("send_to_dev")) return starter.remoteMe.runUserSub(false, "starter","send_to_dev", _data);
RemoteObject _packet = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");
RemoteObject _buffer = null;
RemoteObject _msg = RemoteObject.createImmutable("");
RemoteObject _jsongenerator = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
Debug.locals.put("data", _data);
 BA.debugLineNum = 167;BA.debugLine="Sub send_to_dev(data As Map) As Boolean ' Відправк";
Debug.ShouldStop(64);
 BA.debugLineNum = 168;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 169;BA.debugLine="If UDPSocket.IsInitialized =False Then Return Fal";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",starter._udpsocket.runMethod(true,"IsInitialized"),starter.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 170;BA.debugLine="Dim Packet As UDPPacket";
Debug.ShouldStop(512);
_packet = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 171;BA.debugLine="Dim Buffer() As Byte";
Debug.ShouldStop(1024);
_buffer = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 172;BA.debugLine="Dim msg As String";
Debug.ShouldStop(2048);
_msg = RemoteObject.createImmutable("");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 173;BA.debugLine="Dim JSONGenerator As JSONGenerator";
Debug.ShouldStop(4096);
_jsongenerator = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("JSONGenerator", _jsongenerator);
 BA.debugLineNum = 174;BA.debugLine="data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
Debug.ShouldStop(8192);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("dev_name"))),(Object)((starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 175;BA.debugLine="JSONGenerator.Initialize(data)";
Debug.ShouldStop(16384);
_jsongenerator.runVoidMethod ("Initialize",(Object)(_data));
 BA.debugLineNum = 176;BA.debugLine="msg = JSONGenerator.ToString";
Debug.ShouldStop(32768);
_msg = _jsongenerator.runMethod(true,"ToString");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 177;BA.debugLine="Buffer = msg.GetBytes(\"UTF8\")";
Debug.ShouldStop(65536);
_buffer = _msg.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 178;BA.debugLine="Packet.Initialize(Buffer, \"255.255.255.255\", \"";
Debug.ShouldStop(131072);
_packet.runVoidMethod ("Initialize",(Object)(_buffer),(Object)(BA.ObjectToString("255.255.255.255")),(Object)(BA.numberCast(int.class, RemoteObject.createImmutable("2201"))));
 BA.debugLineNum = 179;BA.debugLine="UDPSocket.Send(Packet)";
Debug.ShouldStop(262144);
starter._udpsocket.runVoidMethod ("Send",(Object)(_packet));
 BA.debugLineNum = 180;BA.debugLine="Return True";
Debug.ShouldStop(524288);
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"True");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e149) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e149.toString()); BA.debugLineNum = 182;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(2097152);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 BA.debugLineNum = 183;BA.debugLine="Return False";
Debug.ShouldStop(4194304);
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,13);
if (RapidSub.canDelegate("service_create")) return starter.remoteMe.runUserSub(false, "starter","service_create");
 BA.debugLineNum = 13;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(4096);
 BA.debugLineNum = 17;BA.debugLine="End Sub";
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
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,30);
if (RapidSub.canDelegate("service_destroy")) return starter.remoteMe.runUserSub(false, "starter","service_destroy");
 BA.debugLineNum = 30;BA.debugLine="Sub Service_Destroy";
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
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,19);
if (RapidSub.canDelegate("service_start")) return starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 19;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(262144);
 BA.debugLineNum = 20;BA.debugLine="udp_init ' ініціалізація UDP";
Debug.ShouldStop(524288);
_udp_init();
 BA.debugLineNum = 21;BA.debugLine="mqtt_init' ініціалізація MQTT";
Debug.ShouldStop(1048576);
_mqtt_init();
 BA.debugLineNum = 23;BA.debugLine="End Sub";
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
public static RemoteObject  _set_key_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_key_set (starter) ","starter",1,starter.processBA,starter.mostCurrent,138);
if (RapidSub.canDelegate("set_key_set")) return starter.remoteMe.runUserSub(false, "starter","set_key_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 138;BA.debugLine="Sub set_key_set (mapar As Map)";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="Try";
Debug.ShouldStop(1024);
try { BA.debugLineNum = 140;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))<1 Or CM.toint(m";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("<",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id"))))))),BA.numberCast(double.class, 1)) || RemoteObject.solveBoolean(">",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id"))))))),BA.numberCast(double.class, 30))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 141;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))=30 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id"))))))),BA.numberCast(double.class, 30))) { 
 BA.debugLineNum = 142;BA.debugLine="ToastMessageShow(\"Load data complete\",False)";
Debug.ShouldStop(8192);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Load data complete")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 143;BA.debugLine="CallSubDelayed(sel_dev,\"finish_him\")";
Debug.ShouldStop(16384);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._sel_dev.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 BA.debugLineNum = 145;BA.debugLine="StateManager.SetSetting(\"keytext\" & mapar.Get (\"";
Debug.ShouldStop(65536);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytext"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))))));
 BA.debugLineNum = 146;BA.debugLine="If mapar.Get (\"name\") =\"@\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))),RemoteObject.createImmutable(("@")))) { 
 BA.debugLineNum = 147;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
Debug.ShouldStop(262144);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(RemoteObject.createImmutable("")));
 }else {
 BA.debugLineNum = 149;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
Debug.ShouldStop(1048576);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))));
 };
 BA.debugLineNum = 151;BA.debugLine="StateManager.SetSetting(\"keylock\" & mapar.Get (\"";
Debug.ShouldStop(4194304);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keylock"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(BA.ObjectToString(starter.mostCurrent._cm.runMethod(true,"_obj2bool",starter.processBA,(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("lock")))))))));
 BA.debugLineNum = 152;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(8388608);
starter.mostCurrent._statemanager.runVoidMethod ("_savesettings",starter.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e121) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e121.toString()); BA.debugLineNum = 154;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(33554432);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 156;BA.debugLine="End Sub";
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
public static RemoteObject  _set_keyinfo_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_keyinfo_set (starter) ","starter",1,starter.processBA,starter.mostCurrent,157);
if (RapidSub.canDelegate("set_keyinfo_set")) return starter.remoteMe.runUserSub(false, "starter","set_keyinfo_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 157;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="Try";
Debug.ShouldStop(536870912);
try { BA.debugLineNum = 159;BA.debugLine="StateManager.SetSetting(\"font_size\", CM.toint(ma";
Debug.ShouldStop(1073741824);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("font_size")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("font_size"))))))))));
 BA.debugLineNum = 160;BA.debugLine="StateManager.SetSetting(\"h_size\", CM.toint(mapar";
Debug.ShouldStop(-2147483648);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("h_size")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("h_size"))))))))));
 BA.debugLineNum = 161;BA.debugLine="StateManager.SetSetting(\"v_size\", CM.toint(mapar";
Debug.ShouldStop(1);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("v_size")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("v_size"))))))))));
 BA.debugLineNum = 162;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(2);
starter.mostCurrent._statemanager.runVoidMethod ("_savesettings",starter.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e131) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e131.toString()); BA.debugLineNum = 164;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(8);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 166;BA.debugLine="End Sub";
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
public static RemoteObject  _udp_init() throws Exception{
try {
		Debug.PushSubsStack("udp_init (starter) ","starter",1,starter.processBA,starter.mostCurrent,94);
if (RapidSub.canDelegate("udp_init")) return starter.remoteMe.runUserSub(false, "starter","udp_init");
 BA.debugLineNum = 94;BA.debugLine="Sub udp_init()";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="Try";
Debug.ShouldStop(1073741824);
try { BA.debugLineNum = 96;BA.debugLine="UDPSocket.Initialize(\"UDP\", 1407,255)";
Debug.ShouldStop(-2147483648);
starter._udpsocket.runVoidMethod ("Initialize",starter.processBA,(Object)(BA.ObjectToString("UDP")),(Object)(BA.numberCast(int.class, 1407)),(Object)(BA.numberCast(int.class, 255)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e67) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e67.toString()); BA.debugLineNum = 98;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(2);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 100;BA.debugLine="End Sub";
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
public static RemoteObject  _udp_packetarrived(RemoteObject _packet) throws Exception{
try {
		Debug.PushSubsStack("UDP_PacketArrived (starter) ","starter",1,starter.processBA,starter.mostCurrent,102);
if (RapidSub.canDelegate("udp_packetarrived")) return starter.remoteMe.runUserSub(false, "starter","udp_packetarrived", _packet);
RemoteObject _result = RemoteObject.createImmutable("");
RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _mapar = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 102;BA.debugLine="Sub UDP_PacketArrived (Packet As UDPPacket)";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 104;BA.debugLine="Dim result As String = BytesToString(Packet.Da";
Debug.ShouldStop(128);
_result = starter.mostCurrent.__c.runMethod(true,"BytesToString",(Object)(_packet.runMethod(false,"getData")),(Object)(_packet.runMethod(true,"getOffset")),(Object)(_packet.runMethod(true,"getLength")),(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 105;BA.debugLine="result=result.Replace(Chr(0),\"\")";
Debug.ShouldStop(256);
_result = _result.runMethod(true,"replace",(Object)(BA.ObjectToString(starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0))))),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("result", _result);
 BA.debugLineNum = 106;BA.debugLine="result=result.Replace(\"}{\",\",\")";
Debug.ShouldStop(512);
_result = _result.runMethod(true,"replace",(Object)(BA.ObjectToString("}{")),(Object)(RemoteObject.createImmutable(",")));Debug.locals.put("result", _result);
 BA.debugLineNum = 107;BA.debugLine="Dim JSON As JSONParser";
Debug.ShouldStop(1024);
_json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("JSON", _json);
 BA.debugLineNum = 108;BA.debugLine="Dim Mapar As Map";
Debug.ShouldStop(2048);
_mapar = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Mapar", _mapar);
 BA.debugLineNum = 109;BA.debugLine="JSON.Initialize(result)";
Debug.ShouldStop(4096);
_json.runVoidMethod ("Initialize",(Object)(_result));
 BA.debugLineNum = 110;BA.debugLine="Mapar = JSON.NextObject";
Debug.ShouldStop(8192);
_mapar = _json.runMethod(false,"NextObject");Debug.locals.put("Mapar", _mapar);
 BA.debugLineNum = 111;BA.debugLine="If Mapar.ContainsKey(\"rssi\")=True Then   CallSubD";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("rssi")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_ris")),(Object)((_mapar)));};
 BA.debugLineNum = 112;BA.debugLine="If Mapar.ContainsKey(\"namedev\")=True Then CallSub";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("namedev")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed3",starter.processBA,(Object)((starter.mostCurrent._sel_dev.getObject())),(Object)(BA.ObjectToString("add_dev_tolist")),(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("namedev"))))),(Object)((_packet.runMethod(true,"getHostAddress"))));};
 BA.debugLineNum = 113;BA.debugLine="If Mapar.ContainsKey(\"ssid_ap\")=True Then CallSub";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("ssid_ap")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._ap_set.getObject())),(Object)(BA.ObjectToString("set_ap_set")),(Object)((_mapar)));};
 BA.debugLineNum = 114;BA.debugLine="If Mapar.ContainsKey(\"ssid_sta\")=True Then CallSu";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("ssid_sta")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._sta_set.getObject())),(Object)(BA.ObjectToString("set_sta_set")),(Object)((_mapar)));};
 BA.debugLineNum = 115;BA.debugLine="If Mapar.ContainsKey(\"key_id\")=True Then set_key_";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("key_id")))),starter.mostCurrent.__c.getField(true,"True"))) { 
_set_key_set(_mapar);};
 BA.debugLineNum = 116;BA.debugLine="If Mapar.ContainsKey(\"font_size\")=True Then set_k";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("font_size")))),starter.mostCurrent.__c.getField(true,"True"))) { 
_set_keyinfo_set(_mapar);};
 BA.debugLineNum = 118;BA.debugLine="If Mapar.ContainsKey(\"save_ok\")=True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("save_ok")))),starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 119;BA.debugLine="ToastMessageShow (\"Saved\",False)";
Debug.ShouldStop(4194304);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Saved")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 120;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=1) Then";
Debug.ShouldStop(8388608);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 121;BA.debugLine="CallSubDelayed(AP_SET,\"finish_him\")";
Debug.ShouldStop(16777216);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._ap_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 BA.debugLineNum = 123;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=2) Then";
Debug.ShouldStop(67108864);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 124;BA.debugLine="CallSubDelayed(STA_SET,\"finish_him\")";
Debug.ShouldStop(134217728);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._sta_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 BA.debugLineNum = 126;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=3) Then";
Debug.ShouldStop(536870912);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 127;BA.debugLine="CallSubDelayed(KEY_SET,\"finish_him\")";
Debug.ShouldStop(1073741824);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._key_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 BA.debugLineNum = 128;BA.debugLine="CallSubDelayed(sel_dev,\"load_keys\")";
Debug.ShouldStop(-2147483648);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._sel_dev.getObject())),(Object)(RemoteObject.createImmutable("load_keys")));
 };
 BA.debugLineNum = 130;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=4) Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 131;BA.debugLine="CallSubDelayed(INET_SET,\"finish_him\")";
Debug.ShouldStop(4);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._inet_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e102) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e102.toString()); BA.debugLineNum = 135;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(64);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 137;BA.debugLine="End Sub";
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
}