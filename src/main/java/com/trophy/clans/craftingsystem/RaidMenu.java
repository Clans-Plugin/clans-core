package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.Items;
import com.trophy.clans.utility.PlayerMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RaidMenu implements Listener, PlayerMenu {

	private final Inventory raidingInventory = Bukkit.createInventory(this, 9, "Raiding");
	private final CraftingTaskHandler taskHandler;
	private final Items items;

	public RaidMenu(final Items items, final CraftingTaskHandler taskHandler) {
		this.items = items;
		this.taskHandler = taskHandler;
	}

	@Override
	public Inventory getInventory() {
		return raidingInventory;
	}

	@Override
	public boolean onClick(final Player player, final int slot, final ClickType type, final ItemStack currentItem) {

		if (currentItem != null) {
			if (currentItem.getType() != Material.AIR) {
				player.openInventory(new AmountSelectionMenu(currentItem, taskHandler, items).getInventory());
				player.playSound(player.getLocation(), Sound.valueOf("ORB_PICKUP"), 1.0F, 1.0F);
			}
		}
		return true;
	}

	@Override
	public void onOpen(final Player player) {
		raidingInventory.setItem(4, items.getC4());
	}

	@Override
	public void onClose(final Player player) {

	}
}
