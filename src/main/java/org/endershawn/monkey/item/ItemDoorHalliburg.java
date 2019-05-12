package org.endershawn.monkey.item;

import org.endershawn.monkey.MonkeyMod;
import org.endershawn.monkey.block.ModBlocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;

public class ItemDoorHalliburg extends ItemBlock {
	private static String name = "item_door_halliburg";
	private static Item.Properties props = new Item.Properties()
			.group(ItemGroup.REDSTONE);
	
	public ItemDoorHalliburg() {
		super(ModBlocks.doorHal, props);
		setRegistryName(MonkeyMod.MODID, name);
		// TODO Auto-generated constructor stub
	}

}
