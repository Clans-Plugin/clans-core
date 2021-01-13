package com.trophy.clans.craftingsystem;

import com.trophy.clans.main.Clans;
import lombok.Getter;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.UUID;

@Getter
public class CraftingTaskHandler {

	private final HashMap<UUID, PlayerCraftingTask> craftingTasks = new HashMap<>();
	private final Clans plugin;

	public CraftingTaskHandler(final Clans plugin) {
		this.plugin = plugin;
		startTaskExecution();
	}

	private void startTaskExecution() {

		Bukkit.getScheduler().runTaskTimer(plugin, () -> {


		}, 0L, 20L);
	}
}
