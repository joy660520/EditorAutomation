package testSuitesLoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.BasicInfoPage;
import pageObjects.LoginPage;

public class AccountLogoutTest extends LoginPageTest{
	@Test
	public void accountLoginTest() throws Exception {
        
		LoginPage.FillEmailTextBox(driver, "joyautomation@staging.com.tw");
		test.log(LogStatus.INFO, "Enter User Name...");

		LoginPage.FillPasswordTextBox(driver, "000000");
		test.log(LogStatus.INFO, "Enter User Password...");

		LoginPage.clickLoginBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");

		Thread.sleep(3000);

		LoginPage.closeWelcome(driver);
		
		BasicInfoPage.clickProfileImg(driver);
		test.log(LogStatus.INFO, "Click Profile Image...");
		Thread.sleep(3000);
		
		BasicInfoPage.clickLogout(driver);
		test.log(LogStatus.INFO, "Click Logout...");
		Thread.sleep(5000);
		
		WebElement primaryBtn = null;

		try {
			primaryBtn = driver.findElement(By.className("logo"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);
		getScreenshots();
		test.log(LogStatus.PASS, "Verified logout successfully");

		Thread.sleep(3000);

	}
}
