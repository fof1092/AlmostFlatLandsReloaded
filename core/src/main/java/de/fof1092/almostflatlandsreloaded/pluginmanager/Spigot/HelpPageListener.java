package de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot;

import de.fof1092.almostflatlandsreloaded.Options;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Command;
import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.HelpMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class HelpPageListener extends de.fof1092.almostflatlandsreloaded.pluginmanager.HelpPageListener {

	public static void sendMessage(Player p, int page) {
		List<HelpMessage> personalHelpMessages = getAllPersonalHelpMessages(p);
		List<HelpMessage> personalHelpPageMessages = getHelpPageMessages(p, personalHelpMessages, page);
		
		p.sendMessage("");
		JSONMessageListener.send(p, getNavBar(personalHelpMessages, personalHelpPageMessages, page));
		p.sendMessage("");
		for (HelpMessage hm : personalHelpPageMessages) {
			JSONMessageListener.send(p, hm.getJsonString());
		}
		p.sendMessage("");
		
		if (getMaxPlayerPages(personalHelpMessages) != 1) {
			p.sendMessage(Options.msg.get("helpTextGui.4").replace("[PAGE]", (page + 1) + ""));
		}
		
		JSONMessageListener.send(p, getNavBar(personalHelpMessages, personalHelpPageMessages, page));
		p.sendMessage("");
	}

	public static void sendNormalMessage(CommandSender cs) {
		cs.sendMessage(Options.msg.get("color.1") + "§m------------§r " + pluginNametag + Options.msg.get("color.1") + "§m------------");
		cs.sendMessage("");
		for (Command command : CommandListener.getAllCommands()) {
			cs.sendMessage(command.getHelpMessage().getNormalString());
		}
		cs.sendMessage("");
		cs.sendMessage(Options.msg.get("color.1") + "§m------------§r " + pluginNametag + Options.msg.get("color.1") + "§m------------");
	}
	
	private static List<HelpMessage> getHelpPageMessages(Player p, List<HelpMessage> personalHelpMessages, int page) {
		List<HelpMessage> personalHelpPageMessages = new ArrayList<>();
		
		for (int i = 0; i < maxHelpMessages; i++) {
			if (personalHelpMessages.size() >= (page * maxHelpMessages + i + 1)) {
				personalHelpPageMessages.add(personalHelpMessages.get(page * maxHelpMessages + i));
			}
		}
		
		return personalHelpPageMessages;
	}

	public static int getMaxPlayerPages(Player p) {
		return (int) Math.ceil(((double)getAllPersonalHelpMessages(p).size() / (double)maxHelpMessages));
	}
	
	private static List<HelpMessage> getAllPersonalHelpMessages(Player p) {
		List<HelpMessage> personalHelpMessages = new ArrayList<HelpMessage>();
		
		for (Command command : CommandListener.getAllCommands()) {
			if (command.getPermission()== null || p.hasPermission(command.getPermission())) {
				personalHelpMessages.add(command.getHelpMessage());
			}
		}
		
		return personalHelpMessages;
	}
	
}