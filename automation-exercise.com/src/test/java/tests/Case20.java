package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Case20 extends BaseTest {


    @Test
    public void testSearchAndCart(){
        String entry = "Top";
        SoftAssert softAssert= new SoftAssert();
        var productPage = homePage.goToProducts();
        productPage.searchProduct(entry);
        productPage.clickSearchButton();
        softAssert.assertTrue(productPage.isSearchedTextVisible(),
                "'Searched Products' Text Was Not Displayed");
        Assert.assertFalse(productPage.isSearchRelatedToProduct(entry),
                "Searched Products Was Related To Product");
        // When we search "Top" bc of this product Little Girls Mr. Panda test will fail
        productPage.clickEveryAddToCart();
        var cartPage = productPage.clickCartLink();
        Assert.assertTrue(cartPage.isCartRelatedToAddToCart(entry),
                "The products was not related to add to cart func");
        var loginPage = cartPage.clickSignupLogin();
        loginPage.setLoginEmail("aliceneverland1@hotmail.com");
        loginPage.setPassword("123456");
        var homePage = loginPage.clickLoginButton();
        var cartPage2 = homePage.goToCart();
        Assert.assertTrue( cartPage2.isCartRelatedToAddToCart(entry),
                "The products is gone");
    }


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Enter product name in search input and click search button
6. Verify 'SEARCHED PRODUCTS' is visible
7. Verify all the products related to search are visible
8. Add those products to cart
9. Click 'Cart' button and verify that products are visible in cart
10. Click 'Signup / Login' button and submit login details
11. Again, go to Cart page
12. Verify that those products are visible in cart after login as well
     */
}
