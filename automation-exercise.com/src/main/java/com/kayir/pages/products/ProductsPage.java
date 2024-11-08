package com.kayir.pages.products;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.*;

public class ProductsPage extends HomePage {

    private By allProductsText = By.xpath("//h2[text()='All Products']");
    private By products = By.className("product-image-wrapper");
    private By firstProduct = By.xpath("//a[@href='/product_details/1']");


    public SingleProductPage clickViewProduct(){
        scrollToElementJS(firstProduct);
        clickJS(firstProduct);
        return new SingleProductPage();
    }

    public boolean isAllProductsTextVisible(){
        return find(allProductsText).isDisplayed();
    }

    public boolean isProductListVisible(){
        if (!findElementList(products).isEmpty()){
            return true;
        } else {
            return false;
        }
    }

}
