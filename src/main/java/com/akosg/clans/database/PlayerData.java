package com.akosg.clans.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerData {

	//Check if player is in a clan

	public static boolean checkPlayerInClan(final String uuid) {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT ClanName FROM PlayerData WHERE UUID=?");

			ps.setString(1, uuid);

			final String solo = "Solo";
			final String name;
			final ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				name = rs.getString("ClanName");
				if (name.equalsIgnoreCase(solo)) {
					return false;
				}

			}

		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return true;
	}

	//Add player to Clan

	public static void setPlayerClan(final String ClanName, final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("UPDATE PlayerData SET ClanName=? WHERE UUID=?");
			ps.setString(1, ClanName);
			ps.setString(2, uuid);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}

	//Get player clan name

	public static String getClanName(final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT ClanName FROM PlayerData WHERE UUID = ?");
			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();
			final String name;
			if (rs.next()) {
				name = rs.getString("ClanName");
				return (name);
			}
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return null;
	}

	// ADD player to database
	public static void firstJoin(final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("INSERT INTO PlayerData (UUID,Level,XP,Points,ClanName) VALUES (?,?,?,?,?)");

			ps.setString(1, uuid);
			ps.setInt(2, 0);
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.setString(5, "Solo");
			ps.executeUpdate();
			System.out.println("ADDED TO DATABASE");
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	//Check if uuid of player is in database

	public static boolean checkDatabaseExist(final String uuid) {

		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT * FROM PlayerData WHERE UUID=?");

			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				return true;

			} else {

				return false;

			}

		} catch (final SQLException x) {
			x.printStackTrace();
		}

		return false;
	}

	//Set player level.

	public static void setLevel(final int level, final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("UPDATE PlayerData SET Level=? WHERE UUID=?");
			ps.setInt(1, level);
			ps.setString(2, uuid);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}

	//Set player xp.


	public static void setXP(final int xp, final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("UPDATE PlayerData SET XP=? WHERE UUID=?");

			ps.setInt(1, xp);
			ps.setString(2, uuid);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}

	//Set player points.

	public static void setPoints(final int points, final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("UPDATE PlayerData SET Points=? WHERE UUID=?");
			ps.setInt(1, points);
			ps.setString(2, uuid);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}


	//Set isDonor

	public static void setDonor(final String value, final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("UPDATE PlayerData SET Donor=? WHERE UUID=?");
			ps.setString(1, value);
			ps.setString(2, uuid);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}


	//Get players level. Requires UUID in a string format

	public static int getPlayerLevel(final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT Level FROM PlayerData WHERE UUID = ?");
			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();
			final int level;
			if (rs.next()) {
				level = rs.getInt("Level");
				return (level);
			}
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return 0;
	}


	//Get players level. Requires UUID in a string format

	public static String isDonor(final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT Donor FROM PlayerData WHERE UUID = ?");
			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();
			final String donor;
			if (rs.next()) {
				donor = rs.getString("Donor");
				return (donor);
			}
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return "null";
	}

	//Get players xp. Requires UUID in a string format

	public static int getPlayerXP(final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT XP FROM PlayerData WHERE UUID = ?");
			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();
			final int xp;
			if (rs.next()) {
				xp = rs.getInt("XP");
				return (xp);
			}
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return 0;
	}

	//Get players points. Requires UUID in a string format

	public static int getPlayerPoints(final String uuid) {
		try {
			final PreparedStatement ps = SQLInstance.getConnection().prepareStatement("SELECT Points FROM PlayerData WHERE UUID = ?");
			ps.setString(1, uuid);
			final ResultSet rs = ps.executeQuery();
			final int points;
			if (rs.next()) {
				points = rs.getInt("Points");
				return (points);
			}
		} catch (final SQLException x) {
			x.printStackTrace();
		}
		return 0;
	}


}
