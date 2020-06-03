package week5.day2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ParentClass {
	
	public String workbookName;
	public ChromeDriver driver;
	
	@Parameters({"URL","UserName","Password"})
	@BeforeMethod
	public void parent(String url, String username, String pwd) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(pwd,Keys.ENTER);	
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click();

	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
	
	@DataProvider
	public String[][] workbook() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+workbookName+".xlsx");
		XSSFSheet ws = wb.getSheetAt(0);
		XSSFRow row = ws.getRow(0);
		int lastRowNum = ws.getLastRowNum();
		short lastCellNum = row.getLastCellNum();
		
		String[][] data = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				String cell = wb.getSheetAt(0).getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=cell;
			}
		}
		return data;
	}

}
