package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_15_R1;

import java.util.Random;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.generator.ChunkGenerator.ChunkData;

/**
 * StonePopulator is responsible for creating the stone layer of the AFLR world.
 */
final class StonePopulator {

	/**
	 * StonePopulator has a private constructor, because it is a utility class.
	 */
	private StonePopulator() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Creates the stone layer of the AFLR world.
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
		for (int newY = 1; newY < y; newY++) {
			
			int randomBlockType = random.nextInt(Options.worldUndergroundMaterials.size());
								
			cd.setBlock(x, newY, z, Options.worldUndergroundMaterials.get(randomBlockType));
		}
		
		return cd;
	}

}