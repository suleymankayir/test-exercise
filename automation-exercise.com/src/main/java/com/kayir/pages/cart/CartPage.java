package com.kayir.pages.cart;

import com.kayir.pages.HomePage;
import com.kayir.pages.signup_login.LoginPage;
import org.openqa.selenium.By;

import static utilities.ActionsUtility.sendKeys;
import static utilities.GetUtility.getText;
import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class CartPage extends HomePage {

    private By subscribeText = By.xpath("//footer[@id='footer']//h2[text()='Subscription']");
    private By subEmailField = By.id("susbscribe_email");
    private By subArrowButton = By.xpath("//button[@type='submit']");
    private By successSubText = By.id("success-subscribe");
    private By firstProduct = By.id("product-1");
    private By secondProduct = By.id("product-2");
    private By price = By.xpath("//tr[@id='product-1']//td[@class='cart_price']");
    private By quantity = By.xpath("//tr[@id='product-1']//td[@class='cart_quantity']");
    private By totalPrice = By.xpath("//tr[@id='product-1']//td[@class='cart_total']");
    private By proceedToCheckoutButton = By.xpath("//a[text()='Proceed To Checkout']");
    private By registerLoginLink = By.xpath("//u[text()='Register / Login']");
    private By deleteFirstProduct = By.xpath("//a[@data-product-id='1']");
    private By firstProductDesc = By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a");

    public void clickDeleteFirstProduct(){
        scrollToElementJS(deleteFirstProduct);
        click(deleteFirstProduct);
    }

    public String getFirstProductDesc(){
        return getText(firstProductDesc);
    }


    public LoginPage clickRegisterLogin(){
        explicitWaitUntilVisible(1,registerLoginLink);
        click(registerLoginLink);
        return new LoginPage();
    }

    public void clickProceedToCheckout(){
        click(proceedToCheckoutButton);
    }

    public CheckoutPage clickProceedToCheckoutLogged(){
        click(proceedToCheckoutButton);
        return new CheckoutPage();
    }

    public String getPrice(){
        return getText(price);
    }

    public String getQuantity(){
        return getText(quantity);
    }

    public String getTotalPrice(){
        return getText(totalPrice);
    }

    public boolean isFirstProductVisible(){
        return find(firstProduct).isDisplayed();
    }

    public boolean isSecondProductVisible(){
        return find(secondProduct).isDisplayed();
    }

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
