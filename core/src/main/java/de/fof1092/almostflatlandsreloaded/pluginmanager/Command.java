package de.fof1092.almostflatlandsreloaded.pluginmanager;

import de.fof1092.almostflatlandsreloaded.Options;

public class Command {
	
	String permission;
	String commandString;
	String commandColloredString;
	HelpMessage helpMessage;

	public Command(String commandString, String permission, String helpMessage) {
		this.commandString = commandString;
		
		this.commandColloredString = Options.msg.get("color.1") + this.commandString.replace("[", Options.msg.get("color.1") + "[" + Options.msg.get("color.2")).replace("(", Options.msg.get("color.1") + "(" + Options.msg.get("color.2")).replace("]", Options.msg.get("color.1") + "]" + Options.msg.get("color.2")).replace(")", Options.msg.get("color.1") + ")" + Options.msg.get("color.2")).replace("|", Options.msg.get("color.1") + "|" + Options.msg.get("color.2"));
		
		this.permission = permission;
		
		this.helpMessage = new HelpMessage(this.commandString, this.commandColloredString, helpMessage);
	}
	
	public String getColoredCommand() {
		return this.commandColloredString;
	}
	
	public String getCommandString() {
		return this.commandString;
	}

	public String getPermission() {
		return this.permission;
	}

	public HelpMessage getHelpMessage() {
		return this.helpMessage;
	}
}
