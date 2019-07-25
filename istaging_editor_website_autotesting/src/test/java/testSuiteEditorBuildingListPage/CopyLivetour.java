package testSuiteEditorBuildingListPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.BuildingListPage;
import pageObjects.LoginPage;
import testSuitesLoginPage.JsLoginPageTest;

public class CopyLivetour extends JsLoginPageTest {

	@Test
	public void copyLivetour() throws Exception {

		LoginPage.FillEmailTextBox(driver, "joyautomation@staging.com.tw");
		test.log(LogStatus.INFO, "Enter User Name...");

		LoginPage.FillPasswordTextBox(driver, "000000");
		test.log(LogStatus.INFO, "Enter User Password...");

		LoginPage.clickLoginBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(5000);

		WebElement elementTR;
		try {
			elementTR = gm.getElement("//*[@id=\"app\"]/section/div[2]/div/div", "xpath");
			gm.getElement("//*[@id=\"app\"]/section/div[2]/div/div/button", "xpath").click();
			Thread.sleep(2000);
			gm.getElement("/html/body/div[4]/div/div[5]/a[1]", "xpath").click();
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Close buildings page tutorial...");
			BuildingListPage.clickCreateNewLivetour(driver);
			test.log(LogStatus.INFO, "Click CreateNewLivetour Btn...");
			Thread.sleep(3000);
		} catch (java.lang.NullPointerException ee) {
			System.out.println("element doesn't exist");
		}
		Thread.sleep(5000);
		

		js.executeScript("window.location='https://vreditor-test.istaging.com/buildings';");
		Thread.sleep(5000);

		js.executeScript("window.scrollBy(0,3500);");

		BuildingListPage.clickCopyLivetour(driver);
		test.log(LogStatus.INFO, "Click Copy Livetour...");
		Thread.sleep(2000);

		BuildingListPage.inputTargetEmail(driver, "joymls");
		test.log(LogStatus.INFO, "Input Email Address...");

		BuildingListPage.clickSubmitCopyLivetour(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(1000);

		WebElement primaryBtn = null;

		try {
			primaryBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);
		getScreenshots();
		test.log(LogStatus.PASS, "Verified copy livetour successfully");

		Thread.sleep(3000);

	}
}
