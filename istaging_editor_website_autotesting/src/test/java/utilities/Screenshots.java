/**
 * 
 */
/**
 * @author joyshen
 *
 */
package utilities;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException, Exception {
//		fileName = getRandomString() + ".png"; // 亂數產生檔名
		fileName = fileName + ".png";
		String directory = "/Users/joyshen/Reports/screenshots/";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName)); // 依照測試名稱截圖
		String destination = directory + fileName; // 返回截圖所在目錄
		return destination;
	}

	public static String getRandomString() throws InterruptedException {
		Thread.sleep(2000);
		String s = UUID.randomUUID().toString();
		return s.toString();
	}
}
