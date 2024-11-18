package com.kayir.pages.signup_login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static utilities.ActionsUtility.sendKeys;
import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;
import static utilities.WaitUtility.explicitWaitUntilVisible;

public class SignUpPage extends LoginPage {

    private By enterAccountInfoText = By.xpath("//b[contains(text(),'Account')]");
    private By mrsRadioButton = By.id("id_gender2");
    private By nameField = By.id("name");
    private By newsletterCheckBox = By.id("newsletter");
    private By offerCheckBox = By.id("optin");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");


    public AccountCreatedPage clickCreateAccountButton() {
        scrollToElementJS(createAccountButton);
        click(createAccountButton);
        return new AccountCreatedPage();
    }

    public boolean isEnterAccountInfoTextVisible() {
        explicitWaitUntilVisible(3, enterAccountInfoText);
        return find(enterAccountInfoText).isDisplayed();
    }

    public void clickMrsRadioButton() {
        scrollToElementJS(mrsRadioButton);
        clickJS(mrsRadioButton);

    }

    public void setName(String name) {
        scrollToElementJS(nameField);
        sendKeys(find(nameField), Keys.chord(name));
    }

    public void setPassword(String password) {
        sendKeys(Keys.TAB + password);
    }

    public void setDay(String day) {
        sendKeys(Keys.TAB + day);
    }

    public void setMonth(String month) {
        sendKeys(Keys.TAB + month);
    }

    public void setYear(String year) {
        sendKeys(Keys.TAB + year);
    }

    public void clickNewsletterCheckbox() {
        sendKeys(Keys.TAB);
        clickJS(newsletterCheckBox);
    }

    public void clickOfferCheckbox() {
        sendKeys(Keys.TAB);
        clickJS(offerCheckBox);
    }

    public void setFirstName(String firstName) {
        sendKeys(Keys.TAB + firstName);
    }

    public void setSurname(String surname) {
        sendKeys(Keys.TAB + surname);
    }

    public void setCompany(String companyName) {
        sendKeys(Keys.TAB + companyName);
    }

    public void setAddress(String address, String address2) {
        sendKeys(Keys.TAB + address);
        sendKeys(Keys.TAB + address2);
    }

    public void setCountry(String country, String state, String city, String zipcode) {
        sendKeys(Keys.TAB + country);
        sendKeys(Keys.TAB + state);
        sendKeys(Keys.TAB + city);
        sendKeys(Keys.TAB + zipcode);
    }

    public void setMobileNo(String number) {
        sendKeys(Keys.TAB + number);
    }

    public void signUp(
            String name, String password, String day, String month,
            String year, String firstName, String surname, String company,
            String address1, String address2, String country, String state,
            String city, String zipcode, String mobileNum) {
        clickMrsRadioButton();
        setName(name);
        setPassword(password);
        setDay(day);
        setMonth(month);
        setYear(year);
        clickNewsletterCheckbox();
        clickOfferCheckbox();
        setFirstName(firstName);
        setSurname(surname);
        setCompany(company);
        setAddress(address1, address2);
        setCountry(country, state, city, zipcode);
        setMobileNo(mobileNum);
    }
}
