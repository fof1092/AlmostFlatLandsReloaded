package de.fof1092.almostflatlandsreloaded.commands;

import de.fof1092.almostflatlandsreloaded.AlmostFlatlandsReloaded;
import de.fof1092.almostflatlandsreloaded.Options;
import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * CommandReload is managing the AFLR Reload commands.
 */
public class CommandReload {

	/**
	 * CommandReload has a private constructor, because it is a utility class.
	 */
	private CommandReload() {
		throw new IllegalStateException("Utility class");
	}


	/**
	 * Provides the logic for the AFLR Reload command.
	 *
	 * @param cs the sender of the command
	 * @param args the arguments of the command
	 */
	public static void command(CommandSender cs, String[] args) {
		if (args.length != 1) {
			String replaceCommand = Options.msg.get("msg.6");
			replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR reload").getColoredCommand());
			cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand);
		} else {
			if (!cs.hasPermission("AlmostFlatLandsReloaded.Reload")) {
				cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + Options.msg.get("msg.2"));
			} else {
				cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + Options.msg.get("msg.4"));

				AlmostFlatlandsReloaded.disable();
				AlmostFlatlandsReloaded.setup();

				cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + Options.msg.get("msg.5"));
			}
		}
	}

	/**
	 * Provides the tab completions for the AFLR Reload command.
	 *
	 * @param cs the sender of the command
	 * @param args the arguments of the command
	 *
	 * @return a list of possible tab completions
	 */
	public static List<String> tabCompleter(CommandSender cs, String[] args) {
		return new ArrayList<>();
	}
	
}
