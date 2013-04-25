package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.herpingdo.infinitedispenser.Utils;

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
				Utils.msgPlayer(p, "You may not create infinite dispenser/dropper signs!", true);
				p.setFoodLevel(0);
				/* 0.5 heart */
				p.setHealth(1);
				event.setCancelled(true);
				return;
			}
			event.setLine(0, "[Infinite]");
			Utils.msgPlayer(p, "You just created an infinite dispenser/dropper sign!", false);
		}
	}

}
