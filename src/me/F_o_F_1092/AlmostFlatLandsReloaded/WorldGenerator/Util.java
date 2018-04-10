package me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator;

import org.bukkit.World;

import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.VersionManager;
import me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager.VersionManager.BukkitVersion;

public class Util {
	
	public static void setBlockFast(World world, int x, int y, int z, int blockId, byte data) {
		if (VersionManager.getBukkitVersion() == BukkitVersion.v1_7_R1) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_7_R1.Util.setBlockFast(world, x, y, z, blockId, data);
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_7_R2) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_7_R2.Util.setBlockFast(world, x, y, z, blockId, data);
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_7_R3) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_7_R3.Util.setBlockFast(world, x, y, z, blockId, data);
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_7_R4) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_7_R4.Util.setBlockFast(world, x, y, z, blockId, data);
			
			
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_8_R1) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_8_R1.Util.setBlockFast(world, x, y, z, blockId, data);
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_8_R2) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_8_R2.Util.setBlockFast(world, x, y, z, blockId, data);
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_8_R3) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_8_R3.Util.setBlockFast(world, x, y, z, blockId, data);
			
			
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_9_R1) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_9_R1.Util.setBlockFast(world, x, y, z, blockId, data);
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_9_R2) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_9_R2.Util.setBlockFast(world, x, y, z, blockId, data);
			
			
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_10_R1) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_10_R1.Util.setBlockFast(world, x, y, z, blockId, data);
			
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_11_R1) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_11_R1.Util.setBlockFast(world, x, y, z, blockId, data);
			
		} else if (VersionManager.getBukkitVersion() == BukkitVersion.v1_12_R1) {
			me.F_o_F_1092.AlmostFlatLandsReloaded.WorldGenerator.v1_12_R1.Util.setBlockFast(world, x, y, z, blockId, data);
		}
	}
	
}