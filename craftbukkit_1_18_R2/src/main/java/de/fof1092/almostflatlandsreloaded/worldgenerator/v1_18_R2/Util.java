package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_18_R2;

import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.IBlockData;
import net.minecraft.world.level.chunk.Chunk;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_18_R2.CraftChunk;

/**
 * Util contains utilities for the WorldGenerator.
 */
final class Util {

	/**
	 * Util has a private constructor, because it is a utility class.
	 */
	private Util() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Modifies a block in the AFLR world without block updates.
	 *
	 * @param world the world of the block
	 * @param x the x position of the block
	 * @param y the y position of the block
	 * @param z the z position of the block
	 * @param block the block to be placed
	 */
	static void setBlockFast(World world, int x, int y, int z, Block block) {
		BlockPosition bp = new BlockPosition(x, y, z);
		IBlockData ibd = block.n();
		Chunk c = ((CraftChunk)world.getBlockAt(x, y, z).getChunk()).getHandle();

		c.setBlockState(bp, ibd, true, true);
	}

}