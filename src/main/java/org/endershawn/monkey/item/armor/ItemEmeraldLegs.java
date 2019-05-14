package org.endershawn.monkey.item.armor;

import org.endershawn.monkey.MonkeyMod;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemGroup;

public class ItemEmeraldLegs extends ItemArmor {
	public ItemEmeraldLegs() {
		super(new ArmorMaterialEmerald(), EntityEquipmentSlot.LEGS, 
				new Item.Properties().group(ItemGroup.COMBAT));
		setRegistryName(MonkeyMod.MODID, "emerald_leggings");
	}
}
