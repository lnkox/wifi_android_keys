Type=StaticCode
Version=5.5
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
Sub Process_Globals
Public bc As ByteConverter
Public connect_type As Boolean
Public myid as String
End Sub

Sub obj2Bool(value As Object) As Boolean
    If value = Null Then Return False
	If value=0 Then Return False
	If value=False Then Return False
	If value="False" Then Return False
	If value="false" Then Return False
    Return True
End Sub

Sub toint(dig As String) As Int
	Dim i As Int
	If IsNumber(dig) Then 
	    i = dig
	Else
	    i = 0  
	End If
	Return i
End Sub
Sub tolong(dig As String) As Int
	Dim i As Long
	If IsNumber(dig) Then 
	    i = dig
	Else
	    i = 0  
	End If
	Return i
End Sub
Sub object_to_byte(obj As Object)As Byte()
    Dim ser As B4XSerializator
    Return ser.ConvertObjectToBytes(obj)
End Sub

Sub byte_to_object(data() As Byte)As Object
    Dim ser As B4XSerializator
    Return ser.ConvertBytesToObject(data)
End Sub