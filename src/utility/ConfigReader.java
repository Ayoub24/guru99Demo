package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties properties;
	
	public ConfigReader() {
		
		try {
			File file = new File("./configuration/configuration.property");
			
			FileInputStream FInput = new FileInputStream(file);			
			
			properties = new Properties();
			
			properties.load(FInput);
			
		} catch (Exception e) {
			
			System.out.println("Exception is "+ e.getMessage());
		}		
		
	}
	
	public String getFileProperty(String pro) {
				
		return properties.getProperty(pro);
		
	}
	
}
