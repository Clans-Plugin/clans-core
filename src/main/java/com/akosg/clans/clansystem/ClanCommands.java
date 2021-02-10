package com.akosg.clans.clansystem;

import com.akosg.clans.database.CacheManager;
import com.akosg.clans.database.ClansData;
import com.akosg.clans.database.PlayerCache;
import com.akosg.clans.database.PlayerData;
import com.akosg.clans.main.Clans;
import com.akosg.clans.utility.Items;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class ClanCommands implements CommandExecutor {

	private final Items items;
	private final Clans plugin;

	public ClanCommands(final Items items, final Clans plugin) {
		this.items = items;
		this.plugin = plugin;
	}

	private final String prefix = "§fClans §7> ";

	private final HashMap<String, String> invites = new HashMap<>();


	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

		final Player player = (Player) sender;
		final String uuid = player.getUniqueId().toString();
		final String clanName = PlayerData.getClanName(uuid);

		final PlayerCache playerCache = CacheManager.playerData.get(player);

		//ARGS length 0 commands
		if (args.length == 0) {
			//ADD ALL COMMANDS TO HELP LIST
			player.sendMessage("§cDeveloped by §6akosG");
			player.sendMessage("§7Try /clan help.");
		}

		//ARGS length 1 commands
		//e.g: /clan give, /clan disband, etc.
		else
			if (args.length == 1) {

				final String arg = args[0].toLowerCase();
				// COMMANDS
				switch (arg) {

					case "help":
						helpCmd(player);
						break;

					case "give":
						//<editor-fold desc="Send player list of items">
						player.sendMessage(" ");
						player.sendMessage("§6§lList of available items:");
						player.sendMessage("§cRaiding § Base blocks: §fc4, wallt1, wallt2, wallt3, doort1, doort2, chest");
						player.sendMessage("§cTools: §fupgradetool, pickt1, pickt2, pickt3, axet1, axet2, axet3");
						player.sendMessage("§cResources: §fwood, stone, iron, fuel, sulfur, cookedsulfur");
						player.sendMessage("§cArmour sets: §farmourt1, armourt2, armourt3");
						//</editor-fold>
						break;

					case "leave":
						if (!uuid.equals(ClansData.getOwner(clanName))) {
							player.sendMessage("§cYou have left the clan §6" + clanName);
							PlayerData.setPlayerClan("Solo", uuid);
						} else {
							player.sendMessage("§cYou are the leader of this clan, use /clan disband");
						}
						break;

					case "disband":
						final int num = ClansData.memberNumber(clanName);
						if (uuid.equals(ClansData.getOwner(clanName))) {

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
						break;

					case "sethome":
						if (PlayerData.checkPlayerInClan(uuid)) {

							final int x = player.getLocation().getBlockX();
							final int y = player.getLocation().getBlockY();
							final int z = player.getLocation().getBlockZ();
							//if()  player is clan owner
							ClansData.setClanHome(clanName, x, y, z);

						}
						player.sendMessage(prefix + "§cClan home has been set to your location for: §6" + clanName);
						break;

					case "home":
						player.teleport(ClansData.getClanHome(PlayerData.getClanName(uuid)));
						player.sendMessage(prefix + "§cYou have been teleported to the Clan home of: §6" + clanName);
						break;

					case "level":
						player.sendMessage(prefix + "§cThe level of §6" + clanName + " §cis " + ClansData.getClanLevel(clanName));
						break;

					case "kick":
						player.sendMessage(prefix + "§cUsage: §6/clan kick player");
						break;

					case "points":
						if (PlayerData.checkPlayerInClan(uuid)) {

							final int points = ClansData.getClanPoints(clanName);

							player.sendMessage(prefix + "§cYour clan §6" + clanName + " §chas §6" + points + " §cpoints");
						} else {

							player.sendMessage(prefix + "§cYou are not a member of any clan!");

						}
						break;

					case "top":

						//<editor-fold desc="Send player list of top clans">
						final ArrayList<String> topClans = ClansData.getTopClans();

						assert topClans != null;
						int rank = 0;

						player.sendMessage("      §c§lTOP CLANS");
						player.sendMessage(" ");
						for (final String name : topClans) {

							rank++;

							player.sendMessage("§c§l" + rank + ". §6" + name);


						}
						//</editor-fold>
						break;

					default:
						player.sendMessage("§6§lClans: §f§cUnknown command.");
				}
			}

			//ARGS length 2 commands
			//e.g: /clan give <item>
			else
				if (args.length == 2) {

					final String base = args[0].toLowerCase();
					final String arg = args[1];
					final Player target = Bukkit.getPlayer(args[1]);

					// COMMANDS
					switch (base) {

						case "join":
							final String clan = args[1];
							if (ClansData.checkClanExists(clan)) {
								if (invites.containsKey(player.getUniqueId().toString())) {
									if (invites.containsValue(clan)) {
										PlayerData.setPlayerClan(clan, player.getUniqueId().toString());
										player.sendMessage("§cYou have joined §6" + clan);
									}
								}
							} else {
								player.sendMessage("§cThat clan does not exist");
							}
							break;

						case "invite":
							final String inviterClanName = PlayerData.getClanName(player.getUniqueId().toString());
							if (target != null) {

								if (ClansData.getOwner(inviterClanName).equalsIgnoreCase(player.getUniqueId().toString())) {

									if (!PlayerData.checkPlayerInClan(target.getUniqueId().toString())) {

										invites.put(target.getUniqueId().toString(), inviterClanName);
										player.sendMessage("§cInvite sent to §6" + target.getDisplayName());
										target.sendMessage("§cYou have been invited to §6" + inviterClanName);

										Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
											@Override
											public void run() {
												invites.remove(target.getUniqueId().toString(), inviterClanName);
												player.sendMessage("§cInvite expired for §6" + clanName);
												target.sendMessage("§cYour invite to §6" + clanName + " §chas expired");
											}
										}, 2400L);

									} else {

										player.sendMessage("§6" + target.getDisplayName() + "§c Is already in a clan!");

									}

								} else {

									player.sendMessage("§cYou are not the owner of §6" + clanName);

								}

							} else {
								player.sendMessage("§cThat player does not exist!");
							}
							break;

						case "kick":
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
							break;

						case "create":
							final String name = args[1];
							if (!PlayerData.checkPlayerInClan(uuid)) {

								if (args[1].length() < 12 && args[1].length() > 3) {

									if (!ClansData.checkClanExists(name)) {


										playerCache.setClanName(name);


										ClansData.createClan(name, uuid, 0, 0, 0, 0, 0, 0, 0, 1);
										//PlayerData.setPlayerClan(name, uuid);


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
							break;

						case "points":
							final String nameC = args[1];
							if (ClansData.checkClanExists(nameC)) {

								final int points = ClansData.getClanPoints(clanName);

								player.sendMessage(prefix + "§cThe clan §6" + clanName + " §chas §6" + points + "§cpoints!");
							} else {

								player.sendMessage(prefix + "§cThe clan§6 " + nameC + " §cdoes not exist!");

							}
							break;

						case "menu":
							//Need check to see if player is in a clan
							player.sendMessage("Not implemented");
							break;

						case "give":
							//<editor-fold desc="HUGE MESS">
							if (args[1].equalsIgnoreCase("c4")) {

								items.giveCustomItem(player, items.getC4(), 4);
								player.sendMessage(items.getCraftTime(items.getTier1Boots(), 2).toString());


							} else
								if (args[1].equalsIgnoreCase("wallt1")) {

									items.giveCustomItem(player, items.getTier1Wall(), 64);

								} else
									if (args[1].equalsIgnoreCase("wallt2")) {

										items.giveCustomItem(player, items.getTier2Wall(), 64);

									} else
										if (args[1].equalsIgnoreCase("wallt3")) {

											items.giveCustomItem(player, items.getTier3Wall(), 64);

										} else
											if (args[1].equalsIgnoreCase("doort1")) {

												items.giveCustomItem(player, items.getTier1Door(), 1);

											} else
												if (args[1].equalsIgnoreCase("doort2")) {

													items.giveCustomItem(player, items.getTier2Door(), 1);

												} else
													if (args[1].equalsIgnoreCase("chest")) {

														items.giveCustomItem(player, items.getChest(), 4);

													} else
														if (args[1].equalsIgnoreCase("upgradetool")) {

															items.giveCustomItem(player, items.getUpgradeTool(), 4);


														} else
															if (args[1].equalsIgnoreCase("pickt1")) {

																items.giveCustomItem(player, items.getTier1Pickaxe(), 1);

															} else
																if (args[1].equalsIgnoreCase("pickt2")) {

																	items.giveCustomItem(player, items.getTier2Pickaxe(), 1);

																} else
																	if (args[1].equalsIgnoreCase("pickt3")) {

																		items.giveCustomItem(player, items.getTier3Pickaxe(), 1);

																	} else
																		if (args[1].equalsIgnoreCase("axet1")) {

																			items.giveCustomItem(player, items.getTier1Axe(), 1);

																		} else
																			if (args[1].equalsIgnoreCase("axet2")) {

																				items.giveCustomItem(player, items.getTier2Axe(), 1);

																			} else
																				if (args[1].equalsIgnoreCase("axet3")) {

																					items.giveCustomItem(player, items.getTier3Axe(), 1);

																				} else
																					if (args[1].equalsIgnoreCase("wood")) {

																						items.giveCustomItem(player, items.getWood(), 64);

																					} else
																						if (args[1].equalsIgnoreCase("stone")) {

																							items.giveCustomItem(player, items.getStone(), 64);

																						} else
																							if (args[1].equalsIgnoreCase("iron")) {

																								items.giveCustomItem(player, items.getIron(), 64);

																							} else
																								if (args[1].equalsIgnoreCase("fuel")) {

																									items.giveCustomItem(player, items.getFuel(), 64);

																								} else
																									if (args[1].equalsIgnoreCase("sulfur")) {

																										items.giveCustomItem(player, items.getSulfur(), 64);

																									} else
																										if (args[1].equalsIgnoreCase("cookedsulfur")) {

																											items.giveCustomItem(player, items.getCookedsulfur(), 64);

																										} else
																											if (args[1].equalsIgnoreCase("armourt1")) {

																												items.giveCustomItem(player, items.getTier1Helmet(), 1);
																												items.giveCustomItem(player, items.getTier1Chestplate(), 1);
																												items.giveCustomItem(player, items.getTier1Leggings(), 1);
																												items.giveCustomItem(player, items.getTier1Boots(), 1);

																											} else
																												if (args[1].equalsIgnoreCase("armourt2")) {

																													items.giveCustomItem(player, items.getTier2Helmet(), 1);
																													items.giveCustomItem(player, items.getTier2Helmet(), 1);
																													items.giveCustomItem(player, items.getTier2Chestplate(), 1);
																													items.giveCustomItem(player, items.getTier2Leggings(), 1);
																													items.giveCustomItem(player, items.getTier2Boots(), 1);

																												} else
																													if (args[1].equalsIgnoreCase("armourt3")) {

																														items.giveCustomItem(player, items.getTier3Helmet(), 1);
																														items.giveCustomItem(player, items.getTier3Chestplate(), 1);
																														items.giveCustomItem(player, items.getTier3Leggings(), 1);
																														items.giveCustomItem(player, items.getTier3Boots(), 1);

																													}
							//</editor-fold>
							break;

						default:
							player.sendMessage("§6§lClans: §f§cUnknown command.");

					}
				}

				//ARGS length 4 commands
				//e.g /clan set level <level>
				else
					if (args.length == 4) {

						if (args[0].equalsIgnoreCase("set")) {

							if (args[1].equalsIgnoreCase("level")) {

								final String targetClan = args[2];

								if (ClansData.checkClanExists(targetClan)) {

									final int targetLevel = Integer.parseInt(args[3]);

									ClansData.setClanLevel(targetClan, targetLevel);

									player.sendMessage(prefix + "§cThe level of the clan§6 " + targetClan + " §cis now §6" + targetLevel);

								} else {

									player.sendMessage(prefix + "§cThe clan§6 " + targetClan + " §cdoes not exist!");

								}

							}

						}

					}
		return false;
	}

	private void helpCmd(final Player player) {
		// String[] cmdList = {"help", "give", "leave",
		//		   "disband", "sethome", "home", "level", "kick", "points"
		//		   , "top", "create"};
		player.sendMessage(" ");
		player.sendMessage("§7§lCommands:");
		player.sendMessage("§6§l/clan §cgive");
		player.sendMessage("§6§l/clan §cleave");
		player.sendMessage("§6§l/clan §cdisband");
		player.sendMessage("§6§l/clan §csethome");
		player.sendMessage("§6§l/clan §chome");
		player.sendMessage("§6§l/clan §clevel");
		player.sendMessage("§6§l/clan §ckick");
		player.sendMessage("§6§l/clan §cpoints");
		player.sendMessage("§6§l/clan §ctop");
		player.sendMessage("§6§l/clan §ccreate");

	}


}

