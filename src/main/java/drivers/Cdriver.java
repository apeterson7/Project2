package drivers;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.MainCaliber;

public class Cdriver {

	public static void main(String[] args) throws InterruptedException {
		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://dev-caliber.revature.tech/caliber/#/vp/reports");
		
		MainCaliber caliber = new MainCaliber(driver);
		caliber.getUsername().sendKeys("calibot@revature.com");
		caliber.getPassword().sendKeys("wrong");
		caliber.getSubmitButton().click();
		
		
		/*
		//web elements just HTML elements
		//There are a bunch fo ways to grab a web element
		
		//Grabbing an element by id
		WebElement deutsch = driver.findElement(By.id("js-link-box-de")); 
		
		WebElement italiano = driver.findElement(By.xpath("//*[@id=\"js-link-box-it\"]"));
		
		WebElement searchBar = driver.findElement(By.name("search"));
		
		//tag name
		//class name
		//link text
		
		//Grabbing CSS Selection
		WebElement espanol = driver.findElement(By.cssSelector("div[lang='es']"));
		
		//espanol.click();
		
		
		//deutsch.click();
		//italiano.click();
		searchBar.sendKeys("Hello Everyone");
		searchBar.sendKeys(Keys.ENTER);
		
		*/
		
		Thread.sleep(5000);
		
		//driver.close();
	}
}
