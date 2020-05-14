package week2.day1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElementById("home").click();
		boolean displayed = driver.findElementByXPath("//h1[contains(text(),'Locators and Selenium Interactions')]").isDisplayed();
		if(displayed==true) {
			System.out.println("Navigated to home page");}
		driver.findElementByXPath("//h5[text()='Button']/following::img[1]").click();
		boolean buttonPage = driver.findElementByXPath("//h1[text()='Bond with Buttons']").isDisplayed();
		if(buttonPage==true) {
			System.out.println("Navigated back to Buttons Page");}
		int x = driver.findElementById("position").getLocation().getX();
		int y = driver.findElementById("position").getLocation().getY();
		System.out.println("Position of the button: "+x +","+ y);
		String color = driver.findElementById("color").getAttribute("style");
		System.out.println("Color of the button is "+color);
		Dimension size = driver.findElementById("size").getSize();
		System.out.println("Size of the button "+size);
		driver.close();		
	}

}
