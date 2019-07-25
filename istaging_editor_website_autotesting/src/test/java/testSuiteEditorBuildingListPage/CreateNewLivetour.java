package testSuiteEditorBuildingListPage;

import java.util.List;
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

import pageObjects.BuildingListPage;
import testSuitesLoginPage.AccountLoginTest;
import testSuitesLoginPage.JsLoginPageTest;
import testSuitesLoginPage.LoginPageTest;

import utilities.GenericMethods;

public class CreateNewLivetour extends LoginPageTest {

	@Test
	public void createNewLivetour() throws Exception {
		GenericMethods gm = new GenericMethods(driver);

		LoginPage.FillEmailTextBox(driver, "joyautomation@staging.com.tw");
		test.log(LogStatus.INFO, "Enter User Name...");

		LoginPage.FillPasswordTextBox(driver, "000000");
		test.log(LogStatus.INFO, "Enter User Password...");

		LoginPage.clickLoginBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(10000);

		WebElement elementTR = gm.getElement("//*[@id=\"app\"]/section/div[2]/div/div", "xpath");
		Thread.sleep(5000);
		if (elementTR.isDisplayed()) { //關閉buildings頁面的導覽
			gm.getElement("//*[@id=\"app\"]/section/div[2]/div/div/button", "xpath").click();
			Thread.sleep(2000);
			gm.getElement("/html/body/div[4]/div/div[5]/a[1]", "xpath").click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Close buildings page tutorial...");
			BuildingListPage.clickCreateNewLivetour(driver);
			test.log(LogStatus.INFO, "Click CreateNewLivetour Btn...");
			Thread.sleep(3000);

		} else {
			System.out.println(elementTR);
			BuildingListPage.clickCreateNewLivetour(driver);
			test.log(LogStatus.INFO, "Click CreateNewLivetour Btn...");
		}

		Thread.sleep(3000);

		BuildingListPage.inputLivetourNameField(driver, "JoyAutoTest");
		test.log(LogStatus.INFO, "Input Livetour Name...");
		Thread.sleep(3000);

		BuildingListPage.clickSubmitBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(8000);

		
		WebElement elementTR2;
		try { //關閉basic-info頁面的導覽
			elementTR2 = gm.getElement("//div[@class='introjs-tooltiptext']", "xpath");
			gm.getElement("//div[@class='introjs-tooltipbuttons']", "xpath").click();
			test.log(LogStatus.INFO, "Close basic-info page tutorial...");
			Thread.sleep(2000);
//			gm.getElement("//*[@id=\"app\"]/div[1]/div[2]/div/div[1]/a/span[2]", "xpath").click();
//			Thread.sleep(2000); 
		} catch (org.openqa.selenium.NoSuchElementException ee) {
			System.out.println("element doesn't exist");
//			gm.getElement("//*[@id=\"app\"]/div[1]/div[2]/div/div[1]/a/span[2]", "xpath").click();
//			Thread.sleep(2000);
		}
		
		gm.getElement("//*[@id=\"app\"]/div[1]/div[2]/div/div[1]/a/span[2]", "xpath").click();
		Thread.sleep(2000); 

		WebElement primaryBtn = null;
		try {
			primaryBtn = driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/ul/li[3]/a/img"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);

		test.log(LogStatus.PASS, "Verified create new livetour successfully");

		Thread.sleep(3000);
	}

}
