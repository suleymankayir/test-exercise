package com.kayir.pages.products;

import com.kayir.pages.cart.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utilities.ActionsUtility.sendKeys;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;
import static utilities.WaitUtility.fluentWaitUntilVisible;

public class SingleProductPage extends ProductsPage {

    private By productDetails = By.className("product-information");
    private By productNameField = By.xpath("//h2[text()='Blue Top']");
    private By categoryField = By.xpath("//p[contains(text(),'Category')]");
    private By priceField = By.xpath("//div[@class='product-information']//span[text()='Rs. 500']");
    private By quantityField = By.id("quantity");
    private By addToCartButton = By.xpath("//button[@class='btn btn-default cart']");
    private By viewCart = By.xpath("//u[text()='View Cart']");
    private By writeYourReviewField = By.xpath("//*[text()='Write Your Review']");
    private By reviewName = By.id("name");
    private By submitButton= By.id("button-review");
    private By successMessage = By.xpath("//span[text()='Thank you for your review.']");

    public boolean isSuccessMessageDisplayed() {
        fluentWaitUntilVisible(3,successMessage);
        return find(successMessage).isDisplayed();
    }

    public void clickSubmitButton(){
        scrollToElementJS(submitButton);
        click(submitButton);
    }

    public void setReviewName(String name) {
        sendKeys(find(reviewName), name);
    }

    public void setReviewEmail(String email) {
        sendKeys(Keys.TAB + email);
    }

    public void setReview(String review) {
        sendKeys(Keys.TAB + review);
    }

    public boolean isWriteYourReviewDisplayed() {
        scrollToElementJS(writeYourReviewField);
        return find(writeYourReviewField).isDisplayed();
    }

    public void setQuantity(String quantity) {
        set(quantityField, quantity);
    }

    public CartPage clickViewCart() {
        explicitWaitUntilVisible(1, viewCart);
        click(viewCart);
        return new CartPage();
    }

    public void clickAddToCart() {
        click(addToCartButton);
    }

    public boolean isProductDetailsAvailable() {
        return find(productDetails).isDisplayed();
    }

    public boolean isProductNameVisible() {
        return find(productNameField).isDisplayed();
    }

    public boolean isCategoryVisible() {
        return find(categoryField).isDisplayed();
    }

    public boolean isPriceFieldVisible() {
        return find(priceField).isDisplayed();
    }


}
