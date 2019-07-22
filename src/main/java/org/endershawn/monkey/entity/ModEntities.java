package org.endershawn.monkey.entity;


import java.util.stream.Stream;

import org.endershawn.monkey.item.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.TieredItem;
import net.minecraft.util.math.BlockPos;


public class ModEntities {
	public static boolean isNearBlockHorizontal(Entity e, float dist) {
		BlockPos pos = e.getPosition();
		Stream<BlockPos> near = BlockPos.getAllInBox(pos.add(dist, 0, dist), pos.add(-dist, 0, -dist));

		Iterable<BlockPos> iter = near::iterator;
		for (BlockPos p: iter) {
			if (e.getEntityWorld().getBlockState(p).isSolid()) {
				return true;
			}
		}
		
		return false;
	}

	public static boolean isWearing(PlayerEntity p, IArmorMaterial m) {
		for (EquipmentSlotType slot : EquipmentSlotType.values()) {
			if (slot.getSlotType() == EquipmentSlotType.Group.ARMOR) {
				Item i = p.getItemStackFromSlot(slot).getItem();
				if (!(i instanceof ArmorItem)) {return false;}
				if (!((ArmorItem)i).getArmorMaterial().getClass().equals(m.getClass())) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean isWearingOrang(PlayerEntity p) {
		return isWearing(p, ModItems.armorMaterialOrang);
	}
	
	private static boolean isTier(Item i, IItemTier tier) {
		if (i instanceof TieredItem) {
			return ((TieredItem)i).getTier().getClass().equals(tier.getClass());
		}

		return false;
	}

	private static boolean isHoldingTier(PlayerEntity p, IItemTier tier) {
		Item main = p.getHeldItemMainhand().getItem();
		Item off = p.getHeldItemOffhand().getItem();

		return (isTier(main, tier) || isTier(off, tier));
	}
	
	public static boolean isHoldingOrang(PlayerEntity p) {
		return isHoldingTier(p, ModItems.orangTier);
	}
}
