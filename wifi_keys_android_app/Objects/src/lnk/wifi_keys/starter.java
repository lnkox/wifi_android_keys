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
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
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
public static String  _proces_error(String _msg) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("proces_error"))
	return (String) Debug.delegate(processBA, "proces_error", new Object[] {_msg});
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub proces_error(msg As String)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",processBA);
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub send_to_dev(data As Map) As Boolean ' Відправк";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Try";
try {RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="If UDPSocket.IsInitialized =False Then Return Fal";
if (_udpsocket.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="Dim Packet As UDPPacket";
_packet = new anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket();
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="Dim Buffer() As Byte";
_buffer = new byte[(int) (0)];
;
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="Dim msg As String";
_msg = "";
RDebugUtils.currentLine=917510;
 //BA.debugLineNum = 917510;BA.debugLine="Dim JSONGenerator As JSONGenerator";
_jsongenerator = new anywheresoftware.b4a.objects.collections.JSONParser.JSONGenerator();
RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
_data.Put((Object)("dev_name"),(Object)(mostCurrent._statemanager._getsetting2(processBA,"cur_dev_name","none")));
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="JSONGenerator.Initialize(data)";
_jsongenerator.Initialize(_data);
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="msg = JSONGenerator.ToString";
_msg = _jsongenerator.ToString();
RDebugUtils.currentLine=917514;
 //BA.debugLineNum = 917514;BA.debugLine="Buffer = msg.GetBytes(\"UTF8\")";
_buffer = _msg.getBytes("UTF8");
RDebugUtils.currentLine=917515;
 //BA.debugLineNum = 917515;BA.debugLine="Packet.Initialize(Buffer, \"255.255.255.255\", \"";
_packet.Initialize(_buffer,"255.255.255.255",(int)(Double.parseDouble("2201")));
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="UDPSocket.Send(Packet)";
_udpsocket.Send(_packet);
RDebugUtils.currentLine=917517;
 //BA.debugLineNum = 917517;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e100) {
			processBA.setLastException(e100);RDebugUtils.currentLine=917519;
 //BA.debugLineNum = 917519;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
RDebugUtils.currentLine=917520;
 //BA.debugLineNum = 917520;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=917522;
 //BA.debugLineNum = 917522;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _udp_init() throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("udp_init"))
	return (String) Debug.delegate(processBA, "udp_init", null);
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub udp_init()";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Try";
try {RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="UDPSocket.Initialize(\"UDP\", 1407,255)";
_udpsocket.Initialize(processBA,"UDP",(int) (1407),(int) (255));
 } 
       catch (Exception e17) {
			processBA.setLastException(e17);RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="End Sub";
return "";
}
public static String  _set_key_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("set_key_set"))
	return (String) Debug.delegate(processBA, "set_key_set", new Object[] {_mapar});
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub set_key_set (mapar As Map)";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Try";
try {RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))<1 Or CM.toint(m";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))<1 || mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))>30) { 
if (true) return "";};
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))=30 Then";
if (mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))==30) { 
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="ToastMessageShow(\"Load data complete\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Load data complete",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="CallSubDelayed(sel_dev,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"finish_him");
 };
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="StateManager.SetSetting(\"keytext\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytext"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("name"))));
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="If mapar.Get (\"name\") =\"@\" Then";
if ((_mapar.Get((Object)("name"))).equals((Object)("@"))) { 
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),"");
 }else {
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="StateManager.SetSetting(\"keytag\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keytag"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(_mapar.Get((Object)("key_id"))));
 };
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="StateManager.SetSetting(\"keylock\" & mapar.Get (\"";
mostCurrent._statemanager._setsetting(processBA,"keylock"+BA.ObjectToString(_mapar.Get((Object)("key_id"))),BA.ObjectToString(mostCurrent._cm._obj2bool(processBA,_mapar.Get((Object)("lock")))));
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e72) {
			processBA.setLastException(e72);RDebugUtils.currentLine=786448;
 //BA.debugLineNum = 786448;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=786450;
 //BA.debugLineNum = 786450;BA.debugLine="End Sub";
return "";
}
public static String  _set_keyinfo_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("set_keyinfo_set"))
	return (String) Debug.delegate(processBA, "set_keyinfo_set", new Object[] {_mapar});
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Try";
try {RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="StateManager.SetSetting(\"font_size\", CM.toint(ma";
mostCurrent._statemanager._setsetting(processBA,"font_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("font_size"))))));
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="StateManager.SetSetting(\"h_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"h_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("h_size"))))));
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="StateManager.SetSetting(\"v_size\", CM.toint(mapar";
mostCurrent._statemanager._setsetting(processBA,"v_size",BA.NumberToString(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("v_size"))))));
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(processBA);
 } 
       catch (Exception e82) {
			processBA.setLastException(e82);RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="End Sub";
return "";
}
public static String  _udp_packetarrived(anywheresoftware.b4a.objects.SocketWrapper.UDPSocket.UDPPacket _packet) throws Exception{
RDebugUtils.currentModule="starter";
if (Debug.shouldDelegate("udp_packetarrived"))
	return (String) Debug.delegate(processBA, "udp_packetarrived", new Object[] {_packet});
String _result = "";
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.Map _mapar = null;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub UDP_PacketArrived (Packet As UDPPacket)";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Try";
try {RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim result As String = BytesToString(Packet.Da";
_result = anywheresoftware.b4a.keywords.Common.BytesToString(_packet.getData(),_packet.getOffset(),_packet.getLength(),"UTF8");
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="result=result.Replace(Chr(0),\"\")";
_result = _result.replace(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.Chr((int) (0))),"");
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="result=result.Replace(\"}{\",\",\")";
_result = _result.replace("}{",",");
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="Dim Mapar As Map";
_mapar = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="JSON.Initialize(result)";
_json.Initialize(_result);
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="Mapar = JSON.NextObject";
_mapar = _json.NextObject();
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="If Mapar.ContainsKey(\"rssi\")=True Then   CallSubD";
if (_mapar.ContainsKey((Object)("rssi"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"set_ris",(Object)(mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("rssi"))))));};
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="If Mapar.ContainsKey(\"rcom\")=True Then   CallSubD";
if (_mapar.ContainsKey((Object)("rcom"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._main.getObject()),"reload_key_state",(Object)(_mapar));};
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="If Mapar.ContainsKey(\"namedev\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("namedev"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(processBA,(Object)(mostCurrent._sel_dev.getObject()),"add_dev_tolist",_mapar.Get((Object)("namedev")),(Object)(_packet.getHostAddress()));};
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="If Mapar.ContainsKey(\"ssid_ap\")=True Then CallSub";
if (_mapar.ContainsKey((Object)("ssid_ap"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._ap_set.getObject()),"set_ap_set",(Object)(_mapar));};
RDebugUtils.currentLine=720909;
 //BA.debugLineNum = 720909;BA.debugLine="If Mapar.ContainsKey(\"ssid_sta\")=True Then CallSu";
if (_mapar.ContainsKey((Object)("ssid_sta"))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(processBA,(Object)(mostCurrent._sta_set.getObject()),"set_sta_set",(Object)(_mapar));};
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="If Mapar.ContainsKey(\"key_id\")=True Then set_key_";
if (_mapar.ContainsKey((Object)("key_id"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_key_set(_mapar);};
RDebugUtils.currentLine=720911;
 //BA.debugLineNum = 720911;BA.debugLine="If Mapar.ContainsKey(\"font_size\")=True Then set_k";
if (_mapar.ContainsKey((Object)("font_size"))==anywheresoftware.b4a.keywords.Common.True) { 
_set_keyinfo_set(_mapar);};
RDebugUtils.currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="If Mapar.ContainsKey(\"save_ok\")=True Then";
if (_mapar.ContainsKey((Object)("save_ok"))==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="ToastMessageShow (\"Saved\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Saved",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=720915;
 //BA.debugLineNum = 720915;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=1) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==1)) { 
RDebugUtils.currentLine=720916;
 //BA.debugLineNum = 720916;BA.debugLine="CallSubDelayed(AP_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._ap_set.getObject()),"finish_him");
 };
RDebugUtils.currentLine=720918;
 //BA.debugLineNum = 720918;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=2) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==2)) { 
RDebugUtils.currentLine=720919;
 //BA.debugLineNum = 720919;BA.debugLine="CallSubDelayed(STA_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sta_set.getObject()),"finish_him");
 };
RDebugUtils.currentLine=720921;
 //BA.debugLineNum = 720921;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=3) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==3)) { 
RDebugUtils.currentLine=720922;
 //BA.debugLineNum = 720922;BA.debugLine="CallSubDelayed(KEY_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._key_set.getObject()),"finish_him");
RDebugUtils.currentLine=720923;
 //BA.debugLineNum = 720923;BA.debugLine="CallSubDelayed(sel_dev,\"load_keys\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._sel_dev.getObject()),"load_keys");
 };
RDebugUtils.currentLine=720925;
 //BA.debugLineNum = 720925;BA.debugLine="If (CM.toint (Mapar.Get (\"save_ok\"))=4) Then";
if ((mostCurrent._cm._toint(processBA,BA.ObjectToString(_mapar.Get((Object)("save_ok"))))==4)) { 
RDebugUtils.currentLine=720926;
 //BA.debugLineNum = 720926;BA.debugLine="CallSubDelayed(INET_SET,\"finish_him\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._inet_set.getObject()),"finish_him");
 };
 };
 } 
       catch (Exception e53) {
			processBA.setLastException(e53);RDebugUtils.currentLine=720930;
 //BA.debugLineNum = 720930;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
RDebugUtils.currentLine=720933;
 //BA.debugLineNum = 720933;BA.debugLine="End Sub";
return "";
}
}