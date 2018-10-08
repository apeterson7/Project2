package basicTest;

import org.testng.annotations.Test;

import pages.AssessCaliber;
import pages.MainCaliber;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class CaliberAssessBatch {
	public static MainCaliber caliberLog;
	public static AssessCaliber ac;

	public static WebDriver driver;
	

	@BeforeSuite
	public void setUpDriverAndPage() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		//puts us on the login page
		driver.get("https://dev-caliber.revature.tech/");
		
		ac =  new AssessCaliber(driver);
		ac.getUsername().sendKeys("calibot@revature.com");
		ac.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
		ac.getSubmitButton().click();
		
		
		
	}
	
//	@BeforeMethod
//	@Parameters({"caliber"})
//	public void goToMainPage() {
//	}
	
	
	@Test
	public void navigateToAssess() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		ac.getAssessBatch().click();
		
	}
	
	
	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
