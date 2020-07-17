package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_9_R1;

import net.minecraft.server.v1_9_R1.BlockPosition;
import net.minecraft.server.v1_9_R1.IBlockData;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_9_R1.CraftWorld;

public class Util {

	public static void setBlockFast(World world, int x, int y, int z, int blockId, byte data) {
		net.minecraft.server.v1_9_R1.World w = ((CraftWorld) world).getHandle();
		BlockPosition bp = new BlockPosition(x, y, z);
		int combined = blockId + (data << 12);
		IBlockData ibd = net.minecraft.server.v1_9_R1.Block.getByCombinedId(combined);
		w.setTypeAndData(bp, ibd, 0);
	}

}