package com.kayir.pages.cart;

import com.kayir.pages.signup_login.DeletedAccountPage;
import org.openqa.selenium.By;

import static utilities.ActionsUtility.sendKeys;
import static utilities.GetUtility.getText;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class CheckoutPage extends CartPage {

    private By addressDetailsText = By.xpath("//h2[text()='Address Details']");
    private By reviewOrder = By.xpath("//h2[text()='Review Your Order']");
    private By messageArea = By.xpath("//textarea[@class='form-control']");
    private By placeOrderButton = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");
    private By deliveryAddress1 = By.cssSelector("#address_delivery > li:nth-child(4)");
    private By invoiceAddress1 = By.cssSelector("#address_invoice > li:nth-child(4)");
    private By deleteAccountLink = By.cssSelector("ul > li:nth-child(5)");

    public PaymentPage clickPlaceOrder() {
        scrollToElementJS(placeOrderButton);
        click(placeOrderButton);
        return new PaymentPage();
    }

    @Override
    public DeletedAccountPage clickDeleteAccount() {
        return super.clickDeleteAccount();
    }

    public String getDeliveryAddress1Text() {
        return getText(deliveryAddress1);
    }

    public String getInvoiceAddress1Text() {
        System.out.println(invoiceAddress1);
        return getText(invoiceAddress1);
    }

    public void setMessage(String message) {
        sendKeys(find(messageArea), message);
    }

    public boolean isAddressDetailsVisible() {
        return find(addressDetailsText).isDisplayed();
    }

    public boolean isReviewOrderVisible() {
        return find(reviewOrder).isDisplayed();
    }

}
