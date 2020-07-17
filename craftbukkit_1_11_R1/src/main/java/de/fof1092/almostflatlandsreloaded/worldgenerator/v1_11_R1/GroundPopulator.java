package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_11_R1;

import java.util.Random;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator.ChunkData;

public class GroundPopulator {

	public static ChunkData populate(int x, int y, int z, ChunkData cd, Random random) {
		
		if (Options.worldWaterHeight >= y) {
			
			for (int newY = y; newY < y + 3; newY++) {
				int randomBlockType = random.nextInt(Options.worldWaterGroundMaterials.size());
				cd.setBlock(x, newY, z, Options.worldWaterGroundMaterials.get(randomBlockType));
				
				if (newY > Options.worldWaterHeight) {
					break;
				}
			}
			
			y+=3;
			
			while (y < Options.worldWaterHeight) {
				cd.setBlock(x, y + 1, z, Material.WATER);

				y++;
			}
		} else {
		
			for (int newY = y; newY < y + 3; newY++) {
				int randomBlockType = random.nextInt(Options.worldPreGroundMaterials.size());
				cd.setBlock(x, newY, z, Options.worldPreGroundMaterials.get(randomBlockType));
			}
			
			y+=3;
			
			int randomBlockType = random.nextInt(Options.worldGroundMaterials.size());
			cd.setBlock(x, y, z, Options.worldGroundMaterials.get(randomBlockType));
		}
		
		return cd;
	}

}
