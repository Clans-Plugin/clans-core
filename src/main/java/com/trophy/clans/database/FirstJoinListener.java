package com.trophy.clans.database;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoinListener implements Listener {


	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {

		final Player player = event.getPlayer();

		final String uuid = player.getUniqueId().toString();

		if (!PlayerData.checkDatabaseExist(uuid)) {

			player.sendMessage("First Join --> Added to Database");
			PlayerData.firstJoin(uuid);


		}
	}


}
