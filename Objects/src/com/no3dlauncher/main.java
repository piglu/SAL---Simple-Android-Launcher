package com.no3dlauncher;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.Path.FillType;
import android.graphics.Paint;
import android.graphics.Color;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.provider.MediaStore.Images;
import android.text.TextUtils;
import android.view.Gravity;
import android.content.res.Resources;
import android.util.TypedValue;
import android.util.DisplayMetrics;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.Path.FillType;
import android.graphics.Path;

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

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "com.no3dlauncher", "com.no3dlauncher.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
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
		activityBA = new BA(this, layout, processBA, "com.no3dlauncher", "com.no3dlauncher.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.no3dlauncher.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
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
		return main.class;
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
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
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
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
vis = vis | (pnlmeni_postavke.mostCurrent != null);
vis = vis | (search.mostCurrent != null);
vis = vis | (postavke_kontakti.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
 {
            Activity __a = null;
            if (pnlmeni_postavke.previousOne != null) {
				__a = pnlmeni_postavke.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(pnlmeni_postavke.mostCurrent == null ? null : pnlmeni_postavke.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

 {
            Activity __a = null;
            if (search.previousOne != null) {
				__a = search.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(search.mostCurrent == null ? null : search.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, notificationservice.class));
 {
            Activity __a = null;
            if (postavke_kontakti.previousOne != null) {
				__a = postavke_kontakti.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(postavke_kontakti.mostCurrent == null ? null : postavke_kontakti.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, provjera.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.object.JavaObject _nativeme = null;
public static com.rootsoft.rssmartwidgets.RSSmartWidgets _smartwidgets = null;
public static anywheresoftware.b4a.objects.Timer _tajmer1 = null;
public static com.no3dlauncher.contactsutils _cu = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldock = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndock = null;
public anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _scvdock = null;
public static boolean _pnl_dock_vidljiv = false;
public anywheresoftware.b4a.objects.ButtonWrapper _btnmeni = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnwidgeti = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmeni = null;
public static int _zadnja_oznacena_app = 0;
public wheelpickerwrapper.wheelpickerWrapper _wp1 = null;
public anywheresoftware.b4a.objects.collections.List _l = null;
public anywheresoftware.b4a.objects.collections.List _l1 = null;
public b4a.example3.customlistview _clv = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblimeapp = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivapp = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivdodaj = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _ivwheeldodaj = null;
public anywheresoftware.b4a.objects.collections.List _iv_size = null;
public anywheresoftware.b4a.objects.collections.List _listafavorita = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnsearch = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnpostavke = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnotify = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
public anywheresoftware.b4a.objects.TabStripViewPager _tabstrip1 = null;
public static int _topw = 0;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public static int _ipsilon = 0;
public anywheresoftware.b4a.objects.ButtonWrapper _btndodajwidget = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btndodajstr = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnatrag = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnnaprijed = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.ContentResolverWrapper _cr = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnpostavkekontakti = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlkontakti = null;
public njdude.customgridview.library.customgridview _grid = null;
public com.no3dlauncher.fanmenu _fomenu = null;
public anywheresoftware.b4a.objects.PanelWrapper _menupanel = null;
public com.no3dlauncher.starter _starter = null;
public com.no3dlauncher.pnlmeni_postavke _pnlmeni_postavke = null;
public com.no3dlauncher.search _search = null;
public com.no3dlauncher.notificationservice _notificationservice = null;
public com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public com.no3dlauncher.f _f = null;
public com.no3dlauncher.provjera _provjera = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.agraham.reflection.Reflection _reflect = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int[] _res = null;
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131073;
 //BA.debugLineNum = 131073;BA.debugLine="Activity.LoadLayout(\"tabs\")";
mostCurrent._activity.LoadLayout("tabs",mostCurrent.activityBA);
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="cu.Initialize";
_cu._initialize(null,processBA);
 };
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="TabStrip1.LoadLayout(\"mejn\", \"Main\")";
mostCurrent._tabstrip1.LoadLayout("mejn",BA.ObjectToCharSequence("Main"));
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="TabStrip1.LoadLayout(\"kontakti\", \"Contacts\")";
mostCurrent._tabstrip1.LoadLayout("kontakti",BA.ObjectToCharSequence("Contacts"));
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="TabStrip1.LoadLayout(\"widget_panel\", \"Widgets\")";
mostCurrent._tabstrip1.LoadLayout("widget_panel",BA.ObjectToCharSequence("Widgets"));
RDebugUtils.currentLine=131086;
 //BA.debugLineNum = 131086;BA.debugLine="Dim reflect As Reflector";
_reflect = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=131087;
 //BA.debugLineNum = 131087;BA.debugLine="reflect.Target = scvDock.Panel";
_reflect.Target = (Object)(mostCurrent._scvdock.getPanel().getObject());
RDebugUtils.currentLine=131088;
 //BA.debugLineNum = 131088;BA.debugLine="reflect.SetOnTouchListener(\"scvPanel_Touch\")";
_reflect.SetOnTouchListener(processBA,"scvPanel_Touch");
RDebugUtils.currentLine=131101;
 //BA.debugLineNum = 131101;BA.debugLine="nativeMe.InitializeContext";
_nativeme.InitializeContext(processBA);
RDebugUtils.currentLine=131103;
 //BA.debugLineNum = 131103;BA.debugLine="f.UcitajVrijednostiOpt";
mostCurrent._f._ucitajvrijednostiopt(mostCurrent.activityBA);
RDebugUtils.currentLine=131105;
 //BA.debugLineNum = 131105;BA.debugLine="Log(\"f.animStr: \" & f.animStr)";
anywheresoftware.b4a.keywords.Common.LogImpl("7131105","f.animStr: "+mostCurrent._f._animstr,0);
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="Log(\"f.brStranica: \" & f.brStranica)";
anywheresoftware.b4a.keywords.Common.LogImpl("7131108","f.brStranica: "+BA.NumberToString(mostCurrent._f._brstranica),0);
RDebugUtils.currentLine=131119;
 //BA.debugLineNum = 131119;BA.debugLine="TabStrip1_PageSelected(0)";
_tabstrip1_pageselected((int) (0));
RDebugUtils.currentLine=131142;
 //BA.debugLineNum = 131142;BA.debugLine="pnlMeni.Visible = False";
mostCurrent._pnlmeni.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=131144;
 //BA.debugLineNum = 131144;BA.debugLine="If Starter.mapa.IsInitialized Then";
if (mostCurrent._starter._mapa.IsInitialized()) { 
RDebugUtils.currentLine=131145;
 //BA.debugLineNum = 131145;BA.debugLine="If Starter.mapa.Size = 0 Then";
if (mostCurrent._starter._mapa.getSize()==0) { 
RDebugUtils.currentLine=131146;
 //BA.debugLineNum = 131146;BA.debugLine="CallSub(Starter, \"GetInstalledApps\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._starter.getObject()),"GetInstalledApps");
 };
 }else {
RDebugUtils.currentLine=131149;
 //BA.debugLineNum = 131149;BA.debugLine="CallSub(Starter, \"GetInstalledApps\")";
anywheresoftware.b4a.keywords.Common.CallSubDebug(processBA,(Object)(mostCurrent._starter.getObject()),"GetInstalledApps");
 };
RDebugUtils.currentLine=131164;
 //BA.debugLineNum = 131164;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=131165;
 //BA.debugLineNum = 131165;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=131166;
 //BA.debugLineNum = 131166;BA.debugLine="res = getARGB(f.bojaPozadine)";
_res = _getargb(mostCurrent._f._bojapozadine);
RDebugUtils.currentLine=131167;
 //BA.debugLineNum = 131167;BA.debugLine="res(0) = f.trans";
_res[(int) (0)] = mostCurrent._f._trans;
RDebugUtils.currentLine=131168;
 //BA.debugLineNum = 131168;BA.debugLine="cd.Initialize(Colors.ARGB(res(0), res(1), res(2),";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB(_res[(int) (0)],_res[(int) (1)],_res[(int) (2)],_res[(int) (3)]),(int) (0));
RDebugUtils.currentLine=131169;
 //BA.debugLineNum = 131169;BA.debugLine="pnlMeni.Background = cd";
mostCurrent._pnlmeni.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=131171;
 //BA.debugLineNum = 131171;BA.debugLine="iv_size.Initialize";
mostCurrent._iv_size.Initialize();
RDebugUtils.currentLine=131172;
 //BA.debugLineNum = 131172;BA.debugLine="listaFavorita.Initialize";
mostCurrent._listafavorita.Initialize();
RDebugUtils.currentLine=131174;
 //BA.debugLineNum = 131174;BA.debugLine="ViewsBringToFront";
_viewsbringtofront();
RDebugUtils.currentLine=131176;
 //BA.debugLineNum = 131176;BA.debugLine="ShowFavoriteApps";
_showfavoriteapps();
RDebugUtils.currentLine=131177;
 //BA.debugLineNum = 131177;BA.debugLine="btnDock_Click";
_btndock_click();
RDebugUtils.currentLine=131179;
 //BA.debugLineNum = 131179;BA.debugLine="tajmer1.Initialize(\"tajmer\", 5000)";
_tajmer1.Initialize(processBA,"tajmer",(long) (5000));
RDebugUtils.currentLine=131180;
 //BA.debugLineNum = 131180;BA.debugLine="tajmer1.Enabled = True";
_tajmer1.setEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=131184;
 //BA.debugLineNum = 131184;BA.debugLine="cr.Initialize(\"cr\")";
mostCurrent._cr.Initialize("cr");
RDebugUtils.currentLine=131185;
 //BA.debugLineNum = 131185;BA.debugLine="End Sub";
return "";
}
public static String  _tabstrip1_pageselected(int _position) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tabstrip1_pageselected", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tabstrip1_pageselected", new Object[] {_position}));}
int _i = 0;
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub TabStrip1_PageSelected (Position As Int)";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="Log($\"Current page: ${Position}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("74980737",("Current page: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_position))+""),0);
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="For Each lbl As Label In GetAllTabLabels(TabStrip";
mostCurrent._lbl = new anywheresoftware.b4a.objects.LabelWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _getalltablabels(mostCurrent._tabstrip1);
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
mostCurrent._lbl.setObject((android.widget.TextView)(group3.Get(index3)));
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="If i = Position Then lbl.TextColor = Colors.Blue";
if (_i==_position) { 
mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);}
else {
mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);};
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 }
};
RDebugUtils.currentLine=4980743;
 //BA.debugLineNum = 4980743;BA.debugLine="If TabStrip1.CurrentPage = 1 And pnlKontakti.Numb";
if (mostCurrent._tabstrip1.getCurrentPage()==1 && mostCurrent._pnlkontakti.getNumberOfViews()==0) { 
RDebugUtils.currentLine=4980744;
 //BA.debugLineNum = 4980744;BA.debugLine="UbaciKontakte2";
_ubacikontakte2();
 };
RDebugUtils.currentLine=4980746;
 //BA.debugLineNum = 4980746;BA.debugLine="End Sub";
return "";
}
public static int[]  _getargb(int _color) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getargb", false))
	 {return ((int[]) Debug.delegate(mostCurrent.activityBA, "getargb", new Object[] {_color}));}
int[] _res = null;
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub getARGB(Color As Int) As Int()";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (0)] = anywheresoftware.b4a.keywords.Common.Bit.UnsignedShiftRight(anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff000000)),(int) (24));
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (1)] = anywheresoftware.b4a.keywords.Common.Bit.UnsignedShiftRight(anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff0000)),(int) (16));
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (2)] = anywheresoftware.b4a.keywords.Common.Bit.UnsignedShiftRight(anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff00)),(int) (8));
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="res(3) = Bit.And(Color, 0xff)";
_res[(int) (3)] = anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff));
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=4718601;
 //BA.debugLineNum = 4718601;BA.debugLine="End Sub";
return null;
}
public static String  _viewsbringtofront() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "viewsbringtofront", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "viewsbringtofront", null));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub ViewsBringToFront";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="btnSearch.BringToFront";
mostCurrent._btnsearch.BringToFront();
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="btnNotify.BringToFront";
mostCurrent._btnnotify.BringToFront();
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="btnPostavke.BringToFront";
mostCurrent._btnpostavke.BringToFront();
RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="End Sub";
return "";
}
public static String  _showfavoriteapps() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "showfavoriteapps", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "showfavoriteapps", null));}
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _i = 0;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bdw = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Private Sub ShowFavoriteApps";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="File.Delete(File.DirInternal, \"favorit_app\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app");
RDebugUtils.currentLine=3014663;
 //BA.debugLineNum = 3014663;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=3014664;
 //BA.debugLineNum = 3014664;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (211),(int) (211),(int) (211)),(int) (0));
RDebugUtils.currentLine=3014665;
 //BA.debugLineNum = 3014665;BA.debugLine="If File.Exists(File.DirInternal, \"favorit_app\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app")) { 
RDebugUtils.currentLine=3014666;
 //BA.debugLineNum = 3014666;BA.debugLine="listaFavorita = File.ReadList(File.DirInternal,";
mostCurrent._listafavorita = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app");
RDebugUtils.currentLine=3014667;
 //BA.debugLineNum = 3014667;BA.debugLine="For i = 0 To listaFavorita.Size - 1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._listafavorita.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=3014685;
 //BA.debugLineNum = 3014685;BA.debugLine="iv.Initialize(\"ivDokPokreniApp\")";
_iv.Initialize(mostCurrent.activityBA,"ivDokPokreniApp");
RDebugUtils.currentLine=3014687;
 //BA.debugLineNum = 3014687;BA.debugLine="iv.Tag = i";
_iv.setTag((Object)(_i));
RDebugUtils.currentLine=3014688;
 //BA.debugLineNum = 3014688;BA.debugLine="iv.Width = 48dip";
_iv.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=3014689;
 //BA.debugLineNum = 3014689;BA.debugLine="iv.Height = 48dip";
_iv.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=3014690;
 //BA.debugLineNum = 3014690;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=3014699;
 //BA.debugLineNum = 3014699;BA.debugLine="Dim bdw As BitmapDrawable = pm.GetApplicationIc";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_pm.GetApplicationIcon(BA.ObjectToString(mostCurrent._listafavorita.Get(_i)))));
RDebugUtils.currentLine=3014700;
 //BA.debugLineNum = 3014700;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=3014701;
 //BA.debugLineNum = 3014701;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True))";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3014702;
 //BA.debugLineNum = 3014702;BA.debugLine="iv.Bitmap = bdw.Bitmap";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=3014722;
 //BA.debugLineNum = 3014722;BA.debugLine="scvDock.Panel.AddView(iv, iv.Width*i + i*10dip,";
mostCurrent._scvdock.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_iv.getWidth()*_i+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4)),_iv.getWidth(),_iv.getHeight());
 }
};
RDebugUtils.currentLine=3014725;
 //BA.debugLineNum = 3014725;BA.debugLine="scvDock.Panel.Width = scvDock.Panel.NumberOfView";
mostCurrent._scvdock.getPanel().setWidth((int) (mostCurrent._scvdock.getPanel().getNumberOfViews()*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))+mostCurrent._scvdock.getPanel().getNumberOfViews()*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 }else {
RDebugUtils.currentLine=3014728;
 //BA.debugLineNum = 3014728;BA.debugLine="lbl.Initialize(\"\")";
mostCurrent._lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3014729;
 //BA.debugLineNum = 3014729;BA.debugLine="lbl.Text = \"Add some apps here (long click on ap";
mostCurrent._lbl.setText(BA.ObjectToCharSequence("Add some apps here (long click on app icon in search window -> 'Add to favorites' or tap '+' in list of all applications)"));
RDebugUtils.currentLine=3014730;
 //BA.debugLineNum = 3014730;BA.debugLine="lbl.TextColor = Colors.yellow'Red";
mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Yellow);
RDebugUtils.currentLine=3014731;
 //BA.debugLineNum = 3014731;BA.debugLine="lbl.TextSize = 12.0";
mostCurrent._lbl.setTextSize((float) (12.0));
RDebugUtils.currentLine=3014732;
 //BA.debugLineNum = 3014732;BA.debugLine="scvDock.Panel.AddView(lbl, 0, 0, scvDock.Width,";
mostCurrent._scvdock.getPanel().AddView((android.view.View)(mostCurrent._lbl.getObject()),(int) (0),(int) (0),mostCurrent._scvdock.getWidth(),mostCurrent._scvdock.getHeight());
RDebugUtils.currentLine=3014733;
 //BA.debugLineNum = 3014733;BA.debugLine="scvDock.Panel.Width = 100%x";
mostCurrent._scvdock.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 };
RDebugUtils.currentLine=3014737;
 //BA.debugLineNum = 3014737;BA.debugLine="End Sub";
return "";
}
public static String  _btndock_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btndock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btndock_click", null));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub btnDock_Click";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="If pnl_dock_vidljiv Then";
if (_pnl_dock_vidljiv) { 
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="btnDock.SendToBack";
mostCurrent._btndock.SendToBack();
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="pnlDock.SendToBack";
mostCurrent._pnldock.SendToBack();
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="pnl_dock_vidljiv = False";
_pnl_dock_vidljiv = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="btnDock.SetBackgroundImage(LoadBitmap(File.DirAs";
mostCurrent._btndock.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"scvdock_otvori.png").getObject()));
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="pnlDock.SetLayoutAnimated(500, 15%x, 100%y - pnl";
mostCurrent._pnldock.SetLayoutAnimated((int) (500),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnldock.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65))),mostCurrent._pnldock.getWidth(),mostCurrent._pnldock.getHeight());
 }else {
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="btnDock.BringToFront";
mostCurrent._btndock.BringToFront();
RDebugUtils.currentLine=3080201;
 //BA.debugLineNum = 3080201;BA.debugLine="pnlDock.BringToFront";
mostCurrent._pnldock.BringToFront();
RDebugUtils.currentLine=3080202;
 //BA.debugLineNum = 3080202;BA.debugLine="pnlMeni.Visible = False";
mostCurrent._pnlmeni.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3080203;
 //BA.debugLineNum = 3080203;BA.debugLine="pnl_dock_vidljiv = True";
_pnl_dock_vidljiv = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=3080204;
 //BA.debugLineNum = 3080204;BA.debugLine="btnDock.SetBackgroundImage(LoadBitmap(File.DirAs";
mostCurrent._btndock.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"scvdock_zatvori.png").getObject()));
RDebugUtils.currentLine=3080205;
 //BA.debugLineNum = 3080205;BA.debugLine="pnlDock.SetLayoutAnimated(500, 15%x, 100%y - pnl";
mostCurrent._pnldock.SetLayoutAnimated((int) (500),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnldock.getHeight()),mostCurrent._pnldock.getWidth(),mostCurrent._pnldock.getHeight());
 };
RDebugUtils.currentLine=3080207;
 //BA.debugLineNum = 3080207;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262150;
 //BA.debugLineNum = 262150;BA.debugLine="End Sub";
return "";
}
public static String  _activity_permissionresult(String _permission,boolean _result) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_permissionresult", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_permissionresult", new Object[] {_permission,_result}));}
RDebugUtils.currentLine=13762560;
 //BA.debugLineNum = 13762560;BA.debugLine="Sub Activity_PermissionResult (Permission As Strin";
RDebugUtils.currentLine=13762564;
 //BA.debugLineNum = 13762564;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.drawable.BitmapDrawable  _bitmaptobitmapdrawable(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmd) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "bitmaptobitmapdrawable", false))
	 {return ((anywheresoftware.b4a.objects.drawable.BitmapDrawable) Debug.delegate(mostCurrent.activityBA, "bitmaptobitmapdrawable", new Object[] {_bmd}));}
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bd = null;
RDebugUtils.currentLine=14155776;
 //BA.debugLineNum = 14155776;BA.debugLine="Sub BitmapToBitmapDrawable(BMD As Bitmap) As Bitma";
RDebugUtils.currentLine=14155777;
 //BA.debugLineNum = 14155777;BA.debugLine="Dim BD As BitmapDrawable";
_bd = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
RDebugUtils.currentLine=14155778;
 //BA.debugLineNum = 14155778;BA.debugLine="BD.Initialize(BMD)";
_bd.Initialize((android.graphics.Bitmap)(_bmd.getObject()));
RDebugUtils.currentLine=14155780;
 //BA.debugLineNum = 14155780;BA.debugLine="Return BD";
if (true) return _bd;
RDebugUtils.currentLine=14155781;
 //BA.debugLineNum = 14155781;BA.debugLine="End Sub";
return null;
}
public static String  _btnclearall_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnclearall_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnclearall_click", null));}
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub btnClearAll_Click";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="CallSubDelayed(NotificationService, \"ClearAll\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._notificationservice.getObject()),"ClearAll");
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="End Sub";
return "";
}
public static String  _btndodajstr_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btndodajstr_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btndodajstr_click", null));}
RDebugUtils.currentLine=5505024;
 //BA.debugLineNum = 5505024;BA.debugLine="Sub btnDodajStr_Click";
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="Log(\"btnDodajStr_Click\")";
anywheresoftware.b4a.keywords.Common.LogImpl("75505025","btnDodajStr_Click",0);
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="End Sub";
return "";
}
public static String  _btndodajwidget_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btndodajwidget_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btndodajwidget_click", null));}
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub btnDodajWidget_Click";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="If Panel1.Visible Then";
if (mostCurrent._panel1.getVisible()) { 
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="CreateSmartWidget(1)";
_createsmartwidget((int) (1));
 };
RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="End Sub";
return "";
}
public static String  _createsmartwidget(int _id) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createsmartwidget", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "createsmartwidget", new Object[] {_id}));}
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub CreateSmartWidget(id As Int)";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="SmartWidgets.Initialize(\"SmartWidgets\", id)";
_smartwidgets.Initialize(processBA,"SmartWidgets",_id);
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="SmartWidgets.SelectWidget";
_smartwidgets.SelectWidget();
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="End Sub";
return "";
}
public static String  _btninfo_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btninfo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btninfo_click", null));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub btnInfo_Click";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="Log(\"btnInfo klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("73276801","btnInfo klik!",0);
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="End Sub";
return "";
}
public static String  _btnkontaktemail_click(String _ajtemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnkontaktemail_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnkontaktemail_click", new Object[] {_ajtemid}));}
anywheresoftware.b4a.phone.Phone.Email _msg = null;
anywheresoftware.b4a.objects.collections.List _lemail = null;
anywheresoftware.b4a.objects.collections.List _allcontactemails = null;
com.no3dlauncher.contactsutils._cuemail _c = null;
String _adresa = "";
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub btnKontaktEmail_Click(ajtemID As String)";
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="Dim msg As Email";
_msg = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="Dim lEmail As List";
_lemail = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="lEmail.Initialize";
_lemail.Initialize();
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="Dim allContactEmails As List = cu.GetEmails(ajtem";
_allcontactemails = new anywheresoftware.b4a.objects.collections.List();
_allcontactemails = _cu._getemails(null,(long)(Double.parseDouble(_ajtemid)));
RDebugUtils.currentLine=6094855;
 //BA.debugLineNum = 6094855;BA.debugLine="If allContactEmails.Size > 0 Then";
if (_allcontactemails.getSize()>0) { 
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="For Each c As cuEmail In allContactEmails";
{
final anywheresoftware.b4a.BA.IterableList group6 = _allcontactemails;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_c = (com.no3dlauncher.contactsutils._cuemail)(group6.Get(index6));
RDebugUtils.currentLine=6094857;
 //BA.debugLineNum = 6094857;BA.debugLine="lEmail.Add(c.Email)";
_lemail.Add((Object)(_c.Email));
 }
};
RDebugUtils.currentLine=6094860;
 //BA.debugLineNum = 6094860;BA.debugLine="If lEmail.Size = 1 Then";
if (_lemail.getSize()==1) { 
RDebugUtils.currentLine=6094861;
 //BA.debugLineNum = 6094861;BA.debugLine="msg.To.Add(c.Email)";
_msg.To.Add((Object)(_c.Email));
RDebugUtils.currentLine=6094862;
 //BA.debugLineNum = 6094862;BA.debugLine="StartActivity(msg.GetIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_msg.GetIntent()));
 }else {
RDebugUtils.currentLine=6094865;
 //BA.debugLineNum = 6094865;BA.debugLine="Dim adresa As String = PrikaziListuEmailAdresaU";
_adresa = _prikazilistuemailadresaudijalogu(_lemail);
RDebugUtils.currentLine=6094866;
 //BA.debugLineNum = 6094866;BA.debugLine="If adresa.EqualsIgnoreCase(\"false\") = False The";
if (_adresa.equalsIgnoreCase("false")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=6094867;
 //BA.debugLineNum = 6094867;BA.debugLine="msg.To.Add(adresa)";
_msg.To.Add((Object)(_adresa));
RDebugUtils.currentLine=6094868;
 //BA.debugLineNum = 6094868;BA.debugLine="StartActivity(msg.GetIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_msg.GetIntent()));
 }else {
RDebugUtils.currentLine=6094870;
 //BA.debugLineNum = 6094870;BA.debugLine="ToastMessageShow(\"You didn't choose email addr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("You didn't choose email address!"),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 }else {
RDebugUtils.currentLine=6094874;
 //BA.debugLineNum = 6094874;BA.debugLine="ToastMessageShow(\"No email address!\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No email address!"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=6094876;
 //BA.debugLineNum = 6094876;BA.debugLine="End Sub";
return "";
}
public static String  _prikazilistuemailadresaudijalogu(anywheresoftware.b4a.objects.collections.List _listaadresa) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "prikazilistuemailadresaudijalogu", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "prikazilistuemailadresaudijalogu", new Object[] {_listaadresa}));}
com.maximus.id.id _x = null;
int _m = 0;
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub PrikaziListuEmailAdresaUDijalogu(listaAdresa A";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="Dim m As Int = x.InputList1(listaAdresa, \"\")";
_m = _x.InputList1(_listaadresa,"",mostCurrent.activityBA);
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="If m >= 0 Then";
if (_m>=0) { 
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="Return listaAdresa.Get(m)";
if (true) return BA.ObjectToString(_listaadresa.Get(_m));
 }else {
RDebugUtils.currentLine=6160392;
 //BA.debugLineNum = 6160392;BA.debugLine="Return False";
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=6160394;
 //BA.debugLineNum = 6160394;BA.debugLine="End Sub";
return "";
}
public static String  _btnkontaktinfo_click(String _ajtemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnkontaktinfo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnkontaktinfo_click", new Object[] {_ajtemid}));}
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub btnKontaktInfo_Click(ajtemID As String)";
RDebugUtils.currentLine=5898243;
 //BA.debugLineNum = 5898243;BA.debugLine="Log(\"GetAccounts: \" & cu.GetAccounts(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("75898243","GetAccounts: "+BA.ObjectToString(_cu._getaccounts(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=5898244;
 //BA.debugLineNum = 5898244;BA.debugLine="Log(\"GetEmails: \" & cu.GetEmails(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("75898244","GetEmails: "+BA.ObjectToString(_cu._getemails(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=5898245;
 //BA.debugLineNum = 5898245;BA.debugLine="Log(\"GetEvents: \" & cu.GetEvents(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("75898245","GetEvents: "+BA.ObjectToString(_cu._getevents(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=5898246;
 //BA.debugLineNum = 5898246;BA.debugLine="Log(\"GetGroups: \" & cu.GetGroups(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("75898246","GetGroups: "+BA.ObjectToString(_cu._getgroups(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=5898247;
 //BA.debugLineNum = 5898247;BA.debugLine="Log(\"GetNameFromId: \" & cu.GetNameFromId(ajtemID)";
anywheresoftware.b4a.keywords.Common.LogImpl("75898247","GetNameFromId: "+_cu._getnamefromid(null,_ajtemid),0);
RDebugUtils.currentLine=5898248;
 //BA.debugLineNum = 5898248;BA.debugLine="Log(\"GetNote: \" & cu.GetNote(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("75898248","GetNote: "+_cu._getnote(null,(long)(Double.parseDouble(_ajtemid))),0);
RDebugUtils.currentLine=5898249;
 //BA.debugLineNum = 5898249;BA.debugLine="Log(\"GetOrganization :\" & cu.GetOrganization(ajte";
anywheresoftware.b4a.keywords.Common.LogImpl("75898249","GetOrganization :"+BA.ObjectToString(_cu._getorganization(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=5898250;
 //BA.debugLineNum = 5898250;BA.debugLine="Log(\"GetPhones: \" & cu.GetPhones(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("75898250","GetPhones: "+BA.ObjectToString(_cu._getphones(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=5898251;
 //BA.debugLineNum = 5898251;BA.debugLine="Log(\"GetStarred: \" & cu.GetStarred(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("75898251","GetStarred: "+BA.ObjectToString(_cu._getstarred(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=5898252;
 //BA.debugLineNum = 5898252;BA.debugLine="End Sub";
return "";
}
public static String  _btnkontaktpoziv_click(String _ajtemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnkontaktpoziv_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnkontaktpoziv_click", new Object[] {_ajtemid}));}
anywheresoftware.b4a.phone.Phone.PhoneCalls _pc = null;
anywheresoftware.b4a.objects.collections.List _lfoun = null;
anywheresoftware.b4a.objects.collections.List _allphones = null;
com.no3dlauncher.contactsutils._cuphone _phone = null;
String _broj_tel = "";
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub btnKontaktPoziv_Click(ajtemID As String)";
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="Dim pc As PhoneCalls";
_pc = new anywheresoftware.b4a.phone.Phone.PhoneCalls();
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="Dim lFoun As List";
_lfoun = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5963781;
 //BA.debugLineNum = 5963781;BA.debugLine="lFoun.Initialize";
_lfoun.Initialize();
RDebugUtils.currentLine=5963782;
 //BA.debugLineNum = 5963782;BA.debugLine="Dim allPhones As List = cu.GetPhones(ajtemID)";
_allphones = new anywheresoftware.b4a.objects.collections.List();
_allphones = _cu._getphones(null,(long)(Double.parseDouble(_ajtemid)));
RDebugUtils.currentLine=5963783;
 //BA.debugLineNum = 5963783;BA.debugLine="If allPhones.Size > 0 Then";
if (_allphones.getSize()>0) { 
RDebugUtils.currentLine=5963784;
 //BA.debugLineNum = 5963784;BA.debugLine="For Each phone As cuPhone In cu.GetPhones(ajtemI";
{
final anywheresoftware.b4a.BA.IterableList group6 = _cu._getphones(null,(long)(Double.parseDouble(_ajtemid)));
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_phone = (com.no3dlauncher.contactsutils._cuphone)(group6.Get(index6));
RDebugUtils.currentLine=5963786;
 //BA.debugLineNum = 5963786;BA.debugLine="lFoun.Add(phone.Number)";
_lfoun.Add((Object)(_phone.Number));
 }
};
RDebugUtils.currentLine=5963788;
 //BA.debugLineNum = 5963788;BA.debugLine="If lFoun.Size = 1 Then";
if (_lfoun.getSize()==1) { 
RDebugUtils.currentLine=5963789;
 //BA.debugLineNum = 5963789;BA.debugLine="StartActivity(pc.Call(lFoun.Get(0)))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_pc.Call(BA.ObjectToString(_lfoun.Get((int) (0))))));
 }else {
RDebugUtils.currentLine=5963791;
 //BA.debugLineNum = 5963791;BA.debugLine="Dim broj_tel As String = PrikaziListuBrojevaTel";
_broj_tel = _prikazilistubrojevatelefona(_lfoun);
RDebugUtils.currentLine=5963792;
 //BA.debugLineNum = 5963792;BA.debugLine="StartActivity(pc.Call(broj_tel))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_pc.Call(_broj_tel)));
 };
 }else {
RDebugUtils.currentLine=5963795;
 //BA.debugLineNum = 5963795;BA.debugLine="ToastMessageShow(\"No phone!\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No phone!"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=5963797;
 //BA.debugLineNum = 5963797;BA.debugLine="End Sub";
return "";
}
public static String  _prikazilistubrojevatelefona(anywheresoftware.b4a.objects.collections.List _listabrojeva) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "prikazilistubrojevatelefona", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "prikazilistubrojevatelefona", new Object[] {_listabrojeva}));}
com.maximus.id.id _x = null;
int _m = 0;
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub PrikaziListuBrojevaTelefona(listaBrojeva As Li";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="Dim m As Int = x.InputList1(listaBrojeva, \"\")";
_m = _x.InputList1(_listabrojeva,"",mostCurrent.activityBA);
RDebugUtils.currentLine=6225925;
 //BA.debugLineNum = 6225925;BA.debugLine="If m >= 0 Then";
if (_m>=0) { 
RDebugUtils.currentLine=6225926;
 //BA.debugLineNum = 6225926;BA.debugLine="Return listaBrojeva.Get(m)";
if (true) return BA.ObjectToString(_listabrojeva.Get(_m));
 }else {
RDebugUtils.currentLine=6225928;
 //BA.debugLineNum = 6225928;BA.debugLine="Return False";
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=6225930;
 //BA.debugLineNum = 6225930;BA.debugLine="End Sub";
return "";
}
public static String  _btnkontaktsms_click(String _ajtemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnkontaktsms_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnkontaktsms_click", new Object[] {_ajtemid}));}
anywheresoftware.b4a.objects.IntentWrapper _intent1 = null;
com.no3dlauncher.contactsutils._cuphone _phone = null;
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub btnKontaktSMS_Click(ajtemID As String)";
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="Dim intent1 As Intent";
_intent1 = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="Dim l As List = cu.GetPhones(ajtemID)";
mostCurrent._l = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._l = _cu._getphones(null,(long)(Double.parseDouble(_ajtemid)));
RDebugUtils.currentLine=6029317;
 //BA.debugLineNum = 6029317;BA.debugLine="If l.Size > 0 Then";
if (mostCurrent._l.getSize()>0) { 
RDebugUtils.currentLine=6029318;
 //BA.debugLineNum = 6029318;BA.debugLine="For Each phone As cuPhone In cu.GetPhones(ajtemI";
{
final anywheresoftware.b4a.BA.IterableList group4 = _cu._getphones(null,(long)(Double.parseDouble(_ajtemid)));
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_phone = (com.no3dlauncher.contactsutils._cuphone)(group4.Get(index4));
 }
};
RDebugUtils.currentLine=6029320;
 //BA.debugLineNum = 6029320;BA.debugLine="intent1.Initialize(intent1.ACTION_VIEW, \"sms:\" &";
_intent1.Initialize(_intent1.ACTION_VIEW,"sms:"+_phone.Number);
RDebugUtils.currentLine=6029321;
 //BA.debugLineNum = 6029321;BA.debugLine="StartActivity(intent1)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_intent1.getObject()));
 }else {
RDebugUtils.currentLine=6029323;
 //BA.debugLineNum = 6029323;BA.debugLine="ToastMessageShow(\"No phone number so no SMS!\", F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No phone number so no SMS!"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=6029325;
 //BA.debugLineNum = 6029325;BA.debugLine="End Sub";
return "";
}
public static String  _btnmeni_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmeni_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmeni_click", null));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub btnMeni_Click";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="If pnl_dock_vidljiv Then";
if (_pnl_dock_vidljiv) { 
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="pnlDock.SendToBack";
mostCurrent._pnldock.SendToBack();
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="pnl_dock_vidljiv = False";
_pnl_dock_vidljiv = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="btnDock.SetBackgroundImage(LoadBitmap(File.DirAs";
mostCurrent._btndock.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"scvdock_otvori.png").getObject()));
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="pnlDock.SetLayoutAnimated(500, 15%x, 100%y - pnl";
mostCurrent._pnldock.SetLayoutAnimated((int) (500),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnldock.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65))),mostCurrent._pnldock.getWidth(),mostCurrent._pnldock.getHeight());
 };
RDebugUtils.currentLine=3211272;
 //BA.debugLineNum = 3211272;BA.debugLine="If f.showApps = 0 Then";
if (mostCurrent._f._showapps==0) { 
RDebugUtils.currentLine=3211284;
 //BA.debugLineNum = 3211284;BA.debugLine="DodajListuAppUKotac";
_dodajlistuappukotac();
 }else 
{RDebugUtils.currentLine=3211285;
 //BA.debugLineNum = 3211285;BA.debugLine="else if f.showApps = 1 Then";
if (mostCurrent._f._showapps==1) { 
RDebugUtils.currentLine=3211297;
 //BA.debugLineNum = 3211297;BA.debugLine="DodajListuSaIkonamaAppULAdicu";
_dodajlistusaikonamaappuladicu();
 }else 
{RDebugUtils.currentLine=3211298;
 //BA.debugLineNum = 3211298;BA.debugLine="else if f.showApps = 2 Then";
if (mostCurrent._f._showapps==2) { 
RDebugUtils.currentLine=3211299;
 //BA.debugLineNum = 3211299;BA.debugLine="DodajAppULadicu";
_dodajappuladicu();
 }else 
{RDebugUtils.currentLine=3211300;
 //BA.debugLineNum = 3211300;BA.debugLine="else if f.showApps = 3 Then";
if (mostCurrent._f._showapps==3) { 
 }}}}
;
RDebugUtils.currentLine=3211303;
 //BA.debugLineNum = 3211303;BA.debugLine="End Sub";
return "";
}
public static void  _dodajlistuappukotac() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dodajlistuappukotac", false))
	 {Debug.delegate(mostCurrent.activityBA, "dodajlistuappukotac", null); return;}
ResumableSub_DodajListuAppUKotac rsub = new ResumableSub_DodajListuAppUKotac(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_DodajListuAppUKotac extends BA.ResumableSub {
public ResumableSub_DodajListuAppUKotac(com.no3dlauncher.main parent) {
this.parent = parent;
}
com.no3dlauncher.main parent;
anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog _dlgdrawer = null;
Object _sf = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.objects.collections.List _mylist = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int[] _res = null;
int _position = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="Private dlgDrawer As CustomLayoutDialog";
_dlgdrawer = new anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog();
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="Dim sf As Object = dlgDrawer.ShowAsync(\"All appli";
_sf = _dlgdrawer.ShowAsync("All applications","","","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="dlgDrawer.SetSize(80%x, 62%y)";
_dlgdrawer.SetSize(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (62),mostCurrent.activityBA));
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="Wait For (sf) Dialog_Ready(pnl As Panel)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_ready", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistuappukotac"), _sf);
this.state = 1;
return;
case 1:
//C
this.state = -1;
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) result[0];
;
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="FiltrirajImenaAppIImenaPaketa";
_filtrirajimenaappiimenapaketa();
RDebugUtils.currentLine=4194312;
 //BA.debugLineNum = 4194312;BA.debugLine="wp1.Initialize(\"wp1\")";
parent.mostCurrent._wp1.Initialize(mostCurrent.activityBA,"wp1");
RDebugUtils.currentLine=4194314;
 //BA.debugLineNum = 4194314;BA.debugLine="pnl.AddView(wp1, 0, btnPostavke.Height, pnlMeni.W";
_pnl.AddView((android.view.View)(parent.mostCurrent._wp1.getObject()),(int) (0),parent.mostCurrent._btnpostavke.getHeight(),(int) (parent.mostCurrent._pnlmeni.getWidth()-anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA)),parent.mostCurrent._pnlmeni.getHeight());
RDebugUtils.currentLine=4194316;
 //BA.debugLineNum = 4194316;BA.debugLine="Dim mylist As List";
_mylist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4194317;
 //BA.debugLineNum = 4194317;BA.debugLine="mylist.Initialize";
_mylist.Initialize();
RDebugUtils.currentLine=4194318;
 //BA.debugLineNum = 4194318;BA.debugLine="mylist.Add(LoadBitmap(File.DirAssets, \"act_add.pn";
_mylist.Add((Object)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"act_add.png").getObject()));
RDebugUtils.currentLine=4194320;
 //BA.debugLineNum = 4194320;BA.debugLine="wp1.Tag = \"kotac\"";
parent.mostCurrent._wp1.setTag((Object)("kotac"));
RDebugUtils.currentLine=4194321;
 //BA.debugLineNum = 4194321;BA.debugLine="wp1.Curved = True";
parent.mostCurrent._wp1.setCurved(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4194322;
 //BA.debugLineNum = 4194322;BA.debugLine="wp1.Cyclic = True";
parent.mostCurrent._wp1.setCyclic(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4194323;
 //BA.debugLineNum = 4194323;BA.debugLine="wp1.ItemTextColor = f.bojaFonta";
parent.mostCurrent._wp1.setItemTextColor(parent.mostCurrent._f._bojafonta);
RDebugUtils.currentLine=4194324;
 //BA.debugLineNum = 4194324;BA.debugLine="wp1.Atmospheric = True";
parent.mostCurrent._wp1.setAtmospheric(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4194325;
 //BA.debugLineNum = 4194325;BA.debugLine="wp1.ItemAlign = 0                        '0 = cen";
parent.mostCurrent._wp1.setItemAlign((int) (0));
RDebugUtils.currentLine=4194326;
 //BA.debugLineNum = 4194326;BA.debugLine="wp1.ItemTextSize = f.fontzSize'55";
parent.mostCurrent._wp1.setItemTextSize(parent.mostCurrent._f._fontzsize);
RDebugUtils.currentLine=4194328;
 //BA.debugLineNum = 4194328;BA.debugLine="wp1.VisibleItemCount = 10";
parent.mostCurrent._wp1.setVisibleItemCount((int) (10));
RDebugUtils.currentLine=4194329;
 //BA.debugLineNum = 4194329;BA.debugLine="wp1.Indicator = True";
parent.mostCurrent._wp1.setIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4194330;
 //BA.debugLineNum = 4194330;BA.debugLine="wp1.ItemSpace = 20";
parent.mostCurrent._wp1.setItemSpace((int) (20));
RDebugUtils.currentLine=4194331;
 //BA.debugLineNum = 4194331;BA.debugLine="wp1.Typeface = Typeface.LoadFromAssets(f.wheelLis";
parent.mostCurrent._wp1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(parent.mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=4194332;
 //BA.debugLineNum = 4194332;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4194333;
 //BA.debugLineNum = 4194333;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=4194334;
 //BA.debugLineNum = 4194334;BA.debugLine="res = getARGB(f.bojaPozadine)";
_res = _getargb(parent.mostCurrent._f._bojapozadine);
RDebugUtils.currentLine=4194335;
 //BA.debugLineNum = 4194335;BA.debugLine="res(0) = f.trans";
_res[(int) (0)] = parent.mostCurrent._f._trans;
RDebugUtils.currentLine=4194336;
 //BA.debugLineNum = 4194336;BA.debugLine="cd.Initialize(Colors.ARGB(res(0), res(1), res(2),";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB(_res[(int) (0)],_res[(int) (1)],_res[(int) (2)],_res[(int) (3)]),(int) (0));
RDebugUtils.currentLine=4194337;
 //BA.debugLineNum = 4194337;BA.debugLine="wp1.Background = cd";
parent.mostCurrent._wp1.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=4194338;
 //BA.debugLineNum = 4194338;BA.debugLine="wp1.Data = l";
parent.mostCurrent._wp1.setData((java.util.List)(parent.mostCurrent._l.getObject()));
RDebugUtils.currentLine=4194341;
 //BA.debugLineNum = 4194341;BA.debugLine="ivWheelDodaj.Initialize(\"ivWheelDodaj\")";
parent.mostCurrent._ivwheeldodaj.Initialize(mostCurrent.activityBA,"ivWheelDodaj");
RDebugUtils.currentLine=4194342;
 //BA.debugLineNum = 4194342;BA.debugLine="ivWheelDodaj.Tag = \"kotac_dodaj\"";
parent.mostCurrent._ivwheeldodaj.setTag((Object)("kotac_dodaj"));
RDebugUtils.currentLine=4194343;
 //BA.debugLineNum = 4194343;BA.debugLine="ivWheelDodaj.Bitmap = LoadBitmap(File.DirAssets,";
parent.mostCurrent._ivwheeldodaj.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"act_add.png").getObject()));
RDebugUtils.currentLine=4194344;
 //BA.debugLineNum = 4194344;BA.debugLine="ivWheelDodaj.Gravity = Gravity.FILL";
parent.mostCurrent._ivwheeldodaj.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=4194345;
 //BA.debugLineNum = 4194345;BA.debugLine="pnl.AddView(ivWheelDodaj, wp1.Width, (pnlMeni.Hei";
_pnl.AddView((android.view.View)(parent.mostCurrent._ivwheeldodaj.getObject()),parent.mostCurrent._wp1.getWidth(),(int) ((parent.mostCurrent._pnlmeni.getHeight()/(double)2)+(parent.mostCurrent._btnpostavke.getHeight()/(double)2)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=4194348;
 //BA.debugLineNum = 4194348;BA.debugLine="Wait For ivWheelDodaj_Click";
anywheresoftware.b4a.keywords.Common.WaitFor("ivwheeldodaj_click", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistuappukotac"), null);
this.state = 2;
return;
case 2:
//C
this.state = -1;
;
RDebugUtils.currentLine=4194350;
 //BA.debugLineNum = 4194350;BA.debugLine="Wait For wp1_index_clicked(position As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("wp1_index_clicked", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistuappukotac"), null);
this.state = 3;
return;
case 3:
//C
this.state = -1;
_position = (Integer) result[0];
;
RDebugUtils.currentLine=4194352;
 //BA.debugLineNum = 4194352;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _dodajlistusaikonamaappuladicu() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dodajlistusaikonamaappuladicu", false))
	 {Debug.delegate(mostCurrent.activityBA, "dodajlistusaikonamaappuladicu", null); return;}
ResumableSub_DodajListuSaIkonamaAppULAdicu rsub = new ResumableSub_DodajListuSaIkonamaAppULAdicu(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_DodajListuSaIkonamaAppULAdicu extends BA.ResumableSub {
public ResumableSub_DodajListuSaIkonamaAppULAdicu(com.no3dlauncher.main parent) {
this.parent = parent;
}
com.no3dlauncher.main parent;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog _dlgdrawer = null;
Object _sf = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
int[] _res = null;
int _i = 0;
String _pckg1 = "";
String _pckg2 = "";
String _pckg = "";
Object _drawable = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bdw = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
int _index = 0;
Object _value = null;
int step12;
int limit12;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="FiltrirajImenaAppIImenaPaketa";
_filtrirajimenaappiimenapaketa();
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="Private dlgDrawer As CustomLayoutDialog";
_dlgdrawer = new anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog();
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="Dim sf As Object = dlgDrawer.ShowAsync(\"All appli";
_sf = _dlgdrawer.ShowAsync("All applications","","","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="dlgDrawer.SetSize(100%x, 90%y)";
_dlgdrawer.SetSize(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (90),mostCurrent.activityBA));
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="Wait For (sf) Dialog_Ready(pnl As Panel)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_ready", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistusaikonamaappuladicu"), _sf);
this.state = 9;
return;
case 9:
//C
this.state = 1;
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) result[0];
;
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="pnl.LoadLayout(\"clv1\")";
_pnl.LoadLayout("clv1",mostCurrent.activityBA);
RDebugUtils.currentLine=3735565;
 //BA.debugLineNum = 3735565;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=3735566;
 //BA.debugLineNum = 3735566;BA.debugLine="res = getARGB(f.bojaPozadine)";
_res = _getargb(parent.mostCurrent._f._bojapozadine);
RDebugUtils.currentLine=3735567;
 //BA.debugLineNum = 3735567;BA.debugLine="res(0) = f.trans";
_res[(int) (0)] = parent.mostCurrent._f._trans;
RDebugUtils.currentLine=3735569;
 //BA.debugLineNum = 3735569;BA.debugLine="clv.AsView.SetColorAndBorder(Colors.ARGB(res(0),";
parent.mostCurrent._clv._asview().SetColorAndBorder(anywheresoftware.b4a.keywords.Common.Colors.ARGB(_res[(int) (0)],_res[(int) (1)],_res[(int) (2)],_res[(int) (3)]),(int) (0),anywheresoftware.b4a.keywords.Common.Colors.Transparent,(int) (0));
RDebugUtils.currentLine=3735573;
 //BA.debugLineNum = 3735573;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
if (true) break;

case 1:
//for
this.state = 8;
step12 = 1;
limit12 = (int) (parent.mostCurrent._starter._mapa.getSize()-1);
_i = (int) (0) ;
this.state = 10;
if (true) break;

case 10:
//C
this.state = 8;
if ((step12 > 0 && _i <= limit12) || (step12 < 0 && _i >= limit12)) this.state = 3;
if (true) break;

case 11:
//C
this.state = 10;
_i = ((int)(0 + _i + step12)) ;
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=3735574;
 //BA.debugLineNum = 3735574;BA.debugLine="Dim pckg1, pckg2 As String";
_pckg1 = "";
_pckg2 = "";
RDebugUtils.currentLine=3735575;
 //BA.debugLineNum = 3735575;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
_pckg = BA.ObjectToString(parent.mostCurrent._starter._mapa.GetKeyAt(_i));
RDebugUtils.currentLine=3735576;
 //BA.debugLineNum = 3735576;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pck";
_pckg1 = _pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length());
RDebugUtils.currentLine=3735577;
 //BA.debugLineNum = 3735577;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon(p";
_drawable = (Object)(_pm.GetApplicationIcon(_pckg1));
RDebugUtils.currentLine=3735578;
 //BA.debugLineNum = 3735578;BA.debugLine="If drawable Is BitmapDrawable Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_drawable instanceof android.graphics.drawable.BitmapDrawable) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=3735579;
 //BA.debugLineNum = 3735579;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_drawable));
RDebugUtils.currentLine=3735580;
 //BA.debugLineNum = 3735580;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=3735581;
 //BA.debugLineNum = 3735581;BA.debugLine="bdw.Initialize(bmp.Resize(32dip, 32dip, True))";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3735582;
 //BA.debugLineNum = 3735582;BA.debugLine="pckg2 = pckg.SubString2(0, pckg.IndexOf(\";\"))";
_pckg2 = _pckg.substring((int) (0),_pckg.indexOf(";"));
RDebugUtils.currentLine=3735583;
 //BA.debugLineNum = 3735583;BA.debugLine="clv.Add(KreirajStavku(bdw.Bitmap, pckg2, pnlMen";
parent.mostCurrent._clv._add((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_kreirajstavku((anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_bdw.getBitmap())),_pckg2,parent.mostCurrent._pnlmeni.getWidth(),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (40))).getObject())),(Object)(""));
 if (true) break;

case 7:
//C
this.state = 11;
;
 if (true) break;
if (true) break;

case 8:
//C
this.state = -1;
;
RDebugUtils.currentLine=3735587;
 //BA.debugLineNum = 3735587;BA.debugLine="Wait For clv_ItemClick (Index As Int, Value As Ob";
anywheresoftware.b4a.keywords.Common.WaitFor("clv_itemclick", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistusaikonamaappuladicu"), null);
this.state = 12;
return;
case 12:
//C
this.state = -1;
_index = (Integer) result[0];
_value = (Object) result[1];
;
RDebugUtils.currentLine=3735588;
 //BA.debugLineNum = 3735588;BA.debugLine="Log(\"Selected item: \" & Value)";
anywheresoftware.b4a.keywords.Common.LogImpl("73735588","Selected item: "+BA.ObjectToString(_value),0);
RDebugUtils.currentLine=3735590;
 //BA.debugLineNum = 3735590;BA.debugLine="Wait For ivClvDodaj_Click";
anywheresoftware.b4a.keywords.Common.WaitFor("ivclvdodaj_click", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistusaikonamaappuladicu"), null);
this.state = 13;
return;
case 13:
//C
this.state = -1;
;
RDebugUtils.currentLine=3735593;
 //BA.debugLineNum = 3735593;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _dodajappuladicu() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dodajappuladicu", false))
	 {Debug.delegate(mostCurrent.activityBA, "dodajappuladicu", null); return;}
ResumableSub_DodajAppULadicu rsub = new ResumableSub_DodajAppULadicu(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_DodajAppULadicu extends BA.ResumableSub {
public ResumableSub_DodajAppULadicu(com.no3dlauncher.main parent) {
this.parent = parent;
}
com.no3dlauncher.main parent;
anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog _dlgdrawer = null;
Object _sf = null;
anywheresoftware.b4a.objects.PanelWrapper _pnl = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int _x = 0;
int _i = 0;
int _j = 0;
String _s = "";
String _s1 = "";
Object _drawable = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bdw = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
String _s2 = "";
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _btm = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper _destrect = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper _can = null;
int step14;
int limit14;
int step15;
int limit15;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="main";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="Private dlgDrawer As CustomLayoutDialog";
_dlgdrawer = new anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog();
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Dim sf As Object = dlgDrawer.ShowAsync(\"All appli";
_sf = _dlgdrawer.ShowAsync("All applications","","","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="dlgDrawer.SetSize(100%x, 90%y)";
_dlgdrawer.SetSize(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (90),mostCurrent.activityBA));
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="Wait For (sf) Dialog_Ready(pnl As Panel)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_ready", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajappuladicu"), _sf);
this.state = 21;
return;
case 21:
//C
this.state = 1;
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) result[0];
;
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="FiltrirajImenaAppIImenaPaketa";
_filtrirajimenaappiimenapaketa();
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="sv.Initialize(1000dip)";
parent.mostCurrent._sv.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1000)));
RDebugUtils.currentLine=3801097;
 //BA.debugLineNum = 3801097;BA.debugLine="pnl.AddView(sv, 0, 0, pnl.Width, pnl.Height)";
_pnl.AddView((android.view.View)(parent.mostCurrent._sv.getObject()),(int) (0),(int) (0),_pnl.getWidth(),_pnl.getHeight());
RDebugUtils.currentLine=3801098;
 //BA.debugLineNum = 3801098;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=3801099;
 //BA.debugLineNum = 3801099;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=3801100;
 //BA.debugLineNum = 3801100;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (211),(int) (211),(int) (211)),(int) (0));
RDebugUtils.currentLine=3801101;
 //BA.debugLineNum = 3801101;BA.debugLine="Dim x As Int";
_x = 0;
RDebugUtils.currentLine=3801102;
 //BA.debugLineNum = 3801102;BA.debugLine="x = Activity.Width / 5'pkg1.Size";
_x = (int) (parent.mostCurrent._activity.getWidth()/(double)5);
RDebugUtils.currentLine=3801103;
 //BA.debugLineNum = 3801103;BA.debugLine="x = x - 10dip";
_x = (int) (_x-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
RDebugUtils.currentLine=3801105;
 //BA.debugLineNum = 3801105;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
if (true) break;

case 1:
//for
this.state = 20;
step14 = 1;
limit14 = (int) (parent.mostCurrent._starter._mapa.getSize()-1);
_i = (int) (0) ;
this.state = 22;
if (true) break;

case 22:
//C
this.state = 20;
if ((step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14)) this.state = 3;
if (true) break;

case 23:
//C
this.state = 22;
_i = ((int)(0 + _i + step14)) ;
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=3801106;
 //BA.debugLineNum = 3801106;BA.debugLine="For j = 0 To 4";
if (true) break;

case 4:
//for
this.state = 19;
step15 = 1;
limit15 = (int) (4);
_j = (int) (0) ;
this.state = 24;
if (true) break;

case 24:
//C
this.state = 19;
if ((step15 > 0 && _j <= limit15) || (step15 < 0 && _j >= limit15)) this.state = 6;
if (true) break;

case 25:
//C
this.state = 24;
_j = ((int)(0 + _j + step15)) ;
if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=3801107;
 //BA.debugLineNum = 3801107;BA.debugLine="If (i*5+j) < Starter.mapa.Size Then";
if (true) break;

case 7:
//if
this.state = 18;
if ((_i*5+_j)<parent.mostCurrent._starter._mapa.getSize()) { 
this.state = 9;
}else {
this.state = 17;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=3801108;
 //BA.debugLineNum = 3801108;BA.debugLine="Dim s As String = Starter.mapa.GetKeyAt(i*5+j)";
_s = BA.ObjectToString(parent.mostCurrent._starter._mapa.GetKeyAt((int) (_i*5+_j)));
RDebugUtils.currentLine=3801110;
 //BA.debugLineNum = 3801110;BA.debugLine="Dim s1 As String = s.SubString2(s.IndexOf(\";\")";
_s1 = _s.substring((int) (_s.indexOf(";")+1),_s.length());
RDebugUtils.currentLine=3801111;
 //BA.debugLineNum = 3801111;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon";
_drawable = (Object)(_pm.GetApplicationIcon(_s1));
RDebugUtils.currentLine=3801112;
 //BA.debugLineNum = 3801112;BA.debugLine="If drawable Is BitmapDrawable Then";
if (true) break;

case 10:
//if
this.state = 15;
if (_drawable instanceof android.graphics.drawable.BitmapDrawable) { 
this.state = 12;
}else {
this.state = 14;
}if (true) break;

case 12:
//C
this.state = 15;
RDebugUtils.currentLine=3801113;
 //BA.debugLineNum = 3801113;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_drawable));
RDebugUtils.currentLine=3801114;
 //BA.debugLineNum = 3801114;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=3801115;
 //BA.debugLineNum = 3801115;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True)";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=3801116;
 //BA.debugLineNum = 3801116;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=3801117;
 //BA.debugLineNum = 3801117;BA.debugLine="iv.Initialize(\"ivAppMain\")";
_iv.Initialize(mostCurrent.activityBA,"ivAppMain");
RDebugUtils.currentLine=3801118;
 //BA.debugLineNum = 3801118;BA.debugLine="iv.Bitmap = bdw.Bitmap";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=3801119;
 //BA.debugLineNum = 3801119;BA.debugLine="iv.Tag = s1'Starter.mapa.GetKeyAt(i*5+j)";
_iv.setTag((Object)(_s1));
RDebugUtils.currentLine=3801120;
 //BA.debugLineNum = 3801120;BA.debugLine="sv.Panel.AddView(iv, x*j + j*2dip, x*i + 10di";
parent.mostCurrent._sv.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(int) (_x*_i+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),_x,_x);
RDebugUtils.currentLine=3801121;
 //BA.debugLineNum = 3801121;BA.debugLine="Dim lbl As Label";
parent.mostCurrent._lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3801122;
 //BA.debugLineNum = 3801122;BA.debugLine="lbl.Initialize(\"\")";
parent.mostCurrent._lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3801124;
 //BA.debugLineNum = 3801124;BA.debugLine="Dim s2 As String = s.SubString2(0, s.IndexOf(";
_s2 = _s.substring((int) (0),_s.indexOf(";"));
RDebugUtils.currentLine=3801125;
 //BA.debugLineNum = 3801125;BA.debugLine="lbl.Text = s2";
parent.mostCurrent._lbl.setText(BA.ObjectToCharSequence(_s2));
RDebugUtils.currentLine=3801126;
 //BA.debugLineNum = 3801126;BA.debugLine="lbl.TextColor = Colors.White";
parent.mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3801127;
 //BA.debugLineNum = 3801127;BA.debugLine="lbl.Background = cd";
parent.mostCurrent._lbl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=3801128;
 //BA.debugLineNum = 3801128;BA.debugLine="lbl.TextSize = 10.0";
parent.mostCurrent._lbl.setTextSize((float) (10.0));
RDebugUtils.currentLine=3801129;
 //BA.debugLineNum = 3801129;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
parent.mostCurrent._lbl.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(parent.mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=3801130;
 //BA.debugLineNum = 3801130;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
parent.mostCurrent._lbl.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL,anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=3801131;
 //BA.debugLineNum = 3801131;BA.debugLine="sv.Panel.AddView(lbl, x*j + j*2dip, x*i + x +";
parent.mostCurrent._sv.getPanel().AddView((android.view.View)(parent.mostCurrent._lbl.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(int) (_x*_i+_x+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))),_x,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=3801133;
 //BA.debugLineNum = 3801133;BA.debugLine="Dim btm As Bitmap";
_btm = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=3801134;
 //BA.debugLineNum = 3801134;BA.debugLine="btm.InitializeMutable(x, x)";
_btm.InitializeMutable(_x,_x);
RDebugUtils.currentLine=3801135;
 //BA.debugLineNum = 3801135;BA.debugLine="Dim DestRect As Rect";
_destrect = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.RectWrapper();
RDebugUtils.currentLine=3801136;
 //BA.debugLineNum = 3801136;BA.debugLine="DestRect.Initialize(0, 0, x, x)";
_destrect.Initialize((int) (0),(int) (0),_x,_x);
RDebugUtils.currentLine=3801137;
 //BA.debugLineNum = 3801137;BA.debugLine="Dim can As Canvas";
_can = new anywheresoftware.b4a.objects.drawable.CanvasWrapper();
RDebugUtils.currentLine=3801138;
 //BA.debugLineNum = 3801138;BA.debugLine="can.Initialize2(btm)";
_can.Initialize2((android.graphics.Bitmap)(_btm.getObject()));
RDebugUtils.currentLine=3801139;
 //BA.debugLineNum = 3801139;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=3801140;
 //BA.debugLineNum = 3801140;BA.debugLine="can.DrawDrawable(pm.GetApplicationIcon(s1), D";
_can.DrawDrawable(_pm.GetApplicationIcon(_s1),(android.graphics.Rect)(_destrect.getObject()));
RDebugUtils.currentLine=3801141;
 //BA.debugLineNum = 3801141;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=3801142;
 //BA.debugLineNum = 3801142;BA.debugLine="iv.Initialize(\"ivAppMain\")";
_iv.Initialize(mostCurrent.activityBA,"ivAppMain");
RDebugUtils.currentLine=3801143;
 //BA.debugLineNum = 3801143;BA.debugLine="iv.Background = BitmapToBitmapDrawable(btm)";
_iv.setBackground((android.graphics.drawable.Drawable)(_bitmaptobitmapdrawable(_btm).getObject()));
RDebugUtils.currentLine=3801144;
 //BA.debugLineNum = 3801144;BA.debugLine="iv.Tag = s1'pkg1.Get(i*5+j)";
_iv.setTag((Object)(_s1));
RDebugUtils.currentLine=3801145;
 //BA.debugLineNum = 3801145;BA.debugLine="sv.Panel.AddView(iv, x*j + j*2dip, x*i + 10di";
parent.mostCurrent._sv.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(int) (_x*_i+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),_x,_x);
RDebugUtils.currentLine=3801146;
 //BA.debugLineNum = 3801146;BA.debugLine="Dim lbl As Label";
parent.mostCurrent._lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=3801147;
 //BA.debugLineNum = 3801147;BA.debugLine="lbl.Initialize(\"\")";
parent.mostCurrent._lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=3801148;
 //BA.debugLineNum = 3801148;BA.debugLine="Dim s2 As String = s.SubString2(0, s.IndexOf(";
_s2 = _s.substring((int) (0),_s.indexOf(";"));
RDebugUtils.currentLine=3801149;
 //BA.debugLineNum = 3801149;BA.debugLine="lbl.Text = s2'pkg2.Get(i*5+j)";
parent.mostCurrent._lbl.setText(BA.ObjectToCharSequence(_s2));
RDebugUtils.currentLine=3801150;
 //BA.debugLineNum = 3801150;BA.debugLine="lbl.TextColor = Colors.White";
parent.mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=3801151;
 //BA.debugLineNum = 3801151;BA.debugLine="lbl.Background = cd";
parent.mostCurrent._lbl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=3801152;
 //BA.debugLineNum = 3801152;BA.debugLine="lbl.TextSize = 10";
parent.mostCurrent._lbl.setTextSize((float) (10));
RDebugUtils.currentLine=3801153;
 //BA.debugLineNum = 3801153;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
parent.mostCurrent._lbl.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(parent.mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=3801154;
 //BA.debugLineNum = 3801154;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
parent.mostCurrent._lbl.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL,anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=3801155;
 //BA.debugLineNum = 3801155;BA.debugLine="sv.Panel.AddView(lbl, x*j + j*2dip, x*i + x +";
parent.mostCurrent._sv.getPanel().AddView((android.view.View)(parent.mostCurrent._lbl.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(int) (_x*_i+_x+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))),_x,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 if (true) break;

case 15:
//C
this.state = 18;
;
 if (true) break;

case 17:
//C
this.state = 18;
RDebugUtils.currentLine=3801158;
 //BA.debugLineNum = 3801158;BA.debugLine="Exit";
this.state = 19;
if (true) break;
 if (true) break;

case 18:
//C
this.state = 25;
;
 if (true) break;
if (true) break;

case 19:
//C
this.state = 23;
;
 if (true) break;
if (true) break;

case 20:
//C
this.state = -1;
;
RDebugUtils.currentLine=3801162;
 //BA.debugLineNum = 3801162;BA.debugLine="sv.Panel.Height = sv.Panel.Height + 12dip";
parent.mostCurrent._sv.getPanel().setHeight((int) (parent.mostCurrent._sv.getPanel().getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12))));
RDebugUtils.currentLine=3801163;
 //BA.debugLineNum = 3801163;BA.debugLine="dlgDrawer.GetButton(DialogResponse.POSITIVE).Enab";
_dlgdrawer.GetButton(anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE).setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801164;
 //BA.debugLineNum = 3801164;BA.debugLine="Wait for (sf) ivAppMain_Click";
anywheresoftware.b4a.keywords.Common.WaitFor("ivappmain_click", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajappuladicu"), _sf);
this.state = 26;
return;
case 26:
//C
this.state = -1;
;
RDebugUtils.currentLine=3801165;
 //BA.debugLineNum = 3801165;BA.debugLine="Wait For (sf) ivApp_LongClick";
anywheresoftware.b4a.keywords.Common.WaitFor("ivapp_longclick", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajappuladicu"), _sf);
this.state = 27;
return;
case 27:
//C
this.state = -1;
;
RDebugUtils.currentLine=3801166;
 //BA.debugLineNum = 3801166;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _btnnaprijed_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnaprijed_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnaprijed_click", null));}
RDebugUtils.currentLine=5636096;
 //BA.debugLineNum = 5636096;BA.debugLine="Sub btnNaprijed_Click";
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="If TabStrip1.CurrentPage < 3 Then";
if (mostCurrent._tabstrip1.getCurrentPage()<3) { 
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="TabStrip1.ScrollTo(TabStrip1.CurrentPage + 1, Tr";
mostCurrent._tabstrip1.ScrollTo((int) (mostCurrent._tabstrip1.getCurrentPage()+1),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="End Sub";
return "";
}
public static String  _btnnatrag_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnatrag_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnatrag_click", null));}
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub btnNatrag_Click";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="If TabStrip1.CurrentPage > 0 Then";
if (mostCurrent._tabstrip1.getCurrentPage()>0) { 
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="TabStrip1.ScrollTo(TabStrip1.CurrentPage - 1, Tr";
mostCurrent._tabstrip1.ScrollTo((int) (mostCurrent._tabstrip1.getCurrentPage()-1),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="TabStrip1.ScrollTo(2, True)";
mostCurrent._tabstrip1.ScrollTo((int) (2),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="If TabStrip1.CurrentPage = 1 And pnlKontakti.Numb";
if (mostCurrent._tabstrip1.getCurrentPage()==1 && mostCurrent._pnlkontakti.getNumberOfViews()==0) { 
RDebugUtils.currentLine=5570569;
 //BA.debugLineNum = 5570569;BA.debugLine="UbaciKontakte2'(c)";
_ubacikontakte2();
 };
RDebugUtils.currentLine=5570571;
 //BA.debugLineNum = 5570571;BA.debugLine="End Sub";
return "";
}
public static String  _ubacikontakte2() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ubacikontakte2", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ubacikontakte2", null));}
anywheresoftware.b4a.objects.collections.List _allcontacts = null;
int _ukupno = 0;
int _i = 0;
anywheresoftware.b4a.objects.collections.List _l1k = null;
anywheresoftware.b4a.objects.collections.List _l2k = null;
com.no3dlauncher.contactsutils._cucontact _c = null;
int _j = 0;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
RDebugUtils.currentLine=5701632;
 //BA.debugLineNum = 5701632;BA.debugLine="Sub UbaciKontakte2";
RDebugUtils.currentLine=5701633;
 //BA.debugLineNum = 5701633;BA.debugLine="Dim allContacts As List = cu.FindAllContacts(True";
_allcontacts = new anywheresoftware.b4a.objects.collections.List();
_allcontacts = _cu._findallcontacts(null,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5701638;
 //BA.debugLineNum = 5701638;BA.debugLine="If File.Exists (File.DirInternal, \"nema_slike.png";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"nema_slike.png")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=5701639;
 //BA.debugLineNum = 5701639;BA.debugLine="File.Copy(File.DirAssets, \"nema_slike.png\", File";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"nema_slike.png",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"nema_slike.png");
 };
RDebugUtils.currentLine=5701642;
 //BA.debugLineNum = 5701642;BA.debugLine="grid.Initialize(pnlKontakti, Me, \"kontaktiGrid\",";
mostCurrent._grid._initialize(mostCurrent.activityBA,mostCurrent._pnlkontakti,main.getObject(),"kontaktiGrid",(int) (4),"S");
RDebugUtils.currentLine=5701644;
 //BA.debugLineNum = 5701644;BA.debugLine="grid.PrepareGridView";
mostCurrent._grid._preparegridview();
RDebugUtils.currentLine=5701664;
 //BA.debugLineNum = 5701664;BA.debugLine="Dim ukupno, i As Int = 0";
_ukupno = 0;
_i = (int) (0);
RDebugUtils.currentLine=5701666;
 //BA.debugLineNum = 5701666;BA.debugLine="ProgressDialogShow(\"Building contacts...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Building contacts..."));
RDebugUtils.currentLine=5701667;
 //BA.debugLineNum = 5701667;BA.debugLine="Dim l1k, l2k As List";
_l1k = new anywheresoftware.b4a.objects.collections.List();
_l2k = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5701668;
 //BA.debugLineNum = 5701668;BA.debugLine="l1k.Initialize	' diaply name";
_l1k.Initialize();
RDebugUtils.currentLine=5701669;
 //BA.debugLineNum = 5701669;BA.debugLine="l2k.Initialize	' id";
_l2k.Initialize();
RDebugUtils.currentLine=5701670;
 //BA.debugLineNum = 5701670;BA.debugLine="For Each c As cuContact In allContacts'cu.FindAll";
{
final anywheresoftware.b4a.BA.IterableList group12 = _allcontacts;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_c = (com.no3dlauncher.contactsutils._cucontact)(group12.Get(index12));
RDebugUtils.currentLine=5701671;
 //BA.debugLineNum = 5701671;BA.debugLine="l1k.Add(c.DisplayName)";
_l1k.Add((Object)(_c.DisplayName));
RDebugUtils.currentLine=5701672;
 //BA.debugLineNum = 5701672;BA.debugLine="l2k.Add(c.Id)";
_l2k.Add((Object)(_c.Id));
 }
};
RDebugUtils.currentLine=5701675;
 //BA.debugLineNum = 5701675;BA.debugLine="Log(l1k)";
anywheresoftware.b4a.keywords.Common.LogImpl("75701675",BA.ObjectToString(_l1k),0);
RDebugUtils.currentLine=5701676;
 //BA.debugLineNum = 5701676;BA.debugLine="Log(l2k)";
anywheresoftware.b4a.keywords.Common.LogImpl("75701676",BA.ObjectToString(_l2k),0);
RDebugUtils.currentLine=5701677;
 //BA.debugLineNum = 5701677;BA.debugLine="For i = 0 To allContacts.Size - 1";
{
final int step18 = 1;
final int limit18 = (int) (_allcontacts.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit18 ;_i = _i + step18 ) {
RDebugUtils.currentLine=5701678;
 //BA.debugLineNum = 5701678;BA.debugLine="For j = 0 To 4";
{
final int step19 = 1;
final int limit19 = (int) (4);
_j = (int) (0) ;
for (;_j <= limit19 ;_j = _j + step19 ) {
RDebugUtils.currentLine=5701679;
 //BA.debugLineNum = 5701679;BA.debugLine="If ukupno < allContacts.Size Then";
if (_ukupno<_allcontacts.getSize()) { 
RDebugUtils.currentLine=5701681;
 //BA.debugLineNum = 5701681;BA.debugLine="Dim bmp As Bitmap = cu.GetPhoto(l2k.Get(i*5+j)";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = _cu._getphoto(null,BA.ObjectToLongNumber(_l2k.Get((int) (_i*5+_j))));
RDebugUtils.currentLine=5701682;
 //BA.debugLineNum = 5701682;BA.debugLine="If bmp.IsInitialized = False Then";
if (_bmp.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=5701683;
 //BA.debugLineNum = 5701683;BA.debugLine="grid.AddToGridView(File.Combine(File.DirInter";
mostCurrent._grid._addtogridview(anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"nema_slike.png"),BA.ObjectToString(_l1k.Get((int) (_i*5+_j))),BA.ObjectToString(_l2k.Get((int) (_i*5+_j))));
 }else {
RDebugUtils.currentLine=5701685;
 //BA.debugLineNum = 5701685;BA.debugLine="Dim bmp As Bitmap = cu.GetPhoto(l2k.Get(i*5+j";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = _cu._getphoto(null,BA.ObjectToLongNumber(_l2k.Get((int) (_i*5+_j))));
RDebugUtils.currentLine=5701686;
 //BA.debugLineNum = 5701686;BA.debugLine="Dim Out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=5701687;
 //BA.debugLineNum = 5701687;BA.debugLine="Out = File.OpenOutput(File.DirInternal, l1k.G";
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_l1k.Get((int) (_i*5+_j))),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5701688;
 //BA.debugLineNum = 5701688;BA.debugLine="bmp.WriteToStream(Out, 100, \"PNG\")";
_bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=5701689;
 //BA.debugLineNum = 5701689;BA.debugLine="Out.Close";
_out.Close();
RDebugUtils.currentLine=5701690;
 //BA.debugLineNum = 5701690;BA.debugLine="grid.AddToGridView(File.Combine(File.DirInter";
mostCurrent._grid._addtogridview(anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_l1k.Get((int) (_i*5+_j)))),BA.ObjectToString(_l1k.Get((int) (_i*5+_j))),BA.ObjectToString(_l2k.Get((int) (_i*5+_j))));
 };
RDebugUtils.currentLine=5701718;
 //BA.debugLineNum = 5701718;BA.debugLine="ukupno = ukupno + 1";
_ukupno = (int) (_ukupno+1);
 }else {
RDebugUtils.currentLine=5701721;
 //BA.debugLineNum = 5701721;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 }
};
RDebugUtils.currentLine=5701726;
 //BA.debugLineNum = 5701726;BA.debugLine="grid.TitleBoxVisible = True";
mostCurrent._grid._settitleboxvisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5701729;
 //BA.debugLineNum = 5701729;BA.debugLine="grid.ShowGridView";
mostCurrent._grid._showgridview();
RDebugUtils.currentLine=5701732;
 //BA.debugLineNum = 5701732;BA.debugLine="End Sub";
return "";
}
public static String  _btnnotify_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnotify_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnotify_click", null));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub btnNotify_Click";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="Log(p.GetSettings(\"enabled_notification_listeners";
anywheresoftware.b4a.keywords.Common.LogImpl("75373954",_p.GetSettings("enabled_notification_listeners"),0);
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="If p.GetSettings(\"enabled_notification_listeners\"";
if (_p.GetSettings("enabled_notification_listeners").contains("com.no3dlauncher")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="Dim In As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="In.Initialize(\"android.settings.ACTION_NOTIFICAT";
_in.Initialize("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS","");
RDebugUtils.currentLine=5373958;
 //BA.debugLineNum = 5373958;BA.debugLine="StartActivity(In)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="End Sub";
return "";
}
public static String  _btnpostavke_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnpostavke_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnpostavke_click", null));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub btnPostavke_Click";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="StartActivity(pnlmeni_postavke)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._pnlmeni_postavke.getObject()));
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="End Sub";
return "";
}
public static String  _btnpostavkekontakti_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnpostavkekontakti_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnpostavkekontakti_click", null));}
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub btnPostavkeKontakti_Click";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="StartActivity(postavke_kontakti)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._postavke_kontakti.getObject()));
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="End Sub";
return "";
}
public static String  _btnsearch_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsearch_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnsearch_click", null));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub btnSearch_Click";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="StartActivity(search)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._search.getObject()));
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="End Sub";
return "";
}
public static String  _btnwidgeti_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnwidgeti_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnwidgeti_click", null));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub btnWidgeti_Click";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="TabStrip1.ScrollTo(2, True)";
mostCurrent._tabstrip1.ScrollTo((int) (2),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="Log(\"widgeti klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("73407878","widgeti klik!",0);
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="File.Delete(File.DirInternal, \"theappid.txt\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"theappid.txt");
RDebugUtils.currentLine=3407880;
 //BA.debugLineNum = 3407880;BA.debugLine="File.Delete(File.DirInternal, \"theid.txt\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"theid.txt");
RDebugUtils.currentLine=3407881;
 //BA.debugLineNum = 3407881;BA.debugLine="File.Delete(File.DirInternal, \"thehost.txt\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"thehost.txt");
RDebugUtils.currentLine=3407940;
 //BA.debugLineNum = 3407940;BA.debugLine="End Sub";
return "";
}
public static String  _clv_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clv_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clv_itemclick", new Object[] {_index,_value}));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub clv_ItemClick (Index As Int, Value As Object)";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="zadnja_oznacena_app = Index";
_zadnja_oznacena_app = _index;
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="in = pm.GetApplicationIntent(l1.Get(Index))";
_in = _pm.GetApplicationIntent(BA.ObjectToString(mostCurrent._l1.Get(_index)));
RDebugUtils.currentLine=4456454;
 //BA.debugLineNum = 4456454;BA.debugLine="If in.IsInitialized Then";
if (_in.IsInitialized()) { 
RDebugUtils.currentLine=4456457;
 //BA.debugLineNum = 4456457;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="End Sub";
return "";
}
public static String  _dodajappufavorite() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dodajappufavorite", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "dodajappufavorite", null));}
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
String _pckg1 = "";
String _pckg = "";
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bdw = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub DodajAppUFavorite";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="Dim pckg1 As String";
_pckg1 = "";
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(zadnja";
_pckg = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_zadnja_oznacena_app));
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(zadn";
_provjeraappufavoritima(BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_zadnja_oznacena_app)));
RDebugUtils.currentLine=4259849;
 //BA.debugLineNum = 4259849;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="iv.Tag = scvDock.Panel.NumberOfViews";
_iv.setTag((Object)(mostCurrent._scvdock.getPanel().getNumberOfViews()));
RDebugUtils.currentLine=4259851;
 //BA.debugLineNum = 4259851;BA.debugLine="iv.Width = 48dip";
_iv.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=4259852;
 //BA.debugLineNum = 4259852;BA.debugLine="iv.Height = 48dip";
_iv.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=4259853;
 //BA.debugLineNum = 4259853;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=4259855;
 //BA.debugLineNum = 4259855;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pckg";
_pckg1 = _pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length());
RDebugUtils.currentLine=4259856;
 //BA.debugLineNum = 4259856;BA.debugLine="Dim bdw As BitmapDrawable = pm.GetApplicationIcon";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_pm.GetApplicationIcon(_pckg1)));
RDebugUtils.currentLine=4259857;
 //BA.debugLineNum = 4259857;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=4259858;
 //BA.debugLineNum = 4259858;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True))";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=4259859;
 //BA.debugLineNum = 4259859;BA.debugLine="listaFavorita.Add(pckg1)	' dodaj ime paketa aplik";
mostCurrent._listafavorita.Add((Object)(_pckg1));
RDebugUtils.currentLine=4259862;
 //BA.debugLineNum = 4259862;BA.debugLine="iv.Bitmap = bdw.Bitmap'bm1";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=4259863;
 //BA.debugLineNum = 4259863;BA.debugLine="scvDock.Panel.AddView(iv, iv.Width*scvDock.Panel.";
mostCurrent._scvdock.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_iv.getWidth()*mostCurrent._scvdock.getPanel().getNumberOfViews()+mostCurrent._scvdock.getPanel().getNumberOfViews()*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_iv.getWidth(),_iv.getHeight());
RDebugUtils.currentLine=4259865;
 //BA.debugLineNum = 4259865;BA.debugLine="ToastMessageShow(\"App added to favorites!\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("App added to favorites!"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4259866;
 //BA.debugLineNum = 4259866;BA.debugLine="End Sub";
return "";
}
public static String  _provjeraappufavoritima(String _mapavrijednost) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "provjeraappufavoritima", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "provjeraappufavoritima", new Object[] {_mapavrijednost}));}
int _brappudoku = 0;
int _i = 0;
String _s = "";
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub ProvjeraAppUFavoritima(mapavrijednost As Strin";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="Dim brAppUDoku As Int = scvDock.Panel.NumberOfVie";
_brappudoku = mostCurrent._scvdock.getPanel().getNumberOfViews();
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="For i = 0 To brAppUDoku - 1";
{
final int step2 = 1;
final int limit2 = (int) (_brappudoku-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="Dim s As String = listaFavorita.Get(i)";
_s = BA.ObjectToString(mostCurrent._listafavorita.Get(_i));
RDebugUtils.currentLine=4849669;
 //BA.debugLineNum = 4849669;BA.debugLine="If mapavrijednost.Contains(s) = True Then";
if (_mapavrijednost.contains(_s)==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=4849670;
 //BA.debugLineNum = 4849670;BA.debugLine="ToastMessageShow(\"App already in favorites!\", F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("App already in favorites!"),anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
RDebugUtils.currentLine=4849673;
 //BA.debugLineNum = 4849673;BA.debugLine="End Sub";
return "";
}
public static String  _filtrirajimenaappiimenapaketa() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "filtrirajimenaappiimenapaketa", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "filtrirajimenaappiimenapaketa", null));}
int _i = 0;
String _pckg1 = "";
String _pckg = "";
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub FiltrirajImenaAppIImenaPaketa";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="l1.Initialize";
mostCurrent._l1.Initialize();
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="Dim l As List";
mostCurrent._l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="l.Initialize";
mostCurrent._l.Initialize();
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._starter._mapa.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="Dim pckg1 As String";
_pckg1 = "";
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
_pckg = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_i));
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pck";
_pckg1 = _pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length());
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="l1.Add(pckg1)";
mostCurrent._l1.Add((Object)(_pckg1));
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="pckg1 = pckg.SubString2(0, pckg.IndexOf(\";\"))";
_pckg1 = _pckg.substring((int) (0),_pckg.indexOf(";"));
RDebugUtils.currentLine=4128780;
 //BA.debugLineNum = 4128780;BA.debugLine="l.Add(pckg1)";
mostCurrent._l.Add((Object)(_pckg1));
 }
};
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _kreirajstavku(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b,String _imeapp,int _width,int _height) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "kreirajstavku", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(mostCurrent.activityBA, "kreirajstavku", new Object[] {_b,_imeapp,_width,_height}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub KreirajStavku(b As Bitmap, imeApp As String, W";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="p.Initialize(\"\")";
_p.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="p.Color = Colors.Transparent";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="p.SetLayout(0, btnPostavke.Height, Width, Height)";
_p.SetLayout((int) (0),mostCurrent._btnpostavke.getHeight(),_width,_height);
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="p.LoadLayout(\"clv_stavka\")";
_p.LoadLayout("clv_stavka",mostCurrent.activityBA);
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="ivApp.Bitmap = b";
mostCurrent._ivapp.setBitmap((android.graphics.Bitmap)(_b.getObject()));
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="lblImeApp.TextSize = f.fontzSize";
mostCurrent._lblimeapp.setTextSize((float) (mostCurrent._f._fontzsize));
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="lblImeApp.Typeface = Typeface.LoadFromAssets(f.wh";
mostCurrent._lblimeapp.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="lblImeApp.Text = imeApp";
mostCurrent._lblimeapp.setText(BA.ObjectToCharSequence(_imeapp));
RDebugUtils.currentLine=4390924;
 //BA.debugLineNum = 4390924;BA.debugLine="lblImeApp.TextColor = f.bojaFonta";
mostCurrent._lblimeapp.setTextColor(mostCurrent._f._bojafonta);
RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="Return p";
if (true) return _p;
RDebugUtils.currentLine=4390927;
 //BA.debugLineNum = 4390927;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.collections.List  _getalltablabels(anywheresoftware.b4a.objects.TabStripViewPager _tabstrip) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getalltablabels", false))
	 {return ((anywheresoftware.b4a.objects.collections.List) Debug.delegate(mostCurrent.activityBA, "getalltablabels", new Object[] {_tabstrip}));}
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.PanelWrapper _tc = null;
anywheresoftware.b4a.objects.collections.List _res = null;
anywheresoftware.b4a.objects.ConcreteViewWrapper _v = null;
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Public Sub GetAllTabLabels (tabstrip As TabStrip)";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="Dim jo As JavaObject = tabstrip";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_tabstrip));
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=2949123;
 //BA.debugLineNum = 2949123;BA.debugLine="r.Target = jo.GetField(\"tabStrip\")";
_r.Target = _jo.GetField("tabStrip");
RDebugUtils.currentLine=2949124;
 //BA.debugLineNum = 2949124;BA.debugLine="Dim tc As Panel = r.GetField(\"tabsContainer\")";
_tc = new anywheresoftware.b4a.objects.PanelWrapper();
_tc.setObject((android.view.ViewGroup)(_r.GetField("tabsContainer")));
RDebugUtils.currentLine=2949125;
 //BA.debugLineNum = 2949125;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2949126;
 //BA.debugLineNum = 2949126;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=2949127;
 //BA.debugLineNum = 2949127;BA.debugLine="For Each v As View In tc";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group7 = _tc;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_v.setObject((android.view.View)(group7.Get(index7)));
RDebugUtils.currentLine=2949128;
 //BA.debugLineNum = 2949128;BA.debugLine="If v Is Label Then res.Add(v)";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
_res.Add((Object)(_v.getObject()));};
 }
};
RDebugUtils.currentLine=2949131;
 //BA.debugLineNum = 2949131;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=2949132;
 //BA.debugLineNum = 2949132;BA.debugLine="End Sub";
return null;
}
public static String  _ivappmain_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivappmain_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivappmain_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub ivAppMain_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("74063238",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="in = pm.GetApplicationIntent(iv.Tag)";
_in = _pm.GetApplicationIntent(BA.ObjectToString(_iv.getTag()));
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="If in.IsInitialized Then";
if (_in.IsInitialized()) { 
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=4063245;
 //BA.debugLineNum = 4063245;BA.debugLine="End Sub";
return "";
}
public static String  _ivappmain_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivappmain_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivappmain_longclick", null));}
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.objects.collections.List _ll = null;
com.maximus.id.id _x = null;
int _m = 0;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub ivAppMain_LongClick";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Log(\"ivapp long klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("73932161","ivapp long klik!",0);
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("73932164",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="Dim ll As List";
_ll = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="ll.Initialize";
_ll.Initialize();
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="ll.AddAll(Array As String(\"Add to favorites\", \"Un";
_ll.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Add to favorites","Uninstall"}));
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=3932169;
 //BA.debugLineNum = 3932169;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
_m = _x.InputList1(_ll,"",mostCurrent.activityBA);
RDebugUtils.currentLine=3932170;
 //BA.debugLineNum = 3932170;BA.debugLine="Select m";
switch (_m) {
case 0: {
RDebugUtils.currentLine=3932172;
 //BA.debugLineNum = 3932172;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(za";
_provjeraappufavoritima(BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_zadnja_oznacena_app)));
RDebugUtils.currentLine=3932173;
 //BA.debugLineNum = 3932173;BA.debugLine="DodajAppUFavorite";
_dodajappufavorite();
 break; }
case 1: {
RDebugUtils.currentLine=3932175;
 //BA.debugLineNum = 3932175;BA.debugLine="UninstallApp(iv.Tag)";
_uninstallapp(BA.ObjectToString(_iv.getTag()));
 break; }
}
;
RDebugUtils.currentLine=3932177;
 //BA.debugLineNum = 3932177;BA.debugLine="End Sub";
return "";
}
public static String  _uninstallapp(String _pkg) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "uninstallapp", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "uninstallapp", new Object[] {_pkg}));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub UninstallApp(pkg As String)";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="If IsPaused(provjera) = True Then StartService(pr";
if (anywheresoftware.b4a.keywords.Common.IsPaused(processBA,(Object)(mostCurrent._provjera.getObject()))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(mostCurrent._provjera.getObject()));};
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="Log(\"package:\" & pkg)";
anywheresoftware.b4a.keywords.Common.LogImpl("73997701","package:"+_pkg,0);
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="i.Initialize(\"android.intent.action.DELETE\", \"pac";
_i.Initialize("android.intent.action.DELETE","package:"+_pkg);
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=3997711;
 //BA.debugLineNum = 3997711;BA.debugLine="End Sub";
return "";
}
public static String  _ivclvdodaj_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivclvdodaj_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivclvdodaj_click", null));}
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.objects.ImageViewWrapper _imgv = null;
int _index = 0;
String _pckg1 = "";
String _pckg = "";
anywheresoftware.b4a.objects.drawable.BitmapDrawable _bdw = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _bmp = null;
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub ivClvDodaj_Click";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="If lbl.IsInitialized Then lbl.RemoveView";
if (mostCurrent._lbl.IsInitialized()) { 
mostCurrent._lbl.RemoveView();};
RDebugUtils.currentLine=4784134;
 //BA.debugLineNum = 4784134;BA.debugLine="Private imgV As ImageView = Sender";
_imgv = new anywheresoftware.b4a.objects.ImageViewWrapper();
_imgv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="Private Index As Int = clv.GetItemFromView(Sender";
_index = mostCurrent._clv._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
RDebugUtils.currentLine=4784137;
 //BA.debugLineNum = 4784137;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(Inde";
_provjeraappufavoritima(BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_index)));
RDebugUtils.currentLine=4784139;
 //BA.debugLineNum = 4784139;BA.debugLine="iv.Initialize(\"ivMainApp\")";
_iv.Initialize(mostCurrent.activityBA,"ivMainApp");
RDebugUtils.currentLine=4784140;
 //BA.debugLineNum = 4784140;BA.debugLine="iv.Tag = scvDock.Panel.NumberOfViews";
_iv.setTag((Object)(mostCurrent._scvdock.getPanel().getNumberOfViews()));
RDebugUtils.currentLine=4784141;
 //BA.debugLineNum = 4784141;BA.debugLine="iv.Width = 48dip";
_iv.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=4784142;
 //BA.debugLineNum = 4784142;BA.debugLine="iv.Height = 48dip";
_iv.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=4784143;
 //BA.debugLineNum = 4784143;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=4784145;
 //BA.debugLineNum = 4784145;BA.debugLine="Dim pckg1 As String";
_pckg1 = "";
RDebugUtils.currentLine=4784146;
 //BA.debugLineNum = 4784146;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(Index)";
_pckg = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_index));
RDebugUtils.currentLine=4784147;
 //BA.debugLineNum = 4784147;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pckg";
_pckg1 = _pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length());
RDebugUtils.currentLine=4784148;
 //BA.debugLineNum = 4784148;BA.debugLine="Dim bdw As BitmapDrawable = pm.GetApplicationIcon";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_pm.GetApplicationIcon(_pckg1)));
RDebugUtils.currentLine=4784149;
 //BA.debugLineNum = 4784149;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=4784150;
 //BA.debugLineNum = 4784150;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True))";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=4784151;
 //BA.debugLineNum = 4784151;BA.debugLine="listaFavorita.Add(pckg1)	' dodaj ime paketa aplik";
mostCurrent._listafavorita.Add((Object)(_pckg1));
RDebugUtils.currentLine=4784154;
 //BA.debugLineNum = 4784154;BA.debugLine="iv.Bitmap = bdw.Bitmap'bm1";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=4784155;
 //BA.debugLineNum = 4784155;BA.debugLine="scvDock.Panel.AddView(iv, iv.Width*scvDock.Panel.";
mostCurrent._scvdock.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_iv.getWidth()*mostCurrent._scvdock.getPanel().getNumberOfViews()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4)),_iv.getWidth(),_iv.getHeight());
RDebugUtils.currentLine=4784244;
 //BA.debugLineNum = 4784244;BA.debugLine="imgV.Bitmap = LoadBitmap(File.DirAssets, \"act_add";
_imgv.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"act_add_pressed.png").getObject()));
RDebugUtils.currentLine=4784246;
 //BA.debugLineNum = 4784246;BA.debugLine="File.WriteList(File.DirInternal, \"favorit_app\", l";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app",mostCurrent._listafavorita);
RDebugUtils.currentLine=4784248;
 //BA.debugLineNum = 4784248;BA.debugLine="ToastMessageShow(\"Application added to favorites.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Application added to favorites."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4784249;
 //BA.debugLineNum = 4784249;BA.debugLine="End Sub";
return "";
}
public static String  _ivdokpokreniapp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivdokpokreniapp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivdokpokreniapp_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub ivDokPokreniApp_Click";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Log(\"klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("74915201","klik!",0);
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=4915206;
 //BA.debugLineNum = 4915206;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=4915207;
 //BA.debugLineNum = 4915207;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("74915207",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=4915209;
 //BA.debugLineNum = 4915209;BA.debugLine="Log(listaFavorita.Get(iv.Tag))";
anywheresoftware.b4a.keywords.Common.LogImpl("74915209",BA.ObjectToString(mostCurrent._listafavorita.Get((int)(BA.ObjectToNumber(_iv.getTag())))),0);
RDebugUtils.currentLine=4915210;
 //BA.debugLineNum = 4915210;BA.debugLine="in = pm.GetApplicationIntent(listaFavorita.Get(iv";
_in = _pm.GetApplicationIntent(BA.ObjectToString(mostCurrent._listafavorita.Get((int)(BA.ObjectToNumber(_iv.getTag())))));
RDebugUtils.currentLine=4915211;
 //BA.debugLineNum = 4915211;BA.debugLine="If in.IsInitialized Then";
if (_in.IsInitialized()) { 
RDebugUtils.currentLine=4915214;
 //BA.debugLineNum = 4915214;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=4915216;
 //BA.debugLineNum = 4915216;BA.debugLine="End Sub";
return "";
}
public static String  _ivwheeldodaj_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivwheeldodaj_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivwheeldodaj_click", null));}
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub ivWheelDodaj_Click";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Log(\"vil dodaj klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("74325377","vil dodaj klik!",0);
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="ivWheelDodaj.BringToFront";
mostCurrent._ivwheeldodaj.BringToFront();
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="If lbl.IsInitialized Then lbl.RemoveView";
if (mostCurrent._lbl.IsInitialized()) { 
mostCurrent._lbl.RemoveView();};
RDebugUtils.currentLine=4325395;
 //BA.debugLineNum = 4325395;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(zadn";
_provjeraappufavoritima(BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_zadnja_oznacena_app)));
RDebugUtils.currentLine=4325396;
 //BA.debugLineNum = 4325396;BA.debugLine="DodajAppUFavorite";
_dodajappufavorite();
RDebugUtils.currentLine=4325494;
 //BA.debugLineNum = 4325494;BA.debugLine="File.WriteList(File.DirInternal, \"favorit_app\", l";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app",mostCurrent._listafavorita);
RDebugUtils.currentLine=4325495;
 //BA.debugLineNum = 4325495;BA.debugLine="End Sub";
return "";
}
public static String  _kontaktigrid_finishedloading() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "kontaktigrid_finishedloading", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "kontaktigrid_finishedloading", null));}
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub kontaktiGrid_FinishedLoading";
RDebugUtils.currentLine=5832705;
 //BA.debugLineNum = 5832705;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="End Sub";
return "";
}
public static String  _kontaktigrid_itemclicked(String _item) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "kontaktigrid_itemclicked", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "kontaktigrid_itemclicked", new Object[] {_item}));}
anywheresoftware.b4a.objects.collections.List _ll = null;
com.maximus.id.id _x = null;
int _m = 0;
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub kontaktiGrid_ItemClicked(Item As String)";
RDebugUtils.currentLine=5767169;
 //BA.debugLineNum = 5767169;BA.debugLine="Log(Item)";
anywheresoftware.b4a.keywords.Common.LogImpl("75767169",_item,0);
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="Dim ll As List";
_ll = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="ll.Initialize";
_ll.Initialize();
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="ll.AddAll(Array As String(\"Call\", \"SMS\", \"EMail\",";
_ll.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Call","SMS","EMail","Info"}));
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
_m = _x.InputList1(_ll,"",mostCurrent.activityBA);
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="Log(m)";
anywheresoftware.b4a.keywords.Common.LogImpl("75767175",BA.NumberToString(_m),0);
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="Select m";
switch (_m) {
case 0: {
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="btnKontaktPoziv_Click(Item.Replace(\"file:///\",";
_btnkontaktpoziv_click(_item.replace("file:///",""));
 break; }
case 1: {
RDebugUtils.currentLine=5767180;
 //BA.debugLineNum = 5767180;BA.debugLine="btnKontaktSMS_Click(Item.Replace(\"file:///\", \"\"";
_btnkontaktsms_click(_item.replace("file:///",""));
 break; }
case 2: {
RDebugUtils.currentLine=5767182;
 //BA.debugLineNum = 5767182;BA.debugLine="btnKontaktEmail_Click(Item.Replace(\"file:///\",";
_btnkontaktemail_click(_item.replace("file:///",""));
 break; }
case 3: {
RDebugUtils.currentLine=5767184;
 //BA.debugLineNum = 5767184;BA.debugLine="btnKontaktInfo_Click(Item.Replace(\"file:///\", \"";
_btnkontaktinfo_click(_item.replace("file:///",""));
 break; }
}
;
RDebugUtils.currentLine=5767186;
 //BA.debugLineNum = 5767186;BA.debugLine="End Sub";
return "";
}
public static String  _lblimeapp_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblimeapp_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblimeapp_longclick", null));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub lblImeApp_LongClick";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="Log(\"lblimeapp long klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("74653057","lblimeapp long klik!",0);
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="End Sub";
return "";
}
public static String  _osvjezi() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "osvjezi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "osvjezi", null));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub Osvjezi";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="f.UcitajVrijednostiOpt";
mostCurrent._f._ucitajvrijednostiopt(mostCurrent.activityBA);
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="ViewsBringToFront";
_viewsbringtofront();
RDebugUtils.currentLine=4587525;
 //BA.debugLineNum = 4587525;BA.debugLine="If scvDock.IsInitialized Then scvDock.Panel.Remov";
if (mostCurrent._scvdock.IsInitialized()) { 
mostCurrent._scvdock.getPanel().RemoveAllViews();};
RDebugUtils.currentLine=4587531;
 //BA.debugLineNum = 4587531;BA.debugLine="ShowFavoriteApps";
_showfavoriteapps();
RDebugUtils.currentLine=4587567;
 //BA.debugLineNum = 4587567;BA.debugLine="End Sub";
return "";
}
public static String  _scvpanel_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "scvpanel_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "scvpanel_longclick", null));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub scvPanel_LongClick";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Log(\"scvDock long klik\")";
anywheresoftware.b4a.keywords.Common.LogImpl("73473409","scvDock long klik",0);
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="End Sub";
return "";
}
public static boolean  _scvpanel_touch(Object _vt_iv,int _action,float _x,float _y,Object _motionevent) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "scvpanel_touch", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "scvpanel_touch", new Object[] {_vt_iv,_action,_x,_y,_motionevent}));}
int _numlab = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _iv1 = null;
String _tag = "";
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub scvPanel_Touch(vt_iv As Object, Action As Int,";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN)) {
case 0: {
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="If lbl.IsInitialized = False Then";
if (mostCurrent._lbl.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="Dim NumLab As Int = (X / 48dip)	' if labels ar";
_numlab = (int) ((_x/(double)anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))));
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="Dim iv1 As ImageView = scvDock.Panel.getview(N";
_iv1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
_iv1.setObject((android.widget.ImageView)(mostCurrent._scvdock.getPanel().GetView(_numlab).getObject()));
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="Dim Tag As String = iv1.Tag";
_tag = BA.ObjectToString(_iv1.getTag());
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="Log(Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("73538951",_tag,0);
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="Log(listaFavorita.Get(Tag))";
anywheresoftware.b4a.keywords.Common.LogImpl("73538952",BA.ObjectToString(mostCurrent._listafavorita.Get((int)(Double.parseDouble(_tag)))),0);
 };
RDebugUtils.currentLine=3538954;
 //BA.debugLineNum = 3538954;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 break; }
}
;
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=3538958;
 //BA.debugLineNum = 3538958;BA.debugLine="End Sub";
return false;
}
public static String  _smartwidgets_backpressed(int _widgetid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "smartwidgets_backpressed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "smartwidgets_backpressed", new Object[] {_widgetid}));}
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub SmartWidgets_BackPressed (WidgetId As Int)";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="Log(\"Back pressed\")";
anywheresoftware.b4a.keywords.Common.LogImpl("75177345","Back pressed",0);
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="End Sub";
return "";
}
public static String  _smartwidgets_widgetcreated(int _hostid,Object _hostview,int _widgetid,Object _widgetinfo) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "smartwidgets_widgetcreated", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "smartwidgets_widgetcreated", new Object[] {_hostid,_hostview,_widgetid,_widgetinfo}));}
anywheresoftware.b4a.objects.PanelWrapper _widget_panel = null;
com.rootsoft.rssmartwidgets.RSAppWidgetProviderInfo _info = null;
com.rootsoft.rssmartwidgets.RSAppWidgetHostView _hw = null;
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub SmartWidgets_WidgetCreated (HostId As Int, Hos";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="Dim widget_panel As Panel";
_widget_panel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=5111811;
 //BA.debugLineNum = 5111811;BA.debugLine="Dim Info As RSWidgetProviderInfo = widgetinfo";
_info = new com.rootsoft.rssmartwidgets.RSAppWidgetProviderInfo();
_info.setObject((android.appwidget.AppWidgetProviderInfo)(_widgetinfo));
RDebugUtils.currentLine=5111812;
 //BA.debugLineNum = 5111812;BA.debugLine="Dim hw As RSWidgetHostView = HostView";
_hw = new com.rootsoft.rssmartwidgets.RSAppWidgetHostView();
_hw.setObject((android.appwidget.AppWidgetHostView)(_hostview));
RDebugUtils.currentLine=5111820;
 //BA.debugLineNum = 5111820;BA.debugLine="Log(hw)";
anywheresoftware.b4a.keywords.Common.LogImpl("75111820",BA.ObjectToString(_hw),0);
RDebugUtils.currentLine=5111821;
 //BA.debugLineNum = 5111821;BA.debugLine="Log(HostId)";
anywheresoftware.b4a.keywords.Common.LogImpl("75111821",BA.NumberToString(_hostid),0);
RDebugUtils.currentLine=5111822;
 //BA.debugLineNum = 5111822;BA.debugLine="Log(WidgetId)";
anywheresoftware.b4a.keywords.Common.LogImpl("75111822",BA.NumberToString(_widgetid),0);
RDebugUtils.currentLine=5111823;
 //BA.debugLineNum = 5111823;BA.debugLine="widget_panel.Initialize(\"\")";
_widget_panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=5111824;
 //BA.debugLineNum = 5111824;BA.debugLine="widget_panel = hw'HostView' SmartWidgets.HostView";
_widget_panel.setObject((android.view.ViewGroup)(_hw.getObject()));
RDebugUtils.currentLine=5111825;
 //BA.debugLineNum = 5111825;BA.debugLine="Log(hw)";
anywheresoftware.b4a.keywords.Common.LogImpl("75111825",BA.ObjectToString(_hw),0);
RDebugUtils.currentLine=5111826;
 //BA.debugLineNum = 5111826;BA.debugLine="Log(HostId)";
anywheresoftware.b4a.keywords.Common.LogImpl("75111826",BA.NumberToString(_hostid),0);
RDebugUtils.currentLine=5111827;
 //BA.debugLineNum = 5111827;BA.debugLine="Log(WidgetId)";
anywheresoftware.b4a.keywords.Common.LogImpl("75111827",BA.NumberToString(_widgetid),0);
RDebugUtils.currentLine=5111828;
 //BA.debugLineNum = 5111828;BA.debugLine="If DipToCurrent(Info.MinWidth) > GetDeviceLayoutV";
if (anywheresoftware.b4a.keywords.Common.DipToCurrent(_info.getMinWidth())>anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Width) { 
RDebugUtils.currentLine=5111829;
 //BA.debugLineNum = 5111829;BA.debugLine="widget_panel.Width = Info.MinWidth";
_widget_panel.setWidth(_info.getMinWidth());
 }else {
RDebugUtils.currentLine=5111831;
 //BA.debugLineNum = 5111831;BA.debugLine="widget_panel.Width = DipToCurrent(Info.MinWidth)";
_widget_panel.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent(_info.getMinWidth()));
 };
RDebugUtils.currentLine=5111834;
 //BA.debugLineNum = 5111834;BA.debugLine="If DipToCurrent(Info.MinHeight) > GetDeviceLayout";
if (anywheresoftware.b4a.keywords.Common.DipToCurrent(_info.getMinHeight())>anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Height) { 
RDebugUtils.currentLine=5111835;
 //BA.debugLineNum = 5111835;BA.debugLine="widget_panel.Height = Info.MinHeight";
_widget_panel.setHeight(_info.getMinHeight());
 }else {
RDebugUtils.currentLine=5111837;
 //BA.debugLineNum = 5111837;BA.debugLine="widget_panel.Height = DipToCurrent(Info.MinHeigh";
_widget_panel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent(_info.getMinHeight()));
 };
RDebugUtils.currentLine=5111840;
 //BA.debugLineNum = 5111840;BA.debugLine="ipsilon = widget_panel.Height";
_ipsilon = _widget_panel.getHeight();
RDebugUtils.currentLine=5111841;
 //BA.debugLineNum = 5111841;BA.debugLine="SmartWidgets.AddView(Panel1, widget_panel, 0, top";
_smartwidgets.AddView(mostCurrent._panel1,(android.appwidget.AppWidgetHostView)(_widget_panel.getObject()),(int) (0),_topw);
RDebugUtils.currentLine=5111842;
 //BA.debugLineNum = 5111842;BA.debugLine="topW = topW + ipsilon";
_topw = (int) (_topw+_ipsilon);
RDebugUtils.currentLine=5111852;
 //BA.debugLineNum = 5111852;BA.debugLine="Log(hw)";
anywheresoftware.b4a.keywords.Common.LogImpl("75111852",BA.ObjectToString(_hw),0);
RDebugUtils.currentLine=5111853;
 //BA.debugLineNum = 5111853;BA.debugLine="SmartWidgets.StartListening";
_smartwidgets.StartListening();
RDebugUtils.currentLine=5111917;
 //BA.debugLineNum = 5111917;BA.debugLine="File.WriteString(File.DirInternal, \"thehost.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"thehost.txt",BA.ObjectToString(_hostview));
RDebugUtils.currentLine=5111918;
 //BA.debugLineNum = 5111918;BA.debugLine="File.writestring(File.DirInternal, \"theid.txt\", H";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"theid.txt",BA.NumberToString(_hostid));
RDebugUtils.currentLine=5111919;
 //BA.debugLineNum = 5111919;BA.debugLine="File.WriteString(File.DirInternal, \"theappid.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"theappid.txt",BA.NumberToString(_smartwidgets.getAppWidgetId()));
RDebugUtils.currentLine=5111920;
 //BA.debugLineNum = 5111920;BA.debugLine="End Sub";
return "";
}
public static String  _tajmer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tajmer_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tajmer_tick", null));}
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Sub tajmer_Tick";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="NotificationService.brojNotifikacija = 0";
mostCurrent._notificationservice._brojnotifikacija = (int) (0);
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="CallSubDelayed(NotificationService, \"GetActive\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._notificationservice.getObject()),"GetActive");
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="Log(NotificationService.brojNotifikacija)";
anywheresoftware.b4a.keywords.Common.LogImpl("75308419",BA.NumberToString(mostCurrent._notificationservice._brojnotifikacija),0);
RDebugUtils.currentLine=5308420;
 //BA.debugLineNum = 5308420;BA.debugLine="End Sub";
return "";
}
public static String  _wp1_index_changed(int _currentindex) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "wp1_index_changed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "wp1_index_changed", new Object[] {_currentindex}));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub wp1_index_changed (currentindex As Int)";
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="If zadnja_oznacena_app <> currentindex Then";
if (_zadnja_oznacena_app!=_currentindex) { 
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="zadnja_oznacena_app = currentindex";
_zadnja_oznacena_app = _currentindex;
 };
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="End Sub";
return "";
}
public static String  _wp1_index_clicked(int _position) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "wp1_index_clicked", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "wp1_index_clicked", new Object[] {_position}));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub wp1_index_clicked(position As Int)";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="in = pm.GetApplicationIntent(l1.Get(zadnja_oznace";
_in = _pm.GetApplicationIntent(BA.ObjectToString(mostCurrent._l1.Get(_zadnja_oznacena_app)));
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="If in.IsInitialized Then";
if (_in.IsInitialized()) { 
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="Log(f.animStr)";
anywheresoftware.b4a.keywords.Common.LogImpl("73670022",mostCurrent._f._animstr,0);
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=3670027;
 //BA.debugLineNum = 3670027;BA.debugLine="End Sub";
return "";
}



public Bitmap getHexagonShape(Bitmap scaleBitmapImage) {

// TODO Auto-generated method stub

    int targetWidth = 32;
    int targetHeight = 32;

	Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight,Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(targetBitmap);
    Path path = new Path();
    float stdW = 32;
    float stdH = 32;
    float w3 =stdW / 2;
    float h2 = stdH / 2;
    path.moveTo(0, (float) (h2*Math.sqrt(3)/2));
    path.rLineTo(w3/2, -(float) (h2*Math.sqrt(3)/2)); path.rLineTo(w3, 0);   path.rLineTo(w3/2, (float) (h2*Math.sqrt(3)/2));
    path.rLineTo(-w3/2, (float) (h2*Math.sqrt(3)/2)); path.rLineTo(-w3, 0); path.rLineTo(-w3/2, -(float) (h2*Math.sqrt(3)/2));
    canvas.clipPath(path);
    Bitmap sourceBitmap = scaleBitmapImage;
    canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
    sourceBitmap.getHeight()),new Rect(0, 0, targetWidth, targetHeight), null);
    return targetBitmap;
}

public static Bitmap getRoundBitmap(Bitmap scaleBitmapImage) {
	int targetWidth = 32;
	int targetHeight = 32;
	Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight,
			Bitmap.Config.ARGB_8888);

	Canvas canvas = new Canvas(targetBitmap);
	Path path = new Path();
	path.addCircle(((float) targetWidth - 1) / 2,
			((float) targetHeight - 1) / 2,
			(Math.min(((float) targetWidth), ((float) targetHeight)) / 2),
			Path.Direction.CCW);

	canvas.clipPath(path);
	Bitmap sourceBitmap = scaleBitmapImage;
	canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
		sourceBitmap.getHeight()), new Rect(0, 0, targetWidth,
		targetHeight), null);
	return targetBitmap;
}
	
public static Drawable getRoundDrawable(Drawable d){
	Bitmap b=getRoundBitmap(((BitmapDrawable) d).getBitmap());
	return new BitmapDrawable(b);
}

public Bitmap getTriangleShape(Bitmap scaleBitmapImage) {

      // TODO Auto-generated method stub

        int targetWidth = 32;
        int targetHeight = 32;

        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        float stdW = 32;
        float stdH = 32;
        float w3 =stdW;
        float h2 = stdH;
		
        path.moveTo((float) w3/2, (float) 0.0);
        path.lineTo(w3, (float) h2); 
		path.lineTo((float)0.0, h2);   
		path.lineTo(w3/2, (float) 0.0);

        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
        sourceBitmap.getHeight()),new Rect(0, 0, targetWidth, targetHeight), null);
        return targetBitmap;
     }

public static Bitmap getStarBitmap (Bitmap scaleBitmapImage, int steps) {
	  int targetWidth = 32;
	  int targetHeight = 32;

	  Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);
	  Canvas canvas = new Canvas(targetBitmap);
	  Path path = new Path();

      float halfWidth = targetWidth / 2.0F;
      float bigRadius = halfWidth;
      float radius = halfWidth / 2.0F;
      float degreesPerStep = (float) Math.toRadians(360.0F / (float) steps);
      float halfDegreesPerStep = degreesPerStep / 2.0F;
	  
      Path ret = new Path();
      ret.setFillType(FillType.EVEN_ODD);
      float max = (float) (2.0F* Math.PI);
      ret.moveTo(targetWidth, halfWidth);
      for (double step = 0; step < max; step += degreesPerStep) {
        ret.lineTo((float)(halfWidth + bigRadius * Math.cos(step)), (float)(halfWidth + bigRadius * Math.sin(step)));
        ret.lineTo((float)(halfWidth + radius * Math.cos(step + halfDegreesPerStep)), (float)(halfWidth + radius * Math.sin(step + halfDegreesPerStep)));
      }
      ret.close();
	  canvas.clipPath(ret);
	
	  Bitmap sourceBitmap = scaleBitmapImage;
	  canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
			sourceBitmap.getHeight()), new Rect(0, 0, targetWidth,
			targetHeight), null);
	  return targetBitmap;
}

public static Bitmap getHeartBitmap (Bitmap scaleBitmapImage) {
	  int targetWidth = 32;
	  int targetHeight = 32;
	  

	  Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);
	  
	  Canvas canvas = new Canvas(targetBitmap);
	  Path path = new Path();
      RectF oval = new RectF();
	  
	  oval.set(0, 0, targetWidth/2, targetHeight/2);
	  path.moveTo((float) 0.0, (float) oval.height()/2);
      path.addArc(oval, 0, 360);  //from point 180 degree(9 o' clock position), go 180 degrees clockwise (to 3 o' clock position)
      
      oval.set(targetWidth/2, 0, targetWidth, targetHeight/2);
	  path.moveTo((float) 0.0, (float) oval.height()/2);
      path.addArc(oval, 0, 360);  //from point 180 degree(9 o' clock position), go 180 degrees clockwise (to 3 o' clock position)
	  
	  path.moveTo((float) targetWidth-11, (float) (targetHeight*0.34));
      path.lineTo((float) targetWidth/2, (float) targetHeight); 
	  path.lineTo((float) 11, (float) (targetHeight*0.34)); 
	  
	  path.moveTo((float) 0.0, (float) (targetHeight*0.25));
	  path.lineTo((float) targetWidth, (float) (targetHeight*0.25));
	  path.lineTo((float) targetWidth/2, (float) targetHeight); 
	  path.lineTo((float) 0.0, (float) (targetHeight*0.25));
	  
	  
	  canvas.clipPath(path);
	
	  Bitmap sourceBitmap = scaleBitmapImage;
	  canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
			sourceBitmap.getHeight()), new Rect(0, 0, targetWidth,
			targetHeight), null);
	  return targetBitmap;
}

public static Bitmap getBubbleBitmap(Bitmap scaleBitmapImage, int targetWidth, int targetHeight) {
//      int targetWidth = 400;
//      int targetHeight = 400;

      Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

      Canvas canvas = new Canvas(targetBitmap);
      Path path = new Path();

      path.moveTo((float) targetWidth/2, (float) 0.0);
      path.lineTo(targetWidth, (float) 0.0);
      path.lineTo((float)targetWidth, targetHeight/2);  

      RectF oval = new RectF();
      oval.set(0, 0, targetWidth, targetHeight);
      path.addArc(oval, 0, 270);
      canvas.clipPath(path);
   
      Bitmap sourceBitmap = scaleBitmapImage;
      canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
            sourceBitmap.getHeight()), new Rect(0, 0, targetWidth,
            targetHeight), null);
      return targetBitmap;
}

/*public static Bitmap getBubbleBitmap(Bitmap scaleBitmapImage) {
	  int targetWidth = 20;
	  int targetHeight = 20;

	  Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

	  Canvas canvas = new Canvas(targetBitmap);
	  Path path = new Path();

      path.moveTo((float) targetWidth/2, (float) 0.0);
      path.lineTo(targetWidth, (float) 0.0); 
	  path.lineTo((float)targetWidth, targetHeight/2);   

      RectF oval = new RectF();
	  oval.set(0, 0, targetWidth, targetHeight);
	  path.addArc(oval, 0, 270);
	  canvas.clipPath(path);
	
	  Bitmap sourceBitmap = scaleBitmapImage;
	  canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
			sourceBitmap.getHeight()), new Rect(0, 0, targetWidth,
			targetHeight), null);
	  return targetBitmap;
}*/

public static Bitmap getConeBitmap(Bitmap scaleBitmapImage) {
	  int targetWidth = 32;
	  int targetHeight = 32;

	  Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);

	  Canvas canvas = new Canvas(targetBitmap);
	  Path path = new Path();

      path.moveTo((float) targetWidth, (float) targetHeight/2);
      path.lineTo(targetWidth/2, (float) targetHeight); 
	  path.lineTo((float)0.0, targetHeight/2);   

      RectF oval = new RectF();
	  oval.set(0, 0, targetWidth, targetHeight);
	  path.addArc(oval, 180, 180);  //from point 180 degree(9 o' clock position), go 180 degrees clockwise (to 3 o' clock position)
	  canvas.clipPath(path);
	
	  Bitmap sourceBitmap = scaleBitmapImage;
	  canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
			sourceBitmap.getHeight()), new Rect(0, 0, targetWidth,
			targetHeight), null);
	  return targetBitmap;
}

public static Bitmap getJollyPatrolly (Bitmap scaleBitmapImage) {

	int targetWidth = 32; // 1000
	int targetHeight = 32; // 1000

	Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888);
	  
	Canvas canvas = new Canvas(targetBitmap);
	Path path = new Path();
    RectF oval = new RectF();

    Paint paint = new Paint();
    paint.setColor(Color.BLUE);
    paint.setAntiAlias(true);
    paint.setStyle(Paint.Style.STROKE);

    float mid = targetWidth / 2;
    float min = targetWidth;
    float fat = min / 17;
    float half = min / 2;
    float rad = half - fat;
    mid = mid - half;

    paint.setStrokeWidth(fat);
    paint.setStyle(Paint.Style.STROKE);

    canvas.drawCircle(mid + half, half, rad, paint);

    path.reset();

    paint.setStyle(Paint.Style.FILL);

    // top left
    path.moveTo(mid + half * 0.5f, half * 0.84f);
    // top right
    path.lineTo(mid + half * 1.5f, half * 0.84f);
    // bottom left
    path.lineTo(mid + half * 0.68f, half * 1.45f);
    // top tip
    path.lineTo(mid + half * 1.0f, half * 0.5f);
    // bottom right
    path.lineTo(mid + half * 1.32f, half * 1.45f);
    // top left
    path.lineTo(mid + half * 0.5f, half * 0.84f);

    path.close();
    canvas.clipPath(path);
      
	Bitmap sourceBitmap = scaleBitmapImage;
	canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
		sourceBitmap.getHeight()), new Rect(0, 0, targetWidth,
		targetHeight), null);
	return targetBitmap;
}

public Bitmap drawRing2(Bitmap bitmap, int deltaRadius,	int color, int bordercolor) {
	bitmap = squareImage(bitmap);		
	bitmap = toRoundCorner(bitmap,bordercolor);	
	int w = bitmap.getWidth();
	int dia = deltaRadius * 2 + w;
	float radius = (float) dia / 2;
	Bitmap resultBitmap = Bitmap.createBitmap(dia, dia, Config.ARGB_8888);
	Paint paint = new Paint();
	paint.setColor(color);
	paint.setAlpha(128);
	paint.setAntiAlias(true);
	Canvas canvas = new Canvas(resultBitmap);
	canvas.drawCircle(radius, radius, radius, paint);
	canvas.drawBitmap(bitmap, deltaRadius, deltaRadius, null);
	return resultBitmap;
}

public Bitmap squareImage(Bitmap bitmap) {
	if (bitmap == null) {
		return null;
	}
	int width = bitmap.getWidth();
	int height = bitmap.getHeight();
	if (width == height) {
		BA.Log("no need to square image");
		return bitmap;
	}
	int x = (height < width) ? ((width - height) / 2) : 0;
	int y = (width < height) ? ((height - width) / 2) : 0;
	int pixels = width < height ? width : height;
	Bitmap square = Bitmap.createBitmap(bitmap, x, y, pixels, pixels);

	return square;
}

public Bitmap toRoundCorner(Bitmap bitmap, int color) {
	try {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		final int delta = dp2px(10);
		final float roundPx = dp2px(28);
		final Paint paint = new Paint();
		paint.setAntiAlias(true);

		/* draw round foreground */
		int foreW = w - 2 * delta;
		int foreH = h - 2 * delta;
		Bitmap foreBmp = Bitmap.createBitmap(foreW, foreH, Config.ARGB_8888);
		Rect rect = new Rect(0, 0, foreW, foreH);
		RectF rectF = new RectF(rect);
		Canvas canvas0 = new Canvas(foreBmp);
		canvas0.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas0.drawBitmap(bitmap, null, rect, paint);

		/* draw round background */
		Drawable drawable = getDrawbale(color, (int) (delta + roundPx));
		drawable.setBounds(0, 0, w, h);
		Bitmap result = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		Canvas canvas = new Canvas(result);
		drawable.draw(canvas);
		canvas.drawBitmap(foreBmp, delta, delta, null);

		return result;
	} catch (Exception e) {
		e.printStackTrace();
		return bitmap;
	}
}

	public int dp2px(int dip) {
		Resources resources = getResources();
		int px = Math
				.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
						dip, resources.getDisplayMetrics()));
		return px;
	}

	public GradientDrawable getDrawbale(int argb, int radius) {
		GradientDrawable drawable = new GradientDrawable();
		drawable.setCornerRadius(radius);
		drawable.setColor(argb);
		return drawable;
	}

}