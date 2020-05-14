package week2.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/radio.html");
		driver.findElementByXPath("//div//input[@id='yes']").click();
		boolean unchecked = driver.findElementByXPath("//label/input[@name='news']").isSelected();
		if(unchecked==false) {
			System.out.println("'Checked' Radio Button is selected by default");
		}else {
			System.out.println("'Unchecked' Radio button is selected by default");}
		boolean age1 = driver.findElementByXPath("(//input[@name='age'])").isSelected();
		boolean age2 = driver.findElementByXPath("(//input[@name='age'])[2]").isSelected();
		boolean age3 = driver.findElementByXPath("(//input[@name='age'])[3]").isSelected();
		if(age1==true||age2==true||age3==true) {
			System.out.println("Age is selected");
		}else {
			driver.findElementByXPath("(//input[@name='age'])[2]").click();}
		driver.close();
		}
	}

