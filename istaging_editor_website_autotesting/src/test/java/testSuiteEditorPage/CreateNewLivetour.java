package testSuiteEditorPage;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.LoginPage;

import pageObjects.EditorPage;
import testSuitesLoginPage.AccountLoginTest;
import testSuitesLoginPage.LoginPageTest;

public class CreateNewLivetour extends LoginPageTest {
	

	@Test
	public void createNewLivetour() throws Exception {
		LoginPage.FillEmailTextBox(driver, "istagingga@gmail.com");
		test.log(LogStatus.INFO, "Enter User Name...");

		LoginPage.FillPasswordTextBox(driver, "000000");
		test.log(LogStatus.INFO, "Enter User Password...");

		LoginPage.clickLoginBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		EditorPage.clickGoToEditor(driver);
		test.log(LogStatus.INFO, "Click GoToEditor Btn...");
		Thread.sleep(5000);
		
		EditorPage.clickCreateNewLivetour(driver);
		test.log(LogStatus.INFO, "Click CreateNewLivetour Btn...");
		Thread.sleep(3000);
		
		EditorPage.inputLivetourNameField(driver, "JoyAutoTest");;
		test.log(LogStatus.INFO, "Input Livetour Name...");
		Thread.sleep(3000);
		
		EditorPage.clickSubmitBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(3000);
		
		WebElement primaryBtn = null;

		try {
			primaryBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[3]/div[2]/div[1]/div/div/form/div[1]/div[1]"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);
		getScreenshots();
		test.log(LogStatus.PASS, "Verified create new livetour successfully");

		Thread.sleep(3000);

	}

}
