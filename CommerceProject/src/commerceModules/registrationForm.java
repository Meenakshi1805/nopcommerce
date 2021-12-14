package commerceModules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class registrationForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Meena\\Selenium\\drivers\\chromedriver.exe");
		WebDriver wd=new ChromeDriver();
		wd.get("https://demo.nopcommerce.com/");
		
		//Find register button and click
		WebElement register=wd.findElement(By.className("ico-register"));
		register.click();
		
		//validating all the elements to register in form
		//select gender
		wd.findElement(By.id("gender-female")).click();
		//enter value in first name
		wd.findElement(By.id("FirstName")).sendKeys("Meenakshi");
		//enter last name
		wd.findElement(By.id("LastName")).sendKeys("Ramanathan"+Keys.TAB);
		//enter DOB
		wd.findElement(By.name("DateOfBirthDay")).sendKeys("18");
		wd.findElement(By.name("DateOfBirthMonth")).sendKeys("may");
		wd.findElement(By.name("DateOfBirthYear")).sendKeys("1990");
		//enter emailId
		wd.findElement(By.id("Email")).sendKeys("meenaram18@gmail.com"+Keys.TAB);
		//enter company
		wd.findElement(By.id("Company")).sendKeys("edubridge"+Keys.ENTER);
		//enter password
		wd.findElement(By.id("Password")).sendKeys("neHarini");
		//enter confirm password
		wd.findElement(By.id("ConfirmPassword")).sendKeys("neHarini");
		//click register button
		wd.findElement(By.id("register-button")).click();
		wd.manage().timeouts().implicitlyWait(1000,TimeUnit.MILLISECONDS);
		//validate result after registration
		//WebElement result=wd.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li"));
		//System.out.println(result.getText());
		WebElement sucreg= wd.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
		System.out.println(sucreg.getText());		
		
	}

}
