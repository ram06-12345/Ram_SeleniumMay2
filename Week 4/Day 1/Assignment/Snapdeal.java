package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		WebElement men = driver.findElementByXPath("(//li[text()='More Categories']/following::span)[1]");
		builder.moveToElement(men).perform();
		//driver.findElementByXPath("(//span[text()='Shirts'])[2]").click();
		WebElement shirt = driver.findElementByXPath("(//span[text()='Shirts'])[2]");
		builder.click(shirt).perform();
		WebElement element = driver.findElementByXPath("(//div[@class='col-xs-6  favDp product-tuple-listing js-tuple '])[1]");
		builder.moveToElement(element);
		driver.findElementByXPath("//div[contains(text(),'Quick View')]").click();
		Thread.sleep(3000);
		driver.close();
	}

}
