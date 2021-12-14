package addTestng;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver wd;
	 
  @Test(priority = 1)
  public void login() {
	  wd.manage().window().maximize();
		
		//find login button
		WebElement login=wd.findElement(By.className("ico-login"));
		login.click();
		//Enter emailId
		WebElement eid=wd.findElement(By.id("Email"));
		eid.sendKeys("meenaram18@gmail.com");
		//Enter password
		WebElement pwd= wd.findElement(By.id("Password"));
		pwd.sendKeys("neHarini");
		//click remember me check box
		wd.findElement(By.id("RememberMe")).click();
		//click login button
		WebElement logbutn=wd.findElement(By.xpath("//button[@class='button-1 login-button']"));
		logbutn.click();
		  
  }
  @Test(priority = 2)
  public void myAccount() throws IOException {
	  
	  wd.findElement(By.linkText("My account")).click();
	  wd.findElement(By.linkText("Orders")).click();
	  TakesScreenshot screenshot= ((TakesScreenshot)wd);
		File img= screenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img, new File("C:\\Users\\meenakshi.r\\Documents\\selenium screenshots\\trackorder.png"));
	  
  }
  @Test(priority = 0)
  public void sys() {
	  System.setProperty("webdriver.chrome.driver","D:\\Meena\\Selenium\\drivers\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.get( "https://demo.nopcommerce.com/");
}
}
 

