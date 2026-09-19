package com.vanillahud.hud;
import com.vanillahud.config.HudConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.joml.Matrix3x2fStack;
public abstract class HudElement {
 protected final Minecraft minecraft=Minecraft.getInstance(); private final String id,title;
 protected HudElement(String id,String title){this.id=id;this.title=title;}
 public String id(){return id;} public String title(){return title;} public abstract int width(); public abstract int height(); public abstract void renderContent(GuiGraphicsExtractor g);
 public void render(GuiGraphicsExtractor g,HudConfig.ElementConfig c){if(!c.visible)return;Matrix3x2fStack p=g.pose();p.pushMatrix();p.translate(c.x,c.y);p.scale(c.scale,c.scale);if(c.background){g.fill(-4,-3,width()+4,height()+3,0x99000000);g.fill(-4,-3,width()+4,-2,0xFFFFFFFF);}renderContent(g);p.popMatrix();}
 public boolean contains(HudConfig.ElementConfig c,double x,double y){return x>=c.x&&x<=c.x+width()*c.scale&&y>=c.y&&y<=c.y+height()*c.scale;}
}
