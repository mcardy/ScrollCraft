package com.mcardy.scrollcraft;

import com.mcardy.scrollcraft.item.ScrollCraftItems;
import com.mcardy.scrollcraft.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name="ScrollCraft", modid = ScrollCraft.MODID, version = ScrollCraft.VERSION)
public class ScrollCraft {
	
	private static final String PACKAGE = "com.mcardy.scrollcraft";
	public static final String MODID = "scrollcraft";
	public static final String VERSION = "%VERSION%";
	
	@SidedProxy(clientSide=PACKAGE + ".client.ClientProxy", serverSide=PACKAGE + ".server.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		ScrollCraftItems.registerItems();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event ) {
		
	}
	
}
