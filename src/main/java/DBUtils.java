import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DBUtils {

    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://uatfincart.database.windows.net:1433;"
                + "database=YourDatabaseName;" // replace with actual DB name
                + "user=FinUatKiran;"          // as per your screenshot
                + "password=YourPasswordHere;" // your DB password
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "loginTimeout=30;";

        String otp = "";

        try {
            // Connect to SQL Server
            Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();

            // Adjust query as per your actual table/column names
            String query = "SELECT TOP 1 otp_column FROM otp_table WHERE user_id = 'testuser' ORDER BY created_at DESC";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                otp = resultSet.getString("otp_column"); // Replace 'otp_column' with your real OTP column name
                System.out.println("Fetched OTP: " + otp);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Selenium part
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://your-otp-page-url.com");

        // Enter OTP into the web page
        driver.findElement(By.id("otp_input_field")).sendKeys(otp); // Adjust locator here

        // Continue with rest of the Selenium script
    }
}
