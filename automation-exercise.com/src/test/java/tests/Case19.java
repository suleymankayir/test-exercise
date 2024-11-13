package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.GetUtility.getURL;

public class Case19 extends BaseTest {

    @Test
    public void testBrandProducts(){
        var productsPage = homePage.goToProducts();
        Assert.assertTrue(productsPage.isBrandsTextVisible(),
                "Brands text is not visible");
        var brandPage = productsPage.clickPolo();
        String expectedURL = "https://automationexercise.com/brand_products/Polo";
        String actualURL = getURL();
        Assert.assertEquals(actualURL,expectedURL,
                "Polo Brand Page Was Not Displayed");
        Assert.assertTrue(brandPage.isItemsDisplayed(),
                "Items did not show up");
        brandPage.clickMadame();
        String expectedBrand = "Madame";
        String url = getURL();
        Assert.assertTrue(url.contains(expectedBrand),
                "Madame Brand Page Was Not Displayed");
        Assert.assertTrue(brandPage.isItemsDisplayed(),
                "Madame Items were Not Displayed");

    }


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify that Brands are visible on left side bar
5. Click on any brand name
6. Verify that user is navigated to brand page and brand products are displayed
7. On left side bar, click on any other brand link
8. Verify that user is navigated to that brand page and can see products
     */

}
