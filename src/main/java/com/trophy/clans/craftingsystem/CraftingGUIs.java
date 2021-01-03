package com.trophy.clans.craftingsystem;

import com.trophy.clans.customitemstacks.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftingGUIs {

	private static Items i = new Items();

	public static void openMainGui(Player p) {


		Inventory inv = Bukkit.createInventory(null, 45, "Crafting");

		ItemStack raiding = new ItemStack(Material.TNT);
		ItemMeta raid = raiding.getItemMeta();
		raid.setDisplayName(ChatColor.DARK_RED + "Raiding");
		raiding.setItemMeta(raid);

		ItemStack baseing = new ItemStack(Material.WOOD);
		ItemMeta base = baseing.getItemMeta();
		base.setDisplayName(ChatColor.DARK_RED + "Base blocks");
		baseing.setItemMeta(base);

		ItemStack tooling = new ItemStack(Material.DIAMOND_PICKAXE);
		ItemMeta tool = tooling.getItemMeta();
		tool.setDisplayName(ChatColor.DARK_RED + "Tools & Resources");
		tooling.setItemMeta(tool);

		ItemStack weaponing = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta weapon = weaponing.getItemMeta();
		weapon.setDisplayName(ChatColor.DARK_RED + "Weapons & Armour");
		weaponing.setItemMeta(weapon);

		inv.setItem(11, baseing);
		inv.setItem(15, tooling);
		inv.setItem(29, weaponing);
		inv.setItem(33, raiding);

		p.openInventory(inv);


	}

	public static void openRaidGui(Player p) {


		Inventory inv = Bukkit.createInventory(null, 9, "Raiding");


		inv.setItem(4, i.getExplosive());

		p.openInventory(inv);


	}


}
