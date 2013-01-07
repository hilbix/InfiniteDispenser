package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.herpingdo.infinitedispenser.Utils;

public class OnBlockBreak implements Listener {
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event)
	{
		if (!Utils.isInfiniteDispenser(event.getBlock())) return;
		Player p = event.getPlayer();
		if (!(event.getBlock().getType().equals(Material.DISPENSER))) return;
		if (p.hasPermission("infinitedispenser.break") || p.isOp()) return;
		event.setCancelled(true);
		p.sendMessage(ChatColor.RED+"[InfiniteDispenser] You may not break infinite dispensers!");
		if (p.getHealth() > 1) p.setHealth(p.getHealth() - 1);
	}
}
