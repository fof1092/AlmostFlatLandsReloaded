package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_8_R3;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.IBlockData;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

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
	 * @param blockId the block id to be placed
	 * @param blockSubId the block sub id to be placed
	 */
	static void setBlockFast(World world, int x, int y, int z, int blockId, byte blockSubId) {
		net.minecraft.server.v1_8_R3.World w = ((CraftWorld) world).getHandle();
		BlockPosition bp = new BlockPosition(x, y, z);
		int combined = blockId + (blockSubId << 12);
		IBlockData ibd = net.minecraft.server.v1_8_R3.Block.getByCombinedId(combined);
		w.setTypeAndData(bp, ibd, 0);
	}

}