package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.GetUtility.getURL;

public class Case14 extends BaseTest {

    @Test
    public void testRegisterWhileOrder() {
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "Home Is Not Visible");
        homePage.clickAddToFirstProduct();
        homePage.clickContinueShoppingButton();
        homePage.clickAddToSecondProduct();
        homePage.clickContinueShoppingButton();
        var cartPage = homePage.goToCart();
        String expectedURL = "https://automationexercise.com/view_cart";
        String actualURL = getURL();
        Assert.assertEquals(expectedURL, actualURL);
        cartPage.clickProceedToCheckout();
        var loginPage = cartPage.clickRegisterLogin();
        loginPage.setUserName("Mephisto2");
        loginPage.setEmail("mep14@hotmail.com");
        var signUpPage = loginPage.clickSignUpButton();
        signUpPage.clickMrsRadioButton();
        signUpPage.setName("Mephisto");
        signUpPage.setPassword("123456");
        signUpPage.setDay("3");
        signUpPage.setMonth("October");
        signUpPage.setYear("1993");
        signUpPage.clickNewsletterCheckbox();
        signUpPage.clickOfferCheckbox();
        signUpPage.setFirstName("Mephisto");
        signUpPage.setSurname("Allen");
        signUpPage.setCompany("Wonderland Corp.");
        signUpPage.setAddress("1234 Avenue", "Button Apt.");
        signUpPage.setCountry("Canada", "Mumbai", "Delhi", "3456");
        signUpPage.setMobileNo("654321098");
         /*
                Hybrid Way
                signUpPage.signUp(
                "Mephisto","123456","3","October",
                "1993","Mephisto","Allen","Wonderland Corp.",
                "1234 Avenue","Button Apt.","Canada","Mumbai",
                "Delhi","3456","654321098");
        */
        var accountCreatedPage = signUpPage.clickCreateAccountButton();
        Assert.assertTrue(accountCreatedPage.isAccountCreatedTextVisible(),
                "Account creation failed");
        var homePage = accountCreatedPage.clickContinueButton();
        Assert.assertTrue(homePage.isLoggedInfoTextVisible(),
                "Not logged in as username");
        var cartPage2 = homePage.goToCart();
        var checkoutPage = cartPage2.clickProceedToCheckoutLogged();
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(),
                "Address Details Is Not Visible");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(),
                "Review Order Is Not Visible");
        checkoutPage.setMessage("This is for you.");
        var paymentPage = checkoutPage.clickPlaceOrder();
        paymentPage.setNameOnCardField("Alice");
        paymentPage.setCardNumber("123443211233");
        paymentPage.setCVC("322");
        paymentPage.setExpMonth("02");
        paymentPage.setExpYear("2020");
        paymentPage.clickPayAndConfirmOrder();
        Assert.assertTrue(paymentPage.isSuccessMessageDisplayed(),
                "Order Process Could Not Be Completed");

        var deletedAccountPage = paymentPage.clickDeleteAccount();
        Assert.assertTrue(deletedAccountPage.isAccountDeletedTextVisible(),
                "Account Deletion Failed");
        deletedAccountPage.clickContinueButton();
    }


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Add products to cart
5. Click 'Cart' button
6. Verify that cart page is displayed
7. Click Proceed To Checkout
8. Click 'Register / Login' button
9. Fill all details in Signup and create account
10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
11. Verify ' Logged in as username' at top
12.Click 'Cart' button
13. Click 'Proceed To Checkout' button
14. Verify Address Details and Review Your Order
15. Enter description in comment text area and click 'Place Order'
16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
17. Click 'Pay and Confirm Order' button
18. Verify success message 'Your order has been placed successfully!'
19. Click 'Delete Account' button
20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
}
