package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_9_R2;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator.ChunkData;

public class OrePopulator {

	public static ChunkData populate(int x, int y, int z, ChunkData cd, Random random) {
		for (int i = 0; i < 20*10; i++) {
			setRandomBlock(x, y, z, cd, random, 128, Material.COAL_ORE);
		}
		
		for (int i = 0; i < 20*6; i++) {
			setRandomBlock(x, y, z, cd, random, 64, Material.IRON_ORE);
		}
		
		for (int i = 0; i < 1*4; i++) {
			setRandomBlock(x, y, z, cd, random, 32, Material.GOLD_ORE);
		}
		
		for (int i = 0; i < 4*1; i++) {
			setRandomBlock(x, y, z, cd, random, 32, Material.EMERALD_ORE);
		}
		
		for (int i = 0; i < 8*6; i++) {
			setRandomBlock(x, y, z, cd, random, 16, Material.REDSTONE_ORE);
		}
		
		for (int i = 0; i < 1*7; i++) {
			setRandomBlock(x, y, z, cd, random, 16, Material.DIAMOND_ORE);
		}
		
		for (int i = 0; i < 1*5; i++) {
			setRandomBlock(x, y, z, cd, random, 16, Material.LAPIS_ORE);
		}
		
		return cd;
	}

	static void setRandomBlock(int x, int y, int z, ChunkData cd, Random random, int maxHeight, Material material) {
		int rndX = random.nextInt(16);
		int rndZ = random.nextInt(16);
		int rndY = random.nextInt(maxHeight - 4) + 4;
		
		if (rndX == x && rndZ == z) {
			if (rndY <= y) {
				cd.setBlock(x, rndY, z, material);
			}
		}
	}

}
