package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftingGUIs {

	private static final Items i = new Items();

	public static void openMainGui(final Player p) {

		final Inventory inv = Bukkit.createInventory(null, 45, "Crafting");

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

		inv.setItem(11, baseing);
		inv.setItem(15, tooling);
		inv.setItem(29, weaponing);
		inv.setItem(33, raiding);

		p.openInventory(inv);


	}

	public static void openRaidGui(final Player p) {


		final Inventory inv = Bukkit.createInventory(null, 9, "Raiding");


		inv.setItem(4, i.getExplosive(1));

		p.openInventory(inv);


	}

	public static void openBaseGui(final Player p) {


		final Inventory inv = Bukkit.createInventory(null, 27, "Base blocks");


		inv.setItem(10, i.getTier1Wall(1));
		inv.setItem(11, i.getTier2Wall(1));
		inv.setItem(12, i.getTier3Wall(1));
		inv.setItem(14, i.getDoorT1());
		inv.setItem(15, i.getDoorT2());
		inv.setItem(16, i.getChest(1));

		p.openInventory(inv);


	}


	public static void openToolsGui(final Player p) {


		final Inventory inv = Bukkit.createInventory(null, 27, "Tools");


		inv.setItem(10, i.getTier1PickAxe());
		inv.setItem(11, i.getTier2PickAxe());
		inv.setItem(12, i.getTier3PickAxe());
		inv.setItem(13, i.getUpgradeTool());
		inv.setItem(14, i.getTier1Axe());
		inv.setItem(15, i.getTier2Axe());
		inv.setItem(16, i.getTier3Axe());

		p.openInventory(inv);


	}

	public static void openWeaponArmourGui(final Player p) {


		final Inventory inv = Bukkit.createInventory(null, 27, "Weapons & Armour");


		inv.setItem(1, i.getTierOneHelmet());
		inv.setItem(2, i.getTierOneChestplate());
		inv.setItem(3, i.getTierOneLeggings());
		inv.setItem(4, i.getTierOneBoots());
		inv.setItem(6, i.getTierOneSword());

		inv.setItem(10, i.getTierTwoHelmet());
		inv.setItem(11, i.getTierTwoChestplate());
		inv.setItem(12, i.getTierTwoLeggings());
		inv.setItem(13, i.getTierTwoBoots());
		inv.setItem(15, i.getTierTwoSword());

		inv.setItem(19, i.getTierThreeHelmet());
		inv.setItem(20, i.getTierThreeChestplate());
		inv.setItem(21, i.getTierThreeLeggings());
		inv.setItem(22, i.getTierThreeBoots());
		inv.setItem(24, i.getTierThreeSword());

		p.openInventory(inv);


	}


}
