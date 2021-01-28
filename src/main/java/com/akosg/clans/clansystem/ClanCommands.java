package com.trophy.clans.clansystem;

import com.trophy.clans.database.ClansData;
import com.trophy.clans.database.PlayerData;
import com.trophy.clans.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClanCommands implements CommandExecutor {

	private final Items items;

	public ClanCommands(final Items items) {
		this.items = items;
	}

	private final String prefix = "§fClans §7> ";

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

		final Player player = (Player) sender;
		final String uuid = player.getUniqueId().toString();
		final String clanName = PlayerData.getClanName(uuid);

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

				player.sendMessage("§c§lList of available items");
				player.sendMessage("§cRaiding § Base blocks: §fc4, wallt1, wallt2, wallt3, doort1, doort2, chest");
				player.sendMessage("§cTools: §fupgradetool, pickt1, pickt2, pickt3, axet1, axet2, axet3");
				player.sendMessage("§cResources: §fwood, stone, iron, fuel, sulfur, cookedsulfur");
				player.sendMessage("§cArmour sets: §farmourt1, armourt2, armourt3");

			} else if (args[0].equalsIgnoreCase("disband")) {

				final int num = ClansData.memberNumber(clanName);

				if (uuid.equalsIgnoreCase(ClansData.getOwner(clanName))) {

					if (num < 2) {


						ClansData.removeClan(PlayerData.getClanName(uuid));

						player.sendMessage(prefix + "§cYou have disbanded the clan: §6" + clanName);


						PlayerData.setPlayerClan("Solo", uuid);


					} else {

						final int members = num - 1;

						player.sendMessage(prefix + "§cYou must kick all §6" + members + "§c members before you can disband §6 " + clanName);


					}

				} else {

					player.sendMessage(prefix + "§cYou are not the owner of: §6" + clanName);


				}


			} else if (args[0].equalsIgnoreCase("sethome")) {

				if (PlayerData.checkPlayerInClan(uuid)) {

					final int x = player.getLocation().getBlockX();
					final int y = player.getLocation().getBlockY();
					final int z = player.getLocation().getBlockZ();
					//if()  player is clan owner
					ClansData.setClanHome(clanName, x, y, z);

				}

				player.sendMessage(prefix + "§cClan home has been set to your location for: §6" + clanName);

			} else if (args[0].equalsIgnoreCase("home")) {

				player.teleport(ClansData.getClanHome(PlayerData.getClanName(uuid)));
				player.sendMessage(prefix + "§cYou have been teleported to the Clan home of: §6" + clanName);


			} else if (args[0].equalsIgnoreCase("kick")) {

				player.sendMessage(prefix + "§cUsage: §6/clan kick player");


			} else if (args[0].equalsIgnoreCase("points")) {

				if (PlayerData.checkPlayerInClan(uuid)) {

					final String points = ClansData.getClanPoints(clanName);

					player.sendMessage(prefix + "§cYour clan §6" + clanName + " §chas §6" + points + " §cpoints");
				} else {

					player.sendMessage(prefix + "§cYou are not a member of any clan!");

				}

			} else if (args[0].equalsIgnoreCase("top")) {

				player.sendMessage("not implemented yet");


			}

		} else

			//ARGS length 2 commands

			if (args.length == 2) {

				if (args[0].equalsIgnoreCase("kick")) {

					Player target = Bukkit.getPlayer(args[1]);

					if (uuid.equalsIgnoreCase(ClansData.getOwner(clanName))) {

						if (PlayerData.getClanName(target.getUniqueId().toString()).equalsIgnoreCase(clanName)) {

							PlayerData.setPlayerClan("Solo", target.getUniqueId().toString());
							player.sendMessage(prefix + "§cYou have kicked§6 " + target + " §cfrom your clan!");
							player.sendMessage(prefix + "§cYou have been kicked from: §6" + clanName);
						} else {

							player.sendMessage(prefix + "§6" + target + " §cis not a member of your clan!");

						}

					} else {

						player.sendMessage(prefix + "§cYou are not the owner of: §6" + clanName);

					}


				} else if (args[0].equalsIgnoreCase("create")) {

					final String name = args[1];


					if (!PlayerData.checkPlayerInClan(uuid)) {

						if (args[1].length() < 12 && args[1].length() > 3) {

							if (!ClansData.checkClanExists(name)) {

								ClansData.createClan(name, uuid, 0, 0, 0, 0, "0");
								PlayerData.setPlayerClan(name, uuid);

								player.sendMessage(prefix + "§cThe clan §6" + name + "§c has been created!");

							} else {

								player.sendMessage(prefix + "§cThe clan §6" + name + "§c already exists!");

							}

						} else {

							player.sendMessage(prefix + "§cThe name of the clan has to be between§6 3 and 12 characters");

						}

					} else {

						player.sendMessage(prefix + "§cYou are already in a clan: §6" + clanName);

					}


				} else if (args[0].equalsIgnoreCase("points")) {

					final String name = args[1];

					if (ClansData.checkClanExists(name)) {

						final String points = ClansData.getClanPoints(clanName);

						player.sendMessage(prefix + "§cThe clan §6" + clanName + " §chas §6" + points + "§cpoints");
					} else {

						player.sendMessage(prefix + "§cThe clan§6 " + name + " §cdoes not exist");

					}

				} else if (args[0].equalsIgnoreCase("home")) {

					if (ClansData.checkClanExists(args[1])) {

						player.teleport(ClansData.getClanHome(args[1]));
						player.sendMessage(prefix + "§cYou have been teleported to the Clan home of: §6" + args[1]);

					} else {

						player.sendMessage(prefix + "§cThat clan does not exist!");


					}

				} else if (args[0].equalsIgnoreCase("menu")) {

					//Need check to see if player is in a clan
					player.sendMessage("Not implemented");

				} else if (args[0].equalsIgnoreCase("top")) {

					//get top clans


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
