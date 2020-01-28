package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
  
	WebDriver driver;
	
	@FindBy(xpath="//h2[contains(., 'Guru99 Bank')]")
	WebElement pageTitle;
	
	@FindBy(name="uid")
	WebElement userId;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void LoginToGuru99 (String uId, String pass) {
		
		userId.sendKeys(uId);
		
		password.sendKeys(pass);
		
		loginBtn.click();
				
	}
	
	public void checkLoginPageTitle() {
		
		String actualPageTitle = pageTitle.getText();
		
		Assert.assertEquals(actualPageTitle, "Guru99 Bank");
	}
	
	
}













