package com.kayir.pages.signup_login;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

public class DeletedAccountPage extends HomePage {

    private By accountDeletedText = By.xpath("//h2[@data-qa='account-deleted']");


    public boolean isAccountDeletedTextVisible() {
        return find(accountDeletedText).isDisplayed();
    }
}
