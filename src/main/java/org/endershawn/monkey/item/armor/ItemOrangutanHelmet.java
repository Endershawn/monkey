package org.endershawn.monkey.item.armor;

import org.endershawn.monkey.MonkeyMod;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemGroup;

public class ItemOrangutanHelmet extends ItemArmor {
	public ItemOrangutanHelmet() {
		super(new ArmorMaterialOrangutan(), EntityEquipmentSlot.HEAD, 
				new Item.Properties().group(ItemGroup.COMBAT));
		setRegistryName(MonkeyMod.MODID, "orangutan_helmet");
	}
}
