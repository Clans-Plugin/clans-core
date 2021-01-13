package com.trophy.clans.main;

import com.trophy.clans.clansystem.ClanCommands;
import com.trophy.clans.clansystem.CoreBlockListener;
import com.trophy.clans.clansystem.ExplosiveListener;
import com.trophy.clans.craftingsystem.CraftingListener;
import com.trophy.clans.customarmour.ArmourListener;
import com.trophy.clans.customore.ResourcesListener;
import com.trophy.clans.lootbarrels.LootListner;
import com.trophy.clans.player.PlayerData;
import com.trophy.clans.utility.Items;
import com.trophy.clans.utility.MenuListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class Clans extends JavaPlugin implements Listener {

	private static Connection connection;
	private String host, database, username, password;
	private int port;
	private Items items;

	private final HashMap<UUID, PlayerData> playerCache = new HashMap<>();

	public static Connection getConnection() {
		return connection;
	}

	@Override
	public void onEnable() {
		this.items = new Items();

		this.registerCMD();
		this.registerListeners();
		this.registerTasks();

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

	@Override
	public void onDisable() {

	}

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {

	}

	@EventHandler
	public void onPlayerLeave(final PlayerQuitEvent event) {

	}

	private void registerTasks() {
		new ArmourListener(items, this);
	}

	private void registerCMD() {
		getCommand("clan").setExecutor(new ClanCommands(items));
	}

	private void registerListeners() {

		final PluginManager plm = org.bukkit.Bukkit.getPluginManager();

		plm.registerEvents(new ResourcesListener(this, items), this);
		plm.registerEvents(new CoreBlockListener(), this);
		plm.registerEvents(new CraftingListener(items), this);
		plm.registerEvents(new ExplosiveListener(), this);
		plm.registerEvents(new LootListner(items), this);
		plm.registerEvents(new MenuListener(), this);
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