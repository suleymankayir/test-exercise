package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static utilities.GetUtility.getURL;

public class Case15 extends BaseTest {

    @Test
    public void testRegisterBeforeCheckout(){
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "Hoem Page page is not visible");
        var signupLoginPage = homePage.goToSignUpLogin();
        signupLoginPage.setUserName("posy2");
        signupLoginPage.setEmail("posy2@hotmail.com");
        var signUpPage = signupLoginPage.clickSignUpButton();
        signUpPage.clickMrsRadioButton();
        signUpPage.setName("Posy");
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
        signUpPage.setMobileNo("654321008");
        /*
                Hybrid Way
                signUpPage.signUp(
                "Posy","123456","3","October",
                "1993","Mephisto","Allen","Wonderland Corp.",
                "1234 Avenue","Button Apt.","Canada","Mumbai",
                "Delhi","3456","654321008");
        */
        var accountCreatedPage = signUpPage.clickCreateAccountButton();
        Assert.assertTrue(accountCreatedPage.isAccountCreatedTextVisible(),
                "Account creation is failed");
        var homePage =  accountCreatedPage.clickContinueButton();
        Assert.assertTrue(homePage.isLoggedInfoTextVisible(),
                "Logging info is not visible");
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
        checkoutPage.setMessage("This is for you.");
        var paymentPage = checkoutPage.clickPlaceOrder();
        paymentPage.setNameOnCardField("Alice");
        paymentPage.setCardNumber("123443211233");
        paymentPage.setCVC("322");
        paymentPage.setExpMonth("02");
        paymentPage.setExpYear("2020");
        paymentPage.clickPayAndConfirmOrder();

        /*
            Hybrid Way
            paymentPage.payment("Alice","123443211233",
                "322","02","2020");
         */
        softAssert.assertTrue(paymentPage.isSuccessMessageDisplayed(),
                "Order Process Could Not Be Completed");
        var deletedAccountPage = paymentPage.clickDeleteAccount();
        softAssert.assertTrue(deletedAccountPage.isAccountDeletedTextVisible(),
                "Account Deletion Failed");
        deletedAccountPage.clickContinueButton();


    }


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Signup / Login' button
5. Fill all details in Signup and create account
6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
7. Verify ' Logged in as username' at top
8. Add products to cart
9. Click 'Cart' button
10. Verify that cart page is displayed
11. Click Proceed To Checkout
12. Verify Address Details and Review Your Order
13. Enter description in comment text area and click 'Place Order'
14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
15. Click 'Pay and Confirm Order' button
16. Verify success message 'Your order has been placed successfully!'
17. Click 'Delete Account' button
18. Verify 'ACCOUNT DELETED!' and click 'Continue' button

     */
}
