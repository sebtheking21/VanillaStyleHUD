package com.vanillahud.screen;
import com.vanillahud.VanillaStyleHudClient;
import com.vanillahud.config.HudConfig;
import com.vanillahud.hud.HudElement;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
public final class ElementSettingsScreen extends Screen{
 private final HudEditorScreen parent;private final HudElement element;private final HudConfig.ElementConfig cfg;
 public ElementSettingsScreen(HudEditorScreen p,HudElement e,HudConfig.ElementConfig c){super(Component.literal(e.title()));parent=p;element=e;cfg=c;}
 protected void init(){int x=width/2;addRenderableWidget(Button.builder(Component.literal(vis()),b->{cfg.visible=!cfg.visible;b.setMessage(Component.literal(vis()));}).bounds(x-90,70,180,20).build());addRenderableWidget(Button.builder(Component.literal(bg()),b->{cfg.background=!cfg.background;b.setMessage(Component.literal(bg()));}).bounds(x-90,96,180,20).build());addRenderableWidget(Button.builder(Component.literal(scale()),b->{cfg.scale+=.25f;if(cfg.scale>2)cfg.scale=.5f;b.setMessage(Component.literal(scale()));}).bounds(x-90,122,180,20).build());addRenderableWidget(Button.builder(Component.literal("Reset Position"),b->{cfg.x=10;cfg.y=40;}).bounds(x-90,148,180,20).build());addRenderableWidget(Button.builder(Component.literal("Done"),b->{VanillaStyleHudClient.save();minecraft.gui.setScreen(parent);}).bounds(x-90,180,180,20).build());}
 private String vis(){return "Visible: "+(cfg.visible?"ON":"OFF");}private String bg(){return "Background: "+(cfg.background?"ON":"OFF");}private String scale(){return "Scale: "+String.format("%.2fx",cfg.scale);}
 protected void extractRenderState(GuiGraphicsExtractor g,int mx,int my,float p){super.extractRenderState(g,mx,my,p);g.drawCenteredString(font,title,width/2,35,0xFFFFFFFF);g.drawCenteredString(font,Component.literal(element.title()+" settings"),width/2,50,0xFFAAAAAA);}
}
