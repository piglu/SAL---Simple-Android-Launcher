package com.no3dlauncher;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class search extends Activity implements B4AActivity{
	public static search mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "com.no3dlauncher", "com.no3dlauncher.search");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (search).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.no3dlauncher", "com.no3dlauncher.search");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.no3dlauncher.search", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (search) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (search) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return search.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (search) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            search mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (search) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edttrazi = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btntrazi = null;
public static String _trazistring = "";
public anywheresoftware.b4a.objects.PanelWrapper _pnlslova = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlapppodslovom = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl1 = null;
public com.no3dlauncher.main _main = null;
public com.no3dlauncher.starter _starter = null;
public com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public com.no3dlauncher.notificationservice _notificationservice = null;
public com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public com.no3dlauncher.f _f = null;
public com.no3dlauncher.provjera _provjera = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2097154;
 //BA.debugLineNum = 2097154;BA.debugLine="Activity.LoadLayout(\"trazi\")";
mostCurrent._activity.LoadLayout("trazi",mostCurrent.activityBA);
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="sv.Initialize(500dip)";
mostCurrent._sv.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (500)));
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="Activity.AddView(sv, 0, 46dip, 100%x, 100%y - 46d";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._sv.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (46)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (46))));
RDebugUtils.currentLine=2097159;
 //BA.debugLineNum = 2097159;BA.debugLine="DodajSlova";
_dodajslova();
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="End Sub";
return "";
}
public static String  _dodajslova() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dodajslova", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "dodajslova", null));}
int _x = 0;
int _y = 0;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _ukupno = 0;
int _i = 0;
int _j = 0;
String _s = "";
anywheresoftware.b4a.objects.ButtonWrapper _btn = null;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub DodajSlova";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="Dim x As Int = Activity.Width / 5	' 5 slova abece";
_x = (int) (mostCurrent._activity.getWidth()/(double)5);
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim y As Int = Activity.Width - x*5 + 8dip";
_y = (int) (mostCurrent._activity.getWidth()-_x*5+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="pnlSlova.Initialize(\"\")";
mostCurrent._pnlslova.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="sv.Panel.AddView(pnlSlova, 0, 0, 100%x, 100%y)";
mostCurrent._sv.getPanel().AddView((android.view.View)(mostCurrent._pnlslova.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=2293767;
 //BA.debugLineNum = 2293767;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="cd.Initialize2(Colors.ARGB(127, 211, 211, 211), x";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (127),(int) (211),(int) (211),(int) (211)),_x,(int) (4),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="Dim ukupno As Int = 0";
_ukupno = (int) (0);
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="For i = 0 To Starter.listaSlova.Size - 1' Step 4";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._starter._listaslova.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="For j = 0 To 4";
{
final int step9 = 1;
final int limit9 = (int) (4);
_j = (int) (0) ;
for (;_j <= limit9 ;_j = _j + step9 ) {
RDebugUtils.currentLine=2293772;
 //BA.debugLineNum = 2293772;BA.debugLine="If ukupno < Starter.listaSlova.Size Then";
if (_ukupno<mostCurrent._starter._listaslova.getSize()) { 
RDebugUtils.currentLine=2293773;
 //BA.debugLineNum = 2293773;BA.debugLine="Dim s As String = Starter.listaSlova.Get(i*5+j";
_s = BA.ObjectToString(mostCurrent._starter._listaslova.Get((int) (_i*5+_j)));
RDebugUtils.currentLine=2293774;
 //BA.debugLineNum = 2293774;BA.debugLine="Dim btn As Button";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2293775;
 //BA.debugLineNum = 2293775;BA.debugLine="btn.Initialize(\"btnSlovo\")";
_btn.Initialize(mostCurrent.activityBA,"btnSlovo");
RDebugUtils.currentLine=2293776;
 //BA.debugLineNum = 2293776;BA.debugLine="btn.Text = s";
_btn.setText(BA.ObjectToCharSequence(_s));
RDebugUtils.currentLine=2293777;
 //BA.debugLineNum = 2293777;BA.debugLine="btn.Tag = s";
_btn.setTag((Object)(_s));
RDebugUtils.currentLine=2293778;
 //BA.debugLineNum = 2293778;BA.debugLine="btn.TextSize = 28.0";
_btn.setTextSize((float) (28.0));
RDebugUtils.currentLine=2293779;
 //BA.debugLineNum = 2293779;BA.debugLine="btn.TextColor = Colors.White";
_btn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2293780;
 //BA.debugLineNum = 2293780;BA.debugLine="btn.Typeface = Typeface.LoadFromAssets(f.wheel";
_btn.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=2293781;
 //BA.debugLineNum = 2293781;BA.debugLine="btn.Background = cd";
_btn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2293782;
 //BA.debugLineNum = 2293782;BA.debugLine="btn.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL";
_btn.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL,anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=2293783;
 //BA.debugLineNum = 2293783;BA.debugLine="pnlSlova.AddView(btn, x*j + j*2dip, x*i + y +";
mostCurrent._pnlslova.AddView((android.view.View)(_btn.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(int) (_x*_i+_y+_i*_y),(int) (_x-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),(int) (_x-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=2293784;
 //BA.debugLineNum = 2293784;BA.debugLine="ukupno = ukupno + 1";
_ukupno = (int) (_ukupno+1);
 }else {
RDebugUtils.currentLine=2293786;
 //BA.debugLineNum = 2293786;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 }
};
RDebugUtils.currentLine=2293790;
 //BA.debugLineNum = 2293790;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And pnlAppPodS";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._pnlapppodslovom.IsInitialized()) { 
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="If pnlAppPodSlovom.Visible = True Then";
if (mostCurrent._pnlapppodslovom.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2883588;
 //BA.debugLineNum = 2883588;BA.debugLine="lbl1.RemoveView";
mostCurrent._lbl1.RemoveView();
RDebugUtils.currentLine=2883589;
 //BA.debugLineNum = 2883589;BA.debugLine="pnlAppPodSlovom.Visible = False";
mostCurrent._pnlapppodslovom.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2883591;
 //BA.debugLineNum = 2883591;BA.debugLine="DodajSlova";
_dodajslova();
RDebugUtils.currentLine=2883592;
 //BA.debugLineNum = 2883592;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
RDebugUtils.currentLine=2883596;
 //BA.debugLineNum = 2883596;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=2883597;
 //BA.debugLineNum = 2883597;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="search";
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="End Sub";
return "";
}
public static String  _addtofavorites() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addtofavorites", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addtofavorites", null));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub AddToFavorites";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="CallSub(Main, \"DodajAppUFavorite\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._main.getObject()),"DodajAppUFavorite");
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.BitmapDrawable  _bitmaptobitmapdrawable(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmd) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bitmaptobitmapdrawable", false))
	 {return ((anywheresoftware.b4a.objects.drawable.BitmapDrawable) Debug.delegate(mostCurrent.activityBA, "bitmaptobitmapdrawable", new Object[] {_bmd}));}
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bd = null;
RDebugUtils.currentLine=13828096;
 //BA.debugLineNum = 13828096;BA.debugLine="Sub BitmapToBitmapDrawable(BMD As Bitmap) As Bitma";
RDebugUtils.currentLine=13828097;
 //BA.debugLineNum = 13828097;BA.debugLine="Dim BD As BitmapDrawable";
_bd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=13828098;
 //BA.debugLineNum = 13828098;BA.debugLine="BD.Initialize(BMD)";
_bd.Initialize((android.graphics.Bitmap)(_bmd.getObject()));
RDebugUtils.currentLine=13828100;
 //BA.debugLineNum = 13828100;BA.debugLine="Return BD";
if (true) return _bd;
RDebugUtils.currentLine=13828101;
 //BA.debugLineNum = 13828101;BA.debugLine="End Sub";
return null;
}
public static String  _btnslovo_click() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnslovo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnslovo_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _b = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.objects.collections.List _pkg1 = null;
anywheresoftware.b4a.objects.collections.List _pkg2 = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _ukupno1 = 0;
int _ukupno2 = 0;
int _i = 0;
String _s = "";
String _pckg = "";
int _x = 0;
int _j = 0;
Object _drawable = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bdw = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _btm = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _destrect = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _can = null;
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub btnSlovo_Click";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim b As Button";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="Dim pkg1, pkg2 As List";
_pkg1 = new anywheresoftware.b4a.objects.collections.List();
_pkg2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="b = Sender";
_b.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="pnlSlova.RemoveView";
mostCurrent._pnlslova.RemoveView();
RDebugUtils.currentLine=2555915;
 //BA.debugLineNum = 2555915;BA.debugLine="pnlAppPodSlovom.Initialize(\"\")";
mostCurrent._pnlapppodslovom.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2555916;
 //BA.debugLineNum = 2555916;BA.debugLine="sv.Panel.AddView(pnlAppPodSlovom, 0, 0, 100%x, 10";
mostCurrent._sv.getPanel().AddView((android.view.View)(mostCurrent._pnlapppodslovom.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=2555917;
 //BA.debugLineNum = 2555917;BA.debugLine="lbl1.Initialize(\"\")";
mostCurrent._lbl1.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2555918;
 //BA.debugLineNum = 2555918;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2555919;
 //BA.debugLineNum = 2555919;BA.debugLine="cd.Initialize(Colors.Yellow, 50)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.Yellow,(int) (50));
RDebugUtils.currentLine=2555920;
 //BA.debugLineNum = 2555920;BA.debugLine="lbl1.Background = cd";
mostCurrent._lbl1.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2555921;
 //BA.debugLineNum = 2555921;BA.debugLine="lbl1.Typeface = Typeface.DEFAULT_BOLD";
mostCurrent._lbl1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.DEFAULT_BOLD);
RDebugUtils.currentLine=2555922;
 //BA.debugLineNum = 2555922;BA.debugLine="lbl1.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL,";
mostCurrent._lbl1.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL,anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=2555924;
 //BA.debugLineNum = 2555924;BA.debugLine="sv.Panel.AddView(lbl1, 100%x - 32dip, 100%y - 80d";
mostCurrent._sv.getPanel().AddView((android.view.View)(mostCurrent._lbl1.getObject()),(int) (anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32))),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (80))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
RDebugUtils.currentLine=2555926;
 //BA.debugLineNum = 2555926;BA.debugLine="Dim ukupno1, ukupno2 As Int = 0";
_ukupno1 = 0;
_ukupno2 = (int) (0);
RDebugUtils.currentLine=2555927;
 //BA.debugLineNum = 2555927;BA.debugLine="pkg1.Initialize";
_pkg1.Initialize();
RDebugUtils.currentLine=2555928;
 //BA.debugLineNum = 2555928;BA.debugLine="pkg2.Initialize";
_pkg2.Initialize();
RDebugUtils.currentLine=2555930;
 //BA.debugLineNum = 2555930;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
{
final int step18 = 1;
final int limit18 = (int) (mostCurrent._starter._mapa.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit18 ;_i = _i + step18 ) {
RDebugUtils.currentLine=2555931;
 //BA.debugLineNum = 2555931;BA.debugLine="Dim s As String = Starter.mapa.GetKeyAt(i)";
_s = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_i));
RDebugUtils.currentLine=2555932;
 //BA.debugLineNum = 2555932;BA.debugLine="If s.StartsWith(b.Tag) Then";
if (_s.startsWith(BA.ObjectToString(_b.getTag()))) { 
RDebugUtils.currentLine=2555933;
 //BA.debugLineNum = 2555933;BA.debugLine="ukupno1 = ukupno1 + 1";
_ukupno1 = (int) (_ukupno1+1);
RDebugUtils.currentLine=2555934;
 //BA.debugLineNum = 2555934;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
_pckg = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_i));
RDebugUtils.currentLine=2555936;
 //BA.debugLineNum = 2555936;BA.debugLine="pkg1.Add(pckg.SubString2(pckg.IndexOf(\";\")+1, p";
_pkg1.Add((Object)(_pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length())));
RDebugUtils.currentLine=2555938;
 //BA.debugLineNum = 2555938;BA.debugLine="pkg2.Add(pckg.SubString2(0, pckg.IndexOf(\";\")))";
_pkg2.Add((Object)(_pckg.substring((int) (0),_pckg.indexOf(";"))));
 };
 }
};
RDebugUtils.currentLine=2555942;
 //BA.debugLineNum = 2555942;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=2555943;
 //BA.debugLineNum = 2555943;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (211),(int) (211),(int) (211)),(int) (0));
RDebugUtils.currentLine=2555944;
 //BA.debugLineNum = 2555944;BA.debugLine="Dim x As Int";
_x = 0;
RDebugUtils.currentLine=2555945;
 //BA.debugLineNum = 2555945;BA.debugLine="x = Activity.Width / 5'pkg1.Size";
_x = (int) (mostCurrent._activity.getWidth()/(double)5);
RDebugUtils.currentLine=2555946;
 //BA.debugLineNum = 2555946;BA.debugLine="x = x - 2dip";
_x = (int) (_x-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2)));
RDebugUtils.currentLine=2555950;
 //BA.debugLineNum = 2555950;BA.debugLine="Log(pnlAppPodSlovom.Height)";
anywheresoftware.b4a.keywords.Common.LogImpl("72555950",BA.NumberToString(mostCurrent._pnlapppodslovom.getHeight()),0);
RDebugUtils.currentLine=2555951;
 //BA.debugLineNum = 2555951;BA.debugLine="For i = 0 To pkg1.Size - 1";
{
final int step33 = 1;
final int limit33 = (int) (_pkg1.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit33 ;_i = _i + step33 ) {
RDebugUtils.currentLine=2555952;
 //BA.debugLineNum = 2555952;BA.debugLine="For j = 0 To 4";
{
final int step34 = 1;
final int limit34 = (int) (4);
_j = (int) (0) ;
for (;_j <= limit34 ;_j = _j + step34 ) {
RDebugUtils.currentLine=2555953;
 //BA.debugLineNum = 2555953;BA.debugLine="If ukupno2 < ukupno1 Then'pkg1.Size - 1 Then";
if (_ukupno2<_ukupno1) { 
RDebugUtils.currentLine=2555954;
 //BA.debugLineNum = 2555954;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon";
_drawable = (Object)(_pm.GetApplicationIcon(BA.ObjectToString(_pkg1.Get((int) (_i*5+_j)))));
RDebugUtils.currentLine=2555955;
 //BA.debugLineNum = 2555955;BA.debugLine="If drawable Is BitmapDrawable Then";
if (_drawable instanceof android.graphics.drawable.BitmapDrawable) { 
RDebugUtils.currentLine=2555956;
 //BA.debugLineNum = 2555956;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_drawable));
RDebugUtils.currentLine=2555957;
 //BA.debugLineNum = 2555957;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=2555958;
 //BA.debugLineNum = 2555958;BA.debugLine="bdw.Initialize(bmp.Resize(64dip, 64dip, True)";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (64))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (64))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=2555959;
 //BA.debugLineNum = 2555959;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2555960;
 //BA.debugLineNum = 2555960;BA.debugLine="iv.Initialize(\"ivApp\")";
_iv.Initialize(mostCurrent.activityBA,"ivApp");
RDebugUtils.currentLine=2555961;
 //BA.debugLineNum = 2555961;BA.debugLine="iv.Bitmap = bdw.Bitmap";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=2555962;
 //BA.debugLineNum = 2555962;BA.debugLine="iv.Tag = pkg1.Get(i*5+j)";
_iv.setTag(_pkg1.Get((int) (_i*5+_j)));
RDebugUtils.currentLine=2555964;
 //BA.debugLineNum = 2555964;BA.debugLine="pnlAppPodSlovom.AddView(iv, x*j + j*1dip, x*i";
mostCurrent._pnlapppodslovom.AddView((android.view.View)(_iv.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))),(int) (_x*_i+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),_x,_x);
RDebugUtils.currentLine=2555965;
 //BA.debugLineNum = 2555965;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2555966;
 //BA.debugLineNum = 2555966;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2555967;
 //BA.debugLineNum = 2555967;BA.debugLine="lbl.Text = pkg2.Get(i*5+j)";
_lbl.setText(BA.ObjectToCharSequence(_pkg2.Get((int) (_i*5+_j))));
RDebugUtils.currentLine=2555968;
 //BA.debugLineNum = 2555968;BA.debugLine="lbl.TextColor = Colors.White";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2555969;
 //BA.debugLineNum = 2555969;BA.debugLine="lbl.Background = cd";
_lbl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2555970;
 //BA.debugLineNum = 2555970;BA.debugLine="lbl.TextSize = 10";
_lbl.setTextSize((float) (10));
RDebugUtils.currentLine=2555971;
 //BA.debugLineNum = 2555971;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
_lbl.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=2555972;
 //BA.debugLineNum = 2555972;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL,anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=2555973;
 //BA.debugLineNum = 2555973;BA.debugLine="pnlAppPodSlovom.AddView(lbl, x*j, x*i + x + i";
mostCurrent._pnlapppodslovom.AddView((android.view.View)(_lbl.getObject()),(int) (_x*_j),(int) (_x*_i+_x+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))),_x,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 }else {
RDebugUtils.currentLine=2555978;
 //BA.debugLineNum = 2555978;BA.debugLine="Dim btm As Bitmap";
_btm = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=2555979;
 //BA.debugLineNum = 2555979;BA.debugLine="btm.InitializeMutable(x, x)";
_btm.InitializeMutable(_x,_x);
RDebugUtils.currentLine=2555980;
 //BA.debugLineNum = 2555980;BA.debugLine="Dim DestRect As Rect";
_destrect = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=2555981;
 //BA.debugLineNum = 2555981;BA.debugLine="DestRect.Initialize(0, 0, x, x)";
_destrect.Initialize((int) (0),(int) (0),_x,_x);
RDebugUtils.currentLine=2555982;
 //BA.debugLineNum = 2555982;BA.debugLine="Dim can As Canvas";
_can = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=2555983;
 //BA.debugLineNum = 2555983;BA.debugLine="can.Initialize2(btm)";
_can.Initialize2((android.graphics.Bitmap)(_btm.getObject()));
RDebugUtils.currentLine=2555984;
 //BA.debugLineNum = 2555984;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=2555985;
 //BA.debugLineNum = 2555985;BA.debugLine="can.DrawDrawable(pm.GetApplicationIcon(pkg1.G";
_can.DrawDrawable(_pm.GetApplicationIcon(BA.ObjectToString(_pkg1.Get((int) (_i*5+_j)))),(android.graphics.Rect)(_destrect.getObject()));
RDebugUtils.currentLine=2555986;
 //BA.debugLineNum = 2555986;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2555987;
 //BA.debugLineNum = 2555987;BA.debugLine="iv.Initialize(\"ivApp\")";
_iv.Initialize(mostCurrent.activityBA,"ivApp");
RDebugUtils.currentLine=2555988;
 //BA.debugLineNum = 2555988;BA.debugLine="iv.Background = BitmapToBitmapDrawable(btm)";
_iv.setBackground((android.graphics.drawable.Drawable)(_bitmaptobitmapdrawable(_btm).getObject()));
RDebugUtils.currentLine=2555991;
 //BA.debugLineNum = 2555991;BA.debugLine="iv.Tag = pkg1.Get(i*5+j)";
_iv.setTag(_pkg1.Get((int) (_i*5+_j)));
RDebugUtils.currentLine=2555993;
 //BA.debugLineNum = 2555993;BA.debugLine="pnlAppPodSlovom.AddView(iv, x*j + j*1dip, x*i";
mostCurrent._pnlapppodslovom.AddView((android.view.View)(_iv.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1))),(int) (_x*_i+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),_x,_x);
RDebugUtils.currentLine=2555994;
 //BA.debugLineNum = 2555994;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=2555995;
 //BA.debugLineNum = 2555995;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2555996;
 //BA.debugLineNum = 2555996;BA.debugLine="lbl.Text = pkg2.Get(i*5+j)";
_lbl.setText(BA.ObjectToCharSequence(_pkg2.Get((int) (_i*5+_j))));
RDebugUtils.currentLine=2555997;
 //BA.debugLineNum = 2555997;BA.debugLine="lbl.TextColor = Colors.White";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=2555998;
 //BA.debugLineNum = 2555998;BA.debugLine="lbl.Background = cd";
_lbl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=2555999;
 //BA.debugLineNum = 2555999;BA.debugLine="lbl.TextSize = 10";
_lbl.setTextSize((float) (10));
RDebugUtils.currentLine=2556000;
 //BA.debugLineNum = 2556000;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
_lbl.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=2556001;
 //BA.debugLineNum = 2556001;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL,anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=2556002;
 //BA.debugLineNum = 2556002;BA.debugLine="pnlAppPodSlovom.AddView(lbl, x*j, x*i + x + i";
mostCurrent._pnlapppodslovom.AddView((android.view.View)(_lbl.getObject()),(int) (_x*_j),(int) (_x*_i+_x+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))),_x,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 };
RDebugUtils.currentLine=2556004;
 //BA.debugLineNum = 2556004;BA.debugLine="ukupno2 = ukupno2 + 1";
_ukupno2 = (int) (_ukupno2+1);
 }else {
RDebugUtils.currentLine=2556006;
 //BA.debugLineNum = 2556006;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 }
};
RDebugUtils.currentLine=2556010;
 //BA.debugLineNum = 2556010;BA.debugLine="lbl1.Text = ukupno1";
mostCurrent._lbl1.setText(BA.ObjectToCharSequence(_ukupno1));
RDebugUtils.currentLine=2556011;
 //BA.debugLineNum = 2556011;BA.debugLine="lbl1.TextColor = Colors.Black";
mostCurrent._lbl1.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=2556013;
 //BA.debugLineNum = 2556013;BA.debugLine="sv.Panel.Height = pnlAppPodSlovom.Height - 46dip";
mostCurrent._sv.getPanel().setHeight((int) (mostCurrent._pnlapppodslovom.getHeight()-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (46))));
RDebugUtils.currentLine=2556014;
 //BA.debugLineNum = 2556014;BA.debugLine="End Sub";
return "";
}
public static String  _btntrazi_click() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btntrazi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btntrazi_click", null));}
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub btnTrazi_Click";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Log(\"trazi\")";
anywheresoftware.b4a.keywords.Common.LogImpl("72424833","trazi",0);
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="Trazi(traziString)";
_trazi(mostCurrent._trazistring);
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="End Sub";
return "";
}
public static String  _trazi(String _str) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "trazi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "trazi", new Object[] {_str}));}
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub Trazi(str As String)";
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="End Sub";
return "";
}
public static String  _edttrazi_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edttrazi_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edttrazi_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub edtTrazi_TextChanged (Old As String, New As St";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="If New.Length > 0 Then";
if (_new.length()>0) { 
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="Log(New)";
anywheresoftware.b4a.keywords.Common.LogImpl("72359298",_new,0);
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="traziString = New";
mostCurrent._trazistring = _new;
 };
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="End Sub";
return "";
}
public static boolean  _issystemapp(String _app) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "issystemapp", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "issystemapp", new Object[] {_app}));}
anywheresoftware.b4a.agraham.reflection.Reflection _obj1 = null;
anywheresoftware.b4a.agraham.reflection.Reflection _obj2 = null;
anywheresoftware.b4a.agraham.reflection.Reflection _obj3 = null;
int _size = 0;
int _i = 0;
int _flags = 0;
boolean _result = false;
String _name = "";
RDebugUtils.currentLine=14024704;
 //BA.debugLineNum = 14024704;BA.debugLine="Sub isSystemapp(app As String) As Boolean";
RDebugUtils.currentLine=14024705;
 //BA.debugLineNum = 14024705;BA.debugLine="Dim Obj1, Obj2, Obj3 As Reflector";
_obj1 = new anywheresoftware.b4a.agraham.reflection.Reflection();
_obj2 = new anywheresoftware.b4a.agraham.reflection.Reflection();
_obj3 = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=14024706;
 //BA.debugLineNum = 14024706;BA.debugLine="Dim size, i, flags As Int";
_size = 0;
_i = 0;
_flags = 0;
RDebugUtils.currentLine=14024707;
 //BA.debugLineNum = 14024707;BA.debugLine="Dim result As Boolean = False";
_result = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=14024709;
 //BA.debugLineNum = 14024709;BA.debugLine="Obj1.Target = Obj1.GetContext";
_obj1.Target = (Object)(_obj1.GetContext(processBA));
RDebugUtils.currentLine=14024710;
 //BA.debugLineNum = 14024710;BA.debugLine="Obj1.Target = Obj1.RunMethod(\"getPackageManager\")";
_obj1.Target = _obj1.RunMethod("getPackageManager");
RDebugUtils.currentLine=14024711;
 //BA.debugLineNum = 14024711;BA.debugLine="Obj1.Target = Obj1.RunMethod2(\"getInstalledPackag";
_obj1.Target = _obj1.RunMethod2("getInstalledPackages",BA.NumberToString(0),"java.lang.int");
RDebugUtils.currentLine=14024712;
 //BA.debugLineNum = 14024712;BA.debugLine="For i = 0 To Obj1.RunMethod(\"size\") -1";
{
final int step7 = 1;
final int limit7 = (int) ((double)(BA.ObjectToNumber(_obj1.RunMethod("size")))-1);
_i = (int) (0) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
RDebugUtils.currentLine=14024713;
 //BA.debugLineNum = 14024713;BA.debugLine="Obj2.Target = Obj1.RunMethod2(\"get\", i, \"java.la";
_obj2.Target = _obj1.RunMethod2("get",BA.NumberToString(_i),"java.lang.int");
RDebugUtils.currentLine=14024714;
 //BA.debugLineNum = 14024714;BA.debugLine="Dim name As String = Obj2.GetField(\"packageName\"";
_name = BA.ObjectToString(_obj2.GetField("packageName"));
RDebugUtils.currentLine=14024715;
 //BA.debugLineNum = 14024715;BA.debugLine="If app.ToLowerCase = name.ToLowerCase Then";
if ((_app.toLowerCase()).equals(_name.toLowerCase())) { 
RDebugUtils.currentLine=14024716;
 //BA.debugLineNum = 14024716;BA.debugLine="Obj3.Target = Obj2.GetField(\"applicationInfo\")";
_obj3.Target = _obj2.GetField("applicationInfo");
RDebugUtils.currentLine=14024717;
 //BA.debugLineNum = 14024717;BA.debugLine="flags = Obj3.GetField(\"flags\")";
_flags = (int)(BA.ObjectToNumber(_obj3.GetField("flags")));
RDebugUtils.currentLine=14024718;
 //BA.debugLineNum = 14024718;BA.debugLine="If Bit.And(flags, 1)  = 0 Then";
if (anywheresoftware.b4a.keywords.Common.Bit.And(_flags,(int) (1))==0) { 
 }else {
RDebugUtils.currentLine=14024722;
 //BA.debugLineNum = 14024722;BA.debugLine="result = True";
_result = anywheresoftware.b4a.keywords.Common.True;
 };
 };
 }
};
RDebugUtils.currentLine=14024726;
 //BA.debugLineNum = 14024726;BA.debugLine="Return result";
if (true) return _result;
RDebugUtils.currentLine=14024727;
 //BA.debugLineNum = 14024727;BA.debugLine="End Sub";
return false;
}
public static String  _ivapp_click() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivapp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivapp_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _in1 = null;
anywheresoftware.b4a.objects.IntentWrapper _myintent = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.objects.collections.List _ll = null;
com.maximus.id.id _x = null;
int _m = 0;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub ivApp_Click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Dim in1, MyIntent As Intent";
_in1 = new anywheresoftware.b4a.objects.IntentWrapper();
_myintent = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=2621445;
 //BA.debugLineNum = 2621445;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("72621446",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="in1 = pm.GetApplicationIntent(iv.Tag)";
_in1 = _pm.GetApplicationIntent(BA.ObjectToString(_iv.getTag()));
RDebugUtils.currentLine=2621452;
 //BA.debugLineNum = 2621452;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2621453;
 //BA.debugLineNum = 2621453;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("72621454",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=2621455;
 //BA.debugLineNum = 2621455;BA.debugLine="Dim ll As List";
_ll = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="ll.Initialize";
_ll.Initialize();
RDebugUtils.currentLine=2621457;
 //BA.debugLineNum = 2621457;BA.debugLine="ll.AddAll(Array As String(\"Run\", \"Add to favorit";
_ll.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Run","Add to favorites","Uninstall"}));
RDebugUtils.currentLine=2621458;
 //BA.debugLineNum = 2621458;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=2621459;
 //BA.debugLineNum = 2621459;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
_m = _x.InputList1(_ll,"",mostCurrent.activityBA);
RDebugUtils.currentLine=2621460;
 //BA.debugLineNum = 2621460;BA.debugLine="Select m";
switch (_m) {
case 0: {
RDebugUtils.currentLine=2621462;
 //BA.debugLineNum = 2621462;BA.debugLine="StartActivity(in1)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in1.getObject()));
 break; }
case 1: {
RDebugUtils.currentLine=2621464;
 //BA.debugLineNum = 2621464;BA.debugLine="AddToFavorites";
_addtofavorites();
 break; }
case 2: {
RDebugUtils.currentLine=2621466;
 //BA.debugLineNum = 2621466;BA.debugLine="UninstallApp(iv.Tag)";
_uninstallapp(BA.ObjectToString(_iv.getTag()));
 break; }
}
;
RDebugUtils.currentLine=2621478;
 //BA.debugLineNum = 2621478;BA.debugLine="End Sub";
return "";
}
public static String  _uninstallapp(String _pkg) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "uninstallapp", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "uninstallapp", new Object[] {_pkg}));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub UninstallApp(pkg As String)";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="If IsPaused(provjera) = True Then StartService(pr";
if (anywheresoftware.b4a.keywords.Common.IsPaused(processBA,(Object)(mostCurrent._provjera.getObject()))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(mostCurrent._provjera.getObject()));};
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="Log(\"package:\" & pkg)";
anywheresoftware.b4a.keywords.Common.LogImpl("72818053","package:"+_pkg,0);
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="i.Initialize(\"android.intent.action.DELETE\", \"pac";
_i.Initialize("android.intent.action.DELETE","package:"+_pkg);
RDebugUtils.currentLine=2818056;
 //BA.debugLineNum = 2818056;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=2818058;
 //BA.debugLineNum = 2818058;BA.debugLine="pnlSlova.Visible = True";
mostCurrent._pnlslova.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2818059;
 //BA.debugLineNum = 2818059;BA.debugLine="pnlSlova.RemoveAllViews";
mostCurrent._pnlslova.RemoveAllViews();
RDebugUtils.currentLine=2818061;
 //BA.debugLineNum = 2818061;BA.debugLine="DodajSlova";
_dodajslova();
RDebugUtils.currentLine=2818062;
 //BA.debugLineNum = 2818062;BA.debugLine="End Sub";
return "";
}
public static String  _playstorelink() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "playstorelink", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "playstorelink", null));}
String _furi = "";
anywheresoftware.b4a.objects.IntentWrapper _market = null;
RDebugUtils.currentLine=13959168;
 //BA.debugLineNum = 13959168;BA.debugLine="Sub PlayStoreLink";
RDebugUtils.currentLine=13959169;
 //BA.debugLineNum = 13959169;BA.debugLine="Dim fURI As String";
_furi = "";
RDebugUtils.currentLine=13959170;
 //BA.debugLineNum = 13959170;BA.debugLine="fURI = \"market://details?id=com.b4a.example\"";
_furi = "market://details?id=com.b4a.example";
RDebugUtils.currentLine=13959171;
 //BA.debugLineNum = 13959171;BA.debugLine="Dim Market As Intent";
_market = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=13959172;
 //BA.debugLineNum = 13959172;BA.debugLine="Market.Initialize(Market.ACTION_VIEW,fURI)";
_market.Initialize(_market.ACTION_VIEW,_furi);
RDebugUtils.currentLine=13959173;
 //BA.debugLineNum = 13959173;BA.debugLine="StartActivity (Market)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_market.getObject()));
RDebugUtils.currentLine=13959174;
 //BA.debugLineNum = 13959174;BA.debugLine="End Sub";
return "";
}
}