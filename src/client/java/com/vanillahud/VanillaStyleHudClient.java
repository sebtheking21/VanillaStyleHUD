package com.vanillahud;
import com.mojang.blaze3d.platform.InputConstants;
import com.vanillahud.config.HudConfig;
import com.vanillahud.hud.*;
import com.vanillahud.screen.HudEditorScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
public final class VanillaStyleHudClient implements ClientModInitializer{
 public static final String MOD_ID="vanillahud"; public static final List<HudElement> ELEMENTS=new ArrayList<>(); public static HudConfig CONFIG; private static KeyMapping editorKey;
 public void onInitializeClient(){
  CONFIG=HudConfig.load(Path.of("config","vanillahud.json"));
  ELEMENTS.add(new CoordinatesElement());ELEMENTS.add(new PerformanceElement());ELEMENTS.add(new MovementElement());ELEMENTS.add(new SaturationElement());ELEMENTS.add(new ArmorStatusElement());
  editorKey=KeyBindingHelper.registerKeyBinding(new KeyMapping("key.vanillahud.open_editor",InputConstants.Type.KEYSYM,GLFW.GLFW_KEY_RIGHT_SHIFT,"category.vanillahud"));
  ClientTickEvents.END_CLIENT_TICK.register(client->{while(editorKey.consumeClick())if(client.gui.getCurrentScreen()==null)client.gui.setScreen(new HudEditorScreen());});
  HudElementRegistry.addLast(Identifier.fromNamespaceAndPath(MOD_ID,"hud"),(graphics,delta)->{if(Minecraft.getInstance().player==null)return;for(HudElement e:ELEMENTS)e.render(graphics,CONFIG.get(e.id(),10,40));});
 }
 public static void save(){CONFIG.save(Path.of("config","vanillahud.json"));}
}
