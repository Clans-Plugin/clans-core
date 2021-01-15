package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.Items;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
public class PlayerCraftingTask {

	private final Items items;
	private final ItemStack item;
	private int currentAmount;
	private final int taskIntervalTime;
	private int currentTime;

	public PlayerCraftingTask(final ItemStack item, final int totalAmount, final Items items) {
		this.item = item;
		this.items = items;
		this.currentAmount = totalAmount;
		this.taskIntervalTime = getIntervalTime();
		this.currentTime = taskIntervalTime;
	}

	private int getIntervalTime() {

		if (item.isSimilar(items.getC4())) {
			return 600;
		} else if (item.isSimilar(items.getTier1Wall())) {
			return 10;
		} else if (item.isSimilar(items.getTier2Wall())) {
			return 30;
		} else if (item.isSimilar(items.getTier3Wall())) {
			return 60;
		} else if (item.isSimilar(items.getTier1Door())) {
			return 60;
		} else if (item.isSimilar(items.getTier2Door())) {
			return 120;
		} else if (item.isSimilar(items.getChest())) {
			return 120;
		} else if (item.isSimilar(items.getUpgradeTool())) {
			return 300;
		} else if (item.isSimilar(items.getTier1Axe())) {
			return 20;
		} else if (item.isSimilar(items.getTier2Axe())) {
			return 40;
		} else if (item.isSimilar(items.getTier3Axe())) {
			return 80;
		} else if (item.isSimilar(items.getTier1Pickaxe())) {
			return 20;
		} else if (item.isSimilar(items.getTier2Pickaxe())) {
			return 40;
		} else if (item.isSimilar(items.getTier3Pickaxe())) {
			return 80;
		} else if (item.isSimilar(items.getTier1Helmet())) {
			return 30;
		} else if (item.isSimilar(items.getTier1Chestplate())) {
			return 30;
		} else if (item.isSimilar(items.getTier1Leggings())) {
			return 30;
		} else if (item.isSimilar(items.getTier1Boots())) {
			return 30;
		} else if (item.isSimilar(items.getTier2Helmet())) {
			return 60;
		} else if (item.isSimilar(items.getTier2Chestplate())) {
			return 60;
		} else if (item.isSimilar(items.getTier2Leggings())) {
			return 60;
		} else if (item.isSimilar(items.getTier2Boots())) {
			return 60;
		} else if (item.isSimilar(items.getTier3Helmet())) {
			return 120;
		} else if (item.isSimilar(items.getTier3Chestplate())) {
			return 120;
		} else if (item.isSimilar(items.getTier3Leggings())) {
			return 120;
		} else if (item.isSimilar(items.getTier3Boots())) {
			return 120;
		}
		return 10;
	}
}
