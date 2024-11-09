package com.kayir.pages.products;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.ActionsUtility.sendKeys;
import static utilities.JavaScriptUtility.*;

public class ProductsPage extends HomePage {

    private By allProductsText = By.xpath("//h2[text()='All Products']");
    private By products = By.className("product-image-wrapper");
    private By firstProduct = By.xpath("//a[@href='/product_details/1']");
    private By searchField = By.xpath("//input[@id='search_product']");
    private By searchButton = By.xpath("//button[@id='submit_search']");
    private By searchedText = By.xpath("//h2[contains(text(),'Searched')]");
    private By searchResult = By.className("productinfo");

    public SingleProductPage clickViewProduct(){
        scrollToElementJS(firstProduct);
        clickJS(firstProduct);
        return new SingleProductPage();
    }



    public boolean isAnyProductShowedUp(){
        scrollToElementJS(searchResult);
        List<WebElement> searchedProducts = findElementList(searchResult);
        if (!searchedProducts.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public boolean isSearchedTextVisible(){
        scrollToElementJS(searchedText);
        return find(searchedText).isDisplayed();
    }

    public void clickSearchButton(){
        scrollToElementJS(searchButton);
        click(searchButton);
    }

    public void searchProduct(String entry){
        sendKeys(find(searchField),entry);
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
