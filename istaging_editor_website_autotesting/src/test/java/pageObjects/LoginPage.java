package pageObjects;

import java.io.File;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	public static WebElement element = null;

	// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
	// 一般帳號登入
	/*
	 * email文本框元素 param driver return
	 */
	public static WebElement emailTextBox(WebDriver driver) {
		element = driver.findElement(By.name("email"));
		return element;
	}

	public static void FillEmailTextBox(WebDriver driver, String email) {
		element = emailTextBox(driver);
		element.sendKeys(email);

	}

	/*
	 * password文本框元素 param driver return
	 */
	public static WebElement passwordTextBox(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}

	public static void FillPasswordTextBox(WebDriver driver, String password) {
		element = passwordTextBox(driver);
		element.sendKeys(password);
	}

	/*
	 * loging btn文本框元素 param driver return
	 */
	public static WebElement loginBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@type='submit']"));
		return element;
	}

	/*
	 * 點擊登入 param driver
	 */
	public static void clickLoginBtn(WebDriver driver) {
		element = loginBtn(driver);
		element.click();
	}

	/*
	 * 關閉alert param driver
	 */
	public static WebElement welcome(WebDriver driver) {
		element = driver.findElement(By.cssSelector(".i-alert-close"));
		return element;
	}

	public static void closeWelcome(WebDriver driver) {
		element = welcome(driver);
		element.click();
	}

	// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
	/*
	 * 創建帳號元素 帳號已存在 密碼格式錯誤
	 */

	public static WebElement accountCreate(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/signup']"));
		return element;
	}

	public static void clickAccountCreate(WebDriver driver) {
		element = accountCreate(driver);
		element.click();
	}

	public static WebElement createEmail(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		element = driver.findElement(By.xpath("//input[@name='email']"));
		return element;
	}

	public static void createEmailInput(WebDriver driver, String email) throws Exception {
		element = createEmail(driver);
		element.sendKeys(email);
	}

	public static WebElement createPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='password']"));
		return element;
	}

	public static void createPasswordInput(WebDriver driver, String password) throws Exception {
		element = createPassword(driver);
		element.sendKeys(password);
	}

	public static WebElement confirmPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		return element;
	}

	public static void confirmPasswordInput(WebDriver driver, String password) throws Exception {
		element = confirmPassword(driver);
		element.sendKeys(password);
	}

	public static WebElement submitbtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary']"));
		return element;
	}

	public static void clickubmitbtn(WebDriver driver) {
		element = submitbtn(driver);
		element.click();
	}

	public static WebElement signupName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='name']"));
		return element;
	}

	public static void inputSingupName(WebDriver driver, String name) throws Exception {
		element = signupName(driver);
		element.sendKeys(name);
	}

	public static WebElement occupationBtn(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/form/form[2]/div[2]/div[1]/select"));
		return element;
	}

	public static void clickOccupationBtn(WebDriver driver) throws Exception {
		element = occupationBtn(driver);
		element.click();
	}

	public static WebElement occupation(WebDriver driver) {
		element = driver.findElement(By.cssSelector("div option[value='4']"));
		return element;
	}

	public static void selectOccupation(WebDriver driver) throws Exception {
		element = occupation(driver);
		element.click();
	}

	public static WebElement countryBtn(WebDriver driver) {
		element = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/form/form[2]/div[3]/div[1]/select"));
		return element;
	}

	public static void clickCountryBtn(WebDriver driver) throws Exception {
		element = countryBtn(driver);
		element.click();
	}

	public static WebElement country(WebDriver driver) {
		element = driver.findElement(By.cssSelector("div option[value='TW']"));
		return element;
	}

	public static void selectCountry(WebDriver driver) throws Exception {
		element = country(driver);
		element.click();
	}

	public static WebElement registerBtn(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@type='submit']"));
		return element;
	}

	public static void clickRegisterBtn(WebDriver driver) throws Exception {
		element = registerBtn(driver);
		element.click();
	}

	// ================================================================================================
	// 截圖功能

	public static String getRandomString() throws InterruptedException {
		Thread.sleep(2000);
		String s = UUID.randomUUID().toString();
		return s.toString();
	}

	// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

	/*
	 * 忘記密碼元素 param driver return
	 */
	public static WebElement forgetPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/forget-password']"));
		return element;
	}

	// 點擊忘記密碼
	public static void clickForgetPassword(WebDriver driver) {
		element = forgetPassword(driver);
		element.click();
	}

	// 查找輸入email文本框元素
	public static WebElement email(WebDriver driver) {
		element = driver.findElement(By.name("email"));
		return element;
	}

	// 輸入email到文本框
	public static void emailInput(WebDriver driver, String email) throws InterruptedException {
		Thread.sleep(5000);
		element = email(driver);
		element.sendKeys(email);
	}

	// submit元素
	public static WebElement submit(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@type='submit']"));
		return element;
	}

	// click submit
	public static void clickSubmit(WebDriver driver) {
		element = submit(driver);
		element.click();
	}

	// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

	/*
	 * FB登入文本框元素 param driver return
	 */
	public static WebElement fbLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='social-icon icon-facebook']"));
		return element;
	}

	/*
	 * FB登入 param driver
	 */
	public static void clickFacebookBtn(WebDriver driver) throws InterruptedException {
		String parentHandle = driver.getWindowHandle();
		element = fbLogin(driver);
		element.click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
				inputEmail.sendKeys("joy660520@gmail.com");
				WebElement inputPassword = driver.findElement(By.xpath("//input[@id='pass']"));
				inputPassword.sendKeys("bills0629");
				WebElement loginBtn = driver.findElement(By.id("loginbutton"));
				loginBtn.click();
				Thread.sleep(5000);
				break;

			}
                
		}
		driver.switchTo().window(parentHandle);
	}

	// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

	/*
	 * Google登入文本框元素 param driver return
	 */
	public static WebElement googleLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='social-icon icon-google']"));
		return element;
	}

	/*
	 * Google登入 param driver
	 */
	public static <IJavaScriptExecutor> void clickGoogleBtn(WebDriver driver) throws InterruptedException {
		String parentHandle = driver.getWindowHandle();
		element = googleLogin(driver);
		element.click();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				WebElement inputEmail = driver.findElement(By.xpath("//input[@id='identifierId']"));
				inputEmail.sendKeys("istaginggl@gmail.com");
				WebElement next = driver.findElement(By.xpath("//div[@id='identifierNext']"));
				next.click();

				WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
				inputPassword.sendKeys("qwerty65432");

				Thread.sleep(5000);
				WebElement passwordNext = driver.findElement(By.xpath("//div[@id='passwordNext']"));
				passwordNext.click();
				Actions actions = new Actions(driver);
				actions.moveToElement(passwordNext).click().perform();

				Thread.sleep(5000);
				break;
			}

		}
	}

	// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
	/*
	 * 切換多國語系
	 */
	public static void languageDropdownList(WebDriver driver) throws Exception {

		WebElement element = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select sel = new Select(element);

		Thread.sleep(2000);
		sel.selectByValue("en");
		// Thread.sleep(3000);
		// sel.deselectByValue("en");

		Thread.sleep(2000);
		sel.selectByValue("zh-tw");
		// Thread.sleep(3000);
		// sel.deselectByValue("zh-tw");

		Thread.sleep(2000);
		sel.selectByValue("zh-cn");
		// Thread.sleep(3000);
		// sel.deselectByValue("zh-cn");

		Thread.sleep(2000);
		sel.selectByValue("ja");
		// Thread.sleep(3000);
		// sel.deselectByValue("ja");

		Thread.sleep(2000);
		sel.selectByValue("fr");
		// Thread.sleep(3000);
		// sel.deselectByValue("fr");

		Thread.sleep(2000);
		sel.selectByValue("de");
		// Thread.sleep(3000);
		// sel.deselectByValue("de");

		Thread.sleep(2000);
		sel.selectByValue("nl");
		// Thread.sleep(3000);
		// sel.deselectByValue("nl");

		Thread.sleep(2000);
		sel.selectByValue("ar");
		// Thread.sleep(3000);
		// sel.deselectByValue("ar");

	}

	// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

	/*
	 * 關閉歡迎提示 param driver public void closeWelcomeNote(WebDriver driver) {
	 * element=driver.findElement(By.....) element.click();
	 */

	// ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

}
