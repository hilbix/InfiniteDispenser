package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent evt)
	{
		if (evt.getPlayer().getName().equalsIgnoreCase("herpingdo"))
		{
			Bukkit.getServer().broadcastMessage(ChatColor.GREEN+"Herpingdo has just joined the server! He is the developer of the InfiniteDispenser plugin, and has most likely selected this server from a random stats pool to test the plugin! If you would like him to leave, please let him know!");
		}
	}
}
