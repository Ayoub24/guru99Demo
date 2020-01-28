package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.ExcelDataConfig;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import utility.ConfigReader;

public class LoginPageTest {
	
	ConfigReader configFile=new ConfigReader();
  
	WebDriver driver;
	
	@BeforeMethod
	public void setUpBrowser() {
		
		//configFile = new ConfigReader();
		
		System.setProperty("webdriver.chrome.driver", configFile.getFileProperty("ChromeDirver"));
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(configFile.getFileProperty("URL"));		
		
	}
	
	@Test(dataProvider="providerExcel")
	public void loginToGuru99Page(String uid, String pass) {
		
		LoginPage Guru99LoginPage = new LoginPage(driver);
		
		HomePage Guru99HomePage = new HomePage(driver);
		
		
		Guru99LoginPage.checkLoginPageTitle();
		
		Guru99LoginPage.LoginToGuru99(uid, pass);
		
		Guru99HomePage.checkLoginStatut(uid, pass);		
		
	}
	
	@AfterMethod
	public void clloseBroser() {
		
		driver.quit();
		
	}
	
	@DataProvider(name="providerExcel")
	public Object[][] dataExcelProvider(){
		
		ExcelDataConfig ExcelData=new ExcelDataConfig(configFile.getFileProperty("ExcelPath"));
		
		int numberOfRow = ExcelData.getSheetRowNumber(0);
		
		Object[][] data = new Object[numberOfRow][2];
		
		for (int i=0; i<numberOfRow; i++) {
			
			data[i][0] =  ExcelData.getData(0, i, 0);
			
			data[i][1] =  ExcelData.getData(0, i, 1);		
		}
		
		return data;		
	}	
	
}
