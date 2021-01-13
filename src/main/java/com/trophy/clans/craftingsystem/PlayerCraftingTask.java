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

		}

		return costMap;
	}
}
