
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

public class statemanager implements IRemote{
	public static statemanager mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public statemanager() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, statemanager.class);
    static {
		mostCurrent = new statemanager();
        remoteMe = RemoteObject.declareNull("lnk.wifi_keys.statemanager");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("statemanager"), "lnk.wifi_keys.statemanager");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("lnk.wifi_keys.statemanager"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _states = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _listposition = RemoteObject.createImmutable(0);
public static RemoteObject _statesfilename = RemoteObject.createImmutable("");
public static RemoteObject _settingsfilename = RemoteObject.createImmutable("");
public static RemoteObject _settings = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static lnk.wifi_keys.main _main = null;
public static lnk.wifi_keys.starter _starter = null;
public static lnk.wifi_keys.sel_dev _sel_dev = null;
public static lnk.wifi_keys.ap_set _ap_set = null;
public static lnk.wifi_keys.sta_set _sta_set = null;
public static lnk.wifi_keys.key_set _key_set = null;
public static lnk.wifi_keys.cm _cm = null;
public static lnk.wifi_keys.inet_set _inet_set = null;
  public Object[] GetGlobals() {
		return new Object[] {"AP_SET",Debug.moduleToString(lnk.wifi_keys.ap_set.class),"CM",Debug.moduleToString(lnk.wifi_keys.cm.class),"INET_SET",Debug.moduleToString(lnk.wifi_keys.inet_set.class),"KEY_SET",Debug.moduleToString(lnk.wifi_keys.key_set.class),"listPosition",statemanager._listposition,"Main",Debug.moduleToString(lnk.wifi_keys.main.class),"sel_dev",Debug.moduleToString(lnk.wifi_keys.sel_dev.class),"settings",statemanager._settings,"settingsFileName",statemanager._settingsfilename,"STA_SET",Debug.moduleToString(lnk.wifi_keys.sta_set.class),"Starter",Debug.moduleToString(lnk.wifi_keys.starter.class),"states",statemanager._states,"statesFileName",statemanager._statesfilename};
}
}