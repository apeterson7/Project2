package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReportsCaliber {
	
	public static WebDriver driver;
	
	public ReportsCaliber(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getDropdowns( ) {
		return driver.findElement(By.cssSelector("ul[class='nav nav-tabs']"));
	}
	
	public WebElement getBatchDropdown() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div/ul/li[2]"));
	}
	
	public WebElement selectBatchWithData() {
		WebElement webEl = getBatchDropdown();
		List<WebElement> webEls = webEl.findElements(By.tagName("li"));
		//System.out.println(webEls.size());
		return webEls.get(webEls.size()-2);
	}
	
	public WebElement getFirstNameInTable() {
		return driver.findElement(By.xpath("//*[@id=\"caliber-container\"]/div/div/div[1]/div[1]/div/div/div[2]/div/div/table/tbody/tr[1]/th"));
	}

}
