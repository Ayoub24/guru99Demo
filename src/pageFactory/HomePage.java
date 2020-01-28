package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.Screenshot;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//td[contains(text(), 'Manger Id : mngr242466')]")
	WebElement managerId;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
				
	}
	
	public void checkLoginStatut(String uid, String pass) {		
		
	   if(uid.equals("mngr242466") && pass.equals("ujybYsY")) {
		   
		   String actualManagerId = managerId.getText();
		   
		   Assert.assertEquals(actualManagerId, "Manger Id : "+uid);	
		   
		   Screenshot.takeScreenshot(driver);
	   }
	   else {
		   
		   String alertText = driver.switchTo().alert().getText();
		   
		   System.out.println("The alert message for (" + uid +"/"+pass+") is "+ alertText );
		   
		   Assert.assertEquals(alertText, "User or Password is not valid");
	   }  	
		
	}	
	
}
