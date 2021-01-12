package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.Items;
import com.trophy.clans.utility.PlayerMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ToolsMenu implements Listener, PlayerMenu {

	private final Inventory toolsInventory = Bukkit.createInventory(null, 27, "Tools");
	private final Items items;

	public ToolsMenu(final Items items) {
		this.items = items;
	}

	@Override
	public Inventory getInventory() {
		return toolsInventory;
	}

	@Override
	public boolean onClick(final Player player, final int slot, final ClickType type, final ItemStack currentItem) {
		return true;
	}

	@Override
	public void onOpen(final Player player) {

		toolsInventory.setItem(10, items.getTier1Pickaxe());
		toolsInventory.setItem(11, items.getTier2Pickaxe());
		toolsInventory.setItem(12, items.getTier3Pickaxe());
		toolsInventory.setItem(13, items.getUpgradeTool());
		toolsInventory.setItem(14, items.getTier1Axe());
		toolsInventory.setItem(15, items.getTier2Axe());
		toolsInventory.setItem(16, items.getTier3Axe());

	}

	@Override
	public void onClose(final Player player) {

	}
}
