package com.akosg.clans.clansystem;

import com.akosg.clans.database.CacheManager;
import com.akosg.clans.database.PlayerCache;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {

	@EventHandler
	public void onChat(final PlayerChatEvent e) {

		final Player player = e.getPlayer();
		final String message = e.getMessage();

		final PlayerCache playerCache = CacheManager.playerData.get(player);

		e.setFormat("§7" + playerCache.getClanName() + " " + player.getDisplayName() + ": " + message);
	}

}
