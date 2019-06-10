package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BuildingListPage {
	WebDriver driver;
	public static WebElement element = null;

	public static WebElement goToEditor(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='nav-link']//img[@class='vrcam-image']"));
		return element;
	}

	public static void clickGoToEditor(WebDriver driver) {
		element = goToEditor(driver);
		element.click();
	}

	public static WebElement createNewLivetour(WebDriver driver) {
		element = driver.findElement(By.id("buildingsCreateBuildingButton"));
		return element;
	}

	public static void clickCreateNewLivetour(WebDriver driver) {
		element = createNewLivetour(driver);
		element.click();
	}

	public static WebElement livetourNameField(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='name']"));
		return element;
	}

	public static void inputLivetourNameField(WebDriver driver, String name) {
		element = livetourNameField(driver);
		element.sendKeys(name);
	}

	public static WebElement submitBtn(WebDriver driver) {
		element = driver.findElement(By.cssSelector(
				"#app > main > div:nth-child(4) > div > div > div > form > div.row.row-mbl.full-width > div > div > button"));
		return element;
	}

	public static void clickSubmitBtn(WebDriver driver) {
		element = submitBtn(driver);
		element.click();
	}

	public static WebElement targetEmail(WebDriver driver) {
		element = driver.findElement(By.name("targetEmail"));
		return element;
	}

	public static void inputTargetEmail(WebDriver driver, String email) {
		element = targetEmail(driver);
		element.sendKeys(email);
	}

	public static WebElement submitCopyLivetour(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"app\"]/main/div[8]/div/div[2]/form/div[2]/div/div/button"));
		return element;
	}

	public static void clickSubmitCopyLivetour(WebDriver driver) {
		element = submitCopyLivetour(driver);
		element.click();
	}

	public static WebElement deleteLivetour(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//div[@class='modal-content-buttons']//button[contains(text(),'LiveTour')]"));
		return element;
	}

	public static void confirmDeleteLivetour(WebDriver driver) {
		element = deleteLivetour(driver);
		element.click();
	}

	public static void clickCopyLivetour(WebDriver driver) throws Exception {
		WebElement mouseHover = driver
				.findElement(By.xpath("//div[contains(@class,'i-list-title') and contains(text(),'sample')]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseHover).perform();
		WebElement copyLivetour = driver.findElement(By.xpath(
				"//div[contains(@class,'i-list-title') and contains(text(),'sample')]//parent::a//following-sibling::div[@class='i-list-hover']/div/ul/li[3]"));
		Thread.sleep(3000);
		action.moveToElement(copyLivetour).click().perform();
	}

	public static void clickDeleteLivetour(WebDriver driver) throws Exception {
		WebElement mouseHover = driver.findElement(By.xpath("//*[@id=\"buildingsList_2\"]/div[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(mouseHover).perform();
		WebElement copyLivetour = driver
				.findElement(By.xpath("//*[@id=\"buildingsList_2\"]/div[2]/div/ul/li[4]/button"));
		Thread.sleep(3000);
		action.moveToElement(copyLivetour).click().perform();
	}

	public static WebElement buildingForImportPhotos(WebDriver driver) {//for import photos
		element = driver
				.findElement(By.xpath("//a[@href='/buildings/60d5b6fe-24a0-4827-b92b-f31f13881e92/basic-info']"));
		return element;
	}

	public static void selectBuildingForImportPhotos(WebDriver driver) {
		element = buildingForImportPhotos(driver);
		element.click();
	}
	
	public static WebElement buildingForDeleteCustomIcon(WebDriver driver) {//for delete custom icon
		element = driver
				.findElement(By.xpath("//a[@href='/buildings/65c59047-9e6e-4966-92b2-06fbd81bccf5/basic-info']"));
		return element;
	}

	public static void selectBuildingForDeleteCustomIcon(WebDriver driver) {
		element = buildingForDeleteCustomIcon(driver);
		element.click();
	}

}
