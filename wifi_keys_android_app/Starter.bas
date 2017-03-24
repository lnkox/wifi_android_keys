Type=Service
Version=5.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	#ExcludeFromLibrary: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
		Dim UDPSocket As UDPSocket
End Sub

Sub Service_Create
	'This is the program entry point.
	'This is a good place to load resources that are not specific to a single activity.

End Sub

Sub Service_Start (StartingIntent As Intent)
	udp_init ' ініціалізація UDP
End Sub

'Return true to allow the OS default exceptions handler to handle the uncaught exception.
Sub Application_Error (Error As Exception, StackTrace As String) As Boolean
	Return True
End Sub

Sub Service_Destroy

End Sub
'/////////////////////////////////////////////////////////////////////////////////////////////////////
'Мережа
'/////////////////////////////////////////////////////////////////////////////////////////////////////
Sub udp_init() 
Try
	UDPSocket.Initialize("UDP", 1407,255)
Catch
	proces_error(LastException.Message)
End Try	
End Sub

Sub UDP_PacketArrived (Packet As UDPPacket)
Try
    Dim result As String = BytesToString(Packet.Data, Packet.Offset, Packet.Length, "UTF8")
	result=result.Replace(Chr(0),"")
	result=result.Replace("}{",",")
	Dim JSON As JSONParser
	Dim Mapar As Map
	JSON.Initialize(result) 
	Mapar = JSON.NextObject
	If Mapar.ContainsKey("rssi")=True Then   CallSubDelayed2(Main,"set_ris",Mapar)
	If Mapar.ContainsKey("namedev")=True Then CallSubDelayed3(sel_dev,"add_dev_tolist",Mapar.Get ("namedev"),Packet.HostAddress)
	If Mapar.ContainsKey("ssid_ap")=True Then CallSubDelayed2(AP_SET,"set_ap_set",Mapar)
	If Mapar.ContainsKey("ssid_sta")=True Then CallSubDelayed2(STA_SET,"set_sta_set",Mapar)
	If Mapar.ContainsKey("key_id")=True Then set_key_set(Mapar) 
	If Mapar.ContainsKey("font_size")=True Then set_keyinfo_set (Mapar)
	
	If Mapar.ContainsKey("save_ok")=True Then
		 ToastMessageShow ("Saved",False)
		 If (CM.toint (Mapar.Get ("save_ok"))=1) Then
		 	 CallSubDelayed(AP_SET,"finish_him") 
		 End If
		 If (CM.toint (Mapar.Get ("save_ok"))=2) Then
		 	CallSubDelayed(STA_SET,"finish_him") 	
		 End If
		 If (CM.toint (Mapar.Get ("save_ok"))=3) Then
		 	 CallSubDelayed(KEY_SET,"finish_him") 
			 CallSubDelayed(sel_dev,"load_keys") 
		 End If
		 If (CM.toint (Mapar.Get ("save_ok"))=4) Then
		  CallSubDelayed(INET_SET,"finish_him") 
		 End If
	End If
Catch
	proces_error(LastException.Message)

End Try	
End Sub
Sub set_key_set (mapar As Map)
Try
	If CM.toint(mapar.Get ("key_id"))<1 Or CM.toint(mapar.Get ("key_id"))>30 Then Return 
	If CM.toint(mapar.Get ("key_id"))=30 Then
		 ToastMessageShow("Load data complete",False)
		 CallSubDelayed(sel_dev,"finish_him") 
	End If
		StateManager.SetSetting("keytext" & mapar.Get ("key_id"),mapar.Get ("name") )
		If mapar.Get ("name") ="@" Then 
			StateManager.SetSetting("keytag" & mapar.Get ("key_id"),"" )
		Else
			StateManager.SetSetting("keytag" & mapar.Get ("key_id"),mapar.Get ("key_id"))
		End If
		StateManager.SetSetting("keylock" & mapar.Get ("key_id"), CM.obj2Bool(mapar.Get ("lock")))
		StateManager.SaveSettings
Catch
  proces_error(LastException.Message)
End Try		
End Sub
Sub set_keyinfo_set (mapar As Map)
Try
		StateManager.SetSetting("font_size", CM.toint(mapar.Get ("font_size")))
		StateManager.SetSetting("h_size", CM.toint(mapar.Get ("h_size")))
		StateManager.SetSetting("v_size", CM.toint(mapar.Get ("v_size")) )
		StateManager.SaveSettings
Catch
  proces_error(LastException.Message)
End Try
End Sub
Sub send_to_dev(data As Map) As Boolean ' Відправка асоційованого масиву (data) в пристрій у вигляді JSON
Try
	If UDPSocket.IsInitialized =False Then Return False
	Dim Packet As UDPPacket
	Dim Buffer() As Byte 
	Dim msg As String 
	Dim JSONGenerator As JSONGenerator
	data.Put ("dev_name",StateManager.GetSetting2("cur_dev_name","none"))
	JSONGenerator.Initialize(data)
	msg = JSONGenerator.ToString  
	Buffer = msg.GetBytes("UTF8")
    Packet.Initialize(Buffer, "255.255.255.255", "2201")
	UDPSocket.Send(Packet)
	Return True
Catch
	proces_error(LastException.Message)
	 Return False
End Try	
End Sub
Sub proces_error(msg As String)
	Msgbox(msg,"error")
End Sub