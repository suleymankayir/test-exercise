package com.kayir.pages.signup_login;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.WaitUtility.fluentWaitUntilVisible;

public class DeletedAccountPage extends HomePage {

    private By accountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public boolean isAccountDeletedTextVisible() {
        fluentWaitUntilVisible(1,accountDeletedText);
        return find(accountDeletedText).isDisplayed();
    }

    public void clickContinueButton() {
        click(continueButton);
    }
}
