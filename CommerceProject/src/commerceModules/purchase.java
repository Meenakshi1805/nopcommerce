package commerceModules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class purchase {

	public void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Meena\\Selenium\\drivers\\chromedriver.exe");
		WebDriver wd=new ChromeDriver();
		wd.get("https://demo.nopcommerce.com//");
		wd.manage().window().maximize();
		//Login login=new Login();
		//login.main(args);
		
		//choose currency from dropdown
		WebElement currency=wd.findElement(By.id("customerCurrency"));
		currency.click();
		Select sel=new Select(currency);
		sel.selectByVisibleText("Euro");
		//mouse hover on electronics and find cell phones from drop down
		
		WebElement elec=wd.findElement(By.xpath("//a[@href='/electronics']"));
		elec.click();
		Actions act= new Actions(wd);
		WebElement cellpn= wd.findElement(By.linkText("Cell phones"));
		act.moveToElement(cellpn).build().perform();
		cellpn.click();
		WebElement nokia= wd.findElement(By.xpath("//a[@href='/nokia-lumia-1020']"));
		System.out.println(nokia.getAttribute("title"));
		nokia.click();
		//Check availability
		WebElement stock=wd.findElement(By.id("stock-availability-value-20"));
		System.out.println(stock.getText());
		
		//Add one element to cart
		WebElement adtocrt= wd.findElement(By.id("add-to-cart-button-20"));
		adtocrt.click();
		/*WebElement confrm=wd.findElement(By.xpath("//p[@class='content']"));
		System.out.println(confrm.getText());
		//To close the alert
		wd.findElement(By.xpath("//span[@class='close']")).click();*/
		Thread.sleep(1000);
		wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
		//To go to the shopping cart
		
		WebElement shopcrt= wd.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));
		shopcrt.click();
		
		JavascriptExecutor jse = (JavascriptExecutor)wd;
		jse.executeScript("window.scrollBy(0,500)");
		
		//To giftwrap
		WebElement gftwrp=wd.findElement(By.id("checkout_attribute_1"));
		gftwrp.click();
		Select sel1=new Select(gftwrp);
		sel1.selectByIndex(1);
		//To print the total price
		WebElement price= wd.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/strong"));
		System.out.println(price.getText());
		//To check the terms and conditions
		WebElement agree= wd.findElement(By.id("termsofservice"));
		agree.click();
		//Click checkout button
		WebElement chkot= wd.findElement(By.id("checkout"));
		chkot.click();
		//to fill shipping address country field
		//wd.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("India");
		
		
	}

}
