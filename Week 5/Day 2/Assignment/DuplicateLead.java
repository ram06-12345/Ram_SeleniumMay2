package week5.day2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DuplicateLead extends ParentClass{

	@BeforeClass
	public void fileName() {
	workbookName = "DuplicateLead";
	}
	
	@Test(dataProvider="workbook")
	public void runDuplicateLead(String input) throws InterruptedException {
	
	driver.findElementByXPath("//a[text()='Leads']").click();
	driver.findElementByXPath("//a[text()='Find Leads']").click();
	driver.findElementByXPath("//span[text()='Email']").click();
	driver.findElementByXPath("//input[@name='emailAddress']").sendKeys(input,Keys.ENTER);
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
}
}