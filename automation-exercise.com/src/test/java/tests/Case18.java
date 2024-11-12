package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case18 extends BaseTest {

    @Test
    public void testLeftBar(){
        Assert.assertTrue(homePage.isCategoryTextVisible(),
                "Category Text Is Not Visible");
        homePage.clickWomenCategory();
        var categoryProductsPage = homePage.clickDressCategory();
        String expectedText ="WOMEN";
        String actualText = categoryProductsPage.getWomenProductsText();
        Assert.assertTrue(actualText.contains(expectedText),
                "Actual Text Does Not Contain 'Women'");
        categoryProductsPage.clickMenBar();
        categoryProductsPage.clickTshirts();
        String expectedTshirtText = "TSHIRTS";
        String actualTshirtText = categoryProductsPage.getTshirtProductText();
        Assert.assertTrue(actualTshirtText.contains(expectedTshirtText),
                "Actual Text Does Not Contain 'TSHIRTS'");

    }

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that categories are visible on left side bar
4. Click on 'Women' category
5. Click on any category link under 'Women' category, for example: Dress
6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
7. On left side bar, click on any sub-category link of 'Men' category
8. Verify that user is navigated to that category page
     */
}
