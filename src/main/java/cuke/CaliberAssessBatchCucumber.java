package cuke;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AssessCaliber;

public class CaliberAssessBatchCucumber {
	public static AssessCaliber caliberAsse;

	public static WebDriver driver;
	@Given("^I am on the Assess page for the batch I want$")
	public void i_am_on_the_Assess_page_for_the_batch_I_want() throws Throwable {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		//puts us on the login page
		driver.get("https://dev-caliber.revature.tech/");

		caliberAsse =  new AssessCaliber(driver);
		caliberAsse.getUsername().sendKeys("calibot@revature.com");
		caliberAsse.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
		caliberAsse.getSubmitButton().click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		caliberAsse.getAssessBatch().click();
		Assert.assertTrue(caliberAsse.isOnAssess());
		
	}

	@When("^I click on the plus button$")
	public void i_click_on_the_plus_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I should be able to see the new window$")
	public void i_should_be_able_to_see_the_new_window() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
