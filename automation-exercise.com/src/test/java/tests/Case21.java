package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case21 extends BaseTest {


    @Test
    public void testReview(){
        var productPage = homePage.goToProducts();
        Assert.assertTrue(productPage.isAllProductsTextVisible(),
                "'All Products' text is not visible");
        var singleProduct = productPage.clickViewProduct();
        Assert.assertTrue(singleProduct.isWriteYourReviewDisplayed(),
                "'Write Your Review' is not visible");
        singleProduct.setReviewName("Alice");
        singleProduct.setReviewEmail("aliceneverland1@hotmail.com");
        singleProduct.setReview("This is sucks.");
        singleProduct.clickSubmitButton();
        Assert.assertTrue(singleProduct.isSuccessMessageDisplayed(),
                "Success message was not appeared");
    }

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Click on 'Products' button
4. Verify user is navigated to ALL PRODUCTS page successfully
5. Click on 'View Product' button
6. Verify 'Write Your Review' is visible
7. Enter name, email and review
8. Click 'Submit' button
9. Verify success message 'Thank you for your review.'
     */
}
