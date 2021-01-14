package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.Items;
import com.trophy.clans.utility.PlayerMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class AmountSelectionMenu implements Listener, PlayerMenu {

	private final Inventory amountSelectionInventory = Bukkit.createInventory(this, 36, "Select Amount");
	private final CraftingTaskHandler taskHandler;
	private final ItemStack currentCraftItem;
	private final Items items;
	private final int[] numberPadIndex = {24, 3, 4, 5, 12, 13, 14, 21, 22, 23};
	private String amount = "";

	public AmountSelectionMenu(final ItemStack currentItem, final CraftingTaskHandler taskHandler, final Items items) {
		this.currentCraftItem = currentItem;
		this.taskHandler = taskHandler;
		this.items = items;
	}


	@Override
	public Inventory getInventory() {
		return amountSelectionInventory;
	}

	@Override
	public boolean onClick(final Player player, final int slot, final ClickType type, final ItemStack currentItem) {

		if ((slot >= 3 && slot <= 5) || (slot >= 12 && slot <= 14) || (slot >= 21 && slot <= 24)) {

			player.playSound(player.getLocation(), Sound.valueOf("ORB_PICKUP"), 1.0F, 1.0F);

			final String displayNumber = ChatColor.stripColor(currentItem.getItemMeta().getDisplayName());

			if (slot == 24) {
				if (amount.isEmpty()) {
					return true;
				}
			}

			if (!maxAmountCheck(amount.concat(displayNumber))) {
				amount = amount.concat(displayNumber);
				amountSelectionInventory.setItem(31, getNewAmount(amount));
			} else {
				player.playSound(player.getLocation(), Sound.valueOf("VILLAGER_NO"), 1.0F, 1.0F);
				player.sendMessage(ChatColor.RED + "You can't craft more than 300 items at once!");
			}
		} else if (slot == 30) {

			amount = "";
			final ItemStack quantity = new ItemStack(Material.GOLD_BLOCK);
			final ItemMeta quantityItemMeta = quantity.getItemMeta();
			quantityItemMeta.setDisplayName(ChatColor.YELLOW + "Quantity");
			quantity.setItemMeta(quantityItemMeta);

			amountSelectionInventory.setItem(31, quantity);

		} else if (slot == 32) {

			if (amount.isEmpty()) {
				return true;
			}


			boolean resourceCheck = true;

			final HashMap<ItemStack, Integer> costMap = taskHandler.getCost(currentCraftItem);

			for (final ItemStack item : costMap.keySet()) {

				if (!player.getInventory().containsAtLeast(item, costMap.get(item) * Integer.parseInt(amount))) {
					resourceCheck = false;
				}
			}

			if (resourceCheck) {

				taskHandler.getCraftingTasks().put(player.getUniqueId(), new PlayerCraftingTask(currentCraftItem, Integer.parseInt(amount), items));

				player.closeInventory();

			} else {
				player.playSound(player.getLocation(), Sound.valueOf("VILLAGER_NO"), 1.0F, 1.0F);
				player.sendMessage(ChatColor.RED + "You don't have enough resources! Reset your quantity.");
			}

		}
		return true;
	}

	@Override
	public void onOpen(final Player player) {

		for (int i = 0; i <= 9; i++) {
			final ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, i);
			final ItemMeta itemMeta = item.getItemMeta();
			itemMeta.setDisplayName(ChatColor.GREEN + String.valueOf(i));
			item.setItemMeta(itemMeta);
			amountSelectionInventory.setItem(numberPadIndex[i], item);
		}

		final ItemStack quantity = new ItemStack(Material.GOLD_BLOCK);
		final ItemMeta quantityItemMeta = quantity.getItemMeta();
		quantityItemMeta.setDisplayName(ChatColor.YELLOW + "Quantity");
		quantity.setItemMeta(quantityItemMeta);

		final ItemStack reinsertquantity = new ItemStack(Material.REDSTONE_BLOCK);
		final ItemMeta reinsertquantityItemMeta = reinsertquantity.getItemMeta();
		reinsertquantityItemMeta.setDisplayName(ChatColor.RED + "Reinsert Quantity");
		reinsertquantity.setItemMeta(reinsertquantityItemMeta);

		final ItemStack craft = new ItemStack(Material.EMERALD_BLOCK);
		final ItemMeta craftItemMeta = craft.getItemMeta();
		craftItemMeta.setDisplayName(ChatColor.GREEN + "Craft");
		craft.setItemMeta(craftItemMeta);

		amountSelectionInventory.setItem(30, reinsertquantity);
		amountSelectionInventory.setItem(31, quantity);
		amountSelectionInventory.setItem(32, craft);

	}

	@Override
	public void onClose(final Player player) {

	}

	private ItemStack getNewAmount(final String newAmount) {
		final ItemStack currentAmount = new ItemStack(Material.PAPER);
		final ItemMeta currentAmountItemMeta = currentAmount.getItemMeta();
		currentAmountItemMeta.setDisplayName(ChatColor.AQUA + "Current Amount: " + ChatColor.GREEN + "" + ChatColor.BOLD + newAmount);
		currentAmount.setItemMeta(currentAmountItemMeta);
		return currentAmount;
	}

	private boolean maxAmountCheck(final String newAmount) {
		return Integer.parseInt(newAmount) > 300;
	}

}
