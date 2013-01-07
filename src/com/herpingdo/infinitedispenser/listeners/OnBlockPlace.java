package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.herpingdo.infinitedispenser.Utils;

public class OnBlockPlace implements Listener {
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event)
	{
		Block placed = event.getBlockPlaced();
		if (placed.getType().equals(Material.DISPENSER))
		{
			Player play = event.getPlayer();
			if (Utils.getAdjacentSign(placed, "[Infinite]", 0) != null)
			{
				if (!play.hasPermission("infinitedispenser.create") && !play.isOp())
				{
					play.sendMessage(ChatColor.RED+"[InfiniteDispenser] You may not create infinite dispensers!");
					play.setFoodLevel(0);
					play.setHealth(1);
					event.setCancelled(true);
					return;
				}
				event.getPlayer().sendMessage(ChatColor.GREEN+"[InfiniteDispenser]"+ChatColor.YELLOW+" You just created an infinite dispenser the hard way!");
			}
		}
	}
}
