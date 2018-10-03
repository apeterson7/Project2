package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainCaliber {

	public static WebDriver driver;
	
	public MainCaliber(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return driver.findElement(By.name("pw")); 
	}
	
	public WebElement getSubmitButton() {
		return driver.findElement(By.cssSelector("input[value='Login']"));
	}
	
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
}
