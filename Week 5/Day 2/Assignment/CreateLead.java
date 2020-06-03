package week5.day2;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateLead extends ParentClass {
	
	
	

	@BeforeClass
	public void getFileName() {
		 workbookName = "CreateLead";

	}
	
	@Test(dataProvider="getData")
	public void runCreateLead(String companyName, String firstName, String lastName) throws InterruptedException {
		
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(companyName);
		driver.findElementById("createLeadForm_firstName").sendKeys(firstName);
		driver.findElementById("createLeadForm_lastName").sendKeys(lastName);
		driver.findElementByClassName("smallSubmit").click();
		
	}
}