package testcases.mytheresa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebdriverSettings {
<<<<<<< HEAD
    public static WebDriver driver;

    public static void driverSettings() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
=======

    protected static WebDriver driver;

    public static void initialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Important for Jenkins/Docker
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
>>>>>>> 8e3621820a5c3a5b6a2b14b2b2b82a1c33b7ff2d
    }
}
