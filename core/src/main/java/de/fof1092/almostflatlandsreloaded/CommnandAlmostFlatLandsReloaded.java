package de.fof1092.almostflatlandsreloaded;

import de.fof1092.almostflatlandsreloaded.commands.CommandHelp;
import de.fof1092.almostflatlandsreloaded.commands.CommandInfo;
import de.fof1092.almostflatlandsreloaded.commands.CommandReload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;

/**
 * CommnandAlmostFlatLandsReloaded is managing the AFLR commands.
 */
class CommnandAlmostFlatLandsReloaded implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            String replaceCommand = Options.msg.get("msg.6");
            replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR help (Page)").getColoredCommand());
            cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand);
        } else if (args[0].equalsIgnoreCase("help")) {
            CommandHelp.command(cs, args);
        } else if (args[0].equalsIgnoreCase("info")) {
            CommandInfo.command(cs, args);
        } else if (args[0].equalsIgnoreCase("reload")) {
            CommandReload.command(cs, args);
        } else {
            String replaceCommand = Options.msg.get("msg.6");
            replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR help (Page)").getColoredCommand());
            cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand);
    	}
		return true;
	}

}
