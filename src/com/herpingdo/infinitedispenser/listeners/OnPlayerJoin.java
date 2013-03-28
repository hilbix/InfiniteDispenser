package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.herpingdo.infinitedispenser.Main;
import com.herpingdo.infinitedispenser.Utils;

public class OnPlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent evt)
	{
		if (evt.getPlayer().getName().equalsIgnoreCase("herpingdo"))
		{
			if (!Utils.hasHerpingdoCome())
			{
				Bukkit.getServer().broadcastMessage(
						ChatColor.GREEN +
						"[ID] "+ChatColor.RESET+
						"Herpingdo joined the game! He made InfiniteDispenser. This message will not show again."
				);
				Utils.setHerpingdoHasCome();
			}
			
		}
		
		if (evt.getPlayer().isOp())
		{
			double ver = Utils.isUpdateAvailable();
			if (ver > 0)
			{
				evt.getPlayer().sendMessage(ChatColor.YELLOW+"There is an update available for InfiniteDispenser! (Your version: "+Main.ver+", Current version: "+ver+".) Download it at http://dev.bukkit.org/server-mods/infinitedispenser");
			}
		}
	}
}
