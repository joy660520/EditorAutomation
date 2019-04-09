package testSuitesLoginPage;

import java.util.UUID;

import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class CreateAccountTest extends LoginPageTest {
	

	@Test
	public void createNewAccount() throws Exception {
		driver.get(baseUrl);
		LoginPage.clickAccountCreate(driver);
		LoginPage.emailInput(driver, "joy@staging.com.tw"); //可以輸入已存在帳號會顯示帳號已存在
		LoginPage.createPasswordInput(driver, "000000");
		LoginPage.confirmPasswordInput(driver, "000000");
		LoginPage.clickSubmit(driver);
	}

	 public static String getRandomString() throws InterruptedException {
	 String s = UUID.randomUUID().toString();
	 return s.toString();
	 }
}
