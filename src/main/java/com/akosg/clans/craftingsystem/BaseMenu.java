package com.akosg.clans.craftingsystem;

import com.akosg.clans.utility.Items;
import com.akosg.clans.utility.PlayerMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BaseMenu implements Listener, PlayerMenu {

	private final Inventory baseBlocksInventory = Bukkit.createInventory(this, 27, "Base blocks");
	private final CraftingTaskHandler taskHandler;
	private final Items items;

	public BaseMenu(final Items items, final CraftingTaskHandler taskHandler) {
		this.items = items;
		this.taskHandler = taskHandler;
	}

	@Override
	public Inventory getInventory() {
		return baseBlocksInventory;
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

		baseBlocksInventory.setItem(10, items.getTier1Wall());
		baseBlocksInventory.setItem(11, items.getTier2Wall());
		baseBlocksInventory.setItem(12, items.getTier3Wall());
		baseBlocksInventory.setItem(14, items.getTier1Door());
		baseBlocksInventory.setItem(15, items.getTier2Door());
		baseBlocksInventory.setItem(16, items.getChest());

	}

	@Override
	public void onClose(final Player player) {

	}
}
