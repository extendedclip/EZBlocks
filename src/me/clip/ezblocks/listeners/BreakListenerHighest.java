package me.clip.ezblocks.listeners;

import me.clip.ezblocks.EZBlocks;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListenerHighest implements Listener {
	
	private EZBlocks plugin;
	
	public BreakListenerHighest(EZBlocks i) {
		plugin = i;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onBreak(BlockBreakEvent e) {
		if (e.isCancelled()) {
			return;
		}
		if (plugin.getBreakHandler().check(e.getPlayer(), e.getBlock())) {
			plugin.getBreakHandler().handleBlockBreakEvent(e.getPlayer(), e.getBlock());
		}
	}
}
