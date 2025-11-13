package testcases.mytheresa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class WishListCheckAdd {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Initialize Chrome in headless mode
        WebdriverSettings.initialize();
        driver = WebdriverSettings.driver;
    }

    @Test
    public void WishList() {
        logIn();

        // ✅ Example action after login — adjust as per your site
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement wishlistIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".wishlist-icon")));
        wishlistIcon.click();

        // Example assertion (customize based on your application)
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Wishlist"), "Wishlist page not loaded!");
    }

    public void logIn() {
        driver.get("https://www.mytheresa.com/"); // change to BASE_URL if you use UrlVariables

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // ✅ Wait for “My Account” link instead of directly finding it
        WebElement myAccount = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("myaccount"))
        );
        myAccount.click();

        // ✅ Wait for login form elements
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("testuser@example.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("TestPassword123");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
        loginButton.click();
    }

    @AfterMethod
    public void tearDown() {
        WebdriverSettings.tearDown();
    }
}
