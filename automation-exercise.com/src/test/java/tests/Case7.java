package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Case7 extends BaseTest {

    @Test
    public void testTestCasePage(){
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "\n Home Is Not Reachable \n");
        var testCasePage = homePage.goToTestCases();
        Assert.assertTrue(testCasePage.isTestCasesTitleIsVisible(),
                "\n Test Cases Page Is Not Reachable \n");
    }



    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
     */
}
