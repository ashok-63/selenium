System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

ChromeOptions options = new ChromeOptions();
options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
driver = new ChromeDriver(options);
