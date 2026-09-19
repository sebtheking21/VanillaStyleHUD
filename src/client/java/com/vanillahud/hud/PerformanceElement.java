package com.vanillahud.hud;
import net.minecraft.client.gui.GuiGraphicsExtractor;
public final class PerformanceElement extends HudElement{
 public PerformanceElement(){super("performance","Performance");} public int width(){return 150;} public int height(){return 30;}
 public void renderContent(GuiGraphicsExtractor g){long u=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory(),m=Runtime.getRuntime().maxMemory();int r=m==0?0:(int)(u*100L/m);g.drawString(minecraft.font,"FPS: "+minecraft.getFps(),0,0,0xFFFFFFFF,true);g.drawString(minecraft.font,"RAM: "+r+"%",0,14,0xFFE0E0E0,true);}
}
