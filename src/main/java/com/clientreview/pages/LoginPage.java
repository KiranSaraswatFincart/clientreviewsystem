package com.clientreview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	@FindBy(xpath="//input[@formcontrolname='username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-fincart']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger mt-3 mb-0']")
	private WebElement IncorrectEmailPassword;
	
	@FindBy(xpath="(//div[@class='invalid-feedback'])[1]")
	private WebElement getUsernameIsRequired;
	
	@FindBy(xpath="(//div[@class='invalid-feedback'])[2]")
	private WebElement getPasswordIsRequiredField;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getUserName(String userNameText)
	{
		userName.sendKeys(userNameText);
	}
	public void getPassword(String passwordtext)
	{
		password.sendKeys(passwordtext);
	}
	public void clickLogin()
	{
		LoginButton.click();
	}
	public String WarningTextForEmailPaswwordIncorrect()
	{
		String IncorrectEmailPasswordText =IncorrectEmailPassword.getText();
		return IncorrectEmailPasswordText;
		
	}
	public String PasswordIsRequired() {
		String PasswordIsRequiredText=getPasswordIsRequiredField.getText();
		return PasswordIsRequiredText;
	
	}
	public String UsernameIsRequired() {
		String UsernameIsRequiredText=getUsernameIsRequired.getText();
		return UsernameIsRequiredText;
	
	}
	
}
