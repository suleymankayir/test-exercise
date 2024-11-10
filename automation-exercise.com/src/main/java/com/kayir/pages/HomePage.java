package com.kayir.pages;

import com.kayir.base.BasePage;
import com.kayir.pages.contact_us.ContactUsPage;
import com.kayir.pages.products.ProductsPage;
import com.kayir.pages.signup_login.DeletedAccountPage;
import com.kayir.pages.signup_login.LoginPage;
import com.kayir.pages.test_cases.TestCasesPage;
import org.openqa.selenium.By;

import static utilities.ActionsUtility.sendKeys;
import static utilities.GetUtility.*;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;
import static utilities.WaitUtility.fluentWaitUntilVisible;


public class HomePage extends BasePage {

    private By signUpLoginLink = By.cssSelector("ul > li:nth-child(4)");
    private By contactUsLink = By.cssSelector("ul > li:nth-child(8)");
    private By homePageLogo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    private By loggedInfoText = By.xpath("//*[contains(text(),'Logged')]");
    private By deleteAccountLink = By.linkText("Delete Account");
    private By logoutLink = By.linkText("Logout");
    private By testCasesLink = By.cssSelector("ul > li:nth-child(5)");
    private By productsLink = By.cssSelector("ul > li:nth-child(2)");
    private By subscribeText = By.xpath("//footer[@id='footer']//h2[text()='Subscription']");
    private By subEmailField = By.id("susbscribe_email");
    private By subArrowButton = By.xpath("//button[@type='submit']");
    private By successSubText = By.id("success-subscribe");
    public LoginPage goToSignUpLogin() {
        click(signUpLoginLink);
        return new LoginPage();
    }

    public ProductsPage goToProducts(){
        click(productsLink);
        return new ProductsPage();
    }

    public TestCasesPage goToTestCases() {
        click(testCasesLink);
        return new TestCasesPage();
    }

    public ContactUsPage goToContactUs() {
        click(contactUsLink);
        return new ContactUsPage();
    }

    public String verifySubscriptionText(){
        scrollToElementJS(subscribeText);
        return getText(subscribeText);
    }

    public void setSubEmail(String email){
        scrollToElementJS(subEmailField);
        sendKeys(find(subEmailField),email);
    }

    public void clickSubArrowButton(){
        scrollToElementJS(subArrowButton);
        click(subArrowButton);
    }

    public String getSubSuccessText(){
        scrollToElementJS(successSubText);
        return getText(successSubText);
    }

    public boolean isHomePageLogoVisible() {
        explicitWaitUntilVisible(3, homePageLogo);
        return find(homePageLogo).isDisplayed();
    }

    public boolean isLoggedInfoTextVisible() {
        fluentWaitUntilVisible(2, homePageLogo);
        return find(loggedInfoText).isDisplayed();
    }

    public DeletedAccountPage clickDeleteAccount() {
        click(deleteAccountLink);
        return new DeletedAccountPage();
    }

    public LoginPage clickLogout() {
        click(logoutLink);
        return new LoginPage();
    }


}
