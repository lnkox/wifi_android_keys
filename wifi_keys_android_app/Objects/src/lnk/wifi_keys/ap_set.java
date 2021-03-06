package lnk.wifi_keys;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class ap_set extends Activity implements B4AActivity{
	public static ap_set mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new BA(this.getApplicationContext(), null, null, "lnk.wifi_keys", "lnk.wifi_keys.ap_set");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (ap_set).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "lnk.wifi_keys", "lnk.wifi_keys.ap_set");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "lnk.wifi_keys.ap_set", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (ap_set) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (ap_set) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return ap_set.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (ap_set) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (ap_set) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}

public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.EditTextWrapper _ap_pass_txt = null;
public anywheresoftware.b4a.objects.EditTextWrapper _ap_ssid_txt = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _hide_ssid_chk = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _save_ap_set_btn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _ap_mode_chk = null;
public anywheresoftware.b4a.objects.EditTextWrapper _menu_pass_txt = null;
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 24;BA.debugLine="Try";
try { //BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"ap_set\")";
mostCurrent._activity.LoadLayout("ap_set",mostCurrent.activityBA);
 //BA.debugLineNum = 26;BA.debugLine="clear_field";
_clear_field();
 //BA.debugLineNum = 27;BA.debugLine="Activity.Title =\"AP setup - \" & StateManager.Get";
mostCurrent._activity.setTitle((Object)("AP setup - "+mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
 //BA.debugLineNum = 28;BA.debugLine="menu_pass_txt.Text =StateManager.getSetting2(\"me";
mostCurrent._menu_pass_txt.setText((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"menu_pass","")));
 //BA.debugLineNum = 29;BA.debugLine="get_apset";
_get_apset();
 } 
       catch (Exception e20) {
			processBA.setLastException(e20); //BA.debugLineNum = 31;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public static String  _clear_field() throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Sub clear_field()";
 //BA.debugLineNum = 60;BA.debugLine="Try";
try { //BA.debugLineNum = 61;BA.debugLine="ap_ssid_txt.Text=\"no connect\"";
mostCurrent._ap_ssid_txt.setText((Object)("no connect"));
 //BA.debugLineNum = 62;BA.debugLine="ap_pass_txt.Text=\"no connect\"";
mostCurrent._ap_pass_txt.setText((Object)("no connect"));
 //BA.debugLineNum = 63;BA.debugLine="hide_ssid_chk.Checked =False";
mostCurrent._hide_ssid_chk.setChecked(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 64;BA.debugLine="ap_mode_chk.Checked=False";
mostCurrent._ap_mode_chk.setChecked(anywheresoftware.b4a.keywords.Common.False);
 } 
       catch (Exception e48) {
			processBA.setLastException(e48); //BA.debugLineNum = 66;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public static String  _finish_him() throws Exception{
 //BA.debugLineNum = 92;BA.debugLine="Sub finish_him()";
 //BA.debugLineNum = 93;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 94;BA.debugLine="End Sub";
return "";
}
public static String  _get_apset() throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 70;BA.debugLine="Sub get_apset()";
 //BA.debugLineNum = 71;BA.debugLine="Try";
try { //BA.debugLineNum = 72;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 73;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 74;BA.debugLine="Data.Put (\"getapset\",1)";
_data.Put((Object)("getapset"),(Object)(1));
 //BA.debugLineNum = 75;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e58) {
			processBA.setLastException(e58); //BA.debugLineNum = 77;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 13;BA.debugLine="Private ap_pass_txt As EditText";
mostCurrent._ap_pass_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private ap_ssid_txt As EditText";
mostCurrent._ap_ssid_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private hide_ssid_chk As CheckBox";
mostCurrent._hide_ssid_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private save_ap_set_btn As Button";
mostCurrent._save_ap_set_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private ap_mode_chk As CheckBox";
mostCurrent._ap_mode_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private menu_pass_txt As EditText";
mostCurrent._menu_pass_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _menu_pass_txt_textchanged(String _old,String _new) throws Exception{
 //BA.debugLineNum = 100;BA.debugLine="Sub menu_pass_txt_TextChanged (Old As String, New";
 //BA.debugLineNum = 101;BA.debugLine="StateManager.SetSetting(\"menu_pass\",New)";
mostCurrent._statemanager._setsetting(mostCurrent.activityBA,"menu_pass",_new);
 //BA.debugLineNum = 102;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(mostCurrent.activityBA);
 //BA.debugLineNum = 103;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
 //BA.debugLineNum = 96;BA.debugLine="Sub proces_error(msg As String)";
 //BA.debugLineNum = 97;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",mostCurrent.activityBA);
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _save_ap_set_btn_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 44;BA.debugLine="Sub save_ap_set_btn_Click";
 //BA.debugLineNum = 45;BA.debugLine="Try";
try { //BA.debugLineNum = 46;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 47;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 48;BA.debugLine="Data.Put (\"ssid_ap\",ap_ssid_txt.Text)";
_data.Put((Object)("ssid_ap"),(Object)(mostCurrent._ap_ssid_txt.getText()));
 //BA.debugLineNum = 49;BA.debugLine="Data.Put (\"pass_ap\",ap_pass_txt.Text)";
_data.Put((Object)("pass_ap"),(Object)(mostCurrent._ap_pass_txt.getText()));
 //BA.debugLineNum = 50;BA.debugLine="Data.Put (\"hide_ssid\",hide_ssid_chk.Checked)";
_data.Put((Object)("hide_ssid"),(Object)(mostCurrent._hide_ssid_chk.getChecked()));
 //BA.debugLineNum = 51;BA.debugLine="Data.Put (\"mode_ap\",ap_mode_chk.Checked)";
_data.Put((Object)("mode_ap"),(Object)(mostCurrent._ap_mode_chk.getChecked()));
 //BA.debugLineNum = 52;BA.debugLine="Data.Put (\"save_info\",1)";
_data.Put((Object)("save_info"),(Object)(1));
 //BA.debugLineNum = 53;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e38) {
			processBA.setLastException(e38); //BA.debugLineNum = 55;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public static String  _set_ap_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub set_ap_set (mapar As Map)";
 //BA.debugLineNum = 83;BA.debugLine="Try";
try { //BA.debugLineNum = 84;BA.debugLine="If mapar.ContainsKey(\"ssid_ap\")=True Then  ap_ssi";
if (_mapar.ContainsKey((Object)("ssid_ap"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._ap_ssid_txt.setText(_mapar.Get((Object)("ssid_ap")));};
 //BA.debugLineNum = 85;BA.debugLine="If mapar.ContainsKey(\"pass_ap\")=True Then  ap_pas";
if (_mapar.ContainsKey((Object)("pass_ap"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._ap_pass_txt.setText(_mapar.Get((Object)("pass_ap")));};
 //BA.debugLineNum = 86;BA.debugLine="If mapar.ContainsKey(\"hide_ssid\")=True Then  hide";
if (_mapar.ContainsKey((Object)("hide_ssid"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._hide_ssid_chk.setChecked(mostCurrent._cm._obj2bool(mostCurrent.activityBA,_mapar.Get((Object)("hide_ssid"))));};
 //BA.debugLineNum = 87;BA.debugLine="If mapar.ContainsKey(\"mode_ap\")=True Then  ap_mod";
if (_mapar.ContainsKey((Object)("mode_ap"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._ap_mode_chk.setChecked(mostCurrent._cm._obj2bool(mostCurrent.activityBA,_mapar.Get((Object)("mode_ap"))));};
 } 
       catch (Exception e68) {
			processBA.setLastException(e68); //BA.debugLineNum = 89;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
}
