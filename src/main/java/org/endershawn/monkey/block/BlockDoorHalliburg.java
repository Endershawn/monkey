package org.endershawn.monkey.block;

import org.endershawn.monkey.MonkeyMod;
import org.endershawn.monkey.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class BlockDoorHalliburg extends DoorBlock {
	private static Block.Properties props = Block.Properties.create(
			Material.GLASS, MaterialColor.GRASS)
				.hardnessAndResistance(Float.MAX_VALUE)
				.sound(SoundType.METAL);
				
	private static final String name = "door_halliburg";
	
	public BlockDoorHalliburg() {
		super(props);
		setRegistryName(MonkeyMod.MODID, name);
	}
	
	@Override
	   public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

		Boolean open = state.get(DoorBlock.OPEN);
		
		if (player.getHeldItemMainhand().getItem() == ModItems.itemKeyHal || open) {
			return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
		} else {
			return false;
		}
    }

}
