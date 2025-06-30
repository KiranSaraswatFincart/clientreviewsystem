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

	@FindBy(xpath = "//button[normalize-space()='Search']")
	private WebElement SearchElement;

	@FindBy(xpath = "//span[@class='dropdown-btn']")
	private WebElement CategoryFilter;

	@FindBy(xpath = "//div[contains(text(),'Select All')]")
	private WebElement DeSelectFilter;

	@FindBy(xpath = "//input[@aria-label='Beta']")
	private WebElement Selectcategory;

	@FindBy(xpath = "//input[@value='team']")
	private WebElement myTeamRadioButton;
	
	@FindBy(xpath="//tbody/tr[1]/td[4]")
    private WebElement ReviewPending;
	
	@FindBy(xpath="(//i)[@class='fa fa-ellipsis-v text-primary'][1]")
	private WebElement EllipsisClick;
	
	@FindBy(xpath="//div[normalize-space()='Mark Review']")
	private WebElement MarkReviewNavigation;
	
	@FindBy(xpath="//span[@class='dropdown-btn']")
	private WebElement discussionPoint;
	
	@FindBy(xpath="//div[normalize-space()='Market Update']")
	private WebElement selectDiscussionPoint;
	
	@FindBy(xpath="//input[@name='datetime']")
	private WebElement datePicker;
	
	@FindBy(xpath="//input[@ng-reflect-model='2025-07-01T15:43']")
	private WebElement enterDate;
	
	@FindBy(xpath="//div[@aria-label='Rich Text Editor, main']")
	private WebElement commentAdd;
	
	@FindBy(xpath="//button[@class='btn btn-save']")
	private WebElement saveMarkreview;
	
	public NavigationToClientReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void OpenSideMenuScreen() {
		OpenSideMenu.click();
	}

	public void navaigateToReports() {
		navaigateToClientScreen.click();

	}
	
	public void EllipsisClick()
	{
		EllipsisClick.click();
	}
  
	public void MarkReviewNavigation() {
		MarkReviewNavigation.click();
	}
	public void ClickToClientScreen() {
		navaigateToClientScreen.click();

	}

	public void SearchElementClick() {
		SearchElement.click();
	}

	public void CategoryFilterSearch() {
		CategoryFilter.click();
	}

	public void DeSelectFilter() {
		DeSelectFilter.click();
	}

	public void Selectcategory() {
		Selectcategory.click();
	}

	public void myTeamRadioButton() {
		myTeamRadioButton.click();
	}
	public void PendingReviewCount()
	{
		ReviewPending.click();
	}
	
	public void discussionPoint()
	{
		discussionPoint.click();
	}
	public void selectDiscussionPoint()
	{
		selectDiscussionPoint.click();
	}
	public void datePicker()
	{
		datePicker.click();
	}
	public void enterDate()
	{
		enterDate.click();	
	}
	public void commentAdd()
	{
		commentAdd.sendKeys("This is the automated generated code for mark review screen");
	}
	public void saveMarkreview()
	{
		saveMarkreview.click();
	}
}