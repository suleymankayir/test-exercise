package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case12 extends BaseTest {

    @Test
    public void testAddToCart() throws InterruptedException {
        Assert.assertTrue(homePage.isHomePageLogoVisible());
        var productPage = homePage.goToProducts();
        productPage.moveToFirstElement();
        productPage.clickFirstAddToCart();
        productPage.clickContinueButton();
        productPage.moveToSecondElement();
        productPage.clickSecondAddToCart();
        var cartPage = productPage.clickViewCart();
        Assert.assertTrue(cartPage.isFirstProductVisible(),
                "Add To Cart Func Does Not Work");
        Assert.assertTrue(cartPage.isSecondProductVisible(),
                "Add To Cart Func Does Not Work");
        String expectedPrice = "Rs. 500";
        String actualPrice = cartPage.getPrice();
        Assert.assertEquals(expectedPrice,actualPrice);

        String expectedQuantity = "1";
        String actualQuantity = cartPage.getQuantity();
        Assert.assertEquals(expectedQuantity,actualQuantity);

        String expectedTotalPrice = "Rs. 500";
        String actualTotalPrice = cartPage.getTotalPrice();
        Assert.assertEquals(expectedTotalPrice,actualTotalPrice);
    }



    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
     */
}
