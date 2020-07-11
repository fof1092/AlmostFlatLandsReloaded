package me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager;

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
