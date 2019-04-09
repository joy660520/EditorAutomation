package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortalPageFactory {
	WebDriver driver;
	@FindBy(xpath = "//a[contains(text(),'個人資訊')]")
	WebElement profile;

	@FindBy(xpath = "//a[contains(text(),'更改密碼')]")
	WebElement changePassword;

	@FindBy(xpath = "//a[contains(text(),'使用者')]")
	WebElement users;

	@FindBy(xpath = "//a[contains(text(),'操作記錄')]")
	WebElement myActivity;

	@FindBy(xpath = "//a[contains(text(),'方案')]")
	WebElement plan;

	@FindBy(xpath = "//a[contains(text(),'帳單')]")
	WebElement billingInformation;

	@FindBy(xpath = "//a[contains(text(),'我的LiveTours')]")
	WebElement myLivetours;

	@FindBy(xpath = "//a[@href='javascript:;']")
	WebElement vrEditor;

	@FindBy(xpath = "//a/img[@src='https://vrcam-prod-cdn.istaging.com/58c2447f77bd140050178be0/profileImage']")
	WebElement profileImage;

	@FindBy(xpath = "//select[@class='form-control']")
	WebElement selectLanguage;

	@FindBy(xpath = "//input[@name='companyDisplayName']")
	WebElement company;
	
	@FindBy(xpath = "//a[@href='/forget-password']")
	WebElement forgetpassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	
	public void clickForgetPassword(WebDriver driver) {
		forgetpassword.click();
	}

	public PortalPageFactory(WebDriver driver) { // 這個類的對象需要帶著driver(從外部傳進來的driver)這個參數來初始化對象
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickProfile(WebDriver driver) {
		profile.click();
	}

	public void clearCompany() {
		company.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END));
	}
	
	public void setCompanyName(String companyname) {
//		company.sendKeys(Keys.HOME,Keys.chord(Keys.SHIFT,Keys.END),companyname);   //清除文本框內的字串
		company.sendKeys(companyname);
	}

	public void clickChangePassword() {
		changePassword.click();
	}

	public void clickSaveBtn() {
		save.click();
	}
}
