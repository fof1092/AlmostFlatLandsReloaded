package me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_12_R1;

import org.bukkit.World;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;

import net.minecraft.server.v1_12_R1.BlockPosition;
import net.minecraft.server.v1_12_R1.IBlockData;

public class Util {
	
	public static void setBlockFast(World world, int x, int y, int z, int blockId, byte data) {
	    net.minecraft.server.v1_12_R1.World w = ((CraftWorld) world).getHandle();
	    net.minecraft.server.v1_12_R1.Chunk chunk = w.getChunkAt(x >> 4, z >> 4);
	    BlockPosition bp = new BlockPosition(x, y, z);
	    int combined = blockId + (data << 12);
	    IBlockData ibd = net.minecraft.server.v1_12_R1.Block.getByCombinedId(combined);
	    chunk.a(bp, ibd);
	}
	
}