package de.fof1092.almostflatlandsreloaded.commands;

import de.fof1092.almostflatlandsreloaded.Options;
import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Math;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.HelpPageListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * CommandHelp is managing the AFLR help command.
 */
public class CommandHelp {

	/**
	 * CommandHelp has a private constructor, because it is a utility class.
	 */
	private CommandHelp() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Provides the logic for the AFLR help command.
	 *
	 * @param cs the sender of the command
	 * @param args the arguments of the command
	 */
	public static void command(CommandSender cs, String[] args) {
		if (!(args.length >= 1 && args.length <= 2)) {
			String replaceCommand = Options.msg.get("msg.6");
			replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR help (Page)").getColoredCommand());
			cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand);
		} else {
			if (!(cs instanceof Player)) {
				if (args.length != 1) {
					String replaceCommand = Options.msg.get("msg.6");
					replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR help (Page)").getColoredCommand());
					cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand);
				} else {
					HelpPageListener.sendNormalMessage(cs);
				}
			} else {
				Player p = (Player) cs;
				if (args.length == 1) {
					HelpPageListener.sendMessage(p, 0);
				} else {
					if (!Math.isInt(args[1])) {
						String replaceCommand = Options.msg.get("msg.6");
						replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR help (Page)").getColoredCommand());
						cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand);
					} else {
						if (Integer.parseInt(args[1]) <= 0 || Integer.parseInt(args[1]) > HelpPageListener.getMaxPlayerPages(p)) {
							String replaceCommand = Options.msg.get("msg.6");
							replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR help (Page)").getColoredCommand());
							cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand);
						} else {
							HelpPageListener.sendMessage(p, Integer.parseInt(args[1]) - 1);
						}
					}
				}
			}
		}
	}

	/**
	 * Provides the tab completions for the AFLR help command.
	 *
	 * @param cs the sender of the command
	 * @param args the arguments of the command
	 *
	 * @return a list of possible tab completions
	 */
	public static List<String> tabCompleter(CommandSender cs, String[] args) {
		if (args.length == 2) {
			if (args[0].equalsIgnoreCase("help")) {
				if (cs instanceof Player) {
					Player p = (Player)cs;
					
					List<String> strings = new ArrayList<>();
					
					for (int i = 0; i < HelpPageListener.getMaxPlayerPages(p); i++) {
						strings.add((i + 1) + "");
					}
					
					return strings;
				}
			}
		}
		
		return new ArrayList<>();
	}

}
