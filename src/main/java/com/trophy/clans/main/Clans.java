package com.trophy.clans.main;

import com.trophy.clans.clansystem.ClanCommands;
import com.trophy.clans.clansystem.CoreBlockListener;
import com.trophy.clans.customarmour.ArmourListener;
import com.trophy.clans.customore.ResourcesListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Clans extends JavaPlugin
{
    private static Clans instance;
    public static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        instance = this;
        registerCMD();
        registerListeners();

    }

    @Override
    public void onDisable() {

    }


    public static Clans getInstance() {
        return instance;
    }


    private void registerCMD() {

		getCommand("clan").setExecutor(new ClanCommands());

    }

    private void registerListeners() {
        PluginManager plm = org.bukkit.Bukkit.getPluginManager();

        plm.registerEvents(new ResourcesListener(), this);
        plm.registerEvents(new ArmourListener(), this);
        plm.registerEvents(new CoreBlockListener(), this);
    }

}