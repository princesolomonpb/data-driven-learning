package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReading {
	WebDriver driver;
	String[][] data=null;
	@DataProvider(name="logindata")
public String[][] logindata() throws BiffException, IOException {
	data=exceldataprovider();
	return data;
}
public String[][] exceldataprovider() throws BiffException, IOException {
	FileInputStream file=new FileInputStream("C:\\Users\\admin\\Desktop\\prine\\LoginDetails.xls");
	Workbook excelbook= Workbook.getWorkbook(file);
	Sheet sheet=excelbook.getSheet(0);
	int rows = sheet.getRows();
	int columns = sheet.getColumns();
	String testdata[][]=new String[rows-1][columns];
	for (int i = 1; i <rows; i++) {
		for(int j=0;j<columns;j++) {
			testdata[i-1][j] = sheet.getCell(j, i).getContents();
		}
		
	}
	return testdata;
}
@BeforeTest
public void beforetest() {
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
}
@Test(dataProvider="logindata")
public void inhvalidusernameandinvalidpassword(String uname,String pword) {
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	WebElement username = driver.findElement(By.id("txtUsername"));
username.sendKeys(uname);
WebElement password = driver.findElement(By.id("txtPassword"));
password.sendKeys(pword);
WebElement login = driver.findElement(By.id("btnLogin"));
login.click();

}
@AfterTest
public void aftertest() {
driver.quit();
}
}
