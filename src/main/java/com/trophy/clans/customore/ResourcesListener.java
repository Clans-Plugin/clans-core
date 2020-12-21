package com.trophy.clans.customore;

import com.trophy.clans.main.Clans;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ResourcesListener implements Listener {


    private OreItemStacks i = new OreItemStacks();

    private String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }


    //Respawn the ore in x time and put ore in inventory
    // material: ore broken, time: respawn time of ore, item: Itemstack to put in inventory, e: event

    private void respawnBlock(Material material, Integer time, ItemStack item, BlockBreakEvent x) {

        x.getBlock().setType(Material.BEDROCK);
        Bukkit.getScheduler().runTaskLater(Clans.plugin, () -> x.getBlock().setType(material), time * 20);
        x.setCancelled(true);

        x.getPlayer().getInventory().addItem(item);
        String lore = item.getItemMeta().getDisplayName();
        x.getPlayer().sendMessage(color("&2+ " + lore));

    }


    @EventHandler
    public void breakEvent(BlockBreakEvent e) {


        Player p = e.getPlayer();

        if (!p.hasPermission("clans.edit")) {

            e.setCancelled(true);

            if (e.getBlock().getType() == Material.STONE) {


                respawnBlock(Material.STONE, 120, i.getStone(2), e);

            } else if (e.getBlock().getType() == Material.COAL_ORE) {

                respawnBlock(Material.COAL_ORE, 240, i.getFuel(2), e);

            } else if (e.getBlock().getType() == Material.IRON_ORE) {

                respawnBlock(Material.IRON_ORE, 240, i.getIron(2), e);

            } else if (e.getBlock().getType() == Material.GOLD_ORE) {

                respawnBlock(Material.GOLD_ORE, 480, i.getSulfur(2), e);

            } else if (e.getBlock().getType() == Material.LOG) {

                respawnBlock(Material.LOG, 120, i.getWood(2), e);

            } else {

                p.sendMessage(color("&cYou can not mine this block!"));

            }

        } else {

            e.setCancelled(false);

        }

    }

}