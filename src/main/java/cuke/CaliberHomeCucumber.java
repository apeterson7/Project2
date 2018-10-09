package cuke;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import pages.MainCaliber;

public class CaliberHomeCucumber {
	
	public static MainCaliber caliber;
	public static WebDriver driver;
	private static Properties props;
	
	@Given("^I am on the Login Page$")
	public void i_am_on_the_Login_Page() throws Throwable {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/");
		caliber = new MainCaliber(driver);
	}

	@When("^I submit the correct credentials$")
	public void i_submit_the_correct_credentials() throws Throwable {
		props = new Properties();
		FileInputStream in; 
		in = new FileInputStream("src/main/resources/connection.properties");
		props.load(in);
		
		caliber.getUsername().sendKeys(props.getProperty("username"));
		caliber.getPassword().sendKeys(props.getProperty("password"));
		caliber.getSubmitButton().click();
		
		//Try to get it to wait until the page loads?
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    
	}

	@Then("^I should be at Home Page$")
	public void i_should_be_at_Home_Page() throws Throwable {
		AssertJUnit.assertEquals(driver.getTitle(), "Caliber | Performance Management");
	}

	@Given("^I am on the Home Page$")
	public void i_am_on_the_Home_Page() throws Throwable {
		caliber.getHome().click();
	}

	@Then("^I should get the correct header$")
	public void i_should_get_the_correct_header() throws Throwable {
		AssertJUnit.assertEquals(caliber.getHomePageHeader().getText(),"Welcome to Caliber!");
	}

	@When("^I select Florida's Quality Audits$")
	public void i_select_Florida_s_Quality_Audits() throws Throwable {
		caliber.getQualityAuditStateFlorida().click();
	}

	@Then("^I should see that Blake Kruppa is the first quality audit$")
	public void i_should_see_that_Blake_Kruppa_is_the_first_quality_audit() throws Throwable {
		AssertJUnit.assertEquals(caliber.getQualityAuditFirstRecord().getText(), "Blake Kruppa 2018-07-30");
	}

	@When("^I select Virginia's Quality Audits$")
	public void i_select_Virginia_s_Quality_Audits() throws Throwable {
		caliber.getQualityAuditStateVirginia().click();
	}

	@Then("^I should see that Patrick Walsh is the first quality audit$")
	public void i_should_see_that_Patrick_Walsh_is_the_first_quality_audit() throws Throwable {
		AssertJUnit.assertEquals(caliber.getQualityAuditFirstRecord().getText(), "Patrick Walsh 2018-08-19");
	}

	@Given("^I am on the Home Page and click states dropdown$")
	public void i_am_on_the_Home_Page_and_click_states_dropdown() throws Throwable {
		caliber.getWeeklyProgressSelector().click();
	}

	@When("^I select New York's Quality Audits$")
	public void i_select_New_York_s_Quality_Audits() throws Throwable {
		caliber.getQualityAuditStateNewYork().click();
	}

	@Then("^I should see that Ryan Lessley is the first quality audit$")
	public void i_should_see_that_Ryan_Lessley_is_the_first_quality_audit() throws Throwable {
		AssertJUnit.assertEquals(caliber.getQualityAuditFirstRecord().getText(), "Ryan Lessley 2018-07-24");
	}

	@When("^I select Florida's Weekly Progress$")
	public void i_select_Florida_s_Weekly_Progress() throws Throwable {
		caliber.getWeeklyProgressStateFlorida().click();
	}

	@Then("^I should see that Steven Kelsey is the first weekly progress report$")
	public void i_should_see_that_Steven_Kelsey_is_the_first_weekly_progress_report() throws Throwable {
		AssertJUnit.assertEquals(caliber.getWeeklyProgressFirstRecord().getText(), "Steven Kelsey 2018-08-19");

	}

	@When("^I select Virginia's Weekly Progress$")
	public void i_select_Virginia_s_Weekly_Progress() throws Throwable {
		caliber.getWeeklyProgressStateVirginia().click();
	}

	@Then("^I should see that is Patrick Walsh first weekly progress report$")
	public void i_should_see_that_is_Patrick_Walsh_first_weekly_progress_report() throws Throwable {
		AssertJUnit.assertEquals(caliber.getWeeklyProgressFirstRecord(), "Patrick Walsh 2018-08-19");
	}

	@When("^I select New York's Weekly Progress$")
	public void i_select_New_York_s_Weekly_Progress() throws Throwable {
		caliber.getWeeklyProgressStateNewYork().click();
	}

	@Then("^I should see that Ryan Lessley is the first weekly progress report$")
	public void i_should_see_that_Ryan_Lessley_is_the_first_weekly_progress_report() throws Throwable {
		AssertJUnit.assertEquals(caliber.getWeeklyProgressFirstRecord(), "Ryan Lessley 2018-07-24");

	}
}
