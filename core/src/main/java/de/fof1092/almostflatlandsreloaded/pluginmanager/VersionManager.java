package de.fof1092.almostflatlandsreloaded.pluginmanager;

public class VersionManager {
	
	static BukkitVersion bukkitVersion;
	static BungeeVersion bungeeVersion;
	
	static ServerType serverType;
	static boolean selfSet;
	
	public enum BukkitVersion {
		v1_7_R1, v1_7_R2, v1_7_R3, v1_7_R4,
		v1_8_R1, v1_8_R2, v1_8_R3,
		v1_9_R1, v1_9_R2,
		v1_10_R1,
		v1_11_R1,
		v1_12_R1,
		v1_13_R1, v1_13_R2,
		v1_14_R1,
		v1_15_R1,
		v1_16_R1, v1_16_R2, v1_16_R3,
		v1_17_R1,
		v1_18_R1, v1_18_R2,
		v1_19_R1,
		v1_20_R1,
		v1_21_R1,
		UNKNOWN	}
	
	public enum BungeeVersion {
		v1_7, v1_8, v1_9, v1_0, v1_10, v1_11, v1_12, v1_13, v1_14, v1_15, v1_16, v1_17, v1_18, v1_19, v1_20, v1_21, UNKNOWN
	}

	public enum ServerType {
		BUKKIT, BUNGEECORD
	}

	public static void setVersionManager(String version, ServerType serverType, boolean selfSet) {
		VersionManager.serverType = serverType;

		if (serverType == ServerType.BUKKIT) {
			
			try {
				bukkitVersion = BukkitVersion.valueOf(version);
			} catch (Exception e) {
				bukkitVersion = BukkitVersion.UNKNOWN;
			}
			
		} else if (serverType == ServerType.BUNGEECORD) {
			
			version = version.replace("git:BungeeCord-Bootstrap:", "");
			version = version.split("-")[0];

			if (version.startsWith("1.7")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_7;
			} else if (version.startsWith("1.8")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_8;
			} else if (version.startsWith("1.9")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_9;
			} else if (version.startsWith("1.0")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_0;
			} else if (version.startsWith("1.10")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_10;
			} else if (version.startsWith("1.11")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_11;
			} else if (version.startsWith("1.12")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_12;
			} else if (version.startsWith("1.13")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_13;
			} else if (version.startsWith("1.14")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_14;
			} else if (version.startsWith("1.15")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_15;
			} else if (version.startsWith("1.16")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_16;
			} else if (version.startsWith("1.17")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_17;
			} else if (version.startsWith("1.18")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_18;
			} else if (version.startsWith("1.19")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_19;
			} else if (version.startsWith("1.20")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_20;
			} else if (version.startsWith("1.21")) {
				VersionManager.bungeeVersion = BungeeVersion.v1_21;
			} else {
				VersionManager.bungeeVersion = BungeeVersion.UNKNOWN;
			}
			
		} else {
			VersionManager.bungeeVersion = BungeeVersion.UNKNOWN;
		}
	}
	
	public static BukkitVersion getBukkitVersion() {
		return bukkitVersion;
	}

	public static BungeeVersion getBungeeVersion() {
		return bungeeVersion;
	}
	
	public static ServerType getServerType() {
		return VersionManager.serverType;
	}
	
	public static String getSetverTypeString() {
		switch (serverType) {
			case BUKKIT:
				return "Bukkit/Spigot";
			case BUNGEECORD:
				return "BungeeCord";
		}
		return null;
	}

}
