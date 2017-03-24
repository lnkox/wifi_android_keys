
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

public class inet_set implements IRemote{
	public static inet_set mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public inet_set() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("inet_set"), "lnk.wifi_keys.inet_set");
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
		pcBA = new PCBA(this, inet_set.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _inet_devname_txt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _inet_login_txt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _inet_pass_txt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _inet_port_txt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _inet_server_txt = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _label5 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _save_ap_set_btn = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static lnk.wifi_keys.main _main = null;
public static lnk.wifi_keys.starter _starter = null;
public static lnk.wifi_keys.statemanager _statemanager = null;
public static lnk.wifi_keys.sel_dev _sel_dev = null;
public static lnk.wifi_keys.ap_set _ap_set = null;
public static lnk.wifi_keys.sta_set _sta_set = null;
public static lnk.wifi_keys.key_set _key_set = null;
public static lnk.wifi_keys.cm _cm = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",inet_set.mostCurrent._activity,"AP_SET",Debug.moduleToString(lnk.wifi_keys.ap_set.class),"CM",Debug.moduleToString(lnk.wifi_keys.cm.class),"inet_devname_txt",inet_set.mostCurrent._inet_devname_txt,"inet_login_txt",inet_set.mostCurrent._inet_login_txt,"inet_pass_txt",inet_set.mostCurrent._inet_pass_txt,"inet_port_txt",inet_set.mostCurrent._inet_port_txt,"inet_server_txt",inet_set.mostCurrent._inet_server_txt,"KEY_SET",Debug.moduleToString(lnk.wifi_keys.key_set.class),"Label1",inet_set.mostCurrent._label1,"Label2",inet_set.mostCurrent._label2,"Label3",inet_set.mostCurrent._label3,"Label4",inet_set.mostCurrent._label4,"Label5",inet_set.mostCurrent._label5,"Main",Debug.moduleToString(lnk.wifi_keys.main.class),"save_ap_set_btn",inet_set.mostCurrent._save_ap_set_btn,"sel_dev",Debug.moduleToString(lnk.wifi_keys.sel_dev.class),"STA_SET",Debug.moduleToString(lnk.wifi_keys.sta_set.class),"Starter",Debug.moduleToString(lnk.wifi_keys.starter.class),"StateManager",Debug.moduleToString(lnk.wifi_keys.statemanager.class)};
}
}