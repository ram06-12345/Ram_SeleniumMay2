package week3.day2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTrainNamesAreUnique {
	public static void main(String[] args) throws InterruptedException {
		List<String> names = new LinkedList<String>();	
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
		for (int i = 1; i <=rows.size(); i++) {
		String trainName = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]/a").getText();
		Thread.sleep(5000);
		System.out.println(trainName);
		names.add(trainName);
		}
		System.out.println(names.size());
		int allNames = names.size();
		Set<String> uniqueNames = new HashSet<String>();
		uniqueNames.addAll(names);
		int dupNames = uniqueNames.size();
		if(allNames==dupNames) {
				System.out.println("All the Train Names are Unique");
			}else
				System.out.println("All the Train Names are not Unique");
		driver.close();
			}
		}


		
	
