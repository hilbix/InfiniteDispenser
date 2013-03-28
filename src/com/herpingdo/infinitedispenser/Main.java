package com.herpingdo.infinitedispenser;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import com.herpingdo.infinitedispenser.commands.CommandInfiniteDispenser;
import com.herpingdo.infinitedispenser.listeners.OnBlockBreak;
import com.herpingdo.infinitedispenser.listeners.OnBlockPlace;
import com.herpingdo.infinitedispenser.listeners.OnDispense;
import com.herpingdo.infinitedispenser.listeners.OnInteract;
import com.herpingdo.infinitedispenser.listeners.OnPlayerJoin;
import com.herpingdo.infinitedispenser.listeners.OnSignChanged;

public class Main extends JavaPlugin {
	public static double ver = 2.0;
	public static File dfolder;
	
	@Override
	public void onEnable()
	{
		dfolder = getDataFolder();
		dfolder.mkdirs();
		/* Register some listeners... */
		getServer().getPluginManager().registerEvents(new OnSignChanged(), this);
		getServer().getPluginManager().registerEvents(new OnDispense(), this);
		getServer().getPluginManager().registerEvents(new OnBlockPlace(), this);
		getServer().getPluginManager().registerEvents(new OnBlockBreak(), this);
		getServer().getPluginManager().registerEvents(new OnInteract(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
		getCommand("infinitedispenser").setExecutor(new CommandInfiniteDispenser());
		Server serv = Bukkit.getServer();
		int totalStarts = Utils.getAndSetServerStarts();
		String startupStat = "[Server Start] Plugin-Version="+ver+", Server-Version="+serv.getVersion()+
				", Server-Port="+serv.getPort()+", Server-Max="+serv.getMaxPlayers()+
				", Server-Total-Starts-With-Plugin="+totalStarts+", Current-Time="+System.currentTimeMillis();
		Utils.sendStatsRequest(startupStat);
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
			System.out.println("[ID] Error starting metrics!");
		}
		
	}
	


}
