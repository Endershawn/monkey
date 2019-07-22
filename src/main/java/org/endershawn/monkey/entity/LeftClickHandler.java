package org.endershawn.monkey.entity;

import org.endershawn.monkey.MonkeyMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class LeftClickHandler {
	private static final float LIFT = .5f;
	private static final float MOVE = 1f;
	
	@SubscribeEvent
	public static void leftClick(LeftClickBlock event) {
		if (!(event.getEntity() instanceof PlayerEntity)) {
			return;
		}
		
		MonkeyMod.LOGGER.debug("// LeftClickHandler.leftClick");
		
		PlayerEntity player = (PlayerEntity)event.getEntity();
		
		if (ModEntities.isHoldingOrang(player) && event.getEntity().getEntityWorld().isRemote) {
			MonkeyMod.LOGGER.debug("// LeftClickHandler.leftClick isHoldingOrang");

			bouncePlayer(player);
		}
	}
	
	private static void bouncePlayer(PlayerEntity player) {
		double moveX, moveY, moveZ;

		if (player.rotationPitch > 70 && player.rotationPitch < 91) {
			moveX = moveZ = 0;
			moveY = MOVE;
		} else {
			Vec3i oppVec = 
					Direction.fromAngle((double)player.rotationYaw)
					.getOpposite()
					.getDirectionVec();
			
			moveX = oppVec.getX() * MOVE;
			moveZ = oppVec.getZ() * MOVE;
			moveY = LIFT;
		}
		
		MonkeyMod.LOGGER.debug("// LeftClickHandler.bouncePlayer: (" + moveX + ", " + moveY +", " + moveZ + ")");
		player.addVelocity(moveX, moveY, moveZ);
		player.setVelocity(moveX, moveY, moveZ);
		//player.markVelocityChanged();
	}
}
