package com.trophy.clans.utility;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
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

	public ItemStack getExplosive(Integer amount) {

		ItemStack c4 = new ItemStack(Material.TNT, amount);
		ItemMeta c4Meta = c4.getItemMeta();
		c4Meta.setDisplayName(color("&c&lC4"));
		c4.setItemMeta(c4Meta);

		return c4;
	}

	public ItemStack getTier1Wall(Integer amount) {

		ItemStack t1 = new ItemStack(Material.WOOD, amount);
		ItemMeta t1Meta = t1.getItemMeta();
		t1Meta.setDisplayName(color("&6&lTier I Wall"));
		t1.setItemMeta(t1Meta);


		return t1;
	}

	public ItemStack getTier2Wall(Integer amount) {


		ItemStack t2 = new ItemStack(Material.BRICK, amount);
		ItemMeta t2Meta = t2.getItemMeta();
		t2Meta.setDisplayName(color("&6&lTier 2 Wall"));
		t2.setItemMeta(t2Meta);

		return t2;
	}

	public ItemStack getTier3Wall(Integer amount) {


		ItemStack t3 = new ItemStack(Material.OBSIDIAN, amount);
		ItemMeta t3Meta = t3.getItemMeta();
		t3Meta.setDisplayName(color("&6&lTier 3 Wall"));
		t3.setItemMeta(t3Meta);

		return t3;
	}

	public ItemStack getDoorT1() {

		ItemStack door = new ItemStack(Material.WOOD_DOOR, 1);
		ItemMeta doorMeta = door.getItemMeta();
		doorMeta.setDisplayName(color("&6&lTier 1 Door"));
		door.setItemMeta(doorMeta);

		return door;
	}

	public ItemStack getDoorT2() {

		ItemStack door2 = new ItemStack(Material.IRON_DOOR, 1);
		ItemMeta door2Meta = door2.getItemMeta();
		door2Meta.setDisplayName(color("&6&lTier 2 Door"));
		door2.setItemMeta(door2Meta);

		return door2;
	}

	public ItemStack getChest(Integer amount) {

		ItemStack chest = new ItemStack(Material.CHEST, amount);
		ItemMeta chestMeta = chest.getItemMeta();
		chestMeta.setDisplayName(color("&6&lChest"));
		chest.setItemMeta(chestMeta);

		return chest;
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

	public ItemStack getWood(Integer amount) {

		ItemStack wood = new ItemStack(Material.LOG, amount);
		ItemMeta woodMeta = wood.getItemMeta();
		woodMeta.setDisplayName(color("&8&lWood"));
		wood.setItemMeta(woodMeta);

		return wood;
	}


	public ItemStack getStone(Integer amount) {

		ItemStack stone = new ItemStack(Material.STONE, amount);
		ItemMeta stoneMeta = stone.getItemMeta();
		stoneMeta.setDisplayName(color("&7&lStone"));
		stone.setItemMeta(stoneMeta);

		return stone;
	}


	public ItemStack getIron(Integer amount) {


		ItemStack iron = new ItemStack(Material.IRON_INGOT, amount);
		ItemMeta ironMeta = iron.getItemMeta();
		ironMeta.setDisplayName(color("&f&lIron"));
		iron.setItemMeta(ironMeta);

		return iron;
	}


	public ItemStack getFuel(Integer amount) {


		ItemStack fuel = new ItemStack(Material.COAL, amount);
		ItemMeta fuelMeta = fuel.getItemMeta();
		fuelMeta.setDisplayName(color("&c&lFuel"));
		fuel.setItemMeta(fuelMeta);

		return fuel;
	}


	public ItemStack getSulfur(Integer amount) {


		ItemStack sulfur = new ItemStack(Material.GOLD_ORE, amount);
		ItemMeta sulfurMeta = sulfur.getItemMeta();
		sulfurMeta.setDisplayName(color("&e&lSulfur Ore"));
		sulfur.setItemMeta(sulfurMeta);

		return sulfur;
	}

	public ItemStack getCookedSulfur(Integer amount) {


		ItemStack sulfur = new ItemStack(Material.GOLD_INGOT, amount);
		ItemMeta sulfurMeta = sulfur.getItemMeta();
		sulfurMeta.setDisplayName(color("&e&lSulfur"));
		sulfur.setItemMeta(sulfurMeta);

		return sulfur;
	}

	//
	//ARMOUR & WEAPONS
	//
	public ItemStack getTierOneHelmet() {

		ItemStack TierOneHelmet = new ItemStack(Material.IRON_HELMET, 1);
		ItemMeta TierOneHelmetMeta = TierOneHelmet.getItemMeta();
		TierOneHelmetMeta.setDisplayName(color("&f&lHelmet - Tier I"));
		TierOneHelmet.setItemMeta(TierOneHelmetMeta);

		return TierOneHelmet;
	}

	public ItemStack getTierOneChestplate() {

		ItemStack TierOneChestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta TierOneChestplateMeta = TierOneChestplate.getItemMeta();
		TierOneChestplateMeta.setDisplayName(color("&f&lChestplate - Tier I"));
		TierOneChestplate.setItemMeta(TierOneChestplateMeta);

		return TierOneChestplate;
	}

	public ItemStack getTierOneLeggings() {

		ItemStack TierOneLeggings = new ItemStack(Material.IRON_LEGGINGS, 1);
		ItemMeta TierOneLeggingsMeta = TierOneLeggings.getItemMeta();
		TierOneLeggingsMeta.setDisplayName(color("&f&lLeggings - Tier I"));
		TierOneLeggings.setItemMeta(TierOneLeggingsMeta);

		return TierOneLeggings;
	}

	public ItemStack getTierOneBoots() {

		ItemStack TierOneBoots = new ItemStack(Material.IRON_BOOTS, 1);
		ItemMeta TierOneBootsMeta = TierOneBoots.getItemMeta();
		TierOneBootsMeta.setDisplayName(color("&f&lBoots - Tier I"));
		TierOneBoots.setItemMeta(TierOneBootsMeta);

		return TierOneBoots;
	}

	public ItemStack getTierTwoHelmet() {

		ItemStack TierTwoHelmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
		ItemMeta TierTwoHelmetMeta = TierTwoHelmet.getItemMeta();
		TierTwoHelmetMeta.setDisplayName(color("&f&lHelmet - Tier II"));
		TierTwoHelmet.setItemMeta(TierTwoHelmetMeta);

		return TierTwoHelmet;
	}

	public ItemStack getTierTwoChestplate() {


		ItemStack TierTwoChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
		ItemMeta TierTwoChestplateMeta = TierTwoChestplate.getItemMeta();
		TierTwoChestplateMeta.setDisplayName(color("&f&lChestplate - Tier II"));
		TierTwoChestplate.setItemMeta(TierTwoChestplateMeta);

		return TierTwoChestplate;
	}

	public ItemStack getTierTwoLeggings() {


		ItemStack TierTwoLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta TierTwoLeggingsMeta = TierTwoLeggings.getItemMeta();
		TierTwoLeggingsMeta.setDisplayName(color("&f&lLeggings - Tier II"));
		TierTwoLeggings.setItemMeta(TierTwoLeggingsMeta);

		return TierTwoLeggings;
	}

	public ItemStack getTierTwoBoots() {

		ItemStack TierTwoBoots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
		ItemMeta TierTwoBootsMeta = TierTwoBoots.getItemMeta();
		TierTwoBootsMeta.setDisplayName(color("&f&lBoots - Tier II"));
		TierTwoBoots.setItemMeta(TierTwoBootsMeta);

		return TierTwoBoots;
	}

	public ItemStack getTierThreeHelmet() {


		ItemStack TierThreeHelmet = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta TierThreeHelmetMeta = TierThreeHelmet.getItemMeta();
		TierThreeHelmetMeta.setDisplayName(color("&f&lHelmet - Tier III"));
		TierThreeHelmet.setItemMeta(TierThreeHelmetMeta);

		return TierThreeHelmet;
	}

	public ItemStack getTierThreeChestplate() {


		ItemStack TierThreeChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta TierThreeChestplateMeta = TierThreeChestplate.getItemMeta();
		TierThreeChestplateMeta.setDisplayName(color("&f&lChestplate - Tier III"));
		TierThreeChestplate.setItemMeta(TierThreeChestplateMeta);

		return TierThreeChestplate;
	}

	public ItemStack getTierThreeLeggings() {


		ItemStack TierThreeLeggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
		ItemMeta TierThreeLeggingsMeta = TierThreeLeggings.getItemMeta();
		TierThreeLeggingsMeta.setDisplayName(color("&f&lLeggings - Tier III"));
		TierThreeLeggings.setItemMeta(TierThreeLeggingsMeta);

		return TierThreeLeggings;
	}

	public ItemStack getTierThreeBoots() {

		ItemStack TierThreeBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);
		ItemMeta TierThreeBootsMeta = TierThreeBoots.getItemMeta();
		TierThreeBootsMeta.setDisplayName(color("&f&lBoots - Tier III"));
		TierThreeBoots.setItemMeta(TierThreeBootsMeta);

		return TierThreeBoots;
	}

	public ItemStack getTierOneSword() {

		ItemStack TierOneSword = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta TierOneSwordMeta = TierOneSword.getItemMeta();
		TierOneSwordMeta.setDisplayName(color("&c&lSword - Tier I"));
		TierOneSword.setItemMeta(TierOneSwordMeta);

		return TierOneSword;
	}

	public ItemStack getTierTwoSword() {

		ItemStack TierTwoSword = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta TierTwoSwordMeta = TierTwoSword.getItemMeta();
		TierTwoSwordMeta.setDisplayName(color("&c&lSword - Tier II"));
		TierTwoSword.setItemMeta(TierTwoSwordMeta);

		return TierTwoSword;
	}

	public ItemStack getTierThreeSword() {

		ItemStack TierThreeSword = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta TierThreeSwordMeta = TierThreeSword.getItemMeta();
		TierThreeSwordMeta.setDisplayName(color("&c&lSword - Tier III"));
		TierThreeSword.setItemMeta(TierThreeSwordMeta);

		return TierThreeSword;
	}

	//
	//
	//
	//  GIVE ITEM METHOD
	//
	//
	//


	public void giveCustomItem(Player target, ItemStack item) {

		target.getInventory().addItem(item);
		target.sendMessage(color(item.getAmount() + "x " + item.getItemMeta().getDisplayName() + " &chas been added to your inventory!"));


	}

	//ALL TIMES IN SECONDS DUE TO COSMETIC REASONS --> CONVERT TO TICKS IN CLASS YOU ARE USING IT

	public Integer getCraftTime(ItemStack item, Integer amount) {

		Integer time = 0;

		if (item.equals(getTierOneBoots())) {

			time = 10;

		}


		return time * amount;
	}

}
