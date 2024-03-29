package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_17_R1;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

/**
 * TreePopulator is responsible for creating the trees of the AFLR world.
 */
class TreePopulator extends BlockPopulator {

	/**
	 * Populates the trees within the given chunk.
	 */
	@Override
	public void populate(World world, Random random, Chunk chunk) {
		int chance = random.nextInt(100) + 1;

		if (chance <= Options.worldTreeChance) {

			int realX = random.nextInt(16) + chunk.getX() * 16;
			int realZ = random.nextInt(16) + chunk.getZ() * 16;

			Block block = world.getHighestBlockAt(realX, realZ);
			Block blockAbove = world.getBlockAt(new Location(world, block.getX(), (block.getY() + 1), block.getZ()));
			Material groundMaterial = block.getType();

			if (Options.worldGroundMaterials.contains(groundMaterial)) {
				int randomTree = random.nextInt(Options.worldTreeTypes.size());
				world.generateTree(blockAbove.getLocation(), Options.worldTreeTypes.get(randomTree));
			}
		}
	}
	
}