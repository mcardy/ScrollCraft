package com.mcardy.scrollcraft.client.gui;

import com.mcardy.scrollcraft.block.tile.CraftingBlockTile;
import com.mcardy.scrollcraft.container.CraftingBlockContainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ScrollCraftGuiHandler implements IGuiHandler {

	public static final int SCROLLCRAFT_CRAFTING_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == SCROLLCRAFT_CRAFTING_GUI) {
			TileEntity tile;
			if ((tile = world.getTileEntity(new BlockPos(x,y,z))) instanceof CraftingBlockTile) {
				return new CraftingBlockContainer(player.inventory, (CraftingBlockTile) world.getTileEntity(new BlockPos(x,y,z)));
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == SCROLLCRAFT_CRAFTING_GUI) {
			TileEntity tile;
			if ((tile = world.getTileEntity(new BlockPos(x,y,z))) instanceof CraftingBlockTile) {
				return new CraftingBlockGui(player.inventory, (CraftingBlockTile) world.getTileEntity(new BlockPos(x,y,z)));
			}
		}
		return null;
	}

}
