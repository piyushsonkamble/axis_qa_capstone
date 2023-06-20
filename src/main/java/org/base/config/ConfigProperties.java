package org.base.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	public static Properties property;
	private static String configPath = "src/main/java/util/configsettings.properties";
	
	public static void initializePropertyFile() throws IOException {
		property = new Properties();
		InputStream inputStream = new FileInputStream(configPath);
		property.load(inputStream);
	}
}
