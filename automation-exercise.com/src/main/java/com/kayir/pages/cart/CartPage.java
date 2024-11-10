package com.kayir.pages.cart;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.ActionsUtility.sendKeys;
import static utilities.GetUtility.getText;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class CartPage extends HomePage {

    private By subscribeText = By.xpath("//footer[@id='footer']//h2[text()='Subscription']");
    private By subEmailField = By.id("susbscribe_email");
    private By subArrowButton = By.xpath("//button[@type='submit']");
    private By successSubText = By.id("success-subscribe");


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



}
