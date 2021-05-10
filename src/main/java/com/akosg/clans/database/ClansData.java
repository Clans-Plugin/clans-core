package com.akosg.clans.database;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClansData {

	//Create a Clan
	public static void createClan(final String clanName, final String owner, final int points, final int homex, final int homey, final int homez, final int claimx, final int claimy, final int claimz, final int level) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("INSERT INTO ClansData (clanName,owner,points,homex,homey,homez,claimx,claimy,claimz,level) VALUES (?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, clanName);
			ps.setString(2, owner);
			ps.setInt(3, points);
			ps.setInt(4, homex);
			ps.setInt(5, homey);
			ps.setInt(6, homez);
			ps.setInt(7, claimx);
			ps.setInt(8, claimy);
			ps.setInt(9, claimz);
			ps.setInt(10, level);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	//REMOVE Clan
	public static void removeClan(final String clanName) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("DELETE FROM ClansData WHERE clanName=?");

			ps.setString(1, clanName);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

//Check if clan exists

	public static boolean checkClanExists(final String clanName) {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT clanName FROM ClansData WHERE clanName=?");

			ps.setString(1, clanName);
			final ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				return true;

			}

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return false;
	}

	//Get number of ALL players in a clan
	public static int memberNumber(final String clanName) {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT clanName FROM ClansData WHERE clanName=?");

			ps.setString(1, clanName);
			final ResultSet rs = ps.executeQuery();
			int members = 0;

			while (rs.next()) {

				members++;
			}

			return members;


		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


//Set clan home

	public static void setClanHome(final String clanName, final int homex, final int homey, final int homez) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("UPDATE ClansData SET homex=?, homey=?, homez=? WHERE clanName=?");
			ps.setInt(1, homex);
			ps.setInt(2, homey);
			ps.setInt(3, homez);
			ps.setString(4, clanName);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}

//Get Clan core location

	public static Location getClanCoreLocation(final String clanName) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT claimx, claimy, claimz FROM ClansData WHERE clanName = ?");
			ps.setString(1, clanName);
			final ResultSet rs = ps.executeQuery();
			final int x;
			final int y;
			final int z;


			if (rs.next()) {
				x = rs.getInt("claimx");
				y = rs.getInt("claimy");
				z = rs.getInt("claimz");
				return (new Location(Bukkit.getWorld("world"), x, y, z));
			}
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}


//Get owner of Core Block

	public static String getCoreBlockOwner(final int claimx, final int claimy, final int claimz) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT clanName FROM ClansData WHERE claimx = ? AND claimy = ? AND claimz = ?");
			ps.setInt(1, claimx);
			ps.setInt(2, claimy);
			ps.setInt(3, claimz);
			final ResultSet rs = ps.executeQuery();


			if (rs.next()) {

				return rs.getString("clanName");
			}
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return "not found";
	}

//Set Clan core location

	public static void setClanCoreLocation(final String clanName, final int claimx, final int claimy, final int claimz) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("UPDATE ClansData SET claimx=?, claimy=?, claimz=? WHERE clanName=?");
			ps.setInt(1, claimx);
			ps.setInt(2, claimy);
			ps.setInt(3, claimz);
			ps.setString(4, clanName);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}


//Set Clan points

	public static void setClanPoints(final String clanName, final int value) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("UPDATE ClansData SET points=? WHERE clanName=?");
			ps.setInt(1, value);
			ps.setString(2, clanName);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}


//Get ALL Clan core location

	public static ArrayList<Location> getAllClanCoreLocation() {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT claimx, claimy, claimz FROM ClansData");
			final ResultSet rs = ps.executeQuery();
			int x;
			int y;
			int z;

			final ArrayList<Location> list = new ArrayList<>();


			while (rs.next()) {


				x = rs.getInt("claimx");
				y = rs.getInt("claimy");
				z = rs.getInt("claimz");
				final Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
				list.add(loc);

			}

			return list;
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}

//Get ALL Clan core location

	public static HashMap<String, Location> getAllLocation() {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT clanName, claimx, claimy, claimz FROM ClansData");
			final ResultSet rs = ps.executeQuery();
			int x;
			int y;
			int z;

			final HashMap<String, Location> list = new HashMap<>();


			while (rs.next()) {


				x = rs.getInt("claimx");
				y = rs.getInt("claimy");
				z = rs.getInt("claimz");
				final Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
				list.put(rs.getString("clanName"), loc);

			}

			return list;
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}


//Get Clan claim

	public static Location getClanHome(final String clanName) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT homex, homey, homez FROM ClansData WHERE clanName = ?");
			ps.setString(1, clanName);
			final ResultSet rs = ps.executeQuery();
			final int x;
			final int y;
			final int z;


			if (rs.next()) {
				x = rs.getInt("homex");
				y = rs.getInt("homey");
				z = rs.getInt("homez");
				return (new Location(Bukkit.getWorld("world"), x, y, z));
			}
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}

//Check if clan exists

	public static String getOwner(final String clanName) {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT owner FROM ClansData WHERE clanName=?");

			ps.setString(1, clanName);
			final ResultSet rs = ps.executeQuery();
			final String owner;
			if (rs.next()) {

				owner = rs.getString("owner");

				return owner;

			}

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}

//Get points of a clan

	public static int getClanPoints(final String clanName) {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT points FROM ClansData WHERE clanName=?");

			ps.setString(1, clanName);
			final ResultSet rs = ps.executeQuery();
			final int points;
			if (rs.next()) {

				points = rs.getInt("points");

				return points;

			}

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return 0;
	}

//Get level of a Clan

	public static int getClanLevel(final String clanName) {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT level FROM ClansData WHERE clanName=?");

			ps.setString(1, clanName);
			final ResultSet rs = ps.executeQuery();
			final int level;
			if (rs.next()) {

				level = rs.getInt("level");

				return level;

			}

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return 0;
	}

//Set level of a Clan

	public static void setClanLevel(final String clanName, final int level) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("UPDATE ClansData SET level=? WHERE clanName=?");

			ps.setInt(1, level);
			ps.setString(2, clanName);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}


//Get top clans

	public static HashMap<String, Integer> getTopClans() {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT clanName, points FROM ClansData ORDER BY points DESC");

			final ResultSet rs = ps.executeQuery();

			final HashMap<String, Integer> topClans = new HashMap<>();

			while (rs.next()) {

				final String name = rs.getString("clanName");
				final int points = rs.getInt("points");

				topClans.put(name, points);


			}
			return topClans;

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}

}


