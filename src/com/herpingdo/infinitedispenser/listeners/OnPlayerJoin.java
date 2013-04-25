package com.herpingdo.infinitedispenser.listeners;

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
			//if (!Utils.devCome())
			//{
				//Bukkit.getServer().broadcastMessage(
				//		ChatColor.GREEN +
				//		"[ID] "+ChatColor.RESET+
				//		"Herpingdo joined the game! He made InfiniteDispenser. This message will never show again."
				//);
				//Utils.setDevCome();
			//}
			evt.getPlayer().sendMessage("[InfiniteDispenser] This server is running InfiniteDispenser version "+Main.ver);
			
		}
		
		if (evt.getPlayer().isOp() && Main.update)
		{
			double ver = Utils.isUpdateAvailable();
			if (ver > 0)
			{
				evt.getPlayer().sendMessage(ChatColor.YELLOW+"There is an update available for InfiniteDispenser! (Your version: "+Main.ver+", Current version: "+ver+".) Download it at http://dev.bukkit.org/server-mods/infinitedispenser");
			}
		}
	}
}
