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
		    processBA = new anywheresoftware.b4a.ShellBA(this, null, null, "lnk.wifi_keys", "lnk.wifi_keys.starter");
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
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("application_error"))
	return (Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace});
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="End Sub";
return false;
}
public static String  _mqtt_connect() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("mqtt_connect"))
	return (String) Debug.delegate(processBA, "mqtt_connect", null);
String _strbroker = "";
String _strusername = "";
String _strpassword = "";
boolean _bret = false;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub mqtt_connect()";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Dim strBroker As String = \"tcp://\" & StateManager";
_strbroker = "tcp://"+mostCurrent._statemanager._getsetting2(processBA,"inet_server","MQTT server")+":"+mostCurrent._statemanager._getsetting2(processBA,"inet_port","1234");
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="Dim strUsername As String  = StateManager.GetSett";
_strusername = mostCurrent._statemanager._getsetting2(processBA,"inet_login","MQTT login");
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Dim strPassword As String  = StateManager.GetSett";
_strpassword = mostCurrent._statemanager._getsetting2(processBA,"inet_pass","MQTT pass");
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="ToastMessageShow(\"Connecting to \" & strBroker,Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Connecting to "+_strbroker,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="Dim bRet As Boolean = objMqtt.Connect(strBroker,\"";
_bret = _objmqtt.Connect(processBA,_strbroker,"",_strusername,_strpassword);
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="If bRet=False Then";
if (_bret==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="ToastMessageShow(\"MQTT error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT error",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 };
 } 
       catch (Exception e32) {
			processBA.setLastException(e32);RDebugUtils.currentLine=1900557;
 //BA.debugLineNum = 1900557;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=1900559;
 //BA.debugLineNum = 1900559;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("proces_error"))
	return (String) Debug.delegate(processBA, "proces_error", new Object[] {_msg});
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub proces_error(msg As String)";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="ToastMessageShow(msg,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(_msg,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_init() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("mqtt_init"))
	return (String) Debug.delegate(processBA, "mqtt_init", null);
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub mqtt_init()";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="objMqtt.JavaDebug = True";
_objmqtt.JavaDebug = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="objMqtt.CleanSession = True";
_objmqtt.CleanSession = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="objMqtt.Initialize(\"oMqtt\")";
_objmqtt.Initialize(processBA,"oMqtt");
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_connectionlost() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_connectionlost"))
	return (String) Debug.delegate(processBA, "omqtt_connectionlost", null);
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub oMqtt_connectionLost()";
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_deliverycomplete(String _token) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_deliverycomplete"))
	return (String) Debug.delegate(processBA, "omqtt_deliverycomplete", new Object[] {_token});
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub oMqtt_deliverycomplete(Token As String)";
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_messagearrived(String _topic,String _message) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_messagearrived"))
	return (String) Debug.delegate(processBA, "omqtt_messagearrived", new Object[] {_topic,_message});
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub oMqtt_messageArrived(Topic As String, Message";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_onconnect(boolean _status) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_onconnect"))
	return (String) Debug.delegate(processBA, "omqtt_onconnect", new Object[] {_status});
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub oMqtt_onConnect(Status As Boolean)";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="If Status=False Then";
if (_status==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="ToastMessageShow(\"MQTT connect error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT connect error",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 }else {
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="ToastMessageShow(\"MQTT is connected\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT is connected",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",True)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.True));
 };
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_ondisconnect(boolean _status) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_ondisconnect"))
	return (String) Debug.delegate(processBA, "omqtt_ondisconnect", new Object[] {_status});
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub oMqtt_onDisconnect(Status As Boolean)";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_oninitialized() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_oninitialized"))
	return (String) Debug.delegate(processBA, "omqtt_oninitialized", null);
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub oMqtt_onInitialized()";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="End Sub";
return "";
}
public static boolean  _send_to_dev(anywheresoftware.b4a.objects.collections.Map _data) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("send_to_dev"))
	return (Boolean) Debug.delegate(processBA, "send_to_dev", new Object[] {_data});
anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet = null;
byte[] _buffer = null;
String _msg = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub send_to_dev(data As Map) As Boolean ' Відправк";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Try";
try {RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="If UDPSocket.IsInitialized =False Then Return Fal";
if (_udpsocket.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Dim Packet As UDPPacket";
_packet = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket();
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="Dim Buffer() As Byte";
_buffer = new byte[(int) (0)];
;
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="Dim msg As String";
_msg = "";
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="Dim JSONGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
_data.Put((Object)("dev_name"),(Object)(mostCurrent._statemanager._getsetting2(processBA,"cur_dev_name","none")));
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="JSONGenerator.Initialize(data)";
_jsongenerator.Initialize(_data);
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="msg = JSONGenerator.ToString";
_msg = _jsongenerator.ToString();
RDebugUtils.currentLine=2621450;
 //BA.debugLineNum = 2621450;BA.debugLine="Buffer = msg.GetBytes(\"UTF8\")";
_buffer = _msg.getBytes("UTF8");
RDebugUtils.currentLine=2621451;
 //BA.debugLineNum = 2621451;BA.debugLine="Packet.Initialize(Buffer, \"255.255.255.255\", \"";
_packet.Initialize(_buffer,"255.255.255.255",(int)(Double.parseDouble("2201")));
RDebugUtils.currentLine=2621452;
 //BA.debugLineNum = 2621452;BA.debugLine="UDPSocket.Send(Packet)";
_udpsocket.Send(_packet);
RDebugUtils.currentLine=2621453;
 //BA.debugLineNum = 2621453;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e142) {
			processBA.setLastException(e142);RDebugUtils.currentLine=2621455;
 //BA.debugLineNum = 2621455;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=2621458;
 //BA.debugLineNum = 2621458;BA.debugLine="End Sub";
return false;
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="udp_init ' ініціалізація UDP";
_udp_init();
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="mqtt_init' ініціалізація MQTT";
_mqtt_init();
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="End Sub";
return "";
}
public static String  _udp_init() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("udp_init"))
	return (String) Debug.delegate(processBA, "udp_init", null);
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub udp_init()";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Try";
try {RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="UDPSocket.Initialize(\"UDP\", 1407,255)";
_udpsocket.Initialize(processBA,"UDP",(int) (1407),(int) (255));
 } 
       catch (Exception e60) {
			processBA.setLastException(e60);RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="End Sub";
return "";
}
public static String  _set_key_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("set_key_set"))
	return (String) Debug.delegate(processBA, "set_key_set", new Object[] {_mapar});
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub set_key_set (mapar As Map)";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Try";
try {RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))<1 Or CM.toint(m";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))<1 || mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))>30) { 
if (true) return "";};
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))=30 Then";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))==30) { 
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="ToastMessageShow(\"Load data complete\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Load data complete",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="CallSubDelayed(sel_dev,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"finish_him");
 };
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="StateManager.SetSetting(\"keytext\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytext"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("name"))));
RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="If mapar.Get (\"name\") =\"@\" Then";
if ((_mapar.Get((Object)("name"))).equals((Object)("@"))) { 
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),"");
 }else {
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("key_id"))));
 };
RDebugUtils.currentLine=2490381;
 //BA.debugLineNum = 2490381;BA.debugLine="StateManager.SetSetting(\"keylock\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keylock"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(mostCurrent._cm._obj2bool(processBA,_mapar.Get((Object)("lock")))));
RDebugUtils.currentLine=2490382;
 //BA.debugLineNum = 2490382;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e114) {
			processBA.setLastException(e114);RDebugUtils.currentLine=2490384;
 //BA.debugLineNum = 2490384;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=2490386;
 //BA.debugLineNum = 2490386;BA.debugLine="End Sub";
return "";
}
public static String  _set_keyinfo_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("set_keyinfo_set"))
	return (String) Debug.delegate(processBA, "set_keyinfo_set", new Object[] {_mapar});
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Try";
try {RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="StateManager.SetSetting(\"font_size\", CM.toint(ma";
mostCurrent._statemanager._setsetting(processBA,"font_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("font_size"))))));
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="StateManager.SetSetting(\"h_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"h_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("h_size"))))));
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="StateManager.SetSetting(\"v_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"v_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("v_size"))))));
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e124) {
			processBA.setLastException(e124);RDebugUtils.currentLine=2555911;
 //BA.debugLineNum = 2555911;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="End Sub";
return "";
}
public static String  _udp_packetarrived(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("udp_packetarrived"))
	return (String) Debug.delegate(processBA, "udp_packetarrived", new Object[] {_packet});
String _result = "";
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.Map _mapar = null;
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub UDP_PacketArrived (Packet As UDPPacket)";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Try";
try {RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Dim result As String = BytesToString(Packet.Da";
_result = anywheresoftware.b4a.keywords.Common.BytesToString(_packet.getData(),_packet.getOffset(),_packet.getLength(),"UTF8");
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="result=result.Replace(Chr(0),\"\")";
_result = _result.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0))),"");
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="result=result.Replace(\"}{\",\",\")";
_result = _result.replace("}{",",");
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=2424838;
 //BA.debugLineNum = 2424838;BA.debugLine="Dim Mapar As Map";
_mapar = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2424839;
 //BA.debugLineNum = 2424839;BA.debugLine="JSON.Initialize(result)";
_json.Initialize(_result);
RDebugUtils.currentLine=2424840;
 //BA.debugLineNum = 2424840;BA.debugLine="Mapar = JSON.NextObject";
_mapar = _json.NextObject();
RDebugUtils.currentLine=2424841;
 //BA.debugLineNum = 2424841;BA.debugLine="If Mapar.ContainsKey(\"rssi\")=True Then   CallSubD";
if (_mapar.ContainsKey((Object)("rssi"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_ris",(Object)(_mapar));};
RDebugUtils.currentLine=2424842;
 //BA.debugLineNum = 2424842;BA.debugLine="If Mapar.ContainsKey(\"namedev\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("namedev"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(processBA,(Object)(mostCurrent._sel_dev.getObject()),"add_dev_tolist",_mapar.Get((Object)("namedev")),(Object)(_packet.getHostAddress()));};
RDebugUtils.currentLine=2424843;
 //BA.debugLineNum = 2424843;BA.debugLine="If Mapar.ContainsKey(\"ssid_ap\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("ssid_ap"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._ap_set.getObject()),"set_ap_set",(Object)(_mapar));};
RDebugUtils.currentLine=2424844;
 //BA.debugLineNum = 2424844;BA.debugLine="If Mapar.ContainsKey(\"ssid_sta\")=True Then CallSu";
if (_mapar.ContainsKey((Object)("ssid_sta"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._sta_set.getObject()),"set_sta_set",(Object)(_mapar));};
RDebugUtils.currentLine=2424845;
 //BA.debugLineNum = 2424845;BA.debugLine="If Mapar.ContainsKey(\"key_id\")=True Then set_key_";
if (_mapar.ContainsKey((Object)("key_id"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_key_set(_mapar);};
RDebugUtils.currentLine=2424846;
 //BA.debugLineNum = 2424846;BA.debugLine="If Mapar.ContainsKey(\"font_size\")=True Then set_k";
if (_mapar.ContainsKey((Object)("font_size"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_keyinfo_set(_mapar);};
RDebugUtils.currentLine=2424848;
 //BA.debugLineNum = 2424848;BA.debugLine="If Mapar.ContainsKey(\"save_ok\")=True Then";
if (_mapar.ContainsKey((Object)("save_ok"))==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2424849;
 //BA.debugLineNum = 2424849;BA.debugLine="ToastMessageShow (\"Saved\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Saved",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2424850;
 //BA.debugLineNum = 2424850;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=1) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==1)) { 
RDebugUtils.currentLine=2424851;
 //BA.debugLineNum = 2424851;BA.debugLine="CallSubDelayed(AP_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._ap_set.getObject()),"finish_him");
 };
RDebugUtils.currentLine=2424853;
 //BA.debugLineNum = 2424853;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=2) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==2)) { 
RDebugUtils.currentLine=2424854;
 //BA.debugLineNum = 2424854;BA.debugLine="CallSubDelayed(STA_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sta_set.getObject()),"finish_him");
 };
RDebugUtils.currentLine=2424856;
 //BA.debugLineNum = 2424856;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=3) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==3)) { 
RDebugUtils.currentLine=2424857;
 //BA.debugLineNum = 2424857;BA.debugLine="CallSubDelayed(KEY_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._key_set.getObject()),"finish_him");
RDebugUtils.currentLine=2424858;
 //BA.debugLineNum = 2424858;BA.debugLine="CallSubDelayed(sel_dev,\"load_keys\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"load_keys");
 };
RDebugUtils.currentLine=2424860;
 //BA.debugLineNum = 2424860;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=4) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==4)) { 
RDebugUtils.currentLine=2424861;
 //BA.debugLineNum = 2424861;BA.debugLine="CallSubDelayed(INET_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._inet_set.getObject()),"finish_him");
 };
 };
 } 
       catch (Exception e95) {
			processBA.setLastException(e95);RDebugUtils.currentLine=2424865;
 //BA.debugLineNum = 2424865;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=2424867;
 //BA.debugLineNum = 2424867;BA.debugLine="End Sub";
return "";
}
}