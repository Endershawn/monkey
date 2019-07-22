package org.endershawn.monkey.entity;

import org.endershawn.monkey.item.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
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
	
	@SubscribeEvent
	public static void climb(LivingUpdateEvent event) {
		if (!(event.getEntity() instanceof PlayerEntity)) {
			return;
		}
		
		PlayerEntity player = (PlayerEntity)event.getEntity();
		
		if (!isWearingOrang(player)) {
			return;
		}
				
		if (isHoldingOn(player)) {
			player.setMotion(Vec3d.ZERO);
			player.velocityChanged = true;
			player.fallDistance = MIN_HEIGHT;
		} else if (player.collidedHorizontally){
			if (player.rotationPitch < 0) {
				player.setMotion(player.getMotion().add(new Vec3d(0, UP_SPEED, 0)));
			} else  {
				player.setMotion(player.getMotion().add(new Vec3d(0, -DOWN_SPEED, 0)));
			}
		}
	}
	
	private static boolean isWearingOrang(PlayerEntity player) {
		return ModEntities.isWearing(player, ModItems.armorMaterialOrang);
	}
	
    private static boolean isHoldingOn(PlayerEntity player) {
		return !player.collidedHorizontally && 
			   !player.onGround && 
			   player.fallDistance >= MIN_HEIGHT && 
			   ModEntities.isNearBlockHorizontal(player, REACH) &&
			   !KEY_FALL.isKeyDown();
    }
}
