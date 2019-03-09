package com.no3dlauncher.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_mejn{

public static void LS_320x480_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("btnmeni").vw.setLeft((int)((2d / 100 * width)));
views.get("btnmeni").vw.setTop((int)((100d / 100 * height)-(2d / 100 * height) - (views.get("btnmeni").vw.getHeight())));
views.get("btnmeni").vw.setWidth((int)((12d / 100 * width)));
//BA.debugLineNum = 5;BA.debugLine="btnMeni.Height = 12%x"[mejn/320x480,scale=1]
views.get("btnmeni").vw.setHeight((int)((12d / 100 * width)));
//BA.debugLineNum = 6;BA.debugLine="btnSearch.Left = 2%x"[mejn/320x480,scale=1]
views.get("btnsearch").vw.setLeft((int)((2d / 100 * width)));
//BA.debugLineNum = 7;BA.debugLine="btnSearch.Bottom = 100%y - 2%y - btnMeni.Height"[mejn/320x480,scale=1]
views.get("btnsearch").vw.setTop((int)((100d / 100 * height)-(2d / 100 * height)-(views.get("btnmeni").vw.getHeight()) - (views.get("btnsearch").vw.getHeight())));
//BA.debugLineNum = 8;BA.debugLine="btnSearch.Width = 12%x"[mejn/320x480,scale=1]
views.get("btnsearch").vw.setWidth((int)((12d / 100 * width)));
//BA.debugLineNum = 9;BA.debugLine="btnSearch.Height = 12%x"[mejn/320x480,scale=1]
views.get("btnsearch").vw.setHeight((int)((12d / 100 * width)));
//BA.debugLineNum = 10;BA.debugLine="pnlDock.Left = 15%x"[mejn/320x480,scale=1]
views.get("pnldock").vw.setLeft((int)((15d / 100 * width)));
//BA.debugLineNum = 11;BA.debugLine="pnlDock.Width = 100%x - 30%x"[mejn/320x480,scale=1]
views.get("pnldock").vw.setWidth((int)((100d / 100 * width)-(30d / 100 * width)));
//BA.debugLineNum = 12;BA.debugLine="btnDock.Left = (pnlDock.Width - 32dip) / 2"[mejn/320x480,scale=1]
views.get("btndock").vw.setLeft((int)(((views.get("pnldock").vw.getWidth())-(32d * scale))/2d));
//BA.debugLineNum = 13;BA.debugLine="btnDock.Top = 0"[mejn/320x480,scale=1]
views.get("btndock").vw.setTop((int)(0d));
//BA.debugLineNum = 14;BA.debugLine="btnDock.Width = 32dip"[mejn/320x480,scale=1]
views.get("btndock").vw.setWidth((int)((32d * scale)));
//BA.debugLineNum = 15;BA.debugLine="btnDock.Height = 32dip"[mejn/320x480,scale=1]
views.get("btndock").vw.setHeight((int)((32d * scale)));
//BA.debugLineNum = 16;BA.debugLine="scvDock.Left = 0"[mejn/320x480,scale=1]
views.get("scvdock").vw.setLeft((int)(0d));
//BA.debugLineNum = 17;BA.debugLine="scvDock.Top = 7%y"[mejn/320x480,scale=1]
views.get("scvdock").vw.setTop((int)((7d / 100 * height)));
//BA.debugLineNum = 18;BA.debugLine="scvDock.Width = pnlDock.Width"[mejn/320x480,scale=1]
views.get("scvdock").vw.setWidth((int)((views.get("pnldock").vw.getWidth())));
//BA.debugLineNum = 19;BA.debugLine="scvDock.Height = pnlDock.Height - 7%y"[mejn/320x480,scale=1]
views.get("scvdock").vw.setHeight((int)((views.get("pnldock").vw.getHeight())-(7d / 100 * height)));
//BA.debugLineNum = 20;BA.debugLine="btnWidgeti.Left = pnlDock.Right + 2%x"[mejn/320x480,scale=1]
views.get("btnwidgeti").vw.setLeft((int)((views.get("pnldock").vw.getLeft() + views.get("pnldock").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 21;BA.debugLine="btnWidgeti.Bottom = 100%y - 2%y"[mejn/320x480,scale=1]
views.get("btnwidgeti").vw.setTop((int)((100d / 100 * height)-(2d / 100 * height) - (views.get("btnwidgeti").vw.getHeight())));
//BA.debugLineNum = 22;BA.debugLine="btnWidgeti.Width = 12%x"[mejn/320x480,scale=1]
views.get("btnwidgeti").vw.setWidth((int)((12d / 100 * width)));
//BA.debugLineNum = 23;BA.debugLine="btnWidgeti.Height = 12%x"[mejn/320x480,scale=1]
views.get("btnwidgeti").vw.setHeight((int)((12d / 100 * width)));
//BA.debugLineNum = 24;BA.debugLine="btnPostavke.Left = pnlDock.Right + 2%x"[mejn/320x480,scale=1]
views.get("btnpostavke").vw.setLeft((int)((views.get("pnldock").vw.getLeft() + views.get("pnldock").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 25;BA.debugLine="btnPostavke.Bottom = 100%y - 2%y - btnWidgeti.Height"[mejn/320x480,scale=1]
views.get("btnpostavke").vw.setTop((int)((100d / 100 * height)-(2d / 100 * height)-(views.get("btnwidgeti").vw.getHeight()) - (views.get("btnpostavke").vw.getHeight())));
//BA.debugLineNum = 26;BA.debugLine="btnPostavke.Width = 12%x"[mejn/320x480,scale=1]
views.get("btnpostavke").vw.setWidth((int)((12d / 100 * width)));
//BA.debugLineNum = 27;BA.debugLine="btnPostavke.Height = 12%x"[mejn/320x480,scale=1]
views.get("btnpostavke").vw.setHeight((int)((12d / 100 * width)));
//BA.debugLineNum = 28;BA.debugLine="btnNotify.Left = pnlDock.Right + 2%x"[mejn/320x480,scale=1]
views.get("btnnotify").vw.setLeft((int)((views.get("pnldock").vw.getLeft() + views.get("pnldock").vw.getWidth())+(2d / 100 * width)));
//BA.debugLineNum = 29;BA.debugLine="btnNotify.Bottom = 100%y - 2%y - btnPostavke.Height - btnWidgeti.Height"[mejn/320x480,scale=1]
views.get("btnnotify").vw.setTop((int)((100d / 100 * height)-(2d / 100 * height)-(views.get("btnpostavke").vw.getHeight())-(views.get("btnwidgeti").vw.getHeight()) - (views.get("btnnotify").vw.getHeight())));
//BA.debugLineNum = 30;BA.debugLine="btnNotify.Width = 12%x"[mejn/320x480,scale=1]
views.get("btnnotify").vw.setWidth((int)((12d / 100 * width)));
//BA.debugLineNum = 31;BA.debugLine="btnNotify.Height = 12%x"[mejn/320x480,scale=1]
views.get("btnnotify").vw.setHeight((int)((12d / 100 * width)));
//BA.debugLineNum = 32;BA.debugLine="pnlMeni.SetLeftAndRight(btnSearch.Right, btnWidgeti.Left)"[mejn/320x480,scale=1]
views.get("pnlmeni").vw.setLeft((int)((views.get("btnsearch").vw.getLeft() + views.get("btnsearch").vw.getWidth())));
views.get("pnlmeni").vw.setWidth((int)((views.get("btnwidgeti").vw.getLeft()) - ((views.get("btnsearch").vw.getLeft() + views.get("btnsearch").vw.getWidth()))));
//BA.debugLineNum = 33;BA.debugLine="pnlMeni.SetTopAndBottom(60%y, btnMeni.Top)"[mejn/320x480,scale=1]
views.get("pnlmeni").vw.setTop((int)((60d / 100 * height)));
views.get("pnlmeni").vw.setHeight((int)((views.get("btnmeni").vw.getTop()) - ((60d / 100 * height))));

}
}