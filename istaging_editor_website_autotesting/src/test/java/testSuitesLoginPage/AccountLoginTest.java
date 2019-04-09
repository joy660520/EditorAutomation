package testSuitesLoginPage;

import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class AccountLoginTest extends LoginPageTest {
	@Test
	public void accountLoginTest() throws Exception {
		driver.get(baseUrl);
		log.info("打開了應用程式");
		LoginPage.FillEmailTextBox(driver, "joy@staging.com.tw"); //可以輸入錯誤帳號會顯示帳號錯誤
		LoginPage.FillPasswordTextBox(driver, "000000"); //可以輸入錯誤密碼會顯示密碼錯誤
		LoginPage.clickLoginBtn(driver);
		Thread.sleep(6000);

	}
}
