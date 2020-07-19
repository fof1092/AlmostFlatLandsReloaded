package de.fof1092.almostflatlandsreloaded;

import java.util.ArrayList;
import java.util.List;

import de.fof1092.almostflatlandsreloaded.commands.CommandHelp;
import de.fof1092.almostflatlandsreloaded.commands.CommandInfo;
import de.fof1092.almostflatlandsreloaded.commands.CommandReload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.TabCompleteListener;

/**
 * CommnandAlmostFlatLandsReloadedTabCompleter manages the tab completion of the AFLR commands.
 */
class CommnandAlmostFlatLandsReloadedTabCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender cs, Command cmd, String label, String[] args) {
		List<String> strings = new ArrayList<>();

		if (args.length == 1) {
			strings = TabCompleteListener.completeTab(cs, CommandListener.getMainCommand().replace("/", ""));

			return StringUtil.copyPartialMatches(args[0], strings, new ArrayList<>(strings.size()));
		} else if (args[0].equalsIgnoreCase("help")) {
			strings.addAll(CommandHelp.tabCompleter(cs, args));
		} else if (args[0].equalsIgnoreCase("info")) {
			strings.addAll(CommandInfo.tabCompleter(cs, args));
		} else if (args[0].equalsIgnoreCase("reload")) {
			strings.addAll(CommandReload.tabCompleter(cs, args));
		}

		return strings;
	}

}
