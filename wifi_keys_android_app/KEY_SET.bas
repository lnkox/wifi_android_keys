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

	Public key_set_load As Boolean
End Sub

Sub Globals
	Public  setbut_tmr As Timer
	Private scview As ScrollView
	Dim chk(33) As CheckBox
	Dim lab(33) As Label
	Dim txt(33) As EditText
	Dim font_size As EditText
	Dim lfont_size As Label
	Dim v_size As EditText
	Dim lv_size As Label
	Dim h_size As EditText
	Dim lh_size As Label
	Dim save_ks_but As Button 
	Dim key_n As Int =0 
End Sub

Sub Activity_Create(FirstTime As Boolean)
Try
	Activity.LoadLayout("key_set_lay")
	lfont_size.Initialize("lfont_size")
	scview.Panel.AddView(lfont_size, 5dip, 10dip, 60dip, 40dip)
	lfont_size.Text ="Font:"
	lfont_size.TextSize ="14"
	font_size.Initialize("font_size")
	font_size.InputType = font_size.INPUT_TYPE_NUMBERS
	scview.Panel.AddView(font_size, 40dip ,0dip, 50dip, 40dip)
	font_size.SingleLine=True
	font_size.Text ="14"
	lh_size.Initialize("lh_size")
	scview.Panel.AddView(lh_size, 120dip, 10dip, 40dip, 40dip)
	lh_size.Text ="Horiz:"
	h_size.Initialize("h_size")
	h_size.InputType = h_size.INPUT_TYPE_NUMBERS
	scview.Panel.AddView(h_size, 160dip ,0dip, 40dip, 40dip)
	h_size.SingleLine=True
	lv_size.Initialize("lv_size")
	scview.Panel.AddView(lv_size, 210dip, 10dip, 40dip, 40dip)
	lv_size.Text ="Vert:"
	v_size.Initialize("h_size")
	v_size.InputType = v_size.INPUT_TYPE_NUMBERS
	scview.Panel.AddView(v_size, 240dip ,0dip, 40dip, 40dip)
	v_size.SingleLine=True

	For i = 1 To 30
        Dim tchk As CheckBox
		Dim tlab As Label
		Dim ttxt As EditText
		tchk.Initialize("CheckBox")
		tlab.Initialize("label")
		ttxt.Initialize("edittext")
        scview.Panel.AddView(tlab, 0, i*40dip+10dip, 20dip, 40dip) 
  		scview.Panel.AddView(tchk, 15dip, i*40dip, 30dip, 40dip) 
		scview.Panel.AddView(ttxt, 45dip, i*40dip, Activity.Width-50dip, 40dip) 
        tlab.Tag=i:tchk.Tag=i:ttxt.Tag=i:
		tlab.Text=i
		ttxt.SingleLine=True
        lab(i)=tlab
      	chk(i)=tchk
		txt(i)=ttxt
    Next
	save_ks_but.Initialize("save_ks_but")
	save_ks_but.Text ="Save"
	scview.Panel.AddView(save_ks_but, 10dip ,1260dip, Activity.Width-20dip, 40dip)
	scview.Panel.Height =1340dip
	Activity.Title ="Keys setup - " & StateManager.GetSetting2("cur_dev_name","none")
	get_key_data
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub Activity_Resume

End Sub


Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub get_key_data() 'заповнення полів налаштування кнопок
Try

	v_size.Text=StateManager.GetSetting2("v_size","")
	h_size.Text=StateManager.GetSetting2("h_size","")
	font_size.Text=StateManager.GetSetting2("font_size","")
	For a=1 To 30
		chk(a).Checked=CM.obj2Bool(StateManager.GetSetting2("keylock" & a,0))
		txt(a).Text =StateManager.GetSetting2("keytext" & a,"")
	Next
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub save_ks_but_Click
Try
	ToastMessageShow("Saving....",True)
	key_n=0
	setbut_tmr.Initialize("setbut_tmr", 100)
	setbut_tmr.Enabled =True
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub setbut_tmr_Tick()
Try
	key_n=key_n+1
	If key_n>=32 Then 
		set_key_info
		setbut_tmr.Enabled =False
		Return
	End If
	set_key(key_n)
Catch
  proces_error(LastException.Message)
End Try	
End Sub

Sub set_key(ind As Int)
Try
	Dim Data As Map
	Data.Initialize
	Data.Put ("setkey",ind)
	Data.Put ("name",txt(ind).Text)
	Data.Put ("lock",chk(ind).Checked)
	CallSubDelayed2(Starter,"send_to_dev",Data)
Catch
  proces_error(LastException.Message)
End Try
End Sub
Sub set_key_info()
Try
	Dim Data As Map
	Data.Initialize
	Data.Put ("font_size",font_size.Text)
	Data.Put ("h_size",h_size.Text)
	Data.Put ("v_size",v_size.Text)
	Data.Put ("save_info",3)
	CallSubDelayed2(Starter,"send_to_dev",Data)	
Catch
  proces_error(LastException.Message)
End Try
End Sub




Sub set_key_set (mapar As Map)
Try
		txt(mapar.Get ("key_id")).Text = mapar.Get ("name")
		chk(mapar.Get ("key_id")).Checked = CM.obj2Bool( mapar.Get ("lock"))
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub set_keyinfo_set (mapar As Map)
Try
	If mapar.ContainsKey("font_size")=True Then  font_size.Text=mapar.Get ("font_size") 
	If mapar.ContainsKey("h_size")=True Then  h_size.Text=mapar.Get ("h_size") 
	If mapar.ContainsKey("v_size")=True Then  v_size.Text=mapar.Get ("v_size") 
Catch
  proces_error(LastException.Message)
End Try
End Sub


Sub finish_him()
Try
	CallSubDelayed(Main,"load_keys")
	Activity.Finish
Catch
  proces_error(LastException.Message)
End Try
End Sub

Sub proces_error(msg As String)
	Msgbox(msg,"error")
End Sub