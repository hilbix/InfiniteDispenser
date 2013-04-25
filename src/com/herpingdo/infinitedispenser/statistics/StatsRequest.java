package com.herpingdo.infinitedispenser.statistics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;

public class StatsRequest {
	private String header;
	private HashMap<String, String> stuff = new HashMap<String, String>();
	
	public StatsRequest(String header)
	{
		this.header = header;
	}
	
	@SuppressWarnings("deprecation")
	public void send(final String url)
	{
		final String str = this.getString();
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				String stat = url.replace("%stat%",URLEncoder.encode(str));
				try
				{
					new BufferedReader(new InputStreamReader(new URL(stat).openConnection().getInputStream())).readLine();
				} catch (Exception e) { }
			}
		}).start();
		
	}
	
	/**
	 * Stat-Stuff¤version 5.0 and stuffz¦Stat-Things¤9 Starts
	 */
	private String getString()
	{
		String str = header + " ";
		for (Entry<String, String> e : stuff.entrySet())
		{
			str += e.getKey();
			str += "¤";
			str += e.getValue();
			str += "¦";
		}
		return sanitize(str);
	}
	
	private String sanitize(String s)
	{
		return s.replace(" ", "-");
	}
	
	public void put(String s, String s2)
	{
		this.stuff.put(s, s2);
	}
}
