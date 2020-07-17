package de.fof1092.almostflatlandsreloaded;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.fof1092.almostflatlandsreloaded.pluginmanager.Command;
import de.fof1092.almostflatlandsreloaded.pluginmanager.CommandListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.ServerLog;
import de.fof1092.almostflatlandsreloaded.pluginmanager.VersionManager;
import de.fof1092.almostflatlandsreloaded.pluginmanager.VersionManager.BukkitVersion;
import de.fof1092.almostflatlandsreloaded.pluginmanager.VersionManager.ServerType;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.HelpPageListener;
import de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot.UpdateListener;

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
		UpdateListener.initializeUpdateListener(1.21, "1.2.1", 55405);
		UpdateListener.checkForUpdate();
		
		
		VersionManager.setVersionManager(Bukkit.getServer().getClass().getPackage().getName().replace(".",  ",").split(",")[3], ServerType.BUKKIT, false);
		
		
		File fileConfig = new File("plugins/AlmostFlatLandsReloaded/Config.yml");
		FileConfiguration ymlFileConfig = YamlConfiguration.loadConfiguration(fileConfig);
		
		if (!fileConfig.exists()) {
			try {
				ymlFileConfig.set("Version", UpdateListener.getUpdateDoubleVersion());
				ymlFileConfig.set("GameVersion.SetOwn", false);
				ymlFileConfig.set("GameVersion.Version", "v1_16_R1");
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
				
				ymlFileConfig.set("World.WaterHeight", -1);
				ymlFileConfig.set("World.GenerateOres", true);
				
				List<String> undergroundMaterials = new ArrayList<String>();
				undergroundMaterials.add(Material.STONE.toString());
				undergroundMaterials.add(Material.STONE.toString());
				undergroundMaterials.add(Material.COBBLESTONE.toString());
				ymlFileConfig.set("World.UndergroundMaterials", undergroundMaterials);
				
				List<String> preGroundMaterials = new ArrayList<String>();
				preGroundMaterials.add(Material.DIRT.toString());
				ymlFileConfig.set("World.PreGroundMaterials", preGroundMaterials);
				
				List<String> groundMaterials = new ArrayList<String>();
				groundMaterials.add(Material.GRASS_BLOCK.toString());
				ymlFileConfig.set("World.GroundMaterials", groundMaterials);
				
				List<String> waterGroundMaterials = new ArrayList<String>();
				waterGroundMaterials.add(Material.SAND.toString());
				ymlFileConfig.set("World.WaterGroundMaterials", waterGroundMaterials);
				
				
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

		Options.worldWaterHeight = ymlFileConfig.getInt("World.WaterHeight");
		Options.worldGenerateOres = ymlFileConfig.getBoolean("World.GenerateOres");

		for (String strMaterial : ymlFileConfig.getStringList("World.UndergroundMaterials")) {
			Options.worldUndergroundMaterials.add(Material.valueOf(strMaterial));
		}

		for (String strMaterial : ymlFileConfig.getStringList("World.PreGroundMaterials")) {
			Options.worldPreGroundMaterials.add(Material.valueOf(strMaterial));
		}

		for (String strMaterial : ymlFileConfig.getStringList("World.GroundMaterials")) {
			Options.worldGroundMaterials.add(Material.valueOf(strMaterial));
		}

		for (String strMaterial : ymlFileConfig.getStringList("World.WaterGroundMaterials")) {
			Options.worldWaterGroundMaterials.add(Material.valueOf(strMaterial));
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
			ServerLog.err("");
			ServerLog.err("This version of AlmostFlatLandsReloaded only supports MC 1.8.8 - 1.16 Servers.");
			ServerLog.err("You can find other versions here https://www.spigotmc.org/resources/55405/history");
			ServerLog.err("");

			getPluginLoader().disablePlugin(this);
		}
	}

	@Override
	public void onDisable() {
		System.out.println("[AlmostFlatLandsReloaded] a Plugin by F_o_F_1092");
	}
	
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id){
		ChunkGenerator chunkGenerator = null;

		try {
			Class<?> c = Class.forName("de.fof1092.almostflatlandsreloaded.worldgenerator." + VersionManager.getBukkitVersion() + ".WorldGenerator");
			Constructor m = c.getConstructor();
			Object i = m.newInstance();
			chunkGenerator = (ChunkGenerator) i;
		} catch (ClassNotFoundException | NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		
		return chunkGenerator;
	}
	
}
