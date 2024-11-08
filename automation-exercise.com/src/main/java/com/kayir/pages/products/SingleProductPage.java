package com.kayir.pages.products;

import org.openqa.selenium.By;

public class SingleProductPage extends ProductsPage{

    private By productDetails = By.className("product-information");
    private By productNameField = By.xpath("//h2[text()='Blue Top']");
    private By categoryField = By.xpath("//p[contains(text(),'Category')]");
    private By priceField = By.xpath("//div[@class='product-information']//span[text()='Rs. 500']");

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
