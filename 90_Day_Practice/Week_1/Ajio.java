package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//1) Go to https://www.ajio.com/shop/sale
//2) Enter Bags in the Search field and Select Bags in Women Handbags
//3) Click on five grid and Select SORT BY as "What's New"
//4) Enter Price Range Min as 2500 and Max as 5000
//5) Click on the product "TOMMY HILFIGER Sling Bag with Chain Strap"
//6) Verify the Coupon code for the price above 2890 is applicable for your product, if applicable then get the Coupon Code and the discount price for the coupon
//7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
//8) Click on Other Informations under Product Details and Print the Customer Care address, phone and email
//9) Click on ADD TO BAG and then GO TO BAG
//10) Check the Order Total before apply coupon
//11) Enter Coupon Code and Click Apply
//12) Verify the discount price matches with the product price
//13) Click on Delete and Delete the item from Bag
//14) Close all the browsers


public class Ajio {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElementByXPath("//input").sendKeys("bags");
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Women Handbags']").click();
		Thread.sleep(2000);
		driver.findElementByClassName("five-grid").click();
		
		Select sort = new Select(driver.findElementByXPath("//div[@class='filter-dropdown']/select"));
		sort.selectByValue("newn");
		
		driver.findElementByXPath("//*[text()='price']").click();
		driver.findElementById("minPrice").sendKeys("2500");
		driver.findElementById("maxPrice").sendKeys("5000");
		driver.findElementByXPath("//*[@id='maxPrice']/following::button").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//*[text()='Sling Bag with Chain Strap']/parent::div").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window	= new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		String couponCode = driver.findElementByClassName("promo-title").getText();
		couponCode = couponCode.replaceFirst("Use Code", "");
		System.out.println(couponCode);
		String amount = driver.findElementByXPath("//*[@class='promo-discounted-price']/span").getText();
		String amount1 = amount.replaceFirst("Get it for ", "");
		String amount2 = amount1.replaceAll("[^0-9]", "");
		System.out.println(amount2);
		
		driver.findElementByClassName("edd-pincode-msg").click();
		driver.findElementByName("pincode").sendKeys("560043");
		driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
		String deliveryDate = driver.findElementByXPath("//*[@class='edd-message-success-details']/li/span").getText();
		System.out.println("Expected Delivery on - "+deliveryDate);
		driver.findElementByXPath("//*[text()='Other information']").click();
		String address = driver.findElementByXPath("//*[text()='Customer Care Address']/following-sibling::span[@class='other-info']").getText();
		System.out.println("Address - "+address);
		driver.findElementByXPath("//*[text()='ADD TO BAG']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@class='ic-cart ']/parent::a").click();
		Thread.sleep(5000);
		String totalAmount = driver.findElementByXPath("//*[@class='priceinfo']/div").getText();
		totalAmount=totalAmount.replaceAll("[^0-9]", "");
		driver.findElementById("couponCodeInput").sendKeys(couponCode);
		driver.findElementByXPath("//*[text()='Apply']").click();
		Thread.sleep(3000);
		String discountAmount = driver.findElementByXPath("//*[@class='priceinfo']/div").getText();
		discountAmount=discountAmount.replaceAll("[^0-9]", "");
		Assert.assertNotEquals(totalAmount, discountAmount);
		driver.findElementByXPath("//*[text()='Delete']").click();
		driver.close();
		
	}

}
