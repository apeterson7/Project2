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
		return webEls.get(webEls.size()-3);
	}
	public WebElement selectQCNote() {
		return driver.findElement(By.xpath("//*[@id=\"Jason Steinberg\"]/a"));
	}
	public WebElement selectTechSkillsOptionMenu() {
		return driver.findElement(By.xpath("//*[@id=\"caliber-container\"]/div/div/div[2]/div[1]/div/div[1]/div"));
		
	}
	public int getTechSkillsTableHeadingCount() {
		WebElement headingRow = driver.findElement(By.xpath("//*[@id=\"caliber-container\"]/div/div/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[1]"));
		List<WebElement> webEls = headingRow.findElements(By.tagName("th"));
		return webEls.size();
	}
	public WebElement toggleFifthTraineeInChart() {
		return driver.findElement(By.xpath("//*[@id=\"insert-trainee\"]/div/div/div[2]/div/table/tbody/tr[5]/th/input"));
	}
	public WebElement closeNotesModal() {
		return driver.findElement(By.cssSelector("#notesModal > div > div > div.modal-footer > button"));
	}
	public WebElement closeModal() {
		return driver.findElement(By.xpath("//*[@id=\"insert-trainee\"]/div/div/div[1]/button"));
	}
	public WebElement getFirstNameInTable() {
		return driver.findElement(By.xpath("//*[@id=\"caliber-container\"]/div/div/div[1]/div[1]/div/div/div[2]/div/div/table/tbody/tr[1]/th"));
	}
	public WebElement getQCNotePopUpText() {
		return driver.findElement(By.xpath("//*[@id=\"notesModal\"]/div/div/div[2]"));
	}
	public WebElement getTechSkillsModal() {
		return driver.findElement(By.id("insert-trainee"));
	}
	public WebElement getYearDropdown() {
		return driver.findElement(By.xpath("html/body/div/ui-view/ui-view/div[1]/div/div/ul/li[1]"));
	}
	public WebElement selectYear() {
		WebElement webEl = getYearDropdown();
		List<WebElement> webEls = webEl.findElements(By.tagName("li"));
		System.out.println(webEls.size());
		return webEls.get(1);
	}
	public WebElement getDoughnut() {
		return driver.findElement(By.id("doughnut1"));
	}
	public WebElement getWeekDropdown() {
		return driver.findElement(By.xpath("html/body/div/ui-view/ui-view/div[1]/div/div/ul/li[3]"));
		}
	public WebElement selectWeek1() {
		WebElement weekDropdown = getWeekDropdown();
		return weekDropdown.findElements(By.tagName("li")).get(1);
	}
	
	public WebElement getLineChartCanvas() {
		return driver.findElement(By.cssSelector("canvas[class='chart chart-line ng-isolate-scope']"));
		}
	public WebElement getTraineeDropdown() {
		return driver.findElement(By.xpath("html/body/div/ui-view/ui-view/div[1]/div/div/ul/li[4]"));
	}
	public WebElement selectTrainee(int i) {
		return getTraineeDropdown().findElements(By.tagName("li")).get(i);
	}
}
