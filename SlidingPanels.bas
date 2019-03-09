Type=StaticCode
Version=7.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Code module
Sub Process_Globals
	Type SlidingData (firstTime As Boolean, currentPanel As Int, Panels() As Panel, LeftAnimations() As Animation, RightAnimations() As Animation, targetPanel As Int)
End Sub

'Sub Initialize (sd As SlidingData, SlidingDuration As Int)
''	duration = SlidingDuration
'	Main.tmrAnimation.Initialize("tmrAnimation", 2)
'	Dim a(2) As Animation
'	sd.LeftAnimations = a
'	Dim a(2) As Animation
'	sd.RightAnimations = a
'	'Initialize the animation objects. We need two objects for each direction as both the current panel and the new panel are animated.
'	For i = 0 To 1
'		sd.leftAnimations(i).InitializeTranslate("animation" & i, 0, 0, -100%x, 0)
'		sd.leftAnimations(i).Duration = SlidingDuration
'		sd.rightAnimations(i).InitializeTranslate("animation" & i, 0, 0, 100%x, 0)
'		sd.rightAnimations(i).Duration = SlidingDuration
'	Next
'	For i = 0 To sd.Panels.Length - 1
'		sd.Panels(i).Left = 100%x 'Move the panels right of the screen
'	Next
'	sd.firstTime = True
'End Sub

Sub Initialize (sd As SlidingData, SlidingDuration As Int)
'	duration = SlidingDuration
	Main.tmrAnimation.Initialize("tmrAnimation", 2)
'	Dim a(2) As Animation
'	sd.LeftAnimations = a
'	Dim a(2) As Animation
'	sd.RightAnimations = a
	'Initialize the animation objects. We need two objects for each direction as both the current panel and the new panel are animated.
	For i = 0 To 1
		Main.animacije.Initialize("Anim", f.animStr)
		Main.animacije.delay(500).duration(2500)

'		sd.leftAnimations(i).InitializeTranslate("animation" & i, 0, 0, -100%x, 0)
'		sd.leftAnimations(i).Duration = SlidingDuration
'		sd.rightAnimations(i).InitializeTranslate("animation" & i, 0, 0, 100%x, 0)
'		sd.rightAnimations(i).Duration = SlidingDuration
	Next
	For i = 0 To sd.Panels.Length - 1
		sd.Panels(i).Left = 100%x 'Move the panels right of the screen
	Next
	sd.firstTime = True
End Sub

Sub ChangePanel(sd As SlidingData, left As Boolean)
	If left Then
		If sd.firstTime = False Then 'remove current panel if such exists (it will not be the case on the first call).
			sd.leftAnimations(0).Start(sd.panels(sd.currentPanel)) 'Animate current panel and move it out
		Else
			sd.firstTime = False
		End If
		sd.leftAnimations(1).Start(sd.panels((sd.currentPanel + 1) Mod sd.Panels.Length)) 'Animate new panel
		sd.currentPanel = (sd.currentPanel + 1) Mod sd.Panels.Length
	Else
		Dim leftPanel As Int
		leftPanel = (sd.currentPanel + sd.Panels.Length - 1) Mod sd.Panels.Length
		sd.panels(leftPanel).left = -100%x
		sd.rightAnimations(0).Start(sd.panels(sd.currentPanel))
		sd.rightAnimations(1).Start(sd.panels(leftPanel))
		sd.currentPanel = leftPanel
	End If
End Sub

Sub Anim_AnimationEnd(sd As SlidingData)
	sd.panels(sd.currentPanel).Left = 0 'Set the position of the new panel
	For i = 0 To sd.panels.Length - 1
		If i <> sd.currentPanel Then sd.panels(i).Left = 100%x 'Move all other panels right of the screen.
	Next
End Sub

'Sub AnimationEnd (sd As SlidingData)
'	sd.panels(sd.currentPanel).Left = 0 'Set the position of the new panel
'	For i = 0 To sd.panels.Length - 1
'		If i <> sd.currentPanel Then sd.panels(i).Left = 100%x 'Move all other panels right of the screen.
'	Next
'End Sub
'
'
