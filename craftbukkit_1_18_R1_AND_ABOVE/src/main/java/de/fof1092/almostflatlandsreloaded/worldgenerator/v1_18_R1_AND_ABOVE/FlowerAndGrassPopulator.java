package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_18_R1_AND_ABOVE;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.LimitedRegion;
import org.bukkit.generator.WorldInfo;

import java.util.Random;

/**
 * FlowerAndGrassPopulator is responsible for creating the flowers and grass of the AFLR world.
 */
class FlowerAndGrassPopulator extends BlockPopulator {

	/**
	 * Populates the flowers and grass within the given chunk.
	 */
	@Override
	public void populate(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, LimitedRegion limitedRegion) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {

				int realX = x + chunkX * 16;
				int realZ = z + chunkZ * 16;

				int highestY = Util.getHighestBlockAt(limitedRegion, realX, realZ);

				BlockData bd = limitedRegion.getBlockData(realX, highestY, realZ);
				BlockData bdAbove = limitedRegion.getBlockData(realX, highestY + 1, realZ);

				if (bd.getMaterial() == Material.DIRT || bd.getMaterial() == Material.GRASS_BLOCK) {
					if (bdAbove.getMaterial() == Material.AIR) {

						int randomBlockGrass = random.nextInt(100) + 1;
						int randomBlockFlower = random.nextInt(100) + 1;

						if (randomBlockGrass <= Options.worldGrassChance) {
							limitedRegion.setType(realX, highestY + 1, realZ, Material.GRASS);
						} else if (randomBlockFlower <= Options.worldFlowerChance) {

							int randomFlowerColor = random.nextInt(4) + 1;

							if (randomFlowerColor <= 3) {
								limitedRegion.setType(realX, highestY + 1, realZ, Material.DANDELION);
							} else {
								limitedRegion.setType(realX, highestY + 1, realZ, Material.POPPY);
							}
						}
					}
				}
			}
		}
	}
}
