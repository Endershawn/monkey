package org.endershawn.monkey.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FallHandler {
	private static final float ORANG_LIMIT = 10f;
	
	@SubscribeEvent
	public static void hurt(LivingHurtEvent event) {
		if (event.getSource() == DamageSource.FALL && event.getEntity() instanceof EntityPlayer) {
			if (ModEntities.isWearingOrang((EntityPlayer)event.getEntity())) {
				float amount = event.getAmount();
				
				if (amount < ORANG_LIMIT) {
					event.setCanceled(true);
				} else {
					event.setAmount(event.getAmount() / 2);
				}
			}
		}
	}
}
