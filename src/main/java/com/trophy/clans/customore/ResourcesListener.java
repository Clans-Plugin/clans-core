package com.trophy.clans.customore;

import com.trophy.clans.main.Clans;
import com.trophy.clans.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class ResourcesListener implements Listener {

	private final Clans plugin;
	private final Items items;

	public ResourcesListener(final Clans main, final Items items) {
		this.plugin = main;
		this.items = items;
	}

	@EventHandler
	public void onBlockBreak(final BlockBreakEvent event) {

		final Player player = event.getPlayer();

		if (!player.hasPermission("clans.edit")) {

			event.setCancelled(true);

			int multiplier = 1;

			if (player.hasPermission("clan.donor")) {
				multiplier = 2;
			}

			final Material material = event.getBlock().getType();

			switch (material) {

				case STONE:
					respawnBlock(material, 120, event);
					items.addItemToInventory(player, items.getStone(), 2 * multiplier);
					break;
				case COAL_ORE:
					respawnBlock(material, 240, event);
					items.addItemToInventory(player, items.getFuel(), 2 * multiplier);
					break;
				case IRON_ORE:
					respawnBlock(material, 240, event);
					items.addItemToInventory(player, items.getIron(), 2 * multiplier);
					items.giveCustomItem(player, items.getIron(), 2 * multiplier);
					break;
				case GOLD_ORE:
					respawnBlock(material, 480, event);
					items.addItemToInventory(player, items.getSulfur(), 2 * multiplier);
					break;
				case LOG:
					respawnBlock(material, 120, event);
					items.addItemToInventory(player, items.getWood(), 2 * multiplier);
					break;
				default:
					player.sendMessage("§cYou can not mine this block!");
					break;
			}
		}
	}

	private void respawnBlock(final Material material, final Integer time, final BlockBreakEvent event) {

		event.getBlock().setType(Material.BEDROCK);
		Bukkit.getScheduler().runTaskLater(plugin, () -> event.getBlock().setType(material), time * 20);

	}

}