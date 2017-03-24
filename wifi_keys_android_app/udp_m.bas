Type=StaticCode
Version=5.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Code module
'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim UDPSock As UDPSocket
End Sub

Sub udp_init() As Boolean
	UDPSock.Initialize("UDP", 2201,255)
	Return UDPSock.IsInitialized
End Sub

Sub UDP_Send(data As String)
	Dim Packet As UDPPacket
    Dim dat() As Byte
    dat = data.GetBytes("UTF8")
    Packet.Initialize(dat, "255.255.255.255", "2202")
    UDPSock.Send(Packet)
End Sub

Sub UDP_PacketArrived (Packet As UDPPacket)
    Dim msg As String
    msg = BytesToString(Packet.Data, Packet.Offset, Packet.Length, "UTF8")
	Msgbox (msg,"udp in")
End Sub