package week4.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class ServiceNow {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev60453.service-now.com/");
		driver.manage().window().maximize();
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
	}

}
