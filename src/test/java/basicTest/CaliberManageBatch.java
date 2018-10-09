package basicTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.MainCaliber;
import pages.ManageCaliber;

public class CaliberManageBatch {
	public static ManageCaliber caliber;
	public static MainCaliber mCaliber;
	public static WebDriver driver;
	

	@BeforeSuite
	public void setUpDriverAndPage() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/manage");
		caliber = new ManageCaliber(driver);
		mCaliber = new MainCaliber(driver);
		
		mCaliber.getUsername().sendKeys("calibot@revature.com");
		mCaliber.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
		mCaliber.getSubmitButton().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
//	@Parameters({"caliber"})
	public void goToMainPage() {
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/manage");
	}
	
	@Test
	public void clickCreateNewBatch() {
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id<locator>));
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		wait.until(ExpectedConditions.elementToBeClickable(caliber.getCreateBatchLink()));
		caliber.getCreateBatchLink().click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement e = wait.until(ExpectedConditions.visibilityOf(caliber.getCreateBatchModal()));
		AssertJUnit.assertTrue(e != null);
	}
//	@Test
//	public void goToManageBatch() {
//		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/manage");
//		AssertJUnit.assertTrue(driver.findElement(By.id("manage")) != null);
//	}
//	@Test

//	public void login() {
//		caliber.getUsername().sendKeys("calibot@revature.com");
//		caliber.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
//		caliber.getSubmitButton().click();
//		AssertJUnit.assertEquals(driver.getTitle(), "Caliber | Performance Management");
//	}
//	
//	@Test
//	public void invalidLogin() {
//		caliber.getUsername().sendKeys("calibot@revature.com");
//		caliber.getPassword().sendKeys("wrongpassword");
//		caliber.getSubmitButton().click();
//		AssertJUnit.assertTrue(driver.findElement(By.cssSelector("label[for='username']")).getText().equals("Username:"));
//	}
	
	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
