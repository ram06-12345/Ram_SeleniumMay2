package week2.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {
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
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys("9");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		WebElement leadLink = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		String leadID = leadLink.getText();
		leadLink.click();
		driver.findElementByXPath("//a[text()='Delete']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[text()='My Leads']").isDisplayed();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadID,Keys.ENTER);
		Thread.sleep(2000);
		boolean deletedLead = driver.findElementByXPath("//div[text()='No records to display']").isDisplayed();
		if(deletedLead==true) {
			System.out.println("Deleted Lead is not displayed");
			
			}else
			{System.out.println("Deleted Lead is displayed");}
		driver.close();
		
	}

}
