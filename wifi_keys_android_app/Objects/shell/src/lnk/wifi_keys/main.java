
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

public class main implements IRemote{
	public static main mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public main() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("main"), "lnk.wifi_keys.main");
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
		pcBA = new PCBA(this, main.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _keys_is_load = RemoteObject.createImmutable(false);
public static RemoteObject _conect_tmout = RemoteObject.createImmutable(0);
public static RemoteObject _send_state_timer = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _butt = null;
public static RemoteObject _status_lab = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _butlock = null;
public static RemoteObject _butstate = null;
public static RemoteObject _sld_norm = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.StateListDrawable");
public static RemoteObject _sld_on = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.StateListDrawable");
public static RemoteObject _sld_down = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.StateListDrawable");
public static RemoteObject _prs = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
public static RemoteObject _ups = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
public static RemoteObject _grn = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.ColorDrawable");
public static RemoteObject _cur_but_state = RemoteObject.createImmutable(0);
public static RemoteObject _prs_but = RemoteObject.createImmutable(0);
public static lnk.wifi_keys.starter _starter = null;
public static lnk.wifi_keys.statemanager _statemanager = null;
public static lnk.wifi_keys.sel_dev _sel_dev = null;
public static lnk.wifi_keys.ap_set _ap_set = null;
public static lnk.wifi_keys.sta_set _sta_set = null;
public static lnk.wifi_keys.key_set _key_set = null;
public static lnk.wifi_keys.cm _cm = null;
public static lnk.wifi_keys.inet_set _inet_set = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",main.mostCurrent._activity,"AP_SET",Debug.moduleToString(lnk.wifi_keys.ap_set.class),"butlock",main._butlock,"butstate",main._butstate,"butt",main.mostCurrent._butt,"CM",Debug.moduleToString(lnk.wifi_keys.cm.class),"conect_tmout",main._conect_tmout,"cur_but_state",main._cur_but_state,"grn",main.mostCurrent._grn,"INET_SET",Debug.moduleToString(lnk.wifi_keys.inet_set.class),"KEY_SET",Debug.moduleToString(lnk.wifi_keys.key_set.class),"keys_is_load",main._keys_is_load,"prs",main.mostCurrent._prs,"prs_but",main._prs_but,"sel_dev",Debug.moduleToString(lnk.wifi_keys.sel_dev.class),"send_state_timer",main._send_state_timer,"sld_down",main.mostCurrent._sld_down,"sld_norm",main.mostCurrent._sld_norm,"sld_on",main.mostCurrent._sld_on,"STA_SET",Debug.moduleToString(lnk.wifi_keys.sta_set.class),"Starter",Debug.moduleToString(lnk.wifi_keys.starter.class),"StateManager",Debug.moduleToString(lnk.wifi_keys.statemanager.class),"status_lab",main.mostCurrent._status_lab,"ups",main.mostCurrent._ups};
}
}