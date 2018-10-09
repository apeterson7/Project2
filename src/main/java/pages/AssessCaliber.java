package pages;

import java.util.List;
import java.util.NoSuchElementException;

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

	public WebElement getBatchDropdown() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div/ul/li[2]"));
	}
	
	public WebElement selectBatchWithData() {
		WebElement webEl = getBatchDropdown();
		List<WebElement> webEls = webEl.findElements(By.tagName("li"));
		return webEls.get(webEls.size()-2);
	}
	
	public WebElement getFirstNameInTable() {
		return driver.findElement(By.xpath("//*[@id=\"trainer-assess-table\"]/div/div/ul/ul/table/tbody/tr[1]"));
	}
	
	public WebElement getYearDropdown() {
		return driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div/ul/li[2]"));
	}
	
	public WebElement selectYearWithData() {
		WebElement webEl = getYearDropdown();
		List<WebElement> webEls = webEl.findElements(By.tagName("li"));
		return webEls.get(webEls.size()-1);
	}
	
	public boolean isOnAssess() {
		try {
			driver.findElement(By.id("trainer-assess-table"));
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	public void openAssignmentWindow() {
		driver.findElement(By.xpath("/html/body/div/ui-view/ui-view/div[1]/div/div[2]/ul[1]/li[4]/a")).click();
		
	}
	
	public String getWindowStyle() {
		return driver.findElement(By.id("createAssessmentModal")).getAttribute("style");
	}
	
	public void clickX() {
		driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/div/button/span")).click();
		
	}
	public void clickClose() {
		driver.findElement(By.xpath("//*[@id=\"createAssessmentModal\"]/div/div/form/div[2]/button")).click();
		
	}
}

