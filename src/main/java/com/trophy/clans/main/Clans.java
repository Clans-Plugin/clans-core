package com.trophy.clans.main;

import org.bukkit.plugin.java.JavaPlugin;

public class Clans extends JavaPlugin
{
	private static Clans instance;
	
	@Override
	public void onEnable()
	{
		instance = this;
	}
	
	@Override
	public void onDisable()
	{
		
	}
	
	
	public static Clans getInstance()
	{
		return instance;
	}

}
