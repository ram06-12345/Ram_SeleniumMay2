package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LaunchApplication {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		WebElement username = driver.findElementById("username");
		username.sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("Accenture");
		driver.findElementById("createLeadForm_firstName").sendKeys("Ram");
		driver.findElementById("createLeadForm_lastName").sendKeys("Prakash");
		
		//Select DD value using VisibleText
		WebElement source = driver.findElementById("createLeadForm_dataSourceId");
		Select sourceDD = new Select(source);
		sourceDD.selectByVisibleText("Employee");
		
		//Select DD value using Value
		WebElement marketingCampaign = driver.findElementById("createLeadForm_marketingCampaignId");
		Select marketingCampaignDD = new Select (marketingCampaign);
		marketingCampaignDD.selectByValue("9001");
		
		//Select DD value using Index
		WebElement ownership = driver.findElementById("createLeadForm_ownershipEnumId");
		Select OwnershipDD = new Select (ownership);
		OwnershipDD.selectByIndex(5);
		
		//Select DD Value using Visible Text
		WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
		Select countryDD = new Select (country);
		countryDD.selectByVisibleText("India");
		
		driver.findElementByClassName("smallSubmit").click();
		String text = driver.findElementById("sectionHeaderTitle_leads").getText();
		System.out.println(text);
		Thread.sleep(2000);
		driver.close();
	}

}