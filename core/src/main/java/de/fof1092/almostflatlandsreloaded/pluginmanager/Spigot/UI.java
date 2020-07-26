package de.fof1092.almostflatlandsreloaded.pluginmanager.Spigot;

import de.fof1092.almostflatlandsreloaded.AlmostFlatlandsReloaded;
import de.fof1092.almostflatlandsreloaded.pluginmanager.ServerLog;
import org.bukkit.Bukkit;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class UI {

	
	public static boolean pb = false;
	protected static String infoURL = "https://fof1092.de/Plugins/pluginInfo.php?user=%%__USER__%%";
	protected static String tag;

	public static void check() {
		Bukkit.getScheduler().scheduleSyncDelayedTask(AlmostFlatlandsReloaded.getPlugin(), new Runnable() {
			@Override
			public void run() {
				try {
					TrustManager[] trustAllCerts = new TrustManager[] {
						new X509TrustManager() {
							public X509Certificate[] getAcceptedIssuers() {
								return null;
							}
							
							public void checkClientTrusted(X509Certificate[] certs, String authType) {}
								
							public void checkServerTrusted(X509Certificate[] certs, String authType) {}
						}
					};
							
					SSLContext sslC = SSLContext.getInstance("SSL");
					sslC.init(null, trustAllCerts, new java.security.SecureRandom());
						
					HttpsURLConnection.setDefaultSSLSocketFactory(sslC.getSocketFactory());

					HostnameVerifier allHostsValid = new HostnameVerifier() {
						public boolean verify(String hostname, SSLSession session) {
							return true;
						}
					};
								    
					HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
						
					URL url = new URL(infoURL);
					URLConnection connection = url.openConnection();
					final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); 
					
					if (reader.readLine().equals("YES")) {
						pb = true;
					}
					
				} catch (IOException e) {
					ServerLog.err("Couldn't check for UserInfo. [" + e.getMessage() +"]");
				} catch (NoSuchAlgorithmException e) {
					ServerLog.err("Couldn't check for UserInfo. [" + e.getMessage() +"]");
					e.printStackTrace();
				} catch (KeyManagementException e) {
					ServerLog.err("Couldn't check for UserInfo. [" + e.getMessage() +"]");
					e.printStackTrace();
				}
			}
		}, 0L);
	}

}
