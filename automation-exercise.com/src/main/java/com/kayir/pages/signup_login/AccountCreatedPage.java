package com.kayir.pages.signup_login;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class AccountCreatedPage extends SignUpPage{

    private By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    private By continueButton = By.linkText("Continue");


    public boolean isAccountCreatedTextVisible(){
        explicitWaitUntilVisible(3,accountCreatedText);
        return find(accountCreatedText).isDisplayed();
    }

    public HomePage clickContinueButton(){
        scrollToElementJS(continueButton);
        click(continueButton);
        return new HomePage();
    }

}
