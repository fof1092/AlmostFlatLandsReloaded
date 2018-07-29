package me.F_o_F_1092.AlmostFlatLandsReloaded;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.Spigot.UpdateListener;

public class EventListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		
		if (UpdateListener.isAnewUpdateAvailable()) {
			if (p.hasPermission("MysteriousHalloween.UpdateMessage")) {
				p.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + Options.msg.get("msg.3"));
			}
		}
	}
}
