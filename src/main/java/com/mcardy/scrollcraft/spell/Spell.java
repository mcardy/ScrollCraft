package com.mcardy.scrollcraft.spell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public interface Spell {
	
	public void cast(World worldIn, EntityPlayer playerIn, EnumHand handIn);

	public SpellEssence getEssence();
	public String getUnlocalizedName();
	
}
