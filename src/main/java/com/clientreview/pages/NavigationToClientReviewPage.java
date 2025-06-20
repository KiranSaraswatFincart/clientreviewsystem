package com.clientreview.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationToClientReviewPage {
	public WebDriver driver;
	@FindBy(xpath = "//a[@class='fin-menu-icon position-absolute rounded-right']//i[@class='fa fa-chevron-right']")
	private WebElement OpenSideMenu;

	@FindBy(xpath = "//a[normalize-space()='Reports']")
	private WebElement navaigateToReports;
	
	@FindBy(xpath = "//a[normalize-space()='Client Activity Review']")
	private WebElement navaigateToClientScreen;
	public NavigationToClientReviewPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void OpenSideMenuScreen() {
		OpenSideMenu.click();
	}
	public void navaigateToReports() {
		navaigateToClientScreen.click();

	}

	public void ClickToClientScreen() {
		navaigateToClientScreen.click();

	}

}