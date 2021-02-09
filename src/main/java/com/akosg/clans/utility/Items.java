package com.akosg.clans.utility;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

@Getter
public class Items {

private final ItemStack c4;
private final ItemStack tier1Wall;
private final ItemStack tier2Wall;
private final ItemStack tier3Wall;
private final ItemStack tier1Door;
private final ItemStack tier2Door;
private final ItemStack chest;
private final ItemStack upgradeTool;
private final ItemStack tier1Axe;
private final ItemStack tier2Axe;
private final ItemStack tier3Axe;
private final ItemStack tier1Pickaxe;
private final ItemStack tier2Pickaxe;
private final ItemStack tier3Pickaxe;
private final ItemStack wood;
private final ItemStack stone;
private final ItemStack iron;
private final ItemStack fuel;
private final ItemStack sulfur;
private final ItemStack cookedsulfur;
private final ItemStack tier1Helmet;
private final ItemStack tier1Chestplate;
private final ItemStack tier1Leggings;
private final ItemStack tier1Boots;
private final ItemStack tier2Helmet;
private final ItemStack tier2Chestplate;
private final ItemStack tier2Leggings;
private final ItemStack tier2Boots;
private final ItemStack tier3Helmet;
private final ItemStack tier3Chestplate;
private final ItemStack tier3Leggings;
private final ItemStack tier3Boots;
private final ItemStack tier1Sword;
private final ItemStack tier2Sword;
private final ItemStack tier3Sword;

private final RandomCollection<ItemStack> tier1Barrel = new RandomCollection<>();
private final RandomCollection<ItemStack> tier2Barrel = new RandomCollection<>();
private final RandomCollection<ItemStack> tier3Barrel = new RandomCollection<>();

public Items() {

   
   // C4

   final ItemStack c4 = new ItemStack(Material.TNT);
   final ItemMeta c4Meta = c4.getItemMeta();
   c4Meta.setDisplayName("§c§lC4");
   c4.setItemMeta(c4Meta);

   this.c4 = c4;

   // Tier 1 Wall

   final ItemStack t1 = new ItemStack(Material.WOOD);
   final ItemMeta t1Meta = t1.getItemMeta();
   t1Meta.setDisplayName("§6§lTier I Wall");
   t1.setItemMeta(t1Meta);

   this.tier1Wall = t1;

   // Tier 2 Wall

   final ItemStack t2 = new ItemStack(Material.BRICK);
   final ItemMeta t2Meta = t2.getItemMeta();
   t2Meta.setDisplayName("§6§lTier 2 Wall");
   t2.setItemMeta(t2Meta);

   this.tier2Wall = t2;

   // Tier 3 Wall

   final ItemStack t3 = new ItemStack(Material.OBSIDIAN);
   final ItemMeta t3Meta = t3.getItemMeta();
   t3Meta.setDisplayName("§6§lTier 3 Wall");
   t3.setItemMeta(t3Meta);

   this.tier3Wall = t3;

   // Tier 1 Door

   final ItemStack door = new ItemStack(Material.WOOD_DOOR);
   final ItemMeta doorMeta = door.getItemMeta();
   doorMeta.setDisplayName("§6§lTier 1 Door");
   door.setItemMeta(doorMeta);

   this.tier1Door = door;

   // Tier 2 Door

   final ItemStack door2 = new ItemStack(Material.IRON_DOOR);
   final ItemMeta door2Meta = door2.getItemMeta();
   door2Meta.setDisplayName("§6§lTier 2 Door");
   door2.setItemMeta(door2Meta);

   this.tier2Door = door2;

   // Chest

   final ItemStack chest = new ItemStack(Material.CHEST);
   final ItemMeta chestMeta = chest.getItemMeta();
   chestMeta.setDisplayName("§6§lChest");
   chest.setItemMeta(chestMeta);

   this.chest = chest;

   // Upgrade Tool

   final ItemStack UpgradeTool = new ItemStack(Material.GOLD_AXE);
   final ItemMeta UpgradeToolMeta = UpgradeTool.getItemMeta();
   UpgradeToolMeta.setDisplayName("§c§lUpgrade Tool");
   UpgradeTool.setItemMeta(UpgradeToolMeta);

   this.upgradeTool = UpgradeTool;

   // Tier 1 Axe

   final ItemStack tier1axe = new ItemStack(Material.WOOD_AXE);
   final ItemMeta tier1axeMeta = tier1axe.getItemMeta();
   tier1axeMeta.setDisplayName("§6§lTier 1 Axe");
   tier1axeMeta.setLore(Collections.singletonList("§6Speed 1"));
   tier1axe.setItemMeta(tier1axeMeta);

   this.tier1Axe = tier1axe;

   // Tier 2 Axe

   final ItemStack tier2axe = new ItemStack(Material.STONE_AXE);
   final ItemMeta tier2axeMeta = tier2axe.getItemMeta();
   tier2axeMeta.setDisplayName("§6§lTier 2 Axe");
   tier2axeMeta.setLore(Collections.singletonList("§6Speed 2"));
   tier2axe.setItemMeta(tier2axeMeta);

   this.tier2Axe = tier2axe;

   // Tier 3 Axe

   final ItemStack tier3axe = new ItemStack(Material.IRON_AXE);
   final ItemMeta tier3axeMeta = tier3axe.getItemMeta();
   tier3axeMeta.setDisplayName("§6§lTier 3 Axe");
   tier3axeMeta.setLore(Collections.singletonList("§6Speed 3"));
   tier3axe.setItemMeta(tier3axeMeta);

   this.tier3Axe = tier3axe;

   // Tier 1 Pickaxe

   final ItemStack tier1pickaxe = new ItemStack(Material.WOOD_PICKAXE, 1);
   final ItemMeta tier1pickaxeMeta = tier1pickaxe.getItemMeta();
   tier1pickaxeMeta.setDisplayName("§6§lTier 1 PickAxe");
   tier1pickaxeMeta.setLore(Collections.singletonList("§6Speed 1"));
   tier1pickaxe.setItemMeta(tier1pickaxeMeta);

   this.tier1Pickaxe = tier1pickaxe;

   // Tier 2 Pickaxe

   final ItemStack tier2pickaxe = new ItemStack(Material.STONE_PICKAXE, 1);
   final ItemMeta tier2pickaxeMeta = tier2pickaxe.getItemMeta();
   tier2pickaxeMeta.setDisplayName("§6§lTier 2 PickAxe");
   tier2pickaxeMeta.setLore(Arrays.asList("§6Speed 2"));
   tier2pickaxe.setItemMeta(tier2pickaxeMeta);

   this.tier2Pickaxe = tier2pickaxe;

   // Tier 3 Pickaxe

   final ItemStack tier3pickaxe = new ItemStack(Material.IRON_PICKAXE, 1);
   final ItemMeta tier3pickaxeMeta = tier3pickaxe.getItemMeta();
   tier3pickaxeMeta.setDisplayName("§6§lTier 3 PickAxe");
   tier3pickaxeMeta.setLore(Arrays.asList("§6Speed 3"));
   tier3pickaxe.setItemMeta(tier3pickaxeMeta);

   this.tier3Pickaxe = tier3pickaxe;

   // Wood

   final ItemStack wood = new ItemStack(Material.LOG);
   final ItemMeta woodMeta = wood.getItemMeta();
   woodMeta.setDisplayName("§8§lWood");
   wood.setItemMeta(woodMeta);

   this.wood = wood;

   // Stone

   final ItemStack stone = new ItemStack(Material.STONE);
   final ItemMeta stoneMeta = stone.getItemMeta();
   stoneMeta.setDisplayName("§7§lStone");
   stone.setItemMeta(stoneMeta);

   this.stone = stone;

   // Iron

   final ItemStack iron = new ItemStack(Material.IRON_INGOT);
   final ItemMeta ironMeta = iron.getItemMeta();
   ironMeta.setDisplayName("§f§lIron");
   iron.setItemMeta(ironMeta);

   this.iron = iron;

   // Fuel

   final ItemStack fuel = new ItemStack(Material.COAL);
   final ItemMeta fuelMeta = fuel.getItemMeta();
   fuelMeta.setDisplayName("§c§lFuel");
   fuel.setItemMeta(fuelMeta);

   this.fuel = fuel;

   // Sulfur

   final ItemStack sulfur = new ItemStack(Material.GOLD_ORE);
   final ItemMeta sulfurMeta = sulfur.getItemMeta();
   sulfurMeta.setDisplayName("§e§lSulfur Ore");
   sulfur.setItemMeta(sulfurMeta);

   this.sulfur = sulfur;

   // Cooked Sulfur

   final ItemStack cookedsulfur = new ItemStack(Material.GOLD_INGOT);
   final ItemMeta cookedsulfurMeta = cookedsulfur.getItemMeta();
   cookedsulfurMeta.setDisplayName("§e§lSulfur");
   cookedsulfur.setItemMeta(cookedsulfurMeta);

   this.cookedsulfur = cookedsulfur;

   // Tier 1 Helmet

   final ItemStack TierOneHelmet = new ItemStack(Material.IRON_HELMET);
   final ItemMeta TierOneHelmetMeta = TierOneHelmet.getItemMeta();
   TierOneHelmetMeta.setDisplayName("§f§lHelmet - Tier I");
   TierOneHelmet.setItemMeta(TierOneHelmetMeta);

   this.tier1Helmet = TierOneHelmet;

   // Tier 1 ChestPlate

   final ItemStack TierOneChestplate = new ItemStack(Material.IRON_CHESTPLATE);
   final ItemMeta TierOneChestplateMeta = TierOneChestplate.getItemMeta();
   TierOneChestplateMeta.setDisplayName("§f§lChestplate - Tier I");
   TierOneChestplate.setItemMeta(TierOneChestplateMeta);

   this.tier1Chestplate = TierOneChestplate;

   // Tier 1 Leggings

   final ItemStack TierOneLeggings = new ItemStack(Material.IRON_LEGGINGS);
   final ItemMeta TierOneLeggingsMeta = TierOneLeggings.getItemMeta();
   TierOneLeggingsMeta.setDisplayName("§f§lLeggings - Tier I");
   TierOneLeggings.setItemMeta(TierOneLeggingsMeta);

   this.tier1Leggings = TierOneLeggings;

   // Tier 1 Boots

   final ItemStack TierOneBoots = new ItemStack(Material.IRON_BOOTS);
   final ItemMeta TierOneBootsMeta = TierOneBoots.getItemMeta();
   TierOneBootsMeta.setDisplayName("§f§lBoots - Tier I");
   TierOneBoots.setItemMeta(TierOneBootsMeta);

   this.tier1Boots = TierOneBoots;

   // Tier 2 Helmet

   final ItemStack TierTwoHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
   final ItemMeta TierTwoHelmetMeta = TierTwoHelmet.getItemMeta();
   TierTwoHelmetMeta.setDisplayName("§f§lHelmet - Tier II");
   TierTwoHelmet.setItemMeta(TierTwoHelmetMeta);

   this.tier2Helmet = TierTwoHelmet;

   // Tier 2 Chestplate

   final ItemStack TierTwoChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
   final ItemMeta TierTwoChestplateMeta = TierTwoChestplate.getItemMeta();
   TierTwoChestplateMeta.setDisplayName("§f§lChestplate - Tier II");
   TierTwoChestplate.setItemMeta(TierTwoChestplateMeta);

   this.tier2Chestplate = TierTwoChestplate;

   // Tier 2 Leggings

   final ItemStack TierTwoLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
   final ItemMeta TierTwoLeggingsMeta = TierTwoLeggings.getItemMeta();
   TierTwoLeggingsMeta.setDisplayName("§f§lLeggings - Tier II");
   TierTwoLeggings.setItemMeta(TierTwoLeggingsMeta);

   this.tier2Leggings = TierTwoLeggings;

   // Tier 2 Boots

   final ItemStack TierTwoBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
   final ItemMeta TierTwoBootsMeta = TierTwoBoots.getItemMeta();
   TierTwoBootsMeta.setDisplayName("§f§lBoots - Tier II");
   TierTwoBoots.setItemMeta(TierTwoBootsMeta);

   this.tier2Boots = TierTwoBoots;

   // Tier 3 Helmet

   final ItemStack TierThreeHelmet = new ItemStack(Material.DIAMOND_HELMET);
   final ItemMeta TierThreeHelmetMeta = TierThreeHelmet.getItemMeta();
   TierThreeHelmetMeta.setDisplayName("§f§lHelmet - Tier III");
   TierThreeHelmet.setItemMeta(TierThreeHelmetMeta);

   this.tier3Helmet = TierThreeHelmet;

   // Tier 3 Chestplate

   final ItemStack TierThreeChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
   final ItemMeta TierThreeChestplateMeta = TierThreeChestplate.getItemMeta();
   TierThreeChestplateMeta.setDisplayName("§f§lChestplate - Tier III");
   TierThreeChestplate.setItemMeta(TierThreeChestplateMeta);

   this.tier3Chestplate = TierThreeChestplate;

   // Tier 3 Leggings

   final ItemStack TierThreeLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
   final ItemMeta TierThreeLeggingsMeta = TierThreeLeggings.getItemMeta();
   TierThreeLeggingsMeta.setDisplayName("§f§lLeggings - Tier III");
   TierThreeLeggings.setItemMeta(TierThreeLeggingsMeta);

   this.tier3Leggings = TierThreeLeggings;

   // Tier 3 Boots

   final ItemStack TierThreeBoots = new ItemStack(Material.DIAMOND_BOOTS);
   final ItemMeta TierThreeBootsMeta = TierThreeBoots.getItemMeta();
   TierThreeBootsMeta.setDisplayName("§f§lBoots - Tier III");
   TierThreeBoots.setItemMeta(TierThreeBootsMeta);

   this.tier3Boots = TierThreeBoots;

   // Tier 1 Sword

   final ItemStack TierOneSword = new ItemStack(Material.STONE_SWORD);
   final ItemMeta TierOneSwordMeta = TierOneSword.getItemMeta();
   TierOneSwordMeta.setDisplayName("§c§lSword - Tier I");
   TierOneSword.setItemMeta(TierOneSwordMeta);

   this.tier1Sword = TierOneSword;

   // Tier 2 Sword

   final ItemStack TierTwoSword = new ItemStack(Material.IRON_SWORD);
   final ItemMeta TierTwoSwordMeta = TierTwoSword.getItemMeta();
   TierTwoSwordMeta.setDisplayName("§c§lSword - Tier II");
   TierTwoSword.setItemMeta(TierTwoSwordMeta);

   this.tier2Sword = TierTwoSword;

   // Tier 3 Sword

   final ItemStack TierThreeSword = new ItemStack(Material.DIAMOND_SWORD);
   final ItemMeta TierThreeSwordMeta = TierThreeSword.getItemMeta();
   TierThreeSwordMeta.setDisplayName("§c§lSword - Tier III");
   TierThreeSword.setItemMeta(TierThreeSwordMeta);

   this.tier3Sword = TierThreeSword;

   // Tier 1 Barrel

   iron.setAmount(16);
   tier1Barrel.add(0.1, iron);
   wood.setAmount(16);
   tier1Barrel.add(0.1, wood);
   stone.setAmount(16);
   tier1Barrel.add(0.1, stone);
   sulfur.setAmount(16);
   tier1Barrel.add(0.1, sulfur);
   iron.setAmount(32);
   tier1Barrel.add(0.15, iron);
   wood.setAmount(32);
   tier1Barrel.add(0.15, wood);
   stone.setAmount(32);
   tier1Barrel.add(0.15, stone);
   sulfur.setAmount(32);
   tier1Barrel.add(0.15, sulfur);

   // Tier 2 Barrel

   t1.setAmount(16);
   tier2Barrel.add(0.15, t1);
   cookedsulfur.setAmount(16);
   tier2Barrel.add(0.15, cookedsulfur);
   stone.setAmount(32);
   tier2Barrel.add(0.15, stone);
   sulfur.setAmount(32);
   tier2Barrel.add(0.15, sulfur);
   iron.setAmount(32);
   tier2Barrel.add(0.1, iron);
   t1.setAmount(32);
   tier2Barrel.add(0.1, t1);
   t2.setAmount(16);
   tier2Barrel.add(0.1, t2);
   tier2Barrel.add(0.05, tier3axe);
   tier2Barrel.add(0.05, tier3pickaxe);

   // Tier 3 Barrel

   t2.setAmount(16);
   tier3Barrel.add(0.15, t2);
   cookedsulfur.setAmount(32);
   tier3Barrel.add(0.15, cookedsulfur);
   tier3Barrel.add(0.15, cookedsulfur);
   tier3Barrel.add(0.15, TierOneSword);
   tier3Barrel.add(0.05, TierThreeSword);
   tier3Barrel.add(0.025, TierTwoHelmet);
   tier3Barrel.add(0.025, TierTwoChestplate);
   tier3Barrel.add(0.025, TierTwoLeggings);
   tier3Barrel.add(0.025, TierTwoBoots);
   t3.setAmount(64);
   tier3Barrel.add(0.05, t3);
   tier3Barrel.add(0.1, tier3axe);
   tier3Barrel.add(0.1, tier3pickaxe);

}

public void giveCustomItem(final Player target, final ItemStack item, final int amount) {

   item.setAmount(amount);
   target.getInventory().addItem(item);
   target.sendMessage(item.getAmount() + "x " + item.getItemMeta().getDisplayName() + " §chas been added to your inventory!");

}

public void addItemToInventory(final Player player, final ItemStack item, final int amount) {

   item.setAmount(amount);
   player.getInventory().addItem(item);
   player.sendMessage("§2+ " + item.getAmount() + " " + item.getItemMeta().getDisplayName());

}

//ALL TIMES IN SECONDS DUE TO COSMETIC REASONS --> CONVERT TO TICKS IN CLASS YOU ARE USING IT

public Integer getCraftTime(final ItemStack item, final int amount) {

   final int time = 0;

   return 0;
}

}
