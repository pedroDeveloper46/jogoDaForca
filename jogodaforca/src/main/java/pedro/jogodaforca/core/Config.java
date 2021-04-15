package pedro.jogodaforca.core;

import java.io.IOException;
import java.util.Properties;

public class Config {
	
	
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.load(Config.class.getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 throw new RuntimeException(e);
		}
	}
	
	public static String get(String name) {
		return prop.getProperty(name);
	}
	
	public static void set(String max) {
		prop.setProperty("maxErro", max);
	}
	
	

}
