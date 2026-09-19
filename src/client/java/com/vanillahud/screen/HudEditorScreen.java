package com.vanillahud.screen;
import com.vanillahud.VanillaStyleHudClient;
import com.vanillahud.config.HudConfig;
import com.vanillahud.hud.HudElement;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
public final class HudEditorScreen extends Screen{
 private HudElement dragging;private double dx,dy;
 public HudEditorScreen(){super(Component.literal("Vanilla Style HUD"));}
 protected void init(){addRenderableWidget(Button.builder(Component.literal("Done"),b->{VanillaStyleHudClient.save();onClose();}).bounds(width-105,height-28,97,20).build());}
 protected void extractRenderState(GuiGraphicsExtractor g,int mx,int my,float delta){
  super.extractRenderState(g,mx,my,delta);g.fill(0,0,width,32,0xCC111111);g.drawCenteredString(font,Component.literal("HUD EDITOR"),width/2,8,0xFFFFFFFF);g.drawCenteredString(font,Component.literal("Drag widgets • Right-click for settings"),width/2,20,0xFFAAAAAA);
  for(HudElement e:VanillaStyleHudClient.ELEMENTS){HudConfig.ElementConfig c=VanillaStyleHudClient.CONFIG.get(e.id(),10,40);if(!c.visible)continue;e.render(g,c);if(e==dragging)g.outline((int)c.x-5,(int)c.y-4,(int)(e.width()*c.scale)+10,(int)(e.height()*c.scale)+8,0xFFFFFFFF);}
 }
 public boolean mouseClicked(net.minecraft.client.input.MouseButtonEvent e,boolean doubled){
  double x=e.x(),y=e.y();
  if(e.button()==0)for(int i=VanillaStyleHudClient.ELEMENTS.size()-1;i>=0;i--){HudElement h=VanillaStyleHudClient.ELEMENTS.get(i);HudConfig.ElementConfig c=VanillaStyleHudClient.CONFIG.get(h.id(),10,40);if(h.contains(c,x,y)){dragging=h;dx=x-c.x;dy=y-c.y;return true;}}
  if(e.button()==1)for(int i=VanillaStyleHudClient.ELEMENTS.size()-1;i>=0;i--){HudElement h=VanillaStyleHudClient.ELEMENTS.get(i);HudConfig.ElementConfig c=VanillaStyleHudClient.CONFIG.get(h.id(),10,40);if(h.contains(c,x,y)){minecraft.gui.setScreen(new ElementSettingsScreen(this,h,c));return true;}}
  return super.mouseClicked(e,doubled);
 }
 public boolean mouseDragged(net.minecraft.client.input.MouseButtonEvent e,double mx,double my){if(dragging!=null&&e.button()==0){HudConfig.ElementConfig c=VanillaStyleHudClient.CONFIG.get(dragging.id(),10,40);c.x=(float)(e.x()-dx);c.y=(float)(e.y()-dy);c.x=Math.max(0,Math.min(c.x,width-dragging.width()*c.scale));c.y=Math.max(32,Math.min(c.y,height-dragging.height()*c.scale));return true;}return super.mouseDragged(e,mx,my);}
 public boolean mouseReleased(net.minecraft.client.input.MouseButtonEvent e){if(e.button()==0&&dragging!=null){dragging=null;VanillaStyleHudClient.save();return true;}return super.mouseReleased(e);}
 public void onClose(){VanillaStyleHudClient.save();super.onClose();}
}
