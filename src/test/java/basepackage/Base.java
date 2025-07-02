package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.clientreview.test.utils.Utilities;

public class Base {
    public static WebDriver driver;
    protected WebDriverWait wait;
    public Properties prop;
    public Properties dataProp;

    public Base() {
        prop = new Properties();
        dataProp = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src\\main\\java\\propertiesfile\\propertyfile.properties");
            prop.load(fis);

            FileInputStream fis1 = new FileInputStream("src\\main\\java\\TestDataPackage\\TestData.properties");
            dataProp.load(fis1);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void setUpSuite() {
        driver = initializeBrowserAndUrl(prop.getProperty("browserName"));
    }

    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver initializeBrowserAndUrl(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
        driver.get(prop.getProperty("url"));
        return driver;
    }

    public void ForgotPasswordValidation() {
        driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
        driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(dataProp.getProperty("ValidEmail"));
        driver.findElement(By.xpath("//button[@class='btn btn-fincart']")).click();
    }

    public void waitForSpinnerToDisappear() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner']")));
        } catch (Exception e) {
            System.out.println("Loader not present or already disappeared.");
        }
    }
}
