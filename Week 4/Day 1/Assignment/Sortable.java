package week4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		builder.clickAndHold(item1).perform();
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		int x = item4.getLocation().getX();
		int y = item4.getLocation().getY();
		builder.dragAndDropBy(item1, x, y).perform();
		driver.close();
	}
	

}
