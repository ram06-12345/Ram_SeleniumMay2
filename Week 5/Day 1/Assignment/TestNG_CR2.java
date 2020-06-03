package week5.day1;

import org.testng.annotations.Test;

import week2.day1.CreateLead;
import week2.day2.DeleteLead;
import week2.day2.EditLead;

public class TestNG_CR2 {
	
	@Test(priority=3)
	public void createLead() throws InterruptedException {
		CreateLead cl = new CreateLead();
		cl.runCreateLead();

	}
	@Test(priority=1)
	public void editLead() throws InterruptedException {
		EditLead el = new EditLead();
		el.runEditLead();

	}
	@Test(priority=2)
	public void deleteLead() throws InterruptedException {
		DeleteLead dl = new DeleteLead();
		dl.runDeleteLead();
	}

}
