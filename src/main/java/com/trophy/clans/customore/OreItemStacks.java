package com.trophy.clans.customore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OreItemStacks {

    private String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public ItemStack getWood(Integer amount) {

        ItemStack wood = new ItemStack(Material.LOG, amount);
        ItemMeta woodMeta = wood.getItemMeta();
        woodMeta.setDisplayName(color("&8&lWood"));
        wood.setItemMeta(woodMeta);

        return wood;
    }


    public ItemStack getStone(Integer amount) {

        ItemStack stone = new ItemStack(Material.STONE, amount);
        ItemMeta stoneMeta = stone.getItemMeta();
        stoneMeta.setDisplayName(color("&7&lStone"));
        stone.setItemMeta(stoneMeta);

        return stone;
    }


    public ItemStack getIron(Integer amount) {


        ItemStack iron = new ItemStack(Material.IRON_INGOT, amount);
        ItemMeta ironMeta = iron.getItemMeta();
        ironMeta.setDisplayName(color("&f&lIron"));
        iron.setItemMeta(ironMeta);

        return iron;
    }


    public ItemStack getFuel(Integer amount) {


        ItemStack fuel = new ItemStack(Material.COAL, amount);
        ItemMeta fuelMeta = fuel.getItemMeta();
        fuelMeta.setDisplayName(color("&c&lFuel"));
        fuel.setItemMeta(fuelMeta);

        return fuel;
    }


    public ItemStack getSulfur(Integer amount) {


        ItemStack sulfur = new ItemStack(Material.GOLD_ORE, amount);
        ItemMeta sulfurMeta = sulfur.getItemMeta();
        sulfurMeta.setDisplayName(color("&e&lSulfur"));
        sulfur.setItemMeta(sulfurMeta);

        return sulfur;
    }


}
