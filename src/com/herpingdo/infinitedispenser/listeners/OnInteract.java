package com.herpingdo.infinitedispenser.listeners;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.herpingdo.infinitedispenser.Utils;

public class OnInteract implements Listener {
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		if (!Utils.isInfiniteDispenser(event.getClickedBlock())) return;
		if (!(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
		Block b = event.getClickedBlock();
		int inf = Utils.getInfinitable(b);
		if (inf == 0) return;
		Player p = event.getPlayer();
		if (p.hasPermission("infinitedispenser.open") || p.isOp()) return;
		event.setCancelled(true);
		String type = (inf == 0 ? "dispenser" : "dropper");
		Utils.msgPlayer(p, "You are not permitted to open infinite "+type+"s!", true);
		if (p.getHealth() > 1) p.setHealth(p.getHealth() - 1);
	}
}
