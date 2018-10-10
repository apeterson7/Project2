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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class CaliberAssessBatch {
	public static MainCaliber caliberLog;
	public static AssessCaliber caliberAsse;

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

	@Test(priority=2)
	public void dropDownYear() {
		String expected = "Bob Dylan";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		caliberAsse.getYearDropdown().click();
		caliberAsse.selectYearWithData().click();
		
		Assert.assertEquals(caliberAsse.getFirstNameInTable().getText().trim(), expected);
	}

	@Test(priority=3)
	public void getPageWithData() throws InterruptedException {
		String expectedName = "Castillo, Erika";
		caliberAsse.getBatchDropdown().click();
		caliberAsse.selectBatchWithData().click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		String result = caliberAsse.getFirstNameInTable().getText();
		Assert.assertEquals(result.trim(), expectedName); 
	}

	
	//The following tests pertain to the create assignment window
	@Test(priority=4)
	public void openAssignmentWindow() {
		caliberAsse.openAssignmentWindow();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(caliberAsse.getWindowStyle()));
		AssertJUnit.assertTrue(e != null);
	}

	
	@Test(priority = 5)
	public void cancelAssignmentX() {
	String expected = "display: none;";
	caliberAsse.clickX();
	WebDriverWait wait = new WebDriverWait(driver, 5);
	boolean e = wait.until(ExpectedConditions.invisibilityOf(caliberAsse.getWindowStyle()));
	AssertJUnit.assertTrue(e );
	}

	@Test(priority = 6)
	public void cancelAssignmentClose() {
		
		caliberAsse.openAssignmentWindow();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(caliberAsse.getWindowStyle()));
		
		caliberAsse.clickClose();
		boolean b = wait.until(ExpectedConditions.invisibilityOf(caliberAsse.getWindowStyle()));
		AssertJUnit.assertTrue(b );
	}

	@Test(priority = 7)
	public void invalidAssignment() {
		caliberAsse.openAssignmentWindow();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(caliberAsse.getWindowStyle()));
		caliberAsse.clickSave();
		e = wait.until(ExpectedConditions.visibilityOf(caliberAsse.getWindowStyle()));
		AssertJUnit.assertTrue(e != null);
		}
	
	@Test(priority = 8, enabled = false)
	public void validAssignment() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		caliberAsse.clickX();
		wait.until(ExpectedConditions.invisibilityOf(caliberAsse.getWindowStyle()));
		int before = caliberAsse.getListOfAssessments().size();
		caliberAsse.openAssignmentWindow();
		wait.until(ExpectedConditions.visibilityOf(caliberAsse.getWindowStyle()));
		
		caliberAsse.selectAssessmentCatagory();
		caliberAsse.clickSave();
		wait.until(ExpectedConditions.invisibilityOf(caliberAsse.getWindowStyle()));
		int after = caliberAsse.getListOfAssessments().size();
		Assert.assertEquals(before+1, after);
		
	}
	
	
	
	

	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
