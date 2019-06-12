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
import testSuitesLoginPage.LoginPageTest;
import utilities.GenericMethods;

public class ImportPhotosTest extends LoginPageTest {
	
	@Test
	public void importPhotos() throws Exception {
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
		
		gm.getElement("buildingsCreateBuildingButton", "id").click();
		test.log(LogStatus.INFO, "Create New Building...");
		Thread.sleep(3000);

		gm.getElement("//input[@name='name']", "xpath").sendKeys("importPhotosTest");
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
	
		PanoramasPage.importPhotos(driver);
		test.log(LogStatus.INFO, "Choose Panoramas...");
		Thread.sleep(3000);
		
		PanoramasPage.submitPhotos(driver);
		test.log(LogStatus.INFO, "Import Panoramas...");
		Thread.sleep(30000);
		
		WebElement elementTR;
		try { //關閉panoramas頁面的導覽
			elementTR = gm.getElement("/html/body/div[6]/div", "xpath");
			gm.getElement("/html/body/div[6]/div/div[5]/a[1]", "xpath").click();
			test.log(LogStatus.INFO, "Close panoramas page tutorial...");
			Thread.sleep(2000);
		} catch (org.openqa.selenium.NoSuchElementException ee) {
			System.out.println("element doesn't exist");
		}
		
		WebElement primaryBtn = null;

		try {
			primaryBtn = driver.findElement(By.className("i-edit-list-container"));
		} catch (Exception e) {
			System.out.println(e);
		}
		Assert.assertTrue(primaryBtn != null);
		test.log(LogStatus.PASS, "Verified import panoramas successfully");

		Thread.sleep(3000);

	}
}