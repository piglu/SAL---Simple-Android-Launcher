package com.no3dlauncher.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_opt{

public static void LS_320x480_1(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
views.get("btnbackground").vw.setLeft((int)(0d));
views.get("btnbackground").vw.setTop((int)(0d));
views.get("btnbackground").vw.setWidth((int)((50d / 100 * width)));
views.get("btnbackground").vw.setHeight((int)((40d * scale)));
views.get("btnfont").vw.setLeft((int)((views.get("btnbackground").vw.getLeft() + views.get("btnbackground").vw.getWidth())));
views.get("btnfont").vw.setTop((int)(0d));
views.get("btnfont").vw.setWidth((int)((50d / 100 * width)));
views.get("btnfont").vw.setHeight((int)((40d * scale)));
views.get("label1").vw.setLeft((int)(0d));
views.get("label1").vw.setTop((int)((views.get("btnbackground").vw.getTop() + views.get("btnbackground").vw.getHeight())));
views.get("label1").vw.setWidth((int)((100d / 100 * width)));
views.get("label1").vw.setHeight((int)((40d * scale)));
views.get("label5").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())));
views.get("label5").vw.setLeft((int)(0d));
views.get("label5").vw.setWidth((int)((120d * scale)));
views.get("label5").vw.setHeight((int)((40d * scale)));
views.get("sbtransparent").vw.setLeft((int)((views.get("label5").vw.getLeft() + views.get("label5").vw.getWidth())));
views.get("sbtransparent").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())));
views.get("sbtransparent").vw.setWidth((int)((100d / 100 * width)-(views.get("label5").vw.getWidth())));
views.get("sbtransparent").vw.setHeight((int)((40d * scale)));
views.get("label2").vw.setLeft((int)(0d));
views.get("label2").vw.setTop((int)((views.get("label5").vw.getTop() + views.get("label5").vw.getHeight())));
views.get("label2").vw.setWidth((int)((100d * scale)));
views.get("label2").vw.setHeight((int)((40d * scale)));
views.get("spnapps").vw.setLeft((int)((views.get("label2").vw.getLeft() + views.get("label2").vw.getWidth())));
views.get("spnapps").vw.setTop((int)((views.get("label5").vw.getTop() + views.get("label5").vw.getHeight())));
views.get("spnapps").vw.setWidth((int)((100d / 100 * width)-(views.get("label2").vw.getWidth())));
views.get("spnapps").vw.setHeight((int)((40d * scale)));
views.get("label3").vw.setLeft((int)(0d));
views.get("label3").vw.setTop((int)((views.get("label2").vw.getTop() + views.get("label2").vw.getHeight())));
views.get("label3").vw.setWidth((int)((100d * scale)));
//BA.debugLineNum = 33;BA.debugLine="Label3.Height = 40dip"[opt/320x480,scale=1]
views.get("label3").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 34;BA.debugLine="spnFont.Left = Label3.Right"[opt/320x480,scale=1]
views.get("spnfont").vw.setLeft((int)((views.get("label3").vw.getLeft() + views.get("label3").vw.getWidth())));
//BA.debugLineNum = 35;BA.debugLine="spnFont.Top = spnApps.Bottom"[opt/320x480,scale=1]
views.get("spnfont").vw.setTop((int)((views.get("spnapps").vw.getTop() + views.get("spnapps").vw.getHeight())));
//BA.debugLineNum = 36;BA.debugLine="spnFont.Width = 100%x - Label3.Width"[opt/320x480,scale=1]
views.get("spnfont").vw.setWidth((int)((100d / 100 * width)-(views.get("label3").vw.getWidth())));
//BA.debugLineNum = 37;BA.debugLine="spnFont.Height = 40dip"[opt/320x480,scale=1]
views.get("spnfont").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 38;BA.debugLine="Label4.Left = 0"[opt/320x480,scale=1]
views.get("label4").vw.setLeft((int)(0d));
//BA.debugLineNum = 39;BA.debugLine="Label4.Top = spnFont.Bottom"[opt/320x480,scale=1]
views.get("label4").vw.setTop((int)((views.get("spnfont").vw.getTop() + views.get("spnfont").vw.getHeight())));
//BA.debugLineNum = 40;BA.debugLine="Label4.Width = 100dip"[opt/320x480,scale=1]
views.get("label4").vw.setWidth((int)((100d * scale)));
//BA.debugLineNum = 41;BA.debugLine="Label4.Height = 40dip"[opt/320x480,scale=1]
views.get("label4").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 42;BA.debugLine="edtFontSize.Left = Label4.Right"[opt/320x480,scale=1]
views.get("edtfontsize").vw.setLeft((int)((views.get("label4").vw.getLeft() + views.get("label4").vw.getWidth())));
//BA.debugLineNum = 43;BA.debugLine="edtFontSize.Top = spnFont.Bottom"[opt/320x480,scale=1]
views.get("edtfontsize").vw.setTop((int)((views.get("spnfont").vw.getTop() + views.get("spnfont").vw.getHeight())));
//BA.debugLineNum = 44;BA.debugLine="edtFontSize.Width = 100%x - Label4.Width"[opt/320x480,scale=1]
views.get("edtfontsize").vw.setWidth((int)((100d / 100 * width)-(views.get("label4").vw.getWidth())));
//BA.debugLineNum = 45;BA.debugLine="edtFontSize.Height = 40dip"[opt/320x480,scale=1]
views.get("edtfontsize").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 46;BA.debugLine="Label6.Left = 0"[opt/320x480,scale=1]
views.get("label6").vw.setLeft((int)(0d));
//BA.debugLineNum = 47;BA.debugLine="Label6.Top = Label4.Bottom"[opt/320x480,scale=1]
views.get("label6").vw.setTop((int)((views.get("label4").vw.getTop() + views.get("label4").vw.getHeight())));
//BA.debugLineNum = 48;BA.debugLine="Label6.Width = 100dip"[opt/320x480,scale=1]
views.get("label6").vw.setWidth((int)((100d * scale)));
//BA.debugLineNum = 49;BA.debugLine="Label6.Height = 40dip"[opt/320x480,scale=1]
views.get("label6").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 50;BA.debugLine="spnIconType.Left = Label6.Right"[opt/320x480,scale=1]
views.get("spnicontype").vw.setLeft((int)((views.get("label6").vw.getLeft() + views.get("label6").vw.getWidth())));
//BA.debugLineNum = 51;BA.debugLine="spnIconType.Top = Label4.Bottom"[opt/320x480,scale=1]
views.get("spnicontype").vw.setTop((int)((views.get("label4").vw.getTop() + views.get("label4").vw.getHeight())));
//BA.debugLineNum = 52;BA.debugLine="spnIconType.Width = 100%x - Label6.Width"[opt/320x480,scale=1]
views.get("spnicontype").vw.setWidth((int)((100d / 100 * width)-(views.get("label6").vw.getWidth())));
//BA.debugLineNum = 53;BA.debugLine="spnIconType.Height = 40dip"[opt/320x480,scale=1]
views.get("spnicontype").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 54;BA.debugLine="Label8.Left = 0"[opt/320x480,scale=1]
views.get("label8").vw.setLeft((int)(0d));
//BA.debugLineNum = 55;BA.debugLine="Label8.Top = Label7.Bottom"[opt/320x480,scale=1]
views.get("label8").vw.setTop((int)((views.get("label7").vw.getTop() + views.get("label7").vw.getHeight())));
//BA.debugLineNum = 56;BA.debugLine="Label8.Width = 100dip"[opt/320x480,scale=1]
views.get("label8").vw.setWidth((int)((100d * scale)));
//BA.debugLineNum = 57;BA.debugLine="Label8.Height = 40dip"[opt/320x480,scale=1]
views.get("label8").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 58;BA.debugLine="edtPages.Left = Label8.Right"[opt/320x480,scale=1]
views.get("edtpages").vw.setLeft((int)((views.get("label8").vw.getLeft() + views.get("label8").vw.getWidth())));
//BA.debugLineNum = 59;BA.debugLine="edtPages.Top = edtNoOfStarPoints.Bottom"[opt/320x480,scale=1]
views.get("edtpages").vw.setTop((int)((views.get("edtnoofstarpoints").vw.getTop() + views.get("edtnoofstarpoints").vw.getHeight())));
//BA.debugLineNum = 60;BA.debugLine="edtPages.Width = 100%x - Label8.Width"[opt/320x480,scale=1]
views.get("edtpages").vw.setWidth((int)((100d / 100 * width)-(views.get("label8").vw.getWidth())));
//BA.debugLineNum = 61;BA.debugLine="edtPages.Height = 40dip"[opt/320x480,scale=1]
views.get("edtpages").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 62;BA.debugLine="Label9.Left = 0"[opt/320x480,scale=1]
views.get("label9").vw.setLeft((int)(0d));
//BA.debugLineNum = 63;BA.debugLine="Label9.Top = Label8.Bottom"[opt/320x480,scale=1]
views.get("label9").vw.setTop((int)((views.get("label8").vw.getTop() + views.get("label8").vw.getHeight())));
//BA.debugLineNum = 64;BA.debugLine="Label9.Width = 100dip"[opt/320x480,scale=1]
views.get("label9").vw.setWidth((int)((100d * scale)));
//BA.debugLineNum = 65;BA.debugLine="Label9.Height = 40dip"[opt/320x480,scale=1]
views.get("label9").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 66;BA.debugLine="spnAnim.Left = Label9.Right"[opt/320x480,scale=1]
views.get("spnanim").vw.setLeft((int)((views.get("label9").vw.getLeft() + views.get("label9").vw.getWidth())));
//BA.debugLineNum = 67;BA.debugLine="spnAnim.Top = edtPages.Bottom"[opt/320x480,scale=1]
views.get("spnanim").vw.setTop((int)((views.get("edtpages").vw.getTop() + views.get("edtpages").vw.getHeight())));
//BA.debugLineNum = 68;BA.debugLine="spnAnim.Width = 100%x - Label9.Width"[opt/320x480,scale=1]
views.get("spnanim").vw.setWidth((int)((100d / 100 * width)-(views.get("label9").vw.getWidth())));
//BA.debugLineNum = 69;BA.debugLine="spnAnim.Height = 40dip"[opt/320x480,scale=1]
views.get("spnanim").vw.setHeight((int)((40d * scale)));
//BA.debugLineNum = 71;BA.debugLine="btnEnableNotifications.Left = 0"[opt/320x480,scale=1]
views.get("btnenablenotifications").vw.setLeft((int)(0d));
//BA.debugLineNum = 72;BA.debugLine="btnEnableNotifications. top = Label4.Bottom"[opt/320x480,scale=1]
views.get("btnenablenotifications").vw.setTop((int)((views.get("label4").vw.getTop() + views.get("label4").vw.getHeight())));
//BA.debugLineNum = 73;BA.debugLine="btnEnableNotifications.Width = 100%x"[opt/320x480,scale=1]
views.get("btnenablenotifications").vw.setWidth((int)((100d / 100 * width)));
//BA.debugLineNum = 74;BA.debugLine="btnEnableNotifications.Height = 40dip"[opt/320x480,scale=1]
views.get("btnenablenotifications").vw.setHeight((int)((40d * scale)));

}
public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);

}
}