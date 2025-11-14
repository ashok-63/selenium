package testcases.mytheresa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewUserJourney {

    WebDriver driver;

    @Test
    public void logIn() {
        driver.get("https://www.mytheresa.com/en-de/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Accept cookies popup if visible
        try {
            WebElement cookieButton = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("button[class*='cookie']"))
            );
            cookieButton.click();
            System.out.println("Cookie consent accepted");
        } catch (Exception e) {
            System.out.println("No cookie popup found.");
        }

        // Locate "My Account"
        WebElement myAccount = null;
        try {
            myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("a[href*='customer/account']")));
        } catch (Exception e1) {
            try {
                myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[contains(.,'My account') or contains(.,'Account')]")));
            } catch (Exception e2) {
                throw new RuntimeException("Could not find My Account button on page");
            }
        }

        myAccount.click();

        // Email field
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("testuser@example.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("TestPassword123");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
        loginButton.click();
    }
}
