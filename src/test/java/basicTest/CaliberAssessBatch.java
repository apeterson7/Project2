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
import org.testng.Assert;
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

		caliberAsse =  new AssessCaliber(driver);
		caliberAsse.getUsername().sendKeys("calibot@revature.com");
		caliberAsse.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
		caliberAsse.getSubmitButton().click();




	}

	//	@BeforeMethod
	//	@Parameters({"caliber"})
	//	public void goToMainPage() {
	//	}


	@Test(priority=1)
	public void navigateToAssess() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		caliberAsse.getAssessBatch().click();
		Assert.assertTrue(caliberAsse.isOnAssess());

	}

	@Test(priority=3)
	public void dropDownYear() {
		String expected = "Aslam Gangji";
		caliberAsse.getYearDropdown().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		caliberAsse.selectYearWithData().click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Assert.assertEquals(caliberAsse.getFirstNameInTable().getText().trim(), expected);
	}

	@Test(priority=2)
	public void getPageWithData() throws InterruptedException {
		String expectedName = "Ahmad Naser";
		caliberAsse.getBatchDropdown().click();
		caliberAsse.selectBatchWithData().click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		String result = caliberAsse.getFirstNameInTable().getText();
		Assert.assertEquals(result.trim(), expectedName); 
	}

	
	//The following tests pertain to the create assignment window
	@Test(priority=4)
	public void openAssignmentWindow() {
		String expected = "display: block; padding-right: 17px;";
		caliberAsse.openAssignmentWindow();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(caliberAsse.getWindowStyle().trim(),expected);
	}

	
	@Test(priority = 5)
	public void cancelAssignmentX() {
	String expected = "display: none;";
	caliberAsse.clickX();
	//This is bad but since nothing is loading it may be the only solution
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(caliberAsse.getWindowStyle().trim(),expected);
	caliberAsse.openAssignmentWindow();
	}

	@Test(priority = 6)
	public void cancelAssignmentClose() {
		
		String expected = "display: none;";
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		caliberAsse.clickClose();
		//This is bad but since nothing is loading it may be the only solution
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(caliberAsse.getWindowStyle().trim(),expected);
	}

//	@Test
//	public void invalidAssignment() {
//		//TODO
//	}
//
	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
