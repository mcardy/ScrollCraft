package com.mcardy.scrollcraft.block;

import com.mcardy.scrollcraft.ScrollCraft;
import com.mcardy.scrollcraft.block.tile.CraftingBlockTile;
import com.mcardy.scrollcraft.client.gui.ScrollCraftGuiHandler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

// TODO Name block, currently placeholder
public class CraftingBlock extends BlockContainer {

	public CraftingBlock() {
		super(Material.ROCK);
		this.setUnlocalizedName("craftingblock");
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			playerIn.openGui(ScrollCraft.instance, ScrollCraftGuiHandler.SCROLLCRAFT_CRAFTING_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new CraftingBlockTile();
	}
	
}
