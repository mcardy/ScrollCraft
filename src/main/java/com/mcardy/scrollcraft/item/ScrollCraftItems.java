package com.mcardy.scrollcraft.item;

import com.mcardy.scrollcraft.ScrollCraft;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ScrollCraftItems {

	public static void registerItems() {
		registerItem(new ScrollItem());
	}
	
	private static void registerItem(ItemBase item) {
		System.out.println(item);
		GameRegistry.register(item);
		if (item instanceof ICustomItemRender)
			((ICustomItemRender) item).registerModel();
	}
	
}
