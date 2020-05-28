package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitToDisappear {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement Button = driver.findElementById("btn");
		wait.until(ExpectedConditions.invisibilityOf(Button));
		String text = driver.findElementByXPath("//Strong").getText();
		System.out.println(text);
		driver.close();
	}

}
