package com.trophy.clans.database;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	//Get Clan home

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
				final Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
				return (loc);
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

	public static String getClanPoints(final String clanName) {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT points FROM ClansData WHERE clanName=?");

			ps.setString(1, clanName);
			final ResultSet rs = ps.executeQuery();
			final String points;
			if (rs.next()) {

				points = rs.getString("points");

				return points;

			}

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}


	//Get top clans

	public static HashMap getTopClans() {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT clanName, points FROM ClansData ORDER BY points DESC");

			final ResultSet rs = ps.executeQuery();

			final HashMap<Integer, String> topClans = new HashMap<>();
			int rank = 0;
			while (rs.next() && rank < 11) {
				rank++;
				final String name = rs.getString("clanName");

				topClans.put(rank, name);

				return topClans;
			}

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}

}


