package testcases.mytheresa;

import base.BaseTest;
import org.testng.annotations.Test;

public class NewUserJourney extends BaseTest {

    @Test
    public void testUserJourney() {

        driver.get("https://www.mytheresa.com/");

        // your existing steps here
        System.out.println("Running New User Journey Test...");
    }
}
