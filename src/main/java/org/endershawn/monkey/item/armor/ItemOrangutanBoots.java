package org.endershawn.monkey.item.armor;

import org.endershawn.monkey.MonkeyMod;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemOrangutanBoots extends ArmorItem {
	public ItemOrangutanBoots() {
		super(new ArmorMaterialOrangutan(), EquipmentSlotType.FEET, 
				new Item.Properties().group(ItemGroup.COMBAT));
		setRegistryName(MonkeyMod.MODID, "orangutan_boots");
	}
}
