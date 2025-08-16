package Ultils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	
	public static Properties prop;
	
	public static Properties loadConfigProperties() {
		
		prop = new Properties();
		
		try {
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\Configuration.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}

}
