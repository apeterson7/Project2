package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.MainCaliber;

public class CaliberHome {
	public static MainCaliber caliber;
	public static WebDriver driver;
	private static Properties props;

	
	
	@BeforeSuite
	public void setUpDriverAndPage() throws IOException {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		caliber = new MainCaliber(driver);
		
		props = new Properties();
		FileInputStream in; 
		in = new FileInputStream("src/main/resources/connection.properties");
		props.load(in);
		
	}
	
	
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		caliber.getUsername().sendKeys(props.getProperty("username"));
		caliber.getPassword().sendKeys(props.getProperty("password"));
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
	public void checkStateSelectorQualityAuditFlorida() {
		caliber.getQualityAuditStateFlorida().click();
		AssertJUnit.assertEquals(caliber.getQualityAuditFirstRecord().getText(), "Blake Kruppa 2018-07-30");
		
	}
	
	@Test(priority = 4)
	public void checkStateSelectorQualityAuditVirginia() {
		caliber.getQualityAuditStateVirginia().click();
		AssertJUnit.assertEquals(caliber.getQualityAuditFirstRecord().getText(), "Patrick Walsh 2018-08-19");
	}
	
	@Test(priority = 5)
	public void checkStateSelectorQualityAuditNewYork() {
		caliber.getQualityAuditStateNewYork().click();
		AssertJUnit.assertEquals(caliber.getQualityAuditFirstRecord().getText(), "Ryan Lessley 2018-07-24");
	}
	
	@Test(priority = 6)
	public void checkStateSelectorWeeklyProgressFlorida() {
		caliber.getWeeklyProgressSelector().click();
		caliber.getWeeklyProgressStateFlorida().click();
		AssertJUnit.assertEquals(caliber.getWeeklyProgressFirstRecord(), "Steven Kelsey 2018-08-19");

	}
	
	@Test(priority = 7)
	public void checkStateSelectorWeeklyProgressVirginia() {
		caliber.getWeeklyProgressSelector().click();
		caliber.getWeeklyProgressStateVirginia().click();
		AssertJUnit.assertEquals(caliber.getWeeklyProgressFirstRecord(), "Patrick Walsh 2018-08-19");
		
	}
	
	@Test(priority = 8)
	public void checkStateSelectorWeeklyProgressNewYork() {
		caliber.getWeeklyProgressSelector().click();
		caliber.getWeeklyProgressStateNewYork().click();
		AssertJUnit.assertEquals(caliber.getWeeklyProgressFirstRecord(), "Ryan Lessley 2018-07-24");
	}
	

	@DataProvider(name = "Employee Names")
	public static Object[][] example(){
		return new Object[][] {
			{"RuneScape"},{"World of Warcraft"},{"Guild Wars"}
		};
	}
	
	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
