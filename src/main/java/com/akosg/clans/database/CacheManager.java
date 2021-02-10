package com.akosg.clans.database;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class CacheManager implements Listener {

	public static HashMap<Player, PlayerCache> playerData;

	public CacheManager(final HashMap<Player, PlayerCache> playerData) {
		this.playerData = playerData;
	}

	@EventHandler
	private void onPlayerJoin(final PlayerJoinEvent event) {

		final Player player = event.getPlayer();

		final String uuid = player.getUniqueId().toString();

		if (PlayerData.checkDatabaseExist(uuid)) {

			final String clanName = PlayerData.getClanName(uuid);
			final int level = PlayerData.getPlayerLevel(uuid);
			final int xp = PlayerData.getPlayerXP(uuid);
			final int points = PlayerData.getPlayerPoints(uuid);

			playerData.put(player, new PlayerCache(clanName, level, xp, points));

			System.out.println("Player is already database");

		} else {
			PlayerData.firstJoin(uuid);
			System.out.println("First join");
			playerData.put(player, new PlayerCache());
		}

		System.out.println("Data: " + playerData.toString());
		System.out.println("Fuck");
	}

	@EventHandler
	private void onPlayerLeave(final PlayerQuitEvent event) {

		final Player player = event.getPlayer();

		final String uuid = player.getUniqueId().toString();

		final PlayerCache playerCache = playerData.get(player);

		final String clanName = playerCache.getClanName();
		System.out.println("clanName: " + clanName);
		final int level = playerCache.getLevel();
		System.out.println("level: " + level);
		final int xp = playerCache.getXp();
		System.out.println("xp: " + xp);
		final int points = playerCache.getPoints();
		System.out.println("points: " + points);

		PlayerData.setPlayerClan(clanName, uuid);
		PlayerData.setLevel(level, uuid);
		PlayerData.setXP(xp, uuid);
		PlayerData.setPoints(points, uuid);

		playerData.remove(player);

		System.out.println("Data: " + playerData.toString());
		System.out.println("Fuck you left");

	}
}
