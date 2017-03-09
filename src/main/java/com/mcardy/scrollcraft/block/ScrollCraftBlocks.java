package com.mcardy.scrollcraft.block;

import com.mcardy.scrollcraft.ScrollCraft;
import com.mcardy.scrollcraft.block.tile.CraftingBlockTile;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ScrollCraftBlocks {

	public static void registerBlocks() {
		registerBlock(new CraftingBlock());
		registerTileEntity(CraftingBlockTile.class, "crafting_block_tile");
	}
	
	public static void registerBlock(Block block) {
		GameRegistry.register(block, new ResourceLocation(ScrollCraft.MODID, block.getUnlocalizedName()));
		GameRegistry.register(new ItemBlock(block), new ResourceLocation(ScrollCraft.MODID, block.getUnlocalizedName()));
	}
	
	public static void registerTileEntity(Class<? extends TileEntity> cls, String id) {
		GameRegistry.registerTileEntity(cls, ScrollCraft.MODID + "_" + id);
	}
	
}
