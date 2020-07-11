package me.F_o_F_1092.AlmostFlatLandsReloaded.PluginManager;

import org.bukkit.ChatColor;

public class JSONMessage {

	String text;
	ChatColor textColor;
	
	String hoverText;

	String previewCommand;
	String runCommand;
	String openURL;
	
	public JSONMessage(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}
	
	public void setTextColor(ChatColor textColor) {
		this.textColor = textColor;
	}

	public boolean hasTextColor() {
		return textColor != null;
	}
	
	public ChatColor getTextColor() {
		return textColor;
	}
	
	
	public void setHoverText(String hoverText) {
		this.hoverText = hoverText;
	}

	public boolean hasHoverText() {
		return hoverText != null;
	}
	
	public String getHoverText() {
		return hoverText;
	}
	
	
	public void setPreviewCommand(String previewCommand) {
		this.previewCommand = previewCommand;
	}
	
	public String getPreviewCommand() {
		return previewCommand;
	}

	public boolean hasPreviewCommand() {
		return previewCommand != null;
	}

	public void setRunCommand(String runCommand) {
		this.runCommand = runCommand;
	}
	
	public boolean hasRunCommand() {
		return runCommand != null;
	}

	public String getRunCommand() {
		return runCommand;
	}
	
	public void setOpenURL(String openURL) {
		this.openURL = openURL;
	}
	
	public String getOpenURL() {
		return openURL;
	}

	public boolean hasOpenURL() {
		return openURL != null;
	}

	
	public String getJsonText() {
		String jsonText = "{\"text\":\"" + this.text + "\"";
		
		if (hasTextColor()) {
			jsonText += ",\"color\":" + getTextColor().name().toLowerCase();
		}
		
		if (hasPreviewCommand()) {
			jsonText += ",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + this.previewCommand + "\"}";
		} else if (hasRunCommand()) {
			jsonText += ",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + this.runCommand + "\"}";
		} else if (hasOpenURL()) {
			jsonText += ",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + this.openURL + "\"}";
		}
			
		if (hasHoverText()) {
			jsonText += ",\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\"" + this.hoverText + "\"}]}}";
		}
		
		jsonText += "}";
		
		return jsonText;
	}
	
	public String getFinalJsonText() {
		return "[\"\"," + getJsonText() + "]";
	}
}
