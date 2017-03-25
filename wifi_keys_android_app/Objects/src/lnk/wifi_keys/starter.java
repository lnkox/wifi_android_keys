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
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("application_error"))
	return (Boolean) Debug.delegate(processBA, "application_error", new Object[] {_error,_stacktrace});
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub mqtt_connect()";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Try";
try {RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Dim strBroker As String = \"tcp://\" & StateManager";
_strbroker = "tcp://"+mostCurrent._statemanager._getsetting2(processBA,"inet_server","MQTT server")+":"+mostCurrent._statemanager._getsetting2(processBA,"inet_port","1234");
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="Dim strUsername As String  = StateManager.GetSett";
_strusername = mostCurrent._statemanager._getsetting2(processBA,"inet_login","MQTT login");
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="Dim strPassword As String  = StateManager.GetSett";
_strpassword = mostCurrent._statemanager._getsetting2(processBA,"inet_pass","MQTT pass");
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="ToastMessageShow(\"Connecting to \" & strBroker,Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Connecting to "+_strbroker,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="Dim bRet As Boolean = objMqtt.Connect(strBroker,\"";
_bret = _objmqtt.Connect(processBA,_strbroker,"",_strusername,_strpassword);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="If bRet=False Then";
if (_bret==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="ToastMessageShow(\"MQTT error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT error",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 };
 } 
       catch (Exception e41) {
			processBA.setLastException(e41);RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=786447;
 //BA.debugLineNum = 786447;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("proces_error"))
	return (String) Debug.delegate(processBA, "proces_error", new Object[] {_msg});
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub proces_error(msg As String)";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="ToastMessageShow(msg,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(_msg,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_disconnect() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("mqtt_disconnect"))
	return (String) Debug.delegate(processBA, "mqtt_disconnect", null);
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub mqtt_disconnect()";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Try";
try {RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="objMqtt.Disconnect";
_objmqtt.Disconnect(processBA);
 } 
       catch (Exception e26) {
			processBA.setLastException(e26);RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_init() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("mqtt_init"))
	return (String) Debug.delegate(processBA, "mqtt_init", null);
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub mqtt_init()";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="objMqtt.JavaDebug = True";
_objmqtt.JavaDebug = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="objMqtt.CleanSession = True";
_objmqtt.CleanSession = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="objMqtt.Initialize(\"oMqtt\")";
_objmqtt.Initialize(processBA,"oMqtt");
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_connectionlost() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_connectionlost"))
	return (String) Debug.delegate(processBA, "omqtt_connectionlost", null);
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub oMqtt_connectionLost()";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_deliverycomplete(String _token) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_deliverycomplete"))
	return (String) Debug.delegate(processBA, "omqtt_deliverycomplete", new Object[] {_token});
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub oMqtt_deliverycomplete(Token As String)";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_messagearrived(String _topic,String _message) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_messagearrived"))
	return (String) Debug.delegate(processBA, "omqtt_messagearrived", new Object[] {_topic,_message});
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub oMqtt_messageArrived(Topic As String, Message";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="proces_json(Message,\"MQTT\")";
_proces_json(_message,"MQTT");
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _proces_json(String _result,String _host) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("proces_json"))
	return (String) Debug.delegate(processBA, "proces_json", new Object[] {_result,_host});
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.Map _mapar = null;
String _tmpid = "";
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub proces_json(result As String,host As String)";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="result=result.Replace(Chr(0),\"\")";
_result = _result.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0))),"");
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="result=result.Replace(\"}{\",\",\")";
_result = _result.replace("}{",",");
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="Dim Mapar As Map";
_mapar = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="JSON.Initialize(result)";
_json.Initialize(_result);
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="Mapar = JSON.NextObject";
_mapar = _json.NextObject();
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="If Mapar.ContainsKey(\"yourid\")=False Then Return";
if (_mapar.ContainsKey((Object)("yourid"))==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=1376265;
 //BA.debugLineNum = 1376265;BA.debugLine="Dim tmpid As String=Mapar.Get(\"yourid\")";
_tmpid = BA.ObjectToString(_mapar.Get((Object)("yourid")));
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="If tmpid.EqualsIgnoreCase(CM.myid)=False Then Ret";
if (_tmpid.equalsIgnoreCase(mostCurrent._cm._myid)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=1376268;
 //BA.debugLineNum = 1376268;BA.debugLine="If Mapar.ContainsKey(\"rssi\")=True Then   CallSubD";
if (_mapar.ContainsKey((Object)("rssi"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_ris",(Object)(_mapar));};
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="If Mapar.ContainsKey(\"namedev\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("namedev"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(processBA,(Object)(mostCurrent._sel_dev.getObject()),"add_dev_tolist",_mapar.Get((Object)("namedev")),(Object)(_host));};
RDebugUtils.currentLine=1376270;
 //BA.debugLineNum = 1376270;BA.debugLine="If Mapar.ContainsKey(\"ssid_ap\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("ssid_ap"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._ap_set.getObject()),"set_ap_set",(Object)(_mapar));};
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="If Mapar.ContainsKey(\"ssid_sta\")=True Then CallSu";
if (_mapar.ContainsKey((Object)("ssid_sta"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._sta_set.getObject()),"set_sta_set",(Object)(_mapar));};
RDebugUtils.currentLine=1376272;
 //BA.debugLineNum = 1376272;BA.debugLine="If Mapar.ContainsKey(\"key_id\")=True Then set_key_";
if (_mapar.ContainsKey((Object)("key_id"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_key_set(_mapar);};
RDebugUtils.currentLine=1376273;
 //BA.debugLineNum = 1376273;BA.debugLine="If Mapar.ContainsKey(\"font_size\")=True Then set_k";
if (_mapar.ContainsKey((Object)("font_size"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_keyinfo_set(_mapar);};
RDebugUtils.currentLine=1376275;
 //BA.debugLineNum = 1376275;BA.debugLine="If Mapar.ContainsKey(\"save_ok\")=True Then";
if (_mapar.ContainsKey((Object)("save_ok"))==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1376276;
 //BA.debugLineNum = 1376276;BA.debugLine="ToastMessageShow (\"Saved\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Saved",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1376277;
 //BA.debugLineNum = 1376277;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=1) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==1)) { 
RDebugUtils.currentLine=1376278;
 //BA.debugLineNum = 1376278;BA.debugLine="CallSubDelayed(AP_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._ap_set.getObject()),"finish_him");
 };
RDebugUtils.currentLine=1376280;
 //BA.debugLineNum = 1376280;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=2) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==2)) { 
RDebugUtils.currentLine=1376281;
 //BA.debugLineNum = 1376281;BA.debugLine="CallSubDelayed(STA_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sta_set.getObject()),"finish_him");
 };
RDebugUtils.currentLine=1376283;
 //BA.debugLineNum = 1376283;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=3) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==3)) { 
RDebugUtils.currentLine=1376284;
 //BA.debugLineNum = 1376284;BA.debugLine="CallSubDelayed(KEY_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._key_set.getObject()),"finish_him");
RDebugUtils.currentLine=1376285;
 //BA.debugLineNum = 1376285;BA.debugLine="CallSubDelayed(sel_dev,\"load_keys\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"load_keys");
 };
RDebugUtils.currentLine=1376287;
 //BA.debugLineNum = 1376287;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=4) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==4)) { 
RDebugUtils.currentLine=1376288;
 //BA.debugLineNum = 1376288;BA.debugLine="CallSubDelayed(INET_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._inet_set.getObject()),"finish_him");
 };
 };
RDebugUtils.currentLine=1376291;
 //BA.debugLineNum = 1376291;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_onconnect(boolean _status) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_onconnect"))
	return (String) Debug.delegate(processBA, "omqtt_onconnect", new Object[] {_status});
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub oMqtt_onConnect(Status As Boolean)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="If Status=False Then";
if (_status==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="ToastMessageShow(\"MQTT connect error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT connect error",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 }else {
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="ToastMessageShow(\"MQTT is connected\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT is connected",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",True)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.True));
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="objMqtt.Subscribe(\"wfkey\")";
_objmqtt.Subscribe(processBA,"wfkey");
 };
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_ondisconnect(boolean _status) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_ondisconnect"))
	return (String) Debug.delegate(processBA, "omqtt_ondisconnect", new Object[] {_status});
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub oMqtt_onDisconnect(Status As Boolean)";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="ToastMessageShow(\"MQTT disconnect\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT disconnect",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_oninitialized() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_oninitialized"))
	return (String) Debug.delegate(processBA, "omqtt_oninitialized", null);
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub oMqtt_onInitialized()";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="End Sub";
return "";
}
public static String  _set_key_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("set_key_set"))
	return (String) Debug.delegate(processBA, "set_key_set", new Object[] {_mapar});
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub set_key_set (mapar As Map)";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Try";
try {RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))<1 Or CM.toint(m";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))<1 || mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))>30) { 
if (true) return "";};
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))=30 Then";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))==30) { 
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="ToastMessageShow(\"Load data complete\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Load data complete",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="CallSubDelayed(sel_dev,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"finish_him");
 };
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="StateManager.SetSetting(\"keytext\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytext"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("name"))));
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="If mapar.Get (\"name\") =\"@\" Then";
if ((_mapar.Get((Object)("name"))).equals((Object)("@"))) { 
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),"");
 }else {
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("key_id"))));
 };
RDebugUtils.currentLine=1441805;
 //BA.debugLineNum = 1441805;BA.debugLine="StateManager.SetSetting(\"keylock\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keylock"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(mostCurrent._cm._obj2bool(processBA,_mapar.Get((Object)("lock")))));
RDebugUtils.currentLine=1441806;
 //BA.debugLineNum = 1441806;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e132) {
			processBA.setLastException(e132);RDebugUtils.currentLine=1441808;
 //BA.debugLineNum = 1441808;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=1441810;
 //BA.debugLineNum = 1441810;BA.debugLine="End Sub";
return "";
}
public static String  _set_keyinfo_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("set_keyinfo_set"))
	return (String) Debug.delegate(processBA, "set_keyinfo_set", new Object[] {_mapar});
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Try";
try {RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="StateManager.SetSetting(\"font_size\", CM.toint(ma";
mostCurrent._statemanager._setsetting(processBA,"font_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("font_size"))))));
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="StateManager.SetSetting(\"h_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"h_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("h_size"))))));
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="StateManager.SetSetting(\"v_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"v_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("v_size"))))));
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e142) {
			processBA.setLastException(e142);RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=1507337;
 //BA.debugLineNum = 1507337;BA.debugLine="End Sub";
return "";
}
public static boolean  _send_to_dev(anywheresoftware.b4a.objects.collections.Map _data) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("send_to_dev"))
	return (Boolean) Debug.delegate(processBA, "send_to_dev", new Object[] {_data});
String _msg = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub send_to_dev(data As Map) As Boolean ' Відправк";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Dim msg As String";
_msg = "";
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Dim JSONGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
_data.Put((Object)("dev_name"),(Object)(mostCurrent._statemanager._getsetting2(processBA,"cur_dev_name","none")));
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="data.Put (\"myid\",CM.myid)";
_data.Put((Object)("myid"),(Object)(mostCurrent._cm._myid));
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="JSONGenerator.Initialize(data)";
_jsongenerator.Initialize(_data);
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="msg = JSONGenerator.ToString";
_msg = _jsongenerator.ToString();
RDebugUtils.currentLine=1572871;
 //BA.debugLineNum = 1572871;BA.debugLine="If CM.connect_type=True Then";
if (mostCurrent._cm._connect_type==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="Return send_to_dev_mqtt(msg)";
if (true) return _send_to_dev_mqtt(_msg);
 }else {
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="Return send_to_dev_udp(msg)";
if (true) return _send_to_dev_udp(_msg);
 };
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="End Sub";
return false;
}
public static boolean  _send_to_dev_mqtt(String _msg) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("send_to_dev_mqtt"))
	return (Boolean) Debug.delegate(processBA, "send_to_dev_mqtt", new Object[] {_msg});
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub send_to_dev_mqtt(msg As String) As Boolean ' В";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Try";
try {RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="If objMqtt.isConnected =False Then Return False";
if (_objmqtt.isConnected()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="objMqtt.Publish(\"wfkeyin\",msg,  objMqtt.QoS_Exact";
_objmqtt.Publish(processBA,"wfkeyin",_msg,_objmqtt.QoS_ExactlyOnce,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e164) {
			processBA.setLastException(e164);RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="End Sub";
return false;
}
public static boolean  _send_to_dev_udp(String _msg) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("send_to_dev_udp"))
	return (Boolean) Debug.delegate(processBA, "send_to_dev_udp", new Object[] {_msg});
anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet = null;
byte[] _buffer = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub send_to_dev_udp(msg As String) As Boolean ' Ві";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="Try";
try {RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="If UDPSocket.IsInitialized =False Then Return Fal";
if (_udpsocket.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Dim Packet As UDPPacket";
_packet = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket();
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="Dim Buffer() As Byte";
_buffer = new byte[(int) (0)];
;
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="Buffer = msg.GetBytes(\"UTF8\")";
_buffer = _msg.getBytes("UTF8");
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="Packet.Initialize(Buffer, \"255.255.255.255\", \"";
_packet.Initialize(_buffer,"255.255.255.255",(int)(Double.parseDouble("2201")));
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="UDPSocket.Send(Packet)";
_udpsocket.Send(_packet);
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e178) {
			processBA.setLastException(e178);RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=1703949;
 //BA.debugLineNum = 1703949;BA.debugLine="End Sub";
return false;
}
public static String  _service_create() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("service_create"))
	return (String) Debug.delegate(processBA, "service_create", null);
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub Service_Create";
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("service_destroy"))
	return (String) Debug.delegate(processBA, "service_destroy", null);
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Service_Destroy";
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("service_start"))
	return (String) Debug.delegate(processBA, "service_start", new Object[] {_startingintent});
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="udp_init ' ініціалізація UDP";
_udp_init();
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="mqtt_init' ініціалізація MQTT";
_mqtt_init();
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="CM.myid=objPhone.GetSettings(\"android_id\")";
mostCurrent._cm._myid = _objphone.GetSettings("android_id");
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="End Sub";
return "";
}
public static String  _udp_init() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("udp_init"))
	return (String) Debug.delegate(processBA, "udp_init", null);
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub udp_init()";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Try";
try {RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="UDPSocket.Initialize(\"UDP\", 1407,255)";
_udpsocket.Initialize(processBA,"UDP",(int) (1407),(int) (255));
 } 
       catch (Exception e72) {
			processBA.setLastException(e72);RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="End Sub";
return "";
}
public static String  _udp_packetarrived(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("udp_packetarrived"))
	return (String) Debug.delegate(processBA, "udp_packetarrived", new Object[] {_packet});
String _result = "";
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub UDP_PacketArrived (Packet As UDPPacket)";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Try";
try {RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="Dim result As String = BytesToString(Packet.Da";
_result = anywheresoftware.b4a.keywords.Common.BytesToString(_packet.getData(),_packet.getOffset(),_packet.getLength(),"UTF8");
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="proces_json(result,Packet.HostAddress)";
_proces_json(_result,_packet.getHostAddress());
 } 
       catch (Exception e80) {
			processBA.setLastException(e80);RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="End Sub";
return "";
}
}