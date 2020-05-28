package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class IRCTC {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		Actions builder = new Actions(driver);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@type='submit']").click();
		driver.findElementByXPath("//*[@class='allcircle circleone']").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		WebElement checkBox = driver.findElementById("agree");
		builder.click(checkBox).perform();
		driver.findElementByXPath("//*[text()='Continue ']").click();
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File ("./snaps/flights.png");
		FileUtils.copyFile(source, target);
		driver.switchTo().window(windows.get(0));
		driver.close();
	}

}
