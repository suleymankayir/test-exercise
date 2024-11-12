package com.kayir.pages;

import com.kayir.base.BasePage;
import com.kayir.pages.cart.CartPage;
import com.kayir.pages.contact_us.ContactUsPage;
import com.kayir.pages.products.CategoryProductsPage;
import com.kayir.pages.products.ProductsPage;
import com.kayir.pages.products.SingleProductPage;
import com.kayir.pages.signup_login.DeletedAccountPage;
import com.kayir.pages.signup_login.LoginPage;
import com.kayir.pages.test_cases.TestCasesPage;
import org.openqa.selenium.By;

import static utilities.ActionsUtility.sendKeys;
import static utilities.GetUtility.*;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;
import static utilities.WaitUtility.fluentWaitUntilVisible;


public class HomePage extends BasePage {
    //Links
    private By signUpLoginLink = By.cssSelector("ul > li:nth-child(4)");
    private By contactUsLink = By.cssSelector("ul > li:nth-child(8)");
    private By productsLink = By.cssSelector("ul > li:nth-child(2)");
    private By testCasesLink = By.cssSelector("ul > li:nth-child(5)");
    private By logoutLink = By.linkText("Logout");
    private By cartLink = By.cssSelector("ul > li:nth-child(3)");

    private By homePageLogo = By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img");
    private By loggedInfoText = By.xpath("//*[contains(text(),'Logged')]");
    private By deleteAccountLink = By.linkText("Delete Account");
    private By subscribeText = By.xpath("//footer[@id='footer']//h2[text()='Subscription']");
    private By subEmailField = By.id("susbscribe_email");
    private By subArrowButton = By.xpath("//button[@type='submit']");
    private By successSubText = By.id("success-subscribe");
    private By firstProductView = By.xpath("//a[@href='/product_details/1']");
    private By addToFirstProduct = By.xpath("//div[@class='features_items']//a[@data-product-id='1']");
    private By continueShopButton = By.xpath("//button[@data-dismiss='modal']");
    private By addToSecondProduct = By.xpath("//div[@class='features_items']//a[@data-product-id='2']");
    private By categoryText = By.xpath("//h2[text()='Category']");
    private By womenCategory = By.xpath("//a[@href='#Women']");
    private By dressCategoty = By.xpath("//div[@id='Women']//a[text()='Dress ']");

    public LoginPage goToSignUpLogin() {
        click(signUpLoginLink);
        return new LoginPage();
    }

    public SingleProductPage viewToProduct(){
        scrollToElementJS(firstProductView);
        click(firstProductView);
        return new SingleProductPage();
    }

    public ProductsPage goToProducts(){
        click(productsLink);
        return new ProductsPage();
    }

    public TestCasesPage goToTestCases() {
        click(testCasesLink);
        return new TestCasesPage();
    }

    public CartPage goToCart(){
        click(cartLink);
        return new CartPage();
    }

    public ContactUsPage goToContactUs() {
        click(contactUsLink);
        return new ContactUsPage();
    }

    public CategoryProductsPage clickDressCategory(){
        explicitWaitUntilVisible(1,dressCategoty);
        click(dressCategoty);
        return new CategoryProductsPage();
    }

    public void clickWomenCategory(){
        scrollToElementJS(womenCategory);
        click(womenCategory);
    }

    public boolean isCategoryTextVisible(){
        return find(categoryText).isDisplayed();
    }

    public void clickAddToFirstProduct(){
        scrollToElementJS(addToFirstProduct);
        click(addToFirstProduct);
    }

    public void clickAddToSecondProduct(){
        scrollToElementJS(addToSecondProduct);
        click(addToSecondProduct);
    }

    public void clickContinueShoppingButton(){
        explicitWaitUntilVisible(1,continueShopButton);
        click(continueShopButton);
    }

    public String verifySubscriptionText(){
        scrollToElementJS(subscribeText);
        return getText(subscribeText);
    }

    public void setSubEmail(String email){
        scrollToElementJS(subEmailField);
        sendKeys(find(subEmailField),email);
    }

    public void clickSubArrowButton(){
        scrollToElementJS(subArrowButton);
        click(subArrowButton);
    }

    public String getSubSuccessText(){
        scrollToElementJS(successSubText);
        return getText(successSubText);
    }

    public boolean isHomePageLogoVisible() {
        explicitWaitUntilVisible(3, homePageLogo);
        return find(homePageLogo).isDisplayed();
    }

    public boolean isLoggedInfoTextVisible() {
        fluentWaitUntilVisible(2, homePageLogo);
        return find(loggedInfoText).isDisplayed();
    }

    public DeletedAccountPage clickDeleteAccount() {
        click(deleteAccountLink);
        return new DeletedAccountPage();
    }

    public LoginPage clickLogout() {
        click(logoutLink);
        return new LoginPage();
    }


}
