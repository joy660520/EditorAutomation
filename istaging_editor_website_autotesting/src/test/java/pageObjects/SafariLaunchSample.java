package pageObjects;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

// 起safari
public class SafariLaunchSample {
	WebDriver driver2;
	String baseUrl2;

	@Before
	public void setUp() throws Exception {

		// System.setProperty("webdriver.safari.driver",
		// "/Users/joyshen/Library/Safari/Extensions"); 不用加這句
		System.setProperty("webdriver.safari.noinstall", "true"); // 永遠允許遠端自動化
		driver2 = new SafariDriver();
		baseUrl2 = "https://letskodeit.teachable.com/p/practice/";

		driver2.manage().window().maximize();
		driver2.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // 隱式等待，作用在所有元素上

	}

	@Test
	public void test() throws Exception {
		driver2.get(baseUrl2);
		driver2.findElement(By.id("openwindow")).sendKeys(Keys.COMMAND + "a"); //chrome的command+a有bug，上網查好像沒有還沒有解
		Thread.sleep(2000);
		////
		// driver2.findElement(By.id("openwindow")).sendKeys(Keys.chord(Keys.COMMAND,"a"));
		// Thread.sleep(2000);

		// String selectAll=Keys.chord(Keys.COMMAND,"a");
		// driver.findElement(By.id("openwindow")).sendKeys(selectAll);
		// Thread.sleep(2000);
		//
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver2.quit();

	}
}
