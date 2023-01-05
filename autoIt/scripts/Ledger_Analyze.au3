#region --- Au3Recorder generated code Start (v3.3.9.5 KeyboardLayout=00004009)  ---

#region --- Internal functions Au3Recorder Start ---
Func _Au3RecordSetup()
Opt('WinWaitDelay',100)
Opt('WinDetectHiddenText',1)
Opt('MouseCoordMode',0)
Local $aResult = DllCall('User32.dll', 'int', 'GetKeyboardLayoutNameW', 'wstr', '')
If $aResult[1] <> '00004009' Then
  MsgBox(64, 'Warning', 'Recording has been done under a different Keyboard layout' & @CRLF & '(00004009->' & $aResult[1] & ')')
EndIf

EndFunc

Func _WinWaitActivate($title,$text,$timeout=0)
	WinWait($title,$text,$timeout)
	If Not WinActive($title,$text) Then WinActivate($title,$text)
	WinWaitActive($title,$text,$timeout)
EndFunc

_AU3RecordSetup()
#endregion --- Internal functions Au3Recorder End ---

#comments-start
_WinWaitActivate("Focus-Ledger - Google Chrome","")
#comments-end
MouseClick("left",1001,334,1)
Sleep(2000)
MouseDown("left")
Sleep(2000)
MouseMove(1002,443)
Sleep(2000)
MouseUp("left")
Sleep(2000)
MouseClick("left",1352,296,1)
Sleep(2000)
MouseClick("left",1352,296,1)
Sleep(2000)
MouseClick("left",989,351,1)
Sleep(2000)
MouseDown("left")
Sleep(2000)
MouseMove(1183,552)
Sleep(2000)
MouseUp("left")
Sleep(2000)
MouseClick("left",1349,325,1)
Sleep(2000)
MouseClick("left",1347,297,1)
Sleep(2000)
MouseClick("left",993,371,1)
Sleep(2000)
MouseDown("left")
Sleep(2000)
MouseMove(1186,570)
Sleep(2000)
MouseUp("left")
Sleep(2000)
MouseClick("left",1350,330,1)
Sleep(2000)
MouseClick("left",999,298,1)
Sleep(2000)
MouseDown("left")
Sleep(2000)
MouseMove(1197,584)
Sleep(2000)
MouseUp("left")
#comments-start
#endregion --- Au3Recorder generated code End ---
#comments-end
