package com.herpingdo.infinitedispenser.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.herpingdo.infinitedispenser.Main;

public class CommandInfiniteDispenser implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		if (!arg0.isOp())
		{
			arg0.sendMessage(ChatColor.RED+"[ID] "+ChatColor.RESET+" Permission denied!");
		}
		arg0.sendMessage("InfiniteDispenser Version "+Main.ver+" is running on this server!");
		return false;
	}
	
}
