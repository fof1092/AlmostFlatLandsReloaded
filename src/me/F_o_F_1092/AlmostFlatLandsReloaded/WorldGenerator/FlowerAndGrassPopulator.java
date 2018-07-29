package me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import me.F_o_F_1092.AlmostFlatLandsReloaded.Options;
import net.minecraft.server.v1_13_R1.Blocks;

public class FlowerAndGrassPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random rnd, Chunk chunk) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				
				int realX = x + chunk.getX() * 16;
				int realZ = z + chunk.getZ() * 16;
				
				Block block = world.getHighestBlockAt(realX, realZ);
				Block blockBelow = world.getBlockAt(new Location(world, block.getX(), block.getY() - 1, block.getZ()));
				
				if (blockBelow.getType() == Material.DIRT || blockBelow.getType() == Material.GRASS_BLOCK) {
					if (block.getType() == Material.AIR) {
					
						int randomBlockGrass = rnd.nextInt(100) + 1;
						int randomBlockFlower = rnd.nextInt(100) + 1;
						
						if (randomBlockGrass <= Options.worldGrassChance) {
							Util.setBlockFast(world, realX, block.getY(), realZ, Blocks.GRASS);
				        } else if (randomBlockFlower <= Options.worldFlowerChance) {
				        	
				        	int randomFlowerColor = rnd.nextInt(4) + 1;
							
				        	if (randomFlowerColor <= 3) {
				        		Util.setBlockFast(world, realX, block.getY(), realZ, Blocks.DANDELION);
				        	} else {
				        		Util.setBlockFast(world, realX, block.getY(), realZ, Blocks.POPPY);
				        	}
				        }
					}
				}
			}
		}
	}
	
}
