package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.GetUtility.getURL;

public class Case23 extends BaseTest {

    @Test
    public void testAddressDetailsInCheckout(){
        String address = "1600 Amphitheatre Parkway";

        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "Home Is Not Visible");
        var signupLoginPage = homePage.goToSignUpLogin();
        signupLoginPage.setUserName("Eric123");
        signupLoginPage.setEmail("ericqwertyy@gmail.com");
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
        signupPage.setAddress(address,"New York, NY, USA");
        signupPage.setCountry("United States","New York","Manhattan","45706");
        signupPage.setMobileNo("9232345678");
        var createdAccount = signupPage.clickCreateAccountButton();
        Assert.assertTrue(createdAccount.isAccountCreatedTextVisible(),
                "'Account created' message should be visible");
        var homePage = createdAccount.clickContinueButton();
        Assert.assertTrue(homePage.isLoggedInfoTextVisible(),
                "'Logged in as username' message should be visible");
        homePage.clickAddToFirstProduct();
        homePage.clickContinueShoppingButton();
        homePage.clickAddToSecondProduct();
        homePage.clickContinueShoppingButton();
        var cartPage = homePage.goToCart();
        String expectedURL = "https://automationexercise.com/view_cart";
        String actualURL = getURL();
        Assert.assertEquals(actualURL,expectedURL,
                "Cart page should be display");
        var checkOutPage = cartPage.clickProceedToCheckoutLogged();
        String actualDeliveryAddress = checkOutPage.getDeliveryAddress1Text();
        Assert.assertTrue(actualDeliveryAddress.contains(address),
                "Delivery address should be same with registration");
        String actualInvoiceAddress = checkOutPage.getInvoiceAddress1Text();
        Assert.assertTrue(actualInvoiceAddress.contains(address),
                "Invoice address should be same with registration");
        var deletedAccountPage = checkOutPage.clickDeleteAccount();
        Assert.assertTrue(deletedAccountPage.isAccountDeletedTextVisible(),
                "'ACCOUNT DELETED' should be visible");
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
12. Verify that the delivery address is same address filled at the time registration of account
13. Verify that the billing address is same address filled at the time registration of account
14. Click 'Delete Account' button
15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */
}
