package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.FileUtility.isFileDownloaded;
import static utilities.GetUtility.getURL;

public class Case24 extends BaseTest {


    @Test
    public void testDownloadInvoice(){
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "Home Is Not Visible");
        homePage.clickAddToFirstProduct();
        homePage.clickContinueShoppingButton();
        homePage.clickAddToSecondProduct();
        homePage.clickContinueShoppingButton();
        var cartPage = homePage.goToCart();
        String expectedURL = "https://automationexercise.com/view_cart";
        String actualURL = getURL();
        Assert.assertEquals(actualURL,expectedURL,
                "Cart page should be display");
        cartPage.clickProceedToCheckout();
        var signupLoginPage = cartPage.clickRegisterLogin();

        signupLoginPage.setUserName("Eric123");
        signupLoginPage.setEmail("ericqwertyysad@gmail.com");
        var signupPage = signupLoginPage.clickSignUpButton();
        signupPage.clickMrsRadioButton();
        signupPage.setName("Eric");
        signupPage.setPassword("123456");
        signupPage.setDay("17");
        signupPage.setMonth("11");
        signupPage.setYear("1999");
        signupPage.clickNewsletterCheckbox();
        signupPage.clickOfferCheckbox();
        signupPage.setFirstName("Eric");
        signupPage.setSurname("Lastman");
        signupPage.setCompany("Google Inc");
        signupPage.setAddress("1600 Amphitheatre Parkway","New York, NY, USA");
        signupPage.setCountry("United States","New York","Manhattan","45706");
        signupPage.setMobileNo("9232345678");
        var createdAccount = signupPage.clickCreateAccountButton();
        Assert.assertTrue(createdAccount.isAccountCreatedTextVisible(),
                "'Account created' message should be visible");
        var homePage = createdAccount.clickContinueButton();
        Assert.assertTrue(homePage.isLoggedInfoTextVisible(),
                "'Logged in as username' message should be visible");
        var cartPageAfterLogin = homePage.goToCart();
        var checkoutPage = cartPageAfterLogin.clickProceedToCheckoutLogged();
        Assert.assertTrue(checkoutPage.isAddressDetailsVisible(),
                "Address details should be visible");
        Assert.assertTrue(checkoutPage.isReviewOrderVisible(),
                "Review order should be visible");
        checkoutPage.setMessage("Damn");
        var paymentPage = checkoutPage.clickPlaceOrder();
        paymentPage.setNameOnCardField("Eric Field");
        paymentPage.setCardNumber("123142532523");
        paymentPage.setCVC("231");
        paymentPage.setExpMonth("01");
        paymentPage.setExpYear("2022");
        paymentPage.clickPayAndConfirmOrder();
        paymentPage.isSuccessMessageDisplayed();
        paymentPage.clickDownloadInvoice();
        boolean isInvoiceFileExist = isFileDownloaded("invoice",10);
        Assert.assertTrue(isInvoiceFileExist,
                "Invoice file did not downloaded");
        var homePageAfter = paymentPage.clickContinueButton();
        var deletedAccountPage = homePageAfter.clickDeleteAccount();
        Assert.assertTrue(deletedAccountPage.isAccountDeletedTextVisible(),
                "'ACCOUNT DELETED' text is not visible");
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
19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
20. Click 'Continue' button
21. Click 'Delete Account' button
22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
}
