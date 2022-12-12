package com.Assignemnt.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	static Properties prop;
	static String CD; 
	public Properties getConfigData() {
		prop = new Properties();
		CD = System.getProperty("user.dir");
		try {
			FileInputStream config = new FileInputStream(CD+"/src/main/java/com/Assignemnt/config/config.properties");
			prop.load(config);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}

}
