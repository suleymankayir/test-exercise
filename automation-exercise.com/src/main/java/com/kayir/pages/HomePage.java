package com.kayir.pages;

import com.kayir.base.BasePage;
import com.kayir.pages.signup_login.LoginPage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By signUpLoginItem = By.cssSelector("ul > li:nth-child(4)");
    private By homePageLogo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");

    public LoginPage goToSignUpLogin(){
        click(signUpLoginItem);
        return new LoginPage();
    }

    public boolean isHomePageLogoVisible(){
        return find(homePageLogo).isDisplayed();
    }



}
