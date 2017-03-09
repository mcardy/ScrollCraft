package com.mcardy.scrollcraft.client.gui;

import com.mcardy.scrollcraft.ScrollCraft;
import com.mcardy.scrollcraft.block.tile.CraftingBlockTile;
import com.mcardy.scrollcraft.container.CraftingBlockContainer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class CraftingBlockGui extends GuiContainer {

	public CraftingBlockGui(IInventory playerInv, CraftingBlockTile tile) {
		super(new CraftingBlockContainer(playerInv, tile));
		this.xSize = 176;
		this.ySize = 201;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.mc.renderEngine.bindTexture(new ResourceLocation(ScrollCraft.MODID + ":textures/gui/scroll-gui.png"));
		this.drawTexturedModalRect(this.width/2-this.xSize/2, this.height/2-this.ySize/2,0, 0, xSize, ySize);
	}

}
