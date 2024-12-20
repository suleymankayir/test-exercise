package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case2 extends BaseTest {

    @Test
    public void testLogin(){

        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "\n Home Page Is Not Visible \n");
        var loginPage = homePage.goToSignUpLogin();
        Assert.assertTrue(loginPage.isLoginAccountTextVisible(),
                "\n Login To Your Account Text Is Not Visible \n");
        loginPage.setLoginEmail("aliceneverland@hotmail.com");
        loginPage.setPassword("123456");
        var homePage = loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isLoggedInfoTextVisible(),
                "\n Logged Info Is Not Exist \n");
        var deletedAccountPage = homePage.clickDeleteAccount();
        Assert.assertTrue(deletedAccountPage.isAccountDeletedTextVisible(),
                "\n Account Deleted Text Is Not Visible \n");

    }






    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
     */

}
