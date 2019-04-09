package testSuitesLoginPage;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class FacebookLoginTest extends LoginPageTest {
	@Test
	public void facebookLoginTest() throws Exception {
		driver.get(baseUrl);
		// log.info("打開了應用程式");
		LoginPage.clickFacebookBtn(driver);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
