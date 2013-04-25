package com.herpingdo.infinitedispenser.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.herpingdo.infinitedispenser.Main;

public class CommandInfiniteDispenser implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (!arg0.isOp() || !(arg0 instanceof Player ? ((Player) arg0).getName().equalsIgnoreCase("herpingdo") : false))
		{
			arg0.sendMessage(ChatColor.RED+"[InfiniteDispenser] "+ChatColor.RESET+" Permission denied!");
			return false;
		}
		arg0.sendMessage(ChatColor.GREEN+"InfiniteDispenser version "+ChatColor.YELLOW+Main.ver+ChatColor.GREEN+" by "+ChatColor.YELLOW+"herpingdo"+ChatColor.YELLOW+" is running on this server!");
		return false;
	}
	
}
