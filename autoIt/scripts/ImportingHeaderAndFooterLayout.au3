
Func _WinWaitActivate($title,$text,$timeout=0)
	WinWait($title,$text,$timeout)
	If Not WinActive($title,$text) Then WinActivate($title,$text)
	WinWaitActive($title,$text,$timeout)
EndFunc


_WinWaitActivate("Open","")
Send(@WorkingDir&"\autoIt\ImportFiles\HeaderAndFooterLayout.xml{ENTER}")

