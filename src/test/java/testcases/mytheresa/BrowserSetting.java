package testcases.mytheresa;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import static variables.mytheresa.UrlVariables.*;

public class BrowserSetting {

    public WebDriver BrowserSettings() {

        // Initialize WebDriver
        WebdriverSettings.initialize();
        WebDriver driver = WebdriverSettings.driver;

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(BASE_URL);

        return driver;
    }
}
