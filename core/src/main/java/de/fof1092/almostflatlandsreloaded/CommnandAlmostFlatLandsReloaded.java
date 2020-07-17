package de.fof1092.almostflatlandsreloaded;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.JSONMessage;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.HelpPageListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.JSONMessageListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.UpdateListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Math;
import de.fof1092.almostflatlandsreloaded.pluginmanager.ServerLog;
import de.fof1092.almostflatlandsreloaded.pluginmanager.VersionManager;
import de.fof1092.almostflatlandsreloaded.pluginmanager.VersionManager.BukkitVersion;
import de.fof1092.almostflatlandsreloaded.pluginmanager.VersionManager.ServerType;

public class CommnandAlmostFlatLandsReloaded implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (VersionManager.getBukkitVersion() != BukkitVersion.v1_8_R3 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_9_R1 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_9_R2 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_10_R1 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_11_R1 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_12_R1 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_13_R1 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_13_R2 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_14_R1 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_15_R1 &&
				VersionManager.getBukkitVersion() != BukkitVersion.v1_16_R1) {
			ServerLog.err("This version of AlmostFlatLandsReloaded only supports MC 1.8.8 - 1.16 Servers.");
			ServerLog.err("You can find other versions here https://www.spigotmc.org/resources/55405/history");
			cs.sendMessage("This version of AlmostFlatLandsReloaded only supports MC 1.8.8 - 1.16 Servers.");
			cs.sendMessage("You can find other versions here https://www.spigotmc.org/resources/55405/history");
		} else {
			if (args.length == 0) {
				String replaceCommand = Options.msg.get("msg.6");
				replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR help (Page)").getColoredCommand());
				cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand); 
			} else if (args[0].equalsIgnoreCase("help")) {
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
						Player p = (Player)cs;
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
			} else if (args[0].equalsIgnoreCase("info")) {
				if (args.length != 1) {
					String replaceCommand = Options.msg.get("msg.6");
					replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR info").getColoredCommand());
					cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand); 
				} else {
					cs.sendMessage("§a§m-----------§2 [§aAlmostFlatLandsReloaded§2] §a§m-----------");
					cs.sendMessage("");
					
					if (cs instanceof Player) {
						Player p = (Player) cs;
						
						List<JSONMessage> jsonFoFMessages = new ArrayList<JSONMessage>();
						
						JSONMessage FoFText = new JSONMessage("§aBy: ");
						JSONMessage FoFLink = new JSONMessage("§2F_o_F_1092");
						FoFLink.setHoverText("§a[§2Open my Website§a]");
						FoFLink.setOpenURL("https://fof1092.de");
						
						jsonFoFMessages.add(FoFText);
						jsonFoFMessages.add(FoFLink);
						
						JSONMessageListener.send(p, JSONMessageListener.putJSONMessagesTogether(jsonFoFMessages));
						
						cs.sendMessage("");
						
						List<JSONMessage> jsonTwitterMessages = new ArrayList<JSONMessage>();
						
						JSONMessage twitterText = new JSONMessage("§aTwitter: ");
						JSONMessage twitterLink = new JSONMessage("§2@F_o_F_1092");
						twitterLink.setHoverText("§a[§2Open Twitter§a]");
						twitterLink.setOpenURL("https://twitter.com/F_o_F_1092");
						
						jsonTwitterMessages.add(twitterText);
						jsonTwitterMessages.add(twitterLink);
						
						JSONMessageListener.send(p, JSONMessageListener.putJSONMessagesTogether(jsonTwitterMessages));
					
						cs.sendMessage("");
						cs.sendMessage("§aVersion: §2" + UpdateListener.getUpdateStringVersion());
						
						List<JSONMessage> jsonOptionsPageMessages = new ArrayList<JSONMessage>();
						
						JSONMessage OptionsWebsiteText = new JSONMessage("§aHelpPagePlus: ");
						JSONMessage OptionsWebsiteLink = new JSONMessage("§2https://fof1092.de/Plugins/AFLR");
						OptionsWebsiteLink.setHoverText("§a[§2Open the Options Page§a]");
						OptionsWebsiteLink.setOpenURL("https://fof1092.de/Plugins/AFLR");
						
						jsonOptionsPageMessages.add(OptionsWebsiteText);
						jsonOptionsPageMessages.add(OptionsWebsiteLink);
						
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
			} else if (args[0].equalsIgnoreCase("reload")) {
				if (args.length != 1) {
					String replaceCommand = Options.msg.get("msg.6");
					replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR reload").getColoredCommand());
					cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand); 
				} else {
					if (!cs.hasPermission("HelpPagePlus.Reload")) {
						cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + Options.msg.get("msg.2"));
					} else {
						cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + Options.msg.get("msg.4"));
						
						CommandListener.clearCommands();
						Options.worldTreeTypes.clear();
						
						VersionManager.setVersionManager(Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3], ServerType.BUKKIT, false);
						
						
						File fileConfig = new File("plugins/AlmostFlatLandsReloaded/Config.yml");
						FileConfiguration ymlFileConfig = YamlConfiguration.loadConfiguration(fileConfig);
						
						if (!fileConfig.exists()) {
							try {
								ymlFileConfig.set("Version", UpdateListener.getUpdateDoubleVersion());
								ymlFileConfig.set("GameVersion.SetOwn", false);
								ymlFileConfig.set("GameVersion.Version", "v1_12_R1");
								ymlFileConfig.set("ColoredConsoleText", true);
								ymlFileConfig.set("ShowUpdateMessage", true);
								
								ymlFileConfig.set("World.Hight", 32);
								ymlFileConfig.set("World.Biome", Biome.PLAINS.toString());
								ymlFileConfig.set("World.GrassChance", 14);
								ymlFileConfig.set("World.FlowerChance", 1);
								ymlFileConfig.set("World.TreeChance", 15);
								
								List<String> treeTypes = new ArrayList<String>();
								treeTypes.add(TreeType.TREE.toString());
								treeTypes.add(TreeType.BIRCH.toString());
								treeTypes.add(TreeType.BIG_TREE.toString());
								ymlFileConfig.set("World.TreeTypes", treeTypes);
								
								ymlFileConfig.save(fileConfig);
							} catch (IOException e) {
								ServerLog.err("Can't create the Config.yml. [" + e.getMessage() +"]");
							}
						}
						
						ServerLog.setUseColoredColores(ymlFileConfig.getBoolean("ColoredConsoleText"));
						UpdateListener.showUpdateMessage = ymlFileConfig.getBoolean("ShowUpdateMessage");
						
						if (!ymlFileConfig.getBoolean("GameVersion.SetOwn")) {
							ServerLog.log("ServerType:§2 " + VersionManager.getSetverTypeString() + "§a, Version:§2 " + VersionManager.getBukkitVersion());
						} else {
							VersionManager.setVersionManager(ymlFileConfig.getString("GameVersion.Version"), ServerType.BUKKIT, true);
							ServerLog.log("ServerType:§2 " + VersionManager.getSetverTypeString() + "§a, Version:§2 " + VersionManager.getBukkitVersion() + "§a | §2(Self configurated)");
						}
						
						
						Options.worldHight = ymlFileConfig.getInt("World.Hight");
						
						try {
							Options.worldBiome = Biome.valueOf(ymlFileConfig.getString("World.Biome"));
						} catch (Exception e) {
							Options.worldBiome = Biome.PLAINS;
							ServerLog.err("§2Invalid Biome name: " + ymlFileConfig.get("World.Biome") + " . [" + e.getMessage() +"]");
						}
						
						Options.worldGrassChance = ymlFileConfig.getInt("World.GrassChance");
						Options.worldFlowerChance = ymlFileConfig.getInt("World.FlowerChance");
						Options.worldTreeChance = ymlFileConfig.getInt("World.TreeChance");
						
						for (String treeTypeString : ymlFileConfig.getStringList("World.TreeTypes")) {
							try {
								Options.worldTreeTypes.add(TreeType.valueOf(treeTypeString));
							} catch (Exception e) {
								ServerLog.err("§2Invalid TreeType name: " + treeTypeString + " . [" + e.getMessage() +"]");
							}
						}
						
						
						File fileMessages = new File("plugins/AlmostFlatLandsReloaded/Messages.yml");
						FileConfiguration ymlFileMessage = YamlConfiguration.loadConfiguration(fileMessages);
						
						if(!fileMessages.exists()) {
							
							try {
								ymlFileMessage.save(fileMessages);
								ymlFileMessage.set("Version", UpdateListener.getUpdateDoubleVersion());
								ymlFileMessage.set("[AlmostFlatLandsReloaded]", "&2[&a&lAFLR&2] ");
								ymlFileMessage.set("Color.1", "&a");
								ymlFileMessage.set("Color.2", "&2");
								ymlFileMessage.set("Message.1", "You have to be a player, to use this command.");
								ymlFileMessage.set("Message.2", "You do not have the permission for this command.");
							    ymlFileMessage.set("Message.3", "There is a new update available for this plugin. &f( https://fof1092.de/Plugins/AFLR )&6");
							    ymlFileMessage.set("Message.4", "The plugin is reloading...");
							    ymlFileMessage.set("Message.5", "Reloading completed.");
								ymlFileMessage.set("Message.6", "Try [COMMAND]");
								ymlFileMessage.set("HelpTextGui.1", "&2[&aClick to use this command&2]");
								ymlFileMessage.set("HelpTextGui.2", "&2[&aNext page&2]");
								ymlFileMessage.set("HelpTextGui.3", "&2[&aLast page&2]");
								ymlFileMessage.set("HelpTextGui.4", "&2&oPage [PAGE]. &2Click on the arrows for the next page.");
								ymlFileMessage.set("HelpText.1", "This command shows you the help page.");
								ymlFileMessage.set("HelpText.2", "This command shows you the info page.");
								ymlFileMessage.set("HelpText.3", "This command is reloading the Config.yml and Messages.yml file.");
								ymlFileMessage.set("HelpText.4", "This command lists your last @ messages.");
								ymlFileMessage.save(fileMessages);
							} catch (IOException e1) {
								ServerLog.err("Can't create the Messages.yml. [" + e1.getMessage() +"]");
							}
						}
						
	
						Options.msg.put("[AlmostFlatLandsReloaded]", ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("[AlmostFlatLandsReloaded]")));
						Options.msg.put("color.1", ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("Color.1")));
						Options.msg.put("color.2", ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("Color.2")));
						Options.msg.put("msg.1", ChatColor.translateAlternateColorCodes('&', Options.msg.get("color.1") + ymlFileMessage.getString("Message.1")));
						Options.msg.put("msg.2", ChatColor.translateAlternateColorCodes('&', Options.msg.get("color.1") + ymlFileMessage.getString("Message.2")));
						Options.msg.put("msg.3", ChatColor.translateAlternateColorCodes('&', Options.msg.get("color.1") + ymlFileMessage.getString("Message.3")));
						Options.msg.put("msg.4", ChatColor.translateAlternateColorCodes('&', Options.msg.get("color.1") + ymlFileMessage.getString("Message.4")));
						Options.msg.put("msg.5", ChatColor.translateAlternateColorCodes('&', Options.msg.get("color.1") + ymlFileMessage.getString("Message.5")));
						Options.msg.put("msg.6", ChatColor.translateAlternateColorCodes('&', Options.msg.get("color.1") + ymlFileMessage.getString("Message.6")));
						Options.msg.put("helpTextGui.1", ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpTextGui.1")));
						Options.msg.put("helpTextGui.2", ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpTextGui.2")));
						Options.msg.put("helpTextGui.3", ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpTextGui.3")));
						Options.msg.put("helpTextGui.4", ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpTextGui.4")));
						
						HelpPageListener.initializeHelpPageListener("/AlmostFlatLandsReloaded help", Options.msg.get("[AlmostFlatLandsReloaded]"));
						
						CommandListener.addCommand(new de.fof1092.almostflatlandsreloaded.pluginmanager.Command("/AFLR help (Page)", null, ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpText.1"))));
						CommandListener.addCommand(new de.fof1092.almostflatlandsreloaded.pluginmanager.Command("/AFLR info", null, ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpText.2"))));
						CommandListener.addCommand(new de.fof1092.almostflatlandsreloaded.pluginmanager.Command("/AFLR reload", "MessageMe.Reload", ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpText.3"))));
						
	
						cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + Options.msg.get("msg.5"));
					}
				}
			} else {
				String replaceCommand = Options.msg.get("msg.6");
				replaceCommand = replaceCommand.replace("[COMMAND]", CommandListener.getCommand("/AFLR help (Page)").getColoredCommand());
				cs.sendMessage(Options.msg.get("[AlmostFlatLandsReloaded]") + replaceCommand); 
			}
		}
		
		return true;
	}

}
