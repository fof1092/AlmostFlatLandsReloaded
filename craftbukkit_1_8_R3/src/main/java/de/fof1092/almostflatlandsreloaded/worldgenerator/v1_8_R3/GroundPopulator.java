package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_8_R3;

import java.util.Random;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator.ChunkData;

/**
 * GroundPopulator is responsible for creating the ground layer of the AFLR world.
 */
final class GroundPopulator {

	/**
	 * GroundPopulator has a private constructor, because it is a utility class.
	 */
	private GroundPopulator() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Creates the ground layer of the AFLR world.
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
		if (Options.worldGenerateWater && y < Options.worldHeight) {
			for (int newY = y; newY < y + 4; newY++) {
				int randomBlockType = random.nextInt(Options.worldWaterGroundMaterials.size());
				cd.setBlock(x, newY, z, Options.worldWaterGroundMaterials.get(randomBlockType));
			}
			y+=4;

			while (y <= Options.worldHeight + 2) {
				cd.setBlock(x, y, z, Material.WATER);
				y++;
			}
		} else {
			for (int newY = y; newY < y + 3; newY++) {
				int randomBlockType = random.nextInt(Options.worldPreGroundMaterials.size());
				cd.setBlock(x, newY, z, Options.worldPreGroundMaterials.get(randomBlockType));
			}
			y+=3;

			int randomBlockType = random.nextInt(Options.worldGroundMaterials.size());
			cd.setBlock(x, y, z, Options.worldGroundMaterials.get(randomBlockType));
		}

		return cd;
	}

}
