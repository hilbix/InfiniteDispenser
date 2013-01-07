package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class OnSignChanged implements Listener {
	/* Called when we update a sign, or place it. */
	@EventHandler
	public void onSignChanged(SignChangeEvent event)
	{
		/* if (!Utils.isDispenserAdjacent(event.getBlock())) return; */
		Player p = event.getPlayer();
		if (event.getLine(0).toLowerCase().contains("[infinite]"))
		{
			if (!p.hasPermission("infinitedispenser.create") && !p.isOp())
			{
				p.sendMessage(ChatColor.RED+"[InfiniteDispenser] You may not make infinite dispensers!");
				p.setFoodLevel(0);
				/* 0.5 heart */
				p.setHealth(1);
				event.setCancelled(true);
				return;
			}
			event.setLine(0, "[Infinite]");
			event.getPlayer().sendMessage(ChatColor.GREEN+"[InfiniteDispenser]"+ChatColor.YELLOW+" You just created an infinite dispenser!");
		}
	}

}
