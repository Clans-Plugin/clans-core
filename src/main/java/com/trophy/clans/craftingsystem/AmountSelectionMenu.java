package com.trophy.clans.craftingsystem;

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

public class AmountSelectionMenu implements Listener, PlayerMenu {

	private final Inventory amountSelectionInventory = Bukkit.createInventory(this, 36, "Select Amount");
	private final ItemStack currentItem;
	private String amount = "";

	public AmountSelectionMenu(final ItemStack currentItem) {
		this.currentItem = currentItem;
	}


	@Override
	public Inventory getInventory() {
		return amountSelectionInventory;
	}

	@Override
	public boolean onClick(final Player player, final int slot, final ClickType type, final ItemStack currentItem) {

		if ((slot >= 3 && slot <= 5) || (slot >= 12 && slot <= 14) || (slot >= 21 && slot <= 24)) {

			final String displayNumber = ChatColor.stripColor(currentItem.getItemMeta().getDisplayName());

			if (maxAmountCheck(amount.concat(displayNumber))) {
				amount = amount.concat(displayNumber);
				amountSelectionInventory.setItem(31, getNewAmount(amount));
			} else {
				player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 1);
			}
		} else if (slot == 30) {

			amount = "";
			final ItemStack quantity = new ItemStack(Material.GOLD_BLOCK);
			final ItemMeta quantityItemMeta = quantity.getItemMeta();
			quantityItemMeta.setDisplayName(ChatColor.YELLOW + "Quantity");
			quantity.setItemMeta(quantityItemMeta);

			amountSelectionInventory.setItem(31, quantity);

		} else if (slot == 32) {
			

		}
		return true;
	}

	@Override
	public void onOpen(final Player player) {

		final ItemStack number1 = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		final ItemMeta number1Meta = number1.getItemMeta();
		number1Meta.setDisplayName(ChatColor.GREEN + "1");
		number1.setItemMeta(number1Meta);

		final ItemStack number2 = new ItemStack(Material.STAINED_GLASS_PANE, 2);
		final ItemMeta number2Meta = number2.getItemMeta();
		number2Meta.setDisplayName(ChatColor.GREEN + "2");
		number2.setItemMeta(number2Meta);

		final ItemStack number3 = new ItemStack(Material.STAINED_GLASS_PANE, 3);
		final ItemMeta number3Meta = number3.getItemMeta();
		number3Meta.setDisplayName(ChatColor.GREEN + "3");
		number3.setItemMeta(number3Meta);

		final ItemStack number4 = new ItemStack(Material.STAINED_GLASS_PANE, 4);
		final ItemMeta number4Meta = number4.getItemMeta();
		number4Meta.setDisplayName(ChatColor.GREEN + "4");
		number4.setItemMeta(number4Meta);

		final ItemStack number5 = new ItemStack(Material.STAINED_GLASS_PANE, 5);
		final ItemMeta number5Meta = number5.getItemMeta();
		number5Meta.setDisplayName(ChatColor.GREEN + "5");
		number5.setItemMeta(number5Meta);

		final ItemStack number6 = new ItemStack(Material.STAINED_GLASS_PANE, 6);
		final ItemMeta number6Meta = number6.getItemMeta();
		number6Meta.setDisplayName(ChatColor.GREEN + "6");
		number6.setItemMeta(number6Meta);

		final ItemStack number7 = new ItemStack(Material.STAINED_GLASS_PANE, 7);
		final ItemMeta number7Meta = number7.getItemMeta();
		number7Meta.setDisplayName(ChatColor.GREEN + "7");
		number7.setItemMeta(number7Meta);

		final ItemStack number8 = new ItemStack(Material.STAINED_GLASS_PANE, 8);
		final ItemMeta number8Meta = number8.getItemMeta();
		number8Meta.setDisplayName(ChatColor.GREEN + "8");
		number8.setItemMeta(number8Meta);

		final ItemStack number9 = new ItemStack(Material.STAINED_GLASS_PANE, 9);
		final ItemMeta number9Meta = number9.getItemMeta();
		number9Meta.setDisplayName(ChatColor.GREEN + "9");
		number9.setItemMeta(number9Meta);

		final ItemStack number0 = new ItemStack(Material.STAINED_GLASS_PANE, 0);
		final ItemMeta number0Meta = number0.getItemMeta();
		number0Meta.setDisplayName(ChatColor.GREEN + "0");
		number0.setItemMeta(number0Meta);

		final ItemStack quantity = new ItemStack(Material.GOLD_BLOCK);
		final ItemMeta quantityItemMeta = quantity.getItemMeta();
		quantityItemMeta.setDisplayName(ChatColor.YELLOW + "Quantity");
		quantity.setItemMeta(quantityItemMeta);

		final ItemStack reinsertquantity = new ItemStack(Material.REDSTONE_BLOCK);
		final ItemMeta reinsertquantityItemMeta = reinsertquantity.getItemMeta();
		reinsertquantityItemMeta.setDisplayName(ChatColor.RED + "Reinsert reinsertquantity");
		reinsertquantity.setItemMeta(reinsertquantityItemMeta);

		final ItemStack craft = new ItemStack(Material.EMERALD_BLOCK);
		final ItemMeta craftItemMeta = craft.getItemMeta();
		craftItemMeta.setDisplayName(ChatColor.GREEN + "Craft");
		craft.setItemMeta(craftItemMeta);

		amountSelectionInventory.setItem(3, number1);
		amountSelectionInventory.setItem(4, number2);
		amountSelectionInventory.setItem(5, number3);

		amountSelectionInventory.setItem(12, number4);
		amountSelectionInventory.setItem(13, number5);
		amountSelectionInventory.setItem(14, number6);

		amountSelectionInventory.setItem(21, number7);
		amountSelectionInventory.setItem(22, number8);
		amountSelectionInventory.setItem(23, number9);
		amountSelectionInventory.setItem(24, number0);

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
