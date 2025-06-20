package clientreview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.clientreview.pages.NavigationToClientReviewPage;

public class NaviagtionToClientReview extends Login{

	public NaviagtionToClientReview()
	{
		super();
	}

	@Test(priority=2)
	public void searchWithValidEmail() throws InterruptedException
	{ 
		Thread.sleep(2000);
		OpenSideMenu();
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