package week1;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//1)Go to https://azure.microsoft.com/en-in/ 
//2) Click on Pricing 
//3) Click on Pricing Calculator 
//4) Click on Containers 
//5) Select Container Instances 
//6) Click on Container Instance Added View 
//7) Select Region as "South India" 
//8) Set the Duration as 180000 seconds 
//9) Select the Memory as 4GB 
//10) Enable SHOW DEV/TEST PRICING 
//11) Select Indian Rupee  as currency 
//12) Print the Estimated monthly price 
//13) Click on Export to download the estimate as excel 
//14) Verify the downloded file in the local folder 
//15) Navigate to Example Scenarios and Select CI/CD for Containers 
//16) Click Add to Estimate 17) Change the Currency as Indian Rupee 
//18) Enable SHOW DEV/TEST PRICING 
//19) Export the Estimate 
//20) Verify the downloded file in the local folder

public class MicrosoftAzure {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://azure.microsoft.com/en-in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElementByLinkText("Pricing").click();
		driver.findElement(By.linkText("Pricing calculator")).click();
		driver.findElementByXPath("//button[@data-event-property='containers']").click();
		driver.findElementByXPath("(//*[@title='Container Instances'])[3]").click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[text()='View']"))).click();
		
		Select region = new Select(driver.findElementByName("region"));
		region.selectByValue("south-india");
		
		WebElement seconds = driver.findElementByName("seconds");
		seconds.clear();
		seconds.sendKeys(Keys.ARROW_RIGHT);
		seconds.sendKeys("80000");
		
		Select memory = new Select(driver.findElementByName("memory"));
		memory.selectByValue("4");
		
		driver.findElementByName("devTestSelected").click();
		
		Select dollar = new Select(driver.findElementByXPath("//*[@class='select currency-dropdown']"));
		dollar.selectByValue("INR");
		
		System.out.println("Estimated Monthly Cost - "+driver.findElementByXPath("(//*[@class='column large-3 text-right total']//span)[3]").getText());
		
		
		driver.findElement(By.xpath("(//button[contains(@class,'calculator-button button-transparent')])[4]")).click();
		
		verifyFile("ExportedEstimate.xlsx");
		
		driver.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		driver.findElement(By.linkText("Example Scenarios")).click();
		driver.findElementByXPath("//button[@title='CI/CD for Azure Web Apps']").click();
		driver.findElementByXPath("//button[text()='Add to estimate']").click();
		
		Select dollar1 = new Select(driver.findElementByXPath("//*[@class='select currency-dropdown']"));
		dollar1.selectByValue("INR");
		
		Thread.sleep(3000);
		driver.findElementByName("devTestSelected").click();
		
		driver.findElement(By.xpath("(//button[contains(@class,'calculator-button button-transparent')])[4]")).click();
		
				verifyFile("ExportedEstimate (1).xlsx");		
		
		driver.close();
	}
	
	
	  public static void verifyFile(String filename) {
	  
	  File file = new File ("C:\\Users\\ram.rajendran\\Downloads\\" + filename);
	  
	  if(file.exists()) 
		  System.out.println("File has been downloaded"); 		  
	  else 
		  System.out.println("File has not been downloaded"); 
	  
	  } 
	 
	
	

}
