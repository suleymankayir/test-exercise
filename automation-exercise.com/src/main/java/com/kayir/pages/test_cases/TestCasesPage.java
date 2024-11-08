package com.kayir.pages.test_cases;

import com.kayir.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.WaitUtility.explicitWaitUntilVisible;

public class TestCasesPage extends HomePage {

    private By testCasesTitle = By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b");

    public boolean isTestCasesTitleIsVisible(){
        explicitWaitUntilVisible(3,testCasesTitle);
        return find(testCasesTitle).isDisplayed();
    }

}
