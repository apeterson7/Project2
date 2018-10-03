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
	

}
