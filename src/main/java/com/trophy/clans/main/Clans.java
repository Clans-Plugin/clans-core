package com.trophy.clans.main;

import com.trophy.clans.clansystem.ClanCommands;
import com.trophy.clans.clansystem.CoreBlockListener;
import com.trophy.clans.clansystem.ExplosiveListener;
import com.trophy.clans.craftingsystem.CraftingListener;
import com.trophy.clans.customarmour.ArmourListener;
import com.trophy.clans.customore.ResourcesListener;
import com.trophy.clans.lootbarrels.LootListner;
import com.trophy.clans.utility.Items;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Clans extends JavaPlugin {
	private static Clans instance;
	public static Plugin plugin;
	private static Connection connection;
	private String host, database, username, password;
	private int port;
	private Items items;

	public static Connection getConnection() {
		return connection;
	}

	@Override
	public void onEnable() {
		plugin = this;
		instance = this;
		this.registerCMD();
		this.registerListeners();
		this.registerTasks();

		this.items = new Items();

		host = "";
		port = 3306;
		username = "";
		password = "";
		database = "";

		try {
			openConnection();
			System.out.println("Connected to database: " + database);
		} catch (
				final SQLException x) {
			x.printStackTrace();
		}

	}


	public static Clans getInstance() {
		return instance;
	}

	private void registerTasks() {
		ArmourListener.startTask();
	}

	private void registerCMD() {

		getCommand("clan").setExecutor(new ClanCommands(items));

	}

	private void registerListeners() {
		final PluginManager plm = org.bukkit.Bukkit.getPluginManager();

		plm.registerEvents(new ResourcesListener(this, items), this);
		plm.registerEvents(new CoreBlockListener(), this);
		plm.registerEvents(new CraftingListener(), this);
		plm.registerEvents(new ExplosiveListener(), this);
		plm.registerEvents(new LootListner(items), this);
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