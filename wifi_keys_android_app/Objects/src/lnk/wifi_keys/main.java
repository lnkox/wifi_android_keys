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
			processBA = new BA(this.getApplicationContext(), null, null, "lnk.wifi_keys", "lnk.wifi_keys.main");
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

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (sel_dev.mostCurrent != null);
vis = vis | (ap_set.mostCurrent != null);
vis = vis | (key_set.mostCurrent != null);
vis = vis | (inet_set.mostCurrent != null);
vis = vis | (sta_set.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _tbuts = null;
 //BA.debugLineNum = 35;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 36;BA.debugLine="Try";
try { //BA.debugLineNum = 38;BA.debugLine="Activity.AddMenuItem(\"Keys set\",\"keys_set\")";
mostCurrent._activity.AddMenuItem("Keys set","keys_set");
 //BA.debugLineNum = 39;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi AP set\",\"wf_ap_set";
mostCurrent._activity.AddMenuItem("Wi-Fi AP set","wf_ap_set");
 //BA.debugLineNum = 40;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi client set\",\"wf_ST";
mostCurrent._activity.AddMenuItem("Wi-Fi client set","wf_STA_set");
 //BA.debugLineNum = 41;BA.debugLine="Activity.AddMenuItem(\"Select device\",\"sel_dev\")";
mostCurrent._activity.AddMenuItem("Select device","sel_dev");
 //BA.debugLineNum = 42;BA.debugLine="Activity.AddMenuItem(\"Inet set\",\"inet_setm\")";
mostCurrent._activity.AddMenuItem("Inet set","inet_setm");
 //BA.debugLineNum = 43;BA.debugLine="Activity.AddMenuItem(\"Reset device\",\"reset_dev\")";
mostCurrent._activity.AddMenuItem("Reset device","reset_dev");
 //BA.debugLineNum = 44;BA.debugLine="Activity.AddMenuItem(\"EXIT\",\"exit_prg\")";
mostCurrent._activity.AddMenuItem("EXIT","exit_prg");
 //BA.debugLineNum = 45;BA.debugLine="prs.Initialize(Colors.Gray,0dip)";
mostCurrent._prs.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Gray,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
 //BA.debugLineNum = 46;BA.debugLine="ups.Initialize(Colors.DarkGray, 0dip)";
mostCurrent._ups.Initialize(anywheresoftware.b4a.keywords.Common.Colors.DarkGray,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
 //BA.debugLineNum = 47;BA.debugLine="grn.Initialize(Colors.RGB(0,150,0), 0dip)";
mostCurrent._grn.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (150),(int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
 //BA.debugLineNum = 48;BA.debugLine="sld_norm.Initialize";
mostCurrent._sld_norm.Initialize();
 //BA.debugLineNum = 49;BA.debugLine="sld_norm.AddState(sld_norm.State_Pressed, ups)";
mostCurrent._sld_norm.AddState(mostCurrent._sld_norm.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._ups.getObject()));
 //BA.debugLineNum = 50;BA.debugLine="sld_norm.AddState(sld_norm.State_Enabled,ups)";
mostCurrent._sld_norm.AddState(mostCurrent._sld_norm.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._ups.getObject()));
 //BA.debugLineNum = 51;BA.debugLine="sld_norm.AddState(sld_on.State_Focused, ups)";
mostCurrent._sld_norm.AddState(mostCurrent._sld_on.State_Focused,(android.graphics.drawable.Drawable)(mostCurrent._ups.getObject()));
 //BA.debugLineNum = 52;BA.debugLine="sld_on.Initialize";
mostCurrent._sld_on.Initialize();
 //BA.debugLineNum = 53;BA.debugLine="sld_on.AddState(sld_on.State_Pressed, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
 //BA.debugLineNum = 54;BA.debugLine="sld_on.AddState(sld_on.State_Enabled, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
 //BA.debugLineNum = 55;BA.debugLine="sld_on.AddState(sld_on.State_Disabled, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Disabled,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
 //BA.debugLineNum = 56;BA.debugLine="sld_on.AddState(sld_on.State_Focused, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Focused,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
 //BA.debugLineNum = 57;BA.debugLine="sld_down.Initialize";
mostCurrent._sld_down.Initialize();
 //BA.debugLineNum = 58;BA.debugLine="sld_down.AddState(sld_on.State_Pressed, prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
 //BA.debugLineNum = 59;BA.debugLine="sld_down.AddState(sld_on.State_Enabled, prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
 //BA.debugLineNum = 60;BA.debugLine="sld_down.AddState(sld_on.State_Disabled,prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Disabled,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
 //BA.debugLineNum = 61;BA.debugLine="sld_down.AddState(sld_on.State_Focused,prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Focused,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
 //BA.debugLineNum = 62;BA.debugLine="status_lab.Initialize(\"status_lab\")";
mostCurrent._status_lab.Initialize(mostCurrent.activityBA,"status_lab");
 //BA.debugLineNum = 63;BA.debugLine="status_lab.TextColor=Colors.Red";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 64;BA.debugLine="status_lab.Text = \"No connected\"";
mostCurrent._status_lab.setText((Object)("No connected"));
 //BA.debugLineNum = 65;BA.debugLine="Activity.AddView(status_lab, 0dip, Activity.He";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._status_lab.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 66;BA.debugLine="mqtt_but.Initialize (\"mqtt_but\")";
mostCurrent._mqtt_but.Initialize(mostCurrent.activityBA,"mqtt_but");
 //BA.debugLineNum = 67;BA.debugLine="mqtt_but.Text =\"MQTT\"";
mostCurrent._mqtt_but.setText((Object)("MQTT"));
 //BA.debugLineNum = 68;BA.debugLine="mqtt_but.TextSize=12";
mostCurrent._mqtt_but.setTextSize((float) (12));
 //BA.debugLineNum = 69;BA.debugLine="Activity.AddView(mqtt_but,Activity.Width-50dip, A";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._mqtt_but.getObject()),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 70;BA.debugLine="If CM.connect_type=True Then";
if (mostCurrent._cm._connect_type==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 71;BA.debugLine="mqtt_but.textColor=Colors.Green";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 }else {
 //BA.debugLineNum = 73;BA.debugLine="mqtt_but.textColor=Colors.Gray";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 };
 //BA.debugLineNum = 75;BA.debugLine="wifi.Initialize(\"wifi\")";
mostCurrent._wifi.Initialize(processBA,"wifi");
 //BA.debugLineNum = 76;BA.debugLine="For i = 1 To 32";
{
final int step40 = 1;
final int limit40 = (int) (32);
for (_i = (int) (1) ; (step40 > 0 && _i <= limit40) || (step40 < 0 && _i >= limit40); _i = ((int)(0 + _i + step40)) ) {
 //BA.debugLineNum = 77;BA.debugLine="Dim tbuts As Button";
_tbuts = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 78;BA.debugLine="tbuts.Initialize(\"tbuts\")";
_tbuts.Initialize(mostCurrent.activityBA,"tbuts");
 //BA.debugLineNum = 79;BA.debugLine="Activity.AddView(tbuts, -2000dip, 0, 20dip";
mostCurrent._activity.AddView((android.view.View)(_tbuts.getObject()),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2000))),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 80;BA.debugLine="tbuts.Background=sld_norm";
_tbuts.setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
 //BA.debugLineNum = 81;BA.debugLine="butt(i)=tbuts";
mostCurrent._butt[_i] = _tbuts;
 }
};
 //BA.debugLineNum = 83;BA.debugLine="add_key_to_panel";
_add_key_to_panel();
 //BA.debugLineNum = 84;BA.debugLine="menu_pass_txt.Initialize(\"menu_pass_txt\")";
mostCurrent._menu_pass_txt.Initialize(mostCurrent.activityBA,"menu_pass_txt");
 //BA.debugLineNum = 85;BA.debugLine="menu_pass_txt.Visible =False";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 86;BA.debugLine="menu_pass_txt.TextSize=6";
mostCurrent._menu_pass_txt.setTextSize((float) (6));
 //BA.debugLineNum = 87;BA.debugLine="menu_pass_txt.PasswordMode=True";
mostCurrent._menu_pass_txt.setPasswordMode(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 88;BA.debugLine="Activity.AddView(menu_pass_txt,Activity.Width/2.5";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._menu_pass_txt.getObject()),(int) (mostCurrent._activity.getWidth()/(double)2.5),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),(int) (mostCurrent._activity.getWidth()/(double)5),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 //BA.debugLineNum = 89;BA.debugLine="send_state_timer.Initialize(\"send_state_timer\",";
_send_state_timer.Initialize(processBA,"send_state_timer",(long) (1000));
 //BA.debugLineNum = 90;BA.debugLine="send_state_timer.Enabled =True";
_send_state_timer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e76) {
			processBA.setLastException(e76); //BA.debugLineNum = 94;BA.debugLine="proces_error(LastException.Message & \"activ. cre";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"activ. creat");
 };
 //BA.debugLineNum = 96;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 108;BA.debugLine="Try";
try { //BA.debugLineNum = 109;BA.debugLine="wifi.StopWifi";
mostCurrent._wifi.StopWifi();
 //BA.debugLineNum = 110;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(mostCurrent.activityBA);
 } 
       catch (Exception e91) {
			processBA.setLastException(e91); //BA.debugLineNum = 112;BA.debugLine="proces_error(LastException.Message & \"active.pau";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"active.pause");
 };
 //BA.debugLineNum = 114;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 99;BA.debugLine="Try";
try { //BA.debugLineNum = 100;BA.debugLine="add_key_to_panel";
_add_key_to_panel();
 } 
       catch (Exception e83) {
			processBA.setLastException(e83); //BA.debugLineNum = 103;BA.debugLine="proces_error(LastException.Message & \"active. re";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"active. resume");
 };
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _add_key_to_panel() throws Exception{
int _vert_size = 0;
int _horiz_size = 0;
int _font_size = 0;
int _b_width = 0;
int _b_height = 0;
int _posx = 0;
int _posy = 0;
int _max_but = 0;
int _a = 0;
 //BA.debugLineNum = 216;BA.debugLine="Sub add_key_to_panel() 'розміщення кнопок керуванн";
 //BA.debugLineNum = 217;BA.debugLine="Try";
try { //BA.debugLineNum = 218;BA.debugLine="Activity.Title =\"Wi-Fi keys - \" & StateManager.Ge";
mostCurrent._activity.setTitle((Object)("Wi-Fi keys - "+mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
 //BA.debugLineNum = 219;BA.debugLine="clear_keys";
_clear_keys();
 //BA.debugLineNum = 220;BA.debugLine="Dim vert_size As Int=StateManager.GetSetting2(\"v_";
_vert_size = (int)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"v_size","")));
 //BA.debugLineNum = 221;BA.debugLine="Dim horiz_size As Int=StateManager.GetSetting2(\"h";
_horiz_size = (int)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"h_size","")));
 //BA.debugLineNum = 222;BA.debugLine="Dim font_size As Int=StateManager.GetSetting2(\"fo";
_font_size = (int)(Double.parseDouble(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"font_size","")));
 //BA.debugLineNum = 223;BA.debugLine="Dim b_width,b_height,posx,posy,max_but As Int";
_b_width = 0;
_b_height = 0;
_posx = 0;
_posy = 0;
_max_but = 0;
 //BA.debugLineNum = 224;BA.debugLine="b_width=Activity.Width/horiz_size";
_b_width = (int) (mostCurrent._activity.getWidth()/(double)_horiz_size);
 //BA.debugLineNum = 225;BA.debugLine="b_height=(Activity.height-20dip)/vert_size";
_b_height = (int) ((mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)))/(double)_vert_size);
 //BA.debugLineNum = 226;BA.debugLine="max_but =horiz_size*vert_size";
_max_but = (int) (_horiz_size*_vert_size);
 //BA.debugLineNum = 227;BA.debugLine="cur_but_state=0";
_cur_but_state = (int) (0);
 //BA.debugLineNum = 228;BA.debugLine="For a=1 To 32";
{
final int step12 = 1;
final int limit12 = (int) (32);
for (_a = (int) (1) ; (step12 > 0 && _a <= limit12) || (step12 < 0 && _a >= limit12); _a = ((int)(0 + _a + step12)) ) {
 //BA.debugLineNum = 229;BA.debugLine="butt(a).Background=sld_norm";
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
 //BA.debugLineNum = 230;BA.debugLine="If CM.toint(StateManager.GetSetting2(\"keytag\" &";
if (mostCurrent._cm._toint(mostCurrent.activityBA,mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytag"+BA.NumberToString(_a),""))>0) { 
 //BA.debugLineNum = 231;BA.debugLine="If cur_but_state>=max_but Then Return";
if (_cur_but_state>=_max_but) { 
if (true) return "";};
 //BA.debugLineNum = 232;BA.debugLine="posy=cur_but_state/horiz_size";
_posy = (int) (_cur_but_state/(double)_horiz_size);
 //BA.debugLineNum = 233;BA.debugLine="posx=cur_but_state mod horiz_size";
_posx = (int) (_cur_but_state%_horiz_size);
 //BA.debugLineNum = 234;BA.debugLine="butlock(a)=CM.obj2Bool(StateManager.GetSetting2";
_butlock[_a] = mostCurrent._cm._obj2bool(mostCurrent.activityBA,(Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keylock"+BA.NumberToString(_a),BA.NumberToString(0))));
 //BA.debugLineNum = 235;BA.debugLine="butt(a).Text =StateManager.GetSetting2(\"keytext";
mostCurrent._butt[_a].setText((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytext"+BA.NumberToString(_a),"")));
 //BA.debugLineNum = 236;BA.debugLine="butt(a).tag =StateManager.GetSetting2(\"keytag\"";
mostCurrent._butt[_a].setTag((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytag"+BA.NumberToString(_a),"")));
 //BA.debugLineNum = 237;BA.debugLine="butt(a).Left =posx*(b_width+1dip)";
mostCurrent._butt[_a].setLeft((int) (_posx*(_b_width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
 //BA.debugLineNum = 238;BA.debugLine="butt(a).top =posy*(b_height+1dip)";
mostCurrent._butt[_a].setTop((int) (_posy*(_b_height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
 //BA.debugLineNum = 239;BA.debugLine="butt(a).width =b_width-2dip";
mostCurrent._butt[_a].setWidth((int) (_b_width-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 //BA.debugLineNum = 240;BA.debugLine="butt(a).height =b_height-2dip";
mostCurrent._butt[_a].setHeight((int) (_b_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 //BA.debugLineNum = 241;BA.debugLine="butt(a).TextSize =font_size";
mostCurrent._butt[_a].setTextSize((float) (_font_size));
 //BA.debugLineNum = 242;BA.debugLine="cur_but_state=cur_but_state+1";
_cur_but_state = (int) (_cur_but_state+1);
 };
 }
};
 } 
       catch (Exception e206) {
			processBA.setLastException(e206); //BA.debugLineNum = 246;BA.debugLine="proces_error(LastException.Message & \"add_key_to";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"add_key_to_panel");
 };
 //BA.debugLineNum = 248;BA.debugLine="End Sub";
return "";
}
public static String  _clear_keys() throws Exception{
int _i = 0;
 //BA.debugLineNum = 117;BA.debugLine="Sub clear_keys";
 //BA.debugLineNum = 118;BA.debugLine="Try";
try { //BA.debugLineNum = 119;BA.debugLine="For i = 1 To 32";
{
final int step2 = 1;
final int limit2 = (int) (32);
for (_i = (int) (1) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
 //BA.debugLineNum = 120;BA.debugLine="butt(i).Left =-2000";
mostCurrent._butt[_i].setLeft((int) (-2000));
 //BA.debugLineNum = 121;BA.debugLine="butt(i).Tag =\"\"";
mostCurrent._butt[_i].setTag((Object)(""));
 }
};
 } 
       catch (Exception e101) {
			processBA.setLastException(e101); //BA.debugLineNum = 125;BA.debugLine="proces_error(LastException.Message & \"clear.keys";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"clear.keys");
 };
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _exit_prg_click() throws Exception{
 //BA.debugLineNum = 332;BA.debugLine="Sub exit_prg_click()";
 //BA.debugLineNum = 333;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 //BA.debugLineNum = 334;BA.debugLine="End Sub";
return "";
}
public static String  _get_rssi() throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 175;BA.debugLine="Sub get_rssi() 'Відправка запиту на отримання рів";
 //BA.debugLineNum = 176;BA.debugLine="Try";
try { //BA.debugLineNum = 177;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 178;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 179;BA.debugLine="Data.Put (\"rssi\",1)";
_data.Put((Object)("rssi"),(Object)(1));
 //BA.debugLineNum = 180;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e147) {
			processBA.setLastException(e147); //BA.debugLineNum = 182;BA.debugLine="proces_error(LastException.Message & \"get_rssi\")";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"get_rssi");
 };
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim antidouble As Boolean";
_antidouble = false;
 //BA.debugLineNum = 19;BA.debugLine="Dim wifi As ABWifi";
mostCurrent._wifi = new com.AB.ABWifi.ABWifi();
 //BA.debugLineNum = 20;BA.debugLine="Dim wifisignal As Int";
_wifisignal = 0;
 //BA.debugLineNum = 21;BA.debugLine="Dim butt(35) As Button";
mostCurrent._butt = new anywheresoftware.b4a.objects.ButtonWrapper[(int) (35)];
{
int d0 = mostCurrent._butt.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._butt[i0] = new anywheresoftware.b4a.objects.ButtonWrapper();
}
}
;
 //BA.debugLineNum = 22;BA.debugLine="Dim mqtt_but As Label";
mostCurrent._mqtt_but = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Dim status_lab As Label";
mostCurrent._status_lab = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Dim butlock(35) As Boolean";
_butlock = new boolean[(int) (35)];
;
 //BA.debugLineNum = 25;BA.debugLine="Dim butstate(35) As Boolean";
_butstate = new boolean[(int) (35)];
;
 //BA.debugLineNum = 26;BA.debugLine="Dim sld_norm,sld_on,sld_down As StateListDrawable";
mostCurrent._sld_norm = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
mostCurrent._sld_on = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
mostCurrent._sld_down = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
 //BA.debugLineNum = 27;BA.debugLine="Dim prs, ups,grn As ColorDrawable";
mostCurrent._prs = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
mostCurrent._ups = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
mostCurrent._grn = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 28;BA.debugLine="Dim menu_pass_txt As EditText";
mostCurrent._menu_pass_txt = new anywheresoftware.b4a.objects.EditTextWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim cur_but_state As Int";
_cur_but_state = 0;
 //BA.debugLineNum = 30;BA.debugLine="Dim prs_but As Int";
_prs_but = 0;
 //BA.debugLineNum = 31;BA.debugLine="Dim enter_menu_pass As String";
mostCurrent._enter_menu_pass = "";
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _inet_setm_click() throws Exception{
 //BA.debugLineNum = 328;BA.debugLine="Sub inet_setm_Click()";
 //BA.debugLineNum = 329;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 330;BA.debugLine="StartActivity(INET_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._inet_set.getObject()));
 //BA.debugLineNum = 331;BA.debugLine="End Sub";
return "";
}
public static String  _keys_set_click() throws Exception{
 //BA.debugLineNum = 324;BA.debugLine="Sub keys_set_Click()";
 //BA.debugLineNum = 325;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 326;BA.debugLine="StartActivity(KEY_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._key_set.getObject()));
 //BA.debugLineNum = 327;BA.debugLine="End Sub";
return "";
}
public static String  _menu_pass_txt_enterpressed() throws Exception{
 //BA.debugLineNum = 371;BA.debugLine="Sub menu_pass_txt_EnterPressed";
 //BA.debugLineNum = 372;BA.debugLine="enter_menu_pass=menu_pass_txt.Text";
mostCurrent._enter_menu_pass = mostCurrent._menu_pass_txt.getText();
 //BA.debugLineNum = 373;BA.debugLine="menu_pass_txt.Visible =False";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 374;BA.debugLine="End Sub";
return "";
}
public static String  _menu_pass_txt_focuschanged(boolean _hasfocus) throws Exception{
 //BA.debugLineNum = 376;BA.debugLine="Sub menu_pass_txt_FocusChanged (HasFocus As Boolea";
 //BA.debugLineNum = 377;BA.debugLine="If HasFocus=False Then";
if (_hasfocus==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 378;BA.debugLine="enter_menu_pass=menu_pass_txt.Text";
mostCurrent._enter_menu_pass = mostCurrent._menu_pass_txt.getText();
 //BA.debugLineNum = 379;BA.debugLine="menu_pass_txt.Visible =False";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 381;BA.debugLine="End Sub";
return "";
}
public static String  _mqtt_but_longclick() throws Exception{
 //BA.debugLineNum = 358;BA.debugLine="Sub mqtt_but_LongClick";
 //BA.debugLineNum = 359;BA.debugLine="If CM.connect_type=True Then";
if (mostCurrent._cm._connect_type==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 360;BA.debugLine="CallSubDelayed(Starter,\"mqtt_disconnect\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"mqtt_disconnect");
 }else {
 //BA.debugLineNum = 362;BA.debugLine="CallSubDelayed(Starter,\"mqtt_connect\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"mqtt_connect");
 };
 //BA.debugLineNum = 366;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
 //BA.debugLineNum = 367;BA.debugLine="Sub proces_error(msg As String)";
 //BA.debugLineNum = 368;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",mostCurrent.activityBA);
 //BA.debugLineNum = 369;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
statemanager._process_globals();
sel_dev._process_globals();
ap_set._process_globals();
key_set._process_globals();
cm._process_globals();
inet_set._process_globals();
sta_set._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim conect_tmout As Int";
_conect_tmout = 0;
 //BA.debugLineNum = 14;BA.debugLine="Public  send_state_timer As Timer";
_send_state_timer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return "";
}
public static String  _reset_dev_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 335;BA.debugLine="Sub reset_dev_Click()";
 //BA.debugLineNum = 336;BA.debugLine="Try";
try { //BA.debugLineNum = 337;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 338;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 339;BA.debugLine="Data.Put (\"rst\",1)";
_data.Put((Object)("rst"),(Object)(1));
 //BA.debugLineNum = 340;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e291) {
			processBA.setLastException(e291); //BA.debugLineNum = 342;BA.debugLine="proces_error(LastException.Message & \"reset_dev\"";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"reset_dev");
 };
 //BA.debugLineNum = 346;BA.debugLine="End Sub";
return "";
}
public static String  _sel_dev_click() throws Exception{
 //BA.debugLineNum = 312;BA.debugLine="Sub sel_dev_Click()";
 //BA.debugLineNum = 313;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 314;BA.debugLine="StartActivity(sel_dev)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sel_dev.getObject()));
 //BA.debugLineNum = 315;BA.debugLine="End Sub";
return "";
}
public static String  _send_comm(int _ind,boolean _com,boolean _lock) throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 134;BA.debugLine="Sub send_comm(ind As Int,com As Boolean,lock As Bo";
 //BA.debugLineNum = 135;BA.debugLine="Try";
try { //BA.debugLineNum = 136;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 137;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 138;BA.debugLine="Data.Put (\"ncom\",ind)";
_data.Put((Object)("ncom"),(Object)(_ind));
 //BA.debugLineNum = 139;BA.debugLine="Data.Put (\"com\",com)";
_data.Put((Object)("com"),(Object)(_com));
 //BA.debugLineNum = 140;BA.debugLine="Data.Put (\"lock\",lock)";
_data.Put((Object)("lock"),(Object)(_lock));
 //BA.debugLineNum = 141;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e113) {
			processBA.setLastException(e113); //BA.debugLineNum = 143;BA.debugLine="proces_error(LastException.Message & \"send_comm\"";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"send_comm");
 };
 //BA.debugLineNum = 145;BA.debugLine="End Sub";
return "";
}
public static String  _send_state_timer_tick() throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Sub send_state_timer_Tick() ' таймер перевірки звя";
 //BA.debugLineNum = 150;BA.debugLine="Try";
try { //BA.debugLineNum = 151;BA.debugLine="If prs_but>0 Then send_comm(prs_but,True,False)";
if (_prs_but>0) { 
_send_comm(_prs_but,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);};
 //BA.debugLineNum = 152;BA.debugLine="get_rssi";
_get_rssi();
 //BA.debugLineNum = 153;BA.debugLine="If conect_tmout>0 Then";
if (_conect_tmout>0) { 
 //BA.debugLineNum = 154;BA.debugLine="conect_tmout=conect_tmout-1";
_conect_tmout = (int) (_conect_tmout-1);
 //BA.debugLineNum = 155;BA.debugLine="If conect_tmout=0 Then";
if (_conect_tmout==0) { 
 //BA.debugLineNum = 156;BA.debugLine="status_lab.TextColor=Colors.Red";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 157;BA.debugLine="status_lab.Text = \"No connected\"";
mostCurrent._status_lab.setText((Object)("No connected"));
 };
 };
 } 
       catch (Exception e128) {
			processBA.setLastException(e128); //BA.debugLineNum = 161;BA.debugLine="proces_error(LastException.Message & \"send_state";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"send_state_timer_tick");
 };
 //BA.debugLineNum = 163;BA.debugLine="End Sub";
return "";
}
public static String  _set_mqtt_state(boolean _state) throws Exception{
 //BA.debugLineNum = 254;BA.debugLine="Sub set_mqtt_state(state As Boolean)";
 //BA.debugLineNum = 255;BA.debugLine="CM.connect_type=state";
mostCurrent._cm._connect_type = _state;
 //BA.debugLineNum = 256;BA.debugLine="If state=True Then";
if (_state==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 257;BA.debugLine="mqtt_but.textColor=Colors.Green";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 }else {
 //BA.debugLineNum = 259;BA.debugLine="mqtt_but.textColor=Colors.Gray";
mostCurrent._mqtt_but.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Gray);
 };
 //BA.debugLineNum = 261;BA.debugLine="End Sub";
return "";
}
public static String  _set_ris(anywheresoftware.b4a.objects.collections.Map _rstate) throws Exception{
long _tmplong = 0L;
int _a = 0;
 //BA.debugLineNum = 186;BA.debugLine="Sub set_ris(rstate As Map)";
 //BA.debugLineNum = 187;BA.debugLine="Try";
try { //BA.debugLineNum = 188;BA.debugLine="Dim tmplong As Long";
_tmplong = 0L;
 //BA.debugLineNum = 189;BA.debugLine="tmplong =CM.tolong(rstate.Get(\"st\"))";
_tmplong = (long) (mostCurrent._cm._tolong(mostCurrent.activityBA,BA.ObjectToString(_rstate.Get((Object)("st")))));
 //BA.debugLineNum = 190;BA.debugLine="For a=1 To 30";
{
final int step4 = 1;
final int limit4 = (int) (30);
for (_a = (int) (1) ; (step4 > 0 && _a <= limit4) || (step4 < 0 && _a >= limit4); _a = ((int)(0 + _a + step4)) ) {
 //BA.debugLineNum = 191;BA.debugLine="butstate(a)=CM.obj2Bool(Bit.And(tmplong , 1))";
_butstate[_a] = mostCurrent._cm._obj2bool(mostCurrent.activityBA,(Object)(anywheresoftware.b4a.keywords.Common.Bit.And((int) (_tmplong),(int) (1))));
 //BA.debugLineNum = 192;BA.debugLine="tmplong=Bit.ShiftRight(tmplong,1)";
_tmplong = (long) (anywheresoftware.b4a.keywords.Common.Bit.ShiftRight((int) (_tmplong),(int) (1)));
 //BA.debugLineNum = 193;BA.debugLine="If butstate(a)=True Then";
if (_butstate[_a]==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 194;BA.debugLine="butt(a).Background =sld_on";
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_on.getObject()));
 }else {
 //BA.debugLineNum = 196;BA.debugLine="butt(a).Background =sld_norm";
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
 };
 }
};
 //BA.debugLineNum = 200;BA.debugLine="status_lab.TextColor=Colors.Green";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 201;BA.debugLine="If CM.toint (rstate.Get(\"rssi\"))<0 Then";
if (mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_rstate.Get((Object)("rssi"))))<0) { 
 //BA.debugLineNum = 202;BA.debugLine="status_lab.Text = \" RSSI: \" & rstate.Get(\"rssi\"";
mostCurrent._status_lab.setText((Object)(" RSSI: "+BA.ObjectToString(_rstate.Get((Object)("rssi")))+"dbm   Connected"));
 }else {
 //BA.debugLineNum = 204;BA.debugLine="wifi.StartWifi";
mostCurrent._wifi.StartWifi();
 //BA.debugLineNum = 205;BA.debugLine="wifi.GetNewReadingWifi";
mostCurrent._wifi.GetNewReadingWifi();
 //BA.debugLineNum = 206;BA.debugLine="status_lab.Text = \" myRSSI: \" & wifisignal & \"";
mostCurrent._status_lab.setText((Object)(" myRSSI: "+BA.NumberToString(_wifisignal)+"dbm   Connected"));
 };
 //BA.debugLineNum = 208;BA.debugLine="conect_tmout=3";
_conect_tmout = (int) (3);
 } 
       catch (Exception e173) {
			processBA.setLastException(e173); //BA.debugLineNum = 211;BA.debugLine="proces_error(LastException.Message & \"set_ris\")";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"set_ris");
 };
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public static String  _status_lab_longclick() throws Exception{
 //BA.debugLineNum = 355;BA.debugLine="Sub status_lab_LongClick";
 //BA.debugLineNum = 357;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_click() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
 //BA.debugLineNum = 294;BA.debugLine="Sub tbuts_click()";
 //BA.debugLineNum = 295;BA.debugLine="Try";
try { //BA.debugLineNum = 296;BA.debugLine="antidouble=False";
_antidouble = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 297;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 298;BA.debugLine="Dim tmind As Int";
_tmind = 0;
 //BA.debugLineNum = 299;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 300;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
 //BA.debugLineNum = 301;BA.debugLine="If tmind<1 Then Return";
if (_tmind<1) { 
if (true) return "";};
 //BA.debugLineNum = 302;BA.debugLine="If butlock(tmind) =False Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 303;BA.debugLine="prs_but=0";
_prs_but = (int) (0);
 //BA.debugLineNum = 304;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 305;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 };
 } 
       catch (Exception e258) {
			processBA.setLastException(e258); //BA.debugLineNum = 308;BA.debugLine="proces_error(LastException.Message & \"tbuts_clic";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"tbuts_click");
 };
 //BA.debugLineNum = 310;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_down() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
 //BA.debugLineNum = 266;BA.debugLine="Sub tbuts_down()";
 //BA.debugLineNum = 267;BA.debugLine="Try";
try { //BA.debugLineNum = 268;BA.debugLine="If antidouble=True Then Return";
if (_antidouble==anywheresoftware.b4a.keywords.Common.True) { 
if (true) return "";};
 //BA.debugLineNum = 269;BA.debugLine="antidouble=True";
_antidouble = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 270;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 271;BA.debugLine="Dim tmind As Int";
_tmind = 0;
 //BA.debugLineNum = 272;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 273;BA.debugLine="p.Background =sld_down";
_p.setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_down.getObject()));
 //BA.debugLineNum = 274;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
 //BA.debugLineNum = 275;BA.debugLine="If tmind<1 Then Return";
if (_tmind<1) { 
if (true) return "";};
 //BA.debugLineNum = 276;BA.debugLine="If butlock(tmind) =True Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 277;BA.debugLine="If butstate(tmind)=True Then";
if (_butstate[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 278;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 279;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 281;BA.debugLine="send_comm(tmind,True,True)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 282;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
 //BA.debugLineNum = 285;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 286;BA.debugLine="send_comm(tmind,True,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 287;BA.debugLine="prs_but=tmind";
_prs_but = _tmind;
 };
 } 
       catch (Exception e241) {
			processBA.setLastException(e241); //BA.debugLineNum = 290;BA.debugLine="proces_error(LastException.Message & \"tbuts_cdow";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"tbuts_cdown");
 };
 //BA.debugLineNum = 292;BA.debugLine="End Sub";
return "";
}
public static boolean  _valid_menu_pass() throws Exception{
String _mpas = "";
 //BA.debugLineNum = 347;BA.debugLine="Sub valid_menu_pass() As Boolean";
 //BA.debugLineNum = 348;BA.debugLine="Dim mpas As String=StateManager.getSetting2(\"menu";
_mpas = mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"menu_pass","");
 //BA.debugLineNum = 349;BA.debugLine="If mpas.Length =0 Then Return True";
if (_mpas.length()==0) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 //BA.debugLineNum = 350;BA.debugLine="If enter_menu_pass.EqualsIgnoreCase(mpas)=True  T";
if (mostCurrent._enter_menu_pass.equalsIgnoreCase(_mpas)==anywheresoftware.b4a.keywords.Common.True) { 
if (true) return anywheresoftware.b4a.keywords.Common.True;};
 //BA.debugLineNum = 351;BA.debugLine="menu_pass_txt.Text =\"\"";
mostCurrent._menu_pass_txt.setText((Object)(""));
 //BA.debugLineNum = 352;BA.debugLine="menu_pass_txt.Visible =True";
mostCurrent._menu_pass_txt.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 353;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 354;BA.debugLine="End Sub";
return false;
}
public static String  _wf_ap_set_click() throws Exception{
 //BA.debugLineNum = 316;BA.debugLine="Sub wf_ap_set_Click()";
 //BA.debugLineNum = 317;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 318;BA.debugLine="StartActivity(AP_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._ap_set.getObject()));
 //BA.debugLineNum = 319;BA.debugLine="End Sub";
return "";
}
public static String  _wf_sta_set_click() throws Exception{
 //BA.debugLineNum = 320;BA.debugLine="Sub wf_sta_set_Click()";
 //BA.debugLineNum = 321;BA.debugLine="If  valid_menu_pass=False Then Return";
if (_valid_menu_pass()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return "";};
 //BA.debugLineNum = 322;BA.debugLine="StartActivity(STA_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sta_set.getObject()));
 //BA.debugLineNum = 323;BA.debugLine="End Sub";
return "";
}
public static String  _wifi_foundreadings(anywheresoftware.b4a.objects.collections.List _readings) throws Exception{
com.AB.ABWifi.ABWifi.ABWifiReading _reading = null;
 //BA.debugLineNum = 165;BA.debugLine="Sub wifi_FoundReadings(readings As List)";
 //BA.debugLineNum = 166;BA.debugLine="Try";
try { //BA.debugLineNum = 167;BA.debugLine="If readings.Size<1 Then Return";
if (_readings.getSize()<1) { 
if (true) return "";};
 //BA.debugLineNum = 168;BA.debugLine="Dim reading As ABWifiReading = readings.Get(0)";
_reading = (com.AB.ABWifi.ABWifi.ABWifiReading)(_readings.Get((int) (0)));
 //BA.debugLineNum = 169;BA.debugLine="wifisignal=reading.Level";
_wifisignal = _reading.Level;
 } 
       catch (Exception e137) {
			processBA.setLastException(e137); //BA.debugLineNum = 171;BA.debugLine="proces_error(LastException.Message & \"wi_fi_foun";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()+"wi_fi_foundread");
 };
 //BA.debugLineNum = 173;BA.debugLine="End Sub";
return "";
}
}
