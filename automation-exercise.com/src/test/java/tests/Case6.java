package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.GetUtility.getURL;
import static utilities.SwitchToUtility.acceptAlert;

public class Case6 extends BaseTest {

    @Test
    public void testContactUsPage(){
        Assert.assertTrue(homePage.isHomePageLogoVisible(),
                "\n Home Page Is Not Reachable \n");
        var contactUsPage = homePage.goToContactUs();
        Assert.assertTrue(contactUsPage.isGetInTouchTextVisible(),
                "\n Get In Touch Is Not Visible \n");
        contactUsPage.setName("Alice Neverland");
        contactUsPage.setEmail("aliceneverland@hotmail.com");
        contactUsPage.setSubject("Nothing");
        contactUsPage.setMessage("Hello everyone,",
        "I need help about sth.");
        contactUsPage.uploadFile("src/main/resources/UploadTest");
        contactUsPage.clickSubmit();
        acceptAlert();
        Assert.assertTrue(contactUsPage.isSuccessInfoTextVisible(),
                "\n Contact Action Has Failed \n");
        var homePage = contactUsPage.goToHomePage();
        String expectedURL = "https://automationexercise.com/";
        String actualURL = getURL();
        Assert.assertEquals(expectedURL, actualURL,
                "\n Wrong Page \n");
    }





    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
     */
}
