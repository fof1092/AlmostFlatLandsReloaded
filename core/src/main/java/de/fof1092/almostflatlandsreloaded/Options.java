package de.fof1092.almostflatlandsreloaded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Biome;

public class Options {
	
	public static HashMap<String, String> msg = new HashMap<String, String>();
	
	public static int worldHight;
	public static Biome worldBiome;
	public static int worldGrassChance;
	public static int worldFlowerChance;
	public static int worldTreeChance;
	public static List<TreeType> worldTreeTypes = new ArrayList<TreeType>();
	public static int worldWaterHeight;
	public static boolean worldGenerateOres;
	public static List<Material> worldUndergroundMaterials = new ArrayList<Material>();
	public static List<Material> worldPreGroundMaterials = new ArrayList<Material>();
	public static List<Material> worldGroundMaterials = new ArrayList<Material>();
	public static List<Material> worldWaterGroundMaterials = new ArrayList<Material>();
	
	public static List<String> pages = new ArrayList<String>();
	public static int commandsPerPage;
	public static int pagesPerPage;
	public static int maxTextLength;
}
