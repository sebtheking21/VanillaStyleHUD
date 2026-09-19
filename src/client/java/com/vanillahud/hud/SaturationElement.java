package com.vanillahud.hud;
import net.minecraft.client.gui.GuiGraphicsExtractor;
public final class SaturationElement extends HudElement{
 public SaturationElement(){super("saturation","Saturation");} public int width(){return 140;} public int height(){return 16;}
 public void renderContent(GuiGraphicsExtractor g){if(minecraft.player==null)return;g.drawString(minecraft.font,String.format("Saturation: %.2f",minecraft.player.getFoodData().getSaturationLevel()),0,0,0xFFFFFFFF,true);}
}
