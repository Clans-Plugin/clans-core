package com.akosg.clans.customore;

import com.akosg.clans.database.CacheManager;
import com.akosg.clans.database.PlayerCache;
import com.akosg.clans.main.Clans;
import com.akosg.clans.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ResourcesListener implements Listener {

	private final Clans plugin;
	private final Items items;
	private int multiplier;


	public ResourcesListener(final Clans main, final Items items) {
		this.plugin = main;
		this.items = items;
	}

	@EventHandler
	public void onBlockBreak(final BlockBreakEvent event) {

		final Player player = event.getPlayer();

		final PlayerCache playerCache = CacheManager.playerData.get(player);

		final Integer xp = playerCache.getXp();

		if (!playerCache.getDonor().equalsIgnoreCase("true")) {

			multiplier = 1;

		} else {
			multiplier = 2;
		}

		final Material material = event.getBlock().getType();

		switch (material) {

			case STONE:
				respawnBlock(material, 120, event);
				items.addItemToInventory(player, items.getStone(), 2 * multiplier);
				playerCache.setXp(xp + 4);
				break;
			case COAL_ORE:
				respawnBlock(material, 240, event);
				items.addItemToInventory(player, items.getFuel(), 2 * multiplier);
				playerCache.setXp(xp + 6);
				break;
			case IRON_ORE:
				respawnBlock(material, 240, event);
				items.addItemToInventory(player, items.getIron(), 2 * multiplier);
				playerCache.setXp(xp + 8);
				break;
			case GOLD_ORE:
				respawnBlock(material, 480, event);
				items.addItemToInventory(player, items.getSulfur(), 2 * multiplier);
				playerCache.setXp(xp + 10);
				break;
			case LOG:
				respawnBlock(material, 120, event);
				items.addItemToInventory(player, items.getWood(), 2 * multiplier);
				playerCache.setXp(xp + 5);
				break;
			default:
				player.sendMessage("§cYou can not mine this block!");
				break;
		}
	}


	private void respawnBlock(final Material material, final Integer time, final BlockBreakEvent event) {

		event.getBlock().setType(Material.BEDROCK);
		Bukkit.getScheduler().runTaskLater(plugin, () -> event.getBlock().setType(material), time * 20);

	}

}