package com.trophy.clans.levelingsystem;

import com.trophy.clans.database.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class LevelGUI {

	public void openLevel(final Player player) {

		final Inventory levelMenuInventory = Bukkit.createInventory(null, 9, "Level Menu");

		final ItemStack experience = new ItemStack(Material.EXP_BOTTLE);
		final ItemMeta xp = experience.getItemMeta();
		xp.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		xp.setDisplayName("§3Experience");
		final ArrayList<String> experience_lore = new ArrayList<>();
		experience_lore.add("");
		experience_lore.add("§3Current experience: §6" + PlayerData.getPlayerXP(player.getUniqueId().toString()));
		experience_lore.add("");
		experience_lore.add("§3Current level: §6" + PlayerData.getPlayerLevel(player.getUniqueId().toString()));
		experience_lore.add("");

		xp.setLore(experience_lore);
		experience.setItemMeta(xp);

		//Level up

		final ItemStack levelup = new ItemStack(Material.EMERALD_BLOCK);
		final ItemMeta po = levelup.getItemMeta();
		po.setDisplayName("§3Click to level up");
		po.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		final ArrayList<String> levelup_lore = new ArrayList<>();
		levelup_lore.add("");
		levelup_lore.add("§3Next level: §6" + PlayerData.getPlayerLevel(player.getUniqueId().toString() + 1));
		levelup_lore.add("");
		po.setLore(levelup_lore);
		levelup.setItemMeta(po);

		levelMenuInventory.setItem(3, experience);
		levelMenuInventory.setItem(5, levelup);

		player.openInventory(levelMenuInventory);

	}

}






