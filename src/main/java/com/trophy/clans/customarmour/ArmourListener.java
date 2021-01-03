package com.trophy.clans.customarmour;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmourListener implements Listener {

	
	private ArmourItemStacks ais = new ArmourItemStacks();
	
	private String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	@EventHandler
	public void armourEvent(InventoryInteractEvent x) {


		HumanEntity p = x.getWhoClicked();
		x.setResult(Event.Result.DENY);

		ArrayList<ItemStack> player_armor = new ArrayList<ItemStack>();
		
		player_armor.add(p.getInventory().getHelmet());
		player_armor.add(p.getInventory().getChestplate());
		player_armor.add(p.getInventory().getLeggings());
		player_armor.add(p.getInventory().getBoots());

		ItemStack air = new ItemStack(Material.AIR);
		
		int amount = 0;
		
		for(ItemStack item: player_armor)
		{
			if (!item.equals(air))
			{
				amount++;
				p.sendMessage("full armour: " + amount);
			}
		}
		
		int tier1 = 0;
		int tier2 = 0;
		int tier3 = 0;
		
		if(amount == 4)
		{
			for(ItemStack item: player_armor)
			{
				if(item.equals(p.getInventory().getHelmet()))
				{
					if(item.equals(ais.getTierOneHelmet()))
					{
						tier1++;
						p.sendMessage("tier1: " + tier1);
					}
					else if(item.equals(ais.getTierTwoHelmet()))
					{
						tier2++;
						p.sendMessage("tier2: " + tier2);
					}
					else
					{
						tier3++;
						p.sendMessage("tier3: " + tier3);
					}
				}				
				else if(item.equals(p.getInventory().getChestplate()))
				{
					if(item.equals(ais.getTierOneChestplate()))
					{
						tier1++;
					}
					else if(item.equals(ais.getTierTwoChestplate()))
					{
						tier2++;
					}
					else
					{
						tier3++;
					}
				}	
				else if(item.equals(p.getInventory().getLeggings()))
				{
					if(item.equals(ais.getTierOneLeggings()))
					{
						tier1++;
					}
					else if(item.equals(ais.getTierTwoLeggings()))
					{
						tier2++;
					}
					else
					{
						tier3++;
					}
				}
				else
				{
					if(item.equals(ais.getTierOneBoots()))
					{
						tier1++;
					}
					else if(item.equals(ais.getTierTwoBoots()))
					{
						tier2++;
					}
					else
					{
						tier3++;
					}
				}
			}
		}
		
		if(tier1 == 4)
		{
			p.addPotionEffect(PotionEffectType.SPEED.createEffect(400, 2));
			p.sendMessage("t1fuck");
		}
		else if(tier2 == 4)
		{
			p.sendMessage("t2fuck");
			//ADD PotionEffect for tier2
		}
		else if(tier3 == 4)
		{
			p.sendMessage("t3fuck");
		}
		else
		{
			//Different armor, dont add potioneffect.
			p.sendMessage("differentfuck");
			return;
		}
		
		


		//NOT DONE


	}

}
