package testSuitesLoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LoginPage;
import pageObjects.BuildingListPage;
import utilities.Screenshots;

public class FacebookLoginTest extends LoginPageTest{

	
	@Test
	public void facebookLoginTest() throws Exception {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// log.info("打開了應用程式");
		LoginPage.clickFacebookBtn(driver);
		test.log(LogStatus.INFO, "Click Facebook Btn...");
		
//        Thread.sleep(2000);
        
        LoginPage.closeWelcome(driver);
        test.log(LogStatus.INFO, "Close Welcome Msg...");

        WebElement primaryBtn = null;

		try {
			primaryBtn = driver.findElement(By.xpath("//a/img[@class='profile-image']"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);
		getScreenshots();
		test.log(LogStatus.PASS, "Verified login by facebook successfully");

		Thread.sleep(3000);
		
	}


}