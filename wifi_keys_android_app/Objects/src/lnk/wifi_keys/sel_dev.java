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

public class sel_dev extends Activity implements B4AActivity{
	public static sel_dev mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "lnk.wifi_keys", "lnk.wifi_keys.sel_dev");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (sel_dev).");
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
		activityBA = new BA(this, layout, processBA, "lnk.wifi_keys", "lnk.wifi_keys.sel_dev");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "lnk.wifi_keys.sel_dev", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (sel_dev) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (sel_dev) Resume **");
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
		return sel_dev.class;
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
        BA.LogInfo("** Activity (sel_dev) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (sel_dev) Resume **");
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



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Timer _mgetbut_tmr = null;
public anywheresoftware.b4a.objects.ListViewWrapper _dev_list = null;
public static int _key_n = 0;
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Activity.LoadLayout(\"sel_dev_lay\")";
mostCurrent._activity.LoadLayout("sel_dev_lay",mostCurrent.activityBA);
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="get_name";
_get_name();
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="End Sub";
return "";
}
public static String  _get_name() throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("get_name"))
	return (String) Debug.delegate(mostCurrent.activityBA, "get_name", null);
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub get_name()";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="Try";
try {RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=3342339;
 //BA.debugLineNum = 3342339;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="Data.Put (\"getname\",1)";
_data.Put((Object)("getname"),(Object)(1));
RDebugUtils.currentLine=3342341;
 //BA.debugLineNum = 3342341;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e30) {
			processBA.setLastException(e30);RDebugUtils.currentLine=3342343;
 //BA.debugLineNum = 3342343;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=3342345;
 //BA.debugLineNum = 3342345;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("activity_pause"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_pause", new Object[] {_userclosed});
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="End Sub";
return "";
}
public static String  _add_dev_tolist(String _dev_name,String _dev_ip) throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("add_dev_tolist"))
	return (String) Debug.delegate(mostCurrent.activityBA, "add_dev_tolist", new Object[] {_dev_name,_dev_ip});
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub add_dev_tolist(dev_name As String,dev_ip As St";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="dev_list.AddTwoLines(dev_name,dev_ip)";
mostCurrent._dev_list.AddTwoLines(_dev_name,_dev_ip);
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="End Sub";
return "";
}
public static String  _clear_field() throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("clear_field"))
	return (String) Debug.delegate(mostCurrent.activityBA, "clear_field", null);
int _i = 0;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub clear_field()";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Try";
try {RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="For i = 1 To 30";
{
final int step2 = 1;
final int limit2 = (int) (30);
for (_i = (int) (1) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="StateManager.SetSetting(\"keytext\" & i,\"\")";
mostCurrent._statemanager._setsetting(mostCurrent.activityBA,"keytext"+BA.NumberToString(_i),"");
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="StateManager.SetSetting(\"keytag\" & i,\"\" )";
mostCurrent._statemanager._setsetting(mostCurrent.activityBA,"keytag"+BA.NumberToString(_i),"");
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="StateManager.SetSetting(\"keylock\" & i, False)";
mostCurrent._statemanager._setsetting(mostCurrent.activityBA,"keylock"+BA.NumberToString(_i),BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False));
 }
};
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="StateManager.SetSetting(\"font_size\", \"\")";
mostCurrent._statemanager._setsetting(mostCurrent.activityBA,"font_size","");
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="StateManager.SetSetting(\"h_size\", \"\")";
mostCurrent._statemanager._setsetting(mostCurrent.activityBA,"h_size","");
RDebugUtils.currentLine=3801097;
 //BA.debugLineNum = 3801097;BA.debugLine="StateManager.SetSetting(\"v_size\", \"\")";
mostCurrent._statemanager._setsetting(mostCurrent.activityBA,"v_size","");
RDebugUtils.currentLine=3801098;
 //BA.debugLineNum = 3801098;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(mostCurrent.activityBA);
 } 
       catch (Exception e90) {
			processBA.setLastException(e90);RDebugUtils.currentLine=3801100;
 //BA.debugLineNum = 3801100;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=3801102;
 //BA.debugLineNum = 3801102;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("proces_error"))
	return (String) Debug.delegate(mostCurrent.activityBA, "proces_error", new Object[] {_msg});
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub proces_error(msg As String)";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",mostCurrent.activityBA);
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="End Sub";
return "";
}
public static String  _dev_list_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("dev_list_itemclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "dev_list_itemclick", new Object[] {_position,_value});
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub dev_list_ItemClick (Position As Int, Value As";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="Try";
try {RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="StateManager.SetSetting(\"cur_dev_name\",dev_list.G";
mostCurrent._statemanager._setsetting(mostCurrent.activityBA,"cur_dev_name",BA.ObjectToString(mostCurrent._dev_list.GetItem(_position)));
RDebugUtils.currentLine=3276803;
 //BA.debugLineNum = 3276803;BA.debugLine="load_keys";
_load_keys();
 } 
       catch (Exception e20) {
			processBA.setLastException(e20);RDebugUtils.currentLine=3276805;
 //BA.debugLineNum = 3276805;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=3276807;
 //BA.debugLineNum = 3276807;BA.debugLine="End Sub";
return "";
}
public static String  _load_keys() throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("load_keys"))
	return (String) Debug.delegate(mostCurrent.activityBA, "load_keys", null);
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub load_keys()";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Try";
try {RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="ToastMessageShow(\"Loading data...\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Loading data...",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="clear_field";
_clear_field();
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="get_key_info";
_get_key_info();
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="key_n=0";
_key_n = (int) (0);
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="mgetbut_tmr.Initialize(\"mgetbut_tmr\", 210)";
_mgetbut_tmr.Initialize(processBA,"mgetbut_tmr",(long) (210));
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="mgetbut_tmr.Enabled =True";
_mgetbut_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e45) {
			processBA.setLastException(e45);RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="End Sub";
return "";
}
public static String  _finish_him() throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("finish_him"))
	return (String) Debug.delegate(mostCurrent.activityBA, "finish_him", null);
RDebugUtils.currentLine=7143424;
 //BA.debugLineNum = 7143424;BA.debugLine="Sub finish_him()";
RDebugUtils.currentLine=7143425;
 //BA.debugLineNum = 7143425;BA.debugLine="CallSubDelayed(Main,\"add_key_to_panel\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._main.getObject()),"add_key_to_panel");
RDebugUtils.currentLine=7143426;
 //BA.debugLineNum = 7143426;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=7143428;
 //BA.debugLineNum = 7143428;BA.debugLine="End Sub";
return "";
}
public static String  _get_key(int _ind) throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("get_key"))
	return (String) Debug.delegate(mostCurrent.activityBA, "get_key", new Object[] {_ind});
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub get_key(ind As Int)";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Try";
try {RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="Data.Put (\"getkey\",ind)";
_data.Put((Object)("getkey"),(Object)(_ind));
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e64) {
			processBA.setLastException(e64);RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="End Sub";
return "";
}
public static String  _get_key_info() throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("get_key_info"))
	return (String) Debug.delegate(mostCurrent.activityBA, "get_key_info", null);
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub get_key_info()";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Try";
try {RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="Data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
_data.Put((Object)("dev_name"),(Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="Data.Put (\"getkey_info\",1)";
_data.Put((Object)("getkey_info"),(Object)(1));
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e75) {
			processBA.setLastException(e75);RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="End Sub";
return "";
}
public static String  _mgetbut_tmr_tick() throws Exception{
RDebugUtils.currentModule="sel_dev";
if (Debug.shouldDelegate("mgetbut_tmr_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mgetbut_tmr_tick", null);
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub mgetbut_tmr_Tick()";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="Try";
try {RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="key_n=key_n+1";
_key_n = (int) (_key_n+1);
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="get_key(key_n)";
_get_key(_key_n);
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="If key_n=30 Then mgetbut_tmr.Enabled =False";
if (_key_n==30) { 
_mgetbut_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.False);};
 } 
       catch (Exception e54) {
			processBA.setLastException(e54);RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="End Sub";
return "";
}
}