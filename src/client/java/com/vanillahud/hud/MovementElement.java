package com.vanillahud.hud;
import net.minecraft.client.gui.GuiGraphicsExtractor;
public final class MovementElement extends HudElement{
 public MovementElement(){super("movement","Movement");} public int width(){return 135;} public int height(){return 30;}
 public void renderContent(GuiGraphicsExtractor g){if(minecraft.player==null)return;g.drawString(minecraft.font,"Sprint: "+(minecraft.player.isSprinting()?"ON":"OFF"),0,0,0xFFFFFFFF,true);g.drawString(minecraft.font,"Sneak: "+(minecraft.player.isCrouching()?"ON":"OFF"),0,14,0xFFE0E0E0,true);}
}
