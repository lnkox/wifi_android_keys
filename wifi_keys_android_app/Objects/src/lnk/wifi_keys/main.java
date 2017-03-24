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
vis = vis | (sta_set.mostCurrent != null);
vis = vis | (key_set.mostCurrent != null);
vis = vis | (inet_set.mostCurrent != null);
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
            if (sta_set.previousOne != null) {
				__a = sta_set.previousOne.get();
			}
            else {
                BA ba = sta_set.mostCurrent.processBA.sharedProcessBA.activityBA.get();
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

}
public anywheresoftware.b4a.keywords.Common __c = null;
public static boolean _keys_is_load = false;
public static int _conect_tmout = 0;
public static anywheresoftware.b4a.objects.Timer _send_state_timer = null;
public anywheresoftware.b4a.objects.ButtonWrapper[] _butt = null;
public anywheresoftware.b4a.objects.LabelWrapper _status_lab = null;
public static boolean[] _butlock = null;
public static boolean[] _butstate = null;
public anywheresoftware.b4a.objects.drawable.StateListDrawable _sld_norm = null;
public anywheresoftware.b4a.objects.drawable.StateListDrawable _sld_on = null;
public anywheresoftware.b4a.objects.drawable.StateListDrawable _sld_down = null;
public anywheresoftware.b4a.objects.drawable.ColorDrawable _prs = null;
public anywheresoftware.b4a.objects.drawable.ColorDrawable _ups = null;
public anywheresoftware.b4a.objects.drawable.ColorDrawable _grn = null;
public static int _cur_but_state = 0;
public static int _prs_but = 0;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public lnk.wifi_keys.key_set _key_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
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
try {RDebugUtils.currentLine=131074;
 //BA.debugLineNum = 131074;BA.debugLine="Activity.Title =\"Wi-Fi keys - \" & StateManager.Ge";
mostCurrent._activity.setTitle((Object)("Wi-Fi keys - "+mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
RDebugUtils.currentLine=131075;
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
 //BA.debugLineNum = 131087;BA.debugLine="sld_norm.AddState(sld_norm.State_Enabled, ups)";
mostCurrent._sld_norm.AddState(mostCurrent._sld_norm.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._ups.getObject()));
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="sld_on.Initialize";
mostCurrent._sld_on.Initialize();
RDebugUtils.currentLine=131089;
 //BA.debugLineNum = 131089;BA.debugLine="sld_on.AddState(sld_on.State_Pressed, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
RDebugUtils.currentLine=131090;
 //BA.debugLineNum = 131090;BA.debugLine="sld_on.AddState(sld_on.State_Enabled, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
RDebugUtils.currentLine=131091;
 //BA.debugLineNum = 131091;BA.debugLine="sld_down.Initialize";
mostCurrent._sld_down.Initialize();
RDebugUtils.currentLine=131092;
 //BA.debugLineNum = 131092;BA.debugLine="sld_down.AddState(sld_on.State_Pressed, prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
RDebugUtils.currentLine=131093;
 //BA.debugLineNum = 131093;BA.debugLine="sld_down.AddState(sld_on.State_Enabled, prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
RDebugUtils.currentLine=131094;
 //BA.debugLineNum = 131094;BA.debugLine="status_lab.Initialize(\"status_lab\")";
mostCurrent._status_lab.Initialize(mostCurrent.activityBA,"status_lab");
RDebugUtils.currentLine=131095;
 //BA.debugLineNum = 131095;BA.debugLine="status_lab.TextColor=Colors.Red";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=131096;
 //BA.debugLineNum = 131096;BA.debugLine="status_lab.Text = \"No connected\"";
mostCurrent._status_lab.setText((Object)("No connected"));
RDebugUtils.currentLine=131097;
 //BA.debugLineNum = 131097;BA.debugLine="Activity.AddView(status_lab, 0dip, Activity.He";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._status_lab.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=131098;
 //BA.debugLineNum = 131098;BA.debugLine="For i = 1 To 32";
{
final int step26 = 1;
final int limit26 = (int) (32);
for (_i = (int) (1) ; (step26 > 0 && _i <= limit26) || (step26 < 0 && _i >= limit26); _i = ((int)(0 + _i + step26)) ) {
RDebugUtils.currentLine=131099;
 //BA.debugLineNum = 131099;BA.debugLine="Dim tbuts As Button";
_tbuts = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=131100;
 //BA.debugLineNum = 131100;BA.debugLine="tbuts.Initialize(\"tbuts\")";
_tbuts.Initialize(mostCurrent.activityBA,"tbuts");
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="Activity.AddView(tbuts, -2000dip, 0, 20dip";
mostCurrent._activity.AddView((android.view.View)(_tbuts.getObject()),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2000))),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
RDebugUtils.currentLine=131102;
 //BA.debugLineNum = 131102;BA.debugLine="tbuts.Background=sld_norm";
_tbuts.setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="butt(i)=tbuts";
mostCurrent._butt[_i] = _tbuts;
 }
};
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="add_key_to_panel";
_add_key_to_panel();
RDebugUtils.currentLine=131106;
 //BA.debugLineNum = 131106;BA.debugLine="send_state_timer.Initialize(\"send_state_timer\", 1";
_send_state_timer.Initialize(processBA,"send_state_timer",(long) (1000));
RDebugUtils.currentLine=131107;
 //BA.debugLineNum = 131107;BA.debugLine="send_state_timer.Enabled =True";
_send_state_timer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e52) {
			processBA.setLastException(e52);RDebugUtils.currentLine=131109;
 //BA.debugLineNum = 131109;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=131111;
 //BA.debugLineNum = 131111;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub add_key_to_panel() 'розміщення кнопок керуванн";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="Try";
try {RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="clear_keys";
_clear_keys();
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="Dim vert_size As Int=StateManager.GetSetting2(\"v_";
_vert_size = (int)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"v_size","")));
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="Dim horiz_size As Int=StateManager.GetSetting2(\"h";
_horiz_size = (int)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"h_size","")));
RDebugUtils.currentLine=2228229;
 //BA.debugLineNum = 2228229;BA.debugLine="Dim font_size As Int=StateManager.GetSetting2(\"fo";
_font_size = (int)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"font_size","")));
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="Dim b_width,b_height,posx,posy,max_but As Int";
_b_width = 0;
_b_height = 0;
_posx = 0;
_posy = 0;
_max_but = 0;
RDebugUtils.currentLine=2228231;
 //BA.debugLineNum = 2228231;BA.debugLine="b_width=Activity.Width/horiz_size";
_b_width = (int) (mostCurrent._activity.getWidth()/(double)_horiz_size);
RDebugUtils.currentLine=2228232;
 //BA.debugLineNum = 2228232;BA.debugLine="b_height=(Activity.height-20dip)/vert_size";
_b_height = (int) ((mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)))/(double)_vert_size);
RDebugUtils.currentLine=2228233;
 //BA.debugLineNum = 2228233;BA.debugLine="max_but =horiz_size*vert_size";
_max_but = (int) (_horiz_size*_vert_size);
RDebugUtils.currentLine=2228234;
 //BA.debugLineNum = 2228234;BA.debugLine="cur_but_state=0";
_cur_but_state = (int) (0);
RDebugUtils.currentLine=2228235;
 //BA.debugLineNum = 2228235;BA.debugLine="For a=1 To 32";
{
final int step11 = 1;
final int limit11 = (int) (32);
for (_a = (int) (1) ; (step11 > 0 && _a <= limit11) || (step11 < 0 && _a >= limit11); _a = ((int)(0 + _a + step11)) ) {
RDebugUtils.currentLine=2228236;
 //BA.debugLineNum = 2228236;BA.debugLine="If butstate(a)=True Then butt(a).Background=sld_";
if (_butstate[_a]==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_on.getObject()));};
RDebugUtils.currentLine=2228237;
 //BA.debugLineNum = 2228237;BA.debugLine="If CM.toint(StateManager.GetSetting2(\"keytag\" &";
if (mostCurrent._cm._toint(mostCurrent.activityBA,mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytag"+BA.NumberToString(_a),""))>0) { 
RDebugUtils.currentLine=2228238;
 //BA.debugLineNum = 2228238;BA.debugLine="If cur_but_state>=max_but Then Return";
if (_cur_but_state>=_max_but) { 
if (true) return "";};
RDebugUtils.currentLine=2228239;
 //BA.debugLineNum = 2228239;BA.debugLine="posy=cur_but_state/horiz_size";
_posy = (int) (_cur_but_state/(double)_horiz_size);
RDebugUtils.currentLine=2228240;
 //BA.debugLineNum = 2228240;BA.debugLine="posx=cur_but_state mod horiz_size";
_posx = (int) (_cur_but_state%_horiz_size);
RDebugUtils.currentLine=2228241;
 //BA.debugLineNum = 2228241;BA.debugLine="butlock(a)=CM.obj2Bool(StateManager.GetSetting2";
_butlock[_a] = mostCurrent._cm._obj2bool(mostCurrent.activityBA,(Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keylock"+BA.NumberToString(_a),BA.NumberToString(0))));
RDebugUtils.currentLine=2228242;
 //BA.debugLineNum = 2228242;BA.debugLine="butt(a).Text =StateManager.GetSetting2(\"keytext";
mostCurrent._butt[_a].setText((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytext"+BA.NumberToString(_a),"")));
RDebugUtils.currentLine=2228243;
 //BA.debugLineNum = 2228243;BA.debugLine="butt(a).tag =StateManager.GetSetting2(\"keytag\"";
mostCurrent._butt[_a].setTag((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytag"+BA.NumberToString(_a),"")));
RDebugUtils.currentLine=2228244;
 //BA.debugLineNum = 2228244;BA.debugLine="butt(a).Left =posx*(b_width+1dip)";
mostCurrent._butt[_a].setLeft((int) (_posx*(_b_width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
RDebugUtils.currentLine=2228245;
 //BA.debugLineNum = 2228245;BA.debugLine="butt(a).top =posy*(b_height+1dip)";
mostCurrent._butt[_a].setTop((int) (_posy*(_b_height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
RDebugUtils.currentLine=2228246;
 //BA.debugLineNum = 2228246;BA.debugLine="butt(a).width =b_width-2dip";
mostCurrent._butt[_a].setWidth((int) (_b_width-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=2228247;
 //BA.debugLineNum = 2228247;BA.debugLine="butt(a).height =b_height-2dip";
mostCurrent._butt[_a].setHeight((int) (_b_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
RDebugUtils.currentLine=2228248;
 //BA.debugLineNum = 2228248;BA.debugLine="butt(a).TextSize =font_size";
mostCurrent._butt[_a].setTextSize((float) (_font_size));
RDebugUtils.currentLine=2228249;
 //BA.debugLineNum = 2228249;BA.debugLine="cur_but_state=cur_but_state+1";
_cur_but_state = (int) (_cur_but_state+1);
 };
 }
};
 } 
       catch (Exception e165) {
			processBA.setLastException(e165);RDebugUtils.currentLine=2228253;
 //BA.debugLineNum = 2228253;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=2228255;
 //BA.debugLineNum = 2228255;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("proces_error"))
	return (String) Debug.delegate(mostCurrent.activityBA, "proces_error", new Object[] {_msg});
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub proces_error(msg As String)";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",mostCurrent.activityBA);
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 262146;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(mostCurrent.activityBA);
 } 
       catch (Exception e62) {
			processBA.setLastException(e62);RDebugUtils.currentLine=262148;
 //BA.debugLineNum = 262148;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="add_key_to_panel";
_add_key_to_panel();
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static String  _clear_keys() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("clear_keys"))
	return (String) Debug.delegate(mostCurrent.activityBA, "clear_keys", null);
int _i = 0;
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub clear_keys";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="Try";
try {RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="For i = 1 To 32";
{
final int step2 = 1;
final int limit2 = (int) (32);
for (_i = (int) (1) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="butt(i).Left =-2000";
mostCurrent._butt[_i].setLeft((int) (-2000));
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="butt(i).Tag =\"\"";
mostCurrent._butt[_i].setTag((Object)(""));
 }
};
 } 
       catch (Exception e72) {
			processBA.setLastException(e72);RDebugUtils.currentLine=1835016;
 //BA.debugLineNum = 1835016;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=1835018;
 //BA.debugLineNum = 1835018;BA.debugLine="End Sub";
return "";
}
public static String  _get_rssi() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("get_rssi"))
	return (String) Debug.delegate(mostCurrent.activityBA, "get_rssi", null);
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub get_rssi() 'Відправка запиту на отримання рів";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Try";
try {RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="Data.Put (\"rssi\",1)";
_data.Put((Object)("rssi"),(Object)(1));
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e124) {
			processBA.setLastException(e124);RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="End Sub";
return "";
}
public static String  _inet_setm_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("inet_setm_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "inet_setm_click", null);
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub inet_setm_Click()";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="StartActivity(INET_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._inet_set.getObject()));
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="End Sub";
return "";
}
public static String  _keys_set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("keys_set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "keys_set_click", null);
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub keys_set_Click()";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="StartActivity(KEY_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._key_set.getObject()));
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="End Sub";
return "";
}
public static String  _reload_key_state(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("reload_key_state"))
	return (String) Debug.delegate(mostCurrent.activityBA, "reload_key_state", new Object[] {_mapar});
int _tmpid = 0;
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub reload_key_state(mapar As Map)";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Try";
try {RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="Dim tmpid As Int";
_tmpid = 0;
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="tmpid=CM.toint(mapar.Get (\"rind\"))";
_tmpid = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("rind"))));
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="If tmpid>0 Then";
if (_tmpid>0) { 
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="If CM.toint(mapar.Get (\"rcom\"))=1 Then";
if (mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("rcom"))))==1) { 
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="butt(tmpid).Background =sld_on";
mostCurrent._butt[_tmpid].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_on.getObject()));
 }else {
RDebugUtils.currentLine=1966088;
 //BA.debugLineNum = 1966088;BA.debugLine="butt(tmpid).Background =sld_norm";
mostCurrent._butt[_tmpid].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
 };
 };
 } 
       catch (Exception e99) {
			processBA.setLastException(e99);RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=1966094;
 //BA.debugLineNum = 1966094;BA.debugLine="End Sub";
return "";
}
public static String  _reset_dev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("reset_dev_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "reset_dev_click", null);
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub reset_dev_Click()";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="Try";
try {RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=2752516;
 //BA.debugLineNum = 2752516;BA.debugLine="Data.Put (\"rst\",1)";
_data.Put((Object)("rst"),(Object)(1));
RDebugUtils.currentLine=2752517;
 //BA.debugLineNum = 2752517;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e229) {
			processBA.setLastException(e229);RDebugUtils.currentLine=2752519;
 //BA.debugLineNum = 2752519;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=2752523;
 //BA.debugLineNum = 2752523;BA.debugLine="End Sub";
return "";
}
public static String  _sel_dev_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("sel_dev_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "sel_dev_click", null);
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub sel_dev_Click()";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="StartActivity(sel_dev)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sel_dev.getObject()));
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="End Sub";
return "";
}
public static String  _send_comm(int _ind,boolean _com,boolean _lock) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("send_comm"))
	return (String) Debug.delegate(mostCurrent.activityBA, "send_comm", new Object[] {_ind,_com,_lock});
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub send_comm(ind As Int,com As Boolean,lock As Bo";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Try";
try {RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Data.Put (\"ncom\",ind)";
_data.Put((Object)("ncom"),(Object)(_ind));
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="Data.Put (\"com\",com)";
_data.Put((Object)("com"),(Object)(_com));
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="Data.Put (\"lock\",lock)";
_data.Put((Object)("lock"),(Object)(_lock));
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e84) {
			processBA.setLastException(e84);RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=1900555;
 //BA.debugLineNum = 1900555;BA.debugLine="End Sub";
return "";
}
public static String  _send_state_timer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("send_state_timer_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "send_state_timer_tick", null);
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub send_state_timer_Tick() ' таймер перевірки звя";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Try";
try {RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="If prs_but>0 Then send_comm(prs_but,True,False)";
if (_prs_but>0) { 
_send_comm(_prs_but,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);};
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="get_rssi";
_get_rssi();
RDebugUtils.currentLine=2031620;
 //BA.debugLineNum = 2031620;BA.debugLine="If conect_tmout>0 Then";
if (_conect_tmout>0) { 
RDebugUtils.currentLine=2031621;
 //BA.debugLineNum = 2031621;BA.debugLine="conect_tmout=conect_tmout-1";
_conect_tmout = (int) (_conect_tmout-1);
RDebugUtils.currentLine=2031622;
 //BA.debugLineNum = 2031622;BA.debugLine="If conect_tmout=0 Then";
if (_conect_tmout==0) { 
RDebugUtils.currentLine=2031623;
 //BA.debugLineNum = 2031623;BA.debugLine="status_lab.TextColor=Colors.Red";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="status_lab.Text = \"No connected\"";
mostCurrent._status_lab.setText((Object)("No connected"));
 };
 };
 } 
       catch (Exception e114) {
			processBA.setLastException(e114);RDebugUtils.currentLine=2031629;
 //BA.debugLineNum = 2031629;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=2031631;
 //BA.debugLineNum = 2031631;BA.debugLine="End Sub";
return "";
}
public static String  _set_ris(int _rsi) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("set_ris"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_ris", new Object[] {_rsi});
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub set_ris(rsi As Int)";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Try";
try {RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="status_lab.TextColor=Colors.Green";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
RDebugUtils.currentLine=2162691;
 //BA.debugLineNum = 2162691;BA.debugLine="status_lab.Text = \" RSSI: \" & rsi & \"dbm   Connec";
mostCurrent._status_lab.setText((Object)(" RSSI: "+BA.NumberToString(_rsi)+"dbm   Connected"));
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="conect_tmout=3";
_conect_tmout = (int) (3);
 } 
       catch (Exception e133) {
			processBA.setLastException(e133);RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=2162696;
 //BA.debugLineNum = 2162696;BA.debugLine="End Sub";
return "";
}
public static String  _status_lab_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("status_lab_longclick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "status_lab_longclick", null);
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub status_lab_LongClick";
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("tbuts_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tbuts_click", null);
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub tbuts_click()";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Try";
try {RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="Dim tmind As Int";
_tmind = 0;
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
RDebugUtils.currentLine=2359302;
 //BA.debugLineNum = 2359302;BA.debugLine="If butlock(tmind) =False Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2359303;
 //BA.debugLineNum = 2359303;BA.debugLine="prs_but=0";
_prs_but = (int) (0);
RDebugUtils.currentLine=2359304;
 //BA.debugLineNum = 2359304;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2359305;
 //BA.debugLineNum = 2359305;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 };
 } 
       catch (Exception e204) {
			processBA.setLastException(e204);RDebugUtils.currentLine=2359308;
 //BA.debugLineNum = 2359308;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=2359310;
 //BA.debugLineNum = 2359310;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_down() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("tbuts_down"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tbuts_down", null);
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub tbuts_down()";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Try";
try {RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="Dim tmind As Int";
_tmind = 0;
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="p.Background =sld_down";
_p.setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_down.getObject()));
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="If butlock(tmind) =True Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="If butstate(tmind)=True Then";
if (_butstate[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=2293772;
 //BA.debugLineNum = 2293772;BA.debugLine="send_comm(tmind,True,True)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
RDebugUtils.currentLine=2293776;
 //BA.debugLineNum = 2293776;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=2293777;
 //BA.debugLineNum = 2293777;BA.debugLine="send_comm(tmind,True,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2293778;
 //BA.debugLineNum = 2293778;BA.debugLine="prs_but=tmind";
_prs_but = _tmind;
 };
 } 
       catch (Exception e189) {
			processBA.setLastException(e189);RDebugUtils.currentLine=2293781;
 //BA.debugLineNum = 2293781;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=2293783;
 //BA.debugLineNum = 2293783;BA.debugLine="End Sub";
return "";
}
public static String  _wf_ap_set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("wf_ap_set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "wf_ap_set_click", null);
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub wf_ap_set_Click()";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="StartActivity(AP_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._ap_set.getObject()));
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="End Sub";
return "";
}
public static String  _wf_sta_set_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate("wf_sta_set_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "wf_sta_set_click", null);
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub wf_sta_set_Click()";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="StartActivity(STA_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sta_set.getObject()));
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="End Sub";
return "";
}
}