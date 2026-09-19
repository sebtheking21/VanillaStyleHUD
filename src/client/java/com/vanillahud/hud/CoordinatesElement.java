package com.vanillahud.hud;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
public final class CoordinatesElement extends HudElement{
 public CoordinatesElement(){super("coordinates","Coordinates");} public int width(){return 190;} public int height(){return 45;}
 public void renderContent(GuiGraphicsExtractor g){if(minecraft.player==null||minecraft.level==null)return;BlockPos p=minecraft.player.blockPosition();String b=minecraft.level.getBiome(p).unwrapKey().map(ResourceKey::location).map(Object::toString).orElse("unknown");g.drawString(minecraft.font,"XYZ: %d %d %d".formatted(p.getX(),p.getY(),p.getZ()),0,0,0xFFFFFFFF,true);g.drawString(minecraft.font,"Facing: "+minecraft.player.getDirection().getName(),0,14,0xFFE0E0E0,true);g.drawString(minecraft.font,"Biome: "+b,0,28,0xFFE0E0E0,true);}
}
