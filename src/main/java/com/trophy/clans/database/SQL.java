package com.trophy.clans.database;

import com.trophy.clans.main.Clans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {

	public static void firstJoin(final String name, final String uuid) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("INSERT INTO PlayerData (UUID,Name,Level,XP,Points) VALUES (?,?,?,?,?)");

			ps.setString(1, uuid);
			ps.setString(2, name);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setInt(5, 0);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	//Check if uuid of player is in database

	public static boolean checkDatabaseExist(final String uuid) {

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT * FROM PlayerData WHERE UUID=?");

			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();
			return rs.next();

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return false;
	}


	//Check if the player name associated to the UUID in database is the same as current player name

	public static String checkDatabaseName(final String uuid) {

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT Name FROM PlayerData WHERE UUID=?");

			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return (rs.getString("Name"));
			}

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}

	//Update players name if name doesnt match UUID

	public static void updateName(final String uuid, final String name) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("UPDATE PlayerData SET Name=? WHERE UUID=?");
			ps.setString(1, name);
			ps.setString(2, uuid);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
}
