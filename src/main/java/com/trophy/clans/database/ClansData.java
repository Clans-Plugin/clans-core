package com.trophy.clans.database;

import com.trophy.clans.main.Clans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClansData {

	//Create a Clan
	public static void createClan(final String clanName, final String owner, final int points, final int homex, final int homey, final int homez, final String claim) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("INSERT INTO ClansData (clanName,owner,points,homex,homey,homez,claim) VALUES (?,?,?,?,?,?,?)");

			ps.setString(1, clanName);
			ps.setString(2, owner);
			ps.setInt(3, points);
			ps.setInt(4, homex);
			ps.setInt(5, homey);
			ps.setInt(6, homez);
			ps.setString(7, claim);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	//Check if clan exists

	public static boolean checkClanExists(final String clanName) {

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT ClanName FROM ClansData WHERE ClanName=?");

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

	public static int memberNumber(final String clanName) {

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT ClanName FROM ClansData WHERE ClanName=?");

			ps.setString(1, clanName);
			final ResultSet rs = ps.executeQuery();
			int members = 0;

			while (rs.next()) {

				members++;
				System.out.println(members);
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
			final PreparedStatement ps = Clans.getConnection().prepareStatement("UPDATE ClansData SET homex=?, homey=?, homez=? WHERE ClanName=?");
			ps.setInt(1, homex);
			ps.setInt(2, homey);
			ps.setInt(3, homez);
			ps.setString(4, clanName);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}


}


