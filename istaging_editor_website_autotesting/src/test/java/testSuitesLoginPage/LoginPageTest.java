package testSuitesLoginPage;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.LoginPage;
import pageObjects.PortalPageFactory;

public class LoginPageTest {
	protected WebDriver driver;
	protected String baseUrl;
	public PortalPageFactory pf;
	protected static final Logger log = LogManager.getLogger(LoginPageTest.class.getName());

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/joyshen/eclipse-workspace/Selenium/chromedriver");

		driver = new ChromeDriver();
		baseUrl = "https://portal.istaging.com/login";
		pf = new PortalPageFactory(driver);
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		log.info("瀏覽器最大化");
	}

	public static String getRandomString() throws InterruptedException {
		String s = UUID.randomUUID().toString();
		return s.toString();
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		String fileName = getRandomString() + ".png";
		String directory = "/Users/joyshen/Documents/autotesting screenshot";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sourceFile, new File(directory, fileName));
		driver.quit();
	}
}
