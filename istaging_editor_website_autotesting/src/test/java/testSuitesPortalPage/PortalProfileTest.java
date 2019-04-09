package testSuitesPortalPage;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

import pageObjects.PortalPageFactory;
import testSuitesLoginPage.AccountLoginTest;
import testSuitesLoginPage.LoginPageTest;

public class PortalProfileTest extends AccountLoginTest {
	
	@Test
	public void clickProfile() {
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		pf.clickProfile(driver);
		pf.clearCompany();
		pf.setCompanyName("Google");
		pf.clickSaveBtn();
	}



}
