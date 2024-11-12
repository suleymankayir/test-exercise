package com.kayir.pages.products;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.GetUtility.getText;
import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class CategoryProductsPage extends HomePage {

    private By womenProductsText = By.xpath("//h2[@class='title text-center']");
    private By menBarField = By.xpath("//a[@href='#Men']");
    private By tshirtsLink = By.xpath("//div[@id='Men']//a[text()='Tshirts ']");
    private By tshirtText = By.xpath("//h2[@class='title text-center']");

    public String getWomenProductsText(){
        return getText(womenProductsText);
    }

    public void clickMenBar(){
        scrollToElementJS(menBarField);
        clickJS(menBarField);
    }

    public void clickTshirts(){
        clickJS(tshirtsLink);
    }

    public String getTshirtProductText(){
        return getText(tshirtText);
    }


}
