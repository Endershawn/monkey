package org.endershawn.monkey.item.armor;

import org.endershawn.monkey.MonkeyMod;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;

public class ItemEmeraldChestplate extends ArmorItem {
	public ItemEmeraldChestplate() {
		super(new ArmorMaterialEmerald(), EquipmentSlotType.CHEST, 
				new Item.Properties().group(ItemGroup.COMBAT));
		setRegistryName(MonkeyMod.MODID, "emerald_chestplate");
	}
}
