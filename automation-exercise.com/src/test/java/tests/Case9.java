package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case9 extends BaseTest {


    @Test
    public void testSearchedProduct(){
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "\n Home Page Is Not Visible \n");
        var productPage = homePage.goToProducts();
        Assert.assertTrue(productPage.isAllProductsTextVisible(),
                "\n Products Was Not Displayed \n");
        productPage.searchProduct("tshirt");
        productPage.clickSearchButton();
        Assert.assertTrue(productPage.isSearchedTextVisible(),
                "\n There Is No Match \n");
        Assert.assertTrue(productPage.isAnyProductShowedUp(),
                "There Is No Product");
    }





    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
     */

}
