package com.trophy.clans.craftingsystem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PlayerCraftingTask {

	private final ItemStack item;
	private final int totalAmount;
	private final int currentAmount;
	private final int intervalTime;
	private final int currentTime;

	public PlayerCraftingTask(final ItemStack item, final int totalAmount, final int intervalTime) {
		this.item = item;
		this.totalAmount = totalAmount;
		this.currentAmount = totalAmount;
		this.intervalTime = intervalTime;
		this.currentTime = intervalTime;
	}

	public PlayerCraftingTask() {
		this.item = new ItemStack(Material.AIR);
		this.totalAmount = 0;
		this.currentAmount = 0;
		this.intervalTime = 0;
		this.currentTime = 0;
	}
}
