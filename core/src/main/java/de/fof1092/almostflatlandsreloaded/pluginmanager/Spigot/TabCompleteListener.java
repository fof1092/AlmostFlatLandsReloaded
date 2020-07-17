package de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot;

import de.fof1092.almostflatlandsreloaded.pluginmanager.Command;
import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteListener extends de.fof1092.almostflatlandsreloaded.pluginmanager.TabCompleteListener {

	public static List<String> completeTab(CommandSender cs, String startCommand) {

		List<String> strings = new ArrayList<String>();
		
		for (Command command : CommandListener.getAllCommands()) {
			if (!command.getCommandString().equals(CommandListener.getMainCommand())) {
				if (command.getPermission() == null || cs.hasPermission(command.getPermission())) {
					strings.add(getNextArg(startCommand, command.getCommandString()));
				}
			}
		}
		
		return strings;
	}
	
}
