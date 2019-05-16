package org.endershawn.monkey.item.armor;

import org.endershawn.monkey.MonkeyMod;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemGroup;

public class ItemOrangutanBoots extends ItemArmor {
	public ItemOrangutanBoots() {
		super(new ArmorMaterialOrangutan(), EntityEquipmentSlot.FEET, 
				new Item.Properties().group(ItemGroup.COMBAT));
		setRegistryName(MonkeyMod.MODID, "orangutan_boots");
	}
}
