package org.endershawn.monkey.item.sword;

import org.endershawn.monkey.item.ModItems;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.Vec3i;

public class SwordOrangutan extends SwordBase {
	private static final float LIFT = .5f;
	private static final float MOVE = .75f;
	
	public SwordOrangutan() {
		super("sword_orangutan", 
			  ModItems.orangTier, 
			  3, 1.0f,
		  	  new Properties().group(ItemGroup.COMBAT));
	}
	
	@Override
   public ActionResultType onItemUse(ItemUseContext context) {
		if (context.getWorld().isRemote) {
			bouncePlayer(context.getPlayer());
			return ActionResultType.SUCCESS;
		}
		
      return ActionResultType.PASS;
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
		
		player.addVelocity(moveX, moveY, moveZ);
	}
}
