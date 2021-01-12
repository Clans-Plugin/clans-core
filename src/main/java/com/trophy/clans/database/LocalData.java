package com.trophy.clans.database;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.UUID;

public class LocalData {

	public static void init_clan(final String clanname, final Player owner, final Location homeloc) throws IOException {
		final String path = "data/" + clanname + ".conf";
		final File file = new File(path);
		file.getParentFile().mkdirs();
		file.createNewFile();
		System.out.println("Initialized Clan file!");

		final BufferedWriter output;
		output = new BufferedWriter(new FileWriter(path, true));
		final PrintWriter print = new PrintWriter(output);
		print.println("Owner: " + owner.getUniqueId().toString());
		print.println("Coreblock: false");
		print.println("Clanlevel: 0");
		print.println("Clanpoints: 0");
		print.println("Home: " + homeloc.getBlockX() + " " + homeloc.getBlockY() + " " + homeloc.getBlockZ());
		print.println("Members: ");
		print.println(owner.getUniqueId().toString());
		print.close();
		output.close();
	}

	public static boolean existsClan(final String clanname) {
		final File folder = new File("data");
		final File[] listfiles = folder.listFiles();

		for (int i = 0; i < listfiles.length; i++) {
			if (listfiles[i].getName().split(".")[0].equals(clanname)) {
				return true;
			}
		}
		return false;

	}

	public static void deleteClan(final String clanname) {
		final File clanfile = getClanfile(clanname);
		clanfile.delete();
	}

	@SuppressWarnings("resource")
	public static String getOwner(final String clanname) throws IOException {
		final File clanfile = getClanfile(clanname);

		String line;

		final BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while ((line = reader.readLine()) != null) {
			if (line.split(":")[0].equals("Owner")) {
				return line.split(": ")[1];
			}
		}

		return null;
	}

	public static File getClanfile(final String clanname) {
		final File folder = new File("data");
		final File[] listfiles = folder.listFiles();

		for (int i = 0; i < listfiles.length; i++) {
			if (listfiles[i].getName().equals(clanname)) {
				return listfiles[i];
			}
		}

		return null;

	}

	public static void addMember(final String clanname, final String membername) throws IOException {
		final File clanfile = getClanfile(clanname);
		final BufferedWriter output;
		output = new BufferedWriter(new FileWriter(clanfile.getPath(), true));
		final PrintWriter print = new PrintWriter(output);
		print.println(Bukkit.getPlayer(membername).getUniqueId().toString());
		print.close();
		output.close();

	}

	public static void removeMember(final String clanname, final String membername) throws IOException {
		final ArrayList<String> filecontent = new ArrayList<>();
		final ArrayList<String> new_filecontent = new ArrayList<>();
		final File clanfile = getClanfile(clanname);
		String line;
		final BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while ((line = reader.readLine()) != null) {
			filecontent.add(line);
		}

		for (final String s : filecontent) {
			if (!s.equals(Bukkit.getPlayer(membername).getUniqueId().toString())) {
				new_filecontent.add(s);
			}
		}

		reader.close();

		clanfile.delete();
		clanfile.createNewFile();

		final BufferedWriter output;
		output = new BufferedWriter(new FileWriter(clanfile.getPath(), true));
		final PrintWriter print = new PrintWriter(output);

		for (final String s : new_filecontent) {
			print.print(s);
		}

		print.close();
		output.close();


	}

	public static String getClanName(final Player player) throws IOException {
		final File folder = new File("data");
		final File[] listfiles = folder.listFiles();
		final ArrayList<String> filecontent = new ArrayList<>();

		for (int i = 0; i < listfiles.length; i++) {
			String line;
			final File file = listfiles[i];
			final BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
			while ((line = reader.readLine()) != null) {
				filecontent.add(line);
			}

			for (final String content : filecontent) {
				if (filecontent.indexOf(content) > 5) {
					if (content.equals(player.getName())) {
						return file.getName().split(".")[0];
					}
				}

			}

		}
		return "player_not_in_a_clan";

	}

	public static ArrayList<UUID> getMembers(final String clanname) throws IOException {
		final ArrayList<String> filecontent = new ArrayList<>();
		final ArrayList<UUID> members = new ArrayList<>();
		final File clanfile = getClanfile(clanname);
		String line;
		final BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while ((line = reader.readLine()) != null) {
			filecontent.add(line);
		}

		for (final String content : filecontent) {
			if (filecontent.indexOf(content) > 5) {
				members.add(UUID.fromString(content));
			}
		}


		return members;

	}

	public static int getMembersNumber(final String clanname) throws IOException {
		return getMembers(clanname).size();
	}

	public static int getClanLevel(final String clanname) throws NumberFormatException, IOException {
		final File clanfile = getClanfile(clanname);
		String line;
		final BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while ((line = reader.readLine()) != null) {
			if (line.split(":")[0].equals("Clanlevel")) {
				return Integer.parseInt(line.split(": ")[1]);
			}
		}

		return -1;
	}

	public static void setClanLevel(final String clanname, final int level) throws NumberFormatException, IOException {
		final File clanfile = getClanfile(clanname);
		final ArrayList<String> oldcontent = new ArrayList<>();
		final ArrayList<String> newcontent = new ArrayList<>();
		String line;
		final BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while ((line = reader.readLine()) != null) {
			oldcontent.add(line);
		}

		for (final String content : oldcontent) {
			if (content.split(":")[0].equals("Clanlevel")) {
				newcontent.add("Clanlevel: " + Integer.toString(level));
			} else {
				newcontent.add(line);
			}
		}

		clanfile.delete();
		clanfile.createNewFile();

		final BufferedWriter output;
		output = new BufferedWriter(new FileWriter(clanfile.getPath(), true));
		final PrintWriter print = new PrintWriter(output);

		for (final String s : newcontent) {
			print.print(s);
		}

		print.close();
		output.close();
	}

	public static Location getCoreBlockLocation(final String clanname) throws IOException {
		final File clanfile = getClanfile(clanname);
		String line;
		final BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while ((line = reader.readLine()) != null) {
			if (line.split(":")[0].equals("Coreblock")) {
				final int loc_x = Integer.parseInt(line.split(" ")[1]);
				final int loc_y = Integer.parseInt(line.split(" ")[2]);
				final int loc_z = Integer.parseInt(line.split(" ")[3]);

				return new Location(Bukkit.getWorld("world"), loc_x, loc_y, loc_z);

			}
		}
		return null;

	}

	public static String getCoreBlockClan(final Location location) throws NumberFormatException, IOException {
		final File folder = new File("data");
		final File[] listfiles = folder.listFiles();

		for (int i = 0; i < listfiles.length; i++) {
			final File file = listfiles[i];
			String line;
			final BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
			while ((line = reader.readLine()) != null) {
				if (line.split(":")[0].equals("Coreblock")) {
					final int loc_x = Integer.parseInt(line.split(" ")[1]);
					final int loc_y = Integer.parseInt(line.split(" ")[2]);
					final int loc_z = Integer.parseInt(line.split(" ")[3]);

					final Location coreblockloc = new Location(Bukkit.getWorld("world"), loc_x, loc_y, loc_z);

					if (coreblockloc.equals(location)) {
						return file.getName().split(".")[0];
					}
				}
			}

		}
		return "coreblock_not_in_a_clan";

	}

	public static boolean CoreBlockIsPlaced(final String clanname) throws IOException {
		final File clanfile = getClanfile(clanname);

		String line;
		final BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while ((line = reader.readLine()) != null) {
			if (line.split(":")[0].equals("Coreblock") && line.split(": ")[1].equals("false")) {
				return false;
			}
		}

		return true;
	}

	public static void setCoreBlockLocation(final String clanname, final Location location) throws IOException {
		final ArrayList<String> oldcontent = new ArrayList<>();
		final ArrayList<String> newcontent = new ArrayList<>();
		final File clanfile = getClanfile(clanname);

		String line;
		final BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while ((line = reader.readLine()) != null) {
			oldcontent.add(line);
		}

		for (final String content : oldcontent) {
			if (content.split(":")[0].equals("Coreblock")) {
				newcontent.add("Coreblock: " + Double.toString(location.getX()) + " " + Double.toString(location.getY()) + " " + Double.toString(location.getZ()));
			} else {
				newcontent.add(content);
			}
		}

		clanfile.delete();
		clanfile.createNewFile();

		final BufferedWriter output;
		output = new BufferedWriter(new FileWriter(clanfile.getPath(), true));
		final PrintWriter print = new PrintWriter(output);

		for (final String s : newcontent) {
			print.print(s);
		}

		print.close();
		output.close();
	}

	public static int getClanPoints(final String clanname) throws NumberFormatException, IOException {
		final File clanfile = getClanfile(clanname);
		String line;
		final BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while ((line = reader.readLine()) != null) {
			if (line.split(":")[0].equals("Clanpoints")) {
				return Integer.valueOf(line.split(": ")[1]);
			}
		}
		return -1;

	}

	public static TreeMap<Integer, String> getTopClans() throws NumberFormatException, IOException {
		final TreeMap<Integer, String> sortedclans = new TreeMap<>(Comparator.reverseOrder());

		final File folder = new File("data");
		final File[] listfiles = folder.listFiles();

		for (int i = 0; i < listfiles.length; i++) {
			final File file = listfiles[i];
			String line;
			final BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
			while ((line = reader.readLine()) != null) {
				if (line.split(":")[0].equals("Clanpoints")) {
					sortedclans.put(Integer.valueOf(line.split(": ")[1]), file.getName().split(".")[0]);
				}
			}

		}

		return sortedclans;

	}

	public static int getPlaceOfClan(final String clanname) throws NumberFormatException, IOException {
		final TreeMap<Integer, String> sortedclans = getTopClans();

		final Object[] clans = sortedclans.values().toArray();

		for (int i = 0; i < clans.length; i++) {
			if (clans[i].equals(clanname)) {
				return i + 1;
			}
		}

		return -1;
	}

	public static void giveCoreBlock(final Player player, final String clanname) {

		final ItemStack CoreBlock = new ItemStack(Material.BEACON);
		final ItemMeta CoreBlockMeta = CoreBlock.getItemMeta();
		CoreBlockMeta.setDisplayName("§c§lCore Block - " + clanname);
		CoreBlock.setItemMeta(CoreBlockMeta);


	}


}
