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
Send("C:\Users\Rakesh\Desktop\280922Pronghorn.exe")
Send("{ENTER}")
Sleep(3000)

_WinWaitActivate("Pronghorn","")
Sleep(2000)
MouseClick("left",41,39,1)
Sleep(2000)
MouseClick("left",98,60,1)
Sleep(2000)

WinSetState("[ACTIVE]", "", @SW_MINIMIZE)



#comments-start
#endregion --- Au3Recorder generated code End ---
#comments-end
