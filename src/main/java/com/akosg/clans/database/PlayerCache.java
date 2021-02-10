package com.akosg.clans.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerCache {

	private String clanName;
	private int level;
	private int xp;
	private int points;

	public PlayerCache(final String clanName, final int level, final int xp, final int points) {
		this.clanName = clanName;
		this.level = level;
		this.xp = xp;
		this.points = points;
	}

	public PlayerCache() {
		this.clanName = "Solo";
		this.level = 1;
		this.xp = 0;
		this.points = 0;
	}
}
