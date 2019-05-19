package org.endershawn.monkey.item.sword;

import org.endershawn.monkey.item.ModItems;

import net.minecraft.item.ItemGroup;

public class SwordOrangutan extends SwordBase {
	public SwordOrangutan() {
		super("sword_orangutan", 
			  ModItems.orangTier, 
			  3, -3.0f,
		  	  new Properties().group(ItemGroup.COMBAT).defaultMaxDamage(5));
	}
}
