package de.fof1092.almostflatlandsreloaded.worldgenerator.v1_8_R3;

import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.IBlockData;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

public class Util {

	public static void setBlockFast(World world, int x, int y, int z, int blockId, byte data) {
		net.minecraft.server.v1_8_R3.World w = ((CraftWorld) world).getHandle();
		BlockPosition bp = new BlockPosition(x, y, z);
		int combined = blockId + (data << 12);
		IBlockData ibd = net.minecraft.server.v1_8_R3.Block.getByCombinedId(combined);
		w.setTypeAndData(bp, ibd, 0);
	}

}