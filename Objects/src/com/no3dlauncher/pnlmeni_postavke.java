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

public class pnlmeni_postavke extends Activity implements B4AActivity{
	public static pnlmeni_postavke mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "com.no3dlauncher", "com.no3dlauncher.pnlmeni_postavke");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (pnlmeni_postavke).");
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
		activityBA = new BA(this, layout, processBA, "com.no3dlauncher", "com.no3dlauncher.pnlmeni_postavke");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.no3dlauncher.pnlmeni_postavke", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (pnlmeni_postavke) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (pnlmeni_postavke) Resume **");
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
		return pnlmeni_postavke.class;
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
        BA.LogInfo("** Activity (pnlmeni_postavke) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            pnlmeni_postavke mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (pnlmeni_postavke) Resume **");
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
public anywheresoftware.b4a.objects.SpinnerWrapper _spnapps = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnfont = null;
public anywheresoftware.b4a.objects.LabelWrapper _label3 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtfontsize = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnbackground = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnfont = null;
public anywheresoftware.b4a.objects.SeekBarWrapper _sbtransparent = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnicontype = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtnoofstarpoints = null;
public anywheresoftware.b4a.objects.LabelWrapper _label7 = null;
public anywheresoftware.b4a.objects.EditTextWrapper _edtpages = null;
public de.donmanfred.AnimationComposerWrapper _animacije = null;
public anywheresoftware.b4a.objects.collections.Map _mapaanimacija = null;
public anywheresoftware.b4a.objects.SpinnerWrapper _spnanim = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnenablenotifications = null;
public com.no3dlauncher.main _main = null;
public com.no3dlauncher.starter _starter = null;
public com.no3dlauncher.search _search = null;
public com.no3dlauncher.notificationservice _notificationservice = null;
public com.no3dlauncher.postavke_kontakti _postavke_kontakti = null;
public com.no3dlauncher.f _f = null;
public com.no3dlauncher.provjera _provjera = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
anywheresoftware.b4a.objects.drawable.ColorDrawable _cd = null;
int[] _res = null;
anywheresoftware.b4a.objects.collections.List _l = null;
int _i = 0;
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="Activity.LoadLayout(\"opt\")";
mostCurrent._activity.LoadLayout("opt",mostCurrent.activityBA);
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="mapaAnimacija = animacije.Techniques";
mostCurrent._mapaanimacija = mostCurrent._animacije.getTechniques();
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="f.UcitajVrijednostiOpt";
mostCurrent._f._ucitajvrijednostiopt(mostCurrent.activityBA);
RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="sbTransparent.Value = f.trans";
mostCurrent._sbtransparent.setValue(mostCurrent._f._trans);
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="Dim cd As ColorDrawable";
_cd = new anywheresoftware.b4a.objects.drawable.ColorDrawable();
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=4325385;
 //BA.debugLineNum = 4325385;BA.debugLine="res = getARGB(f.bojaPozadine)";
_res = _getargb(mostCurrent._f._bojapozadine);
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="res(0) = f.trans";
_res[(int) (0)] = mostCurrent._f._trans;
RDebugUtils.currentLine=4325387;
 //BA.debugLineNum = 4325387;BA.debugLine="cd.Initialize(Colors.ARGB(res(0), res(1), res(2),";
_cd.Initialize(anywheresoftware.b4a.keywords.Common.Colors.ARGB(_res[(int) (0)],_res[(int) (1)],_res[(int) (2)],_res[(int) (3)]),(int) (0));
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="Label1.Background = cd";
mostCurrent._label1.setBackground((android.graphics.drawable.Drawable)(_cd.getObject()));
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="Label1.TextColor = f.bojaFonta";
mostCurrent._label1.setTextColor(mostCurrent._f._bojafonta);
RDebugUtils.currentLine=4325390;
 //BA.debugLineNum = 4325390;BA.debugLine="spnApps.AddAll(Array As String(\"in a wheel\", \"in";
mostCurrent._spnapps.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"in a wheel","in a list with app icons","in drawer"}));
RDebugUtils.currentLine=4325391;
 //BA.debugLineNum = 4325391;BA.debugLine="spnApps.SelectedIndex = f.showApps";
mostCurrent._spnapps.setSelectedIndex(mostCurrent._f._showapps);
RDebugUtils.currentLine=4325392;
 //BA.debugLineNum = 4325392;BA.debugLine="spnIconType.AddAll(Array As String(\"Round\", \"Hexa";
mostCurrent._spnicontype.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{"Round","Hexagon","Triangle","Star","Heart","Bubble","Cone"}));
RDebugUtils.currentLine=4325393;
 //BA.debugLineNum = 4325393;BA.debugLine="spnIconType.SelectedIndex = f.tipIkone";
mostCurrent._spnicontype.setSelectedIndex(mostCurrent._f._tipikone);
RDebugUtils.currentLine=4325394;
 //BA.debugLineNum = 4325394;BA.debugLine="If spnIconType.SelectedIndex = 3 Then";
if (mostCurrent._spnicontype.getSelectedIndex()==3) { 
RDebugUtils.currentLine=4325395;
 //BA.debugLineNum = 4325395;BA.debugLine="Label7.Visible = True";
mostCurrent._label7.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325396;
 //BA.debugLineNum = 4325396;BA.debugLine="edtNoOfStarPoints.Visible = True";
mostCurrent._edtnoofstarpoints.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325397;
 //BA.debugLineNum = 4325397;BA.debugLine="edtNoOfStarPoints.Text = f.brTocaka";
mostCurrent._edtnoofstarpoints.setText(BA.ObjectToCharSequence(mostCurrent._f._brtocaka));
 }else {
RDebugUtils.currentLine=4325399;
 //BA.debugLineNum = 4325399;BA.debugLine="Label7.Visible = False";
mostCurrent._label7.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325400;
 //BA.debugLineNum = 4325400;BA.debugLine="edtNoOfStarPoints.Visible = False";
mostCurrent._edtnoofstarpoints.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=4325403;
 //BA.debugLineNum = 4325403;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4325404;
 //BA.debugLineNum = 4325404;BA.debugLine="l.Initialize";
_l.Initialize();
RDebugUtils.currentLine=4325405;
 //BA.debugLineNum = 4325405;BA.debugLine="For i = 0 To mapaAnimacija.Size - 1";
{
final int step26 = 1;
final int limit26 = (int) (mostCurrent._mapaanimacija.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit26 ;_i = _i + step26 ) {
RDebugUtils.currentLine=4325406;
 //BA.debugLineNum = 4325406;BA.debugLine="l.Add(mapaAnimacija.GetKeyAt(i))";
_l.Add(mostCurrent._mapaanimacija.GetKeyAt(_i));
 }
};
RDebugUtils.currentLine=4325410;
 //BA.debugLineNum = 4325410;BA.debugLine="spnAnim.AddAll(l)";
mostCurrent._spnanim.AddAll(_l);
RDebugUtils.currentLine=4325411;
 //BA.debugLineNum = 4325411;BA.debugLine="spnAnim.SelectedIndex = spnAnim.IndexOf(f.animStr";
mostCurrent._spnanim.setSelectedIndex(mostCurrent._spnanim.IndexOf(mostCurrent._f._animstr));
RDebugUtils.currentLine=4325413;
 //BA.debugLineNum = 4325413;BA.debugLine="edtPages.Text = f.brStranica";
mostCurrent._edtpages.setText(BA.ObjectToCharSequence(mostCurrent._f._brstranica));
RDebugUtils.currentLine=4325415;
 //BA.debugLineNum = 4325415;BA.debugLine="edtFontSize.Text = f.fontzSize";
mostCurrent._edtfontsize.setText(BA.ObjectToCharSequence(mostCurrent._f._fontzsize));
RDebugUtils.currentLine=4325416;
 //BA.debugLineNum = 4325416;BA.debugLine="DodajFontove";
_dodajfontove();
RDebugUtils.currentLine=4325417;
 //BA.debugLineNum = 4325417;BA.debugLine="End Sub";
return "";
}
public static int[]  _getargb(int _color) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "getargb", false))
	 {return ((int[]) Debug.delegate(mostCurrent.activityBA, "getargb", new Object[] {_color}));}
int[] _res = null;
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub getARGB(Color As Int) As Int()";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="res(0) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (0)] = anywheresoftware.b4a.keywords.Common.Bit.UnsignedShiftRight(anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff000000)),(int) (24));
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="res(1) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (1)] = anywheresoftware.b4a.keywords.Common.Bit.UnsignedShiftRight(anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff0000)),(int) (16));
RDebugUtils.currentLine=4915205;
 //BA.debugLineNum = 4915205;BA.debugLine="res(2) = Bit.UnsignedShiftRight(Bit.And(Color, 0x";
_res[(int) (2)] = anywheresoftware.b4a.keywords.Common.Bit.UnsignedShiftRight(anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff00)),(int) (8));
RDebugUtils.currentLine=4915206;
 //BA.debugLineNum = 4915206;BA.debugLine="res(3) = Bit.And(Color, 0xff)";
_res[(int) (3)] = anywheresoftware.b4a.keywords.Common.Bit.And(_color,(int) (0xff));
RDebugUtils.currentLine=4915208;
 //BA.debugLineNum = 4915208;BA.debugLine="Return res";
if (true) return _res;
RDebugUtils.currentLine=4915209;
 //BA.debugLineNum = 4915209;BA.debugLine="End Sub";
return null;
}
public static String  _dodajfontove() throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "dodajfontove", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "dodajfontove", null));}
anywheresoftware.b4a.objects.collections.List _list = null;
int _i = 0;
String _s = "";
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub DodajFontove";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="Dim list As List";
_list = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="list = File.ListFiles(File.DirAssets)";
_list = anywheresoftware.b4a.keywords.Common.File.ListFiles(anywheresoftware.b4a.keywords.Common.File.getDirAssets());
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="For i = 0 To list.Size - 1";
{
final int step3 = 1;
final int limit3 = (int) (_list.getSize()-1);
_i = (int) (0) ;
for (;_i <= limit3 ;_i = _i + step3 ) {
RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="Dim s As String = list.Get(i)";
_s = BA.ObjectToString(_list.Get(_i));
RDebugUtils.currentLine=4521989;
 //BA.debugLineNum = 4521989;BA.debugLine="If s.EndsWith(\".ttf\") Then";
if (_s.endsWith(".ttf")) { 
RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="s = s.SubString2(0, s.LastIndexOf(\".\"))";
_s = _s.substring((int) (0),_s.lastIndexOf("."));
RDebugUtils.currentLine=4521991;
 //BA.debugLineNum = 4521991;BA.debugLine="spnFont.Add(s)";
mostCurrent._spnfont.Add(_s);
 };
 }
};
RDebugUtils.currentLine=4521994;
 //BA.debugLineNum = 4521994;BA.debugLine="spnFont.SelectedIndex = spnFont.IndexOf(f.wheelLi";
mostCurrent._spnfont.setSelectedIndex(mostCurrent._spnfont.IndexOf(mostCurrent._f._wheellistfont));
RDebugUtils.currentLine=4521995;
 //BA.debugLineNum = 4521995;BA.debugLine="Label3.Typeface = Typeface.LoadFromAssets(f.wheel";
mostCurrent._label3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(mostCurrent._f._wheellistfont+".ttf"));
RDebugUtils.currentLine=4521996;
 //BA.debugLineNum = 4521996;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="If UserClosed Then";
if (_userclosed) { 
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="Log(\"juzer klouzed\")";
anywheresoftware.b4a.keywords.Common.LogImpl("34456450","juzer klouzed",0);
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="CallSubDelayed(Main, \"Osvjezi\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"Osvjezi");
 };
RDebugUtils.currentLine=4456453;
 //BA.debugLineNum = 4456453;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="End Sub";
return "";
}
public static void  _btnbackground_click() throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnbackground_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btnbackground_click", null); return;}
ResumableSub_btnBackground_Click rsub = new ResumableSub_btnBackground_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnBackground_Click extends BA.ResumableSub {
public ResumableSub_btnBackground_Click(com.no3dlauncher.pnlmeni_postavke parent) {
this.parent = parent;
}
com.no3dlauncher.pnlmeni_postavke parent;
com.no3dlauncher.colorwheeldialog _cw = null;
int[] _res = null;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="Dim cw As ColorWheelDialog";
_cw = new com.no3dlauncher.colorwheeldialog();
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="cw.Initialize";
_cw._initialize(null,mostCurrent.activityBA);
RDebugUtils.currentLine=4784133;
 //BA.debugLineNum = 4784133;BA.debugLine="cw.ShowAsync(Me, \"Select Background Color\")";
_cw._showasync(null,pnlmeni_postavke.getObject(),"Select Background Color");
RDebugUtils.currentLine=4784134;
 //BA.debugLineNum = 4784134;BA.debugLine="Wait For (cw) Color_Result(Success As Boolean)";
anywheresoftware.b4a.keywords.Common.WaitFor("color_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "pnlmeni_postavke", "btnbackground_click"), (Object)(_cw));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_success = (Boolean) result[0];
;
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="If Success Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_success) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=4784136;
 //BA.debugLineNum = 4784136;BA.debugLine="res = getARGB(cw.ColorResult)";
_res = _getargb(_cw._colorresult);
RDebugUtils.currentLine=4784137;
 //BA.debugLineNum = 4784137;BA.debugLine="Log(res(0))";
anywheresoftware.b4a.keywords.Common.LogImpl("34784137",BA.NumberToString(_res[(int) (0)]),0);
RDebugUtils.currentLine=4784138;
 //BA.debugLineNum = 4784138;BA.debugLine="Log(res(1))";
anywheresoftware.b4a.keywords.Common.LogImpl("34784138",BA.NumberToString(_res[(int) (1)]),0);
RDebugUtils.currentLine=4784139;
 //BA.debugLineNum = 4784139;BA.debugLine="Log(res(2))";
anywheresoftware.b4a.keywords.Common.LogImpl("34784139",BA.NumberToString(_res[(int) (2)]),0);
RDebugUtils.currentLine=4784140;
 //BA.debugLineNum = 4784140;BA.debugLine="Log(res(3))";
anywheresoftware.b4a.keywords.Common.LogImpl("34784140",BA.NumberToString(_res[(int) (3)]),0);
RDebugUtils.currentLine=4784141;
 //BA.debugLineNum = 4784141;BA.debugLine="Label1.Color = cw.ColorResult";
parent.mostCurrent._label1.setColor(_cw._colorresult);
RDebugUtils.currentLine=4784142;
 //BA.debugLineNum = 4784142;BA.debugLine="f.SnimiOpcije2(\"bojaPozadine\", cw.ColorResult)";
parent.mostCurrent._f._snimiopcije2(mostCurrent.activityBA,"bojaPozadine",_cw._colorresult);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=4784144;
 //BA.debugLineNum = 4784144;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _btnfont_click() throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnfont_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "btnfont_click", null); return;}
ResumableSub_btnFont_Click rsub = new ResumableSub_btnFont_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_btnFont_Click extends BA.ResumableSub {
public ResumableSub_btnFont_Click(com.no3dlauncher.pnlmeni_postavke parent) {
this.parent = parent;
}
com.no3dlauncher.pnlmeni_postavke parent;
com.no3dlauncher.colorwheeldialog _cw = null;
int[] _res = null;
boolean _success = false;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="Dim cw As ColorWheelDialog";
_cw = new com.no3dlauncher.colorwheeldialog();
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="cw.Initialize";
_cw._initialize(null,mostCurrent.activityBA);
RDebugUtils.currentLine=4849669;
 //BA.debugLineNum = 4849669;BA.debugLine="cw.ShowAsync(Me, \"Select Font Color\")";
_cw._showasync(null,pnlmeni_postavke.getObject(),"Select Font Color");
RDebugUtils.currentLine=4849670;
 //BA.debugLineNum = 4849670;BA.debugLine="Wait For (cw) Color_Result(Success As Boolean)";
anywheresoftware.b4a.keywords.Common.WaitFor("color_result", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "pnlmeni_postavke", "btnfont_click"), (Object)(_cw));
this.state = 5;
return;
case 5:
//C
this.state = 1;
_success = (Boolean) result[0];
;
RDebugUtils.currentLine=4849671;
 //BA.debugLineNum = 4849671;BA.debugLine="If Success Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_success) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=4849672;
 //BA.debugLineNum = 4849672;BA.debugLine="res = getARGB(cw.ColorResult)";
_res = _getargb(_cw._colorresult);
RDebugUtils.currentLine=4849673;
 //BA.debugLineNum = 4849673;BA.debugLine="Log(res(0))";
anywheresoftware.b4a.keywords.Common.LogImpl("34849673",BA.NumberToString(_res[(int) (0)]),0);
RDebugUtils.currentLine=4849674;
 //BA.debugLineNum = 4849674;BA.debugLine="Log(res(1))";
anywheresoftware.b4a.keywords.Common.LogImpl("34849674",BA.NumberToString(_res[(int) (1)]),0);
RDebugUtils.currentLine=4849675;
 //BA.debugLineNum = 4849675;BA.debugLine="Log(res(2))";
anywheresoftware.b4a.keywords.Common.LogImpl("34849675",BA.NumberToString(_res[(int) (2)]),0);
RDebugUtils.currentLine=4849676;
 //BA.debugLineNum = 4849676;BA.debugLine="Log(res(3))";
anywheresoftware.b4a.keywords.Common.LogImpl("34849676",BA.NumberToString(_res[(int) (3)]),0);
RDebugUtils.currentLine=4849677;
 //BA.debugLineNum = 4849677;BA.debugLine="Label1.TextColor = cw.ColorResult";
parent.mostCurrent._label1.setTextColor(_cw._colorresult);
RDebugUtils.currentLine=4849678;
 //BA.debugLineNum = 4849678;BA.debugLine="f.SnimiOpcije2(\"bojaFonta\", cw.ColorResult)";
parent.mostCurrent._f._snimiopcije2(mostCurrent.activityBA,"bojaFonta",_cw._colorresult);
 if (true) break;

case 4:
//C
this.state = -1;
;
RDebugUtils.currentLine=4849680;
 //BA.debugLineNum = 4849680;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _edtfontsize_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edtfontsize_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edtfontsize_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub edtFontSize_TextChanged (Old As String, New As";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="If New.Length > 0 Then";
if (_new.length()>0) { 
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="f.SnimiOpcije2(\"fontzSize\", New)";
mostCurrent._f._snimiopcije2(mostCurrent.activityBA,"fontzSize",(int)(Double.parseDouble(_new)));
 };
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="End Sub";
return "";
}
public static String  _edtnoofstarpoints_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edtnoofstarpoints_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edtnoofstarpoints_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub edtNoOfStarPoints_TextChanged (Old As String,";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="If New.Length > 0 Then";
if (_new.length()>0) { 
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="f.SnimiOpcije2(\"brTocaka\", New)";
mostCurrent._f._snimiopcije2(mostCurrent.activityBA,"brTocaka",(int)(Double.parseDouble(_new)));
 };
RDebugUtils.currentLine=5111812;
 //BA.debugLineNum = 5111812;BA.debugLine="End Sub";
return "";
}
public static String  _edtpages_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "edtpages_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "edtpages_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub edtPages_TextChanged (Old As String, New As St";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="If New.Length > 0 Then";
if (_new.length()>0) { 
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="f.SnimiOpcije2(\"brStranica\", New)";
mostCurrent._f._snimiopcije2(mostCurrent.activityBA,"brStranica",(int)(Double.parseDouble(_new)));
 };
RDebugUtils.currentLine=5177348;
 //BA.debugLineNum = 5177348;BA.debugLine="End Sub";
return "";
}
public static String  _sbtransparent_valuechanged(int _value,boolean _userchanged) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "sbtransparent_valuechanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "sbtransparent_valuechanged", new Object[] {_value,_userchanged}));}
int[] _res = null;
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub sbTransparent_ValueChanged (Value As Int, User";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="If UserChanged Then";
if (_userchanged) { 
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="Dim res(4) As Int";
_res = new int[(int) (4)];
;
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="f.SnimiOpcije2(\"trans\", Value)";
mostCurrent._f._snimiopcije2(mostCurrent.activityBA,"trans",_value);
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="f.UcitajVrijednostiOpt";
mostCurrent._f._ucitajvrijednostiopt(mostCurrent.activityBA);
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="res = getARGB(f.bojaPozadine)";
_res = _getargb(mostCurrent._f._bojapozadine);
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="res(0) = f.trans";
_res[(int) (0)] = mostCurrent._f._trans;
RDebugUtils.currentLine=4980743;
 //BA.debugLineNum = 4980743;BA.debugLine="Label1.Color = Colors.ARGB(res(0), res(1), res(2";
mostCurrent._label1.setColor(anywheresoftware.b4a.keywords.Common.Colors.ARGB(_res[(int) (0)],_res[(int) (1)],_res[(int) (2)],_res[(int) (3)]));
 };
RDebugUtils.currentLine=4980745;
 //BA.debugLineNum = 4980745;BA.debugLine="End Sub";
return "";
}
public static String  _spnanim_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "spnanim_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "spnanim_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub spnAnim_ItemClick (Position As Int, Value As O";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="f.SnimiOpcije(\"animStr\", Value)";
mostCurrent._f._snimiopcije(mostCurrent.activityBA,"animStr",BA.ObjectToString(_value));
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="End Sub";
return "";
}
public static String  _spnapps_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "spnapps_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "spnapps_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub spnApps_ItemClick (Position As Int, Value As O";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="f.UcitajVrijednostiOpt";
mostCurrent._f._ucitajvrijednostiopt(mostCurrent.activityBA);
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="If Position > 0 Then";
if (_position>0) { 
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="If f.fontzSize >= 50 Then";
if (mostCurrent._f._fontzsize>=50) { 
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="edtFontSize.Text = 18";
mostCurrent._edtfontsize.setText(BA.ObjectToCharSequence(18));
 };
 }else {
RDebugUtils.currentLine=4653064;
 //BA.debugLineNum = 4653064;BA.debugLine="ToastMessageShow(\"Font size should be at least 5";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Font size should be at least 55 for 'in wheel'!"),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653065;
 //BA.debugLineNum = 4653065;BA.debugLine="edtFontSize.Text = 55";
mostCurrent._edtfontsize.setText(BA.ObjectToCharSequence(55));
 };
RDebugUtils.currentLine=4653067;
 //BA.debugLineNum = 4653067;BA.debugLine="f.SnimiOpcije2(\"showApps\", Position)";
mostCurrent._f._snimiopcije2(mostCurrent.activityBA,"showApps",_position);
RDebugUtils.currentLine=4653068;
 //BA.debugLineNum = 4653068;BA.debugLine="End Sub";
return "";
}
public static String  _spnfont_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "spnfont_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "spnfont_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub spnFont_ItemClick (Position As Int, Value As O";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="f.SnimiOpcije(\"wheelListFont\",	Value)";
mostCurrent._f._snimiopcije(mostCurrent.activityBA,"wheelListFont",BA.ObjectToString(_value));
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="Label3.Typeface = Typeface.LoadFromAssets(Value &";
mostCurrent._label3.setTypeface(anywheresoftware.b4a.keywords.Common.Typeface.LoadFromAssets(BA.ObjectToString(_value)+".ttf"));
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="End Sub";
return "";
}
public static String  _spnicontype_itemclick(int _position,Object _value) throws Exception{
RDebugUtils.currentModule="pnlmeni_postavke";
if (Debug.shouldDelegate(mostCurrent.activityBA, "spnicontype_itemclick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "spnicontype_itemclick", new Object[] {_position,_value}));}
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub spnIconType_ItemClick (Position As Int, Value";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="f.SnimiOpcije2(\"tipIkone\", Position)";
mostCurrent._f._snimiopcije2(mostCurrent.activityBA,"tipIkone",_position);
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="If Position = 3 Then";
if (_position==3) { 
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="Label7.Visible = True";
mostCurrent._label7.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="edtNoOfStarPoints.Visible = True";
mostCurrent._edtnoofstarpoints.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046277;
 //BA.debugLineNum = 5046277;BA.debugLine="edtNoOfStarPoints.Text = f.brTocaka";
mostCurrent._edtnoofstarpoints.setText(BA.ObjectToCharSequence(mostCurrent._f._brtocaka));
 }else {
RDebugUtils.currentLine=5046279;
 //BA.debugLineNum = 5046279;BA.debugLine="Label7.Visible = False";
mostCurrent._label7.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046280;
 //BA.debugLineNum = 5046280;BA.debugLine="edtNoOfStarPoints.Visible = False";
mostCurrent._edtnoofstarpoints.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
RDebugUtils.currentLine=5046282;
 //BA.debugLineNum = 5046282;BA.debugLine="End Sub";
return "";
}
}