package clientreview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepackage.Base;

public class ForgotPassword extends Base {

	WebDriver driver;

	public ForgotPassword() {
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
	public void ForgotPasswordForUnregisteredEmail() {
		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(dataProp.getProperty("invalidEmail"));
		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		String Actual = driver.findElement(By.xpath("//div[@class='alert alert-danger mt-3 mb-0']")).getText();
		String Expected = "Email id not exist. Enter valid email id !!!";
		Assert.assertTrue(Actual.contains(Expected), Expected);

	}

	@Test(priority = 2)
	public void ForgotPasswordWithoutEmail() {
		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		String ActualBlankPasswordMesaage = driver.findElement(By.xpath("//div[@class='invalid-feedback']")).getText();
		String ExpectedBlankPasswordMesaage = "email is required";
		Assert.assertTrue(ActualBlankPasswordMesaage.contains(ExpectedBlankPasswordMesaage),
				ExpectedBlankPasswordMesaage);
	}
	
	@Test(priority = 3)
	public void NavigateBackToLogin()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		
	}
	@Test(priority=4)
	public void ForgotPasswordWithBlankDetails()
	{
		ForgotPasswordValidation();
		driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
		String ExpectedOtpError="Mandatory fields can't be left blank.";
		String ActualOtpError=driver.findElement(By.xpath("(//span[@id='otpcode_error'])[1]")).getText();
		Assert.assertEquals(ActualOtpError.contains(ExpectedOtpError), ExpectedOtpError);
		String ExpectedPasswordError="Mandatory fields can't be left blank.";
		String ActualPasswordError=driver.findElement(By.xpath("(//span[@id='confirmpassword_error'])[1]")).getText();
		Assert.assertTrue(ActualPasswordError.contains(ExpectedPasswordError), ExpectedPasswordError);
		}
	@Test(priority=5)
	public void passwordValidationWithLength()
	{
		ForgotPasswordValidation();
		driver.findElement(By.xpath("(//input[@id='otpcode'])[1]")).sendKeys(dataProp.getProperty("otp"));
		driver.findElement(By.xpath("//button[normalize-space()='RESET PASSWORD']")).click();
		String ActualPasswordValidation=driver.findElement(By.xpath("(//span[@id='newPassword_error'])[1]")).getText();
		String ExpectedPasswordValidation="Password allow minimum 8 charcter one uppercase and special and one number";
		Assert.assertTrue(ActualPasswordValidation.contains(ExpectedPasswordValidation), ExpectedPasswordValidation);
	}
	
	@Test(priority=6)
	public void samePasswordValidation()
	{
		ForgotPasswordValidation();
		driver.findElement(By.xpath("(//input[@id='otpcode'])[1]")).sendKeys(dataProp.getProperty("otp"));
		driver.findElement(By.xpath("(//input[@id='newPassword'])[1]")).sendKeys(prop.getProperty("NewPassword"));
		driver.findElement(By.xpath("(//input[@id='confirmpassword'])[1]")).sendKeys(prop.getProperty("NewPassword")+"we");
		driver.findElement(By.xpath("//button[normalize-space()='RESET PASSWORD']")).click();
		String Actualconfirmpassword=driver.findElement(By.xpath("(//div[@class='alert alert-danger mt-3 mb-0']")).getText();
		String Expectedconfirmpassword="new password is not match";
		Assert.assertTrue(Actualconfirmpassword.contains(Expectedconfirmpassword), Expectedconfirmpassword);
	}

	@Test(priority=7)
	public void invalidOtp()
	{
		ForgotPasswordValidation();
		driver.findElement(By.xpath("(//input[@id='otpcode'])[1]")).sendKeys(dataProp.getProperty("otp"));
		driver.findElement(By.xpath("(//input[@id='newPassword'])[1]")).sendKeys(prop.getProperty("NewPassword"));
		driver.findElement(By.xpath("(//input[@id='confirmpassword'])[1]")).sendKeys(prop.getProperty("NewPassword"));
		driver.findElement(By.xpath("//button[normalize-space()='RESET PASSWORD']")).click();
		String ActualInvalidOtp=driver.findElement(By.xpath("(//div[@class='alert alert-danger mt-3 mb-0']")).getText();
		String ExpectedInvalidOtp="Invalid OTP";
		Assert.assertTrue(ActualInvalidOtp.contains(ExpectedInvalidOtp), ExpectedInvalidOtp);
	}
	@Test(priority=8)
	public void validDetails()
	{
		ForgotPasswordValidation();
		driver.findElement(By.xpath("(//input[@id='otpcode'])[1]")).sendKeys(prop.getProperty("validOtp"));
		driver.findElement(By.xpath("(//input[@id='newPassword'])[1]")).sendKeys(prop.getProperty("NewPassword"));
		driver.findElement(By.xpath("(//input[@id='confirmpassword'])[1]")).sendKeys(prop.getProperty("NewPassword"));
		driver.findElement(By.xpath("//button[normalize-space()='RESET PASSWORD']")).click();
		String ActualvalidDetails=driver.findElement(By.xpath("//strong[normalize-space()='Submission Successful !!!']")).getText();
		String ExpectedvalidDetails="Submission Successful !!!";
		Assert.assertTrue(ActualvalidDetails.contains(ExpectedvalidDetails), ExpectedvalidDetails);
		driver.findElement(By.xpath("//button[.='Close']")).click();
	}
}
