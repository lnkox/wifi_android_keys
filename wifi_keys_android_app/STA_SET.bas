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
End Sub

Sub Globals

	Private sta_pass_txt As EditText
	Private sta_ssid_txt As EditText
	Private Label1 As Label
	Private Label2 As Label
	Private save_sta_set_btn As Button
	Private sta_mode_chk As CheckBox
	Private batt_dev_txt As EditText
	Private Label3 As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
Try
	Activity.LoadLayout("sta_set")
	clear_field
	Activity.Title ="WFclient setup - " & StateManager.GetSetting2("cur_dev_name","none")
	get_staset
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub save_sta_set_btn_Click
Try
	Dim Data As Map
	Data.Initialize
	Data.Put ("ssid_sta",sta_ssid_txt.Text)
	Data.Put ("pass_sta",sta_pass_txt.Text)
	Data.Put ("batt_dev",batt_dev_txt.Text)
	Data.Put ("mode_sta",sta_mode_chk.Checked)
	Data.Put ("save_info",2)
	CallSubDelayed2(Starter,"send_to_dev",Data)
	StateManager.SetSetting("batt_dev", CM.toint(batt_dev_txt.Text) )
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub clear_field()
Try
 sta_ssid_txt.Text="no connect"
 sta_pass_txt.Text="no connect"
 sta_mode_chk.Checked=False	
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub get_staset()
Try	
	Dim Data As Map
	Data.Initialize
	Data.Put ("getstaset",1)
	CallSubDelayed2(Starter,"send_to_dev",Data)
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub set_sta_set (mapar As Map)
Try
	If mapar.ContainsKey("ssid_sta")=True Then  sta_ssid_txt.Text=mapar.Get ("ssid_sta") 
	If mapar.ContainsKey("pass_sta")=True Then  sta_pass_txt.Text=mapar.Get ("pass_sta")
	If mapar.ContainsKey("batt_dev")=True Then  batt_dev_txt.Text=mapar.Get ("batt_dev")  
	If mapar.ContainsKey("mode_sta")=True Then  sta_mode_chk.Checked=CM.obj2Bool(mapar.Get("mode_sta") )
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub finish_him()
	Activity.Finish
End Sub

Sub proces_error(msg As String)
	Msgbox(msg,"error")
End Sub