package cuke;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MainCaliber;
import pages.ReportsCaliber;

public class CaliberReportsCucumber {
	
	public static ReportsCaliber caliber;
	public static WebDriver driver;
	public static MainCaliber mCaliber;
	private static Properties props;
	public static WebDriverWait wait;
	
	@Given("^I am on the Reports page and click the week dropdown$")
	public void i_am_on_the_reports_page_and_click_the_week_dropdown() throws Throwable {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		caliber = new ReportsCaliber(driver);
		mCaliber = new MainCaliber(driver);
		props = new Properties();
		wait = new WebDriverWait(driver, 5);
		FileInputStream in;
		in = new FileInputStream("src/main/resources/connection.properties");
		props.load(in);
		
		mCaliber.getUsername().sendKeys(props.getProperty("username"));
		mCaliber.getPassword().sendKeys(props.getProperty("password"));
		mCaliber.getSubmitButton().click();
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/reports");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		caliber.getYearDropdown().click();
		caliber.selectYear().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		caliber.getBatchDropdown().click();
		caliber.selectBatchWithData().click();
	}
	
	@When("^I select a week$")
	public void i_select_a_week() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(caliber.getDropdowns()));
		wait.until(ExpectedConditions.visibilityOf(caliber.getWeekDropdown())).click();
		wait.until(ExpectedConditions.visibilityOf(caliber.selectWeek1())).click();
	}
	
	@Then("^I should see the quality audit panel$")
	public void i_should_see_the_quality_audit_panel() throws Throwable {
		Assert.assertTrue(caliber.getDoughnut() != null);
	}
	
	

}
