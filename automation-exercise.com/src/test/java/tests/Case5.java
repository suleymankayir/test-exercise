package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case5 extends BaseTest {

    @Test
    public void testExistAccount() {
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "\n Home Page Is Not Loading \n");
        var loginPage = homePage.goToSignUpLogin();
        Assert.assertTrue(loginPage.isNewUserSignTextVisible(),
                "\n New User Signup! Text Is Not Visible \n");
        loginPage.setUserName("Alice");
        loginPage.setEmail("aliceneverland@hotmail.com");
        loginPage.clickSignUpButton();
        Assert.assertTrue(loginPage.isAccountExistTextVisible(),
                "\n This Account Is Not Exist \n");
    }

    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
     */
}
