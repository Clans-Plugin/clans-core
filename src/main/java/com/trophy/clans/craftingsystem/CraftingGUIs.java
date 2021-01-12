package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CraftingGUIs {

	private final Items items;
	private final Inventory craftingInventory = Bukkit.createInventory(null, 45, "Crafting");
	private final Inventory raidingInventory = Bukkit.createInventory(null, 9, "Raiding");
	private final Inventory baseBlocksInventory = Bukkit.createInventory(null, 27, "Base blocks");
	private final Inventory toolsInventory = Bukkit.createInventory(null, 27, "Tools");

	public CraftingGUIs(final Items items) {
		this.items = items;
	}

	public void openRaidGui(final Player p) {


		p.openInventory(inv);


	}

	public void openBaseGui(final Player p) {


		inv.setItem(10, items.getTier1Wall(1));
		inv.setItem(11, items.getTier2Wall(1));
		inv.setItem(12, items.getTier3Wall(1));
		inv.setItem(14, items.getDoorT1());
		inv.setItem(15, items.getDoorT2());
		inv.setItem(16, items.getChest(1));

		p.openInventory(inv);


	}


	public void openToolsGui(final Player player) {


		inv.setItem(10, items.getTier1Pickaxe());
		inv.setItem(11, items.getTier2Pickaxe());
		inv.setItem(12, items.getTier3Pickaxe());
		inv.setItem(13, items.getUpgradeTool());
		inv.setItem(14, items.getTier1Axe());
		inv.setItem(15, items.getTier2Axe());
		inv.setItem(16, items.getTier3Axe());

		player.openInventory(inv);
	}

	public void openWeaponArmourGui(final Player p) {


		final Inventory inv = Bukkit.createInventory(null, 27, "Weapons & Armour");


		inv.setItem(1, items.getTierOneHelmet());
		inv.setItem(2, items.getTierOneChestplate());
		inv.setItem(3, items.getTierOneLeggings());
		inv.setItem(4, items.getTierOneBoots());
		inv.setItem(6, items.getTierOneSword());

		inv.setItem(10, items.getTierTwoHelmet());
		inv.setItem(11, items.getTierTwoChestplate());
		inv.setItem(12, items.getTierTwoLeggings());
		inv.setItem(13, items.getTierTwoBoots());
		inv.setItem(15, items.getTierTwoSword());

		inv.setItem(19, items.getTierThreeHelmet());
		inv.setItem(20, items.getTierThreeChestplate());
		inv.setItem(21, items.getTierThreeLeggings());
		inv.setItem(22, items.getTierThreeBoots());
		inv.setItem(24, items.getTierThreeSword());

		p.openInventory(inv);


	}


}
