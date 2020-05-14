package week2.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.findElementById("username").sendKeys("demosalesmanager");
	driver.findElementById("password").sendKeys("crmsfa",Keys.ENTER);
	driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
	driver.findElementByXPath("//a[text()='Leads']").click();
	driver.findElementByXPath("//a[text()='Find Leads']").click();
	driver.findElementByXPath("//span[text()='Email']").click();
	driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("ram@gmai.com",Keys.ENTER);
	Thread.sleep(2000);
	WebElement leadName = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]");
	String name = leadName.getText();
	leadName.click();
	driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
	boolean titleDisplayed = driver.findElementByXPath("//div[text()='Duplicate Lead']").isDisplayed();
	if(titleDisplayed==true) {
		System.out.println("Title is displayed as Duplicate lead");
	}else
	{System.out.println("No Title is displayed");}
	driver.findElementByXPath("//input[@value='Create Lead']").click();
	String nameMatch = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
	if(name.equals(nameMatch)) {
		System.out.println("Duplicate Name is captured as existing Name");
	}else
	{System.out.println("Duplicate Name is not as same as existing Name");}
	driver.close();
}
}
