package org.endershawn.monkey.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
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
    
	public static boolean isWearing(EntityPlayer p, IArmorMaterial m) {
		for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
			if (slot.getSlotType() == EntityEquipmentSlot.Type.ARMOR) {
				Item i = p.getItemStackFromSlot(slot).getItem();
				if (i instanceof ItemArmor) {
					ItemArmor ia = (ItemArmor)i;
					if (!(ia.getArmorMaterial().getClass().equals(m.getClass()))) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
