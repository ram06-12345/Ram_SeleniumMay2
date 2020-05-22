package week3.day2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBus {
	
	static Date date = new Date();
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
	 static String today= sdf.format(date);
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElementById("src").sendKeys("Chennai",Keys.TAB);
		driver.findElementById("dest").sendKeys("Trichy",Keys.TAB);
		driver.findElementByXPath("//div[@id='rb-calendar_onward_cal']/table[@class='rb-monthTable first last']//tr//td[@class='current day']").click();
		driver.findElementByXPath("//label[text()='Return Date']").click();
		driver.findElementByXPath("//div[@id='rb-calendar_return_cal']/table[@class='rb-monthTable first last']//tr//td[@class='current day']").click();
		driver.findElementByXPath("//li[text()='Chennai (All Locations)']").click();
		driver.findElementByXPath("//li[text()='Trichy']").click();
		driver.findElementById("search_btn").click();
		
		
	}

}
