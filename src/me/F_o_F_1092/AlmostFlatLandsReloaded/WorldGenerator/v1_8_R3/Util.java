package me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_8_R3;

import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.IBlockData;

public class Util {
	
	public static void setBlockFast(World world, int x, int y, int z, int blockId, byte data) {
	    net.minecraft.server.v1_8_R3.World w = ((CraftWorld) world).getHandle();
	    net.minecraft.server.v1_8_R3.Chunk chunk = w.getChunkAt(x >> 4, z >> 4);
	    BlockPosition bp = new BlockPosition(x, y, z);
	    int combined = blockId + (data << 12);
	    IBlockData ibd = net.minecraft.server.v1_8_R3.Block.getByCombinedId(combined);
	    chunk.a(bp, ibd);
	}
	
}