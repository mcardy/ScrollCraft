 package com.mcardy.scrollcraft.client;

import com.mcardy.scrollcraft.ScrollCraft;
import com.mcardy.scrollcraft.proxy.CommonProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

	public ClientProxy() {
	}
	
	@Override
	public void registerItemModel(Item item, String id, int meta) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(ScrollCraft.MODID + ":" + id, "inventory"));
	}
	
}
