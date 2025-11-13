package testcases.mytheresa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebdriverSettings {
    public static WebDriver driver;

    public static void driverSettings() {
        // Use system-wide ChromeDriver (installed in Jenkins Docker container)
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode (no GUI)
        options.addArguments("--no-sandbox"); // Required in Docker
        options.addArguments("--disable-dev-shm-usage"); // Prevents crash on shared memory
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
    }
}
