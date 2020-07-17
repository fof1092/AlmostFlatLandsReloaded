package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_8_R3;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator.ChunkData;

public class BeadrockPopulator {

	public static ChunkData populate(int x, int y, int z, ChunkData cd, Random random) {
		int randomBlockType = random.nextInt(100) + 1;
		int randomBlockAbouthType = random.nextInt(100) + 1;
		int randomBlockAbouthAbouthType = random.nextInt(100) + 1;

		cd.setBlock(x, 0, z, Material.BEDROCK);

		if (randomBlockType <= 80) {
			cd.setBlock(x, 1, z, Material.BEDROCK);
		}

		if (randomBlockAbouthType <= 60) {
			cd.setBlock(x, 2, z, Material.BEDROCK);
		}

		if (randomBlockAbouthAbouthType <= 40) {
			cd.setBlock(x, 3, z, Material.BEDROCK);
		}

		return cd;
	}

}