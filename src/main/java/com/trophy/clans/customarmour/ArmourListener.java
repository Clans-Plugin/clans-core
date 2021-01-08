package com.trophy.clans.customarmour;

import com.trophy.clans.utility.Items;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmourListener implements Listener {

	private static Items ais = new Items();

	
	private String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	@EventHandler
	public void onMove(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		p.sendMessage("INTERACTED!!!!");
		
		ItemStack helmet = p.getInventory().getHelmet();
		ItemStack chest = p.getInventory().getChestplate();
		ItemStack legs = p.getInventory().getLeggings();
		ItemStack boots = p.getInventory().getBoots();
		
		if(helmet != null && chest != null && legs != null && boots != null)
		{
			if(helmet.equals(ais.getTierOneHelmet()))
			{
				if(checkFullTierOneArmour(p))
				{
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
				}
				else
				{
					if(p.hasPotionEffect(PotionEffectType.SPEED))
					{
						p.removePotionEffect(PotionEffectType.SPEED);
					}
				}
			}
			else if(helmet.equals(ais.getTierTwoHelmet()))
			{
				if(checkFullTierTwoArmour(p))
				{
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
				}
				else
				{
					if(p.hasPotionEffect(PotionEffectType.SPEED))
					{
						p.removePotionEffect(PotionEffectType.SPEED);
					}

				}
			}
			else if(helmet.equals(ais.getTierThreeHelmet()))
			{
				if(checkFullTierThreeArmour(p))
				{
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
				}
				else
				{
					if(p.hasPotionEffect(PotionEffectType.SPEED))
					{
						p.removePotionEffect(PotionEffectType.SPEED);
					}
				}
			}
		}
	}
	
	
	private static boolean checkFullTierOneArmour(Player player)
	{
		ItemStack chest = player.getInventory().getChestplate();
		ItemStack legs = player.getInventory().getLeggings();
		ItemStack boots = player.getInventory().getBoots();
		
		if(chest.equals(ais.getTierOneChestplate()) && legs.equals(ais.getTierOneLeggings()) && boots.equals(ais.getTierOneBoots()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private static boolean checkFullTierTwoArmour(Player player)
	{
		ItemStack chest = player.getInventory().getChestplate();
		ItemStack legs = player.getInventory().getLeggings();
		ItemStack boots = player.getInventory().getBoots();
		
		if(chest.equals(ais.getTierTwoChestplate()) && legs.equals(ais.getTierTwoLeggings()) && boots.equals(ais.getTierTwoBoots()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	private static boolean checkFullTierThreeArmour(Player player)
	{
		ItemStack chest = player.getInventory().getChestplate();
		ItemStack legs = player.getInventory().getLeggings();
		ItemStack boots = player.getInventory().getBoots();
		
		if(chest.equals(ais.getTierThreeChestplate()) && legs.equals(ais.getTierThreeLeggings()) && boots.equals(ais.getTierThreeBoots()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
