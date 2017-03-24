package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_1 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,30);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
int _i = 0;
RemoteObject _tbuts = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 30;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="Try";
Debug.ShouldStop(1073741824);
try { BA.debugLineNum = 32;BA.debugLine="Activity.Title =\"Wi-Fi keys - \" & StateManager.Ge";
Debug.ShouldStop(-2147483648);
main.mostCurrent._activity.runMethod(false,"setTitle",(RemoteObject.concat(RemoteObject.createImmutable("Wi-Fi keys - "),main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 33;BA.debugLine="Activity.AddMenuItem(\"Keys set\",\"keys_set\")";
Debug.ShouldStop(1);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Keys set")),(Object)(RemoteObject.createImmutable("keys_set")));
 BA.debugLineNum = 34;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi AP set\",\"wf_ap_set";
Debug.ShouldStop(2);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Wi-Fi AP set")),(Object)(RemoteObject.createImmutable("wf_ap_set")));
 BA.debugLineNum = 35;BA.debugLine="Activity.AddMenuItem(\"Wi-Fi client set\",\"wf_ST";
Debug.ShouldStop(4);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Wi-Fi client set")),(Object)(RemoteObject.createImmutable("wf_STA_set")));
 BA.debugLineNum = 36;BA.debugLine="Activity.AddMenuItem(\"Select device\",\"sel_dev\")";
Debug.ShouldStop(8);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Select device")),(Object)(RemoteObject.createImmutable("sel_dev")));
 BA.debugLineNum = 37;BA.debugLine="Activity.AddMenuItem(\"Inet set\",\"inet_setm\")";
Debug.ShouldStop(16);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Inet set")),(Object)(RemoteObject.createImmutable("inet_setm")));
 BA.debugLineNum = 38;BA.debugLine="Activity.AddMenuItem(\"Reset device\",\"reset_dev\")";
Debug.ShouldStop(32);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("Reset device")),(Object)(RemoteObject.createImmutable("reset_dev")));
 BA.debugLineNum = 39;BA.debugLine="Activity.AddMenuItem(\"EXIT\",\"exit_prg\")";
Debug.ShouldStop(64);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToString("EXIT")),(Object)(RemoteObject.createImmutable("exit_prg")));
 BA.debugLineNum = 40;BA.debugLine="prs.Initialize(Colors.Gray,0dip)";
Debug.ShouldStop(128);
main.mostCurrent._prs.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"Gray")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 41;BA.debugLine="ups.Initialize(Colors.DarkGray, 0dip)";
Debug.ShouldStop(256);
main.mostCurrent._ups.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"Colors").getField(true,"DarkGray")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 42;BA.debugLine="grn.Initialize(Colors.RGB(0,150,0), 0dip)";
Debug.ShouldStop(512);
main.mostCurrent._grn.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 150)),(Object)(BA.numberCast(int.class, 0)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))));
 BA.debugLineNum = 43;BA.debugLine="sld_norm.Initialize";
Debug.ShouldStop(1024);
main.mostCurrent._sld_norm.runVoidMethod ("Initialize");
 BA.debugLineNum = 44;BA.debugLine="sld_norm.AddState(sld_norm.State_Pressed, ups)";
Debug.ShouldStop(2048);
main.mostCurrent._sld_norm.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_norm.getField(true,"State_Pressed")),(Object)((main.mostCurrent._ups.getObject())));
 BA.debugLineNum = 45;BA.debugLine="sld_norm.AddState(sld_norm.State_Enabled, ups)";
Debug.ShouldStop(4096);
main.mostCurrent._sld_norm.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_norm.getField(true,"State_Enabled")),(Object)((main.mostCurrent._ups.getObject())));
 BA.debugLineNum = 46;BA.debugLine="sld_on.Initialize";
Debug.ShouldStop(8192);
main.mostCurrent._sld_on.runVoidMethod ("Initialize");
 BA.debugLineNum = 47;BA.debugLine="sld_on.AddState(sld_on.State_Pressed, grn)";
Debug.ShouldStop(16384);
main.mostCurrent._sld_on.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Pressed")),(Object)((main.mostCurrent._grn.getObject())));
 BA.debugLineNum = 48;BA.debugLine="sld_on.AddState(sld_on.State_Enabled, grn)";
Debug.ShouldStop(32768);
main.mostCurrent._sld_on.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Enabled")),(Object)((main.mostCurrent._grn.getObject())));
 BA.debugLineNum = 49;BA.debugLine="sld_down.Initialize";
Debug.ShouldStop(65536);
main.mostCurrent._sld_down.runVoidMethod ("Initialize");
 BA.debugLineNum = 50;BA.debugLine="sld_down.AddState(sld_on.State_Pressed, prs)";
Debug.ShouldStop(131072);
main.mostCurrent._sld_down.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Pressed")),(Object)((main.mostCurrent._prs.getObject())));
 BA.debugLineNum = 51;BA.debugLine="sld_down.AddState(sld_on.State_Enabled, prs)";
Debug.ShouldStop(262144);
main.mostCurrent._sld_down.runVoidMethod ("AddState",(Object)(main.mostCurrent._sld_on.getField(true,"State_Enabled")),(Object)((main.mostCurrent._prs.getObject())));
 BA.debugLineNum = 52;BA.debugLine="status_lab.Initialize(\"status_lab\")";
Debug.ShouldStop(524288);
main.mostCurrent._status_lab.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("status_lab")));
 BA.debugLineNum = 53;BA.debugLine="status_lab.TextColor=Colors.Red";
Debug.ShouldStop(1048576);
main.mostCurrent._status_lab.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 54;BA.debugLine="status_lab.Text = \"No connected\"";
Debug.ShouldStop(2097152);
main.mostCurrent._status_lab.runMethod(true,"setText",RemoteObject.createImmutable(("No connected")));
 BA.debugLineNum = 55;BA.debugLine="Activity.AddView(status_lab, 0dip, Activity.He";
Debug.ShouldStop(4194304);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((main.mostCurrent._status_lab.getObject())),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 0)))),(Object)(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),(Object)(main.mostCurrent._activity.runMethod(true,"getWidth")),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 56;BA.debugLine="For i = 1 To 32";
Debug.ShouldStop(8388608);
{
final int step26 = 1;
final int limit26 = 32;
for (_i = 1 ; (step26 > 0 && _i <= limit26) || (step26 < 0 && _i >= limit26); _i = ((int)(0 + _i + step26)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 57;BA.debugLine="Dim tbuts As Button";
Debug.ShouldStop(16777216);
_tbuts = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("tbuts", _tbuts);
 BA.debugLineNum = 58;BA.debugLine="tbuts.Initialize(\"tbuts\")";
Debug.ShouldStop(33554432);
_tbuts.runVoidMethod ("Initialize",main.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("tbuts")));
 BA.debugLineNum = 59;BA.debugLine="Activity.AddView(tbuts, -2000dip, 0, 20dip";
Debug.ShouldStop(67108864);
main.mostCurrent._activity.runVoidMethod ("AddView",(Object)((_tbuts.getObject())),(Object)(BA.numberCast(int.class, -(double) (0 + main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2000))).<Integer>get().intValue()))),(Object)(BA.numberCast(int.class, 0)),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))),(Object)(main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))));
 BA.debugLineNum = 60;BA.debugLine="tbuts.Background=sld_norm";
Debug.ShouldStop(134217728);
_tbuts.runMethod(false,"setBackground",(main.mostCurrent._sld_norm.getObject()));
 BA.debugLineNum = 61;BA.debugLine="butt(i)=tbuts";
Debug.ShouldStop(268435456);
main.mostCurrent._butt.setArrayElement (_tbuts,BA.numberCast(int.class, _i));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 63;BA.debugLine="add_key_to_panel";
Debug.ShouldStop(1073741824);
_add_key_to_panel();
 BA.debugLineNum = 64;BA.debugLine="send_state_timer.Initialize(\"send_state_timer\", 1";
Debug.ShouldStop(-2147483648);
main._send_state_timer.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("send_state_timer")),(Object)(BA.numberCast(long.class, 1000)));
 BA.debugLineNum = 65;BA.debugLine="send_state_timer.Enabled =True";
Debug.ShouldStop(1);
main._send_state_timer.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e51) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e51.toString()); BA.debugLineNum = 67;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(4);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,75);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 75;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 77;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(4096);
main.mostCurrent._statemanager.runVoidMethod ("_savesettings",main.mostCurrent.activityBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e61) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e61.toString()); BA.debugLineNum = 79;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(16384);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,71);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 71;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="add_key_to_panel";
Debug.ShouldStop(128);
_add_key_to_panel();
 BA.debugLineNum = 73;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("add_key_to_panel (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,169);
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
 BA.debugLineNum = 169;BA.debugLine="Sub add_key_to_panel() 'розміщення кнопок керуванн";
Debug.ShouldStop(256);
 BA.debugLineNum = 170;BA.debugLine="Try";
Debug.ShouldStop(512);
try { BA.debugLineNum = 171;BA.debugLine="clear_keys";
Debug.ShouldStop(1024);
_clear_keys();
 BA.debugLineNum = 172;BA.debugLine="Dim vert_size As Int=StateManager.GetSetting2(\"v_";
Debug.ShouldStop(2048);
_vert_size = BA.numberCast(int.class, main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("v_size")),(Object)(RemoteObject.createImmutable(""))));Debug.locals.put("vert_size", _vert_size);Debug.locals.put("vert_size", _vert_size);
 BA.debugLineNum = 173;BA.debugLine="Dim horiz_size As Int=StateManager.GetSetting2(\"h";
Debug.ShouldStop(4096);
_horiz_size = BA.numberCast(int.class, main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("h_size")),(Object)(RemoteObject.createImmutable(""))));Debug.locals.put("horiz_size", _horiz_size);Debug.locals.put("horiz_size", _horiz_size);
 BA.debugLineNum = 174;BA.debugLine="Dim font_size As Int=StateManager.GetSetting2(\"fo";
Debug.ShouldStop(8192);
_font_size = BA.numberCast(int.class, main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(BA.ObjectToString("font_size")),(Object)(RemoteObject.createImmutable(""))));Debug.locals.put("font_size", _font_size);Debug.locals.put("font_size", _font_size);
 BA.debugLineNum = 175;BA.debugLine="Dim b_width,b_height,posx,posy,max_but As Int";
Debug.ShouldStop(16384);
_b_width = RemoteObject.createImmutable(0);Debug.locals.put("b_width", _b_width);
_b_height = RemoteObject.createImmutable(0);Debug.locals.put("b_height", _b_height);
_posx = RemoteObject.createImmutable(0);Debug.locals.put("posx", _posx);
_posy = RemoteObject.createImmutable(0);Debug.locals.put("posy", _posy);
_max_but = RemoteObject.createImmutable(0);Debug.locals.put("max_but", _max_but);
 BA.debugLineNum = 176;BA.debugLine="b_width=Activity.Width/horiz_size";
Debug.ShouldStop(32768);
_b_width = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getWidth"),_horiz_size}, "/",0, 0));Debug.locals.put("b_width", _b_width);
 BA.debugLineNum = 177;BA.debugLine="b_height=(Activity.height-20dip)/vert_size";
Debug.ShouldStop(65536);
_b_height = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {main.mostCurrent._activity.runMethod(true,"getHeight"),main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 20)))}, "-",1, 1)),_vert_size}, "/",0, 0));Debug.locals.put("b_height", _b_height);
 BA.debugLineNum = 178;BA.debugLine="max_but =horiz_size*vert_size";
Debug.ShouldStop(131072);
_max_but = RemoteObject.solve(new RemoteObject[] {_horiz_size,_vert_size}, "*",0, 1);Debug.locals.put("max_but", _max_but);
 BA.debugLineNum = 179;BA.debugLine="cur_but_state=0";
Debug.ShouldStop(262144);
main._cur_but_state = BA.numberCast(int.class, 0);
 BA.debugLineNum = 180;BA.debugLine="For a=1 To 32";
Debug.ShouldStop(524288);
{
final int step11 = 1;
final int limit11 = 32;
for (_a = 1 ; (step11 > 0 && _a <= limit11) || (step11 < 0 && _a >= limit11); _a = ((int)(0 + _a + step11)) ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 181;BA.debugLine="butt(a).Background=sld_norm";
Debug.ShouldStop(1048576);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(false,"setBackground",(main.mostCurrent._sld_norm.getObject()));
 BA.debugLineNum = 182;BA.debugLine="If CM.toint(StateManager.GetSetting2(\"keytag\" &";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean(">",main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),RemoteObject.createImmutable(_a))),(Object)(RemoteObject.createImmutable(""))))),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 183;BA.debugLine="If cur_but_state>=max_but Then Return";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("g",main._cur_but_state,BA.numberCast(double.class, _max_but))) { 
Debug.CheckDeviceExceptions();if (true) return RemoteObject.createImmutable("");};
 BA.debugLineNum = 184;BA.debugLine="posy=cur_but_state/horiz_size";
Debug.ShouldStop(8388608);
_posy = BA.numberCast(int.class, RemoteObject.solve(new RemoteObject[] {main._cur_but_state,_horiz_size}, "/",0, 0));Debug.locals.put("posy", _posy);
 BA.debugLineNum = 185;BA.debugLine="posx=cur_but_state mod horiz_size";
Debug.ShouldStop(16777216);
_posx = RemoteObject.solve(new RemoteObject[] {main._cur_but_state,_horiz_size}, "%",0, 1);Debug.locals.put("posx", _posx);
 BA.debugLineNum = 186;BA.debugLine="butlock(a)=CM.obj2Bool(StateManager.GetSetting2";
Debug.ShouldStop(33554432);
main._butlock.setArrayElement (main.mostCurrent._cm.runMethod(true,"_obj2bool",main.mostCurrent.activityBA,(Object)((main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keylock"),RemoteObject.createImmutable(_a))),(Object)(BA.NumberToString(0)))))),BA.numberCast(int.class, _a));
 BA.debugLineNum = 187;BA.debugLine="butt(a).Text =StateManager.GetSetting2(\"keytext";
Debug.ShouldStop(67108864);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setText",(main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytext"),RemoteObject.createImmutable(_a))),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 188;BA.debugLine="butt(a).tag =StateManager.GetSetting2(\"keytag\"";
Debug.ShouldStop(134217728);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(false,"setTag",(main.mostCurrent._statemanager.runMethod(true,"_getsetting2",main.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),RemoteObject.createImmutable(_a))),(Object)(RemoteObject.createImmutable("")))));
 BA.debugLineNum = 189;BA.debugLine="butt(a).Left =posx*(b_width+1dip)";
Debug.ShouldStop(268435456);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setLeft",RemoteObject.solve(new RemoteObject[] {_posx,(RemoteObject.solve(new RemoteObject[] {_b_width,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 1))}, "*",0, 1));
 BA.debugLineNum = 190;BA.debugLine="butt(a).top =posy*(b_height+1dip)";
Debug.ShouldStop(536870912);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setTop",RemoteObject.solve(new RemoteObject[] {_posy,(RemoteObject.solve(new RemoteObject[] {_b_height,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 1)))}, "+",1, 1))}, "*",0, 1));
 BA.debugLineNum = 191;BA.debugLine="butt(a).width =b_width-2dip";
Debug.ShouldStop(1073741824);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setWidth",RemoteObject.solve(new RemoteObject[] {_b_width,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1));
 BA.debugLineNum = 192;BA.debugLine="butt(a).height =b_height-2dip";
Debug.ShouldStop(-2147483648);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setHeight",RemoteObject.solve(new RemoteObject[] {_b_height,main.mostCurrent.__c.runMethod(true,"DipToCurrent",(Object)(BA.numberCast(int.class, 2)))}, "-",1, 1));
 BA.debugLineNum = 193;BA.debugLine="butt(a).TextSize =font_size";
Debug.ShouldStop(1);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(true,"setTextSize",BA.numberCast(float.class, _font_size));
 BA.debugLineNum = 194;BA.debugLine="cur_but_state=cur_but_state+1";
Debug.ShouldStop(2);
main._cur_but_state = RemoteObject.solve(new RemoteObject[] {main._cur_but_state,RemoteObject.createImmutable(1)}, "+",1, 1);
 };
 }
}Debug.locals.put("a", _a);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e161) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e161.toString()); BA.debugLineNum = 198;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(32);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 200;BA.debugLine="End Sub";
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
public static RemoteObject  _clear_keys() throws Exception{
try {
		Debug.PushSubsStack("clear_keys (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,84);
if (RapidSub.canDelegate("clear_keys")) return main.remoteMe.runUserSub(false, "main","clear_keys");
int _i = 0;
 BA.debugLineNum = 84;BA.debugLine="Sub clear_keys";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 86;BA.debugLine="For i = 1 To 32";
Debug.ShouldStop(2097152);
{
final int step2 = 1;
final int limit2 = 32;
for (_i = 1 ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 87;BA.debugLine="butt(i).Left =-2000";
Debug.ShouldStop(4194304);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(true,"setLeft",BA.numberCast(int.class, -(double) (0 + 2000)));
 BA.debugLineNum = 88;BA.debugLine="butt(i).Tag =\"\"";
Debug.ShouldStop(8388608);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _i)).runMethod(false,"setTag",RemoteObject.createImmutable(("")));
 }
}Debug.locals.put("i", _i);
;
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e71) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e71.toString()); BA.debugLineNum = 92;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(134217728);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
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
		Debug.PushSubsStack("get_rssi (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,133);
if (RapidSub.canDelegate("get_rssi")) return main.remoteMe.runUserSub(false, "main","get_rssi");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 133;BA.debugLine="Sub get_rssi() 'Відправка запиту на отримання рів";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 135;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(64);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 136;BA.debugLine="Data.Initialize";
Debug.ShouldStop(128);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 137;BA.debugLine="Data.Put (\"rssi\",1)";
Debug.ShouldStop(256);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("rssi"))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 138;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(512);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",main.mostCurrent.activityBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e108) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e108.toString()); BA.debugLineNum = 140;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(2048);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 142;BA.debugLine="End Sub";
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
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 19;BA.debugLine="Dim butt(33) As Button";
main.mostCurrent._butt = RemoteObject.createNewArray ("anywheresoftware.b4a.objects.ButtonWrapper", new int[] {33}, new Object[]{});
 //BA.debugLineNum = 20;BA.debugLine="Dim status_lab As Label";
main.mostCurrent._status_lab = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Dim butlock(33) As Boolean";
main._butlock = RemoteObject.createNewArray ("boolean", new int[] {33}, new Object[]{});
 //BA.debugLineNum = 22;BA.debugLine="Dim butstate(33) As Boolean";
main._butstate = RemoteObject.createNewArray ("boolean", new int[] {33}, new Object[]{});
 //BA.debugLineNum = 23;BA.debugLine="Dim sld_norm,sld_on,sld_down As StateListDrawable";
main.mostCurrent._sld_norm = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.StateListDrawable");
main.mostCurrent._sld_on = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.StateListDrawable");
main.mostCurrent._sld_down = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.StateListDrawable");
 //BA.debugLineNum = 24;BA.debugLine="Dim prs, ups,grn As ColorDrawable";
main.mostCurrent._prs = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");
main.mostCurrent._ups = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");
main.mostCurrent._grn = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.ColorDrawable");
 //BA.debugLineNum = 26;BA.debugLine="Dim cur_but_state As Int";
main._cur_but_state = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 27;BA.debugLine="Dim prs_but As Int";
main._prs_but = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 28;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _inet_setm_click() throws Exception{
try {
		Debug.PushSubsStack("inet_setm_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,259);
if (RapidSub.canDelegate("inet_setm_click")) return main.remoteMe.runUserSub(false, "main","inet_setm_click");
 BA.debugLineNum = 259;BA.debugLine="Sub inet_setm_Click()";
Debug.ShouldStop(4);
 BA.debugLineNum = 260;BA.debugLine="StartActivity(INET_SET)";
Debug.ShouldStop(8);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._inet_set.getObject())));
 BA.debugLineNum = 261;BA.debugLine="End Sub";
Debug.ShouldStop(16);
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
		Debug.PushSubsStack("keys_set_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,256);
if (RapidSub.canDelegate("keys_set_click")) return main.remoteMe.runUserSub(false, "main","keys_set_click");
 BA.debugLineNum = 256;BA.debugLine="Sub keys_set_Click()";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 257;BA.debugLine="StartActivity(KEY_SET)";
Debug.ShouldStop(1);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._key_set.getObject())));
 BA.debugLineNum = 258;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("proces_error (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,278);
if (RapidSub.canDelegate("proces_error")) return main.remoteMe.runUserSub(false, "main","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 278;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 279;BA.debugLine="Msgbox(msg,\"error\")";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(_msg),(Object)(RemoteObject.createImmutable("error")),main.mostCurrent.activityBA);
 BA.debugLineNum = 280;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
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
 //BA.debugLineNum = 15;BA.debugLine="Public  send_state_timer As Timer";
main._send_state_timer = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _reset_dev_click() throws Exception{
try {
		Debug.PushSubsStack("reset_dev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,262);
if (RapidSub.canDelegate("reset_dev_click")) return main.remoteMe.runUserSub(false, "main","reset_dev_click");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 262;BA.debugLine="Sub reset_dev_Click()";
Debug.ShouldStop(32);
 BA.debugLineNum = 263;BA.debugLine="Try";
Debug.ShouldStop(64);
try { BA.debugLineNum = 264;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(128);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 265;BA.debugLine="Data.Initialize";
Debug.ShouldStop(256);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 266;BA.debugLine="Data.Put (\"rst\",1)";
Debug.ShouldStop(512);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("rst"))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 267;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(1024);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",main.mostCurrent.activityBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e225) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e225.toString()); BA.debugLineNum = 269;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(4096);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 273;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
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
		Debug.PushSubsStack("sel_dev_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,247);
if (RapidSub.canDelegate("sel_dev_click")) return main.remoteMe.runUserSub(false, "main","sel_dev_click");
 BA.debugLineNum = 247;BA.debugLine="Sub sel_dev_Click()";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 248;BA.debugLine="StartActivity(sel_dev)";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._sel_dev.getObject())));
 BA.debugLineNum = 249;BA.debugLine="End Sub";
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
public static RemoteObject  _send_comm(RemoteObject _ind,RemoteObject _com,RemoteObject _lock) throws Exception{
try {
		Debug.PushSubsStack("send_comm (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,101);
if (RapidSub.canDelegate("send_comm")) return main.remoteMe.runUserSub(false, "main","send_comm", _ind, _com, _lock);
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("ind", _ind);
Debug.locals.put("com", _com);
Debug.locals.put("lock", _lock);
 BA.debugLineNum = 101;BA.debugLine="Sub send_comm(ind As Int,com As Boolean,lock As Bo";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 103;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(64);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 104;BA.debugLine="Data.Initialize";
Debug.ShouldStop(128);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 105;BA.debugLine="Data.Put (\"ncom\",ind)";
Debug.ShouldStop(256);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("ncom"))),(Object)((_ind)));
 BA.debugLineNum = 106;BA.debugLine="Data.Put (\"com\",com)";
Debug.ShouldStop(512);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("com"))),(Object)((_com)));
 BA.debugLineNum = 107;BA.debugLine="Data.Put (\"lock\",lock)";
Debug.ShouldStop(1024);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("lock"))),(Object)((_lock)));
 BA.debugLineNum = 108;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(2048);
main.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",main.mostCurrent.activityBA,(Object)((main.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e83) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e83.toString()); BA.debugLineNum = 110;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(8192);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 112;BA.debugLine="End Sub";
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
public static RemoteObject  _send_state_timer_tick() throws Exception{
try {
		Debug.PushSubsStack("send_state_timer_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,116);
if (RapidSub.canDelegate("send_state_timer_tick")) return main.remoteMe.runUserSub(false, "main","send_state_timer_tick");
 BA.debugLineNum = 116;BA.debugLine="Sub send_state_timer_Tick() ' таймер перевірки звя";
Debug.ShouldStop(524288);
 BA.debugLineNum = 117;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 118;BA.debugLine="If prs_but>0 Then send_comm(prs_but,True,False)";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean(">",main._prs_but,BA.numberCast(double.class, 0))) { 
_send_comm(main._prs_but,main.mostCurrent.__c.getField(true,"True"),main.mostCurrent.__c.getField(true,"False"));};
 BA.debugLineNum = 119;BA.debugLine="get_rssi";
Debug.ShouldStop(4194304);
_get_rssi();
 BA.debugLineNum = 120;BA.debugLine="If conect_tmout>0 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean(">",main._conect_tmout,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 121;BA.debugLine="conect_tmout=conect_tmout-1";
Debug.ShouldStop(16777216);
main._conect_tmout = RemoteObject.solve(new RemoteObject[] {main._conect_tmout,RemoteObject.createImmutable(1)}, "-",1, 1);
 BA.debugLineNum = 122;BA.debugLine="If conect_tmout=0 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",main._conect_tmout,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 123;BA.debugLine="status_lab.TextColor=Colors.Red";
Debug.ShouldStop(67108864);
main.mostCurrent._status_lab.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Red"));
 BA.debugLineNum = 124;BA.debugLine="status_lab.Text = \"No connected\"";
Debug.ShouldStop(134217728);
main.mostCurrent._status_lab.runMethod(true,"setText",RemoteObject.createImmutable(("No connected")));
 };
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e98) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e98.toString()); BA.debugLineNum = 129;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(1);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 131;BA.debugLine="End Sub";
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
public static RemoteObject  _set_ris(RemoteObject _rstate) throws Exception{
try {
		Debug.PushSubsStack("set_ris (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,144);
if (RapidSub.canDelegate("set_ris")) return main.remoteMe.runUserSub(false, "main","set_ris", _rstate);
RemoteObject _sta = RemoteObject.createImmutable(false);
RemoteObject _tmplong = RemoteObject.createImmutable(0L);
int _a = 0;
Debug.locals.put("rstate", _rstate);
 BA.debugLineNum = 144;BA.debugLine="Sub set_ris(rstate As Map)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="Try";
Debug.ShouldStop(65536);
try { BA.debugLineNum = 146;BA.debugLine="Dim sta As Boolean";
Debug.ShouldStop(131072);
_sta = RemoteObject.createImmutable(false);Debug.locals.put("sta", _sta);
 BA.debugLineNum = 147;BA.debugLine="Dim tmplong As Long";
Debug.ShouldStop(262144);
_tmplong = RemoteObject.createImmutable(0L);Debug.locals.put("tmplong", _tmplong);
 BA.debugLineNum = 148;BA.debugLine="tmplong =CM.tolong(rstate.Get(\"st\"))";
Debug.ShouldStop(524288);
_tmplong = BA.numberCast(long.class, main.mostCurrent._cm.runMethod(true,"_tolong",main.mostCurrent.activityBA,(Object)(BA.ObjectToString(_rstate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("st"))))))));Debug.locals.put("tmplong", _tmplong);
 BA.debugLineNum = 149;BA.debugLine="For a=1 To 30";
Debug.ShouldStop(1048576);
{
final int step5 = 1;
final int limit5 = 30;
for (_a = 1 ; (step5 > 0 && _a <= limit5) || (step5 < 0 && _a >= limit5); _a = ((int)(0 + _a + step5)) ) {
Debug.locals.put("a", _a);
 BA.debugLineNum = 150;BA.debugLine="butstate(a)=CM.obj2Bool(Bit.And(tmplong , 1))";
Debug.ShouldStop(2097152);
main._butstate.setArrayElement (main.mostCurrent._cm.runMethod(true,"_obj2bool",main.mostCurrent.activityBA,(Object)((main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"And",(Object)(BA.numberCast(int.class, _tmplong)),(Object)(BA.numberCast(int.class, 1)))))),BA.numberCast(int.class, _a));
 BA.debugLineNum = 151;BA.debugLine="tmplong=Bit.ShiftRight(tmplong,1)";
Debug.ShouldStop(4194304);
_tmplong = BA.numberCast(long.class, main.mostCurrent.__c.getField(false,"Bit").runMethod(true,"ShiftRight",(Object)(BA.numberCast(int.class, _tmplong)),(Object)(BA.numberCast(int.class, 1))));Debug.locals.put("tmplong", _tmplong);
 BA.debugLineNum = 152;BA.debugLine="If butstate(a)=True Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",main._butstate.getArrayElement(true,BA.numberCast(int.class, _a)),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 153;BA.debugLine="butt(a).Background =sld_on";
Debug.ShouldStop(16777216);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(false,"setBackground",(main.mostCurrent._sld_on.getObject()));
 }else {
 BA.debugLineNum = 155;BA.debugLine="butt(a).Background =sld_norm";
Debug.ShouldStop(67108864);
main.mostCurrent._butt.getArrayElement(false,BA.numberCast(int.class, _a)).runMethod(false,"setBackground",(main.mostCurrent._sld_norm.getObject()));
 };
 }
}Debug.locals.put("a", _a);
;
 BA.debugLineNum = 159;BA.debugLine="status_lab.TextColor=Colors.Green";
Debug.ShouldStop(1073741824);
main.mostCurrent._status_lab.runMethod(true,"setTextColor",main.mostCurrent.__c.getField(false,"Colors").getField(true,"Green"));
 BA.debugLineNum = 160;BA.debugLine="status_lab.Text = \" RSSI: \" & rstate.Get(\"rssi\")";
Debug.ShouldStop(-2147483648);
main.mostCurrent._status_lab.runMethod(true,"setText",(RemoteObject.concat(RemoteObject.createImmutable(" RSSI: "),_rstate.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("rssi")))),RemoteObject.createImmutable("dbm   Connected"))));
 BA.debugLineNum = 161;BA.debugLine="conect_tmout=3";
Debug.ShouldStop(1);
main._conect_tmout = BA.numberCast(int.class, 3);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e129) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e129.toString()); BA.debugLineNum = 164;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(8);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 166;BA.debugLine="End Sub";
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
public static RemoteObject  _status_lab_longclick() throws Exception{
try {
		Debug.PushSubsStack("status_lab_LongClick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,274);
if (RapidSub.canDelegate("status_lab_longclick")) return main.remoteMe.runUserSub(false, "main","status_lab_longclick");
 BA.debugLineNum = 274;BA.debugLine="Sub status_lab_LongClick";
Debug.ShouldStop(131072);
 BA.debugLineNum = 276;BA.debugLine="End Sub";
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
public static RemoteObject  _tbuts_click() throws Exception{
try {
		Debug.PushSubsStack("tbuts_click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,231);
if (RapidSub.canDelegate("tbuts_click")) return main.remoteMe.runUserSub(false, "main","tbuts_click");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _tmind = RemoteObject.createImmutable(0);
 BA.debugLineNum = 231;BA.debugLine="Sub tbuts_click()";
Debug.ShouldStop(64);
 BA.debugLineNum = 232;BA.debugLine="Try";
Debug.ShouldStop(128);
try { BA.debugLineNum = 233;BA.debugLine="Dim p As Button";
Debug.ShouldStop(256);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 234;BA.debugLine="Dim tmind As Int";
Debug.ShouldStop(512);
_tmind = RemoteObject.createImmutable(0);Debug.locals.put("tmind", _tmind);
 BA.debugLineNum = 235;BA.debugLine="p = Sender";
Debug.ShouldStop(1024);
_p.setObject(main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 236;BA.debugLine="tmind=CM.toint(p.Tag)";
Debug.ShouldStop(2048);
_tmind = main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(BA.ObjectToString(_p.runMethod(false,"getTag"))));Debug.locals.put("tmind", _tmind);
 BA.debugLineNum = 237;BA.debugLine="If butlock(tmind) =False Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",main._butlock.getArrayElement(true,_tmind),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 238;BA.debugLine="prs_but=0";
Debug.ShouldStop(8192);
main._prs_but = BA.numberCast(int.class, 0);
 BA.debugLineNum = 239;BA.debugLine="send_comm(tmind,False,False)";
Debug.ShouldStop(16384);
_send_comm(_tmind,main.mostCurrent.__c.getField(true,"False"),main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 240;BA.debugLine="butstate(tmind)=False";
Debug.ShouldStop(32768);
main._butstate.setArrayElement (main.mostCurrent.__c.getField(true,"False"),_tmind);
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e200) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e200.toString()); BA.debugLineNum = 243;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(262144);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 245;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("tbuts_down (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,206);
if (RapidSub.canDelegate("tbuts_down")) return main.remoteMe.runUserSub(false, "main","tbuts_down");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
RemoteObject _tmind = RemoteObject.createImmutable(0);
 BA.debugLineNum = 206;BA.debugLine="Sub tbuts_down()";
Debug.ShouldStop(8192);
 BA.debugLineNum = 207;BA.debugLine="Try";
Debug.ShouldStop(16384);
try { BA.debugLineNum = 208;BA.debugLine="Dim p As Button";
Debug.ShouldStop(32768);
_p = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");Debug.locals.put("p", _p);
 BA.debugLineNum = 209;BA.debugLine="Dim tmind As Int";
Debug.ShouldStop(65536);
_tmind = RemoteObject.createImmutable(0);Debug.locals.put("tmind", _tmind);
 BA.debugLineNum = 210;BA.debugLine="p = Sender";
Debug.ShouldStop(131072);
_p.setObject(main.mostCurrent.__c.runMethod(false,"Sender",main.mostCurrent.activityBA));
 BA.debugLineNum = 211;BA.debugLine="p.Background =sld_down";
Debug.ShouldStop(262144);
_p.runMethod(false,"setBackground",(main.mostCurrent._sld_down.getObject()));
 BA.debugLineNum = 212;BA.debugLine="tmind=CM.toint(p.Tag)";
Debug.ShouldStop(524288);
_tmind = main.mostCurrent._cm.runMethod(true,"_toint",main.mostCurrent.activityBA,(Object)(BA.ObjectToString(_p.runMethod(false,"getTag"))));Debug.locals.put("tmind", _tmind);
 BA.debugLineNum = 213;BA.debugLine="If butlock(tmind) =True Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("=",main._butlock.getArrayElement(true,_tmind),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 214;BA.debugLine="If butstate(tmind)=True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main._butstate.getArrayElement(true,_tmind),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 215;BA.debugLine="send_comm(tmind,False,False)";
Debug.ShouldStop(4194304);
_send_comm(_tmind,main.mostCurrent.__c.getField(true,"False"),main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 216;BA.debugLine="butstate(tmind)=False";
Debug.ShouldStop(8388608);
main._butstate.setArrayElement (main.mostCurrent.__c.getField(true,"False"),_tmind);
 }else {
 BA.debugLineNum = 218;BA.debugLine="send_comm(tmind,True,True)";
Debug.ShouldStop(33554432);
_send_comm(_tmind,main.mostCurrent.__c.getField(true,"True"),main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 219;BA.debugLine="butstate(tmind)=True";
Debug.ShouldStop(67108864);
main._butstate.setArrayElement (main.mostCurrent.__c.getField(true,"True"),_tmind);
 };
 }else {
 BA.debugLineNum = 222;BA.debugLine="butstate(tmind)=True";
Debug.ShouldStop(536870912);
main._butstate.setArrayElement (main.mostCurrent.__c.getField(true,"True"),_tmind);
 BA.debugLineNum = 223;BA.debugLine="send_comm(tmind,True,False)";
Debug.ShouldStop(1073741824);
_send_comm(_tmind,main.mostCurrent.__c.getField(true,"True"),main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 224;BA.debugLine="prs_but=tmind";
Debug.ShouldStop(-2147483648);
main._prs_but = _tmind;
 };
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e185) {
			BA.rdebugUtils.runVoidMethod("setLastException",main.processBA, e185.toString()); BA.debugLineNum = 227;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(4);
_proces_error(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 229;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
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
		Debug.PushSubsStack("wf_ap_set_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,250);
if (RapidSub.canDelegate("wf_ap_set_click")) return main.remoteMe.runUserSub(false, "main","wf_ap_set_click");
 BA.debugLineNum = 250;BA.debugLine="Sub wf_ap_set_Click()";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 251;BA.debugLine="StartActivity(AP_SET)";
Debug.ShouldStop(67108864);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._ap_set.getObject())));
 BA.debugLineNum = 252;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
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
		Debug.PushSubsStack("wf_sta_set_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,253);
if (RapidSub.canDelegate("wf_sta_set_click")) return main.remoteMe.runUserSub(false, "main","wf_sta_set_click");
 BA.debugLineNum = 253;BA.debugLine="Sub wf_sta_set_Click()";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 254;BA.debugLine="StartActivity(STA_SET)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.mostCurrent.activityBA,(Object)((main.mostCurrent._sta_set.getObject())));
 BA.debugLineNum = 255;BA.debugLine="End Sub";
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
}