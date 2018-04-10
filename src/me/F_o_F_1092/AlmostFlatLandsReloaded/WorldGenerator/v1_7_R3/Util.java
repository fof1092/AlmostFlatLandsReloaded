package me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_7_R3;

import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;

import net.minecraft.server.v1_7_R3.Block;

public class Util {
	
	public static void setBlockFast(World world, int x, int y, int z, int blockId, byte data) {
	    net.minecraft.server.v1_7_R3.World w = ((CraftWorld) world).getHandle();
	    
	    w.setTypeAndData(x, y, z, Block.getById(blockId), data, 0);
	}
}