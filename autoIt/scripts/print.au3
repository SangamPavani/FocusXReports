#comments-start
#region --- Au3Recorder generated code Start (v3.3.9.5 KeyboardLayout=00000409)  ---

#region --- Internal functions Au3Recorder Start ---
Func _Au3RecordSetup()
Opt('WinWaitDelay',100)
Opt('WinDetectHiddenText',1)
Opt('MouseCoordMode',0)
Local $aResult = DllCall('User32.dll', 'int', 'GetKeyboardLayoutNameW', 'wstr', '')
If $aResult[1] <> '00000409' Then
  MsgBox(64, 'Warning', 'Recording has been done under a different Keyboard layout' & @CRLF & '(00000409->' & $aResult[1] & ')')
EndIf

EndFunc

#comments-end

Func _WinWaitActivate($title,$text,$timeout=0)
	WinWait($title,$text,$timeout)
	If Not WinActive($title,$text) Then WinActivate($title,$text)
	WinWaitActive($title,$text,$timeout)
EndFunc

#comments-start
_AU3RecordSetup()
#endregion --- Internal functions Au3Recorder End ---
#comments-end

#comments-start
_WinWaitActivate("Focus - Google Chrome","Chrome Legacy Window")
#comments-end
MouseMove(1003,305)
Sleep(2000)
MouseDown("left")
sleep(2000)
MouseMove(286,398)
sleep(2000)
MouseUp("left")
sleep(2000)

#comments-start
_WinWaitActivate("Focus - Google Chrome","Chrome Legacy Window")
#comments-end
MouseClick("left",1004,328,1)
sleep(2000)
MouseClick("left",1002,345,1)
sleep(2000)
MouseDown("left")
sleep(2000)
MouseMove(579,398)
sleep(2000)
MouseUp("left")
sleep(2000)

#comments-start
_WinWaitActivate("Focus - Google Chrome","Chrome Legacy Window")
#comments-end
MouseClick("left",1004,325,1)
sleep(2000)
MouseClick("left",1009,369,1)
sleep(2000)
MouseClick("left",1005,388,1)
sleep(2000)
MouseDown("left")
sleep(2000)
MouseMove(286,448)
sleep(2000)
MouseUp("left")
sleep(2000)


#comments-start
_WinWaitActivate("Focus - Google Chrome","Chrome Legacy Window")
#comments-end
MouseClick("left",1008,365,1)
sleep(2000)
MouseClick("left",1008,393,1)
sleep(2000)
MouseClick("left",1002,405,1)
sleep(2000)
MouseDown("left")
sleep(2000)
MouseMove(572,448)
sleep(2000)
MouseUp("left")
sleep(2000)


#comments-start
_WinWaitActivate("Focus - Google Chrome","Chrome Legacy Window")
#comments-end
MouseClick("left",1007,393,1)
sleep(2000)
MouseClick("left",1013,530,1)
sleep(2000)
MouseClick("left",1007,550,1)
sleep(2000)
MouseDown("left")
sleep(2000)
MouseMove(280,486)
sleep(2000)
MouseUp("left")
sleep(2000)

#comments-start
_WinWaitActivate("Focus - Google Chrome","Chrome Legacy Window")
#comments-end
MouseClick("left",1016,530,1)
sleep(2000)
MouseClick("left",1009,510,1)
sleep(2000)
MouseClick("left",1006,525,1)
sleep(2000)
MouseDown("left")
sleep(2000)
MouseMove(572,486)
sleep(2000)
MouseUp("left")
sleep(2000)


#comments-start
_WinWaitActivate("Focus - Google Chrome","Chrome Legacy Window")
#comments-end
MouseClick("left",1011,510,1)
sleep(2000)
MouseClick("left",1014,570,1)
sleep(2000)
MouseDown("left")
sleep(2000)
MouseMove(280,536)
sleep(2000)
MouseUp("left")
sleep(2000)


#comments-start
_WinWaitActivate("Focus - Google Chrome","Chrome Legacy Window")
#comments-end
MouseClick("left",1003,600,1)
sleep(2000)
MouseDown("left")
sleep(2000)
MouseMove(572,536)
sleep(2000)
MouseUp("left")
sleep(2000)

#comments-start
#endregion --- Au3Recorder generated code End ---
#comments-end


