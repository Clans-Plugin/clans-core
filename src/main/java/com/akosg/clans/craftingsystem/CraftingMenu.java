package com.akosg.clans.craftingsystem;

import com.akosg.clans.utility.Items;
import com.akosg.clans.utility.PlayerMenu;
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

public class CraftingMenu implements Listener, PlayerMenu {

	private final Inventory craftingInventory = Bukkit.createInventory(this, 45, "Crafting");
	private final CraftingTaskHandler taskHandler;
	private final Items items;

	public CraftingMenu(final Items items, final CraftingTaskHandler taskHandler) {
		this.items = items;
		this.taskHandler = taskHandler;
	}

	@Override
	public Inventory getInventory() {
		return craftingInventory;
	}

	@Override
	public boolean onClick(final Player player, final int slot, final ClickType type, final ItemStack currentItem) {

		switch (slot) {
			case 11:
				player.openInventory(new BaseMenu(items, taskHandler).getInventory());
				player.playSound(player.getLocation(), Sound.valueOf("ORB_PICKUP"), 1.0F, 1.0F);
				break;
			case 15:
				player.openInventory(new ToolsMenu(items, taskHandler).getInventory());
				player.playSound(player.getLocation(), Sound.valueOf("ORB_PICKUP"), 1.0F, 1.0F);
				break;
			case 29:
				player.openInventory(new WeaponsArmorMenu(items, taskHandler).getInventory());
				player.playSound(player.getLocation(), Sound.valueOf("ORB_PICKUP"), 1.0F, 1.0F);
				break;
			case 33:
				player.openInventory(new RaidMenu(items, taskHandler).getInventory());
				player.playSound(player.getLocation(), Sound.valueOf("ORB_PICKUP"), 1.0F, 1.0F);
				break;
		}
		return true;
	}

	@Override
	public void onOpen(final Player player) {

		final ItemStack raiding = new ItemStack(Material.TNT);
		final ItemMeta raid = raiding.getItemMeta();
		raid.setDisplayName(ChatColor.DARK_RED + "Raiding");
		raiding.setItemMeta(raid);

		final ItemStack baseing = new ItemStack(Material.WOOD);
		final ItemMeta base = baseing.getItemMeta();
		base.setDisplayName(ChatColor.DARK_RED + "Base blocks");
		baseing.setItemMeta(base);

		final ItemStack tooling = new ItemStack(Material.DIAMOND_PICKAXE);
		final ItemMeta tool = tooling.getItemMeta();
		tool.setDisplayName(ChatColor.DARK_RED + "Tools & Resources");
		tooling.setItemMeta(tool);

		final ItemStack weaponing = new ItemStack(Material.DIAMOND_SWORD);
		final ItemMeta weapon = weaponing.getItemMeta();
		weapon.setDisplayName(ChatColor.DARK_RED + "Weapons & Armour");
		weaponing.setItemMeta(weapon);

		craftingInventory.setItem(11, baseing);
		craftingInventory.setItem(15, tooling);
		craftingInventory.setItem(29, weaponing);
		craftingInventory.setItem(33, raiding);

	}

	@Override
	public void onClose(final Player player) {

	}
}
