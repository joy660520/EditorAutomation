package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {//查找單一元素
	WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type) { // locator:定位路徑 type:定位方式
		type = type.toLowerCase();
		if(type.equals("id")) {
			System.out.println("find element by id"+locator);
			return this.driver.findElement(By.id(locator));
		}else if(type.equals("xpath")) {
			System.out.println("find element by xpath"+locator);
			return this.driver.findElement(By.xpath(locator));
		}else if(type.equals("class")) {
			System.out.println("find element by class"+locator);
			return this.driver.findElement(By.className(locator));
		}
		else {
			System.out.println("invalid locator");
		}

		return null;
	}
}
