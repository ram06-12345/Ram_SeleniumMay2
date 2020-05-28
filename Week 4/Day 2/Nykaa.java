package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		WebElement brand = driver.findElementByXPath("//a[text()='brands']");
		WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
		Thread.sleep(5000);
		builder.moveToElement(brand).perform();
		builder.moveToElement(popular).perform();
		driver.findElementByXPath("(//a[contains(@href,'loreal')])[3]").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> loreal = new ArrayList<String>(windowHandles);
		driver.switchTo().window(loreal.get(1));
		String text = driver.findElementByTagName("h1").getText();
		if(text.contains("OREAL PARIS"))
			System.out.println("Page contains L'Oreal Paris items");
		else
			System.out.println("Page doesn't have L'Oreal Paris items");
		driver.switchTo().window(loreal.get(0));
		driver.close();
		driver.switchTo().window(loreal.get(1));
		driver.findElementByXPath("//*[@class='pull-right']/i").click();
		driver.findElementByXPath("//*[text()='customer top rated']/following-sibling::div").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//*[text()='Category']").click();
		driver.findElementByXPath("(//span[contains(text(),'Shampoo')])[1]/following-sibling::div").click();
		driver.findElementByXPath("(//div[@class='card-img'])[1]//img").click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> product = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(product.get(1));		
		
		driver.findElementByXPath("(//*[@class='pull-left'])[1]//button").click();
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		String errorMessage = driver.findElementByXPath("//div[@class='layout horizontal center message']").getText();
		System.out.println(errorMessage);
		driver.quit();
		
	}

}
