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

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Data 
{
	public static void init_clan(String clanname, Player owner, Location coreblockloc, Location homeloc) throws IOException
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
		print.println("Coreblock: " + coreblockloc.getBlockX() + " " + coreblockloc.getBlockY() + " " + coreblockloc.getBlockZ());
		print.println("Clanpoints: 0");
		print.println("Home: " + homeloc.getBlockX() + " " + homeloc.getBlockY() + " " + homeloc.getBlockZ());
		print.println("Members: ");
		print.close();
		output.close();
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
		print.println(membername);
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
			if(!s.equals(membername))
			{
				new_filecontent.add(s);
			}
		}
		
		BufferedWriter output;
		output = new BufferedWriter(new FileWriter(clanfile.getPath(), true));
		PrintWriter print = new PrintWriter(output);
		print.flush();
		
		for(String s: new_filecontent)
		{
			print.print(s);
		}
		
		print.close();
		output.close();
		
		
		
	}
	
	

}
