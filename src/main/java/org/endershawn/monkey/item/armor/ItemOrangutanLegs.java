package org.endershawn.monkey.item.armor;

import org.endershawn.monkey.MonkeyMod;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemGroup;

public class ItemOrangutanLegs extends ItemArmor {
	public ItemOrangutanLegs() {
		super(new ArmorMaterialOrangutan(), EntityEquipmentSlot.LEGS, 
				new Item.Properties().group(ItemGroup.COMBAT));
		setRegistryName(MonkeyMod.MODID, "orangutan_leggings");
	}
}
