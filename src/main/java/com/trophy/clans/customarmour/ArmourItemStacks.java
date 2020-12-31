package com.trophy.clans.customarmour;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ArmourItemStacks {

	private String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public ItemStack getTierOneHelmet() {

		ItemStack TierOneHelmet = new ItemStack(Material.IRON_HELMET);
		ItemMeta TierOneHelmetMeta = TierOneHelmet.getItemMeta();
		TierOneHelmetMeta.setDisplayName(color("&f&lHelmet - Tier I"));
		TierOneHelmet.setItemMeta(TierOneHelmetMeta);

		return TierOneHelmet;
	}

	public ItemStack getTierOneChestplate() {

		ItemStack TierOneChestplate = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta TierOneChestplateMeta = TierOneChestplate.getItemMeta();
		TierOneChestplateMeta.setDisplayName(color("&f&lChestplate - Tier I"));
		TierOneChestplate.setItemMeta(TierOneChestplateMeta);

		return TierOneChestplate;
	}

	public ItemStack getTierOneLeggings() {

		ItemStack TierOneLeggings = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta TierOneLeggingsMeta = TierOneLeggings.getItemMeta();
		TierOneLeggingsMeta.setDisplayName(color("&f&lLeggings - Tier I"));
		TierOneLeggings.setItemMeta(TierOneLeggingsMeta);

		return TierOneLeggings;
	}

	public ItemStack getTierOneBoots() {

		ItemStack TierOneBoots = new ItemStack(Material.IRON_BOOTS);
		ItemMeta TierOneBootsMeta = TierOneBoots.getItemMeta();
		TierOneBootsMeta.setDisplayName(color("&f&lBoots - Tier I"));
		TierOneBoots.setItemMeta(TierOneBootsMeta);

		return TierOneBoots;
	}
	
	public ItemStack getTierTwoHelmet() {


		return null;
	}

	public ItemStack getTierTwoChestplate() {


		return null;
	}

	public ItemStack getTierTwoLeggings() {


		return null;
	}

	public ItemStack getTierTwoBoots() {

		return null;
	}
	
	public ItemStack getTierThreeHelmet() {


		return null;
	}

	public ItemStack getTierThreeChestplate() {


		return null;
	}

	public ItemStack getTierThreeLeggings() {


		return null;
	}

	public ItemStack getTierThreeBoots() {

		return null;
	}


}
