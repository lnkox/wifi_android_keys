Type=Activity
Version=5.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	Public  mgetbut_tmr As Timer
End Sub

Sub Globals
	Public dev_list As ListView
	Dim key_n As Int =0 
End Sub

Sub Activity_Create(FirstTime As Boolean)
Activity.LoadLayout("sel_dev_lay")
get_name
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub dev_list_ItemClick (Position As Int, Value As Object)
Try
	StateManager.SetSetting("cur_dev_name",dev_list.GetItem(Position))
	load_keys
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub get_name()
Try
	Dim Data As Map
	Data.Initialize
	Data.Put ("getname",1)
	CallSubDelayed2(Starter,"send_to_dev",Data)
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub add_dev_tolist(dev_name As String,dev_ip As String)
	dev_list.AddTwoLines(dev_name,dev_ip) 
End Sub


Sub load_keys()
Try
	ToastMessageShow("Loading data...",True)
	clear_field
	get_key_info
	key_n=0
	mgetbut_tmr.Initialize("mgetbut_tmr", 210)
	mgetbut_tmr.Enabled =True
Catch
  proces_error(LastException.Message)
End Try
End Sub
Sub mgetbut_tmr_Tick()
Try
	key_n=key_n+1
	get_key(key_n)
	If key_n=30 Then mgetbut_tmr.Enabled =False
Catch
  proces_error(LastException.Message)
End Try	
End Sub

Sub get_key(ind As Int)
Try	
	Dim Data As Map
	Data.Initialize
	Data.Put ("getkey",ind)
	CallSubDelayed2(Starter,"send_to_dev",Data)
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub get_key_info()
Try
	Dim Data As Map
	Data.Initialize
	Data.Put ("dev_name",StateManager.GetSetting2("cur_dev_name","none"))
	Data.Put ("getkey_info",1)
	CallSubDelayed2(Starter,"send_to_dev",Data)
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub clear_field()
Try
	For i = 1 To 30
		StateManager.SetSetting("keytext" & i,"")
		StateManager.SetSetting("keytag" & i,"" )
		StateManager.SetSetting("keylock" & i, False)
	Next
	StateManager.SetSetting("font_size", "")
	StateManager.SetSetting("h_size", "")
	StateManager.SetSetting("v_size", "")
	StateManager.SaveSettings
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub finish_him()
	CallSubDelayed(Main,"add_key_to_panel") 
	Activity.Finish
	
End Sub


Sub proces_error(msg As String)
	Msgbox(msg,"error")
End Sub