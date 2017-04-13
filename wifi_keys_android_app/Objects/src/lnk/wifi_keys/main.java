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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "lnk.wifi_keys", "lnk.wifi_keys.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "lnk.wifi_keys", "lnk.wifi_keys.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "lnk.wifi_keys.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (sel_dev.mostCurrent != null);
vis = vis | (ap_set.mostCurrent != null);
vis = vis | (key_set.mostCurrent != null);
vis = vis | (inet_set.mostCurrent != null);
vis = vis | (sta_set.mostCurrent != null);
return vis;}

public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = main.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (sel_dev.previousOne != null) {
				__a = sel_dev.previousOne.get();
			}
            else {
                BA ba = sel_dev.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (ap_set.previousOne != null) {
				__a = ap_set.previousOne.get();
			}
            else {
                BA ba = ap_set.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (key_set.previousOne != null) {
				__a = key_set.previousOne.get();
			}
            else {
                BA ba = key_set.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (inet_set.previousOne != null) {
				__a = inet_set.previousOne.get();
			}
            else {
                BA ba = inet_set.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (sta_set.previousOne != null) {
				__a = sta_set.previousOne.get();
			}
            else {
                BA ba = sta_set.mostCurrent.processBA.sharedProcessBA.activityBA.get();
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static int _conect_tmout = 0;
public static anywheresoftware.b4a.objects.Timer _send_state_timer = null;
public static boolean _antidouble = false;
public com.AB.ABWifi.ABWifi _wifi = null;
public static int _wifisignal = 0;
public anywheresoftware.b4a.objects.ButtonWrapper[] _butt = null;
public anywheresoftware.b4a.objects.LabelWrapper _mqtt_but = null;
public anywheresoftware.b4a.objects.LabelWrapper _status_lab = null;
public static boolean[] _butlock = null;
public static boolean[] _butstate = null;
public anywheresoftware.b4a.objects.drawable.StateListDrawable _sld_norm = null;
public anywheresoftware.b4a.objects.drawable.StateListDrawable _sld_on = null;
public anywheresoftware.b4a.objects.drawable.StateListDrawable _sld_down = null;
public anywheresoftware.b4a.objects.drawable.ColorDrawable _prs = null;
public anywheresoftware.b4a.objects.drawable.ColorDrawable _ups = null;
public anywheresoftware.b4a.objects.drawable.ColorDrawable _grn = null;
public anywheresoftware.b4a.objects.EditTextWrapper _menu_pass_txt = null;
public static int _cur_but_state = 0;
public static int _prs_but = 0;
public static String _enter_menu_pass = "";
public static boolean _allow_menu = false;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _tbuts = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Try";
try {RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="Activity.AddMenuItem(\"Keys set\",\"keys_set\")";
mostCurrent._activity.AddMenuItem("Keys set","keys_set");
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi AP set\",\"wf_ap_set";
mostCurrent._activity.AddMenuItem("Wi-Fi AP set","wf_ap_set");
RDebugUtils.currentLine=131077;
 //BA.debugLineNum = 131077;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi client set\",\"wf_ST";
mostCurrent._activity.AddMenuItem("Wi-Fi client set","wf_STA_set");
RDebugUtils.currentLine=131078;
 //BA.debugLineNum = 131078;BA.debugLine="Activity.AddMenuItem(\"Select device\",\"sel_dev\")";
mostCurrent._activity.AddMenuItem("Select device","sel_dev");
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Activity.AddMenuItem(\"Inet set\",\"inet_setm\")";
mostCurrent._activity.AddMenuItem("Inet set","inet_setm");
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="Activity.AddMenuItem(\"Reset device\",\"reset_dev\")";
mostCurrent._activity.AddMenuItem("Reset device","reset_dev");
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="Activity.AddMenuItem(\"EXIT\",\"exit_prg\")";
mostCurrent._activity.AddMenuItem("EXIT","exit_prg");
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="prs.Initialize(Colors.Gray,0dip)";
mostCurrent._prs.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Gray,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="ups.Initialize(Colors.DarkGray, 0dip)";
mostCurrent._ups.Initialize(anywheresoftware.b4a.keywords.Common.Colors.DarkGray,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="grn.Initialize(Colors.RGB(0,150,0), 0dip)";
mostCurrent._grn.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (150),(int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
RDebugUtils.currentLine=131085;
 //BA.debugLineNum = 131085;BA.debugLine="sld_norm.Initialize";
mostCurrent._sld_norm.Initialize();
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="sld_norm.AddState(sld_norm.State_Pressed, ups)";
mostCurrent._sld_norm.AddState(mostCurrent._sld_norm.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._ups.getObject()));
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="sld_norm.AddState(sld_norm.State_Enabled,ups)";
mostCurrent._sld_norm.AddState(mostCurrent._sld_norm.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._ups.getObject()));
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="sld_norm.AddState(sld_on.State_Focused, ups)";
mostCurrent._sld_norm.AddState(mostCurrent._sld_on.State_Focused,(android.graphics.drawable.Drawable)(mostCurrent._ups.getObject()));
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="sld_on.Initialize";
mostCurrent._sld_on.Initialize();
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="sld_on.AddState(sld_on.State_Pressed, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="sld_on.AddState(sld_on.State_Enabled, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="sld_on.AddState(sld_on.State_Disabled, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Disabled,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="sld_on.AddState(sld_on.State_Focused, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Focused,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="sld_down.Initialize";
mostCurrent._sld_down.Initialize();
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="sld_down.AddState(sld_on.State_Pressed, prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="sld_down.AddState(sld_on.State_Enabled, prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="sld_down.AddState(sld_on.State_Disabled,prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Disabled,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="sld_down.AddState(sld_on.State_Focused,prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Focused,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="status_lab.Initialize(\"status_lab\")";
mostCurrent._status_lab.Initialize(mostCurrent.activityBA,"status_lab");
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="status_lab.TextColor=Colors.Red";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="status_lab.Text = \"No connected\"";
mostCurrent._status_lab.setText((Object)("No connected"));
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="Activity.AddView(status_lab, 0dip, Activity.He";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._status_lab.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="mqtt_but.Initialize (\"mqtt_but\")";
mostCurrent._mqtt_but.Initialize(mostCurrent.activityBA,"mqtt_but");
RDebugUtils.currentLine=131104;
 //BA.debugLineNum = 131104;BA.debugLine="mqtt_but.Text =\"MQTT\"";
mostCurrent._mqtt_but.setText((Object)("MQTT"));
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="mqtt_but.TextSize=12";
mostCurrent._mqtt_but.setTextSize((float) (12));
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="Activity.AddView(mqtt_but,Activity.Width-50dip, A";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._mqtt_but.getObject()),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=131107;
 //BA.debugLineNum = 131107;BA.debugLine="If CM.connect_type=True Then";
if (mostCurrent._cm._connect_type==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="mqtt_but.textColor=Colors.Green";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 }else {
RDebugUtils.currentLine=131110;
 //BA.debugLineNum = 131110;BA.debugLine="mqtt_but.textColor=Colors.Gray";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 };
RDebugUtils.currentLine=131112;
 //BA.debugLineNum = 131112;BA.debugLine="wifi.Initialize(\"wifi\")";
mostCurrent._wifi.Initialize(processBA,"wifi");
RDebugUtils.currentLine=131113;
 //BA.debugLineNum = 131113;BA.debugLine="For i = 1 To 32";
{
final int step40 = 1;
final int limit40 = (int) (32);
for (_i = (int) (1) ; (step40 > 0 && _i <= limit40) || (step40 < 0 && _i >= limit40); _i = ((int)(0 + _i + step40)) ) {
RDebugUtils.currentLine=131114;
 //BA.debugLineNum = 131114;BA.debugLine="Dim tbuts As Button";
_tbuts = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=131115;
 //BA.debugLineNum = 131115;BA.debugLine="tbuts.Initialize(\"tbuts\")";
_tbuts.Initialize(mostCurrent.activityBA,"tbuts");
RDebugUtils.currentLine=131116;
 //BA.debugLineNum = 131116;BA.debugLine="Activity.AddView(tbuts, -2000dip, 0, 20dip";
mostCurrent._activity.AddView((android.view.View)(_tbuts.getObject()),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2000))),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=131117;
 //BA.debugLineNum = 131117;BA.debugLine="tbuts.Background=sld_norm";
_tbuts.setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
RDebugUtils.currentLine=131118;
 //BA.debugLineNum = 131118;BA.debugLine="butt(i)=tbuts";
mostCurrent._butt[_i] = _tbuts;
 }
};
RDebugUtils.currentLine=131120;
 //BA.debugLineNum = 131120;BA.debugLine="add_key_to_panel";
_add_key_to_panel();
RDebugUtils.currentLine=131121;
 //BA.debugLineNum = 131121;BA.debugLine="menu_pass_txt.Initialize(\"menu_pass_txt\")";
mostCurrent._menu_pass_txt.Initialize(mostCurrent.activityBA,"menu_pass_txt");
RDebugUtils.currentLine=131122;
 //BA.debugLineNum = 131122;BA.debugLine="menu_pass_txt.Visible =False";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131123;
 //BA.debugLineNum = 131123;BA.debugLine="menu_pass_txt.TextSize=6";
mostCurrent._menu_pass_txt.setTextSize((float) (6));
RDebugUtils.currentLine=131124;
 //BA.debugLineNum = 131124;BA.debugLine="menu_pass_txt.PasswordMode=True";
mostCurrent._menu_pass_txt.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131125;
 //BA.debugLineNum = 131125;BA.debugLine="Activity.AddView(menu_pass_txt,Activity.Width/2.5";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._menu_pass_txt.getObject()),(int) (mostCurrent._activity.getWidth()/(double)2.5),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),(int) (mostCurrent._activity.getWidth()/(double)5),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
RDebugUtils.currentLine=131126;
 //BA.debugLineNum = 131126;BA.debugLine="send_state_timer.Initialize(\"send_state_timer\",";
_send_state_timer.Initialize(processBA,"send_state_timer",(long) (1000));
RDebugUtils.currentLine=131127;
 //BA.debugLineNum = 131127;BA.debugLine="send_state_timer.Enabled =True";
_send_state_timer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e77) {
			processBA.setLastException(e77);RDebugUtils.currentLine=131131;
 //BA.debugLineNum = 131131;BA.debugLine="proces_error(LastException.Message & \"activ. cre";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"activ. creat");
 };
RDebugUtils.currentLine=131133;
 //BA.debugLineNum = 131133;BA.debugLine="End Sub";
return "";
}
public static String  _add_key_to_panel() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("add_key_to_panel"))
	return (String) Debug.delegate(mostCurrent.activityBA, "add_key_to_panel", null);
int _vert_size = 0;
int _horiz_size = 0;
int _font_size = 0;
int _b_width = 0;
int _b_height = 0;
int _posx = 0;
int _posy = 0;
int _max_but = 0;
int _a = 0;
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub add_key_to_panel() 'розміщення кнопок керуванн";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Try";
try {RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="Activity.Title =\"Wi-Fi keys - \" & StateManager.Ge";
mostCurrent._activity.setTitle((Object)("Wi-Fi keys - "+mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="clear_keys";
_clear_keys();
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="Dim vert_size As Int=CM.toint(StateManager.GetSet";
_vert_size = mostCurrent._cm._toint(mostCurrent.activityBA,mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"v_size",""));
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="Dim horiz_size As Int=CM.toint(StateManager.GetSe";
_horiz_size = mostCurrent._cm._toint(mostCurrent.activityBA,mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"h_size",""));
RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="Dim font_size As Int=CM.toint(StateManager.GetSet";
_font_size = mostCurrent._cm._toint(mostCurrent.activityBA,mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"font_size",""));
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="If vert_size <1 Then Return";
if (_vert_size<1) { 
if (true) return "";};
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="Dim b_width,b_height,posx,posy,max_but As Int";
_b_width = 0;
_b_height = 0;
_posx = 0;
_posy = 0;
_max_but = 0;
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="b_width=Activity.Width/horiz_size";
_b_width = (int) (mostCurrent._activity.getWidth()/(double)_horiz_size);
RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="b_height=(Activity.height-20dip)/vert_size";
_b_height = (int) ((mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)))/(double)_vert_size);
RDebugUtils.currentLine=1048588;
 //BA.debugLineNum = 1048588;BA.debugLine="max_but =horiz_size*vert_size";
_max_but = (int) (_horiz_size*_vert_size);
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="cur_but_state=0";
_cur_but_state = (int) (0);
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="For a=1 To 32";
{
final int step13 = 1;
final int limit13 = (int) (32);
for (_a = (int) (1) ; (step13 > 0 && _a <= limit13) || (step13 < 0 && _a >= limit13); _a = ((int)(0 + _a + step13)) ) {
RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="butt(a).Background=sld_norm";
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
RDebugUtils.currentLine=1048592;
 //BA.debugLineNum = 1048592;BA.debugLine="If CM.toint(StateManager.GetSetting2(\"keytag\" &";
if (mostCurrent._cm._toint(mostCurrent.activityBA,mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytag"+BA.NumberToString(_a),""))>0) { 
RDebugUtils.currentLine=1048593;
 //BA.debugLineNum = 1048593;BA.debugLine="If cur_but_state>=max_but Then Return";
if (_cur_but_state>=_max_but) { 
if (true) return "";};
RDebugUtils.currentLine=1048594;
 //BA.debugLineNum = 1048594;BA.debugLine="posy=cur_but_state/horiz_size";
_posy = (int) (_cur_but_state/(double)_horiz_size);
RDebugUtils.currentLine=1048595;
 //BA.debugLineNum = 1048595;BA.debugLine="posx=cur_but_state mod horiz_size";
_posx = (int) (_cur_but_state%_horiz_size);
RDebugUtils.currentLine=1048596;
 //BA.debugLineNum = 1048596;BA.debugLine="butlock(a)=CM.obj2Bool(StateManager.GetSetting2";
_butlock[_a] = mostCurrent._cm._obj2bool(mostCurrent.activityBA,(Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keylock"+BA.NumberToString(_a),BA.NumberToString(0))));
RDebugUtils.currentLine=1048597;
 //BA.debugLineNum = 1048597;BA.debugLine="butt(a).Text =StateManager.GetSetting2(\"keytext";
mostCurrent._butt[_a].setText((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytext"+BA.NumberToString(_a),"")));
RDebugUtils.currentLine=1048598;
 //BA.debugLineNum = 1048598;BA.debugLine="butt(a).tag =StateManager.GetSetting2(\"keytag\"";
mostCurrent._butt[_a].setTag((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytag"+BA.NumberToString(_a),"")));
RDebugUtils.currentLine=1048599;
 //BA.debugLineNum = 1048599;BA.debugLine="butt(a).Left =posx*(b_width+1dip)";
mostCurrent._butt[_a].setLeft((int) (_posx*(_b_width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
RDebugUtils.currentLine=1048600;
 //BA.debugLineNum = 1048600;BA.debugLine="butt(a).top =posy*(b_height+1dip)";
mostCurrent._butt[_a].setTop((int) (_posy*(_b_height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
RDebugUtils.currentLine=1048601;
 //BA.debugLineNum = 1048601;BA.debugLine="butt(a).width =b_width-2dip";
mostCurrent._butt[_a].setWidth((int) (_b_width-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1048602;
 //BA.debugLineNum = 1048602;BA.debugLine="butt(a).height =b_height-2dip";
mostCurrent._butt[_a].setHeight((int) (_b_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=1048603;
 //BA.debugLineNum = 1048603;BA.debugLine="butt(a).TextSize =font_size";
mostCurrent._butt[_a].setTextSize((float) (_font_size));
RDebugUtils.currentLine=1048604;
 //BA.debugLineNum = 1048604;BA.debugLine="If butlock(a)=True Then";
if (_butlock[_a]==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1048605;
 //BA.debugLineNum = 1048605;BA.debugLine="butt(a).TextColor =Colors.RGB(128,255,255)";
mostCurrent._butt[_a].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (128),(int) (255),(int) (255)));
 }else {
RDebugUtils.currentLine=1048607;
 //BA.debugLineNum = 1048607;BA.debugLine="butt(a).TextColor =Colors.RGB(255,255,255)";
mostCurrent._butt[_a].setTextColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (255),(int) (255)));
 };
RDebugUtils.currentLine=1048609;
 //BA.debugLineNum = 1048609;BA.debugLine="cur_but_state=cur_but_state+1";
_cur_but_state = (int) (_cur_but_state+1);
 };
 }
};
 } 
       catch (Exception e215) {
			processBA.setLastException(e215);RDebugUtils.currentLine=1048613;
 //BA.debugLineNum = 1048613;BA.debugLine="proces_error(LastException.Message & \"add_key_to";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"add_key_to_panel");
 };
RDebugUtils.currentLine=1048615;
 //BA.debugLineNum = 1048615;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("proces_error"))
	return (String) Debug.delegate(mostCurrent.activityBA, "proces_error", new Object[] {_msg});
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub proces_error(msg As String)";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",mostCurrent.activityBA);
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("activity_pause"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_pause", new Object[] {_userclosed});
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262145;
 //BA.debugLineNum = 262145;BA.debugLine="Try";
try {RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="wifi.StopWifi";
mostCurrent._wifi.StopWifi();
RDebugUtils.currentLine=262147;
 //BA.debugLineNum = 262147;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(mostCurrent.activityBA);
 } 
       catch (Exception e92) {
			processBA.setLastException(e92);RDebugUtils.currentLine=262149;
 //BA.debugLineNum = 262149;BA.debugLine="proces_error(LastException.Message & \"active.pau";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"active.pause");
 };
RDebugUtils.currentLine=262151;
 //BA.debugLineNum = 262151;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="Try";
try {RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="add_key_to_panel";
_add_key_to_panel();
 } 
       catch (Exception e84) {
			processBA.setLastException(e84);RDebugUtils.currentLine=196613;
 //BA.debugLineNum = 196613;BA.debugLine="proces_error(LastException.Message & \"active. re";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"active. resume");
 };
RDebugUtils.currentLine=196615;
 //BA.debugLineNum = 196615;BA.debugLine="End Sub";
return "";
}
public static String  _clear_keys() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("clear_keys"))
	return (String) Debug.delegate(mostCurrent.activityBA, "clear_keys", null);
int _i = 0;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub clear_keys";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Try";
try {RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="For i = 1 To 32";
{
final int step2 = 1;
final int limit2 = (int) (32);
for (_i = (int) (1) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="butt(i).Left =-2000";
mostCurrent._butt[_i].setLeft((int) (-2000));
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="butt(i).Tag =\"\"";
mostCurrent._butt[_i].setTag((Object)(""));
 }
};
 } 
       catch (Exception e102) {
			processBA.setLastException(e102);RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="proces_error(LastException.Message & \"clear.keys";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"clear.keys");
 };
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="End Sub";
return "";
}
public static String  _exit_prg_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("exit_prg_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "exit_prg_click", null);
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub exit_prg_click()";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="End Sub";
return "";
}
public static String  _get_rssi() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("get_rssi"))
	return (String) Debug.delegate(mostCurrent.activityBA, "get_rssi", null);
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub get_rssi() 'Відправка запиту на отримання рів";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Try";
try {RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="Data.Put (\"rssi\",1)";
_data.Put((Object)("rssi"),(Object)(1));
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e148) {
			processBA.setLastException(e148);RDebugUtils.currentLine=917511;
 //BA.debugLineNum = 917511;BA.debugLine="proces_error(LastException.Message & \"get_rssi\")";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"get_rssi");
 };
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="End Sub";
return "";
}
public static String  _inet_setm_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("inet_setm_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "inet_setm_click", null);
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub inet_setm_Click()";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="StartActivity(INET_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._inet_set.getObject()));
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="End Sub";
return "";
}
public static boolean  _valid_menu_pass() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("valid_menu_pass"))
	return (Boolean) Debug.delegate(mostCurrent.activityBA, "valid_menu_pass", null);
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub valid_menu_pass() As Boolean";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="If StateManager.getSetting2(\"menu_pass\",\"\").Lengt";
if (mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"menu_pass","").length()==0) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="If allow_menu=True Then Return True";
if (_allow_menu==anywheresoftware.b4a.keywords.Common.True) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="menu_pass_txt.Text =\"\"";
mostCurrent._menu_pass_txt.setText((Object)(""));
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="menu_pass_txt.Visible =True";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="End Sub";
return false;
}
public static String  _keys_set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("keys_set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "keys_set_click", null);
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub keys_set_Click()";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=1507330;
 //BA.debugLineNum = 1507330;BA.debugLine="StartActivity(KEY_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._key_set.getObject()));
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="End Sub";
return "";
}
public static String  _menu_pass_txt_enterpressed() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("menu_pass_txt_enterpressed"))
	return (String) Debug.delegate(mostCurrent.activityBA, "menu_pass_txt_enterpressed", null);
String _ppas = "";
String _ptxt = "";
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub menu_pass_txt_EnterPressed";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Dim ppas As String =StateManager.getSetting2(\"men";
_ppas = mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"menu_pass","");
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="Dim ptxt As String =menu_pass_txt.Text";
_ptxt = mostCurrent._menu_pass_txt.getText();
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="If ppas.EqualsIgnoreCase(ptxt)=True Then";
if (_ppas.equalsIgnoreCase(_ptxt)==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="ToastMessageShow(\"Corect\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Corect",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="allow_menu=True";
_allow_menu = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="ToastMessageShow(\"Invalid pass\",False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Invalid pass",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="allow_menu=False";
_allow_menu = anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=2031626;
 //BA.debugLineNum = 2031626;BA.debugLine="menu_pass_txt.Visible =False";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2031627;
 //BA.debugLineNum = 2031627;BA.debugLine="End Sub";
return "";
}
public static String  _menu_pass_txt_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("menu_pass_txt_textchanged"))
	return (String) Debug.delegate(mostCurrent.activityBA, "menu_pass_txt_textchanged", new Object[] {_old,_new});
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub menu_pass_txt_TextChanged(Old As String, New A";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="enter_menu_pass=New";
mostCurrent._enter_menu_pass = _new;
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_but_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("mqtt_but_longclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mqtt_but_longclick", null);
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub mqtt_but_LongClick";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="If CM.connect_type=True Then";
if (mostCurrent._cm._connect_type==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="CallSubDelayed(Starter,\"mqtt_disconnect\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"mqtt_disconnect");
 }else {
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="CallSubDelayed(Starter,\"mqtt_connect\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"mqtt_connect");
 };
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="End Sub";
return "";
}
public static String  _reset_dev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("reset_dev_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "reset_dev_click", null);
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub reset_dev_Click()";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="Try";
try {RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="Data.Put (\"rst\",1)";
_data.Put((Object)("rst"),(Object)(1));
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e300) {
			processBA.setLastException(e300);RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="proces_error(LastException.Message & \"reset_dev\"";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"reset_dev");
 };
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="End Sub";
return "";
}
public static String  _sel_dev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("sel_dev_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "sel_dev_click", null);
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub sel_dev_Click()";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=1310722;
 //BA.debugLineNum = 1310722;BA.debugLine="StartActivity(sel_dev)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sel_dev.getObject()));
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="End Sub";
return "";
}
public static String  _send_comm(int _ind,boolean _com,boolean _lock) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("send_comm"))
	return (String) Debug.delegate(mostCurrent.activityBA, "send_comm", new Object[] {_ind,_com,_lock});
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub send_comm(ind As Int,com As Boolean,lock As Bo";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Try";
try {RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="Data.Put (\"ncom\",ind)";
_data.Put((Object)("ncom"),(Object)(_ind));
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Data.Put (\"com\",com)";
_data.Put((Object)("com"),(Object)(_com));
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="Data.Put (\"lock\",lock)";
_data.Put((Object)("lock"),(Object)(_lock));
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e114) {
			processBA.setLastException(e114);RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="proces_error(LastException.Message & \"send_comm\"";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"send_comm");
 };
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="End Sub";
return "";
}
public static String  _send_state_timer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("send_state_timer_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "send_state_timer_tick", null);
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub send_state_timer_Tick() ' таймер перевірки звя";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Try";
try {RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="If prs_but>0 Then send_comm(prs_but,True,False)";
if (_prs_but>0) { 
_send_comm(_prs_but,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);};
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="get_rssi";
_get_rssi();
RDebugUtils.currentLine=786436;
 //BA.debugLineNum = 786436;BA.debugLine="If conect_tmout>0 Then";
if (_conect_tmout>0) { 
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="conect_tmout=conect_tmout-1";
_conect_tmout = (int) (_conect_tmout-1);
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="If conect_tmout=0 Then";
if (_conect_tmout==0) { 
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="status_lab.TextColor=Colors.Red";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="status_lab.Text = \"No connected\"";
mostCurrent._status_lab.setText((Object)("No connected"));
 };
 };
 } 
       catch (Exception e129) {
			processBA.setLastException(e129);RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="proces_error(LastException.Message & \"send_state";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"send_state_timer_tick");
 };
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="End Sub";
return "";
}
public static String  _set_mqtt_state(boolean _state) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("set_mqtt_state"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_mqtt_state", new Object[] {_state});
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub set_mqtt_state(state As Boolean)";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="CM.connect_type=state";
mostCurrent._cm._connect_type = _state;
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="If state=True Then";
if (_state==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="mqtt_but.textColor=Colors.Green";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 }else {
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="mqtt_but.textColor=Colors.Gray";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 };
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="End Sub";
return "";
}
public static String  _set_ris(anywheresoftware.b4a.objects.collections.Map _rstate) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("set_ris"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_ris", new Object[] {_rstate});
long _tmplong = 0L;
int _a = 0;
double _btd = 0;
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub set_ris(rstate As Map)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Try";
try {RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="Dim tmplong As Long";
_tmplong = 0L;
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="tmplong =CM.tolong(rstate.Get(\"st\"))";
_tmplong = (long) (mostCurrent._cm._tolong(mostCurrent.activityBA,BA.ObjectToString(_rstate.Get((Object)("st")))));
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="For a=1 To 30";
{
final int step4 = 1;
final int limit4 = (int) (30);
for (_a = (int) (1) ; (step4 > 0 && _a <= limit4) || (step4 < 0 && _a >= limit4); _a = ((int)(0 + _a + step4)) ) {
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="butstate(a)=CM.obj2Bool(Bit.And(tmplong , 1))";
_butstate[_a] = mostCurrent._cm._obj2bool(mostCurrent.activityBA,(Object)(anywheresoftware.b4a.keywords.Common.Bit.And((int) (_tmplong),(int) (1))));
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="tmplong=Bit.ShiftRight(tmplong,1)";
_tmplong = (long) (anywheresoftware.b4a.keywords.Common.Bit.ShiftRight((int) (_tmplong),(int) (1)));
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="If butstate(a)=True Then";
if (_butstate[_a]==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="butt(a).Background =sld_on";
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_on.getObject()));
 }else {
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="butt(a).Background =sld_norm";
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
 };
 }
};
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="Dim btd As Double =rstate.Get(\"analog\")/(StateMan";
_btd = (double)(BA.ObjectToNumber(_rstate.Get((Object)("analog"))))/(double)((double)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"batt_dev",BA.NumberToString(20000))))/(double)100);
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="btd=CM.toint (btd*100)/100";
_btd = mostCurrent._cm._toint(mostCurrent.activityBA,BA.NumberToString(_btd*100))/(double)100;
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="status_lab.TextColor=Colors.Green";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=983056;
 //BA.debugLineNum = 983056;BA.debugLine="If CM.toint (rstate.Get(\"rssi\"))<0 Then";
if (mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_rstate.Get((Object)("rssi"))))<0) { 
RDebugUtils.currentLine=983057;
 //BA.debugLineNum = 983057;BA.debugLine="status_lab.Text = btd & \"V RSSI: \" & rstate.Get";
mostCurrent._status_lab.setText((Object)(BA.NumberToString(_btd)+"V RSSI: "+BA.ObjectToString(_rstate.Get((Object)("rssi")))+"dbm   Connected"));
 }else {
RDebugUtils.currentLine=983059;
 //BA.debugLineNum = 983059;BA.debugLine="wifi.StartWifi";
mostCurrent._wifi.StartWifi();
RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="wifi.GetNewReadingWifi";
mostCurrent._wifi.GetNewReadingWifi();
RDebugUtils.currentLine=983061;
 //BA.debugLineNum = 983061;BA.debugLine="status_lab.Text = btd & \"V myRSSI: \" & wifisig";
mostCurrent._status_lab.setText((Object)(BA.NumberToString(_btd)+"V myRSSI: "+BA.NumberToString(_wifisignal)+"dbm   Connected"));
 };
RDebugUtils.currentLine=983063;
 //BA.debugLineNum = 983063;BA.debugLine="conect_tmout=3";
_conect_tmout = (int) (3);
 } 
       catch (Exception e176) {
			processBA.setLastException(e176);RDebugUtils.currentLine=983066;
 //BA.debugLineNum = 983066;BA.debugLine="proces_error(LastException.Message & \"set_ris\")";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"set_ris");
 };
RDebugUtils.currentLine=983068;
 //BA.debugLineNum = 983068;BA.debugLine="End Sub";
return "";
}
public static String  _status_lab_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("status_lab_longclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "status_lab_longclick", null);
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub status_lab_LongClick";
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("tbuts_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tbuts_click", null);
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub tbuts_click()";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Try";
try {RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="antidouble=False";
_antidouble = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Dim tmind As Int";
_tmind = 0;
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="If tmind<1 Then Return";
if (_tmind<1) { 
if (true) return "";};
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="If butlock(tmind) =False Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="prs_but=0";
_prs_but = (int) (0);
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 };
 } 
       catch (Exception e267) {
			processBA.setLastException(e267);RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="proces_error(LastException.Message & \"tbuts_clic";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"tbuts_click");
 };
RDebugUtils.currentLine=1245200;
 //BA.debugLineNum = 1245200;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_down() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("tbuts_down"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tbuts_down", null);
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub tbuts_down()";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Try";
try {RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="If antidouble=True Then Return";
if (_antidouble==anywheresoftware.b4a.keywords.Common.True) { 
if (true) return "";};
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="antidouble=True";
_antidouble = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=1179653;
 //BA.debugLineNum = 1179653;BA.debugLine="Dim tmind As Int";
_tmind = 0;
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="p.Background =sld_down";
_p.setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_down.getObject()));
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="If tmind<1 Then Return";
if (_tmind<1) { 
if (true) return "";};
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="If butlock(tmind) =True Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="If butstate(tmind)=True Then";
if (_butstate[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179661;
 //BA.debugLineNum = 1179661;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=1179663;
 //BA.debugLineNum = 1179663;BA.debugLine="send_comm(tmind,True,True)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179664;
 //BA.debugLineNum = 1179664;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
RDebugUtils.currentLine=1179667;
 //BA.debugLineNum = 1179667;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1179668;
 //BA.debugLineNum = 1179668;BA.debugLine="send_comm(tmind,True,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1179669;
 //BA.debugLineNum = 1179669;BA.debugLine="prs_but=tmind";
_prs_but = _tmind;
 };
 } 
       catch (Exception e250) {
			processBA.setLastException(e250);RDebugUtils.currentLine=1179672;
 //BA.debugLineNum = 1179672;BA.debugLine="proces_error(LastException.Message & \"tbuts_cdow";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"tbuts_cdown");
 };
RDebugUtils.currentLine=1179674;
 //BA.debugLineNum = 1179674;BA.debugLine="End Sub";
return "";
}
public static String  _wf_ap_set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("wf_ap_set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "wf_ap_set_click", null);
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub wf_ap_set_Click()";
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="StartActivity(AP_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._ap_set.getObject()));
RDebugUtils.currentLine=1376259;
 //BA.debugLineNum = 1376259;BA.debugLine="End Sub";
return "";
}
public static String  _wf_sta_set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("wf_sta_set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "wf_sta_set_click", null);
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub wf_sta_set_Click()";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="StartActivity(STA_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sta_set.getObject()));
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="End Sub";
return "";
}
public static String  _wifi_foundreadings(anywheresoftware.b4a.objects.collections.List _readings) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("wifi_foundreadings"))
	return (String) Debug.delegate(mostCurrent.activityBA, "wifi_foundreadings", new Object[] {_readings});
com.AB.ABWifi.ABWifi.ABWifiReading _reading = null;
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub wifi_FoundReadings(readings As List)";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Try";
try {RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="If readings.Size<1 Then Return";
if (_readings.getSize()<1) { 
if (true) return "";};
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="Dim reading As ABWifiReading = readings.Get(0)";
_reading = (com.AB.ABWifi.ABWifi.ABWifiReading)(_readings.Get((int) (0)));
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="wifisignal=reading.Level";
_wifisignal = _reading.Level;
 } 
       catch (Exception e138) {
			processBA.setLastException(e138);RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="proces_error(LastException.Message & \"wi_fi_foun";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"wi_fi_foundread");
 };
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="End Sub";
return "";
}
}