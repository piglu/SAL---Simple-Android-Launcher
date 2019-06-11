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
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
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
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="Activity.LoadLayout(\"trazi\")";
mostCurrent._activity.LoadLayout("trazi",mostCurrent.activityBA);
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="DodajSlova";
_dodajslova();
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub DodajSlova";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="Dim x As Int = Activity.Width / 5	' 5 slova abece";
_x = (int) (mostCurrent._activity.getWidth()/(double)5);
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="Dim y As Int = Activity.Width - x*5 + 8dip";
_y = (int) (mostCurrent._activity.getWidth()-_x*5+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (8)));
RDebugUtils.currentLine=5636099;
 //BA.debugLineNum = 5636099;BA.debugLine="pnlSlova.Initialize(\"\")";
mostCurrent._pnlslova.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="Activity.AddView(pnlSlova, 0, 46dip, 100%x, 100%y";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pnlslova.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (46)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=5636101;
 //BA.debugLineNum = 5636101;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=5636102;
 //BA.debugLineNum = 5636102;BA.debugLine="cd.Initialize2(Colors.ARGB(127, 211, 211, 211), x";
_cd.Initialize2(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (127),(int) (211),(int) (211),(int) (211)),_x,(int) (4),anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=5636103;
 //BA.debugLineNum = 5636103;BA.debugLine="Dim ukupno As Int = 0";
_ukupno = (int) (0);
RDebugUtils.currentLine=5636104;
 //BA.debugLineNum = 5636104;BA.debugLine="For i = 0 To Starter.listaSlova.Size - 1' Step 4";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._starter._listaslova.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="For j = 0 To 4";
{
final int step9 = 1;
final int limit9 = (int) (4);
_j = (int) (0) ;
for (;_j <= limit9 ;_j = _j + step9 ) {
RDebugUtils.currentLine=5636106;
 //BA.debugLineNum = 5636106;BA.debugLine="If ukupno < Starter.listaSlova.Size Then";
if (_ukupno<mostCurrent._starter._listaslova.getSize()) { 
RDebugUtils.currentLine=5636107;
 //BA.debugLineNum = 5636107;BA.debugLine="Dim s As String = Starter.listaSlova.Get(i*5+j";
_s = BA.ObjectToString(mostCurrent._starter._listaslova.Get((int) (_i*5+_j)));
RDebugUtils.currentLine=5636108;
 //BA.debugLineNum = 5636108;BA.debugLine="Dim btn As Button";
_btn = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=5636109;
 //BA.debugLineNum = 5636109;BA.debugLine="btn.Initialize(\"btnSlovo\")";
_btn.Initialize(mostCurrent.activityBA,"btnSlovo");
RDebugUtils.currentLine=5636110;
 //BA.debugLineNum = 5636110;BA.debugLine="btn.Text = s";
_btn.setText(BA.ObjectToCharSequence(_s));
RDebugUtils.currentLine=5636111;
 //BA.debugLineNum = 5636111;BA.debugLine="btn.Tag = s";
_btn.setTag((Object)(_s));
RDebugUtils.currentLine=5636112;
 //BA.debugLineNum = 5636112;BA.debugLine="btn.TextSize = 28.0";
_btn.setTextSize((float) (28.0));
RDebugUtils.currentLine=5636113;
 //BA.debugLineNum = 5636113;BA.debugLine="btn.TextColor = Colors.White";
_btn.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=5636114;
 //BA.debugLineNum = 5636114;BA.debugLine="btn.Typeface = Typeface.LoadFromAssets(f.wheel";
_btn.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=5636115;
 //BA.debugLineNum = 5636115;BA.debugLine="btn.Background = cd";
_btn.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=5636116;
 //BA.debugLineNum = 5636116;BA.debugLine="btn.Gravity = Bit.Or(Gravity.CENTER_HORIZONTAL";
_btn.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL,anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=5636117;
 //BA.debugLineNum = 5636117;BA.debugLine="pnlSlova.AddView(btn, x*j + j*2dip, x*i + y +";
mostCurrent._pnlslova.AddView((android.view.View)(_btn.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(int) (_x*_i+_y+_i*_y),(int) (_x-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),(int) (_x-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
RDebugUtils.currentLine=5636118;
 //BA.debugLineNum = 5636118;BA.debugLine="ukupno = ukupno + 1";
_ukupno = (int) (_ukupno+1);
 }else {
RDebugUtils.currentLine=5636120;
 //BA.debugLineNum = 5636120;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 }
};
RDebugUtils.currentLine=5636124;
 //BA.debugLineNum = 5636124;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_keypress", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "activity_keypress", new Object[] {_keycode}));}
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK And pnlAppPodS";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK && mostCurrent._pnlapppodslovom.IsInitialized()) { 
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="If pnlAppPodSlovom.Visible = True Then";
if (mostCurrent._pnlapppodslovom.getVisible()==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="pnlAppPodSlovom.Visible = False";
mostCurrent._pnlapppodslovom.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="pnlSlova.Visible = True";
mostCurrent._pnlslova.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
RDebugUtils.currentLine=6225929;
 //BA.debugLineNum = 6225929;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=6225930;
 //BA.debugLineNum = 6225930;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="search";
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="End Sub";
return "";
}
public static String  _addtofavorites() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "addtofavorites", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "addtofavorites", null));}
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub AddToFavorites";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="CallSub(Main, \"DodajAppUFavorite\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._main.getObject()),"DodajAppUFavorite");
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="End Sub";
return "";
}
public static String  _btnslovo_click() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnslovo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnslovo_click", null));}
anywheresoftware.b4a.objects.ButtonWrapper _b = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.objects.collections.List _pkg1 = null;
anywheresoftware.b4a.objects.collections.List _pkg2 = null;
int _ukupno1 = 0;
int _ukupno2 = 0;
int _i = 0;
String _s = "";
String _pckg = "";
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _x = 0;
int _j = 0;
Object _drawable = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bdw = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub btnSlovo_Click";
RDebugUtils.currentLine=5898241;
 //BA.debugLineNum = 5898241;BA.debugLine="Dim b As Button";
_b = new anywheresoftware.b4a.objects.ButtonWrapper();
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="Dim pkg1, pkg2 As List";
_pkg1 = new anywheresoftware.b4a.objects.collections.List();
_pkg2 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="b = Sender";
_b.setObject((android.widget.Button)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="Log(b.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("35898246",BA.ObjectToString(_b.getTag()),0);
RDebugUtils.currentLine=5898247;
 //BA.debugLineNum = 5898247;BA.debugLine="pnlSlova.Visible = False";
mostCurrent._pnlslova.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5898248;
 //BA.debugLineNum = 5898248;BA.debugLine="pnlAppPodSlovom.Initialize(\"\")";
mostCurrent._pnlapppodslovom.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5898249;
 //BA.debugLineNum = 5898249;BA.debugLine="Activity.AddView(pnlAppPodSlovom, 0, 46dip, 100%x";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._pnlapppodslovom.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (46)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=5898250;
 //BA.debugLineNum = 5898250;BA.debugLine="Dim ukupno1, ukupno2 As Int = 0";
_ukupno1 = 0;
_ukupno2 = (int) (0);
RDebugUtils.currentLine=5898251;
 //BA.debugLineNum = 5898251;BA.debugLine="pkg1.Initialize";
_pkg1.Initialize();
RDebugUtils.currentLine=5898252;
 //BA.debugLineNum = 5898252;BA.debugLine="pkg2.Initialize";
_pkg2.Initialize();
RDebugUtils.currentLine=5898254;
 //BA.debugLineNum = 5898254;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
{
final int step12 = 1;
final int limit12 = (int) (mostCurrent._starter._mapa.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit12 ;_i = _i + step12 ) {
RDebugUtils.currentLine=5898255;
 //BA.debugLineNum = 5898255;BA.debugLine="Dim s As String = Starter.mapa.GetKeyAt(i)";
_s = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_i));
RDebugUtils.currentLine=5898256;
 //BA.debugLineNum = 5898256;BA.debugLine="If s.StartsWith(b.Tag) Then";
if (_s.startsWith(BA.ObjectToString(_b.getTag()))) { 
RDebugUtils.currentLine=5898257;
 //BA.debugLineNum = 5898257;BA.debugLine="ukupno1 = ukupno1 + 1";
_ukupno1 = (int) (_ukupno1+1);
RDebugUtils.currentLine=5898258;
 //BA.debugLineNum = 5898258;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
_pckg = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_i));
RDebugUtils.currentLine=5898260;
 //BA.debugLineNum = 5898260;BA.debugLine="pkg1.Add(pckg.SubString2(pckg.IndexOf(\";\")+1, p";
_pkg1.Add((Object)(_pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length())));
RDebugUtils.currentLine=5898262;
 //BA.debugLineNum = 5898262;BA.debugLine="pkg2.Add(pckg.SubString2(0, pckg.IndexOf(\";\")))";
_pkg2.Add((Object)(_pckg.substring((int) (0),_pckg.indexOf(";"))));
 };
 }
};
RDebugUtils.currentLine=5898266;
 //BA.debugLineNum = 5898266;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=5898267;
 //BA.debugLineNum = 5898267;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (211),(int) (211),(int) (211)),(int) (0));
RDebugUtils.currentLine=5898268;
 //BA.debugLineNum = 5898268;BA.debugLine="Dim x As Int";
_x = 0;
RDebugUtils.currentLine=5898269;
 //BA.debugLineNum = 5898269;BA.debugLine="x = Activity.Width / 5'pkg1.Size";
_x = (int) (mostCurrent._activity.getWidth()/(double)5);
RDebugUtils.currentLine=5898273;
 //BA.debugLineNum = 5898273;BA.debugLine="For i = 0 To pkg1.Size - 1";
{
final int step25 = 1;
final int limit25 = (int) (_pkg1.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit25 ;_i = _i + step25 ) {
RDebugUtils.currentLine=5898274;
 //BA.debugLineNum = 5898274;BA.debugLine="For j = 0 To 4";
{
final int step26 = 1;
final int limit26 = (int) (4);
_j = (int) (0) ;
for (;_j <= limit26 ;_j = _j + step26 ) {
RDebugUtils.currentLine=5898275;
 //BA.debugLineNum = 5898275;BA.debugLine="If ukupno2 < ukupno1 Then'pkg1.Size - 1 Then";
if (_ukupno2<_ukupno1) { 
RDebugUtils.currentLine=5898276;
 //BA.debugLineNum = 5898276;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon";
_drawable = (Object)(_pm.GetApplicationIcon(BA.ObjectToString(_pkg1.Get((int) (_i*5+_j)))));
RDebugUtils.currentLine=5898277;
 //BA.debugLineNum = 5898277;BA.debugLine="If drawable Is BitmapDrawable Then";
if (_drawable instanceof android.graphics.drawable.BitmapDrawable) { 
RDebugUtils.currentLine=5898278;
 //BA.debugLineNum = 5898278;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_drawable));
RDebugUtils.currentLine=5898279;
 //BA.debugLineNum = 5898279;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=5898280;
 //BA.debugLineNum = 5898280;BA.debugLine="bdw.Initialize(bmp.Resize(64dip, 64dip, True)";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (64))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (64))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=5898281;
 //BA.debugLineNum = 5898281;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=5898282;
 //BA.debugLineNum = 5898282;BA.debugLine="iv.Initialize(\"ivApp\")";
_iv.Initialize(mostCurrent.activityBA,"ivApp");
RDebugUtils.currentLine=5898283;
 //BA.debugLineNum = 5898283;BA.debugLine="iv.Bitmap = bdw.Bitmap";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=5898284;
 //BA.debugLineNum = 5898284;BA.debugLine="iv.Tag = pkg1.Get(i*5+j)";
_iv.setTag(_pkg1.Get((int) (_i*5+_j)));
RDebugUtils.currentLine=5898285;
 //BA.debugLineNum = 5898285;BA.debugLine="pnlAppPodSlovom.AddView(iv, x*j + j*2dip, x*i";
mostCurrent._pnlapppodslovom.AddView((android.view.View)(_iv.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(int) (_x*_i+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),_x,_x);
RDebugUtils.currentLine=5898286;
 //BA.debugLineNum = 5898286;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=5898287;
 //BA.debugLineNum = 5898287;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5898288;
 //BA.debugLineNum = 5898288;BA.debugLine="lbl.Text = pkg2.Get(i*5+j)";
_lbl.setText(BA.ObjectToCharSequence(_pkg2.Get((int) (_i*5+_j))));
RDebugUtils.currentLine=5898289;
 //BA.debugLineNum = 5898289;BA.debugLine="lbl.TextColor = Colors.White";
_lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=5898290;
 //BA.debugLineNum = 5898290;BA.debugLine="lbl.Background = cd";
_lbl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=5898291;
 //BA.debugLineNum = 5898291;BA.debugLine="lbl.TextSize = 12.0";
_lbl.setTextSize((float) (12.0));
RDebugUtils.currentLine=5898292;
 //BA.debugLineNum = 5898292;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
_lbl.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=5898293;
 //BA.debugLineNum = 5898293;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
_lbl.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL,anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=5898294;
 //BA.debugLineNum = 5898294;BA.debugLine="pnlAppPodSlovom.AddView(lbl, x*j, x*i + x + i";
mostCurrent._pnlapppodslovom.AddView((android.view.View)(_lbl.getObject()),(int) (_x*_j),(int) (_x*_i+_x+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))),_x,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 };
RDebugUtils.currentLine=5898297;
 //BA.debugLineNum = 5898297;BA.debugLine="ukupno2 = ukupno2 + 1";
_ukupno2 = (int) (_ukupno2+1);
 }else {
RDebugUtils.currentLine=5898299;
 //BA.debugLineNum = 5898299;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 }
};
RDebugUtils.currentLine=5898303;
 //BA.debugLineNum = 5898303;BA.debugLine="End Sub";
return "";
}
public static String  _btntrazi_click() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btntrazi_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btntrazi_click", null));}
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub btnTrazi_Click";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Log(\"trazi\")";
anywheresoftware.b4a.keywords.Common.LogImpl("35767169","trazi",0);
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="Trazi(traziString)";
_trazi(mostCurrent._trazistring);
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="End Sub";
return "";
}
public static String  _trazi(String _str) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "trazi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "trazi", new Object[] {_str}));}
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub Trazi(str As String)";
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="End Sub";
return "";
}
public static String  _edttrazi_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edttrazi_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edttrazi_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub edtTrazi_TextChanged (Old As String, New As St";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="If New.Length > 0 Then";
if (_new.length()>0) { 
RDebugUtils.currentLine=5701634;
 //BA.debugLineNum = 5701634;BA.debugLine="Log(New)";
anywheresoftware.b4a.keywords.Common.LogImpl("35701634",_new,0);
RDebugUtils.currentLine=5701635;
 //BA.debugLineNum = 5701635;BA.debugLine="traziString = New";
mostCurrent._trazistring = _new;
 };
RDebugUtils.currentLine=5701637;
 //BA.debugLineNum = 5701637;BA.debugLine="End Sub";
return "";
}
public static String  _ivapp_click() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivapp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivapp_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub ivApp_Click";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=5963779;
 //BA.debugLineNum = 5963779;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("35963782",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=5963783;
 //BA.debugLineNum = 5963783;BA.debugLine="in = pm.GetApplicationIntent(iv.Tag)";
_in = _pm.GetApplicationIntent(BA.ObjectToString(_iv.getTag()));
RDebugUtils.currentLine=5963784;
 //BA.debugLineNum = 5963784;BA.debugLine="If in.IsInitialized Then";
if (_in.IsInitialized()) { 
RDebugUtils.currentLine=5963785;
 //BA.debugLineNum = 5963785;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=5963787;
 //BA.debugLineNum = 5963787;BA.debugLine="End Sub";
return "";
}
public static String  _ivapp_longclick() throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivapp_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivapp_longclick", null));}
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.objects.collections.List _ll = null;
com.maximus.id.id _x = null;
int _m = 0;
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub ivApp_LongClick";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="Log(\"long klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("36029313","long klik!",0);
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=6029315;
 //BA.debugLineNum = 6029315;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("36029316",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=6029317;
 //BA.debugLineNum = 6029317;BA.debugLine="Dim ll As List";
_ll = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="ll.Initialize";
_ll.Initialize();
RDebugUtils.currentLine=6029319;
 //BA.debugLineNum = 6029319;BA.debugLine="ll.AddAll(Array As String(\"Add to favorites\", \"Un";
_ll.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Add to favorites","Uninstall"}));
RDebugUtils.currentLine=6029320;
 //BA.debugLineNum = 6029320;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=6029321;
 //BA.debugLineNum = 6029321;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
_m = _x.InputList1(_ll,"",mostCurrent.activityBA);
RDebugUtils.currentLine=6029322;
 //BA.debugLineNum = 6029322;BA.debugLine="Select m";
switch (_m) {
case 0: {
RDebugUtils.currentLine=6029324;
 //BA.debugLineNum = 6029324;BA.debugLine="AddToFavorites";
_addtofavorites();
 break; }
case 1: {
RDebugUtils.currentLine=6029326;
 //BA.debugLineNum = 6029326;BA.debugLine="UninstallApp(iv.Tag)";
_uninstallapp(BA.ObjectToString(_iv.getTag()));
 break; }
}
;
RDebugUtils.currentLine=6029328;
 //BA.debugLineNum = 6029328;BA.debugLine="End Sub";
return "";
}
public static String  _uninstallapp(String _pkg) throws Exception{
RDebugUtils.currentModule="search";
if (Debug.shouldDelegate(mostCurrent.activityBA, "uninstallapp", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "uninstallapp", new Object[] {_pkg}));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub UninstallApp(pkg As String)";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="If IsPaused(provjera) = True Then StartService(pr";
if (anywheresoftware.b4a.keywords.Common.IsPaused(processBA,(Object)(mostCurrent._provjera.getObject()))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(mostCurrent._provjera.getObject()));};
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="Log(\"package:\" & pkg)";
anywheresoftware.b4a.keywords.Common.LogImpl("36160389","package:"+_pkg,0);
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="i.Initialize(\"android.intent.action.DELETE\", \"pac";
_i.Initialize("android.intent.action.DELETE","package:"+_pkg);
RDebugUtils.currentLine=6160392;
 //BA.debugLineNum = 6160392;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=6160394;
 //BA.debugLineNum = 6160394;BA.debugLine="pnlAppPodSlovom.Visible = False";
mostCurrent._pnlapppodslovom.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6160395;
 //BA.debugLineNum = 6160395;BA.debugLine="pnlAppPodSlovom.RemoveAllViews";
mostCurrent._pnlapppodslovom.RemoveAllViews();
RDebugUtils.currentLine=6160396;
 //BA.debugLineNum = 6160396;BA.debugLine="pnlSlova.Visible = True";
mostCurrent._pnlslova.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6160397;
 //BA.debugLineNum = 6160397;BA.debugLine="pnlSlova.RemoveAllViews";
mostCurrent._pnlslova.RemoveAllViews();
RDebugUtils.currentLine=6160398;
 //BA.debugLineNum = 6160398;BA.debugLine="DodajSlova";
_dodajslova();
RDebugUtils.currentLine=6160399;
 //BA.debugLineNum = 6160399;BA.debugLine="End Sub";
return "";
}
}