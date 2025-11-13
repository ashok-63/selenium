public void logIn() {
    driver.get("https://www.mytheresa.com/en-de/"); // full URL

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    // ✅ 1️⃣ Accept cookies popup if visible
    try {
        WebElement cookieButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("button[class*='cookie']")));
        cookieButton.click();
        System.out.println("✅ Cookie consent accepted");
    } catch (Exception e) {
        System.out.println("ℹ️ No cookie popup found.");
    }

    // ✅ 2️⃣ Wait for 'My Account' element — try multiple locators
    WebElement myAccount = null;
    try {
        myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='customer/account']")));
    } catch (Exception e1) {
        try {
            myAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'My account') or contains(.,'Account')]")));
        } catch (Exception e2) {
            throw new RuntimeException("❌ Could not find My Account button on page");
        }
    }

    myAccount.click();

    // ✅ 3️⃣ Wait for email field
    WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    email.sendKeys("testuser@example.com");

    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("TestPassword123");

    WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));
    loginButton.click();
}
