package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_18_R1_AND_ABOVE;

import org.bukkit.Material;
import org.bukkit.generator.LimitedRegion;

/**
 * Util contains utilities for the WorldGenerator.
 */
final class Util {

	/**
	 * Util has a private constructor, because it is a utility class.
	 */
	private Util() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Searches the highest block in a LimitedRegion.
	 *
	 * @param limitedRegion the LimitedRegion
	 * @param x the x position of the block
	 * @param z the z position of the block
	 *
	 * @return The Y value of the highest block or the lowest point
	 */
	static int getHighestBlockAt(LimitedRegion limitedRegion, int x, int z) {
		for (int y = 256; y > -64; y--) {
			if (limitedRegion.getBlockData(x, y, z).getMaterial() != Material.AIR) {
				return y;
			}
		}
		return -64;
	}

}