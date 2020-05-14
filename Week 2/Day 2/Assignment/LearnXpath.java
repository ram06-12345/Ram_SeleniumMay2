package week2.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnXpath {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeDriver driver= new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
	driver.findElementByXPath("//input[@name='PASSWORD']").sendKeys("crmsfa",Keys.ENTER);
	driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();
	driver.findElementByXPath("//a[text()='Leads']").click();
	driver.findElementByXPath("//a[text()='Create Lead']").click();
	driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys("Accenture");
	driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys("Ram");
	driver.findElementByXPath("(//input[@name='lastName' or @id='createLeadForm_lastName'])[3]").sendKeys("Prakash");
	driver.findElementByXPath("//input[@value='Create Lead']").click();
	driver.close();
}
}
