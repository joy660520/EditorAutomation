package pageObjects;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class PanoramasPage {
	WebDriver driver;
	public static WebElement element = null;

	public static WebElement panoramas(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div[1]/ul/li[2]/a"));
		return element;
	}

	public static void selectPanoramasTab(WebDriver driver) {
		element = panoramas(driver);
		element.click();
	}

	public static WebElement addPanoramas(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='add-panoramas']/button"));
		return element;
	}

	public static void clickAddPanoramas(WebDriver driver) {
		element = addPanoramas(driver);
		element.click();
	}

	public static void importPhotos(WebDriver driver) {
//		File classpathRoot = new File(System.getProperty("user.dir"));
//	    File appDir = new File(classpathRoot, "panoramas");
//	    File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(sourceFile, new File(appDir, fileName));
		
		for (int index = 1; index <= 10; index++) {
			driver.findElement(By.id("Panoramas"))
					.sendKeys("/Users/joyshen/Documents/automation/automation" + index + ".jpg");
		}
	}

	public static void submitPhotos(WebDriver driver) {
		driver.findElement(By
				.xpath("//*[@id=\"app\"]/div[1]/div[3]/div[2]/div[2]/div/div[2]/div/div[2]/form/div[2]/div/div/button"))
				.click();
	}

}
