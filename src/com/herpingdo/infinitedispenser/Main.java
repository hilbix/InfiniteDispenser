package com.herpingdo.infinitedispenser;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.herpingdo.infinitedispenser.commands.CommandInfiniteDispenser;
import com.herpingdo.infinitedispenser.listeners.OnBlockBreak;
import com.herpingdo.infinitedispenser.listeners.OnBlockPlace;
import com.herpingdo.infinitedispenser.listeners.OnDispense;
import com.herpingdo.infinitedispenser.listeners.OnInteract;
import com.herpingdo.infinitedispenser.listeners.OnPlayerJoin;
import com.herpingdo.infinitedispenser.listeners.OnSignChanged;
import com.herpingdo.infinitedispenser.statistics.StatsRequest;
import com.herpingdo.infinitedispenser.statistics.UIDGenerator;

public class Main extends JavaPlugin {
	public static double ver = 2.1;
	public static File dfolder;
	public static boolean update = true;
	
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
		StatsRequest s = new StatsRequest("start");
		s.put("Plugin Version", ver+"");
		s.put("Bukkit Version", serv.getBukkitVersion());
		s.put("Full Version", serv.getVersion());
		s.put("Server Port", serv.getPort()+"");
		s.put("Online Mode", serv.getOnlineMode()+"");
		try { s.put("Unique ID", UIDGenerator.getUID()); } catch (Exception e1) { }
		s.put("Time", System.currentTimeMillis()+"");

		s.send("http://dashie.in/s.php?stat=%stat%");
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
			System.out.println("[ID] Error starting metrics!");
		}
		this.saveDefaultConfig();
		FileConfiguration cf = this.getConfig();
		update = cf.getBoolean("update-checking");
	}
	


}
