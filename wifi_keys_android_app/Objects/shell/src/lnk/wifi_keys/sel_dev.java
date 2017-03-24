
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

public class sel_dev implements IRemote{
	public static sel_dev mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public sel_dev() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("sel_dev"), "lnk.wifi_keys.sel_dev");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, sel_dev.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _mgetbut_tmr = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _dev_list = RemoteObject.declareNull("anywheresoftware.b4a.objects.ListViewWrapper");
public static RemoteObject _key_n = RemoteObject.createImmutable(0);
public static lnk.wifi_keys.main _main = null;
public static lnk.wifi_keys.starter _starter = null;
public static lnk.wifi_keys.statemanager _statemanager = null;
public static lnk.wifi_keys.ap_set _ap_set = null;
public static lnk.wifi_keys.key_set _key_set = null;
public static lnk.wifi_keys.cm _cm = null;
public static lnk.wifi_keys.inet_set _inet_set = null;
public static lnk.wifi_keys.sta_set _sta_set = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",sel_dev.mostCurrent._activity,"AP_SET",Debug.moduleToString(lnk.wifi_keys.ap_set.class),"CM",Debug.moduleToString(lnk.wifi_keys.cm.class),"dev_list",sel_dev.mostCurrent._dev_list,"INET_SET",Debug.moduleToString(lnk.wifi_keys.inet_set.class),"key_n",sel_dev._key_n,"KEY_SET",Debug.moduleToString(lnk.wifi_keys.key_set.class),"Main",Debug.moduleToString(lnk.wifi_keys.main.class),"mgetbut_tmr",sel_dev._mgetbut_tmr,"STA_SET",Debug.moduleToString(lnk.wifi_keys.sta_set.class),"Starter",Debug.moduleToString(lnk.wifi_keys.starter.class),"StateManager",Debug.moduleToString(lnk.wifi_keys.statemanager.class)};
}
}