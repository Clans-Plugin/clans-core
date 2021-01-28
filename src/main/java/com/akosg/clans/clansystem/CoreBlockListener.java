package com.akosg.clans.clansystem;


import com.akosg.clans.database.ClansData;
import com.akosg.clans.database.PlayerData;
import com.akosg.clans.main.Clans;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashMap;

public class CoreBlockListener implements Listener {

private final Clans clans;

public CoreBlockListener(final Clans clans) {
   this.clans = clans;
}

private static boolean isInRadius(final Location check, final Location start, final double radius) {
   return Math.abs(check.getX() - start.getX()) <= radius &&
					  Math.abs(check.getY() - start.getY()) <= radius &&
					  Math.abs(check.getZ() - start.getZ()) <= radius;
}

@EventHandler
public void PlaceEvent(final BlockPlaceEvent event) {

   final Player player = event.getPlayer();
   final String uuid = event.getPlayer().getUniqueId().toString();
   final Location block = event.getBlockPlaced().getLocation();
   final String clanName = PlayerData.getClanName(uuid);
   final Location zero = new Location(Bukkit.getWorld("world"), 0, 0, 0);

   final HashMap<String, Location> allLocations = ClansData.getAllLocation();

   for (final HashMap.Entry<String, Location> entry : allLocations.entrySet()) {

	  if (isInRadius(event.getBlock().getLocation(), entry.getValue(), 6)) {

		 if (!entry.getKey().equalsIgnoreCase(clanName)) {

			event.setCancelled(true);
			player.sendMessage("§cYou can not place blocks in the territory of: §6" + entry.getKey());


		 }


	  }

   }

   if (event.getBlockPlaced().getType() == Material.BEACON) {

	  if (PlayerData.checkPlayerInClan(uuid)) {

		 if (ClansData.getClanCoreLocation(clanName).equals(zero)) {

			for (final HashMap.Entry<String, Location> entry : allLocations.entrySet()) {

			   if (!isInRadius(event.getBlock().getLocation(), entry.getValue(), 20)) {

				  player.sendMessage("§6Core block §cplaced, protect it!");
				  ClansData.setClanCoreLocation(clanName, block.getBlockX(), block.getBlockY(), block.getBlockZ());

			   }
			   else {

				  player.sendMessage("§cCan not place here as it is within a §620 block §cof another §6Core block");

			   }

			}


		 }
		 else {

			player.sendMessage("§cYou clan has already placed a §6Core Block");
			event.setCancelled(true);
		 }
	  }
	  else {

		 event.setCancelled(true);
		 player.sendMessage("§cNot in a clan!");

	  }


   }


}

@EventHandler
public void DestroyEvent(final BlockBreakEvent event) {

   final Player p = event.getPlayer();
   final int x = event.getBlock().getX();
   final int y = event.getBlock().getY();
   final int z = event.getBlock().getZ();
   final String clanOfBreaker = PlayerData.getClanName(p.getUniqueId().toString());
   final String ownerOfBrokenCore = ClansData.getCoreBlockOwner(x, y, z);


   final HashMap<String, Location> allLocations = ClansData.getAllLocation();

   for (final HashMap.Entry<String, Location> entry : allLocations.entrySet()) {


	  if (entry.getKey().equalsIgnoreCase(clanOfBreaker)) {

		 if (isInRadius(event.getBlock().getLocation(), entry.getValue(), 6)) {


			event.setCancelled(false);

			// CHECK FOR CUSTOM BLOCK ELSE CANCEL

		 }

		 else {

			p.sendMessage("§cYou can only break block inside of your territory");
			event.setCancelled(true);

		 }

	  }

   }

   if (event.getBlock().getType() == Material.BEACON) {

	  if (!ownerOfBrokenCore.equalsIgnoreCase(clanOfBreaker)) {


		 p.sendMessage("§cYou have raided §6" + ownerOfBrokenCore + " §cand gained §630 §cpoints!");
		 clans.getServer().broadcastMessage("§cThe clan §6" + ownerOfBrokenCore + " §chas been raided by §6" + clanOfBreaker);
		 ClansData.setClanPoints(clanOfBreaker, ClansData.getClanPoints(clanOfBreaker) + 20);
		 ClansData.setClanCoreLocation(ownerOfBrokenCore, 0, 0, 0);
		 if (ClansData.getClanPoints(ownerOfBrokenCore) > 20) {
			ClansData.setClanPoints(ownerOfBrokenCore, ClansData.getClanPoints(ownerOfBrokenCore) - 20);
		 }
		 else {

			ClansData.setClanPoints(ownerOfBrokenCore, 0);


		 }
	  }
	  else {

		 p.sendMessage("§cYou can not break your own §6Core Block§c! Idiot lol");
		 event.setCancelled(true);
	  }

   }

}


}


