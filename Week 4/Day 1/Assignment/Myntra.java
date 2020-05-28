package week4.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Myntra {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	ChromeDriver driver = new ChromeDriver(options);
	driver.get("https://www.myntra.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	WebElement women = driver.findElementByXPath("//a[text()='Women']");
	Actions builder = new Actions(driver);
	builder.moveToElement(women).perform();
	driver.findElementByXPath("//a[text()='Jackets & Coats']").click();;
	String text = driver.findElementByXPath("//h1[text()='Coats & Jackets For Women']/following::span").getText();
	int totalCount = Integer.parseInt(text.replaceAll("[^0-9]", ""));
	String jacket = driver.findElementByXPath("//span[@class='categories-num']").getText();
	String coat = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
	int totalCategoryCount = (Integer.parseInt(jacket.replaceAll("[^0-9]", ""))+Integer.parseInt(coat.replaceAll("[^0-9]", "")));
	if(totalCount==totalCategoryCount)
		System.out.println("Sum of Categories matches the total count");
	else
		System.out.println("Sum of Categories is not matched with total count");
	driver.findElementByXPath("(//span[@class='categories-num'])[2]/following::div").click();
	driver.findElementByXPath("//div[contains(text(),'+ ')]").click();
	String brand = "MANGO";
	driver.findElementByXPath("//input[@placeholder='Search brand']").sendKeys(brand);
	driver.findElementByXPath("(//label[text()='"+brand+"'])[2]/div").click();
	driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
	Thread.sleep(2000);
	List<WebElement> path = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/h3");
	int size = path.size();
	int verify=0;
	for (int i = 1; i <=size; i++) {
		String brandName = driver.findElementByXPath("(//div[@class='product-productMetaInfo']/h3)["+i+"]").getText();
		if(brandName.equals("MANGO"))
			verify=verify+1;
		}
		if (verify==size) 
			System.out.println("All the Coats displayed are "+brand+" brand");
		else
			System.out.println("All the coats displayed are not "+brand+" brand");
	driver.findElementByXPath("//div[@class='sort-sortBy']").click();
	driver.findElementByXPath("//label[text()='Better Discount']").click();
	System.out.println("Price of the 1st item displayed - "+driver.findElementByXPath("//span[@class='product-discountedPrice']").getText());
	Thread.sleep(2000);
	WebElement productSize = driver.findElementByXPath("(//*[@class='product-sliderContainer'])[1]");
	Thread.sleep(2000);
	builder.moveToElement(productSize).perform();
	driver.findElementByXPath("(//span[text()='wishlist'])[1]").click();
	Thread.sleep(5000);
	driver.close();
	
	
	
	
	
}
}
