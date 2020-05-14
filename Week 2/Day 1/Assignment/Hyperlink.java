package week2.day1;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hyperlink {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String URL ="http://www.leafground.com/pages/Link.html";
		driver.get(URL);
		driver.manage().window().maximize();
		String homePage ="//a[text()='Go to Home Page']";
		driver.findElementByXPath(homePage).click();		
		boolean displayed = driver.findElementByXPath("//h1[contains(text(),'Locators and Selenium Interactions')]").isDisplayed();
		if(displayed==true) {
			System.out.println("Navigated to home page");}
		driver.findElementByXPath("//h5[text()='HyperLink']/following::img[1]").click();
		boolean buttonPage = driver.findElementByXPath("//h1[text()='Play with HyperLinks']").isDisplayed();
		if(buttonPage==true) {
			System.out.println("Navigated back to Hyperlink Page");}
		String attribute = driver.findElementByXPath("//a[contains(text(),'without clicking')]").getAttribute("href");
		System.out.println("If I click on the link, I will be navigated to below link");
		System.out.println("Link: "+attribute);
		driver.findElementByXPath("//a[contains(text(),'broken')]").click();
		boolean pageError = driver.findElementByXPath("//h1[contains(text(),'HTTP Status 404 – Not Found')]").isDisplayed();
		if(pageError==true) {
			System.out.println("URL is broken");
		}else {
			System.out.println("URL not Broken");}
		driver.get(URL);
		driver.findElementByXPath(homePage).click();
		driver.get(URL);
		
		// To find No.of links in page
		List<WebElement> list = driver.findElementsByTagName("a");
		int size = list.size();
		System.out.println(size);
		driver.close();
	}

}
