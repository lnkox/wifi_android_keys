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
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub mqtt_connect()";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Try";
try {RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim strBroker As String = \"tcp://\" & StateManager";
_strbroker = "tcp://"+mostCurrent._statemanager._getsetting2(processBA,"inet_server","MQTT server")+":"+mostCurrent._statemanager._getsetting2(processBA,"inet_port","1234");
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="Dim strUsername As String  = StateManager.GetSett";
_strusername = mostCurrent._statemanager._getsetting2(processBA,"inet_login","MQTT login");
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="Dim strPassword As String  = StateManager.GetSett";
_strpassword = mostCurrent._statemanager._getsetting2(processBA,"inet_pass","MQTT pass");
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="ToastMessageShow(\"Connecting to \" & strBroker,Fal";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Connecting to "+_strbroker,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="Dim bRet As Boolean = objMqtt.Connect(strBroker,\"";
_bret = _objmqtt.Connect(processBA,_strbroker,"",_strusername,_strpassword);
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="If bRet=False Then";
if (_bret==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="ToastMessageShow(\"MQTT error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT error",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 };
 } 
       catch (Exception e46) {
			processBA.setLastException(e46);RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="proces_error(LastException.Message & \"mqtt_connec";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"mqtt_connect");
 };
RDebugUtils.currentLine=2293775;
 //BA.debugLineNum = 2293775;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("proces_error"))
	return (String) Debug.delegate(processBA, "proces_error", new Object[] {_msg});
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub proces_error(msg As String)";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="ToastMessageShow(msg,True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(_msg,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_disconnect() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("mqtt_disconnect"))
	return (String) Debug.delegate(processBA, "mqtt_disconnect", null);
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub mqtt_disconnect()";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="objMqtt.Disconnect";
_objmqtt.Disconnect(processBA);
 } 
       catch (Exception e31) {
			processBA.setLastException(e31);RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="proces_error(LastException.Message & \"mqtt_discon";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"mqtt_disconnect");
 };
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_init() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("mqtt_init"))
	return (String) Debug.delegate(processBA, "mqtt_init", null);
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub mqtt_init()";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Try";
try {RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="objMqtt.JavaDebug = True";
_objmqtt.JavaDebug = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="objMqtt.CleanSession = True";
_objmqtt.CleanSession = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="objMqtt.Initialize(\"oMqtt\")";
_objmqtt.Initialize(processBA,"oMqtt");
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="objMqtt.KeepAliveInterval =3";
_objmqtt.KeepAliveInterval = (int) (3);
 } 
       catch (Exception e24) {
			processBA.setLastException(e24);RDebugUtils.currentLine=2162695;
 //BA.debugLineNum = 2162695;BA.debugLine="proces_error(LastException.Message & \"mqtt_init\")";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"mqtt_init");
 };
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_connectionlost() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_connectionlost"))
	return (String) Debug.delegate(processBA, "omqtt_connectionlost", null);
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub oMqtt_connectionLost()";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="ToastMessageShow(\"MQTT connect error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT connect error",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_deliverycomplete(String _token) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_deliverycomplete"))
	return (String) Debug.delegate(processBA, "omqtt_deliverycomplete", new Object[] {_token});
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub oMqtt_deliverycomplete(Token As String)";
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_messagearrived(String _topic,String _message) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_messagearrived"))
	return (String) Debug.delegate(processBA, "omqtt_messagearrived", new Object[] {_topic,_message});
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub oMqtt_messageArrived(Topic As String, Message";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="proces_json(Message,\"MQTT\")";
_proces_json(_message,"MQTT");
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="End Sub";
return "";
}
public static String  _proces_json(String _result,String _host) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("proces_json"))
	return (String) Debug.delegate(processBA, "proces_json", new Object[] {_result,_host});
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.Map _mapar = null;
String _tmpid = "";
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub proces_json(result As String,host As String)";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Try";
try {RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="result=result.Replace(Chr(0),\"\")";
_result = _result.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0))),"");
RDebugUtils.currentLine=2883587;
 //BA.debugLineNum = 2883587;BA.debugLine="result=result.Replace(\"}{\",\",\")";
_result = _result.replace("}{",",");
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="Dim Mapar As Map";
_mapar = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2883590;
 //BA.debugLineNum = 2883590;BA.debugLine="JSON.Initialize(result)";
_json.Initialize(_result);
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="Mapar = JSON.NextObject";
_mapar = _json.NextObject();
RDebugUtils.currentLine=2883593;
 //BA.debugLineNum = 2883593;BA.debugLine="If Mapar.ContainsKey(\"yourid\")=False Then Return";
if (_mapar.ContainsKey((Object)("yourid"))==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=2883594;
 //BA.debugLineNum = 2883594;BA.debugLine="Dim tmpid As String=Mapar.Get(\"yourid\")";
_tmpid = BA.ObjectToString(_mapar.Get((Object)("yourid")));
RDebugUtils.currentLine=2883595;
 //BA.debugLineNum = 2883595;BA.debugLine="If tmpid.EqualsIgnoreCase(CM.myid)=False Then Ret";
if (_tmpid.equalsIgnoreCase(mostCurrent._cm._myid)==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=2883597;
 //BA.debugLineNum = 2883597;BA.debugLine="If Mapar.ContainsKey(\"rssi\")=True Then   CallSubD";
if (_mapar.ContainsKey((Object)("rssi"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_ris",(Object)(_mapar));};
RDebugUtils.currentLine=2883598;
 //BA.debugLineNum = 2883598;BA.debugLine="If Mapar.ContainsKey(\"namedev\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("namedev"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(processBA,(Object)(mostCurrent._sel_dev.getObject()),"add_dev_tolist",_mapar.Get((Object)("namedev")),(Object)(_host));};
RDebugUtils.currentLine=2883599;
 //BA.debugLineNum = 2883599;BA.debugLine="If Mapar.ContainsKey(\"ssid_ap\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("ssid_ap"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._ap_set.getObject()),"set_ap_set",(Object)(_mapar));};
RDebugUtils.currentLine=2883600;
 //BA.debugLineNum = 2883600;BA.debugLine="If Mapar.ContainsKey(\"ssid_sta\")=True Then CallSu";
if (_mapar.ContainsKey((Object)("ssid_sta"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._sta_set.getObject()),"set_sta_set",(Object)(_mapar));};
RDebugUtils.currentLine=2883601;
 //BA.debugLineNum = 2883601;BA.debugLine="If Mapar.ContainsKey(\"key_id\")=True Then set_key_";
if (_mapar.ContainsKey((Object)("key_id"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_key_set(_mapar);};
RDebugUtils.currentLine=2883602;
 //BA.debugLineNum = 2883602;BA.debugLine="If Mapar.ContainsKey(\"font_size\")=True Then set_k";
if (_mapar.ContainsKey((Object)("font_size"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_keyinfo_set(_mapar);};
RDebugUtils.currentLine=2883604;
 //BA.debugLineNum = 2883604;BA.debugLine="If Mapar.ContainsKey(\"save_ok\")=True Then";
if (_mapar.ContainsKey((Object)("save_ok"))==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2883605;
 //BA.debugLineNum = 2883605;BA.debugLine="ToastMessageShow (\"Saved\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Saved",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2883606;
 //BA.debugLineNum = 2883606;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=1) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==1)) { 
RDebugUtils.currentLine=2883607;
 //BA.debugLineNum = 2883607;BA.debugLine="CallSubDelayed(AP_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._ap_set.getObject()),"finish_him");
 };
RDebugUtils.currentLine=2883609;
 //BA.debugLineNum = 2883609;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=2) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==2)) { 
RDebugUtils.currentLine=2883610;
 //BA.debugLineNum = 2883610;BA.debugLine="CallSubDelayed(STA_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sta_set.getObject()),"finish_him");
 };
RDebugUtils.currentLine=2883612;
 //BA.debugLineNum = 2883612;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=3) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==3)) { 
RDebugUtils.currentLine=2883613;
 //BA.debugLineNum = 2883613;BA.debugLine="CallSubDelayed(KEY_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._key_set.getObject()),"finish_him");
RDebugUtils.currentLine=2883614;
 //BA.debugLineNum = 2883614;BA.debugLine="CallSubDelayed(sel_dev,\"load_keys\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"load_keys");
 };
RDebugUtils.currentLine=2883616;
 //BA.debugLineNum = 2883616;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=4) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==4)) { 
RDebugUtils.currentLine=2883617;
 //BA.debugLineNum = 2883617;BA.debugLine="CallSubDelayed(INET_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._inet_set.getObject()),"finish_him");
 };
 };
 } 
       catch (Exception e123) {
			processBA.setLastException(e123);RDebugUtils.currentLine=2883621;
 //BA.debugLineNum = 2883621;BA.debugLine="proces_error(LastException.Message & \"process_jso";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"process_json");
 };
RDebugUtils.currentLine=2883623;
 //BA.debugLineNum = 2883623;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_onconnect(boolean _status) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_onconnect"))
	return (String) Debug.delegate(processBA, "omqtt_onconnect", new Object[] {_status});
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub oMqtt_onConnect(Status As Boolean)";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="If Status=False Then";
if (_status==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="ToastMessageShow(\"MQTT connect error\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT connect error",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
 }else {
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="ToastMessageShow(\"MQTT is connected\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT is connected",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",True)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.True));
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="objMqtt.Subscribe(\"wfkey\")";
_objmqtt.Subscribe(processBA,"wfkey");
 };
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_ondisconnect(boolean _status) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_ondisconnect"))
	return (String) Debug.delegate(processBA, "omqtt_ondisconnect", new Object[] {_status});
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub oMqtt_onDisconnect(Status As Boolean)";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="ToastMessageShow(\"MQTT disconnect\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("MQTT disconnect",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="CallSubDelayed2(Main,\"set_mqtt_state\",False)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_mqtt_state",(Object)(anywheresoftware.b4a.keywords.Common.False));
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="End Sub";
return "";
}
public static String  _omqtt_oninitialized() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("omqtt_oninitialized"))
	return (String) Debug.delegate(processBA, "omqtt_oninitialized", null);
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub oMqtt_onInitialized()";
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _set_key_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("set_key_set"))
	return (String) Debug.delegate(processBA, "set_key_set", new Object[] {_mapar});
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub set_key_set (mapar As Map)";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Try";
try {RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))<1 Or CM.toint(m";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))<1 || mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))>30) { 
if (true) return "";};
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))=30 Then";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))==30) { 
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="ToastMessageShow(\"Load data complete\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Load data complete",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="CallSubDelayed(sel_dev,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"finish_him");
 };
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="StateManager.SetSetting(\"keytext\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytext"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("name"))));
RDebugUtils.currentLine=2949128;
 //BA.debugLineNum = 2949128;BA.debugLine="If mapar.Get (\"name\") =\"@\" Then";
if ((_mapar.Get((Object)("name"))).equals((Object)("@"))) { 
RDebugUtils.currentLine=2949129;
 //BA.debugLineNum = 2949129;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),"");
 }else {
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("key_id"))));
 };
RDebugUtils.currentLine=2949133;
 //BA.debugLineNum = 2949133;BA.debugLine="StateManager.SetSetting(\"keylock\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keylock"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(mostCurrent._cm._obj2bool(processBA,_mapar.Get((Object)("lock")))));
RDebugUtils.currentLine=2949134;
 //BA.debugLineNum = 2949134;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e142) {
			processBA.setLastException(e142);RDebugUtils.currentLine=2949136;
 //BA.debugLineNum = 2949136;BA.debugLine="proces_error(LastException.Message & \"set_key_se";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"set_key_set");
 };
RDebugUtils.currentLine=2949138;
 //BA.debugLineNum = 2949138;BA.debugLine="End Sub";
return "";
}
public static String  _set_keyinfo_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("set_keyinfo_set"))
	return (String) Debug.delegate(processBA, "set_keyinfo_set", new Object[] {_mapar});
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Try";
try {RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="StateManager.SetSetting(\"font_size\", CM.toint(ma";
mostCurrent._statemanager._setsetting(processBA,"font_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("font_size"))))));
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="StateManager.SetSetting(\"h_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"h_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("h_size"))))));
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="StateManager.SetSetting(\"v_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"v_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("v_size"))))));
RDebugUtils.currentLine=3014661;
 //BA.debugLineNum = 3014661;BA.debugLine="StateManager.SetSetting(\"batt_dev\", CM.toint(map";
mostCurrent._statemanager._setsetting(processBA,"batt_dev",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("batt_dev"))))));
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e153) {
			processBA.setLastException(e153);RDebugUtils.currentLine=3014664;
 //BA.debugLineNum = 3014664;BA.debugLine="proces_error(LastException.Message & \"set_key_in";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"set_key_info_set");
 };
RDebugUtils.currentLine=3014666;
 //BA.debugLineNum = 3014666;BA.debugLine="End Sub";
return "";
}
public static boolean  _send_to_dev(anywheresoftware.b4a.objects.collections.Map _data) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("send_to_dev"))
	return (Boolean) Debug.delegate(processBA, "send_to_dev", new Object[] {_data});
String _msg = "";
anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator _jsongenerator = null;
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub send_to_dev(data As Map) As Boolean ' Відправк";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Try";
try {RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="Dim msg As String";
_msg = "";
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="Dim JSONGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
_data.Put((Object)("dev_name"),(Object)(mostCurrent._statemanager._getsetting2(processBA,"cur_dev_name","none")));
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="data.Put (\"myid\",CM.myid)";
_data.Put((Object)("myid"),(Object)(mostCurrent._cm._myid));
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="JSONGenerator.Initialize(data)";
_jsongenerator.Initialize(_data);
RDebugUtils.currentLine=3080199;
 //BA.debugLineNum = 3080199;BA.debugLine="msg = JSONGenerator.ToString";
_msg = _jsongenerator.ToString();
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="If CM.connect_type=True Then";
if (mostCurrent._cm._connect_type==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="Return send_to_dev_mqtt(msg)";
if (true) return _send_to_dev_mqtt(_msg);
 }else {
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="Return send_to_dev_udp(msg)";
if (true) return _send_to_dev_udp(_msg);
 };
 } 
       catch (Exception e170) {
			processBA.setLastException(e170);RDebugUtils.currentLine=3080206;
 //BA.debugLineNum = 3080206;BA.debugLine="proces_error(LastException.Message & \"send_to_de";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"send_to_dev");
 };
RDebugUtils.currentLine=3080208;
 //BA.debugLineNum = 3080208;BA.debugLine="End Sub";
return false;
}
public static boolean  _send_to_dev_mqtt(String _msg) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("send_to_dev_mqtt"))
	return (Boolean) Debug.delegate(processBA, "send_to_dev_mqtt", new Object[] {_msg});
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub send_to_dev_mqtt(msg As String) As Boolean ' В";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="Try";
try {RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="If objMqtt.isConnected =False Then Return False";
if (_objmqtt.isConnected()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="objMqtt.Publish(\"wfkeyin\",msg,  objMqtt.QoS_Exact";
_objmqtt.Publish(processBA,"wfkeyin",_msg,_objmqtt.QoS_ExactlyOnce,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e179) {
			processBA.setLastException(e179);RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="proces_error(LastException.Message & \"send_to_dev";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"send_to_dev_mqtt");
RDebugUtils.currentLine=3145735;
 //BA.debugLineNum = 3145735;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3145737;
 //BA.debugLineNum = 3145737;BA.debugLine="End Sub";
return false;
}
public static boolean  _send_to_dev_udp(String _msg) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("send_to_dev_udp"))
	return (Boolean) Debug.delegate(processBA, "send_to_dev_udp", new Object[] {_msg});
anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet = null;
byte[] _buffer = null;
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub send_to_dev_udp(msg As String) As Boolean ' Ві";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Try";
try {RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="If UDPSocket.IsInitialized =False Then Return Fal";
if (_udpsocket.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="Dim Packet As UDPPacket";
_packet = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket();
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="Dim Buffer() As Byte";
_buffer = new byte[(int) (0)];
;
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="Buffer = msg.GetBytes(\"UTF8\")";
_buffer = _msg.getBytes("UTF8");
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="Packet.Initialize(Buffer, \"255.255.255.255\", \"";
_packet.Initialize(_buffer,"255.255.255.255",(int)(Double.parseDouble("2201")));
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="UDPSocket.Send(Packet)";
_udpsocket.Send(_packet);
RDebugUtils.currentLine=3211272;
 //BA.debugLineNum = 3211272;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e193) {
			processBA.setLastException(e193);RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="proces_error(LastException.Message & \"send_to_dev";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"send_to_dev_udp");
RDebugUtils.currentLine=3211275;
 //BA.debugLineNum = 3211275;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub udp_init()";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="Try";
try {RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="UDPSocket.Initialize(\"UDP\", 1407,255)";
_udpsocket.Initialize(processBA,"UDP",(int) (1407),(int) (255));
 } 
       catch (Exception e78) {
			processBA.setLastException(e78);RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="proces_error(LastException.Message & \"udp_init\")";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"udp_init");
 };
RDebugUtils.currentLine=2752518;
 //BA.debugLineNum = 2752518;BA.debugLine="End Sub";
return "";
}
public static String  _udp_packetarrived(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("udp_packetarrived"))
	return (String) Debug.delegate(processBA, "udp_packetarrived", new Object[] {_packet});
String _result = "";
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub UDP_PacketArrived (Packet As UDPPacket)";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="Try";
try {RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="Dim result As String = BytesToString(Packet.Da";
_result = anywheresoftware.b4a.keywords.Common.BytesToString(_packet.getData(),_packet.getOffset(),_packet.getLength(),"UTF8");
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="proces_json(result,Packet.HostAddress)";
_proces_json(_result,_packet.getHostAddress());
 } 
       catch (Exception e86) {
			processBA.setLastException(e86);RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="proces_error(LastException.Message & \"udp_pack.ar";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage()+"udp_pack.arrived");
 };
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="End Sub";
return "";
}
}