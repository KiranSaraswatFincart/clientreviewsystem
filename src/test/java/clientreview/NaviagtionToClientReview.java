package clientreview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NaviagtionToClientReview extends Login{

	public NaviagtionToClientReview()
	{
		super();
	}
	@Test
	public void OpenSideMenu()
	{
		
		WebElement employeeLink = driver.findElement(By.xpath("//a[@class='employee-detail-id active']"));
		if (employeeLink.isDisplayed()) {
		    driver.findElement(By.xpath("//a[@class='fin-menu-icon position-absolute rounded-right']")).click();
		}

	    Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/profile']")).isDisplayed());
	}
	
	@Test(priority=1)
	public void searchWithValidEmail()
	{
		driver.findElement(By.xpath("//input[@id='SearchByEmail']")).click();
		driver.findElement(By.xpath("//input[@id='searchLead']")).sendKeys("mayanknegi716@gmail.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement userDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.xpath("//div[.='KIRAN SARASWAT(mayanknegi716@gmail.com)']")));

		Assert.assertTrue(userDiv.isDisplayed(), "Expected user was not displayed");
		userDiv.click();
        driver.findElement(By.xpath("//input[@value='Search']")).click();
	
}
	
}