package com.kayir.pages.signup_login;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.WaitUtility.fluentWaitUntilVisible;

public class DeletedAccountPage extends HomePage {

    private By accountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");


    public boolean isAccountDeletedTextVisible() {
        fluentWaitUntilVisible(3,accountDeletedText);
        return find(accountDeletedText).isDisplayed();
    }
}
