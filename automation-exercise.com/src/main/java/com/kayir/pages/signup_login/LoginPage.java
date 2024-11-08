package com.kayir.pages.signup_login;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utilities.ActionsUtility.sendKeys;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class LoginPage extends HomePage {

    private By newUserText = By.xpath("//h2[text()='New User Signup!']");
    private By loginAccountText = By.xpath("//h2[contains(text(),'Login')]");
    private By signUpName = By.xpath("//input[@data-qa='signup-name']");
    private By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By incorrectInfoText = By.xpath("//p[contains(text(),'incorrect')]");
    private By existAccountText = By.xpath("//p[contains(text(),'exist')]");



    public SignUpPage clickSignUpButton(){
        scrollToElementJS(signUpButton);
        click(signUpButton);
        return new SignUpPage();
    }

    public HomePage clickLoginButton(){
        click(loginButton);
        return new HomePage();
    }

    public boolean isIncorrectInfoTextVisible(){
        return find(incorrectInfoText).isDisplayed();
    }

    public boolean isAccountExistTextVisible(){
        return find(existAccountText).isDisplayed();
    }

    public boolean isLoginAccountTextVisible(){
        return find(loginAccountText).isDisplayed();
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

    public void setLoginEmail(String email){
        scrollToElementJS(loginEmailField);
        sendKeys(find(loginEmailField),Keys.chord(email));
    }

    public void setPassword(String password){
        setLoginEmail(Keys.chord(Keys.TAB,password));
    }


}
