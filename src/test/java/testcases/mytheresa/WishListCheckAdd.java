package testcases.mytheresa;

import base.WebdriverSettings;
import org.testng.annotations.Test;

public class WishListCheckAdd extends WebdriverSettings {

    @Test
    public void testWishlist() {

        driver.get("https://www.mytheresa.com/en-de/");

        System.out.println("Wishlist Test Running...");

        // Your wishlist code goes here
    }
}
