package com.trophy.clans.CustomItemStacks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.Arrays;

public class Items {

	private static String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	//
	//  BASES
	//

	public ItemStack getExplosive() {

		ItemStack c4 = new ItemStack(Material.TNT, 64);
		ItemMeta c4Meta = c4.getItemMeta();
		c4Meta.setDisplayName(color("&c&lC4"));
		c4.setItemMeta(c4Meta);

		return c4;
	}


	//
	//  TOOLS
	//


	public ItemStack getUpgradeTool() {

		ItemStack UpgradeTool = new ItemStack(Material.GOLD_AXE, 1);
		ItemMeta UpgradeToolMeta = UpgradeTool.getItemMeta();
		UpgradeToolMeta.setDisplayName(color("&c&lUpgrade Tool"));
		UpgradeTool.setItemMeta(UpgradeToolMeta);

		return UpgradeTool;
	}

	public ItemStack getTier1Axe() {

		ItemStack tier1axe = new ItemStack(Material.WOOD_AXE, 1);
		ItemMeta tier1axeMeta = tier1axe.getItemMeta();
		tier1axeMeta.setDisplayName(color("&6&lTier 1 Axe"));
		tier1axeMeta.setLore(Arrays.asList(color("&6Speed 1")));
		tier1axe.setItemMeta(tier1axeMeta);

		return tier1axe;
	}

	public ItemStack getTier2Axe() {

		ItemStack tier2axe = new ItemStack(Material.STONE_AXE, 1);
		ItemMeta tier2axeMeta = tier2axe.getItemMeta();
		tier2axeMeta.setDisplayName(color("&6&lTier 2 Axe"));
		tier2axeMeta.setLore(Arrays.asList(color("&6Speed 2")));
		tier2axe.setItemMeta(tier2axeMeta);

		return tier2axe;
	}

	public ItemStack getTier3Axe() {

		ItemStack tier3axe = new ItemStack(Material.IRON_AXE, 1);
		ItemMeta tier3axeMeta = tier3axe.getItemMeta();
		tier3axeMeta.setDisplayName(color("&6&lTier 3 Axe"));
		tier3axeMeta.setLore(Arrays.asList(color("&6Speed 3")));
		tier3axe.setItemMeta(tier3axeMeta);

		return tier3axe;
	}

	public ItemStack getTier1PickAxe() {

		ItemStack tier1pickaxe = new ItemStack(Material.WOOD_PICKAXE, 1);
		ItemMeta tier1pickaxeMeta = tier1pickaxe.getItemMeta();
		tier1pickaxeMeta.setDisplayName(color("&6&lTier 1 PickAxe"));
		tier1pickaxeMeta.setLore(Arrays.asList(color("&6Speed 1")));
		tier1pickaxe.setItemMeta(tier1pickaxeMeta);

		return tier1pickaxe;
	}

	public ItemStack getTier2PickAxe() {

		ItemStack tier2pickaxe = new ItemStack(Material.STONE_PICKAXE, 1);
		ItemMeta tier2pickaxeMeta = tier2pickaxe.getItemMeta();
		tier2pickaxeMeta.setDisplayName(color("&6&lTier 2 PickAxe"));
		tier2pickaxeMeta.setLore(Arrays.asList(color("&6Speed 2")));
		tier2pickaxe.setItemMeta(tier2pickaxeMeta);

		return tier2pickaxe;
	}

	public ItemStack getTier3PickAxe() {

		ItemStack tier3pickaxe = new ItemStack(Material.IRON_PICKAXE, 1);
		ItemMeta tier3pickaxeMeta = tier3pickaxe.getItemMeta();
		tier3pickaxeMeta.setDisplayName(color("&6&lTier 3 PickAxe"));
		tier3pickaxeMeta.setLore(Arrays.asList(color("&6Speed 3")));
		tier3pickaxe.setItemMeta(tier3pickaxeMeta);

		return tier3pickaxe;
	}


	//
	//  ORES
	//

	public ItemStack getWood() {

		ItemStack wood = new ItemStack(Material.LOG, 2);
		ItemMeta woodMeta = wood.getItemMeta();
		woodMeta.setDisplayName(color("&8&lWood"));
		wood.setItemMeta(woodMeta);

		return wood;
	}


	public ItemStack getStone() {

		ItemStack stone = new ItemStack(Material.STONE, 2);
		ItemMeta stoneMeta = stone.getItemMeta();
		stoneMeta.setDisplayName(color("&7&lStone"));
		stone.setItemMeta(stoneMeta);

		return stone;
	}


	public ItemStack getIron() {


		ItemStack iron = new ItemStack(Material.IRON_INGOT, 2);
		ItemMeta ironMeta = iron.getItemMeta();
		ironMeta.setDisplayName(color("&f&lIron"));
		iron.setItemMeta(ironMeta);

		return iron;
	}


	public ItemStack getFuel() {


		ItemStack fuel = new ItemStack(Material.COAL, 2);
		ItemMeta fuelMeta = fuel.getItemMeta();
		fuelMeta.setDisplayName(color("&c&lFuel"));
		fuel.setItemMeta(fuelMeta);

		return fuel;
	}


	public ItemStack getSulfur() {


		ItemStack sulfur = new ItemStack(Material.GOLD_ORE, 1);
		ItemMeta sulfurMeta = sulfur.getItemMeta();
		sulfurMeta.setDisplayName(color("&e&lSulfur"));
		sulfur.setItemMeta(sulfurMeta);

		return sulfur;
	}


}
