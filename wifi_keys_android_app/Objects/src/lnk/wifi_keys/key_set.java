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

public class key_set extends Activity implements B4AActivity{
	public static key_set mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "lnk.wifi_keys", "lnk.wifi_keys.key_set");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (key_set).");
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
		activityBA = new BA(this, layout, processBA, "lnk.wifi_keys", "lnk.wifi_keys.key_set");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "lnk.wifi_keys.key_set", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (key_set) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (key_set) Resume **");
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
		return key_set.class;
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
        BA.LogInfo("** Activity (key_set) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            BA.LogInfo("** Activity (key_set) Resume **");
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
public static boolean _key_set_load = false;
public anywheresoftware.b4a.objects.Timer _setbut_tmr = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scview = null;
public anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper[] _chk = null;
public anywheresoftware.b4a.objects.LabelWrapper[] _lab = null;
public anywheresoftware.b4a.objects.EditTextWrapper[] _txt = null;
public anywheresoftware.b4a.objects.EditTextWrapper _font_size = null;
public anywheresoftware.b4a.objects.LabelWrapper _lfont_size = null;
public anywheresoftware.b4a.objects.EditTextWrapper _v_size = null;
public anywheresoftware.b4a.objects.LabelWrapper _lv_size = null;
public anywheresoftware.b4a.objects.EditTextWrapper _h_size = null;
public anywheresoftware.b4a.objects.LabelWrapper _lh_size = null;
public anywheresoftware.b4a.objects.ButtonWrapper _save_ks_but = null;
public static int _key_n = 0;
public lnk.wifi_keys.main _main = null;
public lnk.wifi_keys.starter _starter = null;
public lnk.wifi_keys.statemanager _statemanager = null;
public lnk.wifi_keys.sel_dev _sel_dev = null;
public lnk.wifi_keys.ap_set _ap_set = null;
public lnk.wifi_keys.cm _cm = null;
public lnk.wifi_keys.inet_set _inet_set = null;
public lnk.wifi_keys.sta_set _sta_set = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
int _i = 0;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _tchk = null;
anywheresoftware.b4a.objects.LabelWrapper _tlab = null;
anywheresoftware.b4a.objects.EditTextWrapper _ttxt = null;
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Try";
try {RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="Activity.LoadLayout(\"key_set_lay\")";
mostCurrent._activity.LoadLayout("key_set_lay",mostCurrent.activityBA);
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="lfont_size.Initialize(\"lfont_size\")";
mostCurrent._lfont_size.Initialize(mostCurrent.activityBA,"lfont_size");
RDebugUtils.currentLine=5701636;
 //BA.debugLineNum = 5701636;BA.debugLine="scview.Panel.AddView(lfont_size, 5dip, 10dip, 60d";
mostCurrent._scview.getPanel().AddView((android.view.View)(mostCurrent._lfont_size.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (5)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (60)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="lfont_size.Text =\"Font:\"";
mostCurrent._lfont_size.setText((Object)("Font:"));
RDebugUtils.currentLine=5701638;
 //BA.debugLineNum = 5701638;BA.debugLine="lfont_size.TextSize =\"14\"";
mostCurrent._lfont_size.setTextSize((float)(Double.parseDouble("14")));
RDebugUtils.currentLine=5701639;
 //BA.debugLineNum = 5701639;BA.debugLine="font_size.Initialize(\"font_size\")";
mostCurrent._font_size.Initialize(mostCurrent.activityBA,"font_size");
RDebugUtils.currentLine=5701640;
 //BA.debugLineNum = 5701640;BA.debugLine="font_size.InputType = font_size.INPUT_TYPE_NUMBER";
mostCurrent._font_size.setInputType(mostCurrent._font_size.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=5701641;
 //BA.debugLineNum = 5701641;BA.debugLine="scview.Panel.AddView(font_size, 40dip ,0dip, 50di";
mostCurrent._scview.getPanel().AddView((android.view.View)(mostCurrent._font_size.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701642;
 //BA.debugLineNum = 5701642;BA.debugLine="font_size.SingleLine=True";
mostCurrent._font_size.setSingleLine(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5701643;
 //BA.debugLineNum = 5701643;BA.debugLine="font_size.Text =\"14\"";
mostCurrent._font_size.setText((Object)("14"));
RDebugUtils.currentLine=5701644;
 //BA.debugLineNum = 5701644;BA.debugLine="lh_size.Initialize(\"lh_size\")";
mostCurrent._lh_size.Initialize(mostCurrent.activityBA,"lh_size");
RDebugUtils.currentLine=5701645;
 //BA.debugLineNum = 5701645;BA.debugLine="scview.Panel.AddView(lh_size, 120dip, 10dip, 40di";
mostCurrent._scview.getPanel().AddView((android.view.View)(mostCurrent._lh_size.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (120)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701646;
 //BA.debugLineNum = 5701646;BA.debugLine="lh_size.Text =\"Horiz:\"";
mostCurrent._lh_size.setText((Object)("Horiz:"));
RDebugUtils.currentLine=5701647;
 //BA.debugLineNum = 5701647;BA.debugLine="h_size.Initialize(\"h_size\")";
mostCurrent._h_size.Initialize(mostCurrent.activityBA,"h_size");
RDebugUtils.currentLine=5701648;
 //BA.debugLineNum = 5701648;BA.debugLine="h_size.InputType = h_size.INPUT_TYPE_NUMBERS";
mostCurrent._h_size.setInputType(mostCurrent._h_size.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=5701649;
 //BA.debugLineNum = 5701649;BA.debugLine="scview.Panel.AddView(h_size, 160dip ,0dip, 40dip,";
mostCurrent._scview.getPanel().AddView((android.view.View)(mostCurrent._h_size.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (160)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701650;
 //BA.debugLineNum = 5701650;BA.debugLine="h_size.SingleLine=True";
mostCurrent._h_size.setSingleLine(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5701651;
 //BA.debugLineNum = 5701651;BA.debugLine="lv_size.Initialize(\"lv_size\")";
mostCurrent._lv_size.Initialize(mostCurrent.activityBA,"lv_size");
RDebugUtils.currentLine=5701652;
 //BA.debugLineNum = 5701652;BA.debugLine="scview.Panel.AddView(lv_size, 210dip, 10dip, 40di";
mostCurrent._scview.getPanel().AddView((android.view.View)(mostCurrent._lv_size.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (210)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701653;
 //BA.debugLineNum = 5701653;BA.debugLine="lv_size.Text =\"Vert:\"";
mostCurrent._lv_size.setText((Object)("Vert:"));
RDebugUtils.currentLine=5701654;
 //BA.debugLineNum = 5701654;BA.debugLine="v_size.Initialize(\"h_size\")";
mostCurrent._v_size.Initialize(mostCurrent.activityBA,"h_size");
RDebugUtils.currentLine=5701655;
 //BA.debugLineNum = 5701655;BA.debugLine="v_size.InputType = v_size.INPUT_TYPE_NUMBERS";
mostCurrent._v_size.setInputType(mostCurrent._v_size.INPUT_TYPE_NUMBERS);
RDebugUtils.currentLine=5701656;
 //BA.debugLineNum = 5701656;BA.debugLine="scview.Panel.AddView(v_size, 240dip ,0dip, 40dip,";
mostCurrent._scview.getPanel().AddView((android.view.View)(mostCurrent._v_size.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (240)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (0)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701657;
 //BA.debugLineNum = 5701657;BA.debugLine="v_size.SingleLine=True";
mostCurrent._v_size.setSingleLine(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5701659;
 //BA.debugLineNum = 5701659;BA.debugLine="For i = 1 To 30";
{
final int step26 = 1;
final int limit26 = (int) (30);
for (_i = (int) (1) ; (step26 > 0 && _i <= limit26) || (step26 < 0 && _i >= limit26); _i = ((int)(0 + _i + step26)) ) {
RDebugUtils.currentLine=5701660;
 //BA.debugLineNum = 5701660;BA.debugLine="Dim tchk As CheckBox";
_tchk = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=5701661;
 //BA.debugLineNum = 5701661;BA.debugLine="Dim tlab As Label";
_tlab = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5701662;
 //BA.debugLineNum = 5701662;BA.debugLine="Dim ttxt As EditText";
_ttxt = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=5701663;
 //BA.debugLineNum = 5701663;BA.debugLine="tchk.Initialize(\"CheckBox\")";
_tchk.Initialize(mostCurrent.activityBA,"CheckBox");
RDebugUtils.currentLine=5701664;
 //BA.debugLineNum = 5701664;BA.debugLine="tlab.Initialize(\"label\")";
_tlab.Initialize(mostCurrent.activityBA,"label");
RDebugUtils.currentLine=5701665;
 //BA.debugLineNum = 5701665;BA.debugLine="ttxt.Initialize(\"edittext\")";
_ttxt.Initialize(mostCurrent.activityBA,"edittext");
RDebugUtils.currentLine=5701666;
 //BA.debugLineNum = 5701666;BA.debugLine="scview.Panel.AddView(tlab, 0, i*40dip+10di";
mostCurrent._scview.getPanel().AddView((android.view.View)(_tlab.getObject()),(int) (0),(int) (_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701667;
 //BA.debugLineNum = 5701667;BA.debugLine="scview.Panel.AddView(tchk, 15dip, i*40dip, 30d";
mostCurrent._scview.getPanel().AddView((android.view.View)(_tchk.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (15)),(int) (_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701668;
 //BA.debugLineNum = 5701668;BA.debugLine="scview.Panel.AddView(ttxt, 45dip, i*40dip, Activ";
mostCurrent._scview.getPanel().AddView((android.view.View)(_ttxt.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (45)),(int) (_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (50))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701669;
 //BA.debugLineNum = 5701669;BA.debugLine="tlab.Tag=i:tchk.Tag=i:ttxt.Tag=i:";
_tlab.setTag((Object)(_i));
RDebugUtils.currentLine=5701669;
 //BA.debugLineNum = 5701669;BA.debugLine="tlab.Tag=i:tchk.Tag=i:ttxt.Tag=i:";
_tchk.setTag((Object)(_i));
RDebugUtils.currentLine=5701669;
 //BA.debugLineNum = 5701669;BA.debugLine="tlab.Tag=i:tchk.Tag=i:ttxt.Tag=i:";
_ttxt.setTag((Object)(_i));
RDebugUtils.currentLine=5701670;
 //BA.debugLineNum = 5701670;BA.debugLine="tlab.Text=i";
_tlab.setText((Object)(_i));
RDebugUtils.currentLine=5701671;
 //BA.debugLineNum = 5701671;BA.debugLine="ttxt.SingleLine=True";
_ttxt.setSingleLine(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5701672;
 //BA.debugLineNum = 5701672;BA.debugLine="lab(i)=tlab";
mostCurrent._lab[_i] = _tlab;
RDebugUtils.currentLine=5701673;
 //BA.debugLineNum = 5701673;BA.debugLine="chk(i)=tchk";
mostCurrent._chk[_i] = _tchk;
RDebugUtils.currentLine=5701674;
 //BA.debugLineNum = 5701674;BA.debugLine="txt(i)=ttxt";
mostCurrent._txt[_i] = _ttxt;
 }
};
RDebugUtils.currentLine=5701676;
 //BA.debugLineNum = 5701676;BA.debugLine="save_ks_but.Initialize(\"save_ks_but\")";
mostCurrent._save_ks_but.Initialize(mostCurrent.activityBA,"save_ks_but");
RDebugUtils.currentLine=5701677;
 //BA.debugLineNum = 5701677;BA.debugLine="save_ks_but.Text =\"Save\"";
mostCurrent._save_ks_but.setText((Object)("Save"));
RDebugUtils.currentLine=5701678;
 //BA.debugLineNum = 5701678;BA.debugLine="scview.Panel.AddView(save_ks_but, 10dip ,1260dip,";
mostCurrent._scview.getPanel().AddView((android.view.View)(mostCurrent._save_ks_but.getObject()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1260)),(int) (mostCurrent._activity.getWidth()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (20))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40)));
RDebugUtils.currentLine=5701679;
 //BA.debugLineNum = 5701679;BA.debugLine="scview.Panel.Height =1340dip";
mostCurrent._scview.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1340)));
RDebugUtils.currentLine=5701680;
 //BA.debugLineNum = 5701680;BA.debugLine="Activity.Title =\"Keys setup - \" & StateManager.Ge";
mostCurrent._activity.setTitle((Object)("Keys setup - "+mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"cur_dev_name","none")));
RDebugUtils.currentLine=5701681;
 //BA.debugLineNum = 5701681;BA.debugLine="get_key_data";
_get_key_data();
 } 
       catch (Exception e70) {
			processBA.setLastException(e70);RDebugUtils.currentLine=5701683;
 //BA.debugLineNum = 5701683;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=5701685;
 //BA.debugLineNum = 5701685;BA.debugLine="End Sub";
return "";
}
public static String  _get_key_data() throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("get_key_data"))
	return (String) Debug.delegate(mostCurrent.activityBA, "get_key_data", null);
int _a = 0;
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub get_key_data() 'заповнення полів налаштування";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Try";
try {RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="v_size.Text=StateManager.GetSetting2(\"v_size\",\"\")";
mostCurrent._v_size.setText((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"v_size","")));
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="h_size.Text=StateManager.GetSetting2(\"h_size\",\"\")";
mostCurrent._h_size.setText((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"h_size","")));
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="font_size.Text=StateManager.GetSetting2(\"font_siz";
mostCurrent._font_size.setText((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"font_size","")));
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="For a=1 To 30";
{
final int step5 = 1;
final int limit5 = (int) (30);
for (_a = (int) (1) ; (step5 > 0 && _a <= limit5) || (step5 < 0 && _a >= limit5); _a = ((int)(0 + _a + step5)) ) {
RDebugUtils.currentLine=5898247;
 //BA.debugLineNum = 5898247;BA.debugLine="chk(a).Checked=CM.obj2Bool(StateManager.GetSetti";
mostCurrent._chk[_a].setChecked(mostCurrent._cm._obj2bool(mostCurrent.activityBA,(Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keylock"+BA.NumberToString(_a),BA.NumberToString(0)))));
RDebugUtils.currentLine=5898248;
 //BA.debugLineNum = 5898248;BA.debugLine="txt(a).Text =StateManager.GetSetting2(\"keytext\"";
mostCurrent._txt[_a].setText((Object)(mostCurrent._statemanager._getsetting2(mostCurrent.activityBA,"keytext"+BA.NumberToString(_a),"")));
 }
};
 } 
       catch (Exception e87) {
			processBA.setLastException(e87);RDebugUtils.currentLine=5898251;
 //BA.debugLineNum = 5898251;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=5898253;
 //BA.debugLineNum = 5898253;BA.debugLine="End Sub";
return "";
}
public static String  _proces_error(String _msg) throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("proces_error"))
	return (String) Debug.delegate(mostCurrent.activityBA, "proces_error", new Object[] {_msg});
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub proces_error(msg As String)";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="Msgbox(msg,\"error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(_msg,"error",mostCurrent.activityBA);
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("activity_pause"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_pause", new Object[] {_userclosed});
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="End Sub";
return "";
}
public static String  _finish_him() throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("finish_him"))
	return (String) Debug.delegate(mostCurrent.activityBA, "finish_him", null);
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub finish_him()";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="Try";
try {RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="CallSubDelayed(Main,\"load_keys\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(mostCurrent.activityBA,(Object)(mostCurrent._main.getObject()),"load_keys");
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 } 
       catch (Exception e160) {
			processBA.setLastException(e160);RDebugUtils.currentLine=6356997;
 //BA.debugLineNum = 6356997;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=6356999;
 //BA.debugLineNum = 6356999;BA.debugLine="End Sub";
return "";
}
public static String  _save_ks_but_click() throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("save_ks_but_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "save_ks_but_click", null);
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub save_ks_but_Click";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Try";
try {RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="ToastMessageShow(\"Saving....\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Saving....",anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="key_n=0";
_key_n = (int) (0);
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="setbut_tmr.Initialize(\"setbut_tmr\", 100)";
mostCurrent._setbut_tmr.Initialize(processBA,"setbut_tmr",(long) (100));
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="setbut_tmr.Enabled =True";
mostCurrent._setbut_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 } 
       catch (Exception e97) {
			processBA.setLastException(e97);RDebugUtils.currentLine=5963783;
 //BA.debugLineNum = 5963783;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=5963785;
 //BA.debugLineNum = 5963785;BA.debugLine="End Sub";
return "";
}
public static String  _set_key(int _ind) throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("set_key"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_key", new Object[] {_ind});
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub set_key(ind As Int)";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="Try";
try {RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="Data.Put (\"setkey\",ind)";
_data.Put((Object)("setkey"),(Object)(_ind));
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="Data.Put (\"name\",txt(ind).Text)";
_data.Put((Object)("name"),(Object)(mostCurrent._txt[_ind].getText()));
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="Data.Put (\"lock\",chk(ind).Checked)";
_data.Put((Object)("lock"),(Object)(mostCurrent._chk[_ind].getChecked()));
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e122) {
			processBA.setLastException(e122);RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=6094859;
 //BA.debugLineNum = 6094859;BA.debugLine="End Sub";
return "";
}
public static String  _set_key_info() throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("set_key_info"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_key_info", null);
anywheresoftware.b4a.objects.collections.Map _data = null;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub set_key_info()";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="Try";
try {RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="Dim Data As Map";
_data = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="Data.Initialize";
_data.Initialize();
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="Data.Put (\"font_size\",font_size.Text)";
_data.Put((Object)("font_size"),(Object)(mostCurrent._font_size.getText()));
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="Data.Put (\"h_size\",h_size.Text)";
_data.Put((Object)("h_size"),(Object)(mostCurrent._h_size.getText()));
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="Data.Put (\"v_size\",v_size.Text)";
_data.Put((Object)("v_size"),(Object)(mostCurrent._v_size.getText()));
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="Data.Put (\"save_info\",3)";
_data.Put((Object)("save_info"),(Object)(3));
RDebugUtils.currentLine=6160392;
 //BA.debugLineNum = 6160392;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(mostCurrent.activityBA,(Object)(mostCurrent._starter.getObject()),"send_to_dev",(Object)(_data));
 } 
       catch (Exception e135) {
			processBA.setLastException(e135);RDebugUtils.currentLine=6160394;
 //BA.debugLineNum = 6160394;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=6160396;
 //BA.debugLineNum = 6160396;BA.debugLine="End Sub";
return "";
}
public static String  _set_key_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("set_key_set"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_key_set", new Object[] {_mapar});
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub set_key_set (mapar As Map)";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="Try";
try {RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="txt(mapar.Get (\"key_id\")).Text = mapar.Get (\"nam";
mostCurrent._txt[(int)(BA.ObjectToNumber(_mapar.Get((Object)("key_id"))))].setText(_mapar.Get((Object)("name")));
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="chk(mapar.Get (\"key_id\")).Checked = CM.obj2Bool(";
mostCurrent._chk[(int)(BA.ObjectToNumber(_mapar.Get((Object)("key_id"))))].setChecked(mostCurrent._cm._obj2bool(mostCurrent.activityBA,_mapar.Get((Object)("lock"))));
 } 
       catch (Exception e143) {
			processBA.setLastException(e143);RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=6225927;
 //BA.debugLineNum = 6225927;BA.debugLine="End Sub";
return "";
}
public static String  _set_keyinfo_set(anywheresoftware.b4a.objects.collections.Map _mapar) throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("set_keyinfo_set"))
	return (String) Debug.delegate(mostCurrent.activityBA, "set_keyinfo_set", new Object[] {_mapar});
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub set_keyinfo_set (mapar As Map)";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="Try";
try {RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="If mapar.ContainsKey(\"font_size\")=True Then  font";
if (_mapar.ContainsKey((Object)("font_size"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._font_size.setText(_mapar.Get((Object)("font_size")));};
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="If mapar.ContainsKey(\"h_size\")=True Then  h_size.";
if (_mapar.ContainsKey((Object)("h_size"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._h_size.setText(_mapar.Get((Object)("h_size")));};
RDebugUtils.currentLine=6291460;
 //BA.debugLineNum = 6291460;BA.debugLine="If mapar.ContainsKey(\"v_size\")=True Then  v_size.";
if (_mapar.ContainsKey((Object)("v_size"))==anywheresoftware.b4a.keywords.Common.True) { 
mostCurrent._v_size.setText(_mapar.Get((Object)("v_size")));};
 } 
       catch (Exception e152) {
			processBA.setLastException(e152);RDebugUtils.currentLine=6291462;
 //BA.debugLineNum = 6291462;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=6291464;
 //BA.debugLineNum = 6291464;BA.debugLine="End Sub";
return "";
}
public static String  _setbut_tmr_tick() throws Exception{
RDebugUtils.currentModule="key_set";
if (Debug.shouldDelegate("setbut_tmr_tick"))
	return (String) Debug.delegate(mostCurrent.activityBA, "setbut_tmr_tick", null);
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub setbut_tmr_Tick()";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Try";
try {RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="key_n=key_n+1";
_key_n = (int) (_key_n+1);
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="If key_n>=31 Then";
if (_key_n>=31) { 
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="set_key_info";
_set_key_info();
RDebugUtils.currentLine=6029317;
 //BA.debugLineNum = 6029317;BA.debugLine="setbut_tmr.Enabled =False";
mostCurrent._setbut_tmr.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=6029320;
 //BA.debugLineNum = 6029320;BA.debugLine="set_key(key_n)";
_set_key(_key_n);
 } 
       catch (Exception e110) {
			processBA.setLastException(e110);RDebugUtils.currentLine=6029322;
 //BA.debugLineNum = 6029322;BA.debugLine="proces_error(LastException.Message)";
_proces_error(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
RDebugUtils.currentLine=6029324;
 //BA.debugLineNum = 6029324;BA.debugLine="End Sub";
return "";
}
}