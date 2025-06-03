package clientreview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clientreview.dbconnection.DBUtils;
import com.clientreview.pages.ForgotPasswordPages;

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
	public void ForgotPasswordForUnregisteredEmail(String Email) {
		ForgotPasswordPages forgotPassword = new ForgotPasswordPages(driver);
		forgotPassword.forgotPasswordLinkCLick();
		waitForSpinnerToDisappear();

		forgotPassword.getEmailField(dataProp.getProperty("invalidEmail"));
		forgotPassword.sendCodeButtonClick();
		forgotPassword.ErrorMessageActual();
		String Actual = forgotPassword.ErrorMessageActual();
		String Expected = "Email id not exist. Enter valid email id !!!";
		Assert.assertTrue(Actual.contains(Expected), Expected);

	}

	@Test(priority = 2)
	public void ForgotPasswordWithoutEmail() {
		ForgotPasswordPages forgotPassword = new ForgotPasswordPages(driver);
		forgotPassword.forgotPasswordLinkCLick();
		forgotPassword.sendCodeButtonClick();
		
		waitForSpinnerToDisappear();
		String ActualBlankPasswordMesaage = forgotPassword.getBlankEmailMessage();
		String ExpectedBlankPasswordMesaage = "email is required";
		Assert.assertTrue(ActualBlankPasswordMesaage.contains(ExpectedBlankPasswordMesaage),
				ExpectedBlankPasswordMesaage);
	}

	@Test(priority = 3)
	public void NavigateBackToLogin() {
		ForgotPasswordPages forgotPassword = new ForgotPasswordPages(driver);
		forgotPassword.forgotPasswordLinkCLick();
		forgotPassword.loginLinkClick();

	}

	@Test(priority = 4)
	public void ForgotPasswordWithBlankDetails() {
		ForgotPasswordValidation();
		ForgotPasswordPages forgotPassword = new ForgotPasswordPages(driver);
		forgotPassword.sendCodeButtonClick();
		waitForSpinnerToDisappear();
		String ExpectedOtpError = "Mandatory fields can't be left blank.";
		String ActualOtpError = forgotPassword.getOtpErrorMessage();
		Assert.assertEquals(ActualOtpError.contains(ExpectedOtpError), ExpectedOtpError);
		String ExpectedPasswordError = "Mandatory fields can't be left blank.";
		String ActualPasswordError = forgotPassword.getPasswordBlankErrorMessage();
		Assert.assertTrue(ActualPasswordError.contains(ExpectedPasswordError), ExpectedPasswordError);
	}

	@Test(priority = 5)
	public void passwordValidationWithLength() {
		ForgotPasswordValidation();
		waitForSpinnerToDisappear();

		ForgotPasswordPages forgotPassword = new ForgotPasswordPages(driver);
		forgotPassword.enterOtpCode(dataProp.getProperty("otp"));
		forgotPassword.enterNewPasswordText(prop.getProperty("ShortLengthPassword"));
		forgotPassword.enterConfirmPasswordText(prop.getProperty("ShortLengthPassword"));
		forgotPassword.resetPasswordButtonClick();
		String ActualPasswordValidation = forgotPassword.validationForPasswordCheck();
		String ExpectedPasswordValidation = "Password allow minimum 8 charcter one uppercase and special and one number";
		Assert.assertTrue(ActualPasswordValidation.contains(ExpectedPasswordValidation), ExpectedPasswordValidation);
	}

	@Test(priority = 6)
	public void samePasswordValidation() {
		ForgotPasswordValidation();
		waitForSpinnerToDisappear();

		ForgotPasswordPages forgotPassword = new ForgotPasswordPages(driver);
		forgotPassword.enterOtpCode(dataProp.getProperty("otp"));
		forgotPassword.enterNewPasswordText(prop.getProperty("NewPassword"));
		forgotPassword.enterConfirmPasswordText(prop.getProperty("NewPassword") + "hh");
		forgotPassword.resetPasswordButtonClick();
		String Actualconfirmpassword = forgotPassword.ErrorMessageActual();
		String Expectedconfirmpassword = "new password is not match";
		Assert.assertTrue(Actualconfirmpassword.contains(Expectedconfirmpassword), Expectedconfirmpassword);
	}

	@Test(priority = 7)
	public void invalidOtp() {
		ForgotPasswordValidation();
		waitForSpinnerToDisappear();

		ForgotPasswordPages forgotPassword = new ForgotPasswordPages(driver);
		forgotPassword.enterOtpCode(dataProp.getProperty("otp"));
		forgotPassword.enterNewPasswordText(prop.getProperty("NewPassword"));
		forgotPassword.enterConfirmPasswordText(prop.getProperty("NewPassword"));
		forgotPassword.resetPasswordButtonClick();

		String ActualInvalidOtp = forgotPassword.ErrorMessageActual();
		String ExpectedInvalidOtp = "Invalid OTP";
		Assert.assertTrue(ActualInvalidOtp.contains(ExpectedInvalidOtp), ExpectedInvalidOtp);
	}

	@Test(priority = 8)
	public void validDetails() {
		ForgotPasswordValidation();
		System.out.println("33");

		waitForSpinnerToDisappear();
		ForgotPasswordPages forgotPassword = new ForgotPasswordPages(driver);
		forgotPassword.enterOtpCodes();
	

		// Fetch the latest OTP from DB (without using email)
		String dbOtp = DBUtils.getLatestOtp();

		// Use OTP in the form
		forgotPassword.enterOtpCode(dbOtp);
		forgotPassword.enterNewPasswordTexts();
		forgotPassword.enterNewPasswordText(prop.getProperty("NewPassword"));
		forgotPassword.enterConfirmPasswordTexts();
		forgotPassword.enterConfirmPasswordText(prop.getProperty("NewPassword"));
		forgotPassword.resetPasswordButtonClick();
		String ActualvalidDetails = forgotPassword.getSuccessfullyPasswordChanged();
		String ExpectedvalidDetails = "Submission Successful !!!";
		Assert.assertTrue(ActualvalidDetails.contains(ExpectedvalidDetails), ExpectedvalidDetails);
		driver.findElement(By.xpath("//button[.='Close']")).click();
	}
}
