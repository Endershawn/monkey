package org.endershawn.monkey.item;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;


public class OrangutanTier implements IItemTier {	
	   /** The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = WOOD/GOLD) */
	   private final int harvestLevel;
	   /** The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32) */
	   private final int maxUses;
	   /** The strength of this tool material against blocks which it is effective against. */
	   private final float efficiency;
	   /** Damage versus entities. */
	   private final float attackDamage;
	   /** Defines the natural enchantability factor of the material. */
	   private final int enchantability;
	   private final LazyLoadBase<Ingredient> repairMaterial;

	   OrangutanTier() {
		  Supplier<Ingredient> i = () -> Ingredient.fromItems(Items.STONE_SWORD);
		  
	      this.harvestLevel = 2;
	      this.maxUses = 500;
	      this.efficiency = 5.0f;
	      this.attackDamage = 3.0f;
	      this.enchantability = 10;
	      this.repairMaterial = new LazyLoadBase<Ingredient>(i);
	   }

	   @Override
	   public int getMaxUses() {
	      return this.maxUses;
	   }
	   @Override
	   public float getEfficiency() {
	      return this.efficiency;
	   }
	   @Override
	   public float getAttackDamage() {
	      return this.attackDamage;
	   }
	   @Override
	   public int getHarvestLevel() {
	      return this.harvestLevel;
	   }
	   @Override
	   public int getEnchantability() {
	      return this.enchantability;
	   }
	   @Override
	   public Ingredient getRepairMaterial() {
	      return this.repairMaterial.getValue();
	   }
}
