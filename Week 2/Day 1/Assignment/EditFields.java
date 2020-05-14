package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditFields {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.findElementById("email").sendKeys("ram1995be@gmail.com");
		driver.findElementByXPath("//input[@value='Append ']").sendKeys("abc123");
		String text = driver.findElementByXPath("//input[@name='username'][@value='TestLeaf']").getAttribute("value");
		System.out.println(text);
		driver.findElementByXPath("//input[@name='username'][@value='Clear me!!']").clear();
		boolean enabled = driver.findElementByXPath("//label[text()='Confirm that edit field is disabled']/following::input").isEnabled();
		if(enabled==false) {
			System.out.println("Edit field is disabled");
		driver.close();
		}
	}
	

}
