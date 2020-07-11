package me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import me.F_o_F_1092.AlmostFlatLandsReloaded.Options;

public class TreePopulator extends BlockPopulator {
	
	@Override
	public void populate(World world, Random rnd, Chunk chunk) {
		int chance = rnd.nextInt(100) + 1;
		
		if (chance <= Options.worldTreeChance) {
	    
			int realX = rnd.nextInt(16) + chunk.getX() * 16;
			int realZ = rnd.nextInt(16) + chunk.getZ() * 16;

			Block block = world.getHighestBlockAt(realX, realZ);

			int randomTree = rnd.nextInt(Options.worldTreeTypes.size());
			world.generateTree(block.getLocation(), Options.worldTreeTypes.get(randomTree));
		}
	}
	
}