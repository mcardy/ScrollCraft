package com.mcardy.scrollcraft.proxy;

import net.minecraft.item.Item;

public abstract class CommonProxy {

	public void registerItemModel(Item item, String id) {
		this.registerItemModel(item, id, 0);
	}
	
	public abstract void registerItemModel(Item item, String id, int meta);
	
	
	
}
