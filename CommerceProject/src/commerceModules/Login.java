package commerceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Meena\\Selenium\\drivers\\chromedriver.exe");
		WebDriver wd=new ChromeDriver();
		wd.get("https://demo.nopcommerce.com/");
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
		//click rememberme checkbox
		wd.findElement(By.id("RememberMe")).click();
		//click login button
		WebElement logbutn=wd.findElement(By.xpath("//button[@class='button-1 login-button']"));
		logbutn.click();
		
}
}
