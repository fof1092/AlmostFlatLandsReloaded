package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_8_R3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

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
		        
		        
		        cd = StonePopulator.populate(x, (int) normalHight, z, cd, random);
		        
		        if (Options.worldGenerateOres) {
		        	cd = OrePopulator.populate(x, (int) normalHight, z, cd, random);
		        }
		        
				cd = BeadrockPopulator.populate(x, (int) normalHight, z, cd, random);
				cd = GroundPopulator.populate(x, (int) normalHight, z, cd, random);
		        
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
