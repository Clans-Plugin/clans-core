package com.trophy.clans.database;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLInstance {

	private static final String host = "178.63.127.184";
	private static final String port = "3306";
	private static final String username = "u5624_fY16jUyDAu";
	private static final String password = "CCTtfGg0Ypj..s6nhmKvHB.1";
	private static final String database = "s5624_trophy";
	public static Connection con;

	static ConsoleCommandSender console = Bukkit.getConsoleSender();

	// connect
	public static void connect() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				console.sendMessage("\247c[\2476Clans\247c] \247bConnected to database!");
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// disconnect
	public static void disconnect() {
		if (isConnected()) {
			try {
				con.close();
				console.sendMessage("\247c[\2476Clans\247c] \247bDatabase connection closed!");
			} catch (final SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// isConnected
	public static boolean isConnected() {
		return (con == null ? false : true);
	}

	// getConnection
	public static Connection getConnection() {
		return con;
	}


	public static void createTables() {

		//BARREL DATA

		try {
			final PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS BarrelData (x varchar(20), y varchar(20), z varchar(20), tier int)");


			final boolean rs = ps.execute();

			console.sendMessage("\247c[\2476Clans\247c] \247bLoaded BarrelData!");


		} catch (final SQLException e) {
			e.printStackTrace();
		}

		//PLAYER DATA

		try {
			final PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PlayerData (UUID varchar(64), Level int, XP int, Points int, ClanName varchar(64))");


			final boolean rs = ps.execute();


			console.sendMessage("\247c[\2476Clans\247c] \247bLoaded PlayerData!");


		} catch (final SQLException e) {
			e.printStackTrace();
		}

		//CLANS DATA

		try {
			final PreparedStatement ps = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ClansData (clanName varchar(64), owner varchar(64), points int, homex int, homey int, homez int, claimx int, claimy int, claimz int)");


			final boolean rs = ps.execute();


			console.sendMessage("\247c[\2476Clans\247c] \247bLoaded ClansData!");


		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}

}
