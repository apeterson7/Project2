package basicTest;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.MainCaliber;

public class CaliberHome {

	public static MainCaliber caliber;
	public static WebDriver driver;
	

	@BeforeSuite
	public void setUpDriverAndPage() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/reports");
		caliber = new MainCaliber(driver);
		
	}
	
	@BeforeMethod
//	@Parameters({"wikipedia"})
	public void goToMainPage() {
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/reports");
	}
	
	@Test
	public void login() {
		caliber.getUsername().sendKeys("calibot@revature.com");
		caliber.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
		caliber.getSubmitButton().click();
		AssertJUnit.assertEquals(driver.getTitle(), "Caliber | Performance Management");
	}
	

	
	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
	
}
