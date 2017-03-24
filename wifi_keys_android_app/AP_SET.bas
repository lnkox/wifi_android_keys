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
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

End Sub

Sub Globals
	Private ap_pass_txt As EditText
	Private ap_ssid_txt As EditText
	Private hide_ssid_chk As CheckBox
	Private Label1 As Label
	Private Label2 As Label
	Private save_ap_set_btn As Button
	Private ap_mode_chk As CheckBox
End Sub

Sub Activity_Create(FirstTime As Boolean)
Try
	Activity.LoadLayout("ap_set")
	 clear_field
	 Activity.Title ="AP setup - " & StateManager.GetSetting2("cur_dev_name","none")
	 get_apset
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub save_ap_set_btn_Click
Try
	Dim Data As Map
	Data.Initialize
	Data.Put ("ssid_ap",ap_ssid_txt.Text)
	Data.Put ("pass_ap",ap_pass_txt.Text)
	Data.Put ("hide_ssid",hide_ssid_chk.Checked)
	Data.Put ("mode_ap",ap_mode_chk.Checked)
	Data.Put ("save_info",1)
	CallSubDelayed2(Starter,"send_to_dev",Data)
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub clear_field()
Try
 ap_ssid_txt.Text="no connect"
 ap_pass_txt.Text="no connect"
 hide_ssid_chk.Checked =False
 ap_mode_chk.Checked=False	
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub get_apset()
Try
	Dim Data As Map
	Data.Initialize
	Data.Put ("getapset",1)
	CallSubDelayed2(Starter,"send_to_dev",Data)
Catch
  proces_error(LastException.Message)
End Try
End Sub


Sub set_ap_set (mapar As Map)
Try
	If mapar.ContainsKey("ssid_ap")=True Then  ap_ssid_txt.Text=mapar.Get ("ssid_ap") 
	If mapar.ContainsKey("pass_ap")=True Then  ap_pass_txt.Text=mapar.Get ("pass_ap") 
	If mapar.ContainsKey("hide_ssid")=True Then  hide_ssid_chk.Checked=CM.obj2Bool(mapar.Get ("hide_ssid") )
	If mapar.ContainsKey("mode_ap")=True Then  ap_mode_chk.Checked=CM.obj2Bool(mapar.Get("mode_ap") )
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