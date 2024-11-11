package com.kayir.pages.products;

import com.kayir.pages.cart.CartPage;
import org.openqa.selenium.By;

import static utilities.WaitUtility.explicitWaitUntilVisible;

public class SingleProductPage extends ProductsPage{

    private By productDetails = By.className("product-information");
    private By productNameField = By.xpath("//h2[text()='Blue Top']");
    private By categoryField = By.xpath("//p[contains(text(),'Category')]");
    private By priceField = By.xpath("//div[@class='product-information']//span[text()='Rs. 500']");
    private By quantityField = By.id("quantity");
    private By addToCartButton = By.xpath("//button[@class='btn btn-default cart']");
    private By viewCart = By.xpath("//u[text()='View Cart']");


    public void setQuantity(String quantity) {
        set(quantityField,quantity);
    }

    public CartPage clickViewCart(){
        explicitWaitUntilVisible(1,viewCart);
        click(viewCart);
        return new CartPage();
    }

    public void clickAddToCart(){
        click(addToCartButton);
    }

    public boolean isProductDetailsAvailable(){
        return find(productDetails).isDisplayed();
    }

    public boolean isProductNameVisible(){
       return find(productNameField).isDisplayed();
    }

    public boolean isCategoryVisible(){
        return find(categoryField).isDisplayed();
    }

    public boolean isPriceFieldVisible(){
        return find(priceField).isDisplayed();
    }




}
