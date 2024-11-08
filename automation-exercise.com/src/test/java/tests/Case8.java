package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case8 extends BaseTest {


    @Test
    public void testProducts(){
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "\n Home Page Did Not Display \n");
        var productsPage = homePage.goToProducts();
        Assert.assertTrue(productsPage.isAllProductsTextVisible(),
                "\n Products Was Not Displayed \n");
        Assert.assertTrue(productsPage.isProductListVisible(),
                "\n Product List Was Not Displayed \n");
        var singleProduct = productsPage.clickViewProduct();
        Assert.assertTrue(singleProduct.isProductDetailsAvailable(),
                "\n Product Details Is Not Visible \n");
        Assert.assertTrue(singleProduct.isProductNameVisible(),
                "\n Product Name Is Not Visible \n");
        Assert.assertTrue(singleProduct.isCategoryVisible(),
                "\n Category Is Not Visible \n");
        Assert.assertTrue(singleProduct.isPriceFieldVisible(),
                "\n Price Is Not Visible \n");
    }


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
     */
}
