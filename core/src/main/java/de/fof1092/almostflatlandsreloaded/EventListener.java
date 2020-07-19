package de.fof1092.almostflatlandsreloaded;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.UpdateListener;

/**
 * EventListener is managing the events of the plugin.
 */
class EventListener implements Listener {

	/**
	 * Informs the players about a plugin update.
	 */
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		
		if (UpdateListener.isAnewUpdateAvailable()) {
			if (p.hasPermission("AlmostFlatLandsReloaded.UpdateMessage")) {
				p.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + Options.msg.get("msg.3"));
			}
		}
	}
}
