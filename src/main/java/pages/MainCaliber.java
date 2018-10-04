package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainCaliber {

	public static WebDriver driver;
	
	public MainCaliber(WebDriver driver) {
		this.driver = driver;
	}
	
	//Login Elements
	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("pw")); 
	}
	
	public WebElement getSubmitButton() {
		return driver.findElement(By.cssSelector("input[value='Login']"));
	}
	
	//Navbar Elements
	
	public WebElement getHome() {
		return driver.findElement(By.cssSelector("a[href='#/vp/home']"));
	}

	public WebElement getManageBatch() {
		return driver.findElement(By.cssSelector("a[href='#/vp/manage']"));
	}
	
	public WebElement getAssessBatch() {
		return driver.findElement(By.cssSelector("a[href='#/vp/asses']"));
	}
	
	public WebElement getPanel() {
		return driver.findElement(By.cssSelector("a[href='#/vp/panel']"));
	}
	
	public WebElement getReports() {
		return driver.findElement(By.cssSelector("a[href='#/vp/reports']"));
	}
	
	public WebElement getSettings() {
		return driver.findElement(By.cssSelector("a[class='dropdown-toggle']"));
	}
	
	
	//Home Page Elements
	//Using xpath, might want to fix it
	public WebElement getHomePageHeader() {
		return driver.findElement(By.xpath("//*[@id='home']/div[1]/h1"));
	}
	
	public WebElement getQualityAuditStateVirginia() {
		return driver.findElement(By.xpath("//*[@id='home']/div[2]/div/div[1]/div/div/div[1]/select[2]/option[2]"));
	}
	
	public WebElement getQualityAuditStateFlorida() {
		return driver.findElement(By.xpath("//*[@id='home']/div[2]/div/div[1]/div/div/div[1]/select/option[3]"));
	}
	
	public WebElement getQualityAuditStateNewYork() {
		return driver.findElement(By.xpath("//*[@id='home']/div[2]/div/div[1]/div/div/div[1]/select[2]/option[4]"));
	}
	
	public WebElement getQualityAuditFirstRecord() {
		return driver.findElement(By.xpath("//*[@id='home']/div[2]/div/div[1]/div/div/div[2]/div[2]/table/tbody/tr[2]/th"));
	}
	
	
	public WebElement getWeeklyProgressSelector() {
		return driver.findElement(By.cssSelector("select[ng-model='selectedLineState']"));
	}
	
	public WebElement getWeeklyProgressStateVirginia() {
		return driver.findElement(By.xpath("//*[@id='home']/div[2]/div/div[2]/div/div/div[1]/select/option[2]"));
	}
	
	public WebElement getWeeklyProgressStateFlorida() {
		return driver.findElement(By.xpath("//*[@id='home']/div[2]/div/div[2]/div/div/div[1]/select[2]/option[4]"));
	}
	
	public WebElement getWeeklyProgressStateNewYork() {
		return driver.findElement(By.xpath("//*[@id='home']/div[2]/div/div[2]/div/div/div[1]/select[2]/option[3]"));
	}
	
	public WebElement getWeeklyProgressFirstRecord() {
		return driver.findElement(By.xpath("//*[@id='home']/div[2]/div/div[2]/div/div/div[2]/div[2]/table/tbody/tr[2]/th"));
	}
	
	
}
