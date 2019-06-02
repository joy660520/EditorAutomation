package testSuiteEditorBuildingListPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.BuildingListPage;
import pageObjects.LoginPage;
import testSuitesLoginPage.JsLoginPageTest;


public class DeleteLivetour extends JsLoginPageTest {
	
	@Test
	public void deleteLivetour() throws Exception { //還沒改

		LoginPage.FillEmailTextBox(driver, "joyautomation@staging.com.tw");
		test.log(LogStatus.INFO, "Enter User Name...");

		LoginPage.FillPasswordTextBox(driver, "000000");
		test.log(LogStatus.INFO, "Enter User Password...");

		LoginPage.clickLoginBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(3000);
		
		BuildingListPage.clickGoToEditor(driver);
		test.log(LogStatus.INFO, "Click GoToEditor Btn...");
		Thread.sleep(5000);
		
		js.executeScript("window.location='https://vreditor-test.istaging.com/buildings';");
		Thread.sleep(5000);
		
		BuildingListPage.clickDeleteLivetour(driver);
		test.log(LogStatus.INFO, "Click Delete Livetour...");
		Thread.sleep(2000);
		
		BuildingListPage.confirmDeleteLivetour(driver);
		test.log(LogStatus.INFO, "Confirm Delete Livetour...");
		Thread.sleep(2000);
		
		
		WebElement primaryBtn = null;

		try {
			primaryBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);
		getScreenshots();
		test.log(LogStatus.PASS, "Verified delete copy livetour successfully");

		Thread.sleep(3000);

	}
}
