package com.akosg.clans.clansystem;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ExplosiveListener implements Listener {

  @EventHandler
  public void onExplosivePlaceEvent(final BlockPlaceEvent event) {

	final Player player = event.getPlayer();

	if (event.getBlock().getType() == Material.TNT) {

	  event.setCancelled(true);

	  final Location target = event.getBlockAgainst().getLocation();

	  player.getWorld().spigot().playEffect(target, Effect.EXPLOSION, 0, 1, 0, 0, 0, 1, 30, 5);

	  final int targetX = target.getBlockX() - 2;
	  final int targetY = target.getBlockY() - 1;
	  final int targetZ = target.getBlockZ() - 2;

	  final int targetEndX = target.getBlockX() + 3;
	  final int targetEndY = target.getBlockY() + 2;
	  final int targetEndZ = target.getBlockZ() + 3;

	  final World world = player.getWorld();

	  for (int x = targetX; x < targetEndX; x++) {
		for (int z = targetZ; z < targetEndZ; z++) {
		  for (int y = targetY; y < targetEndY; y++) {

			final Block block = world.getBlockAt(x, y, z);
			if (block.getType() == Material.OBSIDIAN) {
			  block.setType(Material.BRICK);
			}
			else
			  if (block.getType() == Material.BRICK) {
				block.setType(Material.WOOD);
			  }
			  else
				if (block.getType() == Material.WOOD) {
				  block.setType(Material.AIR);
				}

		  }
		}
	  }
	}


  }

}
