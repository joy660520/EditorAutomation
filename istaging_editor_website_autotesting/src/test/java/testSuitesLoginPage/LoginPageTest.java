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

import pageObjects.BuildingListPage;
import utilities.ExtentFactory;
import utilities.Screenshots;

public class LoginPageTest {
	protected WebDriver driver;
	protected String baseUrl;
	public BuildingListPage pf;
	protected static final Logger log = LogManager.getLogger(LoginPageTest.class.getName());
	public ExtentReports report;
	public ExtentTest test;
	ITestResult finalTestResult;

	@BeforeClass
	public void setUp() throws Exception {
		baseUrl = "https://vrportal-test.istaging.com/login";
		report=ExtentFactory.getInstance();
		test = report.startTest("Regression Test");

		
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser started...");

		pf = new BuildingListPage();

//		driver.manage().window().maximize();
//		test.log(LogStatus.INFO, "Browser Maximized...");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web Application Opened...");
	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws Exception {
		this.finalTestResult = testResult;
		if (this.finalTestResult.getStatus() == ITestResult.FAILURE) {
			getScreenshots();
			
			//加在extentReport裡面的方法
//			String path = (String)Screenshots.takeScreenshot(driver, finalTestResult.getName());
//			String imagePath = test.addScreenCapture(path);
//			test.log(LogStatus.FAIL, "Verified login failed", imagePath);
		}

		driver.quit();
		report.endTest(test);
		report.flush();
	}

	// @AfterClass
	// public void tearDown() throws Exception {
	// // Thread.sleep(1000);
	//
	// if (this.finalTestResult.getStatus() == ITestResult.FAILURE) {
	// String path = (String) Screenshots.takeScreenshot(driver,
	// finalTestResult.getName());
	// String imagePath = test.addScreenCapture(path);
	// test.log(LogStatus.FAIL, "Verified login failed", imagePath);
	// }
	//
	// driver.quit();
	// report.endTest(test);
	// report.flush();
	// }

	public static String getRandomString() throws InterruptedException {
		String s = UUID.randomUUID().toString();
		return s.toString();
	}

	public void getScreenshots() throws Exception { 
		String fileName = getRandomString() + ".png";
		File classpathRoot = new File(System.getProperty("user.dir"));
	    File appDir = new File(classpathRoot, "screenshot");
//		String directory = "/Users/joyshen/Documents/autotesting screenshot";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sourceFile, new File(appDir, fileName));
	}
}
