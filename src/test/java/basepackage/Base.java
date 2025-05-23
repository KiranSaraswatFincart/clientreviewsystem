package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.clientreview.test.utils.Utilities;

public class Base {
	public Properties prop;
	public Properties dataProp;
	public  Base() {
		 prop=new Properties();
		 dataProp=new Properties();
		File propFile=new File("src\\main\\java\\propertiesfile\\propertyfile.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);

			
		} catch ( Throwable e) {
			
			e.printStackTrace();
		}
			
	
	    
		File dataPropFile=new File("src\\main\\java\\TestDataPackage\\TestData.properties");
		
		try {
			FileInputStream fis1 = new FileInputStream(dataPropFile);
			dataProp.load(fis1);

			
		} catch ( Throwable e) {
			
			e.printStackTrace();
		}
			}

  WebDriver driver;
  public WebDriver intializeBrowserAndUrl(String browserName)
  {
	  
	
	if (browserName.equalsIgnoreCase("Chrome"))
	{
		driver = new ChromeDriver();
	}
	
	else if(browserName.equalsIgnoreCase("firebox"))
	{
		driver = new FirefoxDriver();
	}
	
	else if(browserName.equalsIgnoreCase("safari"))
	{
		driver = new SafariDriver();
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		driver = new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
	driver.get(prop.getProperty("url"));
	return driver;
}
	public  void ForgotPasswordValidation()
	{

		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(dataProp.getProperty("ValidEmail"));
		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		
	}
}