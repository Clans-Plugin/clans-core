package com.akosg.clans.database;


public class PlayerCache {

	private String clanName;
	private String donor;
	private int level;
	private int xp;
	private int points;

	public String getClanName() {
		return clanName;
	}

	public String getDonor() {
		return donor;
	}

	public int getLevel() {
		return level;
	}

	public int getXp() {
		return xp;
	}

	public int getPoints() {
		return points;
	}

	public void setClanName(final String clanName) {
		this.clanName = clanName;
	}

	public void setLevel(final int level) {
		this.level = level;
	}

	public void setXp(final int xp) {
		this.xp = xp;
	}

	public void setPoints(final int points) {
		this.points = points;
	}
	
	public void setDonor(String donor) {
		this.donor = donor;
	}

	public PlayerCache(final String clanName, final String donor, final int level, final int xp, final int points) {
		this.clanName = clanName;
		this.donor = donor;
		this.level = level;
		this.xp = xp;
		this.points = points;
	}

	public PlayerCache() {
		this.clanName = "Solo";
		this.donor = "false";
		this.level = 1;
		this.xp = 0;
		this.points = 0;
	}
}
