package me.F_o_F_1092.AlmostFlatLandsReloaded;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.Command;
import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.CommandListener;
import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.ServerLog;
import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.VersionManager;
import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.VersionManager.BukkitVersion;
import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.VersionManager.ServerType;
import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.Spigot.HelpPageListener;
import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.Spigot.UpdateListener;

public class Main extends JavaPlugin {

	static Main plugin;
	
	public static Main getPlugin() {
		return plugin;
	}
	
	@Override
	public void onEnable() {
		System.out.println("[AlmostFlatLandsReloaded] a Plugin by F_o_F_1092");

		plugin = this;
		
		ServerLog.setPluginTag("§2[§a§lAlmostFlatLandsReloaded§2]§a");
		UpdateListener.initializeUpdateListener(1.0, "1.0 v1_13_R1", 55405);
		UpdateListener.checkForUpdate();
		
		
		VersionManager.setVersionManager(Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3], ServerType.BUKKIT, false);
		
		
		File fileConfig = new File("plugins/AlmostFlatLandsReloaded/Config.yml");
		FileConfiguration ymlFileConfig = YamlConfiguration.loadConfiguration(fileConfig);
		
		if (!fileConfig.exists()) {
			try {
				ymlFileConfig.set("Version", UpdateListener.getUpdateDoubleVersion());
				ymlFileConfig.set("GameVersion.SetOwn", false);
				ymlFileConfig.set("GameVersion.Version", "v1_13_R1");
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
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EventListener(), this);
		
		this.getCommand("AlmostFlatLandsReloaded").setExecutor(new CommnandAlmostFlatLandsReloaded());
		this.getCommand("AlmostFlatLandsReloaded").setTabCompleter(new CommnandAlmostFlatLandsReloadedTabCompleter());
		
		
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
		
		CommandListener.addCommand(new Command("/AFLR help (Page)", null, ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpText.1"))));
		CommandListener.addCommand(new Command("/AFLR info", null, ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpText.2"))));
		CommandListener.addCommand(new Command("/AFLR reload", "AlmostFlatLandsReloaded.Reload", ChatColor.translateAlternateColorCodes('&', ymlFileMessage.getString("HelpText.3"))));
		
		
		if (VersionManager.getBukkitVersion() != BukkitVersion.v1_13_R1) {
			ServerLog.err("");
			ServerLog.err("This version of AlmostFlatLandsReloaded only supports MC 1.13 Servers.");
			ServerLog.err("You can find other versions here https://www.spigotmc.org/resources/55405/history");
			ServerLog.err("");
		}
	}

	@Override
	public void onDisable() {
		System.out.println("[AlmostFlatLandsReloaded] a Plugin by F_o_F_1092");
	}
	
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id){
		if (VersionManager.getBukkitVersion() == BukkitVersion.v1_13_R1) {
			return new me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.WorldGenerator();
		}
		
		return null;
	}
	
}
