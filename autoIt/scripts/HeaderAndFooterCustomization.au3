Func _WinWaitActivate($title,$text,$timeout=0)
	WinWait($title,$text,$timeout)
	If Not WinActive($title,$text) Then WinActivate($title,$text)
	WinWaitActive($title,$text,$timeout)
EndFunc

_WinWaitActivate("Focus-Ledger - Google Chrome","")
Sleep(2000)
MouseClick("left",986,397,1)
Sleep(2000)
MouseMove(974,459)
Sleep(2000)
MouseDown("left")
Sleep(2000)
MouseMove(425,476)
Sleep(2000)
MouseUp("left")
Sleep(2000)


