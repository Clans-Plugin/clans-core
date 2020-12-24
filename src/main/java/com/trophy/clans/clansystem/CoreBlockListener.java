package com.trophy.clans.clansystem;

import com.trophy.clans.customore.OreItemStacks;
import com.trophy.clans.database.Data;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CoreBlockListener implements Listener {

	private Data d = new Data();

	private String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public void PlaceEvent(BlockPlaceEvent e) {


		if (e.getBlockPlaced().getType() == Material.BEACON) {

			e.getPlayer().sendMessage(color("Core block placed!"));

			//LOGIC CREATE CLAN

		} else {

			e.getPlayer().sendMessage(color("Not core block"));

		}


	}

}
