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
	Public dev_list As ListView
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
	Activity.Finish
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

Sub proces_error(msg As String)
	Msgbox(msg,"error")
End Sub