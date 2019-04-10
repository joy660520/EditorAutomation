package testSuitesLoginPage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class GoogleLoginTest extends LoginPageTest{
	
	 @Test
		 public void googleLoginTest() throws Exception {
		 driver.get(baseUrl);
		// log.info("打開了應用程式");
		 LoginPage.clickGoogleBtn(driver);
		 Thread.sleep(2000);
		
		 }

}
