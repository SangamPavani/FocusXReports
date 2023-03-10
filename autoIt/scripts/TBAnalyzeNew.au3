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
_WinWaitActivate("Focus-Trial Balance - Google Chrome","")
#comments-end
MouseClick("left",981,350,1)
Sleep(2000)
MouseDown("left")
Sleep(2000)
MouseMove(1178,523)
Sleep(2000)
MouseUp("left")
Sleep(2000)
MouseClick("left",1340,304,1)
Sleep(2000)
MouseClick("left",1343,315,1)
Sleep(2000)
MouseClick("left",1340,316,1)
Sleep(2000)
MouseClick("left",1339,294,1)
Sleep(2000)
MouseClick("left",985,298,1)
Sleep(2000)
MouseMove(986,297)
Sleep(2000)
MouseDown("left")
Sleep(2000)
MouseMove(1187,541)
Sleep(2000)
MouseUp("left")
Sleep(2000)
MouseClick("left",1338,287,1)
Sleep(2000)
MouseClick("left",990,294,1)
Sleep(2000)
MouseDown("left")
Sleep(2000)
MouseMove(984,436)
Sleep(2000)
MouseUp("left")
#comments-start
#endregion --- Au3Recorder generated code End ---\
#comments-end
