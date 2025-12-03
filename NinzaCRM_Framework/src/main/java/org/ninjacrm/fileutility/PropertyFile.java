package org.ninjacrm.fileutility;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertyFile {
	
	public String getPropertyData(String key) throws Throwable
	{
		FileInputStream file = new FileInputStream("C:\\Users\\QSP\\eclipse-workspace1\\Frame\\src\\test\\resources\\commonproperties.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;

	}
}
