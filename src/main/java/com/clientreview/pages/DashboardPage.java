package com.clientreview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	public	WebDriver driver;
	
	@FindBy(xpath="//a[@class='employee-detail-id active']")
	private WebElement loggedInMailIsDisplayed;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean loggedInMailIsDisplayedText()
	{
		boolean AccountName= loggedInMailIsDisplayed.isDisplayed();
		return AccountName;
	}
}
