package com.trophy.clans.craftingsystem;

import com.trophy.clans.main.Clans;
import com.trophy.clans.utility.Items;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

@Getter
public class CraftingTaskHandler {

	private final HashMap<UUID, PlayerCraftingTask> craftingTasks = new HashMap<>();
	private final Clans plugin;
	private final Items items;

	public CraftingTaskHandler(final Clans plugin, final Items items) {
		this.plugin = plugin;
		this.items = items;
		startTaskExecution();
	}

	private void startTaskExecution() {

		Bukkit.getScheduler().runTaskTimer(plugin, () -> {

			for (final Player player : Bukkit.getOnlinePlayers()) {

				if (craftingTasks.containsKey(player.getUniqueId())) {

					final PlayerCraftingTask craftingTask = craftingTasks.get(player.getUniqueId());

					if (craftingTask.getCurrentTime() <= 0) {

						player.getInventory().addItem(craftingTask.getItem());
						craftingTask.setCurrentTime(craftingTask.getTaskIntervalTime());
						craftingTask.setCurrentAmount(craftingTask.getCurrentAmount() - 1);

						if (craftingTask.getCurrentAmount() <= 0) {
							craftingTasks.remove(player.getUniqueId());
							continue;
						}
					}
					craftingTask.setCurrentTime(craftingTask.getCurrentTime() - 1);
					player.setLevel(craftingTask.getCurrentAmount());
					player.setExp((float) (craftingTask.getCurrentTime() / craftingTask.getTaskIntervalTime()));
				}
			}
		}, 0L, 20L);
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
