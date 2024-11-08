package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case3 extends BaseTest {

    @Test
    public void loginWithIncorrectInfo(){
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "\n Could Not Reach Home Page \n");
        var loginPage = homePage.goToSignUpLogin();
        Assert.assertTrue(loginPage.isLoginAccountTextVisible(),
                "\n Login To Your Account Text Is Not Visible \n");
        loginPage.setLoginEmail("asdasd@mail.com");
        loginPage.setPassword("235346535");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isIncorrectInfoTextVisible(),
                "Email & Password Info Exist");
    }


    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter incorrect email address and password
7. Click 'login' button
8. Verify error 'Your email or password is incorrect!' is visible
     */

}
