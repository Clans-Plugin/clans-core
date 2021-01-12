package com.trophy.clans.clansystem;

import com.trophy.clans.database.LocalData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.io.IOException;

public class CoreBlockListener implements Listener {

	@EventHandler
	public void PlaceEvent(final BlockPlaceEvent event) throws IOException {

		if (event.getBlockPlaced().getType() == Material.BEACON) {

			final Player player = event.getPlayer();

			player.sendMessage("§cCore block placed, protect it!");

			final Location loc = event.getBlockPlaced().getLocation();
			final String clanName = LocalData.getClanName(player);

			LocalData.setCoreBlockLocation(clanName, loc);

		}

	}

	@EventHandler
	public void DestoyEvent(final BlockBreakEvent event) throws IOException {

		if (event.getBlock().getType() == Material.BEACON) {

			final Player player = event.getPlayer();
			final Location loc = event.getBlock().getLocation();
			final String playerClan = LocalData.getClanName(player);
			final String coreOwner = LocalData.getCoreBlockClan(loc);

			event.setCancelled(true);

			if (playerClan.equalsIgnoreCase(coreOwner)) {
				
				player.sendMessage("§cERROR: You can not mine your own core block");

			} else {

				event.getBlock().setType(Material.AIR);

				//SET POINTS LOGIC

			}


		}


	}

}
