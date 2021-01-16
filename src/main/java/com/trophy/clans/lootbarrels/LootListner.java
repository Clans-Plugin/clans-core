package com.trophy.clans.lootbarrels;

import com.trophy.clans.player.PlayerData;
import com.trophy.clans.utility.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;

public class LootListner implements Listener {

	private final Items items;
	private final HashMap<UUID, PlayerData> playerCache;

	public LootListner(final Items items, final HashMap<UUID, PlayerData> playerCache) {
		this.items = items;
		this.playerCache = playerCache;
	}

	@EventHandler
	private void onLootInteract(final PlayerInteractEvent event) {

		final Block block = event.getClickedBlock();

		if (block != null) {

			final Player player = event.getPlayer();

			final PlayerData playerData = playerCache.get(player.getUniqueId());

			if (block.getType().equals(Material.IRON_BLOCK)) {

				if (playerData.getLevel() >= 5) {

					player.sendMessage("§cYou opened a §fLoot Barrel");
					block.setType(Material.AIR);

					player.getInventory().addItem(items.getTier1Barrel().next());

				} else {
					player.sendMessage(ChatColor.RED + "You need to be atleast " + ChatColor.YELLOW + "Level 5" + ChatColor.RED + " to open this barrel.");
				}

			} else if (block.getType().equals(Material.GOLD_BLOCK)) {
				if (playerData.getLevel() >= 15) {

					player.sendMessage("§cYou opened a §fLoot Barrel");
					block.setType(Material.AIR);

					player.getInventory().addItem(items.getTier2Barrel().next());

				} else {
					player.sendMessage(ChatColor.RED + "You need to be atleast " + ChatColor.YELLOW + "Level 15" + ChatColor.RED + " to open this barrel.");
				}
			} else if (block.getType().equals(Material.DIAMOND_BLOCK)) {
				if (playerData.getLevel() >= 30) {

					player.sendMessage("§cYou opened a §fLoot Barrel");
					block.setType(Material.AIR);

					player.getInventory().addItem(items.getTier3Barrel().next());

				} else {
					player.sendMessage(ChatColor.RED + "You need to be atleast " + ChatColor.YELLOW + "Level 30" + ChatColor.RED + " to open this barrel.");
				}
			}
		}
	}

	@EventHandler
	private void onLootBarrelPlace(final BlockPlaceEvent event) {

		if (event.getPlayer().isOp()) {
			if (event.getBlock().getType().equals(Material.IRON_BLOCK)) {
				event.getPlayer().sendMessage(ChatColor.RED + "Tier 1 Barrel placed.");
			} else if (event.getBlock().getType().equals(Material.GOLD_BLOCK)) {
				event.getPlayer().sendMessage(ChatColor.RED + "Tier 2 Barrel placed.");
			} else if (event.getBlock().getType().equals(Material.DIAMOND_BLOCK)) {
				event.getPlayer().sendMessage(ChatColor.RED + "Tier 3 Barrel placed.");
			}
		}
	}
}
