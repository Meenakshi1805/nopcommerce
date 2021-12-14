package commerceModules;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginTestExcel {
	WebDriver wd;
	String[][] data =null;

	@DataProvider (name="a")	
	public String[][] a() throws BiffException, IOException
	{
		data=	getDataFromExcel();
		return data;
	}
	
	public  String[][] getDataFromExcel() throws BiffException, IOException  {
		//C:\Users\meenakshi.r\Desktop\Orange.xls
		FileInputStream file=new FileInputStream(new File("C:\\Users\\meenakshi.r\\Desktop\\testdata.xls"));
		Workbook wb=Workbook.getWorkbook(file);
		Sheet sheet=wb.getSheet(0);
		int col=	sheet.getColumns();
		int row = sheet.getRows();
		System.out.println(col+" "+row);
		//System.out.println(sheet.getCell(0,0).getContents());
		String[][] td=new String[row-1][col];
		for (int i = 1; i <row ; i++) {
			for (int j = 0; j < col; j++) {
				td[i-1][j]= sheet.getCell(j, i).getContents();
				System.out.println(td[i-1][j]);
				//System.out.print(sheet.getCell(j, i).getContents()+"\t");
			}
			System.out.println();
		}

		return td;
	}
	@BeforeSuite
	public void beforesuit() {
		 System.setProperty("webdriver.chrome.driver","D:\\Meena\\Selenium\\drivers\\chromedriver.exe");
			WebDriver wd=new ChromeDriver();
			wd.get("https://demo.nopcommerce.com/");
			wd.manage().window().maximize();
	}
  @Test(dataProvider = "a")
  public void login(String username, String password) {
	 
		
		//find login button
		WebElement login=wd.findElement(By.className("ico-login"));
		login.click();
		//Enter emailId
		WebElement eid=wd.findElement(By.id("Email"));
		eid.sendKeys(username);
		//Enter password
		WebElement pwd= wd.findElement(By.id("Password"));
		pwd.sendKeys("password");
		//click rememberme checkbox
		wd.findElement(By.id("RememberMe")).click();
		//click login button
		WebElement logbutn=wd.findElement(By.xpath("//button[@class='button-1 login-button']"));
		logbutn.click();
  }
}
