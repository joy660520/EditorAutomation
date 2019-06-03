package testSuiteEditorBuildingListPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageObjects.BuildingListPage;
import pageObjects.LoginPage;
import testSuitesLoginPage.JsLoginPageTest;
import utilities.GenericMethods;

public class SearchBuilding extends JsLoginPageTest {

	@Test
	public void searchLivetour() throws Exception {
		gm = new GenericMethods(driver);

		LoginPage.FillEmailTextBox(driver, "joyautomation@staging.com.tw");
		test.log(LogStatus.INFO, "Enter User Name...");

		LoginPage.FillPasswordTextBox(driver, "000000");
		test.log(LogStatus.INFO, "Enter User Password...");

		LoginPage.clickLoginBtn(driver);
		test.log(LogStatus.INFO, "Click Submit Btn...");
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		BuildingListPage.clickGoToEditor(driver);
		test.log(LogStatus.INFO, "Click GoToEditor Btn...");
		Thread.sleep(5000);

		WebElement element = gm.getElement("//*[@id=\"app\"]/main/div[2]/div[1]/div/div/div[2]/button", "xpath");
		element.click();
		Thread.sleep(3000);

		WebElement element2 = gm.getElement("i-search", "id");
		element2.sendKeys("sample");
		Thread.sleep(5000);

		List<WebElement> buildings = driver.findElements(By.className("i-list-title")); //建立集合的容器
		int size = buildings.size(); //取到集合的大小
		for (int i = 0; i < size; i++) { //遍歷集合
			String buildingsText = buildings.get(i).getText(); //接收取到的選項文本
			System.out.println(buildingsText);
		}
		Thread.sleep(5000);

	}
}
