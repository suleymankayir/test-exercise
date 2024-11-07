package com.kayir.pages.signup_login;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

public class LoginPage extends HomePage {

    private By newUserText = By.xpath("//h2[text()='New User Signup!']");


    public boolean isNewUserSignTextVisible(){
        return find(newUserText).isDisplayed();
    }


}
