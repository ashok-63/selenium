package testcases.mytheresa;

import base.WebdriverSettings;
import org.testng.annotations.Test;

public class NewUserJourney extends WebdriverSettings {

    @Test
    public void testUserJourney() {

        driver.get("https://www.mytheresa.com/en-de/");

        System.out.println("New User Journey Test Running...");

        // Add real test steps here
    }
}
