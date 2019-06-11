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
public b4a.example3.customlistview _customlistview1 = null;
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
anywheresoftware.b4a.keywords.Common.LogImpl("3131105","f.animStr: "+mostCurrent._f._animstr,0);
RDebugUtils.currentLine=131108;
 //BA.debugLineNum = 131108;BA.debugLine="Log(\"f.brStranica: \" & f.brStranica)";
anywheresoftware.b4a.keywords.Common.LogImpl("3131108","f.brStranica: "+BA.NumberToString(mostCurrent._f._brstranica),0);
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
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Sub TabStrip1_PageSelected (Position As Int)";
RDebugUtils.currentLine=2686977;
 //BA.debugLineNum = 2686977;BA.debugLine="Log($\"Current page: ${Position}\"$)";
anywheresoftware.b4a.keywords.Common.LogImpl("32686977",("Current page: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_position))+""),0);
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="For Each lbl As Label In GetAllTabLabels(TabStrip";
mostCurrent._lbl = new anywheresoftware.b4a.objects.LabelWrapper();
{
final anywheresoftware.b4a.BA.IterableList group3 = _getalltablabels(mostCurrent._tabstrip1);
final int groupLen3 = group3.getSize()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
mostCurrent._lbl.setObject((android.widget.TextView)(group3.Get(index3)));
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="If i = Position Then lbl.TextColor = Colors.Blue";
if (_i==_position) { 
mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Blue);}
else {
mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Red);};
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="i = i + 1";
_i = (int) (_i+1);
 }
};
RDebugUtils.currentLine=2686983;
 //BA.debugLineNum = 2686983;BA.debugLine="If TabStrip1.CurrentPage = 1 And pnlKontakti.Numb";
if (mostCurrent._tabstrip1.getCurrentPage()==1 && mostCurrent._pnlkontakti.getNumberOfViews()==0) { 
RDebugUtils.currentLine=2686984;
 //BA.debugLineNum = 2686984;BA.debugLine="UbaciKontakte2";
_ubacikontakte2();
 };
RDebugUtils.currentLine=2686986;
 //BA.debugLineNum = 2686986;BA.debugLine="End Sub";
return "";
}
public static int[]  _getargb(int _color) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getargb", false))
	 {return ((int[]) Debug.delegate(mostCurrent.activityBA, "getargb", new Object[] {_color}));}
int[] _res = null;
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Sub getARGB(Color As Int) As Int()";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (0)] = anywheresoftware.b4a.keywords.Common.Bit.UnsignedShiftRight(anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff000000)),(int) (24));
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (1)] = anywheresoftware.b4a.keywords.Common.Bit.UnsignedShiftRight(anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff0000)),(int) (16));
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (2)] = anywheresoftware.b4a.keywords.Common.Bit.UnsignedShiftRight(anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff00)),(int) (8));
RDebugUtils.currentLine=2424838;
 //BA.debugLineNum = 2424838;BA.debugLine="res(3) = Bit.And(Color, 0xff)";
_res[(int) (3)] = anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff));
RDebugUtils.currentLine=2424840;
 //BA.debugLineNum = 2424840;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=2424841;
 //BA.debugLineNum = 2424841;BA.debugLine="End Sub";
return null;
}
public static String  _viewsbringtofront() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "viewsbringtofront", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "viewsbringtofront", null));}
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Sub ViewsBringToFront";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="btnSearch.BringToFront";
mostCurrent._btnsearch.BringToFront();
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="btnNotify.BringToFront";
mostCurrent._btnnotify.BringToFront();
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="btnPostavke.BringToFront";
mostCurrent._btnpostavke.BringToFront();
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Private Sub ShowFavoriteApps";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="File.Delete(File.DirInternal, \"favorit_app\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app");
RDebugUtils.currentLine=786439;
 //BA.debugLineNum = 786439;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (211),(int) (211),(int) (211)),(int) (0));
RDebugUtils.currentLine=786441;
 //BA.debugLineNum = 786441;BA.debugLine="If File.Exists(File.DirInternal, \"favorit_app\") T";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app")) { 
RDebugUtils.currentLine=786442;
 //BA.debugLineNum = 786442;BA.debugLine="listaFavorita = File.ReadList(File.DirInternal,";
mostCurrent._listafavorita = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app");
RDebugUtils.currentLine=786443;
 //BA.debugLineNum = 786443;BA.debugLine="For i = 0 To listaFavorita.Size - 1";
{
final int step8 = 1;
final int limit8 = (int) (mostCurrent._listafavorita.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit8 ;_i = _i + step8 ) {
RDebugUtils.currentLine=786461;
 //BA.debugLineNum = 786461;BA.debugLine="iv.Initialize(\"ivDokPokreniApp\")";
_iv.Initialize(mostCurrent.activityBA,"ivDokPokreniApp");
RDebugUtils.currentLine=786463;
 //BA.debugLineNum = 786463;BA.debugLine="iv.Tag = i";
_iv.setTag((Object)(_i));
RDebugUtils.currentLine=786464;
 //BA.debugLineNum = 786464;BA.debugLine="iv.Width = 48dip";
_iv.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=786465;
 //BA.debugLineNum = 786465;BA.debugLine="iv.Height = 48dip";
_iv.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=786466;
 //BA.debugLineNum = 786466;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=786475;
 //BA.debugLineNum = 786475;BA.debugLine="Dim bdw As BitmapDrawable = pm.GetApplicationIc";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_pm.GetApplicationIcon(BA.ObjectToString(mostCurrent._listafavorita.Get(_i)))));
RDebugUtils.currentLine=786476;
 //BA.debugLineNum = 786476;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=786477;
 //BA.debugLineNum = 786477;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True))";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=786478;
 //BA.debugLineNum = 786478;BA.debugLine="iv.Bitmap = bdw.Bitmap";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=786498;
 //BA.debugLineNum = 786498;BA.debugLine="scvDock.Panel.AddView(iv, iv.Width*i + i*10dip,";
mostCurrent._scvdock.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_iv.getWidth()*_i+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4)),_iv.getWidth(),_iv.getHeight());
 }
};
RDebugUtils.currentLine=786501;
 //BA.debugLineNum = 786501;BA.debugLine="scvDock.Panel.Width = scvDock.Panel.NumberOfView";
mostCurrent._scvdock.getPanel().setWidth((int) (mostCurrent._scvdock.getPanel().getNumberOfViews()*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))+mostCurrent._scvdock.getPanel().getNumberOfViews()*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 }else {
RDebugUtils.currentLine=786504;
 //BA.debugLineNum = 786504;BA.debugLine="lbl.Initialize(\"\")";
mostCurrent._lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=786505;
 //BA.debugLineNum = 786505;BA.debugLine="lbl.Text = \"Add some apps here (long click on ap";
mostCurrent._lbl.setText(BA.ObjectToCharSequence("Add some apps here (long click on app icon in search window -> 'Add to favorites' or tap '+' in list of all applications)"));
RDebugUtils.currentLine=786506;
 //BA.debugLineNum = 786506;BA.debugLine="lbl.TextColor = Colors.yellow'Red";
mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Yellow);
RDebugUtils.currentLine=786507;
 //BA.debugLineNum = 786507;BA.debugLine="lbl.TextSize = 12.0";
mostCurrent._lbl.setTextSize((float) (12.0));
RDebugUtils.currentLine=786508;
 //BA.debugLineNum = 786508;BA.debugLine="scvDock.Panel.AddView(lbl, 0, 0, scvDock.Width,";
mostCurrent._scvdock.getPanel().AddView((android.view.View)(mostCurrent._lbl.getObject()),(int) (0),(int) (0),mostCurrent._scvdock.getWidth(),mostCurrent._scvdock.getHeight());
RDebugUtils.currentLine=786509;
 //BA.debugLineNum = 786509;BA.debugLine="scvDock.Panel.Width = 100%x";
mostCurrent._scvdock.getPanel().setWidth(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA));
 };
RDebugUtils.currentLine=786513;
 //BA.debugLineNum = 786513;BA.debugLine="End Sub";
return "";
}
public static String  _btndock_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btndock_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btndock_click", null));}
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub btnDock_Click";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="If pnl_dock_vidljiv Then";
if (_pnl_dock_vidljiv) { 
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="btnDock.SendToBack";
mostCurrent._btndock.SendToBack();
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="pnlDock.SendToBack";
mostCurrent._pnldock.SendToBack();
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="pnl_dock_vidljiv = False";
_pnl_dock_vidljiv = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="btnDock.SetBackgroundImage(LoadBitmap(File.DirAs";
mostCurrent._btndock.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"scvdock_otvori.png").getObject()));
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="pnlDock.SetLayoutAnimated(500, 15%x, 100%y - pnl";
mostCurrent._pnldock.SetLayoutAnimated((int) (500),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnldock.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65))),mostCurrent._pnldock.getWidth(),mostCurrent._pnldock.getHeight());
 }else {
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="btnDock.BringToFront";
mostCurrent._btndock.BringToFront();
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="pnlDock.BringToFront";
mostCurrent._pnldock.BringToFront();
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="pnlMeni.Visible = False";
mostCurrent._pnlmeni.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="pnl_dock_vidljiv = True";
_pnl_dock_vidljiv = anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=851980;
 //BA.debugLineNum = 851980;BA.debugLine="btnDock.SetBackgroundImage(LoadBitmap(File.DirAs";
mostCurrent._btndock.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"scvdock_zatvori.png").getObject()));
RDebugUtils.currentLine=851981;
 //BA.debugLineNum = 851981;BA.debugLine="pnlDock.SetLayoutAnimated(500, 15%x, 100%y - pnl";
mostCurrent._pnldock.SetLayoutAnimated((int) (500),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnldock.getHeight()),mostCurrent._pnldock.getWidth(),mostCurrent._pnldock.getHeight());
 };
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="End Sub";
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
public static String  _btnclearall_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnclearall_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnclearall_click", null));}
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub btnClearAll_Click";
RDebugUtils.currentLine=2949121;
 //BA.debugLineNum = 2949121;BA.debugLine="CallSubDelayed(NotificationService, \"ClearAll\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._notificationservice.getObject()),"ClearAll");
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="End Sub";
return "";
}
public static String  _btndodajstr_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btndodajstr_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btndodajstr_click", null));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub btnDodajStr_Click";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="Log(\"btnDodajStr_Click\")";
anywheresoftware.b4a.keywords.Common.LogImpl("33211265","btnDodajStr_Click",0);
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="End Sub";
return "";
}
public static String  _btndodajwidget_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btndodajwidget_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btndodajwidget_click", null));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub btnDodajWidget_Click";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="If Panel1.Visible Then";
if (mostCurrent._panel1.getVisible()) { 
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="CreateSmartWidget(1)";
_createsmartwidget((int) (1));
 };
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="End Sub";
return "";
}
public static String  _createsmartwidget(int _id) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createsmartwidget", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "createsmartwidget", new Object[] {_id}));}
RDebugUtils.currentLine=2752512;
 //BA.debugLineNum = 2752512;BA.debugLine="Sub CreateSmartWidget(id As Int)";
RDebugUtils.currentLine=2752513;
 //BA.debugLineNum = 2752513;BA.debugLine="SmartWidgets.Initialize(\"SmartWidgets\", id)";
_smartwidgets.Initialize(processBA,"SmartWidgets",_id);
RDebugUtils.currentLine=2752514;
 //BA.debugLineNum = 2752514;BA.debugLine="SmartWidgets.SelectWidget";
_smartwidgets.SelectWidget();
RDebugUtils.currentLine=2752515;
 //BA.debugLineNum = 2752515;BA.debugLine="End Sub";
return "";
}
public static String  _btninfo_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btninfo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btninfo_click", null));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub btnInfo_Click";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Log(\"btnInfo klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("31048577","btnInfo klik!",0);
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub btnKontaktEmail_Click(ajtemID As String)";
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Dim msg As Email";
_msg = new anywheresoftware.b4a.phone.Phone.Email();
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="Dim lEmail As List";
_lemail = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="lEmail.Initialize";
_lemail.Initialize();
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="Dim allContactEmails As List = cu.GetEmails(ajtem";
_allcontactemails = new anywheresoftware.b4a.objects.collections.List();
_allcontactemails = _cu._getemails(null,(long)(Double.parseDouble(_ajtemid)));
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="If allContactEmails.Size > 0 Then";
if (_allcontactemails.getSize()>0) { 
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="For Each c As cuEmail In allContactEmails";
{
final anywheresoftware.b4a.BA.IterableList group6 = _allcontactemails;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_c = (com.no3dlauncher.contactsutils._cuemail)(group6.Get(index6));
RDebugUtils.currentLine=3801097;
 //BA.debugLineNum = 3801097;BA.debugLine="lEmail.Add(c.Email)";
_lemail.Add((Object)(_c.Email));
 }
};
RDebugUtils.currentLine=3801100;
 //BA.debugLineNum = 3801100;BA.debugLine="If lEmail.Size = 1 Then";
if (_lemail.getSize()==1) { 
RDebugUtils.currentLine=3801101;
 //BA.debugLineNum = 3801101;BA.debugLine="msg.To.Add(c.Email)";
_msg.To.Add((Object)(_c.Email));
RDebugUtils.currentLine=3801102;
 //BA.debugLineNum = 3801102;BA.debugLine="StartActivity(msg.GetIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_msg.GetIntent()));
 }else {
RDebugUtils.currentLine=3801105;
 //BA.debugLineNum = 3801105;BA.debugLine="Dim adresa As String = PrikaziListuEmailAdresaU";
_adresa = _prikazilistuemailadresaudijalogu(_lemail);
RDebugUtils.currentLine=3801106;
 //BA.debugLineNum = 3801106;BA.debugLine="If adresa.EqualsIgnoreCase(\"false\") = False The";
if (_adresa.equalsIgnoreCase("false")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3801107;
 //BA.debugLineNum = 3801107;BA.debugLine="msg.To.Add(adresa)";
_msg.To.Add((Object)(_adresa));
RDebugUtils.currentLine=3801108;
 //BA.debugLineNum = 3801108;BA.debugLine="StartActivity(msg.GetIntent)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_msg.GetIntent()));
 }else {
RDebugUtils.currentLine=3801110;
 //BA.debugLineNum = 3801110;BA.debugLine="ToastMessageShow(\"You didn't choose email addr";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("You didn't choose email address!"),anywheresoftware.b4a.keywords.Common.False);
 };
 };
 }else {
RDebugUtils.currentLine=3801114;
 //BA.debugLineNum = 3801114;BA.debugLine="ToastMessageShow(\"No email address!\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No email address!"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3801116;
 //BA.debugLineNum = 3801116;BA.debugLine="End Sub";
return "";
}
public static String  _prikazilistuemailadresaudijalogu(anywheresoftware.b4a.objects.collections.List _listaadresa) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "prikazilistuemailadresaudijalogu", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "prikazilistuemailadresaudijalogu", new Object[] {_listaadresa}));}
com.maximus.id.id _x = null;
int _m = 0;
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub PrikaziListuEmailAdresaUDijalogu(listaAdresa A";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="Dim m As Int = x.InputList1(listaAdresa, \"\")";
_m = _x.InputList1(_listaadresa,"",mostCurrent.activityBA);
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="If m >= 0 Then";
if (_m>=0) { 
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="Return listaAdresa.Get(m)";
if (true) return BA.ObjectToString(_listaadresa.Get(_m));
 }else {
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="Return False";
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3866634;
 //BA.debugLineNum = 3866634;BA.debugLine="End Sub";
return "";
}
public static String  _btnkontaktinfo_click(String _ajtemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnkontaktinfo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnkontaktinfo_click", new Object[] {_ajtemid}));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub btnKontaktInfo_Click(ajtemID As String)";
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="Log(\"GetAccounts: \" & cu.GetAccounts(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("33604483","GetAccounts: "+BA.ObjectToString(_cu._getaccounts(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="Log(\"GetEmails: \" & cu.GetEmails(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("33604484","GetEmails: "+BA.ObjectToString(_cu._getemails(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="Log(\"GetEvents: \" & cu.GetEvents(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("33604485","GetEvents: "+BA.ObjectToString(_cu._getevents(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="Log(\"GetGroups: \" & cu.GetGroups(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("33604486","GetGroups: "+BA.ObjectToString(_cu._getgroups(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=3604487;
 //BA.debugLineNum = 3604487;BA.debugLine="Log(\"GetNameFromId: \" & cu.GetNameFromId(ajtemID)";
anywheresoftware.b4a.keywords.Common.LogImpl("33604487","GetNameFromId: "+_cu._getnamefromid(null,_ajtemid),0);
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="Log(\"GetNote: \" & cu.GetNote(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("33604488","GetNote: "+_cu._getnote(null,(long)(Double.parseDouble(_ajtemid))),0);
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="Log(\"GetOrganization :\" & cu.GetOrganization(ajte";
anywheresoftware.b4a.keywords.Common.LogImpl("33604489","GetOrganization :"+BA.ObjectToString(_cu._getorganization(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="Log(\"GetPhones: \" & cu.GetPhones(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("33604490","GetPhones: "+BA.ObjectToString(_cu._getphones(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="Log(\"GetStarred: \" & cu.GetStarred(ajtemID))";
anywheresoftware.b4a.keywords.Common.LogImpl("33604491","GetStarred: "+BA.ObjectToString(_cu._getstarred(null,(long)(Double.parseDouble(_ajtemid)))),0);
RDebugUtils.currentLine=3604492;
 //BA.debugLineNum = 3604492;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub btnKontaktPoziv_Click(ajtemID As String)";
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Dim pc As PhoneCalls";
_pc = new anywheresoftware.b4a.phone.Phone.PhoneCalls();
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="Dim lFoun As List";
_lfoun = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="lFoun.Initialize";
_lfoun.Initialize();
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="Dim allPhones As List = cu.GetPhones(ajtemID)";
_allphones = new anywheresoftware.b4a.objects.collections.List();
_allphones = _cu._getphones(null,(long)(Double.parseDouble(_ajtemid)));
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="If allPhones.Size > 0 Then";
if (_allphones.getSize()>0) { 
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="For Each phone As cuPhone In cu.GetPhones(ajtemI";
{
final anywheresoftware.b4a.BA.IterableList group6 = _cu._getphones(null,(long)(Double.parseDouble(_ajtemid)));
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_phone = (com.no3dlauncher.contactsutils._cuphone)(group6.Get(index6));
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="lFoun.Add(phone.Number)";
_lfoun.Add((Object)(_phone.Number));
 }
};
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="If lFoun.Size = 1 Then";
if (_lfoun.getSize()==1) { 
RDebugUtils.currentLine=3670029;
 //BA.debugLineNum = 3670029;BA.debugLine="StartActivity(pc.Call(lFoun.Get(0)))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_pc.Call(BA.ObjectToString(_lfoun.Get((int) (0))))));
 }else {
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="Dim broj_tel As String = PrikaziListuBrojevaTel";
_broj_tel = _prikazilistubrojevatelefona(_lfoun);
RDebugUtils.currentLine=3670032;
 //BA.debugLineNum = 3670032;BA.debugLine="StartActivity(pc.Call(broj_tel))";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_pc.Call(_broj_tel)));
 };
 }else {
RDebugUtils.currentLine=3670035;
 //BA.debugLineNum = 3670035;BA.debugLine="ToastMessageShow(\"No phone!\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No phone!"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3670037;
 //BA.debugLineNum = 3670037;BA.debugLine="End Sub";
return "";
}
public static String  _prikazilistubrojevatelefona(anywheresoftware.b4a.objects.collections.List _listabrojeva) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "prikazilistubrojevatelefona", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "prikazilistubrojevatelefona", new Object[] {_listabrojeva}));}
com.maximus.id.id _x = null;
int _m = 0;
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub PrikaziListuBrojevaTelefona(listaBrojeva As Li";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="Dim m As Int = x.InputList1(listaBrojeva, \"\")";
_m = _x.InputList1(_listabrojeva,"",mostCurrent.activityBA);
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="If m >= 0 Then";
if (_m>=0) { 
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="Return listaBrojeva.Get(m)";
if (true) return BA.ObjectToString(_listabrojeva.Get(_m));
 }else {
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="Return False";
if (true) return BA.ObjectToString(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3932170;
 //BA.debugLineNum = 3932170;BA.debugLine="End Sub";
return "";
}
public static String  _btnkontaktsms_click(String _ajtemid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnkontaktsms_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnkontaktsms_click", new Object[] {_ajtemid}));}
anywheresoftware.b4a.objects.IntentWrapper _intent1 = null;
com.no3dlauncher.contactsutils._cuphone _phone = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub btnKontaktSMS_Click(ajtemID As String)";
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="Dim intent1 As Intent";
_intent1 = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="Dim l As List = cu.GetPhones(ajtemID)";
mostCurrent._l = new anywheresoftware.b4a.objects.collections.List();
mostCurrent._l = _cu._getphones(null,(long)(Double.parseDouble(_ajtemid)));
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="If l.Size > 0 Then";
if (mostCurrent._l.getSize()>0) { 
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="For Each phone As cuPhone In cu.GetPhones(ajtemI";
{
final anywheresoftware.b4a.BA.IterableList group4 = _cu._getphones(null,(long)(Double.parseDouble(_ajtemid)));
final int groupLen4 = group4.getSize()
;int index4 = 0;
;
for (; index4 < groupLen4;index4++){
_phone = (com.no3dlauncher.contactsutils._cuphone)(group4.Get(index4));
 }
};
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="intent1.Initialize(intent1.ACTION_VIEW, \"sms:\" &";
_intent1.Initialize(_intent1.ACTION_VIEW,"sms:"+_phone.Number);
RDebugUtils.currentLine=3735561;
 //BA.debugLineNum = 3735561;BA.debugLine="StartActivity(intent1)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_intent1.getObject()));
 }else {
RDebugUtils.currentLine=3735563;
 //BA.debugLineNum = 3735563;BA.debugLine="ToastMessageShow(\"No phone number so no SMS!\", F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("No phone number so no SMS!"),anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=3735565;
 //BA.debugLineNum = 3735565;BA.debugLine="End Sub";
return "";
}
public static String  _btnmeni_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnmeni_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnmeni_click", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub btnMeni_Click";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="If pnl_dock_vidljiv Then";
if (_pnl_dock_vidljiv) { 
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="pnlDock.SendToBack";
mostCurrent._pnldock.SendToBack();
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="pnl_dock_vidljiv = False";
_pnl_dock_vidljiv = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="btnDock.SetBackgroundImage(LoadBitmap(File.DirAs";
mostCurrent._btndock.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"scvdock_otvori.png").getObject()));
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="pnlDock.SetLayoutAnimated(500, 15%x, 100%y - pnl";
mostCurrent._pnldock.SetLayoutAnimated((int) (500),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (15),mostCurrent.activityBA),(int) (anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA)-mostCurrent._pnldock.getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (65))),mostCurrent._pnldock.getWidth(),mostCurrent._pnldock.getHeight());
 };
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="If f.showApps = 0 Then";
if (mostCurrent._f._showapps==0) { 
RDebugUtils.currentLine=983060;
 //BA.debugLineNum = 983060;BA.debugLine="DodajListuAppUKotac";
_dodajlistuappukotac();
 }else 
{RDebugUtils.currentLine=983061;
 //BA.debugLineNum = 983061;BA.debugLine="else if f.showApps = 1 Then";
if (mostCurrent._f._showapps==1) { 
RDebugUtils.currentLine=983073;
 //BA.debugLineNum = 983073;BA.debugLine="DodajListuSaIkonamaAppULAdicu";
_dodajlistusaikonamaappuladicu();
 }else 
{RDebugUtils.currentLine=983074;
 //BA.debugLineNum = 983074;BA.debugLine="else if f.showApps = 2 Then";
if (mostCurrent._f._showapps==2) { 
RDebugUtils.currentLine=983075;
 //BA.debugLineNum = 983075;BA.debugLine="DodajAppULadicu";
_dodajappuladicu();
 }}}
;
RDebugUtils.currentLine=983077;
 //BA.debugLineNum = 983077;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Private dlgDrawer As CustomLayoutDialog";
_dlgdrawer = new anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog();
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="Dim sf As Object = dlgDrawer.ShowAsync(\"All appli";
_sf = _dlgdrawer.ShowAsync("All applications","","","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="dlgDrawer.SetSize(80%x, 62%y)";
_dlgdrawer.SetSize(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (62),mostCurrent.activityBA));
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Wait For (sf) Dialog_Ready(pnl As Panel)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_ready", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistuappukotac"), _sf);
this.state = 1;
return;
case 1:
//C
this.state = -1;
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) result[0];
;
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="FiltrirajImenaAppIImenaPaketa";
_filtrirajimenaappiimenapaketa();
RDebugUtils.currentLine=1900552;
 //BA.debugLineNum = 1900552;BA.debugLine="wp1.Initialize(\"wp1\")";
parent.mostCurrent._wp1.Initialize(mostCurrent.activityBA,"wp1");
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="pnl.AddView(wp1, 0, 0, 100%x, pnlMeni.Height)";
_pnl.AddView((android.view.View)(parent.mostCurrent._wp1.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),parent.mostCurrent._pnlmeni.getHeight());
RDebugUtils.currentLine=1900556;
 //BA.debugLineNum = 1900556;BA.debugLine="Dim mylist As List";
_mylist = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1900557;
 //BA.debugLineNum = 1900557;BA.debugLine="mylist.Initialize";
_mylist.Initialize();
RDebugUtils.currentLine=1900558;
 //BA.debugLineNum = 1900558;BA.debugLine="mylist.Add(LoadBitmap(File.DirAssets, \"act_add.pn";
_mylist.Add((Object)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"act_add.png").getObject()));
RDebugUtils.currentLine=1900560;
 //BA.debugLineNum = 1900560;BA.debugLine="wp1.Tag = \"kotac\"";
parent.mostCurrent._wp1.setTag((Object)("kotac"));
RDebugUtils.currentLine=1900561;
 //BA.debugLineNum = 1900561;BA.debugLine="wp1.Curved = True";
parent.mostCurrent._wp1.setCurved(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900562;
 //BA.debugLineNum = 1900562;BA.debugLine="wp1.Cyclic = True";
parent.mostCurrent._wp1.setCyclic(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900563;
 //BA.debugLineNum = 1900563;BA.debugLine="wp1.ItemTextColor = f.bojaFonta";
parent.mostCurrent._wp1.setItemTextColor(parent.mostCurrent._f._bojafonta);
RDebugUtils.currentLine=1900564;
 //BA.debugLineNum = 1900564;BA.debugLine="wp1.Atmospheric = True";
parent.mostCurrent._wp1.setAtmospheric(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900565;
 //BA.debugLineNum = 1900565;BA.debugLine="wp1.ItemAlign = 0                        '0 = cen";
parent.mostCurrent._wp1.setItemAlign((int) (0));
RDebugUtils.currentLine=1900566;
 //BA.debugLineNum = 1900566;BA.debugLine="wp1.ItemTextSize = f.fontzSize'55";
parent.mostCurrent._wp1.setItemTextSize(parent.mostCurrent._f._fontzsize);
RDebugUtils.currentLine=1900568;
 //BA.debugLineNum = 1900568;BA.debugLine="wp1.VisibleItemCount = 10";
parent.mostCurrent._wp1.setVisibleItemCount((int) (10));
RDebugUtils.currentLine=1900569;
 //BA.debugLineNum = 1900569;BA.debugLine="wp1.Indicator = True";
parent.mostCurrent._wp1.setIndicator(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1900570;
 //BA.debugLineNum = 1900570;BA.debugLine="wp1.ItemSpace = 20";
parent.mostCurrent._wp1.setItemSpace((int) (20));
RDebugUtils.currentLine=1900571;
 //BA.debugLineNum = 1900571;BA.debugLine="wp1.Typeface = Typeface.LoadFromAssets(f.wheelLis";
parent.mostCurrent._wp1.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(parent.mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=1900572;
 //BA.debugLineNum = 1900572;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1900573;
 //BA.debugLineNum = 1900573;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=1900574;
 //BA.debugLineNum = 1900574;BA.debugLine="res = getARGB(f.bojaPozadine)";
_res = _getargb(parent.mostCurrent._f._bojapozadine);
RDebugUtils.currentLine=1900575;
 //BA.debugLineNum = 1900575;BA.debugLine="res(0) = f.trans";
_res[(int) (0)] = parent.mostCurrent._f._trans;
RDebugUtils.currentLine=1900576;
 //BA.debugLineNum = 1900576;BA.debugLine="cd.Initialize(Colors.ARGB(res(0), res(1), res(2),";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB(_res[(int) (0)],_res[(int) (1)],_res[(int) (2)],_res[(int) (3)]),(int) (0));
RDebugUtils.currentLine=1900577;
 //BA.debugLineNum = 1900577;BA.debugLine="wp1.Background = cd";
parent.mostCurrent._wp1.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=1900578;
 //BA.debugLineNum = 1900578;BA.debugLine="wp1.Data = l";
parent.mostCurrent._wp1.setData((java.util.List)(parent.mostCurrent._l.getObject()));
RDebugUtils.currentLine=1900581;
 //BA.debugLineNum = 1900581;BA.debugLine="ivWheelDodaj.Initialize(\"ivWheelDodaj\")";
parent.mostCurrent._ivwheeldodaj.Initialize(mostCurrent.activityBA,"ivWheelDodaj");
RDebugUtils.currentLine=1900582;
 //BA.debugLineNum = 1900582;BA.debugLine="ivWheelDodaj.Tag = \"kotac_dodaj\"";
parent.mostCurrent._ivwheeldodaj.setTag((Object)("kotac_dodaj"));
RDebugUtils.currentLine=1900583;
 //BA.debugLineNum = 1900583;BA.debugLine="ivWheelDodaj.Bitmap = LoadBitmap(File.DirAssets,";
parent.mostCurrent._ivwheeldodaj.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"act_add.png").getObject()));
RDebugUtils.currentLine=1900584;
 //BA.debugLineNum = 1900584;BA.debugLine="ivWheelDodaj.Gravity = Gravity.FILL";
parent.mostCurrent._ivwheeldodaj.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=1900585;
 //BA.debugLineNum = 1900585;BA.debugLine="pnl.AddView(ivWheelDodaj, wp1.Width, (pnlMeni.Hei";
_pnl.AddView((android.view.View)(parent.mostCurrent._ivwheeldodaj.getObject()),parent.mostCurrent._wp1.getWidth(),(int) ((parent.mostCurrent._pnlmeni.getHeight()/(double)2)+(parent.mostCurrent._btnpostavke.getHeight()/(double)2)),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (10),mostCurrent.activityBA));
RDebugUtils.currentLine=1900588;
 //BA.debugLineNum = 1900588;BA.debugLine="Wait For ivWheelDodaj_Click";
anywheresoftware.b4a.keywords.Common.WaitFor("ivwheeldodaj_click", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistuappukotac"), null);
this.state = 2;
return;
case 2:
//C
this.state = -1;
;
RDebugUtils.currentLine=1900590;
 //BA.debugLineNum = 1900590;BA.debugLine="Wait For wp1_index_clicked(position As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("wp1_index_clicked", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistuappukotac"), null);
this.state = 3;
return;
case 3:
//C
this.state = -1;
_position = (Integer) result[0];
;
RDebugUtils.currentLine=1900592;
 //BA.debugLineNum = 1900592;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
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
int step14;
int limit14;

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
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="FiltrirajImenaAppIImenaPaketa";
_filtrirajimenaappiimenapaketa();
RDebugUtils.currentLine=1507333;
 //BA.debugLineNum = 1507333;BA.debugLine="Private dlgDrawer As CustomLayoutDialog";
_dlgdrawer = new anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog();
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="Dim sf As Object = dlgDrawer.ShowAsync(\"All appli";
_sf = _dlgdrawer.ShowAsync("All applications","","","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1507335;
 //BA.debugLineNum = 1507335;BA.debugLine="dlgDrawer.SetSize(100%x, 90%y)";
_dlgdrawer.SetSize(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (90),mostCurrent.activityBA));
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="Wait For (sf) Dialog_Ready(pnl As Panel)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_ready", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistusaikonamaappuladicu"), _sf);
this.state = 9;
return;
case 9:
//C
this.state = 1;
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) result[0];
;
RDebugUtils.currentLine=1507338;
 //BA.debugLineNum = 1507338;BA.debugLine="pnl.LoadLayout(\"clv1\")";
_pnl.LoadLayout("clv1",mostCurrent.activityBA);
RDebugUtils.currentLine=1507340;
 //BA.debugLineNum = 1507340;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1507341;
 //BA.debugLineNum = 1507341;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="res = getARGB(f.bojaPozadine)";
_res = _getargb(parent.mostCurrent._f._bojapozadine);
RDebugUtils.currentLine=1507343;
 //BA.debugLineNum = 1507343;BA.debugLine="res(0) = f.trans";
_res[(int) (0)] = parent.mostCurrent._f._trans;
RDebugUtils.currentLine=1507344;
 //BA.debugLineNum = 1507344;BA.debugLine="cd.Initialize(Colors.ARGB(res(0), res(1), res(2),";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB(_res[(int) (0)],_res[(int) (1)],_res[(int) (2)],_res[(int) (3)]),(int) (0));
RDebugUtils.currentLine=1507346;
 //BA.debugLineNum = 1507346;BA.debugLine="clv.AsView.Color = cd";
parent.mostCurrent._clv._asview().setColor((int)(BA.ObjectToNumber(_cd)));
RDebugUtils.currentLine=1507349;
 //BA.debugLineNum = 1507349;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
if (true) break;

case 1:
//for
this.state = 8;
step14 = 1;
limit14 = (int) (parent.mostCurrent._starter._mapa.getSize()-1);
_i = (int) (0) ;
this.state = 10;
if (true) break;

case 10:
//C
this.state = 8;
if ((step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14)) this.state = 3;
if (true) break;

case 11:
//C
this.state = 10;
_i = ((int)(0 + _i + step14)) ;
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=1507350;
 //BA.debugLineNum = 1507350;BA.debugLine="Dim pckg1, pckg2 As String";
_pckg1 = "";
_pckg2 = "";
RDebugUtils.currentLine=1507351;
 //BA.debugLineNum = 1507351;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
_pckg = BA.ObjectToString(parent.mostCurrent._starter._mapa.GetKeyAt(_i));
RDebugUtils.currentLine=1507352;
 //BA.debugLineNum = 1507352;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pck";
_pckg1 = _pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length());
RDebugUtils.currentLine=1507353;
 //BA.debugLineNum = 1507353;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon(p";
_drawable = (Object)(_pm.GetApplicationIcon(_pckg1));
RDebugUtils.currentLine=1507354;
 //BA.debugLineNum = 1507354;BA.debugLine="If drawable Is BitmapDrawable Then";
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
RDebugUtils.currentLine=1507355;
 //BA.debugLineNum = 1507355;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_drawable));
RDebugUtils.currentLine=1507356;
 //BA.debugLineNum = 1507356;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=1507357;
 //BA.debugLineNum = 1507357;BA.debugLine="bdw.Initialize(bmp.Resize(32dip, 32dip, True))";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=1507358;
 //BA.debugLineNum = 1507358;BA.debugLine="pckg2 = pckg.SubString2(0, pckg.IndexOf(\";\"))";
_pckg2 = _pckg.substring((int) (0),_pckg.indexOf(";"));
RDebugUtils.currentLine=1507359;
 //BA.debugLineNum = 1507359;BA.debugLine="clv.Add(KreirajStavku(bdw.Bitmap, pckg2, pnlMen";
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
RDebugUtils.currentLine=1507363;
 //BA.debugLineNum = 1507363;BA.debugLine="Wait For clv_ItemClick (Index As Int, Value As Ob";
anywheresoftware.b4a.keywords.Common.WaitFor("clv_itemclick", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistusaikonamaappuladicu"), null);
this.state = 12;
return;
case 12:
//C
this.state = -1;
_index = (Integer) result[0];
_value = (Object) result[1];
;
RDebugUtils.currentLine=1507364;
 //BA.debugLineNum = 1507364;BA.debugLine="Log(\"Selected item: \" & Value)";
anywheresoftware.b4a.keywords.Common.LogImpl("31507364","Selected item: "+BA.ObjectToString(_value),0);
RDebugUtils.currentLine=1507366;
 //BA.debugLineNum = 1507366;BA.debugLine="Wait For ivClvDodaj_Click";
anywheresoftware.b4a.keywords.Common.WaitFor("ivclvdodaj_click", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajlistusaikonamaappuladicu"), null);
this.state = 13;
return;
case 13:
//C
this.state = -1;
;
RDebugUtils.currentLine=1507369;
 //BA.debugLineNum = 1507369;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="Private dlgDrawer As CustomLayoutDialog";
_dlgdrawer = new anywheresoftware.b4a.agraham.dialogs.InputDialog.CustomLayoutDialog();
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="Dim sf As Object = dlgDrawer.ShowAsync(\"All appli";
_sf = _dlgdrawer.ShowAsync("All applications","","","",mostCurrent.activityBA,(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572867;
 //BA.debugLineNum = 1572867;BA.debugLine="dlgDrawer.SetSize(100%x, 90%y)";
_dlgdrawer.SetSize(anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (90),mostCurrent.activityBA));
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="Wait For (sf) Dialog_Ready(pnl As Panel)";
anywheresoftware.b4a.keywords.Common.WaitFor("dialog_ready", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajappuladicu"), _sf);
this.state = 19;
return;
case 19:
//C
this.state = 1;
_pnl = (anywheresoftware.b4a.objects.PanelWrapper) result[0];
;
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="FiltrirajImenaAppIImenaPaketa";
_filtrirajimenaappiimenapaketa();
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="sv.Initialize(1000dip)";
parent.mostCurrent._sv.Initialize(mostCurrent.activityBA,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (1000)));
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="pnl.AddView(sv, 0, 0, pnl.Width, pnl.Height)";
_pnl.AddView((android.view.View)(parent.mostCurrent._sv.getObject()),(int) (0),(int) (0),_pnl.getWidth(),_pnl.getHeight());
RDebugUtils.currentLine=1572874;
 //BA.debugLineNum = 1572874;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="cd.Initialize(Colors.ARGB(0, 211, 211, 211), 0)";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB((int) (0),(int) (211),(int) (211),(int) (211)),(int) (0));
RDebugUtils.currentLine=1572877;
 //BA.debugLineNum = 1572877;BA.debugLine="Dim x As Int";
_x = 0;
RDebugUtils.currentLine=1572878;
 //BA.debugLineNum = 1572878;BA.debugLine="x = Activity.Width / 5'pkg1.Size";
_x = (int) (parent.mostCurrent._activity.getWidth()/(double)5);
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="x = x - 10dip";
_x = (int) (_x-anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)));
RDebugUtils.currentLine=1572881;
 //BA.debugLineNum = 1572881;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
if (true) break;

case 1:
//for
this.state = 18;
step14 = 1;
limit14 = (int) (parent.mostCurrent._starter._mapa.getSize()-1);
_i = (int) (0) ;
this.state = 20;
if (true) break;

case 20:
//C
this.state = 18;
if ((step14 > 0 && _i <= limit14) || (step14 < 0 && _i >= limit14)) this.state = 3;
if (true) break;

case 21:
//C
this.state = 20;
_i = ((int)(0 + _i + step14)) ;
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=1572882;
 //BA.debugLineNum = 1572882;BA.debugLine="For j = 0 To 4";
if (true) break;

case 4:
//for
this.state = 17;
step15 = 1;
limit15 = (int) (4);
_j = (int) (0) ;
this.state = 22;
if (true) break;

case 22:
//C
this.state = 17;
if ((step15 > 0 && _j <= limit15) || (step15 < 0 && _j >= limit15)) this.state = 6;
if (true) break;

case 23:
//C
this.state = 22;
_j = ((int)(0 + _j + step15)) ;
if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=1572883;
 //BA.debugLineNum = 1572883;BA.debugLine="If (i*5+j) < Starter.mapa.Size Then";
if (true) break;

case 7:
//if
this.state = 16;
if ((_i*5+_j)<parent.mostCurrent._starter._mapa.getSize()) { 
this.state = 9;
}else {
this.state = 15;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=1572884;
 //BA.debugLineNum = 1572884;BA.debugLine="Dim s As String = Starter.mapa.GetKeyAt(i*5+j)";
_s = BA.ObjectToString(parent.mostCurrent._starter._mapa.GetKeyAt((int) (_i*5+_j)));
RDebugUtils.currentLine=1572886;
 //BA.debugLineNum = 1572886;BA.debugLine="Dim s1 As String = s.SubString2(s.IndexOf(\";\")";
_s1 = _s.substring((int) (_s.indexOf(";")+1),_s.length());
RDebugUtils.currentLine=1572887;
 //BA.debugLineNum = 1572887;BA.debugLine="Dim drawable As Object = pm.GetApplicationIcon";
_drawable = (Object)(_pm.GetApplicationIcon(_s1));
RDebugUtils.currentLine=1572888;
 //BA.debugLineNum = 1572888;BA.debugLine="If drawable Is BitmapDrawable Then";
if (true) break;

case 10:
//if
this.state = 13;
if (_drawable instanceof android.graphics.drawable.BitmapDrawable) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=1572889;
 //BA.debugLineNum = 1572889;BA.debugLine="Dim bdw As BitmapDrawable = drawable";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_drawable));
RDebugUtils.currentLine=1572890;
 //BA.debugLineNum = 1572890;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=1572891;
 //BA.debugLineNum = 1572891;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True)";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=1572892;
 //BA.debugLineNum = 1572892;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1572893;
 //BA.debugLineNum = 1572893;BA.debugLine="iv.Initialize(\"ivAppMain\")";
_iv.Initialize(mostCurrent.activityBA,"ivAppMain");
RDebugUtils.currentLine=1572894;
 //BA.debugLineNum = 1572894;BA.debugLine="iv.Bitmap = bdw.Bitmap";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=1572895;
 //BA.debugLineNum = 1572895;BA.debugLine="iv.Tag = s1'Starter.mapa.GetKeyAt(i*5+j)";
_iv.setTag((Object)(_s1));
RDebugUtils.currentLine=1572896;
 //BA.debugLineNum = 1572896;BA.debugLine="sv.Panel.AddView(iv, x*j + j*2dip, x*i + 10di";
parent.mostCurrent._sv.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(int) (_x*_i+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))),_x,_x);
RDebugUtils.currentLine=1572897;
 //BA.debugLineNum = 1572897;BA.debugLine="Dim lbl As Label";
parent.mostCurrent._lbl = new anywheresoftware.b4a.objects.LabelWrapper();
RDebugUtils.currentLine=1572898;
 //BA.debugLineNum = 1572898;BA.debugLine="lbl.Initialize(\"\")";
parent.mostCurrent._lbl.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1572900;
 //BA.debugLineNum = 1572900;BA.debugLine="Dim s2 As String = s.SubString2(0, s.IndexOf(";
_s2 = _s.substring((int) (0),_s.indexOf(";"));
RDebugUtils.currentLine=1572901;
 //BA.debugLineNum = 1572901;BA.debugLine="lbl.Text = s2";
parent.mostCurrent._lbl.setText(BA.ObjectToCharSequence(_s2));
RDebugUtils.currentLine=1572902;
 //BA.debugLineNum = 1572902;BA.debugLine="lbl.TextColor = Colors.White";
parent.mostCurrent._lbl.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
RDebugUtils.currentLine=1572903;
 //BA.debugLineNum = 1572903;BA.debugLine="lbl.Background = cd";
parent.mostCurrent._lbl.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=1572904;
 //BA.debugLineNum = 1572904;BA.debugLine="lbl.TextSize = 10.0";
parent.mostCurrent._lbl.setTextSize((float) (10.0));
RDebugUtils.currentLine=1572905;
 //BA.debugLineNum = 1572905;BA.debugLine="lbl.Typeface = Typeface.LoadFromAssets(f.whee";
parent.mostCurrent._lbl.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(parent.mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=1572906;
 //BA.debugLineNum = 1572906;BA.debugLine="lbl.Gravity = Bit.Or(Gravity.CENTER_HORIZONTA";
parent.mostCurrent._lbl.setGravity(anywheresoftware.b4a.keywords.Common.Bit.Or(anywheresoftware.b4a.keywords.Common.Gravity.CENTER_HORIZONTAL,anywheresoftware.b4a.keywords.Common.Gravity.CENTER_VERTICAL));
RDebugUtils.currentLine=1572907;
 //BA.debugLineNum = 1572907;BA.debugLine="sv.Panel.AddView(lbl, x*j + j*2dip, x*i + x +";
parent.mostCurrent._sv.getPanel().AddView((android.view.View)(parent.mostCurrent._lbl.getObject()),(int) (_x*_j+_j*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (2))),(int) (_x*_i+_x+_i*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30))+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4))),_x,anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (30)));
 if (true) break;

case 13:
//C
this.state = 16;
;
 if (true) break;

case 15:
//C
this.state = 16;
RDebugUtils.currentLine=1572910;
 //BA.debugLineNum = 1572910;BA.debugLine="Exit";
this.state = 17;
if (true) break;
 if (true) break;

case 16:
//C
this.state = 23;
;
 if (true) break;
if (true) break;

case 17:
//C
this.state = 21;
;
 if (true) break;
if (true) break;

case 18:
//C
this.state = -1;
;
RDebugUtils.currentLine=1572914;
 //BA.debugLineNum = 1572914;BA.debugLine="sv.Panel.Height = sv.Panel.Height + 12dip";
parent.mostCurrent._sv.getPanel().setHeight((int) (parent.mostCurrent._sv.getPanel().getHeight()+anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (12))));
RDebugUtils.currentLine=1572915;
 //BA.debugLineNum = 1572915;BA.debugLine="dlgDrawer.GetButton(DialogResponse.POSITIVE).Enab";
_dlgdrawer.GetButton(anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE).setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1572916;
 //BA.debugLineNum = 1572916;BA.debugLine="Wait for (sf) ivAppMain_Click";
anywheresoftware.b4a.keywords.Common.WaitFor("ivappmain_click", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajappuladicu"), _sf);
this.state = 24;
return;
case 24:
//C
this.state = -1;
;
RDebugUtils.currentLine=1572917;
 //BA.debugLineNum = 1572917;BA.debugLine="Wait For (sf) ivApp_LongClick";
anywheresoftware.b4a.keywords.Common.WaitFor("ivapp_longclick", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "main", "dodajappuladicu"), _sf);
this.state = 25;
return;
case 25:
//C
this.state = -1;
;
RDebugUtils.currentLine=1572918;
 //BA.debugLineNum = 1572918;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _btnnaprijed_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnaprijed_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnaprijed_click", null));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub btnNaprijed_Click";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="If TabStrip1.CurrentPage < 3 Then";
if (mostCurrent._tabstrip1.getCurrentPage()<3) { 
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="TabStrip1.ScrollTo(TabStrip1.CurrentPage + 1, Tr";
mostCurrent._tabstrip1.ScrollTo((int) (mostCurrent._tabstrip1.getCurrentPage()+1),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="End Sub";
return "";
}
public static String  _btnnatrag_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnatrag_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnatrag_click", null));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub btnNatrag_Click";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="If TabStrip1.CurrentPage > 0 Then";
if (mostCurrent._tabstrip1.getCurrentPage()>0) { 
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="TabStrip1.ScrollTo(TabStrip1.CurrentPage - 1, Tr";
mostCurrent._tabstrip1.ScrollTo((int) (mostCurrent._tabstrip1.getCurrentPage()-1),anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="TabStrip1.ScrollTo(2, True)";
mostCurrent._tabstrip1.ScrollTo((int) (2),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3276808;
 //BA.debugLineNum = 3276808;BA.debugLine="If TabStrip1.CurrentPage = 1 And pnlKontakti.Numb";
if (mostCurrent._tabstrip1.getCurrentPage()==1 && mostCurrent._pnlkontakti.getNumberOfViews()==0) { 
RDebugUtils.currentLine=3276809;
 //BA.debugLineNum = 3276809;BA.debugLine="UbaciKontakte2'(c)";
_ubacikontakte2();
 };
RDebugUtils.currentLine=3276811;
 //BA.debugLineNum = 3276811;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub UbaciKontakte2";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="Dim allContacts As List = cu.FindAllContacts(True";
_allcontacts = new anywheresoftware.b4a.objects.collections.List();
_allcontacts = _cu._findallcontacts(null,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="If File.Exists (File.DirInternal, \"nema_slike.png";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"nema_slike.png")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3407879;
 //BA.debugLineNum = 3407879;BA.debugLine="File.Copy(File.DirAssets, \"nema_slike.png\", File";
anywheresoftware.b4a.keywords.Common.File.Copy(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"nema_slike.png",anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"nema_slike.png");
 };
RDebugUtils.currentLine=3407882;
 //BA.debugLineNum = 3407882;BA.debugLine="grid.Initialize(pnlKontakti, Me, \"kontaktiGrid\",";
mostCurrent._grid._initialize(mostCurrent.activityBA,mostCurrent._pnlkontakti,main.getObject(),"kontaktiGrid",(int) (4),"S");
RDebugUtils.currentLine=3407884;
 //BA.debugLineNum = 3407884;BA.debugLine="grid.PrepareGridView";
mostCurrent._grid._preparegridview();
RDebugUtils.currentLine=3407904;
 //BA.debugLineNum = 3407904;BA.debugLine="Dim ukupno, i As Int = 0";
_ukupno = 0;
_i = (int) (0);
RDebugUtils.currentLine=3407906;
 //BA.debugLineNum = 3407906;BA.debugLine="ProgressDialogShow(\"Building contacts...\")";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow(mostCurrent.activityBA,BA.ObjectToCharSequence("Building contacts..."));
RDebugUtils.currentLine=3407907;
 //BA.debugLineNum = 3407907;BA.debugLine="Dim l1k, l2k As List";
_l1k = new anywheresoftware.b4a.objects.collections.List();
_l2k = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3407908;
 //BA.debugLineNum = 3407908;BA.debugLine="l1k.Initialize	' diaply name";
_l1k.Initialize();
RDebugUtils.currentLine=3407909;
 //BA.debugLineNum = 3407909;BA.debugLine="l2k.Initialize	' id";
_l2k.Initialize();
RDebugUtils.currentLine=3407910;
 //BA.debugLineNum = 3407910;BA.debugLine="For Each c As cuContact In allContacts'cu.FindAll";
{
final anywheresoftware.b4a.BA.IterableList group12 = _allcontacts;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_c = (com.no3dlauncher.contactsutils._cucontact)(group12.Get(index12));
RDebugUtils.currentLine=3407911;
 //BA.debugLineNum = 3407911;BA.debugLine="l1k.Add(c.DisplayName)";
_l1k.Add((Object)(_c.DisplayName));
RDebugUtils.currentLine=3407912;
 //BA.debugLineNum = 3407912;BA.debugLine="l2k.Add(c.Id)";
_l2k.Add((Object)(_c.Id));
 }
};
RDebugUtils.currentLine=3407915;
 //BA.debugLineNum = 3407915;BA.debugLine="Log(l1k)";
anywheresoftware.b4a.keywords.Common.LogImpl("33407915",BA.ObjectToString(_l1k),0);
RDebugUtils.currentLine=3407916;
 //BA.debugLineNum = 3407916;BA.debugLine="Log(l2k)";
anywheresoftware.b4a.keywords.Common.LogImpl("33407916",BA.ObjectToString(_l2k),0);
RDebugUtils.currentLine=3407917;
 //BA.debugLineNum = 3407917;BA.debugLine="For i = 0 To allContacts.Size - 1";
{
final int step18 = 1;
final int limit18 = (int) (_allcontacts.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit18 ;_i = _i + step18 ) {
RDebugUtils.currentLine=3407918;
 //BA.debugLineNum = 3407918;BA.debugLine="For j = 0 To 4";
{
final int step19 = 1;
final int limit19 = (int) (4);
_j = (int) (0) ;
for (;_j <= limit19 ;_j = _j + step19 ) {
RDebugUtils.currentLine=3407919;
 //BA.debugLineNum = 3407919;BA.debugLine="If ukupno < allContacts.Size Then";
if (_ukupno<_allcontacts.getSize()) { 
RDebugUtils.currentLine=3407921;
 //BA.debugLineNum = 3407921;BA.debugLine="Dim bmp As Bitmap = cu.GetPhoto(l2k.Get(i*5+j)";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = _cu._getphoto(null,BA.ObjectToLongNumber(_l2k.Get((int) (_i*5+_j))));
RDebugUtils.currentLine=3407922;
 //BA.debugLineNum = 3407922;BA.debugLine="If bmp.IsInitialized = False Then";
if (_bmp.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3407923;
 //BA.debugLineNum = 3407923;BA.debugLine="grid.AddToGridView(File.Combine(File.DirInter";
mostCurrent._grid._addtogridview(anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"nema_slike.png"),BA.ObjectToString(_l1k.Get((int) (_i*5+_j))),BA.ObjectToString(_l2k.Get((int) (_i*5+_j))));
 }else {
RDebugUtils.currentLine=3407925;
 //BA.debugLineNum = 3407925;BA.debugLine="Dim bmp As Bitmap = cu.GetPhoto(l2k.Get(i*5+j";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp = _cu._getphoto(null,BA.ObjectToLongNumber(_l2k.Get((int) (_i*5+_j))));
RDebugUtils.currentLine=3407926;
 //BA.debugLineNum = 3407926;BA.debugLine="Dim Out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
RDebugUtils.currentLine=3407927;
 //BA.debugLineNum = 3407927;BA.debugLine="Out = File.OpenOutput(File.DirInternal, l1k.G";
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_l1k.Get((int) (_i*5+_j))),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3407928;
 //BA.debugLineNum = 3407928;BA.debugLine="bmp.WriteToStream(Out, 100, \"PNG\")";
_bmp.WriteToStream((java.io.OutputStream)(_out.getObject()),(int) (100),BA.getEnumFromString(android.graphics.Bitmap.CompressFormat.class,"PNG"));
RDebugUtils.currentLine=3407929;
 //BA.debugLineNum = 3407929;BA.debugLine="Out.Close";
_out.Close();
RDebugUtils.currentLine=3407930;
 //BA.debugLineNum = 3407930;BA.debugLine="grid.AddToGridView(File.Combine(File.DirInter";
mostCurrent._grid._addtogridview(anywheresoftware.b4a.keywords.Common.File.Combine(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),BA.ObjectToString(_l1k.Get((int) (_i*5+_j)))),BA.ObjectToString(_l1k.Get((int) (_i*5+_j))),BA.ObjectToString(_l2k.Get((int) (_i*5+_j))));
 };
RDebugUtils.currentLine=3407958;
 //BA.debugLineNum = 3407958;BA.debugLine="ukupno = ukupno + 1";
_ukupno = (int) (_ukupno+1);
 }else {
RDebugUtils.currentLine=3407961;
 //BA.debugLineNum = 3407961;BA.debugLine="Exit";
if (true) break;
 };
 }
};
 }
};
RDebugUtils.currentLine=3407966;
 //BA.debugLineNum = 3407966;BA.debugLine="grid.TitleBoxVisible = True";
mostCurrent._grid._settitleboxvisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3407969;
 //BA.debugLineNum = 3407969;BA.debugLine="grid.ShowGridView";
mostCurrent._grid._showgridview();
RDebugUtils.currentLine=3407972;
 //BA.debugLineNum = 3407972;BA.debugLine="End Sub";
return "";
}
public static String  _btnnotify_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnnotify_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnnotify_click", null));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4a.objects.IntentWrapper _in = null;
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub btnNotify_Click";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="Log(p.GetSettings(\"enabled_notification_listeners";
anywheresoftware.b4a.keywords.Common.LogImpl("33080194",_p.GetSettings("enabled_notification_listeners"),0);
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="If p.GetSettings(\"enabled_notification_listeners\"";
if (_p.GetSettings("enabled_notification_listeners").contains("com.no3dlauncher")==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=3080196;
 //BA.debugLineNum = 3080196;BA.debugLine="Dim In As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=3080197;
 //BA.debugLineNum = 3080197;BA.debugLine="In.Initialize(\"android.settings.ACTION_NOTIFICAT";
_in.Initialize("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS","");
RDebugUtils.currentLine=3080198;
 //BA.debugLineNum = 3080198;BA.debugLine="StartActivity(In)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=3080200;
 //BA.debugLineNum = 3080200;BA.debugLine="End Sub";
return "";
}
public static String  _btnpostavke_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnpostavke_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnpostavke_click", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub btnPostavke_Click";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="StartActivity(pnlmeni_postavke)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._pnlmeni_postavke.getObject()));
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="End Sub";
return "";
}
public static String  _btnpostavkekontakti_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnpostavkekontakti_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnpostavkekontakti_click", null));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub btnPostavkeKontakti_Click";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="StartActivity(postavke_kontakti)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._postavke_kontakti.getObject()));
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="End Sub";
return "";
}
public static String  _btnsearch_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnsearch_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnsearch_click", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub btnSearch_Click";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="StartActivity(search)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._search.getObject()));
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="End Sub";
return "";
}
public static String  _btnwidgeti_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnwidgeti_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnwidgeti_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub btnWidgeti_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="TabStrip1.ScrollTo(2, True)";
mostCurrent._tabstrip1.ScrollTo((int) (2),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="Log(\"widgeti klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("31179654","widgeti klik!",0);
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="File.Delete(File.DirInternal, \"theappid.txt\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"theappid.txt");
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="File.Delete(File.DirInternal, \"theid.txt\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"theid.txt");
RDebugUtils.currentLine=1179657;
 //BA.debugLineNum = 1179657;BA.debugLine="File.Delete(File.DirInternal, \"thehost.txt\")";
anywheresoftware.b4a.keywords.Common.File.Delete(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"thehost.txt");
RDebugUtils.currentLine=1179716;
 //BA.debugLineNum = 1179716;BA.debugLine="End Sub";
return "";
}
public static String  _clv_itemclick(int _index,Object _value) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "clv_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "clv_itemclick", new Object[] {_index,_value}));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Sub clv_ItemClick (Index As Int, Value As Object)";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="zadnja_oznacena_app = Index";
_zadnja_oznacena_app = _index;
RDebugUtils.currentLine=2162693;
 //BA.debugLineNum = 2162693;BA.debugLine="in = pm.GetApplicationIntent(l1.Get(Index))";
_in = _pm.GetApplicationIntent(BA.ObjectToString(mostCurrent._l1.Get(_index)));
RDebugUtils.currentLine=2162694;
 //BA.debugLineNum = 2162694;BA.debugLine="If in.IsInitialized Then";
if (_in.IsInitialized()) { 
RDebugUtils.currentLine=2162697;
 //BA.debugLineNum = 2162697;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=2162699;
 //BA.debugLineNum = 2162699;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub DodajAppUFavorite";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1966082;
 //BA.debugLineNum = 1966082;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="Dim pckg1 As String";
_pckg1 = "";
RDebugUtils.currentLine=1966085;
 //BA.debugLineNum = 1966085;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(zadnja";
_pckg = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_zadnja_oznacena_app));
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(zadn";
_provjeraappufavoritima(BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_zadnja_oznacena_app)));
RDebugUtils.currentLine=1966089;
 //BA.debugLineNum = 1966089;BA.debugLine="iv.Initialize(\"\")";
_iv.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="iv.Tag = scvDock.Panel.NumberOfViews";
_iv.setTag((Object)(mostCurrent._scvdock.getPanel().getNumberOfViews()));
RDebugUtils.currentLine=1966091;
 //BA.debugLineNum = 1966091;BA.debugLine="iv.Width = 48dip";
_iv.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="iv.Height = 48dip";
_iv.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=1966093;
 //BA.debugLineNum = 1966093;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=1966095;
 //BA.debugLineNum = 1966095;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pckg";
_pckg1 = _pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length());
RDebugUtils.currentLine=1966096;
 //BA.debugLineNum = 1966096;BA.debugLine="Dim bdw As BitmapDrawable = pm.GetApplicationIcon";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_pm.GetApplicationIcon(_pckg1)));
RDebugUtils.currentLine=1966097;
 //BA.debugLineNum = 1966097;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=1966098;
 //BA.debugLineNum = 1966098;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True))";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=1966099;
 //BA.debugLineNum = 1966099;BA.debugLine="listaFavorita.Add(pckg1)	' dodaj ime paketa aplik";
mostCurrent._listafavorita.Add((Object)(_pckg1));
RDebugUtils.currentLine=1966102;
 //BA.debugLineNum = 1966102;BA.debugLine="iv.Bitmap = bdw.Bitmap'bm1";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=1966103;
 //BA.debugLineNum = 1966103;BA.debugLine="scvDock.Panel.AddView(iv, iv.Width*scvDock.Panel.";
mostCurrent._scvdock.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_iv.getWidth()*mostCurrent._scvdock.getPanel().getNumberOfViews()+mostCurrent._scvdock.getPanel().getNumberOfViews()*anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10)),_iv.getWidth(),_iv.getHeight());
RDebugUtils.currentLine=1966105;
 //BA.debugLineNum = 1966105;BA.debugLine="ToastMessageShow(\"App added to favorites!\", True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("App added to favorites!"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1966106;
 //BA.debugLineNum = 1966106;BA.debugLine="End Sub";
return "";
}
public static String  _provjeraappufavoritima(String _mapavrijednost) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "provjeraappufavoritima", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "provjeraappufavoritima", new Object[] {_mapavrijednost}));}
int _brappudoku = 0;
int _i = 0;
String _s = "";
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Sub ProvjeraAppUFavoritima(mapavrijednost As Strin";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="Dim brAppUDoku As Int = scvDock.Panel.NumberOfVie";
_brappudoku = mostCurrent._scvdock.getPanel().getNumberOfViews();
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="For i = 0 To brAppUDoku - 1";
{
final int step2 = 1;
final int limit2 = (int) (_brappudoku-1);
_i = (int) (0) ;
for (;_i <= limit2 ;_i = _i + step2 ) {
RDebugUtils.currentLine=2555908;
 //BA.debugLineNum = 2555908;BA.debugLine="Dim s As String = listaFavorita.Get(i)";
_s = BA.ObjectToString(mostCurrent._listafavorita.Get(_i));
RDebugUtils.currentLine=2555909;
 //BA.debugLineNum = 2555909;BA.debugLine="If mapavrijednost.Contains(s) = True Then";
if (_mapavrijednost.contains(_s)==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=2555910;
 //BA.debugLineNum = 2555910;BA.debugLine="ToastMessageShow(\"App already in favorites!\", F";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("App already in favorites!"),anywheresoftware.b4a.keywords.Common.False);
 };
 }
};
RDebugUtils.currentLine=2555913;
 //BA.debugLineNum = 2555913;BA.debugLine="End Sub";
return "";
}
public static String  _filtrirajimenaappiimenapaketa() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "filtrirajimenaappiimenapaketa", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "filtrirajimenaappiimenapaketa", null));}
int _i = 0;
String _pckg1 = "";
String _pckg = "";
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub FiltrirajImenaAppIImenaPaketa";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="l1.Initialize";
mostCurrent._l1.Initialize();
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="Dim l As List";
mostCurrent._l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1835011;
 //BA.debugLineNum = 1835011;BA.debugLine="l.Initialize";
mostCurrent._l.Initialize();
RDebugUtils.currentLine=1835012;
 //BA.debugLineNum = 1835012;BA.debugLine="For i = 0 To Starter.mapa.Size - 1";
{
final int step4 = 1;
final int limit4 = (int) (mostCurrent._starter._mapa.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=1835013;
 //BA.debugLineNum = 1835013;BA.debugLine="Dim pckg1 As String";
_pckg1 = "";
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(i)";
_pckg = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_i));
RDebugUtils.currentLine=1835015;
 //BA.debugLineNum = 1835015;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pck";
_pckg1 = _pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length());
RDebugUtils.currentLine=1835017;
 //BA.debugLineNum = 1835017;BA.debugLine="l1.Add(pckg1)";
mostCurrent._l1.Add((Object)(_pckg1));
RDebugUtils.currentLine=1835018;
 //BA.debugLineNum = 1835018;BA.debugLine="pckg1 = pckg.SubString2(0, pckg.IndexOf(\";\"))";
_pckg1 = _pckg.substring((int) (0),_pckg.indexOf(";"));
RDebugUtils.currentLine=1835020;
 //BA.debugLineNum = 1835020;BA.debugLine="l.Add(pckg1)";
mostCurrent._l.Add((Object)(_pckg1));
 }
};
RDebugUtils.currentLine=1835022;
 //BA.debugLineNum = 1835022;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.PanelWrapper  _kreirajstavku(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b,String _imeapp,int _width,int _height) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "kreirajstavku", false))
	 {return ((anywheresoftware.b4a.objects.PanelWrapper) Debug.delegate(mostCurrent.activityBA, "kreirajstavku", new Object[] {_b,_imeapp,_width,_height}));}
anywheresoftware.b4a.objects.PanelWrapper _p = null;
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Sub KreirajStavku(b As Bitmap, imeApp As String, W";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="Dim p As Panel";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="p.Initialize(\"\")";
_p.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="p.Color = Colors.Transparent";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.Transparent);
RDebugUtils.currentLine=2097157;
 //BA.debugLineNum = 2097157;BA.debugLine="p.SetLayout(0, btnPostavke.Height, Width, Height)";
_p.SetLayout((int) (0),mostCurrent._btnpostavke.getHeight(),_width,_height);
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="p.LoadLayout(\"clv_stavka\")";
_p.LoadLayout("clv_stavka",mostCurrent.activityBA);
RDebugUtils.currentLine=2097160;
 //BA.debugLineNum = 2097160;BA.debugLine="ivApp.Bitmap = b";
mostCurrent._ivapp.setBitmap((android.graphics.Bitmap)(_b.getObject()));
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="lblImeApp.TextSize = f.fontzSize";
mostCurrent._lblimeapp.setTextSize((float) (mostCurrent._f._fontzsize));
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="lblImeApp.Typeface = Typeface.LoadFromAssets(f.wh";
mostCurrent._lblimeapp.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=2097163;
 //BA.debugLineNum = 2097163;BA.debugLine="lblImeApp.Text = imeApp";
mostCurrent._lblimeapp.setText(BA.ObjectToCharSequence(_imeapp));
RDebugUtils.currentLine=2097164;
 //BA.debugLineNum = 2097164;BA.debugLine="lblImeApp.TextColor = f.bojaFonta";
mostCurrent._lblimeapp.setTextColor(mostCurrent._f._bojafonta);
RDebugUtils.currentLine=2097166;
 //BA.debugLineNum = 2097166;BA.debugLine="Return p";
if (true) return _p;
RDebugUtils.currentLine=2097167;
 //BA.debugLineNum = 2097167;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Public Sub GetAllTabLabels (tabstrip As TabStrip)";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim jo As JavaObject = tabstrip";
_jo = new anywheresoftware.b4j.object.JavaObject();
_jo.setObject((java.lang.Object)(_tabstrip));
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="r.Target = jo.GetField(\"tabStrip\")";
_r.Target = _jo.GetField("tabStrip");
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="Dim tc As Panel = r.GetField(\"tabsContainer\")";
_tc = new anywheresoftware.b4a.objects.PanelWrapper();
_tc.setObject((android.view.ViewGroup)(_r.GetField("tabsContainer")));
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Dim res As List";
_res = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="res.Initialize";
_res.Initialize();
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="For Each v As View In tc";
_v = new anywheresoftware.b4a.objects.ConcreteViewWrapper();
{
final anywheresoftware.b4a.BA.IterableList group7 = _tc;
final int groupLen7 = group7.getSize()
;int index7 = 0;
;
for (; index7 < groupLen7;index7++){
_v.setObject((android.view.View)(group7.Get(index7)));
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="If v Is Label Then res.Add(v)";
if (_v.getObjectOrNull() instanceof android.widget.TextView) { 
_res.Add((Object)(_v.getObject()));};
 }
};
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="End Sub";
return null;
}
public static String  _ivappmain_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivappmain_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivappmain_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub ivAppMain_Click";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("31769478",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="in = pm.GetApplicationIntent(iv.Tag)";
_in = _pm.GetApplicationIntent(BA.ObjectToString(_iv.getTag()));
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="If in.IsInitialized Then";
if (_in.IsInitialized()) { 
RDebugUtils.currentLine=1769483;
 //BA.debugLineNum = 1769483;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=1769485;
 //BA.debugLineNum = 1769485;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub ivAppMain_LongClick";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Log(\"ivapp long klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("31638401","ivapp long klik!",0);
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=1638404;
 //BA.debugLineNum = 1638404;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("31638404",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="Dim ll As List";
_ll = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=1638406;
 //BA.debugLineNum = 1638406;BA.debugLine="ll.Initialize";
_ll.Initialize();
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="ll.AddAll(Array As String(\"Add to favorites\", \"Un";
_ll.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Add to favorites","Uninstall"}));
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
_m = _x.InputList1(_ll,"",mostCurrent.activityBA);
RDebugUtils.currentLine=1638410;
 //BA.debugLineNum = 1638410;BA.debugLine="Select m";
switch (_m) {
case 0: {
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(za";
_provjeraappufavoritima(BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_zadnja_oznacena_app)));
RDebugUtils.currentLine=1638413;
 //BA.debugLineNum = 1638413;BA.debugLine="DodajAppUFavorite";
_dodajappufavorite();
 break; }
case 1: {
RDebugUtils.currentLine=1638415;
 //BA.debugLineNum = 1638415;BA.debugLine="UninstallApp(iv.Tag)";
_uninstallapp(BA.ObjectToString(_iv.getTag()));
 break; }
}
;
RDebugUtils.currentLine=1638417;
 //BA.debugLineNum = 1638417;BA.debugLine="End Sub";
return "";
}
public static String  _uninstallapp(String _pkg) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "uninstallapp", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "uninstallapp", new Object[] {_pkg}));}
anywheresoftware.b4a.objects.IntentWrapper _i = null;
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub UninstallApp(pkg As String)";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="If IsPaused(provjera) = True Then StartService(pr";
if (anywheresoftware.b4a.keywords.Common.IsPaused(processBA,(Object)(mostCurrent._provjera.getObject()))==anywheresoftware.b4a.keywords.Common.True) { 
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(mostCurrent._provjera.getObject()));};
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="Dim i As Intent";
_i = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="Log(\"package:\" & pkg)";
anywheresoftware.b4a.keywords.Common.LogImpl("31703941","package:"+_pkg,0);
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="i.Initialize(\"android.intent.action.DELETE\", \"pac";
_i.Initialize("android.intent.action.DELETE","package:"+_pkg);
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="StartActivity(i)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_i.getObject()));
RDebugUtils.currentLine=1703951;
 //BA.debugLineNum = 1703951;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Sub ivClvDodaj_Click";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="If lbl.IsInitialized Then lbl.RemoveView";
if (mostCurrent._lbl.IsInitialized()) { 
mostCurrent._lbl.RemoveView();};
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="Private imgV As ImageView = Sender";
_imgv = new anywheresoftware.b4a.objects.ImageViewWrapper();
_imgv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="Private Index As Int = clv.GetItemFromView(Sender";
_index = mostCurrent._clv._getitemfromview((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA))));
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(Inde";
_provjeraappufavoritima(BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_index)));
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="iv.Initialize(\"ivMainApp\")";
_iv.Initialize(mostCurrent.activityBA,"ivMainApp");
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="iv.Tag = scvDock.Panel.NumberOfViews";
_iv.setTag((Object)(mostCurrent._scvdock.getPanel().getNumberOfViews()));
RDebugUtils.currentLine=2490381;
 //BA.debugLineNum = 2490381;BA.debugLine="iv.Width = 48dip";
_iv.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=2490382;
 //BA.debugLineNum = 2490382;BA.debugLine="iv.Height = 48dip";
_iv.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48)));
RDebugUtils.currentLine=2490383;
 //BA.debugLineNum = 2490383;BA.debugLine="iv.Gravity = Gravity.FILL";
_iv.setGravity(anywheresoftware.b4a.keywords.Common.Gravity.FILL);
RDebugUtils.currentLine=2490385;
 //BA.debugLineNum = 2490385;BA.debugLine="Dim pckg1 As String";
_pckg1 = "";
RDebugUtils.currentLine=2490386;
 //BA.debugLineNum = 2490386;BA.debugLine="Dim pckg As String = Starter.mapa.GetKeyAt(Index)";
_pckg = BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_index));
RDebugUtils.currentLine=2490387;
 //BA.debugLineNum = 2490387;BA.debugLine="pckg1 = pckg.SubString2(pckg.IndexOf(\";\")+1, pckg";
_pckg1 = _pckg.substring((int) (_pckg.indexOf(";")+1),_pckg.length());
RDebugUtils.currentLine=2490388;
 //BA.debugLineNum = 2490388;BA.debugLine="Dim bdw As BitmapDrawable = pm.GetApplicationIcon";
_bdw = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
_bdw.setObject((android.graphics.drawable.BitmapDrawable)(_pm.GetApplicationIcon(_pckg1)));
RDebugUtils.currentLine=2490389;
 //BA.debugLineNum = 2490389;BA.debugLine="Dim bmp As Bitmap = bdw.Bitmap";
_bmp = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
_bmp.setObject((android.graphics.Bitmap)(_bdw.getBitmap()));
RDebugUtils.currentLine=2490390;
 //BA.debugLineNum = 2490390;BA.debugLine="bdw.Initialize(bmp.Resize(48dip, 48dip, True))";
_bdw.Initialize((android.graphics.Bitmap)(_bmp.Resize((float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))),anywheresoftware.b4a.keywords.Common.True).getObject()));
RDebugUtils.currentLine=2490391;
 //BA.debugLineNum = 2490391;BA.debugLine="listaFavorita.Add(pckg1)	' dodaj ime paketa aplik";
mostCurrent._listafavorita.Add((Object)(_pckg1));
RDebugUtils.currentLine=2490394;
 //BA.debugLineNum = 2490394;BA.debugLine="iv.Bitmap = bdw.Bitmap'bm1";
_iv.setBitmap(_bdw.getBitmap());
RDebugUtils.currentLine=2490395;
 //BA.debugLineNum = 2490395;BA.debugLine="scvDock.Panel.AddView(iv, iv.Width*scvDock.Panel.";
mostCurrent._scvdock.getPanel().AddView((android.view.View)(_iv.getObject()),(int) (_iv.getWidth()*mostCurrent._scvdock.getPanel().getNumberOfViews()),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (4)),_iv.getWidth(),_iv.getHeight());
RDebugUtils.currentLine=2490484;
 //BA.debugLineNum = 2490484;BA.debugLine="imgV.Bitmap = LoadBitmap(File.DirAssets, \"act_add";
_imgv.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmap(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"act_add_pressed.png").getObject()));
RDebugUtils.currentLine=2490486;
 //BA.debugLineNum = 2490486;BA.debugLine="File.WriteList(File.DirInternal, \"favorit_app\", l";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app",mostCurrent._listafavorita);
RDebugUtils.currentLine=2490488;
 //BA.debugLineNum = 2490488;BA.debugLine="ToastMessageShow(\"Application added to favorites.";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Application added to favorites."),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2490489;
 //BA.debugLineNum = 2490489;BA.debugLine="End Sub";
return "";
}
public static String  _ivdokpokreniapp_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivdokpokreniapp_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivdokpokreniapp_click", null));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4a.objects.ImageViewWrapper _iv = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Sub ivDokPokreniApp_Click";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Log(\"klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32621441","klik!",0);
RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="Dim iv As ImageView";
_iv = new anywheresoftware.b4a.objects.ImageViewWrapper();
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="iv = Sender";
_iv.setObject((android.widget.ImageView)(anywheresoftware.b4a.keywords.Common.Sender(mostCurrent.activityBA)));
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="Log(iv.Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("32621447",BA.ObjectToString(_iv.getTag()),0);
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="Log(listaFavorita.Get(iv.Tag))";
anywheresoftware.b4a.keywords.Common.LogImpl("32621449",BA.ObjectToString(mostCurrent._listafavorita.Get((int)(BA.ObjectToNumber(_iv.getTag())))),0);
RDebugUtils.currentLine=2621450;
 //BA.debugLineNum = 2621450;BA.debugLine="in = pm.GetApplicationIntent(listaFavorita.Get(iv";
_in = _pm.GetApplicationIntent(BA.ObjectToString(mostCurrent._listafavorita.Get((int)(BA.ObjectToNumber(_iv.getTag())))));
RDebugUtils.currentLine=2621451;
 //BA.debugLineNum = 2621451;BA.debugLine="If in.IsInitialized Then";
if (_in.IsInitialized()) { 
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="End Sub";
return "";
}
public static String  _ivwheeldodaj_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "ivwheeldodaj_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "ivwheeldodaj_click", null));}
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Sub ivWheelDodaj_Click";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Log(\"vil dodaj klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32031617","vil dodaj klik!",0);
RDebugUtils.currentLine=2031619;
 //BA.debugLineNum = 2031619;BA.debugLine="ivWheelDodaj.BringToFront";
mostCurrent._ivwheeldodaj.BringToFront();
RDebugUtils.currentLine=2031624;
 //BA.debugLineNum = 2031624;BA.debugLine="If lbl.IsInitialized Then lbl.RemoveView";
if (mostCurrent._lbl.IsInitialized()) { 
mostCurrent._lbl.RemoveView();};
RDebugUtils.currentLine=2031635;
 //BA.debugLineNum = 2031635;BA.debugLine="ProvjeraAppUFavoritima(Starter.mapa.GetKeyAt(zadn";
_provjeraappufavoritima(BA.ObjectToString(mostCurrent._starter._mapa.GetKeyAt(_zadnja_oznacena_app)));
RDebugUtils.currentLine=2031636;
 //BA.debugLineNum = 2031636;BA.debugLine="DodajAppUFavorite";
_dodajappufavorite();
RDebugUtils.currentLine=2031734;
 //BA.debugLineNum = 2031734;BA.debugLine="File.WriteList(File.DirInternal, \"favorit_app\", l";
anywheresoftware.b4a.keywords.Common.File.WriteList(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"favorit_app",mostCurrent._listafavorita);
RDebugUtils.currentLine=2031735;
 //BA.debugLineNum = 2031735;BA.debugLine="End Sub";
return "";
}
public static String  _kontaktigrid_finishedloading() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "kontaktigrid_finishedloading", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "kontaktigrid_finishedloading", null));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub kontaktiGrid_FinishedLoading";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="End Sub";
return "";
}
public static String  _kontaktigrid_itemclicked(String _item) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "kontaktigrid_itemclicked", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "kontaktigrid_itemclicked", new Object[] {_item}));}
anywheresoftware.b4a.objects.collections.List _ll = null;
com.maximus.id.id _x = null;
int _m = 0;
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub kontaktiGrid_ItemClicked(Item As String)";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="Log(Item)";
anywheresoftware.b4a.keywords.Common.LogImpl("33473409",_item,0);
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Dim ll As List";
_ll = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="ll.Initialize";
_ll.Initialize();
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="ll.AddAll(Array As String(\"Call\", \"SMS\", \"EMail\",";
_ll.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Call","SMS","EMail","Info"}));
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="Dim x As id";
_x = new com.maximus.id.id();
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="Dim m As Int = x.InputList1(ll, \"\")";
_m = _x.InputList1(_ll,"",mostCurrent.activityBA);
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="Log(m)";
anywheresoftware.b4a.keywords.Common.LogImpl("33473415",BA.NumberToString(_m),0);
RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="Select m";
switch (_m) {
case 0: {
RDebugUtils.currentLine=3473418;
 //BA.debugLineNum = 3473418;BA.debugLine="btnKontaktPoziv_Click(Item.Replace(\"file:///\",";
_btnkontaktpoziv_click(_item.replace("file:///",""));
 break; }
case 1: {
RDebugUtils.currentLine=3473420;
 //BA.debugLineNum = 3473420;BA.debugLine="btnKontaktSMS_Click(Item.Replace(\"file:///\", \"\"";
_btnkontaktsms_click(_item.replace("file:///",""));
 break; }
case 2: {
RDebugUtils.currentLine=3473422;
 //BA.debugLineNum = 3473422;BA.debugLine="btnKontaktEmail_Click(Item.Replace(\"file:///\",";
_btnkontaktemail_click(_item.replace("file:///",""));
 break; }
case 3: {
RDebugUtils.currentLine=3473424;
 //BA.debugLineNum = 3473424;BA.debugLine="btnKontaktInfo_Click(Item.Replace(\"file:///\", \"";
_btnkontaktinfo_click(_item.replace("file:///",""));
 break; }
}
;
RDebugUtils.currentLine=3473426;
 //BA.debugLineNum = 3473426;BA.debugLine="End Sub";
return "";
}
public static String  _lblimeapp_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "lblimeapp_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "lblimeapp_longclick", null));}
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Sub lblImeApp_LongClick";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Log(\"lblimeapp long klik!\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32359297","lblimeapp long klik!",0);
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="End Sub";
return "";
}
public static String  _osvjezi() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "osvjezi", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "osvjezi", null));}
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Sub Osvjezi";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="f.UcitajVrijednostiOpt";
mostCurrent._f._ucitajvrijednostiopt(mostCurrent.activityBA);
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="ViewsBringToFront";
_viewsbringtofront();
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="If scvDock.IsInitialized Then scvDock.Panel.Remov";
if (mostCurrent._scvdock.IsInitialized()) { 
mostCurrent._scvdock.getPanel().RemoveAllViews();};
RDebugUtils.currentLine=2293771;
 //BA.debugLineNum = 2293771;BA.debugLine="ShowFavoriteApps";
_showfavoriteapps();
RDebugUtils.currentLine=2293807;
 //BA.debugLineNum = 2293807;BA.debugLine="End Sub";
return "";
}
public static String  _scvpanel_longclick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "scvpanel_longclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "scvpanel_longclick", null));}
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub scvPanel_LongClick";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Log(\"scvDock long klik\")";
anywheresoftware.b4a.keywords.Common.LogImpl("31245185","scvDock long klik",0);
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="End Sub";
return "";
}
public static boolean  _scvpanel_touch(Object _vt_iv,int _action,float _x,float _y,Object _motionevent) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "scvpanel_touch", false))
	 {return ((Boolean) Debug.delegate(mostCurrent.activityBA, "scvpanel_touch", new Object[] {_vt_iv,_action,_x,_y,_motionevent}));}
int _numlab = 0;
anywheresoftware.b4a.objects.ImageViewWrapper _iv1 = null;
String _tag = "";
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub scvPanel_Touch(vt_iv As Object, Action As Int,";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Select Action";
switch (BA.switchObjectToInt(_action,mostCurrent._activity.ACTION_DOWN)) {
case 0: {
RDebugUtils.currentLine=1310723;
 //BA.debugLineNum = 1310723;BA.debugLine="If lbl.IsInitialized = False Then";
if (mostCurrent._lbl.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="Dim NumLab As Int = (X / 48dip)	' if labels ar";
_numlab = (int) ((_x/(double)anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (48))));
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="Dim iv1 As ImageView = scvDock.Panel.getview(N";
_iv1 = new anywheresoftware.b4a.objects.ImageViewWrapper();
_iv1.setObject((android.widget.ImageView)(mostCurrent._scvdock.getPanel().GetView(_numlab).getObject()));
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="Dim Tag As String = iv1.Tag";
_tag = BA.ObjectToString(_iv1.getTag());
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="Log(Tag)";
anywheresoftware.b4a.keywords.Common.LogImpl("31310727",_tag,0);
RDebugUtils.currentLine=1310728;
 //BA.debugLineNum = 1310728;BA.debugLine="Log(listaFavorita.Get(Tag))";
anywheresoftware.b4a.keywords.Common.LogImpl("31310728",BA.ObjectToString(mostCurrent._listafavorita.Get((int)(Double.parseDouble(_tag)))),0);
 };
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 break; }
}
;
RDebugUtils.currentLine=1310733;
 //BA.debugLineNum = 1310733;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=1310734;
 //BA.debugLineNum = 1310734;BA.debugLine="End Sub";
return false;
}
public static String  _smartwidgets_backpressed(int _widgetid) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "smartwidgets_backpressed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "smartwidgets_backpressed", new Object[] {_widgetid}));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub SmartWidgets_BackPressed (WidgetId As Int)";
RDebugUtils.currentLine=2883585;
 //BA.debugLineNum = 2883585;BA.debugLine="Log(\"Back pressed\")";
anywheresoftware.b4a.keywords.Common.LogImpl("32883585","Back pressed",0);
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="End Sub";
return "";
}
public static String  _smartwidgets_widgetcreated(int _hostid,Object _hostview,int _widgetid,Object _widgetinfo) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "smartwidgets_widgetcreated", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "smartwidgets_widgetcreated", new Object[] {_hostid,_hostview,_widgetid,_widgetinfo}));}
anywheresoftware.b4a.objects.PanelWrapper _widget_panel = null;
com.rootsoft.rssmartwidgets.RSAppWidgetProviderInfo _info = null;
com.rootsoft.rssmartwidgets.RSAppWidgetHostView _hw = null;
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub SmartWidgets_WidgetCreated (HostId As Int, Hos";
RDebugUtils.currentLine=2818049;
 //BA.debugLineNum = 2818049;BA.debugLine="Dim widget_panel As Panel";
_widget_panel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="Dim Info As RSWidgetProviderInfo = widgetinfo";
_info = new com.rootsoft.rssmartwidgets.RSAppWidgetProviderInfo();
_info.setObject((android.appwidget.AppWidgetProviderInfo)(_widgetinfo));
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="Dim hw As RSWidgetHostView = HostView";
_hw = new com.rootsoft.rssmartwidgets.RSAppWidgetHostView();
_hw.setObject((android.appwidget.AppWidgetHostView)(_hostview));
RDebugUtils.currentLine=2818060;
 //BA.debugLineNum = 2818060;BA.debugLine="Log(hw)";
anywheresoftware.b4a.keywords.Common.LogImpl("32818060",BA.ObjectToString(_hw),0);
RDebugUtils.currentLine=2818061;
 //BA.debugLineNum = 2818061;BA.debugLine="Log(HostId)";
anywheresoftware.b4a.keywords.Common.LogImpl("32818061",BA.NumberToString(_hostid),0);
RDebugUtils.currentLine=2818062;
 //BA.debugLineNum = 2818062;BA.debugLine="Log(WidgetId)";
anywheresoftware.b4a.keywords.Common.LogImpl("32818062",BA.NumberToString(_widgetid),0);
RDebugUtils.currentLine=2818063;
 //BA.debugLineNum = 2818063;BA.debugLine="widget_panel.Initialize(\"\")";
_widget_panel.Initialize(mostCurrent.activityBA,"");
RDebugUtils.currentLine=2818064;
 //BA.debugLineNum = 2818064;BA.debugLine="widget_panel = hw'HostView' SmartWidgets.HostView";
_widget_panel.setObject((android.view.ViewGroup)(_hw.getObject()));
RDebugUtils.currentLine=2818065;
 //BA.debugLineNum = 2818065;BA.debugLine="Log(hw)";
anywheresoftware.b4a.keywords.Common.LogImpl("32818065",BA.ObjectToString(_hw),0);
RDebugUtils.currentLine=2818066;
 //BA.debugLineNum = 2818066;BA.debugLine="Log(HostId)";
anywheresoftware.b4a.keywords.Common.LogImpl("32818066",BA.NumberToString(_hostid),0);
RDebugUtils.currentLine=2818067;
 //BA.debugLineNum = 2818067;BA.debugLine="Log(WidgetId)";
anywheresoftware.b4a.keywords.Common.LogImpl("32818067",BA.NumberToString(_widgetid),0);
RDebugUtils.currentLine=2818068;
 //BA.debugLineNum = 2818068;BA.debugLine="If DipToCurrent(Info.MinWidth) > GetDeviceLayoutV";
if (anywheresoftware.b4a.keywords.Common.DipToCurrent(_info.getMinWidth())>anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Width) { 
RDebugUtils.currentLine=2818069;
 //BA.debugLineNum = 2818069;BA.debugLine="widget_panel.Width = Info.MinWidth";
_widget_panel.setWidth(_info.getMinWidth());
 }else {
RDebugUtils.currentLine=2818071;
 //BA.debugLineNum = 2818071;BA.debugLine="widget_panel.Width = DipToCurrent(Info.MinWidth)";
_widget_panel.setWidth(anywheresoftware.b4a.keywords.Common.DipToCurrent(_info.getMinWidth()));
 };
RDebugUtils.currentLine=2818074;
 //BA.debugLineNum = 2818074;BA.debugLine="If DipToCurrent(Info.MinHeight) > GetDeviceLayout";
if (anywheresoftware.b4a.keywords.Common.DipToCurrent(_info.getMinHeight())>anywheresoftware.b4a.keywords.Common.GetDeviceLayoutValues(mostCurrent.activityBA).Height) { 
RDebugUtils.currentLine=2818075;
 //BA.debugLineNum = 2818075;BA.debugLine="widget_panel.Height = Info.MinHeight";
_widget_panel.setHeight(_info.getMinHeight());
 }else {
RDebugUtils.currentLine=2818077;
 //BA.debugLineNum = 2818077;BA.debugLine="widget_panel.Height = DipToCurrent(Info.MinHeigh";
_widget_panel.setHeight(anywheresoftware.b4a.keywords.Common.DipToCurrent(_info.getMinHeight()));
 };
RDebugUtils.currentLine=2818080;
 //BA.debugLineNum = 2818080;BA.debugLine="ipsilon = widget_panel.Height";
_ipsilon = _widget_panel.getHeight();
RDebugUtils.currentLine=2818081;
 //BA.debugLineNum = 2818081;BA.debugLine="SmartWidgets.AddView(Panel1, widget_panel, 0, top";
_smartwidgets.AddView(mostCurrent._panel1,(android.appwidget.AppWidgetHostView)(_widget_panel.getObject()),(int) (0),_topw);
RDebugUtils.currentLine=2818082;
 //BA.debugLineNum = 2818082;BA.debugLine="topW = topW + ipsilon";
_topw = (int) (_topw+_ipsilon);
RDebugUtils.currentLine=2818092;
 //BA.debugLineNum = 2818092;BA.debugLine="Log(hw)";
anywheresoftware.b4a.keywords.Common.LogImpl("32818092",BA.ObjectToString(_hw),0);
RDebugUtils.currentLine=2818093;
 //BA.debugLineNum = 2818093;BA.debugLine="SmartWidgets.StartListening";
_smartwidgets.StartListening();
RDebugUtils.currentLine=2818157;
 //BA.debugLineNum = 2818157;BA.debugLine="File.WriteString(File.DirInternal, \"thehost.txt\",";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"thehost.txt",BA.ObjectToString(_hostview));
RDebugUtils.currentLine=2818158;
 //BA.debugLineNum = 2818158;BA.debugLine="File.writestring(File.DirInternal, \"theid.txt\", H";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"theid.txt",BA.NumberToString(_hostid));
RDebugUtils.currentLine=2818159;
 //BA.debugLineNum = 2818159;BA.debugLine="File.WriteString(File.DirInternal, \"theappid.txt\"";
anywheresoftware.b4a.keywords.Common.File.WriteString(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"theappid.txt",BA.NumberToString(_smartwidgets.getAppWidgetId()));
RDebugUtils.currentLine=2818160;
 //BA.debugLineNum = 2818160;BA.debugLine="End Sub";
return "";
}
public static String  _tajmer_tick() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tajmer_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "tajmer_tick", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub tajmer_Tick";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="NotificationService.brojNotifikacija = 0";
mostCurrent._notificationservice._brojnotifikacija = (int) (0);
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="CallSubDelayed(NotificationService, \"GetActive\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._notificationservice.getObject()),"GetActive");
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="Log(NotificationService.brojNotifikacija)";
anywheresoftware.b4a.keywords.Common.LogImpl("33014659",BA.NumberToString(mostCurrent._notificationservice._brojnotifikacija),0);
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="End Sub";
return "";
}
public static String  _wp1_index_changed(int _currentindex) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "wp1_index_changed", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "wp1_index_changed", new Object[] {_currentindex}));}
RDebugUtils.currentLine=1376256;
 //BA.debugLineNum = 1376256;BA.debugLine="Sub wp1_index_changed (currentindex As Int)";
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="If zadnja_oznacena_app <> currentindex Then";
if (_zadnja_oznacena_app!=_currentindex) { 
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="zadnja_oznacena_app = currentindex";
_zadnja_oznacena_app = _currentindex;
 };
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="End Sub";
return "";
}
public static String  _wp1_index_clicked(int _position) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "wp1_index_clicked", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "wp1_index_clicked", new Object[] {_position}));}
anywheresoftware.b4a.objects.IntentWrapper _in = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
RDebugUtils.currentLine=1441792;
 //BA.debugLineNum = 1441792;BA.debugLine="Sub wp1_index_clicked(position As Int)";
RDebugUtils.currentLine=1441793;
 //BA.debugLineNum = 1441793;BA.debugLine="Dim in As Intent";
_in = new anywheresoftware.b4a.objects.IntentWrapper();
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="in = pm.GetApplicationIntent(l1.Get(zadnja_oznace";
_in = _pm.GetApplicationIntent(BA.ObjectToString(mostCurrent._l1.Get(_zadnja_oznacena_app)));
RDebugUtils.currentLine=1441797;
 //BA.debugLineNum = 1441797;BA.debugLine="If in.IsInitialized Then";
if (_in.IsInitialized()) { 
RDebugUtils.currentLine=1441798;
 //BA.debugLineNum = 1441798;BA.debugLine="Log(f.animStr)";
anywheresoftware.b4a.keywords.Common.LogImpl("31441798",mostCurrent._f._animstr,0);
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="StartActivity(in)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(_in.getObject()));
 };
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="End Sub";
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