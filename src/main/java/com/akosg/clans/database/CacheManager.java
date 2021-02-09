package com.akosg.clans.database;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class CacheManager implements Listener {

private String clanName;
private int level;
private int xp;
private int points;


public HashMap<String, PlayerCache> data;

@EventHandler
public void playerJoinEvent(final PlayerJoinEvent e) {

   final String uuid = e.getPlayer().getUniqueId().toString();

   clanName = PlayerData.getClanName(uuid);
   level = PlayerData.getPlayerLevel(uuid);
   xp = PlayerData.getPlayerXP(uuid);
   points = PlayerData.getPlayerPoints(uuid);


   //Check if the player is in the database
   if (!PlayerData.checkDatabaseExist(uuid)) {


   }


}


}
