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

_WinWaitActivate("Focus-Buyer Price Book - Google Chrome","")
MouseClick("left",1223,205,1)
MouseClick("left",1184,314,1)
MouseClick("left",468,672,1)
MouseClick("left",1322,287,1)
MouseClick("left",1161,312,1)
MouseDown("left")
MouseMove(497,532)
MouseUp("left")
MouseClick("left",1164,344,1)
MouseDown("left")
MouseMove(636,515)
MouseUp("left")
MouseClick("left",1144,373,1)
MouseMove(1144,375)
MouseDown("left")
MouseMove(742,511)
MouseUp("left")
MouseClick("left",1339,532,1)
MouseClick("left",1133,321,1)
MouseDown("left")
MouseMove(668,515)
MouseUp("left")
MouseClick("left",1129,352,1)
MouseDown("left")
MouseMove(665,517)
MouseUp("left")
MouseClick("left",1338,291,1)
MouseClick("left",1316,285,1)
MouseClick("left",1321,310,1)
MouseClick("left",1148,341,1)
MouseDown("left")
MouseMove(343,407)
MouseUp("left")
MouseClick("left",1147,371,1)
MouseDown("left")
MouseMove(845,413)
MouseUp("left")
#endregion --- Au3Recorder generated code End ---
