package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.herpingdo.infinitedispenser.Utils;

public class OnBlockBreak implements Listener {
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		Block b = event.getBlock();
		Player p = event.getPlayer();
		//if (!Utils.isInfiniteDispenser(event.getBlock())) return;
		if (Utils.isInfiniteDispenser(b) && !(p.hasPermission("infinitedispenser.break") || p.isOp())) //They tried to break an infinite dispenser
		{
			event.setCancelled(true);
			p.sendMessage(ChatColor.RED+"[InfiniteDispenser] You may not break infinite dispensers!");
			if (p.getHealth() > 1) p.setHealth(p.getHealth() - 1);
		}
		
		else if (Utils.isInfiniteSign(b) && !(p.hasPermission("infinitedispenser.break") || p.isOp()))
		{
			event.setCancelled(true);
			Utils.msgPlayer(p, "You may not break infinite dispenser signs!", true);
			if (p.getHealth() > 1) p.setHealth(p.getHealth() - 1);
		}
		
	}
}
