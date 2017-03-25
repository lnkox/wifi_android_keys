
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

public class cm implements IRemote{
	public static cm mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public cm() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, cm.class);
    static {
		mostCurrent = new cm();
        remoteMe = RemoteObject.declareNull("lnk.wifi_keys.cm");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("cm"), "lnk.wifi_keys.cm");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("lnk.wifi_keys.cm"), new java.lang.ref.WeakReference<PCBA> (pcBA));
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
public static RemoteObject _bc = RemoteObject.declareNull("anywheresoftware.b4a.agraham.byteconverter.ByteConverter");
public static RemoteObject _connect_type = RemoteObject.createImmutable(false);
public static RemoteObject _myid = RemoteObject.createImmutable("");
public static lnk.wifi_keys.main _main = null;
public static lnk.wifi_keys.starter _starter = null;
public static lnk.wifi_keys.statemanager _statemanager = null;
public static lnk.wifi_keys.sel_dev _sel_dev = null;
public static lnk.wifi_keys.ap_set _ap_set = null;
public static lnk.wifi_keys.key_set _key_set = null;
public static lnk.wifi_keys.inet_set _inet_set = null;
public static lnk.wifi_keys.sta_set _sta_set = null;
  public Object[] GetGlobals() {
		return new Object[] {"AP_SET",Debug.moduleToString(lnk.wifi_keys.ap_set.class),"bc",cm._bc,"connect_type",cm._connect_type,"INET_SET",Debug.moduleToString(lnk.wifi_keys.inet_set.class),"KEY_SET",Debug.moduleToString(lnk.wifi_keys.key_set.class),"Main",Debug.moduleToString(lnk.wifi_keys.main.class),"myid",cm._myid,"sel_dev",Debug.moduleToString(lnk.wifi_keys.sel_dev.class),"STA_SET",Debug.moduleToString(lnk.wifi_keys.sta_set.class),"Starter",Debug.moduleToString(lnk.wifi_keys.starter.class),"StateManager",Debug.moduleToString(lnk.wifi_keys.statemanager.class)};
}
}