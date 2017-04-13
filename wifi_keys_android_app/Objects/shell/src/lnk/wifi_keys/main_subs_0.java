package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,36);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
int _i = 0;
RemoteObject _tbuts = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 37;BA.debugLine="Try";
Debug.ShouldStop(16);
try { BA.debugLineNum = 39;BA.debugLine="Activity.AddMenuItem(\"Keys set\",\"keys_set\")";
Debug.ShouldStop(64);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Keys set")),(Object)(RemoteObject.createImmutable("keys_set")));
 BA.debugLineNum = 40;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi AP set\",\"wf_ap_set";
Debug.ShouldStop(128);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Wi-Fi AP set")),(Object)(RemoteObject.createImmutable("wf_ap_set")));
 BA.debugLineNum = 41;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi client set\",\"wf_ST";
Debug.ShouldStop(256);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Wi-Fi client set")),(Object)(RemoteObject.createImmutable("wf_STA_set")));
 BA.debugLineNum = 42;BA.debugLine="Activity.AddMenuItem(\"Select device\",\"sel_dev\")";
Debug.ShouldStop(512);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Select device")),(Object)(RemoteObject.createImmutable("sel_dev")));
 BA.debugLineNum = 43;BA.debugLine="Activity.AddMenuItem(\"Inet set\",\"inet_setm\")";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Inet set")),(Object)(RemoteObject.createImmutable("inet_setm")));
 BA.debugLineNum = 44;BA.debugLine="Activity.AddMenuItem(\"Reset device\",\"reset_dev\")";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Reset device")),(Object)(RemoteObject.createImmutable("reset_dev")));
 BA.debugLineNum = 45;BA.debugLine="Activity.AddMenuItem(\"EXIT\",\"exit_prg\")";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("EXIT")),(Object)(RemoteObject.createImmutable("exit_prg")));
 BA.debugLineNum = 46;BA.debugLine="prs.Initialize(Colors.Gray,0dip)";
Debug.ShouldStop(8192);
main.mostCurrent._prs.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 47;BA.debugLine="ups.Initialize(Colors.DarkGray, 0dip)";
Debug.ShouldStop(16384);
main.mostCurrent._ups.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 48;BA.debugLine="grn.Initialize(Colors.RGB(0,150,0), 0dip)";
Debug.ShouldStop(32768);
main.mostCurrent._grn.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 49;BA.debugLine="sld_norm.Initialize";
Debug.ShouldStop(65536);
main.mostCurrent._sld_norm.runVoidMethod ("Initialize");
 BA.debugLineNum = 50;BA.debugLine="sld_norm.AddState(sld_norm.State_Pressed, ups)";
Debug.ShouldStop(131072);
main.mostCurrent._sld_norm.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_norm.getField(true,"State_Pressed")),(Object)((main.mostCurrent._ups.getObject())));
 BA.debugLineNum = 51;BA.debugLine="sld_norm.AddState(sld_norm.State_Enabled,ups)";
Debug.ShouldStop(262144);
main.mostCurrent._sld_norm.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_norm.getField(true,"State_Enabled")),(Object)((main.mostCurrent._ups.getObject())));
 BA.debugLineNum = 52;BA.debugLine="sld_norm.AddState(sld_on.State_Focused, ups)";
Debug.ShouldStop(524288);
main.mostCurrent._sld_norm.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Focused")),(Object)((main.mostCurrent._ups.getObject())));
 BA.debugLineNum = 53;BA.debugLine="sld_on.Initialize";
Debug.ShouldStop(1048576);
main.mostCurrent._sld_on.runVoidMethod ("Initialize");
 BA.debugLineNum = 54;BA.debugLine="sld_on.AddState(sld_on.State_Pressed, grn)";
Debug.ShouldStop(2097152);
main.mostCurrent._sld_on.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Pressed")),(Object)((main.mostCurrent._grn.getObject())));
 BA.debugLineNum = 55;BA.debugLine="sld_on.AddState(sld_on.State_Enabled, grn)";
Debug.ShouldStop(4194304);
main.mostCurrent._sld_on.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Enabled")),(Object)((main.mostCurrent._grn.getObject())));
 BA.debugLineNum = 56;BA.debugLine="sld_on.AddState(sld_on.State_Disabled, grn)";
Debug.ShouldStop(8388608);
main.mostCurrent._sld_on.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Disabled")),(Object)((main.mostCurrent._grn.getObject())));
 BA.debugLineNum = 57;BA.debugLine="sld_on.AddState(sld_on.State_Focused, grn)";
Debug.ShouldStop(16777216);
main.mostCurrent._sld_on.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Focused")),(Object)((main.mostCurrent._grn.getObject())));
 BA.debugLineNum = 58;BA.debugLine="sld_down.Initialize";
Debug.ShouldStop(33554432);
main.mostCurrent._sld_down.runVoidMethod ("Initialize");
 BA.debugLineNum = 59;BA.debugLine="sld_down.AddState(sld_on.State_Pressed, prs)";
Debug.ShouldStop(67108864);
main.mostCurrent._sld_down.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Pressed")),(Object)((main.mostCurrent._prs.getObject())));
 BA.debugLineNum = 60;BA.debugLine="sld_down.AddState(sld_on.State_Enabled, prs)";
Debug.ShouldStop(134217728);
main.mostCurrent._sld_down.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Enabled")),(Object)((main.mostCurrent._prs.getObject())));
 BA.debugLineNum = 61;BA.debugLine="sld_down.AddState(sld_on.State_Disabled,prs)";
Debug.ShouldStop(268435456);
main.mostCurrent._sld_down.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Disabled")),(Object)((main.mostCurrent._prs.getObject())));
 BA.debugLineNum = 62;BA.debugLine="sld_down.AddState(sld_on.State_Focused,prs)";
Debug.ShouldStop(536870912);
main.mostCurrent._sld_down.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Focused")),(Object)((main.mostCurrent._prs.getObject())));
 BA.debugLineNum = 63;BA.debugLine="status_lab.Initialize(\"status_lab\")";
Debug.ShouldStop(1073741824);
main.mostCurrent._status_lab.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("status_lab")));
 BA.debugLineNum = 64;BA.debugLine="status_lab.TextColor=Colors.Red";
Debug.ShouldStop(-2147483648);
main.mostCurrent._status_lab.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 65;BA.debugLine="status_lab.Text = \"No connected\"";
Debug.ShouldStop(1);
main.mostCurrent._status_lab.runMethod(true,"setText",RemoteObject.createImmutable(("No connected")));
 BA.debugLineNum = 66;BA.debugLine="Activity.AddView(status_lab, 0dip, Activity.He";
Debug.ShouldStop(2);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._status_lab.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 67;BA.debugLine="mqtt_but.Initialize (\"mqtt_but\")";
Debug.ShouldStop(4);
main.mostCurrent._mqtt_but.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("mqtt_but")));
 BA.debugLineNum = 68;BA.debugLine="mqtt_but.Text =\"MQTT\"";
Debug.ShouldStop(8);
main.mostCurrent._mqtt_but.runMethod(true,"setText",RemoteObject.createImmutable(("MQTT")));
 BA.debugLineNum = 69;BA.debugLine="mqtt_but.TextSize=12";
Debug.ShouldStop(16);
main.mostCurrent._mqtt_but.runMethod(true,"setTextSize",BA.numberCast(float.class, 12));
 BA.debugLineNum = 70;BA.debugLine="Activity.AddView(mqtt_but,Activity.Width-50dip, A";
Debug.ShouldStop(32);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._mqtt_but.getObject())),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))}, "-",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 50)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 71;BA.debugLine="If CM.connect_type=True Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",main.mostCurrent._cm._connect_type,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 72;BA.debugLine="mqtt_but.textColor=Colors.Green";
Debug.ShouldStop(128);
main.mostCurrent._mqtt_but.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 }else {
 BA.debugLineNum = 74;BA.debugLine="mqtt_but.textColor=Colors.Gray";
Debug.ShouldStop(512);
main.mostCurrent._mqtt_but.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 };
 BA.debugLineNum = 76;BA.debugLine="wifi.Initialize(\"wifi\")";
Debug.ShouldStop(2048);
main.mostCurrent._wifi.runVoidMethod ("Initialize",main.processBA,(Object)(RemoteObject.createImmutable("wifi")));
 BA.debugLineNum = 77;BA.debugLine="For i = 1 To 32";
Debug.ShouldStop(4096);
{
final int step40 = 1;
final int limit40 = 32;
for (_i = 1 ; (step40 > 0 && _i <= limit40) || (step40 < 0 && _i >= limit40); _i = ((int)(0 + _i + step40)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 78;BA.debugLine="Dim tbuts As Button";
Debug.ShouldStop(8192);
_tbuts = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("tbuts", _tbuts);
 BA.debugLineNum = 79;BA.debugLine="tbuts.Initialize(\"tbuts\")";
Debug.ShouldStop(16384);
_tbuts.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tbuts")));
 BA.debugLineNum = 80;BA.debugLine="Activity.AddView(tbuts, -2000dip, 0, 20dip";
Debug.ShouldStop(32768);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((_tbuts.getObject())),(Object)(BA.numberCast(int.class, -(double) (0 + main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2000))).<Integer>get().intValue()))),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 81;BA.debugLine="tbuts.Background=sld_norm";
Debug.ShouldStop(65536);
_tbuts.runMethod(false,"setBackground",(main.mostCurrent._sld_norm.getObject()));
 BA.debugLineNum = 82;BA.debugLine="butt(i)=tbuts";
Debug.ShouldStop(131072);
main.mostCurrent._butt.setArrayElement (_tbuts,BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 84;BA.debugLine="add_key_to_panel";
Debug.ShouldStop(524288);
_add_key_to_panel();
 BA.debugLineNum = 85;BA.debugLine="menu_pass_txt.Initialize(\"menu_pass_txt\")";
Debug.ShouldStop(1048576);
main.mostCurrent._menu_pass_txt.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("menu_pass_txt")));
 BA.debugLineNum = 86;BA.debugLine="menu_pass_txt.Visible =False";
Debug.ShouldStop(2097152);
main.mostCurrent._menu_pass_txt.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 87;BA.debugLine="menu_pass_txt.TextSize=6";
Debug.ShouldStop(4194304);
main.mostCurrent._menu_pass_txt.runMethod(true,"setTextSize",BA.numberCast(float.class, 6));
 BA.debugLineNum = 88;BA.debugLine="menu_pass_txt.PasswordMode=True";
Debug.ShouldStop(8388608);
main.mostCurrent._menu_pass_txt.runVoidMethod ("setPasswordMode",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 89;BA.debugLine="Activity.AddView(menu_pass_txt,Activity.Width/2.5";
Debug.ShouldStop(16777216);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._menu_pass_txt.getObject())),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),RemoteObject.createImmutable(2.5)}, "/",0, 0))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))}, "-",1, 1)),(Object)(BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),RemoteObject.createImmutable(5)}, "/",0, 0))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 30)))));
 BA.debugLineNum = 90;BA.debugLine="send_state_timer.Initialize(\"send_state_timer\",";
Debug.ShouldStop(33554432);
main._send_state_timer.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("send_state_timer")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 91;BA.debugLine="send_state_timer.Enabled =True";
Debug.ShouldStop(67108864);
main._send_state_timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e77) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e77.toString()); BA.debugLineNum = 95;BA.debugLine="proces_error(LastException.Message & \"activ. cre";
Debug.ShouldStop(1073741824);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("activ. creat")));
 };
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,108);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 108;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="Try";
Debug.ShouldStop(4096);
try { BA.debugLineNum = 110;BA.debugLine="wifi.StopWifi";
Debug.ShouldStop(8192);
main.mostCurrent._wifi.runVoidMethod ("StopWifi");
 BA.debugLineNum = 111;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(16384);
main.mostCurrent._statemanager.runVoidMethod ("_savesettings",main.mostCurrent.activityBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e92) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e92.toString()); BA.debugLineNum = 113;BA.debugLine="proces_error(LastException.Message & \"active.pau";
Debug.ShouldStop(65536);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("active.pause")));
 };
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,99);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 99;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 101;BA.debugLine="add_key_to_panel";
Debug.ShouldStop(16);
_add_key_to_panel();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e84) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e84.toString()); BA.debugLineNum = 104;BA.debugLine="proces_error(LastException.Message & \"active. re";
Debug.ShouldStop(128);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("active. resume")));
 };
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _add_key_to_panel() throws Exception{
try {
		Debug.PushSubsStack("add_key_to_panel (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,218);
if (RapidSub.canDelegate("add_key_to_panel")) return main.remoteMe.runUserSub(false, "main","add_key_to_panel");
RemoteObject _vert_size = RemoteObject.createImmutable(0);
RemoteObject _horiz_size = RemoteObject.createImmutable(0);
RemoteObject _font_size = RemoteObject.createImmutable(0);
RemoteObject _b_width = RemoteObject.createImmutable(0);
RemoteObject _b_height = RemoteObject.createImmutable(0);
RemoteObject _posx = RemoteObject.createImmutable(0);
RemoteObject _posy = RemoteObject.createImmutable(0);
RemoteObject _max_but = RemoteObject.createImmutable(0);
int _a = 0;
 BA.debugLineNum = 218;BA.debugLine="Sub add_key_to_panel() 'розміщення кнопок керуванн";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="Try";
Debug.ShouldStop(67108864);
try { BA.debugLineNum = 220;BA.debugLine="Activity.Title =\"Wi-Fi keys - \" & StateManager.Ge";
Debug.ShouldStop(134217728);
main.mostCurrent._activity.runMethod(false,"setTitle",(RemoteObject.concat(RemoteObject.createImmutable("Wi-Fi keys - "),main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 222;BA.debugLine="clear_keys";
Debug.ShouldStop(536870912);
_clear_keys();
 BA.debugLineNum = 223;BA.debugLine="Dim vert_size As Int=CM.toint(StateManager.GetSet";
Debug.ShouldStop(1073741824);
_vert_size = main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("v_size")),(Object)(RemoteObject.createImmutable("")))));Debug.locals.put("vert_size", _vert_size);Debug.locals.put("vert_size", _vert_size);
 BA.debugLineNum = 224;BA.debugLine="Dim horiz_size As Int=CM.toint(StateManager.GetSe";
Debug.ShouldStop(-2147483648);
_horiz_size = main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("h_size")),(Object)(RemoteObject.createImmutable("")))));Debug.locals.put("horiz_size", _horiz_size);Debug.locals.put("horiz_size", _horiz_size);
 BA.debugLineNum = 225;BA.debugLine="Dim font_size As Int=CM.toint(StateManager.GetSet";
Debug.ShouldStop(1);
_font_size = main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("font_size")),(Object)(RemoteObject.createImmutable("")))));Debug.locals.put("font_size", _font_size);Debug.locals.put("font_size", _font_size);
 BA.debugLineNum = 226;BA.debugLine="If vert_size <1 Then Return";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("<",_vert_size,BA.numberCast(double.class, 1))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 227;BA.debugLine="Dim b_width,b_height,posx,posy,max_but As Int";
Debug.ShouldStop(4);
_b_width = RemoteObject.createImmutable(0);Debug.locals.put("b_width", _b_width);
_b_height = RemoteObject.createImmutable(0);Debug.locals.put("b_height", _b_height);
_posx = RemoteObject.createImmutable(0);Debug.locals.put("posx", _posx);
_posy = RemoteObject.createImmutable(0);Debug.locals.put("posy", _posy);
_max_but = RemoteObject.createImmutable(0);Debug.locals.put("max_but", _max_but);
 BA.debugLineNum = 228;BA.debugLine="b_width=Activity.Width/horiz_size";
Debug.ShouldStop(8);
_b_width = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),_horiz_size}, "/",0, 0));Debug.locals.put("b_width", _b_width);
 BA.debugLineNum = 229;BA.debugLine="b_height=(Activity.height-20dip)/vert_size";
Debug.ShouldStop(16);
_b_height = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),_vert_size}, "/",0, 0));Debug.locals.put("b_height", _b_height);
 BA.debugLineNum = 230;BA.debugLine="max_but =horiz_size*vert_size";
Debug.ShouldStop(32);
_max_but = RemoteObject.solve(new RemoteObject[] {_horiz_size,_vert_size}, "*",0, 1);Debug.locals.put("max_but", _max_but);
 BA.debugLineNum = 231;BA.debugLine="cur_but_state=0";
Debug.ShouldStop(64);
main._cur_but_state = BA.numberCast(int.class, 0);
 BA.debugLineNum = 232;BA.debugLine="For a=1 To 32";
Debug.ShouldStop(128);
{
final int step13 = 1;
final int limit13 = 32;
for (_a = 1 ; (step13 > 0 && _a <= limit13) || (step13 < 0 && _a >= limit13); _a = ((int)(0 + _a + step13)) ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 233;BA.debugLine="butt(a).Background=sld_norm";
Debug.ShouldStop(256);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(false,"setBackground",(main.mostCurrent._sld_norm.getObject()));
 BA.debugLineNum = 234;BA.debugLine="If CM.toint(StateManager.GetSetting2(\"keytag\" &";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(">",main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),RemoteObject.createImmutable(_a))),(Object)(RemoteObject.createImmutable(""))))),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 235;BA.debugLine="If cur_but_state>=max_but Then Return";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("g",main._cur_but_state,BA.numberCast(double.class, _max_but))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 236;BA.debugLine="posy=cur_but_state/horiz_size";
Debug.ShouldStop(2048);
_posy = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._cur_but_state,_horiz_size}, "/",0, 0));Debug.locals.put("posy", _posy);
 BA.debugLineNum = 237;BA.debugLine="posx=cur_but_state mod horiz_size";
Debug.ShouldStop(4096);
_posx = RemoteObject.solve(new RemoteObject[] {main._cur_but_state,_horiz_size}, "%",0, 1);Debug.locals.put("posx", _posx);
 BA.debugLineNum = 238;BA.debugLine="butlock(a)=CM.obj2Bool(StateManager.GetSetting2";
Debug.ShouldStop(8192);
main._butlock.setArrayElement (main.mostCurrent._cm.runMethod(true,"_obj2bool",main.mostCurrent.activityBA,(Object)((main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keylock"),RemoteObject.createImmutable(_a))),(Object)(BA.NumberToString(0)))))),BA.numberCast(int.class, _a));
 BA.debugLineNum = 239;BA.debugLine="butt(a).Text =StateManager.GetSetting2(\"keytext";
Debug.ShouldStop(16384);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setText",(main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytext"),RemoteObject.createImmutable(_a))),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 240;BA.debugLine="butt(a).tag =StateManager.GetSetting2(\"keytag\"";
Debug.ShouldStop(32768);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(false,"setTag",(main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),RemoteObject.createImmutable(_a))),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 241;BA.debugLine="butt(a).Left =posx*(b_width+1dip)";
Debug.ShouldStop(65536);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_posx,(RemoteObject.solve(new RemoteObject[] {_b_width,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 1))}, "*",0, 1));
 BA.debugLineNum = 242;BA.debugLine="butt(a).top =posy*(b_height+1dip)";
Debug.ShouldStop(131072);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_posy,(RemoteObject.solve(new RemoteObject[] {_b_height,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 1))}, "*",0, 1));
 BA.debugLineNum = 243;BA.debugLine="butt(a).width =b_width-2dip";
Debug.ShouldStop(262144);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {_b_width,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1));
 BA.debugLineNum = 244;BA.debugLine="butt(a).height =b_height-2dip";
Debug.ShouldStop(524288);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_b_height,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1));
 BA.debugLineNum = 245;BA.debugLine="butt(a).TextSize =font_size";
Debug.ShouldStop(1048576);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setTextSize",BA.numberCast(float.class, _font_size));
 BA.debugLineNum = 246;BA.debugLine="If butlock(a)=True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main._butlock.getArrayElement(true,BA.numberCast(int.class, _a)),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 247;BA.debugLine="butt(a).TextColor =Colors.RGB(128,255,255)";
Debug.ShouldStop(4194304);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 128)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 }else {
 BA.debugLineNum = 249;BA.debugLine="butt(a).TextColor =Colors.RGB(255,255,255)";
Debug.ShouldStop(16777216);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255))));
 };
 BA.debugLineNum = 251;BA.debugLine="cur_but_state=cur_but_state+1";
Debug.ShouldStop(67108864);
main._cur_but_state = RemoteObject.solve(new RemoteObject[] {main._cur_but_state,RemoteObject.createImmutable(1)}, "+",1, 1);
 };
 }
}Debug.locals.put("a", _a);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e215) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e215.toString()); BA.debugLineNum = 255;BA.debugLine="proces_error(LastException.Message & \"add_key_to";
Debug.ShouldStop(1073741824);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("add_key_to_panel")));
 };
 BA.debugLineNum = 257;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _clear_keys() throws Exception{
try {
		Debug.PushSubsStack("clear_keys (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,118);
if (RapidSub.canDelegate("clear_keys")) return main.remoteMe.runUserSub(false, "main","clear_keys");
int _i = 0;
 BA.debugLineNum = 118;BA.debugLine="Sub clear_keys";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 119;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 120;BA.debugLine="For i = 1 To 32";
Debug.ShouldStop(8388608);
{
final int step2 = 1;
final int limit2 = 32;
for (_i = 1 ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 121;BA.debugLine="butt(i).Left =-2000";
Debug.ShouldStop(16777216);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setLeft",BA.numberCast(int.class, -(double) (0 + 2000)));
 BA.debugLineNum = 122;BA.debugLine="butt(i).Tag =\"\"";
Debug.ShouldStop(33554432);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 }
}Debug.locals.put("i", _i);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e102) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e102.toString()); BA.debugLineNum = 126;BA.debugLine="proces_error(LastException.Message & \"clear.keys";
Debug.ShouldStop(536870912);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("clear.keys")));
 };
 BA.debugLineNum = 128;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _exit_prg_click() throws Exception{
try {
		Debug.PushSubsStack("exit_prg_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,341);
if (RapidSub.canDelegate("exit_prg_click")) return main.remoteMe.runUserSub(false, "main","exit_prg_click");
 BA.debugLineNum = 341;BA.debugLine="Sub exit_prg_click()";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 342;BA.debugLine="ExitApplication";
Debug.ShouldStop(2097152);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 BA.debugLineNum = 343;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _get_rssi() throws Exception{
try {
		Debug.PushSubsStack("get_rssi (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,176);
if (RapidSub.canDelegate("get_rssi")) return main.remoteMe.runUserSub(false, "main","get_rssi");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 176;BA.debugLine="Sub get_rssi() 'Відправка запиту на отримання рів";
Debug.ShouldStop(32768);
 BA.debugLineNum = 177;BA.debugLine="Try";
Debug.ShouldStop(65536);
try { BA.debugLineNum = 178;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(131072);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 179;BA.debugLine="Data.Initialize";
Debug.ShouldStop(262144);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 180;BA.debugLine="Data.Put (\"rssi\",1)";
Debug.ShouldStop(524288);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("rssi"))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 181;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(1048576);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",main.mostCurrent.activityBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e148) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e148.toString()); BA.debugLineNum = 183;BA.debugLine="proces_error(LastException.Message & \"get_rssi\")";
Debug.ShouldStop(4194304);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("get_rssi")));
 };
 BA.debugLineNum = 185;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim antidouble As Boolean";
main._antidouble = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 19;BA.debugLine="Dim wifi As ABWifi";
main.mostCurrent._wifi = RemoteObject.createNew ("com.AB.ABWifi.ABWifi");
 //BA.debugLineNum = 20;BA.debugLine="Dim wifisignal As Int";
main._wifisignal = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 21;BA.debugLine="Dim butt(35) As Button";
main.mostCurrent._butt = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.ButtonWrapper", new int[] {35}, new Object[]{});
 //BA.debugLineNum = 22;BA.debugLine="Dim mqtt_but As Label";
main.mostCurrent._mqtt_but = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Dim status_lab As Label";
main.mostCurrent._status_lab = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Dim butlock(35) As Boolean";
main._butlock = RemoteObject.createNewArray ("boolean", new int[] {35}, new Object[]{});
 //BA.debugLineNum = 25;BA.debugLine="Dim butstate(35) As Boolean";
main._butstate = RemoteObject.createNewArray ("boolean", new int[] {35}, new Object[]{});
 //BA.debugLineNum = 26;BA.debugLine="Dim sld_norm,sld_on,sld_down As StateListDrawable";
main.mostCurrent._sld_norm = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.StateListDrawable");
main.mostCurrent._sld_on = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.StateListDrawable");
main.mostCurrent._sld_down = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.StateListDrawable");
 //BA.debugLineNum = 27;BA.debugLine="Dim prs, ups,grn As ColorDrawable";
main.mostCurrent._prs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");
main.mostCurrent._ups = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");
main.mostCurrent._grn = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");
 //BA.debugLineNum = 28;BA.debugLine="Dim menu_pass_txt As EditText";
main.mostCurrent._menu_pass_txt = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Dim cur_but_state As Int";
main._cur_but_state = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 30;BA.debugLine="Dim prs_but As Int";
main._prs_but = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 31;BA.debugLine="Dim enter_menu_pass As String";
main.mostCurrent._enter_menu_pass = RemoteObject.createImmutable("");
 //BA.debugLineNum = 32;BA.debugLine="Dim allow_menu As Boolean";
main._allow_menu = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _inet_setm_click() throws Exception{
try {
		Debug.PushSubsStack("inet_setm_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,337);
if (RapidSub.canDelegate("inet_setm_click")) return main.remoteMe.runUserSub(false, "main","inet_setm_click");
 BA.debugLineNum = 337;BA.debugLine="Sub inet_setm_Click()";
Debug.ShouldStop(65536);
 BA.debugLineNum = 338;BA.debugLine="If  valid_menu_pass=False Then Return";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",_valid_menu_pass(),main.mostCurrent.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 339;BA.debugLine="StartActivity(INET_SET)";
Debug.ShouldStop(262144);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._inet_set.getObject())));
 BA.debugLineNum = 340;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _keys_set_click() throws Exception{
try {
		Debug.PushSubsStack("keys_set_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,333);
if (RapidSub.canDelegate("keys_set_click")) return main.remoteMe.runUserSub(false, "main","keys_set_click");
 BA.debugLineNum = 333;BA.debugLine="Sub keys_set_Click()";
Debug.ShouldStop(4096);
 BA.debugLineNum = 334;BA.debugLine="If  valid_menu_pass=False Then Return";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",_valid_menu_pass(),main.mostCurrent.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 335;BA.debugLine="StartActivity(KEY_SET)";
Debug.ShouldStop(16384);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._key_set.getObject())));
 BA.debugLineNum = 336;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _menu_pass_txt_enterpressed() throws Exception{
try {
		Debug.PushSubsStack("menu_pass_txt_EnterPressed (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,379);
if (RapidSub.canDelegate("menu_pass_txt_enterpressed")) return main.remoteMe.runUserSub(false, "main","menu_pass_txt_enterpressed");
RemoteObject _ppas = RemoteObject.createImmutable("");
RemoteObject _ptxt = RemoteObject.createImmutable("");
 BA.debugLineNum = 379;BA.debugLine="Sub menu_pass_txt_EnterPressed";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 380;BA.debugLine="Dim ppas As String =StateManager.getSetting2(\"men";
Debug.ShouldStop(134217728);
_ppas = main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("menu_pass")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("ppas", _ppas);Debug.locals.put("ppas", _ppas);
 BA.debugLineNum = 381;BA.debugLine="Dim ptxt As String =menu_pass_txt.Text";
Debug.ShouldStop(268435456);
_ptxt = main.mostCurrent._menu_pass_txt.runMethod(true,"getText");Debug.locals.put("ptxt", _ptxt);Debug.locals.put("ptxt", _ptxt);
 BA.debugLineNum = 382;BA.debugLine="If ppas.EqualsIgnoreCase(ptxt)=True Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_ppas.runMethod(true,"equalsIgnoreCase",(Object)(_ptxt)),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 383;BA.debugLine="ToastMessageShow(\"Corect\",False)";
Debug.ShouldStop(1073741824);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Corect")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 384;BA.debugLine="allow_menu=True";
Debug.ShouldStop(-2147483648);
main._allow_menu = main.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 386;BA.debugLine="ToastMessageShow(\"Invalid pass\",False)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Invalid pass")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 387;BA.debugLine="allow_menu=False";
Debug.ShouldStop(4);
main._allow_menu = main.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 389;BA.debugLine="menu_pass_txt.Visible =False";
Debug.ShouldStop(16);
main.mostCurrent._menu_pass_txt.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 390;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _menu_pass_txt_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("menu_pass_txt_TextChanged (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,393);
if (RapidSub.canDelegate("menu_pass_txt_textchanged")) return main.remoteMe.runUserSub(false, "main","menu_pass_txt_textchanged", _old, _new);
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 393;BA.debugLine="Sub menu_pass_txt_TextChanged(Old As String, New A";
Debug.ShouldStop(256);
 BA.debugLineNum = 394;BA.debugLine="enter_menu_pass=New";
Debug.ShouldStop(512);
main.mostCurrent._enter_menu_pass = _new;
 BA.debugLineNum = 395;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mqtt_but_longclick() throws Exception{
try {
		Debug.PushSubsStack("mqtt_but_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,366);
if (RapidSub.canDelegate("mqtt_but_longclick")) return main.remoteMe.runUserSub(false, "main","mqtt_but_longclick");
 BA.debugLineNum = 366;BA.debugLine="Sub mqtt_but_LongClick";
Debug.ShouldStop(8192);
 BA.debugLineNum = 367;BA.debugLine="If CM.connect_type=True Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",main.mostCurrent._cm._connect_type,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 368;BA.debugLine="CallSubDelayed(Starter,\"mqtt_disconnect\")";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.mostCurrent.activityBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("mqtt_disconnect")));
 }else {
 BA.debugLineNum = 370;BA.debugLine="CallSubDelayed(Starter,\"mqtt_connect\")";
Debug.ShouldStop(131072);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed",main.mostCurrent.activityBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(RemoteObject.createImmutable("mqtt_connect")));
 };
 BA.debugLineNum = 374;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _proces_error(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("proces_error (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,375);
if (RapidSub.canDelegate("proces_error")) return main.remoteMe.runUserSub(false, "main","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 375;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 376;BA.debugLine="Msgbox(msg,\"error\")";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(_msg),(Object)(RemoteObject.createImmutable("error")),main.mostCurrent.activityBA);
 BA.debugLineNum = 377;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
statemanager_subs_0._process_globals();
sel_dev_subs_0._process_globals();
ap_set_subs_0._process_globals();
key_set_subs_0._process_globals();
cm_subs_0._process_globals();
inet_set_subs_0._process_globals();
sta_set_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("lnk.wifi_keys.main");
starter.myClass = BA.getDeviceClass ("lnk.wifi_keys.starter");
statemanager.myClass = BA.getDeviceClass ("lnk.wifi_keys.statemanager");
sel_dev.myClass = BA.getDeviceClass ("lnk.wifi_keys.sel_dev");
ap_set.myClass = BA.getDeviceClass ("lnk.wifi_keys.ap_set");
key_set.myClass = BA.getDeviceClass ("lnk.wifi_keys.key_set");
cm.myClass = BA.getDeviceClass ("lnk.wifi_keys.cm");
inet_set.myClass = BA.getDeviceClass ("lnk.wifi_keys.inet_set");
sta_set.myClass = BA.getDeviceClass ("lnk.wifi_keys.sta_set");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 13;BA.debugLine="Dim conect_tmout As Int";
main._conect_tmout = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 14;BA.debugLine="Public  send_state_timer As Timer";
main._send_state_timer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _reset_dev_click() throws Exception{
try {
		Debug.PushSubsStack("reset_dev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,344);
if (RapidSub.canDelegate("reset_dev_click")) return main.remoteMe.runUserSub(false, "main","reset_dev_click");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 344;BA.debugLine="Sub reset_dev_Click()";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 345;BA.debugLine="Try";
Debug.ShouldStop(16777216);
try { BA.debugLineNum = 346;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(33554432);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 347;BA.debugLine="Data.Initialize";
Debug.ShouldStop(67108864);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 348;BA.debugLine="Data.Put (\"rst\",1)";
Debug.ShouldStop(134217728);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("rst"))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 349;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(268435456);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",main.mostCurrent.activityBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e300) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e300.toString()); BA.debugLineNum = 351;BA.debugLine="proces_error(LastException.Message & \"reset_dev\"";
Debug.ShouldStop(1073741824);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("reset_dev")));
 };
 BA.debugLineNum = 355;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _sel_dev_click() throws Exception{
try {
		Debug.PushSubsStack("sel_dev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,321);
if (RapidSub.canDelegate("sel_dev_click")) return main.remoteMe.runUserSub(false, "main","sel_dev_click");
 BA.debugLineNum = 321;BA.debugLine="Sub sel_dev_Click()";
Debug.ShouldStop(1);
 BA.debugLineNum = 322;BA.debugLine="If  valid_menu_pass=False Then Return";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_valid_menu_pass(),main.mostCurrent.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 323;BA.debugLine="StartActivity(sel_dev)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._sel_dev.getObject())));
 BA.debugLineNum = 324;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _send_comm(RemoteObject _ind,RemoteObject _com,RemoteObject _lock) throws Exception{
try {
		Debug.PushSubsStack("send_comm (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,135);
if (RapidSub.canDelegate("send_comm")) return main.remoteMe.runUserSub(false, "main","send_comm", _ind, _com, _lock);
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("ind", _ind);
Debug.locals.put("com", _com);
Debug.locals.put("lock", _lock);
 BA.debugLineNum = 135;BA.debugLine="Sub send_comm(ind As Int,com As Boolean,lock As Bo";
Debug.ShouldStop(64);
 BA.debugLineNum = 136;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 137;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(256);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 138;BA.debugLine="Data.Initialize";
Debug.ShouldStop(512);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 139;BA.debugLine="Data.Put (\"ncom\",ind)";
Debug.ShouldStop(1024);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("ncom"))),(Object)((_ind)));
 BA.debugLineNum = 140;BA.debugLine="Data.Put (\"com\",com)";
Debug.ShouldStop(2048);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("com"))),(Object)((_com)));
 BA.debugLineNum = 141;BA.debugLine="Data.Put (\"lock\",lock)";
Debug.ShouldStop(4096);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("lock"))),(Object)((_lock)));
 BA.debugLineNum = 142;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(8192);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",main.mostCurrent.activityBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e114) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e114.toString()); BA.debugLineNum = 144;BA.debugLine="proces_error(LastException.Message & \"send_comm\"";
Debug.ShouldStop(32768);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("send_comm")));
 };
 BA.debugLineNum = 146;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _send_state_timer_tick() throws Exception{
try {
		Debug.PushSubsStack("send_state_timer_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,150);
if (RapidSub.canDelegate("send_state_timer_tick")) return main.remoteMe.runUserSub(false, "main","send_state_timer_tick");
 BA.debugLineNum = 150;BA.debugLine="Sub send_state_timer_Tick() ' таймер перевірки звя";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 151;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 152;BA.debugLine="If prs_but>0 Then send_comm(prs_but,True,False)";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean(">",main._prs_but,BA.numberCast(double.class, 0))) { 
_send_comm(main._prs_but,main.mostCurrent.__c.getField(true,"True"),main.mostCurrent.__c.getField(true,"False"));};
 BA.debugLineNum = 153;BA.debugLine="get_rssi";
Debug.ShouldStop(16777216);
_get_rssi();
 BA.debugLineNum = 154;BA.debugLine="If conect_tmout>0 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean(">",main._conect_tmout,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 155;BA.debugLine="conect_tmout=conect_tmout-1";
Debug.ShouldStop(67108864);
main._conect_tmout = RemoteObject.solve(new RemoteObject[] {main._conect_tmout,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 156;BA.debugLine="If conect_tmout=0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",main._conect_tmout,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 157;BA.debugLine="status_lab.TextColor=Colors.Red";
Debug.ShouldStop(268435456);
main.mostCurrent._status_lab.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 158;BA.debugLine="status_lab.Text = \"No connected\"";
Debug.ShouldStop(536870912);
main.mostCurrent._status_lab.runMethod(true,"setText",RemoteObject.createImmutable(("No connected")));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e129) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e129.toString()); BA.debugLineNum = 162;BA.debugLine="proces_error(LastException.Message & \"send_state";
Debug.ShouldStop(2);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("send_state_timer_tick")));
 };
 BA.debugLineNum = 164;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_mqtt_state(RemoteObject _state) throws Exception{
try {
		Debug.PushSubsStack("set_mqtt_state (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,263);
if (RapidSub.canDelegate("set_mqtt_state")) return main.remoteMe.runUserSub(false, "main","set_mqtt_state", _state);
Debug.locals.put("state", _state);
 BA.debugLineNum = 263;BA.debugLine="Sub set_mqtt_state(state As Boolean)";
Debug.ShouldStop(64);
 BA.debugLineNum = 264;BA.debugLine="CM.connect_type=state";
Debug.ShouldStop(128);
main.mostCurrent._cm._connect_type = _state;
 BA.debugLineNum = 265;BA.debugLine="If state=True Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",_state,main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 266;BA.debugLine="mqtt_but.textColor=Colors.Green";
Debug.ShouldStop(512);
main.mostCurrent._mqtt_but.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 }else {
 BA.debugLineNum = 268;BA.debugLine="mqtt_but.textColor=Colors.Gray";
Debug.ShouldStop(2048);
main.mostCurrent._mqtt_but.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray"));
 };
 BA.debugLineNum = 270;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _set_ris(RemoteObject _rstate) throws Exception{
try {
		Debug.PushSubsStack("set_ris (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,187);
if (RapidSub.canDelegate("set_ris")) return main.remoteMe.runUserSub(false, "main","set_ris", _rstate);
RemoteObject _tmplong = RemoteObject.createImmutable(0L);
int _a = 0;
RemoteObject _btd = RemoteObject.createImmutable(0);
Debug.locals.put("rstate", _rstate);
 BA.debugLineNum = 187;BA.debugLine="Sub set_ris(rstate As Map)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 188;BA.debugLine="Try";
Debug.ShouldStop(134217728);
try { BA.debugLineNum = 189;BA.debugLine="Dim tmplong As Long";
Debug.ShouldStop(268435456);
_tmplong = RemoteObject.createImmutable(0L);Debug.locals.put("tmplong", _tmplong);
 BA.debugLineNum = 190;BA.debugLine="tmplong =CM.tolong(rstate.Get(\"st\"))";
Debug.ShouldStop(536870912);
_tmplong = BA.numberCast(long.class, main.mostCurrent._cm.runMethod(true,"_tolong",main.mostCurrent.activityBA,(Object)(BA.ObjectToString(_rstate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("st"))))))));Debug.locals.put("tmplong", _tmplong);
 BA.debugLineNum = 191;BA.debugLine="For a=1 To 30";
Debug.ShouldStop(1073741824);
{
final int step4 = 1;
final int limit4 = 30;
for (_a = 1 ; (step4 > 0 && _a <= limit4) || (step4 < 0 && _a >= limit4); _a = ((int)(0 + _a + step4)) ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 192;BA.debugLine="butstate(a)=CM.obj2Bool(Bit.And(tmplong , 1))";
Debug.ShouldStop(-2147483648);
main._butstate.setArrayElement (main.mostCurrent._cm.runMethod(true,"_obj2bool",main.mostCurrent.activityBA,(Object)((main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(BA.numberCast(int.class, _tmplong)),(Object)(BA.numberCast(int.class, 1)))))),BA.numberCast(int.class, _a));
 BA.debugLineNum = 193;BA.debugLine="tmplong=Bit.ShiftRight(tmplong,1)";
Debug.ShouldStop(1);
_tmplong = BA.numberCast(long.class, main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"ShiftRight",(Object)(BA.numberCast(int.class, _tmplong)),(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("tmplong", _tmplong);
 BA.debugLineNum = 194;BA.debugLine="If butstate(a)=True Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",main._butstate.getArrayElement(true,BA.numberCast(int.class, _a)),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 195;BA.debugLine="butt(a).Background =sld_on";
Debug.ShouldStop(4);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(false,"setBackground",(main.mostCurrent._sld_on.getObject()));
 }else {
 BA.debugLineNum = 197;BA.debugLine="butt(a).Background =sld_norm";
Debug.ShouldStop(16);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(false,"setBackground",(main.mostCurrent._sld_norm.getObject()));
 };
 }
}Debug.locals.put("a", _a);
;
 BA.debugLineNum = 200;BA.debugLine="Dim btd As Double =rstate.Get(\"analog\")/(StateMan";
Debug.ShouldStop(128);
_btd = RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, _rstate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("analog"))))),(RemoteObject.solve(new RemoteObject[] {BA.numberCast(double.class, main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("batt_dev")),(Object)(BA.NumberToString(20000)))),RemoteObject.createImmutable(100)}, "/",0, 0))}, "/",0, 0);Debug.locals.put("btd", _btd);Debug.locals.put("btd", _btd);
 BA.debugLineNum = 201;BA.debugLine="btd=CM.toint (btd*100)/100";
Debug.ShouldStop(256);
_btd = RemoteObject.solve(new RemoteObject[] {main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(BA.NumberToString(RemoteObject.solve(new RemoteObject[] {_btd,RemoteObject.createImmutable(100)}, "*",0, 0)))),RemoteObject.createImmutable(100)}, "/",0, 0);Debug.locals.put("btd", _btd);
 BA.debugLineNum = 202;BA.debugLine="status_lab.TextColor=Colors.Green";
Debug.ShouldStop(512);
main.mostCurrent._status_lab.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 203;BA.debugLine="If CM.toint (rstate.Get(\"rssi\"))<0 Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("<",main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(BA.ObjectToString(_rstate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("rssi"))))))),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 204;BA.debugLine="status_lab.Text = btd & \"V RSSI: \" & rstate.Get";
Debug.ShouldStop(2048);
main.mostCurrent._status_lab.runMethod(true,"setText",(RemoteObject.concat(_btd,RemoteObject.createImmutable("V RSSI: "),_rstate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("rssi")))),RemoteObject.createImmutable("dbm   Connected"))));
 }else {
 BA.debugLineNum = 206;BA.debugLine="wifi.StartWifi";
Debug.ShouldStop(8192);
main.mostCurrent._wifi.runVoidMethod ("StartWifi");
 BA.debugLineNum = 207;BA.debugLine="wifi.GetNewReadingWifi";
Debug.ShouldStop(16384);
main.mostCurrent._wifi.runVoidMethod ("GetNewReadingWifi");
 BA.debugLineNum = 208;BA.debugLine="status_lab.Text = btd & \"V myRSSI: \" & wifisig";
Debug.ShouldStop(32768);
main.mostCurrent._status_lab.runMethod(true,"setText",(RemoteObject.concat(_btd,RemoteObject.createImmutable("V myRSSI: "),main._wifisignal,RemoteObject.createImmutable("dbm   Connected"))));
 };
 BA.debugLineNum = 210;BA.debugLine="conect_tmout=3";
Debug.ShouldStop(131072);
main._conect_tmout = BA.numberCast(int.class, 3);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e176) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e176.toString()); BA.debugLineNum = 213;BA.debugLine="proces_error(LastException.Message & \"set_ris\")";
Debug.ShouldStop(1048576);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("set_ris")));
 };
 BA.debugLineNum = 215;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _status_lab_longclick() throws Exception{
try {
		Debug.PushSubsStack("status_lab_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,363);
if (RapidSub.canDelegate("status_lab_longclick")) return main.remoteMe.runUserSub(false, "main","status_lab_longclick");
 BA.debugLineNum = 363;BA.debugLine="Sub status_lab_LongClick";
Debug.ShouldStop(1024);
 BA.debugLineNum = 365;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tbuts_click() throws Exception{
try {
		Debug.PushSubsStack("tbuts_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,303);
if (RapidSub.canDelegate("tbuts_click")) return main.remoteMe.runUserSub(false, "main","tbuts_click");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _tmind = RemoteObject.createImmutable(0);
 BA.debugLineNum = 303;BA.debugLine="Sub tbuts_click()";
Debug.ShouldStop(16384);
 BA.debugLineNum = 304;BA.debugLine="Try";
Debug.ShouldStop(32768);
try { BA.debugLineNum = 305;BA.debugLine="antidouble=False";
Debug.ShouldStop(65536);
main._antidouble = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 306;BA.debugLine="Dim p As Button";
Debug.ShouldStop(131072);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 307;BA.debugLine="Dim tmind As Int";
Debug.ShouldStop(262144);
_tmind = RemoteObject.createImmutable(0);Debug.locals.put("tmind", _tmind);
 BA.debugLineNum = 308;BA.debugLine="p = Sender";
Debug.ShouldStop(524288);
_p.setObject(main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 309;BA.debugLine="tmind=CM.toint(p.Tag)";
Debug.ShouldStop(1048576);
_tmind = main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(BA.ObjectToString(_p.runMethod(false,"getTag"))));Debug.locals.put("tmind", _tmind);
 BA.debugLineNum = 310;BA.debugLine="If tmind<1 Then Return";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("<",_tmind,BA.numberCast(double.class, 1))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 311;BA.debugLine="If butlock(tmind) =False Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",main._butlock.getArrayElement(true,_tmind),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 312;BA.debugLine="prs_but=0";
Debug.ShouldStop(8388608);
main._prs_but = BA.numberCast(int.class, 0);
 BA.debugLineNum = 313;BA.debugLine="send_comm(tmind,False,False)";
Debug.ShouldStop(16777216);
_send_comm(_tmind,main.mostCurrent.__c.getField(true,"False"),main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 314;BA.debugLine="butstate(tmind)=False";
Debug.ShouldStop(33554432);
main._butstate.setArrayElement (main.mostCurrent.__c.getField(true,"False"),_tmind);
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e267) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e267.toString()); BA.debugLineNum = 317;BA.debugLine="proces_error(LastException.Message & \"tbuts_clic";
Debug.ShouldStop(268435456);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("tbuts_click")));
 };
 BA.debugLineNum = 319;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tbuts_down() throws Exception{
try {
		Debug.PushSubsStack("tbuts_down (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,275);
if (RapidSub.canDelegate("tbuts_down")) return main.remoteMe.runUserSub(false, "main","tbuts_down");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _tmind = RemoteObject.createImmutable(0);
 BA.debugLineNum = 275;BA.debugLine="Sub tbuts_down()";
Debug.ShouldStop(262144);
 BA.debugLineNum = 276;BA.debugLine="Try";
Debug.ShouldStop(524288);
try { BA.debugLineNum = 277;BA.debugLine="If antidouble=True Then Return";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main._antidouble,main.mostCurrent.__c.getField(true,"True"))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 278;BA.debugLine="antidouble=True";
Debug.ShouldStop(2097152);
main._antidouble = main.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 279;BA.debugLine="Dim p As Button";
Debug.ShouldStop(4194304);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 280;BA.debugLine="Dim tmind As Int";
Debug.ShouldStop(8388608);
_tmind = RemoteObject.createImmutable(0);Debug.locals.put("tmind", _tmind);
 BA.debugLineNum = 281;BA.debugLine="p = Sender";
Debug.ShouldStop(16777216);
_p.setObject(main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 282;BA.debugLine="p.Background =sld_down";
Debug.ShouldStop(33554432);
_p.runMethod(false,"setBackground",(main.mostCurrent._sld_down.getObject()));
 BA.debugLineNum = 283;BA.debugLine="tmind=CM.toint(p.Tag)";
Debug.ShouldStop(67108864);
_tmind = main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(BA.ObjectToString(_p.runMethod(false,"getTag"))));Debug.locals.put("tmind", _tmind);
 BA.debugLineNum = 284;BA.debugLine="If tmind<1 Then Return";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("<",_tmind,BA.numberCast(double.class, 1))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 285;BA.debugLine="If butlock(tmind) =True Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",main._butlock.getArrayElement(true,_tmind),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 286;BA.debugLine="If butstate(tmind)=True Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",main._butstate.getArrayElement(true,_tmind),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 287;BA.debugLine="send_comm(tmind,False,False)";
Debug.ShouldStop(1073741824);
_send_comm(_tmind,main.mostCurrent.__c.getField(true,"False"),main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 288;BA.debugLine="butstate(tmind)=False";
Debug.ShouldStop(-2147483648);
main._butstate.setArrayElement (main.mostCurrent.__c.getField(true,"False"),_tmind);
 }else {
 BA.debugLineNum = 290;BA.debugLine="send_comm(tmind,True,True)";
Debug.ShouldStop(2);
_send_comm(_tmind,main.mostCurrent.__c.getField(true,"True"),main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 291;BA.debugLine="butstate(tmind)=True";
Debug.ShouldStop(4);
main._butstate.setArrayElement (main.mostCurrent.__c.getField(true,"True"),_tmind);
 };
 }else {
 BA.debugLineNum = 294;BA.debugLine="butstate(tmind)=True";
Debug.ShouldStop(32);
main._butstate.setArrayElement (main.mostCurrent.__c.getField(true,"True"),_tmind);
 BA.debugLineNum = 295;BA.debugLine="send_comm(tmind,True,False)";
Debug.ShouldStop(64);
_send_comm(_tmind,main.mostCurrent.__c.getField(true,"True"),main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 296;BA.debugLine="prs_but=tmind";
Debug.ShouldStop(128);
main._prs_but = _tmind;
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e250) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e250.toString()); BA.debugLineNum = 299;BA.debugLine="proces_error(LastException.Message & \"tbuts_cdow";
Debug.ShouldStop(1024);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("tbuts_cdown")));
 };
 BA.debugLineNum = 301;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _valid_menu_pass() throws Exception{
try {
		Debug.PushSubsStack("valid_menu_pass (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,356);
if (RapidSub.canDelegate("valid_menu_pass")) return main.remoteMe.runUserSub(false, "main","valid_menu_pass");
 BA.debugLineNum = 356;BA.debugLine="Sub valid_menu_pass() As Boolean";
Debug.ShouldStop(8);
 BA.debugLineNum = 357;BA.debugLine="If StateManager.getSetting2(\"menu_pass\",\"\").Lengt";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("menu_pass")),(Object)(RemoteObject.createImmutable(""))).runMethod(true,"length"),BA.numberCast(double.class, 0))) { 
if (true) return main.mostCurrent.__c.getField(true,"True");};
 BA.debugLineNum = 358;BA.debugLine="If allow_menu=True Then Return True";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",main._allow_menu,main.mostCurrent.__c.getField(true,"True"))) { 
if (true) return main.mostCurrent.__c.getField(true,"True");};
 BA.debugLineNum = 359;BA.debugLine="menu_pass_txt.Text =\"\"";
Debug.ShouldStop(64);
main.mostCurrent._menu_pass_txt.runMethodAndSync(true,"setText",RemoteObject.createImmutable(("")));
 BA.debugLineNum = 360;BA.debugLine="menu_pass_txt.Visible =True";
Debug.ShouldStop(128);
main.mostCurrent._menu_pass_txt.runMethod(true,"setVisible",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 361;BA.debugLine="Return False";
Debug.ShouldStop(256);
if (true) return main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 362;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wf_ap_set_click() throws Exception{
try {
		Debug.PushSubsStack("wf_ap_set_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,325);
if (RapidSub.canDelegate("wf_ap_set_click")) return main.remoteMe.runUserSub(false, "main","wf_ap_set_click");
 BA.debugLineNum = 325;BA.debugLine="Sub wf_ap_set_Click()";
Debug.ShouldStop(16);
 BA.debugLineNum = 326;BA.debugLine="If  valid_menu_pass=False Then Return";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_valid_menu_pass(),main.mostCurrent.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 327;BA.debugLine="StartActivity(AP_SET)";
Debug.ShouldStop(64);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._ap_set.getObject())));
 BA.debugLineNum = 328;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wf_sta_set_click() throws Exception{
try {
		Debug.PushSubsStack("wf_sta_set_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,329);
if (RapidSub.canDelegate("wf_sta_set_click")) return main.remoteMe.runUserSub(false, "main","wf_sta_set_click");
 BA.debugLineNum = 329;BA.debugLine="Sub wf_sta_set_Click()";
Debug.ShouldStop(256);
 BA.debugLineNum = 330;BA.debugLine="If  valid_menu_pass=False Then Return";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_valid_menu_pass(),main.mostCurrent.__c.getField(true,"False"))) { 
if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 331;BA.debugLine="StartActivity(STA_SET)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._sta_set.getObject())));
 BA.debugLineNum = 332;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _wifi_foundreadings(RemoteObject _readings) throws Exception{
try {
		Debug.PushSubsStack("wifi_FoundReadings (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,166);
if (RapidSub.canDelegate("wifi_foundreadings")) return main.remoteMe.runUserSub(false, "main","wifi_foundreadings", _readings);
RemoteObject _reading = RemoteObject.declareNull("com.AB.ABWifi.ABWifi.ABWifiReading");
Debug.locals.put("readings", _readings);
 BA.debugLineNum = 166;BA.debugLine="Sub wifi_FoundReadings(readings As List)";
Debug.ShouldStop(32);
 BA.debugLineNum = 167;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 168;BA.debugLine="If readings.Size<1 Then Return";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("<",_readings.runMethod(true,"getSize"),BA.numberCast(double.class, 1))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 169;BA.debugLine="Dim reading As ABWifiReading = readings.Get(0)";
Debug.ShouldStop(256);
_reading = (_readings.runMethod(false,"Get",(Object)(BA.numberCast(int.class, 0))));Debug.locals.put("reading", _reading);Debug.locals.put("reading", _reading);
 BA.debugLineNum = 170;BA.debugLine="wifisignal=reading.Level";
Debug.ShouldStop(512);
main._wifisignal = _reading.getField(true,"Level");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e138) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e138.toString()); BA.debugLineNum = 172;BA.debugLine="proces_error(LastException.Message & \"wi_fi_foun";
Debug.ShouldStop(2048);
_proces_error(RemoteObject.concat(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"),RemoteObject.createImmutable("wi_fi_foundread")));
 };
 BA.debugLineNum = 174;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}