package week2.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.findElementByXPath("//input").click();
		driver.findElementByXPath("//div[contains(text(),'VB')]/input").click();
		boolean selected = driver.findElementByXPath("//div[contains(text(),'Selenium')]/input").isSelected();
		if(selected==true) {
			System.out.println("'Selenium' checkbox is selected");
		}
		boolean deselect1 = driver.findElementByXPath("//div[contains(text(),'Not Selected')]/input").isSelected();
		boolean deselect2 = driver.findElementByXPath("//div[text()='I am Selected']/input").isSelected();
		
		if(deselect1==true) {
			driver.findElementByXPath("//div[contains(text(),'Not Selected')]/input").click();
		}
		else if(deselect2==true) {
			driver.findElementByXPath("//div[text()='I am Selected']/input").click();
		}
		
		driver.findElementByXPath("//div[text()='Option 1']/input").click();
		driver.findElementByXPath("//div[text()='Option 2']/input").click();
		driver.findElementByXPath("//div[text()='Option 3']/input").click();
		driver.findElementByXPath("//div[text()='Option 4']/input").click();
		driver.findElementByXPath("//div[text()='Option 5']/input").click();
		driver.close();
	}

}
