package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//1) Go to https://www.makemytrip.com/ 
//2) Click Hotels 
//3) Enter city as Goa, and choose Goa, India 
//4) Enter Check in date as Next month 15th (July 15) and Check out as start date+4 
//5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button. 
//6) Click Search button 
//7) Select locality as Baga 
//8) Select user rating as 3&above(good) under Select Filters 
//9) Select Sort By: Price-Low to High 
//10) Click on the first resulting hotel and go to the new window 
//11) Print the Hotel Name  
//12) Click VIEW THIS COMBO button under Recommended Combo 
//13) Click on BOOK THIS COMBO button 
//14) Print the Total Payable amount 
//15) Close the browser  

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElementByXPath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']").click();
		driver.findElementByXPath("//li[@class ='menu_Hotels']/a").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='hsw_inputBox dates  ']/preceding::input").click();
		Thread.sleep(2000);
		
		  driver.findElementByXPath("(//*[@type='text'])[2]").sendKeys("Goa");
		  Thread.sleep(2000);
		  driver.findElementByXPath("//ul[@role='listbox']/li").click();
		  Thread.sleep(2000);
		  driver.findElementByXPath("(//div[@class='DayPicker-Week']/div[text()='15'])[1]").click();
		  driver.findElementByXPath("(//div[@class='DayPicker-Week']/div[text()='19'])[1]").click();
		  driver.findElementById("guest").click();
		  driver.findElementByXPath("//p[contains(text(),'CHILDREN')]/following::li[text()='1']").click();
		  
		  WebElement age = driver.findElementByXPath("//select[@class='ageSelectBox']");
		  Select dd = new Select(age);
		  dd.selectByVisibleText("12");
		  
		  driver.findElementByXPath("//button[text()='APPLY']").click();
		  Thread.sleep(2000);
		  driver.findElementByXPath("//button[text()='Search']").click();
		  
		  Actions builder = new Actions(driver);
		  WebElement map = driver.findElementById("seoH1DontRemoveContainer");
		  builder.click(map).perform();
		  
		  driver.findElementByXPath("//label[text()='Baga']").click();
		  Thread.sleep(2000);
		  driver.findElementByXPath("//*[contains(text(),'3 & above (Good)')]").click();
		  Thread.sleep(2000);
		  driver.findElementByXPath("//*[text()='Popularity']").click();
		  Thread.sleep(2000);
		  driver.findElementByXPath("//*[text()='Price - Low to High']").click();
		  Thread.sleep(2000);
		  driver.findElementById("Listing_hotel_0").click();
		  
		  Set<String> windowHandles = driver.getWindowHandles();
		  List<String> window = new ArrayList<String>(windowHandles);
		  driver.switchTo().window(window.get(1));
		  driver.manage().deleteAllCookies();
		  driver.navigate().refresh();
		  
		  String hotelName = driver.findElementById("detpg_hotel_name").getText();
		  System.out.println("Hotel Name is "+hotelName);
		  
		  driver.findElementByLinkText("BOOK THIS NOW").click();
		  String amount = driver.findElementByXPath("(//*[@class='font16 blackText appendBottom5'])[2]").getText();
		  amount = amount.replaceAll("[^0-9]", "");
		  System.out.println("Total Payable amount - "+amount);
		  driver.quit();	 
		
		
	}
}
