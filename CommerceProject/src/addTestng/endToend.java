package addTestng;

import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

public class endToend {
	WebDriver wd;
	Actions act;
	
	WebDriver wait;
  @Test(priority = 1)
  public void reg() {
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
			
		
			//WebElement result=wd.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li"));
			//System.out.println(result.getText());
			WebElement sucreg= wd.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
			System.out.println(sucreg.getText());	
  }
  @SuppressWarnings("deprecation")
@Test(priority = 2)
  public void purchase() {
		//choose currency from dropdown
		WebElement currency=wd.findElement(By.id("customerCurrency"));
		currency.click();
		Select sel=new Select(currency);
		sel.selectByVisibleText("Euro");
		wd.manage().window().maximize();
		//mouse hover on electronics and find cell phones from drop down
		
		WebElement elec=wd.findElement(By.xpath("//a[@href='/electronics']"));
		elec.click();
		Actions act= new Actions(wd);
		WebElement cellpn= wd.findElement(By.linkText("Cell phones"));
		act.moveToElement(cellpn).build().perform();
		cellpn.click();
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,250)", "");
		WebElement nokia= wd.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/a/img"));
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
		wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(wd,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")));
		//To go to the shopping cart
		
		WebElement shopcrt= wd.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]"));
		shopcrt.click();
		
		JavascriptExecutor jse = (JavascriptExecutor)wd;
		jse.executeScript("window.scrollBy(0,500)");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
  }
  @Test(priority = 3)
  public void fillDetails() throws Exception {
	//to fill shipping address country field
      wd.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("India");
		//to fill state or province
		//WebElement state= wd.findElement(By.id("BillingNewAddress_StateProvinceId"));
		//act.doubleClick(state).build().perform();
		//to fill the city value
		wd.findElement(By.id("BillingNewAddress_City")).sendKeys("Bangalore");
		//To fill address1 text field
		wd.findElement(By.id("BillingNewAddress_Address1")).sendKeys("No1, groovy aptmt, 9th cross");
		//To fill address2 column
		wd.findElement(By.id("BillingNewAddress_Address2")).sendKeys("RM nagar, Akshay nagar post");
		//To fill postal code
		wd.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("530032");
		//To fill phone number field    
		wd.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9900345677");  
		//To click the continue button
		wd.findElement(By.xpath("//button[@name='save']")).click();
		Thread.sleep(1000);
		//To click continue button in shipping method
		wd.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
		Thread.sleep(1000);
		//To select credit card radio button in payment method
		wd.findElement(By.xpath("//*[@id=\"paymentmethod_1\"]")).click();
		Thread.sleep(1000);
		//To click continue button in payment method
		wd.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
		Thread.sleep(1000);
		//Fill details in payment information
		//card holder name details
		wd.findElement(By.xpath("//*[@id=\"CardholderName\"]")).sendKeys("Meenakshi");
		//Card number details
		wd.findElement(By.xpath("//*[@id=\"CardNumber\"]")).sendKeys("4854980806227577");
		//Expire month
		WebElement expmon=wd.findElement(By.id("ExpireMonth"));
		Select sel2=new Select(expmon);
		sel2.selectByVisibleText("06");
		WebElement expyear=wd.findElement(By.id("ExpireYear"));
		Select sel3=new Select(expyear);
		sel3.selectByVisibleText("2030");
		//card code details
		wd.findElement(By.id("CardCode")).sendKeys("432");
				
		//To click continue button in payment information
		wd.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();
		JavascriptExecutor jse = (JavascriptExecutor)wd;
		jse.executeScript("window.scrollBy(0,500)");
		
		//To confirm purchase
		WebElement purchas=wd.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
		purchas.click();
	 }
  @Test(priority = 4)
  public void takeScreenShot() throws IOException {
		//To click the link to check the order details
		wd.findElement(By.linkText("Click here for order details.")).click();
		
		TakesScreenshot screenshot= ((TakesScreenshot)wd);
		File img= screenshot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img, new File("C:\\Users\\meenakshi.r\\Documents\\selenium screenshots\\order.png"));
		
  }
  
  @BeforeSuite
  public void beforeSuite() {
	  System.setProperty("webdriver.chrome.driver","D:\\Meena\\Selenium\\drivers\\chromedriver.exe");
		wd=new ChromeDriver();
		wd.get("https://demo.nopcommerce.com/");
  }

 @AfterSuite
  public void afterSuite() {
	  wd.quit();
  }

}
