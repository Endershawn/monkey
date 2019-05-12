package org.endershawn.monkey.entity;

import org.endershawn.monkey.item.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ClimbHandler {
	private static final int MIN_HEIGHT = 3;
	private static final int REACH = 1;
	private static final float UP_SPEED = 0.3f;
	private static final float DOWN_SPEED = 0.2f;
	private static final KeyBinding KEY_FALL = Minecraft.getInstance().gameSettings.keyBindJump;
	private static final Item TOTEM = ModItems.swordOrang;
	
	@SubscribeEvent
	public static void climb(LivingUpdateEvent event) {
		if (!(event.getEntity() instanceof EntityPlayer)) {
			return;
		}
		
		EntityPlayer player = (EntityPlayer)event.getEntity();
		
		if (!(player.getHeldItemMainhand().getItem() == TOTEM)) {
			return;
		}

		if (isHoldingOn(player)) {
			player.motionY = 0;
			player.velocityChanged = true;
			player.fallDistance = MIN_HEIGHT;
		} else if (player.collidedHorizontally){
			if (player.rotationPitch < 0) {
				player.motionY = UP_SPEED;
			} else  {
				player.motionY = -DOWN_SPEED;
		}
		}
	}
	
    private static boolean isHoldingOn(EntityPlayer player) {
		return !player.collidedHorizontally && 
			   !player.onGround && 
			   player.fallDistance >= MIN_HEIGHT && 
			   ModEntities.isNearBlockHorizontal(player, REACH) &&
			   !KEY_FALL.isKeyDown();
    }
}
