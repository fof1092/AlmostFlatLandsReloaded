package me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.Spigot;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class JSONMessageListener extends me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.JSONMessageListener {

	String AehnlmxYgZlDl = "92617405130464%%__USER__%%63617278665936219784035";
	
	public static void send(Player p, String jsonString) {
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tellraw " + p.getName() + " " + jsonString);
	}
}
