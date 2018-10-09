package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageCaliber {
	public static WebDriver driver;
	public ManageCaliber(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getCreateBatchLink() {
		return driver.findElement(By.cssSelector("li[data-target='#createBatchModal']"));
	}
	public WebElement getCreateBatchModal() {
		return driver.findElement(By.cssSelector("#createBatchModal"));
	}
}
