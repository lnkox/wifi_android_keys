package lnk.wifi_keys;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends android.app.Service {
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "lnk.wifi_keys", "lnk.wifi_keys.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        processBA.setActivityPaused(false);
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "lnk.wifi_keys.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            BA.LogInfo("** Service (starter) Create **");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			if (ServiceHelper.StarterHelper.waitForLayout != null)
				BA.handler.post(ServiceHelper.StarterHelper.waitForLayout);
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA))
			handleStart(intent);
		else {
			ServiceHelper.StarterHelper.waitForLayout = new Runnable() {
				public void run() {
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
				}
			};
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = new anywheresoftware.b4a.objects.IntentWrapper();
    			if (intent != null) {
    				if (intent.hasExtra("b4a_internal_intent"))
    					iw.setObject((android.content.Intent) intent.getParcelableExtra("b4a_internal_intent"));
    				else
    					iw.setObject(intent);
    			}
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}
	@Override
	public void onDestroy() {
        BA.LogInfo("** Service (starter) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.SocketWrapper.UDPSocket _udpsocket = null;
public static com.visualnet.mqtt _objmqtt = null;
public static anywheresoftware.b4a.phone.Phone _objphone = null;
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 28;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return false;
}
public static String  _mqtt_connect() throws Exception{
String _strbroker = "";
String _strusername = "";
String _strpassword = "";
boolean _bret = false;
 //BA.debugLineNum = 51;BA.debugLine="Sub mqtt_connect()";
 //BA.debugLineNum = 52;BA.debugLine="Try";
try { //BA.debugLineNum = 53;BA.debugLine="Dim strBroker As String = \"tcp://\" & StateManager";
_strbroker = "tcp://"+mostCurrent._statemanager._getsetting2(processBA,"inet_server","MQTT server")+":"+mostCurrent._statemanager._getsetting2(processBA,"inet_port","1234");
 //BA.debugLineNum = 54;BA.debugLine="Dim strUsername As String  = StateManager.GetSett";
_strusername = mostCurrent._statemanager._getsetting2(processBA,"inet_login","MQTT login");
 //BA.debugLineNum = 55;BA.debugLine="Dim strPassword As String  = StateManager.GetSett";
_strpassword = mostCurrent._statemanager._getsetting2(processBA,"inet_pass","MQTT pass");
 //BA.debugLineNum = 56;BA.debugLine="ToastMessageShow(\"Connecting to \" & strBroker,Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Connecting to "+_strbroker,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 58;BA.debugLine="Dim bRet As Boolean = objMqtt.Connect(strBroker,\"";
_bret = _objmqtt.Connect(processBA,_strbroker,"",_strusername,_strpassword);
 //BA.debugLineNum = 59;BA.debugLine="If bRet=False Then";
if (_bret==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 60;BA.debugLine="ToastMessageShow(\"MQTT error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT error",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 61;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 };
 } 
       catch (Exception e42) {
			processBA.setLastException(e42); //BA.debugLineNum = 64;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_disconnect() throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Sub mqtt_disconnect()";
 //BA.debugLineNum = 44;BA.debugLine="Try";
try { //BA.debugLineNum = 45;BA.debugLine="objMqtt.Disconnect";
_objmqtt.Disconnect(processBA);
 } 
       catch (Exception e27) {
			processBA.setLastException(e27); //BA.debugLineNum = 47;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_init() throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Sub mqtt_init()";
 //BA.debugLineNum = 38;BA.debugLine="objMqtt.JavaDebug = True";
_objmqtt.JavaDebug = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 39;BA.debugLine="objMqtt.CleanSession = True";
_objmqtt.CleanSession = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 40;BA.debugLine="objMqtt.Initialize(\"oMqtt\")";
_objmqtt.Initialize(processBA,"oMqtt");
 //BA.debugLineNum = 41;BA.debugLine="objMqtt.KeepAliveInterval =3";
_objmqtt.KeepAliveInterval = (int) (3);
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_connectionlost() throws Exception{
 //BA.debugLineNum = 71;BA.debugLine="Sub oMqtt_connectionLost()";
 //BA.debugLineNum = 72;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 73;BA.debugLine="ToastMessageShow(\"MQTT connect error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT connect error",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 74;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_deliverycomplete(String _token) throws Exception{
 //BA.debugLineNum = 92;BA.debugLine="Sub oMqtt_deliverycomplete(Token As String)";
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_messagearrived(String _topic,String _message) throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub oMqtt_messageArrived(Topic As String, Message";
 //BA.debugLineNum = 90;BA.debugLine="proces_json(Message,\"MQTT\")";
_proces_json(_message,"MQTT");
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_onconnect(boolean _status) throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Sub oMqtt_onConnect(Status As Boolean)";
 //BA.debugLineNum = 76;BA.debugLine="If Status=False Then";
if (_status==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 77;BA.debugLine="ToastMessageShow(\"MQTT connect error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT connect error",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 78;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 }else {
 //BA.debugLineNum = 80;BA.debugLine="ToastMessageShow(\"MQTT is connected\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT is connected",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 81;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",True)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.True));
 //BA.debugLineNum = 82;BA.debugLine="objMqtt.Subscribe(\"wfkey\")";
_objmqtt.Subscribe(processBA,"wfkey");
 };
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_ondisconnect(boolean _status) throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub oMqtt_onDisconnect(Status As Boolean)";
 //BA.debugLineNum = 86;BA.debugLine="ToastMessageShow(\"MQTT disconnect\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT disconnect",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 87;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 //BA.debugLineNum = 88;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_oninitialized() throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Sub oMqtt_onInitialized()";
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
 //BA.debugLineNum = 220;BA.debugLine="Sub proces_error(msg As String)";
 //BA.debugLineNum = 221;BA.debugLine="ToastMessageShow(msg,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(_msg,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 222;BA.debugLine="End Sub";
return "";
}
public static String  _proces_json(String _result,String _host) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.Map _mapar = null;
String _tmpid = "";
 //BA.debugLineNum = 115;BA.debugLine="Sub proces_json(result As String,host As String)";
 //BA.debugLineNum = 116;BA.debugLine="result=result.Replace(Chr(0),\"\")";
_result = _result.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0))),"");
 //BA.debugLineNum = 117;BA.debugLine="result=result.Replace(\"}{\",\",\")";
_result = _result.replace("}{",",");
 //BA.debugLineNum = 118;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 119;BA.debugLine="Dim Mapar As Map";
_mapar = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 120;BA.debugLine="JSON.Initialize(result)";
_json.Initialize(_result);
 //BA.debugLineNum = 121;BA.debugLine="Mapar = JSON.NextObject";
_mapar = _json.NextObject();
 //BA.debugLineNum = 123;BA.debugLine="If Mapar.ContainsKey(\"yourid\")=False Then Return";
if (_mapar.ContainsKey((Object)("yourid"))==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 124;BA.debugLine="Dim tmpid As String=Mapar.Get(\"yourid\")";
_tmpid = BA.ObjectToString(_mapar.Get((Object)("yourid")));
 //BA.debugLineNum = 125;BA.debugLine="If tmpid.EqualsIgnoreCase(CM.myid)=False Then Ret";
if (_tmpid.equalsIgnoreCase(mostCurrent._cm._myid)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 127;BA.debugLine="If Mapar.ContainsKey(\"rssi\")=True Then   CallSubD";
if (_mapar.ContainsKey((Object)("rssi"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_ris",(Object)(_mapar));};
 //BA.debugLineNum = 128;BA.debugLine="If Mapar.ContainsKey(\"namedev\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("namedev"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(processBA,(Object)(mostCurrent._sel_dev.getObject()),"add_dev_tolist",_mapar.Get((Object)("namedev")),(Object)(_host));};
 //BA.debugLineNum = 129;BA.debugLine="If Mapar.ContainsKey(\"ssid_ap\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("ssid_ap"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._ap_set.getObject()),"set_ap_set",(Object)(_mapar));};
 //BA.debugLineNum = 130;BA.debugLine="If Mapar.ContainsKey(\"ssid_sta\")=True Then CallSu";
if (_mapar.ContainsKey((Object)("ssid_sta"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._sta_set.getObject()),"set_sta_set",(Object)(_mapar));};
 //BA.debugLineNum = 131;BA.debugLine="If Mapar.ContainsKey(\"key_id\")=True Then set_key_";
if (_mapar.ContainsKey((Object)("key_id"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_key_set(_mapar);};
 //BA.debugLineNum = 132;BA.debugLine="If Mapar.ContainsKey(\"font_size\")=True Then set_k";
if (_mapar.ContainsKey((Object)("font_size"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_keyinfo_set(_mapar);};
 //BA.debugLineNum = 134;BA.debugLine="If Mapar.ContainsKey(\"save_ok\")=True Then";
if (_mapar.ContainsKey((Object)("save_ok"))==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 135;BA.debugLine="ToastMessageShow (\"Saved\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Saved",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 136;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=1) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==1)) { 
 //BA.debugLineNum = 137;BA.debugLine="CallSubDelayed(AP_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._ap_set.getObject()),"finish_him");
 };
 //BA.debugLineNum = 139;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=2) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==2)) { 
 //BA.debugLineNum = 140;BA.debugLine="CallSubDelayed(STA_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sta_set.getObject()),"finish_him");
 };
 //BA.debugLineNum = 142;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=3) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==3)) { 
 //BA.debugLineNum = 143;BA.debugLine="CallSubDelayed(KEY_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._key_set.getObject()),"finish_him");
 //BA.debugLineNum = 144;BA.debugLine="CallSubDelayed(sel_dev,\"load_keys\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"load_keys");
 };
 //BA.debugLineNum = 146;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=4) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==4)) { 
 //BA.debugLineNum = 147;BA.debugLine="CallSubDelayed(INET_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._inet_set.getObject()),"finish_him");
 };
 };
 //BA.debugLineNum = 150;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim UDPSocket As UDPSocket";
_udpsocket = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket();
 //BA.debugLineNum = 10;BA.debugLine="Dim objMqtt As MQTT";
_objmqtt = new com.visualnet.mqtt();
 //BA.debugLineNum = 11;BA.debugLine="Dim objPhone As Phone";
_objphone = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public static boolean  _send_to_dev(anywheresoftware.b4a.objects.collections.Map _data) throws Exception{
String _msg = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
 //BA.debugLineNum = 180;BA.debugLine="Sub send_to_dev(data As Map) As Boolean ' Відправк";
 //BA.debugLineNum = 181;BA.debugLine="Dim msg As String";
_msg = "";
 //BA.debugLineNum = 182;BA.debugLine="Dim JSONGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
 //BA.debugLineNum = 183;BA.debugLine="data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
_data.Put((Object)("dev_name"),(Object)(mostCurrent._statemanager._getsetting2(processBA,"cur_dev_name","none")));
 //BA.debugLineNum = 184;BA.debugLine="data.Put (\"myid\",CM.myid)";
_data.Put((Object)("myid"),(Object)(mostCurrent._cm._myid));
 //BA.debugLineNum = 185;BA.debugLine="JSONGenerator.Initialize(data)";
_jsongenerator.Initialize(_data);
 //BA.debugLineNum = 186;BA.debugLine="msg = JSONGenerator.ToString";
_msg = _jsongenerator.ToString();
 //BA.debugLineNum = 187;BA.debugLine="If CM.connect_type=True Then";
if (mostCurrent._cm._connect_type==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 188;BA.debugLine="Return send_to_dev_mqtt(msg)";
if (true) return _send_to_dev_mqtt(_msg);
 }else {
 //BA.debugLineNum = 190;BA.debugLine="Return send_to_dev_udp(msg)";
if (true) return _send_to_dev_udp(_msg);
 };
 //BA.debugLineNum = 192;BA.debugLine="End Sub";
return false;
}
public static boolean  _send_to_dev_mqtt(String _msg) throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Sub send_to_dev_mqtt(msg As String) As Boolean ' В";
 //BA.debugLineNum = 195;BA.debugLine="Try";
try { //BA.debugLineNum = 196;BA.debugLine="If objMqtt.isConnected =False Then Return False";
if (_objmqtt.isConnected()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 197;BA.debugLine="objMqtt.Publish(\"wfkeyin\",msg,  objMqtt.QoS_Exact";
_objmqtt.Publish(processBA,"wfkeyin",_msg,_objmqtt.QoS_ExactlyOnce,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 198;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e166) {
			processBA.setLastException(e166); //BA.debugLineNum = 200;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 //BA.debugLineNum = 201;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 203;BA.debugLine="End Sub";
return false;
}
public static boolean  _send_to_dev_udp(String _msg) throws Exception{
anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet = null;
byte[] _buffer = null;
 //BA.debugLineNum = 205;BA.debugLine="Sub send_to_dev_udp(msg As String) As Boolean ' Ві";
 //BA.debugLineNum = 206;BA.debugLine="Try";
try { //BA.debugLineNum = 207;BA.debugLine="If UDPSocket.IsInitialized =False Then Return Fal";
if (_udpsocket.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
 //BA.debugLineNum = 208;BA.debugLine="Dim Packet As UDPPacket";
_packet = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket();
 //BA.debugLineNum = 209;BA.debugLine="Dim Buffer() As Byte";
_buffer = new byte[(int) (0)];
;
 //BA.debugLineNum = 210;BA.debugLine="Buffer = msg.GetBytes(\"UTF8\")";
_buffer = _msg.getBytes("UTF8");
 //BA.debugLineNum = 211;BA.debugLine="Packet.Initialize(Buffer, \"255.255.255.255\", \"";
_packet.Initialize(_buffer,"255.255.255.255",(int)(Double.parseDouble("2201")));
 //BA.debugLineNum = 212;BA.debugLine="UDPSocket.Send(Packet)";
_udpsocket.Send(_packet);
 //BA.debugLineNum = 213;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e180) {
			processBA.setLastException(e180); //BA.debugLineNum = 215;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 //BA.debugLineNum = 216;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return false;
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 20;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 21;BA.debugLine="udp_init ' ініціалізація UDP";
_udp_init();
 //BA.debugLineNum = 22;BA.debugLine="mqtt_init' ініціалізація MQTT";
_mqtt_init();
 //BA.debugLineNum = 23;BA.debugLine="CM.myid=objPhone.GetSettings(\"android_id\")";
mostCurrent._cm._myid = _objphone.GetSettings("android_id");
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _set_key_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Sub set_key_set (mapar As Map)";
 //BA.debugLineNum = 152;BA.debugLine="Try";
try { //BA.debugLineNum = 153;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))<1 Or CM.toint(m";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))<1 || mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))>30) { 
if (true) return "";};
 //BA.debugLineNum = 154;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))=30 Then";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))==30) { 
 //BA.debugLineNum = 155;BA.debugLine="ToastMessageShow(\"Load data complete\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Load data complete",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 156;BA.debugLine="CallSubDelayed(sel_dev,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"finish_him");
 };
 //BA.debugLineNum = 158;BA.debugLine="StateManager.SetSetting(\"keytext\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytext"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("name"))));
 //BA.debugLineNum = 159;BA.debugLine="If mapar.Get (\"name\") =\"@\" Then";
if ((_mapar.Get((Object)("name"))).equals((Object)("@"))) { 
 //BA.debugLineNum = 160;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),"");
 }else {
 //BA.debugLineNum = 162;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("key_id"))));
 };
 //BA.debugLineNum = 164;BA.debugLine="StateManager.SetSetting(\"keylock\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keylock"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(mostCurrent._cm._obj2bool(processBA,_mapar.Get((Object)("lock")))));
 //BA.debugLineNum = 165;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e134) {
			processBA.setLastException(e134); //BA.debugLineNum = 167;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public static String  _set_keyinfo_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
 //BA.debugLineNum = 170;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
 //BA.debugLineNum = 171;BA.debugLine="Try";
try { //BA.debugLineNum = 172;BA.debugLine="StateManager.SetSetting(\"font_size\", CM.toint(ma";
mostCurrent._statemanager._setsetting(processBA,"font_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("font_size"))))));
 //BA.debugLineNum = 173;BA.debugLine="StateManager.SetSetting(\"h_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"h_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("h_size"))))));
 //BA.debugLineNum = 174;BA.debugLine="StateManager.SetSetting(\"v_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"v_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("v_size"))))));
 //BA.debugLineNum = 175;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e144) {
			processBA.setLastException(e144); //BA.debugLineNum = 177;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
return "";
}
public static String  _udp_init() throws Exception{
 //BA.debugLineNum = 99;BA.debugLine="Sub udp_init()";
 //BA.debugLineNum = 100;BA.debugLine="Try";
try { //BA.debugLineNum = 101;BA.debugLine="UDPSocket.Initialize(\"UDP\", 1407,255)";
_udpsocket.Initialize(processBA,"UDP",(int) (1407),(int) (255));
 } 
       catch (Exception e74) {
			processBA.setLastException(e74); //BA.debugLineNum = 103;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _udp_packetarrived(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet) throws Exception{
String _result = "";
 //BA.debugLineNum = 107;BA.debugLine="Sub UDP_PacketArrived (Packet As UDPPacket)";
 //BA.debugLineNum = 108;BA.debugLine="Try";
try { //BA.debugLineNum = 109;BA.debugLine="Dim result As String = BytesToString(Packet.Da";
_result = anywheresoftware.b4a.keywords.Common.BytesToString(_packet.getData(),_packet.getOffset(),_packet.getLength(),"UTF8");
 //BA.debugLineNum = 110;BA.debugLine="proces_json(result,Packet.HostAddress)";
_proces_json(_result,_packet.getHostAddress());
 } 
       catch (Exception e82) {
			processBA.setLastException(e82); //BA.debugLineNum = 112;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
}
