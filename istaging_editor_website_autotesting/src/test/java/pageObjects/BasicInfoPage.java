package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicInfoPage {
	WebDriver driver;
	public static WebElement element = null;

	public static void clickProfileImg(WebDriver driver) {
		driver.findElement(By.xpath("//a[@class='dropdown-control']//img[@class='profile-image']")).click();
	}
	
	public static void clickLogout(WebDriver driver) {
		driver.findElement(By.xpath("//a[@class='dropdown-item']//parent::div[@class='dropdown-footer-container']")).click();
	}
	
	
	
	
	
}
