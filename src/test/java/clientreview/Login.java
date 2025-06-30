package clientreview; 

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.clientreview.pages.DashboardPage;
import com.clientreview.pages.LoginPage;
import com.clientreview.test.utils.Utilities;

import basepackage.Base;

public class Login extends Base {
	public	WebDriver driver;

	public Login() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		driver = intializeBrowserAndUrl(prop.getProperty("browserName"));
		

	}

//	@AfterMethod
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}

//	@Test(priority = 1, dataProvider = "validDataProvider")
//	public void validLoginDetails(String userNames, String passwords) {
//	    // Create an instance of the LoginPage and use the provided data
//	    LoginPage loginPage = new LoginPage(driver);
//	    loginPage.getUserName(userNames);  // Use the data provider values
//	    loginPage.getPassword(passwords);  // Use the data provider values
//	    loginPage.clickLogin();
//
//	    // Create an instance of the DashboardPage to check if the user is logged in
//	    DashboardPage dashboardPage = new DashboardPage(driver);
//	    
//	    // Assert that the logged-in email is displayed
//	    Assert.assertTrue(dashboardPage.loggedInMailIsDisplayedText(), "User email is not displayed on dashboard.");
//	}
//	@DataProvider(name = "validDataProvider")
//	public Object[][] supplyTestData() {
//	    Object[][] data = null;
//	    try {
//	        // Fetch the data from Excel using the Utilities.fetchDataFromExcel method
//	        data = Utilities.fetchDataFromExcel("LoginData");
//	    } catch (IOException e) {
//	        // Log the error and optionally fail the test if data cannot be loaded
//	        e.printStackTrace();
//	        Assert.fail("Failed to load test data from Excel", e); // This will fail the test if data can't be loaded
//	    }
//	    return data;
//	}
//	@Test(priority = 2)
//	public void invalidPasswordDetails() {
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.getUserName(prop.getProperty("validEmail"));
//		loginPage.getPassword(dataProp.getProperty("invalidPassword"));
//		loginPage.clickLogin();
//		String expected = "Error: Username or password is incorrect";
//		String actual =loginPage.WarningTextForEmailPaswwordIncorrect();
//		Assert.assertTrue(actual.contains(expected), expected);
//	}
//
//	@Test(priority = 3)
//	public void invalidEmailDetails() {
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.getUserName(Utilities.getTimeStamp() + "@fincart.com");
//		loginPage.getPassword(prop.getProperty("validPassword"));
//		loginPage.clickLogin();
//
//		String expected = "Error: Username or password is incorrect";
//		String actual =loginPage.WarningTextForEmailPaswwordIncorrect();
//		Assert.assertTrue(actual.contains(expected), expected);
//	}
//
//	@Test(priority = 4)
//	public void blankEmailDetails() {
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.getPassword(prop.getProperty("validPassword"));
//		loginPage.clickLogin();
//
//		String expected = "Username is required";
//		String actual = loginPage.UsernameIsRequired();
//		Assert.assertTrue(actual.contains(expected), expected);
//	}
//
//	@Test(priority = 5)
//	public void blankPasswordDetails() {
//		LoginPage loginPage=new LoginPage(driver);
//        loginPage.getUserName(prop.getProperty("validEmail"));
//		loginPage.clickLogin();
//
//		String expected = "Password is required";
//		String actual = loginPage.UsernameIsRequired();
//		Assert.assertTrue(actual.contains(expected), expected);
//	}
//
//	@Test(priority = 6)
//	public void blankPasswordEmailDetails() {
//		LoginPage loginPage=new LoginPage(driver);
//		loginPage.clickLogin();
//
//		String expected = "Username is required";
//		String actual = loginPage.UsernameIsRequired();
//		Assert.assertTrue(actual.contains(expected), expected);
//		String expectedPasswordMessage = "Password is required";
//		String actualPasswordMessage =loginPage.PasswordIsRequired();
//		Assert.assertTrue(actualPasswordMessage.contains(expectedPasswordMessage), expectedPasswordMessage);
//	}
//	
	@Test(priority =7)
	public void validLoginDetailsCheck() {
	
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.getUserName(prop.getProperty("validEmail"));  // Use the data provider values
	    loginPage.getPassword(prop.getProperty("validPassword"));  // Use the data provider values
	    loginPage.clickLogin();


	    DashboardPage dashboardPage = new DashboardPage(driver);
	    
	    Assert.assertTrue(dashboardPage.loggedInMailIsDisplayedText(), "User email is not displayed on dashboard.");
	}

}       