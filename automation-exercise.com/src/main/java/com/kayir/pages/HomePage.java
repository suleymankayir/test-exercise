package com.kayir.pages;

import com.kayir.base.BasePage;
import com.kayir.pages.contact_us.ContactUsPage;
import com.kayir.pages.signup_login.DeletedAccountPage;
import com.kayir.pages.signup_login.LoginPage;
import org.openqa.selenium.By;

import static utilities.WaitUtility.*;


public class HomePage extends BasePage {

    private By signUpLoginLink = By.cssSelector("ul > li:nth-child(4)");
    private By contactUsLink = By.cssSelector("ul > li:nth-child(8)");
    private By homePageLogo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    private By loggedInfoText = By.xpath("//*[contains(text(),'Logged')]");
    private By deleteAccountLink = By.linkText("Delete Account");
    private By logoutLink = By.linkText("Logout");


    public LoginPage goToSignUpLogin(){
        click(signUpLoginLink);
        return new LoginPage();
    }

    public ContactUsPage goToContactUs(){
        click(contactUsLink);
        return new ContactUsPage();
    }

    public boolean isHomePageLogoVisible(){
        explicitWaitUntilVisible(3,homePageLogo);
        return find(homePageLogo).isDisplayed();
    }

    public boolean isLoggedInfoTextVisible(){
        fluentWaitUntilVisible(2,homePageLogo);
        return find(loggedInfoText).isDisplayed();
    }

    public DeletedAccountPage clickDeleteAccount(){
        click(deleteAccountLink);
        return new DeletedAccountPage();
    }

    public LoginPage clickLogout(){
        click(logoutLink);
        return new LoginPage();
    }


}
