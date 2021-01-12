package com.trophy.clans.clansystem;

import com.trophy.clans.database.LocalData;
import com.trophy.clans.utility.Items;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ClanCommands implements CommandExecutor {

	private final Items items;

	public ClanCommands(final Items items) {
		this.items = items;
	}

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

		final Player player = (Player) sender;

		// /clan

		if (args.length == 0) {

			//ADD ALL COMMANDS TO HELP LIST

			player.sendMessage("	§c§l				Clans Help				");
			player.sendMessage("	");
			player.sendMessage("§c/clan create [name]");
			player.sendMessage("§c/clan disband");
			player.sendMessage("§c/clan invite [name]");
			player.sendMessage("§c/clan kick [name]");
			player.sendMessage("§c/clan menu (GUI)");
			player.sendMessage("§c/clan sethome");
			player.sendMessage("§c/clan home");
			player.sendMessage("§c/clan top");

		} else if (args.length == 1) {

			if (args[0].equalsIgnoreCase("give")) {

				player.sendMessage("               §c§lList of available items");
				player.sendMessage("§cRaiding § Base blocks: §fc4, wallt1, wallt2, wallt3, doort1, doort2, chest");
				player.sendMessage("§cTools: §fupgradetool, pickt1, pickt2, pickt3, axet1, axet2, axet3");
				player.sendMessage("§cResources: §fwood, stone, iron, fuel, sulfur, cookedsulfur");
				player.sendMessage("§cArmour sets: §farmourt1, armourt2, armourt3");

			}


		} else

			//ARGS length 2 commands

			if (args.length == 2) {

				if (args[0].equalsIgnoreCase("create")) {

					final String clanName = args[1];
					final Location home = player.getLocation();

					//ADD check if player is already in a clan //DONE
					//ADD check if clan with that name exists //DONE

					try {
						if (!LocalData.getClanName(player).equals("player_not_in_clan")) {
							player.sendMessage("§cYou are already in a Clan!");
							return false;
						}
					} catch (final IOException e1) {
						e1.printStackTrace();
					}

					if (LocalData.existsClan(clanName)) {
						player.sendMessage("§cThis Clanname is already given!");
						return false;
					}

					if (args[1].length() < 12 && args[1].length() > 3) {

						try {
							LocalData.init_clan(clanName, player, home);
							player.sendMessage("§cClan §f§l" + clanName + "§c was created successfully!");
							player.sendMessage("§cClan home has been set at your location!");
							LocalData.giveCoreBlock(player, clanName);
							player.sendMessage("§cPlace your core block to claim a chunk!");
						} catch (final IOException e) {
							e.printStackTrace();
						}

					} else {

						player.sendMessage("§cERROR: Clan name must be between 3 and 12 characters");

					}


				} else if (args[0].equalsIgnoreCase("disband")) {

					//Need check to see if player is in a clan
					player.sendMessage("Not implemented");

				} else if (args[0].equalsIgnoreCase("sethome")) {

					//Need check to see if player is in a clan
					player.sendMessage("Not implemented");

				} else if (args[0].equalsIgnoreCase("home")) {

					//Need check to see if player is in a clan
					player.sendMessage("Not implemented");

				} else if (args[0].equalsIgnoreCase("menu")) {

					//Need check to see if player is in a clan
					player.sendMessage("Not implemented");

				} else if (args[0].equalsIgnoreCase("top")) {

					try {
						player.sendMessage(LocalData.getTopClans().toString());
					} catch (final IOException e) {
						e.printStackTrace();
					}

				} else if (args[0].equalsIgnoreCase("give")) {

					if (args[1].equalsIgnoreCase("c4")) {

						items.giveCustomItem(player, items.getC4(), 4);
						player.sendMessage(items.getCraftTime(items.getTier1Boots(), 2).toString());


					} else if (args[1].equalsIgnoreCase("wallt1")) {

						items.giveCustomItem(player, items.getTier1Wall(), 64);

					} else if (args[1].equalsIgnoreCase("wallt2")) {

						items.giveCustomItem(player, items.getTier2Wall(), 64);

					} else if (args[1].equalsIgnoreCase("wallt3")) {

						items.giveCustomItem(player, items.getTier3Wall(), 64);

					} else if (args[1].equalsIgnoreCase("doort1")) {

						items.giveCustomItem(player, items.getTier1Door(), 1);

					} else if (args[1].equalsIgnoreCase("doort2")) {

						items.giveCustomItem(player, items.getTier2Door(), 1);

					} else if (args[1].equalsIgnoreCase("chest")) {

						items.giveCustomItem(player, items.getChest(), 4);

					} else if (args[1].equalsIgnoreCase("upgradetool")) {

						items.giveCustomItem(player, items.getUpgradeTool(), 4);

					} else if (args[1].equalsIgnoreCase("pickt1")) {

						items.giveCustomItem(player, items.getTier1Pickaxe(), 1);

					} else if (args[1].equalsIgnoreCase("pickt2")) {

						items.giveCustomItem(player, items.getTier2Pickaxe(), 1);

					} else if (args[1].equalsIgnoreCase("pickt3")) {

						items.giveCustomItem(player, items.getTier3Pickaxe(), 1);

					} else if (args[1].equalsIgnoreCase("axet1")) {

						items.giveCustomItem(player, items.getTier1Axe(), 1);

					} else if (args[1].equalsIgnoreCase("axet2")) {

						items.giveCustomItem(player, items.getTier2Axe(), 1);

					} else if (args[1].equalsIgnoreCase("axet3")) {

						items.giveCustomItem(player, items.getTier3Axe(), 1);

					} else if (args[1].equalsIgnoreCase("wood")) {

						items.giveCustomItem(player, items.getWood(), 64);

					} else if (args[1].equalsIgnoreCase("stone")) {

						items.giveCustomItem(player, items.getStone(), 64);

					} else if (args[1].equalsIgnoreCase("iron")) {

						items.giveCustomItem(player, items.getIron(), 64);

					} else if (args[1].equalsIgnoreCase("fuel")) {

						items.giveCustomItem(player, items.getFuel(), 64);

					} else if (args[1].equalsIgnoreCase("sulfur")) {

						items.giveCustomItem(player, items.getSulfur(), 64);

					} else if (args[1].equalsIgnoreCase("cookedsulfur")) {

						items.giveCustomItem(player, items.getCookedsulfur(), 64);

					} else if (args[1].equalsIgnoreCase("armourt1")) {

						items.giveCustomItem(player, items.getTier1Helmet(), 1);
						items.giveCustomItem(player, items.getTier1Chestplate(), 1);
						items.giveCustomItem(player, items.getTier1Leggings(), 1);
						items.giveCustomItem(player, items.getTier1Boots(), 1);

					} else if (args[1].equalsIgnoreCase("armourt2")) {

						items.giveCustomItem(player, items.getTier2Helmet(), 1);
						items.giveCustomItem(player, items.getTier2Chestplate(), 1);
						items.giveCustomItem(player, items.getTier2Leggings(), 1);
						items.giveCustomItem(player, items.getTier2Boots(), 1);

					} else if (args[1].equalsIgnoreCase("armourt3")) {

						items.giveCustomItem(player, items.getTier3Helmet(), 1);
						items.giveCustomItem(player, items.getTier3Chestplate(), 1);
						items.giveCustomItem(player, items.getTier3Leggings(), 1);
						items.giveCustomItem(player, items.getTier3Boots(), 1);

					}
				}
			}

		return false;
	}
}
