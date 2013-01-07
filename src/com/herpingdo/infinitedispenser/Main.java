package com.herpingdo.infinitedispenser;

import org.bukkit.plugin.java.JavaPlugin;

import com.herpingdo.infinitedispenser.listeners.OnSignChanged;

public class Main extends JavaPlugin {
	@Override
	public void onEnable()
	{
		/* Register some listeners... */
		getServer().getPluginManager().registerEvents(new OnSignChanged(), this);
	}

}
