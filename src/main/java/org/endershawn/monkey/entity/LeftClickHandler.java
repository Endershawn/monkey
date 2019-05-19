package org.endershawn.monkey.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.LeftClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class LeftClickHandler {
	private static final float LIFT = .5f;
	private static final float MOVE = .7f;
	
	@SubscribeEvent
	public static void leftClick(LeftClickBlock event) {
		if (!(event.getEntity() instanceof EntityPlayer)) {
			return;
		}
		
		EntityPlayer player = (EntityPlayer)event.getEntity();
		
		if (ModEntities.isHoldingOrang(player)) {
			bouncePlayer(player);
		}
	}
	
	private static void bouncePlayer(EntityPlayer player) {
		double moveX, moveY, moveZ;

		if (player.rotationPitch > 70 && player.rotationPitch < 91) {
			moveX = moveZ = 0;
			moveY = MOVE;
		} else {
			Vec3i oppVec = 
					EnumFacing.fromAngle((double)player.rotationYaw)
					.getOpposite()
					.getDirectionVec();
			
			moveX = oppVec.getX() * MOVE;
			moveZ = oppVec.getZ() * MOVE;
			moveY = LIFT;
		}
		player.addVelocity(moveX, moveY, moveZ);
	}
}
