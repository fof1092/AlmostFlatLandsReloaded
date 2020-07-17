package de.fof1092.almostflatlandsreloaded.pluginmanager;

public class UpdateListener {

	protected static boolean updateAvailable = false;
	public static boolean showUpdateMessage;
	protected static double updateDouble;
	protected static String updateString;
	protected static int resourceID;
	
	public static void initializeUpdateListener(double updateDouble, String updateString, int resourceID) {
		UpdateListener.updateDouble = updateDouble;
		UpdateListener.updateString = updateString;
		UpdateListener.resourceID = resourceID;
	}

	public static double getUpdateDoubleVersion() {
		return updateDouble;
	}
	
	public static String getUpdateStringVersion() {
		return updateString;
	}

	public static boolean isAnewUpdateAvailable() {
		return updateAvailable;
	}

	public static boolean isUpdateMessageVisible() {
		return showUpdateMessage;
	}
}
