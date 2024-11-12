package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.GetUtility.getURL;

public class Case17 extends BaseTest {

    @Test
    public void testRemoveProductFromCart(){
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "Home Page was not displayed");
        homePage.clickAddToFirstProduct();
        homePage.clickContinueShoppingButton();
        homePage.clickAddToSecondProduct();
        homePage.clickContinueShoppingButton();
        var cartPage = homePage.goToCart();
        String expectedURL = "https://automationexercise.com/view_cart";
        String actualURL = getURL();
        Assert.assertEquals(expectedURL, actualURL,
                "Cart Page Was Not Displayed");
        cartPage.clickDeleteFirstProduct();
        String expectedText = "Blue Top";
        String actualText = cartPage.getFirstProductDesc();
        Assert.assertEquals(expectedText, actualText,
                "Delete Func Is Not Working");
    }

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click 'X' button corresponding to particular product
8. Verify that product is removed from the cart
     */
}
