package com.trophy.clans.customarmour;

import com.trophy.clans.main.Clans;
import com.trophy.clans.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArmourListener {

	private final Clans plugin;
	private final Items items;

	public ArmourListener(final Items items, final Clans plugin) {
		this.items = items;
		this.plugin = plugin;
		startTask();
	}

	private void startTask() {
		Bukkit.getScheduler().runTaskTimer(plugin, () -> {
			for (final Player player : Bukkit.getServer().getOnlinePlayers()) {
				if (player.getInventory().getHelmet() == null) {
					removeAllEffects(player);
					return;
				}
				if (player.getInventory().getChestplate() == null) {
					removeAllEffects(player);
					return;
				}
				if (player.getInventory().getLeggings() == null) {
					removeAllEffects(player);
					return;
				}
				if (player.getInventory().getBoots() == null) {
					removeAllEffects(player);
					return;
				}
				final ItemStack helmet = player.getInventory().getHelmet();
				final ItemStack chest = player.getInventory().getChestplate();
				final ItemStack legs = player.getInventory().getLeggings();
				final ItemStack boots = player.getInventory().getBoots();
				if (helmet.equals(items.getTier1Helmet())) {
					if (checkFullTierOneArmour(chest, legs, boots)) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
					} else {
						if (player.hasPotionEffect(PotionEffectType.SPEED)) {
							player.removePotionEffect(PotionEffectType.SPEED);
						}
					}
				} else if (helmet.equals(items.getTier2Helmet())) {
					if (checkFullTierTwoArmour(chest, legs, boots)) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
					} else {
						if (player.hasPotionEffect(PotionEffectType.SPEED)) {
							player.removePotionEffect(PotionEffectType.SPEED);
						}
					}
				} else if (helmet.equals(items.getTier3Helmet())) {
					if (checkFullTierThreeArmour(chest, legs, boots)) {
						player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
					} else {
						if (player.hasPotionEffect(PotionEffectType.SPEED)) {
							player.removePotionEffect(PotionEffectType.SPEED);
						}
					}
				}
			}
		}, 0L, 20L);
	}


	private boolean checkFullTierOneArmour(final ItemStack chest, final ItemStack legs, final ItemStack boots) {
		return chest.equals(items.getTier1Chestplate()) && legs.equals(items.getTier1Leggings()) && boots.equals(items.getTier1Boots());
	}

	private boolean checkFullTierTwoArmour(final ItemStack chest, final ItemStack legs, final ItemStack boots) {
		return chest.equals(items.getTier2Chestplate()) && legs.equals(items.getTier2Leggings()) && boots.equals(items.getTier2Boots());
	}

	private boolean checkFullTierThreeArmour(final ItemStack chest, final ItemStack legs, final ItemStack boots) {
		return chest.equals(items.getTier3Chestplate()) && legs.equals(items.getTier3Leggings()) && boots.equals(items.getTier3Boots());
	}

	private void removeAllEffects(final Player player) {
		for (final PotionEffect effect : player.getActivePotionEffects()) {
			player.removePotionEffect(effect.getType());
		}
	}
}
