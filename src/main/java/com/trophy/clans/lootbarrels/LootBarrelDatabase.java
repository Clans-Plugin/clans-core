package com.trophy.clans.lootbarrels;

import com.trophy.clans.main.Clans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LootBarrelDatabase {

	//ADD loot barrel to database
	public static void addBarrel(final String x, final String y, final String z, final Integer tier) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("INSERT INTO BarrelData (x,y,z,tier) VALUES (?,?,?,?)");

			ps.setString(1, x);
			ps.setString(2, y);
			ps.setString(3, z);
			ps.setInt(4, tier);
			ps.executeUpdate();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	//REMOVE loot barrel from database
	public static void removeBarrel(final String x, final String y, final String z) {
		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("DELETE * FROM BarrelData WHERE (x,y,z) VALUES (?,?,?)");

			ps.setString(1, x);
			ps.setString(2, y);
			ps.setString(3, z);
			ps.executeQuery();
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	//Get loot barrel tier from location

	public static Integer getLootBarrel(final String x, final String y, final String z) {

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT tier FROM BarrelData WHERE (x,y,z) VALUES (?,?,?)");

			ps.setString(1, x);
			ps.setString(2, y);
			ps.setString(3, z);
			final ResultSet rs = ps.executeQuery();
			int tier = 0;
			if (rs.next()) {

				tier = rs.getInt("tier");
				return (tier);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	//GET ALL LOOTBARRELS

	public static HashMap getAllLootBarrel() {


		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT * FROM BarrelData");

			final ResultSet rs = ps.executeQuery();
			HashMap list = new HashMap();

			while (rs.next()) {

				????

				return (list);
			}

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
