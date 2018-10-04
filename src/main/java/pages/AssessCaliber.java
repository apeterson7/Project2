package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssessCaliber {

	public static WebDriver driver;

	public AssessCaliber(WebDriver driver) {
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

	//navigate to The Assess page element
	public WebElement getAssessBatch() {
		
		return driver.findElement(By.cssSelector("a[href='#/vp/assess'"));
	}
	
	//DropDown Elements
	public WebElement getYearDropDown() {
		return driver.findElement(By.linkText("2018"));
	}


}
