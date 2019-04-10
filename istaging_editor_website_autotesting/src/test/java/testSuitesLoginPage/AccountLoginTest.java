package testSuitesLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LoginPage;

public class AccountLoginTest extends LoginPageTest {
	
	@Test
	public void accountLoginTest() throws Exception {
        
		LoginPage.FillEmailTextBox(driver, "joy@staging.com.tw");
		test.log(LogStatus.INFO, "Enter User Name...");

		LoginPage.FillPasswordTextBox(driver, "000000");
		test.log(LogStatus.INFO, "Enter User Password...");

		LoginPage.clickLoginBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");

		Thread.sleep(3000);

		LoginPage.closeWelcome(driver);

		WebElement primaryBtn = null;

		try {
			primaryBtn = driver.findElement(By.xpath("//a/img[@class='profile-image']"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);
		getScreenshots();
		test.log(LogStatus.PASS, "Verified login successfully");

		Thread.sleep(3000);

	}
}
