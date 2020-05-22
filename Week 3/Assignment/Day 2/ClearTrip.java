package week3.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ClearTrip {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.cleartrip.com/");
	driver.manage().window().maximize();
	driver.findElementById("RoundTrip").click();
	driver.findElementByXPath("//input[@title='Any worldwide city or airport'][@id='FromTag']").sendKeys("Chennai",Keys.TAB);
	driver.findElementByXPath("//input[@title='Any worldwide city or airport'][@id='ToTag']").sendKeys("New york",Keys.TAB);
	driver.findElementByLinkText("20").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//div[@class='monthBlock last']//tr[3]/td[2]/a").click();
	WebElement adults = driver.findElementById("Adults");
	Select adultDD = new Select(adults);
	adultDD.selectByValue("2");
	WebElement child = driver.findElementById("Childrens");
	Select childDD = new Select(child);
	childDD.selectByValue("1");
	WebElement infant = driver.findElementById("Infants");
	Select infantDD = new Select(infant);
	infantDD.selectByValue("1");
	driver.findElementById("MoreOptionsLink").click();
	WebElement travelClass = driver.findElementById("Class");
	Select classDD = new Select(travelClass);
	classDD.selectByVisibleText("Premium Economy");
	driver.findElementByName("airline").sendKeys("Emirates",Keys.TAB);
	driver.findElementById("SearchBtn").click();
}
}
