package com.kayir.pages.products;

import com.kayir.pages.HomePage;
import com.kayir.pages.cart.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.ActionsUtility.moveTo;
import static utilities.ActionsUtility.sendKeys;
import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;
import static utilities.WaitUtility.fluentWaitUntilVisible;

public class ProductsPage extends HomePage {

    private By allProductsText = By.xpath("//h2[text()='All Products']");
    private By products = By.className("product-image-wrapper");
    private By firstProduct = By.xpath("//a[@href='/product_details/1']");
    private By searchField = By.xpath("//input[@id='search_product']");
    private By searchButton = By.xpath("//button[@id='submit_search']");
    private By searchedText = By.xpath("//h2[contains(text(),'Searched')]");
    private By searchResult = By.className("productinfo");
    private By firstProduct2 = By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='1']");
    private By firstProductAddToCartField = By.xpath("//html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
    private By continueButton = By.xpath("//button[@data-dismiss='modal']");
    private By secondProduct = By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='2']");
    private By secondProductAddToCartField = By.xpath("//html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");
    private By viewCart = By.xpath("//u[text()='View Cart']");


    public SingleProductPage clickViewProduct() {
        scrollToElementJS(firstProduct);
        clickJS(firstProduct);
        return new SingleProductPage();
    }

    public void moveToFirstElement() {
        moveTo(find(firstProduct2));
    }

    public void moveToSecondElement(){
        moveTo(find(secondProduct));
    }

    public void clickFirstAddToCart() {
        fluentWaitUntilVisible(2, firstProductAddToCartField);
        click(firstProductAddToCartField);
    }

    public void clickSecondAddToCart(){
        fluentWaitUntilVisible(2,secondProductAddToCartField);
        click(secondProductAddToCartField);
    }

    public CartPage clickViewCart(){
        explicitWaitUntilVisible(1,viewCart);
        click(viewCart);
        return new CartPage();
    }

    public void clickContinueButton() {
        explicitWaitUntilVisible(1, continueButton);
        click(continueButton);
    }

    public boolean isAnyProductShowedUp() {
        scrollToElementJS(searchResult);
        List<WebElement> searchedProducts = findElementList(searchResult);
        if (!searchedProducts.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSearchedTextVisible() {
        scrollToElementJS(searchedText);
        return find(searchedText).isDisplayed();
    }

    public void clickSearchButton() {
        scrollToElementJS(searchButton);
        click(searchButton);
    }

    public void searchProduct(String entry) {
        sendKeys(find(searchField), entry);
    }

    public boolean isAllProductsTextVisible() {
        return find(allProductsText).isDisplayed();
    }

    public boolean isProductListVisible() {
        if (!findElementList(products).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
