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
import pageObjects.MarkerEditorPage;
import pageObjects.PanoramasPage;
import testSuitesLoginPage.JsLoginPageTest;
import testSuitesLoginPage.LoginPageTest;
import utilities.GenericMethods;

public class AddCustomIconTest extends LoginPageTest {

	@Test
	public void addCustomIcons() throws Exception {
		GenericMethods gm = new GenericMethods(driver);

		LoginPage.FillEmailTextBox(driver, "joyautomation@staging.com.tw");
		test.log(LogStatus.INFO, "Enter User Name...");

		LoginPage.FillPasswordTextBox(driver, "000000");
		test.log(LogStatus.INFO, "Enter User Password...");

		LoginPage.clickLoginBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(8000);

//		BuildingListPage.clickGoToEditor(driver);
//		test.log(LogStatus.INFO, "Click GoToEditor Btn...");
//		Thread.sleep(5000);

		

		gm.getElement("buildingsCreateBuildingButton", "id").click();
		test.log(LogStatus.INFO, "Create New Building...");
		Thread.sleep(3000);

		gm.getElement("//input[@name='name']", "xpath").sendKeys("customIconTest");
		test.log(LogStatus.INFO, "Input New Building Name...");
		Thread.sleep(3000);

		gm.getElement("//*[@id=\"app\"]/main/div[4]/div/div/div/form/div[2]/div/div/button", "xpath").click();
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(3000);

		gm.getElement("//*[@id=\"app\"]/div[1]/div[3]/div[1]/ul/li[2]/a", "xpath").click();
		test.log(LogStatus.INFO, "Select Panoramas Tab...");
		Thread.sleep(3000);
		
		gm.getElement("//div[@class='add-panoramas']/button", "xpath").click();
		test.log(LogStatus.INFO, "Click Add Panoramas Btn...");
		Thread.sleep(3000);
		
		PanoramasPage.importPhotosForAddCustomIcons(driver);
		PanoramasPage.submitPhotos(driver);
		test.log(LogStatus.INFO, "Import Panoramas...");
		Thread.sleep(20000);

		PanoramasPage.selectMarkerEditorTab(driver);
		test.log(LogStatus.INFO, "Select Marker-Editor Tab...");
		Thread.sleep(15000);

		WebElement elementTR;
		try { //關閉marker-editor頁面的導覽
			elementTR = gm.getElement("//div[@class='introjs-tooltipReferenceLayer']/div", "xpath");
			gm.getElement("//div[@class='introjs-tooltipbuttons']/a[1]", "xpath").click();
			test.log(LogStatus.INFO, "Close marker-editor page tutorial...");
			Thread.sleep(2000);
		} catch (org.openqa.selenium.NoSuchElementException ee) {
			System.out.println("element doesn't exist");
		}
		
		gm.getElement("//*[@id=\"markerEditorButtonsContainer\"]/ul/li[1]/button/span[1]", "xpath").click();
		test.log(LogStatus.INFO, "Click add New-Marker Btn...");
		Thread.sleep(10000);

		gm.getElement(
				
				"//*[@id=\"app\"]/div[1]/div[3]/div[2]/div[3]/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div/i",
				"xpath").click();
		test.log(LogStatus.INFO, "Click add Custom-icon Btn...");
		Thread.sleep(10000);

		MarkerEditorPage.importIcos(driver);
		test.log(LogStatus.INFO, "Select icons...");
		Thread.sleep(10000);

		MarkerEditorPage.submitIcons(driver);
		test.log(LogStatus.INFO, "Submit selected icons...");
		Thread.sleep(10000);

		boolean result = gm.isMarkerElementPresent(
				"//*[@id=\"app\"]/div[1]/div[3]/div[2]/div[3]/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/ul/li",
				"xpath");
		Assert.assertTrue(result);
		test.log(LogStatus.PASS, "Verified add custom icons successfully");
		Thread.sleep(3000);

	}
}