package com.mcardy.scrollcraft.item;

import java.util.List;

import com.mcardy.scrollcraft.ScrollCraft;
import com.mcardy.scrollcraft.spell.Spell;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ScrollItem extends Item implements ICustomItemRender {
		
	private String name;
	
	public ScrollItem() {
		this.name = "scroll";
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void registerModel() {
		for (int i = 0; i < ScrollCraft.spells.getAllSpells().size(); i++)
			ScrollCraft.proxy.registerItemModel(this, "scroll", i);
	}
	
	@Override
	public String getHighlightTip(ItemStack item, String displayName) {
		TextFormatting color;
		switch (ScrollCraft.spells.getSpellById(item.getMetadata()).getEssence()) {
		case AER:
			color = TextFormatting.GRAY;
			break;
		case AQUA:
			color = TextFormatting.AQUA;
			break;
		case ENDER:
			color = TextFormatting.DARK_PURPLE;
			break;
		case NETHER:
			color = TextFormatting.DARK_RED;
			break;
		case TERRA:
			color = TextFormatting.DARK_GREEN;
			break;
		case VOID:
			color = TextFormatting.DARK_GRAY;
			break;
		default:
			color = TextFormatting.RESET;
			break;
			
		}
		return color + displayName + TextFormatting.RESET;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ScrollCraft.spells.getSpellById(playerIn.getHeldItem(handIn).getMetadata()).cast(worldIn, playerIn, handIn);
        return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
	
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "_" + ScrollCraft.spells.getSpellById(stack.getMetadata()).getUnlocalizedName();
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		List<Spell> spells = ScrollCraft.spells.getAllSpells();
		for (int i = 0; i < spells.size(); i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}
		
}
