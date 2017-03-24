package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class starter_subs_0 {


public static RemoteObject  _application_error(RemoteObject _error,RemoteObject _stacktrace) throws Exception{
try {
		Debug.PushSubsStack("Application_Error (starter) ","starter",1,starter.processBA,starter.mostCurrent,23);
if (RapidSub.canDelegate("application_error")) return starter.remoteMe.runUserSub(false, "starter","application_error", _error, _stacktrace);
Debug.locals.put("Error", _error);
Debug.locals.put("StackTrace", _stacktrace);
 BA.debugLineNum = 23;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 24;BA.debugLine="Return True";
Debug.ShouldStop(8388608);
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 25;BA.debugLine="End Sub";
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
public static RemoteObject  _proces_error(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("proces_error (starter) ","starter",1,starter.processBA,starter.mostCurrent,127);
if (RapidSub.canDelegate("proces_error")) return starter.remoteMe.runUserSub(false, "starter","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 127;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 128;BA.debugLine="Msgbox(msg,\"error\")";
Debug.ShouldStop(-2147483648);
starter.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(_msg),(Object)(RemoteObject.createImmutable("error")),starter.processBA);
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim UDPSocket As UDPSocket";
starter._udpsocket = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _send_to_dev(RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("send_to_dev (starter) ","starter",1,starter.processBA,starter.mostCurrent,108);
if (RapidSub.canDelegate("send_to_dev")) return starter.remoteMe.runUserSub(false, "starter","send_to_dev", _data);
RemoteObject _packet = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");
RemoteObject _buffer = null;
RemoteObject _msg = RemoteObject.createImmutable("");
RemoteObject _jsongenerator = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");
Debug.locals.put("data", _data);
 BA.debugLineNum = 108;BA.debugLine="Sub send_to_dev(data As Map) As Boolean ' Відправк";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="Try";
Debug.ShouldStop(4096);
try { BA.debugLineNum = 110;BA.debugLine="If UDPSocket.IsInitialized =False Then Return Fal";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",starter._udpsocket.runMethod(true,"IsInitialized"),starter.mostCurrent.__c.getField(true,"False"))) { 
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"False");};
 BA.debugLineNum = 111;BA.debugLine="Dim Packet As UDPPacket";
Debug.ShouldStop(16384);
_packet = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket");Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 112;BA.debugLine="Dim Buffer() As Byte";
Debug.ShouldStop(32768);
_buffer = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 113;BA.debugLine="Dim msg As String";
Debug.ShouldStop(65536);
_msg = RemoteObject.createImmutable("");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 114;BA.debugLine="Dim JSONGenerator As JSONGenerator";
Debug.ShouldStop(131072);
_jsongenerator = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator");Debug.locals.put("JSONGenerator", _jsongenerator);
 BA.debugLineNum = 115;BA.debugLine="data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
Debug.ShouldStop(262144);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("dev_name"))),(Object)((starter.mostCurrent._statemanager.runMethod(true,"_getsetting2",starter.processBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 116;BA.debugLine="JSONGenerator.Initialize(data)";
Debug.ShouldStop(524288);
_jsongenerator.runVoidMethod ("Initialize",(Object)(_data));
 BA.debugLineNum = 117;BA.debugLine="msg = JSONGenerator.ToString";
Debug.ShouldStop(1048576);
_msg = _jsongenerator.runMethod(true,"ToString");Debug.locals.put("msg", _msg);
 BA.debugLineNum = 118;BA.debugLine="Buffer = msg.GetBytes(\"UTF8\")";
Debug.ShouldStop(2097152);
_buffer = _msg.runMethod(false,"getBytes",(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 119;BA.debugLine="Packet.Initialize(Buffer, \"255.255.255.255\", \"";
Debug.ShouldStop(4194304);
_packet.runVoidMethod ("Initialize",(Object)(_buffer),(Object)(BA.ObjectToString("255.255.255.255")),(Object)(BA.numberCast(int.class, RemoteObject.createImmutable("2201"))));
 BA.debugLineNum = 120;BA.debugLine="UDPSocket.Send(Packet)";
Debug.ShouldStop(8388608);
starter._udpsocket.runVoidMethod ("Send",(Object)(_packet));
 BA.debugLineNum = 121;BA.debugLine="Return True";
Debug.ShouldStop(16777216);
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"True");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e100) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e100.toString()); BA.debugLineNum = 123;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(67108864);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 BA.debugLineNum = 124;BA.debugLine="Return False";
Debug.ShouldStop(134217728);
Debug.CheckDeviceExceptions();if (true) return starter.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 126;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("Service_Create (starter) ","starter",1,starter.processBA,starter.mostCurrent,12);
if (RapidSub.canDelegate("service_create")) return starter.remoteMe.runUserSub(false, "starter","service_create");
 BA.debugLineNum = 12;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(2048);
 BA.debugLineNum = 16;BA.debugLine="End Sub";
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
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (starter) ","starter",1,starter.processBA,starter.mostCurrent,27);
if (RapidSub.canDelegate("service_destroy")) return starter.remoteMe.runUserSub(false, "starter","service_destroy");
 BA.debugLineNum = 27;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
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
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (starter) ","starter",1,starter.processBA,starter.mostCurrent,18);
if (RapidSub.canDelegate("service_start")) return starter.remoteMe.runUserSub(false, "starter","service_start", _startingintent);
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 18;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 19;BA.debugLine="udp_init ' ініціалізація UDP";
Debug.ShouldStop(262144);
_udp_init();
 BA.debugLineNum = 20;BA.debugLine="End Sub";
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
public static RemoteObject  _set_key_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_key_set (starter) ","starter",1,starter.processBA,starter.mostCurrent,79);
if (RapidSub.canDelegate("set_key_set")) return starter.remoteMe.runUserSub(false, "starter","set_key_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 79;BA.debugLine="Sub set_key_set (mapar As Map)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 80;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 81;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))<1 Or CM.toint(m";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("<",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id"))))))),BA.numberCast(double.class, 1)) || RemoteObject.solveBoolean(">",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id"))))))),BA.numberCast(double.class, 30))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 82;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))=30 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id"))))))),BA.numberCast(double.class, 30))) { 
 BA.debugLineNum = 83;BA.debugLine="ToastMessageShow(\"Load data complete\",False)";
Debug.ShouldStop(262144);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Load data complete")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 84;BA.debugLine="CallSubDelayed(sel_dev,\"finish_him\")";
Debug.ShouldStop(524288);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._sel_dev.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 BA.debugLineNum = 86;BA.debugLine="StateManager.SetSetting(\"keytext\" & mapar.Get (\"";
Debug.ShouldStop(2097152);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytext"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))))));
 BA.debugLineNum = 87;BA.debugLine="If mapar.Get (\"name\") =\"@\" Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("name")))),RemoteObject.createImmutable(("@")))) { 
 BA.debugLineNum = 88;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
Debug.ShouldStop(8388608);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(RemoteObject.createImmutable("")));
 }else {
 BA.debugLineNum = 90;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
Debug.ShouldStop(33554432);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))));
 };
 BA.debugLineNum = 92;BA.debugLine="StateManager.SetSetting(\"keylock\" & mapar.Get (\"";
Debug.ShouldStop(134217728);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keylock"),_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("key_id")))))),(Object)(BA.ObjectToString(starter.mostCurrent._cm.runMethod(true,"_obj2bool",starter.processBA,(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("lock")))))))));
 BA.debugLineNum = 93;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(268435456);
starter.mostCurrent._statemanager.runVoidMethod ("_savesettings",starter.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e72) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e72.toString()); BA.debugLineNum = 95;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(1073741824);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 97;BA.debugLine="End Sub";
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
public static RemoteObject  _set_keyinfo_set(RemoteObject _mapar) throws Exception{
try {
		Debug.PushSubsStack("set_keyinfo_set (starter) ","starter",1,starter.processBA,starter.mostCurrent,98);
if (RapidSub.canDelegate("set_keyinfo_set")) return starter.remoteMe.runUserSub(false, "starter","set_keyinfo_set", _mapar);
Debug.locals.put("mapar", _mapar);
 BA.debugLineNum = 98;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 100;BA.debugLine="StateManager.SetSetting(\"font_size\", CM.toint(ma";
Debug.ShouldStop(8);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("font_size")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("font_size"))))))))));
 BA.debugLineNum = 101;BA.debugLine="StateManager.SetSetting(\"h_size\", CM.toint(mapar";
Debug.ShouldStop(16);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("h_size")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("h_size"))))))))));
 BA.debugLineNum = 102;BA.debugLine="StateManager.SetSetting(\"v_size\", CM.toint(mapar";
Debug.ShouldStop(32);
starter.mostCurrent._statemanager.runVoidMethod ("_setsetting",starter.processBA,(Object)(BA.ObjectToString("v_size")),(Object)(BA.NumberToString(starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("v_size"))))))))));
 BA.debugLineNum = 103;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(64);
starter.mostCurrent._statemanager.runVoidMethod ("_savesettings",starter.processBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e82) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e82.toString()); BA.debugLineNum = 105;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(256);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 107;BA.debugLine="End Sub";
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
public static RemoteObject  _udp_init() throws Exception{
try {
		Debug.PushSubsStack("udp_init (starter) ","starter",1,starter.processBA,starter.mostCurrent,33);
if (RapidSub.canDelegate("udp_init")) return starter.remoteMe.runUserSub(false, "starter","udp_init");
 BA.debugLineNum = 33;BA.debugLine="Sub udp_init()";
Debug.ShouldStop(1);
 BA.debugLineNum = 34;BA.debugLine="Try";
Debug.ShouldStop(2);
try { BA.debugLineNum = 35;BA.debugLine="UDPSocket.Initialize(\"UDP\", 1407,255)";
Debug.ShouldStop(4);
starter._udpsocket.runVoidMethod ("Initialize",starter.processBA,(Object)(BA.ObjectToString("UDP")),(Object)(BA.numberCast(int.class, 1407)),(Object)(BA.numberCast(int.class, 255)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e17) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e17.toString()); BA.debugLineNum = 37;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(16);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 };
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
public static RemoteObject  _udp_packetarrived(RemoteObject _packet) throws Exception{
try {
		Debug.PushSubsStack("UDP_PacketArrived (starter) ","starter",1,starter.processBA,starter.mostCurrent,41);
if (RapidSub.canDelegate("udp_packetarrived")) return starter.remoteMe.runUserSub(false, "starter","udp_packetarrived", _packet);
RemoteObject _result = RemoteObject.createImmutable("");
RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _mapar = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("Packet", _packet);
 BA.debugLineNum = 41;BA.debugLine="Sub UDP_PacketArrived (Packet As UDPPacket)";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 43;BA.debugLine="Dim result As String = BytesToString(Packet.Da";
Debug.ShouldStop(1024);
_result = starter.mostCurrent.__c.runMethod(true,"BytesToString",(Object)(_packet.runMethod(false,"getData")),(Object)(_packet.runMethod(true,"getOffset")),(Object)(_packet.runMethod(true,"getLength")),(Object)(RemoteObject.createImmutable("UTF8")));Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 44;BA.debugLine="result=result.Replace(Chr(0),\"\")";
Debug.ShouldStop(2048);
_result = _result.runMethod(true,"replace",(Object)(BA.ObjectToString(starter.mostCurrent.__c.runMethod(true,"Chr",(Object)(BA.numberCast(int.class, 0))))),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("result", _result);
 BA.debugLineNum = 45;BA.debugLine="result=result.Replace(\"}{\",\",\")";
Debug.ShouldStop(4096);
_result = _result.runMethod(true,"replace",(Object)(BA.ObjectToString("}{")),(Object)(RemoteObject.createImmutable(",")));Debug.locals.put("result", _result);
 BA.debugLineNum = 46;BA.debugLine="Dim JSON As JSONParser";
Debug.ShouldStop(8192);
_json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("JSON", _json);
 BA.debugLineNum = 47;BA.debugLine="Dim Mapar As Map";
Debug.ShouldStop(16384);
_mapar = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Mapar", _mapar);
 BA.debugLineNum = 48;BA.debugLine="JSON.Initialize(result)";
Debug.ShouldStop(32768);
_json.runVoidMethod ("Initialize",(Object)(_result));
 BA.debugLineNum = 49;BA.debugLine="Mapar = JSON.NextObject";
Debug.ShouldStop(65536);
_mapar = _json.runMethod(false,"NextObject");Debug.locals.put("Mapar", _mapar);
 BA.debugLineNum = 50;BA.debugLine="If Mapar.ContainsKey(\"rssi\")=True Then   CallSubD";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("rssi")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("set_ris")),(Object)((starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("rssi"))))))))));};
 BA.debugLineNum = 51;BA.debugLine="If Mapar.ContainsKey(\"rcom\")=True Then   CallSubD";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("rcom")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._main.getObject())),(Object)(BA.ObjectToString("reload_key_state")),(Object)((_mapar)));};
 BA.debugLineNum = 52;BA.debugLine="If Mapar.ContainsKey(\"namedev\")=True Then CallSub";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("namedev")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed3",starter.processBA,(Object)((starter.mostCurrent._sel_dev.getObject())),(Object)(BA.ObjectToString("add_dev_tolist")),(Object)(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("namedev"))))),(Object)((_packet.runMethod(true,"getHostAddress"))));};
 BA.debugLineNum = 53;BA.debugLine="If Mapar.ContainsKey(\"ssid_ap\")=True Then CallSub";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("ssid_ap")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._ap_set.getObject())),(Object)(BA.ObjectToString("set_ap_set")),(Object)((_mapar)));};
 BA.debugLineNum = 54;BA.debugLine="If Mapar.ContainsKey(\"ssid_sta\")=True Then CallSu";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("ssid_sta")))),starter.mostCurrent.__c.getField(true,"True"))) { 
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",starter.processBA,(Object)((starter.mostCurrent._sta_set.getObject())),(Object)(BA.ObjectToString("set_sta_set")),(Object)((_mapar)));};
 BA.debugLineNum = 55;BA.debugLine="If Mapar.ContainsKey(\"key_id\")=True Then set_key_";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("key_id")))),starter.mostCurrent.__c.getField(true,"True"))) { 
_set_key_set(_mapar);};
 BA.debugLineNum = 56;BA.debugLine="If Mapar.ContainsKey(\"font_size\")=True Then set_k";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("font_size")))),starter.mostCurrent.__c.getField(true,"True"))) { 
_set_keyinfo_set(_mapar);};
 BA.debugLineNum = 58;BA.debugLine="If Mapar.ContainsKey(\"save_ok\")=True Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_mapar.runMethod(true,"ContainsKey",(Object)((RemoteObject.createImmutable("save_ok")))),starter.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 59;BA.debugLine="ToastMessageShow (\"Saved\",False)";
Debug.ShouldStop(67108864);
starter.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Saved")),(Object)(starter.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 60;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=1) Then";
Debug.ShouldStop(134217728);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 1)))) { 
 BA.debugLineNum = 61;BA.debugLine="CallSubDelayed(AP_SET,\"finish_him\")";
Debug.ShouldStop(268435456);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._ap_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 BA.debugLineNum = 63;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=2) Then";
Debug.ShouldStop(1073741824);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 2)))) { 
 BA.debugLineNum = 64;BA.debugLine="CallSubDelayed(STA_SET,\"finish_him\")";
Debug.ShouldStop(-2147483648);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._sta_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 BA.debugLineNum = 66;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=3) Then";
Debug.ShouldStop(2);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 3)))) { 
 BA.debugLineNum = 67;BA.debugLine="CallSubDelayed(KEY_SET,\"finish_him\")";
Debug.ShouldStop(4);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._key_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 BA.debugLineNum = 68;BA.debugLine="CallSubDelayed(sel_dev,\"load_keys\")";
Debug.ShouldStop(8);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._sel_dev.getObject())),(Object)(RemoteObject.createImmutable("load_keys")));
 };
 BA.debugLineNum = 70;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=4) Then";
Debug.ShouldStop(32);
if ((RemoteObject.solveBoolean("=",starter.mostCurrent._cm.runMethod(true,"_toint",starter.processBA,(Object)(BA.ObjectToString(_mapar.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("save_ok"))))))),BA.numberCast(double.class, 4)))) { 
 BA.debugLineNum = 71;BA.debugLine="CallSubDelayed(INET_SET,\"finish_him\")";
Debug.ShouldStop(64);
starter.mostCurrent.__c.runVoidMethod ("CallSubDelayed",starter.processBA,(Object)((starter.mostCurrent._inet_set.getObject())),(Object)(RemoteObject.createImmutable("finish_him")));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e53) {
			BA.rdebugUtils.runVoidMethod("setLastException",starter.processBA, e53.toString()); BA.debugLineNum = 75;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(1024);
_proces_error(starter.mostCurrent.__c.runMethod(false,"LastException",starter.processBA).runMethod(true,"getMessage"));
 };
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
}