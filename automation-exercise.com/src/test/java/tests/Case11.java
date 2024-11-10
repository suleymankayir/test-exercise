package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case11 extends BaseTest {


    @Test
    public void testCartPageSub(){
        Assert.assertTrue(homePage.isHomePageLogoVisible());
        var cartPage = homePage.goToCart();
        String actualText = cartPage.verifySubscriptionText();
        String expectedText = "SUBSCRIPTION";
        Assert.assertEquals(actualText,expectedText,
                "Actual & Expected Text Does Not Match");
        cartPage.setSubEmail("aliceneverland@hotmail.com");
        cartPage.clickSubArrowButton();
        String actualSubResultText = cartPage.getSubSuccessText();
        String expectedSubResultText ="You have been successfully subscribed!";
        Assert.assertEquals(expectedSubResultText, actualSubResultText,
                "Actual & Expected Subscription Result Text Does Not Match");

    }


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Cart' button
5. Scroll down to footer
6. Verify text 'SUBSCRIPTION'
7. Enter email address in input and click arrow button
8. Verify success message 'You have been successfully subscribed!' is visible
     */
}
