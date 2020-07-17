package de.fof1092.almostflatlandsreloaded.pluginmanager;

import java.util.List;

public class JSONMessageListener {

	public static String putJSONMessagesTogether(List<JSONMessage> jsonMessages) {
		
		String jsonString = "[\"\"";
		
		for (JSONMessage jsonMessage : jsonMessages) {
			jsonString += "," + jsonMessage.getJsonText();
		}
		
		jsonString += "]";
		
		return jsonString;
	}
}
