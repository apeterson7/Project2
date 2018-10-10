package basicTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
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
	WebDriverWait wait;
	

	@BeforeSuite
	public void setUpDriverAndPage() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/manage");
		caliber = new ManageCaliber(driver);
		mCaliber = new MainCaliber(driver);
		wait = new WebDriverWait(driver, 5);
		
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
	
	@Test(priority=1)
	public void clickCreateNewBatch() {
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		caliber.getCreateBatchLink().click();
		WebElement e = wait.until(ExpectedConditions.visibilityOf(caliber.getCreateBatchModal()));
		AssertJUnit.assertTrue(e != null);
	}
	@Test(priority=2)
	public void createNewBatchTrainingAllGoodInputs() {
		String trainingname = "testing";
		String startdate = "12122018";
		String startdateF = "Dec 12, 2018";
		String enddate = "12202018";
		String enddateF = "Dec 20, 2018";
		String goodgrade = "99";
		String passinggrade = "98";
		
		caliber.getCreateBatchTrainingNameInput().sendKeys(trainingname);
		
		caliber.getCreateBatchTrainingType().click();
		WebElement e = wait.until(ExpectedConditions.visibilityOf(caliber.getCreateBatchTrainingTypeSelectUniversity()));
		String trainingtype = e.getText();
		e.click();
		
		caliber.getCreateBatchSkillType().click();
		e = wait.until(ExpectedConditions.visibilityOf(caliber.getCreateBatchSkillTypeSelect(2)));
		String skilltype = e.getText();
		e.click();
		
		caliber.getCreateBatchLocation().click();
		String location = wait.until(ExpectedConditions.visibilityOf(caliber.getCreateBatchLocationSelect())).getText();
		caliber.getCreateBatchLocationSelect().click();
		
		caliber.getCreateBatchTrainer().click();
		String trainer = wait.until(ExpectedConditions.visibilityOf(caliber.getCreateBatchTrainerSelect())).getText();
		caliber.getCreateBatchTrainerSelect().click();
		
		caliber.getCreateBatchCoTrainer().click();
		String cotrainer = wait.until(ExpectedConditions.visibilityOf(caliber.getCreateBatchCoTrainerSelect())).getText();
		if(cotrainer.toLowerCase().equals("none")) cotrainer = "";
		caliber.getCreateBatchCoTrainerSelect().click();
		
		caliber.getCreateBatchStartDateInput().click();
		caliber.getCreateBatchStartDateInput().sendKeys(startdate);
		
		caliber.getCreateBatchEndDateInput().click();
		caliber.getCreateBatchEndDateInput().sendKeys(enddate);
		
		caliber.getCreateBatchGoodGradeInput().sendKeys(goodgrade);
		caliber.getCreateBatchPassingGradeInput().clear();
		caliber.getCreateBatchPassingGradeInput().sendKeys(passinggrade);
		caliber.getCreateBatchSaveButton().click();
		AssertJUnit.assertTrue(wait.until(ExpectedConditions.invisibilityOf(caliber.getCreateBatchModal())));
		AssertJUnit.assertEquals(trainingname, caliber.getTrainingNameFromLastRow().getText());
		AssertJUnit.assertEquals(trainingtype, caliber.getTrainingTypeFromLastRow().getText());
		AssertJUnit.assertEquals(skilltype, caliber.getSkillTypeFromLastRow().getText());
//		AssertJUnit.assertEquals(location, caliber.getLocationFromLastRow().getText());
		AssertJUnit.assertEquals(trainer, caliber.getTrainerFromLastRow().getText());
		AssertJUnit.assertEquals(cotrainer, caliber.getCotrainerFromLastRow().getText());
		AssertJUnit.assertEquals(startdateF, caliber.getStartDateFromLastRow().getText());
		AssertJUnit.assertEquals(enddateF, caliber.getEndDateFromLastRow().getText());
		AssertJUnit.assertEquals(goodgrade, caliber.getGoodGradeFromLastRow().getText());
		AssertJUnit.assertEquals(passinggrade, caliber.getPassingGradeFromLastRow().getText());
	} //#manage > div:nth-child(2) > div > div > table > tbody > tr:nth-child(75) > td:nth-child(1)
	@Test(priority=4)
	public void closeCreateNewBatch() {
		caliber.getCreateBatchLink().click();
		wait.until(ExpectedConditions.visibilityOf(caliber.getCreateBatchModal()));
		caliber.getCreateBatchClosedButton().click();
		boolean invisibility = wait.until(ExpectedConditions.invisibilityOf(caliber.getCreateBatchModal()));
		AssertJUnit.assertTrue(invisibility);
	}
	@Test(priority=3) 
	public void closeCreateNewBatchX() {
		caliber.getCreateBatchLink().click();
		WebElement e = wait.until(ExpectedConditions.visibilityOf(caliber.getCreateBatchModal()));
		AssertJUnit.assertTrue(e != null);
		caliber.getCreateBatchXClosedButton().click();
		boolean invisibility = wait.until(ExpectedConditions.invisibilityOf(caliber.getCreateBatchXClosedButton()));
		AssertJUnit.assertTrue(invisibility);
	}
	@Test(enabled=false)
	public void clickImportNewBatch() {
		caliber.getImportBatchLink().click();
		WebElement e = wait.until(ExpectedConditions.visibilityOf(caliber.getImportBatchModal()));
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
