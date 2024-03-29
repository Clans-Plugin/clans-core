package com.akosg.clans.craftingsystem;

import com.akosg.clans.utility.Items;
import com.akosg.clans.utility.PlayerMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class WeaponsArmorMenu implements Listener, PlayerMenu {

	private final Inventory weaponArmorInventory = Bukkit.createInventory(this, 27, "Weapons & Armour");
	private final CraftingTaskHandler taskHandler;
	private final Items items;

	public WeaponsArmorMenu(final Items items, final CraftingTaskHandler taskHandler) {
		this.items = items;
		this.taskHandler = taskHandler;
	}


	@Override
	public Inventory getInventory() {
		return weaponArmorInventory;
	}

	@Override
	public boolean onClick(final Player player, final int slot, final ClickType type, final ItemStack currentItem) {

		if (currentItem != null) {
			if (currentItem.getType() != Material.AIR) {
				player.openInventory(new AmountSelectionMenu(currentItem, taskHandler, items).getInventory());
				player.playSound(player.getLocation(), Sound.valueOf("ORB_PICKUP"), 1.0F, 1.0F);
			}
		}
		return true;
	}

	@Override
	public void onOpen(final Player player) {

		weaponArmorInventory.setItem(1, items.getTier1Helmet());
		weaponArmorInventory.setItem(2, items.getTier1Chestplate());
		weaponArmorInventory.setItem(3, items.getTier1Leggings());
		weaponArmorInventory.setItem(4, items.getTier1Boots());
		weaponArmorInventory.setItem(6, items.getTier1Sword());

		weaponArmorInventory.setItem(10, items.getTier2Helmet());
		weaponArmorInventory.setItem(11, items.getTier2Chestplate());
		weaponArmorInventory.setItem(12, items.getTier2Leggings());
		weaponArmorInventory.setItem(13, items.getTier2Boots());
		weaponArmorInventory.setItem(15, items.getTier2Sword());

		weaponArmorInventory.setItem(19, items.getTier3Helmet());
		weaponArmorInventory.setItem(20, items.getTier3Chestplate());
		weaponArmorInventory.setItem(21, items.getTier3Leggings());
		weaponArmorInventory.setItem(22, items.getTier3Boots());
		weaponArmorInventory.setItem(24, items.getTier3Sword());

	}

	@Override
	public void onClose(final Player player) {

	}
}
