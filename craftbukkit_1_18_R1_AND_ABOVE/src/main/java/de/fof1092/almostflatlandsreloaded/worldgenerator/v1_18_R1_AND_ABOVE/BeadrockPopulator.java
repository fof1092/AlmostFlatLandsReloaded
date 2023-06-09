package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_18_R1_AND_ABOVE;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator.ChunkData;

import java.util.Random;

/**
 * BeadrockPopulator is responsible for creating the bedrock layer of the AFLR world.
 */
final class BeadrockPopulator {

	/**
	 * BeadrockPopulator has a private constructor, because it is a utility class.
	 */
	private BeadrockPopulator() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Creates the bedrock layer of the AFLR world.
	 *
	 * @param x the x position within the chunk
	 * @param z the z position within the chunk
	 * @param cd the current ChunkData of the chunk
	 * @param random the randomizer of the world
	 *
	 * @return the new ChunkData of the chunk
	 */
	 static ChunkData populate(int x, int z, ChunkData cd, Random random) {
		 int randomBlockBedrock1 = random.nextInt(100) + 1;
		 int randomBlockBedrock2 = random.nextInt(100) + 1;
		 int randomBlockBedrock3 = random.nextInt(100) + 1;

		 cd.setBlock(x, Options.getWorldDepth, z, Material.BEDROCK);

		 if (randomBlockBedrock1 <= 80) {
			 cd.setBlock(x, Options.getWorldDepth + 1, z, Material.BEDROCK);
		 }

		 if (randomBlockBedrock2 <= 60) {
			 cd.setBlock(x, Options.getWorldDepth + 2, z, Material.BEDROCK);
		 }

		 if (randomBlockBedrock3 <= 40) {
			 cd.setBlock(x, Options.getWorldDepth + 3, z, Material.BEDROCK);
		 }

		 return cd;
	}
	
}