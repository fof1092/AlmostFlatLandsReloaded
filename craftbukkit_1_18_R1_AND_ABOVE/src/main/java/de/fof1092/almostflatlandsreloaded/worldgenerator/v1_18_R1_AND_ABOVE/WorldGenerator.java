package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_18_R1_AND_ABOVE;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * WorldGenerator manages the AFLR world generator.
 */
public class WorldGenerator extends ChunkGenerator {

	/**
	 * Generates the Chunk Data of the AFLR world.
	 */
	@Override
	public void generateNoise(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkData cd) {

		SimplexOctaveGenerator wgen = new SimplexOctaveGenerator(worldInfo.getSeed(), 8);
		wgen.setScale(0.015625D);

		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {

				int realX = x + chunkX * 16;
				int realZ = z + chunkZ * 16;

				double normalHight = (wgen.noise(realX, realZ, 0.5D, 0.5D) / 0.75) + Options.worldHeight;


				cd = StonePopulator.populate(x, (int) normalHight, z, cd, random);

				if (Options.worldGenerateOres) {
					cd = OrePopulator.populate(x, (int) normalHight, z, cd, random);
				}

				cd = BeadrockPopulator.populate(x, z, cd, random);
				cd = GroundPopulator.populate(x, (int) normalHight, z, cd, random);
			}
		}
	}

	/**
	 * Creates a list of all BlockPopulators.
	 */
	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		List<BlockPopulator> populators = new ArrayList<>();
		populators.add(new FlowerAndGrassPopulator());
		populators.add(new TreePopulator());

		return populators;
	}
}
