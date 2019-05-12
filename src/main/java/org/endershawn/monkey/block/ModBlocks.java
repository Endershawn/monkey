package org.endershawn.monkey.block;

import org.endershawn.monkey.MonkeyMod;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MonkeyMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
	public static final BlockDoorHalliburg doorHal = new BlockDoorHalliburg();
	
  @SubscribeEvent
  public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
      // register a new block here
      MonkeyMod.LOGGER.info("HELLO from Register Block");
      
      blockRegistryEvent.getRegistry().registerAll(
    		  doorHal
      );
  }
}
