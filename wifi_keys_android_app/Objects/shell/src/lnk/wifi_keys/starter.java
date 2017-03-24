
package lnk.wifi_keys;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class starter implements IRemote{
	public static starter mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public starter() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("starter"), "lnk.wifi_keys.starter");
	}
     public static RemoteObject getObject() {
		return myClass;
	 }
	public RemoteObject _service;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
        _service = (RemoteObject) args[2];
        remoteMe = RemoteObject.declareNull("lnk.wifi_keys.starter");
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[3];
		pcBA = new PCBA(this, starter.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _udpsocket = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.UDPSocket");
public static RemoteObject _objmqtt = RemoteObject.declareNull("com.visualnet.mqtt");
public static lnk.wifi_keys.main _main = null;
public static lnk.wifi_keys.statemanager _statemanager = null;
public static lnk.wifi_keys.sel_dev _sel_dev = null;
public static lnk.wifi_keys.ap_set _ap_set = null;
public static lnk.wifi_keys.key_set _key_set = null;
public static lnk.wifi_keys.cm _cm = null;
public static lnk.wifi_keys.inet_set _inet_set = null;
public static lnk.wifi_keys.sta_set _sta_set = null;
  public Object[] GetGlobals() {
		return new Object[] {"AP_SET",Debug.moduleToString(lnk.wifi_keys.ap_set.class),"CM",Debug.moduleToString(lnk.wifi_keys.cm.class),"INET_SET",Debug.moduleToString(lnk.wifi_keys.inet_set.class),"KEY_SET",Debug.moduleToString(lnk.wifi_keys.key_set.class),"Main",Debug.moduleToString(lnk.wifi_keys.main.class),"objMqtt",starter._objmqtt,"sel_dev",Debug.moduleToString(lnk.wifi_keys.sel_dev.class),"Service",starter.mostCurrent._service,"STA_SET",Debug.moduleToString(lnk.wifi_keys.sta_set.class),"StateManager",Debug.moduleToString(lnk.wifi_keys.statemanager.class),"UDPSocket",starter._udpsocket};
}
}