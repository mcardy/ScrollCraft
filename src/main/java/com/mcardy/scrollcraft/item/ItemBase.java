package com.mcardy.scrollcraft.item;

import net.minecraft.item.Item;

public class ItemBase extends Item {

	protected String name;
	
	public ItemBase(String name) {
		super();
		this.name = name;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	
	public String getName() {
		return this.name;
	}
	
}
