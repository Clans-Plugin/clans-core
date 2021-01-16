package com.trophy.clans.database;

import com.trophy.clans.player.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.UUID;

public class FirstJoinListener implements Listener {

	private final HashMap<UUID, PlayerData> playerCache;

	public FirstJoinListener(final HashMap<UUID, PlayerData> playerCache) {
		this.playerCache = playerCache;
	}

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {

		final Player player = event.getPlayer();

		final String uuid = player.getUniqueId().toString();

		if (!SQL.checkDatabaseExist(uuid)) {

			player.sendMessage("First Join --> Added to Database");
			SQL.firstJoin(uuid);

			playerCache.put(player.getUniqueId(), new PlayerData());

		} else {
			playerCache.put(player.getUniqueId(), new PlayerData(SQL.getPlayerLevel(uuid), SQL.getPlayerXP(uuid), SQL.getPlayerPoints(uuid)));
		}
	}

	@EventHandler
	public void onPlayerLeave(final PlayerQuitEvent event) {

		playerCache.remove(event.getPlayer().getUniqueId());

	}

}
