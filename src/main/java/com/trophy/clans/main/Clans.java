package com.trophy.clans.main;

import com.trophy.clans.clansystem.ClanCommands;
import com.trophy.clans.clansystem.CoreBlockListener;
import com.trophy.clans.clansystem.ExplosiveListener;
import com.trophy.clans.craftingsystem.CraftingListener;
import com.trophy.clans.craftingsystem.CraftingTaskHandler;
import com.trophy.clans.customarmour.ArmourListener;
import com.trophy.clans.customore.ResourcesListener;
import com.trophy.clans.database.SQL;
import com.trophy.clans.lootbarrels.LootListner;
import com.trophy.clans.player.PlayerData;
import com.trophy.clans.utility.Items;
import com.trophy.clans.utility.MenuListener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class Clans extends JavaPlugin implements Listener {

	private static Connection connection;
	private String host, database, username, password;
	private int port;
	private final Items items = new Items();

	private final HashMap<UUID, PlayerData> playerCache = new HashMap<>();
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


		host = "eu01-sql.pebblehost.com";
		port = 3306;
		username = "customer_154510_clans";
		password = "wxzXyGDfigj$p36DK@rg";
		database = "customer_154510_clans";

		connectDatabase();

		createTables();
	}

	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent event) {

		final Player player = event.getPlayer();

		final String uuid = player.getUniqueId().toString();

		if (!SQL.checkDatabaseExist(uuid)) {

			player.sendMessage("First Join --> Added to Database");
			SQL.firstJoin(uuid);

			playerCache.put(player.getUniqueId(), new PlayerData());

		} else {
			playerCache.put(player.getUniqueId(), new PlayerData(SQL.getPlayerLevel(uuid), SQL.getPlayerXP(uuid), SQL.getPlayerPoints(uuid)));
		}
	}

	@EventHandler
	public void onPlayerLeave(final PlayerQuitEvent event) {

		playerCache.remove(event.getPlayer().getUniqueId());

	}

	private void registerTasks() {
		new ArmourListener(items, this);
	}

	private void registerCMD() {
		getCommand("clan").setExecutor(new ClanCommands(items));
	}

	private void createTables() {

		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS BarrelData (x varchar(20), y varchar(20), z varchar(20), tier int)");


			final boolean rs = ps.execute();


			System.out.println("Loaded BarrelData");


		} catch (final SQLException e) {
			e.printStackTrace();
		}


		try {
			final PreparedStatement ps = Clans.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS PlayerData (UUID varchar(64), Level int, XP int, Points int)");


			final boolean rs = ps.execute();


			System.out.println("Loaded PlayerData");


		} catch (final SQLException e) {
			e.printStackTrace();
		}

	}

	private void connectDatabase() {

		try {
			openConnection();
			System.out.println("Connected to database: " + database);
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
		plm.registerEvents(new LootListner(items, playerCache), this);
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