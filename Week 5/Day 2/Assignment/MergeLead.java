package week5.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.testng.annotations.Test;

public class MergeLead extends ParentClass {
	
	@Test
	public void runMergeLead() throws InterruptedException {
		
		driver.findElementByXPath("//a[text()='Contacts']").click();
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		driver.findElementByXPath("//input[@id='partyIdFrom']/following::a").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		String mainWindow = window.get(0);
		String fromWindow = window.get(1);
		driver.switchTo().window(fromWindow);
		driver.findElementByXPath("(//*[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		driver.switchTo().window(mainWindow);
		driver.findElementByXPath("//input[@id='partyIdTo']/following::a").click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(windowHandles2);
		String toWindow = window2.get(1);
		driver.switchTo().window(toWindow);
		driver.findElementByXPath("(//*[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a").click();
		driver.switchTo().window(mainWindow);
		driver.findElementByXPath("//*[text()='Merge']").click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.findElementByXPath("//*[text()='View Contact']").isDisplayed();
			
	}

}