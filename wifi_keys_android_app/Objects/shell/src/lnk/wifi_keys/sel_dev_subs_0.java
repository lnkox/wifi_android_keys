package lnk.wifi_keys;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class sel_dev_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,15);
if (RapidSub.canDelegate("activity_create")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 15;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16384);
 BA.debugLineNum = 16;BA.debugLine="Activity.LoadLayout(\"sel_dev_lay\")";
Debug.ShouldStop(32768);
sel_dev.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("sel_dev_lay")),sel_dev.mostCurrent.activityBA);
 BA.debugLineNum = 17;BA.debugLine="get_name";
Debug.ShouldStop(65536);
_get_name();
 BA.debugLineNum = 18;BA.debugLine="End Sub";
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,24);
if (RapidSub.canDelegate("activity_pause")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 26;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Resume (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,20);
if (RapidSub.canDelegate("activity_resume")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","activity_resume");
 BA.debugLineNum = 20;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(524288);
 BA.debugLineNum = 22;BA.debugLine="End Sub";
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
public static RemoteObject  _add_dev_tolist(RemoteObject _dev_name,RemoteObject _dev_ip) throws Exception{
try {
		Debug.PushSubsStack("add_dev_tolist (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,48);
if (RapidSub.canDelegate("add_dev_tolist")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","add_dev_tolist", _dev_name, _dev_ip);
Debug.locals.put("dev_name", _dev_name);
Debug.locals.put("dev_ip", _dev_ip);
 BA.debugLineNum = 48;BA.debugLine="Sub add_dev_tolist(dev_name As String,dev_ip As St";
Debug.ShouldStop(32768);
 BA.debugLineNum = 49;BA.debugLine="dev_list.AddTwoLines(dev_name,dev_ip)";
Debug.ShouldStop(65536);
sel_dev.mostCurrent._dev_list.runVoidMethod ("AddTwoLines",(Object)(_dev_name),(Object)(_dev_ip));
 BA.debugLineNum = 50;BA.debugLine="End Sub";
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
public static RemoteObject  _clear_field() throws Exception{
try {
		Debug.PushSubsStack("clear_field (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,98);
if (RapidSub.canDelegate("clear_field")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","clear_field");
int _i = 0;
 BA.debugLineNum = 98;BA.debugLine="Sub clear_field()";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="Try";
Debug.ShouldStop(4);
try { BA.debugLineNum = 100;BA.debugLine="For i = 1 To 30";
Debug.ShouldStop(8);
{
final int step2 = 1;
final int limit2 = 30;
for (_i = 1 ; (step2 > 0 && _i <= limit2) || (step2 < 0 && _i >= limit2); _i = ((int)(0 + _i + step2)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 101;BA.debugLine="StateManager.SetSetting(\"keytext\" & i,\"\")";
Debug.ShouldStop(16);
sel_dev.mostCurrent._statemanager.runVoidMethod ("_setsetting",sel_dev.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytext"),RemoteObject.createImmutable(_i))),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 102;BA.debugLine="StateManager.SetSetting(\"keytag\" & i,\"\" )";
Debug.ShouldStop(32);
sel_dev.mostCurrent._statemanager.runVoidMethod ("_setsetting",sel_dev.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keytag"),RemoteObject.createImmutable(_i))),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 103;BA.debugLine="StateManager.SetSetting(\"keylock\" & i, False)";
Debug.ShouldStop(64);
sel_dev.mostCurrent._statemanager.runVoidMethod ("_setsetting",sel_dev.mostCurrent.activityBA,(Object)(RemoteObject.concat(RemoteObject.createImmutable("keylock"),RemoteObject.createImmutable(_i))),(Object)(BA.ObjectToString(sel_dev.mostCurrent.__c.getField(true,"False"))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 105;BA.debugLine="StateManager.SetSetting(\"font_size\", \"\")";
Debug.ShouldStop(256);
sel_dev.mostCurrent._statemanager.runVoidMethod ("_setsetting",sel_dev.mostCurrent.activityBA,(Object)(BA.ObjectToString("font_size")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 106;BA.debugLine="StateManager.SetSetting(\"h_size\", \"\")";
Debug.ShouldStop(512);
sel_dev.mostCurrent._statemanager.runVoidMethod ("_setsetting",sel_dev.mostCurrent.activityBA,(Object)(BA.ObjectToString("h_size")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 107;BA.debugLine="StateManager.SetSetting(\"v_size\", \"\")";
Debug.ShouldStop(1024);
sel_dev.mostCurrent._statemanager.runVoidMethod ("_setsetting",sel_dev.mostCurrent.activityBA,(Object)(BA.ObjectToString("v_size")),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 108;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(2048);
sel_dev.mostCurrent._statemanager.runVoidMethod ("_savesettings",sel_dev.mostCurrent.activityBA);
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e90) {
			BA.rdebugUtils.runVoidMethod("setLastException",sel_dev.processBA, e90.toString()); BA.debugLineNum = 110;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(8192);
_proces_error(sel_dev.mostCurrent.__c.runMethod(false,"LastException",sel_dev.mostCurrent.activityBA).runMethod(true,"getMessage"));
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
public static RemoteObject  _dev_list_itemclick(RemoteObject _position,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("dev_list_ItemClick (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,28);
if (RapidSub.canDelegate("dev_list_itemclick")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","dev_list_itemclick", _position, _value);
Debug.locals.put("Position", _position);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 28;BA.debugLine="Sub dev_list_ItemClick (Position As Int, Value As";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 29;BA.debugLine="Try";
Debug.ShouldStop(268435456);
try { BA.debugLineNum = 30;BA.debugLine="StateManager.SetSetting(\"cur_dev_name\",dev_list.G";
Debug.ShouldStop(536870912);
sel_dev.mostCurrent._statemanager.runVoidMethod ("_setsetting",sel_dev.mostCurrent.activityBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(BA.ObjectToString(sel_dev.mostCurrent._dev_list.runMethod(false,"GetItem",(Object)(_position)))));
 BA.debugLineNum = 31;BA.debugLine="load_keys";
Debug.ShouldStop(1073741824);
_load_keys();
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e20) {
			BA.rdebugUtils.runVoidMethod("setLastException",sel_dev.processBA, e20.toString()); BA.debugLineNum = 33;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(1);
_proces_error(sel_dev.mostCurrent.__c.runMethod(false,"LastException",sel_dev.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 35;BA.debugLine="End Sub";
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
public static RemoteObject  _finish_him() throws Exception{
try {
		Debug.PushSubsStack("finish_him (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,114);
if (RapidSub.canDelegate("finish_him")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","finish_him");
 BA.debugLineNum = 114;BA.debugLine="Sub finish_him()";
Debug.ShouldStop(131072);
 BA.debugLineNum = 115;BA.debugLine="CallSubDelayed(Main,\"add_key_to_panel\")";
Debug.ShouldStop(262144);
sel_dev.mostCurrent.__c.runVoidMethod ("CallSubDelayed",sel_dev.mostCurrent.activityBA,(Object)((sel_dev.mostCurrent._main.getObject())),(Object)(RemoteObject.createImmutable("add_key_to_panel")));
 BA.debugLineNum = 116;BA.debugLine="Activity.Finish";
Debug.ShouldStop(524288);
sel_dev.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 118;BA.debugLine="End Sub";
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
public static RemoteObject  _get_key(RemoteObject _ind) throws Exception{
try {
		Debug.PushSubsStack("get_key (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,75);
if (RapidSub.canDelegate("get_key")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","get_key", _ind);
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
Debug.locals.put("ind", _ind);
 BA.debugLineNum = 75;BA.debugLine="Sub get_key(ind As Int)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 76;BA.debugLine="Try";
Debug.ShouldStop(2048);
try { BA.debugLineNum = 77;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(4096);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 78;BA.debugLine="Data.Initialize";
Debug.ShouldStop(8192);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 79;BA.debugLine="Data.Put (\"getkey\",ind)";
Debug.ShouldStop(16384);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("getkey"))),(Object)((_ind)));
 BA.debugLineNum = 80;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(32768);
sel_dev.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",sel_dev.mostCurrent.activityBA,(Object)((sel_dev.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e64) {
			BA.rdebugUtils.runVoidMethod("setLastException",sel_dev.processBA, e64.toString()); BA.debugLineNum = 82;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(131072);
_proces_error(sel_dev.mostCurrent.__c.runMethod(false,"LastException",sel_dev.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 84;BA.debugLine="End Sub";
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
public static RemoteObject  _get_key_info() throws Exception{
try {
		Debug.PushSubsStack("get_key_info (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,86);
if (RapidSub.canDelegate("get_key_info")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","get_key_info");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 86;BA.debugLine="Sub get_key_info()";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 87;BA.debugLine="Try";
Debug.ShouldStop(4194304);
try { BA.debugLineNum = 88;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(8388608);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 89;BA.debugLine="Data.Initialize";
Debug.ShouldStop(16777216);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 90;BA.debugLine="Data.Put (\"dev_name\",StateManager.GetSetting2(\"cu";
Debug.ShouldStop(33554432);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("dev_name"))),(Object)((sel_dev.mostCurrent._statemanager.runMethod(true,"_getsetting2",sel_dev.mostCurrent.activityBA,(Object)(BA.ObjectToString("cur_dev_name")),(Object)(RemoteObject.createImmutable("none"))))));
 BA.debugLineNum = 91;BA.debugLine="Data.Put (\"getkey_info\",1)";
Debug.ShouldStop(67108864);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("getkey_info"))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 92;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(134217728);
sel_dev.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",sel_dev.mostCurrent.activityBA,(Object)((sel_dev.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e75) {
			BA.rdebugUtils.runVoidMethod("setLastException",sel_dev.processBA, e75.toString()); BA.debugLineNum = 94;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(536870912);
_proces_error(sel_dev.mostCurrent.__c.runMethod(false,"LastException",sel_dev.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 96;BA.debugLine="End Sub";
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
public static RemoteObject  _get_name() throws Exception{
try {
		Debug.PushSubsStack("get_name (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,37);
if (RapidSub.canDelegate("get_name")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","get_name");
RemoteObject _data = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
 BA.debugLineNum = 37;BA.debugLine="Sub get_name()";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="Try";
Debug.ShouldStop(32);
try { BA.debugLineNum = 39;BA.debugLine="Dim Data As Map";
Debug.ShouldStop(64);
_data = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Data", _data);
 BA.debugLineNum = 40;BA.debugLine="Data.Initialize";
Debug.ShouldStop(128);
_data.runVoidMethod ("Initialize");
 BA.debugLineNum = 41;BA.debugLine="Data.Put (\"getname\",1)";
Debug.ShouldStop(256);
_data.runVoidMethod ("Put",(Object)(RemoteObject.createImmutable(("getname"))),(Object)(RemoteObject.createImmutable((1))));
 BA.debugLineNum = 42;BA.debugLine="CallSubDelayed2(Starter,\"send_to_dev\",Data)";
Debug.ShouldStop(512);
sel_dev.mostCurrent.__c.runVoidMethod ("CallSubDelayed2",sel_dev.mostCurrent.activityBA,(Object)((sel_dev.mostCurrent._starter.getObject())),(Object)(BA.ObjectToString("send_to_dev")),(Object)((_data)));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e30) {
			BA.rdebugUtils.runVoidMethod("setLastException",sel_dev.processBA, e30.toString()); BA.debugLineNum = 44;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(2048);
_proces_error(sel_dev.mostCurrent.__c.runMethod(false,"LastException",sel_dev.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 46;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 10;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 11;BA.debugLine="Public dev_list As ListView";
sel_dev.mostCurrent._dev_list = RemoteObject.createNew ("anywheresoftware.b4a.objects.ListViewWrapper");
 //BA.debugLineNum = 12;BA.debugLine="Dim key_n As Int =0";
sel_dev._key_n = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _load_keys() throws Exception{
try {
		Debug.PushSubsStack("load_keys (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,53);
if (RapidSub.canDelegate("load_keys")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","load_keys");
 BA.debugLineNum = 53;BA.debugLine="Sub load_keys()";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="Try";
Debug.ShouldStop(2097152);
try { BA.debugLineNum = 55;BA.debugLine="ToastMessageShow(\"Loading data...\",True)";
Debug.ShouldStop(4194304);
sel_dev.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("Loading data...")),(Object)(sel_dev.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 56;BA.debugLine="clear_field";
Debug.ShouldStop(8388608);
_clear_field();
 BA.debugLineNum = 57;BA.debugLine="get_key_info";
Debug.ShouldStop(16777216);
_get_key_info();
 BA.debugLineNum = 58;BA.debugLine="key_n=0";
Debug.ShouldStop(33554432);
sel_dev._key_n = BA.numberCast(int.class, 0);
 BA.debugLineNum = 59;BA.debugLine="mgetbut_tmr.Initialize(\"mgetbut_tmr\", 210)";
Debug.ShouldStop(67108864);
sel_dev._mgetbut_tmr.runVoidMethod ("Initialize",sel_dev.processBA,(Object)(BA.ObjectToString("mgetbut_tmr")),(Object)(BA.numberCast(long.class, 210)));
 BA.debugLineNum = 60;BA.debugLine="mgetbut_tmr.Enabled =True";
Debug.ShouldStop(134217728);
sel_dev._mgetbut_tmr.runMethod(true,"setEnabled",sel_dev.mostCurrent.__c.getField(true,"True"));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e45) {
			BA.rdebugUtils.runVoidMethod("setLastException",sel_dev.processBA, e45.toString()); BA.debugLineNum = 62;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(536870912);
_proces_error(sel_dev.mostCurrent.__c.runMethod(false,"LastException",sel_dev.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
 BA.debugLineNum = 64;BA.debugLine="End Sub";
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
public static RemoteObject  _mgetbut_tmr_tick() throws Exception{
try {
		Debug.PushSubsStack("mgetbut_tmr_Tick (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,65);
if (RapidSub.canDelegate("mgetbut_tmr_tick")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","mgetbut_tmr_tick");
 BA.debugLineNum = 65;BA.debugLine="Sub mgetbut_tmr_Tick()";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="Try";
Debug.ShouldStop(2);
try { BA.debugLineNum = 67;BA.debugLine="key_n=key_n+1";
Debug.ShouldStop(4);
sel_dev._key_n = RemoteObject.solve(new RemoteObject[] {sel_dev._key_n,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 68;BA.debugLine="get_key(key_n)";
Debug.ShouldStop(8);
_get_key(sel_dev._key_n);
 BA.debugLineNum = 69;BA.debugLine="If key_n=30 Then mgetbut_tmr.Enabled =False";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",sel_dev._key_n,BA.numberCast(double.class, 30))) { 
sel_dev._mgetbut_tmr.runMethod(true,"setEnabled",sel_dev.mostCurrent.__c.getField(true,"False"));};
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e54) {
			BA.rdebugUtils.runVoidMethod("setLastException",sel_dev.processBA, e54.toString()); BA.debugLineNum = 71;BA.debugLine="proces_error(LastException.Message)";
Debug.ShouldStop(64);
_proces_error(sel_dev.mostCurrent.__c.runMethod(false,"LastException",sel_dev.mostCurrent.activityBA).runMethod(true,"getMessage"));
 };
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
public static RemoteObject  _proces_error(RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("proces_error (sel_dev) ","sel_dev",3,sel_dev.mostCurrent.activityBA,sel_dev.mostCurrent,121);
if (RapidSub.canDelegate("proces_error")) return sel_dev.remoteMe.runUserSub(false, "sel_dev","proces_error", _msg);
Debug.locals.put("msg", _msg);
 BA.debugLineNum = 121;BA.debugLine="Sub proces_error(msg As String)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 122;BA.debugLine="Msgbox(msg,\"error\")";
Debug.ShouldStop(33554432);
sel_dev.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(_msg),(Object)(RemoteObject.createImmutable("error")),sel_dev.mostCurrent.activityBA);
 BA.debugLineNum = 123;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 7;BA.debugLine="Public  mgetbut_tmr As Timer";
sel_dev._mgetbut_tmr = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}