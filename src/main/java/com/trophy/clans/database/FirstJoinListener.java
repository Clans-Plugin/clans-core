package com.trophy.clans.database;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class FirstJoinListener implements Listener {

	@EventHandler

	public void firstJoinEvent(PlayerJoinEvent e) {

		Player p = e.getPlayer();

		String name = e.getPlayer().getName();
		String uuid = e.getPlayer().getUniqueId().toString();

		if (!SQL.checkDatabaseExist(p.getUniqueId().toString())) {


			p.sendMessage("First Join --> Added to Database");
			SQL.firstJoin(p.getName(), p.getUniqueId().toString());

		} else {

			if (!SQL.checkDatabaseName(p.getUniqueId().toString()).equals(p.getName())) {


				SQL.updateName(p.getUniqueId().toString(), p.getName());
				p.sendMessage("Database --> New name assigned to UUID");

			}

		}


	}


}
