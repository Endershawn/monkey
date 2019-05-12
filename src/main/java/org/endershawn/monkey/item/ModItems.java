package org.endershawn.monkey.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.endershawn.item.sword.SwordBase;
import org.endershawn.monkey.MonkeyMod;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = MonkeyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
	private static final Logger LOGGER = LogManager.getLogger();
	public static SwordBase swordOrang = new SwordBase(
			"sword_orangutan", 
			ItemTier.STONE, 
			new Properties().group(ItemGroup.COMBAT), 
			100, 3);
	
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	LOGGER.info("Registering Items");
        event.getRegistry().registerAll(
        		swordOrang
		);
    }
}
