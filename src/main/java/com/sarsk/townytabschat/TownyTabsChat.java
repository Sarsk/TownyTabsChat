package com.sarsk.townytabschat;

import com.sarsk.townytabschat.client.TownyTabsChatClient;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(TownyTabsChat.MODID)
public class TownyTabsChat
{
	//TODO: Thanks EMX for starter tutorial - https://emxtutorials.wordpress.com/
	
	public static final String NAME = "Towny Tabs Chat";

	public static final String MODID = "townytabschat";

	public TownyTabsChat()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::initialization);
		//FMLJavaModLoadingContext.get().getModEventBus().addListener(TownyTabsChatClient::initialization);
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new DVEvents());
		//MinecraftForge.EVENT_BUS.register(new TownyTabsChatClient());
		
		DistExecutor.runWhenOn(Dist.CLIENT, () -> () ->
		{
			FMLJavaModLoadingContext.get().getModEventBus().addListener(TownyTabsChatClient::initialization);
			MinecraftForge.EVENT_BUS.register(new TownyTabsChatClient());
		});
	}
	
	private void initialization(final FMLCommonSetupEvent event)
    {
    }

	public static ResourceLocation locate(String name)
	{
		return new ResourceLocation(MODID, name);
	}
	
	public static String find(String name)
	{
		return MODID + ":" + name;
	}
}
