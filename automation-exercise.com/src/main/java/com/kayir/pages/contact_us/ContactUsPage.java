package com.kayir.pages.contact_us;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utilities.ActionsUtility.sendKeys;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class ContactUsPage extends HomePage {

    private By getInTouchText = By.xpath("//h2[text()='Get In Touch']");
    private By nameField = By.xpath("//input[@data-qa='name']");
    private By uploadFileField = By.name("upload_file");
    private By submitButton = By.xpath("//input[@data-qa='submit-button']");
    private By successInfoText = By.xpath("//div[@class='contact-form']/div[contains(text(),'Success')]");
    private By homePageLink = By.cssSelector("ul > li:nth-child(1)");


    public HomePage goToHomePage(){
        click(homePageLink);
        return new HomePage();

    }

    public boolean isSuccessInfoTextVisible(){
        return find(successInfoText).isDisplayed();
    }

    public void clickSubmit(){
        scrollToElementJS(submitButton);
        click(submitButton);
    }

    public boolean isGetInTouchTextVisible() {
        return find(getInTouchText).isDisplayed();
    }

    public void setName(String name){
        sendKeys(find(nameField),name);
    }

    public void setEmail(String email){
        sendKeys(Keys.chord(Keys.TAB,email));
    }

    public void setSubject(String subject){
        sendKeys(Keys.chord(Keys.TAB,subject));
    }

    public void setMessage(String message,String message2){
        sendKeys(Keys.chord(Keys.TAB,message));
        sendKeys(Keys.chord(Keys.ENTER,message2));
    }

    public void uploadFile(String path){
        sendKeys(find(uploadFileField),path);
    }

}
