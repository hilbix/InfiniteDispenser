package com.herpingdo.infinitedispenser.statistics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

import com.herpingdo.infinitedispenser.Main;

public class UIDGenerator {
	
	@SuppressWarnings("resource")
	public static String getUID() throws Exception
	{
		File ufile = new File(Main.dfolder, "uid.dat");
		if (!ufile.exists())
		{
			String s = genUID();
			BufferedWriter br = new BufferedWriter(new FileWriter(ufile));
			br.write(s);
			br.newLine();
			br.flush();
			br.close();
		}
		return (new BufferedReader(new FileReader(ufile))).readLine();
	}
	
	public static String genUID()
	{
		return UUID.randomUUID().toString();
	}
}
