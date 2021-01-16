package com.trophy.clans.utility;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class RandomCollection<ItemStack> {
	private final NavigableMap<Double, ItemStack> map = new TreeMap<>();
	private final Random random;
	private double total = 0;

	public RandomCollection() {
		this(new Random());
	}

	public RandomCollection(final Random random) {
		this.random = random;
	}

	public RandomCollection<ItemStack> add(final double weight, final ItemStack result) {
		if (weight <= 0) return this;
		total += weight;
		map.put(total, result);
		return this;
	}

	public ItemStack next() {
		final double value = random.nextDouble() * total;
		return map.higherEntry(value).getValue();
	}
}