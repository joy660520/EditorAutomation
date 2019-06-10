/**
 * 
 */
/**
 * @author joyshen
 *
 */
package testSuiteEditorBuildingDetailPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.BuildingListPage;
import pageObjects.LoginPage;
import pageObjects.PanoramasPage;
import testSuitesLoginPage.JsLoginPageTest;

public class ImportPhotosTest extends JsLoginPageTest {
	
	@Test
	public void importPhotos() throws Exception {

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
		
		BuildingListPage.selectBuildingForImportPhotos(driver);;
		test.log(LogStatus.INFO, "Enter Building Detail Page...");
		Thread.sleep(3000);
		
		PanoramasPage.selectPanoramasTab(driver);
		test.log(LogStatus.INFO, "Select Panoramas Tab...");
		Thread.sleep(3000);
		
		PanoramasPage.clickAddPanoramas(driver);
		test.log(LogStatus.INFO, "Click Add Panoramas Btn...");
		Thread.sleep(3000);
	
		PanoramasPage.importPhotos(driver);
		test.log(LogStatus.INFO, "Choose Panoramas...");
		Thread.sleep(3000);
		
		PanoramasPage.submitPhotos(driver);
		test.log(LogStatus.INFO, "Import Panoramas...");
		Thread.sleep(10000);
		
		WebElement primaryBtn = null;

		try {
			primaryBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);
		test.log(LogStatus.PASS, "Verified import livetour successfully");

		Thread.sleep(3000);

	}
}