package com.trophy.clans.player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerData {

	private int level = 25;
	private int xp = 0;
	private int points = 0;

	public PlayerData(final int level, final int xp, final int points) {
		this.level = level;
		this.xp = xp;
		this.points = points;
	}

	public PlayerData() {
	}

}
