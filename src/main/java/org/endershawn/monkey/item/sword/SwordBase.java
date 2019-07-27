package org.endershawn.monkey.item.sword;


import org.endershawn.monkey.MonkeyMod;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SwordBase extends SwordItem {
	protected String name;
	protected IItemTier tier;
	
	public SwordBase(String name, IItemTier tier, int attackDamage, float attackSpeed, Properties props) {
		super(tier, attackDamage, attackSpeed, props);
		this.name = name;
		this.tier = tier;
		setRegistryName(MonkeyMod.MODID, name);	
	}
	
	protected boolean canDestroy(BlockState s) {
		return tier.getHarvestLevel() > s.getHarvestLevel();
	}
	
	protected RayTraceResult rayTrace(World worldIn, PlayerEntity playerIn, boolean useLiquids, double dM)
    {
        float f = playerIn.rotationPitch;
        float f1 = playerIn.rotationYaw;
        double d0 = playerIn.posX;
        double d1 = playerIn.posY + (double)playerIn.getEyeHeight();
        double d2 = playerIn.posZ;
        Vec3d vec3d = new Vec3d(d0, d1, d2);
        float f2 = MathHelper.cos(-f1 * 0.017453292F - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * 0.017453292F);
        float f5 = MathHelper.sin(-f * 0.017453292F);
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d3 = playerIn.getAttribute(PlayerEntity.REACH_DISTANCE).getValue() * dM;
        Vec3d vec3d1 = vec3d.add((double)f6 * d3, (double)f5 * d3, (double)f7 * d3);
        
        RayTraceContext ctx = new RayTraceContext(
        		vec3d, vec3d1, 
        		RayTraceContext.BlockMode.OUTLINE, 
        		RayTraceContext.FluidMode.ANY, 
        		playerIn);

        return worldIn.rayTraceBlocks(ctx);
    }
}
