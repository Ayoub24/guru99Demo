package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	
	public static void takeScreenshot(WebDriver driver){
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File src = ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src, new File("./screenshot/image.png"));
			
			System.out.println("Screenshot Taken");
		} catch (Exception e) {
			System.out.println("Exception is :  " + e.getMessage());
		} 		
	} 
}
