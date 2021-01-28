package com.trophy.clans.clansystem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class CoreBlockListener implements Listener {

	@EventHandler
	public void PlaceEvent(final BlockPlaceEvent event) {

		if (event.getBlockPlaced().getType() == Material.BEACON) {

			final Player player = event.getPlayer();
			final String uuid = event.getPlayer().getUniqueId().toString();

			player.sendMessage("§cCore block placed, protect it!");

			final int locx = event.getBlockPlaced().getChunk().getX();
			final int locz = event.getBlockPlaced().getChunk().getZ();


		}

	}

	@EventHandler
	public void DestroyEvent(final BlockBreakEvent event) {

		if (event.getBlock().getType() == Material.BEACON) {

			event.setCancelled(true);

		}


	}

}
