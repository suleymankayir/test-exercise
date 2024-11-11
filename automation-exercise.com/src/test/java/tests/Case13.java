package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.GetUtility.getURL;

public class Case13 extends BaseTest {


    @Test
    public void testProductQuantity(){

        Assert.assertTrue(homePage.isHomePageLogoVisible());
        var singleProduct = homePage.viewToProduct();
        String expectedURL = "https://automationexercise.com/product_details";
        String actualURL = getURL();
        Assert.assertTrue(actualURL.contains(expectedURL),
                "Product Detail Page Was Not Displayed");
        singleProduct.setQuantity("4");
        singleProduct.clickAddToCart();
        var cartPage = singleProduct.clickViewCart();
        String actualQuantity = cartPage.getQuantity();
        String expectedQuantity = "4";
        Assert.assertEquals(expectedQuantity, actualQuantity,
                "Quantity Value Do Not Match");


    }


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'View Product' for any product on home page
5. Verify product detail is opened
6. Increase quantity to 4
7. Click 'Add to cart' button
8. Click 'View Cart' button
9. Verify that product is displayed in cart page with exact quantity
     */
}
