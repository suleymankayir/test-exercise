package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.WaitUtility.*;

public class Case1 extends BaseTest {


    @Test
    public void testRegisterUser(){

        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "\n Home Page Logo Is Not Visible \n");

        var loginPage = homePage.goToSignUpLogin();
        Assert.assertTrue(loginPage.isNewUserSignTextVisible(),
                "\n New User Text Is Not Visible \n");
        loginPage.setUserName("Alice2");
        loginPage.setEmail("aliceinwonderland2@gmail.com");

        var signUpPage = loginPage.clickSubmitButton();
        Assert.assertTrue(signUpPage.isEnterAccountInfoTextVisible());
        signUpPage.clickMrsRadioButton();
        signUpPage.setName("Alice Neverland");
        signUpPage.setPassword("123456");
        signUpPage.setDay("14");
        signUpPage.setMonth("November");
        signUpPage.setYear("1991");
        signUpPage.clickNewsletterCheckbox();
        signUpPage.clickOfferCheckbox();
        signUpPage.setFirstName("Alice");
        signUpPage.setSurname("Neverland");
        signUpPage.setCompany("Wonderland Corp.");
        signUpPage.setAddress("Nowhere Avenue","Suite 3200");
        signUpPage.setCountry("Canada","Quebec","Montreal","6601");
        signUpPage.setMobileNo("+123457651221");

        var accountCreatedPage = signUpPage.clickCreateAccountButton();
        Assert.assertTrue(accountCreatedPage.isAccountCreatedTextVisible());
        accountCreatedPage.clickContinueButton();
        Assert.assertTrue(homePage.isLoggedInfoTextVisible());

        var deletedAccountPage = homePage.clickDeleteAccount();
        Assert.assertTrue(deletedAccountPage.isAccountDeletedTextVisible());
    }




    /*
    Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */
}
