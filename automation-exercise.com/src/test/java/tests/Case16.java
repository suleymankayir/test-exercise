package tests;

import base.BaseTest;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utilities.GetUtility.getURL;

public class Case16 extends BaseTest {

    @Test
    public void testLoggedOrder(){
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "Home Page Is Not Visible");
        var signUpLoginPage = homePage.goToSignUpLogin();
        signUpLoginPage.setLoginEmail("aliceneverland@hotmail.com");
        signUpLoginPage.setPassword("123456");
        var homePage = signUpLoginPage.clickLoginButton();
        Assert.assertTrue(homePage.isLoggedInfoTextVisible(),
                "Logged Info Is Not Visible");
        homePage.clickAddToFirstProduct();
        homePage.clickContinueShoppingButton();
        homePage.clickAddToSecondProduct();
        homePage.clickContinueShoppingButton();
        var cartPage = homePage.goToCart();
        String expectedURL = "https://automationexercise.com/view_cart";
        String actualURL = getURL();
        softAssert.assertEquals(expectedURL, actualURL,
                "Cart Page Was Not Displayed");
        var checkoutPage = cartPage.clickProceedToCheckoutLogged();
        softAssert.assertTrue(checkoutPage.isAddressDetailsVisible(),
                "Address Details Is Not Visible");
        softAssert.assertTrue(checkoutPage.isReviewOrderVisible(),
                "Review Order Is Not Visible");
        checkoutPage.setMessage("Lets goooo");
        var paymentPage = checkoutPage.clickPlaceOrder();
        paymentPage.setNameOnCardField("Posy posy");
        paymentPage.setCardNumber("1234567899");
        paymentPage.setCVC("123");
        paymentPage.setExpMonth("09");
        paymentPage.setExpYear("2022");
        paymentPage.clickPayAndConfirmOrder();
        softAssert.assertTrue(paymentPage.isSuccessMessageDisplayed(),
                "Success message was not displayed");
        var deletedAccountPage = paymentPage.clickDeleteAccount();
        softAssert.assertTrue(deletedAccountPage.isAccountDeletedTextVisible(),
                "The account was not deleted");
        deletedAccountPage.clickContinueButton();
    }






    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill email, password and click 'Login' button
6. Verify 'Logged in as username' at top
7. Add products to cart
8. Click 'Cart' button
9. Verify that cart page is displayed
10. Click Proceed To Checkout
11. Verify Address Details and Review Your Order
12. Enter description in comment text area and click 'Place Order'
13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
14. Click 'Pay and Confirm Order' button
15. Verify success message 'Your order has been placed successfully!'
16. Click 'Delete Account' button
17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
}
