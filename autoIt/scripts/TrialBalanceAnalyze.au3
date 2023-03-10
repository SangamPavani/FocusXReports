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

_WinWaitActivate("Focus-Trial Balance - Google Chrome","")
MouseClick("left",1042,257,1)
MouseClick("left",976,348,1)
MouseDown("left")
MouseMove(1175,518)
MouseUp("left")
MouseClick("left",1340,320,1)
MouseClick("left",976,295,1)
MouseDown("left")
MouseMove(1174,540)
MouseUp("left")
MouseClick("left",1341,288,1)
MouseClick("left",996,295,1)
MouseDown("left")
MouseMove(994,428)
MouseUp("left")
#endregion --- Au3Recorder generated code End ---
