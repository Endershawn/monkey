package org.endershawn.monkey.item;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.endershawn.item.sword.SwordBase;
import org.endershawn.monkey.MonkeyMod;
import org.endershawn.monkey.item.armor.ItemEmeraldBoots;
import org.endershawn.monkey.item.armor.ItemEmeraldChestplate;
import org.endershawn.monkey.item.armor.ItemEmeraldHelmet;
import org.endershawn.monkey.item.armor.ItemEmeraldLegs;

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
	
	/** Orangutan Equipment **/
	public static SwordBase swordOrang = new SwordBase(
			"sword_orangutan", 
			ItemTier.WOOD, 
			new Properties().group(ItemGroup.COMBAT).defaultMaxDamage(10), 
			100, 10);
	
	/** Halliburg Door and Key **/
	public static ItemDoorHalliburg itemDoorHal = new ItemDoorHalliburg();
	public static Item itemKeyHal = new Item(
			new Item.Properties()
				.group(ItemGroup.REDSTONE))
					.setRegistryName("key_halliburg");
	
	/** Emerald Equipment **/
	private static ItemEmeraldChestplate armorEmeraldChest = new ItemEmeraldChestplate();
	private static ItemEmeraldHelmet armorEmeraldHelmit = new ItemEmeraldHelmet();
	private static ItemEmeraldBoots armorEmeraldBoots = new ItemEmeraldBoots();
	private static ItemEmeraldLegs armorEmeraldLegs = new ItemEmeraldLegs();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
    	LOGGER.info("HELLO from register items");
        event.getRegistry().registerAll(
        		swordOrang,
        		
        		itemDoorHal,
        		itemKeyHal,
        		
        		armorEmeraldChest,
        		armorEmeraldHelmit,
        		armorEmeraldBoots,
        		armorEmeraldLegs
		);
    }
}
