package com.trophy.clans.database;

import com.trophy.clans.main.Clans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQL {

	public static void firstJoin(final String uuid) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("INSERT INTO PlayerData (UUID,Level,XP,Points) VALUES (?,?,?,?)");

			ps.setString(1, uuid);
			ps.setInt(2, 0);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
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

	//Set player level.

	public static void updateLevel(final Integer level, final String uuid) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("UPDATE PlayerData SET Level=? WHERE UUID=?");

			ps.setInt(1, level);
			ps.setString(2, uuid);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}

	//Set player xp.


	public static void updateXP(final Integer xp, final String uuid) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("UPDATE PlayerData SET XP=? WHERE UUID=?");

			ps.setInt(1, xp);
			ps.setString(2, uuid);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}

	//Set player points.

	public static void updatePoints(final Integer points, final String uuid) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("UPDATE PlayerData SET Points=? WHERE UUID=?");

			ps.setInt(1, points);
			ps.setString(2, uuid);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}


	//Get players level. Requires UUID in a string format

	public static Integer getPlayerLevel(final String uuid) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT Level FROM PlayerData WHERE UUID = ?");
			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();
			Integer level = 0;
			if (rs.next()) {

				level = rs.getInt("Level");
				return (level);
			}


		} catch (final SQLException x) {

			x.printStackTrace();

		}


		return null;
	}

	//Get players xp. Requires UUID in a string format

	public static Integer getPlayerXP(final String uuid) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT XP FROM PlayerData WHERE UUID = ?");
			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();
			Integer xp = 0;
			if (rs.next()) {

				xp = rs.getInt("XP");
				return (xp);
			}


		} catch (final SQLException x) {

			x.printStackTrace();

		}


		return null;
	}

	//Get players points. Requires UUID in a string format

	public static Integer getPlayerPoints(final String uuid) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT Points FROM PlayerData WHERE UUID = ?");
			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();
			Integer points = 0;
			if (rs.next()) {

				points = rs.getInt("Points");
				return (points);
			}


		} catch (final SQLException x) {

			x.printStackTrace();

		}


		return null;
	}


}
