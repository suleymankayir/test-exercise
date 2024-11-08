package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.GetUtility.getURL;

public class Case4 extends BaseTest {


    @Test
    public void testLogoutFunc(){
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "\n Home Page Is Not Reachable \n");
        var loginPage = homePage.goToSignUpLogin();
        Assert.assertTrue(loginPage.isLoginAccountTextVisible(),
                "\n Login To Your Account Text Is Not Visible \n");
        loginPage.setLoginEmail("aliceneverland@hotmail.com");
        loginPage.setPassword("123456");
        var homePage = loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isLoggedInfoTextVisible(),
                "\n Unsuccessful Login Attempt \n");
        var loginPageAfterLogout = homePage.clickLogout();
        String expectedURL = "https://automationexercise.com/login";
        String actualURL = getURL();
        Assert.assertEquals(expectedURL,actualURL,
                "\n Wrong Page \n");
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
9. Click 'Logout' button
10. Verify that user is navigated to login page
     */
}
