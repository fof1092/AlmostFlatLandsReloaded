package de.fof1092.almostflatlandsreloaded.pluginmanager;

public class Math {

	public static boolean isInt(String strg) {  
		try  {  
			Integer.parseInt(strg);  
		} catch(NumberFormatException e) {  
			return false;  
		}  
		  
		return true;  
	}

	public static boolean isDouble(String strg) {  
		try  {  
			Double.parseDouble(strg);  
		} catch(NumberFormatException e) {  
			return false;  
		}  
			  
		return true;  
	}
}
