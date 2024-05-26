package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.rmi.RemoteException;
import java.time.Duration;

public class CommonMethods {

    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() throws IOException {
        ConfigReader.readProperties("C:\\Users\\Михаил\\TestNgBasicsb10\\src\\config\\config.properties");
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.drivers", "drivers/chromdriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("browser not available");
                break;
            default:
                throw new RemoteException("Invalid browser name");

        }

        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}