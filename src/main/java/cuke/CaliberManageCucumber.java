package cuke;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MainCaliber;
import pages.ManageCaliber;

public class CaliberManageCucumber {
	public static ManageCaliber caliber;
	public static MainCaliber mCaliber;
	public static WebDriver driver;
	WebDriverWait wait;
	
	@Given("^I am on the Manage page$")
	public void i_am_on_the_manage_page() throws Throwable {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		//puts us on the login page
		driver.get("https://dev-caliber.revature.tech/");
		caliber = new ManageCaliber(driver);
		mCaliber = new MainCaliber(driver);
		wait = new WebDriverWait(driver, 5);
		
		mCaliber.getUsername().sendKeys("calibot@revature.com");
		mCaliber.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
		mCaliber.getSubmitButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/manage");
	}
	@When("^I click on the human icon$")
	public void i_click_on_the_human_icon() throws Throwable {
		caliber.getTraineeButton().click();
	}
	@Then("^The View Batch Trainees modal should appear$")
	public void the_view_batch_trainees_modal_should_appear() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(caliber.getTraineeModal()));
		driver.quit();
	}
}
