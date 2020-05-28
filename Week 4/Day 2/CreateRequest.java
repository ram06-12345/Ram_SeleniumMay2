package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateRequest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev60453.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		driver.findElementById("filter").sendKeys("Change");
		driver.findElementByXPath("(//div[text()='All'])[4]").click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//button[text()='New']").click();
		driver.findElementByXPath("//a[contains(text(),'Normal')]").click();
		String reqNumber = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println(reqNumber);
		driver.findElementById("change_request.short_description").sendKeys("short Description");
		driver.findElementById("sysverb_insert_bottom").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[contains(text(),'Press Enter')]/following-sibling::input").sendKeys(reqNumber,Keys.ENTER);
		String getNumber = driver.findElementByXPath("//tbody[@class='list2_body']//td[3]/a").getText();
		System.out.println(getNumber);
		if(reqNumber.equals(getNumber))
			System.out.println("Request number is displayed");
		else
			System.out.println("Request number is not created");
		driver.close();
		
	}

}
