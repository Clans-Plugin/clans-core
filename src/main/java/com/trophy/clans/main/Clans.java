package com.trophy.clans.main;

import com.trophy.clans.clansystem.ChatListener;
import com.trophy.clans.clansystem.ClanCommands;
import com.trophy.clans.clansystem.CoreBlockListener;
import com.trophy.clans.clansystem.ExplosiveListener;
import com.trophy.clans.craftingsystem.CraftingListener;
import com.trophy.clans.craftingsystem.CraftingTaskHandler;
import com.trophy.clans.customarmour.ArmourListener;
import com.trophy.clans.customore.ResourcesListener;
import com.trophy.clans.database.FirstJoinListener;
import com.trophy.clans.levelingsystem.LevelingCommands;
import com.trophy.clans.lootbarrels.LootListener;
import com.trophy.clans.utility.Items;
import com.trophy.clans.utility.MenuListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clans extends JavaPlugin {

	private static Connection connection;
	private String host, database, username, password;
	private int port;
	private final Items items = new Items();

	private CraftingTaskHandler taskHandler;

	public static Connection getConnection() {
		return connection;
	}

	@Override
	public void onEnable() {

		this.taskHandler = new CraftingTaskHandler(this, items);

		registerTasks();
		registerCMD();
		registerListeners();


		host = "178.63.127.184";
		port = 3306;
		username = "u5624_fY16jUyDAu";
		password = "CCTtfGg0Ypj..s6nhmKvHB.1";
		database = "s5624_trophy";

		connectDatabase();

		createTables();
	}

	private void registerTasks() {
		new ArmourListener(items, this);
	}

	private void registerCMD() {
		getCommand("clan").setExecutor(new ClanCommands(items));
		getCommand("level").setExecutor(new LevelingCommands());
	}

	private void createTables() {

		//BARREL DATA

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS BarrelData (x varchar(20), y varchar(20), z varchar(20), tier int)");


			final boolean rs = ps.execute();


			System.out.println("Clans --> Loaded BarrelData");


		} catch (final SQLException e) {
			e.printStackTrace();
		}

		//PLAYER DATA

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PlayerData (UUID varchar(64), Level int, XP int, Points int, ClanName varchar(64))");


			final boolean rs = ps.execute();


			System.out.println("Clans --> Loaded PlayerData");


		} catch (final SQLException e) {
			e.printStackTrace();
		}

		//CLANS DATA

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS ClansData (clanName varchar(64), owner varchar(64), points int, homex int, homey int, homez int, claim varchar(20))");


			final boolean rs = ps.execute();


			System.out.println("Clans --> Loaded ClansData");


		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}

	private void connectDatabase() {

		try {
			openConnection();
			System.out.println("Clans --> Connected to database: " + database);
		} catch (
				final SQLException x) {
			x.printStackTrace();
		}

	}

	private void registerListeners() {

		final PluginManager plm = org.bukkit.Bukkit.getPluginManager();

		plm.registerEvents(new ResourcesListener(this, items), this);
		plm.registerEvents(new CoreBlockListener(), this);
		plm.registerEvents(new CraftingListener(items, taskHandler), this);
		plm.registerEvents(new ExplosiveListener(), this);
		plm.registerEvents(new LootListener(), this);
		plm.registerEvents(new MenuListener(), this);
		plm.registerEvents(new FirstJoinListener(), this);
		plm.registerEvents(new ChatListener(), this);
	}


	private void openConnection() throws SQLException {

		if (connection != null && !connection.isClosed()) {
			return;
		}

		connection = DriverManager.getConnection("jdbc:mysql://"
						+ this.host + ":" + this.port + "/" + this.database,
				this.username, this.password);

	}

}