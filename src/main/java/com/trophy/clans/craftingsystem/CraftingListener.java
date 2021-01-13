package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.Items;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingListener implements Listener {

	private final Items items;
	private final CraftingTaskHandler taskHandler;

	public CraftingListener(final Items items, final CraftingTaskHandler taskHandler) {
		this.items = items;
		this.taskHandler = taskHandler;
	}

	@EventHandler
	private void preventCrafting(final PrepareItemCraftEvent event) {
		final Material itemType = event.getRecipe().getResult().getType();
		if (itemType == Material.WORKBENCH) {
			event.getInventory().setResult(new ItemStack(Material.AIR));
		}
	}

	@EventHandler
	private void openCraftingTable(final PlayerInteractEvent event) {

		if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (event.getClickedBlock().getType() == Material.WORKBENCH) {

				event.getPlayer().openInventory(new CraftingMenu(items, taskHandler).getInventory());
				event.setCancelled(true);
			}
		}
	}
}



