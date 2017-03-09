package com.mcardy.scrollcraft.container;

import com.mcardy.scrollcraft.block.tile.CraftingBlockTile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class CraftingBlockContainer extends Container {

	private CraftingBlockTile tile;

	public CraftingBlockContainer(IInventory player, CraftingBlockTile tile) {
		this.tile = tile;
		System.out.println(tile);
		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 3; y++) {
				this.addSlotToContainer(new Slot(tile, y + (x * 3), (x * 74) + 43, (y * 21) + 24));
			}
		}
		this.addSlotToContainer(new Slot(tile, 6, 80, 44));

		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 3; y++) {
				this.addSlotToContainer(new Slot(player, x + (y * 9) + 9, 8 + (x * 18), 120 + (y * 18)));
			}
		}
		for (int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(player, x, 8 + (x * 18), 178));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

	
	
}
