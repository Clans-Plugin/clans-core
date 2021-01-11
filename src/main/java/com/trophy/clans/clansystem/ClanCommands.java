package com.trophy.clans.clansystem;

import com.trophy.clans.utility.Items;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.trophy.clans.database.LocalData;

import java.io.IOException;

public class ClanCommands implements CommandExecutor {

	private String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	private Items ais = new Items();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		Player p = (Player) sender;

		// /clan

		if (args.length == 0) {

			//ADD ALL COMMANDS TO HELP LIST

			p.sendMessage(color("	&c&l				Clans Help				"));
			p.sendMessage(color("	"));
			p.sendMessage(color("&c/clan create [name]"));
			p.sendMessage(color("&c/clan disband"));
			p.sendMessage(color("&c/clan invite [name]"));
			p.sendMessage(color("&c/clan kick [name]"));
			p.sendMessage(color("&c/clan menu (GUI)"));
			p.sendMessage(color("&c/clan sethome"));
			p.sendMessage(color("&c/clan home"));
			p.sendMessage(color("&c/clan top"));

		} else

			//ARGS length 2 commands

			if (args.length == 1) {

				if (args[0].equalsIgnoreCase("give")) {

					p.sendMessage(color("               &c&lList of available items"));
					p.sendMessage(color("&cRaiding & Base blocks: &fc4, wallt1, wallt2, wallt3, doort1, doort2, chest"));
					p.sendMessage(color("&cTools: &fupgradetool, pickt1, pickt2, pickt3, axet1, axet2, axet3"));
					p.sendMessage(color("&cResources: &fwood, stone, iron, fuel, sulfur, cookedsulfur"));
					p.sendMessage(color("&cArmour sets: &farmourt1, armourt2, armourt3"));

				}


			} else

				//ARGS length 2 commands


				if (args.length == 2) {

			if (args[0].equalsIgnoreCase("create")) {

				String clanName = args[1];
				Player owner = p;
				Location home = p.getLocation();

				//ADD check if player is already in a clan //DONE
				//ADD check if clan with that name exists //DONE
				
				try {
					if (!LocalData.getClanName(owner).equals("player_not_in_clan"))
					{
						owner.sendMessage("§cYou are already in a Clan!");
						return false;
					}
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}

				if (LocalData.existsClan(clanName))
				{
					owner.sendMessage("§cThis Clanname is already given!");
					return false;
				}

				if (args[1].length() < 12 && args[1].length() > 3) {

					try {
						LocalData.init_clan(clanName, owner, home);
						p.sendMessage(color("&cClan &f&l" + clanName + "&c was created successfully!"));
						p.sendMessage(color("&cClan home has been set at your location!"));
						LocalData.giveCoreBlock(p, clanName);
						p.sendMessage(color("&cPlace your core block to claim a chunk!"));
					} catch (IOException e) {
						e.printStackTrace();
					}

				} else {


					p.sendMessage(color("&cERROR: Clan name must be between 3 and 12 characters"));

				}


			} else if (args[0].equalsIgnoreCase("disband")) {

				//Need check to see if player is in a clan
				p.sendMessage("Not implemented");

			} else if (args[0].equalsIgnoreCase("sethome")) {

				//Need check to see if player is in a clan
				p.sendMessage("Not implemented");

			} else if (args[0].equalsIgnoreCase("home")) {

				//Need check to see if player is in a clan
				p.sendMessage("Not implemented");

			} else if (args[0].equalsIgnoreCase("menu")) {

				//Need check to see if player is in a clan
				p.sendMessage("Not implemented");

			} else if (args[0].equalsIgnoreCase("top")) {

				try {
					p.sendMessage(LocalData.getTopClans().toString());
				} catch (IOException e) {
					e.printStackTrace();
				}

			} else if (args[0].equalsIgnoreCase("give")) {

				if (args[1].equalsIgnoreCase("c4")) {

					ais.giveCustomItem(p, ais.getExplosive(4));
					p.sendMessage(ais.getCraftTime(ais.getTierOneBoots(), 2).toString());


				} else if (args[1].equalsIgnoreCase("wallt1")) {

					ais.giveCustomItem(p, ais.getTier1Wall(64));

				} else if (args[1].equalsIgnoreCase("wallt2")) {

					ais.giveCustomItem(p, ais.getTier2Wall(64));

				} else if (args[1].equalsIgnoreCase("wallt3")) {

					ais.giveCustomItem(p, ais.getTier3Wall(64));

				} else if (args[1].equalsIgnoreCase("doort1")) {

					ais.giveCustomItem(p, ais.getDoorT1());

				} else if (args[1].equalsIgnoreCase("doort2")) {

					ais.giveCustomItem(p, ais.getDoorT2());

				} else if (args[1].equalsIgnoreCase("chest")) {

					ais.giveCustomItem(p, ais.getChest(4));

				} else if (args[1].equalsIgnoreCase("upgradetool")) {

					ais.giveCustomItem(p, ais.getUpgradeTool());

				} else if (args[1].equalsIgnoreCase("pickt1")) {

					ais.giveCustomItem(p, ais.getTier1PickAxe());

				} else if (args[1].equalsIgnoreCase("pickt2")) {

					ais.giveCustomItem(p, ais.getTier2PickAxe());

				} else if (args[1].equalsIgnoreCase("pickt3")) {

					ais.giveCustomItem(p, ais.getTier3PickAxe());

				} else if (args[1].equalsIgnoreCase("axet1")) {

					ais.giveCustomItem(p, ais.getTier1Axe());

				} else if (args[1].equalsIgnoreCase("axet2")) {

					ais.giveCustomItem(p, ais.getTier2Axe());

				} else if (args[1].equalsIgnoreCase("axet3")) {

					ais.giveCustomItem(p, ais.getTier3Axe());

				} else if (args[1].equalsIgnoreCase("wood")) {

					ais.giveCustomItem(p, ais.getWood(64));

				} else if (args[1].equalsIgnoreCase("stone")) {

					ais.giveCustomItem(p, ais.getStone(64));

				} else if (args[1].equalsIgnoreCase("iron")) {

					ais.giveCustomItem(p, ais.getIron(64));

				} else if (args[1].equalsIgnoreCase("fuel")) {

					ais.giveCustomItem(p, ais.getFuel(64));

				} else if (args[1].equalsIgnoreCase("sulfur")) {

					ais.giveCustomItem(p, ais.getSulfur(64));

				} else if (args[1].equalsIgnoreCase("cookedsulfur")) {

					ais.giveCustomItem(p, ais.getCookedSulfur(64));

				} else if (args[1].equalsIgnoreCase("armourt1")) {

					ais.giveCustomItem(p, ais.getTierOneHelmet());
					ais.giveCustomItem(p, ais.getTierOneChestplate());
					ais.giveCustomItem(p, ais.getTierOneLeggings());
					ais.giveCustomItem(p, ais.getTierOneBoots());

				} else if (args[1].equalsIgnoreCase("armourt2")) {

					ais.giveCustomItem(p, ais.getTierTwoHelmet());
					ais.giveCustomItem(p, ais.getTierTwoChestplate());
					ais.giveCustomItem(p, ais.getTierTwoLeggings());
					ais.giveCustomItem(p, ais.getTierTwoBoots());

				} else if (args[1].equalsIgnoreCase("armourt3")) {

					ais.giveCustomItem(p, ais.getTierThreeHelmet());
					ais.giveCustomItem(p, ais.getTierThreeChestplate());
					ais.giveCustomItem(p, ais.getTierThreeLeggings());
					ais.giveCustomItem(p, ais.getTierThreeBoots());

				}

			}


		}


		return false;
	}
}
