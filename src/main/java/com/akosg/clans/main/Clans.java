package com.akosg.clans.main;

import com.akosg.clans.clansystem.ChatListener;
import com.akosg.clans.clansystem.ClanCommands;
import com.akosg.clans.clansystem.CoreBlockListener;
import com.akosg.clans.clansystem.ExplosiveListener;
import com.akosg.clans.craftingsystem.CraftingListener;
import com.akosg.clans.craftingsystem.CraftingTaskHandler;
import com.akosg.clans.customarmour.ArmourListener;
import com.akosg.clans.customore.ResourcesListener;
import com.akosg.clans.database.CacheManager;
import com.akosg.clans.database.FirstJoinListener;
import com.akosg.clans.database.SQLInstance;
import com.akosg.clans.levelingsystem.LevelingCommands;
import com.akosg.clans.lootbarrels.LootListener;
import com.akosg.clans.utility.Items;
import com.akosg.clans.utility.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class Clans extends JavaPlugin {

private final Items items = new Items();

private CraftingTaskHandler taskHandler;
ConsoleCommandSender console = Bukkit.getConsoleSender();


@Override
public void onEnable() {

   this.taskHandler = new CraftingTaskHandler(this, items);

   registerTasks();
   registerCMD();
   registerListeners();

   SQLInstance.connect();

   reconnect();


   SQLInstance.createTables();
}

@Override
public void onDisable() {

   SQLInstance.disconnect();

}



public void reconnect() {
   Bukkit.getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
	  @Override
	  public void run() {
		 try {
			SQLInstance.getConnection().prepareStatement("SELECT 'Hello world'\n" +
																	 "  FROM DUAL");

			console.sendMessage("\247c[\2476Clans\247c] \247bDatabase connection refreshed!");
		 } catch (final SQLException e) {
			e.printStackTrace();
		 }
	  }
   }, (30 * 60 * 20L), 10);
}


private void registerTasks() {
   new ArmourListener(items, this);
}

private void registerCMD() {
   getCommand("clan").setExecutor(new ClanCommands(items, this));
   getCommand("level").setExecutor(new LevelingCommands());
}


private void registerListeners() {

   final PluginManager plm = org.bukkit.Bukkit.getPluginManager();

   plm.registerEvents(new ResourcesListener(this, items), this);
   plm.registerEvents(new CoreBlockListener(this), this);
   plm.registerEvents(new CraftingListener(items, taskHandler), this);
   plm.registerEvents(new ExplosiveListener(), this);
   plm.registerEvents(new LootListener(), this);
   plm.registerEvents(new MenuListener(), this);
   plm.registerEvents(new FirstJoinListener(), this);
   plm.registerEvents(new ChatListener(), this);
   plm.registerEvents(new CacheManager(), this);
}


}