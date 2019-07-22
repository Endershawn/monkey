package org.endershawn.monkey.item.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArmorMaterialOrangutan implements IArmorMaterial {
	private String name;
	private int maxDamageFactor;
	private int[] damageReductionAmountArray;
	private int enchantability;
	private SoundEvent soundEvent;
	private float toughness;
	private LazyLoadBase<Ingredient> repairMaterial;
	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 13, 15, 16, 11 };

	public ArmorMaterialOrangutan() {
        /**
         * Holds the damage reduction (each 1 points is half a shield on gui) 
         * of each piece of armor (helmet, plate, legs and boots)
         */
		this.damageReductionAmountArray = new int[] { 2, 3, 4, 2 };
		this.name = "monkey:orangutan";
		this.maxDamageFactor = 33;
		this.enchantability = 10;
		this.soundEvent = SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
		this.toughness = 2;
//		this.repairMaterial = new LazyLoadBase<>(() -> {
//			return Ingredient.fromItems(Items.POTATO);
//		});
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	public Ingredient getRepairMaterial() {
		return (Ingredient) this.repairMaterial.getValue();
	}

	@OnlyIn(Dist.CLIENT)
	public String getName() {
		return this.name;
	}

	public float getToughness() {
		return this.toughness;
	}

}