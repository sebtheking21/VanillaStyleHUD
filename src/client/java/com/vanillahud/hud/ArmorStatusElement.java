package com.vanillahud.hud;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
public final class ArmorStatusElement extends HudElement{
 public ArmorStatusElement(){super("armor","Armor Status");} public int width(){return 160;} public int height(){return 22;}
 public void renderContent(GuiGraphicsExtractor g){if(minecraft.player==null)return;EquipmentSlot[] s={EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET};int x=0;for(EquipmentSlot slot:s){ItemStack st=minecraft.player.getItemBySlot(slot);g.renderItem(st,x,0);if(!st.isEmpty()&&st.isDamageableItem())g.drawString(minecraft.font,Integer.toString(st.getMaxDamage()-st.getDamageValue()),x+17,9,0xFFFFFFFF,true);x+=38;}}
}
