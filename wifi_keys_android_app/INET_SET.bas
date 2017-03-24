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
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private inet_devname_txt As EditText
	Private inet_login_txt As EditText
	Private inet_pass_txt As EditText
	Private inet_port_txt As EditText
	Private inet_server_txt As EditText
	Private Label1 As Label
	Private Label2 As Label
	Private Label3 As Label
	Private Label4 As Label
	Private Label5 As Label
	Private save_ap_set_btn As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
Try
	Activity.LoadLayout("INET_SET")
	Activity.Title ="Inet MQTT set - " & StateManager.GetSetting2("cur_dev_name","none")
	inet_devname_txt.Text=StateManager.GetSetting2("cur_dev_name","none")
	inet_login_txt.Text=StateManager.GetSetting2("inet_login","MQTT login")
	inet_pass_txt.Text=StateManager.GetSetting2("inet_pass","MQTT pass")
	inet_port_txt.Text=StateManager.GetSetting2("inet_port","1234")
	inet_server_txt.Text=StateManager.GetSetting2("inet_server","MQTT server")
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
	StateManager.SetSetting("new_dev_name",inet_devname_txt.Text)
	StateManager.SetSetting("inet_login",inet_login_txt.Text)
	StateManager.SetSetting("inet_pass",inet_pass_txt.Text)
	StateManager.SetSetting("inet_port",inet_port_txt.Text)
	StateManager.SetSetting("inet_server",inet_server_txt.Text)
	Dim Data As Map
	Data.Initialize
	Data.Put ("newdevname",inet_devname_txt.Text)
	Data.Put ("inet_login",inet_login_txt.Text)
	Data.Put ("inet_pass",inet_pass_txt.Text)
	Data.Put ("inet_port",inet_port_txt.Text)
	Data.Put ("inet_server",inet_server_txt.Text)
	Data.Put ("save_info",4)
	CallSubDelayed2(Starter,"send_to_dev",Data)
Catch
  proces_error(LastException.Message)
End Try	
End Sub

Sub proces_error(msg As String)
	Msgbox(msg,"error")
End Sub

Sub finish_him()
	Activity.Finish
End Sub

Sub Label5_LongClick
	
End Sub