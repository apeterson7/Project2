package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		driver.get("https://dev-caliber.revature.tech/");
		caliber = new MainCaliber(driver);
		
	}
	
	
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		caliber.getUsername().sendKeys("calibot@revature.com");
		caliber.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
		caliber.getSubmitButton().click();
		AssertJUnit.assertEquals(driver.getTitle(), "Caliber | Performance Management");
		//Try to get it to wait until the page loads?
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
	
	
	@Test(priority = 2)
	public void checkHomePageHeader() {
		System.out.println(caliber.getHomePageHeader().getText());
		AssertJUnit.assertEquals(caliber.getHomePageHeader().getText(),"Welcome to Caliber!");

	}
	

	@Test(priority = 3)
	public void checkStateSelectorQualityAudit() {
		caliber.getQualityAuditStateFlorida().click();
		AssertJUnit.assertEquals(caliber.getQualityAuditFirstRecord().getText(), "Blake Kruppa 2018-07-30");
		caliber.getQualityAuditStateVirginia().click();
		AssertJUnit.assertEquals(caliber.getQualityAuditFirstRecord().getText(), "Patrick Walsh 2018-08-19");
		caliber.getQualityAuditStateNewYork().click();
		AssertJUnit.assertEquals(caliber.getQualityAuditFirstRecord().getText(), "Ryan Lessley 2018-07-24");
		
	}
	

	@Test(priority = 4)
	public void checkStateSelectorWeeklyProgress() {
		caliber.getWeeklyProgressSelector().click();
		caliber.getWeeklyProgressStateFlorida().click();
		AssertJUnit.assertEquals(caliber.getWeeklyProgressFirstRecord(), "Steven Kelsey 2018-08-19");
		caliber.getWeeklyProgressStateVirginia().click();
		AssertJUnit.assertEquals(caliber.getWeeklyProgressFirstRecord(), "Patrick Walsh 2018-08-19");
		caliber.getWeeklyProgressStateNewYork().click();
		AssertJUnit.assertEquals(caliber.getWeeklyProgressFirstRecord(), "Ryan Lessley 2018-07-24");
		
	}
	
	
	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
