package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_17_R1;

import de.fof1092.almostflatlandsreloaded.Options;
import net.minecraft.world.level.block.Blocks;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import java.util.Random;

/**
 * FlowerAndGrassPopulator is responsible for creating the flowers and grass of the AFLR world.
 */
class FlowerAndGrassPopulator extends BlockPopulator {

	/**
	 * Populates the flowers and grass within the given chunk.
	 */
	@Override
	public void populate(World world, Random random, Chunk chunk) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				
				int realX = x + chunk.getX() * 16;
				int realZ = z + chunk.getZ() * 16;
				
				Block block = world.getHighestBlockAt(realX, realZ);
				Block blockAbove = world.getBlockAt(new Location(world, block.getX(), (block.getY() + 1), block.getZ()));

				if (block.getType() == Material.DIRT || block.getType() == Material.GRASS_BLOCK) {
					if (blockAbove.getType() == Material.AIR) {
					
						int randomBlockGrass = random.nextInt(100) + 1;
						int randomBlockFlower = random.nextInt(100) + 1;

						if (randomBlockGrass <= Options.worldGrassChance) {
							Util.setBlockFast(world, realX, blockAbove.getY(), realZ, Blocks.aX);
				        } else if (randomBlockFlower <= Options.worldFlowerChance) {
				        	
				        	int randomFlowerColor = random.nextInt(4) + 1;
							
				        	if (randomFlowerColor <= 3) {
				        		Util.setBlockFast(world, realX, blockAbove.getY(), realZ, Blocks.bv);
				        	} else {
				        		Util.setBlockFast(world, realX, blockAbove.getY(), realZ, Blocks.bw);
				        	}
				        }
					}
				}
			}
		}
	}
	
}
