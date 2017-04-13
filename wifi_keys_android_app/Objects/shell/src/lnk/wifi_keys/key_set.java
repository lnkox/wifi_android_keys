
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

public class key_set implements IRemote{
	public static key_set mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public key_set() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("key_set"), "lnk.wifi_keys.key_set");
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
		pcBA = new PCBA(this, key_set.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _key_set_load = RemoteObject.createImmutable(false);
public static RemoteObject _setbut_tmr = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _scview = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _chk = null;
public static RemoteObject _lab = null;
public static RemoteObject _txt = null;
public static RemoteObject _font_size = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lfont_size = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _v_size = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lv_size = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _h_size = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _lh_size = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _save_ks_but = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _key_n = RemoteObject.createImmutable(0);
public static lnk.wifi_keys.main _main = null;
public static lnk.wifi_keys.starter _starter = null;
public static lnk.wifi_keys.statemanager _statemanager = null;
public static lnk.wifi_keys.sel_dev _sel_dev = null;
public static lnk.wifi_keys.ap_set _ap_set = null;
public static lnk.wifi_keys.cm _cm = null;
public static lnk.wifi_keys.inet_set _inet_set = null;
public static lnk.wifi_keys.sta_set _sta_set = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",key_set.mostCurrent._activity,"AP_SET",Debug.moduleToString(lnk.wifi_keys.ap_set.class),"chk",key_set.mostCurrent._chk,"CM",Debug.moduleToString(lnk.wifi_keys.cm.class),"font_size",key_set.mostCurrent._font_size,"h_size",key_set.mostCurrent._h_size,"INET_SET",Debug.moduleToString(lnk.wifi_keys.inet_set.class),"key_n",key_set._key_n,"key_set_load",key_set._key_set_load,"lab",key_set.mostCurrent._lab,"lfont_size",key_set.mostCurrent._lfont_size,"lh_size",key_set.mostCurrent._lh_size,"lv_size",key_set.mostCurrent._lv_size,"Main",Debug.moduleToString(lnk.wifi_keys.main.class),"save_ks_but",key_set.mostCurrent._save_ks_but,"scview",key_set.mostCurrent._scview,"sel_dev",Debug.moduleToString(lnk.wifi_keys.sel_dev.class),"setbut_tmr",key_set.mostCurrent._setbut_tmr,"STA_SET",Debug.moduleToString(lnk.wifi_keys.sta_set.class),"Starter",Debug.moduleToString(lnk.wifi_keys.starter.class),"StateManager",Debug.moduleToString(lnk.wifi_keys.statemanager.class),"txt",key_set.mostCurrent._txt,"v_size",key_set.mostCurrent._v_size};
}
}