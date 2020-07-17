package de.fof1092.almostflatlandsreloaded;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.HelpPageListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.TabCompleteListener;

public class CommnandAlmostFlatLandsReloadedTabCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender cs, Command cmd, String label, String[] args) {
		if (args.length == 1) {
			List<String> strings = TabCompleteListener.completeTab(cs, CommandListener.getMainCommand().replace("/", ""));
			
			return StringUtil.copyPartialMatches(args[0], strings, new ArrayList<String>(strings.size()));
		} else if (args[0].equalsIgnoreCase("help")) {
			if (args.length == 2) {
				if (cs instanceof Player) {
					Player p = (Player)cs;
					
					List<String> strings = new ArrayList<String>();
					
					for (int i = 0; i < HelpPageListener.getMaxPlayerPages(p); i++) {
						strings.add((i + 1) + "");
					}
					
					return strings;
				}
			}
		}
		
		return new ArrayList<String>();
	}

}
