package testSuitesLoginPage;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LoginPage;

public class CreateAccountTest extends LoginPageTest {
	

	@Test
	public void createNewAccount() throws Exception {
		
		LoginPage.clickAccountCreate(driver);
		test.log(LogStatus.INFO, "Click Create Btn...");
		
		LoginPage.emailInput(driver, "joytest01@staging.com.tw"); //可以輸入已存在帳號會顯示帳號已存在
		test.log(LogStatus.INFO, "Enter User Name...");
		
		LoginPage.createPasswordInput(driver, "000000");
		test.log(LogStatus.INFO, "Enter Create Password...");
		
		LoginPage.confirmPasswordInput(driver, "000000");
		test.log(LogStatus.INFO, "Enter Confirm Password...");
		
		LoginPage.clickSubmit(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		
		LoginPage.inputSingupName(driver, "Joy Shen");
		test.log(LogStatus.INFO, "Enter Signup Name...");
		
		LoginPage.clickOccupationBtn(driver);
		test.log(LogStatus.INFO, "Click Occupation Btn...");
		
		LoginPage.selectOccupation(driver);
		test.log(LogStatus.INFO, "Select Occupation...");
		
		LoginPage.clickCountryBtn(driver);
		test.log(LogStatus.INFO, "Click Country Btn...");
		
		LoginPage.selectCountry(driver);
		test.log(LogStatus.INFO, "Select Country...");
		
		LoginPage.clickRegisterBtn(driver);
		test.log(LogStatus.INFO, "Click Register Btn...");
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
		WebElement primaryBtn = null;

		try {
			primaryBtn = driver.findElement(By.xpath("//div[@class='text-xs-center']"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);
		getScreenshots();
		test.log(LogStatus.PASS, "Verified register successfully");

		Thread.sleep(3000);
	}

	 
}
