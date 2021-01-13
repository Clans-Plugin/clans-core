package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.Items;
import com.trophy.clans.utility.PlayerMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RaidMenu implements Listener, PlayerMenu {

	private final Inventory raidingInventory = Bukkit.createInventory(this, 9, "Raiding");
	private final Items items;

	public RaidMenu(final Items items) {
		this.items = items;
	}

	@Override
	public Inventory getInventory() {
		return raidingInventory;
	}

	@Override
	public boolean onClick(final Player player, final int slot, final ClickType type, final ItemStack currentItem) {
		if (slot == 4) {
			new AmountSelectionMenu(currentItem);
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
