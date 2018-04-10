package me.F_o_F_1092.AlmostFlatLandsReloaded;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	public static List<String> pages = new ArrayList<String>();
	public static int commandsPerPage;
	public static int pagesPerPage;
	public static int maxTextLength;
}
