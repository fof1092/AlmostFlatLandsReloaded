package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_16_R1;

import net.minecraft.server.v1_16_R1.Block;
import net.minecraft.server.v1_16_R1.BlockPosition;
import net.minecraft.server.v1_16_R1.Chunk;
import net.minecraft.server.v1_16_R1.IBlockData;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_16_R1.CraftChunk;

public class Util {
	
	public static void setBlockFast(World world, int x, int y, int z, Block b) {
		BlockPosition bp = new BlockPosition(x, y, z);
		IBlockData ibd = b.getBlockData();
		Chunk c = ((CraftChunk)world.getBlockAt(x, y, z).getChunk()).getHandle();

		c.setType(bp, ibd, true);
    }

}