package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.PlayerMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftingMenu implements Listener, PlayerMenu {

	private final Inventory craftingInventory = Bukkit.createInventory(this, 45, "Crafting");

	@Override
	public Inventory getInventory() {
		return craftingInventory;
	}

	@Override
	public boolean onClick(final Player player, final int slot, final ClickType type, final ItemStack currentItem) {
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
