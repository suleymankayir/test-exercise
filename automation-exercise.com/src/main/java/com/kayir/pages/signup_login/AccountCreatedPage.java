package com.kayir.pages.signup_login;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;
import static utilities.WaitUtility.fluentWaitUntilVisible;

public class AccountCreatedPage extends SignUpPage{

    private By accountCreatedText = By.xpath("//h2[@data-qa='account-created']");
    private By continueButton = By.linkText("Continue");


    public boolean isAccountCreatedTextVisible(){

        return find(accountCreatedText).isDisplayed();
    }

    public HomePage clickContinueButton(){
        scrollToElementJS(continueButton);
        click(continueButton);
        return new HomePage();
    }

}
