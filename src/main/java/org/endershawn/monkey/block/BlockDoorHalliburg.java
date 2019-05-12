package org.endershawn.monkey.block;

import org.endershawn.monkey.MonkeyMod;
import org.endershawn.monkey.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDoorHalliburg extends BlockDoor {
	private static Block.Properties props = Block.Properties.create(
			Material.GLASS, MaterialColor.GRASS)
				.hardnessAndResistance(5.0F)
				.sound(SoundType.METAL);
				
	private static final String name = "door_halliburg";
	
	public BlockDoorHalliburg() {
		super(props);
		setRegistryName(MonkeyMod.MODID, name);
	}
	
	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		Boolean open = state.get(BlockDoor.OPEN);
		
		if (player.getHeldItemMainhand().getItem() == ModItems.itemKeyHal || open) {
			return super.onBlockActivated(state, worldIn, pos, player, hand, side, hitX, hitY, hitZ);
		} else {
			return false;
		}
    }

}
