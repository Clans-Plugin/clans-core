package com.trophy.clans.lootbarrels;

import com.trophy.clans.main.Clans;
import org.bukkit.Bukkit;
import org.bukkit.Location;

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

	public static int getLootBarrel(final String x, final String y, final String z) {

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
		return 0;
	}


	//GET ALL LOOTBARRELS

	public static HashMap<Location, Integer> getAllLootBarrel() {

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("SELECT * FROM BarrelData");

			final ResultSet rs = ps.executeQuery();
			final HashMap<Location, Integer> list = new HashMap<>();

			while (rs.next()) {

				final int x = rs.getInt("x");
				final int y = rs.getInt("y");
				final int z = rs.getInt("z");
				final int tier = rs.getInt("tier");

				list.put(new Location(Bukkit.getWorld("world"), x, y, z), tier);

			}

			return list;

		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
