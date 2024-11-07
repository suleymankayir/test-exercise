package com.kayir.pages.signup_login;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utilities.ActionsUtility.sendKeys;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class LoginPage extends HomePage {

    private By newUserText = By.xpath("//h2[text()='New User Signup!']");
    private By signUpName = By.xpath("//input[@data-qa='signup-name']");
    private By signUpButton = By.xpath("//button[@data-qa='signup-button']");



    public SignUpPage clickSubmitButton(){
        scrollToElementJS(signUpButton);
        click(signUpButton);
        return new SignUpPage();
    }


    public boolean isNewUserSignTextVisible(){
        return find(newUserText).isDisplayed();
    }

    public void setUserName(String userName){
        scrollToElementJS(signUpName);
        sendKeys(find(signUpName), Keys.chord(userName));
    }

    public void setEmail(String email){
        setUserName(Keys.chord(Keys.TAB,email));
    }


}
