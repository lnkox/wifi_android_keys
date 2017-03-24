
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

public class ap_set implements IRemote{
	public static ap_set mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public ap_set() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("ap_set"), "lnk.wifi_keys.ap_set");
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
		pcBA = new PCBA(this, ap_set.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _ap_pass_txt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _ap_ssid_txt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _hide_ssid_chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _save_ap_set_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _ap_mode_chk = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static lnk.wifi_keys.main _main = null;
public static lnk.wifi_keys.starter _starter = null;
public static lnk.wifi_keys.statemanager _statemanager = null;
public static lnk.wifi_keys.sel_dev _sel_dev = null;
public static lnk.wifi_keys.sta_set _sta_set = null;
public static lnk.wifi_keys.key_set _key_set = null;
public static lnk.wifi_keys.cm _cm = null;
public static lnk.wifi_keys.inet_set _inet_set = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",ap_set.mostCurrent._activity,"ap_mode_chk",ap_set.mostCurrent._ap_mode_chk,"ap_pass_txt",ap_set.mostCurrent._ap_pass_txt,"ap_ssid_txt",ap_set.mostCurrent._ap_ssid_txt,"CM",Debug.moduleToString(lnk.wifi_keys.cm.class),"hide_ssid_chk",ap_set.mostCurrent._hide_ssid_chk,"INET_SET",Debug.moduleToString(lnk.wifi_keys.inet_set.class),"KEY_SET",Debug.moduleToString(lnk.wifi_keys.key_set.class),"Label1",ap_set.mostCurrent._label1,"Label2",ap_set.mostCurrent._label2,"Main",Debug.moduleToString(lnk.wifi_keys.main.class),"save_ap_set_btn",ap_set.mostCurrent._save_ap_set_btn,"sel_dev",Debug.moduleToString(lnk.wifi_keys.sel_dev.class),"STA_SET",Debug.moduleToString(lnk.wifi_keys.sta_set.class),"Starter",Debug.moduleToString(lnk.wifi_keys.starter.class),"StateManager",Debug.moduleToString(lnk.wifi_keys.statemanager.class)};
}
}