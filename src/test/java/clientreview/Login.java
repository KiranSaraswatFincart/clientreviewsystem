package clientreview; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clientreview.test.utils.Utilities;

import basepackage.Base;

public class Login extends Base {
	WebDriver driver;

	public Login() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		driver = intializeBrowserAndUrl(prop.getProperty("browserName"));

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(priority = 1)
	public void validLoginDetails() {
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='employee-detail-id active']")).isDisplayed());
	}

	@Test(priority = 2)
	public void invalidPasswordDetails() {
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		String expected = "Error: Username or password is incorrect";
		String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger mt-3 mb-0']")).getText();
		Assert.assertTrue(actual.contains(expected), expected);
	}

	@Test(priority = 3)
	public void invalidEmailDetails() {
		driver.findElement(By.xpath("//input[@formcontrolname='username']"))
				.sendKeys("shilpi.goyal" + Utilities.getTimeStamp() + "@fincart.com");
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		String expected = "Error: Username or password is incorrect";
		String actual = driver.findElement(By.xpath("//div[@class='alert alert-danger mt-3 mb-0']")).getText();
		Assert.assertTrue(actual.contains(expected), expected);
	}

	@Test(priority = 4)
	public void blankEmailDetails() {

		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		String expected = "Username is required";
		String actual = driver.findElement(By.xpath("(//div[@class='invalid-feedback'])[1]")).getText();
		Assert.assertTrue(actual.contains(expected), expected);
	}

	@Test(priority = 5)
	public void blankPasswordDetails() {
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(prop.getProperty("validEmail"));

		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		String expected = "Password is required";
		String actual = driver.findElement(By.xpath("(//div[@class='invalid-feedback'])[1]")).getText();
		Assert.assertTrue(actual.contains(expected), expected);
	}

	@Test(priority = 6)
	public void blankPasswordEmailDetails() {
		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		String expected = "Username is required";
		String actual = driver.findElement(By.xpath("(//div[@class='invalid-feedback'])[1]")).getText();
		Assert.assertTrue(actual.contains(expected), expected);
		String expectedPasswordMessage = "Password is required";
		String actualPasswordMessage = driver.findElement(By.xpath("(//div[@class='invalid-feedback'])[2]")).getText();
		Assert.assertTrue(actualPasswordMessage.contains(expectedPasswordMessage), expectedPasswordMessage);
	}

}       