package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case10 extends BaseTest {

    @Test
    public void testSubscribe(){
        Assert.assertTrue(homePage.isHomePageLogoVisible());
        String actualText =  homePage.verifySubscriptionText();
        String expectedText = "SUBSCRIPTION";
        Assert.assertEquals(actualText,expectedText,
                "Actual & Expected Text Does Not Match");
        homePage.setSubEmail("aliceneverland@hotmail.com");
        homePage.clickSubArrowButton();
        String actualSubResultText = homePage.getSubSuccessText();
        String expectedSubResultText ="You have been successfully subscribed!";
        Assert.assertEquals(expectedSubResultText, actualSubResultText,
                "Actual & Expected Subscription Result Text Does Not Match");
    }



    /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Scroll down to footer
5. Verify text 'SUBSCRIPTION'
6. Enter email address in input and click arrow button
7. Verify success message 'You have been successfully subscribed!' is visible
     */
}
