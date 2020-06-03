package week5.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DeleteLead extends ParentClass{
	
	@BeforeClass
	public void fileName() {
		 workbookName = "DeleteLead";
	}
	
	@Test(dataProvider="workbook")
	public void runDeleteLead(String phoneNumber) throws InterruptedException {
		
		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//span[text()='Phone']").click();
		driver.findElementByXPath("//input[@name='phoneNumber']").sendKeys(phoneNumber);
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
		
	}

}