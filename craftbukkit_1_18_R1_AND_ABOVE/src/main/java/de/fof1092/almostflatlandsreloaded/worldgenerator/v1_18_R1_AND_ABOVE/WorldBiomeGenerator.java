package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_18_R1_AND_ABOVE;

import de.fof1092.almostflatlandsreloaded.Options;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;

import java.util.Arrays;
import java.util.List;

/**
 * WorldBiomeGenerator manages the AFLR world Biome generator.
 */
public class WorldBiomeGenerator extends BiomeProvider {

    /**
     * Generates the Biome of the AFLR world.
     */
    @Override
    public Biome getBiome(WorldInfo worldInfo, int x, int y, int z) {
        return Options.worldBiome;
    }

    /**
     * List the Biomes of the AFLR world.
     */
    @Override
    public List<Biome> getBiomes(WorldInfo worldInfo) {
        return Arrays.asList(Options.worldBiome);
    }
}

