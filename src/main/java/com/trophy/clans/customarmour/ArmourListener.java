package com.trophy.clans.customarmour;

import javafx.event.EventType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmourListener implements Listener {

	private String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public void armourEvent(InventoryInteractEvent x) {

		HumanEntity p = x.getWhoClicked();

		//NOT DONE


	}

}
