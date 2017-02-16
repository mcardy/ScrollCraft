package com.mcardy.scrollcraft.item;

import com.mcardy.scrollcraft.ScrollCraft;

import net.minecraft.item.Item;

public class ScrollItem extends ItemBase implements ICustomItemRender {
		
	public ScrollItem() {
		super("scroll");
	}
	
	@Override
	public void registerModel() {
		ScrollCraft.proxy.registerItemModel(this, "scroll");
	}
	
}
