package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForTextChange {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement button = driver.findElementById("btn");
		wait.until(ExpectedConditions.textToBePresentInElement(button, "Click ME!"));
		String text = button.getText();
		System.out.println(text);
		button.click();
		Thread.sleep(3000);
		driver.quit();
	}

}
