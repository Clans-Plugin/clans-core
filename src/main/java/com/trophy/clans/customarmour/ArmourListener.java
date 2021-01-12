package com.trophy.clans.customarmour;

import com.trophy.clans.main.Clans;
import com.trophy.clans.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmourListener implements Listener {

	private final Clans plugin;
	private final Items items;

	public ArmourListener(final Items items, final Clans plugin) {
		this.items = items;
		this.plugin = plugin;
	}

	@EventHandler
	public void startTask() {
		Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {
			for (final Player p : Bukkit.getServer().getOnlinePlayers()) {
				final ItemStack helmet = p.getInventory().getHelmet();
				final ItemStack chest = p.getInventory().getChestplate();
				final ItemStack legs = p.getInventory().getLeggings();
				final ItemStack boots = p.getInventory().getBoots();
				if (helmet.equals(items.getTier1Helmet())) {
					p.sendMessage("tier 1 helmet true");
					if (checkFullTierOneArmour(p)) {
						Bukkit.getScheduler().runTaskLater(plugin, () -> p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1)), 1L);
					} else {
						if (p.hasPotionEffect(PotionEffectType.SPEED)) {
							Bukkit.getScheduler().runTaskLater(plugin, () -> p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1)), 1L);
						}
					}
				} else if (helmet.equals(items.getTier2Helmet())) {
					p.sendMessage("tier 2 helmet true");
					if (checkFullTierTwoArmour(p)) {
						Bukkit.getScheduler().runTaskLater(plugin, () -> p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1)), 1L);
					} else {
						Bukkit.getScheduler().runTaskLater(plugin, () -> {
							if (p.hasPotionEffect(PotionEffectType.SPEED)) {
								p.removePotionEffect(PotionEffectType.SPEED);
							}
						}, 1L);

					}
				} else if (helmet.equals(items.getTier3Helmet())) {
					p.sendMessage("tier 3 helmet true");
					if (checkFullTierThreeArmour(p)) {
						Bukkit.getScheduler().runTaskLater(plugin, () -> p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1)), 1L);
					} else {
						if (p.hasPotionEffect(PotionEffectType.SPEED)) {
							Bukkit.getScheduler().runTaskLater(plugin, () -> {
								if (p.hasPotionEffect(PotionEffectType.SPEED)) {
									p.removePotionEffect(PotionEffectType.SPEED);
								}
							}, 1L);
						}
					}
				} else {
					Bukkit.getScheduler().runTaskLater(plugin, () -> {
						if (p.hasPotionEffect(PotionEffectType.SPEED)) {
							p.removePotionEffect(PotionEffectType.SPEED);
						}
					}, 1L);
				}
			}
		}, 0L, 2L);
	}


	private static boolean checkFullTierOneArmour(final Player player) {
		final ItemStack chest = player.getInventory().getChestplate();
		final ItemStack legs = player.getInventory().getLeggings();
		final ItemStack boots = player.getInventory().getBoots();

		if (chest.equals(items.getTierOneChestplate()) && legs.equals(items.getTierOneLeggings()) && boots.equals(items.getTierOneBoots())) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean checkFullTierTwoArmour(final Player player) {
		final ItemStack chest = player.getInventory().getChestplate();
		final ItemStack legs = player.getInventory().getLeggings();
		final ItemStack boots = player.getInventory().getBoots();

		if (chest.equals(items.getTierTwoChestplate()) && legs.equals(items.getTierTwoLeggings()) && boots.equals(items.getTierTwoBoots())) {
			return true;
		} else {
			return false;
		}

	}

	private static boolean checkFullTierThreeArmour(final Player player) {
		final ItemStack chest = player.getInventory().getChestplate();
		final ItemStack legs = player.getInventory().getLeggings();
		final ItemStack boots = player.getInventory().getBoots();

		if (chest.equals(items.getTierThreeChestplate()) && legs.equals(items.getTierThreeLeggings()) && boots.equals(items.getTierThreeBoots())) {
			return true;
		} else {
			return false;
		}
	}

}
