package com.trophy.clans.player;

import com.trophy.clans.craftingsystem.PlayerCraftingTask;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerData {

	private int level = 0;
	private int xp = 0;
	private int points = 0;
	private final PlayerCraftingTask craftingTask;

	public PlayerData(final int level, final int xp, final int points, final PlayerCraftingTask craftingTask) {
		this.level = level;
		this.xp = xp;
		this.points = points;
		this.craftingTask = craftingTask;
	}

	public PlayerData() {
		this.craftingTask = new PlayerCraftingTask();
	}

}
