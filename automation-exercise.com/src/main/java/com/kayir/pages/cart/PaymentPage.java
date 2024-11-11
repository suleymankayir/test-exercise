package com.kayir.pages.cart;

import com.kayir.pages.signup_login.DeletedAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utilities.ActionsUtility.sendKeys;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.NavigateUtility.back;
import static utilities.NavigateUtility.forward;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class PaymentPage extends CheckoutPage {

    private By nameOnCardField = By.xpath("//input[@data-qa='name-on-card']");
    private By payAndConfirmOrder = By.xpath("//button[@data-qa='pay-button']");
    private By successMessage = By.xpath("//div[contains(text(),'order')]");
    private By deleteAccountLink = By.cssSelector("ul > li:nth-child(5)");

    public DeletedAccountPage clickDeleteAccount() {
        click(deleteAccountLink);
        return new DeletedAccountPage();
    }

    public boolean isSuccessMessageDisplayed() {
        back();
        explicitWaitUntilVisible(1,successMessage);
        boolean value = find(successMessage).isDisplayed();
        forward();
        return value;
    }

    public void clickPayAndConfirmOrder() {
        scrollToElementJS(payAndConfirmOrder);
        click(payAndConfirmOrder);

    }

    public void setNameOnCardField(String name) {
        sendKeys(find(nameOnCardField), name);
    }

    public void setCardNumber(String cardNumber) {
        sendKeys(Keys.TAB + cardNumber);
    }

    public void setCVC(String cvc) {
        sendKeys(Keys.TAB + cvc);
    }

    public void setExpMonth(String expMonth) {
        sendKeys(Keys.TAB + expMonth);
    }

    public void setExpYear(String expYear) {
        sendKeys(Keys.TAB + expYear);
    }

}
