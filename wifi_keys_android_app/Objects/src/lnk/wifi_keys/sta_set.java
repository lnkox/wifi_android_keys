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

public class sta_set extends Activity implements B4AActivity{
	public static sta_set mostCurrent;
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
			processBA = new BA(this.getApplicationContext(), null, null, "lnk.wifi_keys", "lnk.wifi_keys.sta_set");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (sta_set).");
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
		activityBA = new BA(this, layout, processBA, "lnk.wifi_keys", "lnk.wifi_keys.sta_set");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "lnk.wifi_keys.sta_set", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (sta_set) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (sta_set) Resume **");
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
		return sta_set.class;
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
        BA.LogInfo("** Activity (sta_set) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (sta_set) Resume **");
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
public anywheresoftware.b4a.objects.EditTextWrapper _sta_pass_txt = null;
public anywheresoftware.b4a.objects.EditTextWrapper _sta_ssid_txt = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _label2 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _save_sta_set_btn = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _sta_mode_chk = null;
public anywheresoftware.b4a.objects.EditTextWrapper _batt_dev_txt = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 22;BA.debugLine="Try";
try { //BA.debugLineNum = 23;BA.debugLine="Activity.LoadLayout(\"sta_set\")";
mostCurrent._activity.LoadLayout("sta_set",mostCurrent.activityBA);
 //BA.debugLineNum = 24;BA.debugLine="clear_field";
_clear_field();
 //BA.debugLineNum = 25;BA.debugLine="Activity.Title =\"WFclient setup - \" & StateManage";
mostCurrent._activity.setTitle((Object)("WFclient setup - "+mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
 //BA.debugLineNum = 26;BA.debugLine="get_staset";
_get_staset();
 } 
       catch (Exception e19) {
			processBA.setLastException(e19); //BA.debugLineNum = 28;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _clear_field() throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Sub clear_field()";
 //BA.debugLineNum = 58;BA.debugLine="Try";
try { //BA.debugLineNum = 59;BA.debugLine="sta_ssid_txt.Text=\"no connect\"";
mostCurrent._sta_ssid_txt.setText((Object)("no connect"));
 //BA.debugLineNum = 60;BA.debugLine="sta_pass_txt.Text=\"no connect\"";
mostCurrent._sta_pass_txt.setText((Object)("no connect"));
 //BA.debugLineNum = 61;BA.debugLine="sta_mode_chk.Checked=False";
mostCurrent._sta_mode_chk.setChecked(anywheresoftware.b4a.keywords.Common.False);
 } 
       catch (Exception e47) {
			processBA.setLastException(e47); //BA.debugLineNum = 63;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 65;BA.debugLine="End Sub";
return "";
}
public static String  _finish_him() throws Exception{
 //BA.debugLineNum = 89;BA.debugLine="Sub finish_him()";
 //BA.debugLineNum = 90;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _get_staset() throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 67;BA.debugLine="Sub get_staset()";
 //BA.debugLineNum = 68;BA.debugLine="Try";
try { //BA.debugLineNum = 69;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 70;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 71;BA.debugLine="Data.Put (\"getstaset\",1)";
_data.Put((Object)("getstaset"),(Object)(1));
 //BA.debugLineNum = 72;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e57) {
			processBA.setLastException(e57); //BA.debugLineNum = 74;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 9;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 11;BA.debugLine="Private sta_pass_txt As EditText";
mostCurrent._sta_pass_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 12;BA.debugLine="Private sta_ssid_txt As EditText";
mostCurrent._sta_ssid_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private Label1 As Label";
mostCurrent._label1 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private Label2 As Label";
mostCurrent._label2 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private save_sta_set_btn As Button";
mostCurrent._save_sta_set_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private sta_mode_chk As CheckBox";
mostCurrent._sta_mode_chk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private batt_dev_txt As EditText";
mostCurrent._batt_dev_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private Label3 As Label";
mostCurrent._label3 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
 //BA.debugLineNum = 93;BA.debugLine="Sub proces_error(msg As String)";
 //BA.debugLineNum = 94;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",mostCurrent.activityBA);
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="End Sub";
return "";
}
public static String  _save_sta_set_btn_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 41;BA.debugLine="Sub save_sta_set_btn_Click";
 //BA.debugLineNum = 42;BA.debugLine="Try";
try { //BA.debugLineNum = 43;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 44;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 45;BA.debugLine="Data.Put (\"ssid_sta\",sta_ssid_txt.Text)";
_data.Put((Object)("ssid_sta"),(Object)(mostCurrent._sta_ssid_txt.getText()));
 //BA.debugLineNum = 46;BA.debugLine="Data.Put (\"pass_sta\",sta_pass_txt.Text)";
_data.Put((Object)("pass_sta"),(Object)(mostCurrent._sta_pass_txt.getText()));
 //BA.debugLineNum = 47;BA.debugLine="Data.Put (\"batt_dev\",batt_dev_txt.Text)";
_data.Put((Object)("batt_dev"),(Object)(mostCurrent._batt_dev_txt.getText()));
 //BA.debugLineNum = 48;BA.debugLine="Data.Put (\"mode_sta\",sta_mode_chk.Checked)";
_data.Put((Object)("mode_sta"),(Object)(mostCurrent._sta_mode_chk.getChecked()));
 //BA.debugLineNum = 49;BA.debugLine="Data.Put (\"save_info\",2)";
_data.Put((Object)("save_info"),(Object)(2));
 //BA.debugLineNum = 50;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 //BA.debugLineNum = 51;BA.debugLine="StateManager.SetSetting(\"batt_dev\", CM.toint(batt";
mostCurrent._statemanager._setsetting(mostCurrent.activityBA,"batt_dev",BA.NumberToString(mostCurrent._cm._toint(mostCurrent.activityBA,mostCurrent._batt_dev_txt.getText())));
 } 
       catch (Exception e38) {
			processBA.setLastException(e38); //BA.debugLineNum = 53;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static String  _set_sta_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub set_sta_set (mapar As Map)";
 //BA.debugLineNum = 79;BA.debugLine="Try";
try { //BA.debugLineNum = 80;BA.debugLine="If mapar.ContainsKey(\"ssid_sta\")=True Then  sta_s";
if (_mapar.ContainsKey((Object)("ssid_sta"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._sta_ssid_txt.setText(_mapar.Get((Object)("ssid_sta")));};
 //BA.debugLineNum = 81;BA.debugLine="If mapar.ContainsKey(\"pass_sta\")=True Then  sta_p";
if (_mapar.ContainsKey((Object)("pass_sta"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._sta_pass_txt.setText(_mapar.Get((Object)("pass_sta")));};
 //BA.debugLineNum = 82;BA.debugLine="If mapar.ContainsKey(\"batt_dev\")=True Then  batt_";
if (_mapar.ContainsKey((Object)("batt_dev"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._batt_dev_txt.setText(_mapar.Get((Object)("batt_dev")));};
 //BA.debugLineNum = 83;BA.debugLine="If mapar.ContainsKey(\"mode_sta\")=True Then  sta_m";
if (_mapar.ContainsKey((Object)("mode_sta"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._sta_mode_chk.setChecked(mostCurrent._cm._obj2bool(mostCurrent.activityBA,_mapar.Get((Object)("mode_sta"))));};
 } 
       catch (Exception e67) {
			processBA.setLastException(e67); //BA.debugLineNum = 85;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
}
