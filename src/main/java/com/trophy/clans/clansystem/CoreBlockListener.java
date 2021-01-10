package com.trophy.clans.clansystem;

import com.trophy.clans.database.Data;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.io.IOException;

public class CoreBlockListener implements Listener {



	private String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	@EventHandler
	public void PlaceEvent(BlockPlaceEvent e) throws IOException {

		if (e.getBlockPlaced().getType() == Material.BEACON) {

			Player p = e.getPlayer();

			p.sendMessage(color("&cCore block placed, protect it!"));

			Location loc = e.getBlockPlaced().getLocation();
			String clanName = Data.getClanName(p);

			Data.setCoreBlockLocation(clanName, loc);

		}

	}

	@EventHandler
	public void DestoyEvent(BlockBreakEvent e) throws IOException {

		if (e.getBlock().getType() == Material.BEACON) {

			Player p = e.getPlayer();
			Location loc = e.getBlock().getLocation();
			String playerClan = Data.getClanName(p);
			String coreOwner = Data.getCoreBlockClan(loc);

			if (playerClan.equalsIgnoreCase(coreOwner)) {

				e.setCancelled(true);
				p.sendMessage(color("&cERROR: You can not mine your own core block"));

			} else {

				e.setCancelled(true);
				e.getBlock().setType(Material.AIR);

				//SET POINTS LOGIC

			}


		}


	}

}
