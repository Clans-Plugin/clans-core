package com.trophy.clans.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Data 
{
	public static void init_clan(String clanname, Player owner,Location homeloc) throws IOException
	{
		String path = "data/" + clanname + ".conf";
		File file = new File(path);
		file.getParentFile().mkdirs();
		file.createNewFile();
		System.out.println("INITIALIZED CLAN FILE!!!!");
			
		BufferedWriter output;
		output = new BufferedWriter(new FileWriter(path, true));
		PrintWriter print = new PrintWriter(output);
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
	
	public static boolean existsClan(String clanname)
	{
		File folder = new File("data");
		File[] listfiles = folder.listFiles();
		
		for(int i = 0; i < listfiles.length; i++)
		{
			if(listfiles[i].getName().split(".")[0].equals(clanname))
			{
				return true;
			}
		}
		return false;
		
	}
	
	public static void deleteClan(String clanname)
	{
		File clanfile = getClanfile(clanname);
		clanfile.delete();
	}
	
	@SuppressWarnings("resource")
	public static String getOwner(String clanname) throws IOException
	{
		File clanfile = getClanfile(clanname);
		
		String line;
		
		BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while((line = reader.readLine()) != null)
		{
			if(line.split(":")[0].equals("Owner"))
			{
				return line.split(": ")[1];
			}
		}
		
		return null;
	}
	
	public static File getClanfile(String clanname)
	{
		File folder = new File("data");
		File[] listfiles = folder.listFiles();
		
		for(int i = 0; i < listfiles.length; i++)
		{
			if(listfiles[i].getName().equals(clanname))
			{
				return listfiles[i];
			}
		}
		
		return null;
		
	}
	
	public static void addMember(String clanname, String membername) throws IOException
	{
		File clanfile = getClanfile(clanname);
		BufferedWriter output;
		output = new BufferedWriter(new FileWriter(clanfile.getPath(), true));
		PrintWriter print = new PrintWriter(output);
		print.println(Bukkit.getPlayer(membername).getUniqueId().toString());
		print.close();
		output.close();
		
	}
	
	public static void removeMember(String clanname, String membername) throws IOException
	{
		ArrayList<String> filecontent = new ArrayList<String>();
		ArrayList<String> new_filecontent = new ArrayList<String>();
		File clanfile = getClanfile(clanname);
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while((line = reader.readLine()) != null)
		{
			filecontent.add(line);
		}
		
		for(String s: filecontent)
		{
			if(!s.equals(Bukkit.getPlayer(membername).getUniqueId().toString()))
			{
				new_filecontent.add(s);
			}
		}
		
		reader.close();
		
		clanfile.delete();
		clanfile.createNewFile();
		
		BufferedWriter output;
		output = new BufferedWriter(new FileWriter(clanfile.getPath(), true));
		PrintWriter print = new PrintWriter(output);
		
		for(String s: new_filecontent)
		{
			print.print(s);
		}
		
		print.close();
		output.close();
		
		
	}
	
	public static String getClanName(Player player) throws IOException
	{
		File folder = new File("data");
		File[] listfiles = folder.listFiles();
		ArrayList<String> filecontent = new ArrayList<String>();
		
		for(int i = 0; i < listfiles.length; i++)
		{
			String line;
			File file = listfiles[i];
			BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
			while((line = reader.readLine()) != null)
			{
				filecontent.add(line);
			}
			
			for(String content: filecontent)
			{
				if(filecontent.indexOf(content) > 5)
				{
					if(content.equals(player.getName()))
					{
						return file.getName().split(".")[0];
					}
				}
					
			}
			
		}
		return "player_not_in_a_clan";
		
	}
	
	public static ArrayList<UUID> getMembers(String clanname) throws IOException
	{
		ArrayList<String> filecontent = new ArrayList<String>();
		ArrayList<UUID> members = new ArrayList<UUID>();
		File clanfile = getClanfile(clanname);
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while((line = reader.readLine()) != null)
		{
			filecontent.add(line);
		}
		
		for(String content: filecontent)
		{
			if(filecontent.indexOf(content) > 5)
			{
				members.add(UUID.fromString(content));
			}
		}
		
		
		return members;
		
	}
	
	public static int getMembersNumber(String clanname) throws IOException
	{
		return getMembers(clanname).size();
	}
	
	public static int getClanLevel(String clanname) throws NumberFormatException, IOException
	{
		File clanfile = getClanfile(clanname);
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while((line = reader.readLine()) != null)
		{
			if(line.split(":")[0].equals("Clanlevel"))
			{
				return Integer.valueOf(line.split(": ")[1]);
			}
		}
		
		return -1;
	}
	
	public static void setClanLevel(String clanname, int level) throws NumberFormatException, IOException
	{
		File clanfile = getClanfile(clanname);
		ArrayList<String> oldcontent = new ArrayList<String>();
		ArrayList<String> newcontent = new ArrayList<String>();
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while((line = reader.readLine()) != null)
		{
			oldcontent.add(line);
		}
		
		for(String content: oldcontent)
		{
			if(content.split(":")[0].equals("Clanlevel"))
			{
				newcontent.add("Clanlevel: " + Integer.toString(level));
			}
			else
			{
				newcontent.add(line);
			}
		}
		
		clanfile.delete();
		clanfile.createNewFile();
		
		BufferedWriter output;
		output = new BufferedWriter(new FileWriter(clanfile.getPath(), true));
		PrintWriter print = new PrintWriter(output);
		
		for(String s: newcontent)
		{
			print.print(s);
		}
		
		print.close();
		output.close();
	}
	
	public static Location getCoreBlockLocation(String clanname) throws IOException
	{
		File clanfile = getClanfile(clanname);
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while((line = reader.readLine()) != null)
		{
			if(line.split(":")[0].equals("Coreblock"))
			{
				int loc_x = Integer.valueOf(line.split(" ")[1]);
				int loc_y = Integer.valueOf(line.split(" ")[2]);
				int loc_z = Integer.valueOf(line.split(" ")[3]);
				
				Location coreblockloc = new Location(Bukkit.getWorld("world"), loc_x, loc_y, loc_z);
				
				return coreblockloc;
				
			}
		}
		return null;
		
	}
	
	public static String getCoreBlockClan(Location location) throws NumberFormatException, IOException
	{
		File folder = new File("data");
		File[] listfiles = folder.listFiles();
		
		for(int i = 0; i < listfiles.length; i++)
		{
			File file = listfiles[i];
			String line;
			BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
			while((line = reader.readLine()) != null)
			{
				if(line.split(":")[0].equals("Coreblock"))
				{
					int loc_x = Integer.valueOf(line.split(" ")[1]);
					int loc_y = Integer.valueOf(line.split(" ")[2]);
					int loc_z = Integer.valueOf(line.split(" ")[3]);
					
					Location coreblockloc = new Location(Bukkit.getWorld("world"), loc_x, loc_y, loc_z);
					
					if(coreblockloc.equals(location))
					{
						return file.getName().split(".")[0];
					}
				}
			}
			
		}
		return "coreblock_not_in_a_clan";
		
	}
	
	public static boolean CoreBlockIsPlaced(String clanname) throws IOException
	{
		File clanfile = getClanfile(clanname);
		
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while((line = reader.readLine()) != null)
		{
			if(line.split(":")[0].equals("Coreblock") && line.split(": ")[1].equals("false"))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static void setCoreBlockLocation(String clanname, Location location) throws IOException
	{
		ArrayList<String> oldcontent = new ArrayList<String>();
		ArrayList<String> newcontent = new ArrayList<String>();
		File clanfile = getClanfile(clanname);
		
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while((line = reader.readLine()) != null)
		{
			oldcontent.add(line);
		}
		
		for(String content: oldcontent)
		{
			if(content.split(":")[0].equals("Coreblock"))
			{
				newcontent.add("Coreblock: " + Double.toString(location.getX()) + " " + Double.toString(location.getY()) + " " + Double.toString(location.getZ()));
			}
			else
			{
				newcontent.add(content);
			}
		}
		
		clanfile.delete();
		clanfile.createNewFile();
		
		BufferedWriter output;
		output = new BufferedWriter(new FileWriter(clanfile.getPath(), true));
		PrintWriter print = new PrintWriter(output);
		
		for(String s: newcontent)
		{
			print.print(s);
		}
		
		print.close();
		output.close();
	}
	
	public static int getClanPoints(String clanname) throws NumberFormatException, IOException
	{
		File clanfile = getClanfile(clanname);
		String line;
		BufferedReader reader = new BufferedReader(new FileReader(clanfile.getPath()));
		while((line = reader.readLine()) != null)
		{
			if(line.split(":")[0].equals("Clanpoints"))
			{
				return Integer.valueOf(line.split(": ")[1]);
			}
		}
		return -1;
		
	}
	
	public static TreeMap<Integer, String> getTopClans() throws NumberFormatException, IOException
	{
		TreeMap<Integer, String> sortedclans = new TreeMap<Integer, String>(Comparator.reverseOrder());
		
		File folder = new File("data");
		File[] listfiles = folder.listFiles();
		
		for(int i = 0; i < listfiles.length; i++)
		{
			File file =  listfiles[i];
			String line;
			BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
			while((line = reader.readLine()) != null)
			{
				if(line.split(":")[0].equals("Clanpoints"))
				{
					sortedclans.put(Integer.valueOf(line.split(": ")[1]), file.getName().split(".")[0]);
				}
			}
			
		}
		
		return sortedclans;

	}
	
	public static int getPlaceOfClan(String clanname) throws NumberFormatException, IOException
	{		
		TreeMap<Integer, String> sortedclans = getTopClans();
		
		Object[] clans = sortedclans.values().toArray();
		
		for(int i = 0; i < clans.length; i++)
		{
			if(clans[i].equals(clanname))
			{
				return i+1;
			}
		}
		
		return -1;
	}
	

}
