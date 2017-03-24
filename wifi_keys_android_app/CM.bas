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
	Public vert_size As Int
	Public horiz_size As Int
	Public font_size As Int
End Sub

Sub obj2Bool(value As Object) As Boolean
    If value = Null Then Return False
	If value=0 Then Return False
	If value=False Then Return False
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