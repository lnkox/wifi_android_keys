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
       catch (Exception e76) {
			processBA.setLastException(e76);RDebugUtils.currentLine=131131;
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
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub add_key_to_panel() 'розміщення кнопок керуванн";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="Try";
try {RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="Activity.Title =\"Wi-Fi keys - \" & StateManager.Ge";
mostCurrent._activity.setTitle((Object)("Wi-Fi keys - "+mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="clear_keys";
_clear_keys();
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="Dim vert_size As Int=StateManager.GetSetting2(\"v_";
_vert_size = (int)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"v_size","")));
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="Dim horiz_size As Int=StateManager.GetSetting2(\"h";
_horiz_size = (int)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"h_size","")));
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="Dim font_size As Int=StateManager.GetSetting2(\"fo";
_font_size = (int)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"font_size","")));
RDebugUtils.currentLine=4718599;
 //BA.debugLineNum = 4718599;BA.debugLine="Dim b_width,b_height,posx,posy,max_but As Int";
_b_width = 0;
_b_height = 0;
_posx = 0;
_posy = 0;
_max_but = 0;
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="b_width=Activity.Width/horiz_size";
_b_width = (int) (mostCurrent._activity.getWidth()/(double)_horiz_size);
RDebugUtils.currentLine=4718601;
 //BA.debugLineNum = 4718601;BA.debugLine="b_height=(Activity.height-20dip)/vert_size";
_b_height = (int) ((mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)))/(double)_vert_size);
RDebugUtils.currentLine=4718602;
 //BA.debugLineNum = 4718602;BA.debugLine="max_but =horiz_size*vert_size";
_max_but = (int) (_horiz_size*_vert_size);
RDebugUtils.currentLine=4718603;
 //BA.debugLineNum = 4718603;BA.debugLine="cur_but_state=0";
_cur_but_state = (int) (0);
RDebugUtils.currentLine=4718604;
 //BA.debugLineNum = 4718604;BA.debugLine="For a=1 To 32";
{
final int step12 = 1;
final int limit12 = (int) (32);
for (_a = (int) (1) ; (step12 > 0 && _a <= limit12) || (step12 < 0 && _a >= limit12); _a = ((int)(0 + _a + step12)) ) {
RDebugUtils.currentLine=4718605;
 //BA.debugLineNum = 4718605;BA.debugLine="butt(a).Background=sld_norm";
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
RDebugUtils.currentLine=4718606;
 //BA.debugLineNum = 4718606;BA.debugLine="If CM.toint(StateManager.GetSetting2(\"keytag\" &";
if (mostCurrent._cm._toint(mostCurrent.activityBA,mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytag"+BA.NumberToString(_a),""))>0) { 
RDebugUtils.currentLine=4718607;
 //BA.debugLineNum = 4718607;BA.debugLine="If cur_but_state>=max_but Then Return";
if (_cur_but_state>=_max_but) { 
if (true) return "";};
RDebugUtils.currentLine=4718608;
 //BA.debugLineNum = 4718608;BA.debugLine="posy=cur_but_state/horiz_size";
_posy = (int) (_cur_but_state/(double)_horiz_size);
RDebugUtils.currentLine=4718609;
 //BA.debugLineNum = 4718609;BA.debugLine="posx=cur_but_state mod horiz_size";
_posx = (int) (_cur_but_state%_horiz_size);
RDebugUtils.currentLine=4718610;
 //BA.debugLineNum = 4718610;BA.debugLine="butlock(a)=CM.obj2Bool(StateManager.GetSetting2";
_butlock[_a] = mostCurrent._cm._obj2bool(mostCurrent.activityBA,(Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keylock"+BA.NumberToString(_a),BA.NumberToString(0))));
RDebugUtils.currentLine=4718611;
 //BA.debugLineNum = 4718611;BA.debugLine="butt(a).Text =StateManager.GetSetting2(\"keytext";
mostCurrent._butt[_a].setText((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytext"+BA.NumberToString(_a),"")));
RDebugUtils.currentLine=4718612;
 //BA.debugLineNum = 4718612;BA.debugLine="butt(a).tag =StateManager.GetSetting2(\"keytag\"";
mostCurrent._butt[_a].setTag((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytag"+BA.NumberToString(_a),"")));
RDebugUtils.currentLine=4718613;
 //BA.debugLineNum = 4718613;BA.debugLine="butt(a).Left =posx*(b_width+1dip)";
mostCurrent._butt[_a].setLeft((int) (_posx*(_b_width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
RDebugUtils.currentLine=4718614;
 //BA.debugLineNum = 4718614;BA.debugLine="butt(a).top =posy*(b_height+1dip)";
mostCurrent._butt[_a].setTop((int) (_posy*(_b_height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
RDebugUtils.currentLine=4718615;
 //BA.debugLineNum = 4718615;BA.debugLine="butt(a).width =b_width-2dip";
mostCurrent._butt[_a].setWidth((int) (_b_width-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=4718616;
 //BA.debugLineNum = 4718616;BA.debugLine="butt(a).height =b_height-2dip";
mostCurrent._butt[_a].setHeight((int) (_b_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=4718617;
 //BA.debugLineNum = 4718617;BA.debugLine="butt(a).TextSize =font_size";
mostCurrent._butt[_a].setTextSize((float) (_font_size));
RDebugUtils.currentLine=4718618;
 //BA.debugLineNum = 4718618;BA.debugLine="cur_but_state=cur_but_state+1";
_cur_but_state = (int) (_cur_but_state+1);
 };
 }
};
 } 
       catch (Exception e206) {
			processBA.setLastException(e206);RDebugUtils.currentLine=4718622;
 //BA.debugLineNum = 4718622;BA.debugLine="proces_error(LastException.Message & \"add_key_to";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"add_key_to_panel");
 };
RDebugUtils.currentLine=4718624;
 //BA.debugLineNum = 4718624;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("proces_error"))
	return (String) Debug.delegate(mostCurrent.activityBA, "proces_error", new Object[] {_msg});
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub proces_error(msg As String)";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",mostCurrent.activityBA);
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="End Sub";
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
       catch (Exception e91) {
			processBA.setLastException(e91);RDebugUtils.currentLine=262149;
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
       catch (Exception e83) {
			processBA.setLastException(e83);RDebugUtils.currentLine=196613;
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
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub clear_keys";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Try";
try {RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="For i = 1 To 32";
{
final int step2 = 1;
final int limit2 = (int) (32);
for (_i = (int) (1) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="butt(i).Left =-2000";
mostCurrent._butt[_i].setLeft((int) (-2000));
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="butt(i).Tag =\"\"";
mostCurrent._butt[_i].setTag((Object)(""));
 }
};
 } 
       catch (Exception e101) {
			processBA.setLastException(e101);RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="proces_error(LastException.Message & \"clear.keys";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"clear.keys");
 };
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="End Sub";
return "";
}
public static String  _exit_prg_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("exit_prg_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "exit_prg_click", null);
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Sub exit_prg_click()";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="End Sub";
return "";
}
public static String  _get_rssi() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("get_rssi"))
	return (String) Debug.delegate(mostCurrent.activityBA, "get_rssi", null);
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub get_rssi() 'Відправка запиту на отримання рів";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="Try";
try {RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="Data.Put (\"rssi\",1)";
_data.Put((Object)("rssi"),(Object)(1));
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e147) {
			processBA.setLastException(e147);RDebugUtils.currentLine=4587527;
 //BA.debugLineNum = 4587527;BA.debugLine="proces_error(LastException.Message & \"get_rssi\")";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"get_rssi");
 };
RDebugUtils.currentLine=4587529;
 //BA.debugLineNum = 4587529;BA.debugLine="End Sub";
return "";
}
public static String  _inet_setm_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("inet_setm_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "inet_setm_click", null);
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub inet_setm_Click()";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="StartActivity(INET_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._inet_set.getObject()));
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="End Sub";
return "";
}
public static boolean  _valid_menu_pass() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("valid_menu_pass"))
	return (Boolean) Debug.delegate(mostCurrent.activityBA, "valid_menu_pass", null);
String _mpas = "";
RDebugUtils.currentLine=9830400;
 //BA.debugLineNum = 9830400;BA.debugLine="Sub valid_menu_pass() As Boolean";
RDebugUtils.currentLine=9830401;
 //BA.debugLineNum = 9830401;BA.debugLine="Dim mpas As String=StateManager.getSetting2(\"menu";
_mpas = mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"menu_pass","");
RDebugUtils.currentLine=9830402;
 //BA.debugLineNum = 9830402;BA.debugLine="If mpas.Length =0 Then Return True";
if (_mpas.length()==0) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
RDebugUtils.currentLine=9830403;
 //BA.debugLineNum = 9830403;BA.debugLine="If enter_menu_pass.EqualsIgnoreCase(mpas)=True  T";
if (mostCurrent._enter_menu_pass.equalsIgnoreCase(_mpas)==anywheresoftware.b4a.keywords.Common.True) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
RDebugUtils.currentLine=9830404;
 //BA.debugLineNum = 9830404;BA.debugLine="menu_pass_txt.Text =\"\"";
mostCurrent._menu_pass_txt.setText((Object)(""));
RDebugUtils.currentLine=9830405;
 //BA.debugLineNum = 9830405;BA.debugLine="menu_pass_txt.Visible =True";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=9830406;
 //BA.debugLineNum = 9830406;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=9830407;
 //BA.debugLineNum = 9830407;BA.debugLine="End Sub";
return false;
}
public static String  _keys_set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("keys_set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "keys_set_click", null);
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub keys_set_Click()";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="StartActivity(KEY_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._key_set.getObject()));
RDebugUtils.currentLine=5177347;
 //BA.debugLineNum = 5177347;BA.debugLine="End Sub";
return "";
}
public static String  _menu_pass_txt_enterpressed() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("menu_pass_txt_enterpressed"))
	return (String) Debug.delegate(mostCurrent.activityBA, "menu_pass_txt_enterpressed", null);
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Sub menu_pass_txt_EnterPressed";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="enter_menu_pass=menu_pass_txt.Text";
mostCurrent._enter_menu_pass = mostCurrent._menu_pass_txt.getText();
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="menu_pass_txt.Visible =False";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8519683;
 //BA.debugLineNum = 8519683;BA.debugLine="End Sub";
return "";
}
public static String  _menu_pass_txt_focuschanged(boolean _hasfocus) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("menu_pass_txt_focuschanged"))
	return (String) Debug.delegate(mostCurrent.activityBA, "menu_pass_txt_focuschanged", new Object[] {_hasfocus});
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Sub menu_pass_txt_FocusChanged (HasFocus As Boolea";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="If HasFocus=False Then";
if (_hasfocus==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="enter_menu_pass=menu_pass_txt.Text";
mostCurrent._enter_menu_pass = mostCurrent._menu_pass_txt.getText();
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="menu_pass_txt.Visible =False";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=8585221;
 //BA.debugLineNum = 8585221;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_but_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("mqtt_but_longclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mqtt_but_longclick", null);
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub mqtt_but_LongClick";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="If CM.connect_type=True Then";
if (mostCurrent._cm._connect_type==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="CallSubDelayed(Starter,\"mqtt_disconnect\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"mqtt_disconnect");
 }else {
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="CallSubDelayed(Starter,\"mqtt_connect\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"mqtt_connect");
 };
RDebugUtils.currentLine=5505032;
 //BA.debugLineNum = 5505032;BA.debugLine="End Sub";
return "";
}
public static String  _reset_dev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("reset_dev_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "reset_dev_click", null);
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub reset_dev_Click()";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="Try";
try {RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="Data.Put (\"rst\",1)";
_data.Put((Object)("rst"),(Object)(1));
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e291) {
			processBA.setLastException(e291);RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="proces_error(LastException.Message & \"reset_dev\"";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"reset_dev");
 };
RDebugUtils.currentLine=5373963;
 //BA.debugLineNum = 5373963;BA.debugLine="End Sub";
return "";
}
public static String  _sel_dev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("sel_dev_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "sel_dev_click", null);
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub sel_dev_Click()";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="StartActivity(sel_dev)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sel_dev.getObject()));
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="End Sub";
return "";
}
public static String  _send_comm(int _ind,boolean _com,boolean _lock) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("send_comm"))
	return (String) Debug.delegate(mostCurrent.activityBA, "send_comm", new Object[] {_ind,_com,_lock});
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub send_comm(ind As Int,com As Boolean,lock As Bo";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="Try";
try {RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="Data.Put (\"ncom\",ind)";
_data.Put((Object)("ncom"),(Object)(_ind));
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="Data.Put (\"com\",com)";
_data.Put((Object)("com"),(Object)(_com));
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="Data.Put (\"lock\",lock)";
_data.Put((Object)("lock"),(Object)(_lock));
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e113) {
			processBA.setLastException(e113);RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="proces_error(LastException.Message & \"send_comm\"";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"send_comm");
 };
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="End Sub";
return "";
}
public static String  _send_state_timer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("send_state_timer_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "send_state_timer_tick", null);
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub send_state_timer_Tick() ' таймер перевірки звя";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Try";
try {RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="If prs_but>0 Then send_comm(prs_but,True,False)";
if (_prs_but>0) { 
_send_comm(_prs_but,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);};
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="get_rssi";
_get_rssi();
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="If conect_tmout>0 Then";
if (_conect_tmout>0) { 
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="conect_tmout=conect_tmout-1";
_conect_tmout = (int) (_conect_tmout-1);
RDebugUtils.currentLine=4456454;
 //BA.debugLineNum = 4456454;BA.debugLine="If conect_tmout=0 Then";
if (_conect_tmout==0) { 
RDebugUtils.currentLine=4456455;
 //BA.debugLineNum = 4456455;BA.debugLine="status_lab.TextColor=Colors.Red";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=4456456;
 //BA.debugLineNum = 4456456;BA.debugLine="status_lab.Text = \"No connected\"";
mostCurrent._status_lab.setText((Object)("No connected"));
 };
 };
 } 
       catch (Exception e128) {
			processBA.setLastException(e128);RDebugUtils.currentLine=4456460;
 //BA.debugLineNum = 4456460;BA.debugLine="proces_error(LastException.Message & \"send_state";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"send_state_timer_tick");
 };
RDebugUtils.currentLine=4456462;
 //BA.debugLineNum = 4456462;BA.debugLine="End Sub";
return "";
}
public static String  _set_mqtt_state(boolean _state) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("set_mqtt_state"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_mqtt_state", new Object[] {_state});
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub set_mqtt_state(state As Boolean)";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="CM.connect_type=state";
mostCurrent._cm._connect_type = _state;
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="If state=True Then";
if (_state==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="mqtt_but.textColor=Colors.Green";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 }else {
RDebugUtils.currentLine=4784133;
 //BA.debugLineNum = 4784133;BA.debugLine="mqtt_but.textColor=Colors.Gray";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 };
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="End Sub";
return "";
}
public static String  _set_ris(anywheresoftware.b4a.objects.collections.Map _rstate) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("set_ris"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_ris", new Object[] {_rstate});
long _tmplong = 0L;
int _a = 0;
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub set_ris(rstate As Map)";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="Try";
try {RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="Dim tmplong As Long";
_tmplong = 0L;
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="tmplong =CM.tolong(rstate.Get(\"st\"))";
_tmplong = (long) (mostCurrent._cm._tolong(mostCurrent.activityBA,BA.ObjectToString(_rstate.Get((Object)("st")))));
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="For a=1 To 30";
{
final int step4 = 1;
final int limit4 = (int) (30);
for (_a = (int) (1) ; (step4 > 0 && _a <= limit4) || (step4 < 0 && _a >= limit4); _a = ((int)(0 + _a + step4)) ) {
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="butstate(a)=CM.obj2Bool(Bit.And(tmplong , 1))";
_butstate[_a] = mostCurrent._cm._obj2bool(mostCurrent.activityBA,(Object)(anywheresoftware.b4a.keywords.Common.Bit.And((int) (_tmplong),(int) (1))));
RDebugUtils.currentLine=4653062;
 //BA.debugLineNum = 4653062;BA.debugLine="tmplong=Bit.ShiftRight(tmplong,1)";
_tmplong = (long) (anywheresoftware.b4a.keywords.Common.Bit.ShiftRight((int) (_tmplong),(int) (1)));
RDebugUtils.currentLine=4653063;
 //BA.debugLineNum = 4653063;BA.debugLine="If butstate(a)=True Then";
if (_butstate[_a]==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4653064;
 //BA.debugLineNum = 4653064;BA.debugLine="butt(a).Background =sld_on";
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_on.getObject()));
 }else {
RDebugUtils.currentLine=4653066;
 //BA.debugLineNum = 4653066;BA.debugLine="butt(a).Background =sld_norm";
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
 };
 }
};
RDebugUtils.currentLine=4653070;
 //BA.debugLineNum = 4653070;BA.debugLine="status_lab.TextColor=Colors.Green";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=4653071;
 //BA.debugLineNum = 4653071;BA.debugLine="If CM.toint (rstate.Get(\"rssi\"))<0 Then";
if (mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_rstate.Get((Object)("rssi"))))<0) { 
RDebugUtils.currentLine=4653072;
 //BA.debugLineNum = 4653072;BA.debugLine="status_lab.Text = \" RSSI: \" & rstate.Get(\"rssi\"";
mostCurrent._status_lab.setText((Object)(" RSSI: "+BA.ObjectToString(_rstate.Get((Object)("rssi")))+"dbm   Connected"));
 }else {
RDebugUtils.currentLine=4653074;
 //BA.debugLineNum = 4653074;BA.debugLine="wifi.StartWifi";
mostCurrent._wifi.StartWifi();
RDebugUtils.currentLine=4653075;
 //BA.debugLineNum = 4653075;BA.debugLine="wifi.GetNewReadingWifi";
mostCurrent._wifi.GetNewReadingWifi();
RDebugUtils.currentLine=4653076;
 //BA.debugLineNum = 4653076;BA.debugLine="status_lab.Text = \" myRSSI: \" & wifisignal & \"";
mostCurrent._status_lab.setText((Object)(" myRSSI: "+BA.NumberToString(_wifisignal)+"dbm   Connected"));
 };
RDebugUtils.currentLine=4653078;
 //BA.debugLineNum = 4653078;BA.debugLine="conect_tmout=3";
_conect_tmout = (int) (3);
 } 
       catch (Exception e173) {
			processBA.setLastException(e173);RDebugUtils.currentLine=4653081;
 //BA.debugLineNum = 4653081;BA.debugLine="proces_error(LastException.Message & \"set_ris\")";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"set_ris");
 };
RDebugUtils.currentLine=4653083;
 //BA.debugLineNum = 4653083;BA.debugLine="End Sub";
return "";
}
public static String  _status_lab_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("status_lab_longclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "status_lab_longclick", null);
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub status_lab_LongClick";
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("tbuts_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tbuts_click", null);
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub tbuts_click()";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Try";
try {RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="antidouble=False";
_antidouble = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="Dim tmind As Int";
_tmind = 0;
RDebugUtils.currentLine=4915205;
 //BA.debugLineNum = 4915205;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=4915206;
 //BA.debugLineNum = 4915206;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
RDebugUtils.currentLine=4915207;
 //BA.debugLineNum = 4915207;BA.debugLine="If tmind<1 Then Return";
if (_tmind<1) { 
if (true) return "";};
RDebugUtils.currentLine=4915208;
 //BA.debugLineNum = 4915208;BA.debugLine="If butlock(tmind) =False Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=4915209;
 //BA.debugLineNum = 4915209;BA.debugLine="prs_but=0";
_prs_but = (int) (0);
RDebugUtils.currentLine=4915210;
 //BA.debugLineNum = 4915210;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4915211;
 //BA.debugLineNum = 4915211;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 };
 } 
       catch (Exception e258) {
			processBA.setLastException(e258);RDebugUtils.currentLine=4915214;
 //BA.debugLineNum = 4915214;BA.debugLine="proces_error(LastException.Message & \"tbuts_clic";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"tbuts_click");
 };
RDebugUtils.currentLine=4915216;
 //BA.debugLineNum = 4915216;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_down() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("tbuts_down"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tbuts_down", null);
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub tbuts_down()";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="Try";
try {RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="If antidouble=True Then Return";
if (_antidouble==anywheresoftware.b4a.keywords.Common.True) { 
if (true) return "";};
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="antidouble=True";
_antidouble = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=4849669;
 //BA.debugLineNum = 4849669;BA.debugLine="Dim tmind As Int";
_tmind = 0;
RDebugUtils.currentLine=4849670;
 //BA.debugLineNum = 4849670;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=4849671;
 //BA.debugLineNum = 4849671;BA.debugLine="p.Background =sld_down";
_p.setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_down.getObject()));
RDebugUtils.currentLine=4849672;
 //BA.debugLineNum = 4849672;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
RDebugUtils.currentLine=4849673;
 //BA.debugLineNum = 4849673;BA.debugLine="If tmind<1 Then Return";
if (_tmind<1) { 
if (true) return "";};
RDebugUtils.currentLine=4849674;
 //BA.debugLineNum = 4849674;BA.debugLine="If butlock(tmind) =True Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4849675;
 //BA.debugLineNum = 4849675;BA.debugLine="If butstate(tmind)=True Then";
if (_butstate[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4849676;
 //BA.debugLineNum = 4849676;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849677;
 //BA.debugLineNum = 4849677;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=4849679;
 //BA.debugLineNum = 4849679;BA.debugLine="send_comm(tmind,True,True)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4849680;
 //BA.debugLineNum = 4849680;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
RDebugUtils.currentLine=4849683;
 //BA.debugLineNum = 4849683;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=4849684;
 //BA.debugLineNum = 4849684;BA.debugLine="send_comm(tmind,True,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849685;
 //BA.debugLineNum = 4849685;BA.debugLine="prs_but=tmind";
_prs_but = _tmind;
 };
 } 
       catch (Exception e241) {
			processBA.setLastException(e241);RDebugUtils.currentLine=4849688;
 //BA.debugLineNum = 4849688;BA.debugLine="proces_error(LastException.Message & \"tbuts_cdow";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"tbuts_cdown");
 };
RDebugUtils.currentLine=4849690;
 //BA.debugLineNum = 4849690;BA.debugLine="End Sub";
return "";
}
public static String  _wf_ap_set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("wf_ap_set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "wf_ap_set_click", null);
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub wf_ap_set_Click()";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="StartActivity(AP_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._ap_set.getObject()));
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="End Sub";
return "";
}
public static String  _wf_sta_set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("wf_sta_set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "wf_sta_set_click", null);
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub wf_sta_set_Click()";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="StartActivity(STA_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sta_set.getObject()));
RDebugUtils.currentLine=5111811;
 //BA.debugLineNum = 5111811;BA.debugLine="End Sub";
return "";
}
public static String  _wifi_foundreadings(anywheresoftware.b4a.objects.collections.List _readings) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("wifi_foundreadings"))
	return (String) Debug.delegate(mostCurrent.activityBA, "wifi_foundreadings", new Object[] {_readings});
com.AB.ABWifi.ABWifi.ABWifiReading _reading = null;
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub wifi_FoundReadings(readings As List)";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="Try";
try {RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="If readings.Size<1 Then Return";
if (_readings.getSize()<1) { 
if (true) return "";};
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="Dim reading As ABWifiReading = readings.Get(0)";
_reading = (com.AB.ABWifi.ABWifi.ABWifiReading)(_readings.Get((int) (0)));
RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="wifisignal=reading.Level";
_wifisignal = _reading.Level;
 } 
       catch (Exception e137) {
			processBA.setLastException(e137);RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="proces_error(LastException.Message & \"wi_fi_foun";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"wi_fi_foundread");
 };
RDebugUtils.currentLine=4521992;
 //BA.debugLineNum = 4521992;BA.debugLine="End Sub";
return "";
}
}