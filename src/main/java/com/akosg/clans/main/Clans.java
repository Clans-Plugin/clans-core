package com.akosg.clans.main;

import com.akosg.clans.clansystem.ChatListener;
import com.akosg.clans.clansystem.ClanCommands;
import com.akosg.clans.clansystem.CoreBlockListener;
import com.akosg.clans.clansystem.ExplosiveListener;
import com.akosg.clans.craftingsystem.CraftingListener;
import com.akosg.clans.craftingsystem.CraftingTaskHandler;
import com.akosg.clans.customarmour.ArmourListener;
import com.akosg.clans.customore.ResourcesListener;
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

private void reconnect() {

   Bukkit.getServer().getScheduler().runTaskLater(this, SQLInstance::connect, (36 * 20));
   console.sendMessage("\247c[\2476Clans\247c] \247bDatabase connection refreshed!");

}


private void registerTasks() {
   new ArmourListener(items, this);
}

private void registerCMD() {
   getCommand("clan").setExecutor(new ClanCommands(items));
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
}


}