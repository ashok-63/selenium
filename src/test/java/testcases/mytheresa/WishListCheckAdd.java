package testcases.mytheresa;

<<<<<<< HEAD
import base.BaseTest;
import org.testng.annotations.Test;

public class WishListCheckAdd extends BaseTest {

    @Test
    public void testWishlistCheckAdd() {

        driver.get("https://www.mytheresa.com/");

        // your wishlist test steps…
        System.out.println("Running Wishlist Add Test...");
=======
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishListCheckAdd {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void logIn() {
        driver.get("https://www.mytheresa.com/en-de/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            WebElement cookieButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("button[class*='cookie']")));
            cookieButton.click();
        } catch (Exception ignored) { }

        WebElement myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("a[href*='customer/account']")));

        myAccount.click();

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("testuser@example.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("TestPassword123");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
        loginButton.click();
>>>>>>> 8e3621820a5c3a5b6a2b14b2b2b82a1c33b7ff2d
    }
}
