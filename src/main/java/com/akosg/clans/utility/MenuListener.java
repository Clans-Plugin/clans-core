package com.trophy.clans.utility;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;

public class MenuListener implements Listener {

	@EventHandler(ignoreCancelled = true)
	private void onClick(final InventoryClickEvent event) {
		final InventoryHolder holder = event.getInventory().getHolder();
		if (!(holder instanceof PlayerMenu)) return;
		event.setCancelled(((PlayerMenu) holder).onClick((Player) event.getWhoClicked(), event.getRawSlot(), event.getClick(), event.getCurrentItem()));
	}

	@EventHandler
	private void onOpen(final InventoryOpenEvent event) {
		final InventoryHolder holder = event.getInventory().getHolder();
		if (holder instanceof PlayerMenu) ((PlayerMenu) holder).onOpen((Player) event.getPlayer());
	}

	@EventHandler
	private void onClose(final InventoryCloseEvent event) {
		final InventoryHolder holder = event.getInventory().getHolder();
		if (holder instanceof PlayerMenu) ((PlayerMenu) holder).onClose((Player) event.getPlayer());
	}
	

}
