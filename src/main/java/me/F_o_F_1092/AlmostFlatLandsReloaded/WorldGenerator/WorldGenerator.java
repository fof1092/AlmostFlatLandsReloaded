package me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import me.F_o_F_1092.AlmostFlatLandsReloaded.Options;

public class WorldGenerator extends ChunkGenerator {
	
	public static List<BlockPopulator> populators;
	
	@Override
	public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biomeGrid) {
		
		ChunkData cd = createChunkData(world);

		SimplexOctaveGenerator wgen = new SimplexOctaveGenerator(world, 8);
		wgen.setScale(0.015625D);
		
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {

				int realX = x + chunkX * 16;
				int realZ = z + chunkZ * 16;
		        
		        double normalHight = (wgen.noise(realX, realZ, 0.5D, 0.5D) / 0.75) + Options.worldHight;
		        
		        cd.setBlock(x, 0, z, Material.BEDROCK);

		        for (int bY = 1; bY < normalHight - 4; bY++) {
		        	cd.setBlock(x, bY, z, Material.BEDROCK);
		        }
		        
		        for (int bY = (int) (normalHight - 4); bY < normalHight - 1; bY++) {
		        	cd.setBlock(x, bY, z, Material.DIRT);
		        }
		        
		        cd.setBlock(x, (int) normalHight, z, Material.GRASS_BLOCK);
		        
		        
				biomeGrid.setBiome(x, z, Options.worldBiome);
			}
		}
		
		return cd;
	}
	
	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
	    List<BlockPopulator> populators_main = new ArrayList<BlockPopulator>();
	    populators_main.add(new FlowerAndGrassPopulator());
	    populators_main.add(new TreePopulator());
	    
	    return populators_main;
	}
	

}
