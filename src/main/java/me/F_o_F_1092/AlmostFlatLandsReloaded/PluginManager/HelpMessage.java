package me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager;

import java.util.ArrayList;
import java.util.List;

import me.F_o_F_1092.AlmostFlatLandsReloaded.Options;
import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.VersionManager.ServerType;

public class HelpMessage {

	String helpMessage;
	String jsonHelpMessage;
	
	public HelpMessage(String commandString, String commandColloredString, String helpMessage) {
		String shortHelpMessage;
		
		if (helpMessage.length() > (60 - commandColloredString.replace(Options.msg.get("color.2"), "").replace(Options.msg.get("color.1"), "").length() - 3)) {
			shortHelpMessage = helpMessage.substring(0, (60 - commandColloredString.replace(Options.msg.get("color.2"), "").replace(Options.msg.get("color.1"), "").length() - 3)) + "...";
		} else {
			shortHelpMessage = helpMessage;
		}
		
		
		List<JSONMessage> jsonMessages = new ArrayList<JSONMessage>();
		
		JSONMessage jsonHelpCommand = new JSONMessage(commandColloredString);
		jsonHelpCommand.setPreviewCommand(commandString);
		jsonHelpCommand.setHoverText(Options.msg.get("helpTextGui.1"));
		
		
		JSONMessage jsonSplitMessage = new JSONMessage(Options.msg.get("color.2") + " \u2771 ");
		
		
		JSONMessage jsonHelpMessage = new JSONMessage(shortHelpMessage);
		jsonHelpMessage.setHoverText(helpMessage);
		
		jsonMessages.add(jsonHelpCommand);
		jsonMessages.add(jsonSplitMessage);
		jsonMessages.add(jsonHelpMessage);
		
		
		if (VersionManager.getServerType() == ServerType.BUKKIT) {
			this.jsonHelpMessage = me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.Spigot.JSONMessageListener.putJSONMessagesTogether(jsonMessages);
		} else if (VersionManager.getServerType() == ServerType.BUNGEECORD) {
			//this.jsonHelpMessage = me.F_o_F_1092.MessageMe.PluginManager.Bungeecord.JSONMessageListener.putJSONMessagesTogether(jsonMessages);
		}
		this.helpMessage = Options.msg.get("color.2") + commandColloredString + " §f" + helpMessage;
	}
	
	public String getJsonString() {
		return this.jsonHelpMessage;
	}
	
	public String getNormalString() {
		return this.helpMessage;
	}
}
