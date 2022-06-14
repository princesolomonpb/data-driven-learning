package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wrongusernamewrongpassword {
	@Test
	public void inhvalidusernameandinvalidpassword() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		WebElement username = driver.findElement(By.id("txtUsername"));
	username.sendKeys("admin");
	WebElement password = driver.findElement(By.id("txtPassword"));
	password.sendKeys("admin");
	WebElement login = driver.findElement(By.id("btnLogin"));
	login.click();
	driver.quit();
	}
}
