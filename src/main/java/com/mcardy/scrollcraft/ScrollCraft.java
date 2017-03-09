package com.mcardy.scrollcraft;

import com.mcardy.scrollcraft.block.ScrollCraftBlocks;
import com.mcardy.scrollcraft.client.gui.ScrollCraftGuiHandler;
import com.mcardy.scrollcraft.item.ScrollCraftItems;
import com.mcardy.scrollcraft.proxy.CommonProxy;
import com.mcardy.scrollcraft.spell.SpellManager;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(name="ScrollCraft", modid = ScrollCraft.MODID, version = ScrollCraft.VERSION)
public class ScrollCraft {
	
	public static final String PACKAGE = "com.mcardy.scrollcraft";
	public static final String MODID = "scrollcraft";
	public static final String VERSION = "%VERSION%";
	
	@SidedProxy(clientSide=PACKAGE + ".client.ClientProxy", serverSide=PACKAGE + ".server.ServerProxy")
	public static CommonProxy proxy;
	public static ScrollCraft instance;
	public static SpellManager spells;
	
	public ScrollCraft() {
		ScrollCraft.instance = this;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		spells = new SpellManager();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		ScrollCraftItems.registerItems();
		ScrollCraftBlocks.registerBlocks();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ScrollCraftGuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event ) {
		
	}
	
}
