package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageCaliber {
	public static WebDriver driver;
	public ManageCaliber(WebDriver driver) {
		this.driver = driver;
	}
	// Main Manage page
	public WebElement getLastTableElement() {
//		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody")).findElement(By.cssSelector("tr:last-child"));
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child"));
	}
	// Delete batch modal
	public WebElement getDeleteBatchModal() {
		return driver.findElement(By.cssSelector("#deleteBatchModal"));
	}
	public WebElement getDeleteBatchDelButton() {
		return driver.findElement(By.cssSelector("#deleteBatchModal > div > div > div.modal-footer > input"));
	}
	public WebElement getDeleteBatchCancelButton() {
		return driver.findElement(By.cssSelector("#deleteBatchModal > div > div > div.modal-footer > button"));
	}
	// Last Row of Table
	public WebElement getDeleteBatchButton() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(13) > a"));
	}
	public WebElement getTrainingNameFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(1)"));
	}
	public WebElement getTrainingTypeFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(2)"));
	}
	public WebElement getSkillTypeFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(3)"));
	}
	public WebElement getTrainerFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(4)"));
	}
	public WebElement getCotrainerFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(5)"));
	}
	public WebElement getLocationFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(6)"));
	}
	public WebElement getStartDateFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(7)"));
	}
	public WebElement getEndDateFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(8)"));
	}
	public WebElement getGoodGradeFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(9)"));
	}
	public WebElement getPassingGradeFromLastRow() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(10)"));
	}
	// view batch trainees
	public WebElement getTraineeButton() {
		return driver.findElement(By.cssSelector("#manage > div:nth-child(2) > div > div > table > tbody > tr:last-child > td:nth-child(11) > a"));
	}
	public WebElement getTraineeModal() {
		return driver.findElement(By.cssSelector("#viewTraineeModal"));
	}
	// Create Batch
	public WebElement getCreateBatchLink() {
		return driver.findElement(By.cssSelector("li[data-target='#createBatchModal']"));
	}
	public WebElement getCreateBatchModal() {
		return driver.findElement(By.cssSelector("#createBatchModal"));
	}
	public WebElement getCreateBatchTrainingNameInput() {
		return driver.findElement(By.cssSelector("#trainingName"));
	}
	public WebElement getCreateBatchTrainingType() {
		return driver.findElement(By.cssSelector("#trainingType"));
	}
	public WebElement getCreateBatchTrainingTypeSelectRevature() {
		return driver.findElement(By.cssSelector("#trainingType > option:nth-child(2)"));
	}
	public WebElement getCreateBatchTrainingTypeSelectCoperate() {
		return driver.findElement(By.cssSelector("#trainingType > option:nth-child(3)"));
	}
	public WebElement getCreateBatchTrainingTypeSelectUniversity() {
		return driver.findElement(By.cssSelector("#trainingType > option:nth-child(4)"));
	}
	public WebElement getCreateBatchTrainingTypeSelectOther() {
		return driver.findElement(By.cssSelector("#trainingType > option:nth-child(5)"));
	}
	public WebElement getCreateBatchSkillType() {
		return driver.findElement(By.cssSelector("#skillType"));
	}
	public WebElement getCreateBatchSkillTypeSelect(int n) {
		String css = "#skillType > option:nth-child(" + n + ")";
		return driver.findElement(By.cssSelector(css));
	}
	public WebElement getCreateBatchLocation() {
		return driver.findElement(By.cssSelector("#location"));
	}
	public WebElement getCreateBatchLocationSelect() {
		return driver.findElement(By.cssSelector("#location > optgroup:nth-child(4) > option:nth-child(1)"));
	}
	public WebElement getCreateBatchTrainer() {
		return driver.findElement(By.cssSelector("#trainer"));
	}
	public WebElement getCreateBatchTrainerSelect() {
		return driver.findElement(By.cssSelector("#trainer > option:nth-child(2)"));
	}
	public WebElement getCreateBatchCoTrainer() {
		return driver.findElement(By.cssSelector("#co-trainer"));
	}
	public WebElement getCreateBatchCoTrainerSelect() {
		return driver.findElement(By.cssSelector("#co-trainer > option:nth-child(2)"));
	}
	public WebElement getCreateBatchStartDateInput() {
		return driver.findElement(By.cssSelector("#start-date > input"));
	}
	public WebElement getCreateBatchEndDateInput() {
		return driver.findElement(By.cssSelector("#end-date > input"));
	}
	public WebElement getCreateBatchGoodGradeInput() {
		return driver.findElement(By.cssSelector("#goodGrade"));
	}
	public WebElement getCreateBatchPassingGradeInput() {
		return driver.findElement(By.cssSelector("#borderlineGrade"));
	}
	public WebElement getCreateBatchSaveButton() {
		return driver.findElement(By.cssSelector("#createBatchModal > div > div > div.modal-footer > input"));
	}
	public WebElement getCreateBatchXClosedButton() {
		return driver.findElement(By.cssSelector("#createBatchModal > div > div > div.modal-header > button"));
	}
	public WebElement getCreateBatchClosedButton() {
		return driver.findElement(By.cssSelector("#createBatchModal > div > div > div.modal-footer > button"));
	}
	// Import Batch
	public WebElement getImportBatchLink() {
		return driver.findElement(By.cssSelector("li[data-target='#importBatchModal']"));
	}
	public WebElement getImportBatchModal() {
		return driver.findElement(By.cssSelector("#importBatchModal"));
	}
	public WebElement getImportBatchSelector() {
		return driver.findElement(By.cssSelector("#importId"));
	}
	public WebElement getImportBatchLastItem() {
		return driver.findElement(By.cssSelector("#importId > option:last-child"));
	}
	public WebElement getImportBatchForm() {
		return driver.findElement(By.cssSelector("#importBatchModal > div > div > div.modal-body > div.ng-scope"));
	}
	public WebElement getImportSelectLocation() {
		return driver.findElement(By.cssSelector("#location"));
	}
	public WebElement getImportSelectedLocation() {
		return driver.findElement(By.cssSelector("#location > optgroup:nth-child(2) > option"));
	}
	public WebElement getImportBatchTrainingName() {
		WebElement divthing = driver.findElement(By.cssSelector("#importBatchModal > div > div > div.modal-body > div.ng-scope > div:nth-child(1) > div:nth-child(1)"));
		return divthing.findElement(By.cssSelector("#name"));
//		return driver.findElement(By.xpath("//*[@id=\"name\"]"));
//		#importBatchModal > div > div > div.modal-body > div.ng-scope > div:nth-child(1) > div:nth-child(1) > label
	}
	public WebElement getImportBatchSubmitButton() {
		return driver.findElement(By.cssSelector("#importBatchModal > div > div > div.modal-footer > input"));
	}
	public WebElement getImportBatchCancelButton() {
		return driver.findElement(By.cssSelector("#importBatchModal > div > div > div.modal-footer > button"));
	}
}
