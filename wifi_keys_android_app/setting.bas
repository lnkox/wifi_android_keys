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
	   Public Socket1 As Socket 
	Dim InputStream1 As InputStream
	Dim OutputStream1 As OutputStream
   
   Public timerListener As Timer
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

 
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private dev_list As Spinner
	Private scv As ScrollView
	Dim chk(33) As CheckBox
	Dim lab(33) As Label
	Dim txt(33) As EditText
	Dim ssid As EditText
	Dim pass As EditText
	Dim lssid As Label
	Dim lpass As Label
	Dim ip0 As EditText
	Dim ip1 As EditText
	Dim ip2 As EditText
	Dim ip3 As EditText
	Dim lip As Label
	Dim stmode As CheckBox
	Dim lstmode As Label
	Dim font_size As EditText
	Dim lfont_size As Label
	
	
	Private add_dev_btn As Button
	Private add_dev_panel As Panel
	Private ip0_txt As EditText
	Private ip1_txt As EditText
	Private ip2_txt As EditText
	Private ip3_txt As EditText
	Private Label1 As Label
	Private exit_add As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
   Activity.LoadLayout("set_lay")
   lssid.Initialize("lssid")
   scv.Panel.AddView(lssid, 0, 10dip, 60dip, 40dip)
   lssid.Text ="SSID:"
   ssid.Initialize("ssid")
   scv.Panel.AddView(ssid, 50dip ,0dip, Activity.Width-60dip, 40dip)
   ssid.SingleLine=True
   lpass.Initialize("lpass")
   scv.Panel.AddView(lpass, 0, 50dip, 60dip, 40dip)
   lpass.Text ="Pass:"
   pass.Initialize("pass")
   scv.Panel.AddView(pass, 50dip ,40dip, Activity.Width-60dip, 40dip)   
   pass.SingleLine=True
	lip.Initialize("lip")
   scv.Panel.AddView(lip, 0, 90dip, 60dip, 40dip)
   lip.Text ="IP:"
   ip0.Initialize("ip0")
   scv.Panel.AddView(ip0, 50dip ,80dip, 60dip, 40dip)  
   ip0.SingleLine=True 
   ip0.TextSize=14
   ip0.InputType = ip0.INPUT_TYPE_NUMBERS
   ip1.Initialize("ip1")
   scv.Panel.AddView(ip1, 110dip ,80dip, 60dip, 40dip)  
   ip1.SingleLine=True 
   ip1.TextSize=14
   ip1.InputType = ip1.INPUT_TYPE_NUMBERS
   ip2.Initialize("ip2")
   scv.Panel.AddView(ip2, 170dip ,80dip, 60dip, 40dip)  
   ip2.SingleLine=True 
   ip2.TextSize=14
   ip2.InputType = ip2.INPUT_TYPE_NUMBERS
   ip3.Initialize("ip3")
   scv.Panel.AddView(ip3, 230dip ,80dip, 60dip, 40dip)  
   ip3.SingleLine=True 
   ip3.TextSize=14
   ip3.InputType = ip3.INPUT_TYPE_NUMBERS
   lstmode.Initialize("lstmode")
   scv.Panel.AddView(lstmode, 0dip ,130dip, 60dip, 40dip)  
   lstmode.Text ="STA:"
   stmode.Initialize("stmode")
   scv.Panel.AddView(stmode, 40dip ,120dip, 60dip, 40dip) 
   lfont_size.Initialize("lfont_size")
   scv.Panel.AddView(lfont_size, 0, 170dip, 60dip, 40dip)
   lfont_size.Text ="Font:"
   font_size.Initialize("font_size")
   font_size.InputType = font_size.INPUT_TYPE_NUMBERS
   scv.Panel.AddView(font_size, 50dip ,160dip, 60dip, 40dip)
   font_size.SingleLine=True
   font_size.Text ="14"
    For i = 1 To 32
        Dim tchk As CheckBox
		Dim tlab As Label
		Dim ttxt As EditText
		tchk.Initialize("checkbox")
		tlab.Initialize("label")
		ttxt.Initialize("edittext")
        scv.Panel.AddView(tlab, 0, i*40dip+170dip, 20dip, 40dip) 
  		scv.Panel.AddView(tchk, 15dip, i*40dip+160dip, 30dip, 40dip) 
		scv.Panel.AddView(ttxt, 35dip, i*40dip+160dip, Activity.Width-40dip, 40dip) 
        tlab.Tag=i:tchk.Tag=i:ttxt.Tag=i:
		tlab.Text=i
		ttxt.SingleLine=True
        lab(i)=tlab
      	chk(i)=tchk
		txt(i)=ttxt
    Next
 
   dev_list.Left =0dip
   dev_list.Top =0dip
   dev_list.Width =Activity.Width
   dev_list.Height =50dip
   scv.Left =0
   scv.Top=50dip
   scv.Width =Activity.Width
   scv.Height =Activity.Height-50dip
  
   Activity.AddMenuItem("Додати пристрій","add_dev")
	Activity.AddMenuItem("Видалити пристрій","del_dev")
	Activity.AddMenuItem("Зберегти налаштування","save_set")
	Activity.AddMenuItem("Перезавантажити пристрій","reset_dev")	
	StateManager.RestoreState (Activity, "Main", 60) 
	timerListener.Initialize("timerListener", 1)
	load_dev_list


End Sub


Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)
	If UserClosed Then
		StateManager.ResetState("Main")
	Else
		StateManager.SaveState(Activity, "Main")
	End If
	StateManager.SaveSettings
End Sub

Sub timerListener_Tick

    Dim cv As ByteConverter 
	Dim fd,sd As Int
	Dim ttxt As String
  If InputStream1.BytesAvailable > 0 Then
    Dim buffer(InputStream1.BytesAvailable) As Byte
    InputStream1.ReadBytes(buffer, 0,InputStream1.BytesAvailable)
    Dim result As String = cv.StringFromBytes(buffer, "UTF8")
	result=result.Replace(Chr(0),"")
	result=result.Replace("}{",",")
	Msgbox (result,"1")
	Dim JSON As JSONParser
	Dim Map1 As Map
	JSON.Initialize(result)
	Map1 = JSON.NextObject
	If Map1.ContainsKey("ssid")=True Then ssid.Text =Map1.Get ("ssid")
	If Map1.ContainsKey("pass")=True Then pass.Text =Map1.Get ("pass")
	If Map1.ContainsKey("ip0")=True Then ip0.Text =Map1.Get ("ip0")
	If Map1.ContainsKey("ip1")=True Then ip1.Text =Map1.Get ("ip1")
	If Map1.ContainsKey("ip2")=True Then ip2.Text =Map1.Get ("ip2")
	If Map1.ContainsKey("ip3")=True Then ip3.Text =Map1.Get ("ip3")
	If Map1.ContainsKey("stmode")=True Then stmode.Checked =obj2Bool(Map1.Get("stmode"))
	If Map1.ContainsKey("fnts")=True Then font_size.Text =Map1.Get ("fnts")
	For a=1 To 32
		fd=a/10
		sd=a-fd*10
		If Map1.ContainsKey("but" & fd & sd)=True Then	
			ttxt=Map1.Get ("but" & fd & sd)
			txt(a).Text=ttxt.SubString(1)
			chk(a).Checked =obj2Bool(ttxt.SubString2(0,1))
		End If
	Next
  End If
End Sub
Sub clear_field()
	ssid.Text ="":pass.Text ="":ip0.Text =0:ip1.Text =0:ip2.Text =0:ip3.Text =0
	stmode.Checked =False
	font_size.Text =0
End Sub
Sub obj2Bool(value As Object) As Boolean
    If value = Null Then Return False
	If value=0 Then Return False
    Return True
End Sub
Sub save_dev_list()
	Dim tmplst As String
	For a=0 To dev_list.Size-1 
		tmplst=tmplst & dev_list.GetItem (a) & ";"
	Next
	StateManager.SetSetting("dev_list",tmplst)
	StateManager.SaveSettings
End Sub
Sub load_dev_list()
	Dim tmplst As String
	Dim tmpind As Int
	dev_list.Clear
	tmplst=StateManager.GetSetting2 ("dev_list","192.168.0.22;")
	Do While(tmplst.Length >5)
		tmpind=tmplst.IndexOf(";")	
		If tmpind<1 Then Return
		dev_list.Add (tmplst.SubString2(0,tmpind))
		tmplst=tmplst.SubString(tmpind+1)
	Loop
End Sub

Sub connect_to_dev(dev_ip As String)
	clear_field
	ToastMessageShow("З`єднання з " & dev_ip,False)
	Socket1.Close
	Socket1.Initialize("Socket1")
   	Socket1.Connect(dev_ip,80,3000)
End Sub

Sub Socket1_Connected(Connected As Boolean)As Boolean 
If Connected = True Then
	InputStream1 =Socket1.InputStream
	OutputStream1=Socket1.OutputStream
	ToastMessageShow("З`єднанно",False) 
	load_dev_info
	Return True
Else
	Msgbox ("Пристрій не доступний","Помилка")
	Return False
End If
End Sub

Sub load_dev_info()
Dim Buffer() As Byte 
Dim Data As Map
Dim msg As String 

Dim JSONGenerator As JSONGenerator
timerListener.Enabled = True
Data.Initialize
Data.Put ("info",1)
JSONGenerator.Initialize(Data)
msg = JSONGenerator.ToString  
Buffer = msg.GetBytes("UTF8")
OutputStream1.WriteBytes(Buffer,0,Buffer.Length)

End Sub
Sub get_btn_info(indbut As Int)
	Dim Buffer() As Byte 
	Dim Data As Map
	Dim msg As String 
	Dim JSONGenerator As JSONGenerator
	timerListener.Enabled = True
	Data.Initialize
	Data.Put ("butn",1)
	Data.Put ("indbut",indbut)
	JSONGenerator.Initialize(Data)
	msg = JSONGenerator.ToString  
	Buffer = msg.GetBytes("UTF8")
	OutputStream1.WriteBytes(Buffer,0,Buffer.Length)	
End Sub
Sub dev_list_ItemClick (Position As Int, Value As Object)
	connect_to_dev(Value)	
End Sub

Sub button_Click()
    Dim p As Button
    p = Sender
    Msgbox (p.Tag,"jj") 
End Sub

Sub add_dev_Click()
	add_dev_panel.Visible =True
End Sub

Sub del_dev_Click()
	If Msgbox2("Ви дійсно бажаєте видалити пристрій","Видалення пристрою","Видалити","Відміна","",Null)<>-1 Then Return 
	dev_list.RemoveAt (dev_list.SelectedIndex)
	save_dev_list
End Sub

Sub add_dev_btn_Click()
	dev_list.Add (ip0_txt.Text & "." &  ip1_txt.Text &  "." &   ip2_txt.Text &  "." &   ip3_txt.Text )   
	StateManager.SetSetting("hh","ty")
	save_dev_list
	add_dev_panel.Visible =False	
End Sub

Sub exit_add_Click()
	add_dev_panel.Visible =False
End Sub

Sub save_set_click()
	Dim Buffer() As Byte 
	Dim Data As Map
	Dim msg As String 
	Dim JSONGenerator As JSONGenerator
	Data.Initialize
	Data.Put ("ssid",ssid.Text)
	Data.Put ("pass",pass.Text)
	Data.Put ("ip0",ip0.Text)
	Data.Put ("ip1",ip1.Text)
	Data.Put ("ip2",ip2.Text)
	Data.Put ("ip3",ip3.Text)
	Data.Put ("fnts",font_size.Text)
	Data.Put ("stmode",stmode.Checked)
	JSONGenerator.Initialize(Data)
	msg = JSONGenerator.ToString  
	Buffer = msg.GetBytes("UTF8")
	OutputStream1.WriteBytes(Buffer,0,Buffer.Length)	
	save_btn(2)
End Sub
Sub save_btn(indbut As Int)
	Dim Buffer() As Byte 
	Dim Data As Map
	Dim msg As String 
	Dim JSONGenerator As JSONGenerator
	Data.Initialize
	Data.Put ("sbutn",1)
	Data.Put ("indbut",indbut)
	Data.Put ("txt","test text")
	Data.Put ("lock",1)
	JSONGenerator.Initialize(Data)
	msg = JSONGenerator.ToString  
	Buffer = msg.GetBytes("UTF8")
	OutputStream1.WriteBytes(Buffer,0,Buffer.Length)	
End Sub
