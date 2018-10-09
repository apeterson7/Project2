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
	public WebElement getCreateBatchXClosedButton() {
		return driver.findElement(By.cssSelector("#createBatchModal > div > div > div.modal-header > button"));
	}
	public WebElement getCreateBatchClosedButton() {
		return driver.findElement(By.cssSelector("#createBatchModal > div > div > div.modal-footer > button"));
	}
	public WebElement getImportBatchLink() {
		return driver.findElement(By.cssSelector("li[data-target='#importBatchModal']"));
	}
	public WebElement getImportBatchModal() {
		return driver.findElement(By.cssSelector("#importBatchModal"));
	}
}
