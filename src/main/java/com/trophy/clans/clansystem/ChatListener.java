package com.trophy.clans.clansystem;

import com.trophy.clans.database.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatListener implements Listener {

	@EventHandler
	public void onChat(final PlayerChatEvent e) {

		final Player p = e.getPlayer();
		final String message = e.getMessage();

		e.setFormat("§7" + PlayerData.getClanName(p.getUniqueId().toString()) + " " + p.getDisplayName() + ": " + message);
	}

}
