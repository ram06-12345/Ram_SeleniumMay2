package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTable {
	public static void main(String[] args) throws InterruptedException {
		List<String>noOfRows= new ArrayList<String>();
		List<String>noOfCols= new ArrayList<String>();
		List<Integer>progressValues= new ArrayList<Integer>();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElementsByXPath("//table[@id='table_id']//tr");
		for (int i = 1; i <= rows.size(); i++) {
			String rowTagName = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]").getTagName();
			noOfRows.add(rowTagName);
		}
		int sizeOfRow = noOfRows.size();
		System.out.println("Size of the Row - "+sizeOfRow);
		List<WebElement> cols = driver.findElementsByXPath("//table[@id='table_id']//tr/th");
		for (int j = 1; j <=cols.size(); j++) {
			String colsTagName = driver.findElementByXPath("//table[@id='table_id']//tr/th["+j+"]").getTagName();
			noOfCols.add(colsTagName);
		}
		int sizeOfCols = noOfCols.size();
		System.out.println("Size of the Column - "+sizeOfCols);
		String text = driver.findElementByXPath("//table[@id='table_id']//tr/td[text()='Learn to interact with Elements']/following-sibling::td").getText();
		System.out.println("Progress value of 'Learn to interact with Elements' is "+text);
		
		List<WebElement> xpath = driver.findElementsByXPath("//table[@id='table_id']//tr");
		for (int i = 2; i <= xpath.size(); i++) {
			String values = driver.findElementByXPath("//table[@id='table_id']//tr["+i+"]/td[2]").getText();
			Thread.sleep(2000);
			values=values.replace("%", "");
			progressValues.add(Integer.parseInt(values));
		}
		Collections.sort(progressValues);
		Integer value = progressValues.get(0);
		WebElement checkBox = driver.findElementByXPath("//table[@id='table_id']//tr/td[contains(text(),'"+value+"')]/following-sibling::td/input");
		checkBox.click();
		boolean selected = checkBox.isSelected();
		Thread.sleep(5000);
		if(selected==true) {
			System.out.println("Vital Task for the Least completed Progress is selected");
		}else {
			System.out.println("Vital Task for the Least completed Progress is not selected");
		}
		driver.close();
	}

}
