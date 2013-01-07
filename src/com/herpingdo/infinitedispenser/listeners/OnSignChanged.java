package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.herpingdo.infinitedispenser.Utils;

public class OnSignChanged implements Listener {
	/* Called when we update a sign, or place it. */
	@EventHandler
	public void onSignChanged(SignChangeEvent event)
	{
		if (!Utils.isDispenserAdjacent(event.getBlock())) return;
		Player p = event.getPlayer();
		if (event.getLine(0).toLowerCase().contains("[infinite]"))
		{
			if (!p.hasPermission("infinitedispenser.create") && !p.isOp())
			{
				p.sendMessage(ChatColor.RED+"[InfiniteDispenser] You may not make infinite dispensers!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 2, 5));
				event.setCancelled(true);
				return;
			}
			/* TODO: Check if it's actually next to a dispenser. */
			event.getPlayer().sendMessage(ChatColor.GREEN+"[InfiniteDispenser]"+ChatColor.YELLOW+" You just created an infinite dispenser!");
		}
	}

}
