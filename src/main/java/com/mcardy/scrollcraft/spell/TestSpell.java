package com.mcardy.scrollcraft.spell;

import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class TestSpell implements Spell {

	@Override
	public void cast(World worldIn, final EntityPlayer playerIn, EnumHand handIn) {
		if (worldIn.isRemote) {
			// Messing around
			playerIn.setNoGravity(true);
			new Timer().schedule(new TimerTask() {

				@Override
				public void run() {
					playerIn.setNoGravity(false);
				}}, 4000);
		}
	}

	@Override
	public SpellEssence getEssence() {
		return SpellEssence.ENDER;
	}
	
	@Override
	public String getUnlocalizedName() {
		return "test";
	}

}
