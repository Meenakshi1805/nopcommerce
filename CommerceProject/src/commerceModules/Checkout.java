package commerceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Meena\\Selenium\\drivers\\chromedriver.exe");
		WebDriver wd=new ChromeDriver();
		wd.get("https://demo.nopcommerce.com/onepagecheckout#opc-billing");
		wd.manage().window().maximize();
		
		WebElement country= wd.findElement(By.id("BillingNewAddress_CountryId"));
		country.sendKeys("India");
		
	}

}
