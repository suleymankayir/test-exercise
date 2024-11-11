package com.kayir.pages.cart;

import org.openqa.selenium.By;

import static utilities.ActionsUtility.sendKeys;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class CheckoutPage extends CartPage{

    private By addressDetailsText = By.xpath("//h2[text()='Address Details']");
    private By reviewOrder = By.xpath("//h2[text()='Review Your Order']");
    private By messageArea = By.xpath("//textarea[@class='form-control']");
    private By placeOrderButton = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");


    public PaymentPage clickPlaceOrder(){
        scrollToElementJS(placeOrderButton);
        click(placeOrderButton);
        return new PaymentPage();
    }

    public void setMessage(String message){
        sendKeys(find(messageArea),message);
    }

    public boolean isAddressDetailsVisible(){
        return find(addressDetailsText).isDisplayed();
    }

    public boolean isReviewOrderVisible(){
        return find(reviewOrder).isDisplayed();
    }

}
