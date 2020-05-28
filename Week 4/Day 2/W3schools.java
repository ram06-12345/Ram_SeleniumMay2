package week4.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class W3schools {
	public static void main(String[] args) {
		String name = "Ram"; 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[text()='Try it']").click();
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		boolean displayed = driver.findElementByXPath("//p[contains(text(),'"+name+"')]").isDisplayed();
		if (displayed==true) {
			System.out.println("Name is displayed");			
		}else {
			System.out.println("Name is not displayed");
		}
		driver.close();
	}

}
