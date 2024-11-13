package com.kayir.pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class BrandsProductsPage extends ProductsPage{

    private By singleItems = By.className("single-products");
    private By madameLink = By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[3]/a");

    public boolean isItemsDisplayed() {
        List<WebElement> itemList = findElementList(singleItems);
        return !itemList.isEmpty();
    }

    public void clickMadame(){
        scrollToElementJS(madameLink);
        click(madameLink);
    }
}
