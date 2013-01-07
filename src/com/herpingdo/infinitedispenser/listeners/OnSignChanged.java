package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class OnSignChanged implements Listener {
	/* Called when we update a sign, or place it. */
	@EventHandler
	public void onSignChanged(SignChangeEvent event)
	{
		if (!(event.getBlock() instanceof Sign)) return;
		Sign sign = (Sign) event.getBlock();
		String[] signLines = sign.getLines();
		if (signLines[0].equalsIgnoreCase("[Infinite]"))
		{
			/* This might give the user some indication that it worked. */
			sign.setLine(0, ChatColor.RED+"=[Infinite]=");
		}
	}

}
