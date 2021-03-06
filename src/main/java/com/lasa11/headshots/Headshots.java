package com.lasa11.headshots;



import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(modid= Headshots.modid, version=Headshots.version, name="Headshots")
public class Headshots 
{
	public static final String modid="headshots";
	public static final String version="0.3";
	
	
	public static Class EntityBullet;
	public boolean flansModLoaded=false;
	
	
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(new HitHandler());
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
		if(Loader.isModLoaded("flansmod"))
		{
				try 
				{
					if(EntityBullet==null)EntityBullet=Class.forName("com.flansmod.common.guns.EntityBullet");
					if(EntityBullet==null)EntityBullet=Class.forName("net.minecraft.src.com.flansmod.common.guns.EntityBullet");
				} catch (ClassNotFoundException e1) 
				{
					System.err.println("[Headshots]ERROR:Incompatible Flan's Mod version found!");
					e1.printStackTrace();
				}
			if(!(EntityBullet==null))flansModLoaded=true;
		}
	}
}

