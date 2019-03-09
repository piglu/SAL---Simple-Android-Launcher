package com.no3dlauncher.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_widget_panel{

public static void LS_320x480_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("btnnatrag").vw.setTop((int)((views.get("panel1").vw.getTop() + views.get("panel1").vw.getHeight())));
views.get("btnnatrag").vw.setLeft((int)((2d / 100 * width)));
views.get("btnnaprijed").vw.setTop((int)((views.get("panel1").vw.getTop() + views.get("panel1").vw.getHeight())));
views.get("btnnaprijed").vw.setLeft((int)((98d / 100 * width) - (views.get("btnnaprijed").vw.getWidth())));

}
public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);

}
}