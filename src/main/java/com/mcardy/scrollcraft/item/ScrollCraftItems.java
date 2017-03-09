package com.mcardy.scrollcraft.item;

import com.mcardy.scrollcraft.ScrollCraft;
import com.mcardy.scrollcraft.spell.Spell;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ScrollCraftItems {

	public static void registerItems() {
		registerItem(new ScrollItem());
	}
	
	private static void registerItem(Item item) {
		GameRegistry.register(item);
		if (item instanceof ICustomItemRender)
			((ICustomItemRender) item).registerModel();
	}
	
}
