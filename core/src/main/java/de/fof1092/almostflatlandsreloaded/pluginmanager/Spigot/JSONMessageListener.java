package de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class JSONMessageListener extends de.fof1092.almostflatlandsreloaded.pluginmanager.JSONMessageListener {

	public static void send(Player p, String jsonString) {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tellraw " + p.getName() + " " + jsonString);
	}

}
