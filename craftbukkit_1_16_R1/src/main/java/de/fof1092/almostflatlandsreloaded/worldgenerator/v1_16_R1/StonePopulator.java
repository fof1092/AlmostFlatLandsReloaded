package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_16_R1;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.generator.ChunkGenerator.ChunkData;

import java.util.Random;

public class StonePopulator {

	public static ChunkData populate(int x, int y, int z, ChunkData cd, Random random) {
		for (int newY = 1; newY < y; newY++) {
			
			int randomBlockType = random.nextInt(Options.worldUndergroundMaterials.size());
								
			cd.setBlock(x, newY, z, Options.worldUndergroundMaterials.get(randomBlockType));
		}
		
		return cd;
	}

}