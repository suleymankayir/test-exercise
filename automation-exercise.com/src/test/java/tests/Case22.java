package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case22 extends BaseTest {

    @Test
    public void testRecommendedItems(){
        Assert.assertTrue( homePage.isRecommendedTextVisible(),
                "Recommended Items is visible");
        homePage.clickAddToRecommendedFirst();
        var cartPage = homePage.clickViewCart();
        cartPage.isCartRelatedToAddToCart("Blue Top");
    }


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Scroll to bottom of page
4. Verify 'RECOMMENDED ITEMS' are visible
5. Click on 'Add To Cart' on Recommended product
6. Click on 'View Cart' button
7. Verify that product is displayed in cart page
     */
}
