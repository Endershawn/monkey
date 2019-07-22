package org.endershawn.monkey.item.armor;

import org.endershawn.monkey.MonkeyMod;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemOrangutanLegs extends ArmorItem {
	public ItemOrangutanLegs() {
		super(new ArmorMaterialOrangutan(), EquipmentSlotType.LEGS, 
				new Item.Properties().group(ItemGroup.COMBAT));
		setRegistryName(MonkeyMod.MODID, "orangutan_leggings");
	}
}
