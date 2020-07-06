package week1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

//1) Go to https://www.pepperfry.com/
//2) Mouseover on Furniture and click Office Chairs under Chairs
//3) click Executive Chairs
//4) Change the minimum Height as 50 in under Dimensions
//5) Add "Poise Executive Chair in Black Colour" chair to Wishlist
//6) Mouseover on Furniture and Click Office tables
//7) Select Executive Desks
//8) Select Price between 20000 to 40000 rs
//9) Add "Executive Office Table in Brown Color" to Wishlist
//10) Verify the number of items in Wishlist
//11) Navigate to Wishlist
//12) Get the offer Price and Coupon Code for Executive Office Table in Brown Color
//13) Move Executive Office Table in Brown Color only to Cart from Wishlist
//14) Check for the availability for Pincode 600128
//15) Click on PROCEED TO PAY SECURELY from My Cart
//16) Enter the Coupon code and click Apply
//17) Click Proceed to Pay
//18) Capture the screenshot of the item under ORDER SUMMARY
//19) Close the browser


public class PepperFry {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");		
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(10000);
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		driver.findElementByXPath("//div[@class='close']").click();
		Thread.sleep(5000);
		
		Actions builder = new Actions(driver);
		WebElement closeButton = driver.findElementByXPath("//div[@id='regPopUp']/a");
		builder.click(closeButton).perform();
		
		WebElement furniture = driver.findElementByLinkText("Furniture");
		Thread.sleep(3000);
		builder.moveToElement(furniture).perform();
		Thread.sleep(5000);
		//driver.findElementByXPath("(//a[text()='Office Chairs'])[2]").click();
		driver.findElementByCssSelector("div#meta-furniture>div>div:nth-of-type(3)>div:nth-of-type(2)>div:nth-of-type(12)>a").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='cat-wrap-img'])[2]").click();
		Thread.sleep(2000);
		
		WebElement dimension = driver.findElementByXPath("//div[@class='clip__filter-dimension-input-holder']/input");
		dimension.clear();
		dimension.sendKeys("50");
		Thread.sleep(5000);
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		driver.findElementByXPath("//div[@class='close']").click();
		Thread.sleep(5000);
		
		driver.findElementByXPath("//a[@data-productname='Poise Executive Chair in Black Colour']").click();
		Thread.sleep(3000);
		
		WebElement furniture2 = driver.findElementByLinkText("Furniture");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",furniture2);
		builder.moveToElement(furniture2).perform();
		Thread.sleep(3000);
		driver.findElementByXPath("//a[text()='Office Tables']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//li[@class='clip-main-cat carousel-cell ']/a)[2]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//label[@for='price20000-40000']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@data-productname='Executive Office Table in Brown Color']").click();
		Thread.sleep(2000);
		System.out.println("No.of items in wishlist - "+ driver.findElementByXPath("(//*[@class='wishlist_bar']/a/following::span)[1]").getText());
		driver.findElementByXPath("//*[@class='wishlist_bar']/a").click();
		Thread.sleep(3000);
		
		String offerPrice = driver.findElementByXPath("//*[@class='oprice']/span[@class='txt-green']").getText();
		System.out.println("Offer Price is "+offerPrice);
		String couponCode = driver.findElementByXPath("//*[@class='oprice']/following::p/strong").getText();
		driver.findElementByXPath("//*[@class='action_block']/a").click();
		driver.findElementByXPath("//*[text()='Showing availability at']/following::input").sendKeys("600128",Keys.ENTER);
		driver.findElementByXPath("//*[@class='minicart_footer']/a").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//*[@placeholder='Enter Coupon Code']").sendKeys(couponCode,Keys.ENTER);
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@class='ck-proceed-btn-wrap']/a").click();
		Thread.sleep(3000);
		driver.findElementById("ordersummary_accrodian").click();
		
		WebElement orderDetails = driver.findElementByXPath("(//*[@class='nCheckout__accrodian open'])[2]");
		File source = orderDetails.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/pepperfry.png");
		FileUtils.copyFile(source, target);
		driver.close();
		
	}

}
