package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailSort {
	public static void main(String[] args) throws InterruptedException {
		
		List<String>names = new ArrayList<String>();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.findElementById("chkSelectDateOnly").click();
		Thread.sleep(5000);
		WebElement stationFrom = driver.findElementById("txtStationFrom");
		stationFrom.clear();
		stationFrom.sendKeys("Chennai", Keys.TAB);
		WebElement stationTo = driver.findElementById("txtStationTo");
		stationTo.clear();
		stationTo.sendKeys("Erode",Keys.ENTER);
		Thread.sleep(5000);
		List<WebElement> rows = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");
		for (int i = 1; i <= rows.size(); i++) {
			String trainName = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]/a").getText();
			Thread.sleep(3000);
			
			names.add(trainName);
		}
			Collections.sort(names);			
			for(String eachValue : names) {
					
					System.out.println(eachValue);
				}
			driver.close();
		}	
}
				
		


