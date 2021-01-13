package com.trophy.clans.craftingsystem;

import com.trophy.clans.utility.Items;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

@Getter
@Setter
public class PlayerCraftingTask {

	private final Items items;
	private final ItemStack item;
	private int currentAmount;
	private final int intervalTime;
	private int currentTime;

	public PlayerCraftingTask(final ItemStack item, final int totalAmount, final Items items) {
		this.item = item;
		this.currentAmount = totalAmount;
		this.intervalTime = getIntervalTime();
		this.currentTime = intervalTime;
		this.items = items;
	}

	public int getIntervalTime() {

		// Return time in seconds

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


		return 0;
	}

	public HashMap<ItemStack, Integer> getCost(final ItemStack item) {

		final HashMap<ItemStack, Integer> costMap = new HashMap<>();

		if (item.isSimilar(items.getC4())) {

			costMap.put(items.getCookedsulfur(), 64);
			costMap.put(items.getIron(), 32);

		} else if (item.isSimilar(items.getTier1Wall())) {

			costMap.put(items.getWood(), 20);

		} else if (item.isSimilar(items.getTier2Wall())) {

			costMap.put(items.getWood(), 20);
			costMap.put(items.getStone(), 20);

		} else if (item.isSimilar(items.getTier3Wall())) {

			costMap.put(items.getWood(), 20);
			costMap.put(items.getIron(), 20);

		} else if (item.isSimilar(items.getTier1Door())) {

			costMap.put(items.getWood(), 40);

		} else if (item.isSimilar(items.getTier2Door())) {

			costMap.put(items.getIron(), 40);


		} else if (item.isSimilar(items.getChest())) {

			costMap.put(items.getWood(), 64);

		} else if (item.isSimilar(items.getUpgradeTool())) {

			costMap.put(items.getStone(), 64);
			costMap.put(items.getIron(), 64);

		} else if (item.isSimilar(items.getTier1Axe())) {

			costMap.put(items.getWood(), 20);

		} else if (item.isSimilar(items.getTier2Axe())) {

			costMap.put(items.getWood(), 20);
			costMap.put(items.getStone(), 20);

		} else if (item.isSimilar(items.getTier3Axe())) {

			costMap.put(items.getStone(), 20);
			costMap.put(items.getIron(), 20);

		} else if (item.isSimilar(items.getTier1Pickaxe())) {

			costMap.put(items.getWood(), 20);

		} else if (item.isSimilar(items.getTier2Pickaxe())) {

			costMap.put(items.getWood(), 20);
			costMap.put(items.getStone(), 20);

		} else if (item.isSimilar(items.getTier3Pickaxe())) {

			costMap.put(items.getStone(), 20);
			costMap.put(items.getIron(), 20);

		} else if (item.isSimilar(items.getTier1Helmet())) {

			costMap.put(items.getStone(), 30);

		} else if (item.isSimilar(items.getTier1Chestplate())) {

			costMap.put(items.getStone(), 30);

		} else if (item.isSimilar(items.getTier1Leggings())) {

			costMap.put(items.getStone(), 30);

		} else if (item.isSimilar(items.getTier1Boots())) {

			costMap.put(items.getStone(), 30);

		} else if (item.isSimilar(items.getTier2Helmet())) {

			costMap.put(items.getStone(), 60);

		} else if (item.isSimilar(items.getTier2Chestplate())) {

			costMap.put(items.getStone(), 60);

		} else if (item.isSimilar(items.getTier2Leggings())) {

			costMap.put(items.getStone(), 60);

		} else if (item.isSimilar(items.getTier2Boots())) {

			costMap.put(items.getStone(), 60);

		} else if (item.isSimilar(items.getTier3Helmet())) {

			costMap.put(items.getIron(), 30);

		} else if (item.isSimilar(items.getTier3Chestplate())) {

			costMap.put(items.getIron(), 30);

		} else if (item.isSimilar(items.getTier3Leggings())) {

			costMap.put(items.getIron(), 30);

		} else if (item.isSimilar(items.getTier3Boots())) {

			costMap.put(items.getIron(), 30);

		}

		return costMap;
	}
}
