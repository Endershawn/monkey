package org.endershawn.monkey.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;

public class ModEntities {
    public static boolean isNearBlockHorizontal(Entity e, float dist) {
    	BlockPos pos = e.getPosition();
    	Iterable<BlockPos> near = BlockPos.getAllInBox(pos.add(dist, 0, dist), pos.add(-dist, 0, -dist));
    	
    	for (BlockPos p: near) {
    		if (e.getEntityWorld().getBlockState(p).isBlockNormalCube()) {
    			return true;
    		}
    	}
    	
    	return false;
    }
}
