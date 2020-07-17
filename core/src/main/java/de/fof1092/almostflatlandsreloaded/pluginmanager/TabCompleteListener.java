package de.fof1092.almostflatlandsreloaded.pluginmanager;

public class TabCompleteListener {
	
	protected static String getNextArg(String startCommand, String command) {
		command = command.replace(startCommand, "").replace("/ ", "");
		String[] args = command.split(" ");
		
		return args[0];
	}

}
