package com.clientreview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPages {
	public WebDriver driver;
	@FindBy(xpath = "//input[@formcontrolname='email']")
	private WebElement getEmail;

	@FindBy(xpath = "//a[normalize-space()='Forgot Password?']")
	private WebElement forgotPasswordLiink;

	@FindBy(xpath = "//button[@class='btn btn-fincart']")
	private WebElement sendCodeButton;

	@FindBy(xpath = "//div[@class='alert alert-danger mt-3 mb-0']")
	private WebElement getErrorMessageActual;

	@FindBy(xpath = "//div[@class='invalid-feedback']")
	private WebElement blankEmailMessage;

	@FindBy(xpath = "//a[@href='/login']")
	private WebElement loginClick;

	@FindBy(xpath = "(//span[@id='otpcode_error'])[1]")
	private WebElement otpErrorMessage;

	@FindBy(xpath = "(//span[@id='confirmpassword_error'])[1]")
	private WebElement passwordBlankErrorMessage;

	@FindBy(xpath = "//form[@id='passwordValidatetion']//div[1]")
	private WebElement enterOtp;

	@FindBy(xpath = "//form[@id='passwordValidatetion']//div[2]")
	private  WebElement enternewPassword;

	@FindBy(xpath = "//form[@id='passwordValidatetion']//div[3]")
	private WebElement confirmPassword;

	@FindBy(xpath="//button[normalize-space()='RESET PASSWORD']")
	private WebElement resetPasswordButton;
	
	@FindBy (xpath="(//span[@id='newPassword_error'])[1]")
	private WebElement validationForPassword;
	
	@FindBy(xpath="//strong[normalize-space()='Submission Successful !!!']")
	private WebElement successfullyPasswordChanged;
	

	public ForgotPasswordPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getEmailField(String Email) {
		getEmail.sendKeys(Email);
	}

	public void forgotPasswordLinkCLick() {
		forgotPasswordLiink.click();
	}

	public void sendCodeButtonClick() {
		sendCodeButton.click();
	}

	public String ErrorMessageActual() {
		String getErrorMessageActualText = getErrorMessageActual.getText();
		return getErrorMessageActualText;

	}

	public String getBlankEmailMessage() {
		String blankEmailMessageText = blankEmailMessage.getText();
		return blankEmailMessageText;

	}

	public void loginLinkClick() {
		loginClick.click();
	}

	public String getOtpErrorMessage() {
		String otpErrorMessageText = otpErrorMessage.getText();
		return otpErrorMessageText;
	}

	public String getPasswordBlankErrorMessage() {
		String passwordBlankErrorMessageText = passwordBlankErrorMessage.getText();
		return passwordBlankErrorMessageText;
	}
	public void enterOtpCodes() {
		enterOtp.click();
	}
  
	public void enterOtpCode(String otp) {
		enterOtp.sendKeys(otp);
	}
	public void enterNewPasswordTexts() {
		enternewPassword.click();
	}
	public void enterNewPasswordText(String newPassword) {
		enternewPassword.sendKeys(newPassword);
	}
	public void enterConfirmPasswordTexts() {
		confirmPassword.click();
	}
	public void enterConfirmPasswordText(String confirmPasswordCode) {
		confirmPassword.sendKeys(confirmPasswordCode);
	}
	public void resetPasswordButtonClick()
	{
		resetPasswordButton.click();
	}
	public String validationForPasswordCheck()
	{
		String validationcheckPasswords =validationForPassword.getText();
		return validationcheckPasswords;
	}
	public String getSuccessfullyPasswordChanged()
	{
		String getSuccessfullyPasswordChangedText=successfullyPasswordChanged.getText();
		return getSuccessfullyPasswordChangedText;
	}
	
	
}
