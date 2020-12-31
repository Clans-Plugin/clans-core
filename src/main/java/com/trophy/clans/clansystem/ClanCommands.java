package com.trophy.clans.clansystem;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.trophy.clans.database.Data;

import java.io.IOException;

public class ClanCommands implements CommandExecutor {

	private String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}


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

		} else if (args.length == 1) {


			//ARGS 1 commands


		} else if (args.length == 2) {

			if (args[0].equalsIgnoreCase("create")) {

				String clanName = args[1];
				Player owner = p;
				Location home = p.getLocation();

				//ADD check if player is already in a clan
				//ADD check if clan with that name exists

				if (args[1].length() < 12 && args[1].length() > 3) {

					try {
						Data.init_clan(clanName, owner, home);
						p.sendMessage(color("&cClan &f&l" + clanName + "&c was created successfully!"));
						p.sendMessage(color("&cClan home has been set at your location!"));
						Data.giveCoreBlock(p, clanName);
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
					p.sendMessage(Data.getTopClans().toString());
				} catch (IOException e) {
					e.printStackTrace();
				}

			}


		}


		return false;
	}
}
