package com.trophy.clans.craftingsystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingListener implements Listener {


	//Prevent Crafting

	@EventHandler
	public void craftItem(PrepareItemCraftEvent e) {
		Material itemType = e.getRecipe().getResult().getType();
		Byte itemData = e.getRecipe().getResult().getData().getData();
		if (itemType == Material.WORKBENCH) {
			e.getInventory().setResult(new ItemStack(Material.AIR));

		}
	}


	//Crafting Table Interact

	@EventHandler
	public void craftingEvent(PlayerInteractEvent e) {

		Player p = e.getPlayer();


		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getClickedBlock().getType() == Material.WORKBENCH) {

				CraftingGUIs.openMainGui(p);
				e.setCancelled(true);
			} else {
				return;
			}
		}
	}


	//Inventory interact events

	@EventHandler
	public void interactSelector(InventoryClickEvent x) {

		HumanEntity p = x.getWhoClicked();
		Player pl = Bukkit.getPlayer(x.getWhoClicked().getName());

		//
		//MAIN INVENTORY
		//

		if (x.getView().getTitle().equals("Crafting")) {

			x.setCancelled(true);
			x.setResult(Event.Result.DENY);


			//BASE
			if (x.getSlot() == 11) {

				CraftingGUIs.openBaseGui(pl);


			}

			//TOOLS
			else if (x.getSlot() == 15) {

				CraftingGUIs.openToolsGui(pl);


			}

			//WEAPONS
			else if (x.getSlot() == 29) {


				CraftingGUIs.openToolsGui(pl);


			}

			//RAIDING
			else if (x.getSlot() == 33) {


				p.closeInventory();
				CraftingGUIs.openRaidGui(pl);


			}


		}


		if (x.getView().getTitle().equals("Raiding")) {

			x.setCancelled(true);
			x.setResult(Event.Result.DENY);


		}

		//RAIDING
		else if (x.getSlot() == 4) {


			p.closeInventory();


		}


	}


}



