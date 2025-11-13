package testcases.mytheresa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebdriverSettings {

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
    }
}
