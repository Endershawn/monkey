package org.endershawn.monkey.entity;

import org.endershawn.monkey.item.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemTiered;
import net.minecraft.util.math.BlockPos;

public class ModEntities {
	public static boolean isNearBlockHorizontal(Entity e, float dist) {
		BlockPos pos = e.getPosition();
		Iterable<BlockPos> near = BlockPos.getAllInBox(pos.add(dist, 0, dist), pos.add(-dist, 0, -dist));

		for (BlockPos p : near) {
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
				if (!(i instanceof ItemArmor)) {return false;}
				if (!((ItemArmor)i).getArmorMaterial().getClass().equals(m.getClass())) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isWearingOrang(EntityPlayer p) {
		return isWearing(p, ModItems.armorMaterialOrang);
	}
	
	private static boolean isTier(Item i, IItemTier tier) {
		if (i instanceof ItemTiered) {
			return ((ItemTiered)i).getTier().getClass().equals(tier.getClass());
		}

		return false;
	}

	private static boolean isHoldingTier(EntityPlayer p, IItemTier tier) {
		Item main = p.getHeldItemMainhand().getItem();
		Item off = p.getHeldItemOffhand().getItem();

		return (isTier(main, tier) || isTier(off, tier));
	}
	
	public static boolean isHoldingOrang(EntityPlayer p) {
		return isHoldingTier(p, ModItems.orangTier);
	}
}
