package com.trophy.clans.lootbarrels;

import com.trophy.clans.utility.Items;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class LootListner implements Listener {

	private Items i = new Items();

	private static String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	@EventHandler
	public void onLootInteract(PlayerInteractEvent x) {

		Player p = x.getPlayer();
		Block target = x.getClickedBlock();

		if (target.getType().equals(Material.EMERALD_BLOCK)) {

			p.sendMessage(color("&cYou opened a &fLoot Barrel"));
			target.setType(Material.AIR);

			i.giveCustomItem(p, i.getCookedSulfur(10));

		}


	}

}
