package week5.day2;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditLead extends ParentClass{
	
	@BeforeClass
	public void fileName() {
		workbookName = "EditLead";

	}
	
	@Test(dataProvider="getData")
	public void runEditLead(String firstName, String compName) throws InterruptedException {
		
		driver.findElementByXPath("//a[text()='Create Lead']").click();
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys(firstName);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		String text = driver.findElementByXPath("//div[@id='sectionHeaderTitle_leads']").getText();
		System.out.println("Title of the page is: "+text);		
		driver.findElementByXPath("//a[text()='Edit']").click();
		WebElement companyName = driver.findElementById("updateLeadForm_companyName");
		companyName.clear();
		companyName.sendKeys(compName);
		driver.findElementByXPath("//input[@value='Update']").click();
		boolean updated = driver.findElementByXPath("//span[@id='viewLead_companyName_sp'][contains(text(),name)]").isDisplayed();
		if(updated==true) {
			System.out.println("company name is changed");
		}
	}

}