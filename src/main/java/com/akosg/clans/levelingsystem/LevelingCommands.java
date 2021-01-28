package com.akosg.clans.levelingsystem;

import com.akosg.clans.database.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelingCommands implements CommandExecutor {

	public LevelGUI gui = new LevelGUI();

	@Override
	public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

		final Player player = (Player) sender;

		// /clan

		if (args.length == 0) {

			// level command

			gui.openLevel(player);


		} else

			//ARGS length 2 commands

			if (args.length == 1) {

				if (player.isOp()) {

					if (args[0].equalsIgnoreCase("set")) {

						player.sendMessage("level set [var] [value] [target]");


					}
				} else {

					player.sendMessage("no perm");

				}
			} else if (args.length == 4) {

				if (args[0].equalsIgnoreCase("set")) {

					if (args[1].equalsIgnoreCase("level")) {

						final int value = Integer.valueOf(args[2]);
						final Player target = Bukkit.getPlayer(args[3]);

						PlayerData.updateLevel(value, target.getUniqueId().toString());

					} else if (args[1].equalsIgnoreCase("xp")) {

						final int value = Integer.valueOf(args[2]);
						final Player target = Bukkit.getPlayer(args[3]);

						PlayerData.updateXP(value, target.getUniqueId().toString());

					} else if (args[1].equalsIgnoreCase("points")) {

						final int value = Integer.valueOf(args[2]);
						final Player target = Bukkit.getPlayer(args[3]);

						PlayerData.updatePoints(value, target.getUniqueId().toString());

					}

				}


			}

		return false;
	}

}
