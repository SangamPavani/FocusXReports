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

Send('#r')
WinWaitActive("Run")
Sleep(2000)
Send("inetMgr.exe")
Send("{ENTER}")
Sleep(4000)

ControlSend("Internet Information Services (IIS) Manager","","[CLASS:WindowsForms10.STATIC.app.0.297b065_r33_ad1]","{CTRLDOWN}")
ControlClick("Internet Information Services (IIS) Manager","","[CLASS:WindowsForms10.STATIC.app.0.297b065_r33_ad113]","Left" ,1,835,107)



Sleep(4000)
Send("!{F4}")


#comments-start
#endregion --- Au3Recorder generated code End ---
#comments-end
