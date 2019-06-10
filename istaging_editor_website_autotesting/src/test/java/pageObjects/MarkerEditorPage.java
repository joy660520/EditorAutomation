package pageObjects;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MarkerEditorPage {
	
	private static String getHostname() {
		
		WebDriver driver;
		WebElement element = null;
		
        InetAddress ip;
        String hostname = "";
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
//            System.out.println("Your current IP address : " + ip);
//            System.out.println("Your current Hostname : " + hostname);
        } catch (UnknownHostException e) {
            e.printStackTrace();
          }
        return hostname;
    }

	public static void importIcos(WebDriver driver) {
        if(getHostname().equals("iMac.local")) {
        	for (int index = 1; index <= 10; index++) {
    			driver.findElement(By.id("MarkerEditorEditIcon"))
    					.sendKeys("/Users/mac-mini-slave/jenkins-k8s/workspace/istaging_editor_website_autotesting/istaging_editor_website_autotesting/icon/icon" + index + ".jpg");
    			}
        }else if(getHostname().equals("joy-MacBook-Pro.local")) {
        	for (int index = 1; index <= 10; index++) {
    			driver.findElement(By.id("MarkerEditorEditIcon"))
    					.sendKeys("/Users/joyshen/Documents/automation/icon/icon" + index + ".png");
    			}
        }

	}

	public static void submitIcons(WebDriver driver) {
		driver.findElement(By
				.xpath("//*[@id=\"app\"]/div[1]/div[3]/div[2]/div[3]/div/div/div[1]/div[2]/div/div[2]/div/div[2]/form/div[2]/div/div/button"))
				.click();
	}

}
