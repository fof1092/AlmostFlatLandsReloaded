package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_13_R2;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator.ChunkData;

import java.util.Random;

/**
 * OrePopulator is responsible for creating the ores within the stone layer of the AFLR world.
 */
final class OrePopulator {

	/**
	 * OrePopulator has a private constructor, because it is a utility class.
	 */
	private OrePopulator() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Creates the ores within the stone layer of the AFLR world.
	 *
	 * @param x the x position within the chunk
	 * @param y the y position within the chunk
	 * @param z the z position within the chunk
	 * @param cd the current ChunkData of the chunk
	 * @param random the randomizer of the world
	 *
	 * @return the new ChunkData of the chunk
	 */
	static ChunkData populate(int x, int y, int z, ChunkData cd, Random random) {
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

	/**
	 * Creates the ores at a random height taking into account the maxHeight.
	 *
	 * @param x the x position within the chunk
	 * @param y the y position within the chunk
	 * @param z the z position within the chunk
	 * @param cd the current ChunkData of the chunk
	 * @param random the randomizer of the WorldGenerator
	 * @param maxHeight the maximum y of the block
	 * @param material the material of the block to be placed
	 */
	private static void setRandomBlock(int x, int y, int z, ChunkData cd, Random random, int maxHeight, Material material) {
		int chance = random.nextInt(100) + 1;
		if (chance <= Options.worldOresChance) {

			int rndX = random.nextInt(16);
			int rndZ = random.nextInt(16);
			int rndY = random.nextInt((maxHeight - Options.getWorldDepth) - 4) + 4 + Options.getWorldDepth;

			if (rndX == x && rndZ == z) {
				if (rndY <= y) {
					cd.setBlock(x, rndY, z, material);
				}
			}
		}
	}

}
