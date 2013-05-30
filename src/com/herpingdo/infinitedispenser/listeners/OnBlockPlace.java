package com.herpingdo.infinitedispenser.listeners;

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
		int inf = Utils.getInfinitable(placed);
		if (inf > 0)
		{
			Player play = event.getPlayer();
			if (Utils.getAdjacentSign(placed, "[Infinite]", 0) != null)
			{
				if (!play.hasPermission("infinitedispenser.create") && !play.isOp())
				{
					Utils.msgPlayer(play, "You may not create infinite dispensers!", true);
					play.setFoodLevel(0);
					play.setHealth(1);
					event.setCancelled(true);
					return;
				}
				String type = (inf == 1 ? "dispenser" : "dropper");
				Utils.msgPlayer(play, "You just created an infinite "+type+" the hard way!", false);
			}
		}
	}
}
