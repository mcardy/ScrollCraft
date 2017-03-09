package com.mcardy.scrollcraft.spell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TestSpell2 implements Spell {

	@Override
	public void cast(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (worldIn.isRemote) {
			ITextComponent comp = new TextComponentString("Hello World, again!");
			playerIn.sendMessage(comp);
		}
	}

	@Override
	public SpellEssence getEssence() {
		return SpellEssence.AQUA;
	}
	
	@Override
	public String getUnlocalizedName() {
		return "test2";
	}

}
