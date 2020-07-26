package de.fof1092.almostflatlandsreloaded.commands;

import de.fof1092.almostflatlandsreloaded.Options;
import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.JSONMessage;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.JSONMessageListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.UpdateListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * CommandInfo is managing the AFLR Info command.
 */
public class CommandInfo {

	/**
	 * CommandInfo has a private constructor, because it is a utility class.
	 */
	private CommandInfo() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Provides the logic for the AFLR Info command.
	 *
	 * @param cs the sender of the command
	 * @param args the arguments of the command
	 */
	public static void command(CommandSender cs, String[] args) {
		if (args.length != 1) {
			String replaceCommand = Options.msg.get("msg.6");
			replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR info").getColoredCommand());
			cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand);
		} else {
			cs.sendMessage("§a§m-----------§2 [§aAlmostFlatLandsReloaded§2] §a§m-----------");
			cs.sendMessage("");

			if (cs instanceof Player) {
				Player p = (Player) cs;

				List<JSONMessage> jsonFoFMessages = new ArrayList<>();

				JSONMessage fofText = new JSONMessage("§aBy: ");
				JSONMessage fofLink = new JSONMessage("§2F_o_F_1092");
				fofLink.setHoverText("§a[§2Open my Website§a]");
				fofLink.setOpenURL("https://fof1092.de");

				jsonFoFMessages.add(fofText);
				jsonFoFMessages.add(fofLink);

				JSONMessageListener.send(p, JSONMessageListener.putJSONMessagesTogether(jsonFoFMessages));

				cs.sendMessage("");

				List<JSONMessage> jsonTwitterMessages = new ArrayList<>();

				JSONMessage twitterText = new JSONMessage("§aTwitter: ");
				JSONMessage twitterLink = new JSONMessage("§2@F_o_F_1092");
				twitterLink.setHoverText("§a[§2Open Twitter§a]");
				twitterLink.setOpenURL("https://twitter.com/F_o_F_1092");

				jsonTwitterMessages.add(twitterText);
				jsonTwitterMessages.add(twitterLink);

				JSONMessageListener.send(p, JSONMessageListener.putJSONMessagesTogether(jsonTwitterMessages));

				cs.sendMessage("");
				cs.sendMessage("§aVersion: §2" + UpdateListener.getUpdateStringVersion());

				List<JSONMessage> jsonOptionsPageMessages = new ArrayList<>();

				JSONMessage optionsWebsiteText = new JSONMessage("§aHelpPagePlus: ");
				JSONMessage optionsWebsiteLink = new JSONMessage("§2https://fof1092.de/Plugins/AFLR");
				optionsWebsiteLink.setHoverText("§a[§2Open the Options Page§a]");
				optionsWebsiteLink.setOpenURL("https://fof1092.de/Plugins/AFLR");

				jsonOptionsPageMessages.add(optionsWebsiteText);
				jsonOptionsPageMessages.add(optionsWebsiteLink);

				JSONMessageListener.send(p, JSONMessageListener.putJSONMessagesTogether(jsonOptionsPageMessages));

			} else {
				cs.sendMessage("§aBy: §2F_o_F_1092");
				cs.sendMessage("");
				cs.sendMessage("§aTwitter: §2@F_o_F_1092");
				cs.sendMessage("");
				cs.sendMessage("§aVersion: §2" + UpdateListener.getUpdateStringVersion());
				cs.sendMessage("§aHelpPagePlus: §2https://fof1092.de/Plugins/AFLR");
			}

			cs.sendMessage("");
			cs.sendMessage("§a§m-----------§2 [§aAlmostFlatLandsReloaded§2] §a§m-----------");
		}
	}

	/**
	 * Provides the tab completions for the AFLR Info command.
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
