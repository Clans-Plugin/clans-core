package com.trophy.clans.clansystem;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class ExplosiveListener implements Listener {


	@EventHandler
	public void onExplosivePlaceEvent(BlockPlaceEvent e) {

		Player p = e.getPlayer();

		if (e.getBlock().getType() == Material.TNT) {

			e.setCancelled(true);

			Location target = e.getBlockAgainst().getLocation();


			p.getLocation().getWorld().spigot().playEffect(target, Effect.EXPLOSION, 0, 1, 0, 0, 0, 1, 30, 5);


			int targetX = target.getBlockX() - 2;
			int targetY = target.getBlockY() - 1;
			int targetZ = target.getBlockZ() - 2;

			int targetEndX = target.getBlockX() + 3;
			int targetEndY = target.getBlockY() + 2;
			int targetEndZ = target.getBlockZ() + 3;

			World world = Bukkit.getServer().getWorld("World");

			for (int x = targetX; x < targetEndX; x++) {
				for (int z = targetZ; z < targetEndZ; z++) {
					for (int y = targetY; y < targetEndY; y++) {


						Block block = world.getBlockAt(x, y, z);
						if (block.getType() == Material.OBSIDIAN) {
							block.setType(Material.BRICK);
						} else if (block.getType() == Material.BRICK) {
							block.setType(Material.WOOD);
						} else if (block.getType() == Material.WOOD) {
							block.setType(Material.AIR);
						}

					}
				}
			}
		}


	}

}
