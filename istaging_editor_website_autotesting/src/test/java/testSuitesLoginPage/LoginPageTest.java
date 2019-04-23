package testSuitesLoginPage;

import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import pageObjects.EditorPage;
import utilities.Screenshots;

public class LoginPageTest {
	protected WebDriver driver;
	protected String baseUrl;
	public EditorPage pf;
	protected static final Logger log = LogManager.getLogger(LoginPageTest.class.getName());
	public ExtentReports report;
	public ExtentTest test;
	ITestResult finalTestResult;
	

	@BeforeClass
	public void setUp() throws Exception {
		baseUrl = "https://portal.istaging.com/login";
		report = new ExtentReports("/Users/joyshen/Documents/autotestingReport/logintest.html");
		test = report.startTest("Verify if login successfully");
		

		System.setProperty("webdriver.chrome.driver", "/Users/joyshen/eclipse-workspace/Selenium/chromedriver");
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser started...");

		pf = new EditorPage();

		// driver.manage().window().maximize();
		// test.log(LogStatus.INFO, "Browser Maximized...");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web Application Opened...");
	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws Exception {
		this.finalTestResult = testResult;
	}

	@AfterClass
	public void tearDown() throws Exception {
		// Thread.sleep(1000);

		if (this.finalTestResult.getStatus() == ITestResult.FAILURE) {
			String path = (String) Screenshots.takeScreenshot(driver, finalTestResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verified login failed", imagePath);
		}

		driver.quit();
		report.endTest(test);
		report.flush();
	}

	public static String getRandomString() throws InterruptedException {
		String s = UUID.randomUUID().toString();
		return s.toString();
	}

	public void getScreenshots() throws Exception {
		String fileName = getRandomString() + ".png";
		String directory = "/Users/joyshen/Documents/autotesting screenshot";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sourceFile, new File(directory, fileName));
	}
}
