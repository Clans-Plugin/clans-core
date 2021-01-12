package com.trophy.clans.lootbarrels;

import com.trophy.clans.utility.Items;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class LootListner implements Listener {

	private final Items items;

	public LootListner(final Items items) {
		this.items = items;
	}

	@EventHandler
	public void onLootInteract(final PlayerInteractEvent event) {

		final Player player = event.getPlayer();
		final Block target = event.getClickedBlock();

		if (target.getType().equals(Material.EMERALD_BLOCK)) {

			player.sendMessage("§cYou opened a §fLoot Barrel");
			target.setType(Material.AIR);

			items.giveCustomItem(player, items.getCookedsulfur(), 10);

		}


	}

}
