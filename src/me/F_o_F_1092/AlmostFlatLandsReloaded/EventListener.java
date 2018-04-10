package me.F_o_F_1092.AlmostFlatLandsReloaded;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.ChunkPopulateEvent;

import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.Spigot.UpdateListener;

public class EventListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		
		//es fehlt was...
		if (UpdateListener.isAnewUpdateAvailable()) {
			if (p.hasPermission("MysteriousHalloween.UpdateMessage")) {
				p.sendMessage(Options.msg.get("[MysteriousHalloweenPlus]") + Options.msg.get("msg.11"));
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onChunkPopulate(ChunkPopulateEvent e) {
		e.getChunk().getWorld().refreshChunk(e.getChunk().getX() + 1, e.getChunk().getZ() + 1);
		e.getChunk().getWorld().refreshChunk(e.getChunk().getX() + 0, e.getChunk().getZ() + 1);
		e.getChunk().getWorld().refreshChunk(e.getChunk().getX() - 1, e.getChunk().getZ() + 1);
		
		e.getChunk().getWorld().refreshChunk(e.getChunk().getX() + 1, e.getChunk().getZ() + 0);
		e.getChunk().getWorld().refreshChunk(e.getChunk().getX() - 1, e.getChunk().getZ() + 0 );
		
		e.getChunk().getWorld().refreshChunk(e.getChunk().getX() + 1, e.getChunk().getZ() - 1);
		e.getChunk().getWorld().refreshChunk(e.getChunk().getX() + 0, e.getChunk().getZ() - 1);
		e.getChunk().getWorld().refreshChunk(e.getChunk().getX() - 1, e.getChunk().getZ() - 1);
	}
	
}
