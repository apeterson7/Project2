package basicTest;

import org.testng.annotations.Test;

import pages.MainCaliber;
import pages.ReportsCaliber;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

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
import org.testng.annotations.BeforeMethod;

public class CaliberReports {
	public static ReportsCaliber caliber;
	public static WebDriver driver;
	public static MainCaliber mCaliber;
	public static WebDriverWait wait;

	@BeforeSuite
	public void setUpDriverAndPage() {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/reports");
		caliber = new ReportsCaliber(driver);
		mCaliber = new MainCaliber(driver);
		wait = new WebDriverWait(driver, 5);
		
		mCaliber.getUsername().sendKeys("calibot@revature.com");
		mCaliber.getPassword().sendKeys("*6Ak4-&kXnNTfTh6");
		mCaliber.getSubmitButton().click();
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/reports");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
//	@Parameters({"caliber"})
	public void goToMainPage() {
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/reports");
	}
	
	@Test(priority=1)
	public void getPageWithData() throws InterruptedException {
		String expectedName = "Dillon Pape";
		caliber.getYearDropdown().click();
		caliber.selectYear().click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		caliber.getBatchDropdown().click();
		caliber.selectBatchWithData().click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Assert.assertEquals(expectedName, caliber.getFirstNameInTable().getText()); 
	}
	
	@Test(priority=2)
	public void checkQCNotes() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		String expectedString = "linkedlist : various values point to each other singly vs doubly-linkedlist : not sure iterator : sort of linkedlist , go through each value of iterator iterator vs listIterator : no";
		WebElement note = wait.until(ExpectedConditions.visibilityOf(caliber.selectQCNote()));
		note.click();
		
//		Thread.sleep(3000);//probably there is some other way but was unable to find ANYTHING else that worked
		wait.until(ExpectedConditions.visibilityOf(caliber.getQCNotePopUpText()));
		Assert.assertEquals(caliber.getQCNotePopUpText().getText(), expectedString);
		caliber.closeNotesModal().click();
	}
	
	@Test(priority=2)
	public void techSkillsOptions() throws InterruptedException {
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		int precount = caliber.getTechSkillsTableHeadingCount();
		System.out.println("check 0");
		wait.until(ExpectedConditions.elementToBeClickable(caliber.selectTechSkillsOptionMenu())).click();;
		//caliber.selectTechSkillsOptionMenu().click();
		System.out.println("check 1");
		//Thread.sleep(1000);
		WebElement techModal = wait.until(ExpectedConditions.visibilityOf(caliber.getTechSkillsModal()));
		caliber.toggleFifthTraineeInChart().click();
		System.out.println("check 2");
		caliber.closeModal().click();
		Boolean e = wait.until(ExpectedConditions.invisibilityOf(caliber.getTechSkillsModal()));
		System.out.println("check 3");
		//Thread.sleep(1000);
		Assert.assertEquals(caliber.getTechSkillsTableHeadingCount(), (precount+1));
	}
	
	@Test(priority=3)
	public void selectByWeek() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(caliber.getDropdowns()));
		wait.until(ExpectedConditions.visibilityOf(caliber.getWeekDropdown())).click();
		wait.until(ExpectedConditions.visibilityOf(caliber.selectWeek1())).click();
		
		Assert.assertTrue(caliber.getDoughnut() != null);
	}
	@Test(priority=4)
	public void selectByWeekAndTrainee() throws InterruptedException {
		selectByWeek();
		wait.until(ExpectedConditions.visibilityOf(caliber.getTraineeDropdown())).click();
		int i =(int) (Math.random() * (caliber.getTraineeDropdown().findElements(By.tagName("li")).size()-1));
		//System.out.println(i);
		wait.until(ExpectedConditions.visibilityOf(caliber.selectTrainee(i+1))).click();
		//wait.until(ExpectedConditions.visibilityOf(caliber.getLineChartCanvas()));
		Assert.assertTrue(caliber.getLineChartCanvas() !=  null);
	}
	
	
	
	@AfterSuite
	public void cleanup() {
		driver.quit();
	}

}
