package basicTest;

import org.testng.annotations.Test;

import pages.MainCaliber;
import pages.ReportsCaliber;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class CaliberReports {
	public static ReportsCaliber caliber;
	public static WebDriver driver;
	public static MainCaliber mCaliber;

	@BeforeSuite
	public void setUpDriverAndPage() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/reports");
		caliber = new ReportsCaliber(driver);
		mCaliber = new MainCaliber(driver);
		
		
		mCaliber.getUsername().sendKeys("calibot@revature.com");
		mCaliber.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
		mCaliber.getSubmitButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
//	@Parameters({"caliber"})
	public void goToMainPage() {
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/reports");
	}
	
	@Test(priority=1)
	public void getPageWithData() throws InterruptedException {
		String expectedName = "Dillon Pape";
		caliber.getBatchDropdown().click();
		caliber.selectBatchWithData().click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Assert.assertEquals(expectedName, caliber.getFirstNameInTable().getText()); 
	}
	
	@AfterSuite
	public void cleanup() {
		//driver.quit();
	}

}
