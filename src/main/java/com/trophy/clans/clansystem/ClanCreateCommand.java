package com.trophy.clans.clansystem;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.trophy.clans.database.Data;

public class ClanCreateCommand implements CommandExecutor {

	private String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		Player p = (Player) sender;
		
		if(args.length == 2)
		{
			String clanname = args[1];
			if(Data.existsClan(clanname))
			{
				p.sendMessage("§cThis Clanname already exists! Please choose another Name!");
			}
			else
			{
				return false;
				//Data.init_clan(clanname, p, coreblockloc, homeloc);
			}
		}
		else
		{
			return false;
		}

		ItemStack CoreBlock = new ItemStack(Material.BEACON);
		ItemMeta CoreBlockMeta = CoreBlock.getItemMeta();
		CoreBlockMeta.setDisplayName(color("&c&lCore Block"));
		CoreBlock.setItemMeta(CoreBlockMeta);

		p.sendMessage("Gave core block");
		p.getInventory().addItem(CoreBlock);

		return false;
	}
}
