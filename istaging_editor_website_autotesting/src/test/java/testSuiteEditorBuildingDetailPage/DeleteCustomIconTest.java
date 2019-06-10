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
import utilities.GenericMethods;

public class DeleteCustomIconTest extends JsLoginPageTest {

	@Test
	public void deleteCustomIcons() throws Exception {
		GenericMethods gm = new GenericMethods(driver);

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

		gm.getElement("//a[@href='/buildings/65c59047-9e6e-4966-92b2-06fbd81bccf5/basic-info']", "xpath").click();
		test.log(LogStatus.INFO, "Select Building For Delete Custom Icon...");
		Thread.sleep(3000);

		PanoramasPage.selectMarkerEditorTab(driver);
		test.log(LogStatus.INFO, "Select Marker-Editor Tab...");
		Thread.sleep(3000);

		gm.getElement("//*[@id=\"markerEditorButtonsContainer\"]/ul/li[1]/button/span[1]", "xpath").click();
		test.log(LogStatus.INFO, "Click add New-Marker Btn...");
		Thread.sleep(5000);

		gm.getElement(
				"//*[@id=\"app\"]/div[1]/div[3]/div[2]/div[3]/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div/span[3]",
				"xpath").click();
		test.log(LogStatus.INFO, "Click add Custom-icon Btn...");
		Thread.sleep(3000);

		GenericMethods.deleteCustomIcon(driver);
		test.log(LogStatus.INFO, "Delete All Custom-icons...");
		Thread.sleep(3000);

		gm.getElement(
				"//*[@id=\"app\"]/div[1]/div[3]/div[2]/div[3]/div/div/div[1]/div[2]/div/div[2]/div/div[2]/form/div[2]/div/div/button",
				"xpath").click();
		test.log(LogStatus.INFO, "Confirm Delete Custom-icons...");
		Thread.sleep(3000);

		boolean result = gm.isCustomIconElementPresent(
				"//*[@id=\"app\"]/div[1]/div[3]/div[2]/div[3]/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/ul/li",
				"xpath");
		Assert.assertTrue(result);
		test.log(LogStatus.PASS, "Verified delete custom icons successfully");
		Thread.sleep(3000);

	}
}