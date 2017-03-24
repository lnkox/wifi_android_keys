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
public static boolean _keys_is_load = false;
public static int _conect_tmout = 0;
public static anywheresoftware.b4a.objects.Timer _mgetbut_tmr = null;
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
public static int _key_n = 0;
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

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (sel_dev.mostCurrent != null);
vis = vis | (ap_set.mostCurrent != null);
vis = vis | (sta_set.mostCurrent != null);
vis = vis | (key_set.mostCurrent != null);
vis = vis | (inet_set.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
int _i = 0;
anywheresoftware.b4a.objects.ButtonWrapper _tbuts = null;
 //BA.debugLineNum = 31;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 32;BA.debugLine="Try";
try { //BA.debugLineNum = 33;BA.debugLine="Activity.Title =\"Wi-Fi keys - \" & StateManager.Ge";
mostCurrent._activity.setTitle((Object)("Wi-Fi keys - "+mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
 //BA.debugLineNum = 34;BA.debugLine="Activity.AddMenuItem(\"Keys set\",\"keys_set\")";
mostCurrent._activity.AddMenuItem("Keys set","keys_set");
 //BA.debugLineNum = 35;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi AP set\",\"wf_ap_set";
mostCurrent._activity.AddMenuItem("Wi-Fi AP set","wf_ap_set");
 //BA.debugLineNum = 36;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi client set\",\"wf_ST";
mostCurrent._activity.AddMenuItem("Wi-Fi client set","wf_STA_set");
 //BA.debugLineNum = 37;BA.debugLine="Activity.AddMenuItem(\"Select device\",\"sel_dev\")";
mostCurrent._activity.AddMenuItem("Select device","sel_dev");
 //BA.debugLineNum = 38;BA.debugLine="Activity.AddMenuItem(\"Inet set\",\"inet_setm\")";
mostCurrent._activity.AddMenuItem("Inet set","inet_setm");
 //BA.debugLineNum = 39;BA.debugLine="Activity.AddMenuItem(\"Reset device\",\"reset_dev\")";
mostCurrent._activity.AddMenuItem("Reset device","reset_dev");
 //BA.debugLineNum = 40;BA.debugLine="Activity.AddMenuItem(\"EXIT\",\"exit_prg\")";
mostCurrent._activity.AddMenuItem("EXIT","exit_prg");
 //BA.debugLineNum = 41;BA.debugLine="prs.Initialize(Colors.Gray,0dip)";
mostCurrent._prs.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Gray,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
 //BA.debugLineNum = 42;BA.debugLine="ups.Initialize(Colors.DarkGray, 0dip)";
mostCurrent._ups.Initialize(anywheresoftware.b4a.keywords.Common.Colors.DarkGray,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
 //BA.debugLineNum = 43;BA.debugLine="grn.Initialize(Colors.RGB(0,150,0), 0dip)";
mostCurrent._grn.Initialize(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (0),(int) (150),(int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)));
 //BA.debugLineNum = 44;BA.debugLine="sld_norm.Initialize";
mostCurrent._sld_norm.Initialize();
 //BA.debugLineNum = 45;BA.debugLine="sld_norm.AddState(sld_norm.State_Pressed, ups)";
mostCurrent._sld_norm.AddState(mostCurrent._sld_norm.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._ups.getObject()));
 //BA.debugLineNum = 46;BA.debugLine="sld_norm.AddState(sld_norm.State_Enabled, ups)";
mostCurrent._sld_norm.AddState(mostCurrent._sld_norm.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._ups.getObject()));
 //BA.debugLineNum = 47;BA.debugLine="sld_on.Initialize";
mostCurrent._sld_on.Initialize();
 //BA.debugLineNum = 48;BA.debugLine="sld_on.AddState(sld_on.State_Pressed, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
 //BA.debugLineNum = 49;BA.debugLine="sld_on.AddState(sld_on.State_Enabled, grn)";
mostCurrent._sld_on.AddState(mostCurrent._sld_on.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._grn.getObject()));
 //BA.debugLineNum = 50;BA.debugLine="sld_down.Initialize";
mostCurrent._sld_down.Initialize();
 //BA.debugLineNum = 51;BA.debugLine="sld_down.AddState(sld_on.State_Pressed, prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Pressed,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
 //BA.debugLineNum = 52;BA.debugLine="sld_down.AddState(sld_on.State_Enabled, prs)";
mostCurrent._sld_down.AddState(mostCurrent._sld_on.State_Enabled,(android.graphics.drawable.Drawable)(mostCurrent._prs.getObject()));
 //BA.debugLineNum = 53;BA.debugLine="status_lab.Initialize(\"status_lab\")";
mostCurrent._status_lab.Initialize(mostCurrent.activityBA,"status_lab");
 //BA.debugLineNum = 54;BA.debugLine="status_lab.TextColor=Colors.Red";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 55;BA.debugLine="status_lab.Text = \"No connected\"";
mostCurrent._status_lab.setText((Object)("No connected"));
 //BA.debugLineNum = 56;BA.debugLine="Activity.AddView(status_lab, 0dip, Activity.He";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._status_lab.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),(int) (mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),mostCurrent._activity.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 57;BA.debugLine="For i = 1 To 32";
{
final int step26 = 1;
final int limit26 = (int) (32);
for (_i = (int) (1) ; (step26 > 0 && _i <= limit26) || (step26 < 0 && _i >= limit26); _i = ((int)(0 + _i + step26)) ) {
 //BA.debugLineNum = 58;BA.debugLine="Dim tbuts As Button";
_tbuts = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 59;BA.debugLine="tbuts.Initialize(\"tbuts\")";
_tbuts.Initialize(mostCurrent.activityBA,"tbuts");
 //BA.debugLineNum = 60;BA.debugLine="Activity.AddView(tbuts, -2000dip, 0, 20dip";
mostCurrent._activity.AddView((android.view.View)(_tbuts.getObject()),(int) (-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2000))),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)));
 //BA.debugLineNum = 61;BA.debugLine="tbuts.Background=sld_norm";
_tbuts.setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
 //BA.debugLineNum = 62;BA.debugLine="butt(i)=tbuts";
mostCurrent._butt[_i] = _tbuts;
 }
};
 //BA.debugLineNum = 65;BA.debugLine="If keys_is_load=False Then";
if (_keys_is_load==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 66;BA.debugLine="load_keys";
_load_keys();
 }else {
 //BA.debugLineNum = 68;BA.debugLine="StateManager.RestoreState (Activity, \"Main\", 60)";
mostCurrent._statemanager._restorestate(mostCurrent.activityBA,mostCurrent._activity,"Main",(int) (60));
 //BA.debugLineNum = 69;BA.debugLine="add_key_to_panel";
_add_key_to_panel();
 };
 //BA.debugLineNum = 71;BA.debugLine="send_state_timer.Initialize(\"send_state_timer\", 1";
_send_state_timer.Initialize(processBA,"send_state_timer",(long) (1000));
 //BA.debugLineNum = 72;BA.debugLine="send_state_timer.Enabled =True";
_send_state_timer.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e59) {
			processBA.setLastException(e59); //BA.debugLineNum = 74;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 76;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 82;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 83;BA.debugLine="Try";
try { //BA.debugLineNum = 84;BA.debugLine="If UserClosed Then";
if (_userclosed) { 
 //BA.debugLineNum = 85;BA.debugLine="StateManager.ResetState(\"Main\")";
mostCurrent._statemanager._resetstate(mostCurrent.activityBA,"Main");
 }else {
 //BA.debugLineNum = 87;BA.debugLine="StateManager.SaveState(Activity, \"Main\")";
mostCurrent._statemanager._savestate(mostCurrent.activityBA,mostCurrent._activity,"Main");
 };
 //BA.debugLineNum = 89;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(mostCurrent.activityBA);
 } 
       catch (Exception e73) {
			processBA.setLastException(e73); //BA.debugLineNum = 91;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 80;BA.debugLine="End Sub";
return "";
}
public static String  _add_key_to_panel() throws Exception{
int _b_width = 0;
int _b_height = 0;
int _posx = 0;
int _posy = 0;
int _max_but = 0;
int _a = 0;
 //BA.debugLineNum = 264;BA.debugLine="Sub add_key_to_panel() 'розміщення кнопок керуванн";
 //BA.debugLineNum = 265;BA.debugLine="Try";
try { //BA.debugLineNum = 266;BA.debugLine="Dim b_width,b_height,posx,posy,max_but As Int";
_b_width = 0;
_b_height = 0;
_posx = 0;
_posy = 0;
_max_but = 0;
 //BA.debugLineNum = 267;BA.debugLine="b_width=Activity.Width/CM.horiz_size";
_b_width = (int) (mostCurrent._activity.getWidth()/(double)mostCurrent._cm._horiz_size);
 //BA.debugLineNum = 268;BA.debugLine="b_height=(Activity.height-20dip)/CM.vert_size";
_b_height = (int) ((mostCurrent._activity.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)))/(double)mostCurrent._cm._vert_size);
 //BA.debugLineNum = 269;BA.debugLine="max_but =CM.horiz_size*CM.vert_size";
_max_but = (int) (mostCurrent._cm._horiz_size*mostCurrent._cm._vert_size);
 //BA.debugLineNum = 270;BA.debugLine="cur_but_state=0";
_cur_but_state = (int) (0);
 //BA.debugLineNum = 271;BA.debugLine="For a=1 To 32";
{
final int step7 = 1;
final int limit7 = (int) (32);
for (_a = (int) (1) ; (step7 > 0 && _a <= limit7) || (step7 < 0 && _a >= limit7); _a = ((int)(0 + _a + step7)) ) {
 //BA.debugLineNum = 272;BA.debugLine="If butstate(a)=True Then butt(a).Background=sld_";
if (_butstate[_a]==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._butt[_a].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_on.getObject()));};
 //BA.debugLineNum = 273;BA.debugLine="If CM.toint(butt(a).tag)>0 Then";
if (mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(mostCurrent._butt[_a].getTag()))>0) { 
 //BA.debugLineNum = 274;BA.debugLine="If cur_but_state>=max_but Then Return";
if (_cur_but_state>=_max_but) { 
if (true) return "";};
 //BA.debugLineNum = 275;BA.debugLine="posy=cur_but_state/CM.horiz_size";
_posy = (int) (_cur_but_state/(double)mostCurrent._cm._horiz_size);
 //BA.debugLineNum = 276;BA.debugLine="posx=cur_but_state mod CM.horiz_size";
_posx = (int) (_cur_but_state%mostCurrent._cm._horiz_size);
 //BA.debugLineNum = 277;BA.debugLine="butt(a).Left =posx*(b_width+1dip)";
mostCurrent._butt[_a].setLeft((int) (_posx*(_b_width+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
 //BA.debugLineNum = 278;BA.debugLine="butt(a).top =posy*(b_height+1dip)";
mostCurrent._butt[_a].setTop((int) (_posy*(_b_height+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1)))));
 //BA.debugLineNum = 279;BA.debugLine="butt(a).width =b_width-2dip";
mostCurrent._butt[_a].setWidth((int) (_b_width-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 //BA.debugLineNum = 280;BA.debugLine="butt(a).height =b_height-2dip";
mostCurrent._butt[_a].setHeight((int) (_b_height-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))));
 //BA.debugLineNum = 281;BA.debugLine="butt(a).TextSize =CM.font_size";
mostCurrent._butt[_a].setTextSize((float) (mostCurrent._cm._font_size));
 //BA.debugLineNum = 282;BA.debugLine="cur_but_state=cur_but_state+1";
_cur_but_state = (int) (_cur_but_state+1);
 };
 }
};
 } 
       catch (Exception e246) {
			processBA.setLastException(e246); //BA.debugLineNum = 286;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 288;BA.debugLine="End Sub";
return "";
}
public static String  _clear_keys() throws Exception{
int _i = 0;
 //BA.debugLineNum = 106;BA.debugLine="Sub clear_keys";
 //BA.debugLineNum = 107;BA.debugLine="Try";
try { //BA.debugLineNum = 108;BA.debugLine="For i = 1 To 32";
{
final int step2 = 1;
final int limit2 = (int) (32);
for (_i = (int) (1) ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
 //BA.debugLineNum = 109;BA.debugLine="butt(i).Left =-2000";
mostCurrent._butt[_i].setLeft((int) (-2000));
 //BA.debugLineNum = 110;BA.debugLine="butt(i).Tag =\"\"";
mostCurrent._butt[_i].setTag((Object)(""));
 }
};
 } 
       catch (Exception e94) {
			processBA.setLastException(e94); //BA.debugLineNum = 114;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 116;BA.debugLine="End Sub";
return "";
}
public static String  _get_key(int _ind) throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 130;BA.debugLine="Sub get_key(ind As Int)";
 //BA.debugLineNum = 131;BA.debugLine="Try";
try { //BA.debugLineNum = 132;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 133;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 134;BA.debugLine="Data.Put (\"getkey\",ind)";
_data.Put((Object)("getkey"),(Object)(_ind));
 //BA.debugLineNum = 135;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e116) {
			processBA.setLastException(e116); //BA.debugLineNum = 137;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 139;BA.debugLine="End Sub";
return "";
}
public static String  _get_key_info() throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 141;BA.debugLine="Sub get_key_info()";
 //BA.debugLineNum = 142;BA.debugLine="Try";
try { //BA.debugLineNum = 143;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 144;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 145;BA.debugLine="Data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
_data.Put((Object)("dev_name"),(Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
 //BA.debugLineNum = 146;BA.debugLine="Data.Put (\"getkey_info\",1)";
_data.Put((Object)("getkey_info"),(Object)(1));
 //BA.debugLineNum = 147;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e127) {
			processBA.setLastException(e127); //BA.debugLineNum = 149;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 151;BA.debugLine="End Sub";
return "";
}
public static String  _get_rssi() throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 234;BA.debugLine="Sub get_rssi() 'Відправка запиту на отримання рів";
 //BA.debugLineNum = 235;BA.debugLine="Try";
try { //BA.debugLineNum = 236;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 237;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 238;BA.debugLine="Data.Put (\"rssi\",1)";
_data.Put((Object)("rssi"),(Object)(1));
 //BA.debugLineNum = 239;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e212) {
			processBA.setLastException(e212); //BA.debugLineNum = 241;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 18;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim butt(33) As Button";
mostCurrent._butt = new anywheresoftware.b4a.objects.ButtonWrapper[(int) (33)];
{
int d0 = mostCurrent._butt.length;
for (int i0 = 0;i0 < d0;i0++) {
mostCurrent._butt[i0] = new anywheresoftware.b4a.objects.ButtonWrapper();
}
}
;
 //BA.debugLineNum = 21;BA.debugLine="Dim status_lab As Label";
mostCurrent._status_lab = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Dim butlock(33) As Boolean";
_butlock = new boolean[(int) (33)];
;
 //BA.debugLineNum = 23;BA.debugLine="Dim butstate(33) As Boolean";
_butstate = new boolean[(int) (33)];
;
 //BA.debugLineNum = 24;BA.debugLine="Dim sld_norm,sld_on,sld_down As StateListDrawable";
mostCurrent._sld_norm = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
mostCurrent._sld_on = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
mostCurrent._sld_down = new anywheresoftware.b4a.objects.drawable.StateListDrawable();
 //BA.debugLineNum = 25;BA.debugLine="Dim prs, ups,grn As ColorDrawable";
mostCurrent._prs = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
mostCurrent._ups = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
mostCurrent._grn = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
 //BA.debugLineNum = 26;BA.debugLine="Dim key_n As Int =0";
_key_n = (int) (0);
 //BA.debugLineNum = 27;BA.debugLine="Dim cur_but_state As Int";
_cur_but_state = 0;
 //BA.debugLineNum = 28;BA.debugLine="Dim prs_but As Int";
_prs_but = 0;
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _inet_setm_click() throws Exception{
 //BA.debugLineNum = 346;BA.debugLine="Sub inet_setm_Click()";
 //BA.debugLineNum = 347;BA.debugLine="StartActivity(INET_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._inet_set.getObject()));
 //BA.debugLineNum = 348;BA.debugLine="End Sub";
return "";
}
public static String  _keys_set_click() throws Exception{
 //BA.debugLineNum = 343;BA.debugLine="Sub keys_set_Click()";
 //BA.debugLineNum = 344;BA.debugLine="StartActivity(KEY_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._key_set.getObject()));
 //BA.debugLineNum = 345;BA.debugLine="End Sub";
return "";
}
public static String  _load_keys() throws Exception{
 //BA.debugLineNum = 95;BA.debugLine="Sub load_keys()";
 //BA.debugLineNum = 96;BA.debugLine="Try";
try { //BA.debugLineNum = 97;BA.debugLine="clear_keys";
_clear_keys();
 //BA.debugLineNum = 98;BA.debugLine="get_key_info";
_get_key_info();
 //BA.debugLineNum = 99;BA.debugLine="key_n=0";
_key_n = (int) (0);
 //BA.debugLineNum = 100;BA.debugLine="mgetbut_tmr.Initialize(\"mgetbut_tmr\", 210)";
_mgetbut_tmr.Initialize(processBA,"mgetbut_tmr",(long) (210));
 //BA.debugLineNum = 101;BA.debugLine="mgetbut_tmr.Enabled =True";
_mgetbut_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e84) {
			processBA.setLastException(e84); //BA.debugLineNum = 103;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _mgetbut_tmr_tick() throws Exception{
 //BA.debugLineNum = 117;BA.debugLine="Sub mgetbut_tmr_Tick()";
 //BA.debugLineNum = 118;BA.debugLine="Try";
try { //BA.debugLineNum = 119;BA.debugLine="key_n=key_n+1";
_key_n = (int) (_key_n+1);
 //BA.debugLineNum = 120;BA.debugLine="If key_n=31 Then";
if (_key_n==31) { 
 //BA.debugLineNum = 121;BA.debugLine="mgetbut_tmr.Enabled =False";
_mgetbut_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 122;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 124;BA.debugLine="get_key(key_n)";
_get_key(_key_n);
 } 
       catch (Exception e106) {
			processBA.setLastException(e106); //BA.debugLineNum = 126;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 128;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
 //BA.debugLineNum = 365;BA.debugLine="Sub proces_error(msg As String)";
 //BA.debugLineNum = 366;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",mostCurrent.activityBA);
 //BA.debugLineNum = 367;BA.debugLine="End Sub";
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
sta_set._process_globals();
key_set._process_globals();
cm._process_globals();
inet_set._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim keys_is_load As Boolean";
_keys_is_load = false;
 //BA.debugLineNum = 14;BA.debugLine="Dim conect_tmout As Int";
_conect_tmout = 0;
 //BA.debugLineNum = 15;BA.debugLine="Public  mgetbut_tmr As Timer";
_mgetbut_tmr = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 16;BA.debugLine="Public  send_state_timer As Timer";
_send_state_timer = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public static String  _reload_key_state(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
int _tmpid = 0;
 //BA.debugLineNum = 201;BA.debugLine="Sub reload_key_state(mapar As Map)";
 //BA.debugLineNum = 202;BA.debugLine="Try";
try { //BA.debugLineNum = 203;BA.debugLine="Dim tmpid As Int";
_tmpid = 0;
 //BA.debugLineNum = 204;BA.debugLine="tmpid=CM.toint(mapar.Get (\"rind\"))";
_tmpid = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("rind"))));
 //BA.debugLineNum = 205;BA.debugLine="If tmpid>0 Then";
if (_tmpid>0) { 
 //BA.debugLineNum = 206;BA.debugLine="If CM.toint(mapar.Get (\"rcom\"))=1 Then";
if (mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("rcom"))))==1) { 
 //BA.debugLineNum = 207;BA.debugLine="butt(tmpid).Background =sld_on";
mostCurrent._butt[_tmpid].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_on.getObject()));
 }else {
 //BA.debugLineNum = 209;BA.debugLine="butt(tmpid).Background =sld_norm";
mostCurrent._butt[_tmpid].setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_norm.getObject()));
 };
 };
 } 
       catch (Exception e187) {
			processBA.setLastException(e187); //BA.debugLineNum = 213;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 215;BA.debugLine="End Sub";
return "";
}
public static String  _reset_dev_click() throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 349;BA.debugLine="Sub reset_dev_Click()";
 //BA.debugLineNum = 350;BA.debugLine="Try";
try { //BA.debugLineNum = 351;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 352;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 353;BA.debugLine="Data.Put (\"rst\",1)";
_data.Put((Object)("rst"),(Object)(1));
 //BA.debugLineNum = 354;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e310) {
			processBA.setLastException(e310); //BA.debugLineNum = 356;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 360;BA.debugLine="End Sub";
return "";
}
public static String  _sel_dev_click() throws Exception{
 //BA.debugLineNum = 334;BA.debugLine="Sub sel_dev_Click()";
 //BA.debugLineNum = 335;BA.debugLine="StartActivity(sel_dev)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sel_dev.getObject()));
 //BA.debugLineNum = 336;BA.debugLine="End Sub";
return "";
}
public static String  _send_comm(int _ind,boolean _com,boolean _lock) throws Exception{
anywheresoftware.b4a.objects.collections.Map _data = null;
 //BA.debugLineNum = 188;BA.debugLine="Sub send_comm(ind As Int,com As Boolean,lock As Bo";
 //BA.debugLineNum = 189;BA.debugLine="Try";
try { //BA.debugLineNum = 190;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 191;BA.debugLine="Data.Initialize";
_data.Initialize();
 //BA.debugLineNum = 192;BA.debugLine="Data.Put (\"ncom\",ind)";
_data.Put((Object)("ncom"),(Object)(_ind));
 //BA.debugLineNum = 193;BA.debugLine="Data.Put (\"com\",com)";
_data.Put((Object)("com"),(Object)(_com));
 //BA.debugLineNum = 194;BA.debugLine="Data.Put (\"lock\",lock)";
_data.Put((Object)("lock"),(Object)(_lock));
 //BA.debugLineNum = 195;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e172) {
			processBA.setLastException(e172); //BA.debugLineNum = 197;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public static String  _send_state_timer_tick() throws Exception{
 //BA.debugLineNum = 217;BA.debugLine="Sub send_state_timer_Tick() ' таймер перевірки звя";
 //BA.debugLineNum = 218;BA.debugLine="Try";
try { //BA.debugLineNum = 219;BA.debugLine="If prs_but>0 Then send_comm(prs_but,True,False)";
if (_prs_but>0) { 
_send_comm(_prs_but,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);};
 //BA.debugLineNum = 220;BA.debugLine="get_rssi";
_get_rssi();
 //BA.debugLineNum = 221;BA.debugLine="If conect_tmout>0 Then";
if (_conect_tmout>0) { 
 //BA.debugLineNum = 222;BA.debugLine="conect_tmout=conect_tmout-1";
_conect_tmout = (int) (_conect_tmout-1);
 //BA.debugLineNum = 223;BA.debugLine="If conect_tmout=0 Then";
if (_conect_tmout==0) { 
 //BA.debugLineNum = 224;BA.debugLine="status_lab.TextColor=Colors.Red";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);
 //BA.debugLineNum = 225;BA.debugLine="status_lab.Text = \"No connected\"";
mostCurrent._status_lab.setText((Object)("No connected"));
 };
 };
 } 
       catch (Exception e202) {
			processBA.setLastException(e202); //BA.debugLineNum = 230;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 232;BA.debugLine="End Sub";
return "";
}
public static String  _set_key_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
 //BA.debugLineNum = 153;BA.debugLine="Sub set_key_set (mapar As Map)";
 //BA.debugLineNum = 154;BA.debugLine="Try";
try { //BA.debugLineNum = 155;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))<1 Or CM.toint(ma";
if (mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))<1 || mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))>30) { 
if (true) return "";};
 //BA.debugLineNum = 156;BA.debugLine="If CM.toint(mapar.Get (\"key_id\"))=30 Then";
if (mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("key_id"))))==30) { 
 //BA.debugLineNum = 157;BA.debugLine="keys_is_load=True";
_keys_is_load = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 158;BA.debugLine="add_key_to_panel";
_add_key_to_panel();
 //BA.debugLineNum = 159;BA.debugLine="mgetbut_tmr.Enabled =False";
_mgetbut_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 160;BA.debugLine="StateManager.SaveState(Activity, \"Main\")";
mostCurrent._statemanager._savestate(mostCurrent.activityBA,mostCurrent._activity,"Main");
 //BA.debugLineNum = 161;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(mostCurrent.activityBA);
 //BA.debugLineNum = 162;BA.debugLine="ToastMessageShow(\"Load keys complete\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Load keys complete",anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 164;BA.debugLine="butt(mapar.Get (\"key_id\")).Text = mapar.Get (\"na";
mostCurrent._butt[(int)(BA.ObjectToNumber(_mapar.Get((Object)("key_id"))))].setText(_mapar.Get((Object)("name")));
 //BA.debugLineNum = 165;BA.debugLine="If butt(mapar.Get (\"key_id\")).Text =\"@\" Then";
if ((mostCurrent._butt[(int)(BA.ObjectToNumber(_mapar.Get((Object)("key_id"))))].getText()).equals("@")) { 
 //BA.debugLineNum = 166;BA.debugLine="butt(mapar.Get (\"key_id\")).tag=\"\"";
mostCurrent._butt[(int)(BA.ObjectToNumber(_mapar.Get((Object)("key_id"))))].setTag((Object)(""));
 }else {
 //BA.debugLineNum = 168;BA.debugLine="butt(mapar.Get (\"key_id\")).tag = mapar.Get (\"ke";
mostCurrent._butt[(int)(BA.ObjectToNumber(_mapar.Get((Object)("key_id"))))].setTag(_mapar.Get((Object)("key_id")));
 };
 //BA.debugLineNum = 170;BA.debugLine="butlock(mapar.Get (\"key_id\"))  = CM.obj2Bool( ma";
_butlock[(int)(BA.ObjectToNumber(_mapar.Get((Object)("key_id"))))] = mostCurrent._cm._obj2bool(mostCurrent.activityBA,_mapar.Get((Object)("lock")));
 //BA.debugLineNum = 171;BA.debugLine="butstate(mapar.Get (\"key_id\"))  = CM.obj2Bool( m";
_butstate[(int)(BA.ObjectToNumber(_mapar.Get((Object)("key_id"))))] = mostCurrent._cm._obj2bool(mostCurrent.activityBA,_mapar.Get((Object)("state")));
 } 
       catch (Exception e150) {
			processBA.setLastException(e150); //BA.debugLineNum = 173;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return "";
}
public static String  _set_keyinfo_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
 //BA.debugLineNum = 177;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
 //BA.debugLineNum = 178;BA.debugLine="Try";
try { //BA.debugLineNum = 179;BA.debugLine="ToastMessageShow(\"Loading keys....\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Loading keys....",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 180;BA.debugLine="If mapar.ContainsKey(\"font_size\")=True Then  CM.f";
if (_mapar.ContainsKey((Object)("font_size"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._cm._font_size = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("font_size"))));};
 //BA.debugLineNum = 181;BA.debugLine="If mapar.ContainsKey(\"h_size\")=True Then   CM.hor";
if (_mapar.ContainsKey((Object)("h_size"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._cm._horiz_size = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("h_size"))));};
 //BA.debugLineNum = 182;BA.debugLine="If mapar.ContainsKey(\"v_size\")=True Then   CM.ver";
if (_mapar.ContainsKey((Object)("v_size"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._cm._vert_size = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_mapar.Get((Object)("v_size"))));};
 } 
       catch (Exception e160) {
			processBA.setLastException(e160); //BA.debugLineNum = 184;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 186;BA.debugLine="End Sub";
return "";
}
public static String  _set_ris(int _rsi) throws Exception{
 //BA.debugLineNum = 245;BA.debugLine="Sub set_ris(rsi As Int)";
 //BA.debugLineNum = 246;BA.debugLine="Try";
try { //BA.debugLineNum = 247;BA.debugLine="status_lab.TextColor=Colors.Green";
mostCurrent._status_lab.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Green);
 //BA.debugLineNum = 248;BA.debugLine="status_lab.Text = \" RSSI: \" & rsi & \"dbm   Connec";
mostCurrent._status_lab.setText((Object)(" RSSI: "+BA.NumberToString(_rsi)+"dbm   Connected"));
 //BA.debugLineNum = 249;BA.debugLine="conect_tmout=3";
_conect_tmout = (int) (3);
 } 
       catch (Exception e221) {
			processBA.setLastException(e221); //BA.debugLineNum = 251;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 253;BA.debugLine="End Sub";
return "";
}
public static String  _status_lab_longclick() throws Exception{
 //BA.debugLineNum = 361;BA.debugLine="Sub status_lab_LongClick";
 //BA.debugLineNum = 362;BA.debugLine="load_keys";
_load_keys();
 //BA.debugLineNum = 363;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_click() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
 //BA.debugLineNum = 318;BA.debugLine="Sub tbuts_click()";
 //BA.debugLineNum = 319;BA.debugLine="Try";
try { //BA.debugLineNum = 320;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 321;BA.debugLine="Dim tmind As Int";
_tmind = 0;
 //BA.debugLineNum = 322;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 323;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
 //BA.debugLineNum = 324;BA.debugLine="If butlock(tmind) =False Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 325;BA.debugLine="prs_but=0";
_prs_but = (int) (0);
 //BA.debugLineNum = 326;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 327;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 };
 } 
       catch (Exception e285) {
			processBA.setLastException(e285); //BA.debugLineNum = 330;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 332;BA.debugLine="End Sub";
return "";
}
public static String  _tbuts_down() throws Exception{
anywheresoftware.b4a.objects.ButtonWrapper _p = null;
int _tmind = 0;
 //BA.debugLineNum = 293;BA.debugLine="Sub tbuts_down()";
 //BA.debugLineNum = 294;BA.debugLine="Try";
try { //BA.debugLineNum = 295;BA.debugLine="Dim p As Button";
_p = new anywheresoftware.b4a.objects.ButtonWrapper();
 //BA.debugLineNum = 296;BA.debugLine="Dim tmind As Int";
_tmind = 0;
 //BA.debugLineNum = 297;BA.debugLine="p = Sender";
_p.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
 //BA.debugLineNum = 298;BA.debugLine="p.Background =sld_down";
_p.setBackground((android.graphics.drawable.Drawable)(mostCurrent._sld_down.getObject()));
 //BA.debugLineNum = 299;BA.debugLine="tmind=CM.toint(p.Tag)";
_tmind = mostCurrent._cm._toint(mostCurrent.activityBA,BA.ObjectToString(_p.getTag()));
 //BA.debugLineNum = 300;BA.debugLine="If butlock(tmind) =True Then";
if (_butlock[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 301;BA.debugLine="If butstate(tmind)=True Then";
if (_butstate[_tmind]==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 302;BA.debugLine="send_comm(tmind,False,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.False,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 303;BA.debugLine="butstate(tmind)=False";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 305;BA.debugLine="send_comm(tmind,True,True)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 306;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
 };
 }else {
 //BA.debugLineNum = 309;BA.debugLine="butstate(tmind)=True";
_butstate[_tmind] = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 310;BA.debugLine="send_comm(tmind,True,False)";
_send_comm(_tmind,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 311;BA.debugLine="prs_but=tmind";
_prs_but = _tmind;
 };
 } 
       catch (Exception e270) {
			processBA.setLastException(e270); //BA.debugLineNum = 314;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return "";
}
public static String  _wf_ap_set_click() throws Exception{
 //BA.debugLineNum = 337;BA.debugLine="Sub wf_ap_set_Click()";
 //BA.debugLineNum = 338;BA.debugLine="StartActivity(AP_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._ap_set.getObject()));
 //BA.debugLineNum = 339;BA.debugLine="End Sub";
return "";
}
public static String  _wf_sta_set_click() throws Exception{
 //BA.debugLineNum = 340;BA.debugLine="Sub wf_sta_set_Click()";
 //BA.debugLineNum = 341;BA.debugLine="StartActivity(STA_SET)";
anywheresoftware.b4a.keywords.Common.StartActivity(mostCurrent.activityBA,(Object)(mostCurrent._sta_set.getObject()));
 //BA.debugLineNum = 342;BA.debugLine="End Sub";
return "";
}
}
