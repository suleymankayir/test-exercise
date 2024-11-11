package utilities;

import org.openqa.selenium.WebDriver;

public class NavigateUtility extends Utility{

    public static WebDriver.Navigation navigate(){
        return driver.navigate();
    }

    public static void forward(){
        navigate().forward();
    }

    public static void back(){
        navigate().back();
    }

}
