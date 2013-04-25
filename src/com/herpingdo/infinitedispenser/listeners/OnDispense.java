package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Dispenser;
import org.bukkit.block.Dropper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.herpingdo.infinitedispenser.Utils;

public class OnDispense implements Listener {
	@EventHandler
	public void onDispense(BlockDispenseEvent event)
	{
		Block block = event.getBlock();
		Block b = Utils.getAdjacentSign(block, "[Infinite]", 0);
		ItemStack justDispensed = event.getItem();
		if (b != null)
		{
			BlockState theState = block.getState();
			if (theState instanceof Dispenser)
			{
				Inventory dispenserInv = ((Dispenser)block.getState()).getInventory();
				if (!dispenserInv.contains(justDispensed.getType())) dispenserInv.clear();
				justDispensed.setAmount(64);
				dispenserInv.addItem(justDispensed);
			}
			else if (theState instanceof Dropper)
			{
				Inventory dispenserInv = ((Dropper)block.getState()).getInventory();
				if (!dispenserInv.contains(justDispensed.getType())) dispenserInv.clear();
				justDispensed.setAmount(64);
				dispenserInv.addItem(justDispensed);
			}
			
		}
		//org.bukkit.event.block.
	}
}
