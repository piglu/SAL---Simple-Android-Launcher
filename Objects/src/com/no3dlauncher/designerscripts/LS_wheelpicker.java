package com.no3dlauncher.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_wheelpicker{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
String _size="";
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
_size = BA.NumberToString(Math.min((views.get("pnlcolors").vw.getWidth()),(views.get("pnlcolors").vw.getHeight())));
views.get("pnlcolors").vw.setWidth((int)(Double.parseDouble(_size)));
views.get("pnlcolors").vw.setHeight((int)(Double.parseDouble(_size)));
views.get("pnlcolors").vw.setLeft((int)((50d / 100 * width) - (views.get("pnlcolors").vw.getWidth() / 2)));
views.get("pnloverlay").vw.setLeft((int)((views.get("pnlcolors").vw.getLeft())));
views.get("pnloverlay").vw.setWidth((int)((views.get("pnlcolors").vw.getLeft() + views.get("pnlcolors").vw.getWidth()) - ((views.get("pnlcolors").vw.getLeft()))));
views.get("pnloverlay").vw.setTop((int)((views.get("pnlcolors").vw.getTop())));
views.get("pnloverlay").vw.setHeight((int)((views.get("pnlcolors").vw.getTop() + views.get("pnlcolors").vw.getHeight()) - ((views.get("pnlcolors").vw.getTop()))));

}
}