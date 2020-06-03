package week5.day1;

import org.testng.annotations.Test;

import week2.day1.CreateLead;
import week2.day2.DeleteLead;
import week2.day2.EditLead;

public class TestNG_CR1 {
	
	@Test
	public void createLead() throws InterruptedException {
		CreateLead CL = new CreateLead();
		CL.runCreateLead();

	}
	@Test(dependsOnMethods= {("week5.day1.TestNG_CR1.createLead")})
	public void editLead() throws InterruptedException {
		EditLead EL = new EditLead();
		EL.runEditLead();

	}
	@Test(dependsOnMethods= {("week5.day1.TestNG_CR1.editLead")})
	public void deleteLead() throws InterruptedException {
		DeleteLead DL = new DeleteLead();
		DL.runDeleteLead();
	}

}
