package testSuitesLoginPage;

import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class SelectLanguageTest extends LoginPageTest {

	@Test
	public void selectLanguage() throws Exception {
		driver.get(baseUrl);
		LoginPage.languageDropdownList(driver);
	}
}
